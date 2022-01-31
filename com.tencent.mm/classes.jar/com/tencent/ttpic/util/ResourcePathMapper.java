package com.tencent.ttpic.util;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class ResourcePathMapper
{
  public static boolean COPY_XML = false;
  public static final String RES_PREFIX_ASSETS = "assets://";
  private static Map<String, String> lutFilterIdMap;
  private static Map<String, ResourcePathMapper.ResourcePath> resMap;
  private static String resPathXml;
  
  static
  {
    AppMethodBeat.i(83963);
    COPY_XML = true;
    lutFilterIdMap = new HashMap();
    resMap = new HashMap();
    AppMethodBeat.o(83963);
  }
  
  private static String bufferedReaderFile(String paramString)
  {
    AppMethodBeat.i(83960);
    if (paramString == null)
    {
      AppMethodBeat.o(83960);
      return null;
    }
    paramString = new File(paramString);
    if ((!paramString.exists()) || (paramString.isDirectory()))
    {
      paramString = new FileNotFoundException();
      AppMethodBeat.o(83960);
      throw paramString;
    }
    BufferedReader localBufferedReader = new BufferedReader(new FileReader(paramString));
    StringBuffer localStringBuffer = new StringBuffer();
    for (paramString = localBufferedReader.readLine(); paramString != null; paramString = localBufferedReader.readLine()) {
      localStringBuffer.append(paramString + " ");
    }
    localBufferedReader.close();
    paramString = localStringBuffer.toString();
    AppMethodBeat.o(83960);
    return paramString;
  }
  
  public static boolean checkFileExist(String paramString)
  {
    AppMethodBeat.i(83961);
    if (paramString == null)
    {
      AppMethodBeat.o(83961);
      return false;
    }
    if (new File(paramString).exists())
    {
      AppMethodBeat.o(83961);
      return true;
    }
    AppMethodBeat.o(83961);
    return false;
  }
  
  private static void clearResourceMap()
  {
    AppMethodBeat.i(83959);
    if ((resMap != null) && (!resMap.isEmpty()))
    {
      Iterator localIterator = resMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ResourcePathMapper.ResourcePath localResourcePath = (ResourcePathMapper.ResourcePath)resMap.get(str);
        if ((localResourcePath.getType().equals("model")) || (localResourcePath.getType().equals("so")))
        {
          localResourcePath.setPath("");
          resMap.put(str, localResourcePath);
        }
      }
    }
    AppMethodBeat.o(83959);
  }
  
  public static String getFilterResPath(String paramString)
  {
    AppMethodBeat.i(83953);
    if (paramString == null)
    {
      AppMethodBeat.o(83953);
      return null;
    }
    paramString = paramString.substring(paramString.lastIndexOf('/') + 1);
    String str = (String)lutFilterIdMap.get(paramString);
    if (str != null)
    {
      paramString = getResPath(str) + paramString;
      AppMethodBeat.o(83953);
      return paramString;
    }
    AppMethodBeat.o(83953);
    return null;
  }
  
  public static String getModelResPath(String paramString)
  {
    AppMethodBeat.i(83956);
    if (paramString == null)
    {
      AppMethodBeat.o(83956);
      return null;
    }
    paramString = (String)lutFilterIdMap.get(paramString);
    if (paramString != null)
    {
      paramString = getResPath(paramString);
      AppMethodBeat.o(83956);
      return paramString;
    }
    AppMethodBeat.o(83956);
    return null;
  }
  
  public static String getResPath(String paramString)
  {
    AppMethodBeat.i(83954);
    if (paramString == null)
    {
      AppMethodBeat.o(83954);
      return null;
    }
    paramString = (ResourcePathMapper.ResourcePath)resMap.get(paramString);
    if ((paramString != null) && (!paramString.getPath().equals("")))
    {
      paramString = paramString.getPath();
      AppMethodBeat.o(83954);
      return paramString;
    }
    AppMethodBeat.o(83954);
    return null;
  }
  
  public static void init(ResourcePathMapper.MODE paramMODE)
  {
    AppMethodBeat.i(83951);
    String str = VideoGlobalContext.getContext().getFilesDir().getAbsolutePath() + File.separator + "resource_path.xml";
    resPathXml = str;
    if ((!checkFileExist(str)) || (COPY_XML))
    {
      FileUtils.copyAssets(VideoGlobalContext.getContext(), "resource_path.xml", resPathXml);
      COPY_XML = false;
    }
    parseXml(resPathXml, resMap, lutFilterIdMap);
    if (paramMODE == ResourcePathMapper.MODE.REMOTE) {
      clearResourceMap();
    }
    AppMethodBeat.o(83951);
  }
  
  private static void parseXml(String paramString, Map<String, ResourcePathMapper.ResourcePath> paramMap, Map<String, String> paramMap1)
  {
    Object localObject = null;
    AppMethodBeat.i(83958);
    if ((!checkFileExist(paramString)) || (paramMap == null) || (paramMap1 == null))
    {
      AppMethodBeat.o(83958);
      return;
    }
    for (;;)
    {
      try
      {
        XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
        try
        {
          localXmlPullParser.setInput(new StringReader(bufferedReaderFile(paramString)));
          i = localXmlPullParser.getEventType();
          paramString = (String)localObject;
        }
        catch (Exception paramString)
        {
          try
          {
            int i;
            str1 = localXmlPullParser.getName();
            switch (i)
            {
            case 2: 
              i = localXmlPullParser.next();
              paramString = (String)localObject;
            }
          }
          catch (IOException paramString)
          {
            String str2;
            AppMethodBeat.o(83958);
            return;
          }
          paramString = paramString;
          AppMethodBeat.o(83958);
          return;
        }
        if (i != 1)
        {
          String str1;
          if ("resource".equals(str1))
          {
            localObject = localXmlPullParser.getAttributeValue(null, "type");
            str1 = localXmlPullParser.getAttributeValue(null, "id");
            str2 = localXmlPullParser.getAttributeValue(null, "name");
            paramString = localXmlPullParser.getAttributeValue(null, "path");
            if ((paramString == null) || (paramString.equals("")) || (paramString.endsWith(File.separator))) {
              break label324;
            }
            paramString = paramString + File.separator;
            localObject = new ResourcePathMapper.ResourcePath(str1, (String)localObject, str2, paramString);
            paramMap.put(str1, localObject);
            continue;
          }
          localObject = paramString;
          if (!"item".equals(str1)) {
            continue;
          }
          localObject = localXmlPullParser.nextText();
          paramString.addItem((String)localObject);
          paramMap1.put(localObject, paramString.getId());
          localObject = paramString;
          continue;
        }
        AppMethodBeat.o(83958);
      }
      catch (XmlPullParserException paramString)
      {
        AppMethodBeat.o(83958);
        return;
      }
      return;
      label324:
      continue;
      localObject = paramString;
    }
  }
  
  public static void printMap()
  {
    AppMethodBeat.i(83962);
    if (resMap != null) {
      new StringBuilder("resMap.size = ").append(resMap.size());
    }
    Iterator localIterator = resMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      new StringBuilder("resMap = ").append(((ResourcePathMapper.ResourcePath)resMap.get(str)).getId()).append(", ").append(((ResourcePathMapper.ResourcePath)resMap.get(str)).getName());
    }
    AppMethodBeat.o(83962);
  }
  
  public static void setResPath(String paramString1, String paramString2)
  {
    AppMethodBeat.i(83955);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(83955);
      return;
    }
    String str = paramString2;
    if (!paramString2.endsWith(File.separator)) {
      str = paramString2 + File.separator;
    }
    paramString2 = (ResourcePathMapper.ResourcePath)resMap.get(paramString1);
    if (paramString2 != null)
    {
      paramString2.setPath(str);
      resMap.put(paramString1, paramString2);
    }
    AppMethodBeat.o(83955);
  }
  
  public static void updateResoucePathStorage()
  {
    AppMethodBeat.i(83952);
    updateXmlFile(resMap, resPathXml);
    AppMethodBeat.o(83952);
  }
  
  /* Error */
  private static void updateXmlFile(Map<String, ResourcePathMapper.ResourcePath> paramMap, String paramString)
  {
    // Byte code:
    //   0: ldc_w 312
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +7 -> 14
    //   10: aload_1
    //   11: ifnonnull +10 -> 21
    //   14: ldc_w 312
    //   17: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: return
    //   21: new 51	java/io/File
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore_1
    //   30: aload_1
    //   31: invokevirtual 58	java/io/File:exists	()Z
    //   34: ifeq +13 -> 47
    //   37: aload_1
    //   38: invokevirtual 315	java/io/File:delete	()Z
    //   41: pop
    //   42: aload_1
    //   43: invokevirtual 318	java/io/File:createNewFile	()Z
    //   46: pop
    //   47: new 320	java/io/FileOutputStream
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 321	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   55: astore_1
    //   56: invokestatic 327	android/util/Xml:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
    //   59: astore_2
    //   60: aload_2
    //   61: aload_1
    //   62: ldc_w 329
    //   65: invokeinterface 335 3 0
    //   70: aload_2
    //   71: aconst_null
    //   72: getstatic 341	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   75: invokeinterface 345 3 0
    //   80: aload_2
    //   81: aconst_null
    //   82: ldc_w 347
    //   85: invokeinterface 351 3 0
    //   90: pop
    //   91: aload_0
    //   92: invokeinterface 114 1 0
    //   97: invokeinterface 120 1 0
    //   102: astore_3
    //   103: aload_3
    //   104: invokeinterface 125 1 0
    //   109: ifeq +194 -> 303
    //   112: aload_0
    //   113: aload_3
    //   114: invokeinterface 129 1 0
    //   119: checkcast 131	java/lang/String
    //   122: invokeinterface 135 2 0
    //   127: checkcast 8	com/tencent/ttpic/util/ResourcePathMapper$ResourcePath
    //   130: astore 4
    //   132: aload_2
    //   133: aconst_null
    //   134: ldc 255
    //   136: invokeinterface 351 3 0
    //   141: pop
    //   142: aload_2
    //   143: aconst_null
    //   144: ldc_w 257
    //   147: aload 4
    //   149: invokevirtual 138	com/tencent/ttpic/util/ResourcePathMapper$ResourcePath:getType	()Ljava/lang/String;
    //   152: invokeinterface 355 4 0
    //   157: pop
    //   158: aload_2
    //   159: aconst_null
    //   160: ldc_w 263
    //   163: aload 4
    //   165: invokevirtual 284	com/tencent/ttpic/util/ResourcePathMapper$ResourcePath:getId	()Ljava/lang/String;
    //   168: invokeinterface 355 4 0
    //   173: pop
    //   174: aload_2
    //   175: aconst_null
    //   176: ldc_w 265
    //   179: aload 4
    //   181: invokevirtual 302	com/tencent/ttpic/util/ResourcePathMapper$ResourcePath:getName	()Ljava/lang/String;
    //   184: invokeinterface 355 4 0
    //   189: pop
    //   190: aload_2
    //   191: aconst_null
    //   192: ldc_w 267
    //   195: aload 4
    //   197: invokevirtual 174	com/tencent/ttpic/util/ResourcePathMapper$ResourcePath:getPath	()Ljava/lang/String;
    //   200: invokeinterface 355 4 0
    //   205: pop
    //   206: aload 4
    //   208: invokevirtual 359	com/tencent/ttpic/util/ResourcePathMapper$ResourcePath:getItems	()Ljava/util/List;
    //   211: invokeinterface 362 1 0
    //   216: astore 4
    //   218: aload 4
    //   220: invokeinterface 125 1 0
    //   225: ifeq +65 -> 290
    //   228: aload 4
    //   230: invokeinterface 129 1 0
    //   235: checkcast 131	java/lang/String
    //   238: astore 5
    //   240: aload_2
    //   241: aconst_null
    //   242: ldc_w 275
    //   245: invokeinterface 351 3 0
    //   250: pop
    //   251: aload_2
    //   252: aload 5
    //   254: invokeinterface 366 2 0
    //   259: pop
    //   260: aload_2
    //   261: aconst_null
    //   262: ldc_w 275
    //   265: invokeinterface 369 3 0
    //   270: pop
    //   271: goto -53 -> 218
    //   274: astore_0
    //   275: ldc_w 312
    //   278: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   281: return
    //   282: astore_0
    //   283: ldc_w 312
    //   286: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: return
    //   290: aload_2
    //   291: aconst_null
    //   292: ldc 255
    //   294: invokeinterface 369 3 0
    //   299: pop
    //   300: goto -197 -> 103
    //   303: aload_2
    //   304: aconst_null
    //   305: ldc_w 347
    //   308: invokeinterface 369 3 0
    //   313: pop
    //   314: aload_2
    //   315: invokeinterface 372 1 0
    //   320: aload_2
    //   321: invokeinterface 375 1 0
    //   326: aload_1
    //   327: invokevirtual 376	java/io/FileOutputStream:close	()V
    //   330: ldc_w 312
    //   333: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   336: return
    //   337: astore_2
    //   338: goto -291 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	paramMap	Map<String, ResourcePathMapper.ResourcePath>
    //   0	341	1	paramString	String
    //   59	262	2	localXmlSerializer	org.xmlpull.v1.XmlSerializer
    //   337	1	2	localIOException	IOException
    //   102	12	3	localIterator	Iterator
    //   130	99	4	localObject	Object
    //   238	15	5	str	String
    // Exception table:
    //   from	to	target	type
    //   60	103	274	java/lang/Exception
    //   103	218	274	java/lang/Exception
    //   218	271	274	java/lang/Exception
    //   290	300	274	java/lang/Exception
    //   303	330	274	java/lang/Exception
    //   47	56	282	java/io/FileNotFoundException
    //   42	47	337	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.ttpic.util.ResourcePathMapper
 * JD-Core Version:    0.7.0.1
 */
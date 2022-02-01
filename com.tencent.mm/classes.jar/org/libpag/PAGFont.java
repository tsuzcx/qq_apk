package org.libpag;

import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.extra.tools.b;
import org.xmlpull.v1.XmlPullParser;

public class PAGFont
{
  private static final String DefaultLanguage = "zh-Hans";
  private static final Pattern FILENAME_WHITESPACE_PATTERN;
  private static final String[] FallbackFontFileNames;
  private static final String SystemFontConfigPath_JellyBean = "/system/etc/fallback_fonts.xml";
  private static final String SystemFontConfigPath_Lollipop = "/system/etc/fonts.xml";
  private static final String SystemFontPath = "/system/fonts/";
  private static boolean systemFontLoaded;
  public String fontFamily = "";
  public String fontStyle = "";
  
  static
  {
    AppMethodBeat.i(220154);
    FallbackFontFileNames = new String[] { "/system/fonts/NotoSansCJK-Regular.ttc", "/system/fonts/NotoSansSC-Regular.otf", "/system/fonts/DroidSansFallback.ttf" };
    FILENAME_WHITESPACE_PATTERN = Pattern.compile("^[ \\n\\r\\t]+|[ \\n\\r\\t]+$");
    systemFontLoaded = false;
    b.loadLibrary("libpag");
    loadSystemFonts();
    AppMethodBeat.o(220154);
  }
  
  public PAGFont() {}
  
  public PAGFont(String paramString1, String paramString2)
  {
    this.fontFamily = paramString1;
    this.fontStyle = paramString2;
  }
  
  public static PAGFont RegisterFont(AssetManager paramAssetManager, String paramString)
  {
    AppMethodBeat.i(220142);
    paramAssetManager = RegisterFont(paramAssetManager, paramString, 0);
    AppMethodBeat.o(220142);
    return paramAssetManager;
  }
  
  public static native PAGFont RegisterFont(AssetManager paramAssetManager, String paramString, int paramInt);
  
  public static PAGFont RegisterFont(String paramString)
  {
    AppMethodBeat.i(220141);
    paramString = RegisterFont(paramString, 0);
    AppMethodBeat.o(220141);
    return paramString;
  }
  
  public static native PAGFont RegisterFont(String paramString, int paramInt);
  
  private static native PAGFont RegisterFontBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private static native void SetFallbackFontPaths(String[] paramArrayOfString, int[] paramArrayOfInt);
  
  private static void addFont(FontConfig paramFontConfig, ArrayList<String> paramArrayList, ArrayList<Integer> paramArrayList1)
  {
    AppMethodBeat.i(220152);
    if (paramArrayList.contains(paramFontConfig.fileName))
    {
      AppMethodBeat.o(220152);
      return;
    }
    if (!new File(paramFontConfig.fileName).exists())
    {
      AppMethodBeat.o(220152);
      return;
    }
    paramArrayList.add(paramFontConfig.fileName);
    paramArrayList1.add(Integer.valueOf(paramFontConfig.ttcIndex));
    AppMethodBeat.o(220152);
  }
  
  private static FontConfig getFontByLanguage(FontConfig[] paramArrayOfFontConfig, String paramString)
  {
    AppMethodBeat.i(220151);
    paramString = paramString.toLowerCase();
    int j = paramArrayOfFontConfig.length;
    int i = 0;
    while (i < j)
    {
      FontConfig localFontConfig = paramArrayOfFontConfig[i];
      if (localFontConfig.language.toLowerCase().equals(paramString))
      {
        AppMethodBeat.o(220151);
        return localFontConfig;
      }
      i += 1;
    }
    AppMethodBeat.o(220151);
    return null;
  }
  
  public static void loadSystemFonts()
  {
    int j = 0;
    AppMethodBeat.i(220153);
    if (systemFontLoaded)
    {
      AppMethodBeat.o(220153);
      return;
    }
    systemFontLoaded = true;
    Object localObject1 = new FontConfig[0];
    if (new File("/system/etc/fonts.xml").exists()) {}
    for (;;)
    {
      try
      {
        localObject2 = parseLollipop();
        localObject1 = localObject2;
      }
      catch (Exception localException1)
      {
        Object localObject2;
        Object localObject3;
        Object localObject4;
        int k;
        int i;
        Object localObject5;
        FontConfig localFontConfig;
        continue;
        continue;
      }
      localObject3 = new ArrayList();
      localObject2 = new ArrayList();
      localObject4 = getFontByLanguage((FontConfig[])localObject1, "zh-Hans");
      if (localObject4 != null) {
        addFont((FontConfig)localObject4, (ArrayList)localObject3, (ArrayList)localObject2);
      }
      localObject4 = FallbackFontFileNames;
      k = localObject4.length;
      i = 0;
      if (i < k)
      {
        localObject5 = localObject4[i];
        localFontConfig = new FontConfig(null);
        localFontConfig.fileName = localObject5;
        addFont(localFontConfig, (ArrayList)localObject3, (ArrayList)localObject2);
        i += 1;
      }
      try
      {
        localObject2 = parseJellyBean();
        localObject1 = localObject2;
      }
      catch (Exception localException2) {}
    }
    k = localObject1.length;
    i = 0;
    while (i < k)
    {
      addFont(localObject1[i], (ArrayList)localObject3, (ArrayList)localObject2);
      i += 1;
    }
    if (!((ArrayList)localObject3).isEmpty())
    {
      localObject1 = new String[((ArrayList)localObject3).size()];
      ((ArrayList)localObject3).toArray((Object[])localObject1);
      localObject3 = new int[((ArrayList)localObject2).size()];
      localObject2 = ((ArrayList)localObject2).iterator();
      i = j;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3[i] = ((Integer)((Iterator)localObject2).next()).intValue();
        i += 1;
      }
      SetFallbackFontPaths((String[])localObject1, (int[])localObject3);
    }
    AppMethodBeat.o(220153);
  }
  
  /* Error */
  private static FontConfig[] parseJellyBean()
  {
    // Byte code:
    //   0: ldc 199
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 201	java/io/FileInputStream
    //   8: dup
    //   9: ldc 20
    //   11: invokespecial 202	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: invokestatic 208	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   18: astore_1
    //   19: aload_1
    //   20: aload_0
    //   21: aconst_null
    //   22: invokeinterface 214 3 0
    //   27: aload_1
    //   28: invokeinterface 217 1 0
    //   33: pop
    //   34: aload_1
    //   35: invokestatic 221	org/libpag/PAGFont:readFamiliesJellyBean	(Lorg/xmlpull/v1/XmlPullParser;)[Lorg/libpag/PAGFont$FontConfig;
    //   38: astore_1
    //   39: aload_0
    //   40: invokevirtual 224	java/io/FileInputStream:close	()V
    //   43: ldc 199
    //   45: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: areturn
    //   50: astore_0
    //   51: ldc 199
    //   53: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: iconst_0
    //   57: anewarray 8	org/libpag/PAGFont$FontConfig
    //   60: areturn
    //   61: astore_1
    //   62: aload_0
    //   63: invokevirtual 224	java/io/FileInputStream:close	()V
    //   66: ldc 199
    //   68: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   14	26	0	localFileInputStream	java.io.FileInputStream
    //   50	13	0	localIOException	java.io.IOException
    //   18	31	1	localObject1	Object
    //   61	11	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	15	50	java/io/IOException
    //   15	39	61	finally
  }
  
  /* Error */
  private static FontConfig[] parseLollipop()
  {
    // Byte code:
    //   0: ldc 225
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 201	java/io/FileInputStream
    //   8: dup
    //   9: ldc 23
    //   11: invokespecial 202	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: invokestatic 208	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   18: astore_1
    //   19: aload_1
    //   20: aload_0
    //   21: aconst_null
    //   22: invokeinterface 214 3 0
    //   27: aload_1
    //   28: invokeinterface 217 1 0
    //   33: pop
    //   34: aload_1
    //   35: invokestatic 228	org/libpag/PAGFont:readFamilies	(Lorg/xmlpull/v1/XmlPullParser;)[Lorg/libpag/PAGFont$FontConfig;
    //   38: astore_1
    //   39: aload_0
    //   40: invokevirtual 224	java/io/FileInputStream:close	()V
    //   43: ldc 225
    //   45: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: areturn
    //   50: astore_0
    //   51: ldc 225
    //   53: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: iconst_0
    //   57: anewarray 8	org/libpag/PAGFont$FontConfig
    //   60: areturn
    //   61: astore_1
    //   62: aload_0
    //   63: invokevirtual 224	java/io/FileInputStream:close	()V
    //   66: ldc 225
    //   68: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   14	26	0	localFileInputStream	java.io.FileInputStream
    //   50	13	0	localIOException	java.io.IOException
    //   18	31	1	localObject1	Object
    //   61	11	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	15	50	java/io/IOException
    //   15	39	61	finally
  }
  
  private static FontConfig[] readFamilies(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(220144);
    ArrayList localArrayList = new ArrayList();
    paramXmlPullParser.require(2, null, "familyset");
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2) {
        if (paramXmlPullParser.getName().equals("family")) {
          readFamily(paramXmlPullParser, localArrayList);
        } else {
          skip(paramXmlPullParser);
        }
      }
    }
    paramXmlPullParser = new FontConfig[localArrayList.size()];
    localArrayList.toArray(paramXmlPullParser);
    AppMethodBeat.o(220144);
    return paramXmlPullParser;
  }
  
  private static FontConfig[] readFamiliesJellyBean(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(220149);
    ArrayList localArrayList = new ArrayList();
    paramXmlPullParser.require(2, null, "familyset");
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2) {
        if (paramXmlPullParser.getName().equals("family")) {
          while (paramXmlPullParser.next() != 3) {
            if (paramXmlPullParser.getEventType() == 2) {
              if (paramXmlPullParser.getName().equals("fileset")) {
                readFileset(paramXmlPullParser, localArrayList);
              } else {
                skip(paramXmlPullParser);
              }
            }
          }
        } else {
          skip(paramXmlPullParser);
        }
      }
    }
    paramXmlPullParser = new FontConfig[localArrayList.size()];
    localArrayList.toArray(paramXmlPullParser);
    AppMethodBeat.o(220149);
    return paramXmlPullParser;
  }
  
  private static void readFamily(XmlPullParser paramXmlPullParser, ArrayList<FontConfig> paramArrayList)
  {
    AppMethodBeat.i(220145);
    paramXmlPullParser.getAttributeValue(null, "name");
    String str = paramXmlPullParser.getAttributeValue(null, "lang");
    ArrayList localArrayList = new ArrayList();
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2) {
        if (paramXmlPullParser.getName().equals("font")) {
          localArrayList.add(readFont(paramXmlPullParser));
        } else {
          skip(paramXmlPullParser);
        }
      }
    }
    if (localArrayList.isEmpty())
    {
      AppMethodBeat.o(220145);
      return;
    }
    Object localObject = localArrayList.iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramXmlPullParser = (FontConfig)((Iterator)localObject).next();
    } while (paramXmlPullParser.weight != 400);
    for (;;)
    {
      localObject = paramXmlPullParser;
      if (paramXmlPullParser == null) {
        localObject = (FontConfig)localArrayList.get(0);
      }
      if (!((FontConfig)localObject).fileName.isEmpty())
      {
        paramXmlPullParser = str;
        if (str == null) {
          paramXmlPullParser = "";
        }
        ((FontConfig)localObject).language = paramXmlPullParser;
        paramArrayList.add(localObject);
      }
      AppMethodBeat.o(220145);
      return;
      paramXmlPullParser = null;
    }
  }
  
  private static void readFileset(XmlPullParser paramXmlPullParser, ArrayList<FontConfig> paramArrayList)
  {
    AppMethodBeat.i(220150);
    ArrayList localArrayList = new ArrayList();
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2) {
        if (paramXmlPullParser.getName().equals("file")) {
          localArrayList.add(readFont(paramXmlPullParser));
        } else {
          skip(paramXmlPullParser);
        }
      }
    }
    if (localArrayList.isEmpty())
    {
      AppMethodBeat.o(220150);
      return;
    }
    Object localObject = localArrayList.iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramXmlPullParser = (FontConfig)((Iterator)localObject).next();
    } while (paramXmlPullParser.weight != 400);
    for (;;)
    {
      localObject = paramXmlPullParser;
      if (paramXmlPullParser == null) {
        localObject = (FontConfig)localArrayList.get(0);
      }
      if (!((FontConfig)localObject).fileName.isEmpty()) {
        paramArrayList.add(localObject);
      }
      AppMethodBeat.o(220150);
      return;
      paramXmlPullParser = null;
    }
  }
  
  private static FontConfig readFont(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(220146);
    FontConfig localFontConfig = new FontConfig(null);
    Object localObject = paramXmlPullParser.getAttributeValue(null, "index");
    if (localObject == null)
    {
      i = 0;
      localFontConfig.ttcIndex = i;
      localObject = paramXmlPullParser.getAttributeValue(null, "weight");
      if (localObject != null) {
        break label125;
      }
    }
    label125:
    for (int i = 400;; i = Integer.parseInt((String)localObject))
    {
      localFontConfig.weight = i;
      localObject = new StringBuilder();
      while (paramXmlPullParser.next() != 3)
      {
        if (paramXmlPullParser.getEventType() == 4) {
          ((StringBuilder)localObject).append(paramXmlPullParser.getText());
        }
        if (paramXmlPullParser.getEventType() == 2) {
          skip(paramXmlPullParser);
        }
      }
      i = Integer.parseInt((String)localObject);
      break;
    }
    localFontConfig.fileName = ("/system/fonts/" + FILENAME_WHITESPACE_PATTERN.matcher((CharSequence)localObject).replaceAll(""));
    AppMethodBeat.o(220146);
    return localFontConfig;
  }
  
  private static void skip(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(220147);
    int i = 1;
    while (i > 0) {
      switch (paramXmlPullParser.next())
      {
      default: 
        break;
      case 2: 
        i += 1;
        break;
      case 3: 
        i -= 1;
      }
    }
    AppMethodBeat.o(220147);
  }
  
  static class FontConfig
  {
    String fileName = "";
    String language = "";
    int ttcIndex = 0;
    int weight = 400;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.libpag.PAGFont
 * JD-Core Version:    0.7.0.1
 */
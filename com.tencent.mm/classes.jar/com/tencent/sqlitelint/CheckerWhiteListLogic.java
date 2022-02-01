package com.tencent.sqlitelint;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

public final class CheckerWhiteListLogic
{
  private static final String ATTRIBUTE_CHECKER_NAME = "name";
  private static final String TAG = "SQLiteLint.CheckerWhiteListLogic";
  private static final String TAG_CHECKER = "checker";
  private static final String TAG_WHITE_LIST_ELEMENT = "element";
  
  private static void addToNative(String paramString, Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(52819);
    if (paramMap == null)
    {
      AppMethodBeat.o(52819);
      return;
    }
    Iterator localIterator = paramMap.entrySet().iterator();
    String[] arrayOfString = new String[paramMap.size()];
    paramMap = new String[paramMap.size()][];
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      arrayOfString[i] = ((String)((Map.Entry)localObject).getKey());
      localObject = (List)((Map.Entry)localObject).getValue();
      paramMap[i] = new String[((List)localObject).size()];
      int j = 0;
      while (j < ((List)localObject).size())
      {
        paramMap[i][j] = ((String)((List)localObject).get(j));
        j += 1;
      }
      i += 1;
    }
    SQLiteLintNativeBridge.nativeAddToWhiteList(paramString, arrayOfString, paramMap);
    AppMethodBeat.o(52819);
  }
  
  public static void setWhiteList(Context paramContext, String paramString, int paramInt)
  {
    localObject = null;
    AppMethodBeat.i(52818);
    XmlResourceParser localXmlResourceParser;
    try
    {
      localXmlResourceParser = paramContext.getResources().getXml(paramInt);
      if (localXmlResourceParser == null)
      {
        SLog.w("SQLiteLint.CheckerWhiteListLogic", "buildWhiteListSet: parser null", new Object[0]);
        AppMethodBeat.o(52818);
        return;
      }
    }
    catch (Exception paramContext)
    {
      SLog.w("SQLiteLint.CheckerWhiteListLogic", "buildWhiteListSet: getResources exp=%s", new Object[] { paramContext.getLocalizedMessage() });
      AppMethodBeat.o(52818);
      return;
    }
    try
    {
      paramInt = localXmlResourceParser.getEventType();
      localHashMap = new HashMap();
      i = 0;
      paramContext = (Context)localObject;
    }
    catch (XmlPullParserException paramContext)
    {
      for (;;)
      {
        HashMap localHashMap;
        int i;
        int j;
        ArrayList localArrayList;
        SLog.w("SQLiteLint.CheckerWhiteListLogic", "buildWhiteListSet: exp=%s", new Object[] { paramContext.getLocalizedMessage() });
      }
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        SLog.w("SQLiteLint.CheckerWhiteListLogic", "buildWhiteListSet: exp=%s", new Object[] { paramContext.getLocalizedMessage() });
        continue;
        continue;
        localObject = paramContext;
        continue;
        if (paramInt != 1)
        {
          localObject = paramContext;
          switch (paramInt)
          {
          }
        }
      }
    }
    SLog.w("SQLiteLint.CheckerWhiteListLogic", "buildWhiteListMap: default branch , eventType:%d", new Object[] { Integer.valueOf(paramInt) });
    localObject = paramContext;
    localXmlResourceParser.next();
    paramInt = localXmlResourceParser.getEventType();
    j = i + 1;
    paramContext = (Context)localObject;
    i = j;
    if (j > 10000)
    {
      SLog.e("SQLiteLint.CheckerWhiteListLogic", "buildWhiteListMap:maybe dead loop!!", new Object[0]);
      addToNative(paramString, localHashMap);
      localXmlResourceParser.close();
      AppMethodBeat.o(52818);
      return;
      localObject = localXmlResourceParser.getName();
      if ("checker".equalsIgnoreCase((String)localObject))
      {
        paramContext = localXmlResourceParser.getAttributeValue(null, "name");
        if ((!"element".equalsIgnoreCase((String)localObject)) || (SQLiteLintUtil.isNullOrNil(paramContext))) {
          break label368;
        }
        localObject = localXmlResourceParser.nextText();
        if (localHashMap.get(paramContext) == null)
        {
          localArrayList = new ArrayList();
          localArrayList.add(localObject);
          localHashMap.put(paramContext, localArrayList);
        }
        for (;;)
        {
          SLog.v("SQLiteLint.CheckerWhiteListLogic", "buildWhiteListMap: add to whiteList[%s]: %s", new Object[] { paramContext, localObject });
          localObject = paramContext;
          break;
          ((List)localHashMap.get(paramContext)).add(localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.sqlitelint.CheckerWhiteListLogic
 * JD-Core Version:    0.7.0.1
 */
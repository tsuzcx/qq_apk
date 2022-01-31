package com.tencent.sqlitelint;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import com.tencent.sqlitelint.behaviour.b.a.a;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLite3ProfileHooker;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParserException;

public class e
{
  public static String bnW;
  private static c wQU;
  static a.a wQV;
  
  static
  {
    if (!e.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      SQLiteLintNativeBridge.loadLibrary();
      wQU = null;
      bnW = null;
      return;
    }
  }
  
  public static void N(String paramString1, String paramString2, int paramInt)
  {
    if (g.wRf.afX(paramString1) == null) {
      return;
    }
    g.wRf.afX(paramString1);
    long l = paramInt;
    String str = "null";
    if (l >= 8L) {
      str = SQLiteLintUtil.getThrowableStack(new Throwable());
    }
    SQLiteLintNativeBridge.nativeNotifySqlExecute(paramString1, paramString2, l, str);
  }
  
  public static void a(Context paramContext, a parama, b paramb)
  {
    assert (parama != null);
    assert (wQU != null) : "SqlExecutionCallbackMode is UNKNOWN！setSqlExecutionCallbackMode must be called before install";
    b localb = paramb;
    if (paramb == null) {
      localb = b.wQY;
    }
    paramb = g.wRf;
    String str = parama.wQW;
    if (paramb.wRg.containsKey(str))
    {
      SLog.w("SQLiteLint.SQLiteLintAndroidCoreManager", "install twice!! ignore", new Object[0]);
      return;
    }
    paramContext = new f(paramContext, parama, localb);
    paramb.wRg.put(str, paramContext);
  }
  
  static void a(a.a parama)
  {
    wQV = parama;
  }
  
  public static void a(c paramc)
  {
    if (wQU != null) {}
    do
    {
      return;
      wQU = paramc;
    } while (paramc != c.wRb);
    SQLite3ProfileHooker.cPU();
  }
  
  public static void afW(String paramString)
  {
    f localf = g.wRf.afX(paramString);
    if (wQU == c.wRb) {
      SQLite3ProfileHooker.cPV();
    }
    SQLiteLintNativeBridge.nativeUninstall(localf.wQW);
    g.wRf.wRg.remove(paramString);
  }
  
  public static void ag(Context paramContext)
  {
    if (bnW == null) {
      bnW = paramContext.getPackageName();
    }
  }
  
  public static c cPQ()
  {
    return wQU;
  }
  
  public static void dW(String paramString, int paramInt)
  {
    str1 = null;
    if (g.wRf.afX(paramString) == null) {
      return;
    }
    Object localObject = g.wRf.afX(paramString);
    paramString = ((f)localObject).mContext;
    String str2 = ((f)localObject).wQW;
    try
    {
      localObject = paramString.getResources().getXml(paramInt);
      if (localObject == null)
      {
        SLog.w("SQLiteLint.CheckerWhiteListLogic", "buildWhiteListSet: parser null", new Object[0]);
        return;
      }
    }
    catch (Exception paramString)
    {
      SLog.w("SQLiteLint.CheckerWhiteListLogic", "buildWhiteListSet: getResources exp=%s", new Object[] { paramString.getLocalizedMessage() });
      return;
    }
    try
    {
      paramInt = ((XmlResourceParser)localObject).getEventType();
      localHashMap = new HashMap();
      i = 0;
      paramString = str1;
    }
    catch (XmlPullParserException paramString)
    {
      for (;;)
      {
        HashMap localHashMap;
        int i;
        int j;
        ArrayList localArrayList;
        SLog.w("SQLiteLint.CheckerWhiteListLogic", "buildWhiteListSet: exp=%s", new Object[] { paramString.getLocalizedMessage() });
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        SLog.w("SQLiteLint.CheckerWhiteListLogic", "buildWhiteListSet: exp=%s", new Object[] { paramString.getLocalizedMessage() });
        continue;
        continue;
        str1 = paramString;
        continue;
        if (paramInt != 1)
        {
          str1 = paramString;
          switch (paramInt)
          {
          }
        }
      }
    }
    SLog.w("SQLiteLint.CheckerWhiteListLogic", "buildWhiteListMap: default branch , eventType:%d", new Object[] { Integer.valueOf(paramInt) });
    str1 = paramString;
    ((XmlResourceParser)localObject).next();
    paramInt = ((XmlResourceParser)localObject).getEventType();
    j = i + 1;
    paramString = str1;
    i = j;
    if (j > 10000)
    {
      SLog.e("SQLiteLint.CheckerWhiteListLogic", "buildWhiteListMap:maybe dead loop!!", new Object[0]);
      a.z(str2, localHashMap);
      ((XmlResourceParser)localObject).close();
      return;
      str1 = ((XmlResourceParser)localObject).getName();
      if ("checker".equalsIgnoreCase(str1))
      {
        paramString = ((XmlResourceParser)localObject).getAttributeValue(null, "name");
        if ((!"element".equalsIgnoreCase(str1)) || (SQLiteLintUtil.bl(paramString))) {
          break label382;
        }
        str1 = ((XmlResourceParser)localObject).nextText();
        if (localHashMap.get(paramString) == null)
        {
          localArrayList = new ArrayList();
          localArrayList.add(str1);
          localHashMap.put(paramString, localArrayList);
        }
        for (;;)
        {
          SLog.v("SQLiteLint.CheckerWhiteListLogic", "buildWhiteListMap: add to whiteList[%s]: %s", new Object[] { paramString, str1 });
          str1 = paramString;
          break;
          ((List)localHashMap.get(paramString)).add(str1);
        }
      }
    }
  }
  
  public static void z(String paramString, List<String> paramList)
  {
    if (g.wRf.afX(paramString) == null) {}
    while ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    paramString = g.wRf.afX(paramString);
    String[] arrayOfString = new String[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfString[i] = ((String)paramList.get(i));
      i += 1;
    }
    SQLiteLintNativeBridge.nativeEnableCheckers(paramString.wQW, arrayOfString);
  }
  
  public static final class a
  {
    public final String wQW;
    final c wQX;
    
    static
    {
      if (!e.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    public a(String paramString, c paramc)
    {
      assert (paramString != null);
      this.wQW = paramString;
      this.wQX = paramc;
    }
  }
  
  public static final class b
  {
    public static final b wQY = new a().cPR();
    int wQZ;
    
    public static final class a
    {
      public int wRa;
      
      public a()
      {
        this.wRa |= 0x1;
      }
      
      public final e.b cPR()
      {
        e.b localb = new e.b();
        e.b.a(localb, this.wRa);
        return localb;
      }
    }
  }
  
  public static enum c
  {
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.e
 * JD-Core Version:    0.7.0.1
 */
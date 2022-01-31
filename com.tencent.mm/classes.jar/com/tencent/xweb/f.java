package com.tencent.xweb;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.xwalk.a.b;
import com.tencent.xweb.xwalk.a.c;
import com.tencent.xweb.xwalk.a.e;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class f
{
  private static Map<String, String> BDj;
  private static Class BDk;
  private static int BDl;
  
  static
  {
    AppMethodBeat.i(155568);
    BDj = new HashMap();
    BDk = null;
    BDl = -1;
    AppMethodBeat.o(155568);
  }
  
  private static void a(String paramString, int paramInt1, ValueCallback<Integer> paramValueCallback, int paramInt2)
  {
    AppMethodBeat.i(151414);
    if (paramInt2 != 0)
    {
      d.a(paramString, d.a.BDb);
      if ((paramString.endsWith("ppt")) || (paramString.endsWith("pptx"))) {
        d.aL(paramString, paramInt1, paramInt2);
      }
    }
    paramValueCallback.onReceiveValue(Integer.valueOf(paramInt2));
    AppMethodBeat.o(151414);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, Activity paramActivity, ViewGroup paramViewGroup, ValueCallback<Integer> paramValueCallback)
  {
    AppMethodBeat.i(151412);
    d.iY(paramString2, d.a.BDb.name());
    b localb;
    int i;
    if ((paramString2.endsWith("ppt")) || (paramString2.endsWith("pptx")))
    {
      localb = (b)e.ayq("XFilesPPTReader");
      if (localb == null)
      {
        Log.e("FileReaderXWeb", "readPPTFile plugin not found");
        a(paramString2, -1, paramValueCallback, -1);
        AppMethodBeat.o(151412);
        return;
      }
      i = localb.BKm;
      if (i <= 0)
      {
        Log.e("FileReaderXWeb", "readPPTFile plugin not installed");
        a(paramString2, -1, paramValueCallback, -2);
        AppMethodBeat.o(151412);
        return;
      }
      if (i < 203)
      {
        Log.e("FileReaderXWeb", "readPPTFile plugin version is too old, require: 203");
        a(paramString2, i, paramValueCallback, -11);
        AppMethodBeat.o(151412);
        return;
      }
      Log.i("FileReaderXWeb", "readPPTFile by xweb, plugin version " + i + ", token " + paramString3);
      int j = localb.BKm;
      if (j <= 0) {
        Log.e("XWalkPlugin", "reportUsingVersion plugin not installed: " + localb.eak());
      }
      for (;;)
      {
        try
        {
          long l1 = System.currentTimeMillis();
          long l2 = d.jR(paramActivity);
          boolean bool2 = false;
          boolean bool1 = true;
          if (q.dYn() != null)
          {
            bool2 = q.dYn().dYo();
            bool1 = q.dYn().BDH.getSharedPreferences("wcwebview", 4).getBoolean("fr_disable_encry", true);
          }
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("cache_dir", localb.TK(i));
          ((HashMap)localObject1).put("res_dir", localb.TL(i));
          ((HashMap)localObject1).put("disable_cache", String.valueOf(bool2));
          ((HashMap)localObject1).put("disable_encry", String.valueOf(bool1));
          ((HashMap)localObject1).put("file_path", paramString1);
          ((HashMap)localObject1).put("file_ext", paramString2);
          ((HashMap)localObject1).put("token", paramString3);
          ((HashMap)localObject1).put("time_start", String.valueOf(l1));
          ((HashMap)localObject1).put("memory_start", String.valueOf(l2));
          if ((BDk == null) || (BDl != i))
          {
            Log.i("FileReaderXWeb", "readPPTFile load reader class of version ".concat(String.valueOf(i)));
            BDk = new DexClassLoader(localb.bX(i, "pptreader.apk"), localb.TH(i), null, ClassLoader.getSystemClassLoader()).loadClass("com.tencent.xweb.xfiles.ppt.PPTReader");
            BDl = i;
          }
          localObject2 = BDk.getMethod("readFile", new Class[] { Activity.class, ViewGroup.class, ClassLoader.class, HashMap.class, ValueCallback.class, ValueCallback.class, ValueCallback.class });
          ((Method)localObject2).setAccessible(true);
          z.onStart(paramString2);
          ((Method)localObject2).invoke(null, new Object[] { paramActivity, paramViewGroup, BDk.getClassLoader(), localObject1, new f.1(), new f.2(i), new f.3(paramString2, i, paramValueCallback) });
          BDj.put(paramString3 + paramString1, "XFilesPPTReader");
          AppMethodBeat.o(151412);
          return;
        }
        catch (Exception paramString1)
        {
          Object localObject1;
          Object localObject2;
          int k;
          String str;
          Log.e("FileReaderXWeb", "readPPTFile error: " + paramString1.getMessage());
          BDk = null;
          BDl = -1;
          localb.ean();
          a(paramString2, i, paramValueCallback, -3);
          AppMethodBeat.o(151412);
          return;
        }
        localObject2 = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(localb.eak());
        if (localObject2 == null)
        {
          Log.e("XWalkPlugin", "reportUsingVersion sp is null");
        }
        else
        {
          k = ((SharedPreferences)localObject2).getInt("lastReportVersion", -1);
          str = ((SharedPreferences)localObject2).getString("lastReportDate", "");
          try
          {
            localObject1 = new SimpleDateFormat("yyyyMMdd").format(new Date());
            if ((k == j) && (str.equals(localObject1))) {
              continue;
            }
            k = j % 50 + 100;
            Log.i("XWalkPlugin", "reportUsingVersion of " + localb.eak() + ", id:1068, key:" + k);
            com.tencent.xweb.util.f.m(1068L, k, 1L);
            localObject2 = ((SharedPreferences)localObject2).edit();
            if (localObject2 == null) {
              continue;
            }
            ((SharedPreferences.Editor)localObject2).putInt("lastReportVersion", j);
            ((SharedPreferences.Editor)localObject2).putString("lastReportDate", (String)localObject1);
            ((SharedPreferences.Editor)localObject2).commit();
          }
          catch (Exception localException)
          {
            Log.e("XWalkPlugin", "reportUsingVersion get cur date error: " + localException.getMessage());
          }
          continue;
          Log.e("XWalkPlugin", "reportUsingVersion editor is null");
        }
      }
    }
    Log.e("FileReaderXWeb", "readFile unSupport format".concat(String.valueOf(paramString2)));
    a(paramString2, -1, paramValueCallback, -7);
    AppMethodBeat.o(151412);
  }
  
  public static void iZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151413);
    Object localObject = (String)BDj.get(paramString1 + paramString2);
    if (localObject == null)
    {
      Log.i("FileReaderXWeb", "finishReadFile but not read before, skip");
      AppMethodBeat.o(151413);
      return;
    }
    BDj.remove(paramString1 + paramString2);
    if (("XFilesPPTReader".equals(localObject)) && (BDk != null))
    {
      Log.i("FileReaderXWeb", "finishReadFile, token ".concat(String.valueOf(paramString1)));
      try
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("file_path", paramString2);
        ((HashMap)localObject).put("token", paramString1);
        paramString1 = BDk.getMethod("finishReadFile", new Class[] { HashMap.class });
        paramString1.setAccessible(true);
        paramString1.invoke(null, new Object[] { localObject });
        AppMethodBeat.o(151413);
        return;
      }
      catch (Exception paramString1)
      {
        Log.e("FileReaderXWeb", "finishReadFile error: " + paramString1.getMessage());
        AppMethodBeat.o(151413);
        return;
      }
    }
    Log.e("FileReaderXWeb", "finishReadFile unknown plugin: ".concat(String.valueOf(localObject)));
    AppMethodBeat.o(151413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.f
 * JD-Core Version:    0.7.0.1
 */
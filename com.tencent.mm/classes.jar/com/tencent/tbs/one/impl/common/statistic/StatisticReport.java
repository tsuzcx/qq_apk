package com.tencent.tbs.one.impl.common.statistic;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.a.e;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.d.a.a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class StatisticReport
{
  private static String a = "https://tbsone.imtt.qq.com";
  private static WeakReference<Context> h;
  private static String i = "log.lock";
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  
  private StatisticReport(String paramString, int paramInt)
  {
    AppMethodBeat.i(174205);
    this.b = "";
    this.c = "";
    this.d = "";
    this.e = "";
    this.f = "";
    this.g = "";
    this.b = paramString;
    this.c = String.valueOf(paramInt);
    AppMethodBeat.o(174205);
  }
  
  private static int a()
  {
    AppMethodBeat.i(174211);
    Object localObject = new File(e.a(), i);
    if (((File)localObject).exists()) {
      try
      {
        localObject = com.tencent.tbs.one.impl.a.c.a(new FileInputStream((File)localObject), "utf-8");
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        if (bool)
        {
          AppMethodBeat.o(174211);
          return -1;
        }
        int j = Integer.parseInt((String)localObject);
        AppMethodBeat.o(174211);
        return j;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(174211);
        return -1;
      }
    }
    AppMethodBeat.o(174211);
    return -1;
  }
  
  public static StatisticReport create(String paramString, int paramInt)
  {
    AppMethodBeat.i(174206);
    paramString = new StatisticReport(paramString, paramInt);
    AppMethodBeat.o(174206);
    return paramString;
  }
  
  public static void initialize(Context paramContext)
  {
    AppMethodBeat.i(174203);
    h = new WeakReference(paramContext);
    AppMethodBeat.o(174203);
  }
  
  public static void reportLog()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(174212);
        Context localContext1 = (Context)h.get();
        if (localContext1 == null)
        {
          f.c("Null context! Have you initialized Statistic with null context or haven't initialized Statistic?", new Object[] { new Throwable("Null context!") });
          AppMethodBeat.o(174212);
          return;
        }
        int j = a();
        if ((j > 0) && (j == c.c(localContext1)))
        {
          f.a("Detected logs have been uploaded in this version, log report ignored.", new Object[0]);
          AppMethodBeat.o(174212);
          continue;
        }
        b.a();
      }
      finally {}
      b.a(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174214);
          e.a();
          new a(e.a()).a(new l() {});
          AppMethodBeat.o(174214);
        }
      });
      AppMethodBeat.o(174212);
    }
  }
  
  public static void shiftRepService(boolean paramBoolean)
  {
    AppMethodBeat.i(174204);
    if (paramBoolean) {}
    for (String str = "https://tbsone.sparta.html5.qq.com";; str = "https://tbsone.imtt.qq.com")
    {
      a = str;
      new StringBuilder("Shifting to report server: ").append(a);
      AppMethodBeat.o(174204);
      return;
    }
  }
  
  public void report()
  {
    AppMethodBeat.i(174210);
    Context localContext = (Context)h.get();
    if (localContext == null)
    {
      f.c("Null context! Have you initialized Statistic with null context or haven't initialized Statistic?", new Object[] { new Throwable("Null context!") });
      AppMethodBeat.o(174210);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PROTV", Integer.valueOf(1));
    localHashMap.put("FUNC", Integer.valueOf(2));
    localHashMap.put("EVENT", this.b);
    localHashMap.put("CODE", this.c);
    if (!TextUtils.isEmpty(this.d)) {}
    for (Object localObject = this.d.replaceAll("\r\n|\r|\n", "");; localObject = "")
    {
      localHashMap.put("DESCRIPTION", localObject);
      localHashMap.put("IMEI", c.e(localContext));
      localHashMap.put("DEVMODEL", c.b());
      localHashMap.put("CPUABI", c.a());
      localHashMap.put("APPVERCODE", c.c(localContext));
      localHashMap.put("APPVERNAME", c.b(localContext));
      localHashMap.put("APPPKG", localContext.getPackageName());
      localHashMap.put("CREATETIME", System.currentTimeMillis());
      localHashMap.put("APNTYPE", c.a(localContext));
      localHashMap.put("ANDROIDID", c.f(localContext));
      localHashMap.put("ONECODE", "1");
      localHashMap.put("ONENAME", "1.0.0");
      localHashMap.put("COMPNAME", this.e);
      localHashMap.put("COMPCODE", this.f);
      localHashMap.put("DEPSCODE", this.g);
      localHashMap.put("SDKCODE", c.c());
      localHashMap.put("MODEL", Build.MODEL);
      localHashMap.put("ADV", Build.VERSION.RELEASE);
      localObject = new JSONObject(localHashMap).toString();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      AppMethodBeat.o(174210);
      return;
    }
    localObject = new com.tencent.tbs.one.impl.d.a(localContext, a, "POST", null, ((String)localObject).getBytes());
    ((com.tencent.tbs.one.impl.d.a)localObject).f = new a.a()
    {
      public final void a(int paramAnonymousInt, Map<String, List<String>> paramAnonymousMap, InputStream paramAnonymousInputStream)
      {
        AppMethodBeat.i(174215);
        if (paramAnonymousInputStream == null)
        {
          AppMethodBeat.o(174215);
          return;
        }
        try
        {
          paramAnonymousMap = new ByteArrayOutputStream();
          byte[] arrayOfByte = new byte[1024];
          for (;;)
          {
            paramAnonymousInt = paramAnonymousInputStream.read(arrayOfByte);
            if (paramAnonymousInt == -1) {
              break;
            }
            paramAnonymousMap.write(arrayOfByte, 0, paramAnonymousInt);
          }
          paramAnonymousMap.close();
        }
        catch (IOException paramAnonymousMap)
        {
          AppMethodBeat.o(174215);
          return;
        }
        paramAnonymousInputStream.close();
        paramAnonymousMap = new String(paramAnonymousMap.toByteArray());
        f.c(paramAnonymousMap, new Object[0]);
        try
        {
          paramAnonymousInt = new JSONObject(paramAnonymousMap).getInt("CODE");
          if (paramAnonymousInt == 0)
          {
            f.a("Statistic report successfully!", new Object[0]);
            AppMethodBeat.o(174215);
            return;
          }
        }
        catch (JSONException paramAnonymousMap)
        {
          AppMethodBeat.o(174215);
          return;
        }
        if (paramAnonymousInt == -1001)
        {
          f.c("Statistic report error! Not post method!", new Object[0]);
          AppMethodBeat.o(174215);
          return;
        }
        if (paramAnonymousInt == -1002)
        {
          f.c("Statistic report error! Params not valid!", new Object[0]);
          AppMethodBeat.o(174215);
          return;
        }
        if (paramAnonymousInt == -1003)
        {
          f.c("Statistic report error! Server exception!", new Object[0]);
          AppMethodBeat.o(174215);
          return;
        }
        if (paramAnonymousInt == -1004)
        {
          f.c("Statistic report error! Server over charge!", new Object[0]);
          AppMethodBeat.o(174215);
          return;
        }
        if (paramAnonymousInt == -1005)
        {
          f.c("Statistic report error! DB exception!", new Object[0]);
          AppMethodBeat.o(174215);
          return;
        }
        if (paramAnonymousInt == -1006)
        {
          f.c("Statistic report error! DB exception!", new Object[0]);
          AppMethodBeat.o(174215);
          return;
        }
        if (paramAnonymousInt == -1007) {
          f.c("Statistic report error! Config not hit!", new Object[0]);
        }
        AppMethodBeat.o(174215);
      }
    };
    ((com.tencent.tbs.one.impl.d.a)localObject).a(new l()
    {
      public final void a(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(174201);
        f.c(paramAnonymousString, new Object[] { paramAnonymousThrowable });
        AppMethodBeat.o(174201);
      }
    });
    AppMethodBeat.o(174210);
  }
  
  public StatisticReport setComponent(String paramString, int paramInt)
  {
    AppMethodBeat.i(174208);
    this.e = paramString;
    this.f = String.valueOf(paramInt);
    AppMethodBeat.o(174208);
    return this;
  }
  
  public StatisticReport setDEPSCode(int paramInt)
  {
    AppMethodBeat.i(174209);
    this.g = String.valueOf(paramInt);
    AppMethodBeat.o(174209);
    return this;
  }
  
  public StatisticReport setDescription(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public StatisticReport setDescription(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(174207);
    StringBuilder localStringBuilder = new StringBuilder().append(paramString).append("@");
    if (paramThrowable != null) {}
    for (paramString = Log.getStackTraceString(paramThrowable);; paramString = "")
    {
      this.d = paramString;
      AppMethodBeat.o(174207);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.StatisticReport
 * JD-Core Version:    0.7.0.1
 */
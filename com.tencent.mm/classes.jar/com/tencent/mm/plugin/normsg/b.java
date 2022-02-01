package com.tencent.mm.plugin.normsg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.d.a.d.1;
import com.tencent.d.e.a.d.a;
import com.tencent.h.a.h.a;
import com.tencent.h.a.i;
import com.tencent.h.a.i.a;
import com.tencent.h.a.j;
import com.tencent.h.a.m.a;
import com.tencent.h.a.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ag;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.f.a.cw;
import com.tencent.mm.f.a.cw.b;
import com.tencent.mm.normsg.c.p;
import com.tencent.mm.normsgext.QValue;
import com.tencent.mm.plugin.normsg.d.k;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.edb;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.WiFiScanResult;
import com.tencent.mm.sdk.platformtools.ImmutableBundle;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.storage.ao;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

 enum b
  implements com.tencent.mm.normsg.a, com.tencent.mm.normsgext.a, com.tencent.mm.plugin.normsg.a.a
{
  private static final MMHandler Gxz;
  private final String[] GxA;
  private final Map<String, String> GxB;
  
  static
  {
    AppMethodBeat.i(148981);
    Gxy = new b("INSTANCE");
    GxC = new b[] { Gxy };
    Gxz = new MMHandler("NormsgWorker");
    AppMethodBeat.o(148981);
  }
  
  private b()
  {
    AppMethodBeat.i(257727);
    this.GxA = new String[] { null };
    this.GxB = new ConcurrentHashMap();
    AppMethodBeat.o(257727);
  }
  
  private static String aTg(String paramString)
  {
    AppMethodBeat.i(148947);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148947);
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      switch (c)
      {
      default: 
        if ((c > '~') || (c == '[') || (c == ']')) {
          localStringBuilder.append("&#").append(c).append(';');
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("&quot;");
        continue;
        localStringBuilder.append("&amp;");
        continue;
        localStringBuilder.append("&apos;");
        continue;
        localStringBuilder.append("&lt;");
        continue;
        localStringBuilder.append("&gt;");
        continue;
        localStringBuilder.append(c);
      }
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(148947);
    return paramString;
  }
  
  private static String anV()
  {
    AppMethodBeat.i(148950);
    for (;;)
    {
      try
      {
        localObject = ((ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (((NetworkInfo)localObject).getType() != 1) {
          continue;
        }
        localObject = "wifi";
      }
      catch (Exception localException)
      {
        Object localObject;
        Log.e("MicroMsg.NormsgSourceImpl", "getNetTypeStr: %s", new Object[] { Util.stackTraceToString(localException) });
        String str = "";
        continue;
      }
      AppMethodBeat.o(148950);
      return localObject;
      localObject = ((NetworkInfo)localObject).getSubtype();
    }
  }
  
  private static int getVersionCode()
  {
    int i = 0;
    AppMethodBeat.i(148949);
    Object localObject1 = MMApplicationContext.getContext().getPackageManager();
    try
    {
      localObject1 = ((PackageManager)localObject1).getPackageInfo(MMApplicationContext.getPackageName(), 0);
      if (localObject1 != null) {
        i = ((PackageInfo)localObject1).versionCode;
      }
      AppMethodBeat.o(148949);
      return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Object localObject2 = null;
        Log.w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + MMApplicationContext.getPackageName());
      }
    }
  }
  
  private static String iE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148948);
    localObject1 = "";
    Object localObject2 = MMApplicationContext.getContext().getPackageManager();
    try
    {
      localObject2 = ((PackageManager)localObject2).getPackageInfo(MMApplicationContext.getPackageName(), 0);
      if (localObject2 != null) {
        localObject1 = ((PackageInfo)localObject2).applicationInfo.sourceDir;
      }
      try
      {
        localObject2 = com.tencent.mm.d.c.u(new File((String)localObject1));
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2))
        {
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(322L, 13L, 1L, true);
          com.tencent.mm.plugin.report.f.Iyx.a(11098, new Object[] { Integer.valueOf(4013), String.format("%s|%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }) });
          localObject1 = localObject2;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject3;
          Log.w("MicroMsg.NormsgSourceImpl", "summertoken getSecurityCode e: " + localException.getMessage());
          localObject1 = "0";
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(322L, 12L, 1L, true);
          com.tencent.mm.plugin.report.f.Iyx.a(11098, new Object[] { Integer.valueOf(4012), String.format("%s|%s|%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localException.getMessage() }) });
        }
      }
      AppMethodBeat.o(148948);
      return localObject1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localObject3 = null;
        Log.w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + MMApplicationContext.getPackageName());
      }
    }
  }
  
  public static boolean isDualByTools()
  {
    AppMethodBeat.i(148957);
    boolean bool = c.p.aj();
    Log.i("MicroMsg.NormsgSourceImpl", "[tomys-edt] charlie brown: %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(148957);
    return bool;
  }
  
  public static boolean isHookedByXposed()
  {
    AppMethodBeat.i(148955);
    boolean bool = c.p.ah();
    Log.i("MicroMsg.NormsgSourceImpl", "[tomys-edt] alpha tom: %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(148955);
    return bool;
  }
  
  public static boolean isX86Env()
  {
    AppMethodBeat.i(148956);
    boolean bool = c.p.ai();
    Log.i("MicroMsg.NormsgSourceImpl", "[tomys-edt] bravo jerry: %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(148956);
    return bool;
  }
  
  public final String H(Context paramContext, String paramString)
  {
    AppMethodBeat.i(257802);
    String str = (String)this.GxB.get(paramString);
    Object localObject = str;
    if (str == null)
    {
      paramContext = NormsgDataService.H(paramContext, paramString);
      localObject = paramContext;
      if (!TextUtils.isEmpty(paramContext))
      {
        this.GxB.put(paramString, paramContext);
        localObject = paramContext;
      }
    }
    paramContext = Util.nullAsNil((String)localObject);
    AppMethodBeat.o(257802);
    return paramContext;
  }
  
  public final boolean M(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148977);
    boolean bool = c.p.eb(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(148977);
    return bool;
  }
  
  public final void R(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(257784);
    com.tencent.mm.plugin.report.service.h.IzE.p(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(257784);
  }
  
  public final void T(int paramInt, String paramString)
  {
    AppMethodBeat.i(257783);
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(paramInt, paramString);
    AppMethodBeat.o(257783);
  }
  
  public final byte[] Zy(String paramString)
  {
    AppMethodBeat.i(257796);
    paramString = MultiProcessMMKV.getMMKV(new StringBuilder("atadtsurt_").reverse().toString()).decodeBytes(paramString);
    AppMethodBeat.o(257796);
    return paramString;
  }
  
  public final void Zz(String paramString)
  {
    AppMethodBeat.i(257799);
    MultiProcessMMKV.getMMKV(new StringBuilder("atadtsurt_").reverse().toString()).remove(paramString).commit();
    AppMethodBeat.o(257799);
  }
  
  public final void a(View paramView, Class<? extends IEvent> paramClass)
  {
    AppMethodBeat.i(148961);
    com.tencent.mm.plugin.normsg.d.c.a(paramView, paramClass);
    AppMethodBeat.o(148961);
  }
  
  public final void a(com.tencent.mm.plugin.normsg.a.b paramb)
  {
    AppMethodBeat.i(257775);
    try
    {
      if (!BuildInfo.IS_FLAVOR_RED)
      {
        bool = BuildInfo.DEBUG;
        if (!bool) {
          break label33;
        }
      }
      label33:
      for (boolean bool = true; !bool; bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vZI, false))
      {
        AppMethodBeat.o(257775);
        return;
      }
      Object localObject = new m.a();
      ((m.a)localObject).ZSm = new j();
      n.a(MMApplicationContext.getContext(), ((m.a)localObject).itG());
      localObject = new com.tencent.h.a.e()
      {
        public final boolean cm(byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(257898);
          com.tencent.mm.plugin.secinforeport.a.d.Jcm.asyncReportTuringOwnerThroughCgi(paramAnonymousArrayOfByte);
          AppMethodBeat.o(257898);
          return true;
        }
      };
      h.a locala = new h.a((byte)0);
      locala.ELa = MD5Util.getMD5String(q.getAndroidId());
      locala.ZRS = 4;
      locala.ZRT = com.tencent.h.a.b.ZRN;
      locala.ZRU = com.tencent.h.a.c.ZRP;
      locala.ZRY = paramb;
      n.a(locala, (com.tencent.h.a.e)localObject);
      AppMethodBeat.o(257775);
      return;
    }
    catch (Throwable paramb)
    {
      Log.i("MicroMsg.NormsgSourceImpl", "start turing owner failed");
      AppMethodBeat.o(257775);
    }
  }
  
  public final void a(String paramString, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(148971);
    c.p.dg(paramString, paramMotionEvent);
    AppMethodBeat.o(148971);
  }
  
  public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PByteArray paramPByteArray)
  {
    AppMethodBeat.i(148964);
    QValue localQValue1 = new QValue();
    QValue localQValue2 = new QValue();
    QValue localQValue3 = new QValue();
    boolean bool = com.tencent.mm.normsgext.b.a.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, localQValue1, localQValue2, localQValue3);
    if (bool)
    {
      paramArrayOfByte = new edb();
      paramArrayOfByte.Uhw = ((Integer)localQValue1.getValue(Integer.valueOf(0))).intValue();
      paramArrayOfByte.Uhx = ((Integer)localQValue2.getValue(Integer.valueOf(0))).intValue();
      paramArrayOfByte.SpW = com.tencent.mm.cd.b.cU((byte[])localQValue3.value);
    }
    try
    {
      paramPByteArray.value = paramArrayOfByte.toByteArray();
      AppMethodBeat.o(148964);
      return bool;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        Log.e("MicroMsg.NormsgSourceImpl", "[-] pb deseralize failed");
      }
    }
  }
  
  public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, PByteArray paramPByteArray)
  {
    AppMethodBeat.i(148963);
    QValue localQValue1 = new QValue();
    QValue localQValue2 = new QValue();
    QValue localQValue3 = new QValue();
    boolean bool = com.tencent.mm.normsgext.b.a.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, localQValue1, localQValue2, localQValue3);
    if (bool)
    {
      paramPInt1.value = ((Integer)localQValue1.getValue(Integer.valueOf(0))).intValue();
      paramPInt2.value = ((Integer)localQValue2.getValue(Integer.valueOf(0))).intValue();
    }
    for (paramPByteArray.value = ((byte[])localQValue3.value);; paramPByteArray.value = null)
    {
      AppMethodBeat.o(148963);
      return bool;
      paramPInt1.value = 0;
      paramPInt2.value = 0;
    }
  }
  
  public final String aTf(String paramString)
  {
    AppMethodBeat.i(148945);
    int j = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append((char)(paramString.charAt(i) ^ 0xFFFFFFA7 ^ (byte)(i + 1 ^ j ^ 0xFFFFFFFF)));
      i += 1;
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(148945);
    return paramString;
  }
  
  public final void aTh(String paramString)
  {
    AppMethodBeat.i(148965);
    c.p.da(paramString);
    AppMethodBeat.o(148965);
  }
  
  public final void aTi(String paramString)
  {
    AppMethodBeat.i(148966);
    c.p.db(paramString);
    AppMethodBeat.o(148966);
  }
  
  public final void aTj(String paramString)
  {
    AppMethodBeat.i(148967);
    c.p.dc(paramString);
    AppMethodBeat.o(148967);
  }
  
  public final boolean aTk(String paramString)
  {
    AppMethodBeat.i(148968);
    boolean bool = c.p.dd(paramString);
    AppMethodBeat.o(148968);
    return bool;
  }
  
  public final byte[] aTl(String paramString)
  {
    AppMethodBeat.i(148969);
    paramString = c.p.de(paramString);
    AppMethodBeat.o(148969);
    return paramString;
  }
  
  public final void aTm(String paramString)
  {
    AppMethodBeat.i(148972);
    c.p.dh(paramString);
    AppMethodBeat.o(148972);
  }
  
  public final boolean aTn(String paramString)
  {
    AppMethodBeat.i(148973);
    boolean bool = c.p.di(paramString);
    AppMethodBeat.o(148973);
    return bool;
  }
  
  public final byte[] aTo(String paramString)
  {
    AppMethodBeat.i(148974);
    paramString = c.p.dj(paramString);
    AppMethodBeat.o(148974);
    return paramString;
  }
  
  public final String aTp(String paramString)
  {
    AppMethodBeat.i(257749);
    paramString = c.p.dk(paramString);
    AppMethodBeat.o(257749);
    return paramString;
  }
  
  public final String[] aTq(String paramString)
  {
    AppMethodBeat.i(257807);
    cw localcw = new cw();
    localcw.fyy.path = paramString;
    EventCenter.instance.publish(localcw);
    if (localcw.fyz.fyA != null)
    {
      paramString = localcw.fyz.fyA;
      AppMethodBeat.o(257807);
      return paramString;
    }
    if (localcw.fyz.isTimeout)
    {
      AppMethodBeat.o(257807);
      return new String[] { "<timeout>" };
    }
    AppMethodBeat.o(257807);
    return null;
  }
  
  public final byte[] aaw(int paramInt)
  {
    AppMethodBeat.i(148943);
    byte[] arrayOfByte = c.p.aa(paramInt, 0);
    AppMethodBeat.o(148943);
    return arrayOfByte;
  }
  
  public final String aax(int paramInt)
  {
    AppMethodBeat.i(148946);
    Object localObject4 = "";
    if (com.tencent.mm.kernel.h.aHB()) {
      localObject4 = (String)com.tencent.mm.kernel.h.aHG().aHp().b(79, "");
    }
    com.tencent.mm.kernel.h.aHJ().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(148938);
        if (!com.tencent.mm.kernel.h.aHB())
        {
          AppMethodBeat.o(148938);
          return;
        }
        try
        {
          long l1 = System.currentTimeMillis();
          Object localObject = MMApplicationContext.getContext().getApplicationInfo().sourceDir;
          com.tencent.mm.kernel.h.aHE();
          localObject = c.p.ae(com.tencent.mm.kernel.b.getUin());
          com.tencent.mm.kernel.h.aHE();
          byte[] arrayOfByte = c.p.af(com.tencent.mm.kernel.b.getUin());
          long l2 = System.currentTimeMillis();
          String str = String.format("<k25>%s</k25>", new Object[] { com.tencent.mm.plugin.normsg.d.d.N((byte[])localObject, 0, localObject.length) });
          localObject = str;
          if (arrayOfByte != null)
          {
            if (arrayOfByte.length != 8) {
              break label340;
            }
            int i = arrayOfByte[0];
            arrayOfByte[0] = arrayOfByte[3];
            arrayOfByte[3] = i;
            i = arrayOfByte[1];
            arrayOfByte[1] = arrayOfByte[2];
            arrayOfByte[2] = i;
            i = arrayOfByte[4];
            arrayOfByte[4] = arrayOfByte[7];
            arrayOfByte[7] = i;
            i = arrayOfByte[5];
            arrayOfByte[5] = arrayOfByte[6];
            arrayOfByte[6] = i;
          }
          for (localObject = str + String.format("<k28>%s</k28><k29>%s</k29>", new Object[] { com.tencent.mm.plugin.normsg.d.d.N(arrayOfByte, 0, 4), com.tencent.mm.plugin.normsg.d.d.N(arrayOfByte, 4, 8) });; localObject = str + String.format("<k27>%s</k27>", new Object[] { com.tencent.mm.plugin.normsg.d.d.N(arrayOfByte, 0, arrayOfByte.length) }))
          {
            try
            {
              str = Inet4Address.getByName(WeChatHosts.domainString(c.a.host_mp_weixin_qq_com)).getHostAddress();
              str = (String)localObject + String.format("<k32>%s</k32>", new Object[] { Util.nullAsNil(str) });
              localObject = str;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                label340:
                Log.e("MicroMsg.NormsgSourceImpl", "exception:%s", new Object[] { Util.stackTraceToString(localException2) });
              }
            }
            Log.i("MicroMsg.NormsgSourceImpl", "checkSoftType2 [time: " + (l2 - l1) + ", value: " + (String)localObject + "]");
            com.tencent.mm.kernel.h.aHG().aHp().i(79, localObject);
            AppMethodBeat.o(148938);
            return;
          }
          return;
        }
        catch (Exception localException1)
        {
          Log.printErrStackTrace("MicroMsg.NormsgSourceImpl", localException1, "Failed checkSoftType2.", new Object[0]);
          AppMethodBeat.o(148938);
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(148939);
        String str = super.toString() + "|checkSoftTypeExtra";
        AppMethodBeat.o(148939);
        return str;
      }
    }, 5000L);
    String str1 = "";
    Object localObject1;
    label124:
    int i;
    label126:
    int j;
    label132:
    label140:
    int k;
    label149:
    int m;
    label170:
    int n;
    label179:
    int i1;
    label188:
    label209:
    int i2;
    String str2;
    Object localObject2;
    Object localObject7;
    if (com.tencent.mm.kernel.h.aHB())
    {
      if (com.tencent.mm.kernel.h.aHG().kcF.VJC.VIW) {
        str1 = "1";
      }
    }
    else
    {
      Context localContext = MMApplicationContext.getContext().getApplicationContext();
      String str3 = ConnectivityCompat.Companion.getFormattedWiFiSsid();
      String str4 = ConnectivityCompat.Companion.getFormattedWiFiBssid();
      localObject1 = MMApplicationContext.getContext();
      if (localObject1 != null) {
        break label1289;
      }
      Log.w("MicroMsg.NormsgSourceImpl", "Failed checking mock location: application context not initialized.");
      i = 0;
      if (i == 0) {
        break label1309;
      }
      i = 1;
      if (!c.p.ab()) {
        break label1314;
      }
      j = 1;
      if (!Debug.isDebuggerConnected()) {
        break label1319;
      }
      k = 1;
      if ((!com.tencent.mm.plugin.normsg.d.g.Gzw) && (!com.tencent.mm.plugin.normsg.d.g.Gzx) && (!com.tencent.mm.plugin.normsg.d.g.Gzy)) {
        break label1325;
      }
      m = 1;
      if (!com.tencent.mm.plugin.normsg.d.f.Gzs) {
        break label1331;
      }
      n = 1;
      if (!com.tencent.mm.plugin.normsg.d.h.Gzz) {
        break label1337;
      }
      i1 = 1;
      localObject1 = c.p.ad();
      if (localObject1 == null) {
        break label1343;
      }
      localObject3 = com.tencent.mm.plugin.normsg.d.d.N((byte[])localObject1, 0, localObject1.length);
      i2 = getVersionCode();
      str2 = iE(i2, paramInt);
      Map localMap = q.auU();
      localObject2 = "1234567890ABCDEF";
      Object localObject5 = "";
      localObject1 = "";
      if (com.tencent.mm.kernel.h.aHB())
      {
        localObject6 = q.dR(true);
        localObject7 = q.auF();
        Log.d("MicroMsg.NormsgSourceImpl", "READ_PHONE_STATE.getLine1Number %s", new Object[] { Util.getStack() });
        localObject8 = Util.nullAsNil(Util.getLine1Number(MMApplicationContext.getContext()));
        localObject1 = localObject8;
        localObject5 = localObject7;
        localObject2 = localObject6;
        if (((String)localObject8).length() > 0)
        {
          localObject1 = com.tencent.mm.b.g.getMessageDigest(((String)localObject8).getBytes());
          localObject2 = localObject6;
          localObject5 = localObject7;
        }
      }
      localObject7 = new StringBuilder();
      Object localObject8 = ((StringBuilder)localObject7).append("<softtype><lctmoc>").append(i).append("</lctmoc><level>").append(j).append("</level>").append((String)localObject4).append("<k1>");
      Object localObject6 = (String)localMap.get("model name");
      localObject4 = localObject6;
      if (localObject6 == null) {
        localObject4 = q.auT()[0];
      }
      localObject6 = ((StringBuilder)localObject8).append(aTg((String)localObject4)).append("</k1><k2>").append(aTg(q.auS())).append("</k2><k3>").append(aTg(Build.VERSION.RELEASE)).append("</k3><k4>").append(aTg((String)localObject2)).append("</k4><k5>").append(aTg((String)localObject5)).append("</k5><k6>").append(aTg(q.auH())).append("</k6><k7>").append(aTg(q.getAndroidId())).append("</k7><k8>").append(aTg(q.auG())).append("</k8><k9>").append(aTg(Build.MODEL)).append("</k9><k10>").append(q.auV()).append("</k10><k11>").append(Util.nullAsNil(aTg((String)localMap.get("hardware")))).append("</k11><k12>").append(Util.nullAsNil(aTg((String)localMap.get("revision")))).append("</k12><k13>").append(Util.nullAsNil(aTg((String)localMap.get("serial")))).append("</k13><k14>").append(aTg(q.auJ())).append("</k14><k15>").append(aTg(q.auK())).append("</k15><k16>");
      localObject5 = (String)localMap.get("features");
      localObject4 = localObject5;
      if (localObject5 == null) {
        localObject4 = (String)localMap.get("flags");
      }
      localObject4 = ((StringBuilder)localObject6).append(Util.nullAsNil(aTg((String)localObject4))).append("</k16><k18>").append((String)localObject3).append("</k18><k21>").append(Util.nullAsNil(aTg(str3))).append("</k21><k22>").append(Util.nullAsNil(aTg(q.cp(localContext)))).append("</k22><k24>").append(Util.nullAsNil(aTg(str4))).append("</k24><k26>").append(k).append("</k26><k30>");
      localObject3 = ((ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localObject3 == null) {
        break label1357;
      }
    }
    label1289:
    label1309:
    label1314:
    label1319:
    label1325:
    label1331:
    label1337:
    label1343:
    label1357:
    for (Object localObject3 = ((NetworkInfo)localObject3).getExtraInfo();; localObject3 = null)
    {
      localObject1 = ((StringBuilder)localObject4).append(Util.nullAsNil(aTg((String)localObject3))).append("</k30><k33>").append(aTg(MMApplicationContext.getPackageName())).append("</k33><k34>").append(Util.nullAsNil(aTg(ag.get("ro.build.fingerprint")))).append("</k34><k35>").append(Util.nullAsNil(aTg(Build.BOARD))).append("</k35><k36>").append(Util.nullAsNil(aTg(Build.BOOTLOADER))).append("</k36><k37>").append(Util.nullAsNil(aTg(Build.BRAND))).append("</k37><k38>").append(Util.nullAsNil(aTg(Build.DEVICE))).append("</k38><k39>").append(Util.nullAsNil(aTg(Build.HARDWARE))).append("</k39><k40>").append(Util.nullAsNil(aTg(Build.PRODUCT))).append("</k40><k41>").append(m).append("</k41><k42>").append(Util.nullAsNil(aTg(ag.get("ro.product.manufacturer")))).append("</k42><k43>").append(Settings.System.getString(MMApplicationContext.getContext().getContentResolver(), "89884a87498ef44f")).append("</k43><k44>0</k44><k45>").append((String)localObject1).append("</k45><k46>").append(str1).append("</k46><k47>").append(aTg(anV())).append("</k47><k48>").append((String)localObject2).append("</k48><k49>").append(com.tencent.mm.loader.j.b.aSC()).append("</k49><k52>").append(n).append("</k52><k53>").append(i1).append("</k53><k57>").append(i2).append("</k57><k58>").append(Util.nullAsNil(aTg(str2))).append("</k58><k59>").append(paramInt).append("</k59><k60>").append(aTg(BuildInfo.ext.getString("FEATURE_ID"))).append("</k60><k61>").append(q.auO()).append("</k61><k62>");
      str1 = com.tencent.mm.plugin.soter.d.d.gai().Lwz;
      if (str1 != null) {}
      for (;;)
      {
        ((StringBuilder)localObject1).append(str1).append("</k62><k63>").append(q.auM()).append("</k63><k64>").append(q.auP()).append("</k64><k65>").append(q.auQ()).append("</k65></softtype>");
        str1 = ((StringBuilder)localObject7).toString();
        AppMethodBeat.o(148946);
        return str1;
        str1 = "0";
        break;
        if (Settings.Secure.getInt(((Context)localObject1).getContentResolver(), "mock_location", 0) == 0) {
          break label124;
        }
        i = 1;
        break label126;
        i = 0;
        break label132;
        j = 0;
        break label140;
        k = 0;
        break label149;
        m = 0;
        break label170;
        n = 0;
        break label179;
        i1 = 0;
        break label188;
        localObject3 = "";
        break label209;
        str1 = "";
      }
    }
  }
  
  public final void aay(int paramInt)
  {
    AppMethodBeat.i(148962);
    com.tencent.mm.plugin.normsg.d.a.fjB().aay(paramInt);
    AppMethodBeat.o(148962);
  }
  
  public final byte[] aaz(int paramInt)
  {
    AppMethodBeat.i(148976);
    if (com.tencent.mm.kernel.h.aHB()) {}
    for (int i = 7;; i = 0)
    {
      byte[] arrayOfByte = c.p.ea(paramInt, i);
      AppMethodBeat.o(148976);
      return arrayOfByte;
    }
  }
  
  public final String auQ()
  {
    AppMethodBeat.i(148980);
    try
    {
      Object localObject = com.tencent.d.e.b.a.a.b.lS(MMApplicationContext.getContext());
      if (((com.tencent.d.e.b.a.a.c)localObject).errorCode == 0)
      {
        localObject = Util.nullAsNil(((com.tencent.d.e.b.a.a.c)localObject).JyL);
        AppMethodBeat.o(148980);
        return localObject;
      }
      Log.e("MicroMsg.NormsgSourceImpl", "[-] Fail to get OAID, errorcode: %s", new Object[] { Integer.valueOf(((com.tencent.d.e.b.a.a.c)localObject).errorCode) });
      AppMethodBeat.o(148980);
      return "";
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.NormsgSourceImpl", localThrowable, "Fail to get OAID.", new Object[0]);
      AppMethodBeat.o(148980);
    }
    return "";
  }
  
  public final void av(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(257747);
    c.p.df(paramString1, paramString2, paramString3);
    AppMethodBeat.o(257747);
  }
  
  public final void ay(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(148944);
    Object localObject = MMApplicationContext.getContext();
    if ((paramInt2 <= 0) || (paramInt2 > 4))
    {
      localObject = new IllegalArgumentException("action invalid: ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(148944);
      throw ((Throwable)localObject);
    }
    localObject = new d.a((Context)localObject, paramInt1, paramInt2, (byte)0);
    long l = paramInt3 * 1000;
    if (l < com.tencent.d.e.a.a.f.ZpA) {
      ((d.a)localObject).MMU = com.tencent.d.e.a.a.f.ZpA;
    }
    for (;;)
    {
      ((d.a)localObject).MMU = l;
      localObject = new com.tencent.d.e.a.d((d.a)localObject, (byte)0);
      com.tencent.d.e.a.e.iob().a((com.tencent.d.e.a.d)localObject);
      AppMethodBeat.o(148944);
      return;
      if (l > com.tencent.d.e.a.a.f.Zpx * 12L) {
        ((d.a)localObject).MMU = (com.tencent.d.e.a.a.f.Zpx * 12L);
      }
    }
  }
  
  public final String bue()
  {
    AppMethodBeat.i(257779);
    synchronized (this.GxA)
    {
      if (this.GxA[0] == null)
      {
        Log.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src rf.");
        localObject1 = com.tencent.mm.lib.riskscanner.a.a.cJ(MMApplicationContext.getContext());
        if ((localObject1 != null) && (((Bundle)localObject1).getInt("errCode", -100) == 0))
        {
          localObject1 = ((Bundle)localObject1).getByteArray("reqBufferBase64");
          if (localObject1 != null) {
            this.GxA[0] = Base64.encodeToString((byte[])localObject1, 2);
          }
        }
      }
      if (this.GxA[0] != null)
      {
        localObject1 = this.GxA[0];
        AppMethodBeat.o(257779);
        return localObject1;
      }
      Object localObject1 = "";
    }
  }
  
  public final long buf()
  {
    AppMethodBeat.i(257780);
    long l = com.tencent.mm.plugin.normsg.d.a.fjB().fjC();
    AppMethodBeat.o(257780);
    return l;
  }
  
  public final String bug()
  {
    AppMethodBeat.i(257787);
    String str = com.tencent.mm.plugin.soter.d.d.gai().Lwz;
    if (str != null)
    {
      AppMethodBeat.o(257787);
      return str;
    }
    AppMethodBeat.o(257787);
    return "";
  }
  
  public final boolean buh()
  {
    AppMethodBeat.i(257788);
    boolean bool = k.isConnected();
    AppMethodBeat.o(257788);
    return bool;
  }
  
  public final String bui()
  {
    AppMethodBeat.i(257789);
    String str = com.tencent.mm.plugin.soter.d.d.gai().ktM;
    if (str != null)
    {
      AppMethodBeat.o(257789);
      return str;
    }
    AppMethodBeat.o(257789);
    return "";
  }
  
  public final boolean buj()
  {
    AppMethodBeat.i(257809);
    try
    {
      String str1 = (String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, null);
      if (!TextUtils.isEmpty(str1)) {
        if (com.tencent.mm.plugin.normsg.d.e.aTt(str1))
        {
          AppMethodBeat.o(257809);
          return true;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NormsgSourceImpl", localThrowable, "[-] Error happened.", new Object[0]);
        String str2 = MultiProcessMMKV.getMMKV("mmkv_crossprocess_infos").decodeString("mmkv_key_user_reg_ic", null);
      }
      AppMethodBeat.o(257809);
      return false;
    }
    AppMethodBeat.o(257809);
    return false;
  }
  
  public final List<String> buk()
  {
    AppMethodBeat.i(257814);
    try
    {
      List localList = ConnectivityCompat.Companion.getWiFiScanResults();
      Collections.sort(localList, new Comparator() {});
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      while (i < localList.size())
      {
        String str = ((ConnectivityCompat.WiFiScanResult)localList.get(i)).getBssid();
        if (!TextUtils.isEmpty(str))
        {
          localArrayList2.add(str);
          int j = localArrayList2.size();
          if (j >= 5) {
            break;
          }
        }
        i += 1;
      }
      AppMethodBeat.o(257814);
      return localArrayList2;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.NormsgSourceImpl", localThrowable, "[-] Error happened.", new Object[0]);
      ArrayList localArrayList1 = new ArrayList();
      AppMethodBeat.o(257814);
      return localArrayList1;
    }
  }
  
  public final boolean c(Object paramObject, Class paramClass)
  {
    AppMethodBeat.i(148958);
    boolean bool = c.p.ca(paramObject, paramClass);
    AppMethodBeat.o(148958);
    return bool;
  }
  
  public final boolean dK(Object paramObject)
  {
    AppMethodBeat.i(148960);
    boolean bool = c.p.cb(paramObject);
    AppMethodBeat.o(148960);
    return bool;
  }
  
  public final boolean dk(Context paramContext)
  {
    AppMethodBeat.i(257804);
    boolean bool = NormsgDataService.dk(paramContext);
    AppMethodBeat.o(257804);
    return bool;
  }
  
  public final String fjk()
  {
    AppMethodBeat.i(148952);
    if (WeChatSomeFeatureSwitch.onlyUSMobile())
    {
      AppMethodBeat.o(148952);
      return "";
    }
    if (com.tencent.mm.plugin.normsg.d.e.aTt((String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, null)))
    {
      Log.w("MicroMsg.NormsgSourceImpl", "*** point 0, explained by source code.");
      AppMethodBeat.o(148952);
      return "";
    }
    Object localObject2 = MMApplicationContext.getContext().getPackageManager().getInstalledPackages(0);
    Object localObject1 = new StringBuilder(8192);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((StringBuilder)localObject1).append(((PackageInfo)((Iterator)localObject2).next()).packageName).append('\n');
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(148952);
    return localObject1;
  }
  
  public final boolean fjl()
  {
    AppMethodBeat.i(148953);
    boolean bool = c.p.ab();
    AppMethodBeat.o(148953);
    return bool;
  }
  
  public final boolean fjm()
  {
    AppMethodBeat.i(148954);
    try
    {
      boolean bool = c.p.ag();
      AppMethodBeat.o(148954);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.NormsgSourceImpl", localThrowable, "unexpected error.", new Object[0]);
      AppMethodBeat.o(148954);
    }
    return false;
  }
  
  public final byte[] fjn()
  {
    AppMethodBeat.i(148959);
    try
    {
      if (com.tencent.mm.kernel.h.aHB()) {}
      for (int i = 0;; i = 7)
      {
        byte[] arrayOfByte = c.p.aa(0, i);
        AppMethodBeat.o(148959);
        return arrayOfByte;
      }
      return new byte[0];
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.NormsgSourceImpl", "get brief security info error: %s", new Object[] { localException.toString() });
      AppMethodBeat.o(148959);
    }
  }
  
  public final byte[] fjo()
  {
    AppMethodBeat.i(148975);
    Object localObject = new ByteArrayOutputStream();
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    com.tencent.d.e.a.e.iob().TV();
    Context localContext = MMApplicationContext.getContext();
    String str = q.dR(true);
    com.tencent.d.a.b local2 = new com.tencent.d.a.b()
    {
      public final boolean q(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        boolean bool = false;
        AppMethodBeat.i(148940);
        if (paramAnonymousInt == 0)
        {
          if ((paramAnonymousArrayOfByte != null) && (paramAnonymousArrayOfByte.length > 0)) {
            this.GxE.write(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
          }
          bool = true;
        }
        localCountDownLatch.countDown();
        AppMethodBeat.o(148940);
        return bool;
      }
    };
    com.tencent.d.b.c localc = new com.tencent.d.b.c(localContext);
    com.tencent.d.e.a.e.iob().a(localContext, str, new d.1(local2, localc));
    try
    {
      localCountDownLatch.await();
      label86:
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      AppMethodBeat.o(148975);
      return localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label86;
    }
  }
  
  public final boolean fjp()
  {
    AppMethodBeat.i(148978);
    boolean bool = c.p.ec();
    AppMethodBeat.o(148978);
    return bool;
  }
  
  public final byte[] fjq()
  {
    AppMethodBeat.i(148979);
    byte[] arrayOfByte = c.p.ee();
    AppMethodBeat.o(148979);
    return arrayOfByte;
  }
  
  public final boolean fjr()
  {
    AppMethodBeat.i(257757);
    boolean bool = c.p.al();
    AppMethodBeat.o(257757);
    return bool;
  }
  
  public final String fjs()
  {
    AppMethodBeat.i(257759);
    String str = c.p.ef();
    AppMethodBeat.o(257759);
    return str;
  }
  
  public final String fjt()
  {
    AppMethodBeat.i(257762);
    String str = c.p.eg();
    AppMethodBeat.o(257762);
    return str;
  }
  
  public final String fju()
  {
    AppMethodBeat.i(257765);
    String str = c.p.eh();
    AppMethodBeat.o(257765);
    return str;
  }
  
  public final com.tencent.mm.normsg.a fjv()
  {
    return this;
  }
  
  public final com.tencent.mm.normsgext.a fjw()
  {
    return this;
  }
  
  public final void fjx()
  {
    AppMethodBeat.i(257769);
    Log.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src i1.");
    Object localObject = MMApplicationContext.getContext();
    if (localObject == null)
    {
      if ((BuildInfo.DEBUG) || (CrashReportFactory.hasDebuger()))
      {
        localObject = new IllegalStateException("MMApplicationContext has not been initialized.");
        AppMethodBeat.o(257769);
        throw ((Throwable)localObject);
      }
      Log.e("MicroMsg.NormsgSourceImpl", "[-] MMApplicationContext has not been initialized.");
      AppMethodBeat.o(257769);
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addDataScheme("package");
    ((Context)localObject).registerReceiver(new BroadcastReceiver()
    {
      public final void onReceive(Context arg1, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(257608);
        if (paramAnonymousIntent == null)
        {
          Log.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src, g1.");
          AppMethodBeat.o(257608);
          return;
        }
        if (("android.intent.action.PACKAGE_REMOVED".equals(paramAnonymousIntent.getAction())) && (paramAnonymousIntent.getBooleanExtra("android.intent.extra.REPLACING", false)))
        {
          Log.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src, g2.");
          AppMethodBeat.o(257608);
          return;
        }
        synchronized (b.a(b.this))
        {
          Log.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src, invalidating sth.");
          b.a(b.this)[0] = null;
          b.b(b.this).clear();
          if (("android.intent.action.PACKAGE_ADDED".equals(paramAnonymousIntent.getAction())) && (!paramAnonymousIntent.getBooleanExtra("android.intent.extra.REPLACING", false)) && (MMApplicationContext.isMainProcess())) {
            com.tencent.mm.plugin.secinforeport.a.d.Jcm.asyncReportNewInstallAppThroughCgi(paramAnonymousIntent);
          }
          AppMethodBeat.o(257608);
          return;
        }
      }
    }, localIntentFilter);
    AppMethodBeat.o(257769);
  }
  
  public final void fx(String paramString, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(257771);
    int k = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vZK, 200);
    int i = k;
    if (k <= 0) {
      i = 0;
    }
    paramString = new com.tencent.mm.plugin.normsg.c.a.a.b(paramString, i);
    i = j;
    if (paramString.Gyh > 0) {
      i = 1;
    }
    if (i != 0)
    {
      com.tencent.mm.plugin.normsg.c.a.a locala = com.tencent.mm.plugin.normsg.c.a.a.fjy();
      locala.h(1, paramInt, paramString);
      locala.a(3, paramString.Gyj, paramString.Gyi);
    }
    AppMethodBeat.o(257771);
  }
  
  public final String getDeviceId()
  {
    AppMethodBeat.i(257791);
    String str = q.auM();
    AppMethodBeat.o(257791);
    return str;
  }
  
  public final String getWiFiBssid()
  {
    AppMethodBeat.i(257813);
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      String str = ConnectivityCompat.Companion.getWiFiBssid();
      AppMethodBeat.o(257813);
      return str;
    }
    AppMethodBeat.o(257813);
    return "";
  }
  
  public final String getWiFiSsid()
  {
    AppMethodBeat.i(257810);
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      String str = ConnectivityCompat.Companion.getWiFiSsid();
      AppMethodBeat.o(257810);
      return str;
    }
    AppMethodBeat.o(257810);
    return "";
  }
  
  public final void jr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148970);
    c.p.df(paramString1, paramString2, "");
    AppMethodBeat.o(148970);
  }
  
  public final boolean k(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(257794);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(new StringBuilder("atadtsurt_").reverse().toString());
    if (!localMultiProcessMMKV.encode(paramString, paramArrayOfByte))
    {
      AppMethodBeat.o(257794);
      return false;
    }
    boolean bool = localMultiProcessMMKV.commit();
    AppMethodBeat.o(257794);
    return bool;
  }
  
  public final String vJ(boolean paramBoolean)
  {
    AppMethodBeat.i(148951);
    String str = c.p.ac(",", paramBoolean);
    AppMethodBeat.o(148951);
    return str;
  }
  
  public final void vK(boolean paramBoolean)
  {
    AppMethodBeat.i(257777);
    try
    {
      i.a locala = i.itE();
      locala.ZSa = paramBoolean;
      n.a(locala);
      AppMethodBeat.o(257777);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.i("MicroMsg.NormsgSourceImpl", "stop turing owner failed");
      AppMethodBeat.o(257777);
    }
  }
  
  public final void y(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(257785);
    com.tencent.mm.plugin.report.service.h.IzE.c(paramInt1, paramInt2, paramInt3, paramInt4, true);
    AppMethodBeat.o(257785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b
 * JD-Core Version:    0.7.0.1
 */
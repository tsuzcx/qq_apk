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
import com.tencent.e.a.d.1;
import com.tencent.e.e.a.d.a;
import com.tencent.i.a.h.a;
import com.tencent.i.a.i;
import com.tencent.i.a.i.a;
import com.tencent.i.a.j;
import com.tencent.i.a.m.a;
import com.tencent.i.a.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.normsg.c.p;
import com.tencent.mm.normsgext.QValue;
import com.tencent.mm.plugin.normsg.d.k;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.dtd;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BuildInfo;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

 enum b
  implements com.tencent.mm.normsg.a, com.tencent.mm.normsgext.a, com.tencent.mm.plugin.normsg.a.a
{
  private static final MMHandler AEv;
  private final String[] AEw;
  private final Map<String, String> AEx;
  
  static
  {
    AppMethodBeat.i(148981);
    AEu = new b("INSTANCE");
    AEy = new b[] { AEu };
    AEv = new MMHandler("NormsgWorker");
    AppMethodBeat.o(148981);
  }
  
  private b()
  {
    AppMethodBeat.i(187555);
    this.AEw = new String[] { null };
    this.AEx = new ConcurrentHashMap();
    AppMethodBeat.o(187555);
  }
  
  private static String aIK(String paramString)
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
  
  private static String ait()
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
  
  private static String hz(int paramInt1, int paramInt2)
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
        localObject2 = com.tencent.mm.d.c.B(new File((String)localObject1));
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2))
        {
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(322L, 13L, 1L, true);
          com.tencent.mm.plugin.report.e.Cxv.a(11098, new Object[] { Integer.valueOf(4013), String.format("%s|%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }) });
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
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(322L, 12L, 1L, true);
          com.tencent.mm.plugin.report.e.Cxv.a(11098, new Object[] { Integer.valueOf(4012), String.format("%s|%s|%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localException.getMessage() }) });
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
  
  public final String G(Context paramContext, String paramString)
  {
    AppMethodBeat.i(187578);
    String str = (String)this.AEx.get(paramString);
    Object localObject = str;
    if (str == null)
    {
      paramContext = NormsgDataProvider.G(paramContext, paramString);
      localObject = paramContext;
      if (!TextUtils.isEmpty(paramContext))
      {
        this.AEx.put(paramString, paramContext);
        localObject = paramContext;
      }
    }
    paramContext = Util.nullAsNil((String)localObject);
    AppMethodBeat.o(187578);
    return paramContext;
  }
  
  public final boolean K(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148977);
    boolean bool = c.p.eb(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(148977);
    return bool;
  }
  
  public final void O(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(187569);
    com.tencent.mm.plugin.report.service.h.CyF.n(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(187569);
  }
  
  public final void R(int paramInt, String paramString)
  {
    AppMethodBeat.i(187568);
    com.tencent.mm.plugin.report.service.h.CyF.kvStat(paramInt, paramString);
    AppMethodBeat.o(187568);
  }
  
  public final byte[] RW(String paramString)
  {
    AppMethodBeat.i(187576);
    paramString = MultiProcessMMKV.getMMKV(new StringBuilder("atadtsurt_").reverse().toString()).decodeBytes(paramString);
    AppMethodBeat.o(187576);
    return paramString;
  }
  
  public final void RX(String paramString)
  {
    AppMethodBeat.i(187577);
    MultiProcessMMKV.getMMKV(new StringBuilder("atadtsurt_").reverse().toString()).remove(paramString).commit();
    AppMethodBeat.o(187577);
  }
  
  public final byte[] TJ(int paramInt)
  {
    AppMethodBeat.i(148943);
    byte[] arrayOfByte = c.p.aa(paramInt, 0);
    AppMethodBeat.o(148943);
    return arrayOfByte;
  }
  
  public final String TK(int paramInt)
  {
    AppMethodBeat.i(148946);
    Object localObject3 = "";
    if (com.tencent.mm.kernel.g.aAc()) {
      localObject3 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(79, "");
    }
    com.tencent.mm.kernel.g.aAk().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(148938);
        if (!com.tencent.mm.kernel.g.aAc())
        {
          AppMethodBeat.o(148938);
          return;
        }
        try
        {
          long l1 = System.currentTimeMillis();
          Object localObject = MMApplicationContext.getContext().getApplicationInfo().sourceDir;
          com.tencent.mm.kernel.g.aAf();
          localObject = c.p.ae(com.tencent.mm.kernel.a.getUin());
          com.tencent.mm.kernel.g.aAf();
          byte[] arrayOfByte = c.p.af(com.tencent.mm.kernel.a.getUin());
          long l2 = System.currentTimeMillis();
          String str = String.format("<k25>%s</k25>", new Object[] { com.tencent.mm.plugin.normsg.d.d.L((byte[])localObject, 0, localObject.length) });
          localObject = str;
          if (arrayOfByte != null)
          {
            if (arrayOfByte.length != 8) {
              break label339;
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
          for (localObject = str + String.format("<k28>%s</k28><k29>%s</k29>", new Object[] { com.tencent.mm.plugin.normsg.d.d.L(arrayOfByte, 0, 4), com.tencent.mm.plugin.normsg.d.d.L(arrayOfByte, 4, 8) });; localObject = str + String.format("<k27>%s</k27>", new Object[] { com.tencent.mm.plugin.normsg.d.d.L(arrayOfByte, 0, arrayOfByte.length) }))
          {
            try
            {
              str = Inet4Address.getByName(WeChatHosts.domainString(2131761726)).getHostAddress();
              str = (String)localObject + String.format("<k32>%s</k32>", new Object[] { Util.nullAsNil(str) });
              localObject = str;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                label339:
                Log.e("MicroMsg.NormsgSourceImpl", "exception:%s", new Object[] { Util.stackTraceToString(localException2) });
              }
            }
            Log.i("MicroMsg.NormsgSourceImpl", "checkSoftType2 [time: " + (l2 - l1) + ", value: " + (String)localObject + "]");
            com.tencent.mm.kernel.g.aAh().azQ().set(79, localObject);
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
    label122:
    int i;
    label124:
    int j;
    label130:
    label138:
    int k;
    label147:
    int m;
    label168:
    int n;
    label177:
    int i1;
    label186:
    label207:
    int i2;
    String str2;
    label237:
    StringBuilder localStringBuilder1;
    Object localObject4;
    if (com.tencent.mm.kernel.g.aAc())
    {
      if (com.tencent.mm.kernel.g.aAh().hqK.OtB.OsT) {
        str1 = "1";
      }
    }
    else
    {
      Context localContext = MMApplicationContext.getContext().getApplicationContext();
      String str3 = NetStatusUtil.getConnectedWifiSsid(localContext);
      String str4 = NetStatusUtil.getConnectedWifiBssid(localContext);
      localObject1 = MMApplicationContext.getContext();
      if (localObject1 != null) {
        break label1258;
      }
      Log.w("MicroMsg.NormsgSourceImpl", "Failed checking mock location: application context not initialized.");
      i = 0;
      if (i == 0) {
        break label1278;
      }
      i = 1;
      if (!c.p.ab()) {
        break label1283;
      }
      j = 1;
      if (!Debug.isDebuggerConnected()) {
        break label1288;
      }
      k = 1;
      if ((!com.tencent.mm.plugin.normsg.d.g.AGn) && (!com.tencent.mm.plugin.normsg.d.g.AGo) && (!com.tencent.mm.plugin.normsg.d.g.AGp)) {
        break label1294;
      }
      m = 1;
      if (!com.tencent.mm.plugin.normsg.d.f.AGj) {
        break label1300;
      }
      n = 1;
      if (!com.tencent.mm.plugin.normsg.d.h.AGq) {
        break label1306;
      }
      i1 = 1;
      localObject1 = c.p.ad();
      if (localObject1 == null) {
        break label1312;
      }
      localObject2 = com.tencent.mm.plugin.normsg.d.d.L((byte[])localObject1, 0, localObject1.length);
      i2 = getVersionCode();
      str2 = hz(i2, paramInt);
      Map localMap = q.aoO();
      if (!com.tencent.mm.kernel.g.aAc()) {
        break label1319;
      }
      localObject1 = q.dr(true);
      localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = localStringBuilder1.append("<softtype><lctmoc>").append(i).append("</lctmoc><level>").append(j).append("</level>").append((String)localObject3).append("<k1>");
      localObject4 = (String)localMap.get("model name");
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = q.aoN()[0];
      }
      localStringBuilder2 = localStringBuilder2.append(aIK((String)localObject3)).append("</k1><k2>").append(aIK(q.aoM())).append("</k2><k3>").append(aIK(Build.VERSION.RELEASE)).append("</k3><k4>").append(aIK((String)localObject1)).append("</k4><k5>").append(aIK(q.aoA())).append("</k5><k6>").append(aIK(q.aoC())).append("</k6><k7>").append(aIK(q.getAndroidId())).append("</k7><k8>").append(aIK(q.aoB())).append("</k8><k9>").append(aIK(Build.MODEL)).append("</k9><k10>").append(q.aoP()).append("</k10><k11>").append(Util.nullAsNil(aIK((String)localMap.get("hardware")))).append("</k11><k12>").append(Util.nullAsNil(aIK((String)localMap.get("revision")))).append("</k12><k13>").append(Util.nullAsNil(aIK((String)localMap.get("serial")))).append("</k13><k14>").append(aIK(q.aoD())).append("</k14><k15>").append(aIK(q.aoE())).append("</k15><k16>");
      localObject4 = (String)localMap.get("features");
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = (String)localMap.get("flags");
      }
      localObject3 = localStringBuilder2.append(Util.nullAsNil(aIK((String)localObject3))).append("</k16><k18>").append((String)localObject2).append("</k18><k21>").append(Util.nullAsNil(aIK(str3))).append("</k21><k22>").append(Util.nullAsNil(aIK(q.ct(localContext)))).append("</k22><k24>").append(Util.nullAsNil(aIK(str4))).append("</k24><k26>").append(k).append("</k26><k30>");
      localObject2 = ((ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localObject2 == null) {
        break label1334;
      }
    }
    label1283:
    label1288:
    label1294:
    label1300:
    label1306:
    label1312:
    label1319:
    label1334:
    for (Object localObject2 = ((NetworkInfo)localObject2).getExtraInfo();; localObject2 = null)
    {
      localObject4 = ((StringBuilder)localObject3).append(Util.nullAsNil(aIK((String)localObject2))).append("</k30><k33>").append(aIK(MMApplicationContext.getPackageName())).append("</k33><k34>").append(Util.nullAsNil(aIK(af.get("ro.build.fingerprint")))).append("</k34><k35>").append(Util.nullAsNil(aIK(Build.BOARD))).append("</k35><k36>").append(Util.nullAsNil(aIK(Build.BOOTLOADER))).append("</k36><k37>").append(Util.nullAsNil(aIK(Build.BRAND))).append("</k37><k38>").append(Util.nullAsNil(aIK(Build.DEVICE))).append("</k38><k39>").append(Util.nullAsNil(aIK(Build.HARDWARE))).append("</k39><k40>").append(Util.nullAsNil(aIK(Build.PRODUCT))).append("</k40><k41>").append(m).append("</k41><k42>").append(Util.nullAsNil(aIK(af.get("ro.product.manufacturer")))).append("</k42><k43>").append(Settings.System.getString(MMApplicationContext.getContext().getContentResolver(), "89884a87498ef44f")).append("</k43><k44>0</k44><k45>");
      Log.d("MicroMsg.NormsgSourceImpl", "READ_PHONE_STATE.getLine1Number %s", new Object[] { Util.getStack() });
      localObject3 = Util.nullAsNil(Util.getLine1Number(MMApplicationContext.getContext()));
      localObject2 = localObject3;
      if (((String)localObject3).length() > 0) {
        localObject2 = com.tencent.mm.b.g.getMessageDigest(((String)localObject3).getBytes());
      }
      localObject1 = ((StringBuilder)localObject4).append((String)localObject2).append("</k45><k46>").append(str1).append("</k46><k47>").append(aIK(ait())).append("</k47><k48>").append((String)localObject1).append("</k48><k49>").append(com.tencent.mm.loader.j.b.aKA()).append("</k49><k52>").append(n).append("</k52><k53>").append(i1).append("</k53><k57>").append(i2).append("</k57><k58>").append(Util.nullAsNil(aIK(str2))).append("</k58><k59>").append(paramInt).append("</k59><k60>").append(aIK(BuildInfo.ext.getString("FEATURE_ID"))).append("</k60><k61>").append(q.aoI()).append("</k61><k62>");
      str1 = com.tencent.mm.plugin.soter.d.d.flM().FhU;
      if (str1 != null) {}
      for (;;)
      {
        ((StringBuilder)localObject1).append(str1).append("</k62><k63>").append(q.aoG()).append("</k63><k64>").append(q.aoJ()).append("</k64><k65>").append(q.aoK()).append("</k65></softtype>");
        str1 = localStringBuilder1.toString();
        AppMethodBeat.o(148946);
        return str1;
        str1 = "0";
        break;
        label1258:
        if (Settings.Secure.getInt(((Context)localObject1).getContentResolver(), "mock_location", 0) == 0) {
          break label122;
        }
        i = 1;
        break label124;
        label1278:
        i = 0;
        break label130;
        j = 0;
        break label138;
        k = 0;
        break label147;
        m = 0;
        break label168;
        n = 0;
        break label177;
        i1 = 0;
        break label186;
        localObject2 = "";
        break label207;
        localObject1 = "1234567890ABCDEF";
        break label237;
        str1 = "";
      }
    }
  }
  
  public final void TL(int paramInt)
  {
    AppMethodBeat.i(148962);
    com.tencent.mm.plugin.normsg.d.a.exW().TL(paramInt);
    AppMethodBeat.o(148962);
  }
  
  public final byte[] TM(int paramInt)
  {
    AppMethodBeat.i(148976);
    if (com.tencent.mm.kernel.g.aAc()) {}
    for (int i = 1;; i = 0)
    {
      byte[] arrayOfByte = c.p.ea(paramInt, i);
      AppMethodBeat.o(148976);
      return arrayOfByte;
    }
  }
  
  public final void a(View paramView, Class<? extends IEvent> paramClass)
  {
    AppMethodBeat.i(148961);
    com.tencent.mm.plugin.normsg.d.c.a(paramView, paramClass);
    AppMethodBeat.o(148961);
  }
  
  public final void a(com.tencent.mm.plugin.normsg.a.b paramb)
  {
    AppMethodBeat.i(187564);
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
      for (boolean bool = true; !bool; bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sol, false))
      {
        AppMethodBeat.o(187564);
        return;
      }
      Object localObject = new m.a();
      ((m.a)localObject).SqJ = new j();
      n.a(MMApplicationContext.getContext(), ((m.a)localObject).hqb());
      localObject = new com.tencent.i.a.e()
      {
        public final boolean bW(byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(187554);
          if ((paramAnonymousArrayOfByte != null) && (paramAnonymousArrayOfByte.length > 0))
          {
            sb localsb = new sb();
            localsb.dYE.buffer = paramAnonymousArrayOfByte;
            EventCenter.instance.publish(localsb);
          }
          AppMethodBeat.o(187554);
          return true;
        }
      };
      h.a locala = new h.a((byte)0);
      locala.zfX = MD5Util.getMD5String(q.getAndroidId());
      locala.Sqp = 4;
      locala.Sqq = com.tencent.i.a.b.Sqk;
      locala.Sqr = com.tencent.i.a.c.Sqm;
      locala.Sqv = paramb;
      n.a(locala, (com.tencent.i.a.e)localObject);
      AppMethodBeat.o(187564);
      return;
    }
    catch (Throwable paramb)
    {
      Log.i("MicroMsg.NormsgSourceImpl", "start turing owner failed");
      AppMethodBeat.o(187564);
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
      paramArrayOfByte = new dtd();
      paramArrayOfByte.MVj = ((Integer)localQValue1.getValue(Integer.valueOf(0))).intValue();
      paramArrayOfByte.MVk = ((Integer)localQValue2.getValue(Integer.valueOf(0))).intValue();
      paramArrayOfByte.LoA = com.tencent.mm.bw.b.cD((byte[])localQValue3.value);
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
  
  public final void aA(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(187556);
    c.p.df(paramString1, paramString2, paramString3);
    AppMethodBeat.o(187556);
  }
  
  public final String aIJ(String paramString)
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
  
  public final void aIL(String paramString)
  {
    AppMethodBeat.i(148965);
    c.p.da(paramString);
    AppMethodBeat.o(148965);
  }
  
  public final void aIM(String paramString)
  {
    AppMethodBeat.i(148966);
    c.p.db(paramString);
    AppMethodBeat.o(148966);
  }
  
  public final void aIN(String paramString)
  {
    AppMethodBeat.i(148967);
    c.p.dc(paramString);
    AppMethodBeat.o(148967);
  }
  
  public final boolean aIO(String paramString)
  {
    AppMethodBeat.i(148968);
    boolean bool = c.p.dd(paramString);
    AppMethodBeat.o(148968);
    return bool;
  }
  
  public final byte[] aIP(String paramString)
  {
    AppMethodBeat.i(148969);
    paramString = c.p.de(paramString);
    AppMethodBeat.o(148969);
    return paramString;
  }
  
  public final void aIQ(String paramString)
  {
    AppMethodBeat.i(148972);
    c.p.dh(paramString);
    AppMethodBeat.o(148972);
  }
  
  public final boolean aIR(String paramString)
  {
    AppMethodBeat.i(148973);
    boolean bool = c.p.di(paramString);
    AppMethodBeat.o(148973);
    return bool;
  }
  
  public final byte[] aIS(String paramString)
  {
    AppMethodBeat.i(148974);
    paramString = c.p.dj(paramString);
    AppMethodBeat.o(148974);
    return paramString;
  }
  
  public final String aIT(String paramString)
  {
    AppMethodBeat.i(187557);
    paramString = c.p.dk(paramString);
    AppMethodBeat.o(187557);
    return paramString;
  }
  
  public final String[] aIU(String paramString)
  {
    AppMethodBeat.i(187580);
    cs localcs = new cs();
    localcs.dFQ.path = paramString;
    EventCenter.instance.publish(localcs);
    if (localcs.dFR.dFS != null)
    {
      paramString = localcs.dFR.dFS;
      AppMethodBeat.o(187580);
      return paramString;
    }
    if (localcs.dFR.isTimeout)
    {
      AppMethodBeat.o(187580);
      return new String[] { "<timeout>" };
    }
    AppMethodBeat.o(187580);
    return null;
  }
  
  public final String aoK()
  {
    AppMethodBeat.i(148980);
    try
    {
      Object localObject = com.tencent.e.e.b.a.a.b.kV(MMApplicationContext.getContext());
      if (((com.tencent.e.e.b.a.a.c)localObject).errorCode == 0)
      {
        localObject = Util.nullAsNil(((com.tencent.e.e.b.a.a.c)localObject).Dsg);
        AppMethodBeat.o(148980);
        return localObject;
      }
      Log.e("MicroMsg.NormsgSourceImpl", "[-] Fail to get OAID, errorcode: %s", new Object[] { Integer.valueOf(((com.tencent.e.e.b.a.a.c)localObject).errorCode) });
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
  
  public final void au(int paramInt1, int paramInt2, int paramInt3)
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
    if (l < com.tencent.e.e.a.a.f.RMU) {
      ((d.a)localObject).Gfd = com.tencent.e.e.a.a.f.RMU;
    }
    for (;;)
    {
      ((d.a)localObject).Gfd = l;
      localObject = new com.tencent.e.e.a.d((d.a)localObject, (byte)0);
      com.tencent.e.e.a.e.hkD().a((com.tencent.e.e.a.d)localObject);
      AppMethodBeat.o(148944);
      return;
      if (l > com.tencent.e.e.a.a.f.RMR * 12L) {
        ((d.a)localObject).Gfd = (com.tencent.e.e.a.a.f.RMR * 12L);
      }
    }
  }
  
  public final boolean bkA()
  {
    AppMethodBeat.i(187581);
    try
    {
      String str1 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(274436, null);
      if (!TextUtils.isEmpty(str1)) {
        if (com.tencent.mm.plugin.normsg.d.e.aIX(str1))
        {
          AppMethodBeat.o(187581);
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
      AppMethodBeat.o(187581);
      return false;
    }
    AppMethodBeat.o(187581);
    return false;
  }
  
  public final String bkv()
  {
    AppMethodBeat.i(187566);
    synchronized (this.AEw)
    {
      if (this.AEw[0] == null)
      {
        Log.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src rf.");
        localObject1 = com.tencent.mm.lib.riskscanner.a.a.cM(MMApplicationContext.getContext());
        if ((localObject1 != null) && (((Bundle)localObject1).getInt("errCode", -100) == 0))
        {
          localObject1 = ((Bundle)localObject1).getByteArray("reqBufferBase64");
          if (localObject1 != null) {
            this.AEw[0] = Base64.encodeToString((byte[])localObject1, 2);
          }
        }
      }
      if (this.AEw[0] != null)
      {
        localObject1 = this.AEw[0];
        AppMethodBeat.o(187566);
        return localObject1;
      }
      Object localObject1 = "";
    }
  }
  
  public final long bkw()
  {
    AppMethodBeat.i(187567);
    long l = com.tencent.mm.plugin.normsg.d.a.exW().exX();
    AppMethodBeat.o(187567);
    return l;
  }
  
  public final String bkx()
  {
    AppMethodBeat.i(187571);
    String str = com.tencent.mm.plugin.soter.d.d.flM().FhU;
    if (str != null)
    {
      AppMethodBeat.o(187571);
      return str;
    }
    AppMethodBeat.o(187571);
    return "";
  }
  
  public final boolean bky()
  {
    AppMethodBeat.i(187572);
    boolean bool = k.isConnected();
    AppMethodBeat.o(187572);
    return bool;
  }
  
  public final String bkz()
  {
    AppMethodBeat.i(187573);
    String str = com.tencent.mm.plugin.soter.d.d.flM().hFF;
    if (str != null)
    {
      AppMethodBeat.o(187573);
      return str;
    }
    AppMethodBeat.o(187573);
    return "";
  }
  
  public final boolean c(Object paramObject, Class paramClass)
  {
    AppMethodBeat.i(148958);
    boolean bool = c.p.ca(paramObject, paramClass);
    AppMethodBeat.o(148958);
    return bool;
  }
  
  public final boolean dH(Object paramObject)
  {
    AppMethodBeat.i(148960);
    boolean bool = c.p.cb(paramObject);
    AppMethodBeat.o(148960);
    return bool;
  }
  
  public final boolean dn(Context paramContext)
  {
    AppMethodBeat.i(187579);
    boolean bool = NormsgDataProvider.dn(paramContext);
    AppMethodBeat.o(187579);
    return bool;
  }
  
  public final void eW(String paramString, int paramInt)
  {
    AppMethodBeat.i(187563);
    com.tencent.mm.plugin.normsg.c.a.a locala = com.tencent.mm.plugin.normsg.c.a.a.exU();
    locala.g(1, paramInt, paramString);
    locala.a(3, paramString, 4000L);
    AppMethodBeat.o(187563);
  }
  
  public final String exG()
  {
    AppMethodBeat.i(148952);
    if (WeChatSomeFeatureSwitch.onlyUSMobile())
    {
      AppMethodBeat.o(148952);
      return "";
    }
    if (com.tencent.mm.plugin.normsg.d.e.aIX((String)com.tencent.mm.kernel.g.aAh().azQ().get(274436, null)))
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
  
  public final boolean exH()
  {
    AppMethodBeat.i(148953);
    boolean bool = c.p.ab();
    AppMethodBeat.o(148953);
    return bool;
  }
  
  public final boolean exI()
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
  
  public final byte[] exJ()
  {
    AppMethodBeat.i(148959);
    if (com.tencent.mm.kernel.g.aAc()) {}
    for (int i = 0;; i = 1)
    {
      byte[] arrayOfByte = c.p.aa(0, i);
      AppMethodBeat.o(148959);
      return arrayOfByte;
    }
  }
  
  public final byte[] exK()
  {
    AppMethodBeat.i(148975);
    Object localObject = new ByteArrayOutputStream();
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    com.tencent.e.e.a.e.hkD().Qt();
    Context localContext = MMApplicationContext.getContext();
    String str = q.dr(true);
    com.tencent.e.a.b local2 = new com.tencent.e.a.b()
    {
      public final boolean p(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        boolean bool = false;
        AppMethodBeat.i(148940);
        if (paramAnonymousInt == 0)
        {
          if ((paramAnonymousArrayOfByte != null) && (paramAnonymousArrayOfByte.length > 0)) {
            this.AEA.write(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
          }
          bool = true;
        }
        localCountDownLatch.countDown();
        AppMethodBeat.o(148940);
        return bool;
      }
    };
    com.tencent.e.b.c localc = new com.tencent.e.b.c(localContext);
    com.tencent.e.e.a.e.hkD().a(localContext, str, new d.1(local2, localc));
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
  
  public final boolean exL()
  {
    AppMethodBeat.i(148978);
    boolean bool = c.p.ec();
    AppMethodBeat.o(148978);
    return bool;
  }
  
  public final byte[] exM()
  {
    AppMethodBeat.i(148979);
    byte[] arrayOfByte = c.p.ee();
    AppMethodBeat.o(148979);
    return arrayOfByte;
  }
  
  public final boolean exN()
  {
    AppMethodBeat.i(187558);
    boolean bool = c.p.al();
    AppMethodBeat.o(187558);
    return bool;
  }
  
  public final String exO()
  {
    AppMethodBeat.i(187559);
    String str = c.p.ef();
    AppMethodBeat.o(187559);
    return str;
  }
  
  public final String exP()
  {
    AppMethodBeat.i(187560);
    String str = c.p.eg();
    AppMethodBeat.o(187560);
    return str;
  }
  
  public final String exQ()
  {
    AppMethodBeat.i(187561);
    String str = c.p.eh();
    AppMethodBeat.o(187561);
    return str;
  }
  
  public final com.tencent.mm.normsg.a exR()
  {
    return this;
  }
  
  public final com.tencent.mm.normsgext.a exS()
  {
    return this;
  }
  
  public final void exT()
  {
    AppMethodBeat.i(187562);
    Log.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src i1.");
    Object localObject = MMApplicationContext.getContext();
    if (localObject == null)
    {
      if ((BuildInfo.DEBUG) || (CrashReportFactory.hasDebuger()))
      {
        localObject = new IllegalStateException("MMApplicationContext has not been initialized.");
        AppMethodBeat.o(187562);
        throw ((Throwable)localObject);
      }
      Log.e("MicroMsg.NormsgSourceImpl", "[-] MMApplicationContext has not been initialized.");
      AppMethodBeat.o(187562);
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
        AppMethodBeat.i(187553);
        if (paramAnonymousIntent == null)
        {
          Log.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src, g1.");
          AppMethodBeat.o(187553);
          return;
        }
        if (("android.intent.action.PACKAGE_REMOVED".equals(paramAnonymousIntent.getAction())) && (paramAnonymousIntent.getBooleanExtra("android.intent.extra.REPLACING", false)))
        {
          Log.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src, g2.");
          AppMethodBeat.o(187553);
          return;
        }
        synchronized (b.a(b.this))
        {
          Log.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src, invalidating sth.");
          b.a(b.this)[0] = null;
          b.b(b.this).clear();
          AppMethodBeat.o(187553);
          return;
        }
      }
    }, localIntentFilter);
    AppMethodBeat.o(187562);
  }
  
  public final String getDeviceId()
  {
    AppMethodBeat.i(187574);
    String str = q.aoG();
    AppMethodBeat.o(187574);
    return str;
  }
  
  public final void jf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148970);
    c.p.df(paramString1, paramString2, "");
    AppMethodBeat.o(148970);
  }
  
  public final boolean k(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(187575);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(new StringBuilder("atadtsurt_").reverse().toString());
    if (!localMultiProcessMMKV.encode(paramString, paramArrayOfByte))
    {
      AppMethodBeat.o(187575);
      return false;
    }
    boolean bool = localMultiProcessMMKV.commit();
    AppMethodBeat.o(187575);
    return bool;
  }
  
  public final String sv(boolean paramBoolean)
  {
    AppMethodBeat.i(148951);
    String str = c.p.ac(",", paramBoolean);
    AppMethodBeat.o(148951);
    return str;
  }
  
  public final void sw(boolean paramBoolean)
  {
    AppMethodBeat.i(187565);
    try
    {
      i.a locala = i.hpZ();
      locala.Sqx = paramBoolean;
      n.a(locala);
      AppMethodBeat.o(187565);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.i("MicroMsg.NormsgSourceImpl", "stop turing owner failed");
      AppMethodBeat.o(187565);
    }
  }
  
  public final void w(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(187570);
    com.tencent.mm.plugin.report.service.h.CyF.b(paramInt1, paramInt2, paramInt3, paramInt4, true);
    AppMethodBeat.o(187570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b
 * JD-Core Version:    0.7.0.1
 */
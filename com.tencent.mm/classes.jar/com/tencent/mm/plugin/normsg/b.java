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
import com.tencent.h.a.h.a;
import com.tencent.h.a.i;
import com.tencent.h.a.i.a;
import com.tencent.h.a.j;
import com.tencent.h.a.m.a;
import com.tencent.h.a.n;
import com.tencent.mars.comm.NetworkSignalUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dg;
import com.tencent.mm.autogen.a.dg.b;
import com.tencent.mm.compatible.deviceinfo.ag;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.normsg.c.p;
import com.tencent.mm.normsgext.QValue;
import com.tencent.mm.normsgext.b.a;
import com.tencent.mm.plugin.normsg.d.k;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.ewq;
import com.tencent.mm.sdk.crash.CrashReportFactory;
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
import com.tencent.mm.storage.aq;
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
  private static final MMHandler MtF;
  private final String[] MtG;
  private final Map<String, String> MtH;
  
  static
  {
    AppMethodBeat.i(148981);
    MtE = new b("INSTANCE");
    MtI = new b[] { MtE };
    MtF = new MMHandler("NormsgWorker");
    AppMethodBeat.o(148981);
  }
  
  private b()
  {
    AppMethodBeat.i(261914);
    this.MtG = new String[] { null };
    this.MtH = new ConcurrentHashMap();
    AppMethodBeat.o(261914);
  }
  
  private static String aQg(String paramString)
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
  
  private static String gtA()
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
  
  private static String kk(int paramInt1, int paramInt2)
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
        localObject2 = com.tencent.mm.d.c.z(new File((String)localObject1));
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2))
        {
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(322L, 13L, 1L, true);
          com.tencent.mm.plugin.report.f.Ozc.b(11098, new Object[] { Integer.valueOf(4013), String.format("%s|%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }) });
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
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(322L, 12L, 1L, true);
          com.tencent.mm.plugin.report.f.Ozc.b(11098, new Object[] { Integer.valueOf(4012), String.format("%s|%s|%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localException.getMessage() }) });
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
  
  public final String Af(boolean paramBoolean)
  {
    AppMethodBeat.i(148951);
    String str = c.p.ac(",", paramBoolean);
    AppMethodBeat.o(148951);
    return str;
  }
  
  public final void Ag(boolean paramBoolean)
  {
    AppMethodBeat.i(262040);
    try
    {
      i.a locala = i.kcZ();
      locala.ahWx = paramBoolean;
      n.a(locala);
      AppMethodBeat.o(262040);
      return;
    }
    finally
    {
      Log.i("MicroMsg.NormsgSourceImpl", "stop turing owner failed");
      AppMethodBeat.o(262040);
    }
  }
  
  public final void E(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(262058);
    com.tencent.mm.plugin.report.service.h.OAn.c(paramInt1, paramInt2, paramInt3, paramInt4, true);
    AppMethodBeat.o(262058);
  }
  
  public final boolean K(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148977);
    boolean bool = c.p.eb(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(148977);
    return bool;
  }
  
  public final String M(Context paramContext, String paramString)
  {
    AppMethodBeat.i(262067);
    String str = (String)this.MtH.get(paramString);
    Object localObject = str;
    if (str == null)
    {
      paramContext = NormsgDataService.M(paramContext, paramString);
      localObject = paramContext;
      if (!TextUtils.isEmpty(paramContext))
      {
        this.MtH.put(paramString, paramContext);
        localObject = paramContext;
      }
    }
    paramContext = Util.nullAsNil((String)localObject);
    AppMethodBeat.o(262067);
    return paramContext;
  }
  
  public final byte[] RA(String paramString)
  {
    AppMethodBeat.i(262065);
    paramString = MultiProcessMMKV.getMMKV(new StringBuilder("atadtsurt_").reverse().toString()).decodeBytes(paramString);
    AppMethodBeat.o(262065);
    return paramString;
  }
  
  public final void RB(String paramString)
  {
    AppMethodBeat.i(262066);
    MultiProcessMMKV.getMMKV(new StringBuilder("atadtsurt_").reverse().toString()).remove(paramString).commit();
    AppMethodBeat.o(262066);
  }
  
  public final void W(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(262057);
    com.tencent.mm.plugin.report.service.h.OAn.p(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(262057);
  }
  
  public final void Y(int paramInt, String paramString)
  {
    AppMethodBeat.i(262055);
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(paramInt, paramString);
    AppMethodBeat.o(262055);
  }
  
  public final void a(View paramView, Class<? extends IEvent> paramClass)
  {
    AppMethodBeat.i(148961);
    com.tencent.mm.plugin.normsg.d.c.a(paramView, paramClass);
    AppMethodBeat.o(148961);
  }
  
  public final void a(com.tencent.mm.plugin.normsg.a.b paramb)
  {
    AppMethodBeat.i(262037);
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
      for (boolean bool = true; !bool; bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ztj, false))
      {
        AppMethodBeat.o(262037);
        return;
      }
      Object localObject = new m.a();
      ((m.a)localObject).ahWJ = new j();
      n.a(MMApplicationContext.getContext(), ((m.a)localObject).kdb());
      localObject = new com.tencent.h.a.e()
      {
        public final boolean cn(byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(261890);
          com.tencent.mm.plugin.secinforeport.a.d.Pmb.asyncReportTuringOwnerThroughCgi(paramAnonymousArrayOfByte);
          AppMethodBeat.o(261890);
          return true;
        }
      };
      h.a locala = new h.a((byte)0);
      locala.KFd = MD5Util.getMD5String(q.getAndroidId());
      locala.ahWp = 4;
      locala.ahWq = com.tencent.h.a.b.ahWk;
      locala.ahWr = com.tencent.h.a.c.ahWm;
      locala.ahWv = paramb;
      n.a(locala, (com.tencent.h.a.e)localObject);
      AppMethodBeat.o(262037);
      return;
    }
    finally
    {
      Log.i("MicroMsg.NormsgSourceImpl", "start turing owner failed");
      AppMethodBeat.o(262037);
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
    boolean bool = b.a.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, localQValue1, localQValue2, localQValue3);
    if (bool)
    {
      paramArrayOfByte = new ewq();
      paramArrayOfByte.abyR = ((Integer)localQValue1.getValue(Integer.valueOf(0))).intValue();
      paramArrayOfByte.abyS = ((Integer)localQValue2.getValue(Integer.valueOf(0))).intValue();
      paramArrayOfByte.ZoS = com.tencent.mm.bx.b.cX((byte[])localQValue3.value);
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
    boolean bool = b.a.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, localQValue1, localQValue2, localQValue3);
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
  
  public final void aJ(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(261988);
    c.p.df(paramString1, paramString2, paramString3);
    AppMethodBeat.o(261988);
  }
  
  public final String aPk()
  {
    AppMethodBeat.i(148980);
    try
    {
      Object localObject = com.tencent.e.e.b.a.a.b.nY(MMApplicationContext.getContext());
      if (((com.tencent.e.e.b.a.a.c)localObject).errorCode == 0)
      {
        localObject = Util.nullAsNil(((com.tencent.e.e.b.a.a.c)localObject).PNk);
        AppMethodBeat.o(148980);
        return localObject;
      }
      Log.e("MicroMsg.NormsgSourceImpl", "[-] Fail to get OAID, errorcode: %s", new Object[] { Integer.valueOf(((com.tencent.e.e.b.a.a.c)localObject).errorCode) });
      AppMethodBeat.o(148980);
      return "";
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.NormsgSourceImpl", localThrowable, "Fail to get OAID.", new Object[0]);
      AppMethodBeat.o(148980);
    }
    return "";
  }
  
  public final String aQf(String paramString)
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
  
  public final void aQh(String paramString)
  {
    AppMethodBeat.i(148965);
    c.p.da(paramString);
    AppMethodBeat.o(148965);
  }
  
  public final void aQi(String paramString)
  {
    AppMethodBeat.i(148966);
    c.p.db(paramString);
    AppMethodBeat.o(148966);
  }
  
  public final void aQj(String paramString)
  {
    AppMethodBeat.i(148967);
    c.p.dc(paramString);
    AppMethodBeat.o(148967);
  }
  
  public final boolean aQk(String paramString)
  {
    AppMethodBeat.i(148968);
    boolean bool = c.p.dd(paramString);
    AppMethodBeat.o(148968);
    return bool;
  }
  
  public final byte[] aQl(String paramString)
  {
    AppMethodBeat.i(148969);
    paramString = c.p.de(paramString);
    AppMethodBeat.o(148969);
    return paramString;
  }
  
  public final void aQm(String paramString)
  {
    AppMethodBeat.i(148972);
    c.p.dh(paramString);
    AppMethodBeat.o(148972);
  }
  
  public final boolean aQn(String paramString)
  {
    AppMethodBeat.i(148973);
    boolean bool = c.p.di(paramString);
    AppMethodBeat.o(148973);
    return bool;
  }
  
  public final byte[] aQo(String paramString)
  {
    AppMethodBeat.i(148974);
    paramString = c.p.dj(paramString);
    AppMethodBeat.o(148974);
    return paramString;
  }
  
  public final String aQp(String paramString)
  {
    AppMethodBeat.i(262004);
    paramString = c.p.dk(paramString);
    AppMethodBeat.o(262004);
    return paramString;
  }
  
  public final String[] aQq(String paramString)
  {
    AppMethodBeat.i(262069);
    dg localdg = new dg();
    localdg.hDh.path = paramString;
    localdg.publish();
    if (localdg.hDi.hDj != null)
    {
      paramString = localdg.hDi.hDj;
      AppMethodBeat.o(262069);
      return paramString;
    }
    if (localdg.hDi.isTimeout)
    {
      AppMethodBeat.o(262069);
      return new String[] { "<timeout>" };
    }
    AppMethodBeat.o(262069);
    return null;
  }
  
  public final void aW(int paramInt1, int paramInt2, int paramInt3)
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
    if (l < com.tencent.e.e.a.a.f.ahui) {
      ((d.a)localObject).Tzj = com.tencent.e.e.a.a.f.ahui;
    }
    for (;;)
    {
      ((d.a)localObject).Tzj = l;
      localObject = new com.tencent.e.e.a.d((d.a)localObject, (byte)0);
      com.tencent.e.e.a.e.jXm().a((com.tencent.e.e.a.d)localObject);
      AppMethodBeat.o(148944);
      return;
      if (l > com.tencent.e.e.a.a.f.ahuf * 12L) {
        ((d.a)localObject).Tzj = (com.tencent.e.e.a.a.f.ahuf * 12L);
      }
    }
  }
  
  public final byte[] aeP(int paramInt)
  {
    AppMethodBeat.i(148943);
    byte[] arrayOfByte = c.p.aa(paramInt, 0);
    AppMethodBeat.o(148943);
    return arrayOfByte;
  }
  
  public final String aeQ(int paramInt)
  {
    AppMethodBeat.i(148946);
    Object localObject5 = "";
    if (com.tencent.mm.kernel.h.baz()) {
      localObject5 = (String)com.tencent.mm.kernel.h.baE().ban().d(79, "");
    }
    com.tencent.mm.kernel.h.baH().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(148938);
        if (!com.tencent.mm.kernel.h.baz())
        {
          AppMethodBeat.o(148938);
          return;
        }
        try
        {
          long l1 = System.currentTimeMillis();
          Object localObject = MMApplicationContext.getContext().getApplicationInfo().sourceDir;
          com.tencent.mm.kernel.h.baC();
          localObject = c.p.ae(com.tencent.mm.kernel.b.getUin());
          com.tencent.mm.kernel.h.baC();
          byte[] arrayOfByte = c.p.af(com.tencent.mm.kernel.b.getUin());
          long l2 = System.currentTimeMillis();
          String str = String.format("<k25>%s</k25>", new Object[] { com.tencent.mm.plugin.normsg.d.d.L((byte[])localObject, 0, localObject.length) });
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
          for (localObject = str + String.format("<k28>%s</k28><k29>%s</k29>", new Object[] { com.tencent.mm.plugin.normsg.d.d.L(arrayOfByte, 0, 4), com.tencent.mm.plugin.normsg.d.d.L(arrayOfByte, 4, 8) });; localObject = str + String.format("<k27>%s</k27>", new Object[] { com.tencent.mm.plugin.normsg.d.d.L(arrayOfByte, 0, arrayOfByte.length) }))
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
            com.tencent.mm.kernel.h.baE().ban().B(79, localObject);
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
    Object localObject1 = "";
    Object localObject2;
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
    String str1;
    Object localObject3;
    Object localObject8;
    if (com.tencent.mm.kernel.h.baz())
    {
      if (com.tencent.mm.kernel.h.baE().mCN.adnG.adna) {
        localObject1 = "1";
      }
    }
    else
    {
      Context localContext = MMApplicationContext.getContext().getApplicationContext();
      String str2 = ConnectivityCompat.Companion.getFormattedWiFiSsid();
      String str3 = ConnectivityCompat.Companion.getFormattedWiFiBssid();
      localObject2 = MMApplicationContext.getContext();
      if (localObject2 != null) {
        break label1327;
      }
      Log.w("MicroMsg.NormsgSourceImpl", "Failed checking mock location: application context not initialized.");
      i = 0;
      if (i == 0) {
        break label1347;
      }
      i = 1;
      if (!c.p.ab()) {
        break label1352;
      }
      j = 1;
      if (!Debug.isDebuggerConnected()) {
        break label1357;
      }
      k = 1;
      if ((!com.tencent.mm.plugin.normsg.d.g.MvE) && (!com.tencent.mm.plugin.normsg.d.g.MvF) && (!com.tencent.mm.plugin.normsg.d.g.MvG)) {
        break label1363;
      }
      m = 1;
      if (!com.tencent.mm.plugin.normsg.d.f.MvA) {
        break label1369;
      }
      n = 1;
      if (!com.tencent.mm.plugin.normsg.d.h.MvH) {
        break label1375;
      }
      i1 = 1;
      localObject2 = c.p.ad();
      if (localObject2 == null) {
        break label1381;
      }
      localObject4 = com.tencent.mm.plugin.normsg.d.d.L((byte[])localObject2, 0, localObject2.length);
      i2 = getVersionCode();
      str1 = kk(i2, paramInt);
      Map localMap = q.aPp();
      localObject3 = "1234567890ABCDEF";
      Object localObject6 = "";
      localObject2 = "";
      if (com.tencent.mm.kernel.h.baz())
      {
        localObject7 = q.eD(true);
        localObject8 = q.aOZ();
        Log.d("MicroMsg.NormsgSourceImpl", "READ_PHONE_STATE.getLine1Number %s", new Object[] { Util.getStack() });
        localObject9 = Util.nullAsNil(Util.getLine1Number(MMApplicationContext.getContext()));
        localObject2 = localObject9;
        localObject6 = localObject8;
        localObject3 = localObject7;
        if (((String)localObject9).length() > 0)
        {
          localObject2 = com.tencent.mm.b.g.getMessageDigest(((String)localObject9).getBytes());
          localObject3 = localObject7;
          localObject6 = localObject8;
        }
      }
      localObject8 = new StringBuilder();
      Object localObject9 = ((StringBuilder)localObject8).append("<softtype><lctmoc>").append(i).append("</lctmoc><level>").append(j).append("</level>").append((String)localObject5).append("<k1>");
      Object localObject7 = (String)localMap.get("model name");
      localObject5 = localObject7;
      if (localObject7 == null)
      {
        String[] arrayOfString = q.aPn();
        localObject5 = localObject7;
        if (arrayOfString.length > 1) {
          localObject5 = arrayOfString[0];
        }
      }
      localObject6 = ((StringBuilder)localObject9).append(aQg((String)localObject5)).append("</k1><k2>").append(aQg(q.aPm())).append("</k2><k3>").append(aQg(Build.VERSION.RELEASE)).append("</k3><k4>").append(aQg((String)localObject3)).append("</k4><k5>").append(aQg((String)localObject6)).append("</k5><k6>").append(aQg(q.aPb())).append("</k6><k7>").append(aQg(q.getAndroidId())).append("</k7><k8>").append(aQg(q.aPa())).append("</k8><k9>").append(aQg(q.aPo())).append("</k9><k10>").append(q.aPq()).append("</k10><k11>").append(Util.nullAsNil(aQg((String)localMap.get("hardware")))).append("</k11><k12>").append(Util.nullAsNil(aQg((String)localMap.get("revision")))).append("</k12><k13>").append(Util.nullAsNil(aQg((String)localMap.get("serial")))).append("</k13><k14>").append(aQg(q.aPd())).append("</k14><k15>");
      if (!com.tencent.mm.kernel.h.baz()) {
        break label1388;
      }
      localObject5 = q.aPe();
      label678:
      localObject7 = ((StringBuilder)localObject6).append(aQg((String)localObject5)).append("</k15><k16>");
      localObject6 = (String)localMap.get("features");
      localObject5 = localObject6;
      if (localObject6 == null) {
        localObject5 = (String)localMap.get("flags");
      }
      localObject5 = ((StringBuilder)localObject7).append(Util.nullAsNil(aQg((String)localObject5))).append("</k16><k18>").append((String)localObject4).append("</k18><k21>").append(Util.nullAsNil(aQg(str2))).append("</k21><k22>").append(Util.nullAsNil(aQg(q.dd(localContext)))).append("</k22><k24>").append(Util.nullAsNil(aQg(str3))).append("</k24><k26>").append(k).append("</k26><k30>");
      localObject4 = ((ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localObject4 == null) {
        break label1402;
      }
    }
    label1327:
    label1347:
    label1352:
    label1357:
    label1363:
    label1369:
    label1375:
    label1381:
    label1388:
    label1402:
    for (Object localObject4 = ((NetworkInfo)localObject4).getExtraInfo();; localObject4 = null)
    {
      localObject2 = ((StringBuilder)localObject5).append(Util.nullAsNil(aQg((String)localObject4))).append("</k30><k33>").append(aQg(MMApplicationContext.getPackageName())).append("</k33><k34>").append(Util.nullAsNil(aQg(ag.get("ro.build.fingerprint")))).append("</k34><k35>").append(Util.nullAsNil(aQg(Build.BOARD))).append("</k35><k36>").append(Util.nullAsNil(aQg(Build.BOOTLOADER))).append("</k36><k37>").append(Util.nullAsNil(aQg(Build.BRAND))).append("</k37><k38>").append(Util.nullAsNil(aQg(Build.DEVICE))).append("</k38><k39>").append(Util.nullAsNil(aQg(Build.HARDWARE))).append("</k39><k40>").append(Util.nullAsNil(aQg(Build.PRODUCT))).append("</k40><k41>").append(m).append("</k41><k42>").append(Util.nullAsNil(aQg(ag.get("ro.product.manufacturer")))).append("</k42><k43>").append(Settings.System.getString(MMApplicationContext.getContext().getContentResolver(), "89884a87498ef44f")).append("</k43><k44>0</k44><k45>").append((String)localObject2).append("</k45><k46>").append((String)localObject1).append("</k46><k47>").append(aQg(gtA())).append("</k47><k48>").append((String)localObject3).append("</k48><k49>").append(com.tencent.mm.loader.i.b.bmq()).append("</k49><k52>").append(n).append("</k52><k53>").append(i1).append("</k53><k57>").append(i2).append("</k57><k58>").append(Util.nullAsNil(aQg(str1))).append("</k58><k59>").append(paramInt).append("</k59><k60>").append(aQg(BuildInfo.ext.getString("FEATURE_ID"))).append("</k60><k61>").append(q.aPi()).append("</k61><k62>");
      localObject1 = com.tencent.mm.plugin.soter.model.b.htz();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.soter.model.c)localObject1).RZY;
        if (localObject1 == null) {}
      }
      for (;;)
      {
        ((StringBuilder)localObject2).append((String)localObject1).append("</k62><k63>").append(q.aPg()).append("</k63><k64>").append(q.aPj()).append("</k64><k65>").append(q.aPk()).append("</k65></softtype>");
        localObject1 = ((StringBuilder)localObject8).toString();
        AppMethodBeat.o(148946);
        return localObject1;
        localObject1 = "0";
        break;
        if (Settings.Secure.getInt(((Context)localObject2).getContentResolver(), "mock_location", 0) == 0) {
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
        localObject4 = "";
        break label209;
        localObject5 = "";
        break label678;
        localObject1 = "";
      }
    }
  }
  
  public final void aeR(int paramInt)
  {
    AppMethodBeat.i(148962);
    com.tencent.mm.plugin.normsg.d.a.gtU().aeR(paramInt);
    AppMethodBeat.o(148962);
  }
  
  public final byte[] aeS(int paramInt)
  {
    AppMethodBeat.i(148976);
    if (com.tencent.mm.kernel.h.baz()) {}
    for (int i = 15;; i = 0)
    {
      byte[] arrayOfByte = c.p.ea(paramInt, i);
      AppMethodBeat.o(148976);
      return arrayOfByte;
    }
  }
  
  public final String bRH()
  {
    AppMethodBeat.i(262051);
    synchronized (this.MtG)
    {
      if (this.MtG[0] == null)
      {
        Log.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src rf.");
        localObject1 = com.tencent.mm.lib.riskscanner.a.a.dy(MMApplicationContext.getContext());
        if ((localObject1 != null) && (((Bundle)localObject1).getInt("errCode", -100) == 0))
        {
          localObject1 = ((Bundle)localObject1).getByteArray("reqBufferBase64");
          if (localObject1 != null) {
            this.MtG[0] = Base64.encodeToString((byte[])localObject1, 2);
          }
        }
      }
      if (this.MtG[0] != null)
      {
        localObject1 = this.MtG[0];
        AppMethodBeat.o(262051);
        return localObject1;
      }
      Object localObject1 = "";
    }
  }
  
  public final long bRI()
  {
    AppMethodBeat.i(262053);
    long l = com.tencent.mm.plugin.normsg.d.a.gtU().gtV();
    AppMethodBeat.o(262053);
    return l;
  }
  
  public final String bRJ()
  {
    AppMethodBeat.i(262059);
    Object localObject = com.tencent.mm.plugin.soter.model.b.htz();
    if (localObject == null)
    {
      AppMethodBeat.o(262059);
      return "";
    }
    localObject = ((com.tencent.mm.plugin.soter.model.c)localObject).RZY;
    if (localObject != null)
    {
      AppMethodBeat.o(262059);
      return localObject;
    }
    AppMethodBeat.o(262059);
    return "";
  }
  
  public final boolean bRK()
  {
    AppMethodBeat.i(262060);
    boolean bool = k.isConnected();
    AppMethodBeat.o(262060);
    return bool;
  }
  
  public final String bRL()
  {
    AppMethodBeat.i(262061);
    Object localObject = com.tencent.mm.plugin.soter.model.b.htz();
    if (localObject == null)
    {
      AppMethodBeat.o(262061);
      return "";
    }
    localObject = ((com.tencent.mm.plugin.soter.model.c)localObject).mXG;
    if (localObject != null)
    {
      AppMethodBeat.o(262061);
      return localObject;
    }
    AppMethodBeat.o(262061);
    return "";
  }
  
  public final String bRM()
  {
    AppMethodBeat.i(262062);
    String str = q.aPg();
    AppMethodBeat.o(262062);
    return str;
  }
  
  public final boolean bRN()
  {
    AppMethodBeat.i(262070);
    try
    {
      String str1 = (String)com.tencent.mm.kernel.h.baE().ban().d(274436, null);
      if (!TextUtils.isEmpty(str1)) {
        if (com.tencent.mm.plugin.normsg.d.e.aQt(str1))
        {
          AppMethodBeat.o(262070);
          return true;
        }
      }
    }
    finally
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NormsgSourceImpl", localThrowable, "[-] Error happened.", new Object[0]);
        String str2 = MultiProcessMMKV.getMMKV("mmkv_crossprocess_infos").decodeString("mmkv_key_user_reg_ic", null);
      }
      AppMethodBeat.o(262070);
      return false;
    }
    AppMethodBeat.o(262070);
    return false;
  }
  
  public final List<String> bRO()
  {
    AppMethodBeat.i(262073);
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
      AppMethodBeat.o(262073);
      return localArrayList2;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.NormsgSourceImpl", localThrowable, "[-] Error happened.", new Object[0]);
      ArrayList localArrayList1 = new ArrayList();
      AppMethodBeat.o(262073);
      return localArrayList1;
    }
  }
  
  public final boolean d(Object paramObject, Class paramClass)
  {
    AppMethodBeat.i(148958);
    boolean bool = c.p.ca(paramObject, paramClass);
    AppMethodBeat.o(148958);
    return bool;
  }
  
  public final boolean ec(Context paramContext)
  {
    AppMethodBeat.i(262068);
    boolean bool = NormsgDataService.ec(paramContext);
    AppMethodBeat.o(262068);
    return bool;
  }
  
  public final boolean ge(Object paramObject)
  {
    AppMethodBeat.i(148960);
    boolean bool = c.p.cb(paramObject);
    AppMethodBeat.o(148960);
    return bool;
  }
  
  public final String getAndroidId()
  {
    AppMethodBeat.i(262075);
    String str = q.getAndroidId();
    AppMethodBeat.o(262075);
    return str;
  }
  
  public final long getGSMSignalStrength()
  {
    AppMethodBeat.i(262074);
    try
    {
      long l = NetworkSignalUtil.getGSMSignalStrength();
      AppMethodBeat.o(262074);
      return l;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.NormsgSourceImpl", localThrowable, "[-] Error happened.", new Object[0]);
      AppMethodBeat.o(262074);
    }
    return -1L;
  }
  
  public final String getWiFiBssid()
  {
    AppMethodBeat.i(262072);
    if (NetStatusUtil.isWifiFromCache(MMApplicationContext.getContext()))
    {
      String str = ConnectivityCompat.Companion.getWiFiBssid();
      AppMethodBeat.o(262072);
      return str;
    }
    AppMethodBeat.o(262072);
    return "";
  }
  
  public final String getWiFiSsid()
  {
    AppMethodBeat.i(262071);
    if (NetStatusUtil.isWifiFromCache(MMApplicationContext.getContext()))
    {
      String str = ConnectivityCompat.Companion.getWiFiSsid();
      AppMethodBeat.o(262071);
      return str;
    }
    AppMethodBeat.o(262071);
    return "";
  }
  
  public final void gq(String paramString, int paramInt)
  {
    AppMethodBeat.i(262032);
    int j = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ztl, 200);
    int i = j;
    if (j <= 0) {
      i = 0;
    }
    paramString = new com.tencent.mm.plugin.normsg.c.a.a.b(paramString, i);
    if (paramString.gtT()) {
      com.tencent.mm.plugin.normsg.c.a.a.gtR().a(paramInt, paramString);
    }
    AppMethodBeat.o(262032);
  }
  
  public final String gtB()
  {
    AppMethodBeat.i(148952);
    if (WeChatSomeFeatureSwitch.onlyUSMobile())
    {
      AppMethodBeat.o(148952);
      return "";
    }
    if (com.tencent.mm.plugin.normsg.d.e.aQt((String)com.tencent.mm.kernel.h.baE().ban().d(274436, null)))
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
  
  public final boolean gtC()
  {
    AppMethodBeat.i(148953);
    boolean bool = c.p.ab();
    AppMethodBeat.o(148953);
    return bool;
  }
  
  public final boolean gtD()
  {
    AppMethodBeat.i(148954);
    try
    {
      boolean bool = c.p.ag();
      AppMethodBeat.o(148954);
      return bool;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.NormsgSourceImpl", localThrowable, "unexpected error.", new Object[0]);
      AppMethodBeat.o(148954);
    }
    return false;
  }
  
  public final byte[] gtE()
  {
    AppMethodBeat.i(148959);
    try
    {
      if (com.tencent.mm.kernel.h.baz()) {}
      for (int i = 0;; i = 15)
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
  
  public final byte[] gtF()
  {
    AppMethodBeat.i(148975);
    Object localObject = new ByteArrayOutputStream();
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    com.tencent.e.e.a.e.jXm().stop();
    Context localContext = MMApplicationContext.getContext();
    String str = q.eD(true);
    com.tencent.e.a.b local2 = new com.tencent.e.a.b()
    {
      public final boolean r(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        boolean bool = false;
        AppMethodBeat.i(148940);
        if (paramAnonymousInt == 0)
        {
          if ((paramAnonymousArrayOfByte != null) && (paramAnonymousArrayOfByte.length > 0)) {
            this.MtK.write(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
          }
          bool = true;
        }
        localCountDownLatch.countDown();
        AppMethodBeat.o(148940);
        return bool;
      }
    };
    com.tencent.e.b.c localc = new com.tencent.e.b.c(localContext);
    com.tencent.e.e.a.e.jXm().a(localContext, str, new d.1(local2, localc));
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
  
  public final boolean gtG()
  {
    AppMethodBeat.i(148978);
    boolean bool = c.p.ec();
    AppMethodBeat.o(148978);
    return bool;
  }
  
  public final byte[] gtH()
  {
    AppMethodBeat.i(148979);
    byte[] arrayOfByte = c.p.ee();
    AppMethodBeat.o(148979);
    return arrayOfByte;
  }
  
  public final boolean gtI()
  {
    AppMethodBeat.i(262016);
    boolean bool = c.p.al();
    AppMethodBeat.o(262016);
    return bool;
  }
  
  public final String gtJ()
  {
    AppMethodBeat.i(262017);
    String str = c.p.ef();
    AppMethodBeat.o(262017);
    return str;
  }
  
  public final String gtK()
  {
    AppMethodBeat.i(262019);
    String str = c.p.eg();
    AppMethodBeat.o(262019);
    return str;
  }
  
  public final String gtL()
  {
    AppMethodBeat.i(262022);
    String str = c.p.eh();
    AppMethodBeat.o(262022);
    return str;
  }
  
  public final com.tencent.mm.normsg.a gtM()
  {
    return this;
  }
  
  public final com.tencent.mm.normsgext.a gtN()
  {
    return this;
  }
  
  public final void gtO()
  {
    AppMethodBeat.i(262029);
    Log.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src i1.");
    Object localObject = MMApplicationContext.getContext();
    if (localObject == null)
    {
      if ((BuildInfo.DEBUG) || (CrashReportFactory.hasDebuger()))
      {
        localObject = new IllegalStateException("MMApplicationContext has not been initialized.");
        AppMethodBeat.o(262029);
        throw ((Throwable)localObject);
      }
      Log.e("MicroMsg.NormsgSourceImpl", "[-] MMApplicationContext has not been initialized.");
      AppMethodBeat.o(262029);
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
        AppMethodBeat.i(261892);
        if (paramAnonymousIntent == null)
        {
          Log.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src, g1.");
          AppMethodBeat.o(261892);
          return;
        }
        if (("android.intent.action.PACKAGE_REMOVED".equals(paramAnonymousIntent.getAction())) && (paramAnonymousIntent.getBooleanExtra("android.intent.extra.REPLACING", false)))
        {
          Log.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src, g2.");
          AppMethodBeat.o(261892);
          return;
        }
        synchronized (b.a(b.this))
        {
          Log.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src, invalidating sth.");
          b.a(b.this)[0] = null;
          b.b(b.this).clear();
          if (("android.intent.action.PACKAGE_ADDED".equals(paramAnonymousIntent.getAction())) && (!paramAnonymousIntent.getBooleanExtra("android.intent.extra.REPLACING", false)) && (MMApplicationContext.isMainProcess())) {
            com.tencent.mm.plugin.secinforeport.a.d.Pmb.asyncReportNewInstallAppThroughCgi(paramAnonymousIntent);
          }
          AppMethodBeat.o(261892);
          return;
        }
      }
    }, localIntentFilter);
    AppMethodBeat.o(262029);
  }
  
  public final void kI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148970);
    c.p.df(paramString1, paramString2, "");
    AppMethodBeat.o(148970);
  }
  
  public final boolean m(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(262063);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(new StringBuilder("atadtsurt_").reverse().toString());
    if (!localMultiProcessMMKV.encode(paramString, paramArrayOfByte))
    {
      AppMethodBeat.o(262063);
      return false;
    }
    boolean bool = localMultiProcessMMKV.commit();
    AppMethodBeat.o(262063);
    return bool;
  }
  
  public final void sR(long paramLong)
  {
    AppMethodBeat.i(262043);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(262043);
      return;
    }
    com.tencent.mm.plugin.normsg.c.a.gtP().a(6, paramLong, true, 10000);
    AppMethodBeat.o(262043);
  }
  
  public final void sS(long paramLong)
  {
    AppMethodBeat.i(262046);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(262046);
      return;
    }
    com.tencent.mm.plugin.normsg.c.a.gtP().sT(paramLong);
    AppMethodBeat.o(262046);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b
 * JD-Core Version:    0.7.0.1
 */
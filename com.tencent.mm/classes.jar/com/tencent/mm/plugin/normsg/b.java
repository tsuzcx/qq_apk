package com.tencent.mm.plugin.normsg;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.d.a.d.1;
import com.tencent.d.e.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.normsg.PValue;
import com.tencent.mm.normsg.b.a;
import com.tencent.mm.normsg.c.p;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.ae;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

 enum b
  implements com.tencent.mm.plugin.normsg.a.a
{
  private static final ao voh;
  
  static
  {
    AppMethodBeat.i(148981);
    vog = new b("INSTANCE");
    voi = new b[] { vog };
    voh = new ao("NormsgWorker");
    AppMethodBeat.o(148981);
  }
  
  private b() {}
  
  private static String aoo(String paramString)
  {
    AppMethodBeat.i(148947);
    if (bs.isNullOrNil(paramString))
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
  
  public static boolean dkA()
  {
    AppMethodBeat.i(148956);
    boolean bool = c.p.ai();
    ac.i("MicroMsg.NormsgSourceImpl", "[tomys-edt] bravo jerry: %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(148956);
    return bool;
  }
  
  public static boolean dkB()
  {
    AppMethodBeat.i(148957);
    boolean bool = c.p.aj();
    ac.i("MicroMsg.NormsgSourceImpl", "[tomys-edt] charlie brown: %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(148957);
    return bool;
  }
  
  private static String dkv()
  {
    AppMethodBeat.i(148950);
    for (;;)
    {
      try
      {
        localObject = ((ConnectivityManager)ai.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (((NetworkInfo)localObject).getType() != 1) {
          continue;
        }
        localObject = "wifi";
      }
      catch (Exception localException)
      {
        Object localObject;
        ac.e("MicroMsg.NormsgSourceImpl", "getNetTypeStr: %s", new Object[] { bs.m(localException) });
        String str = "";
        continue;
      }
      AppMethodBeat.o(148950);
      return localObject;
      localObject = ((NetworkInfo)localObject).getSubtype();
    }
  }
  
  public static boolean dkz()
  {
    AppMethodBeat.i(148955);
    boolean bool = c.p.ah();
    ac.i("MicroMsg.NormsgSourceImpl", "[tomys-edt] alpha tom: %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(148955);
    return bool;
  }
  
  private static int getVersionCode()
  {
    int i = 0;
    AppMethodBeat.i(148949);
    Object localObject1 = ai.getContext().getPackageManager();
    try
    {
      localObject1 = ((PackageManager)localObject1).getPackageInfo(ai.getPackageName(), 0);
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
        ac.w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + ai.getPackageName());
      }
    }
  }
  
  private static String gw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148948);
    localObject1 = "";
    Object localObject2 = ai.getContext().getPackageManager();
    try
    {
      localObject2 = ((PackageManager)localObject2).getPackageInfo(ai.getPackageName(), 0);
      if (localObject2 != null) {
        localObject1 = ((PackageInfo)localObject2).applicationInfo.sourceDir;
      }
      try
      {
        localObject2 = com.tencent.mm.d.c.B(new File((String)localObject1));
        localObject1 = localObject2;
        if (bs.isNullOrNil((String)localObject2))
        {
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(322L, 13L, 1L, true);
          com.tencent.mm.plugin.report.e.wTc.f(11098, new Object[] { Integer.valueOf(4013), String.format("%s|%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }) });
          localObject1 = localObject2;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject3;
          ac.w("MicroMsg.NormsgSourceImpl", "summertoken getSecurityCode e: " + localException.getMessage());
          localObject1 = "0";
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(322L, 12L, 1L, true);
          com.tencent.mm.plugin.report.e.wTc.f(11098, new Object[] { Integer.valueOf(4012), String.format("%s|%s|%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localException.getMessage() }) });
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
        ac.w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + ai.getPackageName());
      }
    }
  }
  
  public final byte[] Kv(int paramInt)
  {
    AppMethodBeat.i(148943);
    byte[] arrayOfByte = c.p.aa(paramInt);
    AppMethodBeat.o(148943);
    return arrayOfByte;
  }
  
  public final String Kw(int paramInt)
  {
    AppMethodBeat.i(148946);
    Object localObject2 = "";
    if (com.tencent.mm.kernel.g.agM()) {
      localObject2 = (String)com.tencent.mm.kernel.g.agR().agA().get(79, "");
    }
    com.tencent.mm.kernel.g.agU().m(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(148938);
        if (!com.tencent.mm.kernel.g.agM())
        {
          AppMethodBeat.o(148938);
          return;
        }
        try
        {
          long l1 = System.currentTimeMillis();
          Object localObject = ai.getContext().getApplicationInfo().sourceDir;
          com.tencent.mm.kernel.g.agP();
          localObject = c.p.ae(com.tencent.mm.kernel.a.getUin());
          com.tencent.mm.kernel.g.agP();
          byte[] arrayOfByte = c.p.af(com.tencent.mm.kernel.a.getUin());
          long l2 = System.currentTimeMillis();
          String str = String.format("<k25>%s</k25>", new Object[] { com.tencent.mm.plugin.normsg.c.d.z((byte[])localObject, 0, localObject.length) });
          localObject = str;
          if (arrayOfByte != null)
          {
            if (arrayOfByte.length != 8) {
              break label336;
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
          for (localObject = str + String.format("<k28>%s</k28><k29>%s</k29>", new Object[] { com.tencent.mm.plugin.normsg.c.d.z(arrayOfByte, 0, 4), com.tencent.mm.plugin.normsg.c.d.z(arrayOfByte, 4, 8) });; localObject = str + String.format("<k27>%s</k27>", new Object[] { com.tencent.mm.plugin.normsg.c.d.z(arrayOfByte, 0, arrayOfByte.length) }))
          {
            try
            {
              str = Inet4Address.getByName("mp.weixin.qq.com").getHostAddress();
              str = (String)localObject + String.format("<k32>%s</k32>", new Object[] { bs.nullAsNil(str) });
              localObject = str;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                label336:
                ac.e("MicroMsg.NormsgSourceImpl", "exception:%s", new Object[] { bs.m(localException2) });
              }
            }
            ac.i("MicroMsg.NormsgSourceImpl", "checkSoftType2 [time: " + (l2 - l1) + ", value: " + (String)localObject + "]");
            com.tencent.mm.kernel.g.agR().agA().set(79, localObject);
            AppMethodBeat.o(148938);
            return;
          }
          return;
        }
        catch (Exception localException1)
        {
          ac.printErrStackTrace("MicroMsg.NormsgSourceImpl", localException1, "Failed checkSoftType2.", new Object[0]);
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
    StringBuilder localStringBuilder1;
    Object localObject3;
    if (com.tencent.mm.kernel.g.agM())
    {
      if (com.tencent.mm.kernel.g.agR().ghG.HbL.Hbg) {
        str1 = "1";
      }
    }
    else
    {
      Context localContext = ai.getContext().getApplicationContext();
      String str3 = ax.iL(localContext);
      String str4 = ax.iM(localContext);
      localObject1 = ai.getContext();
      if (localObject1 != null) {
        break label1250;
      }
      ac.w("MicroMsg.NormsgSourceImpl", "Failed checking mock location: application context not initialized.");
      i = 0;
      if (i == 0) {
        break label1270;
      }
      i = 1;
      if (!c.p.ab()) {
        break label1275;
      }
      j = 1;
      if (!Debug.isDebuggerConnected()) {
        break label1280;
      }
      k = 1;
      if ((!com.tencent.mm.plugin.normsg.c.f.vpJ) && (!com.tencent.mm.plugin.normsg.c.f.vpK) && (!com.tencent.mm.plugin.normsg.c.f.vpL)) {
        break label1286;
      }
      m = 1;
      if (!com.tencent.mm.plugin.normsg.c.e.vpF) {
        break label1292;
      }
      n = 1;
      if (!com.tencent.mm.plugin.normsg.c.g.vpM) {
        break label1298;
      }
      i1 = 1;
      localObject1 = c.p.ad();
      if (localObject1 == null) {
        break label1304;
      }
      localObject1 = com.tencent.mm.plugin.normsg.c.d.z((byte[])localObject1, 0, localObject1.length);
      i2 = getVersionCode();
      str2 = gw(i2, paramInt);
      Map localMap = q.Ye();
      localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = localStringBuilder1.append("<softtype><lctmoc>").append(i).append("</lctmoc><level>").append(j).append("</level>").append((String)localObject2).append("<k1>");
      localObject3 = (String)localMap.get("model name");
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = q.Yd()[0];
      }
      localStringBuilder2 = localStringBuilder2.append(aoo((String)localObject2)).append("</k1><k2>").append(aoo(q.Yc())).append("</k2><k3>").append(aoo(Build.VERSION.RELEASE)).append("</k3><k4>").append(aoo(q.cF(true))).append("</k4><k5>").append(aoo(q.XR())).append("</k5><k6>").append(aoo(q.XT())).append("</k6><k7>").append(aoo(q.getAndroidId())).append("</k7><k8>").append(aoo(q.XS())).append("</k8><k9>").append(aoo(Build.MODEL)).append("</k9><k10>").append(q.Yf()).append("</k10><k11>").append(bs.nullAsNil(aoo((String)localMap.get("hardware")))).append("</k11><k12>").append(bs.nullAsNil(aoo((String)localMap.get("revision")))).append("</k12><k13>").append(bs.nullAsNil(aoo((String)localMap.get("serial")))).append("</k13><k14>").append(aoo(q.XU())).append("</k14><k15>").append(aoo(q.XV())).append("</k15><k16>");
      localObject3 = (String)localMap.get("features");
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = (String)localMap.get("flags");
      }
      localObject2 = localStringBuilder2.append(bs.nullAsNil(aoo((String)localObject2))).append("</k16><k18>").append((String)localObject1).append("</k18><k21>").append(bs.nullAsNil(aoo(str3))).append("</k21><k22>").append(bs.nullAsNil(aoo(q.bY(localContext)))).append("</k22><k24>").append(bs.nullAsNil(aoo(str4))).append("</k24><k26>").append(k).append("</k26><k30>");
      localObject1 = ((ConnectivityManager)ai.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localObject1 == null) {
        break label1318;
      }
    }
    label1280:
    label1286:
    label1292:
    label1298:
    label1304:
    label1318:
    for (Object localObject1 = ((NetworkInfo)localObject1).getExtraInfo();; localObject1 = null)
    {
      localObject3 = ((StringBuilder)localObject2).append(bs.nullAsNil(aoo((String)localObject1))).append("</k30><k33>").append(aoo(ai.getPackageName())).append("</k33><k34>").append(bs.nullAsNil(aoo(af.get("ro.build.fingerprint")))).append("</k34><k35>").append(bs.nullAsNil(aoo(Build.BOARD))).append("</k35><k36>").append(bs.nullAsNil(aoo(Build.BOOTLOADER))).append("</k36><k37>").append(bs.nullAsNil(aoo(Build.BRAND))).append("</k37><k38>").append(bs.nullAsNil(aoo(Build.DEVICE))).append("</k38><k39>").append(bs.nullAsNil(aoo(Build.HARDWARE))).append("</k39><k40>").append(bs.nullAsNil(aoo(Build.PRODUCT))).append("</k40><k41>").append(m).append("</k41><k42>").append(bs.nullAsNil(aoo(af.get("ro.product.manufacturer")))).append("</k42><k43>").append(Settings.System.getString(ai.getContext().getContentResolver(), "89884a87498ef44f")).append("</k43><k44>0</k44><k45>");
      ac.d("MicroMsg.NormsgSourceImpl", "READ_PHONE_STATE.getLine1Number %s", new Object[] { bs.eWi() });
      localObject2 = bs.nullAsNil(bs.iV(ai.getContext()));
      localObject1 = localObject2;
      if (((String)localObject2).length() > 0) {
        localObject1 = com.tencent.mm.b.g.getMessageDigest(((String)localObject2).getBytes());
      }
      localObject1 = ((StringBuilder)localObject3).append((String)localObject1).append("</k45><k46>").append(str1).append("</k46><k47>").append(aoo(dkv())).append("</k47><k48>").append(q.cF(true)).append("</k48><k49>").append(com.tencent.mm.loader.j.b.aoY()).append("</k49><k52>").append(n).append("</k52><k53>").append(i1).append("</k53><k57>").append(i2).append("</k57><k58>").append(bs.nullAsNil(aoo(str2))).append("</k58><k59>").append(paramInt).append("</k59><k60>").append(aoo(com.tencent.mm.sdk.platformtools.h.GqF.getString("FEATURE_ID"))).append("</k60><k61>").append(q.XZ()).append("</k61><k62>");
      str1 = com.tencent.mm.plugin.soter.d.d.dTq().znE;
      if (str1 != null) {}
      for (;;)
      {
        ((StringBuilder)localObject1).append(str1).append("</k62><k63>").append(q.XX()).append("</k63><k64>").append(q.Ya()).append("</k64><k65>").append(q.getOAID()).append("</k65></softtype>");
        str1 = localStringBuilder1.toString();
        AppMethodBeat.o(148946);
        return str1;
        str1 = "0";
        break;
        label1250:
        if (Settings.Secure.getInt(((Context)localObject1).getContentResolver(), "mock_location", 0) == 0) {
          break label122;
        }
        i = 1;
        break label124;
        label1270:
        i = 0;
        break label130;
        label1275:
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
        localObject1 = "";
        break label207;
        str1 = "";
      }
    }
  }
  
  public final void Kx(int paramInt)
  {
    AppMethodBeat.i(148962);
    com.tencent.mm.plugin.normsg.c.a.dkH().Kx(paramInt);
    AppMethodBeat.o(148962);
  }
  
  public final byte[] Ky(int paramInt)
  {
    AppMethodBeat.i(148976);
    byte[] arrayOfByte = c.p.ea(paramInt);
    AppMethodBeat.o(148976);
    return arrayOfByte;
  }
  
  public final void a(View paramView, Class<? extends com.tencent.mm.sdk.b.b> paramClass)
  {
    AppMethodBeat.i(148961);
    com.tencent.mm.plugin.normsg.c.c.a(paramView, paramClass);
    AppMethodBeat.o(148961);
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
    PValue localPValue1 = new PValue();
    PValue localPValue2 = new PValue();
    PValue localPValue3 = new PValue();
    boolean bool = b.a.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, localPValue1, localPValue2, localPValue3);
    if (bool)
    {
      paramArrayOfByte = new ctv();
      paramArrayOfByte.FFu = ((Integer)localPValue1.getValue(Integer.valueOf(0))).intValue();
      paramArrayOfByte.FFv = ((Integer)localPValue2.getValue(Integer.valueOf(0))).intValue();
      paramArrayOfByte.FFw = com.tencent.mm.bw.b.cc((byte[])localPValue3.value);
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
        ac.e("MicroMsg.NormsgSourceImpl", "[-] pb deseralize failed");
      }
    }
  }
  
  public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, PByteArray paramPByteArray)
  {
    AppMethodBeat.i(148963);
    PValue localPValue1 = new PValue();
    PValue localPValue2 = new PValue();
    PValue localPValue3 = new PValue();
    boolean bool = b.a.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, localPValue1, localPValue2, localPValue3);
    if (bool)
    {
      paramPInt1.value = ((Integer)localPValue1.getValue(Integer.valueOf(0))).intValue();
      paramPInt2.value = ((Integer)localPValue2.getValue(Integer.valueOf(0))).intValue();
    }
    for (paramPByteArray.value = ((byte[])localPValue3.value);; paramPByteArray.value = null)
    {
      AppMethodBeat.o(148963);
      return bool;
      paramPInt1.value = 0;
      paramPInt2.value = 0;
    }
  }
  
  public final void ao(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(148944);
    Object localObject = ai.getContext();
    if ((paramInt2 <= 0) || (paramInt2 > 4))
    {
      localObject = new IllegalArgumentException("action invalid: ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(148944);
      throw ((Throwable)localObject);
    }
    localObject = new d.a((Context)localObject, paramInt1, paramInt2, (byte)0);
    long l = paramInt3 * 1000;
    if (l < com.tencent.d.e.a.a.f.JTF) {
      ((d.a)localObject).JTk = com.tencent.d.e.a.a.f.JTF;
    }
    for (;;)
    {
      ((d.a)localObject).JTk = l;
      localObject = new com.tencent.d.e.a.d((d.a)localObject, (byte)0);
      com.tencent.d.e.a.e.fCB().a((com.tencent.d.e.a.d)localObject);
      AppMethodBeat.o(148944);
      return;
      if (l > com.tencent.d.e.a.a.f.JTC * 12L) {
        ((d.a)localObject).JTk = (com.tencent.d.e.a.a.f.JTC * 12L);
      }
    }
  }
  
  public final String aon(String paramString)
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
  
  public final void aop(String paramString)
  {
    AppMethodBeat.i(148965);
    c.p.da(paramString);
    AppMethodBeat.o(148965);
  }
  
  public final void aoq(String paramString)
  {
    AppMethodBeat.i(148966);
    c.p.db(paramString);
    AppMethodBeat.o(148966);
  }
  
  public final void aor(String paramString)
  {
    AppMethodBeat.i(148967);
    c.p.dc(paramString);
    AppMethodBeat.o(148967);
  }
  
  public final boolean aos(String paramString)
  {
    AppMethodBeat.i(148968);
    boolean bool = c.p.dd(paramString);
    AppMethodBeat.o(148968);
    return bool;
  }
  
  public final byte[] aot(String paramString)
  {
    AppMethodBeat.i(148969);
    paramString = c.p.de(paramString);
    AppMethodBeat.o(148969);
    return paramString;
  }
  
  public final void aou(String paramString)
  {
    AppMethodBeat.i(148972);
    c.p.dh(paramString);
    AppMethodBeat.o(148972);
  }
  
  public final boolean aov(String paramString)
  {
    AppMethodBeat.i(148973);
    boolean bool = c.p.di(paramString);
    AppMethodBeat.o(148973);
    return bool;
  }
  
  public final byte[] aow(String paramString)
  {
    AppMethodBeat.i(148974);
    paramString = c.p.dj(paramString);
    AppMethodBeat.o(148974);
    return paramString;
  }
  
  public final byte[] dkC()
  {
    AppMethodBeat.i(148959);
    byte[] arrayOfByte = c.p.aa(0);
    AppMethodBeat.o(148959);
    return arrayOfByte;
  }
  
  public final byte[] dkD()
  {
    AppMethodBeat.i(148975);
    Object localObject = new ByteArrayOutputStream();
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    com.tencent.d.e.a.e.fCB().Fb();
    Context localContext = ai.getContext();
    String str = q.cF(true);
    com.tencent.d.a.b local2 = new com.tencent.d.a.b()
    {
      public final boolean p(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        boolean bool = false;
        AppMethodBeat.i(148940);
        if (paramAnonymousInt == 0)
        {
          if ((paramAnonymousArrayOfByte != null) && (paramAnonymousArrayOfByte.length > 0)) {
            this.vok.write(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
          }
          bool = true;
        }
        localCountDownLatch.countDown();
        AppMethodBeat.o(148940);
        return bool;
      }
    };
    com.tencent.d.b.c localc = new com.tencent.d.b.c(localContext);
    com.tencent.d.e.a.e.fCB().a(localContext, str, new d.1(local2, localc));
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
  
  public final boolean dkE()
  {
    AppMethodBeat.i(148978);
    boolean bool = c.p.ec();
    AppMethodBeat.o(148978);
    return bool;
  }
  
  public final byte[] dkF()
  {
    AppMethodBeat.i(148979);
    byte[] arrayOfByte = c.p.ee();
    AppMethodBeat.o(148979);
    return arrayOfByte;
  }
  
  public final boolean dkG()
  {
    AppMethodBeat.i(206473);
    boolean bool = c.p.al();
    AppMethodBeat.o(206473);
    return bool;
  }
  
  public final String dkw()
  {
    AppMethodBeat.i(148952);
    if (com.tencent.mm.aw.b.CQ((String)com.tencent.mm.kernel.g.agR().agA().get(274436, null)))
    {
      ac.w("MicroMsg.NormsgSourceImpl", "*** point 0, explained by source code.");
      AppMethodBeat.o(148952);
      return "";
    }
    Object localObject2 = ai.getContext().getPackageManager().getInstalledPackages(0);
    Object localObject1 = new StringBuilder(8192);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((StringBuilder)localObject1).append(((PackageInfo)((Iterator)localObject2).next()).packageName).append('\n');
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(148952);
    return localObject1;
  }
  
  public final boolean dkx()
  {
    AppMethodBeat.i(148953);
    boolean bool = c.p.ab();
    AppMethodBeat.o(148953);
    return bool;
  }
  
  public final boolean dky()
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
      ac.printErrStackTrace("MicroMsg.NormsgSourceImpl", localThrowable, "unexpected error.", new Object[0]);
      AppMethodBeat.o(148954);
    }
    return false;
  }
  
  public final boolean du(Object paramObject)
  {
    AppMethodBeat.i(148960);
    boolean bool = c.p.cb(paramObject);
    AppMethodBeat.o(148960);
    return bool;
  }
  
  public final boolean e(Object paramObject, Class paramClass)
  {
    AppMethodBeat.i(148958);
    boolean bool = c.p.ca(paramObject, paramClass);
    AppMethodBeat.o(148958);
    return bool;
  }
  
  public final String getOAID()
  {
    AppMethodBeat.i(148980);
    try
    {
      Object localObject = com.tencent.d.e.b.a.a.b.kG(ai.getContext());
      if (((com.tencent.d.e.b.a.a.c)localObject).errorCode == 0)
      {
        localObject = bs.nullAsNil(((com.tencent.d.e.b.a.a.c)localObject).DOw);
        AppMethodBeat.o(148980);
        return localObject;
      }
      ac.e("MicroMsg.NormsgSourceImpl", "[-] Fail to get OAID, errorcode: %s", new Object[] { Integer.valueOf(((com.tencent.d.e.b.a.a.c)localObject).errorCode) });
      AppMethodBeat.o(148980);
      return "";
    }
    catch (Throwable localThrowable)
    {
      ac.printErrStackTrace("MicroMsg.NormsgSourceImpl", localThrowable, "Fail to get OAID.", new Object[0]);
      AppMethodBeat.o(148980);
    }
    return "";
  }
  
  public final void id(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148970);
    c.p.df(paramString1, paramString2);
    AppMethodBeat.o(148970);
  }
  
  public final String oJ(boolean paramBoolean)
  {
    AppMethodBeat.i(148951);
    String str = c.p.ac(",", paramBoolean);
    AppMethodBeat.o(148951);
    return str;
  }
  
  public final boolean y(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148977);
    boolean bool = c.p.eb(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(148977);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b
 * JD-Core Version:    0.7.0.1
 */
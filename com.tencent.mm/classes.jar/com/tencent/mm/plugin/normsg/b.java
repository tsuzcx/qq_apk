package com.tencent.mm.plugin.normsg;

import android.content.Context;
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
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.d.a.d.1;
import com.tencent.d.e.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.normsg.c.p;
import com.tencent.mm.normsgext.QValue;
import com.tencent.mm.normsgext.b.a;
import com.tencent.mm.plugin.normsg.c.j;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.czf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storagebase.h;
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
  implements com.tencent.mm.normsg.a, com.tencent.mm.normsgext.a, com.tencent.mm.plugin.normsg.a.a
{
  private static final ap wtz;
  
  static
  {
    AppMethodBeat.i(148981);
    wty = new b("INSTANCE");
    wtA = new b[] { wty };
    wtz = new ap("NormsgWorker");
    AppMethodBeat.o(148981);
  }
  
  private b() {}
  
  private static String Ux()
  {
    AppMethodBeat.i(148950);
    for (;;)
    {
      try
      {
        localObject = ((ConnectivityManager)aj.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (((NetworkInfo)localObject).getType() != 1) {
          continue;
        }
        localObject = "wifi";
      }
      catch (Exception localException)
      {
        Object localObject;
        ad.e("MicroMsg.NormsgSourceImpl", "getNetTypeStr: %s", new Object[] { bt.n(localException) });
        String str = "";
        continue;
      }
      AppMethodBeat.o(148950);
      return localObject;
      localObject = ((NetworkInfo)localObject).getSubtype();
    }
  }
  
  private static String ato(String paramString)
  {
    AppMethodBeat.i(148947);
    if (bt.isNullOrNil(paramString))
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
  
  public static boolean duL()
  {
    AppMethodBeat.i(148955);
    boolean bool = c.p.ah();
    ad.i("MicroMsg.NormsgSourceImpl", "[tomys-edt] alpha tom: %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(148955);
    return bool;
  }
  
  public static boolean duM()
  {
    AppMethodBeat.i(148956);
    boolean bool = c.p.ai();
    ad.i("MicroMsg.NormsgSourceImpl", "[tomys-edt] bravo jerry: %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(148956);
    return bool;
  }
  
  public static boolean duN()
  {
    AppMethodBeat.i(148957);
    boolean bool = c.p.aj();
    ad.i("MicroMsg.NormsgSourceImpl", "[tomys-edt] charlie brown: %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(148957);
    return bool;
  }
  
  private static String gO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148948);
    localObject1 = "";
    Object localObject2 = aj.getContext().getPackageManager();
    try
    {
      localObject2 = ((PackageManager)localObject2).getPackageInfo(aj.getPackageName(), 0);
      if (localObject2 != null) {
        localObject1 = ((PackageInfo)localObject2).applicationInfo.sourceDir;
      }
      try
      {
        localObject2 = com.tencent.mm.d.c.B(new File((String)localObject1));
        localObject1 = localObject2;
        if (bt.isNullOrNil((String)localObject2))
        {
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(322L, 13L, 1L, true);
          com.tencent.mm.plugin.report.e.ygI.f(11098, new Object[] { Integer.valueOf(4013), String.format("%s|%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }) });
          localObject1 = localObject2;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject3;
          ad.w("MicroMsg.NormsgSourceImpl", "summertoken getSecurityCode e: " + localException.getMessage());
          localObject1 = "0";
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(322L, 12L, 1L, true);
          com.tencent.mm.plugin.report.e.ygI.f(11098, new Object[] { Integer.valueOf(4012), String.format("%s|%s|%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localException.getMessage() }) });
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
        ad.w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + aj.getPackageName());
      }
    }
  }
  
  private static int getVersionCode()
  {
    int i = 0;
    AppMethodBeat.i(148949);
    Object localObject1 = aj.getContext().getPackageManager();
    try
    {
      localObject1 = ((PackageManager)localObject1).getPackageInfo(aj.getPackageName(), 0);
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
        ad.w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + aj.getPackageName());
      }
    }
  }
  
  public final String G(Context paramContext, String paramString)
  {
    AppMethodBeat.i(219075);
    paramContext = bt.nullAsNil(NormsgDataProvider.G(paramContext, paramString));
    AppMethodBeat.o(219075);
    return paramContext;
  }
  
  public final byte[] Ix(String paramString)
  {
    AppMethodBeat.i(219073);
    paramString = ax.aQz(new StringBuilder("atadtsurt_").reverse().toString()).decodeBytes(paramString);
    AppMethodBeat.o(219073);
    return paramString;
  }
  
  public final void Iy(String paramString)
  {
    AppMethodBeat.i(219074);
    ax.aQz(new StringBuilder("atadtsurt_").reverse().toString()).remove(paramString).commit();
    AppMethodBeat.o(219074);
  }
  
  public final byte[] LX(int paramInt)
  {
    AppMethodBeat.i(148943);
    byte[] arrayOfByte = c.p.aa(paramInt);
    AppMethodBeat.o(148943);
    return arrayOfByte;
  }
  
  public final String LY(int paramInt)
  {
    AppMethodBeat.i(148946);
    Object localObject2 = "";
    if (com.tencent.mm.kernel.g.ajx()) {
      localObject2 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(79, "");
    }
    com.tencent.mm.kernel.g.ajF().n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(148938);
        if (!com.tencent.mm.kernel.g.ajx())
        {
          AppMethodBeat.o(148938);
          return;
        }
        try
        {
          long l1 = System.currentTimeMillis();
          Object localObject = aj.getContext().getApplicationInfo().sourceDir;
          com.tencent.mm.kernel.g.ajA();
          localObject = c.p.ae(com.tencent.mm.kernel.a.getUin());
          com.tencent.mm.kernel.g.ajA();
          byte[] arrayOfByte = c.p.af(com.tencent.mm.kernel.a.getUin());
          long l2 = System.currentTimeMillis();
          String str = String.format("<k25>%s</k25>", new Object[] { com.tencent.mm.plugin.normsg.c.d.A((byte[])localObject, 0, localObject.length) });
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
          for (localObject = str + String.format("<k28>%s</k28><k29>%s</k29>", new Object[] { com.tencent.mm.plugin.normsg.c.d.A(arrayOfByte, 0, 4), com.tencent.mm.plugin.normsg.c.d.A(arrayOfByte, 4, 8) });; localObject = str + String.format("<k27>%s</k27>", new Object[] { com.tencent.mm.plugin.normsg.c.d.A(arrayOfByte, 0, arrayOfByte.length) }))
          {
            try
            {
              str = Inet4Address.getByName("mp.weixin.qq.com").getHostAddress();
              str = (String)localObject + String.format("<k32>%s</k32>", new Object[] { bt.nullAsNil(str) });
              localObject = str;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                label336:
                ad.e("MicroMsg.NormsgSourceImpl", "exception:%s", new Object[] { bt.n(localException2) });
              }
            }
            ad.i("MicroMsg.NormsgSourceImpl", "checkSoftType2 [time: " + (l2 - l1) + ", value: " + (String)localObject + "]");
            com.tencent.mm.kernel.g.ajC().ajl().set(79, localObject);
            AppMethodBeat.o(148938);
            return;
          }
          return;
        }
        catch (Exception localException1)
        {
          ad.printErrStackTrace("MicroMsg.NormsgSourceImpl", localException1, "Failed checkSoftType2.", new Object[0]);
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
    if (com.tencent.mm.kernel.g.ajx())
    {
      if (com.tencent.mm.kernel.g.ajC().gBq.IPb.IOv) {
        str1 = "1";
      }
    }
    else
    {
      Context localContext = aj.getContext().getApplicationContext();
      String str3 = ay.iV(localContext);
      String str4 = ay.iW(localContext);
      localObject1 = aj.getContext();
      if (localObject1 != null) {
        break label1250;
      }
      ad.w("MicroMsg.NormsgSourceImpl", "Failed checking mock location: application context not initialized.");
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
      if ((!com.tencent.mm.plugin.normsg.c.f.wvb) && (!com.tencent.mm.plugin.normsg.c.f.wvc) && (!com.tencent.mm.plugin.normsg.c.f.wvd)) {
        break label1286;
      }
      m = 1;
      if (!com.tencent.mm.plugin.normsg.c.e.wuX) {
        break label1292;
      }
      n = 1;
      if (!com.tencent.mm.plugin.normsg.c.g.wve) {
        break label1298;
      }
      i1 = 1;
      localObject1 = c.p.ad();
      if (localObject1 == null) {
        break label1304;
      }
      localObject1 = com.tencent.mm.plugin.normsg.c.d.A((byte[])localObject1, 0, localObject1.length);
      i2 = getVersionCode();
      str2 = gO(i2, paramInt);
      Map localMap = q.aaG();
      localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = localStringBuilder1.append("<softtype><lctmoc>").append(i).append("</lctmoc><level>").append(j).append("</level>").append((String)localObject2).append("<k1>");
      localObject3 = (String)localMap.get("model name");
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = q.aaF()[0];
      }
      localStringBuilder2 = localStringBuilder2.append(ato((String)localObject2)).append("</k1><k2>").append(ato(q.aaE())).append("</k2><k3>").append(ato(Build.VERSION.RELEASE)).append("</k3><k4>").append(ato(q.cH(true))).append("</k4><k5>").append(ato(q.aas())).append("</k5><k6>").append(ato(q.aau())).append("</k6><k7>").append(ato(q.getAndroidId())).append("</k7><k8>").append(ato(q.aat())).append("</k8><k9>").append(ato(Build.MODEL)).append("</k9><k10>").append(q.aaH()).append("</k10><k11>").append(bt.nullAsNil(ato((String)localMap.get("hardware")))).append("</k11><k12>").append(bt.nullAsNil(ato((String)localMap.get("revision")))).append("</k12><k13>").append(bt.nullAsNil(ato((String)localMap.get("serial")))).append("</k13><k14>").append(ato(q.aav())).append("</k14><k15>").append(ato(q.aaw())).append("</k15><k16>");
      localObject3 = (String)localMap.get("features");
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = (String)localMap.get("flags");
      }
      localObject2 = localStringBuilder2.append(bt.nullAsNil(ato((String)localObject2))).append("</k16><k18>").append((String)localObject1).append("</k18><k21>").append(bt.nullAsNil(ato(str3))).append("</k21><k22>").append(bt.nullAsNil(ato(q.bW(localContext)))).append("</k22><k24>").append(bt.nullAsNil(ato(str4))).append("</k24><k26>").append(k).append("</k26><k30>");
      localObject1 = ((ConnectivityManager)aj.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
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
      localObject3 = ((StringBuilder)localObject2).append(bt.nullAsNil(ato((String)localObject1))).append("</k30><k33>").append(ato(aj.getPackageName())).append("</k33><k34>").append(bt.nullAsNil(ato(af.get("ro.build.fingerprint")))).append("</k34><k35>").append(bt.nullAsNil(ato(Build.BOARD))).append("</k35><k36>").append(bt.nullAsNil(ato(Build.BOOTLOADER))).append("</k36><k37>").append(bt.nullAsNil(ato(Build.BRAND))).append("</k37><k38>").append(bt.nullAsNil(ato(Build.DEVICE))).append("</k38><k39>").append(bt.nullAsNil(ato(Build.HARDWARE))).append("</k39><k40>").append(bt.nullAsNil(ato(Build.PRODUCT))).append("</k40><k41>").append(m).append("</k41><k42>").append(bt.nullAsNil(ato(af.get("ro.product.manufacturer")))).append("</k42><k43>").append(Settings.System.getString(aj.getContext().getContentResolver(), "89884a87498ef44f")).append("</k43><k44>0</k44><k45>");
      ad.d("MicroMsg.NormsgSourceImpl", "READ_PHONE_STATE.getLine1Number %s", new Object[] { bt.flS() });
      localObject2 = bt.nullAsNil(bt.jf(aj.getContext()));
      localObject1 = localObject2;
      if (((String)localObject2).length() > 0) {
        localObject1 = com.tencent.mm.b.g.getMessageDigest(((String)localObject2).getBytes());
      }
      localObject1 = ((StringBuilder)localObject3).append((String)localObject1).append("</k45><k46>").append(str1).append("</k46><k47>").append(ato(Ux())).append("</k47><k48>").append(q.cH(true)).append("</k48><k49>").append(com.tencent.mm.loader.j.b.arL()).append("</k49><k52>").append(n).append("</k52><k53>").append(i1).append("</k53><k57>").append(i2).append("</k57><k58>").append(bt.nullAsNil(ato(str2))).append("</k58><k59>").append(paramInt).append("</k59><k60>").append(ato(i.Ict.getString("FEATURE_ID"))).append("</k60><k61>").append(q.aaA()).append("</k61><k62>");
      str1 = com.tencent.mm.plugin.soter.d.d.efE().AFy;
      if (str1 != null) {}
      for (;;)
      {
        ((StringBuilder)localObject1).append(str1).append("</k62><k63>").append(q.aay()).append("</k63><k64>").append(q.aaB()).append("</k64><k65>").append(q.aaC()).append("</k65></softtype>");
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
  
  public final void LZ(int paramInt)
  {
    AppMethodBeat.i(148962);
    com.tencent.mm.plugin.normsg.c.a.duY().LZ(paramInt);
    AppMethodBeat.o(148962);
  }
  
  public final byte[] Ma(int paramInt)
  {
    AppMethodBeat.i(148976);
    byte[] arrayOfByte = c.p.ea(paramInt);
    AppMethodBeat.o(148976);
    return arrayOfByte;
  }
  
  public final void N(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(219066);
    com.tencent.mm.plugin.report.service.g.yhR.n(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(219066);
  }
  
  public final void O(int paramInt, String paramString)
  {
    AppMethodBeat.i(219065);
    com.tencent.mm.plugin.report.service.g.yhR.kvStat(paramInt, paramString);
    AppMethodBeat.o(219065);
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
    QValue localQValue1 = new QValue();
    QValue localQValue2 = new QValue();
    QValue localQValue3 = new QValue();
    boolean bool = b.a.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, localQValue1, localQValue2, localQValue3);
    if (bool)
    {
      paramArrayOfByte = new czf();
      paramArrayOfByte.HpT = ((Integer)localQValue1.getValue(Integer.valueOf(0))).intValue();
      paramArrayOfByte.HpU = ((Integer)localQValue2.getValue(Integer.valueOf(0))).intValue();
      paramArrayOfByte.HpV = com.tencent.mm.bx.b.cj((byte[])localQValue3.value);
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
        ad.e("MicroMsg.NormsgSourceImpl", "[-] pb deseralize failed");
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
  
  public final String aPv()
  {
    AppMethodBeat.i(219063);
    String str2 = "";
    Object localObject = com.tencent.mm.lib.riskscanner.a.a.co(aj.getContext());
    String str1 = str2;
    if (localObject != null)
    {
      str1 = str2;
      if (((Bundle)localObject).getInt("errCode", -100) == 0)
      {
        localObject = ((Bundle)localObject).getByteArray("reqBufferBase64");
        str1 = str2;
        if (localObject != null) {
          str1 = Base64.encodeToString((byte[])localObject, 2);
        }
      }
    }
    AppMethodBeat.o(219063);
    return str1;
  }
  
  public final long aPw()
  {
    AppMethodBeat.i(219064);
    long l = com.tencent.mm.plugin.normsg.c.a.duY().duZ();
    AppMethodBeat.o(219064);
    return l;
  }
  
  public final String aPx()
  {
    AppMethodBeat.i(219068);
    String str = com.tencent.mm.plugin.soter.d.d.efE().AFy;
    if (str != null)
    {
      AppMethodBeat.o(219068);
      return str;
    }
    AppMethodBeat.o(219068);
    return "";
  }
  
  public final boolean aPy()
  {
    AppMethodBeat.i(219069);
    boolean bool = j.isConnected();
    AppMethodBeat.o(219069);
    return bool;
  }
  
  public final String aPz()
  {
    AppMethodBeat.i(219070);
    String str = com.tencent.mm.plugin.soter.d.d.efE().AFz;
    if (str != null)
    {
      AppMethodBeat.o(219070);
      return str;
    }
    AppMethodBeat.o(219070);
    return "";
  }
  
  public final String aaC()
  {
    AppMethodBeat.i(148980);
    try
    {
      Object localObject = com.tencent.d.e.b.a.a.b.kS(aj.getContext());
      if (((com.tencent.d.e.b.a.a.c)localObject).errorCode == 0)
      {
        localObject = bt.nullAsNil(((com.tencent.d.e.b.a.a.c)localObject).yWM);
        AppMethodBeat.o(148980);
        return localObject;
      }
      ad.e("MicroMsg.NormsgSourceImpl", "[-] Fail to get OAID, errorcode: %s", new Object[] { Integer.valueOf(((com.tencent.d.e.b.a.a.c)localObject).errorCode) });
      AppMethodBeat.o(148980);
      return "";
    }
    catch (Throwable localThrowable)
    {
      ad.printErrStackTrace("MicroMsg.NormsgSourceImpl", localThrowable, "Fail to get OAID.", new Object[0]);
      AppMethodBeat.o(148980);
    }
    return "";
  }
  
  public final void ao(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(148944);
    Object localObject = aj.getContext();
    if ((paramInt2 <= 0) || (paramInt2 > 4))
    {
      localObject = new IllegalArgumentException("action invalid: ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(148944);
      throw ((Throwable)localObject);
    }
    localObject = new d.a((Context)localObject, paramInt1, paramInt2, (byte)0);
    long l = paramInt3 * 1000;
    if (l < com.tencent.d.e.a.a.f.LNv) {
      ((d.a)localObject).BFC = com.tencent.d.e.a.a.f.LNv;
    }
    for (;;)
    {
      ((d.a)localObject).BFC = l;
      localObject = new com.tencent.d.e.a.d((d.a)localObject, (byte)0);
      com.tencent.d.e.a.e.fTR().a((com.tencent.d.e.a.d)localObject);
      AppMethodBeat.o(148944);
      return;
      if (l > com.tencent.d.e.a.a.f.LNs * 12L) {
        ((d.a)localObject).BFC = (com.tencent.d.e.a.a.f.LNs * 12L);
      }
    }
  }
  
  public final String atn(String paramString)
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
  
  public final void atp(String paramString)
  {
    AppMethodBeat.i(148965);
    c.p.da(paramString);
    AppMethodBeat.o(148965);
  }
  
  public final void atq(String paramString)
  {
    AppMethodBeat.i(148966);
    c.p.db(paramString);
    AppMethodBeat.o(148966);
  }
  
  public final void atr(String paramString)
  {
    AppMethodBeat.i(148967);
    c.p.dc(paramString);
    AppMethodBeat.o(148967);
  }
  
  public final boolean ats(String paramString)
  {
    AppMethodBeat.i(148968);
    boolean bool = c.p.dd(paramString);
    AppMethodBeat.o(148968);
    return bool;
  }
  
  public final byte[] att(String paramString)
  {
    AppMethodBeat.i(148969);
    paramString = c.p.de(paramString);
    AppMethodBeat.o(148969);
    return paramString;
  }
  
  public final void atu(String paramString)
  {
    AppMethodBeat.i(148972);
    c.p.dh(paramString);
    AppMethodBeat.o(148972);
  }
  
  public final boolean atv(String paramString)
  {
    AppMethodBeat.i(148973);
    boolean bool = c.p.di(paramString);
    AppMethodBeat.o(148973);
    return bool;
  }
  
  public final byte[] atw(String paramString)
  {
    AppMethodBeat.i(148974);
    paramString = c.p.dj(paramString);
    AppMethodBeat.o(148974);
    return paramString;
  }
  
  public final boolean cQ(Context paramContext)
  {
    AppMethodBeat.i(219076);
    boolean bool = NormsgDataProvider.cQ(paramContext);
    AppMethodBeat.o(219076);
    return bool;
  }
  
  public final String duI()
  {
    AppMethodBeat.i(148952);
    if (com.tencent.mm.ax.b.FU((String)com.tencent.mm.kernel.g.ajC().ajl().get(274436, null)))
    {
      ad.w("MicroMsg.NormsgSourceImpl", "*** point 0, explained by source code.");
      AppMethodBeat.o(148952);
      return "";
    }
    Object localObject2 = aj.getContext().getPackageManager().getInstalledPackages(0);
    Object localObject1 = new StringBuilder(8192);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((StringBuilder)localObject1).append(((PackageInfo)((Iterator)localObject2).next()).packageName).append('\n');
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(148952);
    return localObject1;
  }
  
  public final boolean duJ()
  {
    AppMethodBeat.i(148953);
    boolean bool = c.p.ab();
    AppMethodBeat.o(148953);
    return bool;
  }
  
  public final boolean duK()
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
      ad.printErrStackTrace("MicroMsg.NormsgSourceImpl", localThrowable, "unexpected error.", new Object[0]);
      AppMethodBeat.o(148954);
    }
    return false;
  }
  
  public final byte[] duO()
  {
    AppMethodBeat.i(148959);
    byte[] arrayOfByte = c.p.aa(0);
    AppMethodBeat.o(148959);
    return arrayOfByte;
  }
  
  public final byte[] duP()
  {
    AppMethodBeat.i(148975);
    Object localObject = new ByteArrayOutputStream();
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    com.tencent.d.e.a.e.fTR().Gv();
    Context localContext = aj.getContext();
    String str = q.cH(true);
    com.tencent.d.a.b local2 = new com.tencent.d.a.b()
    {
      public final boolean p(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        boolean bool = false;
        AppMethodBeat.i(148940);
        if (paramAnonymousInt == 0)
        {
          if ((paramAnonymousArrayOfByte != null) && (paramAnonymousArrayOfByte.length > 0)) {
            this.wtC.write(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
          }
          bool = true;
        }
        localCountDownLatch.countDown();
        AppMethodBeat.o(148940);
        return bool;
      }
    };
    com.tencent.d.b.c localc = new com.tencent.d.b.c(localContext);
    com.tencent.d.e.a.e.fTR().a(localContext, str, new d.1(local2, localc));
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
  
  public final boolean duQ()
  {
    AppMethodBeat.i(148978);
    boolean bool = c.p.ec();
    AppMethodBeat.o(148978);
    return bool;
  }
  
  public final byte[] duR()
  {
    AppMethodBeat.i(148979);
    byte[] arrayOfByte = c.p.ee();
    AppMethodBeat.o(148979);
    return arrayOfByte;
  }
  
  public final boolean duS()
  {
    AppMethodBeat.i(219059);
    boolean bool = c.p.al();
    AppMethodBeat.o(219059);
    return bool;
  }
  
  public final String duT()
  {
    AppMethodBeat.i(219060);
    String str = c.p.ef();
    AppMethodBeat.o(219060);
    return str;
  }
  
  public final String duU()
  {
    AppMethodBeat.i(219061);
    String str = c.p.eg();
    AppMethodBeat.o(219061);
    return str;
  }
  
  public final String duV()
  {
    AppMethodBeat.i(219062);
    String str = c.p.eh();
    AppMethodBeat.o(219062);
    return str;
  }
  
  public final com.tencent.mm.normsg.a duW()
  {
    return this;
  }
  
  public final com.tencent.mm.normsgext.a duX()
  {
    return this;
  }
  
  public final boolean dx(Object paramObject)
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
  
  public final String getDeviceId()
  {
    AppMethodBeat.i(219071);
    String str = q.aay();
    AppMethodBeat.o(219071);
    return str;
  }
  
  public final void io(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148970);
    c.p.df(paramString1, paramString2);
    AppMethodBeat.o(148970);
  }
  
  public final boolean k(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(219072);
    ax localax = ax.aQz(new StringBuilder("atadtsurt_").reverse().toString());
    if (!localax.encode(paramString, paramArrayOfByte))
    {
      AppMethodBeat.o(219072);
      return false;
    }
    boolean bool = localax.commit();
    AppMethodBeat.o(219072);
    return bool;
  }
  
  public final String pi(boolean paramBoolean)
  {
    AppMethodBeat.i(148951);
    String str = c.p.ac(",", paramBoolean);
    AppMethodBeat.o(148951);
    return str;
  }
  
  public final void w(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(219067);
    com.tencent.mm.plugin.report.service.g.yhR.c(paramInt1, paramInt2, paramInt3, paramInt4, true);
    AppMethodBeat.o(219067);
  }
  
  public final boolean z(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
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
package com.tencent.mm.plugin.normsg;

import android.content.Context;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.cp;
import com.tencent.mm.g.a.cp.b;
import com.tencent.mm.normsg.c.p;
import com.tencent.mm.normsgext.QValue;
import com.tencent.mm.normsgext.b.a;
import com.tencent.mm.plugin.normsg.c.k;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.czz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aj;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

 enum b
  implements com.tencent.mm.normsg.a, com.tencent.mm.normsgext.a, com.tencent.mm.plugin.normsg.a.a
{
  private static final aq wJj;
  private final String[] FaW;
  private final Map<String, String> FaX;
  
  static
  {
    AppMethodBeat.i(148981);
    wJi = new b("INSTANCE");
    wJk = new b[] { wJi };
    wJj = new aq("NormsgWorker");
    AppMethodBeat.o(148981);
  }
  
  private b()
  {
    AppMethodBeat.i(224269);
    this.FaW = new String[] { null };
    this.FaX = new ConcurrentHashMap();
    AppMethodBeat.o(224269);
  }
  
  private static String UD()
  {
    AppMethodBeat.i(148950);
    for (;;)
    {
      try
      {
        localObject = ((ConnectivityManager)ak.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (((NetworkInfo)localObject).getType() != 1) {
          continue;
        }
        localObject = "wifi";
      }
      catch (Exception localException)
      {
        Object localObject;
        ae.e("MicroMsg.NormsgSourceImpl", "getNetTypeStr: %s", new Object[] { bu.o(localException) });
        String str = "";
        continue;
      }
      AppMethodBeat.o(148950);
      return localObject;
      localObject = ((NetworkInfo)localObject).getSubtype();
    }
  }
  
  private static String auB(String paramString)
  {
    AppMethodBeat.i(148947);
    if (bu.isNullOrNil(paramString))
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
  
  public static boolean dyb()
  {
    AppMethodBeat.i(148955);
    boolean bool = c.p.ah();
    ae.i("MicroMsg.NormsgSourceImpl", "[tomys-edt] alpha tom: %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(148955);
    return bool;
  }
  
  public static boolean dyc()
  {
    AppMethodBeat.i(148956);
    boolean bool = c.p.ai();
    ae.i("MicroMsg.NormsgSourceImpl", "[tomys-edt] bravo jerry: %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(148956);
    return bool;
  }
  
  public static boolean dyd()
  {
    AppMethodBeat.i(148957);
    boolean bool = c.p.aj();
    ae.i("MicroMsg.NormsgSourceImpl", "[tomys-edt] charlie brown: %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(148957);
    return bool;
  }
  
  private static String gP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148948);
    localObject1 = "";
    Object localObject2 = ak.getContext().getPackageManager();
    try
    {
      localObject2 = ((PackageManager)localObject2).getPackageInfo(ak.getPackageName(), 0);
      if (localObject2 != null) {
        localObject1 = ((PackageInfo)localObject2).applicationInfo.sourceDir;
      }
      try
      {
        localObject2 = com.tencent.mm.d.c.B(new File((String)localObject1));
        localObject1 = localObject2;
        if (bu.isNullOrNil((String)localObject2))
        {
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(322L, 13L, 1L, true);
          com.tencent.mm.plugin.report.e.ywz.f(11098, new Object[] { Integer.valueOf(4013), String.format("%s|%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }) });
          localObject1 = localObject2;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject3;
          ae.w("MicroMsg.NormsgSourceImpl", "summertoken getSecurityCode e: " + localException.getMessage());
          localObject1 = "0";
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(322L, 12L, 1L, true);
          com.tencent.mm.plugin.report.e.ywz.f(11098, new Object[] { Integer.valueOf(4012), String.format("%s|%s|%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localException.getMessage() }) });
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
        ae.w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + ak.getPackageName());
      }
    }
  }
  
  private static int getVersionCode()
  {
    int i = 0;
    AppMethodBeat.i(148949);
    Object localObject1 = ak.getContext().getPackageManager();
    try
    {
      localObject1 = ((PackageManager)localObject1).getPackageInfo(ak.getPackageName(), 0);
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
        ae.w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + ak.getPackageName());
      }
    }
  }
  
  public final boolean A(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148977);
    boolean bool = c.p.eb(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(148977);
    return bool;
  }
  
  public final String H(Context paramContext, String paramString)
  {
    AppMethodBeat.i(189723);
    String str = (String)this.FaX.get(paramString);
    Object localObject = str;
    if (str == null)
    {
      paramContext = NormsgDataProvider.H(paramContext, paramString);
      localObject = paramContext;
      if (!TextUtils.isEmpty(paramContext))
      {
        this.FaX.put(paramString, paramContext);
        localObject = paramContext;
      }
    }
    paramContext = bu.nullAsNil((String)localObject);
    AppMethodBeat.o(189723);
    return paramContext;
  }
  
  public final byte[] IZ(String paramString)
  {
    AppMethodBeat.i(189721);
    paramString = ay.aRW(new StringBuilder("atadtsurt_").reverse().toString()).decodeBytes(paramString);
    AppMethodBeat.o(189721);
    return paramString;
  }
  
  public final void Ja(String paramString)
  {
    AppMethodBeat.i(189722);
    ay.aRW(new StringBuilder("atadtsurt_").reverse().toString()).remove(paramString).commit();
    AppMethodBeat.o(189722);
  }
  
  public final byte[] MC(int paramInt)
  {
    AppMethodBeat.i(148943);
    byte[] arrayOfByte = c.p.aa(paramInt);
    AppMethodBeat.o(148943);
    return arrayOfByte;
  }
  
  public final String MD(int paramInt)
  {
    AppMethodBeat.i(148946);
    Object localObject2 = "";
    if (com.tencent.mm.kernel.g.ajM()) {
      localObject2 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(79, "");
    }
    com.tencent.mm.kernel.g.ajU().n(new b.1(this), 5000L);
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
    if (com.tencent.mm.kernel.g.ajM())
    {
      if (com.tencent.mm.kernel.g.ajR().gDX.JjJ.Jjb) {
        str1 = "1";
      }
    }
    else
    {
      Context localContext = ak.getContext().getApplicationContext();
      String str3 = az.ja(localContext);
      String str4 = az.jb(localContext);
      localObject1 = ak.getContext();
      if (localObject1 != null) {
        break label1250;
      }
      ae.w("MicroMsg.NormsgSourceImpl", "Failed checking mock location: application context not initialized.");
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
      if ((!com.tencent.mm.plugin.normsg.c.g.wKM) && (!com.tencent.mm.plugin.normsg.c.g.wKN) && (!com.tencent.mm.plugin.normsg.c.g.wKO)) {
        break label1286;
      }
      m = 1;
      if (!com.tencent.mm.plugin.normsg.c.f.wKI) {
        break label1292;
      }
      n = 1;
      if (!com.tencent.mm.plugin.normsg.c.h.wKP) {
        break label1298;
      }
      i1 = 1;
      localObject1 = c.p.ad();
      if (localObject1 == null) {
        break label1304;
      }
      localObject1 = com.tencent.mm.plugin.normsg.c.d.B((byte[])localObject1, 0, localObject1.length);
      i2 = getVersionCode();
      str2 = gP(i2, paramInt);
      Map localMap = q.aaP();
      localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = localStringBuilder1.append("<softtype><lctmoc>").append(i).append("</lctmoc><level>").append(j).append("</level>").append((String)localObject2).append("<k1>");
      localObject3 = (String)localMap.get("model name");
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = q.aaO()[0];
      }
      localStringBuilder2 = localStringBuilder2.append(auB((String)localObject2)).append("</k1><k2>").append(auB(q.aaN())).append("</k2><k3>").append(auB(Build.VERSION.RELEASE)).append("</k3><k4>").append(auB(q.cH(true))).append("</k4><k5>").append(auB(q.aaB())).append("</k5><k6>").append(auB(q.aaD())).append("</k6><k7>").append(auB(q.getAndroidId())).append("</k7><k8>").append(auB(q.aaC())).append("</k8><k9>").append(auB(Build.MODEL)).append("</k9><k10>").append(q.aaQ()).append("</k10><k11>").append(bu.nullAsNil(auB((String)localMap.get("hardware")))).append("</k11><k12>").append(bu.nullAsNil(auB((String)localMap.get("revision")))).append("</k12><k13>").append(bu.nullAsNil(auB((String)localMap.get("serial")))).append("</k13><k14>").append(auB(q.aaE())).append("</k14><k15>").append(auB(q.aaF())).append("</k15><k16>");
      localObject3 = (String)localMap.get("features");
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = (String)localMap.get("flags");
      }
      localObject2 = localStringBuilder2.append(bu.nullAsNil(auB((String)localObject2))).append("</k16><k18>").append((String)localObject1).append("</k18><k21>").append(bu.nullAsNil(auB(str3))).append("</k21><k22>").append(bu.nullAsNil(auB(q.bY(localContext)))).append("</k22><k24>").append(bu.nullAsNil(auB(str4))).append("</k24><k26>").append(k).append("</k26><k30>");
      localObject1 = ((ConnectivityManager)ak.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
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
      localObject3 = ((StringBuilder)localObject2).append(bu.nullAsNil(auB((String)localObject1))).append("</k30><k33>").append(auB(ak.getPackageName())).append("</k33><k34>").append(bu.nullAsNil(auB(af.get("ro.build.fingerprint")))).append("</k34><k35>").append(bu.nullAsNil(auB(Build.BOARD))).append("</k35><k36>").append(bu.nullAsNil(auB(Build.BOOTLOADER))).append("</k36><k37>").append(bu.nullAsNil(auB(Build.BRAND))).append("</k37><k38>").append(bu.nullAsNil(auB(Build.DEVICE))).append("</k38><k39>").append(bu.nullAsNil(auB(Build.HARDWARE))).append("</k39><k40>").append(bu.nullAsNil(auB(Build.PRODUCT))).append("</k40><k41>").append(m).append("</k41><k42>").append(bu.nullAsNil(auB(af.get("ro.product.manufacturer")))).append("</k42><k43>").append(Settings.System.getString(ak.getContext().getContentResolver(), "89884a87498ef44f")).append("</k43><k44>0</k44><k45>");
      ae.d("MicroMsg.NormsgSourceImpl", "READ_PHONE_STATE.getLine1Number %s", new Object[] { bu.fpN() });
      localObject2 = bu.nullAsNil(bu.jl(ak.getContext()));
      localObject1 = localObject2;
      if (((String)localObject2).length() > 0) {
        localObject1 = com.tencent.mm.b.g.getMessageDigest(((String)localObject2).getBytes());
      }
      localObject1 = ((StringBuilder)localObject3).append((String)localObject1).append("</k45><k46>").append(str1).append("</k46><k47>").append(auB(UD())).append("</k47><k48>").append(q.cH(true)).append("</k48><k49>").append(com.tencent.mm.loader.j.b.asa()).append("</k49><k52>").append(n).append("</k52><k53>").append(i1).append("</k53><k57>").append(i2).append("</k57><k58>").append(bu.nullAsNil(auB(str2))).append("</k58><k59>").append(paramInt).append("</k59><k60>").append(auB(j.IwE.getString("FEATURE_ID"))).append("</k60><k61>").append(q.aaJ()).append("</k61><k62>");
      str1 = com.tencent.mm.plugin.soter.d.d.ejm().AXb;
      if (str1 != null) {}
      for (;;)
      {
        ((StringBuilder)localObject1).append(str1).append("</k62><k63>").append(q.aaH()).append("</k63><k64>").append(q.aaK()).append("</k64><k65>").append(q.aaL()).append("</k65></softtype>");
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
  
  public final void ME(int paramInt)
  {
    AppMethodBeat.i(148962);
    com.tencent.mm.plugin.normsg.c.a.dyo().ME(paramInt);
    AppMethodBeat.o(148962);
  }
  
  public final byte[] MF(int paramInt)
  {
    AppMethodBeat.i(148976);
    byte[] arrayOfByte = c.p.ea(paramInt);
    AppMethodBeat.o(148976);
    return arrayOfByte;
  }
  
  public final void N(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(189714);
    com.tencent.mm.plugin.report.service.g.yxI.n(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(189714);
  }
  
  public final void O(int paramInt, String paramString)
  {
    AppMethodBeat.i(189713);
    com.tencent.mm.plugin.report.service.g.yxI.kvStat(paramInt, paramString);
    AppMethodBeat.o(189713);
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
      paramArrayOfByte = new czz();
      paramArrayOfByte.HJv = ((Integer)localQValue1.getValue(Integer.valueOf(0))).intValue();
      paramArrayOfByte.HJw = ((Integer)localQValue2.getValue(Integer.valueOf(0))).intValue();
      paramArrayOfByte.HJx = com.tencent.mm.bw.b.cm((byte[])localQValue3.value);
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
        ae.e("MicroMsg.NormsgSourceImpl", "[-] pb deseralize failed");
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
  
  public final String aPT()
  {
    AppMethodBeat.i(189711);
    synchronized (this.FaW)
    {
      if (this.FaW[0] == null)
      {
        ae.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src rf.");
        localObject1 = com.tencent.mm.lib.riskscanner.a.a.cq(ak.getContext());
        if ((localObject1 != null) && (((Bundle)localObject1).getInt("errCode", -100) == 0))
        {
          localObject1 = ((Bundle)localObject1).getByteArray("reqBufferBase64");
          if (localObject1 != null) {
            this.FaW[0] = Base64.encodeToString((byte[])localObject1, 2);
          }
        }
      }
      if (this.FaW[0] != null)
      {
        localObject1 = this.FaW[0];
        AppMethodBeat.o(189711);
        return localObject1;
      }
      Object localObject1 = "";
    }
  }
  
  public final long aPU()
  {
    AppMethodBeat.i(189712);
    long l = com.tencent.mm.plugin.normsg.c.a.dyo().dyp();
    AppMethodBeat.o(189712);
    return l;
  }
  
  public final String aPV()
  {
    AppMethodBeat.i(189716);
    String str = com.tencent.mm.plugin.soter.d.d.ejm().AXb;
    if (str != null)
    {
      AppMethodBeat.o(189716);
      return str;
    }
    AppMethodBeat.o(189716);
    return "";
  }
  
  public final boolean aPW()
  {
    AppMethodBeat.i(189717);
    boolean bool = k.isConnected();
    AppMethodBeat.o(189717);
    return bool;
  }
  
  public final String aPX()
  {
    AppMethodBeat.i(189718);
    String str = com.tencent.mm.plugin.soter.d.d.ejm().AXc;
    if (str != null)
    {
      AppMethodBeat.o(189718);
      return str;
    }
    AppMethodBeat.o(189718);
    return "";
  }
  
  public final boolean aPY()
  {
    AppMethodBeat.i(189726);
    try
    {
      String str1 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(274436, null);
      if (!TextUtils.isEmpty(str1))
      {
        boolean bool = com.tencent.mm.plugin.normsg.c.e.auL(str1);
        AppMethodBeat.o(189726);
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.NormsgSourceImpl", localThrowable, "[-] Error happened.", new Object[0]);
        String str2 = ay.aRW("mmkv_crossprocess_infos").decodeString("mmkv_key_user_reg_ic", null);
      }
      AppMethodBeat.o(189726);
    }
    return false;
  }
  
  public final String aaL()
  {
    AppMethodBeat.i(148980);
    try
    {
      Object localObject = com.tencent.d.e.b.a.a.b.kZ(ak.getContext());
      if (((com.tencent.d.e.b.a.a.c)localObject).errorCode == 0)
      {
        localObject = bu.nullAsNil(((com.tencent.d.e.b.a.a.c)localObject).zmV);
        AppMethodBeat.o(148980);
        return localObject;
      }
      ae.e("MicroMsg.NormsgSourceImpl", "[-] Fail to get OAID, errorcode: %s", new Object[] { Integer.valueOf(((com.tencent.d.e.b.a.a.c)localObject).errorCode) });
      AppMethodBeat.o(148980);
      return "";
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace("MicroMsg.NormsgSourceImpl", localThrowable, "Fail to get OAID.", new Object[0]);
      AppMethodBeat.o(148980);
    }
    return "";
  }
  
  public final void ao(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(148944);
    Object localObject = ak.getContext();
    if ((paramInt2 <= 0) || (paramInt2 > 4))
    {
      localObject = new IllegalArgumentException("action invalid: ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(148944);
      throw ((Throwable)localObject);
    }
    localObject = new d.a((Context)localObject, paramInt1, paramInt2, (byte)0);
    long l = paramInt3 * 1000;
    if (l < com.tencent.d.e.a.a.f.Mku) {
      ((d.a)localObject).BXa = com.tencent.d.e.a.a.f.Mku;
    }
    for (;;)
    {
      ((d.a)localObject).BXa = l;
      localObject = new com.tencent.d.e.a.d((d.a)localObject, (byte)0);
      com.tencent.d.e.a.e.fYr().a((com.tencent.d.e.a.d)localObject);
      AppMethodBeat.o(148944);
      return;
      if (l > com.tencent.d.e.a.a.f.Mkr * 12L) {
        ((d.a)localObject).BXa = (com.tencent.d.e.a.a.f.Mkr * 12L);
      }
    }
  }
  
  public final String auA(String paramString)
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
  
  public final void auC(String paramString)
  {
    AppMethodBeat.i(148965);
    c.p.da(paramString);
    AppMethodBeat.o(148965);
  }
  
  public final void auD(String paramString)
  {
    AppMethodBeat.i(148966);
    c.p.db(paramString);
    AppMethodBeat.o(148966);
  }
  
  public final void auE(String paramString)
  {
    AppMethodBeat.i(148967);
    c.p.dc(paramString);
    AppMethodBeat.o(148967);
  }
  
  public final boolean auF(String paramString)
  {
    AppMethodBeat.i(148968);
    boolean bool = c.p.dd(paramString);
    AppMethodBeat.o(148968);
    return bool;
  }
  
  public final byte[] auG(String paramString)
  {
    AppMethodBeat.i(148969);
    paramString = c.p.de(paramString);
    AppMethodBeat.o(148969);
    return paramString;
  }
  
  public final void auH(String paramString)
  {
    AppMethodBeat.i(148972);
    c.p.dh(paramString);
    AppMethodBeat.o(148972);
  }
  
  public final boolean auI(String paramString)
  {
    AppMethodBeat.i(148973);
    boolean bool = c.p.di(paramString);
    AppMethodBeat.o(148973);
    return bool;
  }
  
  public final byte[] auJ(String paramString)
  {
    AppMethodBeat.i(148974);
    paramString = c.p.dj(paramString);
    AppMethodBeat.o(148974);
    return paramString;
  }
  
  public final String[] auK(String paramString)
  {
    AppMethodBeat.i(189725);
    cp localcp = new cp();
    localcp.doA.path = paramString;
    com.tencent.mm.sdk.b.a.IvT.l(localcp);
    if (localcp.doB.doC != null)
    {
      paramString = localcp.doB.doC;
      AppMethodBeat.o(189725);
      return paramString;
    }
    if (localcp.doB.cYg)
    {
      AppMethodBeat.o(189725);
      return new String[] { "<timeout>" };
    }
    AppMethodBeat.o(189725);
    return null;
  }
  
  public final boolean cS(Context paramContext)
  {
    AppMethodBeat.i(189724);
    boolean bool = NormsgDataProvider.cS(paramContext);
    AppMethodBeat.o(189724);
    return bool;
  }
  
  public final void dWk()
  {
    AppMethodBeat.i(224270);
    ae.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src i1.");
    Object localObject = ak.getContext();
    if (localObject == null)
    {
      if ((j.DEBUG) || (com.tencent.mm.sdk.a.b.fnF()))
      {
        localObject = new IllegalStateException("MMApplicationContext has not been initialized.");
        AppMethodBeat.o(224270);
        throw ((Throwable)localObject);
      }
      ae.e("MicroMsg.NormsgSourceImpl", "[-] MMApplicationContext has not been initialized.");
      AppMethodBeat.o(224270);
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addDataScheme("package");
    ((Context)localObject).registerReceiver(new b.3(this), localIntentFilter);
    AppMethodBeat.o(224270);
  }
  
  public final String dxY()
  {
    AppMethodBeat.i(148952);
    if (com.tencent.mm.plugin.normsg.c.e.auL((String)com.tencent.mm.kernel.g.ajR().ajA().get(274436, null)))
    {
      ae.w("MicroMsg.NormsgSourceImpl", "*** point 0, explained by source code.");
      AppMethodBeat.o(148952);
      return "";
    }
    Object localObject2 = ak.getContext().getPackageManager().getInstalledPackages(0);
    Object localObject1 = new StringBuilder(8192);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((StringBuilder)localObject1).append(((PackageInfo)((Iterator)localObject2).next()).packageName).append('\n');
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(148952);
    return localObject1;
  }
  
  public final boolean dxZ()
  {
    AppMethodBeat.i(148953);
    boolean bool = c.p.ab();
    AppMethodBeat.o(148953);
    return bool;
  }
  
  public final boolean dy(Object paramObject)
  {
    AppMethodBeat.i(148960);
    boolean bool = c.p.cb(paramObject);
    AppMethodBeat.o(148960);
    return bool;
  }
  
  public final boolean dya()
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
      ae.printErrStackTrace("MicroMsg.NormsgSourceImpl", localThrowable, "unexpected error.", new Object[0]);
      AppMethodBeat.o(148954);
    }
    return false;
  }
  
  public final byte[] dye()
  {
    AppMethodBeat.i(148959);
    byte[] arrayOfByte = c.p.aa(0);
    AppMethodBeat.o(148959);
    return arrayOfByte;
  }
  
  public final byte[] dyf()
  {
    AppMethodBeat.i(148975);
    Object localObject = new ByteArrayOutputStream();
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    com.tencent.d.e.a.e.fYr().GB();
    Context localContext = ak.getContext();
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
            this.wJm.write(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
          }
          bool = true;
        }
        localCountDownLatch.countDown();
        AppMethodBeat.o(148940);
        return bool;
      }
    };
    com.tencent.d.b.c localc = new com.tencent.d.b.c(localContext);
    com.tencent.d.e.a.e.fYr().a(localContext, str, new d.1(local2, localc));
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
  
  public final boolean dyg()
  {
    AppMethodBeat.i(148978);
    boolean bool = c.p.ec();
    AppMethodBeat.o(148978);
    return bool;
  }
  
  public final byte[] dyh()
  {
    AppMethodBeat.i(148979);
    byte[] arrayOfByte = c.p.ee();
    AppMethodBeat.o(148979);
    return arrayOfByte;
  }
  
  public final boolean dyi()
  {
    AppMethodBeat.i(189707);
    boolean bool = c.p.al();
    AppMethodBeat.o(189707);
    return bool;
  }
  
  public final String dyj()
  {
    AppMethodBeat.i(189708);
    String str = c.p.ef();
    AppMethodBeat.o(189708);
    return str;
  }
  
  public final String dyk()
  {
    AppMethodBeat.i(189709);
    String str = c.p.eg();
    AppMethodBeat.o(189709);
    return str;
  }
  
  public final String dyl()
  {
    AppMethodBeat.i(189710);
    String str = c.p.eh();
    AppMethodBeat.o(189710);
    return str;
  }
  
  public final com.tencent.mm.normsg.a dym()
  {
    return this;
  }
  
  public final com.tencent.mm.normsgext.a dyn()
  {
    return this;
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
    AppMethodBeat.i(189719);
    String str = q.aaH();
    AppMethodBeat.o(189719);
    return str;
  }
  
  public final void iu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148970);
    c.p.df(paramString1, paramString2);
    AppMethodBeat.o(148970);
  }
  
  public final boolean k(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189720);
    ay localay = ay.aRW(new StringBuilder("atadtsurt_").reverse().toString());
    if (!localay.encode(paramString, paramArrayOfByte))
    {
      AppMethodBeat.o(189720);
      return false;
    }
    boolean bool = localay.commit();
    AppMethodBeat.o(189720);
    return bool;
  }
  
  public final String pq(boolean paramBoolean)
  {
    AppMethodBeat.i(148951);
    String str = c.p.ac(",", paramBoolean);
    AppMethodBeat.o(148951);
    return str;
  }
  
  public final void w(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(189715);
    com.tencent.mm.plugin.report.service.g.yxI.c(paramInt1, paramInt2, paramInt3, paramInt4, true);
    AppMethodBeat.o(189715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b
 * JD-Core Version:    0.7.0.1
 */
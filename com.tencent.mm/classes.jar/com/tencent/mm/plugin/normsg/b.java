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
import com.tencent.e.e.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.compatible.e.ad;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.storage.z;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

 enum b
  implements com.tencent.mm.plugin.normsg.a.a
{
  private static final al pgH;
  
  static
  {
    AppMethodBeat.i(10349);
    pgG = new b("INSTANCE");
    pgI = new b[] { pgG };
    pgH = new al("NormsgWorker");
    AppMethodBeat.o(10349);
  }
  
  private b() {}
  
  private static String We(String paramString)
  {
    AppMethodBeat.i(10322);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(10322);
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
    AppMethodBeat.o(10322);
    return paramString;
  }
  
  private static String bXn()
  {
    AppMethodBeat.i(10325);
    for (;;)
    {
      try
      {
        localObject = ((ConnectivityManager)ah.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (((NetworkInfo)localObject).getType() != 1) {
          continue;
        }
        localObject = "wifi";
      }
      catch (Exception localException)
      {
        Object localObject;
        ab.e("MicroMsg.NormsgSourceImpl", "getNetTypeStr: %s", new Object[] { bo.l(localException) });
        String str = "";
        continue;
      }
      AppMethodBeat.o(10325);
      return localObject;
      localObject = ((NetworkInfo)localObject).getSubtype();
    }
  }
  
  private static String eT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(10323);
    localObject1 = "";
    Object localObject2 = ah.getContext().getPackageManager();
    try
    {
      localObject2 = ((PackageManager)localObject2).getPackageInfo(ah.getPackageName(), 0);
      if (localObject2 != null) {
        localObject1 = ((PackageInfo)localObject2).applicationInfo.sourceDir;
      }
      try
      {
        localObject2 = com.tencent.mm.c.c.u(new File((String)localObject1));
        localObject1 = localObject2;
        if (bo.isNullOrNil((String)localObject2))
        {
          com.tencent.mm.plugin.report.e.qrI.idkeyStat(322L, 13L, 1L, true);
          com.tencent.mm.plugin.report.e.qrI.e(11098, new Object[] { Integer.valueOf(4013), String.format("%s|%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }) });
          localObject1 = localObject2;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject3;
          ab.w("MicroMsg.NormsgSourceImpl", "summertoken getSecurityCode e: " + localException.getMessage());
          localObject1 = "0";
          com.tencent.mm.plugin.report.e.qrI.idkeyStat(322L, 12L, 1L, true);
          com.tencent.mm.plugin.report.e.qrI.e(11098, new Object[] { Integer.valueOf(4012), String.format("%s|%s|%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localException.getMessage() }) });
        }
      }
      AppMethodBeat.o(10323);
      return localObject1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localObject3 = null;
        ab.w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + ah.getPackageName());
      }
    }
  }
  
  private static int getVersionCode()
  {
    int i = 0;
    AppMethodBeat.i(10324);
    Object localObject1 = ah.getContext().getPackageManager();
    try
    {
      localObject1 = ((PackageManager)localObject1).getPackageInfo(ah.getPackageName(), 0);
      if (localObject1 != null) {
        i = ((PackageInfo)localObject1).versionCode;
      }
      AppMethodBeat.o(10324);
      return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Object localObject2 = null;
        ab.w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + ah.getPackageName());
      }
    }
  }
  
  public final byte[] AO(int paramInt)
  {
    AppMethodBeat.i(10317);
    byte[] arrayOfByte = Normsg.b.AL(paramInt);
    AppMethodBeat.o(10317);
    return arrayOfByte;
  }
  
  public final String AP(int paramInt)
  {
    AppMethodBeat.i(10321);
    Object localObject2 = "";
    if (com.tencent.mm.kernel.g.RG()) {
      localObject2 = (String)com.tencent.mm.kernel.g.RL().Ru().get(79, "");
    }
    com.tencent.mm.kernel.g.RO().o(new b.1(this), 5000L);
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
    if (com.tencent.mm.kernel.g.RG())
    {
      if (com.tencent.mm.kernel.g.RL().eHS.yQQ.yQl) {
        str1 = "1";
      }
    }
    else
    {
      Context localContext = ah.getContext().getApplicationContext();
      String str3 = at.gX(localContext);
      String str4 = at.gY(localContext);
      localObject1 = ah.getContext();
      if (localObject1 != null) {
        break label1219;
      }
      ab.w("MicroMsg.NormsgSourceImpl", "Failed checking mock location: application context not initialized.");
      i = 0;
      if (i == 0) {
        break label1239;
      }
      i = 1;
      if (!Normsg.b.bXh()) {
        break label1244;
      }
      j = 1;
      if (!Debug.isDebuggerConnected()) {
        break label1249;
      }
      k = 1;
      if ((!com.tencent.mm.plugin.normsg.b.f.pii) && (!com.tencent.mm.plugin.normsg.b.f.pij) && (!com.tencent.mm.plugin.normsg.b.f.pik)) {
        break label1255;
      }
      m = 1;
      if (!com.tencent.mm.plugin.normsg.b.e.pie) {
        break label1261;
      }
      n = 1;
      if (!com.tencent.mm.plugin.normsg.b.g.pil) {
        break label1267;
      }
      i1 = 1;
      localObject1 = Normsg.b.bXi();
      if (localObject1 == null) {
        break label1273;
      }
      localObject1 = com.tencent.mm.plugin.normsg.b.d.w((byte[])localObject1, 0, localObject1.length);
      i2 = getVersionCode();
      str2 = eT(i2, paramInt);
      Map localMap = q.LR();
      localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = localStringBuilder1.append("<softtype><lctmoc>").append(i).append("</lctmoc><level>").append(j).append("</level>").append((String)localObject2).append("<k1>");
      localObject3 = (String)localMap.get("model name");
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = q.LQ()[0];
      }
      localStringBuilder2 = localStringBuilder2.append(We((String)localObject2)).append("</k1><k2>").append(We(q.LP())).append("</k2><k3>").append(We(Build.VERSION.RELEASE)).append("</k3><k4>").append(We(q.bP(true))).append("</k4><k5>").append(We(q.LE())).append("</k5><k6>").append(We(q.LG())).append("</k6><k7>").append(We(q.getAndroidId())).append("</k7><k8>").append(We(q.LF())).append("</k8><k9>").append(We(Build.MODEL)).append("</k9><k10>").append(q.LS()).append("</k10><k11>").append(bo.nullAsNil(We((String)localMap.get("hardware")))).append("</k11><k12>").append(bo.nullAsNil(We((String)localMap.get("revision")))).append("</k12><k13>").append(bo.nullAsNil(We((String)localMap.get("serial")))).append("</k13><k14>").append(We(q.LH())).append("</k14><k15>").append(We(q.LI())).append("</k15><k16>");
      localObject3 = (String)localMap.get("features");
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = (String)localMap.get("flags");
      }
      localObject2 = localStringBuilder2.append(bo.nullAsNil(We((String)localObject2))).append("</k16><k18>").append((String)localObject1).append("</k18><k21>").append(bo.nullAsNil(We(str3))).append("</k21><k22>").append(bo.nullAsNil(We(q.bG(localContext)))).append("</k22><k24>").append(bo.nullAsNil(We(str4))).append("</k24><k26>").append(k).append("</k26><k30>");
      localObject1 = ((ConnectivityManager)ah.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localObject1 == null) {
        break label1287;
      }
    }
    label1287:
    for (Object localObject1 = ((NetworkInfo)localObject1).getExtraInfo();; localObject1 = null)
    {
      localObject3 = ((StringBuilder)localObject2).append(bo.nullAsNil(We((String)localObject1))).append("</k30><k33>").append(We(ah.getPackageName())).append("</k33><k34>").append(bo.nullAsNil(We(ad.get("ro.build.fingerprint")))).append("</k34><k35>").append(bo.nullAsNil(We(Build.BOARD))).append("</k35><k36>").append(bo.nullAsNil(We(Build.BOOTLOADER))).append("</k36><k37>").append(bo.nullAsNil(We(Build.BRAND))).append("</k37><k38>").append(bo.nullAsNil(We(Build.DEVICE))).append("</k38><k39>").append(bo.nullAsNil(We(Build.HARDWARE))).append("</k39><k40>").append(bo.nullAsNil(We(Build.PRODUCT))).append("</k40><k41>").append(m).append("</k41><k42>").append(bo.nullAsNil(We(ad.get("ro.product.manufacturer")))).append("</k42><k43>").append(Settings.System.getString(ah.getContext().getContentResolver(), "89884a87498ef44f")).append("</k43><k44>0</k44><k45>");
      localObject2 = bo.nullAsNil(bo.hh(ah.getContext()));
      localObject1 = localObject2;
      if (((String)localObject2).length() > 0) {
        localObject1 = com.tencent.mm.a.g.w(((String)localObject2).getBytes());
      }
      localObject1 = ((StringBuilder)localObject3).append((String)localObject1).append("</k45><k46>").append(str1).append("</k46><k47>").append(We(bXn())).append("</k47><k48>").append(q.bP(true)).append("</k48><k49>").append(com.tencent.mm.compatible.util.e.eQu).append("</k49><k52>").append(n).append("</k52><k53>").append(i1).append("</k53><k57>").append(i2).append("</k57><k58>").append(bo.nullAsNil(We(str2))).append("</k58><k59>").append(paramInt).append("</k59><k60>").append(We(com.tencent.mm.sdk.platformtools.f.ymH.getString("FEATURE_ID"))).append("</k60><k61>").append(q.LM()).append("</k61><k62>");
      str1 = com.tencent.mm.plugin.soter.d.d.cyc().son;
      if (str1 != null) {}
      for (;;)
      {
        ((StringBuilder)localObject1).append(str1).append("</k62><k63>").append(q.LK()).append("</k63><k64>").append(q.LN()).append("</k64></softtype>");
        str1 = localStringBuilder1.toString();
        AppMethodBeat.o(10321);
        return str1;
        str1 = "0";
        break;
        label1219:
        if (Settings.Secure.getInt(((Context)localObject1).getContentResolver(), "mock_location", 0) == 0) {
          break label122;
        }
        i = 1;
        break label124;
        label1239:
        i = 0;
        break label130;
        label1244:
        j = 0;
        break label138;
        label1249:
        k = 0;
        break label147;
        label1255:
        m = 0;
        break label168;
        label1261:
        n = 0;
        break label177;
        label1267:
        i1 = 0;
        break label186;
        label1273:
        localObject1 = "";
        break label207;
        str1 = "";
      }
    }
  }
  
  public final void AQ(int paramInt)
  {
    AppMethodBeat.i(10337);
    com.tencent.mm.plugin.normsg.b.a.bXr().AQ(paramInt);
    AppMethodBeat.o(10337);
  }
  
  public final void VV(String paramString)
  {
    AppMethodBeat.i(10339);
    Normsg.c.VV(paramString);
    AppMethodBeat.o(10339);
  }
  
  public final void VW(String paramString)
  {
    AppMethodBeat.i(10340);
    Normsg.c.VW(paramString);
    AppMethodBeat.o(10340);
  }
  
  public final void VX(String paramString)
  {
    AppMethodBeat.i(10341);
    Normsg.c.VX(paramString);
    AppMethodBeat.o(10341);
  }
  
  public final boolean VY(String paramString)
  {
    AppMethodBeat.i(10342);
    boolean bool = Normsg.c.VY(paramString);
    AppMethodBeat.o(10342);
    return bool;
  }
  
  public final byte[] VZ(String paramString)
  {
    AppMethodBeat.i(10343);
    paramString = Normsg.c.VZ(paramString);
    AppMethodBeat.o(10343);
    return paramString;
  }
  
  public final void Wa(String paramString)
  {
    AppMethodBeat.i(10346);
    Normsg.c.Wa(paramString);
    AppMethodBeat.o(10346);
  }
  
  public final boolean Wb(String paramString)
  {
    AppMethodBeat.i(10347);
    boolean bool = Normsg.c.Wb(paramString);
    AppMethodBeat.o(10347);
    return bool;
  }
  
  public final byte[] Wc(String paramString)
  {
    AppMethodBeat.i(10348);
    paramString = Normsg.c.Wc(paramString);
    AppMethodBeat.o(10348);
    return paramString;
  }
  
  public final String Wd(String paramString)
  {
    AppMethodBeat.i(10319);
    int j = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append((char)(paramString.charAt(i) ^ 0xFFFFFFA7 ^ (byte)(i + 1 ^ j ^ 0xFFFFFFFF)));
      i += 1;
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(10319);
    return paramString;
  }
  
  public final void a(View paramView, Class<? extends com.tencent.mm.sdk.b.b> paramClass)
  {
    AppMethodBeat.i(10336);
    com.tencent.mm.plugin.normsg.b.c.a(paramView, paramClass);
    AppMethodBeat.o(10336);
  }
  
  public final void a(String paramString, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(10345);
    Normsg.c.a(paramString, paramMotionEvent);
    AppMethodBeat.o(10345);
  }
  
  public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, PByteArray paramPByteArray)
  {
    AppMethodBeat.i(10338);
    boolean bool = Normsg.a.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPByteArray);
    AppMethodBeat.o(10338);
    return bool;
  }
  
  public final void ad(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(10318);
    Object localObject = ah.getContext();
    if ((paramInt2 <= 0) || (paramInt2 > 4))
    {
      localObject = new IllegalArgumentException("action invalid: ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(10318);
      throw ((Throwable)localObject);
    }
    localObject = new d.a((Context)localObject, paramInt1, paramInt2, (byte)0);
    long l = paramInt3 * 1000;
    if (l < com.tencent.e.e.a.a.f.BkS) {
      ((d.a)localObject).Bkx = com.tencent.e.e.a.a.f.BkS;
    }
    for (;;)
    {
      ((d.a)localObject).Bkx = l;
      localObject = new com.tencent.e.e.a.d((d.a)localObject, (byte)0);
      com.tencent.e.e.a.e.dUE().a((com.tencent.e.e.a.d)localObject);
      AppMethodBeat.o(10318);
      return;
      if (l > com.tencent.e.e.a.a.f.BkP * 12L) {
        ((d.a)localObject).Bkx = (com.tencent.e.e.a.a.f.BkP * 12L);
      }
    }
  }
  
  public final boolean bXh()
  {
    AppMethodBeat.i(10328);
    boolean bool = Normsg.b.bXh();
    AppMethodBeat.o(10328);
    return bool;
  }
  
  public final boolean bXk()
  {
    AppMethodBeat.i(10330);
    boolean bool = Normsg.b.bXk();
    ab.i("MicroMsg.NormsgSourceImpl", "[tomys-edt] alpha tom: %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(10330);
    return bool;
  }
  
  public final boolean bXl()
  {
    AppMethodBeat.i(10331);
    boolean bool = Normsg.b.bXl();
    ab.i("MicroMsg.NormsgSourceImpl", "[tomys-edt] bravo jerry: %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(10331);
    return bool;
  }
  
  public final boolean bXm()
  {
    AppMethodBeat.i(10332);
    boolean bool = Normsg.b.bXm();
    ab.i("MicroMsg.NormsgSourceImpl", "[tomys-edt] charlie brown: %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(10332);
    return bool;
  }
  
  public final String bXo()
  {
    AppMethodBeat.i(10327);
    if (com.tencent.mm.au.b.tM((String)com.tencent.mm.kernel.g.RL().Ru().get(274436, null)))
    {
      ab.w("MicroMsg.NormsgSourceImpl", "*** point 0, explained by source code.");
      AppMethodBeat.o(10327);
      return "";
    }
    Object localObject2 = ah.getContext().getPackageManager().getInstalledPackages(0);
    Object localObject1 = new StringBuilder(8192);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((StringBuilder)localObject1).append(((PackageInfo)((Iterator)localObject2).next()).packageName).append('\n');
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(10327);
    return localObject1;
  }
  
  public final boolean bXp()
  {
    AppMethodBeat.i(10329);
    try
    {
      boolean bool = Normsg.b.bXj();
      AppMethodBeat.o(10329);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("MicroMsg.NormsgSourceImpl", localThrowable, "unexpected error.", new Object[0]);
      AppMethodBeat.o(10329);
    }
    return false;
  }
  
  public final byte[] bXq()
  {
    AppMethodBeat.i(10334);
    byte[] arrayOfByte = Normsg.b.AL(0);
    AppMethodBeat.o(10334);
    return arrayOfByte;
  }
  
  public final boolean bY(Object paramObject)
  {
    AppMethodBeat.i(10335);
    boolean bool = Normsg.d.bY(paramObject);
    AppMethodBeat.o(10335);
    return bool;
  }
  
  public final boolean d(Object paramObject, Class paramClass)
  {
    AppMethodBeat.i(10333);
    boolean bool = Normsg.d.c(paramObject, paramClass);
    AppMethodBeat.o(10333);
    return bool;
  }
  
  public final void fD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10344);
    Normsg.c.fD(paramString1, paramString2);
    AppMethodBeat.o(10344);
  }
  
  public final String jU(boolean paramBoolean)
  {
    AppMethodBeat.i(10326);
    String str = Normsg.b.bf(",", paramBoolean);
    AppMethodBeat.o(10326);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b
 * JD-Core Version:    0.7.0.1
 */
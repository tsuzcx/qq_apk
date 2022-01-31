package com.tencent.mm.plugin.normsg;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Debug;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.d.e.a.d.a;
import com.tencent.mm.cf.h;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.storage.z;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

 enum b
  implements com.tencent.mm.plugin.normsg.a.a
{
  private static final ai mGB = new ai("NormsgWorker");
  
  private b() {}
  
  private static String Ke(String paramString)
  {
    if (bk.bl(paramString)) {
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
    return localStringBuilder.toString();
  }
  
  private static String boM()
  {
    try
    {
      Object localObject = ((ConnectivityManager)ae.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (((NetworkInfo)localObject).getType() == 1) {
        return "wifi";
      }
      localObject = ((NetworkInfo)localObject).getSubtype();
      return localObject;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NormsgSourceImpl", "getNetTypeStr: %s", new Object[] { bk.j(localException) });
    }
    return "";
  }
  
  private static String dt(int paramInt1, int paramInt2)
  {
    Object localObject3 = "";
    Object localObject1 = ae.getContext().getPackageManager();
    try
    {
      localObject1 = ((PackageManager)localObject1).getPackageInfo(ae.getPackageName(), 0);
      if (localObject1 != null) {
        localObject1 = ((PackageInfo)localObject1).applicationInfo.sourceDir;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        try
        {
          localObject1 = com.tencent.mm.c.c.p(new File((String)localObject1));
          localObject3 = localObject1;
          if (bk.bl((String)localObject1))
          {
            com.tencent.mm.plugin.report.f.nEG.a(322L, 13L, 1L, true);
            com.tencent.mm.plugin.report.f.nEG.f(11098, new Object[] { Integer.valueOf(4013), String.format("%s|%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }) });
            localObject3 = localObject1;
          }
          return localObject3;
        }
        catch (Exception localException)
        {
          Object localObject2;
          com.tencent.mm.sdk.platformtools.y.w("MicroMsg.NormsgSourceImpl", "summertoken getSecurityCode e: " + localException.getMessage());
          com.tencent.mm.plugin.report.f.nEG.a(322L, 12L, 1L, true);
          com.tencent.mm.plugin.report.f.nEG.f(11098, new Object[] { Integer.valueOf(4012), String.format("%s|%s|%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localException.getMessage() }) });
        }
        localNameNotFoundException = localNameNotFoundException;
        localObject2 = null;
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + ae.getPackageName());
      }
    }
    return "0";
  }
  
  private static int getVersionCode()
  {
    int i = 0;
    Object localObject1 = ae.getContext().getPackageManager();
    try
    {
      localObject1 = ((PackageManager)localObject1).getPackageInfo(ae.getPackageName(), 0);
      if (localObject1 != null) {
        i = ((PackageInfo)localObject1).versionCode;
      }
      return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Object localObject2 = null;
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + ae.getPackageName());
      }
    }
  }
  
  public final void JV(String paramString)
  {
    Normsg.c.JV(paramString);
  }
  
  public final void JW(String paramString)
  {
    Normsg.c.JW(paramString);
  }
  
  public final void JX(String paramString)
  {
    Normsg.c.JX(paramString);
  }
  
  public final boolean JY(String paramString)
  {
    return Normsg.c.JY(paramString);
  }
  
  public final byte[] JZ(String paramString)
  {
    return Normsg.c.JZ(paramString);
  }
  
  public final void Ka(String paramString)
  {
    Normsg.c.Ka(paramString);
  }
  
  public final boolean Kb(String paramString)
  {
    return Normsg.c.Kb(paramString);
  }
  
  public final byte[] Kc(String paramString)
  {
    return Normsg.c.Kc(paramString);
  }
  
  public final String Kd(String paramString)
  {
    int j = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append((char)(paramString.charAt(i) ^ 0xFFFFFFA7 ^ (byte)(i + 1 ^ j ^ 0xFFFFFFFF)));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public final void S(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = ae.getContext();
    if ((paramInt2 <= 0) || (paramInt2 > 4)) {
      throw new IllegalArgumentException("action invalid: " + paramInt2);
    }
    localObject = new d.a((Context)localObject, paramInt1, paramInt2, (byte)0);
    long l = paramInt3 * 1000;
    if (l < com.tencent.d.e.a.a.f.wNt) {
      ((d.a)localObject).wMY = com.tencent.d.e.a.a.f.wNt;
    }
    for (;;)
    {
      ((d.a)localObject).wMY = l;
      localObject = new com.tencent.d.e.a.d((d.a)localObject, (byte)0);
      com.tencent.d.e.a.e.cOP().a((com.tencent.d.e.a.d)localObject);
      return;
      if (l > com.tencent.d.e.a.a.f.wNq * 12L) {
        ((d.a)localObject).wMY = (com.tencent.d.e.a.a.f.wNq * 12L);
      }
    }
  }
  
  public final void a(View paramView, Class<? extends com.tencent.mm.sdk.b.b> paramClass)
  {
    com.tencent.mm.plugin.normsg.b.c.a(paramView, paramClass);
  }
  
  public final void a(String paramString, MotionEvent paramMotionEvent)
  {
    Normsg.c.a(paramString, paramMotionEvent);
  }
  
  public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, PByteArray paramPByteArray)
  {
    return Normsg.a.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPByteArray);
  }
  
  public final boolean boG()
  {
    return Normsg.b.boG();
  }
  
  public final boolean boJ()
  {
    boolean bool = Normsg.b.boJ();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NormsgSourceImpl", "[tomys-edt] alpha tom: %s", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public final boolean boK()
  {
    boolean bool = Normsg.b.boK();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NormsgSourceImpl", "[tomys-edt] bravo jerry: %s", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public final boolean boL()
  {
    boolean bool = Normsg.b.boL();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NormsgSourceImpl", "[tomys-edt] charlie brown: %s", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public final String boN()
  {
    Object localObject = ae.getContext().getPackageManager().getInstalledPackages(0);
    StringBuilder localStringBuilder = new StringBuilder(8192);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localStringBuilder.append(((PackageInfo)((Iterator)localObject).next()).packageName).append('\n');
    }
    return localStringBuilder.toString();
  }
  
  public final boolean boO()
  {
    try
    {
      boolean bool = Normsg.b.boI();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.NormsgSourceImpl", localThrowable, "unexpected error.", new Object[0]);
    }
    return false;
  }
  
  public final byte[] boP()
  {
    return Normsg.b.vn(0);
  }
  
  public final boolean bu(Object paramObject)
  {
    return Normsg.d.bu(paramObject);
  }
  
  public final boolean c(Object paramObject, Class paramClass)
  {
    return Normsg.d.b(paramObject, paramClass);
  }
  
  public final void ei(String paramString1, String paramString2)
  {
    Normsg.c.ei(paramString1, paramString2);
  }
  
  public final String hY(boolean paramBoolean)
  {
    return Normsg.b.aP(",", paramBoolean);
  }
  
  public final byte[] vq(int paramInt)
  {
    return Normsg.b.vn(paramInt);
  }
  
  public final String vr(int paramInt)
  {
    if (com.tencent.mm.kernel.g.DK()) {}
    for (Object localObject1 = (String)com.tencent.mm.kernel.g.DP().Dz().get(79, "");; localObject1 = "")
    {
      com.tencent.mm.kernel.g.DS().k(new b.1(this), 5000L);
      String str1;
      if (com.tencent.mm.kernel.g.DK()) {
        if (com.tencent.mm.kernel.g.DP().dKu.uEh.uDE) {
          str1 = "1";
        }
      }
      for (;;)
      {
        Context localContext = ae.getContext().getApplicationContext();
        Object localObject2 = ((WifiManager)localContext.getSystemService("wifi")).getConnectionInfo();
        String str3 = ((WifiInfo)localObject2).getSSID();
        String str4 = ((WifiInfo)localObject2).getBSSID();
        localObject2 = ae.getContext();
        label123:
        int i;
        label125:
        int j;
        label131:
        label139:
        int k;
        label148:
        int m;
        label169:
        int n;
        label178:
        int i1;
        label187:
        label208:
        int i2;
        String str2;
        StringBuilder localStringBuilder1;
        Object localObject3;
        if (localObject2 == null)
        {
          com.tencent.mm.sdk.platformtools.y.w("MicroMsg.NormsgSourceImpl", "Failed checking mock location: application context not initialized.");
          i = 0;
          if (i == 0) {
            break label1176;
          }
          i = 1;
          if (!Normsg.b.boG()) {
            break label1181;
          }
          j = 1;
          if (!Debug.isDebuggerConnected()) {
            break label1186;
          }
          k = 1;
          if ((!com.tencent.mm.plugin.normsg.b.f.mIb) && (!com.tencent.mm.plugin.normsg.b.f.mIc) && (!com.tencent.mm.plugin.normsg.b.f.mIe)) {
            break label1192;
          }
          m = 1;
          if (!com.tencent.mm.plugin.normsg.b.e.mHX) {
            break label1198;
          }
          n = 1;
          if (!com.tencent.mm.plugin.normsg.b.g.mIf) {
            break label1204;
          }
          i1 = 1;
          localObject2 = Normsg.b.boH();
          if (localObject2 == null) {
            break label1210;
          }
          localObject2 = com.tencent.mm.plugin.normsg.b.d.s((byte[])localObject2, 0, localObject2.length);
          i2 = getVersionCode();
          str2 = dt(i2, paramInt);
          Map localMap = q.zt();
          localStringBuilder1 = new StringBuilder();
          StringBuilder localStringBuilder2 = localStringBuilder1.append("<softtype><lctmoc>").append(i).append("</lctmoc><level>").append(j).append("</level>").append((String)localObject1).append("<k1>");
          localObject3 = (String)localMap.get("model name");
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = q.zm()[0];
          }
          localStringBuilder2 = localStringBuilder2.append(Ke((String)localObject1)).append("</k1><k2>").append(Ke(q.zo())).append("</k2><k3>").append(Ke(q.zp())).append("</k3><k4>").append(Ke(q.zf())).append("</k4><k5>").append(Ke(q.zq())).append("</k5><k6>").append(Ke(q.zr())).append("</k6><k7>").append(Ke(q.getAndroidId())).append("</k7><k8>").append(Ke(q.zs())).append("</k8><k9>").append(Ke(q.zl())).append("</k9><k10>").append(q.zu()).append("</k10><k11>").append(bk.pm(Ke((String)localMap.get("hardware")))).append("</k11><k12>").append(bk.pm(Ke((String)localMap.get("revision")))).append("</k12><k13>").append(bk.pm(Ke((String)localMap.get("serial")))).append("</k13><k14>").append(Ke(q.zi())).append("</k14><k15>").append(Ke(q.zn())).append("</k15><k16>");
          localObject3 = (String)localMap.get("features");
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = (String)localMap.get("flags");
          }
          localObject2 = localStringBuilder2.append(bk.pm(Ke((String)localObject1))).append("</k16><k18>").append((String)localObject2).append("</k18><k21>").append(bk.pm(Ke(str3))).append("</k21><k22>").append(bk.pm(Ke(q.bd(localContext)))).append("</k22><k24>").append(bk.pm(Ke(str4))).append("</k24><k26>").append(k).append("</k26><k30>");
          localObject1 = ((ConnectivityManager)ae.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
          if (localObject1 == null) {
            break label1217;
          }
        }
        label1176:
        label1181:
        label1186:
        label1192:
        label1198:
        label1204:
        label1210:
        label1217:
        for (localObject1 = ((NetworkInfo)localObject1).getExtraInfo();; localObject1 = null)
        {
          localObject3 = ((StringBuilder)localObject2).append(bk.pm(Ke((String)localObject1))).append("</k30><k33>").append(Ke(ae.getPackageName())).append("</k33><k34>").append(bk.pm(Ke(com.tencent.mm.compatible.e.y.get("ro.build.fingerprint")))).append("</k34><k35>").append(bk.pm(Ke(Build.BOARD))).append("</k35><k36>").append(bk.pm(Ke(Build.BOOTLOADER))).append("</k36><k37>").append(bk.pm(Ke(Build.BRAND))).append("</k37><k38>").append(bk.pm(Ke(Build.DEVICE))).append("</k38><k39>").append(bk.pm(Ke(Build.HARDWARE))).append("</k39><k40>").append(bk.pm(Ke(Build.PRODUCT))).append("</k40><k41>").append(m).append("</k41><k42>").append(bk.pm(Ke(com.tencent.mm.compatible.e.y.get("ro.product.manufacturer")))).append("</k42><k43>").append(Settings.System.getString(ae.getContext().getContentResolver(), "89884a87498ef44f")).append("</k43><k44>0</k44><k45>");
          localObject2 = bk.pm(bk.fR(ae.getContext()));
          localObject1 = localObject2;
          if (((String)localObject2).length() > 0) {
            localObject1 = com.tencent.mm.a.g.o(((String)localObject2).getBytes());
          }
          ((StringBuilder)localObject3).append((String)localObject1).append("</k45><k46>").append(str1).append("</k46><k47>").append(Ke(boM())).append("</k47><k48>").append(q.zf()).append("</k48><k49>").append(com.tencent.mm.compatible.util.e.dOO).append("</k49><k52>").append(n).append("</k52><k53>").append(i1).append("</k53><k57>").append(i2).append("</k57><k58>").append(bk.pm(Ke(str2))).append("</k58><k59>").append(paramInt).append("</k59><k60>").append(Ke(com.tencent.mm.sdk.platformtools.d.ueg.getString("FEATURE_ID"))).append("</k60><k61>").append(q.zh()).append("</k61></softtype>");
          return localStringBuilder1.toString();
          str1 = "0";
          break;
          if (Settings.Secure.getInt(((Context)localObject2).getContentResolver(), "mock_location", 0) == 0) {
            break label123;
          }
          i = 1;
          break label125;
          i = 0;
          break label131;
          j = 0;
          break label139;
          k = 0;
          break label148;
          m = 0;
          break label169;
          n = 0;
          break label178;
          i1 = 0;
          break label187;
          localObject2 = "";
          break label208;
        }
        str1 = "";
      }
    }
  }
  
  public final void vs(int paramInt)
  {
    com.tencent.mm.plugin.normsg.b.a.boQ().vs(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b
 * JD-Core Version:    0.7.0.1
 */
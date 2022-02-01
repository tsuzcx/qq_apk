package com.tencent.xweb.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ao;
import com.tencent.xweb.util.b;
import com.tencent.xweb.util.d;
import com.tencent.xweb.util.i;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkGrayValueUtil;

public final class b$d
{
  public int aiiX = -1;
  public int aiiY = -1;
  public int aiiZ = -1;
  public String aijA = null;
  public String aijB = null;
  public int aijC = -1;
  public int aijD = -1;
  public String aijE;
  public String aijF;
  public String aijG = null;
  public int aija = -1;
  public int aijb = -1;
  public int aijc = -1;
  public int aijd = -1;
  public int aije = -1;
  public int aijf = -1;
  public int aijg = -1;
  public String aijh = "";
  public String aiji = "";
  public int aijj = -1;
  public int aijk = -1;
  public int aijl = -1;
  public int aijm = -1;
  public int aijn = -1;
  public int aijo = -1;
  public int aijp = -1;
  public double aijq = -1.0D;
  public double aijr = -1.0D;
  public String aijs = "";
  public String aijt = "";
  public int aiju = -1;
  public int aijv = -1;
  public int aijw = -1;
  public int aijx = -1;
  public String aijy = null;
  public String aijz = null;
  private String source;
  
  private static boolean ad(double paramDouble)
  {
    return (paramDouble >= 0.0D) && (paramDouble < 24.0D);
  }
  
  private static boolean bHO(String paramString)
  {
    AppMethodBeat.i(156954);
    Object localObject2 = "";
    if (a.kgU() != null) {
      localObject2 = "" + a.kgU();
    }
    Object localObject1 = localObject2;
    if (a.kgV() != null) {
      localObject1 = (String)localObject2 + " " + a.kgV();
    }
    localObject2 = localObject1;
    if (a.kgW() != null) {
      localObject2 = (String)localObject1 + " " + a.kgW();
    }
    if ((paramString == null) || (localObject2 == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(156954);
      return false;
    }
    boolean bool = qX(paramString, (String)localObject2);
    AppMethodBeat.o(156954);
    return bool;
  }
  
  private static boolean bJ(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 > 0) && (paramInt1 > paramInt3)) {}
    while ((paramInt2 > 0) && (paramInt1 < paramInt2)) {
      return false;
    }
    return true;
  }
  
  private String getLogTag()
  {
    AppMethodBeat.i(212567);
    if ((this.source != null) && (!"".equals(this.source)))
    {
      str = "ConfigFilter(" + this.source + "|" + hashCode() + ")";
      AppMethodBeat.o(212567);
      return str;
    }
    String str = "ConfigFilter(" + hashCode() + ")";
    AppMethodBeat.o(212567);
    return str;
  }
  
  private String kgX()
  {
    AppMethodBeat.i(156951);
    if (!TextUtils.isEmpty(this.aijG))
    {
      str = this.aijG;
      AppMethodBeat.o(156951);
      return str;
    }
    String str = b.khw();
    AppMethodBeat.o(156951);
    return str;
  }
  
  private boolean kgY()
  {
    AppMethodBeat.i(212588);
    if ((!ad(this.aijq)) && (!ad(this.aijr)))
    {
      AppMethodBeat.o(212588);
      return true;
    }
    double d = i.khC();
    if ((this.aijr > 0.0D) && (d > this.aijr))
    {
      AppMethodBeat.o(212588);
      return false;
    }
    if ((this.aijq > 0.0D) && (d < this.aijq))
    {
      AppMethodBeat.o(212588);
      return false;
    }
    AppMethodBeat.o(212588);
    return true;
  }
  
  private static boolean qW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156953);
    if (paramString1 == null)
    {
      AppMethodBeat.o(156953);
      return false;
    }
    paramString1 = paramString1.split("\\|");
    if ((paramString1 == null) || (paramString1.length < 0))
    {
      AppMethodBeat.o(156953);
      return false;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      AppMethodBeat.o(156953);
      return false;
    }
    paramString2 = paramString2.trim();
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      CharSequence localCharSequence = paramString1[i];
      if ((!TextUtils.isEmpty(localCharSequence)) && (localCharSequence.trim().equalsIgnoreCase(paramString2)))
      {
        AppMethodBeat.o(156953);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(156953);
    return false;
  }
  
  private static boolean qX(String paramString1, String paramString2)
  {
    boolean bool1 = false;
    AppMethodBeat.i(156955);
    if ((paramString1 == null) || (paramString1.isEmpty()) || (paramString1.trim() == null) || (paramString1.trim().isEmpty()))
    {
      AppMethodBeat.o(156955);
      return false;
    }
    if ((paramString2 == null) || (paramString2.isEmpty()))
    {
      AppMethodBeat.o(156955);
      return false;
    }
    try
    {
      boolean bool2 = Pattern.compile(paramString1).matcher(paramString2.toUpperCase()).find();
      bool1 = bool2;
    }
    finally
    {
      for (;;)
      {
        Log.e("ConfigDef", "_IsMatchRex, compile pattern failed, strRex:" + paramString1 + ", strContent:" + paramString2);
      }
    }
    AppMethodBeat.o(156955);
    return bool1;
  }
  
  public final boolean g(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    AppMethodBeat.i(212605);
    this.source = paramString;
    int k = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
    int m = XWalkEnvironment.getInstalledNewstVersionForPredownAbi();
    int n = WebView.getTbsSDKVersion(XWalkEnvironment.getApplicationContext());
    int i1 = WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext());
    int i2 = ao.kge();
    if (XWalkEnvironment.getApplicationContext().getApplicationInfo() != null) {}
    for (int i = XWalkEnvironment.getApplicationContext().getApplicationInfo().targetSdkVersion;; i = 0)
    {
      if ((paramBoolean1) || (bJ(XWalkGrayValueUtil.getGrayValue(), this.aijj, this.aijk))) {}
      for (int j = 1;; j = 0)
      {
        Log.i(getLogTag(), "checkMatch, ignoreGrayValue:" + paramBoolean1 + ", grayValue(" + XWalkGrayValueUtil.getGrayValue() + "):" + bJ(XWalkGrayValueUtil.getGrayValue(), this.aijj, this.aijk) + ", apk(" + k + "):" + bJ(k, this.aiiZ, this.aija) + ", preDownApk(" + m + "):" + bJ(m, this.aijb, this.aijc) + ", sdk(" + i2 + "):" + bJ(i2, this.aiiX, this.aiiY) + ", x5sdk(" + n + "):" + bJ(n, this.aiju, this.aijv) + ", x5core(" + i1 + "):" + bJ(i1, this.aijw, this.aijx) + ", api(" + Build.VERSION.SDK_INT + "):" + bJ(Build.VERSION.SDK_INT, this.aijd, this.aije) + ", targetApi(" + i + "):" + bJ(i, this.aijf, this.aijg) + ", todayGrayValue(" + XWalkGrayValueUtil.getTodayGrayValue() + "):" + bJ(XWalkGrayValueUtil.getTodayGrayValue(), this.aijl, this.aijm) + ", forbidDeviceRegex(" + this.aijh + "):" + bHO(this.aijh) + ", forbidAppRegex(" + this.aijs + "):" + qX(this.aijs, XWalkEnvironment.getPackageName()) + ", timeRange:" + kgY() + ", runtimeAbi:" + b.khw() + ", targetRuntimeAbi:" + kgX());
        if ((j == 0) || (!bJ(k, this.aiiZ, this.aija)) || (!bJ(m, this.aijb, this.aijc)) || (!bJ(i2, this.aiiX, this.aiiY)) || (!bJ(n, this.aiju, this.aijv)) || (!bJ(i1, this.aijw, this.aijx)) || (!bJ(Build.VERSION.SDK_INT, this.aijd, this.aije)) || (!bJ(i, this.aijf, this.aijg)) || (!bJ(XWalkGrayValueUtil.getTodayGrayValue(), this.aijl, this.aijm)) || (bHO(this.aijh)) || (qX(this.aijs, XWalkEnvironment.getPackageName())) || (!kgY())) {
          break label1497;
        }
        if ((this.aijp <= 0) || (ao.kgt() == this.aijp)) {
          break;
        }
        Log.i(getLogTag(), "not match user type:" + this.aijp);
        AppMethodBeat.o(212605);
        return false;
      }
      if ((this.aiji != null) && (this.aiji.trim() != null) && (!this.aiji.trim().isEmpty()) && (!bHO(this.aiji)))
      {
        Log.i(getLogTag(), "not match white device regex:" + this.aiji);
        AppMethodBeat.o(212605);
        return false;
      }
      if ((this.aijt != null) && (this.aijt.trim() != null) && (!this.aijt.trim().isEmpty()) && (!qX(this.aijt, XWalkEnvironment.getPackageName())))
      {
        Log.i(getLogTag(), "not match white app regex:" + this.aijt);
        AppMethodBeat.o(212605);
        return false;
      }
      if ((this.aijn > 0) || (this.aijo > 0))
      {
        i = d.khy();
        if (!bJ(i, this.aijn, this.aijo))
        {
          Log.i(getLogTag(), "not match chromium version(" + this.aijn + ", " + this.aijo + "), current version is:" + i);
          AppMethodBeat.o(212605);
          return false;
        }
      }
      if (((paramBoolean2) || (!TextUtils.isEmpty(this.aijz))) && (!qW(this.aijz, kgX())))
      {
        Log.i(getLogTag(), "not match whiteRuntimeabis, white abis is:" + this.aijz + ", cur runtime abi is:" + b.khw() + ", target runtime abi:" + kgX());
        AppMethodBeat.o(212605);
        return false;
      }
      if ((!TextUtils.isEmpty(this.aijy)) && (!qW(this.aijy, b.khx())))
      {
        Log.i(getLogTag(), "not match whiteDeviceAbis, white abis is:" + this.aijy + ", cur device abi is:" + b.khx());
        AppMethodBeat.o(212605);
        return false;
      }
      if ((!TextUtils.isEmpty(this.aijB)) && (qW(this.aijB, kgX())))
      {
        Log.i(getLogTag(), "match blackRuntimeAbis, black abis is:" + this.aijB + ", cur runtime abi is:" + b.khw() + ", target runtime abi:" + kgX());
        AppMethodBeat.o(212605);
        return false;
      }
      if ((!TextUtils.isEmpty(this.aijA)) && (qW(this.aijA, b.khx())))
      {
        Log.i(getLogTag(), "match blackDeviceAbis, black abis is:" + this.aijA + ", cur device abi is:" + b.khx());
        AppMethodBeat.o(212605);
        return false;
      }
      i = XWalkEnvironment.getAppClientVersion();
      if ((i > 0) && (!bJ(i, this.aijC, this.aijD)))
      {
        Log.i(getLogTag(), "not match AppClientVersion(" + this.aijC + ", " + this.aijD + "), cur client version is:" + i);
        AppMethodBeat.o(212605);
        return false;
      }
      if ((!TextUtils.isEmpty(this.aijE)) && (!XWalkEnvironment.containsAppInfo(this.aijE)))
      {
        Log.i(getLogTag(), "not match appInfoWhiteList:" + this.aijE);
        AppMethodBeat.o(212605);
        return false;
      }
      if ((!TextUtils.isEmpty(this.aijF)) && (XWalkEnvironment.containsAppInfo(this.aijF)))
      {
        Log.i(getLogTag(), "match appInfoBlackList:" + this.aijF);
        AppMethodBeat.o(212605);
        return false;
      }
      AppMethodBeat.o(212605);
      return true;
      label1497:
      AppMethodBeat.o(212605);
      return false;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(212619);
    Object localObject = new StringBuilder("Filter{");
    if (this.aiiX != 0) {
      ((StringBuilder)localObject).append("sdkMin=").append(this.aiiX);
    }
    if (this.aiiY != 0) {
      ((StringBuilder)localObject).append(", sdkMax=").append(this.aiiY);
    }
    if (this.aiiZ != 0) {
      ((StringBuilder)localObject).append(", apkMin=").append(this.aiiZ);
    }
    if (this.aija != 0) {
      ((StringBuilder)localObject).append(", apkMax=").append(this.aija);
    }
    if (this.aijb != 0) {
      ((StringBuilder)localObject).append(", preDownApkMin=").append(this.aijb);
    }
    if (this.aijc != 0) {
      ((StringBuilder)localObject).append(", preDownApkMax=").append(this.aijc);
    }
    if (this.aijd != 0) {
      ((StringBuilder)localObject).append(", apiMin=").append(this.aijd);
    }
    if (this.aije != 0) {
      ((StringBuilder)localObject).append(", apiMax=").append(this.aije);
    }
    if (this.aijf != 0) {
      ((StringBuilder)localObject).append(", targetApiMin=").append(this.aijf);
    }
    if (this.aijg != 0) {
      ((StringBuilder)localObject).append(", targetApiMax=").append(this.aijg);
    }
    if (this.aijj != 0) {
      ((StringBuilder)localObject).append(", grayMin=").append(this.aijj);
    }
    if (this.aijk != 0) {
      ((StringBuilder)localObject).append(", grayMax=").append(this.aijk);
    }
    if (this.aijl != 0) {
      ((StringBuilder)localObject).append(", dayGrayMin=").append(this.aijl);
    }
    if (this.aijm != 0) {
      ((StringBuilder)localObject).append(", dayGrayMax=").append(this.aijm);
    }
    if (this.aijn != 0) {
      ((StringBuilder)localObject).append(", chromeMin=").append(this.aijn);
    }
    if (this.aijo != 0) {
      ((StringBuilder)localObject).append(", chromeMax=").append(this.aijo);
    }
    if (this.aijp != 0) {
      ((StringBuilder)localObject).append(", usertype=").append(this.aijp);
    }
    if (this.aijq != -1.0D) {
      ((StringBuilder)localObject).append(", hoursStart=").append(this.aijq);
    }
    if (this.aijr != -1.0D) {
      ((StringBuilder)localObject).append(", hoursEnd=").append(this.aijr);
    }
    if (this.aiju != 0) {
      ((StringBuilder)localObject).append(", x5sdkmin=").append(this.aiju);
    }
    if (this.aijv != 0) {
      ((StringBuilder)localObject).append(", x5sdkmax=").append(this.aijv);
    }
    if (this.aijw != 0) {
      ((StringBuilder)localObject).append(", x5coremin=").append(this.aijw);
    }
    if (this.aijx != 0) {
      ((StringBuilder)localObject).append(", x5coremax=").append(this.aijx);
    }
    if (this.aijC != 0) {
      ((StringBuilder)localObject).append(", appClientVerMin=").append(this.aijC);
    }
    if (this.aijD != 0) {
      ((StringBuilder)localObject).append(", appClientVerMax=").append(this.aijD);
    }
    if (!TextUtils.isEmpty(this.aijh)) {
      ((StringBuilder)localObject).append(", forbidDeviceRegex='").append(this.aijh).append('\'');
    }
    if (!TextUtils.isEmpty(this.aiji)) {
      ((StringBuilder)localObject).append(", whiteDeviceRegex='").append(this.aiji).append('\'');
    }
    if (!TextUtils.isEmpty(this.aijs)) {
      ((StringBuilder)localObject).append(", forbidAppRegex='").append(this.aijs).append('\'');
    }
    if (!TextUtils.isEmpty(this.aijt)) {
      ((StringBuilder)localObject).append(", whiteAppRegex='").append(this.aijt).append('\'');
    }
    if (!TextUtils.isEmpty(this.aijy)) {
      ((StringBuilder)localObject).append(", deviceAbis='").append(this.aijy).append('\'');
    }
    if (!TextUtils.isEmpty(this.aijz)) {
      ((StringBuilder)localObject).append(", runtimeAbis='").append(this.aijz).append('\'');
    }
    if (!TextUtils.isEmpty(this.aijA)) {
      ((StringBuilder)localObject).append(", blackDeviceAbis='").append(this.aijA).append('\'');
    }
    if (!TextUtils.isEmpty(this.aijB)) {
      ((StringBuilder)localObject).append(", blackRuntimeAbis='").append(this.aijB).append('\'');
    }
    if (!TextUtils.isEmpty(this.aijE)) {
      ((StringBuilder)localObject).append(", appInfoWhiteList='").append(this.aijE).append('\'');
    }
    if (!TextUtils.isEmpty(this.aijF)) {
      ((StringBuilder)localObject).append(", appInfoBlackList='").append(this.aijF).append('\'');
    }
    ((StringBuilder)localObject).append('}');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(212619);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.internal.b.d
 * JD-Core Version:    0.7.0.1
 */
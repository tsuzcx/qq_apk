package com.tencent.mm.plugin.sns.ad.d;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.l;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URI;

public final class d
{
  private static boolean jxV = false;
  
  public static boolean No()
  {
    return jxV;
  }
  
  public static void a(com.tencent.mm.i.e parame, cvt paramcvt)
  {
    AppMethodBeat.i(266556);
    if ((paramcvt != null) && (paramcvt.isAd) && (!TextUtils.isEmpty(paramcvt.Url))) {
      try
      {
        if (!paramcvt.Url.contains("svpuseh265flag=1")) {
          break label199;
        }
        boolean bool = com.tencent.mm.modelcontrol.e.vW(6);
        if (bool) {
          parame.field_requestVideoFormat = 2;
        }
        for (;;)
        {
          Log.i("AdH265Helper", "checkAppendAdH265Flag, isDeviceSupportHevc=" + bool + ", requestVideoFormat=" + parame.field_requestVideoFormat + ", url=" + paramcvt.Url);
          az(true, bool);
          AppMethodBeat.o(266556);
          return;
          parame.field_requestVideoFormat = 1;
          try
          {
            String str = Build.MODEL.toLowerCase();
            l.a(l.JQN, str, 0, 0, "");
          }
          catch (Throwable localThrowable)
          {
            Log.e("AdH265Helper", "checkAdDeviceSupportH265 report exp=" + localThrowable.toString());
          }
        }
        AppMethodBeat.o(266556);
      }
      catch (Throwable paramcvt)
      {
        parame.field_requestVideoFormat = 1;
        Log.e("AdH265Helper", "checkAppendAdH265Flag, exp=" + paramcvt.toString());
      }
    } else {
      return;
    }
    label199:
    parame.field_requestVideoFormat = 1;
    Log.i("AdH265Helper", "checkAppendAdH265Flag, url has no h265 flag, url=" + paramcvt.Url);
    az(false, false);
    AppMethodBeat.o(266556);
  }
  
  public static void a(ADXml paramADXml, cvt paramcvt, String paramString)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    AppMethodBeat.i(266552);
    long l = System.currentTimeMillis();
    if ((paramADXml == null) || (paramcvt == null) || (!paramcvt.isAd))
    {
      paramString = new StringBuilder("checkAdSupportH265, adXml==null?");
      if (paramADXml == null)
      {
        bool1 = true;
        paramADXml = paramString.append(bool1).append(", media==null?");
        if (paramcvt != null) {
          break label107;
        }
        bool1 = bool3;
        label65:
        paramADXml = paramADXml.append(bool1).append(", isAd=");
        if (paramcvt != null) {
          break label112;
        }
      }
      label107:
      label112:
      for (boolean bool1 = bool2;; bool1 = paramcvt.isAd)
      {
        Log.w("AdH265Helper", bool1);
        AppMethodBeat.o(266552);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label65;
      }
    }
    if (paramADXml.isFullCardAd())
    {
      if (!fJN())
      {
        Log.i("AdH265Helper", "fullcardAd not enable h265");
        a(paramcvt, false);
        AppMethodBeat.o(266552);
        return;
      }
      paramADXml = "fullcardAd enable h265";
    }
    for (;;)
    {
      a(paramcvt, true);
      Log.i("AdH265Helper", "checkAdSupportH265, " + paramADXml + ", snsId=" + paramString + ", timeCost=" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(266552);
      return;
      if (paramADXml.isCardAd())
      {
        if (!fJO())
        {
          Log.i("AdH265Helper", "cardAd not enable h265");
          a(paramcvt, false);
          AppMethodBeat.o(266552);
          return;
        }
        paramADXml = "cardAd enable h265";
      }
      else
      {
        if (!fJP())
        {
          Log.i("AdH265Helper", "normalAd not enable h265");
          a(paramcvt, false);
          AppMethodBeat.o(266552);
          return;
        }
        paramADXml = "normalAd enable h265";
      }
    }
  }
  
  public static void a(w paramw, boolean paramBoolean)
  {
    AppMethodBeat.i(266558);
    if (paramw == null)
    {
      AppMethodBeat.o(266558);
      return;
    }
    boolean bool2 = fJR();
    if ((bool2) && (paramw.Kms)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramw.Kml = co(paramw.Kml, bool1);
      Log.i("AdH265Helper", "checkAdLandingPageSightForH265, expt=" + bool2 + ", cdn=" + paramw.Kms + ", isPreload=" + paramBoolean + ", ret url=" + paramw.Kml);
      AppMethodBeat.o(266558);
      return;
    }
  }
  
  public static void a(SnsInfo paramSnsInfo, cvt paramcvt)
  {
    AppMethodBeat.i(266551);
    if ((paramSnsInfo != null) && (paramSnsInfo.isAd())) {
      a(paramSnsInfo.getAdXml(), paramcvt, t.Qu(paramSnsInfo.field_snsId));
    }
    AppMethodBeat.o(266551);
  }
  
  public static void a(cvt paramcvt, boolean paramBoolean)
  {
    AppMethodBeat.i(266553);
    long l1 = System.currentTimeMillis();
    if (paramcvt == null)
    {
      Log.e("AdH265Helper", "setMediaInfoForH265, media==null");
      AppMethodBeat.o(266553);
      return;
    }
    if (!paramcvt.isAd)
    {
      Log.e("AdH265Helper", "setMediaInfoForH265, !media.isAd");
      AppMethodBeat.o(266553);
      return;
    }
    paramcvt.Url = co(paramcvt.Url, paramBoolean);
    paramcvt.Id = cp(paramcvt.Id, paramBoolean);
    long l2 = System.currentTimeMillis();
    Log.i("AdH265Helper", "setMediaInfoForH265, media.hash=" + paramcvt.hashCode() + ", enableH265=" + paramBoolean + ", meida.enc=" + paramcvt.TDQ + ", cost=" + (l2 - l1));
    AppMethodBeat.o(266553);
  }
  
  private static String aYp(String paramString)
  {
    AppMethodBeat.i(266565);
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool)
      {
        AppMethodBeat.o(266565);
        return paramString;
      }
      bool = paramString.contains("svpuseh265flag");
      if (!bool)
      {
        AppMethodBeat.o(266565);
        return paramString;
      }
      URI localURI = new URI(paramString);
      Object localObject2 = localURI.getQuery();
      Object localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (((String)localObject2).contains("svpuseh265flag=0")) {
          localObject1 = ((String)localObject2).replace("&svpuseh265flag=0", "").replace("svpuseh265flag=0", "");
        }
        localObject2 = localObject1;
        if (((String)localObject1).contains("svpuseh265flag=1")) {
          localObject2 = ((String)localObject1).replace("&svpuseh265flag=1", "").replace("svpuseh265flag=1", "");
        }
        localObject1 = localObject2;
        if (((String)localObject2).startsWith("&")) {
          localObject1 = ((String)localObject2).replaceFirst("&", "");
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = null;
      }
      localObject1 = new URI(localURI.getScheme(), localURI.getAuthority(), localURI.getPath(), (String)localObject2, localURI.getFragment()).toString();
      AppMethodBeat.o(266565);
      return localObject1;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("AdH265Helper", localException, "", new Object[0]);
      AppMethodBeat.o(266565);
    }
    return paramString;
  }
  
  private static void az(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(266566);
    int i;
    if ((paramBoolean1) && (paramBoolean2)) {
      i = 4;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.IzE.el(1579, i);
      Log.i("AdH265Helper", "report, isOnline=false, urlHasFlag=" + paramBoolean1 + ", cdnHasFlag=" + paramBoolean2 + ", key=" + i);
      AppMethodBeat.o(266566);
      return;
      if (!paramBoolean1) {
        i = 5;
      } else {
        i = 6;
      }
    }
  }
  
  public static String co(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(266554);
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        if (!paramBoolean) {
          continue;
        }
        if (paramString.contains("svpuseh265flag")) {
          continue;
        }
        str1 = ao.m(paramString, new String[] { "svpuseh265flag=1" });
      }
      catch (Throwable localThrowable)
      {
        String str1;
        Log.e("AdH265Helper", "setMediaUrlForH265, exp=" + localThrowable.toString());
        String str2 = paramString;
        continue;
      }
      Log.d("AdH265Helper", "setMediaUrlForH265, raw=" + paramString + ", ret=" + str1 + ", enable=" + paramBoolean);
      AppMethodBeat.o(266554);
      return str1;
      str1 = paramString.replace("svpuseh265flag=0", "svpuseh265flag=1");
      continue;
      str1 = aYp(paramString);
      continue;
      Log.e("AdH265Helper", "setMediaUrlForH265, media.Url==null");
      str1 = paramString;
    }
  }
  
  public static String cp(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(266555);
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        if (!paramBoolean) {
          continue;
        }
        if (paramString.contains("_hvec")) {
          continue;
        }
        str1 = paramString + "_hvec";
      }
      catch (Throwable localThrowable)
      {
        String str1;
        Log.e("AdH265Helper", "setMediaIdForH265, exp=" + localThrowable.toString());
        String str2 = paramString;
        continue;
      }
      Log.i("AdH265Helper", "setMediaIdForH265, raw=" + paramString + ", ret=" + str1 + ", enable=" + paramBoolean);
      AppMethodBeat.o(266555);
      return str1;
      if (paramString.contains("_hvec"))
      {
        str1 = paramString.replace("_hvec", "");
        continue;
        Log.e("AdH265Helper", "setMediaIdForH265, mediaId==null");
      }
      else
      {
        str1 = paramString;
      }
    }
  }
  
  private static boolean fJN()
  {
    AppMethodBeat.i(266559);
    try
    {
      if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vvb, 0) > 0)
      {
        AppMethodBeat.o(266559);
        return true;
      }
      AppMethodBeat.o(266559);
      return false;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdH265Helper", "isExptFullCardAdEnableH265, exp=" + localThrowable.toString());
      AppMethodBeat.o(266559);
    }
    return false;
  }
  
  private static boolean fJO()
  {
    AppMethodBeat.i(266560);
    try
    {
      if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vvc, 0) > 0)
      {
        AppMethodBeat.o(266560);
        return true;
      }
      AppMethodBeat.o(266560);
      return false;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdH265Helper", "isExptCardAdEnableH265, exp=" + localThrowable.toString());
      AppMethodBeat.o(266560);
    }
    return false;
  }
  
  private static boolean fJP()
  {
    AppMethodBeat.i(266562);
    try
    {
      if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vvd, 0) > 0)
      {
        AppMethodBeat.o(266562);
        return true;
      }
      AppMethodBeat.o(266562);
      return false;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdH265Helper", "isExptNormAdEnableH265, exp=" + localThrowable.toString());
      AppMethodBeat.o(266562);
    }
    return false;
  }
  
  public static boolean fJQ()
  {
    AppMethodBeat.i(266563);
    try
    {
      if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vve, 0) > 0)
      {
        AppMethodBeat.o(266563);
        return true;
      }
      AppMethodBeat.o(266563);
      return false;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdH265Helper", "isExptNormAdEnableH265, exp=" + localThrowable.toString());
      AppMethodBeat.o(266563);
    }
    return false;
  }
  
  private static boolean fJR()
  {
    AppMethodBeat.i(266564);
    try
    {
      if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vvf, 0) > 0)
      {
        AppMethodBeat.o(266564);
        return true;
      }
      AppMethodBeat.o(266564);
      return false;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdH265Helper", "isExptLandingPageSightVideoEnableH265, exp=" + localThrowable.toString());
      AppMethodBeat.o(266564);
    }
    return false;
  }
  
  public static void h(com.tencent.mm.i.h paramh)
  {
    AppMethodBeat.i(266557);
    if ((paramh.arR()) && (!TextUtils.isEmpty(paramh.url))) {
      try
      {
        if (!paramh.url.contains("svpuseh265flag=1")) {
          break label198;
        }
        boolean bool = com.tencent.mm.modelcontrol.e.vW(6);
        if (bool) {
          paramh.field_requestVideoFormat = 2;
        }
        for (;;)
        {
          Log.i("AdH265Helper", "checkAppendAdH265Flag, isDeviceSupportHevc=" + bool + ", requestVideoFormat=" + paramh.field_requestVideoFormat + ", url=" + paramh.url);
          az(true, bool);
          AppMethodBeat.o(266557);
          return;
          paramh.field_requestVideoFormat = 1;
          try
          {
            String str = Build.MODEL.toLowerCase();
            l.a(l.JQN, str, 0, 0, "");
          }
          catch (Throwable localThrowable1)
          {
            Log.e("AdH265Helper", "checkAdDeviceSupportH265 report exp=" + localThrowable1.toString());
          }
        }
        AppMethodBeat.o(266557);
      }
      catch (Throwable localThrowable2)
      {
        paramh.field_requestVideoFormat = 1;
        Log.e("AdH265Helper", "checkAppendAdH265Flag, exp=" + localThrowable2.toString());
      }
    } else {
      return;
    }
    label198:
    paramh.field_requestVideoFormat = 1;
    Log.i("AdH265Helper", "checkAppendAdH265Flag, url has no h265 flag, url=" + paramh.url);
    az(false, false);
    AppMethodBeat.o(266557);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.d
 * JD-Core Version:    0.7.0.1
 */
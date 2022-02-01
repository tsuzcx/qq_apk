package com.tencent.mm.plugin.sns.ad.e;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URI;

public final class b
{
  private static boolean gNA = false;
  
  public static boolean KB()
  {
    return gNA;
  }
  
  public static cnb a(cnb paramcnb)
  {
    AppMethodBeat.i(201897);
    try
    {
      cnb localcnb = new cnb();
      localcnb.parseFrom(paramcnb.toByteArray());
      Log.d("AdH265Helper", "copyMediaObj id=" + localcnb.Id);
      AppMethodBeat.o(201897);
      return localcnb;
    }
    catch (Exception localException)
    {
      Log.e("AdH265Helper", "copyMediaObj exp=" + localException.toString());
      AppMethodBeat.o(201897);
    }
    return paramcnb;
  }
  
  public static void a(com.tencent.mm.i.e parame, cnb paramcnb)
  {
    AppMethodBeat.i(201892);
    if ((paramcnb != null) && (paramcnb.isAd) && (!TextUtils.isEmpty(paramcnb.Url))) {
      try
      {
        if (!paramcnb.Url.contains("svpuseh265flag=1")) {
          break label199;
        }
        boolean bool = com.tencent.mm.modelcontrol.e.sX(6);
        if (bool) {
          parame.field_requestVideoFormat = 2;
        }
        for (;;)
        {
          Log.i("AdH265Helper", "checkAppendAdH265Flag, isDeviceSupportHevc=" + bool + ", requestVideoFormat=" + parame.field_requestVideoFormat + ", url=" + paramcnb.Url);
          an(true, bool);
          AppMethodBeat.o(201892);
          return;
          parame.field_requestVideoFormat = 1;
          try
          {
            String str = Build.MODEL.toLowerCase();
            j.b(j.DEe, str, 0, 0, "");
          }
          catch (Throwable localThrowable)
          {
            Log.e("AdH265Helper", "checkAdDeviceSupportH265 report exp=" + localThrowable.toString());
          }
        }
        AppMethodBeat.o(201892);
      }
      catch (Throwable paramcnb)
      {
        parame.field_requestVideoFormat = 1;
        Log.e("AdH265Helper", "checkAppendAdH265Flag, exp=" + paramcnb.toString());
      }
    } else {
      return;
    }
    label199:
    parame.field_requestVideoFormat = 1;
    Log.i("AdH265Helper", "checkAppendAdH265Flag, url has no h265 flag, url=" + paramcnb.Url);
    an(false, false);
    AppMethodBeat.o(201892);
  }
  
  public static void a(ADXml paramADXml, cnb paramcnb, String paramString)
  {
    AppMethodBeat.i(201890);
    long l = System.currentTimeMillis();
    if ((paramADXml == null) || (paramcnb == null) || (!paramcnb.isAd))
    {
      AppMethodBeat.o(201890);
      return;
    }
    if (paramADXml.isFullCardAd())
    {
      if (!eWK())
      {
        Log.i("AdH265Helper", "fullcardAd not enable h265");
        a(paramcnb, false);
        AppMethodBeat.o(201890);
        return;
      }
      paramADXml = "fullcardAd enable h265";
    }
    for (;;)
    {
      a(paramcnb, true);
      Log.i("AdH265Helper", "checkAdSupportH265, " + paramADXml + ", snsId=" + paramString + ", timeCost=" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(201890);
      return;
      if (paramADXml.isCardAd())
      {
        if (!eWL())
        {
          Log.i("AdH265Helper", "cardAd not enable h265");
          a(paramcnb, false);
          AppMethodBeat.o(201890);
          return;
        }
        paramADXml = "cardAd enable h265";
      }
      else
      {
        if (!eWM())
        {
          Log.i("AdH265Helper", "normalAd not enable h265");
          a(paramcnb, false);
          AppMethodBeat.o(201890);
          return;
        }
        paramADXml = "normalAd enable h265";
      }
    }
  }
  
  public static void a(SnsInfo paramSnsInfo, cnb paramcnb)
  {
    AppMethodBeat.i(201889);
    if ((paramSnsInfo != null) && (paramSnsInfo.isAd())) {
      a(paramSnsInfo.getAdXml(), paramcnb, r.Jb(paramSnsInfo.field_snsId));
    }
    AppMethodBeat.o(201889);
  }
  
  public static void a(cnb paramcnb, boolean paramBoolean)
  {
    AppMethodBeat.i(201891);
    long l1 = System.currentTimeMillis();
    if (paramcnb == null)
    {
      Log.e("AdH265Helper", "setMediaInfoForH265, media==null");
      AppMethodBeat.o(201891);
      return;
    }
    if (!paramcnb.isAd)
    {
      Log.e("AdH265Helper", "setMediaInfoForH265, !media.isAd");
      AppMethodBeat.o(201891);
      return;
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramcnb.Url)) {
          continue;
        }
        str = paramcnb.Url;
        if (!paramBoolean) {
          continue;
        }
        if (str.contains("svpuseh265flag")) {
          continue;
        }
        str = ap.n(str, new String[] { "svpuseh265flag=1" });
        paramcnb.Url = str;
      }
      catch (Throwable localThrowable1)
      {
        String str;
        Log.e("AdH265Helper", "setMediaInfoForH265, exp=" + localThrowable1.toString());
        continue;
        if (!paramcnb.Id.contains("_hvec")) {
          continue;
        }
        paramcnb.Id = paramcnb.Id.replace("_hvec", "");
        continue;
      }
      str = paramcnb.Id;
      try
      {
        if (TextUtils.isEmpty(paramcnb.Id)) {
          break label376;
        }
        if (!paramBoolean) {
          continue;
        }
        if (!paramcnb.Id.contains("_hvec")) {
          paramcnb.Id += "_hvec";
        }
      }
      catch (Throwable localThrowable2)
      {
        long l2;
        Log.e("AdH265Helper", "setMediaInfoForH265, exp=" + localThrowable2.toString());
        continue;
        Log.e("AdH265Helper", "setMediaInfoForH265, media.Id==null");
        continue;
      }
      l2 = System.currentTimeMillis();
      Log.i("AdH265Helper", "setMediaInfoForH265, media.hash=" + paramcnb.hashCode() + ", enableH265=" + paramBoolean + ", meida.enc=" + paramcnb.MsK + ", cost=" + (l2 - l1) + ", rawMediaId=" + str + ", media.Id=" + paramcnb.Id);
      AppMethodBeat.o(201891);
      return;
      str = str.replace("svpuseh265flag=0", "svpuseh265flag=1");
      continue;
      str = aNE(str);
      continue;
      Log.e("AdH265Helper", "setMediaInfoForH265, media.Url==null");
    }
  }
  
  private static String aNE(String paramString)
  {
    AppMethodBeat.i(201896);
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool)
      {
        AppMethodBeat.o(201896);
        return paramString;
      }
      bool = paramString.contains("svpuseh265flag");
      if (!bool)
      {
        AppMethodBeat.o(201896);
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
      AppMethodBeat.o(201896);
      return localObject1;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("AdH265Helper", localException, "", new Object[0]);
      AppMethodBeat.o(201896);
    }
    return paramString;
  }
  
  private static void an(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(201898);
    int i;
    if ((paramBoolean1) && (paramBoolean2)) {
      i = 4;
    }
    for (;;)
    {
      h.CyF.dN(1579, i);
      Log.i("AdH265Helper", "report, isOnline=false, urlHasFlag=" + paramBoolean1 + ", cdnHasFlag=" + paramBoolean2 + ", key=" + i);
      AppMethodBeat.o(201898);
      return;
      if (!paramBoolean1) {
        i = 5;
      } else {
        i = 6;
      }
    }
  }
  
  private static boolean eWK()
  {
    AppMethodBeat.i(201893);
    try
    {
      if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rOZ, 0) > 0)
      {
        AppMethodBeat.o(201893);
        return true;
      }
      AppMethodBeat.o(201893);
      return false;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdH265Helper", "isExptFullCardAdEnableH265, exp=" + localThrowable.toString());
      AppMethodBeat.o(201893);
    }
    return false;
  }
  
  private static boolean eWL()
  {
    AppMethodBeat.i(201894);
    try
    {
      if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPa, 0) > 0)
      {
        AppMethodBeat.o(201894);
        return true;
      }
      AppMethodBeat.o(201894);
      return false;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdH265Helper", "isExptCardAdEnableH265, exp=" + localThrowable.toString());
      AppMethodBeat.o(201894);
    }
    return false;
  }
  
  private static boolean eWM()
  {
    AppMethodBeat.i(201895);
    try
    {
      if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPb, 0) > 0)
      {
        AppMethodBeat.o(201895);
        return true;
      }
      AppMethodBeat.o(201895);
      return false;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdH265Helper", "isExptNormAdEnableH265, exp=" + localThrowable.toString());
      AppMethodBeat.o(201895);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.b
 * JD-Core Version:    0.7.0.1
 */
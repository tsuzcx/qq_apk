package com.tencent.mm.plugin.sns.ad.adxml;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class n
{
  @p(hkF=1)
  public String PNb;
  @p(hkF=1)
  public String PNc;
  @p(hkF=1)
  public String PNd;
  public String PNe;
  public float PNf;
  public float PNg;
  public int PNh;
  public int PNi;
  public int afd;
  public AdClickActionInfo clickActionInfo;
  public float dwJ;
  @p(hkF=1)
  public String iconUrl;
  public int layoutWidth;
  public String nSx;
  public String title;
  
  public static n X(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(309863);
    n localn = new n();
    localn.PNb = Util.nullAsNil((String)paramMap.get(paramString + ".bgImageUrl"));
    localn.PNc = Util.nullAsNil((String)paramMap.get(paramString + ".bgImageUrlDark"));
    localn.iconUrl = Util.nullAsNil((String)paramMap.get(paramString + ".iconUrl"));
    localn.PNd = Util.nullAsNil((String)paramMap.get(paramString + ".iconUrlDark"));
    localn.title = Util.nullAsNil((String)paramMap.get(paramString + ".title"));
    if ((TextUtils.isEmpty(localn.PNc)) && (!TextUtils.isEmpty(localn.PNb)))
    {
      localn.PNc = localn.PNb;
      Log.w("AdTagButtonInfo", "bgImageUrlDark is empty");
    }
    if ((TextUtils.isEmpty(localn.PNb)) && (!TextUtils.isEmpty(localn.PNc)))
    {
      localn.PNb = localn.PNc;
      Log.w("AdTagButtonInfo", "bgImageUrl is empty");
    }
    if ((TextUtils.isEmpty(localn.PNd)) && (!TextUtils.isEmpty(localn.iconUrl)))
    {
      localn.PNd = localn.iconUrl;
      Log.w("AdTagButtonInfo", "iconUrlDark is empty");
    }
    if ((TextUtils.isEmpty(localn.iconUrl)) && (!TextUtils.isEmpty(localn.PNd)))
    {
      localn.iconUrl = localn.PNd;
      Log.w("AdTagButtonInfo", "iconUrl is empty");
    }
    localn.nSx = Util.nullAsNil((String)paramMap.get(paramString + ".titleColor"));
    localn.PNe = Util.nullAsNil((String)paramMap.get(paramString + ".titleColorDark"));
    localn.PNf = Util.safeParseFloat((String)paramMap.get(paramString + ".titleColorAlpha"));
    localn.PNg = Util.safeParseFloat((String)paramMap.get(paramString + ".titleColorAlphaDark"));
    localn.PNh = Util.safeParseInt((String)paramMap.get(paramString + ".basicRootFontSize"));
    localn.PNi = Util.safeParseInt((String)paramMap.get(paramString + ".basicRemWidth"));
    int i = Util.safeParseInt((String)paramMap.get(paramString + ".layoutWidth"));
    int j = Util.safeParseInt((String)paramMap.get(paramString + ".layoutHeight"));
    localn.layoutWidth = ((int)l.a(i, 1, localn.PNi, localn.PNh));
    localn.afd = ((int)l.a(j, 1, localn.PNi, localn.PNh));
    i = Util.safeParseInt((String)paramMap.get(paramString + ".cornerRadius"));
    localn.dwJ = a.fromDPToPix(MMApplicationContext.getContext(), i);
    localn.clickActionInfo = AdClickActionInfo.w(paramMap, paramString + ".clickActionInfo");
    localn.clickActionInfo.scene = 2;
    AppMethodBeat.o(309863);
    return localn;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(309865);
    if ((!Util.isNullOrNil(this.title)) || (!Util.isNullOrNil(this.iconUrl)) || (!Util.isNullOrNil(this.PNb))) {}
    for (int i = 1; (i != 0) && (this.afd > 0) && (this.layoutWidth > 0); i = 0)
    {
      AppMethodBeat.o(309865);
      return true;
    }
    AppMethodBeat.o(309865);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.n
 * JD-Core Version:    0.7.0.1
 */
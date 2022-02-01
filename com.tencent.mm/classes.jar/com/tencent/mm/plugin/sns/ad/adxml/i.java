package com.tencent.mm.plugin.sns.ad.adxml;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.d;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class i
{
  public float JyC;
  public l JyD;
  public AdClickActionInfo clickActionInfo;
  public String desc;
  public cvt fVT;
  private int mediaType;
  public String title;
  
  public static i G(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(236265);
    if (d.isEmpty(paramMap))
    {
      AppMethodBeat.o(236265);
      return null;
    }
    if (TextUtils.isEmpty(Util.nullAsNil((String)paramMap.get(paramString + ".media.id"))))
    {
      AppMethodBeat.o(236265);
      return null;
    }
    try
    {
      i locali = new i();
      locali.title = Util.nullAsNil((String)paramMap.get(paramString + ".title"));
      locali.desc = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
      locali.JyC = Util.safeParseFloat((String)paramMap.get(paramString + ".markMaxAlpha"));
      Object localObject = paramString + ".media";
      cvt localcvt = new cvt();
      localcvt.Id = ("SlideFullCardAd_" + Util.nullAsNil((String)paramMap.get(new StringBuilder().append((String)localObject).append(".id").toString())));
      localcvt.isAd = true;
      localcvt.rWu = Util.safeParseInt((String)paramMap.get((String)localObject + ".type"));
      localcvt.subType = Util.safeParseInt((String)paramMap.get((String)localObject + ".subtype"));
      localcvt.Url = Util.nullAsNil((String)paramMap.get((String)localObject + ".url"));
      localcvt.TlV = Util.safeParseInt((String)paramMap.get((String)localObject + ".url.$type"));
      localcvt.TDM = Util.nullAsNil((String)paramMap.get((String)localObject + ".url.$md5"));
      localcvt.TDF = Util.nullAsNil((String)paramMap.get((String)localObject + ".thumb"));
      localcvt.TDG = Util.safeParseInt((String)paramMap.get((String)localObject + ".thumb.$type"));
      localcvt.TDH = new cvv();
      localcvt.TDH.TEv = Util.safeParseInt((String)paramMap.get((String)localObject + ".size.$height"));
      localcvt.TDH.TEu = Util.safeParseInt((String)paramMap.get((String)localObject + ".size.$width"));
      localcvt.TDH.TEw = Util.safeParseInt((String)paramMap.get((String)localObject + ".size.$totalSize"));
      locali.fVT = localcvt;
      if (locali.fVT.rWu == 6) {}
      for (int i = 1;; i = 0)
      {
        locali.mediaType = i;
        locali.clickActionInfo = AdClickActionInfo.t(paramMap, paramString + ".clickActionInfo");
        locali.clickActionInfo.scene = 3;
        paramString = paramString + ".buttonInfo";
        localObject = new l();
        ((l)localObject).icon = Util.nullAsNil((String)paramMap.get(paramString + ".icon"));
        ((l)localObject).title = Util.nullAsNil((String)paramMap.get(paramString + ".title"));
        ((l)localObject).JyK = AdClickActionInfo.t(paramMap, paramString + ".clickActionInfo");
        ((l)localObject).JyK.scene = 4;
        locali.JyD = ((l)localObject);
        AppMethodBeat.o(236265);
        return locali;
      }
      return null;
    }
    catch (Throwable paramMap)
    {
      Log.e("AdSlideFullCardItemInfo", "parse AdSlideFullCardItemInfo error " + paramMap.getMessage());
      AppMethodBeat.o(236265);
    }
  }
  
  public static i a(i parami, int paramInt)
  {
    AppMethodBeat.i(236270);
    try
    {
      i locali = new i();
      locali.title = parami.title;
      locali.desc = parami.desc;
      locali.JyC = parami.JyC;
      cvt localcvt1 = parami.fVT;
      cvt localcvt2 = new cvt();
      localcvt2.Id = (localcvt1.Id + "_" + paramInt);
      localcvt2.isAd = true;
      localcvt2.rWu = localcvt1.rWu;
      localcvt2.subType = localcvt1.subType;
      localcvt2.Url = localcvt1.Url;
      localcvt2.TlV = localcvt1.TlV;
      localcvt2.TDM = localcvt1.TDM;
      localcvt2.TDF = localcvt1.TDF;
      localcvt2.TDG = localcvt1.TDG;
      localcvt2.TDH = new cvv();
      localcvt2.TDH.TEv = localcvt1.TDH.TEv;
      localcvt2.TDH.TEu = localcvt1.TDH.TEu;
      localcvt2.TDH.TEw = localcvt1.TDH.TEw;
      locali.fVT = localcvt2;
      locali.mediaType = parami.mediaType;
      locali.clickActionInfo = parami.clickActionInfo;
      locali.clickActionInfo.scene = 3;
      locali.JyD = parami.JyD;
      AppMethodBeat.o(236270);
      return locali;
    }
    catch (Throwable parami)
    {
      Log.e("AdSlideFullCardItemInfo", "cloneAdSlideFullCardItemInfo AdSlideFullCardItemInfo error " + parami.getMessage());
      AppMethodBeat.o(236270);
    }
    return null;
  }
  
  public final boolean fJE()
  {
    return this.mediaType == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.i
 * JD-Core Version:    0.7.0.1
 */
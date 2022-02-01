package com.tencent.mm.plugin.sns.ad.adxml;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class l
{
  public float PMX;
  public o PMY;
  public AdClickActionInfo clickActionInfo;
  public String desc;
  public dmz ibT;
  private int mediaType;
  public String title;
  
  public static l U(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(309849);
    if (d.isEmpty(paramMap))
    {
      AppMethodBeat.o(309849);
      return null;
    }
    if (TextUtils.isEmpty(Util.nullAsNil((String)paramMap.get(paramString + ".media.id"))))
    {
      AppMethodBeat.o(309849);
      return null;
    }
    try
    {
      l locall = new l();
      locall.title = Util.nullAsNil((String)paramMap.get(paramString + ".title"));
      locall.desc = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
      locall.PMX = Util.safeParseFloat((String)paramMap.get(paramString + ".markMaxAlpha"));
      Object localObject = paramString + ".media";
      dmz localdmz = new dmz();
      localdmz.Id = ("SlideFullCardAd_" + Util.nullAsNil((String)paramMap.get(new StringBuilder().append((String)localObject).append(".id").toString())));
      localdmz.isAd = true;
      localdmz.vhJ = Util.safeParseInt((String)paramMap.get((String)localObject + ".type"));
      localdmz.subType = Util.safeParseInt((String)paramMap.get((String)localObject + ".subtype"));
      localdmz.Url = Util.nullAsNil((String)paramMap.get((String)localObject + ".url"));
      localdmz.aazR = Util.safeParseInt((String)paramMap.get((String)localObject + ".url.$type"));
      localdmz.aaTs = Util.nullAsNil((String)paramMap.get((String)localObject + ".url.$md5"));
      localdmz.aaTl = Util.nullAsNil((String)paramMap.get((String)localObject + ".thumb"));
      localdmz.aaTm = Util.safeParseInt((String)paramMap.get((String)localObject + ".thumb.$type"));
      localdmz.aaTn = new dnb();
      localdmz.aaTn.aaUc = Util.safeParseInt((String)paramMap.get((String)localObject + ".size.$height"));
      localdmz.aaTn.aaUb = Util.safeParseInt((String)paramMap.get((String)localObject + ".size.$width"));
      localdmz.aaTn.aaUd = Util.safeParseInt((String)paramMap.get((String)localObject + ".size.$totalSize"));
      locall.ibT = localdmz;
      if (locall.ibT.vhJ == 6) {}
      for (int i = 1;; i = 0)
      {
        locall.mediaType = i;
        locall.clickActionInfo = AdClickActionInfo.w(paramMap, paramString + ".clickActionInfo");
        locall.clickActionInfo.scene = 3;
        paramString = paramString + ".buttonInfo";
        localObject = new o();
        ((o)localObject).icon = Util.nullAsNil((String)paramMap.get(paramString + ".icon"));
        ((o)localObject).title = Util.nullAsNil((String)paramMap.get(paramString + ".title"));
        ((o)localObject).PNj = AdClickActionInfo.w(paramMap, paramString + ".clickActionInfo");
        ((o)localObject).PNj.scene = 4;
        locall.PMY = ((o)localObject);
        AppMethodBeat.o(309849);
        return locall;
      }
      return null;
    }
    finally
    {
      Log.e("AdSlideFullCardItemInfo", "parse AdSlideFullCardItemInfo error " + paramMap.getMessage());
      AppMethodBeat.o(309849);
    }
  }
  
  public static l a(l paraml, int paramInt)
  {
    AppMethodBeat.i(309855);
    try
    {
      l locall = new l();
      locall.title = paraml.title;
      locall.desc = paraml.desc;
      locall.PMX = paraml.PMX;
      dmz localdmz1 = paraml.ibT;
      dmz localdmz2 = new dmz();
      localdmz2.Id = (localdmz1.Id + "_" + paramInt);
      localdmz2.isAd = true;
      localdmz2.vhJ = localdmz1.vhJ;
      localdmz2.subType = localdmz1.subType;
      localdmz2.Url = localdmz1.Url;
      localdmz2.aazR = localdmz1.aazR;
      localdmz2.aaTs = localdmz1.aaTs;
      localdmz2.aaTl = localdmz1.aaTl;
      localdmz2.aaTm = localdmz1.aaTm;
      localdmz2.aaTn = new dnb();
      localdmz2.aaTn.aaUc = localdmz1.aaTn.aaUc;
      localdmz2.aaTn.aaUb = localdmz1.aaTn.aaUb;
      localdmz2.aaTn.aaUd = localdmz1.aaTn.aaUd;
      locall.ibT = localdmz2;
      locall.mediaType = paraml.mediaType;
      locall.clickActionInfo = paraml.clickActionInfo;
      locall.clickActionInfo.scene = 3;
      locall.PMY = paraml.PMY;
      AppMethodBeat.o(309855);
      return locall;
    }
    finally
    {
      Log.e("AdSlideFullCardItemInfo", "cloneAdSlideFullCardItemInfo AdSlideFullCardItemInfo error " + paraml.getMessage());
      AppMethodBeat.o(309855);
    }
    return null;
  }
  
  public final boolean gZy()
  {
    return this.mediaType == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.l
 * JD-Core Version:    0.7.0.1
 */
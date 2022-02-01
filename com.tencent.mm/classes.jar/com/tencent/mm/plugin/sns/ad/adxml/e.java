package com.tencent.mm.plugin.sns.ad.adxml;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.d;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class e
{
  public String Jyn;
  public float Jyo;
  public String Jyp;
  public String Jyq;
  public String avatar;
  public String desc;
  public cvt fVT;
  private int mediaType;
  public String nickname;
  public String tag;
  
  public static e A(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(218629);
    if (d.isEmpty(paramMap))
    {
      AppMethodBeat.o(218629);
      return null;
    }
    if (TextUtils.isEmpty(Util.nullAsNil((String)paramMap.get(paramString + ".media.id"))))
    {
      AppMethodBeat.o(218629);
      return null;
    }
    try
    {
      e locale = new e();
      locale.avatar = Util.nullAsNil((String)paramMap.get(paramString + ".avatar"));
      locale.nickname = Util.nullAsNil((String)paramMap.get(paramString + ".nickname"));
      locale.tag = Util.nullAsNil((String)paramMap.get(paramString + ".tag"));
      locale.desc = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
      locale.Jyn = Util.nullAsNil((String)paramMap.get(paramString + ".barBgColor"));
      locale.Jyo = Util.safeParseFloat((String)paramMap.get(paramString + ".barBgAlpha"));
      locale.Jyp = Util.nullAsNil((String)paramMap.get(paramString + ".duration"));
      String str = paramString + ".media";
      cvt localcvt = new cvt();
      localcvt.Id = Util.nullAsNil((String)paramMap.get(str + ".id"));
      localcvt.isAd = true;
      localcvt.rWu = Util.safeParseInt((String)paramMap.get(str + ".type"));
      localcvt.subType = Util.safeParseInt((String)paramMap.get(str + ".subtype"));
      localcvt.Url = Util.nullAsNil((String)paramMap.get(str + ".url"));
      localcvt.TlV = Util.safeParseInt((String)paramMap.get(str + ".url.$type"));
      localcvt.TDM = Util.nullAsNil((String)paramMap.get(str + ".url.$md5"));
      localcvt.TDF = Util.nullAsNil((String)paramMap.get(str + ".thumb"));
      localcvt.TDG = Util.safeParseInt((String)paramMap.get(str + ".thumb.$type"));
      localcvt.TDH = new cvv();
      localcvt.TDH.TEv = Util.safeParseInt((String)paramMap.get(str + ".size.$height"));
      localcvt.TDH.TEu = Util.safeParseInt((String)paramMap.get(str + ".size.$width"));
      localcvt.TDH.TEw = Util.safeParseInt((String)paramMap.get(str + ".size.$totalSize"));
      locale.fVT = localcvt;
      if (locale.fVT.rWu == 6) {}
      for (int i = 1;; i = 0)
      {
        locale.mediaType = i;
        locale.Jyq = Util.nullAsNil((String)paramMap.get(paramString + ".finderType"));
        AppMethodBeat.o(218629);
        return locale;
      }
      return null;
    }
    catch (Throwable paramMap)
    {
      Log.e("AdFinderTopicResInfo", "parse AdFinderTopicResInfo error " + paramMap.getMessage());
      AppMethodBeat.o(218629);
    }
  }
  
  public final boolean fJE()
  {
    return this.mediaType == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.e
 * JD-Core Version:    0.7.0.1
 */
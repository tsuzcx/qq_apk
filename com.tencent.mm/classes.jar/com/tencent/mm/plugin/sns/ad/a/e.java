package com.tencent.mm.plugin.sns.ad.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class e
{
  public String DrT;
  public float DrU;
  public String DrV;
  public String DrW;
  public String desc;
  public cnb ebR;
  private int mediaType;
  public String nickname;
  public String tag;
  public String uNR;
  
  public static e z(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(201855);
    if (c.isEmpty(paramMap))
    {
      AppMethodBeat.o(201855);
      return null;
    }
    if (TextUtils.isEmpty(Util.nullAsNil((String)paramMap.get(paramString + ".media.id"))))
    {
      AppMethodBeat.o(201855);
      return null;
    }
    try
    {
      e locale = new e();
      locale.uNR = Util.nullAsNil((String)paramMap.get(paramString + ".avatar"));
      locale.nickname = Util.nullAsNil((String)paramMap.get(paramString + ".nickname"));
      locale.tag = Util.nullAsNil((String)paramMap.get(paramString + ".tag"));
      locale.desc = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
      locale.DrT = Util.nullAsNil((String)paramMap.get(paramString + ".barBgColor"));
      locale.DrU = Util.safeParseFloat((String)paramMap.get(paramString + ".barBgAlpha"));
      locale.DrV = Util.nullAsNil((String)paramMap.get(paramString + ".duration"));
      String str = paramString + ".media";
      cnb localcnb = new cnb();
      localcnb.Id = Util.nullAsNil((String)paramMap.get(str + ".id"));
      localcnb.isAd = true;
      localcnb.oUv = Util.safeParseInt((String)paramMap.get(str + ".type"));
      localcnb.subType = Util.safeParseInt((String)paramMap.get(str + ".subtype"));
      localcnb.Url = Util.nullAsNil((String)paramMap.get(str + ".url"));
      localcnb.Mcw = Util.safeParseInt((String)paramMap.get(str + ".url.$type"));
      localcnb.MsG = Util.nullAsNil((String)paramMap.get(str + ".url.$md5"));
      localcnb.Msz = Util.nullAsNil((String)paramMap.get(str + ".thumb"));
      localcnb.MsA = Util.safeParseInt((String)paramMap.get(str + ".thumb.$type"));
      localcnb.MsB = new cnd();
      localcnb.MsB.Mtp = Util.safeParseInt((String)paramMap.get(str + ".size.$height"));
      localcnb.MsB.Mto = Util.safeParseInt((String)paramMap.get(str + ".size.$width"));
      localcnb.MsB.Mtq = Util.safeParseInt((String)paramMap.get(str + ".size.$totalSize"));
      locale.ebR = localcnb;
      if (locale.ebR.oUv == 6) {}
      for (int i = 1;; i = 0)
      {
        locale.mediaType = i;
        locale.DrW = Util.nullAsNil((String)paramMap.get(paramString + ".finderType"));
        AppMethodBeat.o(201855);
        return locale;
      }
      return null;
    }
    catch (Throwable paramMap)
    {
      Log.e("AdFinderTopicResInfo", "parse AdFinderTopicResInfo error " + paramMap.getMessage());
      AppMethodBeat.o(201855);
    }
  }
  
  public final boolean eWB()
  {
    return this.mediaType == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.a.e
 * JD-Core Version:    0.7.0.1
 */
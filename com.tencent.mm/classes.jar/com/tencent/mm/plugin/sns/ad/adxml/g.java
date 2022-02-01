package com.tencent.mm.plugin.sns.ad.adxml;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class g
{
  public String PMH;
  public float PMI;
  public String PMJ;
  public String PMK;
  public String avatar;
  public String desc;
  public dmz ibT;
  private int mediaType;
  public String nickname;
  public String tag;
  
  public static g M(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(309841);
    if (d.isEmpty(paramMap))
    {
      AppMethodBeat.o(309841);
      return null;
    }
    if (TextUtils.isEmpty(Util.nullAsNil((String)paramMap.get(paramString + ".media.id"))))
    {
      AppMethodBeat.o(309841);
      return null;
    }
    try
    {
      g localg = new g();
      localg.avatar = Util.nullAsNil((String)paramMap.get(paramString + ".avatar"));
      localg.nickname = Util.nullAsNil((String)paramMap.get(paramString + ".nickname"));
      localg.tag = Util.nullAsNil((String)paramMap.get(paramString + ".tag"));
      localg.desc = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
      localg.PMH = Util.nullAsNil((String)paramMap.get(paramString + ".barBgColor"));
      localg.PMI = Util.safeParseFloat((String)paramMap.get(paramString + ".barBgAlpha"));
      localg.PMJ = Util.nullAsNil((String)paramMap.get(paramString + ".duration"));
      String str = paramString + ".media";
      dmz localdmz = new dmz();
      localdmz.Id = Util.nullAsNil((String)paramMap.get(str + ".id"));
      localdmz.isAd = true;
      localdmz.vhJ = Util.safeParseInt((String)paramMap.get(str + ".type"));
      localdmz.subType = Util.safeParseInt((String)paramMap.get(str + ".subtype"));
      localdmz.Url = Util.nullAsNil((String)paramMap.get(str + ".url"));
      localdmz.aazR = Util.safeParseInt((String)paramMap.get(str + ".url.$type"));
      localdmz.aaTs = Util.nullAsNil((String)paramMap.get(str + ".url.$md5"));
      localdmz.aaTl = Util.nullAsNil((String)paramMap.get(str + ".thumb"));
      localdmz.aaTm = Util.safeParseInt((String)paramMap.get(str + ".thumb.$type"));
      localdmz.aaTn = new dnb();
      localdmz.aaTn.aaUc = Util.safeParseInt((String)paramMap.get(str + ".size.$height"));
      localdmz.aaTn.aaUb = Util.safeParseInt((String)paramMap.get(str + ".size.$width"));
      localdmz.aaTn.aaUd = Util.safeParseInt((String)paramMap.get(str + ".size.$totalSize"));
      localg.ibT = localdmz;
      if (localg.ibT.vhJ == 6) {}
      for (int i = 1;; i = 0)
      {
        localg.mediaType = i;
        localg.PMK = Util.nullAsNil((String)paramMap.get(paramString + ".finderType"));
        AppMethodBeat.o(309841);
        return localg;
      }
      return null;
    }
    finally
    {
      Log.e("AdFinderTopicResInfo", "parse AdFinderTopicResInfo error " + paramMap.getMessage());
      AppMethodBeat.o(309841);
    }
  }
  
  public final boolean gZy()
  {
    return this.mediaType == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.g
 * JD-Core Version:    0.7.0.1
 */
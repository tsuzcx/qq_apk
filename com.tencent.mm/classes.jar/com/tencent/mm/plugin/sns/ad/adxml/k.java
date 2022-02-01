package com.tencent.mm.plugin.sns.ad.adxml;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class k
{
  public String JyG;
  public String JyH;
  public int JyI;
  public int JyJ;
  public float bDI;
  public AdClickActionInfo clickActionInfo;
  public int zPO;
  public int zPP;
  
  public static k J(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(198986);
    k localk = new k();
    localk.JyG = Util.nullAsNil((String)paramMap.get(paramString + ".bgImageUrl"));
    localk.JyH = Util.nullAsNil((String)paramMap.get(paramString + ".bgImageUrlDark"));
    if ((TextUtils.isEmpty(localk.JyH)) && (!TextUtils.isEmpty(localk.JyG)))
    {
      localk.JyH = localk.JyG;
      Log.w("AdTagButtonInfo", "bgImageUrlDark is empty");
    }
    if ((TextUtils.isEmpty(localk.JyG)) && (!TextUtils.isEmpty(localk.JyH)))
    {
      localk.JyG = localk.JyH;
      Log.w("AdTagButtonInfo", "bgImageUrl is empty");
    }
    localk.JyI = Util.safeParseInt((String)paramMap.get(paramString + ".basicRootFontSize"));
    localk.JyJ = Util.safeParseInt((String)paramMap.get(paramString + ".basicRemWidth"));
    int i = Util.safeParseInt((String)paramMap.get(paramString + ".layoutWidth"));
    int j = Util.safeParseInt((String)paramMap.get(paramString + ".layoutHeight"));
    localk.zPO = ((int)i.a(i, 1, localk.JyJ, localk.JyI));
    localk.zPP = ((int)i.a(j, 1, localk.JyJ, localk.JyI));
    i = Util.safeParseInt((String)paramMap.get(paramString + ".cornerRadius"));
    localk.bDI = a.fromDPToPix(MMApplicationContext.getContext(), i);
    localk.clickActionInfo = AdClickActionInfo.t(paramMap, paramString + ".clickActionInfo");
    localk.clickActionInfo.scene = 2;
    AppMethodBeat.o(198986);
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.k
 * JD-Core Version:    0.7.0.1
 */
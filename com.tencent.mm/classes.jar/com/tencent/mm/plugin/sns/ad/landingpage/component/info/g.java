package com.tencent.mm.plugin.sns.ad.landingpage.component.info;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class g
  extends aa
{
  public String POQ;
  @p(hkF=1)
  public String PRX;
  public String PRY;
  public String PRZ;
  @p(hkF=1)
  public String PSa;
  public String PSb;
  public String PSc;
  public g.a[] PSd;
  public String jumpUrl;
  public String svG;
  public String title;
  
  public g()
  {
    AppMethodBeat.i(310643);
    this.PSd = new g.a[4];
    AppMethodBeat.o(310643);
  }
  
  public static g Z(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(310650);
    for (;;)
    {
      try
      {
        localg = new g();
        localg.PRX = Util.nullAsNil((String)paramMap.get(paramString + ".hbImgUrl"));
        localg.title = Util.nullAsNil((String)paramMap.get(paramString + ".title"));
        localg.svG = Util.nullAsNil((String)paramMap.get(paramString + ".shareTitle"));
        localg.PSa = Util.nullAsNil((String)paramMap.get(paramString + ".shareThumbUrl"));
        localg.jumpUrl = Util.nullAsNil((String)paramMap.get(paramString + ".jumpUrl"));
        localg.PRY = Util.nullAsNil((String)paramMap.get(paramString + ".inviteLinkTxt"));
        localg.PRZ = m.lP(Util.nullAsNil((String)paramMap.get(paramString + ".inviteLinkTxtColor")), Util.nullAsNil((String)paramMap.get(paramString + ".inviteLinkTxtColorAlpha")));
        localg.PSb = m.lP(Util.nullAsNil((String)paramMap.get(paramString + ".btnTxtColor")), Util.nullAsNil((String)paramMap.get(paramString + ".btnTxtColorAlpha")));
        if (TextUtils.isEmpty(localg.PSb)) {
          localg.PSb = "#FFFFFF";
        }
        localg.PSc = m.lP(Util.nullAsNil((String)paramMap.get(paramString + ".btnBgColor")), Util.nullAsNil((String)paramMap.get(paramString + ".btnBgColorAlpha")));
        if (!TextUtils.isEmpty(localg.PSc)) {
          break label648;
        }
        localg.PSc = "#FA5151";
      }
      finally
      {
        g localg;
        StringBuilder localStringBuilder;
        Object localObject;
        int j;
        Log.e("MicroMsg.AdLandingPageComponentInfo", "parse, exp=" + paramMap.toString());
        Log.e("MicroMsg.AdLandingPageComponentInfo", "parse, null");
        AppMethodBeat.o(310650);
        return null;
      }
      localStringBuilder = new StringBuilder().append(paramString).append(".item");
      if (i == 0)
      {
        localObject = "";
        localObject = localObject;
        if (paramMap.containsKey(localObject))
        {
          j = Util.safeParseInt((String)paramMap.get((String)localObject + ".subType"));
          if ((j <= 0) || (j > 4)) {
            break label653;
          }
          localObject = aa(paramMap, (String)localObject);
          localg.PSd[(j - 1)] = localObject;
          break label653;
        }
      }
      else
      {
        localObject = Integer.valueOf(i);
        continue;
      }
      AppMethodBeat.o(310650);
      return localg;
      label648:
      int i = 0;
      continue;
      label653:
      i += 1;
    }
  }
  
  private static g.a aa(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(310655);
    Log.d("MicroMsg.AdLandingPageComponentInfo", "parseHBCardInfo, pref=".concat(String.valueOf(paramString)));
    for (;;)
    {
      g.a locala;
      int i;
      try
      {
        locala = new g.a();
        locala.subType = Util.safeParseInt((String)paramMap.get(paramString + ".subType"));
        if (locala.subType == 3) {
          break label533;
        }
        locala.PSe = Util.nullAsNil((String)paramMap.get(paramString + ".headline"));
        locala.desc = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
        locala.PSf = Util.nullAsNil((String)paramMap.get(paramString + ".decorationTitle"));
        locala.btnTitle = Util.nullAsNil((String)paramMap.get(paramString + ".btnTitle"));
        locala.PSg = Util.nullAsNil((String)paramMap.get(paramString + ".btnTitleAfterAction"));
        locala.PSh = Util.nullAsNil((String)paramMap.get(paramString + ".btnTitleExpired"));
        locala.PSi = Util.nullAsNil((String)paramMap.get(paramString + ".btnTitleGetByOther"));
        locala.expireTime = Util.safeParseInt((String)paramMap.get(paramString + ".expireTime"));
      }
      finally
      {
        StringBuilder localStringBuilder;
        Object localObject;
        int j;
        Log.e("MicroMsg.AdLandingPageComponentInfo", "parseHBCardInfo, exp=" + paramMap.toString());
        AppMethodBeat.o(310655);
        return null;
      }
      localStringBuilder = new StringBuilder().append(paramString).append(".item");
      if (i == 0)
      {
        localObject = "";
        localObject = localObject;
        if (!paramMap.containsKey(localObject)) {
          break label525;
        }
        j = Util.safeParseInt((String)paramMap.get((String)localObject + ".subType"));
        if (j == 1)
        {
          locala.PSj = aa(paramMap, (String)localObject);
          break label538;
        }
      }
      else
      {
        localObject = Integer.valueOf(i);
        continue;
      }
      if (j == 2)
      {
        locala.PSk = aa(paramMap, (String)localObject);
        break label538;
        label525:
        AppMethodBeat.o(310655);
        return locala;
        label533:
        i = 0;
        continue;
      }
      label538:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.info.g
 * JD-Core Version:    0.7.0.1
 */
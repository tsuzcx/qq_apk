package com.tencent.mm.plugin.sns.ad.adxml;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdClickActionInfo
{
  public String PLA;
  public String PLB;
  public String PLC;
  public String PLD;
  public String PLE;
  public String PLF;
  public String PLG;
  public String PLH;
  public String PLI;
  public String PLJ;
  public String PLK;
  public String PLL;
  public String PLM;
  public String PLN;
  public String PLO;
  public String PLP;
  public String PLQ;
  public String PLR;
  public String PLS;
  public boolean PLT;
  public String PLU;
  public String PLV;
  public String PLW;
  public String PLX;
  public String PLY;
  public String PLZ;
  public String PLk;
  public String PLl;
  public int PLm;
  public String PLn;
  public int PLo;
  public String PLp;
  public String PLq;
  public String PLr;
  public String PLs;
  public String PLt;
  public String PLu;
  public String PLv;
  public String PLw;
  public String PLx;
  public String PLy;
  public long PLz;
  public String PMa;
  public String PMb;
  public List<e.a.a> PMc;
  public String PMd;
  public String PMe;
  public String PMf;
  public a PMg;
  public String appGiftPackCode;
  public String appGiftPackCodeTips;
  public String appId;
  public String finderLiveId;
  public String finderNickName;
  public String finderUsername;
  public String hEy;
  public String nUS;
  public int nUT;
  public String owR;
  public int scene;
  public String wtm;
  public String wui;
  public String xVm;
  
  public AdClickActionInfo()
  {
    AppMethodBeat.i(309864);
    this.PMc = new ArrayList();
    AppMethodBeat.o(309864);
  }
  
  private static void a(AdClickActionInfo paramAdClickActionInfo, Map<String, String> paramMap, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(309881);
    if (d.isEmpty(paramMap))
    {
      AppMethodBeat.o(309881);
      return;
    }
    try
    {
      if (!paramMap.containsKey(paramString))
      {
        paramAdClickActionInfo.PLT = false;
        return;
      }
      paramAdClickActionInfo.PLT = true;
      paramAdClickActionInfo.PLU = Util.nullAsNil((String)paramMap.get(paramString + ".bgImage"));
      paramAdClickActionInfo.PLV = Util.nullAsNil((String)paramMap.get(paramString + ".avatar"));
      paramAdClickActionInfo.PLW = Util.nullAsNil((String)paramMap.get(paramString + ".nickname"));
      Object localObject = new e.a.b().I(paramMap, paramString + ".productInfo");
      paramAdClickActionInfo.PLX = ((e.a.b)localObject).PLX;
      paramAdClickActionInfo.PLY = ((e.a.b)localObject).PLY;
      paramAdClickActionInfo.PLZ = ((e.a.b)localObject).PLZ;
      paramAdClickActionInfo.PMa = ((e.a.b)localObject).PMa;
      paramAdClickActionInfo.PMb = ((e.a.b)localObject).PMb;
      localObject = paramString + ".liveCheerIconList.iconInfo";
      StringBuilder localStringBuilder = new StringBuilder().append((String)localObject);
      if (i == 0) {}
      for (paramString = "";; paramString = Integer.valueOf(i))
      {
        paramString = paramString;
        if (!paramMap.containsKey(paramString)) {
          break label329;
        }
        paramString = new e.a.a().H(paramMap, paramString);
        paramAdClickActionInfo.PMc.add(paramString);
        i += 1;
        break;
      }
      label329:
      return;
    }
    finally
    {
      AppMethodBeat.o(309881);
    }
  }
  
  public static AdClickActionInfo w(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(309875);
    AdClickActionInfo localAdClickActionInfo = new AdClickActionInfo();
    localAdClickActionInfo.PLm = Util.getInt((String)paramMap.get(paramString + ".clickActionType"), 0);
    localAdClickActionInfo.PLn = Util.nullAsNil((String)paramMap.get(paramString + ".clickActionLink"));
    localAdClickActionInfo.xVm = Util.nullAsNil((String)paramMap.get(paramString + ".weappUserName"));
    localAdClickActionInfo.nUS = Util.nullAsNil((String)paramMap.get(paramString + ".weappPath"));
    localAdClickActionInfo.nUT = Util.getInt((String)paramMap.get(paramString + ".weappVersion"), 0);
    localAdClickActionInfo.PLo = Util.safeParseInt((String)paramMap.get(paramString + ".miniProgramType"));
    localAdClickActionInfo.PLp = Util.nullAsNil((String)paramMap.get(paramString + ".tempId"));
    localAdClickActionInfo.PLq = Util.nullAsNil((String)paramMap.get(paramString + ".btnTitleAfterOrder"));
    localAdClickActionInfo.PLr = Util.nullAsNil((String)paramMap.get(paramString + ".subscribeTitle"));
    localAdClickActionInfo.PLs = Util.nullAsNil((String)paramMap.get(paramString + ".subscribeContent"));
    localAdClickActionInfo.PLt = Util.nullAsNil((String)paramMap.get(paramString + ".subscribeSubmitBtnTitle"));
    localAdClickActionInfo.PLu = Util.nullAsNil((String)paramMap.get(paramString + ".subscribeFailedTip"));
    localAdClickActionInfo.PLv = Util.nullAsNil((String)paramMap.get(paramString + ".subscribeSucTip"));
    localAdClickActionInfo.PLw = Util.nullAsNil((String)paramMap.get(paramString + ".appType"));
    localAdClickActionInfo.appId = Util.nullAsNil((String)paramMap.get(paramString + ".appId"));
    localAdClickActionInfo.PLx = Util.nullAsNil((String)paramMap.get(paramString + ".subscribeHeadImg"));
    localAdClickActionInfo.PLy = Util.nullAsNil((String)paramMap.get(paramString + ".subscribeNickname"));
    localAdClickActionInfo.PLz = t.aXD((String)paramMap.get(paramString + ".subscribeExpiredTime"));
    localAdClickActionInfo.PLA = Util.nullAsNil((String)paramMap.get(paramString + ".subscribeExpiredTip"));
    localAdClickActionInfo.PLB = Util.nullAsNil((String)paramMap.get(paramString + ".openSdkAppId"));
    localAdClickActionInfo.PLC = Util.nullAsNil((String)paramMap.get(paramString + ".packageName"));
    localAdClickActionInfo.PLD = Util.nullAsNil((String)paramMap.get(paramString + ".appPageUrlAndroid"));
    localAdClickActionInfo.wtm = Util.nullAsNil((String)paramMap.get(paramString + ".cardTpId"));
    localAdClickActionInfo.wui = Util.nullAsNil((String)paramMap.get(paramString + ".cardExt"));
    localAdClickActionInfo.owR = Util.nullAsNil((String)paramMap.get(paramString + ".brandUsername"));
    localAdClickActionInfo.PLE = Util.nullAsNil((String)paramMap.get(paramString + ".brandHead"));
    localAdClickActionInfo.hEy = Util.nullAsNil((String)paramMap.get(paramString + ".brandName"));
    localAdClickActionInfo.PLF = Util.nullAsNil((String)paramMap.get(paramString + ".brandDesc"));
    localAdClickActionInfo.PLG = Util.nullAsNil((String)paramMap.get(paramString + ".btnTitleAfterAddBrand"));
    localAdClickActionInfo.PLH = Util.nullAsNil((String)paramMap.get(paramString + ".couponAppId"));
    localAdClickActionInfo.PLI = Util.nullAsNil((String)paramMap.get(paramString + ".couponStockId"));
    localAdClickActionInfo.PLJ = Util.nullAsNil((String)paramMap.get(paramString + ".couponSenderPhoto"));
    localAdClickActionInfo.PLK = Util.nullAsNil((String)paramMap.get(paramString + ".couponSenderName"));
    localAdClickActionInfo.PLL = Util.nullAsNil((String)paramMap.get(paramString + ".couponName"));
    localAdClickActionInfo.PLM = Util.nullAsNil((String)paramMap.get(paramString + ".couponDesc"));
    localAdClickActionInfo.finderUsername = Util.nullAsNil((String)paramMap.get(paramString + ".finderUsername"));
    localAdClickActionInfo.PLN = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveNoticeId"));
    localAdClickActionInfo.PLO = Util.nullAsNil((String)paramMap.get(paramString + ".finderAvatar"));
    localAdClickActionInfo.finderNickName = Util.nullAsNil((String)paramMap.get(paramString + ".finderNickname"));
    localAdClickActionInfo.PLP = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveTitle"));
    localAdClickActionInfo.finderLiveId = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveId"));
    localAdClickActionInfo.PLR = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveFeedExportId"));
    localAdClickActionInfo.PLS = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveFeedNonceId"));
    a(localAdClickActionInfo, paramMap, paramString + ".finderLivePreviewInfo");
    localAdClickActionInfo.PLk = Util.nullAsNil((String)paramMap.get(paramString + ".finderEncryptedTopicId"));
    localAdClickActionInfo.PLl = Util.nullAsNil((String)paramMap.get(paramString + ".finderTopicName"));
    localAdClickActionInfo.PMd = Util.nullAsNil((String)paramMap.get(paramString + ".finderObjectNonceId"));
    localAdClickActionInfo.PMe = Util.nullAsNil((String)paramMap.get(paramString + ".finderExportId"));
    localAdClickActionInfo.PLQ = Util.nullAsNil((String)paramMap.get(paramString + ".finderDesc"));
    localAdClickActionInfo.PMf = Util.nullAsNil((String)paramMap.get(paramString + ".finderFollowingBtnTitle"));
    localAdClickActionInfo.appGiftPackCode = Util.nullAsNil((String)paramMap.get(paramString + ".appGiftPackCode"));
    localAdClickActionInfo.appGiftPackCodeTips = Util.nullAsNil((String)paramMap.get(paramString + ".appGiftPackCodeTips"));
    localAdClickActionInfo.PMg = a.u(paramMap, paramString + ".appointmentInfo");
    AppMethodBeat.o(309875);
    return localAdClickActionInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo
 * JD-Core Version:    0.7.0.1
 */
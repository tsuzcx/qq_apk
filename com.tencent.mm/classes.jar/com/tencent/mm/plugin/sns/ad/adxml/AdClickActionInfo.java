package com.tencent.mm.plugin.sns.ad.adxml;

import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class AdClickActionInfo
{
  public String JxA;
  public String JxB;
  public String JxC;
  public String JxD;
  public String JxE;
  public String JxF;
  public String JxG;
  public String JxH;
  public String JxI;
  public String JxJ;
  public long JxK;
  public String JxL;
  public String JxM;
  public String JxN;
  public String JxO;
  public String JxP;
  public String JxQ;
  public String JxR;
  public String JxS;
  public String JxT;
  public String JxU;
  public String JxV;
  public String JxW;
  public String JxX;
  public String JxY;
  public String JxZ;
  public String Jxv;
  public String Jxw;
  public int Jxx;
  public String Jxy;
  public int Jxz;
  public String Jya;
  public String Jyb;
  public String Jyc;
  public String Jyd;
  public String Jye;
  public String Jyf;
  public String Jyg;
  public String Jyh;
  public String appGiftPackCode;
  public String appGiftPackCodeTips;
  public String appId;
  @Keep
  public String finderLiveId;
  @Keep
  public String finderUsername;
  public String fzM;
  public String lFl;
  public String lpQ;
  public int lpR;
  public int scene;
  public String toN;
  public String tpJ;
  public String uMJ;
  
  public static AdClickActionInfo t(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(231882);
    AdClickActionInfo localAdClickActionInfo = new AdClickActionInfo();
    localAdClickActionInfo.Jxx = Util.getInt((String)paramMap.get(paramString + ".clickActionType"), 0);
    localAdClickActionInfo.Jxy = Util.nullAsNil((String)paramMap.get(paramString + ".clickActionLink"));
    localAdClickActionInfo.uMJ = Util.nullAsNil((String)paramMap.get(paramString + ".weappUserName"));
    localAdClickActionInfo.lpQ = Util.nullAsNil((String)paramMap.get(paramString + ".weappPath"));
    localAdClickActionInfo.lpR = Util.getInt((String)paramMap.get(paramString + ".weappVersion"), 0);
    localAdClickActionInfo.Jxz = Util.safeParseInt((String)paramMap.get(paramString + ".miniProgramType"));
    localAdClickActionInfo.JxA = Util.nullAsNil((String)paramMap.get(paramString + ".tempId"));
    localAdClickActionInfo.JxB = Util.nullAsNil((String)paramMap.get(paramString + ".btnTitleAfterOrder"));
    localAdClickActionInfo.JxC = Util.nullAsNil((String)paramMap.get(paramString + ".subscribeTitle"));
    localAdClickActionInfo.JxD = Util.nullAsNil((String)paramMap.get(paramString + ".subscribeContent"));
    localAdClickActionInfo.JxE = Util.nullAsNil((String)paramMap.get(paramString + ".subscribeSubmitBtnTitle"));
    localAdClickActionInfo.JxF = Util.nullAsNil((String)paramMap.get(paramString + ".subscribeFailedTip"));
    localAdClickActionInfo.JxG = Util.nullAsNil((String)paramMap.get(paramString + ".subscribeSucTip"));
    localAdClickActionInfo.JxH = Util.nullAsNil((String)paramMap.get(paramString + ".appType"));
    localAdClickActionInfo.appId = Util.nullAsNil((String)paramMap.get(paramString + ".appId"));
    localAdClickActionInfo.JxI = Util.nullAsNil((String)paramMap.get(paramString + ".subscribeHeadImg"));
    localAdClickActionInfo.JxJ = Util.nullAsNil((String)paramMap.get(paramString + ".subscribeNickname"));
    localAdClickActionInfo.JxK = t.aZs((String)paramMap.get(paramString + ".subscribeExpiredTime"));
    localAdClickActionInfo.JxL = Util.nullAsNil((String)paramMap.get(paramString + ".subscribeExpiredTip"));
    localAdClickActionInfo.JxM = Util.nullAsNil((String)paramMap.get(paramString + ".openSdkAppId"));
    localAdClickActionInfo.JxN = Util.nullAsNil((String)paramMap.get(paramString + ".packageName"));
    localAdClickActionInfo.JxO = Util.nullAsNil((String)paramMap.get(paramString + ".appPageUrlAndroid"));
    localAdClickActionInfo.toN = Util.nullAsNil((String)paramMap.get(paramString + ".cardTpId"));
    localAdClickActionInfo.tpJ = Util.nullAsNil((String)paramMap.get(paramString + ".cardExt"));
    localAdClickActionInfo.lFl = Util.nullAsNil((String)paramMap.get(paramString + ".brandUsername"));
    localAdClickActionInfo.JxP = Util.nullAsNil((String)paramMap.get(paramString + ".brandHead"));
    localAdClickActionInfo.fzM = Util.nullAsNil((String)paramMap.get(paramString + ".brandName"));
    localAdClickActionInfo.JxQ = Util.nullAsNil((String)paramMap.get(paramString + ".brandDesc"));
    localAdClickActionInfo.JxR = Util.nullAsNil((String)paramMap.get(paramString + ".btnTitleAfterAddBrand"));
    localAdClickActionInfo.JxS = Util.nullAsNil((String)paramMap.get(paramString + ".couponAppId"));
    localAdClickActionInfo.JxT = Util.nullAsNil((String)paramMap.get(paramString + ".couponStockId"));
    localAdClickActionInfo.JxU = Util.nullAsNil((String)paramMap.get(paramString + ".couponSenderPhoto"));
    localAdClickActionInfo.JxV = Util.nullAsNil((String)paramMap.get(paramString + ".couponSenderName"));
    localAdClickActionInfo.JxW = Util.nullAsNil((String)paramMap.get(paramString + ".couponName"));
    localAdClickActionInfo.JxX = Util.nullAsNil((String)paramMap.get(paramString + ".couponDesc"));
    localAdClickActionInfo.finderUsername = Util.nullAsNil((String)paramMap.get(paramString + ".finderUsername"));
    localAdClickActionInfo.JxY = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveNoticeId"));
    localAdClickActionInfo.JxZ = Util.nullAsNil((String)paramMap.get(paramString + ".finderAvatar"));
    localAdClickActionInfo.Jya = Util.nullAsNil((String)paramMap.get(paramString + ".finderNickname"));
    localAdClickActionInfo.Jyb = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveTitle"));
    localAdClickActionInfo.finderLiveId = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveId"));
    localAdClickActionInfo.Jyd = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveFeedExportId"));
    localAdClickActionInfo.Jye = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveFeedNonceId"));
    localAdClickActionInfo.Jxv = Util.nullAsNil((String)paramMap.get(paramString + ".finderEncryptedTopicId"));
    localAdClickActionInfo.Jxw = Util.nullAsNil((String)paramMap.get(paramString + ".finderTopicName"));
    localAdClickActionInfo.Jyf = Util.nullAsNil((String)paramMap.get(paramString + ".finderObjectNonceId"));
    localAdClickActionInfo.Jyg = Util.nullAsNil((String)paramMap.get(paramString + ".finderExportId"));
    localAdClickActionInfo.Jyc = Util.nullAsNil((String)paramMap.get(paramString + ".finderDesc"));
    localAdClickActionInfo.Jyh = Util.nullAsNil((String)paramMap.get(paramString + ".finderFollowingBtnTitle"));
    localAdClickActionInfo.appGiftPackCode = Util.nullAsNil((String)paramMap.get(paramString + ".appGiftPackCode"));
    localAdClickActionInfo.appGiftPackCodeTips = Util.nullAsNil((String)paramMap.get(paramString + ".appGiftPackCodeTips"));
    AppMethodBeat.o(231882);
    return localAdClickActionInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo
 * JD-Core Version:    0.7.0.1
 */
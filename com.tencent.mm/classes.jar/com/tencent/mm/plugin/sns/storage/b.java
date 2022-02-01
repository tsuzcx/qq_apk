package com.tencent.mm.plugin.sns.storage;

import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.device.appstore.a;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b
{
  public String dCX;
  public String nickname;
  public String zLV;
  public int zMQ;
  public String zMR;
  public int zMS;
  public int zMT;
  public String zMU;
  public String zMV;
  public String zMW;
  public String zMX;
  public String zMY;
  public int zMZ;
  boolean zMi;
  public float zNA;
  public float zNB;
  public float zNC;
  public int zND;
  public String zNE;
  public String zNF;
  public String zNG;
  public String zNH;
  public d zNI;
  public k zNJ;
  public h zNK;
  public j zNL;
  public f zNM;
  public boolean zNN;
  public String zNO;
  public String zNP;
  public int zNQ;
  public int zNR;
  public String zNS;
  public b.n zNT;
  public String zNU;
  public Intent zNV;
  public int zNW;
  public int zNX;
  public int zNY;
  public b zNZ;
  public String zNa;
  public String zNb;
  public int zNc;
  public String zNd;
  public int zNe;
  public String zNf;
  public String zNg;
  public String zNh;
  public String zNi;
  public String zNj;
  public String zNk;
  public int zNl;
  public int zNm;
  public int zNn;
  public long zNo;
  public Map<String, String> zNp;
  boolean zNq;
  public int zNr;
  public int zNs;
  public float zNt;
  public float zNu;
  public int zNv;
  public int zNw;
  public int zNx;
  public String zNy;
  public float zNz;
  public a zOa;
  public int zOb;
  public int zOc;
  private i zOd;
  public l zOe;
  public String zsJ;
  public c zsZ;
  
  public b(String paramString)
  {
    AppMethodBeat.i(96269);
    this.dCX = "";
    this.zMS = 0;
    this.zMT = 0;
    this.zMU = "";
    this.zMV = "";
    this.zMW = "";
    this.zMX = "";
    this.zMY = "";
    this.zMZ = 0;
    this.zNa = "";
    this.zNb = "";
    this.zNc = 0;
    this.zNd = "";
    this.zNe = 0;
    this.zNf = "";
    this.zNg = "";
    this.zNh = "";
    this.zNi = "";
    this.zNj = "";
    this.zNk = "";
    this.zNp = new HashMap();
    this.zNW = 0;
    this.zNX = 0;
    this.zNY = 0;
    this.zOc = -1;
    if ((!bu.isNullOrNil(paramString)) && (paramString.trim().startsWith("<RecXml")))
    {
      paramString = aF(paramString, ".RecXml", "RecXml");
      if ((paramString != null) && (!paramString.isEmpty()))
      {
        this.zNl = bu.aSB((String)paramString.get(".RecXml.$type"));
        this.zNm = bu.aSB((String)paramString.get(".RecXml.$source"));
        this.zNn = bu.aSB((String)paramString.get(".RecXml.$expId"));
        this.zNo = r.azz((String)paramString.get(".RecXml.$expOriginSnsId"));
      }
      AppMethodBeat.o(96269);
      return;
    }
    aF(paramString, "", "adxml");
    AppMethodBeat.o(96269);
  }
  
  private Map<String, String> aF(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96270);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString3)))
    {
      AppMethodBeat.o(96270);
      return null;
    }
    this.dCX = paramString1;
    ae.i("MicroMsg.ADXml", "feed xml %s, keyPrefix %s, tag %s", new Object[] { paramString1, paramString2, paramString3 });
    Map localMap = bx.M(paramString1, paramString3);
    if (localMap == null)
    {
      AppMethodBeat.o(96270);
      return null;
    }
    this.zMQ = bu.aSB((String)localMap.get(paramString2 + ".adxml.adType"));
    this.zMR = bu.bI((String)localMap.get(paramString2 + ".adxml.adActionTitle"), "");
    this.zLV = bu.bI((String)localMap.get(paramString2 + ".adxml.adActionLink"), "");
    this.nickname = bu.bI((String)localMap.get(paramString2 + ".adxml.nickname"), "");
    this.zMS = bu.aSB((String)localMap.get(paramString2 + ".adxml.webviewRightBarShow"));
    this.zMT = bu.aSB((String)localMap.get(paramString2 + ".adxml.adActionLinkHidden"));
    this.zMU = bu.bI((String)localMap.get(paramString2 + ".adxml.adActionLinkName"), "");
    this.zMV = bu.bI((String)localMap.get(paramString2 + ".adxml.adActionLinkIcon"), "");
    this.zMW = bu.bI((String)localMap.get(paramString2 + ".adxml.adActionLinkTitle.zh"), "");
    this.zMY = bu.bI((String)localMap.get(paramString2 + ".adxml.adActionLinkTitle.tw"), "");
    this.zMX = bu.bI((String)localMap.get(paramString2 + ".adxml.adActionLinkTitle.en"), "");
    this.zNa = bu.bI((String)localMap.get(paramString2 + ".adxml.attachShareLinkWording"), "");
    this.zNb = bu.bI((String)localMap.get(paramString2 + ".adxml.attachShareLinkUrl"), "");
    this.zMZ = bu.aSB((String)localMap.get(paramString2 + ".adxml.attachShareLinkIsHidden"));
    if ((bu.isNullOrNil(this.zNa)) || (bu.isNullOrNil(this.zNb))) {
      this.zMZ = 1;
    }
    this.zNf = bu.bI((String)localMap.get(paramString2 + ".adxml.expandOutsideTitle.zh"), "");
    this.zNh = bu.bI((String)localMap.get(paramString2 + ".adxml.expandOutsideTitle.tw"), "");
    this.zNg = bu.bI((String)localMap.get(paramString2 + ".adxml.expandOutsideTitle.en"), "");
    this.zNi = bu.bI((String)localMap.get(paramString2 + ".adxml.expandInsideTitle.zh"), "");
    this.zNk = bu.bI((String)localMap.get(paramString2 + ".adxml.expandInsideTitle.tw"), "");
    this.zNj = bu.bI((String)localMap.get(paramString2 + ".adxml.expandInsideTitle.en"), "");
    this.zNc = bu.aSB((String)localMap.get(paramString2 + ".adxml.headClickType"));
    this.zNd = bu.bI((String)localMap.get(paramString2 + ".adxml.headClickParam"), "");
    this.zNe = bu.aSB((String)localMap.get(paramString2 + ".adxml.headClickRightBarShow"));
    this.zNW = bu.aSB((String)localMap.get(paramString2 + ".adxml.toAdMarket"));
    this.zNX = bu.aSB((String)localMap.get(paramString2 + ".adxml.newFeedback"));
    this.zNY = bu.aSB((String)localMap.get(paramString2 + ".adxml.videoPlayInStreamingMode"));
    int i = 0;
    paramString3 = new StringBuilder().append(paramString2).append(".adxml.adArgs.arg");
    label1128:
    Object localObject1;
    Object localObject2;
    if (i == 0)
    {
      paramString1 = "";
      paramString3 = paramString1 + ".key";
      localObject1 = (String)localMap.get(paramString3);
      if (localObject1 == null) {
        break label1313;
      }
      localObject2 = new StringBuilder().append(paramString2).append(".adxml.adArgs.arg");
      if (i != 0) {
        break label1304;
      }
    }
    label1304:
    for (paramString1 = "";; paramString1 = Integer.valueOf(i))
    {
      paramString1 = paramString1 + ".value";
      localObject2 = (String)localMap.get(paramString1);
      ae.i("MicroMsg.ADXml", "newKey " + paramString3 + " " + (String)localObject1 + " newValue : " + paramString1 + " " + (String)localObject2);
      this.zNp.put(localObject1, localObject2);
      i += 1;
      break;
      paramString1 = Integer.valueOf(i);
      break label1128;
    }
    label1313:
    this.zMi = localMap.containsKey(paramString2 + ".adxml.adCanvasInfo");
    boolean bool;
    if (bu.aSB((String)localMap.get(paramString2 + ".adxml.usePreferedInfo")) == 1)
    {
      bool = true;
      this.zNN = bool;
      this.zNO = bu.nullAsNil((String)localMap.get(paramString2 + ".adxml.preferNickname"));
      this.zNP = bu.nullAsNil((String)localMap.get(paramString2 + ".adxml.preferAvatar"));
      this.zNr = bu.aSB((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.contentDisplayType"));
      this.zNs = bu.aSB((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaDisplayMode"));
      this.zNt = ((float)bu.aSD((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaDisplayWidth")));
      this.zNu = ((float)bu.aSD((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaDisplayHeight")));
      this.zNx = bu.aSB((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.btnDisplayType"));
      this.zNy = bu.bI((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconUrl"), "");
      this.zNv = bu.aSB((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.basicRemWidth"));
      this.zNw = bu.aSB((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.basicRootFontSize"));
      this.zNz = ((float)bu.aSD((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconWidth")));
      this.zNA = ((float)bu.aSD((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconHeight")));
      this.zNB = ((float)bu.aSD((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingRight")));
      this.zNC = ((float)bu.aSD((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingBottom")));
      this.zND = bu.aSB((String)localMap.get(paramString2 + ".adxml.adContentStyle"));
      this.zNE = bu.bI((String)localMap.get(paramString2 + ".adxml.adCardInfo.title"), "");
      this.zNF = bu.bI((String)localMap.get(paramString2 + ".adxml.adCardInfo.description"), "");
      this.zNI = new d().u(localMap, paramString2);
      this.zNG = bu.nullAsNil((String)localMap.get(paramString2 + ".adxml.adCardInfo.adRatingCardInfo.headTitle"));
      this.zNH = bu.nullAsNil((String)localMap.get(paramString2 + ".adxml.adCardInfo.adRatingCardInfo.headUrl"));
      paramString1 = bu.bI((String)localMap.get(paramString2 + ".adxml.adSelectInfo.leftBtnTitle"), "");
      paramString3 = bu.bI((String)localMap.get(paramString2 + ".adxml.adSelectInfo.rightBtnTitle"), "");
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)))
      {
        this.zOd = new i();
        this.zOd.zOQ = paramString1;
        this.zOd.zOR = paramString3;
      }
      paramString1 = bu.bI((String)localMap.get(paramString2 + ".adxml.adVoteInfo.componentUrl"), "");
      if (TextUtils.isEmpty(paramString1)) {
        break label2709;
      }
      this.zOe = new l();
      this.zOe.zOZ = paramString1;
      this.zOe.zPa = bu.bI((String)localMap.get(paramString2 + ".adxml.adVoteInfo.voteLabel"), "");
      paramString3 = paramString2 + ".adxml.adVoteInfo.optionList.option";
      i = 0;
      label2365:
      if (i == 0) {
        break label5987;
      }
    }
    label2709:
    label5276:
    label5987:
    for (paramString1 = paramString3 + i;; paramString1 = paramString3)
    {
      if (!TextUtils.isEmpty(bu.bI((String)localMap.get(paramString1 + ".title"), "")))
      {
        localObject1 = new m();
        ((m)localObject1).title = bu.bI((String)localMap.get(paramString1 + ".title"), "");
        ((m)localObject1).qlw = bu.bI((String)localMap.get(paramString1 + ".shareTitle"), "");
        ((m)localObject1).uly = bu.bI((String)localMap.get(paramString1 + ".shareDesc"), "");
        ((m)localObject1).zPc = bu.bI((String)localMap.get(paramString1 + ".shareThumb"), "");
        ((m)localObject1).zPd = bu.bI((String)localMap.get(paramString1 + ".selectedTitle"), "");
        ((m)localObject1).id = bu.bI((String)localMap.get(paramString1 + ".id"), "");
        this.zOe.zPb.add(localObject1);
        i += 1;
        break label2365;
        bool = false;
        break;
      }
      this.zNq = localMap.containsKey(paramString2 + ".adxml.adTurnCanvasInfo");
      this.zNJ = new k();
      this.zNJ.w(localMap, paramString2);
      this.zNM = new f().v(localMap, paramString2);
      if (this.zND == 3)
      {
        this.zNK = new h();
        paramString3 = paramString2 + ".adxml.adFullCardInfo";
        paramString1 = this.zNK;
        paramString1.zOE = bu.aSB((String)localMap.get(paramString3 + ".displayType"));
        paramString1.title = bu.nullAsNil((String)localMap.get(paramString3 + ".title"));
        paramString1.description = bu.nullAsNil((String)localMap.get(paramString3 + ".description"));
        paramString1.zOF = bu.getInt((String)localMap.get(paramString3 + ".markMaxAlpha"), 30);
        paramString1.zOG = bu.aSB((String)localMap.get(paramString3 + ".titlePosition"));
        paramString1.zOI = bu.nullAsNil((String)localMap.get(paramString3 + ".maskImg"));
        paramString1.zOJ = bu.aSB((String)localMap.get(paramString3 + ".maskImgDisappearTime"));
        paramString1.zOK = bu.nullAsNil((String)localMap.get(paramString3 + ".coverImg"));
        paramString1.zOL = bu.aSB((String)localMap.get(paramString3 + ".coverImgAppearTime"));
        if (!bu.isNullOrNil((String)localMap.get(paramString3 + ".adGestureInfo.points")))
        {
          paramString1.zOH = new b.h.a();
          paramString1.zOH.color = -1;
          paramString1.zOH.startTime = bu.aSB((String)localMap.get(paramString3 + ".adGestureInfo.startTime"));
          paramString1.zOH.endTime = bu.aSB((String)localMap.get(paramString3 + ".adGestureInfo.endTime"));
          paramString1.zOH.zOO = bu.aSE((String)localMap.get(paramString3 + ".adGestureInfo.distance"));
          paramString1.zOH.color = Color.parseColor(bu.nullAsNil((String)localMap.get(paramString3 + ".adGestureInfo.color")));
          paramString1.zOH.zOP = bu.nullAsNil((String)localMap.get(paramString3 + ".adGestureInfo.points"));
        }
        localObject1 = paramString3 + ".endCoverInfo";
        if (localMap.containsKey(localObject1))
        {
          paramString1.zOM = new at();
          paramString1.zOM.title = bu.nullAsNil((String)localMap.get((String)localObject1 + ".title"));
          paramString1.zOM.desc = bu.nullAsNil((String)localMap.get((String)localObject1 + ".description"));
          paramString1.zOM.Aoh = bu.nullAsNil((String)localMap.get((String)localObject1 + ".actionTitle"));
          paramString1.zOM.coverImgUrl = bu.nullAsNil((String)localMap.get((String)localObject1 + ".ambientImageUrl"));
          paramString1.zOM.Aog = bu.nullAsNil((String)localMap.get((String)localObject1 + ".titleImageUrl"));
          paramString1.zOM.duration = bu.aSB((String)localMap.get((String)localObject1 + ".endCoverEndTime"));
        }
        paramString3 = paramString3 + ".adLongPressGestureInfo";
        if (localMap.containsKey(paramString3))
        {
          paramString1.zON = new p();
          paramString1.zON.zPe = bu.aSB((String)localMap.get(paramString3 + ".pressStartTime"));
          paramString1.zON.zPf = bu.aSB((String)localMap.get(paramString3 + ".pressEndTime"));
          paramString1.zON.zPg = bu.aSB((String)localMap.get(paramString3 + ".pressDuration"));
          paramString1.zON.zPh = bu.nullAsNil((String)localMap.get(paramString3 + ".spriteImageUrl"));
          paramString1.zON.zPi = bu.aSB((String)localMap.get(paramString3 + ".spriteType"));
        }
        this.zNQ = bu.aSB((String)localMap.get(paramString2 + ".adxml.compatible.clientVersion.androidMin"));
        this.zNR = bu.aSB((String)localMap.get(paramString2 + ".adxml.compatible.clientVersion.androidMax"));
        this.zNS = bu.nullAsNil((String)localMap.get(paramString2 + ".adxml.compatible.jumpUrl"));
        paramString1 = paramString2 + ".adxml.adCardInfo.adCardButton";
        if (localMap.containsKey(paramString1))
        {
          this.zsZ = new c();
          paramString3 = this.zsZ;
          paramString3.iconUrl = bu.nullAsNil((String)localMap.get(paramString1 + ".iconUrl"));
          paramString3.zOj = bu.nullAsNil((String)localMap.get(paramString1 + ".btnTitle"));
          paramString3.zOk = bu.getInt((String)localMap.get(paramString1 + ".clickActionType"), 0);
          paramString3.zOl = bu.nullAsNil((String)localMap.get(paramString1 + ".clickActionLink"));
          paramString3.pSx = bu.nullAsNil((String)localMap.get(paramString1 + ".weappUserName"));
          paramString3.hGk = bu.nullAsNil((String)localMap.get(paramString1 + ".weappPath"));
          paramString3.hGl = bu.getInt((String)localMap.get(paramString1 + ".weappVersion"), 0);
          paramString3.zOm = bu.nullAsNil((String)localMap.get(paramString1 + ".tempId"));
          paramString3.zOn = bu.nullAsNil((String)localMap.get(paramString1 + ".btnTitleAfterOrder"));
          paramString3.zOo = bu.nullAsNil((String)localMap.get(paramString1 + ".subscribeTitle"));
          paramString3.zOp = bu.nullAsNil((String)localMap.get(paramString1 + ".subscribeContent"));
          paramString3.zOq = bu.nullAsNil((String)localMap.get(paramString1 + ".subscribeSubmitBtnTitle"));
          paramString3.zOr = bu.nullAsNil((String)localMap.get(paramString1 + ".subscribeFailedTip"));
          paramString3.zOs = bu.nullAsNil((String)localMap.get(paramString1 + ".subscribeSucTip"));
          paramString3.zOt = bu.nullAsNil((String)localMap.get(paramString1 + ".appType"));
          paramString3.appId = bu.nullAsNil((String)localMap.get(paramString1 + ".appId"));
          paramString3.zOu = bu.nullAsNil((String)localMap.get(paramString1 + ".subscribeHeadImg"));
          paramString3.zOv = bu.nullAsNil((String)localMap.get(paramString1 + ".subscribeNickname"));
          paramString3.zOw = bu.nullAsNil((String)localMap.get(paramString1 + ".openSdkAppId"));
          paramString3.zOx = bu.nullAsNil((String)localMap.get(paramString1 + ".packageName"));
          paramString3.zMz = bu.nullAsNil((String)localMap.get(paramString1 + ".appPageUrlAndroid"));
          paramString3.oFe = bu.nullAsNil((String)localMap.get(paramString1 + ".cardTpId"));
          paramString3.oGb = bu.nullAsNil((String)localMap.get(paramString1 + ".cardExt"));
          paramString3.hTJ = bu.nullAsNil((String)localMap.get(paramString1 + ".brandUsername"));
          paramString3.ztf = bu.nullAsNil((String)localMap.get(paramString1 + ".brandHead"));
          paramString3.dpI = bu.nullAsNil((String)localMap.get(paramString1 + ".brandName"));
          paramString3.ztg = bu.nullAsNil((String)localMap.get(paramString1 + ".brandDesc"));
          paramString3.zth = bu.nullAsNil((String)localMap.get(paramString1 + ".btnTitleAfterAddBrand"));
          if (!TextUtils.isEmpty(this.zsZ.zOx))
          {
            this.zNU = this.zsZ.zOx;
            ae.i("MicroMsg.ADXml", "findDownloadApkPkgName, adCardActionBtnInfo.pkg=" + this.zsZ.zOx);
          }
        }
        if (TextUtils.isEmpty(this.zNU)) {
          aR(localMap);
        }
        this.zsJ = i.azd((String)localMap.get(paramString2 + ".adxml.adExtInfo"));
      }
      try
      {
        paramString1 = a.b(ak.getContext(), localMap);
        if (paramString1 != null) {
          this.zNV = paramString1.dWs();
        }
      }
      catch (Throwable paramString1)
      {
        break label5276;
      }
      this.zNZ = b.t(localMap, paramString2 + ".adxml.adScanInfo");
      this.zNT = b.n.x(localMap, paramString2 + ".adxml.adCanvasInfo.globalComponentItems.componentItem");
      paramString1 = paramString2 + ".adxml.adFinderInfo";
      paramString3 = bu.nullAsNil((String)localMap.get(paramString1 + ".objectNonceId"));
      localObject1 = bu.nullAsNil((String)localMap.get(paramString1 + ".finderUsername"));
      localObject2 = bu.nullAsNil((String)localMap.get(paramString1 + ".exportId"));
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        paramString1 = new a();
        paramString1.objectNonceId = paramString3;
        paramString1.sbR = ((String)localObject1);
        paramString1.zOf = ((String)localObject2);
      }
      for (;;)
      {
        this.zOa = paramString1;
        this.zOb = bu.aSB((String)localMap.get(paramString2 + ".adxml.addPlayIconOnCover"));
        AppMethodBeat.o(96270);
        return localMap;
        if (this.zND != 4) {
          break;
        }
        this.zNL = new j();
        paramString1 = paramString2 + ".adxml.adSphereCardInfo";
        paramString3 = this.zNL;
        paramString3.zOE = bu.aSB((String)localMap.get(paramString1 + ".displayType"));
        paramString3.title = bu.nullAsNil((String)localMap.get(paramString1 + ".title"));
        paramString3.description = bu.nullAsNil((String)localMap.get(paramString1 + ".description"));
        paramString3.zOF = bu.getInt((String)localMap.get(paramString1 + ".markMaxAlpha"), 30);
        paramString3.zOG = bu.aSB((String)localMap.get(paramString1 + ".titlePosition"));
        paramString3.zOT = bu.aSB((String)localMap.get(paramString1 + ".gestureDelayTime"));
        paramString3.zOV = bu.nullAsNil((String)localMap.get(paramString1 + ".sphereThumbUrl"));
        paramString3.zOW = bu.nullAsNil((String)localMap.get(paramString1 + ".bgColor"));
        paramString3.zOX = bu.nullAsNil((String)localMap.get(paramString1 + ".bgColorAlpha"));
        paramString3.zOU = bu.nullAsNil((String)localMap.get(paramString1 + ".sphereImageUrl"));
        break;
        paramString1 = null;
      }
    }
  }
  
  private void aR(Map<String, String> paramMap)
  {
    AppMethodBeat.i(219378);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(219378);
      return;
    }
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if ((str1.endsWith(".pkg")) || (str1.endsWith(".appPackage")))
      {
        String str2 = (String)paramMap.get(str1);
        if (!TextUtils.isEmpty(str2))
        {
          this.zNU = str2;
          ae.i("MicroMsg.ADXml", "findDownloadApkPkgName, key=" + str1 + ", pkg=" + str2);
          AppMethodBeat.o(219378);
          return;
        }
      }
    }
    AppMethodBeat.o(219378);
  }
  
  public final boolean dZA()
  {
    return this.zND == 1;
  }
  
  public final boolean dZB()
  {
    return this.zND == 3;
  }
  
  public final boolean dZC()
  {
    return this.zND == 4;
  }
  
  public final boolean dZD()
  {
    AppMethodBeat.i(219377);
    if ((dZB()) && (this.zNK != null) && (this.zNK.zON != null) && (this.zNK.zON.zPe > 0) && (this.zNK.zON.zPf > this.zNK.zON.zPe))
    {
      AppMethodBeat.o(219377);
      return true;
    }
    AppMethodBeat.o(219377);
    return false;
  }
  
  public final boolean dZE()
  {
    return this.zOd != null;
  }
  
  public final boolean dZF()
  {
    AppMethodBeat.i(96274);
    if ((this.zOe != null) && (this.zOe.zPb.size() > 1) && (!TextUtils.isEmpty(((m)this.zOe.zPb.get(0)).id)) && (!TextUtils.isEmpty(((m)this.zOe.zPb.get(1)).id)))
    {
      AppMethodBeat.o(96274);
      return true;
    }
    AppMethodBeat.o(96274);
    return false;
  }
  
  public final boolean dZG()
  {
    AppMethodBeat.i(96275);
    if ((this.zOe != null) && (this.zOe.zPb.size() > 1))
    {
      AppMethodBeat.o(96275);
      return true;
    }
    AppMethodBeat.o(96275);
    return false;
  }
  
  public final String dZH()
  {
    AppMethodBeat.i(96276);
    String str2 = this.dCX;
    String str1 = str2;
    if (str2.contains("<adCanvasInfoLeft>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "").replaceAll("adCanvasInfoLeft", "adCanvasInfo");
    }
    AppMethodBeat.o(96276);
    return str1;
  }
  
  public final String dZI()
  {
    AppMethodBeat.i(96277);
    String str2 = this.dCX;
    String str1 = str2;
    if (str2.contains("<adCanvasInfoRight>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("adCanvasInfoRight", "adCanvasInfo");
    }
    AppMethodBeat.o(96277);
    return str1;
  }
  
  public final String dZJ()
  {
    AppMethodBeat.i(96278);
    String str2 = this.dCX;
    String str1 = str2;
    if (str2.contains("<adTurnCanvasInfo>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adTurnCanvasInfo", "adCanvasInfo");
    }
    AppMethodBeat.o(96278);
    return str1;
  }
  
  public final String dZK()
  {
    AppMethodBeat.i(96279);
    String str = this.dCX;
    if ((this.zNK != null) && (str.contains("<adFullCardGestureCanvasInfo>"))) {}
    for (str = str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adFullCardGestureCanvasInfo", "adCanvasInfo");; str = "")
    {
      AppMethodBeat.o(96279);
      return str;
    }
  }
  
  public final boolean dZL()
  {
    return this.zNm == 2;
  }
  
  public final boolean dZM()
  {
    return this.zOb == 1;
  }
  
  public final boolean dZu()
  {
    return (this.zsZ != null) && (this.zsZ.zOk >= 0);
  }
  
  public final boolean dZv()
  {
    return (this.zMi) || (this.zNq);
  }
  
  public final String dZw()
  {
    AppMethodBeat.i(96271);
    String str;
    if (dZE())
    {
      str = this.zOd.zOQ;
      AppMethodBeat.o(96271);
      return str;
    }
    if (dZG())
    {
      str = ((m)this.zOe.zPb.get(0)).title;
      AppMethodBeat.o(96271);
      return str;
    }
    AppMethodBeat.o(96271);
    return "";
  }
  
  public final String dZx()
  {
    AppMethodBeat.i(96272);
    String str;
    if (dZE())
    {
      str = this.zOd.zOR;
      AppMethodBeat.o(96272);
      return str;
    }
    if (dZG())
    {
      str = ((m)this.zOe.zPb.get(1)).title;
      AppMethodBeat.o(96272);
      return str;
    }
    AppMethodBeat.o(96272);
    return "";
  }
  
  public final String dZy()
  {
    AppMethodBeat.i(96273);
    if (dZG())
    {
      String str = this.zOe.zOZ;
      AppMethodBeat.o(96273);
      return str;
    }
    AppMethodBeat.o(96273);
    return "";
  }
  
  public final boolean dZz()
  {
    return this.zND == 2;
  }
  
  public static final class a
  {
    public String objectNonceId;
    public String sbR;
    public String zOf;
  }
  
  public static final class b
  {
    public String desc;
    public String oEV;
    public String zOg;
    public String zOh;
    public int zOi;
    
    public static b t(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(219373);
      String str1 = bu.nullAsNil((String)paramMap.get(paramString + ".bgImage"));
      String str2 = bu.nullAsNil((String)paramMap.get(paramString + ".desc"));
      String str3 = bu.nullAsNil((String)paramMap.get(paramString + ".descIcon"));
      String str4 = bu.nullAsNil((String)paramMap.get(paramString + ".detectSucIcon"));
      int i = bu.aSB((String)paramMap.get(paramString + ".scanGestureType"));
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)) && (i > 0))
      {
        paramMap = new b();
        paramMap.zOg = str1;
        paramMap.desc = str2;
        paramMap.oEV = str3;
        paramMap.zOh = str4;
        paramMap.zOi = i;
        AppMethodBeat.o(219373);
        return paramMap;
      }
      AppMethodBeat.o(219373);
      return null;
    }
  }
  
  public static final class c
  {
    public String appId;
    public String dpI;
    public String hGk;
    public int hGl;
    public String hTJ;
    public String iconUrl;
    public String oFe;
    public String oGb;
    public String pSx;
    public String zMz;
    public String zOj;
    public int zOk;
    public String zOl;
    public String zOm;
    public String zOn;
    public String zOo;
    public String zOp;
    public String zOq;
    public String zOr;
    public String zOs;
    public String zOt;
    public String zOu;
    public String zOv;
    public String zOw;
    public String zOx;
    public String ztf;
    public String ztg;
    public String zth;
  }
  
  public static final class d
  {
    public List<b.e> zOy;
    
    public d()
    {
      AppMethodBeat.i(219374);
      this.zOy = new ArrayList();
      AppMethodBeat.o(219374);
    }
    
    public final d u(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(219375);
      int i = 0;
      Object localObject2 = new StringBuilder().append(paramString).append(".adxml.adCardInfo.adRatingCardInfo.tagList.tag");
      if (i == 0) {}
      for (Object localObject1 = "";; localObject1 = Integer.valueOf(i))
      {
        String str = localObject1;
        if (!paramMap.containsKey(str)) {
          break label297;
        }
        ae.i("MicroMsg.ADXml", "card ad tag %s", new Object[] { paramMap.get(str) });
        if (!bu.isNullOrNil((String)paramMap.get(str)))
        {
          localObject1 = new b.e();
          ((b.e)localObject1).zOz = bu.bI((String)paramMap.get(str), "");
          localObject2 = str + ".$light_mode_url";
          str = str + ".$dark_mode_url";
          ((b.e)localObject1).zOA = bu.bI((String)paramMap.get(localObject2), "");
          ((b.e)localObject1).zOB = bu.bI((String)paramMap.get(str), "");
          ae.i("MicroMsg.ADXml", "Tag content = ", new Object[] { ((b.e)localObject1).zOz + ", Tag light iconUrl = " + ((b.e)localObject1).zOA + ", Tag dark iconUrl = " + ((b.e)localObject1).zOB });
          this.zOy.add(localObject1);
        }
        i += 1;
        break;
      }
      label297:
      AppMethodBeat.o(219375);
      return this;
    }
  }
  
  public static final class e
  {
    public String zOA;
    public String zOB;
    public String zOz;
  }
  
  public static final class f
  {
    public List<b.g> list;
    
    public f()
    {
      AppMethodBeat.i(96262);
      this.list = new LinkedList();
      AppMethodBeat.o(96262);
    }
    
    public final f v(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(96263);
      String str1 = paramString + ".adxml.feedbackInfo.feedbackList.item";
      int i = 0;
      if (i > 0) {}
      for (paramString = str1 + i;; paramString = str1)
      {
        String str2 = paramString + ".url";
        if ((paramMap.get(str2) != null) && (((String)paramMap.get(str2)).length() > 0))
        {
          b.g localg = new b.g();
          localg.url = bu.bI((String)paramMap.get(str2), "");
          localg.zOC = bu.bI((String)paramMap.get(paramString + ".Wording.zh"), "");
          localg.zGp = bu.bI((String)paramMap.get(paramString + ".Wording.en"), "");
          localg.zOD = bu.bI((String)paramMap.get(paramString + ".Wording.tw"), "");
          if (localg.zOC.length() + localg.zGp.length() + localg.zOD.length() > 0) {
            this.list.add(localg);
          }
          i += 1;
          break;
        }
        AppMethodBeat.o(96263);
        return this;
      }
    }
  }
  
  public static final class g
  {
    public String url = "";
    public String zGp = "";
    public String zOC = "";
    public String zOD = "";
  }
  
  public static final class h
  {
    public String description;
    public String title;
    public int zOE;
    public int zOF = 30;
    public int zOG;
    public a zOH;
    public String zOI;
    public int zOJ;
    public String zOK;
    public int zOL;
    public at zOM;
    public b.p zON;
    
    public static final class a
    {
      public int color;
      public long endTime;
      public long startTime;
      public float zOO;
      public String zOP;
    }
  }
  
  public final class i
  {
    public String zOQ;
    public String zOR;
    
    public i() {}
  }
  
  public static final class j
  {
    public String description;
    public String title;
    public int zOE;
    public int zOF = 30;
    public int zOG;
    public int zOT;
    public String zOU;
    public String zOV;
    public String zOW;
    public String zOX;
  }
  
  public static final class k
  {
    public String appVersion;
    public String dlk;
    public String duJ;
    public String zLV;
    public List<b.o> zOY;
    
    public k()
    {
      AppMethodBeat.i(96264);
      this.zLV = "";
      this.zOY = new ArrayList();
      AppMethodBeat.o(96264);
    }
    
    public final void w(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(96265);
      this.zLV = bu.bI((String)paramMap.get(paramString + ".adxml.adTurnActionLink"), "");
      String str = (String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.appUserName");
      if (!TextUtils.isEmpty(str))
      {
        this.duJ = str;
        this.appVersion = ((String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.appVersion"));
        this.dlk = ((String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.relativePagePath"));
      }
      str = paramString + ".adxml.adTurnInfo.materialInfo";
      int i = 0;
      if (i > 0) {}
      for (paramString = str + i;; paramString = str)
      {
        if ((paramMap.get(paramString + ".displayType") != null) && (((String)paramMap.get(paramString + ".displayType")).length() > 0))
        {
          b.o localo = new b.o();
          localo.title = bu.bI((String)paramMap.get(paramString + ".title"), "");
          localo.desc = bu.bI((String)paramMap.get(paramString + ".desc"), "");
          localo.zOE = bu.aSB((String)paramMap.get(paramString + ".displayType"));
          this.zOY.add(localo);
          i += 1;
          break;
        }
        AppMethodBeat.o(96265);
        return;
      }
    }
  }
  
  public final class l
  {
    public String zOZ;
    public String zPa;
    public ArrayList<b.m> zPb;
    
    public l()
    {
      AppMethodBeat.i(96266);
      this.zOZ = "";
      this.zPa = "";
      this.zPb = new ArrayList();
      AppMethodBeat.o(96266);
    }
    
    public final String QT(int paramInt)
    {
      AppMethodBeat.i(96267);
      if ((paramInt >= 0) && (paramInt < this.zPb.size()))
      {
        String str = ((b.m)this.zPb.get(paramInt)).zPd;
        AppMethodBeat.o(96267);
        return str;
      }
      AppMethodBeat.o(96267);
      return "";
    }
    
    public final String QU(int paramInt)
    {
      AppMethodBeat.i(96268);
      if ((paramInt >= 0) && (paramInt < this.zPb.size()))
      {
        String str = ((b.m)this.zPb.get(paramInt)).title;
        AppMethodBeat.o(96268);
        return str;
      }
      AppMethodBeat.o(96268);
      return "";
    }
  }
  
  public final class m
  {
    public String id = "";
    public String qlw = "";
    public String title = "";
    public String uly = "";
    public String zPc = "";
    public String zPd = "";
    
    public m() {}
  }
  
  public static final class o
  {
    public String desc;
    public String title;
    public int zOE = 0;
  }
  
  public static final class p
  {
    public int zPe;
    public int zPf;
    public int zPg;
    public String zPh;
    public int zPi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.b
 * JD-Core Version:    0.7.0.1
 */
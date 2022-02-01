package com.tencent.mm.plugin.sns.storage;

import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.device.appstore.a;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b
{
  public String dsv;
  public String nickname;
  public String wBR;
  public String wRX;
  public int wSJ;
  public String wSK;
  public int wSL;
  public int wSM;
  public String wSN;
  public String wSO;
  public String wSP;
  public String wSQ;
  public String wSR;
  public int wSS;
  public String wST;
  public String wSU;
  public int wSV;
  public String wSW;
  public int wSX;
  public String wSY;
  public String wSZ;
  boolean wSg;
  public String wTA;
  public b wTB;
  public i wTC;
  public f wTD;
  public h wTE;
  public d wTF;
  public boolean wTG;
  public String wTH;
  public String wTI;
  public int wTJ;
  public int wTK;
  public String wTL;
  public a wTM;
  public String wTN;
  public Intent wTO;
  public int wTP;
  private g wTQ;
  public j wTR;
  public String wTa;
  public String wTb;
  public String wTc;
  public String wTd;
  public int wTe;
  public int wTf;
  public int wTg;
  public long wTh;
  public Map<String, String> wTi;
  boolean wTj;
  public int wTk;
  public int wTl;
  public float wTm;
  public float wTn;
  public int wTo;
  public int wTp;
  public int wTq;
  public String wTr;
  public float wTs;
  public float wTt;
  public float wTu;
  public float wTv;
  public int wTw;
  public String wTx;
  public String wTy;
  public String wTz;
  
  public b(String paramString)
  {
    AppMethodBeat.i(96269);
    this.dsv = "";
    this.wSL = 0;
    this.wSM = 0;
    this.wSN = "";
    this.wSO = "";
    this.wSP = "";
    this.wSQ = "";
    this.wSR = "";
    this.wSS = 0;
    this.wST = "";
    this.wSU = "";
    this.wSV = 0;
    this.wSW = "";
    this.wSX = 0;
    this.wSY = "";
    this.wSZ = "";
    this.wTa = "";
    this.wTb = "";
    this.wTc = "";
    this.wTd = "";
    this.wTi = new HashMap();
    this.wTP = 0;
    if ((!bt.isNullOrNil(paramString)) && (paramString.trim().startsWith("<RecXml")))
    {
      paramString = aw(paramString, ".RecXml", "RecXml");
      if ((paramString != null) && (!paramString.isEmpty()))
      {
        this.wTe = bt.aGh((String)paramString.get(".RecXml.$type"));
        this.wTf = bt.aGh((String)paramString.get(".RecXml.$source"));
        this.wTg = bt.aGh((String)paramString.get(".RecXml.$expId"));
        this.wTh = q.anR((String)paramString.get(".RecXml.$expOriginSnsId"));
      }
      AppMethodBeat.o(96269);
      return;
    }
    aw(paramString, "", "adxml");
    AppMethodBeat.o(96269);
  }
  
  private void aE(Map<String, String> paramMap)
  {
    AppMethodBeat.i(187338);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(187338);
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
          this.wTN = str2;
          ad.i("MicroMsg.ADXml", "findDownloadApkPkgName, key=" + str1 + ", pkg=" + str2);
          AppMethodBeat.o(187338);
          return;
        }
      }
    }
    AppMethodBeat.o(187338);
  }
  
  private Map<String, String> aw(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96270);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString3)))
    {
      AppMethodBeat.o(96270);
      return null;
    }
    this.dsv = paramString1;
    ad.i("MicroMsg.ADXml", "feed xml %s, keyPrefix %s, tag %s", new Object[] { paramString1, paramString2, paramString3 });
    Map localMap = bw.K(paramString1, paramString3);
    if (localMap == null)
    {
      AppMethodBeat.o(96270);
      return null;
    }
    this.wSJ = bt.aGh((String)localMap.get(paramString2 + ".adxml.adType"));
    this.wSK = bt.by((String)localMap.get(paramString2 + ".adxml.adActionTitle"), "");
    this.wRX = bt.by((String)localMap.get(paramString2 + ".adxml.adActionLink"), "");
    this.nickname = bt.by((String)localMap.get(paramString2 + ".adxml.nickname"), "");
    this.wSL = bt.aGh((String)localMap.get(paramString2 + ".adxml.webviewRightBarShow"));
    this.wSM = bt.aGh((String)localMap.get(paramString2 + ".adxml.adActionLinkHidden"));
    this.wSN = bt.by((String)localMap.get(paramString2 + ".adxml.adActionLinkName"), "");
    this.wSO = bt.by((String)localMap.get(paramString2 + ".adxml.adActionLinkIcon"), "");
    this.wSP = bt.by((String)localMap.get(paramString2 + ".adxml.adActionLinkTitle.zh"), "");
    this.wSR = bt.by((String)localMap.get(paramString2 + ".adxml.adActionLinkTitle.tw"), "");
    this.wSQ = bt.by((String)localMap.get(paramString2 + ".adxml.adActionLinkTitle.en"), "");
    this.wST = bt.by((String)localMap.get(paramString2 + ".adxml.attachShareLinkWording"), "");
    this.wSU = bt.by((String)localMap.get(paramString2 + ".adxml.attachShareLinkUrl"), "");
    this.wSS = bt.aGh((String)localMap.get(paramString2 + ".adxml.attachShareLinkIsHidden"));
    if ((bt.isNullOrNil(this.wST)) || (bt.isNullOrNil(this.wSU))) {
      this.wSS = 1;
    }
    this.wSY = bt.by((String)localMap.get(paramString2 + ".adxml.expandOutsideTitle.zh"), "");
    this.wTa = bt.by((String)localMap.get(paramString2 + ".adxml.expandOutsideTitle.tw"), "");
    this.wSZ = bt.by((String)localMap.get(paramString2 + ".adxml.expandOutsideTitle.en"), "");
    this.wTb = bt.by((String)localMap.get(paramString2 + ".adxml.expandInsideTitle.zh"), "");
    this.wTd = bt.by((String)localMap.get(paramString2 + ".adxml.expandInsideTitle.tw"), "");
    this.wTc = bt.by((String)localMap.get(paramString2 + ".adxml.expandInsideTitle.en"), "");
    this.wSV = bt.aGh((String)localMap.get(paramString2 + ".adxml.headClickType"));
    this.wSW = bt.by((String)localMap.get(paramString2 + ".adxml.headClickParam"), "");
    this.wSX = bt.aGh((String)localMap.get(paramString2 + ".adxml.headClickRightBarShow"));
    this.wTP = bt.aGh((String)localMap.get(paramString2 + ".adxml.toAdMarket"));
    int i = 0;
    paramString3 = new StringBuilder().append(paramString2).append(".adxml.adArgs.arg");
    label1054:
    Object localObject1;
    Object localObject2;
    if (i == 0)
    {
      paramString1 = "";
      paramString3 = paramString1 + ".key";
      localObject1 = (String)localMap.get(paramString3);
      if (localObject1 == null) {
        break label1239;
      }
      localObject2 = new StringBuilder().append(paramString2).append(".adxml.adArgs.arg");
      if (i != 0) {
        break label1230;
      }
    }
    label1230:
    for (paramString1 = "";; paramString1 = Integer.valueOf(i))
    {
      paramString1 = paramString1 + ".value";
      localObject2 = (String)localMap.get(paramString1);
      ad.i("MicroMsg.ADXml", "newKey " + paramString3 + " " + (String)localObject1 + " newValue : " + paramString1 + " " + (String)localObject2);
      this.wTi.put(localObject1, localObject2);
      i += 1;
      break;
      paramString1 = Integer.valueOf(i);
      break label1054;
    }
    label1239:
    this.wSg = localMap.containsKey(paramString2 + ".adxml.adCanvasInfo");
    boolean bool;
    if (bt.aGh((String)localMap.get(paramString2 + ".adxml.usePreferedInfo")) == 1)
    {
      bool = true;
      this.wTG = bool;
      this.wTH = bt.nullAsNil((String)localMap.get(paramString2 + ".adxml.preferNickname"));
      this.wTI = bt.nullAsNil((String)localMap.get(paramString2 + ".adxml.preferAvatar"));
      this.wTk = bt.aGh((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.contentDisplayType"));
      this.wTl = bt.aGh((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaDisplayMode"));
      this.wTm = ((float)bt.aGj((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaDisplayWidth")));
      this.wTn = ((float)bt.aGj((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaDisplayHeight")));
      this.wTq = bt.aGh((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.btnDisplayType"));
      this.wTr = bt.by((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconUrl"), "");
      this.wTo = bt.aGh((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.basicRemWidth"));
      this.wTp = bt.aGh((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.basicRootFontSize"));
      this.wTs = ((float)bt.aGj((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconWidth")));
      this.wTt = ((float)bt.aGj((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconHeight")));
      this.wTu = ((float)bt.aGj((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingRight")));
      this.wTv = ((float)bt.aGj((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingBottom")));
      this.wTw = bt.aGh((String)localMap.get(paramString2 + ".adxml.adContentStyle"));
      this.wTx = bt.by((String)localMap.get(paramString2 + ".adxml.adCardInfo.title"), "");
      this.wTy = bt.by((String)localMap.get(paramString2 + ".adxml.adCardInfo.description"), "");
      this.wTB = new b().r(localMap, paramString2);
      this.wTz = bt.nullAsNil((String)localMap.get(paramString2 + ".adxml.adCardInfo.adRatingCardInfo.headTitle"));
      this.wTA = bt.nullAsNil((String)localMap.get(paramString2 + ".adxml.adCardInfo.adRatingCardInfo.headUrl"));
      paramString1 = bt.by((String)localMap.get(paramString2 + ".adxml.adSelectInfo.leftBtnTitle"), "");
      paramString3 = bt.by((String)localMap.get(paramString2 + ".adxml.adSelectInfo.rightBtnTitle"), "");
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)))
      {
        this.wTQ = new g();
        this.wTQ.wUw = paramString1;
        this.wTQ.wUx = paramString3;
      }
      paramString1 = bt.by((String)localMap.get(paramString2 + ".adxml.adVoteInfo.componentUrl"), "");
      if (TextUtils.isEmpty(paramString1)) {
        break label2635;
      }
      this.wTR = new j();
      this.wTR.wUF = paramString1;
      this.wTR.wUG = bt.by((String)localMap.get(paramString2 + ".adxml.adVoteInfo.voteLabel"), "");
      paramString3 = paramString2 + ".adxml.adVoteInfo.optionList.option";
      i = 0;
      label2291:
      if (i == 0) {
        break label5302;
      }
    }
    label4869:
    label5302:
    for (paramString1 = paramString3 + i;; paramString1 = paramString3)
    {
      if (!TextUtils.isEmpty(bt.by((String)localMap.get(paramString1 + ".title"), "")))
      {
        localObject1 = new k();
        ((k)localObject1).title = bt.by((String)localMap.get(paramString1 + ".title"), "");
        ((k)localObject1).oYb = bt.by((String)localMap.get(paramString1 + ".shareTitle"), "");
        ((k)localObject1).rUO = bt.by((String)localMap.get(paramString1 + ".shareDesc"), "");
        ((k)localObject1).wUI = bt.by((String)localMap.get(paramString1 + ".shareThumb"), "");
        ((k)localObject1).wUJ = bt.by((String)localMap.get(paramString1 + ".selectedTitle"), "");
        ((k)localObject1).id = bt.by((String)localMap.get(paramString1 + ".id"), "");
        this.wTR.wUH.add(localObject1);
        i += 1;
        break label2291;
        bool = false;
        break;
      }
      label2635:
      this.wTj = localMap.containsKey(paramString2 + ".adxml.adTurnCanvasInfo");
      this.wTC = new i();
      this.wTC.t(localMap, paramString2);
      this.wTF = new d().s(localMap, paramString2);
      if (this.wTw == 3)
      {
        this.wTD = new f();
        paramString3 = paramString2 + ".adxml.adFullCardInfo";
        paramString1 = this.wTD;
        paramString1.wUk = bt.aGh((String)localMap.get(paramString3 + ".displayType"));
        paramString1.title = bt.nullAsNil((String)localMap.get(paramString3 + ".title"));
        paramString1.description = bt.nullAsNil((String)localMap.get(paramString3 + ".description"));
        paramString1.wUl = bt.getInt((String)localMap.get(paramString3 + ".markMaxAlpha"), 30);
        paramString1.wUm = bt.aGh((String)localMap.get(paramString3 + ".titlePosition"));
        paramString1.wUo = bt.nullAsNil((String)localMap.get(paramString3 + ".maskImg"));
        paramString1.wUp = bt.aGh((String)localMap.get(paramString3 + ".maskImgDisappearTime"));
        paramString1.wUq = bt.nullAsNil((String)localMap.get(paramString3 + ".coverImg"));
        paramString1.wUr = bt.aGh((String)localMap.get(paramString3 + ".coverImgAppearTime"));
        if (!bt.isNullOrNil((String)localMap.get(paramString3 + ".adGestureInfo.points")))
        {
          paramString1.wUn = new b.f.a();
          paramString1.wUn.color = -1;
          paramString1.wUn.startTime = bt.aGh((String)localMap.get(paramString3 + ".adGestureInfo.startTime"));
          paramString1.wUn.endTime = bt.aGh((String)localMap.get(paramString3 + ".adGestureInfo.endTime"));
          paramString1.wUn.wUu = bt.aGk((String)localMap.get(paramString3 + ".adGestureInfo.distance"));
          paramString1.wUn.color = Color.parseColor(bt.nullAsNil((String)localMap.get(paramString3 + ".adGestureInfo.color")));
          paramString1.wUn.wUv = bt.nullAsNil((String)localMap.get(paramString3 + ".adGestureInfo.points"));
        }
        localObject1 = paramString3 + ".endCoverInfo";
        if (localMap.containsKey(localObject1))
        {
          paramString1.wUs = new aq();
          paramString1.wUs.title = bt.nullAsNil((String)localMap.get((String)localObject1 + ".title"));
          paramString1.wUs.desc = bt.nullAsNil((String)localMap.get((String)localObject1 + ".description"));
          paramString1.wUs.xsN = bt.nullAsNil((String)localMap.get((String)localObject1 + ".actionTitle"));
          paramString1.wUs.coverImgUrl = bt.nullAsNil((String)localMap.get((String)localObject1 + ".ambientImageUrl"));
          paramString1.wUs.xsM = bt.nullAsNil((String)localMap.get((String)localObject1 + ".titleImageUrl"));
          paramString1.wUs.duration = bt.aGh((String)localMap.get((String)localObject1 + ".endCoverEndTime"));
        }
        paramString3 = paramString3 + ".adLongPressGestureInfo";
        if (localMap.containsKey(paramString3))
        {
          paramString1.wUt = new m();
          paramString1.wUt.wUK = bt.aGh((String)localMap.get(paramString3 + ".pressStartTime"));
          paramString1.wUt.wUL = bt.aGh((String)localMap.get(paramString3 + ".pressEndTime"));
          paramString1.wUt.wUM = bt.aGh((String)localMap.get(paramString3 + ".pressDuration"));
          paramString1.wUt.wUN = bt.nullAsNil((String)localMap.get(paramString3 + ".spriteImageUrl"));
          paramString1.wUt.wUO = bt.aGh((String)localMap.get(paramString3 + ".spriteType"));
        }
      }
      for (;;)
      {
        this.wTJ = bt.aGh((String)localMap.get(paramString2 + ".adxml.compatible.clientVersion.androidMin"));
        this.wTK = bt.aGh((String)localMap.get(paramString2 + ".adxml.compatible.clientVersion.androidMax"));
        this.wTL = bt.nullAsNil((String)localMap.get(paramString2 + ".adxml.compatible.jumpUrl"));
        paramString1 = paramString2 + ".adxml.adCardInfo.adCardButton";
        if (localMap.containsKey(paramString1))
        {
          this.wTM = new a();
          paramString3 = this.wTM;
          paramString3.wTS = bt.nullAsNil((String)localMap.get(paramString1 + ".btnTitle"));
          paramString3.wTT = bt.getInt((String)localMap.get(paramString1 + ".clickActionType"), 0);
          paramString3.wTU = bt.nullAsNil((String)localMap.get(paramString1 + ".clickActionLink"));
          paramString3.oER = bt.nullAsNil((String)localMap.get(paramString1 + ".weappUserName"));
          paramString3.gKJ = bt.nullAsNil((String)localMap.get(paramString1 + ".weappPath"));
          paramString3.gKK = bt.getInt((String)localMap.get(paramString1 + ".weappVersion"), 0);
          paramString3.wTV = bt.nullAsNil((String)localMap.get(paramString1 + ".tempId"));
          paramString3.wTW = bt.nullAsNil((String)localMap.get(paramString1 + ".btnTitleAfterOrder"));
          paramString3.wTX = bt.nullAsNil((String)localMap.get(paramString1 + ".subscribeTitle"));
          paramString3.wTY = bt.nullAsNil((String)localMap.get(paramString1 + ".subscribeContent"));
          paramString3.oER = bt.nullAsNil((String)localMap.get(paramString1 + ".weappUserName"));
          paramString3.wTZ = bt.nullAsNil((String)localMap.get(paramString1 + ".subscribeSubmitBtnTitle"));
          paramString3.wUa = bt.nullAsNil((String)localMap.get(paramString1 + ".subscribeFailedTip"));
          paramString3.wUb = bt.nullAsNil((String)localMap.get(paramString1 + ".subscribeSucTip"));
          paramString3.wUc = bt.nullAsNil((String)localMap.get(paramString1 + ".openSdkAppId"));
          paramString3.wUd = bt.nullAsNil((String)localMap.get(paramString1 + ".packageName"));
          paramString3.wSw = bt.nullAsNil((String)localMap.get(paramString1 + ".appPageUrlAndroid"));
          paramString3.nsh = bt.nullAsNil((String)localMap.get(paramString1 + ".cardTpId"));
          paramString3.ntf = bt.nullAsNil((String)localMap.get(paramString1 + ".cardExt"));
          if (!TextUtils.isEmpty(this.wTM.wUd))
          {
            this.wTN = this.wTM.wUd;
            ad.i("MicroMsg.ADXml", "findDownloadApkPkgName, adCardActionBtnInfo.pkg=" + this.wTM.wUd);
          }
        }
        if (TextUtils.isEmpty(this.wTN)) {
          aE(localMap);
        }
        this.wBR = h.any((String)localMap.get(paramString2 + ".adxml.adExtInfo"));
        try
        {
          paramString1 = a.b(aj.getContext(), localMap);
          if (paramString1 != null) {
            this.wTO = paramString1.dsg();
          }
        }
        catch (Throwable paramString1)
        {
          break label4869;
        }
        AppMethodBeat.o(96270);
        return localMap;
        if (this.wTw == 4)
        {
          this.wTE = new h();
          paramString1 = paramString2 + ".adxml.adSphereCardInfo";
          paramString3 = this.wTE;
          paramString3.wUk = bt.aGh((String)localMap.get(paramString1 + ".displayType"));
          paramString3.title = bt.nullAsNil((String)localMap.get(paramString1 + ".title"));
          paramString3.description = bt.nullAsNil((String)localMap.get(paramString1 + ".description"));
          paramString3.wUl = bt.getInt((String)localMap.get(paramString1 + ".markMaxAlpha"), 30);
          paramString3.wUm = bt.aGh((String)localMap.get(paramString1 + ".titlePosition"));
          paramString3.wUz = bt.aGh((String)localMap.get(paramString1 + ".gestureDelayTime"));
          paramString3.wUB = bt.nullAsNil((String)localMap.get(paramString1 + ".sphereThumbUrl"));
          paramString3.wUC = bt.nullAsNil((String)localMap.get(paramString1 + ".bgColor"));
          paramString3.wUD = bt.nullAsNil((String)localMap.get(paramString1 + ".bgColorAlpha"));
          paramString3.wUA = bt.nullAsNil((String)localMap.get(paramString1 + ".sphereImageUrl"));
        }
      }
    }
  }
  
  public final boolean dvg()
  {
    return (this.wTM != null) && (this.wTM.wTT >= 0);
  }
  
  public final boolean dvh()
  {
    return (this.wSg) || (this.wTj);
  }
  
  public final String dvi()
  {
    AppMethodBeat.i(96271);
    String str;
    if (dvo())
    {
      str = this.wTQ.wUw;
      AppMethodBeat.o(96271);
      return str;
    }
    if (dvq())
    {
      str = ((k)this.wTR.wUH.get(0)).title;
      AppMethodBeat.o(96271);
      return str;
    }
    AppMethodBeat.o(96271);
    return "";
  }
  
  public final String dvj()
  {
    AppMethodBeat.i(96272);
    String str;
    if (dvo())
    {
      str = this.wTQ.wUx;
      AppMethodBeat.o(96272);
      return str;
    }
    if (dvq())
    {
      str = ((k)this.wTR.wUH.get(1)).title;
      AppMethodBeat.o(96272);
      return str;
    }
    AppMethodBeat.o(96272);
    return "";
  }
  
  public final String dvk()
  {
    AppMethodBeat.i(96273);
    if (dvq())
    {
      String str = this.wTR.wUF;
      AppMethodBeat.o(96273);
      return str;
    }
    AppMethodBeat.o(96273);
    return "";
  }
  
  public final boolean dvl()
  {
    return this.wTw == 2;
  }
  
  public final boolean dvm()
  {
    return this.wTw == 1;
  }
  
  public final boolean dvn()
  {
    return this.wTw == 3;
  }
  
  public final boolean dvo()
  {
    return this.wTQ != null;
  }
  
  public final boolean dvp()
  {
    AppMethodBeat.i(96274);
    if ((this.wTR != null) && (this.wTR.wUH.size() > 1) && (!TextUtils.isEmpty(((k)this.wTR.wUH.get(0)).id)) && (!TextUtils.isEmpty(((k)this.wTR.wUH.get(1)).id)))
    {
      AppMethodBeat.o(96274);
      return true;
    }
    AppMethodBeat.o(96274);
    return false;
  }
  
  public final boolean dvq()
  {
    AppMethodBeat.i(96275);
    if ((this.wTR != null) && (this.wTR.wUH.size() > 1))
    {
      AppMethodBeat.o(96275);
      return true;
    }
    AppMethodBeat.o(96275);
    return false;
  }
  
  public final String dvr()
  {
    AppMethodBeat.i(96276);
    String str2 = this.dsv;
    String str1 = str2;
    if (str2.contains("<adCanvasInfoLeft>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "").replaceAll("adCanvasInfoLeft", "adCanvasInfo");
    }
    AppMethodBeat.o(96276);
    return str1;
  }
  
  public final String dvs()
  {
    AppMethodBeat.i(96277);
    String str2 = this.dsv;
    String str1 = str2;
    if (str2.contains("<adCanvasInfoRight>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("adCanvasInfoRight", "adCanvasInfo");
    }
    AppMethodBeat.o(96277);
    return str1;
  }
  
  public final String dvt()
  {
    AppMethodBeat.i(96278);
    String str2 = this.dsv;
    String str1 = str2;
    if (str2.contains("<adTurnCanvasInfo>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adTurnCanvasInfo", "adCanvasInfo");
    }
    AppMethodBeat.o(96278);
    return str1;
  }
  
  public final String dvu()
  {
    AppMethodBeat.i(96279);
    String str = this.dsv;
    if ((this.wTD != null) && (str.contains("<adFullCardGestureCanvasInfo>"))) {}
    for (str = str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adFullCardGestureCanvasInfo", "adCanvasInfo");; str = "")
    {
      AppMethodBeat.o(96279);
      return str;
    }
  }
  
  public final boolean dvv()
  {
    return this.wTf == 2;
  }
  
  public static final class a
  {
    public String gKJ;
    public int gKK;
    public String nsh;
    public String ntf;
    public String oER;
    public String wSw;
    public String wTS;
    public int wTT;
    public String wTU;
    public String wTV;
    public String wTW;
    public String wTX;
    public String wTY;
    public String wTZ;
    public String wUa;
    public String wUb;
    public String wUc;
    public String wUd;
  }
  
  public static final class b
  {
    public List<b.c> wUe;
    
    public b()
    {
      AppMethodBeat.i(187336);
      this.wUe = new ArrayList();
      AppMethodBeat.o(187336);
    }
    
    public final b r(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(187337);
      int i = 0;
      Object localObject2 = new StringBuilder().append(paramString).append(".adxml.adCardInfo.adRatingCardInfo.tagList.tag");
      if (i == 0) {}
      for (Object localObject1 = "";; localObject1 = Integer.valueOf(i))
      {
        String str = localObject1;
        if (!paramMap.containsKey(str)) {
          break label297;
        }
        ad.i("MicroMsg.ADXml", "card ad tag %s", new Object[] { paramMap.get(str) });
        if (!bt.isNullOrNil((String)paramMap.get(str)))
        {
          localObject1 = new b.c();
          ((b.c)localObject1).wUf = bt.by((String)paramMap.get(str), "");
          localObject2 = str + ".$light_mode_url";
          str = str + ".$dark_mode_url";
          ((b.c)localObject1).wUg = bt.by((String)paramMap.get(localObject2), "");
          ((b.c)localObject1).wUh = bt.by((String)paramMap.get(str), "");
          ad.i("MicroMsg.ADXml", "Tag content = ", new Object[] { ((b.c)localObject1).wUf + ", Tag light iconUrl = " + ((b.c)localObject1).wUg + ", Tag dark iconUrl = " + ((b.c)localObject1).wUh });
          this.wUe.add(localObject1);
        }
        i += 1;
        break;
      }
      label297:
      AppMethodBeat.o(187337);
      return this;
    }
  }
  
  public static final class c
  {
    public String wUf;
    public String wUg;
    public String wUh;
  }
  
  public static final class d
  {
    public List<b.e> list;
    
    public d()
    {
      AppMethodBeat.i(96262);
      this.list = new LinkedList();
      AppMethodBeat.o(96262);
    }
    
    public final d s(Map<String, String> paramMap, String paramString)
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
          b.e locale = new b.e();
          locale.url = bt.by((String)paramMap.get(str2), "");
          locale.wUi = bt.by((String)paramMap.get(paramString + ".Wording.zh"), "");
          locale.wMv = bt.by((String)paramMap.get(paramString + ".Wording.en"), "");
          locale.wUj = bt.by((String)paramMap.get(paramString + ".Wording.tw"), "");
          if (locale.wUi.length() + locale.wMv.length() + locale.wUj.length() > 0) {
            this.list.add(locale);
          }
          i += 1;
          break;
        }
        AppMethodBeat.o(96263);
        return this;
      }
    }
  }
  
  public static final class e
  {
    public String url = "";
    public String wMv = "";
    public String wUi = "";
    public String wUj = "";
  }
  
  public static final class f
  {
    public String description;
    public String title;
    public int wUk;
    public int wUl = 30;
    public int wUm;
    public a wUn;
    public String wUo;
    public int wUp;
    public String wUq;
    public int wUr;
    public aq wUs;
    public b.m wUt;
    
    public static final class a
    {
      public int color;
      public long endTime;
      public long startTime;
      public float wUu;
      public String wUv;
    }
  }
  
  public final class g
  {
    public String wUw;
    public String wUx;
    
    public g() {}
  }
  
  public static final class h
  {
    public String description;
    public String title;
    public String wUA;
    public String wUB;
    public String wUC;
    public String wUD;
    public int wUk;
    public int wUl = 30;
    public int wUm;
    public int wUz;
  }
  
  public static final class i
  {
    public String appVersion;
    public String dbu;
    public String dkB;
    public String wRX;
    public List<b.l> wUE;
    
    public i()
    {
      AppMethodBeat.i(96264);
      this.wRX = "";
      this.wUE = new ArrayList();
      AppMethodBeat.o(96264);
    }
    
    public final void t(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(96265);
      this.wRX = bt.by((String)paramMap.get(paramString + ".adxml.adTurnActionLink"), "");
      String str = (String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.appUserName");
      if (!TextUtils.isEmpty(str))
      {
        this.dkB = str;
        this.appVersion = ((String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.appVersion"));
        this.dbu = ((String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.relativePagePath"));
      }
      str = paramString + ".adxml.adTurnInfo.materialInfo";
      int i = 0;
      if (i > 0) {}
      for (paramString = str + i;; paramString = str)
      {
        if ((paramMap.get(paramString + ".displayType") != null) && (((String)paramMap.get(paramString + ".displayType")).length() > 0))
        {
          b.l locall = new b.l();
          locall.title = bt.by((String)paramMap.get(paramString + ".title"), "");
          locall.desc = bt.by((String)paramMap.get(paramString + ".desc"), "");
          locall.wUk = bt.aGh((String)paramMap.get(paramString + ".displayType"));
          this.wUE.add(locall);
          i += 1;
          break;
        }
        AppMethodBeat.o(96265);
        return;
      }
    }
  }
  
  public final class j
  {
    public String wUF;
    public String wUG;
    public ArrayList<b.k> wUH;
    
    public j()
    {
      AppMethodBeat.i(96266);
      this.wUF = "";
      this.wUG = "";
      this.wUH = new ArrayList();
      AppMethodBeat.o(96266);
    }
    
    public final String MC(int paramInt)
    {
      AppMethodBeat.i(96267);
      if ((paramInt >= 0) && (paramInt < this.wUH.size()))
      {
        String str = ((b.k)this.wUH.get(paramInt)).wUJ;
        AppMethodBeat.o(96267);
        return str;
      }
      AppMethodBeat.o(96267);
      return "";
    }
    
    public final String MD(int paramInt)
    {
      AppMethodBeat.i(96268);
      if ((paramInt >= 0) && (paramInt < this.wUH.size()))
      {
        String str = ((b.k)this.wUH.get(paramInt)).title;
        AppMethodBeat.o(96268);
        return str;
      }
      AppMethodBeat.o(96268);
      return "";
    }
  }
  
  public final class k
  {
    public String id = "";
    public String oYb = "";
    public String rUO = "";
    public String title = "";
    public String wUI = "";
    public String wUJ = "";
    
    public k() {}
  }
  
  public static final class l
  {
    public String desc;
    public String title;
    public int wUk = 0;
  }
  
  public static final class m
  {
    public int wUK;
    public int wUL;
    public int wUM;
    public String wUN;
    public int wUO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.b
 * JD-Core Version:    0.7.0.1
 */
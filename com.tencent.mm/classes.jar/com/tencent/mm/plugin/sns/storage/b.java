package com.tencent.mm.plugin.sns.storage;

import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.device.appstore.a;
import com.tencent.mm.plugin.sns.ui.at;
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
  public String dBS;
  public String nickname;
  public b zcl;
  public String zeg;
  public String zuE;
  boolean zuN;
  public String zvA;
  public String zvB;
  public String zvC;
  public String zvD;
  public int zvE;
  public String zvF;
  public String zvG;
  public int zvH;
  public String zvI;
  public int zvJ;
  public String zvK;
  public String zvL;
  public String zvM;
  public String zvN;
  public String zvO;
  public String zvP;
  public int zvQ;
  public int zvR;
  public int zvS;
  public long zvT;
  public Map<String, String> zvU;
  boolean zvV;
  public int zvW;
  public int zvX;
  public float zvY;
  public float zvZ;
  public int zvv;
  public String zvw;
  public int zvx;
  public int zvy;
  public String zvz;
  public int zwA;
  public int zwB;
  public int zwC;
  public a zwD;
  public int zwE;
  private h zwF;
  public k zwG;
  public int zwa;
  public int zwb;
  public int zwc;
  public String zwd;
  public float zwe;
  public float zwf;
  public float zwg;
  public float zwh;
  public int zwi;
  public String zwj;
  public String zwk;
  public String zwl;
  public String zwm;
  public c zwn;
  public j zwo;
  public g zwp;
  public i zwq;
  public e zwr;
  public boolean zws;
  public String zwt;
  public String zwu;
  public int zwv;
  public int zww;
  public String zwx;
  public String zwy;
  public Intent zwz;
  
  public b(String paramString)
  {
    AppMethodBeat.i(96269);
    this.dBS = "";
    this.zvx = 0;
    this.zvy = 0;
    this.zvz = "";
    this.zvA = "";
    this.zvB = "";
    this.zvC = "";
    this.zvD = "";
    this.zvE = 0;
    this.zvF = "";
    this.zvG = "";
    this.zvH = 0;
    this.zvI = "";
    this.zvJ = 0;
    this.zvK = "";
    this.zvL = "";
    this.zvM = "";
    this.zvN = "";
    this.zvO = "";
    this.zvP = "";
    this.zvU = new HashMap();
    this.zwA = 0;
    this.zwB = 0;
    this.zwC = 0;
    this.zwE = -1;
    if ((!bt.isNullOrNil(paramString)) && (paramString.trim().startsWith("<RecXml")))
    {
      paramString = aF(paramString, ".RecXml", "RecXml");
      if ((paramString != null) && (!paramString.isEmpty()))
      {
        this.zvQ = bt.aRe((String)paramString.get(".RecXml.$type"));
        this.zvR = bt.aRe((String)paramString.get(".RecXml.$source"));
        this.zvS = bt.aRe((String)paramString.get(".RecXml.$expId"));
        this.zvT = q.ayi((String)paramString.get(".RecXml.$expOriginSnsId"));
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
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString3)))
    {
      AppMethodBeat.o(96270);
      return null;
    }
    this.dBS = paramString1;
    ad.i("MicroMsg.ADXml", "feed xml %s, keyPrefix %s, tag %s", new Object[] { paramString1, paramString2, paramString3 });
    Map localMap = bw.M(paramString1, paramString3);
    if (localMap == null)
    {
      AppMethodBeat.o(96270);
      return null;
    }
    this.zvv = bt.aRe((String)localMap.get(paramString2 + ".adxml.adType"));
    this.zvw = bt.bI((String)localMap.get(paramString2 + ".adxml.adActionTitle"), "");
    this.zuE = bt.bI((String)localMap.get(paramString2 + ".adxml.adActionLink"), "");
    this.nickname = bt.bI((String)localMap.get(paramString2 + ".adxml.nickname"), "");
    this.zvx = bt.aRe((String)localMap.get(paramString2 + ".adxml.webviewRightBarShow"));
    this.zvy = bt.aRe((String)localMap.get(paramString2 + ".adxml.adActionLinkHidden"));
    this.zvz = bt.bI((String)localMap.get(paramString2 + ".adxml.adActionLinkName"), "");
    this.zvA = bt.bI((String)localMap.get(paramString2 + ".adxml.adActionLinkIcon"), "");
    this.zvB = bt.bI((String)localMap.get(paramString2 + ".adxml.adActionLinkTitle.zh"), "");
    this.zvD = bt.bI((String)localMap.get(paramString2 + ".adxml.adActionLinkTitle.tw"), "");
    this.zvC = bt.bI((String)localMap.get(paramString2 + ".adxml.adActionLinkTitle.en"), "");
    this.zvF = bt.bI((String)localMap.get(paramString2 + ".adxml.attachShareLinkWording"), "");
    this.zvG = bt.bI((String)localMap.get(paramString2 + ".adxml.attachShareLinkUrl"), "");
    this.zvE = bt.aRe((String)localMap.get(paramString2 + ".adxml.attachShareLinkIsHidden"));
    if ((bt.isNullOrNil(this.zvF)) || (bt.isNullOrNil(this.zvG))) {
      this.zvE = 1;
    }
    this.zvK = bt.bI((String)localMap.get(paramString2 + ".adxml.expandOutsideTitle.zh"), "");
    this.zvM = bt.bI((String)localMap.get(paramString2 + ".adxml.expandOutsideTitle.tw"), "");
    this.zvL = bt.bI((String)localMap.get(paramString2 + ".adxml.expandOutsideTitle.en"), "");
    this.zvN = bt.bI((String)localMap.get(paramString2 + ".adxml.expandInsideTitle.zh"), "");
    this.zvP = bt.bI((String)localMap.get(paramString2 + ".adxml.expandInsideTitle.tw"), "");
    this.zvO = bt.bI((String)localMap.get(paramString2 + ".adxml.expandInsideTitle.en"), "");
    this.zvH = bt.aRe((String)localMap.get(paramString2 + ".adxml.headClickType"));
    this.zvI = bt.bI((String)localMap.get(paramString2 + ".adxml.headClickParam"), "");
    this.zvJ = bt.aRe((String)localMap.get(paramString2 + ".adxml.headClickRightBarShow"));
    this.zwA = bt.aRe((String)localMap.get(paramString2 + ".adxml.toAdMarket"));
    this.zwB = bt.aRe((String)localMap.get(paramString2 + ".adxml.newFeedback"));
    this.zwC = bt.aRe((String)localMap.get(paramString2 + ".adxml.videoPlayInStreamingMode"));
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
      ad.i("MicroMsg.ADXml", "newKey " + paramString3 + " " + (String)localObject1 + " newValue : " + paramString1 + " " + (String)localObject2);
      this.zvU.put(localObject1, localObject2);
      i += 1;
      break;
      paramString1 = Integer.valueOf(i);
      break label1128;
    }
    label1313:
    this.zuN = localMap.containsKey(paramString2 + ".adxml.adCanvasInfo");
    boolean bool;
    if (bt.aRe((String)localMap.get(paramString2 + ".adxml.usePreferedInfo")) == 1)
    {
      bool = true;
      this.zws = bool;
      this.zwt = bt.nullAsNil((String)localMap.get(paramString2 + ".adxml.preferNickname"));
      this.zwu = bt.nullAsNil((String)localMap.get(paramString2 + ".adxml.preferAvatar"));
      this.zvW = bt.aRe((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.contentDisplayType"));
      this.zvX = bt.aRe((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaDisplayMode"));
      this.zvY = ((float)bt.aRg((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaDisplayWidth")));
      this.zvZ = ((float)bt.aRg((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaDisplayHeight")));
      this.zwc = bt.aRe((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.btnDisplayType"));
      this.zwd = bt.bI((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconUrl"), "");
      this.zwa = bt.aRe((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.basicRemWidth"));
      this.zwb = bt.aRe((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.basicRootFontSize"));
      this.zwe = ((float)bt.aRg((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconWidth")));
      this.zwf = ((float)bt.aRg((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconHeight")));
      this.zwg = ((float)bt.aRg((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingRight")));
      this.zwh = ((float)bt.aRg((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingBottom")));
      this.zwi = bt.aRe((String)localMap.get(paramString2 + ".adxml.adContentStyle"));
      this.zwj = bt.bI((String)localMap.get(paramString2 + ".adxml.adCardInfo.title"), "");
      this.zwk = bt.bI((String)localMap.get(paramString2 + ".adxml.adCardInfo.description"), "");
      this.zwn = new c().u(localMap, paramString2);
      this.zwl = bt.nullAsNil((String)localMap.get(paramString2 + ".adxml.adCardInfo.adRatingCardInfo.headTitle"));
      this.zwm = bt.nullAsNil((String)localMap.get(paramString2 + ".adxml.adCardInfo.adRatingCardInfo.headUrl"));
      paramString1 = bt.bI((String)localMap.get(paramString2 + ".adxml.adSelectInfo.leftBtnTitle"), "");
      paramString3 = bt.bI((String)localMap.get(paramString2 + ".adxml.adSelectInfo.rightBtnTitle"), "");
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)))
      {
        this.zwF = new h();
        this.zwF.zxr = paramString1;
        this.zwF.zxs = paramString3;
      }
      paramString1 = bt.bI((String)localMap.get(paramString2 + ".adxml.adVoteInfo.componentUrl"), "");
      if (TextUtils.isEmpty(paramString1)) {
        break label2709;
      }
      this.zwG = new k();
      this.zwG.zxA = paramString1;
      this.zwG.zxB = bt.bI((String)localMap.get(paramString2 + ".adxml.adVoteInfo.voteLabel"), "");
      paramString3 = paramString2 + ".adxml.adVoteInfo.optionList.option";
      i = 0;
      label2365:
      if (i == 0) {
        break label5553;
      }
    }
    label2709:
    label5553:
    for (paramString1 = paramString3 + i;; paramString1 = paramString3)
    {
      if (!TextUtils.isEmpty(bt.bI((String)localMap.get(paramString1 + ".title"), "")))
      {
        localObject1 = new l();
        ((l)localObject1).title = bt.bI((String)localMap.get(paramString1 + ".title"), "");
        ((l)localObject1).qeR = bt.bI((String)localMap.get(paramString1 + ".shareTitle"), "");
        ((l)localObject1).uaw = bt.bI((String)localMap.get(paramString1 + ".shareDesc"), "");
        ((l)localObject1).zxD = bt.bI((String)localMap.get(paramString1 + ".shareThumb"), "");
        ((l)localObject1).zxE = bt.bI((String)localMap.get(paramString1 + ".selectedTitle"), "");
        ((l)localObject1).id = bt.bI((String)localMap.get(paramString1 + ".id"), "");
        this.zwG.zxC.add(localObject1);
        i += 1;
        break label2365;
        bool = false;
        break;
      }
      this.zvV = localMap.containsKey(paramString2 + ".adxml.adTurnCanvasInfo");
      this.zwo = new j();
      this.zwo.w(localMap, paramString2);
      this.zwr = new e().v(localMap, paramString2);
      if (this.zwi == 3)
      {
        this.zwp = new g();
        paramString3 = paramString2 + ".adxml.adFullCardInfo";
        paramString1 = this.zwp;
        paramString1.zxf = bt.aRe((String)localMap.get(paramString3 + ".displayType"));
        paramString1.title = bt.nullAsNil((String)localMap.get(paramString3 + ".title"));
        paramString1.description = bt.nullAsNil((String)localMap.get(paramString3 + ".description"));
        paramString1.zxg = bt.getInt((String)localMap.get(paramString3 + ".markMaxAlpha"), 30);
        paramString1.zxh = bt.aRe((String)localMap.get(paramString3 + ".titlePosition"));
        paramString1.zxj = bt.nullAsNil((String)localMap.get(paramString3 + ".maskImg"));
        paramString1.zxk = bt.aRe((String)localMap.get(paramString3 + ".maskImgDisappearTime"));
        paramString1.zxl = bt.nullAsNil((String)localMap.get(paramString3 + ".coverImg"));
        paramString1.zxm = bt.aRe((String)localMap.get(paramString3 + ".coverImgAppearTime"));
        if (!bt.isNullOrNil((String)localMap.get(paramString3 + ".adGestureInfo.points")))
        {
          paramString1.zxi = new b.g.a();
          paramString1.zxi.color = -1;
          paramString1.zxi.startTime = bt.aRe((String)localMap.get(paramString3 + ".adGestureInfo.startTime"));
          paramString1.zxi.endTime = bt.aRe((String)localMap.get(paramString3 + ".adGestureInfo.endTime"));
          paramString1.zxi.zxp = bt.aRh((String)localMap.get(paramString3 + ".adGestureInfo.distance"));
          paramString1.zxi.color = Color.parseColor(bt.nullAsNil((String)localMap.get(paramString3 + ".adGestureInfo.color")));
          paramString1.zxi.zxq = bt.nullAsNil((String)localMap.get(paramString3 + ".adGestureInfo.points"));
        }
        localObject1 = paramString3 + ".endCoverInfo";
        if (localMap.containsKey(localObject1))
        {
          paramString1.zxn = new at();
          paramString1.zxn.title = bt.nullAsNil((String)localMap.get((String)localObject1 + ".title"));
          paramString1.zxn.desc = bt.nullAsNil((String)localMap.get((String)localObject1 + ".description"));
          paramString1.zxn.zWW = bt.nullAsNil((String)localMap.get((String)localObject1 + ".actionTitle"));
          paramString1.zxn.coverImgUrl = bt.nullAsNil((String)localMap.get((String)localObject1 + ".ambientImageUrl"));
          paramString1.zxn.zWV = bt.nullAsNil((String)localMap.get((String)localObject1 + ".titleImageUrl"));
          paramString1.zxn.duration = bt.aRe((String)localMap.get((String)localObject1 + ".endCoverEndTime"));
        }
        paramString3 = paramString3 + ".adLongPressGestureInfo";
        if (localMap.containsKey(paramString3))
        {
          paramString1.zxo = new n();
          paramString1.zxo.zxF = bt.aRe((String)localMap.get(paramString3 + ".pressStartTime"));
          paramString1.zxo.zxG = bt.aRe((String)localMap.get(paramString3 + ".pressEndTime"));
          paramString1.zxo.zxH = bt.aRe((String)localMap.get(paramString3 + ".pressDuration"));
          paramString1.zxo.zxI = bt.nullAsNil((String)localMap.get(paramString3 + ".spriteImageUrl"));
          paramString1.zxo.zxJ = bt.aRe((String)localMap.get(paramString3 + ".spriteType"));
        }
      }
      for (;;)
      {
        this.zwv = bt.aRe((String)localMap.get(paramString2 + ".adxml.compatible.clientVersion.androidMin"));
        this.zww = bt.aRe((String)localMap.get(paramString2 + ".adxml.compatible.clientVersion.androidMax"));
        this.zwx = bt.nullAsNil((String)localMap.get(paramString2 + ".adxml.compatible.jumpUrl"));
        paramString1 = paramString2 + ".adxml.adCardInfo.adCardButton";
        if (localMap.containsKey(paramString1))
        {
          this.zcl = new b();
          paramString3 = this.zcl;
          paramString3.iconUrl = bt.nullAsNil((String)localMap.get(paramString1 + ".iconUrl"));
          paramString3.zwK = bt.nullAsNil((String)localMap.get(paramString1 + ".btnTitle"));
          paramString3.zwL = bt.getInt((String)localMap.get(paramString1 + ".clickActionType"), 0);
          paramString3.zwM = bt.nullAsNil((String)localMap.get(paramString1 + ".clickActionLink"));
          paramString3.pLS = bt.nullAsNil((String)localMap.get(paramString1 + ".weappUserName"));
          paramString3.hDs = bt.nullAsNil((String)localMap.get(paramString1 + ".weappPath"));
          paramString3.hDt = bt.getInt((String)localMap.get(paramString1 + ".weappVersion"), 0);
          paramString3.zwN = bt.nullAsNil((String)localMap.get(paramString1 + ".tempId"));
          paramString3.zwO = bt.nullAsNil((String)localMap.get(paramString1 + ".btnTitleAfterOrder"));
          paramString3.zwP = bt.nullAsNil((String)localMap.get(paramString1 + ".subscribeTitle"));
          paramString3.zwQ = bt.nullAsNil((String)localMap.get(paramString1 + ".subscribeContent"));
          paramString3.zwR = bt.nullAsNil((String)localMap.get(paramString1 + ".subscribeSubmitBtnTitle"));
          paramString3.zwS = bt.nullAsNil((String)localMap.get(paramString1 + ".subscribeFailedTip"));
          paramString3.zwT = bt.nullAsNil((String)localMap.get(paramString1 + ".subscribeSucTip"));
          paramString3.zwU = bt.nullAsNil((String)localMap.get(paramString1 + ".appType"));
          paramString3.appId = bt.nullAsNil((String)localMap.get(paramString1 + ".appId"));
          paramString3.zwV = bt.nullAsNil((String)localMap.get(paramString1 + ".subscribeHeadImg"));
          paramString3.zwW = bt.nullAsNil((String)localMap.get(paramString1 + ".subscribeNickname"));
          paramString3.zwX = bt.nullAsNil((String)localMap.get(paramString1 + ".openSdkAppId"));
          paramString3.zwY = bt.nullAsNil((String)localMap.get(paramString1 + ".packageName"));
          paramString3.zve = bt.nullAsNil((String)localMap.get(paramString1 + ".appPageUrlAndroid"));
          paramString3.oyC = bt.nullAsNil((String)localMap.get(paramString1 + ".cardTpId"));
          paramString3.ozz = bt.nullAsNil((String)localMap.get(paramString1 + ".cardExt"));
          if (!TextUtils.isEmpty(this.zcl.zwY))
          {
            this.zwy = this.zcl.zwY;
            ad.i("MicroMsg.ADXml", "findDownloadApkPkgName, adCardActionBtnInfo.pkg=" + this.zcl.zwY);
          }
        }
        if (TextUtils.isEmpty(this.zwy)) {
          aL(localMap);
        }
        this.zeg = h.axM((String)localMap.get(paramString2 + ".adxml.adExtInfo"));
        try
        {
          paramString1 = a.b(aj.getContext(), localMap);
          if (paramString1 != null) {
            this.zwz = paramString1.dSS();
          }
        }
        catch (Throwable paramString1)
        {
          label5091:
          break label5091;
        }
        this.zwD = a.t(localMap, paramString2 + ".adxml.adScanInfo");
        AppMethodBeat.o(96270);
        return localMap;
        if (this.zwi == 4)
        {
          this.zwq = new i();
          paramString1 = paramString2 + ".adxml.adSphereCardInfo";
          paramString3 = this.zwq;
          paramString3.zxf = bt.aRe((String)localMap.get(paramString1 + ".displayType"));
          paramString3.title = bt.nullAsNil((String)localMap.get(paramString1 + ".title"));
          paramString3.description = bt.nullAsNil((String)localMap.get(paramString1 + ".description"));
          paramString3.zxg = bt.getInt((String)localMap.get(paramString1 + ".markMaxAlpha"), 30);
          paramString3.zxh = bt.aRe((String)localMap.get(paramString1 + ".titlePosition"));
          paramString3.zxu = bt.aRe((String)localMap.get(paramString1 + ".gestureDelayTime"));
          paramString3.zxw = bt.nullAsNil((String)localMap.get(paramString1 + ".sphereThumbUrl"));
          paramString3.zxx = bt.nullAsNil((String)localMap.get(paramString1 + ".bgColor"));
          paramString3.zxy = bt.nullAsNil((String)localMap.get(paramString1 + ".bgColorAlpha"));
          paramString3.zxv = bt.nullAsNil((String)localMap.get(paramString1 + ".sphereImageUrl"));
        }
      }
    }
  }
  
  private void aL(Map<String, String> paramMap)
  {
    AppMethodBeat.i(197883);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(197883);
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
          this.zwy = str2;
          ad.i("MicroMsg.ADXml", "findDownloadApkPkgName, key=" + str1 + ", pkg=" + str2);
          AppMethodBeat.o(197883);
          return;
        }
      }
    }
    AppMethodBeat.o(197883);
  }
  
  public final boolean dVT()
  {
    return (this.zcl != null) && (this.zcl.zwL >= 0);
  }
  
  public final boolean dVU()
  {
    return (this.zuN) || (this.zvV);
  }
  
  public final String dVV()
  {
    AppMethodBeat.i(96271);
    String str;
    if (dWd())
    {
      str = this.zwF.zxr;
      AppMethodBeat.o(96271);
      return str;
    }
    if (dWf())
    {
      str = ((l)this.zwG.zxC.get(0)).title;
      AppMethodBeat.o(96271);
      return str;
    }
    AppMethodBeat.o(96271);
    return "";
  }
  
  public final String dVW()
  {
    AppMethodBeat.i(96272);
    String str;
    if (dWd())
    {
      str = this.zwF.zxs;
      AppMethodBeat.o(96272);
      return str;
    }
    if (dWf())
    {
      str = ((l)this.zwG.zxC.get(1)).title;
      AppMethodBeat.o(96272);
      return str;
    }
    AppMethodBeat.o(96272);
    return "";
  }
  
  public final String dVX()
  {
    AppMethodBeat.i(96273);
    if (dWf())
    {
      String str = this.zwG.zxA;
      AppMethodBeat.o(96273);
      return str;
    }
    AppMethodBeat.o(96273);
    return "";
  }
  
  public final boolean dVY()
  {
    return this.zwi == 2;
  }
  
  public final boolean dVZ()
  {
    return this.zwi == 1;
  }
  
  public final boolean dWa()
  {
    return this.zwi == 3;
  }
  
  public final boolean dWb()
  {
    return this.zwi == 4;
  }
  
  public final boolean dWc()
  {
    AppMethodBeat.i(197882);
    if ((dWa()) && (this.zwp != null) && (this.zwp.zxo != null) && (this.zwp.zxo.zxF > 0) && (this.zwp.zxo.zxG > this.zwp.zxo.zxF))
    {
      AppMethodBeat.o(197882);
      return true;
    }
    AppMethodBeat.o(197882);
    return false;
  }
  
  public final boolean dWd()
  {
    return this.zwF != null;
  }
  
  public final boolean dWe()
  {
    AppMethodBeat.i(96274);
    if ((this.zwG != null) && (this.zwG.zxC.size() > 1) && (!TextUtils.isEmpty(((l)this.zwG.zxC.get(0)).id)) && (!TextUtils.isEmpty(((l)this.zwG.zxC.get(1)).id)))
    {
      AppMethodBeat.o(96274);
      return true;
    }
    AppMethodBeat.o(96274);
    return false;
  }
  
  public final boolean dWf()
  {
    AppMethodBeat.i(96275);
    if ((this.zwG != null) && (this.zwG.zxC.size() > 1))
    {
      AppMethodBeat.o(96275);
      return true;
    }
    AppMethodBeat.o(96275);
    return false;
  }
  
  public final String dWg()
  {
    AppMethodBeat.i(96276);
    String str2 = this.dBS;
    String str1 = str2;
    if (str2.contains("<adCanvasInfoLeft>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "").replaceAll("adCanvasInfoLeft", "adCanvasInfo");
    }
    AppMethodBeat.o(96276);
    return str1;
  }
  
  public final String dWh()
  {
    AppMethodBeat.i(96277);
    String str2 = this.dBS;
    String str1 = str2;
    if (str2.contains("<adCanvasInfoRight>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("adCanvasInfoRight", "adCanvasInfo");
    }
    AppMethodBeat.o(96277);
    return str1;
  }
  
  public final String dWi()
  {
    AppMethodBeat.i(96278);
    String str2 = this.dBS;
    String str1 = str2;
    if (str2.contains("<adTurnCanvasInfo>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adTurnCanvasInfo", "adCanvasInfo");
    }
    AppMethodBeat.o(96278);
    return str1;
  }
  
  public final String dWj()
  {
    AppMethodBeat.i(96279);
    String str = this.dBS;
    if ((this.zwp != null) && (str.contains("<adFullCardGestureCanvasInfo>"))) {}
    for (str = str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adFullCardGestureCanvasInfo", "adCanvasInfo");; str = "")
    {
      AppMethodBeat.o(96279);
      return str;
    }
  }
  
  public final boolean dWk()
  {
    return this.zvR == 2;
  }
  
  public static final class a
  {
    public String desc;
    public String oyt;
    public String zwH;
    public String zwI;
    public int zwJ;
    
    public static a t(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(197879);
      String str1 = bt.nullAsNil((String)paramMap.get(paramString + ".bgImage"));
      String str2 = bt.nullAsNil((String)paramMap.get(paramString + ".desc"));
      String str3 = bt.nullAsNil((String)paramMap.get(paramString + ".descIcon"));
      String str4 = bt.nullAsNil((String)paramMap.get(paramString + ".detectSucIcon"));
      int i = bt.aRe((String)paramMap.get(paramString + ".scanGestureType"));
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)) && (i > 0))
      {
        paramMap = new a();
        paramMap.zwH = str1;
        paramMap.desc = str2;
        paramMap.oyt = str3;
        paramMap.zwI = str4;
        paramMap.zwJ = i;
        AppMethodBeat.o(197879);
        return paramMap;
      }
      AppMethodBeat.o(197879);
      return null;
    }
  }
  
  public static final class b
  {
    public String appId;
    public String hDs;
    public int hDt;
    public String iconUrl;
    public String oyC;
    public String ozz;
    public String pLS;
    public String zve;
    public String zwK;
    public int zwL;
    public String zwM;
    public String zwN;
    public String zwO;
    public String zwP;
    public String zwQ;
    public String zwR;
    public String zwS;
    public String zwT;
    public String zwU;
    public String zwV;
    public String zwW;
    public String zwX;
    public String zwY;
  }
  
  public static final class c
  {
    public List<b.d> zwZ;
    
    public c()
    {
      AppMethodBeat.i(197880);
      this.zwZ = new ArrayList();
      AppMethodBeat.o(197880);
    }
    
    public final c u(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(197881);
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
          localObject1 = new b.d();
          ((b.d)localObject1).zxa = bt.bI((String)paramMap.get(str), "");
          localObject2 = str + ".$light_mode_url";
          str = str + ".$dark_mode_url";
          ((b.d)localObject1).zxb = bt.bI((String)paramMap.get(localObject2), "");
          ((b.d)localObject1).zxc = bt.bI((String)paramMap.get(str), "");
          ad.i("MicroMsg.ADXml", "Tag content = ", new Object[] { ((b.d)localObject1).zxa + ", Tag light iconUrl = " + ((b.d)localObject1).zxb + ", Tag dark iconUrl = " + ((b.d)localObject1).zxc });
          this.zwZ.add(localObject1);
        }
        i += 1;
        break;
      }
      label297:
      AppMethodBeat.o(197881);
      return this;
    }
  }
  
  public static final class d
  {
    public String zxa;
    public String zxb;
    public String zxc;
  }
  
  public static final class e
  {
    public List<b.f> list;
    
    public e()
    {
      AppMethodBeat.i(96262);
      this.list = new LinkedList();
      AppMethodBeat.o(96262);
    }
    
    public final e v(Map<String, String> paramMap, String paramString)
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
          b.f localf = new b.f();
          localf.url = bt.bI((String)paramMap.get(str2), "");
          localf.zxd = bt.bI((String)paramMap.get(paramString + ".Wording.zh"), "");
          localf.zpa = bt.bI((String)paramMap.get(paramString + ".Wording.en"), "");
          localf.zxe = bt.bI((String)paramMap.get(paramString + ".Wording.tw"), "");
          if (localf.zxd.length() + localf.zpa.length() + localf.zxe.length() > 0) {
            this.list.add(localf);
          }
          i += 1;
          break;
        }
        AppMethodBeat.o(96263);
        return this;
      }
    }
  }
  
  public static final class f
  {
    public String url = "";
    public String zpa = "";
    public String zxd = "";
    public String zxe = "";
  }
  
  public static final class g
  {
    public String description;
    public String title;
    public int zxf;
    public int zxg = 30;
    public int zxh;
    public a zxi;
    public String zxj;
    public int zxk;
    public String zxl;
    public int zxm;
    public at zxn;
    public b.n zxo;
    
    public static final class a
    {
      public int color;
      public long endTime;
      public long startTime;
      public float zxp;
      public String zxq;
    }
  }
  
  public final class h
  {
    public String zxr;
    public String zxs;
    
    public h() {}
  }
  
  public static final class i
  {
    public String description;
    public String title;
    public int zxf;
    public int zxg = 30;
    public int zxh;
    public int zxu;
    public String zxv;
    public String zxw;
    public String zxx;
    public String zxy;
  }
  
  public static final class j
  {
    public String appVersion;
    public String dki;
    public String dtE;
    public String zuE;
    public List<b.m> zxz;
    
    public j()
    {
      AppMethodBeat.i(96264);
      this.zuE = "";
      this.zxz = new ArrayList();
      AppMethodBeat.o(96264);
    }
    
    public final void w(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(96265);
      this.zuE = bt.bI((String)paramMap.get(paramString + ".adxml.adTurnActionLink"), "");
      String str = (String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.appUserName");
      if (!TextUtils.isEmpty(str))
      {
        this.dtE = str;
        this.appVersion = ((String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.appVersion"));
        this.dki = ((String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.relativePagePath"));
      }
      str = paramString + ".adxml.adTurnInfo.materialInfo";
      int i = 0;
      if (i > 0) {}
      for (paramString = str + i;; paramString = str)
      {
        if ((paramMap.get(paramString + ".displayType") != null) && (((String)paramMap.get(paramString + ".displayType")).length() > 0))
        {
          b.m localm = new b.m();
          localm.title = bt.bI((String)paramMap.get(paramString + ".title"), "");
          localm.desc = bt.bI((String)paramMap.get(paramString + ".desc"), "");
          localm.zxf = bt.aRe((String)paramMap.get(paramString + ".displayType"));
          this.zxz.add(localm);
          i += 1;
          break;
        }
        AppMethodBeat.o(96265);
        return;
      }
    }
  }
  
  public final class k
  {
    public String zxA;
    public String zxB;
    public ArrayList<b.l> zxC;
    
    public k()
    {
      AppMethodBeat.i(96266);
      this.zxA = "";
      this.zxB = "";
      this.zxC = new ArrayList();
      AppMethodBeat.o(96266);
    }
    
    public final String Qm(int paramInt)
    {
      AppMethodBeat.i(96267);
      if ((paramInt >= 0) && (paramInt < this.zxC.size()))
      {
        String str = ((b.l)this.zxC.get(paramInt)).zxE;
        AppMethodBeat.o(96267);
        return str;
      }
      AppMethodBeat.o(96267);
      return "";
    }
    
    public final String Qn(int paramInt)
    {
      AppMethodBeat.i(96268);
      if ((paramInt >= 0) && (paramInt < this.zxC.size()))
      {
        String str = ((b.l)this.zxC.get(paramInt)).title;
        AppMethodBeat.o(96268);
        return str;
      }
      AppMethodBeat.o(96268);
      return "";
    }
  }
  
  public final class l
  {
    public String id = "";
    public String qeR = "";
    public String title = "";
    public String uaw = "";
    public String zxD = "";
    public String zxE = "";
    
    public l() {}
  }
  
  public static final class m
  {
    public String desc;
    public String title;
    public int zxf = 0;
  }
  
  public static final class n
  {
    public int zxF;
    public int zxG;
    public int zxH;
    public String zxI;
    public int zxJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.b
 * JD-Core Version:    0.7.0.1
 */
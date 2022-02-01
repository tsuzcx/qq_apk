package com.tencent.mm.plugin.sns.storage;

import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.device.appstore.a;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b
{
  public int DeA;
  public String dqf;
  public String nickname;
  public String xOm;
  public String yeD;
  boolean yeM;
  public String yfA;
  public String yfB;
  public int yfC;
  public String yfD;
  public String yfE;
  public int yfF;
  public String yfG;
  public int yfH;
  public String yfI;
  public String yfJ;
  public String yfK;
  public String yfL;
  public String yfM;
  public String yfN;
  public int yfO;
  public int yfP;
  public int yfQ;
  public long yfR;
  public Map<String, String> yfS;
  boolean yfT;
  public int yfU;
  public int yfV;
  public float yfW;
  public float yfX;
  public int yfY;
  public int yfZ;
  public int yft;
  public String yfu;
  public int yfv;
  public int yfw;
  public String yfx;
  public String yfy;
  public String yfz;
  public a ygA;
  private h ygB;
  public k ygC;
  public int yga;
  public String ygb;
  public float ygc;
  public float ygd;
  public float yge;
  public float ygf;
  public int ygg;
  public String ygh;
  public String ygi;
  public String ygj;
  public String ygk;
  public b.c ygl;
  public j ygm;
  public g ygn;
  public i ygo;
  public e ygp;
  public boolean ygq;
  public String ygr;
  public String ygs;
  public int ygt;
  public int ygu;
  public String ygv;
  public b ygw;
  public String ygx;
  public Intent ygy;
  public int ygz;
  
  public b(String paramString)
  {
    AppMethodBeat.i(96269);
    this.dqf = "";
    this.yfv = 0;
    this.yfw = 0;
    this.yfx = "";
    this.yfy = "";
    this.yfz = "";
    this.yfA = "";
    this.yfB = "";
    this.yfC = 0;
    this.yfD = "";
    this.yfE = "";
    this.yfF = 0;
    this.yfG = "";
    this.yfH = 0;
    this.yfI = "";
    this.yfJ = "";
    this.yfK = "";
    this.yfL = "";
    this.yfM = "";
    this.yfN = "";
    this.yfS = new HashMap();
    this.ygz = 0;
    this.DeA = 0;
    if ((!bs.isNullOrNil(paramString)) && (paramString.trim().startsWith("<RecXml")))
    {
      paramString = ay(paramString, ".RecXml", "RecXml");
      if ((paramString != null) && (!paramString.isEmpty()))
      {
        this.yfO = bs.aLy((String)paramString.get(".RecXml.$type"));
        this.yfP = bs.aLy((String)paramString.get(".RecXml.$source"));
        this.yfQ = bs.aLy((String)paramString.get(".RecXml.$expId"));
        this.yfR = q.atd((String)paramString.get(".RecXml.$expOriginSnsId"));
      }
      AppMethodBeat.o(96269);
      return;
    }
    ay(paramString, "", "adxml");
    AppMethodBeat.o(96269);
  }
  
  private void aI(Map<String, String> paramMap)
  {
    AppMethodBeat.i(200135);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(200135);
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
          this.ygx = str2;
          ac.i("MicroMsg.ADXml", "findDownloadApkPkgName, key=" + str1 + ", pkg=" + str2);
          AppMethodBeat.o(200135);
          return;
        }
      }
    }
    AppMethodBeat.o(200135);
  }
  
  private Map<String, String> ay(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96270);
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString3)))
    {
      AppMethodBeat.o(96270);
      return null;
    }
    this.dqf = paramString1;
    ac.i("MicroMsg.ADXml", "feed xml %s, keyPrefix %s, tag %s", new Object[] { paramString1, paramString2, paramString3 });
    Map localMap = bv.L(paramString1, paramString3);
    if (localMap == null)
    {
      AppMethodBeat.o(96270);
      return null;
    }
    this.yft = bs.aLy((String)localMap.get(paramString2 + ".adxml.adType"));
    this.yfu = bs.bG((String)localMap.get(paramString2 + ".adxml.adActionTitle"), "");
    this.yeD = bs.bG((String)localMap.get(paramString2 + ".adxml.adActionLink"), "");
    this.nickname = bs.bG((String)localMap.get(paramString2 + ".adxml.nickname"), "");
    this.yfv = bs.aLy((String)localMap.get(paramString2 + ".adxml.webviewRightBarShow"));
    this.yfw = bs.aLy((String)localMap.get(paramString2 + ".adxml.adActionLinkHidden"));
    this.yfx = bs.bG((String)localMap.get(paramString2 + ".adxml.adActionLinkName"), "");
    this.yfy = bs.bG((String)localMap.get(paramString2 + ".adxml.adActionLinkIcon"), "");
    this.yfz = bs.bG((String)localMap.get(paramString2 + ".adxml.adActionLinkTitle.zh"), "");
    this.yfB = bs.bG((String)localMap.get(paramString2 + ".adxml.adActionLinkTitle.tw"), "");
    this.yfA = bs.bG((String)localMap.get(paramString2 + ".adxml.adActionLinkTitle.en"), "");
    this.yfD = bs.bG((String)localMap.get(paramString2 + ".adxml.attachShareLinkWording"), "");
    this.yfE = bs.bG((String)localMap.get(paramString2 + ".adxml.attachShareLinkUrl"), "");
    this.yfC = bs.aLy((String)localMap.get(paramString2 + ".adxml.attachShareLinkIsHidden"));
    if ((bs.isNullOrNil(this.yfD)) || (bs.isNullOrNil(this.yfE))) {
      this.yfC = 1;
    }
    this.yfI = bs.bG((String)localMap.get(paramString2 + ".adxml.expandOutsideTitle.zh"), "");
    this.yfK = bs.bG((String)localMap.get(paramString2 + ".adxml.expandOutsideTitle.tw"), "");
    this.yfJ = bs.bG((String)localMap.get(paramString2 + ".adxml.expandOutsideTitle.en"), "");
    this.yfL = bs.bG((String)localMap.get(paramString2 + ".adxml.expandInsideTitle.zh"), "");
    this.yfN = bs.bG((String)localMap.get(paramString2 + ".adxml.expandInsideTitle.tw"), "");
    this.yfM = bs.bG((String)localMap.get(paramString2 + ".adxml.expandInsideTitle.en"), "");
    this.yfF = bs.aLy((String)localMap.get(paramString2 + ".adxml.headClickType"));
    this.yfG = bs.bG((String)localMap.get(paramString2 + ".adxml.headClickParam"), "");
    this.yfH = bs.aLy((String)localMap.get(paramString2 + ".adxml.headClickRightBarShow"));
    this.ygz = bs.aLy((String)localMap.get(paramString2 + ".adxml.toAdMarket"));
    this.DeA = bs.aLy((String)localMap.get(paramString2 + ".adxml.newFeedback"));
    int i = 0;
    paramString3 = new StringBuilder().append(paramString2).append(".adxml.adArgs.arg");
    label1091:
    Object localObject1;
    Object localObject2;
    if (i == 0)
    {
      paramString1 = "";
      paramString3 = paramString1 + ".key";
      localObject1 = (String)localMap.get(paramString3);
      if (localObject1 == null) {
        break label1276;
      }
      localObject2 = new StringBuilder().append(paramString2).append(".adxml.adArgs.arg");
      if (i != 0) {
        break label1267;
      }
    }
    label1267:
    for (paramString1 = "";; paramString1 = Integer.valueOf(i))
    {
      paramString1 = paramString1 + ".value";
      localObject2 = (String)localMap.get(paramString1);
      ac.i("MicroMsg.ADXml", "newKey " + paramString3 + " " + (String)localObject1 + " newValue : " + paramString1 + " " + (String)localObject2);
      this.yfS.put(localObject1, localObject2);
      i += 1;
      break;
      paramString1 = Integer.valueOf(i);
      break label1091;
    }
    label1276:
    this.yeM = localMap.containsKey(paramString2 + ".adxml.adCanvasInfo");
    boolean bool;
    if (bs.aLy((String)localMap.get(paramString2 + ".adxml.usePreferedInfo")) == 1)
    {
      bool = true;
      this.ygq = bool;
      this.ygr = bs.nullAsNil((String)localMap.get(paramString2 + ".adxml.preferNickname"));
      this.ygs = bs.nullAsNil((String)localMap.get(paramString2 + ".adxml.preferAvatar"));
      this.yfU = bs.aLy((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.contentDisplayType"));
      this.yfV = bs.aLy((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaDisplayMode"));
      this.yfW = ((float)bs.aLA((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaDisplayWidth")));
      this.yfX = ((float)bs.aLA((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaDisplayHeight")));
      this.yga = bs.aLy((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.btnDisplayType"));
      this.ygb = bs.bG((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconUrl"), "");
      this.yfY = bs.aLy((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.basicRemWidth"));
      this.yfZ = bs.aLy((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.basicRootFontSize"));
      this.ygc = ((float)bs.aLA((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconWidth")));
      this.ygd = ((float)bs.aLA((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconHeight")));
      this.yge = ((float)bs.aLA((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingRight")));
      this.ygf = ((float)bs.aLA((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingBottom")));
      this.ygg = bs.aLy((String)localMap.get(paramString2 + ".adxml.adContentStyle"));
      this.ygh = bs.bG((String)localMap.get(paramString2 + ".adxml.adCardInfo.title"), "");
      this.ygi = bs.bG((String)localMap.get(paramString2 + ".adxml.adCardInfo.description"), "");
      this.ygl = new b.c().s(localMap, paramString2);
      this.ygj = bs.nullAsNil((String)localMap.get(paramString2 + ".adxml.adCardInfo.adRatingCardInfo.headTitle"));
      this.ygk = bs.nullAsNil((String)localMap.get(paramString2 + ".adxml.adCardInfo.adRatingCardInfo.headUrl"));
      paramString1 = bs.bG((String)localMap.get(paramString2 + ".adxml.adSelectInfo.leftBtnTitle"), "");
      paramString3 = bs.bG((String)localMap.get(paramString2 + ".adxml.adSelectInfo.rightBtnTitle"), "");
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)))
      {
        this.ygB = new h();
        this.ygB.yhk = paramString1;
        this.ygB.yhl = paramString3;
      }
      paramString1 = bs.bG((String)localMap.get(paramString2 + ".adxml.adVoteInfo.componentUrl"), "");
      if (TextUtils.isEmpty(paramString1)) {
        break label2672;
      }
      this.ygC = new k();
      this.ygC.yht = paramString1;
      this.ygC.yhu = bs.bG((String)localMap.get(paramString2 + ".adxml.adVoteInfo.voteLabel"), "");
      paramString3 = paramString2 + ".adxml.adVoteInfo.optionList.option";
      i = 0;
      label2328:
      if (i == 0) {
        break label5405;
      }
    }
    label5405:
    for (paramString1 = paramString3 + i;; paramString1 = paramString3)
    {
      if (!TextUtils.isEmpty(bs.bG((String)localMap.get(paramString1 + ".title"), "")))
      {
        localObject1 = new l();
        ((l)localObject1).title = bs.bG((String)localMap.get(paramString1 + ".title"), "");
        ((l)localObject1).pBm = bs.bG((String)localMap.get(paramString1 + ".shareTitle"), "");
        ((l)localObject1).tcG = bs.bG((String)localMap.get(paramString1 + ".shareDesc"), "");
        ((l)localObject1).yhw = bs.bG((String)localMap.get(paramString1 + ".shareThumb"), "");
        ((l)localObject1).yhx = bs.bG((String)localMap.get(paramString1 + ".selectedTitle"), "");
        ((l)localObject1).id = bs.bG((String)localMap.get(paramString1 + ".id"), "");
        this.ygC.yhv.add(localObject1);
        i += 1;
        break label2328;
        bool = false;
        break;
      }
      label2672:
      this.yfT = localMap.containsKey(paramString2 + ".adxml.adTurnCanvasInfo");
      this.ygm = new j();
      this.ygm.u(localMap, paramString2);
      this.ygp = new e().t(localMap, paramString2);
      if (this.ygg == 3)
      {
        this.ygn = new g();
        paramString3 = paramString2 + ".adxml.adFullCardInfo";
        paramString1 = this.ygn;
        paramString1.ygY = bs.aLy((String)localMap.get(paramString3 + ".displayType"));
        paramString1.title = bs.nullAsNil((String)localMap.get(paramString3 + ".title"));
        paramString1.description = bs.nullAsNil((String)localMap.get(paramString3 + ".description"));
        paramString1.ygZ = bs.getInt((String)localMap.get(paramString3 + ".markMaxAlpha"), 30);
        paramString1.yha = bs.aLy((String)localMap.get(paramString3 + ".titlePosition"));
        paramString1.yhc = bs.nullAsNil((String)localMap.get(paramString3 + ".maskImg"));
        paramString1.yhd = bs.aLy((String)localMap.get(paramString3 + ".maskImgDisappearTime"));
        paramString1.yhe = bs.nullAsNil((String)localMap.get(paramString3 + ".coverImg"));
        paramString1.yhf = bs.aLy((String)localMap.get(paramString3 + ".coverImgAppearTime"));
        if (!bs.isNullOrNil((String)localMap.get(paramString3 + ".adGestureInfo.points")))
        {
          paramString1.yhb = new b.g.a();
          paramString1.yhb.color = -1;
          paramString1.yhb.startTime = bs.aLy((String)localMap.get(paramString3 + ".adGestureInfo.startTime"));
          paramString1.yhb.endTime = bs.aLy((String)localMap.get(paramString3 + ".adGestureInfo.endTime"));
          paramString1.yhb.yhi = bs.aLB((String)localMap.get(paramString3 + ".adGestureInfo.distance"));
          paramString1.yhb.color = Color.parseColor(bs.nullAsNil((String)localMap.get(paramString3 + ".adGestureInfo.color")));
          paramString1.yhb.yhj = bs.nullAsNil((String)localMap.get(paramString3 + ".adGestureInfo.points"));
        }
        localObject1 = paramString3 + ".endCoverInfo";
        if (localMap.containsKey(localObject1))
        {
          paramString1.yhg = new aq();
          paramString1.yhg.title = bs.nullAsNil((String)localMap.get((String)localObject1 + ".title"));
          paramString1.yhg.desc = bs.nullAsNil((String)localMap.get((String)localObject1 + ".description"));
          paramString1.yhg.yFE = bs.nullAsNil((String)localMap.get((String)localObject1 + ".actionTitle"));
          paramString1.yhg.coverImgUrl = bs.nullAsNil((String)localMap.get((String)localObject1 + ".ambientImageUrl"));
          paramString1.yhg.yFD = bs.nullAsNil((String)localMap.get((String)localObject1 + ".titleImageUrl"));
          paramString1.yhg.duration = bs.aLy((String)localMap.get((String)localObject1 + ".endCoverEndTime"));
        }
        paramString3 = paramString3 + ".adLongPressGestureInfo";
        if (localMap.containsKey(paramString3))
        {
          paramString1.yhh = new n();
          paramString1.yhh.yhy = bs.aLy((String)localMap.get(paramString3 + ".pressStartTime"));
          paramString1.yhh.yhz = bs.aLy((String)localMap.get(paramString3 + ".pressEndTime"));
          paramString1.yhh.yhA = bs.aLy((String)localMap.get(paramString3 + ".pressDuration"));
          paramString1.yhh.yhB = bs.nullAsNil((String)localMap.get(paramString3 + ".spriteImageUrl"));
          paramString1.yhh.yhC = bs.aLy((String)localMap.get(paramString3 + ".spriteType"));
        }
      }
      for (;;)
      {
        this.ygt = bs.aLy((String)localMap.get(paramString2 + ".adxml.compatible.clientVersion.androidMin"));
        this.ygu = bs.aLy((String)localMap.get(paramString2 + ".adxml.compatible.clientVersion.androidMax"));
        this.ygv = bs.nullAsNil((String)localMap.get(paramString2 + ".adxml.compatible.jumpUrl"));
        paramString1 = paramString2 + ".adxml.adCardInfo.adCardButton";
        if (localMap.containsKey(paramString1))
        {
          this.ygw = new b();
          paramString3 = this.ygw;
          paramString3.iconUrl = bs.nullAsNil((String)localMap.get(paramString1 + ".iconUrl"));
          paramString3.ygG = bs.nullAsNil((String)localMap.get(paramString1 + ".btnTitle"));
          paramString3.ygH = bs.getInt((String)localMap.get(paramString1 + ".clickActionType"), 0);
          paramString3.ygI = bs.nullAsNil((String)localMap.get(paramString1 + ".clickActionLink"));
          paramString3.pis = bs.nullAsNil((String)localMap.get(paramString1 + ".weappUserName"));
          paramString3.hlj = bs.nullAsNil((String)localMap.get(paramString1 + ".weappPath"));
          paramString3.hlk = bs.getInt((String)localMap.get(paramString1 + ".weappVersion"), 0);
          paramString3.ygJ = bs.nullAsNil((String)localMap.get(paramString1 + ".tempId"));
          paramString3.ygK = bs.nullAsNil((String)localMap.get(paramString1 + ".btnTitleAfterOrder"));
          paramString3.ygL = bs.nullAsNil((String)localMap.get(paramString1 + ".subscribeTitle"));
          paramString3.ygM = bs.nullAsNil((String)localMap.get(paramString1 + ".subscribeContent"));
          paramString3.pis = bs.nullAsNil((String)localMap.get(paramString1 + ".weappUserName"));
          paramString3.ygN = bs.nullAsNil((String)localMap.get(paramString1 + ".subscribeSubmitBtnTitle"));
          paramString3.ygO = bs.nullAsNil((String)localMap.get(paramString1 + ".subscribeFailedTip"));
          paramString3.ygP = bs.nullAsNil((String)localMap.get(paramString1 + ".subscribeSucTip"));
          paramString3.ygQ = bs.nullAsNil((String)localMap.get(paramString1 + ".openSdkAppId"));
          paramString3.ygR = bs.nullAsNil((String)localMap.get(paramString1 + ".packageName"));
          paramString3.yfc = bs.nullAsNil((String)localMap.get(paramString1 + ".appPageUrlAndroid"));
          paramString3.nVh = bs.nullAsNil((String)localMap.get(paramString1 + ".cardTpId"));
          paramString3.nWf = bs.nullAsNil((String)localMap.get(paramString1 + ".cardExt"));
          if (!TextUtils.isEmpty(this.ygw.ygR))
          {
            this.ygx = this.ygw.ygR;
            ac.i("MicroMsg.ADXml", "findDownloadApkPkgName, adCardActionBtnInfo.pkg=" + this.ygw.ygR);
          }
        }
        if (TextUtils.isEmpty(this.ygx)) {
          aI(localMap);
        }
        this.xOm = h.asK((String)localMap.get(paramString2 + ".adxml.adExtInfo"));
        try
        {
          paramString1 = a.b(ai.getContext(), localMap);
          if (paramString1 != null) {
            this.ygy = paramString1.dGF();
          }
        }
        catch (Throwable paramString1)
        {
          label4943:
          break label4943;
        }
        this.ygA = a.r(localMap, paramString2 + ".adxml.adScanInfo");
        AppMethodBeat.o(96270);
        return localMap;
        if (this.ygg == 4)
        {
          this.ygo = new i();
          paramString1 = paramString2 + ".adxml.adSphereCardInfo";
          paramString3 = this.ygo;
          paramString3.ygY = bs.aLy((String)localMap.get(paramString1 + ".displayType"));
          paramString3.title = bs.nullAsNil((String)localMap.get(paramString1 + ".title"));
          paramString3.description = bs.nullAsNil((String)localMap.get(paramString1 + ".description"));
          paramString3.ygZ = bs.getInt((String)localMap.get(paramString1 + ".markMaxAlpha"), 30);
          paramString3.yha = bs.aLy((String)localMap.get(paramString1 + ".titlePosition"));
          paramString3.yhn = bs.aLy((String)localMap.get(paramString1 + ".gestureDelayTime"));
          paramString3.yhp = bs.nullAsNil((String)localMap.get(paramString1 + ".sphereThumbUrl"));
          paramString3.yhq = bs.nullAsNil((String)localMap.get(paramString1 + ".bgColor"));
          paramString3.yhr = bs.nullAsNil((String)localMap.get(paramString1 + ".bgColorAlpha"));
          paramString3.yho = bs.nullAsNil((String)localMap.get(paramString1 + ".sphereImageUrl"));
        }
      }
    }
  }
  
  public final boolean dJF()
  {
    return (this.ygw != null) && (this.ygw.ygH >= 0);
  }
  
  public final boolean dJG()
  {
    return (this.yeM) || (this.yfT);
  }
  
  public final String dJH()
  {
    AppMethodBeat.i(96271);
    String str;
    if (dJN())
    {
      str = this.ygB.yhk;
      AppMethodBeat.o(96271);
      return str;
    }
    if (dJP())
    {
      str = ((l)this.ygC.yhv.get(0)).title;
      AppMethodBeat.o(96271);
      return str;
    }
    AppMethodBeat.o(96271);
    return "";
  }
  
  public final String dJI()
  {
    AppMethodBeat.i(96272);
    String str;
    if (dJN())
    {
      str = this.ygB.yhl;
      AppMethodBeat.o(96272);
      return str;
    }
    if (dJP())
    {
      str = ((l)this.ygC.yhv.get(1)).title;
      AppMethodBeat.o(96272);
      return str;
    }
    AppMethodBeat.o(96272);
    return "";
  }
  
  public final String dJJ()
  {
    AppMethodBeat.i(96273);
    if (dJP())
    {
      String str = this.ygC.yht;
      AppMethodBeat.o(96273);
      return str;
    }
    AppMethodBeat.o(96273);
    return "";
  }
  
  public final boolean dJK()
  {
    return this.ygg == 2;
  }
  
  public final boolean dJL()
  {
    return this.ygg == 1;
  }
  
  public final boolean dJM()
  {
    return this.ygg == 3;
  }
  
  public final boolean dJN()
  {
    return this.ygB != null;
  }
  
  public final boolean dJO()
  {
    AppMethodBeat.i(96274);
    if ((this.ygC != null) && (this.ygC.yhv.size() > 1) && (!TextUtils.isEmpty(((l)this.ygC.yhv.get(0)).id)) && (!TextUtils.isEmpty(((l)this.ygC.yhv.get(1)).id)))
    {
      AppMethodBeat.o(96274);
      return true;
    }
    AppMethodBeat.o(96274);
    return false;
  }
  
  public final boolean dJP()
  {
    AppMethodBeat.i(96275);
    if ((this.ygC != null) && (this.ygC.yhv.size() > 1))
    {
      AppMethodBeat.o(96275);
      return true;
    }
    AppMethodBeat.o(96275);
    return false;
  }
  
  public final String dJQ()
  {
    AppMethodBeat.i(96276);
    String str2 = this.dqf;
    String str1 = str2;
    if (str2.contains("<adCanvasInfoLeft>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "").replaceAll("adCanvasInfoLeft", "adCanvasInfo");
    }
    AppMethodBeat.o(96276);
    return str1;
  }
  
  public final String dJR()
  {
    AppMethodBeat.i(96277);
    String str2 = this.dqf;
    String str1 = str2;
    if (str2.contains("<adCanvasInfoRight>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("adCanvasInfoRight", "adCanvasInfo");
    }
    AppMethodBeat.o(96277);
    return str1;
  }
  
  public final String dJS()
  {
    AppMethodBeat.i(96278);
    String str2 = this.dqf;
    String str1 = str2;
    if (str2.contains("<adTurnCanvasInfo>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adTurnCanvasInfo", "adCanvasInfo");
    }
    AppMethodBeat.o(96278);
    return str1;
  }
  
  public final String dJT()
  {
    AppMethodBeat.i(96279);
    String str = this.dqf;
    if ((this.ygn != null) && (str.contains("<adFullCardGestureCanvasInfo>"))) {}
    for (str = str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adFullCardGestureCanvasInfo", "adCanvasInfo");; str = "")
    {
      AppMethodBeat.o(96279);
      return str;
    }
  }
  
  public final boolean dJU()
  {
    return this.yfP == 2;
  }
  
  public static final class a
  {
    public String desc;
    public String nUY;
    public String ygD;
    public String ygE;
    public int ygF;
    
    public static a r(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(200132);
      String str1 = bs.nullAsNil((String)paramMap.get(paramString + ".bgImage"));
      String str2 = bs.nullAsNil((String)paramMap.get(paramString + ".desc"));
      String str3 = bs.nullAsNil((String)paramMap.get(paramString + ".descIcon"));
      String str4 = bs.nullAsNil((String)paramMap.get(paramString + ".detectSucIcon"));
      int i = bs.aLy((String)paramMap.get(paramString + ".scanGestureType"));
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)) && (i > 0))
      {
        paramMap = new a();
        paramMap.ygD = str1;
        paramMap.desc = str2;
        paramMap.nUY = str3;
        paramMap.ygE = str4;
        paramMap.ygF = i;
        AppMethodBeat.o(200132);
        return paramMap;
      }
      AppMethodBeat.o(200132);
      return null;
    }
  }
  
  public static final class b
  {
    public String hlj;
    public int hlk;
    public String iconUrl;
    public String nVh;
    public String nWf;
    public String pis;
    public String yfc;
    public String ygG;
    public int ygH;
    public String ygI;
    public String ygJ;
    public String ygK;
    public String ygL;
    public String ygM;
    public String ygN;
    public String ygO;
    public String ygP;
    public String ygQ;
    public String ygR;
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
    
    public final e t(Map<String, String> paramMap, String paramString)
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
          localf.url = bs.bG((String)paramMap.get(str2), "");
          localf.ygW = bs.bG((String)paramMap.get(paramString + ".Wording.zh"), "");
          localf.xZb = bs.bG((String)paramMap.get(paramString + ".Wording.en"), "");
          localf.ygX = bs.bG((String)paramMap.get(paramString + ".Wording.tw"), "");
          if (localf.ygW.length() + localf.xZb.length() + localf.ygX.length() > 0) {
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
    public String xZb = "";
    public String ygW = "";
    public String ygX = "";
  }
  
  public static final class g
  {
    public String description;
    public String title;
    public int ygY;
    public int ygZ = 30;
    public int yha;
    public a yhb;
    public String yhc;
    public int yhd;
    public String yhe;
    public int yhf;
    public aq yhg;
    public b.n yhh;
    
    public static final class a
    {
      public int color;
      public long endTime;
      public long startTime;
      public float yhi;
      public String yhj;
    }
  }
  
  public final class h
  {
    public String yhk;
    public String yhl;
    
    public h() {}
  }
  
  public static final class i
  {
    public String description;
    public String title;
    public int ygY;
    public int ygZ = 30;
    public int yha;
    public int yhn;
    public String yho;
    public String yhp;
    public String yhq;
    public String yhr;
  }
  
  public static final class j
  {
    public String appVersion;
    public String cYQ;
    public String dia;
    public String yeD;
    public List<b.m> yhs;
    
    public j()
    {
      AppMethodBeat.i(96264);
      this.yeD = "";
      this.yhs = new ArrayList();
      AppMethodBeat.o(96264);
    }
    
    public final void u(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(96265);
      this.yeD = bs.bG((String)paramMap.get(paramString + ".adxml.adTurnActionLink"), "");
      String str = (String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.appUserName");
      if (!TextUtils.isEmpty(str))
      {
        this.dia = str;
        this.appVersion = ((String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.appVersion"));
        this.cYQ = ((String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.relativePagePath"));
      }
      str = paramString + ".adxml.adTurnInfo.materialInfo";
      int i = 0;
      if (i > 0) {}
      for (paramString = str + i;; paramString = str)
      {
        if ((paramMap.get(paramString + ".displayType") != null) && (((String)paramMap.get(paramString + ".displayType")).length() > 0))
        {
          b.m localm = new b.m();
          localm.title = bs.bG((String)paramMap.get(paramString + ".title"), "");
          localm.desc = bs.bG((String)paramMap.get(paramString + ".desc"), "");
          localm.ygY = bs.aLy((String)paramMap.get(paramString + ".displayType"));
          this.yhs.add(localm);
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
    public String yht;
    public String yhu;
    public ArrayList<b.l> yhv;
    
    public k()
    {
      AppMethodBeat.i(96266);
      this.yht = "";
      this.yhu = "";
      this.yhv = new ArrayList();
      AppMethodBeat.o(96266);
    }
    
    public final String OE(int paramInt)
    {
      AppMethodBeat.i(96267);
      if ((paramInt >= 0) && (paramInt < this.yhv.size()))
      {
        String str = ((b.l)this.yhv.get(paramInt)).yhx;
        AppMethodBeat.o(96267);
        return str;
      }
      AppMethodBeat.o(96267);
      return "";
    }
    
    public final String OF(int paramInt)
    {
      AppMethodBeat.i(96268);
      if ((paramInt >= 0) && (paramInt < this.yhv.size()))
      {
        String str = ((b.l)this.yhv.get(paramInt)).title;
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
    public String pBm = "";
    public String tcG = "";
    public String title = "";
    public String yhw = "";
    public String yhx = "";
    
    public l() {}
  }
  
  public static final class m
  {
    public String desc;
    public String title;
    public int ygY = 0;
  }
  
  public static final class n
  {
    public int yhA;
    public String yhB;
    public int yhC;
    public int yhy;
    public int yhz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.b
 * JD-Core Version:    0.7.0.1
 */
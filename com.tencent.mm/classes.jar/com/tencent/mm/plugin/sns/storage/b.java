package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  public String bUr = "";
  public String nickname;
  public int oAE;
  public String oAF;
  public int oAG = 0;
  public int oAH = 0;
  public String oAI = "";
  public String oAJ = "";
  public String oAK = "";
  public String oAL = "";
  public String oAM = "";
  public int oAN = 0;
  public String oAO = "";
  public String oAP = "";
  public int oAQ = 0;
  public String oAR = "";
  public int oAS = 0;
  public String oAT = "";
  public String oAU = "";
  public String oAV = "";
  public String oAW = "";
  public String oAX = "";
  public String oAY = "";
  public int oAZ;
  public String oAa;
  boolean oAj;
  public boolean oBA;
  public String oBB;
  public String oBC;
  public int oBD;
  public int oBE;
  public String oBF;
  private b.d oBG;
  public b.f oBH;
  public int oBa;
  public int oBb;
  public long oBc;
  public Map<String, String> oBd = new HashMap();
  boolean oBe;
  public int oBf;
  public int oBg;
  public float oBh;
  public float oBi;
  public int oBj;
  public int oBk;
  public int oBl;
  public String oBm;
  public float oBn;
  public float oBo;
  public float oBp;
  public float oBq;
  public int oBr;
  public String oBs;
  public String oBt;
  public String oBu;
  public String oBv;
  public List<String> oBw = new ArrayList();
  public b.e oBx;
  public b.c oBy;
  public b.a oBz;
  
  public b(String paramString)
  {
    if ((!bk.bl(paramString)) && (paramString.trim().startsWith("<RecXml")))
    {
      paramString = aa(paramString, ".RecXml", "RecXml");
      if ((paramString != null) && (!paramString.isEmpty()))
      {
        this.oAZ = bk.ZR((String)paramString.get(".RecXml.$type"));
        this.oBa = bk.ZR((String)paramString.get(".RecXml.$source"));
        this.oBb = bk.ZR((String)paramString.get(".RecXml.$expId"));
        this.oBc = i.Ng((String)paramString.get(".RecXml.$expOriginSnsId"));
      }
      return;
    }
    aa(paramString, "", "adxml");
  }
  
  private Map<String, String> aa(String paramString1, String paramString2, String paramString3)
  {
    int j = 0;
    if ((bk.bl(paramString1)) || (bk.bl(paramString3))) {}
    Map localMap;
    do
    {
      return null;
      this.bUr = paramString1;
      y.i("MicroMsg.ADXml", "feed xml %s, keyPrefix %s, tag %s", new Object[] { paramString1, paramString2, paramString3 });
      localMap = bn.s(paramString1, paramString3);
    } while (localMap == null);
    this.oAE = bk.ZR((String)localMap.get(paramString2 + ".adxml.adType"));
    this.oAF = bk.aM((String)localMap.get(paramString2 + ".adxml.adActionTitle"), "");
    this.oAa = bk.aM((String)localMap.get(paramString2 + ".adxml.adActionLink"), "");
    this.nickname = bk.aM((String)localMap.get(paramString2 + ".adxml.nickname"), "");
    this.oAG = bk.ZR((String)localMap.get(paramString2 + ".adxml.webviewRightBarShow"));
    this.oAH = bk.ZR((String)localMap.get(paramString2 + ".adxml.adActionLinkHidden"));
    this.oAI = bk.aM((String)localMap.get(paramString2 + ".adxml.adActionLinkName"), "");
    this.oAJ = bk.aM((String)localMap.get(paramString2 + ".adxml.adActionLinkIcon"), "");
    this.oAK = bk.aM((String)localMap.get(paramString2 + ".adxml.adActionLinkTitle.zh"), "");
    this.oAM = bk.aM((String)localMap.get(paramString2 + ".adxml.adActionLinkTitle.tw"), "");
    this.oAL = bk.aM((String)localMap.get(paramString2 + ".adxml.adActionLinkTitle.en"), "");
    this.oAO = bk.aM((String)localMap.get(paramString2 + ".adxml.attachShareLinkWording"), "");
    this.oAP = bk.aM((String)localMap.get(paramString2 + ".adxml.attachShareLinkUrl"), "");
    this.oAN = bk.ZR((String)localMap.get(paramString2 + ".adxml.attachShareLinkIsHidden"));
    if ((bk.bl(this.oAO)) || (bk.bl(this.oAP))) {
      this.oAN = 1;
    }
    this.oAT = bk.aM((String)localMap.get(paramString2 + ".adxml.expandOutsideTitle.zh"), "");
    this.oAV = bk.aM((String)localMap.get(paramString2 + ".adxml.expandOutsideTitle.tw"), "");
    this.oAU = bk.aM((String)localMap.get(paramString2 + ".adxml.expandOutsideTitle.en"), "");
    this.oAW = bk.aM((String)localMap.get(paramString2 + ".adxml.expandInsideTitle.zh"), "");
    this.oAY = bk.aM((String)localMap.get(paramString2 + ".adxml.expandInsideTitle.tw"), "");
    this.oAX = bk.aM((String)localMap.get(paramString2 + ".adxml.expandInsideTitle.en"), "");
    this.oAQ = bk.ZR((String)localMap.get(paramString2 + ".adxml.headClickType"));
    this.oAR = bk.aM((String)localMap.get(paramString2 + ".adxml.headClickParam"), "");
    this.oAS = bk.ZR((String)localMap.get(paramString2 + ".adxml.headClickRightBarShow"));
    int i = 0;
    paramString3 = new StringBuilder().append(paramString2).append(".adxml.adArgs.arg");
    label995:
    Object localObject1;
    Object localObject2;
    if (i == 0)
    {
      paramString1 = "";
      paramString3 = paramString1 + ".key";
      localObject1 = (String)localMap.get(paramString3);
      if (localObject1 == null) {
        break label1179;
      }
      localObject2 = new StringBuilder().append(paramString2).append(".adxml.adArgs.arg");
      if (i != 0) {
        break label1170;
      }
    }
    label1170:
    for (paramString1 = "";; paramString1 = Integer.valueOf(i))
    {
      paramString1 = paramString1 + ".value";
      localObject2 = (String)localMap.get(paramString1);
      y.i("MicroMsg.ADXml", "newKey " + paramString3 + " " + (String)localObject1 + " newValue : " + paramString1 + " " + (String)localObject2);
      this.oBd.put(localObject1, localObject2);
      i += 1;
      break;
      paramString1 = Integer.valueOf(i);
      break label995;
    }
    label1179:
    this.oAj = localMap.containsKey(paramString2 + ".adxml.adCanvasInfo");
    boolean bool;
    if (bk.ZR((String)localMap.get(paramString2 + ".adxml.usePreferedInfo")) == 1)
    {
      bool = true;
      this.oBA = bool;
      this.oBB = bk.pm((String)localMap.get(paramString2 + ".adxml.preferNickname"));
      this.oBC = bk.pm((String)localMap.get(paramString2 + ".adxml.preferAvatar"));
      this.oBf = bk.ZR((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.contentDisplayType"));
      this.oBg = bk.ZR((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaDisplayMode"));
      this.oBh = ((float)bk.ZT((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaDisplayWidth")));
      this.oBi = ((float)bk.ZT((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaDisplayHeight")));
      this.oBl = bk.ZR((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.btnDisplayType"));
      this.oBm = bk.aM((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconUrl"), "");
      this.oBj = bk.ZR((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.basicRemWidth"));
      this.oBk = bk.ZR((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.basicRootFontSize"));
      this.oBn = ((float)bk.ZT((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconWidth")));
      this.oBo = ((float)bk.ZT((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconHeight")));
      this.oBp = ((float)bk.ZT((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingRight")));
      this.oBq = ((float)bk.ZT((String)localMap.get(paramString2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingBottom")));
      this.oBr = bk.ZR((String)localMap.get(paramString2 + ".adxml.adContentStyle"));
      this.oBs = bk.aM((String)localMap.get(paramString2 + ".adxml.adCardInfo.title"), "");
      this.oBt = bk.aM((String)localMap.get(paramString2 + ".adxml.adCardInfo.description"), "");
      i = 0;
      label1900:
      paramString3 = new StringBuilder().append(paramString2).append(".adxml.adCardInfo.adRatingCardInfo.tagList.tag");
      if (i != 0) {
        break label2019;
      }
    }
    label2019:
    for (paramString1 = "";; paramString1 = Integer.valueOf(i))
    {
      paramString1 = paramString1;
      if (!localMap.containsKey(paramString1)) {
        break label2028;
      }
      y.i("MicroMsg.ADXml", "card ad tag %s", new Object[] { localMap.get(paramString1) });
      if (!bk.bl((String)localMap.get(paramString1))) {
        this.oBw.add(localMap.get(paramString1));
      }
      i += 1;
      break label1900;
      bool = false;
      break;
    }
    label2028:
    this.oBu = bk.pm((String)localMap.get(paramString2 + ".adxml.adCardInfo.adRatingCardInfo.headTitle"));
    this.oBv = bk.pm((String)localMap.get(paramString2 + ".adxml.adCardInfo.adRatingCardInfo.headUrl"));
    paramString1 = bk.aM((String)localMap.get(paramString2 + ".adxml.adSelectInfo.leftBtnTitle"), "");
    paramString3 = bk.aM((String)localMap.get(paramString2 + ".adxml.adSelectInfo.rightBtnTitle"), "");
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)))
    {
      this.oBG = new b.d(this);
      this.oBG.oBN = paramString1;
      this.oBG.oBO = paramString3;
    }
    paramString1 = bk.aM((String)localMap.get(paramString2 + ".adxml.adVoteInfo.componentUrl"), "");
    if (!TextUtils.isEmpty(paramString1))
    {
      this.oBH = new b.f(this);
      this.oBH.oBR = paramString1;
      paramString3 = paramString2 + ".adxml.adVoteInfo.optionList.option";
      i = j;
      if (i == 0) {
        break label3017;
      }
    }
    label3017:
    for (paramString1 = paramString3 + i;; paramString1 = paramString3)
    {
      if (!TextUtils.isEmpty(bk.aM((String)localMap.get(paramString1 + ".title"), "")))
      {
        localObject1 = new b.g(this);
        ((b.g)localObject1).title = bk.aM((String)localMap.get(paramString1 + ".title"), "");
        ((b.g)localObject1).jxS = bk.aM((String)localMap.get(paramString1 + ".shareTitle"), "");
        ((b.g)localObject1).oBT = bk.aM((String)localMap.get(paramString1 + ".shareDesc"), "");
        ((b.g)localObject1).oBU = bk.aM((String)localMap.get(paramString1 + ".shareThumb"), "");
        ((b.g)localObject1).oBV = bk.aM((String)localMap.get(paramString1 + ".selectedTitle"), "");
        this.oBH.oBS.add(localObject1);
        i += 1;
        break;
      }
      this.oBe = localMap.containsKey(paramString2 + ".adxml.adTurnCanvasInfo");
      this.oBx = new b.e();
      this.oBx.r(localMap, paramString2);
      this.oBz = new b.a().q(localMap, paramString2);
      if (this.oBr == 3)
      {
        this.oBy = new b.c();
        paramString1 = paramString2 + ".adxml.adFullCardInfo";
        paramString3 = this.oBy;
        paramString3.oBK = bk.ZR((String)localMap.get(paramString1 + ".displayType"));
        paramString3.title = bk.pm((String)localMap.get(paramString1 + ".title"));
        paramString3.description = bk.pm((String)localMap.get(paramString1 + ".description"));
        paramString3.oBL = bk.getInt((String)localMap.get(paramString1 + ".markMaxAlpha"), 30);
        paramString3.oBM = bk.ZR((String)localMap.get(paramString1 + ".titlePosition"));
      }
      this.oBD = bk.ZR((String)localMap.get(paramString2 + ".adxml.compatible.clientVersion.androidMin"));
      this.oBE = bk.ZR((String)localMap.get(paramString2 + ".adxml.compatible.clientVersion.androidMax"));
      this.oBF = bk.pm((String)localMap.get(paramString2 + ".adxml.compatible.jumpUrl"));
      return localMap;
    }
  }
  
  public final boolean bEE()
  {
    return (this.oAj) || (this.oBe);
  }
  
  public final String bEF()
  {
    if (bEL()) {
      return this.oBG.oBN;
    }
    if (bEM()) {
      return ((b.g)this.oBH.oBS.get(0)).title;
    }
    return "";
  }
  
  public final String bEG()
  {
    if (bEL()) {
      return this.oBG.oBO;
    }
    if (bEM()) {
      return ((b.g)this.oBH.oBS.get(1)).title;
    }
    return "";
  }
  
  public final String bEH()
  {
    if (bEM()) {
      return this.oBH.oBR;
    }
    return "";
  }
  
  public final boolean bEI()
  {
    return this.oBr == 2;
  }
  
  public final boolean bEJ()
  {
    return this.oBr == 1;
  }
  
  public final boolean bEK()
  {
    return this.oBr == 3;
  }
  
  public final boolean bEL()
  {
    return this.oBG != null;
  }
  
  public final boolean bEM()
  {
    return (this.oBH != null) && (this.oBH.oBS.size() > 1);
  }
  
  public final String bEN()
  {
    String str2 = this.bUr;
    String str1 = str2;
    if (str2.contains("<adCanvasInfoLeft>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "").replaceAll("adCanvasInfoLeft", "adCanvasInfo");
    }
    return str1;
  }
  
  public final String bEO()
  {
    String str2 = this.bUr;
    String str1 = str2;
    if (str2.contains("<adCanvasInfoRight>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("adCanvasInfoRight", "adCanvasInfo");
    }
    return str1;
  }
  
  public final String bEP()
  {
    String str2 = this.bUr;
    String str1 = str2;
    if (str2.contains("<adTurnCanvasInfo>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adTurnCanvasInfo", "adCanvasInfo");
    }
    return str1;
  }
  
  public final boolean bEQ()
  {
    return this.oBa == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.sns.storage;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.a.b;
import com.tencent.mm.plugin.sns.ad.a.d;
import com.tencent.mm.plugin.sns.ad.a.f;
import com.tencent.mm.plugin.sns.ad.a.g;
import com.tencent.mm.plugin.sns.ad.a.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Keep
public class ADXml
{
  public static final int AD_CONTENT_STYLE_CARD = 1;
  public static final int AD_CONTENT_STYLE_FINDER_TOPIC_CARD = 5;
  public static final int AD_CONTENT_STYLE_FULL_CARD = 3;
  public static final int AD_CONTENT_STYLE_LINK = 2;
  public static final int AD_CONTENT_STYLE_SPHERE_CARD = 4;
  public static final int AD_FULL_CARD_MEDIA_SIZE_W1_H1 = 1;
  public static final int AD_FULL_CARD_MEDIA_SIZE_W4_H3 = 0;
  public static final int AD_FULL_CARD_TITLE_LEFT_BOTTOM = 1;
  public static final int AD_FULL_CARD_TITLE_LEFT_TOP = 0;
  public static final int AD_MEDIA_DISPLAY_CENTER = 1;
  public static final int AD_MEDIA_DISPLAY_LEFT = 0;
  public static final int AD_MEDIA_DISPLAY_RIGHT = 2;
  public static final int AD_TURN_CARD_ANIMATION_TIME = 374;
  public static final String PRE_KEY_AD_ARGS = ".adxml.adArgs.arg";
  public static final String PRE_KEY_CARD_TAG_LIST = ".adxml.adCardInfo.adRatingCardInfo.tagList.tag";
  public static final String SUFF_KEY_CARD_TAG_BACKGROUND_DARK_MODE_COLOR = ".$tag_dark_bg_color";
  public static final String SUFF_KEY_CARD_TAG_BACKGROUND_LIGHT_MODE_COLOR = ".$tag_light_bg_color";
  public static final String SUFF_KEY_CARD_TAG_CONTENT_DARK_MODE_COLOR = ".$tag_dark_name_color";
  public static final String SUFF_KEY_CARD_TAG_CONTENT_LIGHT_MODE_COLOR = ".$tag_light_name_color";
  public static final String SUFF_KEY_CARD_TAG_ICON_DARK_MODE_URL = ".$dark_mode_url";
  public static final String SUFF_KEY_CARD_TAG_ICON_LIGHT_MODE_URL = ".$light_mode_url";
  public static final String TAG = "MicroMsg.ADXml";
  public String adActionLink;
  public int adActionLinkHidden;
  public String adActionLinkIcon;
  public String adActionLinkName;
  public String adActionLinkTitle_cn;
  public String adActionLinkTitle_en;
  public String adActionLinkTitle_tw;
  public String adActionTitle;
  public Map<String, String> adArgs;
  public com.tencent.mm.plugin.sns.ad.a.a adAvatarFinderTopicInfo;
  public int adBasicRemWidth;
  public int adBasicRootFontSize;
  public int adBtnDisplayType;
  public String adCard3dHeadTitle;
  public String adCard3dHeadUrl;
  @Keep
  public AdCardActionBtnInfo adCardActionBtnInfo;
  public String adCardDesc;
  public c adCardTagInfo;
  public String adCardTitle;
  public int adContentDisplayType;
  public int adContentStyle;
  public b adDynamicUpdateInfo;
  public String adExtInfo;
  public e adFeedbackInfo;
  public a adFinderInfo;
  public com.tencent.mm.plugin.sns.ad.a.c adFinderLiveInfo;
  public d adFinderTopicInfo;
  public ADXml.n adFloatWebViewInfo;
  public g adFullCardInfo;
  public f adHeadFinderProfile;
  public g adLiveInfo;
  public float adMediaDisplayHeight;
  public int adMediaDisplayMode;
  public float adMediaDisplayWidth;
  public float adMediaIconHeight;
  public float adMediaIconPaddingBottom;
  public float adMediaIconPaddingRight;
  public String adMediaIconUrl;
  public float adMediaIconWidth;
  public h adPromotionInfo;
  public b adScanJumpInfo;
  private h adSelectInfo;
  public i adSphereCardInfo;
  public j adTurnInfo;
  public k adTwistInfo;
  public int adType;
  public boolean adVideoContinuePlay;
  public l adVoteInfo;
  public int addPlayIconOnCover;
  public Intent appMarketIntent;
  public int attachShareLinkIsHidden;
  public String attachShareLinkUrl;
  public String attachShareLinkWording;
  boolean bLandingPagesAd;
  boolean bTurnLandingPagesAd;
  public int clientMaxVersion;
  public int clientMinVersion;
  public String compatibleUrl;
  public String expandInsideTitle_cn;
  public String expandInsideTitle_en;
  public String expandInsideTitle_tw;
  public String expandOutsideTitle_cn;
  public String expandOutsideTitle_en;
  public String expandOutsideTitle_tw;
  public String firstDownloadApkPkgName;
  public boolean forbiddenCustomAnimation;
  public String headClickParam;
  public int headClickRightBarShow;
  public int headClickType;
  public int isValidJumpCanvas;
  public int newFeedbackPanel;
  @Keep
  public String nickname;
  public long originSnsId;
  public String preferAvatar;
  public String preferNickName;
  public boolean preloadWeAppPkg;
  public int recExpId;
  public int recSrc;
  public int recType;
  public int toAdMarket;
  public boolean usePreferedInfo;
  public int verticalVideoDisplayType;
  public int videoPlayInStreamingMode;
  public q weAppInfo;
  public int webrightBar;
  public String xml;
  
  public ADXml(String paramString)
  {
    AppMethodBeat.i(96269);
    this.xml = "";
    this.webrightBar = 0;
    this.adActionLinkHidden = 0;
    this.adActionLinkName = "";
    this.adActionLinkIcon = "";
    this.adActionLinkTitle_cn = "";
    this.adActionLinkTitle_en = "";
    this.adActionLinkTitle_tw = "";
    this.attachShareLinkIsHidden = 0;
    this.attachShareLinkWording = "";
    this.attachShareLinkUrl = "";
    this.headClickType = 0;
    this.headClickParam = "";
    this.headClickRightBarShow = 0;
    this.expandOutsideTitle_cn = "";
    this.expandOutsideTitle_en = "";
    this.expandOutsideTitle_tw = "";
    this.expandInsideTitle_cn = "";
    this.expandInsideTitle_en = "";
    this.expandInsideTitle_tw = "";
    this.adArgs = new HashMap();
    this.adVideoContinuePlay = false;
    this.toAdMarket = 0;
    this.newFeedbackPanel = 0;
    this.videoPlayInStreamingMode = 0;
    this.isValidJumpCanvas = -1;
    this.verticalVideoDisplayType = 0;
    this.forbiddenCustomAnimation = false;
    this.preloadWeAppPkg = false;
    feed(paramString);
    AppMethodBeat.o(96269);
  }
  
  private void feed(String paramString)
  {
    AppMethodBeat.i(202822);
    if ((!Util.isNullOrNil(paramString)) && (paramString.trim().startsWith("<RecXml")))
    {
      feedRecXml(paramString);
      AppMethodBeat.o(202822);
      return;
    }
    feedAdXml(paramString);
    AppMethodBeat.o(202822);
  }
  
  private void feedAdXml(String paramString)
  {
    AppMethodBeat.i(202824);
    feedXml(paramString, "", "adxml");
    AppMethodBeat.o(202824);
  }
  
  private void feedRecXml(String paramString)
  {
    AppMethodBeat.i(202823);
    paramString = feedXml(paramString, ".RecXml", "RecXml");
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      this.recType = Util.safeParseInt((String)paramString.get(".RecXml.$type"));
      this.recSrc = Util.safeParseInt((String)paramString.get(".RecXml.$source"));
      this.recExpId = Util.safeParseInt((String)paramString.get(".RecXml.$expId"));
      this.originSnsId = r.aOw((String)paramString.get(".RecXml.$expOriginSnsId"));
    }
    AppMethodBeat.o(202823);
  }
  
  private Map<String, String> feedXml(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96270);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString3)))
    {
      AppMethodBeat.o(96270);
      return null;
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    this.xml = paramString1;
    Log.i("MicroMsg.ADXml", "feed xml %s, keyPrefix %s, tag %s", new Object[] { paramString1, str, paramString3 });
    paramString3 = XmlParser.parseXml(paramString1, paramString3, null);
    if (paramString3 == null)
    {
      AppMethodBeat.o(96270);
      return null;
    }
    this.adType = Util.safeParseInt((String)paramString3.get(str + ".adxml.adType"));
    this.adActionTitle = Util.nullAs((String)paramString3.get(str + ".adxml.adActionTitle"), "");
    this.adActionLink = Util.nullAs((String)paramString3.get(str + ".adxml.adActionLink"), "");
    this.nickname = Util.nullAs((String)paramString3.get(str + ".adxml.nickname"), "");
    this.webrightBar = Util.safeParseInt((String)paramString3.get(str + ".adxml.webviewRightBarShow"));
    this.adActionLinkHidden = Util.safeParseInt((String)paramString3.get(str + ".adxml.adActionLinkHidden"));
    this.adActionLinkName = Util.nullAs((String)paramString3.get(str + ".adxml.adActionLinkName"), "");
    this.adActionLinkIcon = Util.nullAs((String)paramString3.get(str + ".adxml.adActionLinkIcon"), "");
    this.adActionLinkTitle_cn = Util.nullAs((String)paramString3.get(str + ".adxml.adActionLinkTitle.zh"), "");
    this.adActionLinkTitle_tw = Util.nullAs((String)paramString3.get(str + ".adxml.adActionLinkTitle.tw"), "");
    this.adActionLinkTitle_en = Util.nullAs((String)paramString3.get(str + ".adxml.adActionLinkTitle.en"), "");
    this.attachShareLinkWording = Util.nullAs((String)paramString3.get(str + ".adxml.attachShareLinkWording"), "");
    this.attachShareLinkUrl = Util.nullAs((String)paramString3.get(str + ".adxml.attachShareLinkUrl"), "");
    this.attachShareLinkIsHidden = Util.safeParseInt((String)paramString3.get(str + ".adxml.attachShareLinkIsHidden"));
    if ((Util.isNullOrNil(this.attachShareLinkWording)) || (Util.isNullOrNil(this.attachShareLinkUrl))) {
      this.attachShareLinkIsHidden = 1;
    }
    this.expandOutsideTitle_cn = Util.nullAs((String)paramString3.get(str + ".adxml.expandOutsideTitle.zh"), "");
    this.expandOutsideTitle_tw = Util.nullAs((String)paramString3.get(str + ".adxml.expandOutsideTitle.tw"), "");
    this.expandOutsideTitle_en = Util.nullAs((String)paramString3.get(str + ".adxml.expandOutsideTitle.en"), "");
    this.expandInsideTitle_cn = Util.nullAs((String)paramString3.get(str + ".adxml.expandInsideTitle.zh"), "");
    this.expandInsideTitle_tw = Util.nullAs((String)paramString3.get(str + ".adxml.expandInsideTitle.tw"), "");
    this.expandInsideTitle_en = Util.nullAs((String)paramString3.get(str + ".adxml.expandInsideTitle.en"), "");
    this.headClickType = Util.safeParseInt((String)paramString3.get(str + ".adxml.headClickType"));
    this.headClickParam = Util.nullAs((String)paramString3.get(str + ".adxml.headClickParam"), "");
    this.headClickRightBarShow = Util.safeParseInt((String)paramString3.get(str + ".adxml.headClickRightBarShow"));
    this.toAdMarket = Util.safeParseInt((String)paramString3.get(str + ".adxml.toAdMarket"));
    this.newFeedbackPanel = Util.safeParseInt((String)paramString3.get(str + ".adxml.newFeedback"));
    this.videoPlayInStreamingMode = Util.safeParseInt((String)paramString3.get(str + ".adxml.videoPlayInStreamingMode"));
    int i = 0;
    paramString2 = new StringBuilder().append(str).append(".adxml.adArgs.arg");
    label1138:
    Object localObject1;
    Object localObject2;
    if (i == 0)
    {
      paramString1 = "";
      paramString2 = paramString1 + ".key";
      localObject1 = (String)paramString3.get(paramString2);
      if (localObject1 == null) {
        break label1320;
      }
      localObject2 = new StringBuilder().append(str).append(".adxml.adArgs.arg");
      if (i != 0) {
        break label1311;
      }
    }
    label1311:
    for (paramString1 = "";; paramString1 = Integer.valueOf(i))
    {
      paramString1 = paramString1 + ".value";
      localObject2 = (String)paramString3.get(paramString1);
      Log.i("MicroMsg.ADXml", "newKey " + paramString2 + " " + (String)localObject1 + " newValue : " + paramString1 + " " + (String)localObject2);
      this.adArgs.put(localObject1, localObject2);
      i += 1;
      break;
      paramString1 = Integer.valueOf(i);
      break label1138;
    }
    label1320:
    this.bLandingPagesAd = paramString3.containsKey(str + ".adxml.adCanvasInfo");
    boolean bool;
    if (Util.safeParseInt((String)paramString3.get(str + ".adxml.usePreferedInfo")) == 1)
    {
      bool = true;
      this.usePreferedInfo = bool;
      this.preferNickName = Util.nullAsNil((String)paramString3.get(str + ".adxml.preferNickname"));
      this.preferAvatar = Util.nullAsNil((String)paramString3.get(str + ".adxml.preferAvatar"));
      this.adContentDisplayType = Util.safeParseInt((String)paramString3.get(str + ".adxml.adFeedDisplayInfo.contentDisplayType"));
      this.adMediaDisplayMode = Util.safeParseInt((String)paramString3.get(str + ".adxml.adFeedDisplayInfo.mediaDisplayMode"));
      this.adMediaDisplayWidth = ((float)Util.safeParseDouble((String)paramString3.get(str + ".adxml.adFeedDisplayInfo.mediaDisplayWidth")));
      this.adMediaDisplayHeight = ((float)Util.safeParseDouble((String)paramString3.get(str + ".adxml.adFeedDisplayInfo.mediaDisplayHeight")));
      this.adBtnDisplayType = Util.safeParseInt((String)paramString3.get(str + ".adxml.adFeedDisplayInfo.btnDisplayType"));
      this.adMediaIconUrl = Util.nullAs((String)paramString3.get(str + ".adxml.adFeedDisplayInfo.mediaIconUrl"), "");
      this.adBasicRemWidth = Util.safeParseInt((String)paramString3.get(str + ".adxml.adFeedDisplayInfo.basicRemWidth"));
      this.adBasicRootFontSize = Util.safeParseInt((String)paramString3.get(str + ".adxml.adFeedDisplayInfo.basicRootFontSize"));
      this.adMediaIconWidth = ((float)Util.safeParseDouble((String)paramString3.get(str + ".adxml.adFeedDisplayInfo.mediaIconWidth")));
      this.adMediaIconHeight = ((float)Util.safeParseDouble((String)paramString3.get(str + ".adxml.adFeedDisplayInfo.mediaIconHeight")));
      this.adMediaIconPaddingRight = ((float)Util.safeParseDouble((String)paramString3.get(str + ".adxml.adFeedDisplayInfo.mediaIconPaddingRight")));
      this.adMediaIconPaddingBottom = ((float)Util.safeParseDouble((String)paramString3.get(str + ".adxml.adFeedDisplayInfo.mediaIconPaddingBottom")));
      this.adContentStyle = Util.safeParseInt((String)paramString3.get(str + ".adxml.adContentStyle"));
      this.adCardTitle = Util.nullAs((String)paramString3.get(str + ".adxml.adCardInfo.title"), "");
      this.adCardDesc = Util.nullAs((String)paramString3.get(str + ".adxml.adCardInfo.description"), "");
      this.adCardTagInfo = new c().G(paramString3, str);
      this.adCard3dHeadTitle = Util.nullAsNil((String)paramString3.get(str + ".adxml.adCardInfo.adRatingCardInfo.headTitle"));
      this.adCard3dHeadUrl = Util.nullAsNil((String)paramString3.get(str + ".adxml.adCardInfo.adRatingCardInfo.headUrl"));
      paramString1 = Util.nullAs((String)paramString3.get(str + ".adxml.adSelectInfo.leftBtnTitle"), "");
      paramString2 = Util.nullAs((String)paramString3.get(str + ".adxml.adSelectInfo.rightBtnTitle"), "");
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        this.adSelectInfo = new h();
        this.adSelectInfo.Dse = paramString1;
        this.adSelectInfo.DWI = paramString2;
      }
      paramString1 = Util.nullAs((String)paramString3.get(str + ".adxml.adVoteInfo.componentUrl"), "");
      if (TextUtils.isEmpty(paramString1)) {
        break label2710;
      }
      this.adVoteInfo = new l();
      this.adVoteInfo.DWX = paramString1;
      this.adVoteInfo.DWY = Util.nullAs((String)paramString3.get(str + ".adxml.adVoteInfo.voteLabel"), "");
      paramString2 = str + ".adxml.adVoteInfo.optionList.option";
      i = 0;
      label2373:
      if (i == 0) {
        break label5853;
      }
    }
    label2710:
    label4442:
    label4827:
    label5853:
    for (paramString1 = paramString2 + i;; paramString1 = paramString2)
    {
      if (!TextUtils.isEmpty(Util.nullAs((String)paramString3.get(paramString1 + ".title"), "")))
      {
        localObject1 = new m();
        ((m)localObject1).title = Util.nullAs((String)paramString3.get(paramString1 + ".title"), "");
        ((m)localObject1).msN = Util.nullAs((String)paramString3.get(paramString1 + ".shareTitle"), "");
        ((m)localObject1).xDQ = Util.nullAs((String)paramString3.get(paramString1 + ".shareDesc"), "");
        ((m)localObject1).DXa = Util.nullAs((String)paramString3.get(paramString1 + ".shareThumb"), "");
        ((m)localObject1).DXb = Util.nullAs((String)paramString3.get(paramString1 + ".selectedTitle"), "");
        ((m)localObject1).id = Util.nullAs((String)paramString3.get(paramString1 + ".id"), "");
        this.adVoteInfo.DWZ.add(localObject1);
        i += 1;
        break label2373;
        bool = false;
        break;
      }
      this.bTurnLandingPagesAd = paramString3.containsKey(str + ".adxml.adTurnCanvasInfo");
      this.adTurnInfo = new j();
      this.adTurnInfo.I(paramString3, str);
      this.adFeedbackInfo = new e().H(paramString3, str);
      if (this.adContentStyle == 3)
      {
        this.adFullCardInfo = new g();
        paramString2 = str + ".adxml.adFullCardInfo";
        paramString1 = this.adFullCardInfo;
        paramString1.DWw = Util.safeParseInt((String)paramString3.get(paramString2 + ".displayType"));
        paramString1.title = Util.nullAsNil((String)paramString3.get(paramString2 + ".title"));
        paramString1.description = Util.nullAsNil((String)paramString3.get(paramString2 + ".description"));
        paramString1.DWx = Util.getInt((String)paramString3.get(paramString2 + ".markMaxAlpha"), 30);
        paramString1.DWy = Util.safeParseInt((String)paramString3.get(paramString2 + ".titlePosition"));
        paramString1.DWA = Util.nullAsNil((String)paramString3.get(paramString2 + ".maskImg"));
        paramString1.DWB = Util.safeParseInt((String)paramString3.get(paramString2 + ".maskImgDisappearTime"));
        paramString1.DWC = Util.nullAsNil((String)paramString3.get(paramString2 + ".coverImg"));
        paramString1.DWD = Util.safeParseInt((String)paramString3.get(paramString2 + ".coverImgAppearTime"));
        if (!Util.isNullOrNil((String)paramString3.get(paramString2 + ".adGestureInfo.points")))
        {
          paramString1.DWz = new ADXml.g.a();
          paramString1.DWz.color = -1;
          paramString1.DWz.startTime = Util.safeParseInt((String)paramString3.get(paramString2 + ".adGestureInfo.startTime"));
          paramString1.DWz.endTime = Util.safeParseInt((String)paramString3.get(paramString2 + ".adGestureInfo.endTime"));
          paramString1.DWz.DWG = Util.safeParseFloat((String)paramString3.get(paramString2 + ".adGestureInfo.distance"));
          paramString1.DWz.color = Color.parseColor(Util.nullAsNil((String)paramString3.get(paramString2 + ".adGestureInfo.color")));
          paramString1.DWz.DWH = Util.nullAsNil((String)paramString3.get(paramString2 + ".adGestureInfo.points"));
        }
        localObject1 = paramString2 + ".endCoverInfo";
        if (paramString3.containsKey(localObject1))
        {
          paramString1.DWE = new aw();
          paramString1.DWE.title = Util.nullAsNil((String)paramString3.get((String)localObject1 + ".title"));
          paramString1.DWE.desc = Util.nullAsNil((String)paramString3.get((String)localObject1 + ".description"));
          paramString1.DWE.EwS = Util.nullAsNil((String)paramString3.get((String)localObject1 + ".actionTitle"));
          paramString1.DWE.coverImgUrl = Util.nullAsNil((String)paramString3.get((String)localObject1 + ".ambientImageUrl"));
          paramString1.DWE.EwR = Util.nullAsNil((String)paramString3.get((String)localObject1 + ".titleImageUrl"));
          paramString1.DWE.duration = Util.safeParseInt((String)paramString3.get((String)localObject1 + ".endCoverEndTime"));
        }
        paramString2 = paramString2 + ".adLongPressGestureInfo";
        if (paramString3.containsKey(paramString2))
        {
          paramString1.DWF = new p();
          paramString1.DWF.DXc = Util.safeParseInt((String)paramString3.get(paramString2 + ".pressStartTime"));
          paramString1.DWF.DXd = Util.safeParseInt((String)paramString3.get(paramString2 + ".pressEndTime"));
          paramString1.DWF.DXe = Util.safeParseInt((String)paramString3.get(paramString2 + ".pressDuration"));
          paramString1.DWF.DXf = Util.nullAsNil((String)paramString3.get(paramString2 + ".spriteImageUrl"));
          paramString1.DWF.DXg = Util.safeParseInt((String)paramString3.get(paramString2 + ".spriteType"));
        }
        this.clientMinVersion = Util.safeParseInt((String)paramString3.get(str + ".adxml.compatible.clientVersion.androidMin"));
        this.clientMaxVersion = Util.safeParseInt((String)paramString3.get(str + ".adxml.compatible.clientVersion.androidMax"));
        this.compatibleUrl = Util.nullAsNil((String)paramString3.get(str + ".adxml.compatible.jumpUrl"));
        paramString1 = str + ".adxml.adCardInfo.adCardButton";
        if (paramString3.containsKey(paramString1))
        {
          this.adCardActionBtnInfo = new AdCardActionBtnInfo();
          this.adCardActionBtnInfo.parse(paramString3, paramString1);
          if (!TextUtils.isEmpty(this.adCardActionBtnInfo.downloadApkPkgName))
          {
            this.firstDownloadApkPkgName = this.adCardActionBtnInfo.downloadApkPkgName;
            Log.i("MicroMsg.ADXml", "findDownloadApkPkgName, adCardActionBtnInfo.pkg=" + this.adCardActionBtnInfo.downloadApkPkgName);
          }
        }
        if (TextUtils.isEmpty(this.firstDownloadApkPkgName)) {
          findDownloadApkPkgName(paramString3);
        }
        this.adExtInfo = i.aNZ((String)paramString3.get(str + ".adxml.adExtInfo"));
      }
      try
      {
        paramString1 = com.tencent.mm.plugin.sns.device.appstore.a.b(MMApplicationContext.getContext(), paramString3);
        if (paramString1 != null) {
          this.appMarketIntent = paramString1.eZA();
        }
      }
      catch (Throwable paramString1)
      {
        label4213:
        break label4213;
      }
      this.adScanJumpInfo = b.F(paramString3, str + ".adxml.adScanInfo");
      this.adFloatWebViewInfo = ADXml.n.K(paramString3, str + ".adxml.adCanvasInfo.globalComponentItems.componentItem");
      paramString1 = str + ".adxml.adFinderInfo";
      paramString2 = Util.nullAsNil((String)paramString3.get(paramString1 + ".objectNonceId"));
      localObject1 = Util.nullAsNil((String)paramString3.get(paramString1 + ".finderUsername"));
      localObject2 = Util.nullAsNil((String)paramString3.get(paramString1 + ".exportId"));
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        paramString1 = new a();
        paramString1.objectNonceId = paramString2;
        paramString1.finderUsername = ((String)localObject1);
        paramString1.DrX = ((String)localObject2);
        this.adFinderInfo = paramString1;
        this.addPlayIconOnCover = Util.safeParseInt((String)paramString3.get(str + ".adxml.addPlayIconOnCover"));
        this.adTwistInfo = k.J(paramString3, str + ".adxml.adTwistInfo");
        this.verticalVideoDisplayType = Util.safeParseInt((String)paramString3.get(str + ".adxml.verticalVideoDisplayType"));
        paramString1 = str + ".adxml.headWeAppInfo";
        paramString2 = Util.nullAsNil((String)paramString3.get(paramString1 + ".appUserName"));
        localObject1 = Util.nullAsNil((String)paramString3.get(paramString1 + ".relativePagePath"));
        localObject2 = Util.nullAsNil((String)paramString3.get(paramString1 + ".appVersion"));
        i = Util.safeParseInt((String)paramString3.get(paramString1 + ".miniProgramType"));
        if (TextUtils.isEmpty(paramString2)) {
          break label5522;
        }
        paramString1 = new q();
        paramString1.appUserName = paramString2;
        paramString1.dCx = ((String)localObject1);
        paramString1.appVersion = ((String)localObject2);
        paramString1.weAppType = i;
        this.weAppInfo = paramString1;
        if (Util.safeParseInt((String)paramString3.get(str + ".adxml.forbiddenCustomAnimation")) != 1) {
          break label5527;
        }
        bool = true;
        this.forbiddenCustomAnimation = bool;
        paramString2 = str + ".adxml.adCardInfo.promotionInfo";
        if (!com.tencent.mm.plugin.sns.ad.i.c.isEmpty(paramString3)) {
          break label5533;
        }
        paramString1 = null;
        this.adPromotionInfo = paramString1;
        this.adLiveInfo = g.B(paramString3, str + ".adxml.adLiveInfo");
        this.adFinderLiveInfo = com.tencent.mm.plugin.sns.ad.a.c.v(paramString3, str + ".adxml.adFinderLiveInfo");
        this.adHeadFinderProfile = f.A(paramString3, str + ".adxml.headFinderProfile");
        this.adFinderTopicInfo = d.w(paramString3, str + ".adxml.adFinderTopicInfo");
        this.adAvatarFinderTopicInfo = com.tencent.mm.plugin.sns.ad.a.a.s(paramString3, str + ".adxml.headFinderTopicInfo");
        if (Util.safeParseInt((String)paramString3.get(str + ".adxml.preloadWeAppPkg")) != 1) {
          break label5837;
        }
        bool = true;
        this.preloadWeAppPkg = bool;
        if (Util.safeParseInt((String)paramString3.get(str + ".adxml.adVideoContinuePlay")) != 1) {
          break label5843;
        }
      }
      for (bool = true;; bool = false)
      {
        this.adVideoContinuePlay = bool;
        this.adDynamicUpdateInfo = b.t(paramString3, str + ".adxml.adDynamicUpdateInfo");
        AppMethodBeat.o(96270);
        return paramString3;
        if (this.adContentStyle != 4) {
          break;
        }
        this.adSphereCardInfo = new i();
        paramString1 = str + ".adxml.adSphereCardInfo";
        paramString2 = this.adSphereCardInfo;
        paramString2.DWw = Util.safeParseInt((String)paramString3.get(paramString1 + ".displayType"));
        paramString2.title = Util.nullAsNil((String)paramString3.get(paramString1 + ".title"));
        paramString2.description = Util.nullAsNil((String)paramString3.get(paramString1 + ".description"));
        paramString2.DWx = Util.getInt((String)paramString3.get(paramString1 + ".markMaxAlpha"), 30);
        paramString2.DWy = Util.safeParseInt((String)paramString3.get(paramString1 + ".titlePosition"));
        paramString2.DWK = Util.safeParseInt((String)paramString3.get(paramString1 + ".gestureDelayTime"));
        paramString2.DWM = Util.nullAsNil((String)paramString3.get(paramString1 + ".sphereThumbUrl"));
        paramString2.DWN = Util.nullAsNil((String)paramString3.get(paramString1 + ".bgColor"));
        paramString2.DWO = Util.nullAsNil((String)paramString3.get(paramString1 + ".bgColorAlpha"));
        paramString2.DWL = Util.nullAsNil((String)paramString3.get(paramString1 + ".sphereImageUrl"));
        break;
        paramString1 = null;
        break label4442;
        paramString1 = null;
        break label4745;
        bool = false;
        break label4790;
        paramString1 = (String)paramString3.get(paramString2 + ".endTime");
        long l = Util.safeParseLong(paramString1);
        if ((TextUtils.isEmpty(paramString1)) || (l == 0L))
        {
          paramString1 = null;
          break label4827;
        }
        paramString1 = new h();
        paramString1.endTime = (l * 1000L);
        paramString1.startTime = (Util.safeParseLong((String)paramString3.get(paramString2 + ".startTime")) * 1000L);
        paramString1.lco = Util.nullAs((String)paramString3.get(paramString2 + ".barBgColor"), "");
        paramString1.Dsc = Util.nullAs((String)paramString3.get(paramString2 + ".barBgAlpha"), "");
        paramString1.Dsd = Util.safeParseInt((String)paramString3.get(paramString2 + ".leftTitleType"));
        paramString1.Dse = Util.nullAs((String)paramString3.get(paramString2 + ".leftTitle"), "");
        paramString1.Dsf = Util.nullAs((String)paramString3.get(paramString2 + ".rightTitle"), "");
        break label4827;
        bool = false;
        break label5017;
      }
    }
  }
  
  public static String getGestureCanvasInfo(String paramString)
  {
    AppMethodBeat.i(202826);
    if (paramString.contains("<adFullCardGestureCanvasInfo>")) {}
    for (paramString = paramString.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adFullCardGestureCanvasInfo", "adCanvasInfo");; paramString = "")
    {
      AppMethodBeat.o(202826);
      return paramString;
    }
  }
  
  public void findDownloadApkPkgName(Map<String, String> paramMap)
  {
    AppMethodBeat.i(202827);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(202827);
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
          this.firstDownloadApkPkgName = str2;
          Log.i("MicroMsg.ADXml", "findDownloadApkPkgName, key=" + str1 + ", pkg=" + str2);
          AppMethodBeat.o(202827);
          return;
        }
      }
    }
    AppMethodBeat.o(202827);
  }
  
  public String getAdVoteComponentUrl()
  {
    AppMethodBeat.i(96273);
    if (hasVoteInfo())
    {
      String str = this.adVoteInfo.DWX;
      AppMethodBeat.o(96273);
      return str;
    }
    AppMethodBeat.o(96273);
    return "";
  }
  
  public String getCardSelectLeftTitle()
  {
    AppMethodBeat.i(96271);
    String str;
    if (hasSelectInfo())
    {
      str = this.adSelectInfo.Dse;
      AppMethodBeat.o(96271);
      return str;
    }
    if (hasVoteInfo())
    {
      str = ((m)this.adVoteInfo.DWZ.get(0)).title;
      AppMethodBeat.o(96271);
      return str;
    }
    AppMethodBeat.o(96271);
    return "";
  }
  
  public String getCardSelectRightTitle()
  {
    AppMethodBeat.i(96272);
    String str;
    if (hasSelectInfo())
    {
      str = this.adSelectInfo.DWI;
      AppMethodBeat.o(96272);
      return str;
    }
    if (hasVoteInfo())
    {
      str = ((m)this.adVoteInfo.DWZ.get(1)).title;
      AppMethodBeat.o(96272);
      return str;
    }
    AppMethodBeat.o(96272);
    return "";
  }
  
  public String getGestureCanvasInfo()
  {
    AppMethodBeat.i(96279);
    String str = this.xml;
    if ((this.adFullCardInfo != null) && (str.contains("<adFullCardGestureCanvasInfo>"))) {}
    for (str = str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adFullCardGestureCanvasInfo", "adCanvasInfo");; str = "")
    {
      AppMethodBeat.o(96279);
      return str;
    }
  }
  
  public String getLeftCanvasInfo()
  {
    AppMethodBeat.i(96276);
    String str2 = this.xml;
    String str1 = str2;
    if (str2.contains("<adCanvasInfoLeft>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "").replaceAll("adCanvasInfoLeft", "adCanvasInfo");
    }
    AppMethodBeat.o(96276);
    return str1;
  }
  
  public String getRightCanvasInfo()
  {
    AppMethodBeat.i(96277);
    String str2 = this.xml;
    String str1 = str2;
    if (str2.contains("<adCanvasInfoRight>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("adCanvasInfoRight", "adCanvasInfo");
    }
    AppMethodBeat.o(96277);
    return str1;
  }
  
  public String getTurnCanvasInfo()
  {
    AppMethodBeat.i(96278);
    String str2 = this.xml;
    String str1 = str2;
    if (str2.contains("<adTurnCanvasInfo>")) {
      str1 = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adTurnCanvasInfo", "adCanvasInfo");
    }
    AppMethodBeat.o(96278);
    return str1;
  }
  
  public boolean hasActionBtn()
  {
    return (this.adCardActionBtnInfo != null) && (this.adCardActionBtnInfo.clickActionType >= 0);
  }
  
  public boolean hasSelectInfo()
  {
    return this.adSelectInfo != null;
  }
  
  public boolean hasVoteInfo()
  {
    AppMethodBeat.i(96275);
    if ((this.adVoteInfo != null) && (this.adVoteInfo.DWZ.size() > 1))
    {
      AppMethodBeat.o(96275);
      return true;
    }
    AppMethodBeat.o(96275);
    return false;
  }
  
  public boolean isCardAd()
  {
    return this.adContentStyle == 1;
  }
  
  public boolean isFinderTopicCard()
  {
    return this.adContentStyle == 5;
  }
  
  public boolean isFullCardAd()
  {
    return this.adContentStyle == 3;
  }
  
  public boolean isLandingPagesAd()
  {
    return (this.bLandingPagesAd) || (this.bTurnLandingPagesAd);
  }
  
  public boolean isLinkAd()
  {
    return this.adContentStyle == 2;
  }
  
  public boolean isLongPressGestureAd()
  {
    AppMethodBeat.i(202825);
    if ((isFullCardAd()) && (this.adFullCardInfo != null) && (this.adFullCardInfo.DWF != null) && (this.adFullCardInfo.DWF.DXc > 0) && (this.adFullCardInfo.DWF.DXd > this.adFullCardInfo.DWF.DXc))
    {
      AppMethodBeat.o(202825);
      return true;
    }
    AppMethodBeat.o(202825);
    return false;
  }
  
  public boolean isNewStyleVote()
  {
    AppMethodBeat.i(96274);
    if ((this.adVoteInfo != null) && (this.adVoteInfo.DWZ.size() > 1) && (!TextUtils.isEmpty(((m)this.adVoteInfo.DWZ.get(0)).id)) && (!TextUtils.isEmpty(((m)this.adVoteInfo.DWZ.get(1)).id)))
    {
      AppMethodBeat.o(96274);
      return true;
    }
    AppMethodBeat.o(96274);
    return false;
  }
  
  public boolean isNormalAd()
  {
    return this.recSrc == 0;
  }
  
  public boolean isRecExpAd()
  {
    return this.recSrc == 2;
  }
  
  public boolean isShowPlayIconOnCover()
  {
    return this.addPlayIconOnCover == 1;
  }
  
  public boolean isSphereCardAd()
  {
    return this.adContentStyle == 4;
  }
  
  @Keep
  public static class AdCardActionBtnInfo
  {
    public String appId;
    public String appPageUrl;
    public String appType;
    public String brandDesc;
    public String brandHead;
    public String brandName;
    public String brandUsername;
    public String btnTitle;
    public String btnTitleAfterAddBrand;
    public String btnTitleAfterOrder;
    public String cardExt;
    public String cardTpId;
    public String clickActionLink;
    public int clickActionType;
    public String couponAppId;
    public String couponDesc;
    public String couponName;
    public String couponSenderName;
    public String couponSenderPhoto;
    public String couponStockId;
    public String downloadApkAppId;
    public String downloadApkPkgName;
    public String finderAvatar;
    public String finderEncryptedTopicId;
    public String finderLiveFeedExportId;
    public String finderLiveFeedNonceId;
    @Keep
    public String finderLiveId;
    public String finderLiveNoticeId;
    public String finderLiveTitle;
    public String finderNickName;
    public String finderTopicName;
    @Keep
    public String finderUsername;
    public String iconUrl;
    public String subscribeContent;
    public long subscribeExpiredTime;
    public String subscribeExpiredTip;
    public String subscribeFailedTip;
    public String subscribeHeadImg;
    public String subscribeNickname;
    public String subscribeSubmitBtnTitle;
    public String subscribeSucTip;
    public String subscribeTitle;
    public String tempId;
    public int weAppType;
    public String weappPath;
    public String weappUserName;
    public int weappVersion;
    
    public void parse(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(202815);
      this.iconUrl = Util.nullAsNil((String)paramMap.get(paramString + ".iconUrl"));
      this.btnTitle = Util.nullAsNil((String)paramMap.get(paramString + ".btnTitle"));
      this.clickActionType = Util.getInt((String)paramMap.get(paramString + ".clickActionType"), 0);
      this.clickActionLink = Util.nullAsNil((String)paramMap.get(paramString + ".clickActionLink"));
      this.weappUserName = Util.nullAsNil((String)paramMap.get(paramString + ".weappUserName"));
      this.weappPath = Util.nullAsNil((String)paramMap.get(paramString + ".weappPath"));
      this.weappVersion = Util.getInt((String)paramMap.get(paramString + ".weappVersion"), 0);
      this.weAppType = Util.safeParseInt((String)paramMap.get(paramString + ".miniProgramType"));
      this.tempId = Util.nullAsNil((String)paramMap.get(paramString + ".tempId"));
      this.btnTitleAfterOrder = Util.nullAsNil((String)paramMap.get(paramString + ".btnTitleAfterOrder"));
      this.subscribeTitle = Util.nullAsNil((String)paramMap.get(paramString + ".subscribeTitle"));
      this.subscribeContent = Util.nullAsNil((String)paramMap.get(paramString + ".subscribeContent"));
      this.subscribeSubmitBtnTitle = Util.nullAsNil((String)paramMap.get(paramString + ".subscribeSubmitBtnTitle"));
      this.subscribeFailedTip = Util.nullAsNil((String)paramMap.get(paramString + ".subscribeFailedTip"));
      this.subscribeSucTip = Util.nullAsNil((String)paramMap.get(paramString + ".subscribeSucTip"));
      this.appType = Util.nullAsNil((String)paramMap.get(paramString + ".appType"));
      this.appId = Util.nullAsNil((String)paramMap.get(paramString + ".appId"));
      this.subscribeHeadImg = Util.nullAsNil((String)paramMap.get(paramString + ".subscribeHeadImg"));
      this.subscribeNickname = Util.nullAsNil((String)paramMap.get(paramString + ".subscribeNickname"));
      this.subscribeExpiredTime = r.aOw((String)paramMap.get(paramString + ".subscribeExpiredTime"));
      this.subscribeExpiredTip = Util.nullAsNil((String)paramMap.get(paramString + ".subscribeExpiredTip"));
      this.downloadApkAppId = Util.nullAsNil((String)paramMap.get(paramString + ".openSdkAppId"));
      this.downloadApkPkgName = Util.nullAsNil((String)paramMap.get(paramString + ".packageName"));
      this.appPageUrl = Util.nullAsNil((String)paramMap.get(paramString + ".appPageUrlAndroid"));
      this.cardTpId = Util.nullAsNil((String)paramMap.get(paramString + ".cardTpId"));
      this.cardExt = Util.nullAsNil((String)paramMap.get(paramString + ".cardExt"));
      this.brandUsername = Util.nullAsNil((String)paramMap.get(paramString + ".brandUsername"));
      this.brandHead = Util.nullAsNil((String)paramMap.get(paramString + ".brandHead"));
      this.brandName = Util.nullAsNil((String)paramMap.get(paramString + ".brandName"));
      this.brandDesc = Util.nullAsNil((String)paramMap.get(paramString + ".brandDesc"));
      this.btnTitleAfterAddBrand = Util.nullAsNil((String)paramMap.get(paramString + ".btnTitleAfterAddBrand"));
      this.couponAppId = Util.nullAsNil((String)paramMap.get(paramString + ".couponAppId"));
      this.couponStockId = Util.nullAsNil((String)paramMap.get(paramString + ".couponStockId"));
      this.couponSenderPhoto = Util.nullAsNil((String)paramMap.get(paramString + ".couponSenderPhoto"));
      this.couponSenderName = Util.nullAsNil((String)paramMap.get(paramString + ".couponSenderName"));
      this.couponName = Util.nullAsNil((String)paramMap.get(paramString + ".couponName"));
      this.couponDesc = Util.nullAsNil((String)paramMap.get(paramString + ".couponDesc"));
      this.finderUsername = Util.nullAsNil((String)paramMap.get(paramString + ".finderUsername"));
      this.finderLiveNoticeId = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveNoticeId"));
      this.finderAvatar = Util.nullAsNil((String)paramMap.get(paramString + ".finderAvatar"));
      this.finderNickName = Util.nullAsNil((String)paramMap.get(paramString + ".finderNickname"));
      this.finderLiveTitle = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveTitle"));
      this.finderLiveId = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveId"));
      this.finderLiveFeedExportId = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveFeedExportId"));
      this.finderLiveFeedNonceId = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveFeedNonceId"));
      this.finderEncryptedTopicId = Util.nullAsNil((String)paramMap.get(paramString + ".finderEncryptedTopicId"));
      this.finderTopicName = Util.nullAsNil((String)paramMap.get(paramString + ".finderTopicName"));
      AppMethodBeat.o(202815);
    }
  }
  
  public static final class a
  {
    public String DrX;
    public String finderUsername;
    public String objectNonceId;
  }
  
  public static final class b
  {
    public String DWj;
    public String DWk;
    public int DWl;
    public String desc;
    public String pSE;
    
    public static b F(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(202814);
      String str1 = Util.nullAsNil((String)paramMap.get(paramString + ".bgImage"));
      String str2 = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
      String str3 = Util.nullAsNil((String)paramMap.get(paramString + ".descIcon"));
      String str4 = Util.nullAsNil((String)paramMap.get(paramString + ".detectSucIcon"));
      int i = Util.safeParseInt((String)paramMap.get(paramString + ".scanGestureType"));
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)) && (i > 0))
      {
        paramMap = new b();
        paramMap.DWj = str1;
        paramMap.desc = str2;
        paramMap.pSE = str3;
        paramMap.DWk = str4;
        paramMap.DWl = i;
        AppMethodBeat.o(202814);
        return paramMap;
      }
      AppMethodBeat.o(202814);
      return null;
    }
  }
  
  public static final class c
  {
    public List<ADXml.d> DWm;
    
    public c()
    {
      AppMethodBeat.i(202816);
      this.DWm = new ArrayList();
      AppMethodBeat.o(202816);
    }
    
    public final c G(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(202817);
      int i = 0;
      Object localObject2 = new StringBuilder().append(paramString).append(".adxml.adCardInfo.adRatingCardInfo.tagList.tag");
      if (i == 0) {}
      for (Object localObject1 = "";; localObject1 = Integer.valueOf(i))
      {
        String str5 = localObject1;
        if (!paramMap.containsKey(str5)) {
          break label513;
        }
        Log.i("MicroMsg.ADXml", "card ad tag %s", new Object[] { paramMap.get(str5) });
        if (!Util.isNullOrNil((String)paramMap.get(str5)))
        {
          localObject1 = new ADXml.d();
          ((ADXml.d)localObject1).DWn = Util.nullAs((String)paramMap.get(str5), "");
          localObject2 = str5 + ".$light_mode_url";
          String str1 = str5 + ".$dark_mode_url";
          String str2 = str5 + ".$tag_light_bg_color";
          String str3 = str5 + ".$tag_dark_bg_color";
          String str4 = str5 + ".$tag_light_name_color";
          str5 = str5 + ".$tag_dark_name_color";
          ((ADXml.d)localObject1).DWo = Util.nullAs((String)paramMap.get(localObject2), "");
          ((ADXml.d)localObject1).DWp = Util.nullAs((String)paramMap.get(str1), "");
          ((ADXml.d)localObject1).DWq = Util.nullAsNil((String)paramMap.get(str2));
          ((ADXml.d)localObject1).DWr = Util.nullAsNil((String)paramMap.get(str3));
          ((ADXml.d)localObject1).DWs = Util.nullAsNil((String)paramMap.get(str4));
          ((ADXml.d)localObject1).DWt = Util.nullAsNil((String)paramMap.get(str5));
          Log.i("MicroMsg.ADXml", "Tag content = ", new Object[] { ((ADXml.d)localObject1).DWn + ", Tag light iconUrl = " + ((ADXml.d)localObject1).DWo + ", Tag dark iconUrl = " + ((ADXml.d)localObject1).DWp + ", Tag background light color = " + ((ADXml.d)localObject1).DWq + ", Tag background dark color = " + ((ADXml.d)localObject1).DWr + ", Tag content light color = " + ((ADXml.d)localObject1).DWs + ", Tag content dark color = " + ((ADXml.d)localObject1).DWt });
          this.DWm.add(localObject1);
        }
        i += 1;
        break;
      }
      label513:
      AppMethodBeat.o(202817);
      return this;
    }
  }
  
  public static final class d
  {
    public String DWn;
    public String DWo;
    public String DWp;
    public String DWq;
    public String DWr;
    public String DWs;
    public String DWt;
  }
  
  public static final class e
  {
    public List<ADXml.f> list;
    
    public e()
    {
      AppMethodBeat.i(96262);
      this.list = new LinkedList();
      AppMethodBeat.o(96262);
    }
    
    public final e H(Map<String, String> paramMap, String paramString)
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
          ADXml.f localf = new ADXml.f();
          localf.url = Util.nullAs((String)paramMap.get(str2), "");
          localf.DWu = Util.nullAs((String)paramMap.get(paramString + ".Wording.zh"), "");
          localf.DQp = Util.nullAs((String)paramMap.get(paramString + ".Wording.en"), "");
          localf.DWv = Util.nullAs((String)paramMap.get(paramString + ".Wording.tw"), "");
          if (localf.DWu.length() + localf.DQp.length() + localf.DWv.length() > 0) {
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
    public String DQp = "";
    public String DWu = "";
    public String DWv = "";
    public String url = "";
  }
  
  public static final class g
  {
    public String DWA;
    public int DWB;
    public String DWC;
    public int DWD;
    public aw DWE;
    public ADXml.p DWF;
    public int DWw;
    public int DWx = 30;
    public int DWy;
    public a DWz;
    public String description;
    public String title;
    
    public static final class a
    {
      public float DWG;
      public String DWH;
      public int color;
      public long endTime;
      public long startTime;
    }
  }
  
  public final class h
  {
    public String DWI;
    public String Dse;
    
    public h() {}
  }
  
  public static final class i
  {
    public int DWK;
    public String DWL;
    public String DWM;
    public String DWN;
    public String DWO;
    public int DWw;
    public int DWx = 30;
    public int DWy;
    public String description;
    public String title;
  }
  
  public static final class j
  {
    public List<ADXml.o> DWP;
    public String adActionLink;
    public String appUserName;
    public String appVersion;
    public String dCx;
    
    public j()
    {
      AppMethodBeat.i(96264);
      this.adActionLink = "";
      this.DWP = new ArrayList();
      AppMethodBeat.o(96264);
    }
    
    public final void I(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(96265);
      this.adActionLink = Util.nullAs((String)paramMap.get(paramString + ".adxml.adTurnActionLink"), "");
      String str = (String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.appUserName");
      if (!TextUtils.isEmpty(str))
      {
        this.appUserName = str;
        this.appVersion = ((String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.appVersion"));
        this.dCx = ((String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.relativePagePath"));
      }
      str = paramString + ".adxml.adTurnInfo.materialInfo";
      int i = 0;
      if (i > 0) {}
      for (paramString = str + i;; paramString = str)
      {
        if ((paramMap.get(paramString + ".displayType") != null) && (((String)paramMap.get(paramString + ".displayType")).length() > 0))
        {
          ADXml.o localo = new ADXml.o();
          localo.title = Util.nullAs((String)paramMap.get(paramString + ".title"), "");
          localo.desc = Util.nullAs((String)paramMap.get(paramString + ".desc"), "");
          localo.DWw = Util.safeParseInt((String)paramMap.get(paramString + ".displayType"));
          this.DWP.add(localo);
          i += 1;
          break;
        }
        AppMethodBeat.o(96265);
        return;
      }
    }
  }
  
  public static final class k
    implements Serializable
  {
    public int DWQ;
    public int DWR;
    public int DWS;
    public int DWT;
    public int DWU;
    public boolean DWV;
    public boolean DWW;
    public String desc;
    public String title;
    
    public static k J(Map<String, String> paramMap, String paramString)
    {
      boolean bool2 = true;
      AppMethodBeat.i(202818);
      int k;
      int m;
      int n;
      int i;
      int j;
      if (paramMap.containsKey(paramString))
      {
        k = Util.safeParseInt((String)paramMap.get(paramString + ".twistStartTime"));
        m = Util.safeParseInt((String)paramMap.get(paramString + ".twistEndTime"));
        n = Util.safeParseInt((String)paramMap.get(paramString + ".twistDegree"));
        i = Util.safeParseInt((String)paramMap.get(paramString + ".coverStartTime"));
        j = Util.safeParseInt((String)paramMap.get(paramString + ".coverEndTime"));
        if (i != 0) {
          break label467;
        }
        i = k;
      }
      label451:
      label467:
      for (;;)
      {
        if (j == 0) {
          j = m;
        }
        for (;;)
        {
          if ((k >= 0) && (m > k) && (j >= i) && (i >= k) && (j <= m) && (n > 0))
          {
            int i1 = Util.safeParseInt((String)paramMap.get(paramString + ".isClockwise"));
            int i2 = Util.safeParseInt((String)paramMap.get(paramString + ".showSimpleTransition"));
            String str = Util.nullAsNil((String)paramMap.get(paramString + ".title"));
            paramMap = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
            paramString = new k();
            paramString.DWQ = k;
            paramString.DWR = m;
            paramString.DWS = i;
            paramString.DWT = j;
            paramString.DWU = n;
            paramString.title = str;
            paramString.desc = paramMap;
            if (i1 == 1)
            {
              bool1 = true;
              paramString.DWV = bool1;
              if (i2 != 1) {
                break label451;
              }
            }
            for (boolean bool1 = bool2;; bool1 = false)
            {
              paramString.DWW = bool1;
              AppMethodBeat.o(202818);
              return paramString;
              bool1 = false;
              break;
            }
          }
          AppMethodBeat.o(202818);
          return null;
        }
      }
    }
    
    public static boolean aPT(String paramString)
    {
      AppMethodBeat.i(202820);
      if ((paramString != null) && (paramString.contains("<isTwistAnimView>1</isTwistAnimView>")))
      {
        AppMethodBeat.o(202820);
        return true;
      }
      AppMethodBeat.o(202820);
      return false;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(202819);
      String str = "{twistStartTime=" + this.DWQ + ", twistEndTime=" + this.DWR + ", coverStartTime=" + this.DWS + ", coverEndTime=" + this.DWT + ", maxDegree=" + this.DWU + ", isClockWise=" + this.DWV + ", title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + '}';
      AppMethodBeat.o(202819);
      return str;
    }
  }
  
  public final class l
  {
    public String DWX;
    public String DWY;
    public ArrayList<ADXml.m> DWZ;
    
    public l()
    {
      AppMethodBeat.i(96266);
      this.DWX = "";
      this.DWY = "";
      this.DWZ = new ArrayList();
      AppMethodBeat.o(96266);
    }
    
    public final String YR(int paramInt)
    {
      AppMethodBeat.i(96267);
      if ((paramInt >= 0) && (paramInt < this.DWZ.size()))
      {
        String str = ((ADXml.m)this.DWZ.get(paramInt)).DXb;
        AppMethodBeat.o(96267);
        return str;
      }
      AppMethodBeat.o(96267);
      return "";
    }
    
    public final String YS(int paramInt)
    {
      AppMethodBeat.i(96268);
      if ((paramInt >= 0) && (paramInt < this.DWZ.size()))
      {
        String str = ((ADXml.m)this.DWZ.get(paramInt)).title;
        AppMethodBeat.o(96268);
        return str;
      }
      AppMethodBeat.o(96268);
      return "";
    }
  }
  
  public final class m
  {
    public String DXa = "";
    public String DXb = "";
    public String id = "";
    public String msN = "";
    public String title = "";
    public String xDQ = "";
    
    public m() {}
  }
  
  public static final class o
  {
    public int DWw = 0;
    public String desc;
    public String title;
  }
  
  public static final class p
  {
    public int DXc;
    public int DXd;
    public int DXe;
    public String DXf;
    public int DXg;
  }
  
  public static final class q
  {
    public String appUserName;
    public String appVersion;
    public String dCx;
    public int weAppType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.ADXml
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.sns.storage;

import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.adxml.c;
import com.tencent.mm.plugin.sns.ad.adxml.e.a;
import com.tencent.mm.plugin.sns.ad.adxml.f;
import com.tencent.mm.plugin.sns.ad.adxml.i;
import com.tencent.mm.plugin.sns.ad.adxml.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.p;
import com.tencent.mm.plugin.sns.ui.az;
import com.tencent.mm.protocal.protobuf.dmz;
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
import java.util.Objects;
import java.util.Set;
import kotlin.g.b.s;

public class ADXml
{
  public static final int AD_CONTENT_STYLE_CARD = 1;
  public static final int AD_CONTENT_STYLE_FINDER_TOPIC_CARD = 5;
  public static final int AD_CONTENT_STYLE_FULL_CARD = 3;
  public static final int AD_CONTENT_STYLE_LINK = 2;
  public static final int AD_CONTENT_STYLE_SLIDE_FULL_CARD = 6;
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
  public static final String PRE_KEY_GESTURE_LIST = ".pointsItem";
  public static final String SUFF_KEY_CARD_TAG_BACKGROUND_DARK_MODE_COLOR = ".$tag_dark_bg_color";
  public static final String SUFF_KEY_CARD_TAG_BACKGROUND_LIGHT_MODE_COLOR = ".$tag_light_bg_color";
  public static final String SUFF_KEY_CARD_TAG_CONTENT_DARK_MODE_COLOR = ".$tag_dark_name_color";
  public static final String SUFF_KEY_CARD_TAG_CONTENT_LIGHT_MODE_COLOR = ".$tag_light_name_color";
  public static final String SUFF_KEY_CARD_TAG_ICON_DARK_MODE_URL = ".$dark_mode_url";
  public static final String SUFF_KEY_CARD_TAG_ICON_LIGHT_MODE_URL = ".$light_mode_url";
  public static final String TAG = "MicroMsg.ADXml";
  public String adActionLink;
  public AdClickActionInfo adActionLinkClickInfo;
  public int adActionLinkHidden;
  public String adActionLinkIcon;
  public String adActionLinkName;
  public String adActionLinkTitle_cn;
  public String adActionLinkTitle_en;
  public String adActionLinkTitle_tw;
  public String adActionTitle;
  public Map<String, String> adArgs;
  public com.tencent.mm.plugin.sns.ad.adxml.b adAvatarFinderTopicInfo;
  public int adBasicRemWidth;
  public int adBasicRootFontSize;
  public b adBreakFrameInfo;
  public int adBtnDisplayType;
  public String adCard3dHeadTitle;
  public String adCard3dHeadUrl;
  public AdCardActionBtnInfo adCardActionBtnInfo;
  public String adCardDesc;
  public c adCardTagInfo;
  public String adCardTitle;
  public int adContentDisplayType;
  public int adContentStyle;
  public c adDynamicUpdateInfo;
  public String adExtInfo;
  public e adFeedbackInfo;
  public a adFinderInfo;
  public com.tencent.mm.plugin.sns.ad.adxml.e adFinderLiveInfo;
  public e.a adFinderLivePreviewInfo;
  public f adFinderTopicInfo;
  public ADXml.n adFloatWebViewInfo;
  @p(hkF=7)
  public g adFullCardInfo;
  public com.tencent.mm.plugin.sns.ad.adxml.h adHeadFinderProfile;
  public com.tencent.mm.plugin.sns.ad.widget.interactionlabel.a adInteractionLabelInfo;
  public i adLiveInfo;
  public float adMediaDisplayHeight;
  public int adMediaDisplayMode;
  public float adMediaDisplayWidth;
  public float adMediaIconHeight;
  public float adMediaIconPaddingBottom;
  public float adMediaIconPaddingRight;
  public String adMediaIconUrl;
  public float adMediaIconWidth;
  public j adPromotionInfo;
  @p(hkF=7)
  public com.tencent.mm.plugin.sns.ad.adxml.k adRollInfo;
  public b adScanJumpInfo;
  private h adSelectInfo;
  public e adSellingPointInfo;
  @p(hkF=7)
  public com.tencent.mm.plugin.sns.ad.widget.shakead.a adShakeInfo;
  public com.tencent.mm.plugin.sns.ad.adxml.m adSliderFullCardInfo;
  @p(hkF=7)
  public g adSocialInfo;
  public i adSphereCardInfo;
  @p(hkF=7)
  public com.tencent.mm.plugin.sns.ad.adxml.n adTagBtnInfo;
  public j adTurnInfo;
  public k adTwistInfo;
  public int adType;
  public boolean adVideoContinuePlay;
  public l adVoteInfo;
  public int addPlayIconOnCover;
  public String appGiftPackCode;
  public String appGiftPackCodeTips;
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
  public String feedbackWeAppPath;
  public String feedbackWeAppUsername;
  public String feedbackWording;
  public String firstDownloadApkPkgName;
  public boolean forbiddenCustomAnimation;
  public String headClickParam;
  public int headClickRightBarShow;
  public int headClickType;
  public int isValidJumpCanvas;
  public int newFeedbackPanel;
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
    AppMethodBeat.i(306671);
    if ((!Util.isNullOrNil(paramString)) && (paramString.trim().startsWith("<RecXml")))
    {
      feedRecXml(paramString);
      AppMethodBeat.o(306671);
      return;
    }
    feedAdXml(paramString);
    AppMethodBeat.o(306671);
  }
  
  private void feedAdXml(String paramString)
  {
    AppMethodBeat.i(306682);
    feedXml(paramString, "", "adxml");
    AppMethodBeat.o(306682);
  }
  
  private void feedRecXml(String paramString)
  {
    AppMethodBeat.i(306676);
    paramString = feedXml(paramString, ".RecXml", "RecXml");
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      this.recType = Util.safeParseInt((String)paramString.get(".RecXml.$type"));
      this.recSrc = Util.safeParseInt((String)paramString.get(".RecXml.$source"));
      this.recExpId = Util.safeParseInt((String)paramString.get(".RecXml.$expId"));
      this.originSnsId = t.aXD((String)paramString.get(".RecXml.$expOriginSnsId"));
    }
    AppMethodBeat.o(306676);
  }
  
  private Map<String, String> feedXml(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96270);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString3)))
    {
      AppMethodBeat.o(96270);
      return null;
    }
    Object localObject1 = paramString2;
    if (paramString2 == null) {
      localObject1 = "";
    }
    this.xml = paramString1;
    Log.i("MicroMsg.ADXml", "feed xml %s, keyPrefix %s, tag %s", new Object[] { paramString1, localObject1, paramString3 });
    Map localMap = XmlParser.parseXml(paramString1, paramString3, null);
    if (localMap == null)
    {
      AppMethodBeat.o(96270);
      return null;
    }
    this.adType = Util.safeParseInt((String)localMap.get((String)localObject1 + ".adxml.adType"));
    this.adActionTitle = Util.nullAs((String)localMap.get((String)localObject1 + ".adxml.adActionTitle"), "");
    this.adActionLink = Util.nullAs((String)localMap.get((String)localObject1 + ".adxml.adActionLink"), "");
    this.nickname = Util.nullAs((String)localMap.get((String)localObject1 + ".adxml.nickname"), "");
    this.webrightBar = Util.safeParseInt((String)localMap.get((String)localObject1 + ".adxml.webviewRightBarShow"));
    this.adActionLinkHidden = Util.safeParseInt((String)localMap.get((String)localObject1 + ".adxml.adActionLinkHidden"));
    this.adActionLinkName = Util.nullAs((String)localMap.get((String)localObject1 + ".adxml.adActionLinkName"), "");
    this.adActionLinkIcon = Util.nullAs((String)localMap.get((String)localObject1 + ".adxml.adActionLinkIcon"), "");
    this.adActionLinkTitle_cn = Util.nullAs((String)localMap.get((String)localObject1 + ".adxml.adActionLinkTitle.zh"), "");
    this.adActionLinkTitle_tw = Util.nullAs((String)localMap.get((String)localObject1 + ".adxml.adActionLinkTitle.tw"), "");
    this.adActionLinkTitle_en = Util.nullAs((String)localMap.get((String)localObject1 + ".adxml.adActionLinkTitle.en"), "");
    this.attachShareLinkWording = Util.nullAs((String)localMap.get((String)localObject1 + ".adxml.attachShareLinkWording"), "");
    this.attachShareLinkUrl = Util.nullAs((String)localMap.get((String)localObject1 + ".adxml.attachShareLinkUrl"), "");
    this.attachShareLinkIsHidden = Util.safeParseInt((String)localMap.get((String)localObject1 + ".adxml.attachShareLinkIsHidden"));
    if ((Util.isNullOrNil(this.attachShareLinkWording)) || (Util.isNullOrNil(this.attachShareLinkUrl))) {
      this.attachShareLinkIsHidden = 1;
    }
    this.expandOutsideTitle_cn = Util.nullAs((String)localMap.get((String)localObject1 + ".adxml.expandOutsideTitle.zh"), "");
    this.expandOutsideTitle_tw = Util.nullAs((String)localMap.get((String)localObject1 + ".adxml.expandOutsideTitle.tw"), "");
    this.expandOutsideTitle_en = Util.nullAs((String)localMap.get((String)localObject1 + ".adxml.expandOutsideTitle.en"), "");
    this.expandInsideTitle_cn = Util.nullAs((String)localMap.get((String)localObject1 + ".adxml.expandInsideTitle.zh"), "");
    this.expandInsideTitle_tw = Util.nullAs((String)localMap.get((String)localObject1 + ".adxml.expandInsideTitle.tw"), "");
    this.expandInsideTitle_en = Util.nullAs((String)localMap.get((String)localObject1 + ".adxml.expandInsideTitle.en"), "");
    this.headClickType = Util.safeParseInt((String)localMap.get((String)localObject1 + ".adxml.headClickType"));
    this.headClickParam = Util.nullAs((String)localMap.get((String)localObject1 + ".adxml.headClickParam"), "");
    this.headClickRightBarShow = Util.safeParseInt((String)localMap.get((String)localObject1 + ".adxml.headClickRightBarShow"));
    this.toAdMarket = Util.safeParseInt((String)localMap.get((String)localObject1 + ".adxml.toAdMarket"));
    this.newFeedbackPanel = Util.safeParseInt((String)localMap.get((String)localObject1 + ".adxml.newFeedback"));
    this.videoPlayInStreamingMode = Util.safeParseInt((String)localMap.get((String)localObject1 + ".adxml.videoPlayInStreamingMode"));
    int i = 0;
    paramString2 = new StringBuilder().append((String)localObject1).append(".adxml.adArgs.arg");
    label1185:
    Object localObject2;
    if (i == 0)
    {
      paramString1 = "";
      paramString2 = paramString1 + ".key";
      paramString3 = (String)localMap.get(paramString2);
      if (paramString3 == null) {
        break label1366;
      }
      localObject2 = new StringBuilder().append((String)localObject1).append(".adxml.adArgs.arg");
      if (i != 0) {
        break label1357;
      }
    }
    label1357:
    for (paramString1 = "";; paramString1 = Integer.valueOf(i))
    {
      paramString1 = paramString1 + ".value";
      localObject2 = (String)localMap.get(paramString1);
      Log.i("MicroMsg.ADXml", "newKey " + paramString2 + " " + paramString3 + " newValue : " + paramString1 + " " + (String)localObject2);
      this.adArgs.put(paramString3, localObject2);
      i += 1;
      break;
      paramString1 = Integer.valueOf(i);
      break label1185;
    }
    label1366:
    this.bLandingPagesAd = localMap.containsKey((String)localObject1 + ".adxml.adCanvasInfo");
    boolean bool;
    if (Util.safeParseInt((String)localMap.get((String)localObject1 + ".adxml.usePreferedInfo")) == 1)
    {
      bool = true;
      this.usePreferedInfo = bool;
      this.preferNickName = Util.nullAsNil((String)localMap.get((String)localObject1 + ".adxml.preferNickname"));
      this.preferAvatar = Util.nullAsNil((String)localMap.get((String)localObject1 + ".adxml.preferAvatar"));
      this.adContentDisplayType = Util.safeParseInt((String)localMap.get((String)localObject1 + ".adxml.adFeedDisplayInfo.contentDisplayType"));
      this.adMediaDisplayMode = Util.safeParseInt((String)localMap.get((String)localObject1 + ".adxml.adFeedDisplayInfo.mediaDisplayMode"));
      this.adMediaDisplayWidth = ((float)Util.safeParseDouble((String)localMap.get((String)localObject1 + ".adxml.adFeedDisplayInfo.mediaDisplayWidth")));
      this.adMediaDisplayHeight = ((float)Util.safeParseDouble((String)localMap.get((String)localObject1 + ".adxml.adFeedDisplayInfo.mediaDisplayHeight")));
      this.adBtnDisplayType = Util.safeParseInt((String)localMap.get((String)localObject1 + ".adxml.adFeedDisplayInfo.btnDisplayType"));
      this.adMediaIconUrl = Util.nullAs((String)localMap.get((String)localObject1 + ".adxml.adFeedDisplayInfo.mediaIconUrl"), "");
      this.adBasicRemWidth = Util.safeParseInt((String)localMap.get((String)localObject1 + ".adxml.adFeedDisplayInfo.basicRemWidth"));
      this.adBasicRootFontSize = Util.safeParseInt((String)localMap.get((String)localObject1 + ".adxml.adFeedDisplayInfo.basicRootFontSize"));
      this.adMediaIconWidth = ((float)Util.safeParseDouble((String)localMap.get((String)localObject1 + ".adxml.adFeedDisplayInfo.mediaIconWidth")));
      this.adMediaIconHeight = ((float)Util.safeParseDouble((String)localMap.get((String)localObject1 + ".adxml.adFeedDisplayInfo.mediaIconHeight")));
      this.adMediaIconPaddingRight = ((float)Util.safeParseDouble((String)localMap.get((String)localObject1 + ".adxml.adFeedDisplayInfo.mediaIconPaddingRight")));
      this.adMediaIconPaddingBottom = ((float)Util.safeParseDouble((String)localMap.get((String)localObject1 + ".adxml.adFeedDisplayInfo.mediaIconPaddingBottom")));
      this.adContentStyle = Util.safeParseInt((String)localMap.get((String)localObject1 + ".adxml.adContentStyle"));
      this.adCardTitle = Util.nullAs((String)localMap.get((String)localObject1 + ".adxml.adCardInfo.title"), "");
      this.adCardDesc = Util.nullAs((String)localMap.get((String)localObject1 + ".adxml.adCardInfo.description"), "");
      this.adCardTagInfo = new c().ai(localMap, (String)localObject1);
      this.adCard3dHeadTitle = Util.nullAsNil((String)localMap.get((String)localObject1 + ".adxml.adCardInfo.adRatingCardInfo.headTitle"));
      this.adCard3dHeadUrl = Util.nullAsNil((String)localMap.get((String)localObject1 + ".adxml.adCardInfo.adRatingCardInfo.headUrl"));
      paramString1 = Util.nullAs((String)localMap.get((String)localObject1 + ".adxml.adSelectInfo.leftBtnTitle"), "");
      paramString2 = Util.nullAs((String)localMap.get((String)localObject1 + ".adxml.adSelectInfo.rightBtnTitle"), "");
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        this.adSelectInfo = new h();
        this.adSelectInfo.PMU = paramString1;
        this.adSelectInfo.QHQ = paramString2;
        paramString1 = this.adSelectInfo;
        paramString2 = (String)localObject1 + ".adxml.adSelectInfo";
        paramString1.QHR = AdClickActionInfo.w(localMap, paramString2 + ".leftBtnClickActionInfo");
        paramString1.QHR.scene = 5;
        paramString1.QHS = AdClickActionInfo.w(localMap, paramString2 + ".rightBtnClickActionInfo");
        paramString1.QHS.scene = 6;
      }
      paramString1 = Util.nullAs((String)localMap.get((String)localObject1 + ".adxml.adVoteInfo.componentUrl"), "");
      if (TextUtils.isEmpty(paramString1)) {
        break label2897;
      }
      this.adVoteInfo = new l();
      this.adVoteInfo.QIe = paramString1;
      this.adVoteInfo.QIf = Util.nullAs((String)localMap.get((String)localObject1 + ".adxml.adVoteInfo.voteLabel"), "");
      paramString2 = (String)localObject1 + ".adxml.adVoteInfo.optionList.option";
      i = 0;
      label2554:
      if (i == 0) {
        break label6722;
      }
    }
    label4631:
    label4925:
    label6463:
    label6722:
    for (paramString1 = paramString2 + i;; paramString1 = paramString2)
    {
      if (!TextUtils.isEmpty(Util.nullAs((String)localMap.get(paramString1 + ".title"), "")))
      {
        paramString3 = new m();
        paramString3.title = Util.nullAs((String)localMap.get(paramString1 + ".title"), "");
        paramString3.svG = Util.nullAs((String)localMap.get(paramString1 + ".shareTitle"), "");
        paramString3.ICb = Util.nullAs((String)localMap.get(paramString1 + ".shareDesc"), "");
        paramString3.QIh = Util.nullAs((String)localMap.get(paramString1 + ".shareThumb"), "");
        paramString3.QIi = Util.nullAs((String)localMap.get(paramString1 + ".selectedTitle"), "");
        paramString3.id = Util.nullAs((String)localMap.get(paramString1 + ".id"), "");
        this.adVoteInfo.QIg.add(paramString3);
        i += 1;
        break label2554;
        bool = false;
        break;
      }
      label2897:
      this.bTurnLandingPagesAd = localMap.containsKey((String)localObject1 + ".adxml.adTurnCanvasInfo");
      this.adTurnInfo = new j();
      this.adTurnInfo.al(localMap, (String)localObject1);
      this.adFeedbackInfo = new e().aj(localMap, (String)localObject1);
      if (this.adContentStyle == 3)
      {
        this.adFullCardInfo = new g();
        paramString1 = (String)localObject1 + ".adxml.adFullCardInfo";
        paramString2 = this.adFullCardInfo;
        paramString2.QHE = Util.safeParseInt((String)localMap.get(paramString1 + ".displayType"));
        paramString2.title = Util.nullAsNil((String)localMap.get(paramString1 + ".title"));
        paramString2.description = Util.nullAsNil((String)localMap.get(paramString1 + ".description"));
        paramString2.QHF = Util.getInt((String)localMap.get(paramString1 + ".markMaxAlpha"), 30);
        paramString2.QHG = Util.safeParseInt((String)localMap.get(paramString1 + ".titlePosition"));
        paramString2.QHI = Util.nullAsNil((String)localMap.get(paramString1 + ".maskImg"));
        paramString2.QHJ = Util.safeParseInt((String)localMap.get(paramString1 + ".maskImgDisappearTime"));
        paramString2.QHK = Util.nullAsNil((String)localMap.get(paramString1 + ".coverImg"));
        paramString2.QHL = Util.safeParseInt((String)localMap.get(paramString1 + ".coverImgAppearTime"));
        paramString3 = (String)localMap.get(paramString1 + ".adGestureInfo.points");
        localObject2 = paramString1 + ".adGestureInfo.pointsList";
        if ((!Util.isNullOrNil(paramString3)) || (localMap.containsKey(localObject2)))
        {
          paramString2.QHH = new ADXml.g.a();
          paramString2.QHH.color = -1;
          paramString2.QHH.startTime = Util.safeParseInt((String)localMap.get(paramString1 + ".adGestureInfo.startTime"));
          paramString2.QHH.endTime = Util.safeParseInt((String)localMap.get(paramString1 + ".adGestureInfo.endTime"));
          paramString2.QHH.TG = Util.safeParseFloat((String)localMap.get(paramString1 + ".adGestureInfo.distance"));
          paramString2.QHH.color = Color.parseColor(Util.nullAsNil((String)localMap.get(paramString1 + ".adGestureInfo.color")));
          paramString2.QHH.QHO = Util.nullAsNil((String)localMap.get(paramString1 + ".adGestureInfo.points"));
          if (localMap.containsKey(localObject2)) {
            paramString2.QHH.ak(localMap, (String)localObject2);
          }
        }
        paramString3 = paramString1 + ".endCoverInfo";
        if (localMap.containsKey(paramString3))
        {
          paramString2.QHM = new az();
          paramString2.QHM.title = Util.nullAsNil((String)localMap.get(paramString3 + ".title"));
          paramString2.QHM.desc = Util.nullAsNil((String)localMap.get(paramString3 + ".description"));
          paramString2.QHM.Rkx = Util.nullAsNil((String)localMap.get(paramString3 + ".actionTitle"));
          paramString2.QHM.coverImgUrl = Util.nullAsNil((String)localMap.get(paramString3 + ".ambientImageUrl"));
          paramString2.QHM.Rkw = Util.nullAsNil((String)localMap.get(paramString3 + ".titleImageUrl"));
          paramString2.QHM.duration = Util.safeParseInt((String)localMap.get(paramString3 + ".endCoverEndTime"));
        }
        paramString2.QHN = p.ao(localMap, paramString1 + ".adLongPressGestureInfo");
        this.clientMinVersion = Util.safeParseInt((String)localMap.get((String)localObject1 + ".adxml.compatible.clientVersion.androidMin"));
        this.clientMaxVersion = Util.safeParseInt((String)localMap.get((String)localObject1 + ".adxml.compatible.clientVersion.androidMax"));
        this.compatibleUrl = Util.nullAsNil((String)localMap.get((String)localObject1 + ".adxml.compatible.jumpUrl"));
        paramString1 = (String)localObject1 + ".adxml.adCardInfo.adCardButton";
        if (localMap.containsKey(paramString1))
        {
          this.adCardActionBtnInfo = new AdCardActionBtnInfo();
          this.adCardActionBtnInfo.parse(localMap, paramString1);
          if (!TextUtils.isEmpty(this.adCardActionBtnInfo.clickActionInfo.PLC))
          {
            this.firstDownloadApkPkgName = this.adCardActionBtnInfo.clickActionInfo.PLC;
            Log.i("MicroMsg.ADXml", "findDownloadApkPkgName, adCardActionBtnInfo.pkg=" + this.adCardActionBtnInfo.clickActionInfo.PLC);
          }
        }
        if (TextUtils.isEmpty(this.firstDownloadApkPkgName)) {
          findDownloadApkPkgName(localMap);
        }
        this.adExtInfo = com.tencent.mm.plugin.sns.data.k.aXd((String)localMap.get((String)localObject1 + ".adxml.adExtInfo"));
      }
      try
      {
        paramString1 = com.tencent.mm.plugin.sns.device.appstore.a.b(MMApplicationContext.getContext(), (String)localObject1 + ".adxml.adMarketJump.", localMap);
        if (paramString1 != null)
        {
          this.appMarketIntent = paramString1.heU();
          if (this.appMarketIntent == null)
          {
            paramString1 = com.tencent.mm.plugin.sns.device.appstore.a.c(MMApplicationContext.getContext(), localMap);
            if (paramString1 != null) {
              this.appMarketIntent = paramString1.heU();
            }
          }
        }
      }
      finally
      {
        label4334:
        break label4334;
      }
      this.adScanJumpInfo = b.ah(localMap, (String)localObject1 + ".adxml.adScanInfo");
      this.adFloatWebViewInfo = ADXml.n.an(localMap, (String)localObject1 + ".adxml.adCanvasInfo.globalComponentItems.componentItem");
      this.adFinderInfo = a.ag(localMap, (String)localObject1 + ".adxml.adFinderInfo");
      this.addPlayIconOnCover = Util.safeParseInt((String)localMap.get((String)localObject1 + ".adxml.addPlayIconOnCover"));
      this.adTwistInfo = k.am(localMap, (String)localObject1 + ".adxml.adTwistInfo");
      this.adShakeInfo = com.tencent.mm.plugin.sns.ad.widget.shakead.a.ad(localMap, (String)localObject1 + ".adxml.adShakeInfo");
      this.verticalVideoDisplayType = Util.safeParseInt((String)localMap.get((String)localObject1 + ".adxml.verticalVideoDisplayType"));
      this.weAppInfo = q.ap(localMap, (String)localObject1 + ".adxml.headWeAppInfo");
      if (Util.safeParseInt((String)localMap.get((String)localObject1 + ".adxml.forbiddenCustomAnimation")) == 1)
      {
        bool = true;
        this.forbiddenCustomAnimation = bool;
        this.adPromotionInfo = j.R(localMap, (String)localObject1 + ".adxml.adCardInfo.promotionInfo");
        this.adLiveInfo = i.O(localMap, (String)localObject1 + ".adxml.adLiveInfo");
        this.adRollInfo = com.tencent.mm.plugin.sns.ad.adxml.k.S(localMap, (String)localObject1 + ".adxml.adRollInfo");
        this.adFinderLiveInfo = com.tencent.mm.plugin.sns.ad.adxml.e.F(localMap, (String)localObject1 + ".adxml.adFinderLiveInfo");
        this.adFinderLivePreviewInfo = new e.a().G(localMap, (String)localObject1 + ".adxml.adFinderLiveInfo.finderLivePreviewInfo");
        this.adHeadFinderProfile = com.tencent.mm.plugin.sns.ad.adxml.h.N(localMap, (String)localObject1 + ".adxml.headFinderProfile");
        this.adFinderTopicInfo = f.J(localMap, (String)localObject1 + ".adxml.adFinderTopicInfo");
        this.adAvatarFinderTopicInfo = com.tencent.mm.plugin.sns.ad.adxml.b.v(localMap, (String)localObject1 + ".adxml.headFinderTopicInfo");
        if (Util.safeParseInt((String)localMap.get((String)localObject1 + ".adxml.preloadWeAppPkg")) != 1) {
          break label5889;
        }
        bool = true;
        this.preloadWeAppPkg = bool;
        if (Util.safeParseInt((String)localMap.get((String)localObject1 + ".adxml.adVideoContinuePlay")) != 1) {
          break label5895;
        }
        bool = true;
        label4972:
        this.adVideoContinuePlay = bool;
        this.adDynamicUpdateInfo = c.x(localMap, (String)localObject1 + ".adxml.adDynamicUpdateInfo");
        this.feedbackWording = Util.nullAsNil((String)localMap.get((String)localObject1 + ".adxml.feedbackWording"));
        this.feedbackWeAppUsername = Util.nullAsNil((String)localMap.get((String)localObject1 + ".adxml.feedbackWeAppUsername"));
        this.feedbackWeAppPath = Util.nullAsNil((String)localMap.get((String)localObject1 + ".adxml.feedbackWeAppPath"));
        paramString1 = (String)localObject1 + ".adxml.tagButtonInfo";
        if (localMap.containsKey(paramString1)) {
          this.adTagBtnInfo = com.tencent.mm.plugin.sns.ad.adxml.n.X(localMap, paramString1);
        }
        this.appGiftPackCode = Util.nullAsNil((String)localMap.get((String)localObject1 + ".adxml.appGiftPackCode"));
        this.appGiftPackCodeTips = Util.nullAsNil((String)localMap.get((String)localObject1 + ".adxml.appGiftPackCodeTips"));
        this.adSliderFullCardInfo = com.tencent.mm.plugin.sns.ad.adxml.m.V(localMap, (String)localObject1 + ".adxml.adSliderCardInfo");
        paramString1 = (String)localObject1 + ".adxml.adActionLinkClickInfo";
        if (localMap.containsKey(paramString1)) {
          this.adActionLinkClickInfo = AdClickActionInfo.w(localMap, paramString1);
        }
        this.adSellingPointInfo = e.ar(localMap, (String)localObject1 + ".adxml.adCardInfo.adSellPointInfo");
        this.adSocialInfo = g.as(localMap, (String)localObject1 + ".adxml.adSocialInfo");
        this.adInteractionLabelInfo = com.tencent.mm.plugin.sns.ad.widget.interactionlabel.a.ac(localMap, (String)localObject1 + ".adxml.interactionLabelInfo");
        paramString2 = (String)localObject1 + ".adxml.adBreakFrameInfo";
        if (localMap.containsKey(paramString2))
        {
          paramString1 = b.QIu;
          if (localMap != null) {
            break label5901;
          }
          paramString1 = null;
        }
      }
      for (;;)
      {
        this.adBreakFrameInfo = paramString1;
        AppMethodBeat.o(96270);
        return localMap;
        if (this.adContentStyle != 4) {
          break;
        }
        this.adSphereCardInfo = new i();
        paramString1 = (String)localObject1 + ".adxml.adSphereCardInfo";
        paramString2 = this.adSphereCardInfo;
        paramString2.QHE = Util.safeParseInt((String)localMap.get(paramString1 + ".displayType"));
        paramString2.title = Util.nullAsNil((String)localMap.get(paramString1 + ".title"));
        paramString2.description = Util.nullAsNil((String)localMap.get(paramString1 + ".description"));
        paramString2.QHF = Util.getInt((String)localMap.get(paramString1 + ".markMaxAlpha"), 30);
        paramString2.QHG = Util.safeParseInt((String)localMap.get(paramString1 + ".titlePosition"));
        paramString2.QHU = Util.safeParseInt((String)localMap.get(paramString1 + ".gestureDelayTime"));
        paramString2.QHW = Util.nullAsNil((String)localMap.get(paramString1 + ".sphereThumbUrl"));
        paramString2.bgColor = Util.nullAsNil((String)localMap.get(paramString1 + ".bgColor"));
        paramString2.QHX = Util.nullAsNil((String)localMap.get(paramString1 + ".bgColorAlpha"));
        paramString2.QHV = Util.nullAsNil((String)localMap.get(paramString1 + ".sphereImageUrl"));
        break;
        bool = false;
        break label4631;
        bool = false;
        break label4925;
        bool = false;
        break label4972;
        if (paramString2 == null)
        {
          paramString1 = null;
        }
        else
        {
          paramString3 = (String)localMap.get(s.X(paramString2, ".mediaType"));
          if (paramString3 == null)
          {
            paramString3 = "";
            paramString1 = h.QYt;
            paramString1 = s.X(paramString2, ".alphaVideoInfo");
            if (localMap != null) {
              break label5967;
            }
            paramString1 = null;
          }
          label5967:
          float f1;
          label6097:
          float f2;
          for (;;)
          {
            if (paramString1 != null) {
              break label6290;
            }
            paramString1 = null;
            break;
            break label5936;
            if (paramString1 == null)
            {
              paramString1 = null;
            }
            else
            {
              localObject1 = k.QYy;
              localObject1 = k.W(s.X(paramString1, ".media"), localMap);
              if (localObject1 == null)
              {
                paramString1 = null;
              }
              else
              {
                localObject2 = m.QYz;
                paramString1 = s.X(paramString1, ".playModeInfo");
                if (localMap == null) {
                  paramString1 = null;
                }
                for (;;)
                {
                  if (paramString1 == null)
                  {
                    paramString1 = null;
                    break;
                    if (paramString1 == null)
                    {
                      paramString1 = null;
                    }
                    else
                    {
                      localObject2 = (String)localMap.get(s.X(paramString1, ".playMode"));
                      label6124:
                      float f3;
                      if (localObject2 == null)
                      {
                        i = 0;
                        localObject2 = (String)localMap.get(s.X(paramString1, ".startOffset"));
                        if (localObject2 != null) {
                          break label6196;
                        }
                        f1 = 0.0F;
                        localObject2 = (String)localMap.get(s.X(paramString1, ".loopStartTime"));
                        if (localObject2 != null) {
                          break label6224;
                        }
                        f2 = 0.0F;
                        paramString1 = (String)localMap.get(s.X(paramString1, ".loopEndTime"));
                        if (paramString1 != null) {
                          break label6252;
                        }
                        f3 = 0.0F;
                      }
                      for (;;)
                      {
                        paramString1 = new m(i, f1, f2, f3);
                        break;
                        localObject2 = kotlin.n.n.bJF((String)localObject2);
                        if (localObject2 == null)
                        {
                          i = 0;
                          break label6070;
                        }
                        i = ((Integer)localObject2).intValue();
                        break label6070;
                        localObject2 = kotlin.n.n.bJE((String)localObject2);
                        if (localObject2 == null)
                        {
                          f1 = 0.0F;
                          break label6097;
                        }
                        f1 = ((Float)localObject2).floatValue();
                        break label6097;
                        label6224:
                        localObject2 = kotlin.n.n.bJE((String)localObject2);
                        if (localObject2 == null)
                        {
                          f2 = 0.0F;
                          break label6124;
                        }
                        f2 = ((Float)localObject2).floatValue();
                        break label6124;
                        label6252:
                        paramString1 = kotlin.n.n.bJE(paramString1);
                        if (paramString1 == null) {
                          f3 = 0.0F;
                        } else {
                          f3 = paramString1.floatValue();
                        }
                      }
                    }
                  }
                }
                paramString1 = new h((dmz)localObject1, paramString1);
              }
            }
          }
          localObject1 = a.QIn;
          paramString2 = s.X(paramString2, ".clickInfo");
          if (localMap == null) {
            paramString2 = null;
          }
          for (;;)
          {
            if (paramString2 != null) {
              break label6704;
            }
            paramString1 = null;
            break;
            if (paramString2 == null)
            {
              paramString2 = null;
            }
            else
            {
              localObject1 = (String)localMap.get(s.X(paramString2, ".areaLeft"));
              label6355:
              int j;
              label6382:
              int k;
              int m;
              if (localObject1 == null)
              {
                i = 0;
                localObject1 = (String)localMap.get(s.X(paramString2, ".areaTop"));
                if (localObject1 != null) {
                  break label6540;
                }
                j = 0;
                localObject1 = (String)localMap.get(s.X(paramString2, ".areaWidth"));
                if (localObject1 != null) {
                  break label6568;
                }
                k = 0;
                localObject1 = (String)localMap.get(s.X(paramString2, ".areaHeight"));
                if (localObject1 != null) {
                  break label6596;
                }
                m = 0;
                localObject1 = (String)localMap.get(s.X(paramString2, ".clickStartTime"));
                if (localObject1 != null) {
                  break label6624;
                }
                f1 = 0.0F;
                localObject1 = (String)localMap.get(s.X(paramString2, ".clickEndTime"));
                if (localObject1 != null) {
                  break label6652;
                }
                f2 = 0.0F;
              }
              for (;;)
              {
                paramString2 = AdClickActionInfo.w(localMap, s.X(paramString2, ".clickActionInfo"));
                if (paramString2 != null) {
                  break label6680;
                }
                paramString2 = null;
                break;
                localObject1 = kotlin.n.n.bJF((String)localObject1);
                if (localObject1 == null)
                {
                  i = 0;
                  break label6355;
                }
                i = ((Integer)localObject1).intValue();
                break label6355;
                localObject1 = kotlin.n.n.bJF((String)localObject1);
                if (localObject1 == null)
                {
                  j = 0;
                  break label6382;
                }
                j = ((Integer)localObject1).intValue();
                break label6382;
                localObject1 = kotlin.n.n.bJF((String)localObject1);
                if (localObject1 == null)
                {
                  k = 0;
                  break label6409;
                }
                k = ((Integer)localObject1).intValue();
                break label6409;
                label6596:
                localObject1 = kotlin.n.n.bJF((String)localObject1);
                if (localObject1 == null)
                {
                  m = 0;
                  break label6436;
                }
                m = ((Integer)localObject1).intValue();
                break label6436;
                label6624:
                localObject1 = kotlin.n.n.bJE((String)localObject1);
                if (localObject1 == null)
                {
                  f1 = 0.0F;
                  break label6463;
                }
                f1 = ((Float)localObject1).floatValue();
                break label6463;
                label6652:
                localObject1 = kotlin.n.n.bJE((String)localObject1);
                if (localObject1 == null) {
                  f2 = 0.0F;
                } else {
                  f2 = ((Float)localObject1).floatValue();
                }
              }
              paramString2 = new a(i, j, k, m, f1, f2, paramString2);
            }
          }
          paramString1 = new b(paramString3, paramString1, paramString2);
        }
      }
    }
  }
  
  public static String getGestureCanvasInfo(String paramString)
  {
    AppMethodBeat.i(306722);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(306722);
      return "";
    }
    if (paramString.contains("<adFullCardGestureCanvasInfo>")) {}
    for (paramString = paramString.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adFullCardGestureCanvasInfo", "adCanvasInfo");; paramString = "")
    {
      AppMethodBeat.o(306722);
      return paramString;
    }
  }
  
  public static boolean isShakeAdCanvas(String paramString)
  {
    AppMethodBeat.i(306732);
    if ((paramString != null) && (paramString.contains("<isShakeAnimView>1</isShakeAnimView>")))
    {
      AppMethodBeat.o(306732);
      return true;
    }
    AppMethodBeat.o(306732);
    return false;
  }
  
  public static boolean isSimpleShakeAd(String paramString)
  {
    AppMethodBeat.i(306733);
    if ((paramString != null) && (paramString.contains("<simpleTransitionAnimationUrl>")))
    {
      AppMethodBeat.o(306733);
      return true;
    }
    AppMethodBeat.o(306733);
    return false;
  }
  
  public static boolean isSimpleSharedShakeAd(String paramString)
  {
    AppMethodBeat.i(306734);
    if ((isSimpleShakeAd(paramString)) && (paramString != null) && (paramString.contains("<isInteractiveCanvas>")))
    {
      AppMethodBeat.o(306734);
      return true;
    }
    AppMethodBeat.o(306734);
    return false;
  }
  
  public static boolean isTwistAdCanvas(String paramString)
  {
    AppMethodBeat.i(306728);
    if ((paramString != null) && (paramString.contains("<isTwistAnimView>1</isTwistAnimView>")))
    {
      AppMethodBeat.o(306728);
      return true;
    }
    AppMethodBeat.o(306728);
    return false;
  }
  
  public void findDownloadApkPkgName(Map<String, String> paramMap)
  {
    AppMethodBeat.i(306798);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(306798);
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
          AppMethodBeat.o(306798);
          return;
        }
      }
    }
    AppMethodBeat.o(306798);
  }
  
  public h getAdSelectInfo()
  {
    return this.adSelectInfo;
  }
  
  public String getAdVoteComponentUrl()
  {
    AppMethodBeat.i(96273);
    if (hasVoteInfo())
    {
      String str = this.adVoteInfo.QIe;
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
      str = this.adSelectInfo.PMU;
      AppMethodBeat.o(96271);
      return str;
    }
    if (hasVoteInfo())
    {
      str = ((m)this.adVoteInfo.QIg.get(0)).title;
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
      str = this.adSelectInfo.QHQ;
      AppMethodBeat.o(96272);
      return str;
    }
    if (hasVoteInfo())
    {
      str = ((m)this.adVoteInfo.QIg.get(1)).title;
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
    return (this.adCardActionBtnInfo != null) && (this.adCardActionBtnInfo.clickActionInfo.PLm >= 0);
  }
  
  public boolean hasSelectInfo()
  {
    return this.adSelectInfo != null;
  }
  
  public boolean hasVoteInfo()
  {
    AppMethodBeat.i(96275);
    if ((this.adVoteInfo != null) && (this.adVoteInfo.QIg.size() > 1))
    {
      AppMethodBeat.o(96275);
      return true;
    }
    AppMethodBeat.o(96275);
    return false;
  }
  
  public boolean isAdBreakFrameVideo()
  {
    if (this.adBreakFrameInfo == null) {}
    for (;;)
    {
      return false;
      try
      {
        int i = this.adBreakFrameInfo.QIv.QYu.QYA;
        if (i == 0) {
          return true;
        }
      }
      catch (Exception localException) {}
    }
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
  
  public boolean isGestureAd()
  {
    AppMethodBeat.i(306770);
    if ((isFullCardAd()) && (this.adFullCardInfo != null) && (this.adFullCardInfo.QHH != null) && (this.adFullCardInfo.QHH.startTime >= 0L) && (this.adFullCardInfo.QHH.endTime > this.adFullCardInfo.QHH.startTime))
    {
      AppMethodBeat.o(306770);
      return true;
    }
    AppMethodBeat.o(306770);
    return false;
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
    AppMethodBeat.i(306761);
    if ((isFullCardAd()) && (this.adFullCardInfo != null) && (this.adFullCardInfo.QHN != null) && (this.adFullCardInfo.QHN.QIj > 0) && (this.adFullCardInfo.QHN.QIk > this.adFullCardInfo.QHN.QIj))
    {
      AppMethodBeat.o(306761);
      return true;
    }
    AppMethodBeat.o(306761);
    return false;
  }
  
  public boolean isNewStyleVote()
  {
    AppMethodBeat.i(96274);
    if ((this.adVoteInfo != null) && (this.adVoteInfo.QIg.size() > 1) && (!TextUtils.isEmpty(((m)this.adVoteInfo.QIg.get(0)).id)) && (!TextUtils.isEmpty(((m)this.adVoteInfo.QIg.get(1)).id)))
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
  
  public boolean isShakeAd()
  {
    AppMethodBeat.i(306768);
    if ((isFullCardAd()) && (this.adShakeInfo != null))
    {
      AppMethodBeat.o(306768);
      return true;
    }
    AppMethodBeat.o(306768);
    return false;
  }
  
  public boolean isShowPlayIconOnCover()
  {
    return this.addPlayIconOnCover == 1;
  }
  
  public boolean isSlideFullCard()
  {
    return this.adContentStyle == 6;
  }
  
  public boolean isSphereCardAd()
  {
    return this.adContentStyle == 4;
  }
  
  public boolean isTwistAd()
  {
    AppMethodBeat.i(306764);
    if ((isFullCardAd()) && (this.adTwistInfo != null))
    {
      AppMethodBeat.o(306764);
      return true;
    }
    AppMethodBeat.o(306764);
    return false;
  }
  
  public static class AdCardActionBtnInfo
  {
    public String btnTitle;
    public AdClickActionInfo clickActionInfo;
    public String iconUrl;
    
    public void parse(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(306611);
      this.iconUrl = Util.nullAsNil((String)paramMap.get(paramString + ".iconUrl"));
      this.btnTitle = Util.nullAsNil((String)paramMap.get(paramString + ".btnTitle"));
      this.clickActionInfo = AdClickActionInfo.w(paramMap, paramString);
      this.clickActionInfo.scene = 1;
      AppMethodBeat.o(306611);
    }
  }
  
  public static class a
  {
    public String finderUsername;
    public String hAx;
    public String objectNonceId;
    
    public static a ag(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(306649);
      String str1 = Util.nullAsNil((String)paramMap.get(paramString + ".objectNonceId"));
      String str2 = Util.nullAsNil((String)paramMap.get(paramString + ".finderUsername"));
      paramMap = Util.nullAsNil((String)paramMap.get(paramString + ".exportId"));
      if ((!TextUtils.isEmpty(paramMap)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        paramString = new a();
        paramString.objectNonceId = str1;
        paramString.finderUsername = str2;
        paramString.hAx = paramMap;
        AppMethodBeat.o(306649);
        return paramString;
      }
      AppMethodBeat.o(306649);
      return null;
    }
  }
  
  public static class b
  {
    public String PNb;
    public String QHs;
    public int QHt;
    public String desc;
    public String wtd;
    
    public static b ah(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(306653);
      String str1 = Util.nullAsNil((String)paramMap.get(paramString + ".bgImage"));
      String str2 = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
      String str3 = Util.nullAsNil((String)paramMap.get(paramString + ".descIcon"));
      String str4 = Util.nullAsNil((String)paramMap.get(paramString + ".detectSucIcon"));
      int i = Util.safeParseInt((String)paramMap.get(paramString + ".scanGestureType"));
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)) && (i > 0))
      {
        paramMap = new b();
        paramMap.PNb = str1;
        paramMap.desc = str2;
        paramMap.wtd = str3;
        paramMap.QHs = str4;
        paramMap.QHt = i;
        AppMethodBeat.o(306653);
        return paramMap;
      }
      AppMethodBeat.o(306653);
      return null;
    }
  }
  
  public static class c
  {
    public List<ADXml.d> QHu;
    
    public c()
    {
      AppMethodBeat.i(306630);
      this.QHu = new ArrayList();
      AppMethodBeat.o(306630);
    }
    
    public final c ai(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(306651);
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
          ((ADXml.d)localObject1).QHv = Util.nullAs((String)paramMap.get(str5), "");
          localObject2 = str5 + ".$light_mode_url";
          String str1 = str5 + ".$dark_mode_url";
          String str2 = str5 + ".$tag_light_bg_color";
          String str3 = str5 + ".$tag_dark_bg_color";
          String str4 = str5 + ".$tag_light_name_color";
          str5 = str5 + ".$tag_dark_name_color";
          ((ADXml.d)localObject1).QHw = Util.nullAs((String)paramMap.get(localObject2), "");
          ((ADXml.d)localObject1).QHx = Util.nullAs((String)paramMap.get(str1), "");
          ((ADXml.d)localObject1).QHy = Util.nullAsNil((String)paramMap.get(str2));
          ((ADXml.d)localObject1).QHz = Util.nullAsNil((String)paramMap.get(str3));
          ((ADXml.d)localObject1).QHA = Util.nullAsNil((String)paramMap.get(str4));
          ((ADXml.d)localObject1).QHB = Util.nullAsNil((String)paramMap.get(str5));
          Log.i("MicroMsg.ADXml", "Tag content = ", new Object[] { ((ADXml.d)localObject1).QHv + ", Tag light iconUrl = " + ((ADXml.d)localObject1).QHw + ", Tag dark iconUrl = " + ((ADXml.d)localObject1).QHx + ", Tag background light color = " + ((ADXml.d)localObject1).QHy + ", Tag background dark color = " + ((ADXml.d)localObject1).QHz + ", Tag content light color = " + ((ADXml.d)localObject1).QHA + ", Tag content dark color = " + ((ADXml.d)localObject1).QHB });
          this.QHu.add(localObject1);
        }
        i += 1;
        break;
      }
      label513:
      AppMethodBeat.o(306651);
      return this;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(306634);
      if (this == paramObject)
      {
        AppMethodBeat.o(306634);
        return true;
      }
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        AppMethodBeat.o(306634);
        return false;
      }
      paramObject = (c)paramObject;
      boolean bool = Objects.equals(this.QHu, paramObject.QHu);
      AppMethodBeat.o(306634);
      return bool;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(306643);
      int i = Objects.hash(new Object[] { this.QHu });
      AppMethodBeat.o(306643);
      return i;
    }
  }
  
  public static final class d
  {
    public String QHA;
    public String QHB;
    public String QHv;
    public String QHw;
    public String QHx;
    public String QHy;
    public String QHz;
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(306636);
      if (this == paramObject)
      {
        AppMethodBeat.o(306636);
        return true;
      }
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        AppMethodBeat.o(306636);
        return false;
      }
      paramObject = (d)paramObject;
      if ((Objects.equals(this.QHv, paramObject.QHv)) && (Objects.equals(this.QHw, paramObject.QHw)) && (Objects.equals(this.QHx, paramObject.QHx)) && (Objects.equals(this.QHy, paramObject.QHy)) && (Objects.equals(this.QHz, paramObject.QHz)) && (Objects.equals(this.QHA, paramObject.QHA)) && (Objects.equals(this.QHB, paramObject.QHB)))
      {
        AppMethodBeat.o(306636);
        return true;
      }
      AppMethodBeat.o(306636);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(306642);
      int i = Objects.hash(new Object[] { this.QHv, this.QHw, this.QHx, this.QHy, this.QHz, this.QHA, this.QHB });
      AppMethodBeat.o(306642);
      return i;
    }
  }
  
  public static class e
  {
    public List<ADXml.f> list;
    
    public e()
    {
      AppMethodBeat.i(96262);
      this.list = new LinkedList();
      AppMethodBeat.o(96262);
    }
    
    public final e aj(Map<String, String> paramMap, String paramString)
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
          localf.QHC = Util.nullAs((String)paramMap.get(paramString + ".Wording.zh"), "");
          localf.QBc = Util.nullAs((String)paramMap.get(paramString + ".Wording.en"), "");
          localf.QHD = Util.nullAs((String)paramMap.get(paramString + ".Wording.tw"), "");
          if (localf.QHC.length() + localf.QBc.length() + localf.QHD.length() > 0) {
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
    public String QBc = "";
    public String QHC = "";
    public String QHD = "";
    public String url = "";
  }
  
  public static class g
  {
    public int QHE;
    public int QHF = 30;
    public int QHG;
    public a QHH;
    @p(hkF=1)
    public String QHI;
    public int QHJ;
    @p(hkF=1)
    public String QHK;
    public int QHL;
    @p(hkF=7)
    public az QHM;
    public ADXml.p QHN;
    public String description;
    public String title;
    
    public static final class a
    {
      public String QHO;
      public List<ADXml.g.b> QHP;
      public float TG;
      public int color;
      public long endTime;
      public long startTime;
      
      public a()
      {
        AppMethodBeat.i(306650);
        this.QHP = new ArrayList();
        AppMethodBeat.o(306650);
      }
      
      final void ak(Map<String, String> paramMap, String paramString)
      {
        AppMethodBeat.i(306656);
        int i = 0;
        Object localObject2 = new StringBuilder().append(paramString).append(".pointsItem");
        if (i == 0) {}
        for (Object localObject1 = "";; localObject1 = Integer.valueOf(i))
        {
          localObject1 = localObject1;
          if ((!paramMap.containsKey(localObject1)) || (this.QHP == null)) {
            break label149;
          }
          localObject1 = (String)paramMap.get(localObject1);
          Log.i("MicroMsg.ADXml", "parse points item %s", new Object[] { localObject1 });
          if (!Util.isNullOrNil((String)localObject1))
          {
            localObject2 = new ADXml.g.b();
            ((ADXml.g.b)localObject2).QHO = Util.nullAs((String)localObject1, "");
            this.QHP.add(localObject2);
          }
          i += 1;
          break;
        }
        label149:
        AppMethodBeat.o(306656);
      }
    }
    
    public static final class b
    {
      public String QHO;
    }
  }
  
  public class h
  {
    public String PMU;
    public String QHQ;
    public AdClickActionInfo QHR;
    public AdClickActionInfo QHS;
    
    public h() {}
  }
  
  public static class i
  {
    public int QHE;
    public int QHF = 30;
    public int QHG;
    public int QHU;
    public String QHV;
    public String QHW;
    public String QHX;
    public String bgColor;
    public String description;
    public String title;
  }
  
  public static class j
  {
    public List<ADXml.o> QHY;
    public String adActionLink;
    public String appUserName;
    public String appVersion;
    public String hzy;
    
    public j()
    {
      AppMethodBeat.i(96264);
      this.adActionLink = "";
      this.QHY = new ArrayList();
      AppMethodBeat.o(96264);
    }
    
    public final void al(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(96265);
      this.adActionLink = Util.nullAs((String)paramMap.get(paramString + ".adxml.adTurnActionLink"), "");
      String str = (String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.appUserName");
      if (!TextUtils.isEmpty(str))
      {
        this.appUserName = str;
        this.appVersion = ((String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.appVersion"));
        this.hzy = ((String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.relativePagePath"));
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
          localo.QHE = Util.safeParseInt((String)paramMap.get(paramString + ".displayType"));
          this.QHY.add(localo);
          i += 1;
          break;
        }
        AppMethodBeat.o(96265);
        return;
      }
    }
  }
  
  public static class k
    implements Serializable
  {
    public int QHZ;
    public int QIa;
    public int QIb;
    public boolean QIc;
    public boolean QId;
    public int QhW;
    public int QhX;
    public String desc;
    public String title;
    
    public static k am(Map<String, String> paramMap, String paramString)
    {
      boolean bool2 = true;
      AppMethodBeat.i(306618);
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
            paramString.QHZ = k;
            paramString.QIa = m;
            paramString.QhW = i;
            paramString.QhX = j;
            paramString.QIb = n;
            paramString.title = str;
            paramString.desc = paramMap;
            if (i1 == 1)
            {
              bool1 = true;
              paramString.QIc = bool1;
              if (i2 != 1) {
                break label451;
              }
            }
            for (boolean bool1 = bool2;; bool1 = false)
            {
              paramString.QId = bool1;
              AppMethodBeat.o(306618);
              return paramString;
              bool1 = false;
              break;
            }
          }
          AppMethodBeat.o(306618);
          return null;
        }
      }
    }
    
    public String toString()
    {
      AppMethodBeat.i(306622);
      String str = "{twistStartTime=" + this.QHZ + ", twistEndTime=" + this.QIa + ", coverStartTime=" + this.QhW + ", coverEndTime=" + this.QhX + ", maxDegree=" + this.QIb + ", isClockWise=" + this.QIc + ", title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + '}';
      AppMethodBeat.o(306622);
      return str;
    }
  }
  
  public class l
  {
    public String QIe;
    public String QIf;
    public ArrayList<ADXml.m> QIg;
    
    public l()
    {
      AppMethodBeat.i(96266);
      this.QIe = "";
      this.QIf = "";
      this.QIg = new ArrayList();
      AppMethodBeat.o(96266);
    }
    
    public final String ala(int paramInt)
    {
      AppMethodBeat.i(96267);
      if ((paramInt >= 0) && (paramInt < this.QIg.size()))
      {
        String str = ((ADXml.m)this.QIg.get(paramInt)).QIi;
        AppMethodBeat.o(96267);
        return str;
      }
      AppMethodBeat.o(96267);
      return "";
    }
    
    public final String alb(int paramInt)
    {
      AppMethodBeat.i(96268);
      if ((paramInt >= 0) && (paramInt < this.QIg.size()))
      {
        String str = ((ADXml.m)this.QIg.get(paramInt)).title;
        AppMethodBeat.o(96268);
        return str;
      }
      AppMethodBeat.o(96268);
      return "";
    }
  }
  
  public final class m
  {
    public String ICb = "";
    public String QIh = "";
    public String QIi = "";
    public String id = "";
    public String svG = "";
    public String title = "";
    
    public m() {}
  }
  
  public static final class o
  {
    public int QHE = 0;
    public String desc;
    public String title;
  }
  
  public static final class p
  {
    public int PMu;
    public int PMv;
    public int PMw;
    public String PMx;
    public int QIj;
    public int QIk;
    public int QIl;
    public int QIm;
    
    public static p ao(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(306624);
      if (paramMap.containsKey(paramString))
      {
        p localp = new p();
        localp.QIj = Util.safeParseInt((String)paramMap.get(paramString + ".pressStartTime"));
        localp.QIk = Util.safeParseInt((String)paramMap.get(paramString + ".pressEndTime"));
        localp.QIl = Util.safeParseInt((String)paramMap.get(paramString + ".pressDuration"));
        localp.PMx = Util.nullAsNil((String)paramMap.get(paramString + ".spriteImageUrl"));
        localp.PMu = Util.safeParseInt((String)paramMap.get(paramString + ".spriteType"));
        localp.PMv = Util.safeParseInt((String)paramMap.get(paramString + ".spriteSizeType"));
        localp.PMw = Util.safeParseInt((String)paramMap.get(paramString + ".spriteDuration"));
        localp.QIm = Util.safeParseInt((String)paramMap.get(paramString + ".minimumPressDuration"));
        if (localp.PMw == 0) {
          localp.PMw = 4000;
        }
        if (localp.QIm == 0) {
          localp.QIm = 500;
        }
        AppMethodBeat.o(306624);
        return localp;
      }
      AppMethodBeat.o(306624);
      return null;
    }
  }
  
  public static class q
  {
    public int PLo;
    public String appUserName;
    public String appVersion;
    public String hzy;
    
    public static q ap(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(306628);
      String str1 = Util.nullAsNil((String)paramMap.get(paramString + ".appUserName"));
      String str2 = Util.nullAsNil((String)paramMap.get(paramString + ".relativePagePath"));
      String str3 = Util.nullAsNil((String)paramMap.get(paramString + ".appVersion"));
      int i = Util.safeParseInt((String)paramMap.get(paramString + ".miniProgramType"));
      if (!TextUtils.isEmpty(str1))
      {
        paramMap = new q();
        paramMap.appUserName = str1;
        paramMap.hzy = str2;
        paramMap.appVersion = str3;
        paramMap.PLo = i;
        AppMethodBeat.o(306628);
        return paramMap;
      }
      AppMethodBeat.o(306628);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.ADXml
 * JD-Core Version:    0.7.0.1
 */
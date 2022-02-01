package com.tencent.mm.plugin.sns.storage;

import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.adxml.b;
import com.tencent.mm.plugin.sns.ad.adxml.c;
import com.tencent.mm.plugin.sns.ad.adxml.d;
import com.tencent.mm.plugin.sns.ad.adxml.f;
import com.tencent.mm.plugin.sns.ad.adxml.g;
import com.tencent.mm.plugin.sns.ad.adxml.h;
import com.tencent.mm.plugin.sns.ad.adxml.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.ui.ay;
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
  public int adActionLinkHidden;
  public String adActionLinkIcon;
  public String adActionLinkName;
  public String adActionLinkTitle_cn;
  public String adActionLinkTitle_en;
  public String adActionLinkTitle_tw;
  public String adActionTitle;
  public Map<String, String> adArgs;
  public com.tencent.mm.plugin.sns.ad.adxml.a adAvatarFinderTopicInfo;
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
  public c adFinderLiveInfo;
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
  public com.tencent.mm.plugin.sns.ad.widget.shakead.a adShakeInfo;
  public j adSliderFullCardInfo;
  public i adSphereCardInfo;
  public com.tencent.mm.plugin.sns.ad.adxml.k adTagBtnInfo;
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
    AppMethodBeat.i(195669);
    if ((!Util.isNullOrNil(paramString)) && (paramString.trim().startsWith("<RecXml")))
    {
      feedRecXml(paramString);
      AppMethodBeat.o(195669);
      return;
    }
    feedAdXml(paramString);
    AppMethodBeat.o(195669);
  }
  
  private void feedAdXml(String paramString)
  {
    AppMethodBeat.i(195674);
    feedXml(paramString, "", "adxml");
    AppMethodBeat.o(195674);
  }
  
  private void feedRecXml(String paramString)
  {
    AppMethodBeat.i(195672);
    paramString = feedXml(paramString, ".RecXml", "RecXml");
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      this.recType = Util.safeParseInt((String)paramString.get(".RecXml.$type"));
      this.recSrc = Util.safeParseInt((String)paramString.get(".RecXml.$source"));
      this.recExpId = Util.safeParseInt((String)paramString.get(".RecXml.$expId"));
      this.originSnsId = t.aZs((String)paramString.get(".RecXml.$expOriginSnsId"));
    }
    AppMethodBeat.o(195672);
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
      this.adCardTagInfo = new c().R(paramString3, str);
      this.adCard3dHeadTitle = Util.nullAsNil((String)paramString3.get(str + ".adxml.adCardInfo.adRatingCardInfo.headTitle"));
      this.adCard3dHeadUrl = Util.nullAsNil((String)paramString3.get(str + ".adxml.adCardInfo.adRatingCardInfo.headUrl"));
      paramString1 = Util.nullAs((String)paramString3.get(str + ".adxml.adSelectInfo.leftBtnTitle"), "");
      paramString2 = Util.nullAs((String)paramString3.get(str + ".adxml.adSelectInfo.rightBtnTitle"), "");
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        this.adSelectInfo = new h();
        this.adSelectInfo.JyA = paramString1;
        this.adSelectInfo.KjU = paramString2;
      }
      paramString1 = Util.nullAs((String)paramString3.get(str + ".adxml.adVoteInfo.componentUrl"), "");
      if (TextUtils.isEmpty(paramString1)) {
        break label2710;
      }
      this.adVoteInfo = new l();
      this.adVoteInfo.Kkg = paramString1;
      this.adVoteInfo.Kkh = Util.nullAs((String)paramString3.get(str + ".adxml.adVoteInfo.voteLabel"), "");
      paramString2 = str + ".adxml.adVoteInfo.optionList.option";
      i = 0;
      label2373:
      if (i == 0) {
        break label5565;
      }
    }
    label2710:
    label4280:
    label5565:
    for (paramString1 = paramString2 + i;; paramString1 = paramString2)
    {
      if (!TextUtils.isEmpty(Util.nullAs((String)paramString3.get(paramString1 + ".title"), "")))
      {
        localObject1 = new m();
        ((m)localObject1).title = Util.nullAs((String)paramString3.get(paramString1 + ".title"), "");
        ((m)localObject1).pqW = Util.nullAs((String)paramString3.get(paramString1 + ".shareTitle"), "");
        ((m)localObject1).CHR = Util.nullAs((String)paramString3.get(paramString1 + ".shareDesc"), "");
        ((m)localObject1).Kkj = Util.nullAs((String)paramString3.get(paramString1 + ".shareThumb"), "");
        ((m)localObject1).Kkk = Util.nullAs((String)paramString3.get(paramString1 + ".selectedTitle"), "");
        ((m)localObject1).id = Util.nullAs((String)paramString3.get(paramString1 + ".id"), "");
        this.adVoteInfo.Kki.add(localObject1);
        i += 1;
        break label2373;
        bool = false;
        break;
      }
      this.bTurnLandingPagesAd = paramString3.containsKey(str + ".adxml.adTurnCanvasInfo");
      this.adTurnInfo = new j();
      this.adTurnInfo.U(paramString3, str);
      this.adFeedbackInfo = new e().S(paramString3, str);
      if (this.adContentStyle == 3)
      {
        this.adFullCardInfo = new g();
        paramString2 = str + ".adxml.adFullCardInfo";
        paramString1 = this.adFullCardInfo;
        paramString1.KjH = Util.safeParseInt((String)paramString3.get(paramString2 + ".displayType"));
        paramString1.title = Util.nullAsNil((String)paramString3.get(paramString2 + ".title"));
        paramString1.description = Util.nullAsNil((String)paramString3.get(paramString2 + ".description"));
        paramString1.KjI = Util.getInt((String)paramString3.get(paramString2 + ".markMaxAlpha"), 30);
        paramString1.KjJ = Util.safeParseInt((String)paramString3.get(paramString2 + ".titlePosition"));
        paramString1.KjL = Util.nullAsNil((String)paramString3.get(paramString2 + ".maskImg"));
        paramString1.KjM = Util.safeParseInt((String)paramString3.get(paramString2 + ".maskImgDisappearTime"));
        paramString1.KjN = Util.nullAsNil((String)paramString3.get(paramString2 + ".coverImg"));
        paramString1.KjO = Util.safeParseInt((String)paramString3.get(paramString2 + ".coverImgAppearTime"));
        localObject1 = (String)paramString3.get(paramString2 + ".adGestureInfo.points");
        localObject2 = paramString2 + ".adGestureInfo.pointsList";
        if ((!Util.isNullOrNil((String)localObject1)) || (paramString3.containsKey(localObject2)))
        {
          paramString1.KjK = new ADXml.g.a();
          paramString1.KjK.color = -1;
          paramString1.KjK.startTime = Util.safeParseInt((String)paramString3.get(paramString2 + ".adGestureInfo.startTime"));
          paramString1.KjK.endTime = Util.safeParseInt((String)paramString3.get(paramString2 + ".adGestureInfo.endTime"));
          paramString1.KjK.KjR = Util.safeParseFloat((String)paramString3.get(paramString2 + ".adGestureInfo.distance"));
          paramString1.KjK.color = Color.parseColor(Util.nullAsNil((String)paramString3.get(paramString2 + ".adGestureInfo.color")));
          paramString1.KjK.KjS = Util.nullAsNil((String)paramString3.get(paramString2 + ".adGestureInfo.points"));
          if (paramString3.containsKey(localObject2)) {
            paramString1.KjK.T(paramString3, (String)localObject2);
          }
        }
        localObject1 = paramString2 + ".endCoverInfo";
        if (paramString3.containsKey(localObject1))
        {
          paramString1.KjP = new ay();
          paramString1.KjP.title = Util.nullAsNil((String)paramString3.get((String)localObject1 + ".title"));
          paramString1.KjP.desc = Util.nullAsNil((String)paramString3.get((String)localObject1 + ".description"));
          paramString1.KjP.KKL = Util.nullAsNil((String)paramString3.get((String)localObject1 + ".actionTitle"));
          paramString1.KjP.coverImgUrl = Util.nullAsNil((String)paramString3.get((String)localObject1 + ".ambientImageUrl"));
          paramString1.KjP.KKK = Util.nullAsNil((String)paramString3.get((String)localObject1 + ".titleImageUrl"));
          paramString1.KjP.duration = Util.safeParseInt((String)paramString3.get((String)localObject1 + ".endCoverEndTime"));
        }
        paramString2 = paramString2 + ".adLongPressGestureInfo";
        if (paramString3.containsKey(paramString2))
        {
          paramString1.KjQ = new p();
          paramString1.KjQ.Kkl = Util.safeParseInt((String)paramString3.get(paramString2 + ".pressStartTime"));
          paramString1.KjQ.Kkm = Util.safeParseInt((String)paramString3.get(paramString2 + ".pressEndTime"));
          paramString1.KjQ.Kkn = Util.safeParseInt((String)paramString3.get(paramString2 + ".pressDuration"));
          paramString1.KjQ.Kko = Util.nullAsNil((String)paramString3.get(paramString2 + ".spriteImageUrl"));
          paramString1.KjQ.Kkp = Util.safeParseInt((String)paramString3.get(paramString2 + ".spriteType"));
        }
        this.clientMinVersion = Util.safeParseInt((String)paramString3.get(str + ".adxml.compatible.clientVersion.androidMin"));
        this.clientMaxVersion = Util.safeParseInt((String)paramString3.get(str + ".adxml.compatible.clientVersion.androidMax"));
        this.compatibleUrl = Util.nullAsNil((String)paramString3.get(str + ".adxml.compatible.jumpUrl"));
        paramString1 = str + ".adxml.adCardInfo.adCardButton";
        if (paramString3.containsKey(paramString1))
        {
          this.adCardActionBtnInfo = new AdCardActionBtnInfo();
          this.adCardActionBtnInfo.parse(paramString3, paramString1);
          if (!TextUtils.isEmpty(this.adCardActionBtnInfo.clickActionInfo.JxN))
          {
            this.firstDownloadApkPkgName = this.adCardActionBtnInfo.clickActionInfo.JxN;
            Log.i("MicroMsg.ADXml", "findDownloadApkPkgName, adCardActionBtnInfo.pkg=" + this.adCardActionBtnInfo.clickActionInfo.JxN);
          }
        }
        if (TextUtils.isEmpty(this.firstDownloadApkPkgName)) {
          findDownloadApkPkgName(paramString3);
        }
        this.adExtInfo = com.tencent.mm.plugin.sns.data.k.aYR((String)paramString3.get(str + ".adxml.adExtInfo"));
      }
      try
      {
        paramString1 = com.tencent.mm.plugin.sns.device.appstore.a.c(MMApplicationContext.getContext(), paramString3);
        if (paramString1 != null) {
          this.appMarketIntent = paramString1.fNs();
        }
      }
      catch (Throwable paramString1)
      {
        break label4280;
      }
      this.adScanJumpInfo = b.Q(paramString3, str + ".adxml.adScanInfo");
      this.adFloatWebViewInfo = ADXml.n.W(paramString3, str + ".adxml.adCanvasInfo.globalComponentItems.componentItem");
      this.adFinderInfo = a.P(paramString3, str + ".adxml.adFinderInfo");
      this.addPlayIconOnCover = Util.safeParseInt((String)paramString3.get(str + ".adxml.addPlayIconOnCover"));
      this.adTwistInfo = k.V(paramString3, str + ".adxml.adTwistInfo");
      this.adShakeInfo = com.tencent.mm.plugin.sns.ad.widget.shakead.a.M(paramString3, str + ".adxml.adShakeInfo");
      this.verticalVideoDisplayType = Util.safeParseInt((String)paramString3.get(str + ".adxml.verticalVideoDisplayType"));
      this.weAppInfo = q.X(paramString3, str + ".adxml.headWeAppInfo");
      if (Util.safeParseInt((String)paramString3.get(str + ".adxml.forbiddenCustomAnimation")) == 1)
      {
        bool = true;
        label4568:
        this.forbiddenCustomAnimation = bool;
        this.adPromotionInfo = h.F(paramString3, str + ".adxml.adCardInfo.promotionInfo");
        this.adLiveInfo = g.C(paramString3, str + ".adxml.adLiveInfo");
        this.adFinderLiveInfo = c.w(paramString3, str + ".adxml.adFinderLiveInfo");
        this.adHeadFinderProfile = f.B(paramString3, str + ".adxml.headFinderProfile");
        this.adFinderTopicInfo = d.x(paramString3, str + ".adxml.adFinderTopicInfo");
        this.adAvatarFinderTopicInfo = com.tencent.mm.plugin.sns.ad.adxml.a.s(paramString3, str + ".adxml.headFinderTopicInfo");
        if (Util.safeParseInt((String)paramString3.get(str + ".adxml.preloadWeAppPkg")) != 1) {
          break label5549;
        }
        bool = true;
        this.preloadWeAppPkg = bool;
        if (Util.safeParseInt((String)paramString3.get(str + ".adxml.adVideoContinuePlay")) != 1) {
          break label5555;
        }
      }
      for (bool = true;; bool = false)
      {
        this.adVideoContinuePlay = bool;
        this.adDynamicUpdateInfo = b.u(paramString3, str + ".adxml.adDynamicUpdateInfo");
        this.feedbackWording = Util.nullAsNil((String)paramString3.get(str + ".adxml.feedbackWording"));
        this.feedbackWeAppUsername = Util.nullAsNil((String)paramString3.get(str + ".adxml.feedbackWeAppUsername"));
        this.feedbackWeAppPath = Util.nullAsNil((String)paramString3.get(str + ".adxml.feedbackWeAppPath"));
        paramString1 = str + ".adxml.tagButtonInfo";
        if (paramString3.containsKey(paramString1)) {
          this.adTagBtnInfo = com.tencent.mm.plugin.sns.ad.adxml.k.J(paramString3, paramString1);
        }
        this.appGiftPackCode = Util.nullAsNil((String)paramString3.get(str + ".adxml.appGiftPackCode"));
        this.appGiftPackCodeTips = Util.nullAsNil((String)paramString3.get(str + ".adxml.appGiftPackCodeTips"));
        this.adSliderFullCardInfo = j.H(paramString3, str + ".adxml.adSliderCardInfo");
        AppMethodBeat.o(96270);
        return paramString3;
        if (this.adContentStyle != 4) {
          break;
        }
        this.adSphereCardInfo = new i();
        paramString1 = str + ".adxml.adSphereCardInfo";
        paramString2 = this.adSphereCardInfo;
        paramString2.KjH = Util.safeParseInt((String)paramString3.get(paramString1 + ".displayType"));
        paramString2.title = Util.nullAsNil((String)paramString3.get(paramString1 + ".title"));
        paramString2.description = Util.nullAsNil((String)paramString3.get(paramString1 + ".description"));
        paramString2.KjI = Util.getInt((String)paramString3.get(paramString1 + ".markMaxAlpha"), 30);
        paramString2.KjJ = Util.safeParseInt((String)paramString3.get(paramString1 + ".titlePosition"));
        paramString2.KjW = Util.safeParseInt((String)paramString3.get(paramString1 + ".gestureDelayTime"));
        paramString2.KjY = Util.nullAsNil((String)paramString3.get(paramString1 + ".sphereThumbUrl"));
        paramString2.bgColor = Util.nullAsNil((String)paramString3.get(paramString1 + ".bgColor"));
        paramString2.KjZ = Util.nullAsNil((String)paramString3.get(paramString1 + ".bgColorAlpha"));
        paramString2.KjX = Util.nullAsNil((String)paramString3.get(paramString1 + ".sphereImageUrl"));
        break;
        bool = false;
        break label4568;
        bool = false;
        break label4788;
      }
    }
  }
  
  public static String getGestureCanvasInfo(String paramString)
  {
    AppMethodBeat.i(195769);
    if (paramString.contains("<adFullCardGestureCanvasInfo>")) {}
    for (paramString = paramString.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adFullCardGestureCanvasInfo", "adCanvasInfo");; paramString = "")
    {
      AppMethodBeat.o(195769);
      return paramString;
    }
  }
  
  public static boolean isShakeAdCanvas(String paramString)
  {
    AppMethodBeat.i(195777);
    if ((paramString != null) && (paramString.contains("<isShakeAnimView>1</isShakeAnimView>")))
    {
      AppMethodBeat.o(195777);
      return true;
    }
    AppMethodBeat.o(195777);
    return false;
  }
  
  public static boolean isTwistAdCanvas(String paramString)
  {
    AppMethodBeat.i(195776);
    if ((paramString != null) && (paramString.contains("<isTwistAnimView>1</isTwistAnimView>")))
    {
      AppMethodBeat.o(195776);
      return true;
    }
    AppMethodBeat.o(195776);
    return false;
  }
  
  public void findDownloadApkPkgName(Map<String, String> paramMap)
  {
    AppMethodBeat.i(195774);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(195774);
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
          AppMethodBeat.o(195774);
          return;
        }
      }
    }
    AppMethodBeat.o(195774);
  }
  
  public String getAdVoteComponentUrl()
  {
    AppMethodBeat.i(96273);
    if (hasVoteInfo())
    {
      String str = this.adVoteInfo.Kkg;
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
      str = this.adSelectInfo.JyA;
      AppMethodBeat.o(96271);
      return str;
    }
    if (hasVoteInfo())
    {
      str = ((m)this.adVoteInfo.Kki.get(0)).title;
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
      str = this.adSelectInfo.KjU;
      AppMethodBeat.o(96272);
      return str;
    }
    if (hasVoteInfo())
    {
      str = ((m)this.adVoteInfo.Kki.get(1)).title;
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
    return (this.adCardActionBtnInfo != null) && (this.adCardActionBtnInfo.clickActionInfo.Jxx >= 0);
  }
  
  public boolean hasSelectInfo()
  {
    return this.adSelectInfo != null;
  }
  
  public boolean hasVoteInfo()
  {
    AppMethodBeat.i(96275);
    if ((this.adVoteInfo != null) && (this.adVoteInfo.Kki.size() > 1))
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
  
  public boolean isGestureAd()
  {
    AppMethodBeat.i(195756);
    if ((isFullCardAd()) && (this.adFullCardInfo != null) && (this.adFullCardInfo.KjK != null) && (this.adFullCardInfo.KjK.startTime >= 0L) && (this.adFullCardInfo.KjK.endTime > this.adFullCardInfo.KjK.startTime))
    {
      AppMethodBeat.o(195756);
      return true;
    }
    AppMethodBeat.o(195756);
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
    AppMethodBeat.i(195750);
    if ((isFullCardAd()) && (this.adFullCardInfo != null) && (this.adFullCardInfo.KjQ != null) && (this.adFullCardInfo.KjQ.Kkl > 0) && (this.adFullCardInfo.KjQ.Kkm > this.adFullCardInfo.KjQ.Kkl))
    {
      AppMethodBeat.o(195750);
      return true;
    }
    AppMethodBeat.o(195750);
    return false;
  }
  
  public boolean isNewStyleVote()
  {
    AppMethodBeat.i(96274);
    if ((this.adVoteInfo != null) && (this.adVoteInfo.Kki.size() > 1) && (!TextUtils.isEmpty(((m)this.adVoteInfo.Kki.get(0)).id)) && (!TextUtils.isEmpty(((m)this.adVoteInfo.Kki.get(1)).id)))
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
    AppMethodBeat.i(195752);
    if ((isFullCardAd()) && (this.adShakeInfo != null))
    {
      AppMethodBeat.o(195752);
      return true;
    }
    AppMethodBeat.o(195752);
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
    AppMethodBeat.i(195751);
    if ((isFullCardAd()) && (this.adTwistInfo != null))
    {
      AppMethodBeat.o(195751);
      return true;
    }
    AppMethodBeat.o(195751);
    return false;
  }
  
  @Keep
  public static class AdCardActionBtnInfo
  {
    public String btnTitle;
    public AdClickActionInfo clickActionInfo;
    public String iconUrl;
    
    public void parse(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(226415);
      this.iconUrl = Util.nullAsNil((String)paramMap.get(paramString + ".iconUrl"));
      this.btnTitle = Util.nullAsNil((String)paramMap.get(paramString + ".btnTitle"));
      this.clickActionInfo = AdClickActionInfo.t(paramMap, paramString);
      this.clickActionInfo.scene = 1;
      AppMethodBeat.o(226415);
    }
  }
  
  public static class a
  {
    public String finderUsername;
    public String fwa;
    public String objectNonceId;
    
    public static a P(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(223520);
      String str1 = Util.nullAsNil((String)paramMap.get(paramString + ".objectNonceId"));
      String str2 = Util.nullAsNil((String)paramMap.get(paramString + ".finderUsername"));
      paramMap = Util.nullAsNil((String)paramMap.get(paramString + ".exportId"));
      if ((!TextUtils.isEmpty(paramMap)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        paramString = new a();
        paramString.objectNonceId = str1;
        paramString.finderUsername = str2;
        paramString.fwa = paramMap;
        AppMethodBeat.o(223520);
        return paramString;
      }
      AppMethodBeat.o(223520);
      return null;
    }
  }
  
  public static class b
  {
    public String JyG;
    public String Kjv;
    public int Kjw;
    public String desc;
    public String toE;
    
    public static b Q(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(223625);
      String str1 = Util.nullAsNil((String)paramMap.get(paramString + ".bgImage"));
      String str2 = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
      String str3 = Util.nullAsNil((String)paramMap.get(paramString + ".descIcon"));
      String str4 = Util.nullAsNil((String)paramMap.get(paramString + ".detectSucIcon"));
      int i = Util.safeParseInt((String)paramMap.get(paramString + ".scanGestureType"));
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)) && (i > 0))
      {
        paramMap = new b();
        paramMap.JyG = str1;
        paramMap.desc = str2;
        paramMap.toE = str3;
        paramMap.Kjv = str4;
        paramMap.Kjw = i;
        AppMethodBeat.o(223625);
        return paramMap;
      }
      AppMethodBeat.o(223625);
      return null;
    }
  }
  
  public static class c
  {
    public List<ADXml.d> Kjx;
    
    public c()
    {
      AppMethodBeat.i(202008);
      this.Kjx = new ArrayList();
      AppMethodBeat.o(202008);
    }
    
    public final c R(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(202032);
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
          ((ADXml.d)localObject1).Kjy = Util.nullAs((String)paramMap.get(str5), "");
          localObject2 = str5 + ".$light_mode_url";
          String str1 = str5 + ".$dark_mode_url";
          String str2 = str5 + ".$tag_light_bg_color";
          String str3 = str5 + ".$tag_dark_bg_color";
          String str4 = str5 + ".$tag_light_name_color";
          str5 = str5 + ".$tag_dark_name_color";
          ((ADXml.d)localObject1).Kjz = Util.nullAs((String)paramMap.get(localObject2), "");
          ((ADXml.d)localObject1).KjA = Util.nullAs((String)paramMap.get(str1), "");
          ((ADXml.d)localObject1).KjB = Util.nullAsNil((String)paramMap.get(str2));
          ((ADXml.d)localObject1).KjC = Util.nullAsNil((String)paramMap.get(str3));
          ((ADXml.d)localObject1).KjD = Util.nullAsNil((String)paramMap.get(str4));
          ((ADXml.d)localObject1).KjE = Util.nullAsNil((String)paramMap.get(str5));
          Log.i("MicroMsg.ADXml", "Tag content = ", new Object[] { ((ADXml.d)localObject1).Kjy + ", Tag light iconUrl = " + ((ADXml.d)localObject1).Kjz + ", Tag dark iconUrl = " + ((ADXml.d)localObject1).KjA + ", Tag background light color = " + ((ADXml.d)localObject1).KjB + ", Tag background dark color = " + ((ADXml.d)localObject1).KjC + ", Tag content light color = " + ((ADXml.d)localObject1).KjD + ", Tag content dark color = " + ((ADXml.d)localObject1).KjE });
          this.Kjx.add(localObject1);
        }
        i += 1;
        break;
      }
      label513:
      AppMethodBeat.o(202032);
      return this;
    }
  }
  
  public static final class d
  {
    public String KjA;
    public String KjB;
    public String KjC;
    public String KjD;
    public String KjE;
    public String Kjy;
    public String Kjz;
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
    
    public final e S(Map<String, String> paramMap, String paramString)
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
          localf.KjF = Util.nullAs((String)paramMap.get(paramString + ".Wording.zh"), "");
          localf.Kdw = Util.nullAs((String)paramMap.get(paramString + ".Wording.en"), "");
          localf.KjG = Util.nullAs((String)paramMap.get(paramString + ".Wording.tw"), "");
          if (localf.KjF.length() + localf.Kdw.length() + localf.KjG.length() > 0) {
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
    public String Kdw = "";
    public String KjF = "";
    public String KjG = "";
    public String url = "";
  }
  
  public static class g
  {
    public int KjH;
    public int KjI = 30;
    public int KjJ;
    public a KjK;
    public String KjL;
    public int KjM;
    public String KjN;
    public int KjO;
    public ay KjP;
    public ADXml.p KjQ;
    public String description;
    public String title;
    
    public static final class a
    {
      public float KjR;
      public String KjS;
      public List<ADXml.g.b> KjT;
      public int color;
      public long endTime;
      public long startTime;
      
      public a()
      {
        AppMethodBeat.i(269345);
        this.KjT = new ArrayList();
        AppMethodBeat.o(269345);
      }
      
      final void T(Map<String, String> paramMap, String paramString)
      {
        AppMethodBeat.i(269347);
        int i = 0;
        Object localObject2 = new StringBuilder().append(paramString).append(".pointsItem");
        if (i == 0) {}
        for (Object localObject1 = "";; localObject1 = Integer.valueOf(i))
        {
          localObject1 = localObject1;
          if ((!paramMap.containsKey(localObject1)) || (this.KjT == null)) {
            break label149;
          }
          localObject1 = (String)paramMap.get(localObject1);
          Log.i("MicroMsg.ADXml", "parse points item %s", new Object[] { localObject1 });
          if (!Util.isNullOrNil((String)localObject1))
          {
            localObject2 = new ADXml.g.b();
            ((ADXml.g.b)localObject2).KjS = Util.nullAs((String)localObject1, "");
            this.KjT.add(localObject2);
          }
          i += 1;
          break;
        }
        label149:
        AppMethodBeat.o(269347);
      }
    }
    
    public static final class b
    {
      public String KjS;
    }
  }
  
  public class h
  {
    public String JyA;
    public String KjU;
    
    public h() {}
  }
  
  public static class i
  {
    public int KjH;
    public int KjI = 30;
    public int KjJ;
    public int KjW;
    public String KjX;
    public String KjY;
    public String KjZ;
    public String bgColor;
    public String description;
    public String title;
  }
  
  public static class j
  {
    public List<ADXml.o> Kka;
    public String adActionLink;
    public String appUserName;
    public String appVersion;
    public String fve;
    
    public j()
    {
      AppMethodBeat.i(96264);
      this.adActionLink = "";
      this.Kka = new ArrayList();
      AppMethodBeat.o(96264);
    }
    
    public final void U(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(96265);
      this.adActionLink = Util.nullAs((String)paramMap.get(paramString + ".adxml.adTurnActionLink"), "");
      String str = (String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.appUserName");
      if (!TextUtils.isEmpty(str))
      {
        this.appUserName = str;
        this.appVersion = ((String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.appVersion"));
        this.fve = ((String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.relativePagePath"));
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
          localo.KjH = Util.safeParseInt((String)paramMap.get(paramString + ".displayType"));
          this.Kka.add(localo);
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
    public int JNw;
    public int JNx;
    public int Kkb;
    public int Kkc;
    public int Kkd;
    public boolean Kke;
    public boolean Kkf;
    public String desc;
    public String title;
    
    public static k V(Map<String, String> paramMap, String paramString)
    {
      boolean bool2 = true;
      AppMethodBeat.i(205762);
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
            paramString.Kkb = k;
            paramString.Kkc = m;
            paramString.JNw = i;
            paramString.JNx = j;
            paramString.Kkd = n;
            paramString.title = str;
            paramString.desc = paramMap;
            if (i1 == 1)
            {
              bool1 = true;
              paramString.Kke = bool1;
              if (i2 != 1) {
                break label451;
              }
            }
            for (boolean bool1 = bool2;; bool1 = false)
            {
              paramString.Kkf = bool1;
              AppMethodBeat.o(205762);
              return paramString;
              bool1 = false;
              break;
            }
          }
          AppMethodBeat.o(205762);
          return null;
        }
      }
    }
    
    public String toString()
    {
      AppMethodBeat.i(205763);
      String str = "{twistStartTime=" + this.Kkb + ", twistEndTime=" + this.Kkc + ", coverStartTime=" + this.JNw + ", coverEndTime=" + this.JNx + ", maxDegree=" + this.Kkd + ", isClockWise=" + this.Kke + ", title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + '}';
      AppMethodBeat.o(205763);
      return str;
    }
  }
  
  public class l
  {
    public String Kkg;
    public String Kkh;
    public ArrayList<ADXml.m> Kki;
    
    public l()
    {
      AppMethodBeat.i(96266);
      this.Kkg = "";
      this.Kkh = "";
      this.Kki = new ArrayList();
      AppMethodBeat.o(96266);
    }
    
    public final String agi(int paramInt)
    {
      AppMethodBeat.i(96267);
      if ((paramInt >= 0) && (paramInt < this.Kki.size()))
      {
        String str = ((ADXml.m)this.Kki.get(paramInt)).Kkk;
        AppMethodBeat.o(96267);
        return str;
      }
      AppMethodBeat.o(96267);
      return "";
    }
    
    public final String agj(int paramInt)
    {
      AppMethodBeat.i(96268);
      if ((paramInt >= 0) && (paramInt < this.Kki.size()))
      {
        String str = ((ADXml.m)this.Kki.get(paramInt)).title;
        AppMethodBeat.o(96268);
        return str;
      }
      AppMethodBeat.o(96268);
      return "";
    }
  }
  
  public final class m
  {
    public String CHR = "";
    public String Kkj = "";
    public String Kkk = "";
    public String id = "";
    public String pqW = "";
    public String title = "";
    
    public m() {}
  }
  
  public static final class o
  {
    public int KjH = 0;
    public String desc;
    public String title;
  }
  
  public static final class p
  {
    public int Kkl;
    public int Kkm;
    public int Kkn;
    public String Kko;
    public int Kkp;
  }
  
  public static class q
  {
    public int Jxz;
    public String appUserName;
    public String appVersion;
    public String fve;
    
    public static q X(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(270535);
      String str1 = Util.nullAsNil((String)paramMap.get(paramString + ".appUserName"));
      String str2 = Util.nullAsNil((String)paramMap.get(paramString + ".relativePagePath"));
      String str3 = Util.nullAsNil((String)paramMap.get(paramString + ".appVersion"));
      int i = Util.safeParseInt((String)paramMap.get(paramString + ".miniProgramType"));
      if (!TextUtils.isEmpty(str1))
      {
        paramMap = new q();
        paramMap.appUserName = str1;
        paramMap.fve = str2;
        paramMap.appVersion = str3;
        paramMap.Jxz = i;
        AppMethodBeat.o(270535);
        return paramMap;
      }
      AppMethodBeat.o(270535);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.ADXml
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.textstatus.ui;

import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ad;
import com.tencent.mm.ay.r;
import com.tencent.mm.ay.r.a;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.f.a.ye;
import com.tencent.mm.f.a.ye.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.v;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.plugin.finder.utils.ac.a;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.SnsLabelUI;
import com.tencent.mm.plugin.textstatus.a.q.a;
import com.tencent.mm.plugin.textstatus.b.b;
import com.tencent.mm.plugin.textstatus.b.c;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.b.g;
import com.tencent.mm.plugin.textstatus.b.h;
import com.tencent.mm.plugin.textstatus.emoji.TextStatusEmojiView;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.proto.al;
import com.tencent.mm.plugin.textstatus.proto.am;
import com.tencent.mm.plugin.thumbplayer.view.MMTPEffectVideoLayout;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.vfs.u;
import com.tencent.mm.videocomposition.effect.EffectRenderView;
import com.tencent.mm.view.MaxHeightScrollView;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(32)
@com.tencent.mm.ui.widget.pulldown.c(0)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "Lcom/tencent/mm/plugin/textstatus/emoji/ITextStatusEmojiActionListener;", "()V", "animator_move_to_below", "Landroid/animation/ObjectAnimator;", "animator_move_to_up", "btnBack", "Landroid/view/View;", "getBtnBack", "()Landroid/view/View;", "setBtnBack", "(Landroid/view/View;)V", "btnEditFinish", "Landroid/widget/Button;", "getBtnEditFinish", "()Landroid/widget/Button;", "setBtnEditFinish", "(Landroid/widget/Button;)V", "btnOk", "getBtnOk", "setBtnOk", "btnTag", "getBtnTag", "setBtnTag", "cameraClickListener", "Landroid/view/View$OnClickListener;", "configUpdateListener", "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$configUpdateListener$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$configUpdateListener$1;", "curLocalMediaStruct", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$MediaStruct;", "getCurLocalMediaStruct", "()Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$MediaStruct;", "setCurLocalMediaStruct", "(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$MediaStruct;)V", "curMode", "", "getCurMode", "()I", "setCurMode", "(I)V", "curTextStatusExtInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;", "getCurTextStatusExtInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;", "setCurTextStatusExtInfo", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;)V", "defaultBackgroundImgId", "editLayout", "getEditLayout", "setEditLayout", "emojiContainer", "Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView;", "getEmojiContainer", "()Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView;", "emojiContainer$delegate", "Lkotlin/Lazy;", "etDesc", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEtDesc", "()Lcom/tencent/mm/ui/widget/MMEditText;", "setEtDesc", "(Lcom/tencent/mm/ui/widget/MMEditText;)V", "etTextStatus", "Landroid/widget/EditText;", "getEtTextStatus", "()Landroid/widget/EditText;", "setEtTextStatus", "(Landroid/widget/EditText;)V", "fakeBtnOk", "getFakeBtnOk", "fakeBtnOk$delegate", "fakePic", "getFakePic", "setFakePic", "finishByPost", "", "globalLayoutListenerMode1", "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$globalLayoutListenerMode1$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$globalLayoutListenerMode1$1;", "globalLayoutListenerMode2", "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$globalLayoutListenerMode2$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$globalLayoutListenerMode2$1;", "hasReportPostWhenFinish", "getHasReportPostWhenFinish", "()Z", "setHasReportPostWhenFinish", "(Z)V", "hasSetCustomThumb", "getHasSetCustomThumb", "setHasSetCustomThumb", "iconCamera", "getIconCamera", "setIconCamera", "iconPoi", "getIconPoi", "setIconPoi", "iconStatus", "Landroid/widget/ImageView;", "getIconStatus", "()Landroid/widget/ImageView;", "setIconStatus", "(Landroid/widget/ImageView;)V", "iconText", "getIconText", "setIconText", "iconVisibility", "getIconVisibility", "setIconVisibility", "imgVideoSource", "", "ivBlur", "getIvBlur", "setIvBlur", "ivBlurSelect", "getIvBlurSelect", "ivBlurSelect$delegate", "ivBlurText", "Landroid/widget/TextView;", "getIvBlurText", "()Landroid/widget/TextView;", "ivBlurText$delegate", "ivBrand", "getIvBrand", "ivBrand$delegate", "ivPoiSelected", "getIvPoiSelected", "ivPoiSelected$delegate", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "lastClickTime", "getLastClickTime", "()J", "setLastClickTime", "(J)V", "lastGetCustomPartsTopicInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "getLastGetCustomPartsTopicInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "setLastGetCustomPartsTopicInfo", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;)V", "lastKeyboardHeight", "Ljava/lang/Integer;", "lastOriBitmap", "Landroid/graphics/Bitmap;", "lastSetThirdBackInfo", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$ThirdInfo;", "getLastSetThirdBackInfo", "()Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$ThirdInfo;", "setLastSetThirdBackInfo", "(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$ThirdInfo;)V", "layoutBlurOption", "getLayoutBlurOption", "setLayoutBlurOption", "layoutEditDesc", "getLayoutEditDesc", "setLayoutEditDesc", "layoutEditToolContainer", "getLayoutEditToolContainer", "setLayoutEditToolContainer", "layoutShow", "getLayoutShow", "setLayoutShow", "layoutThirdContainer", "Landroid/widget/FrameLayout;", "getLayoutThirdContainer", "()Landroid/widget/FrameLayout;", "layoutThirdContainer$delegate", "layoutThirdThumb", "getLayoutThirdThumb", "layoutThirdThumb$delegate", "layoutTopicEdit", "getLayoutTopicEdit", "setLayoutTopicEdit", "layoutVideo", "getLayoutVideo", "setLayoutVideo", "(Landroid/widget/FrameLayout;)V", "locationClickListener", "mChatRoomNameList", "", "mCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IMixStatusCustomParts;", "getMCustomParts", "()Lcom/tencent/mm/plugin/textstatus/api/IMixStatusCustomParts;", "setMCustomParts", "(Lcom/tencent/mm/plugin/textstatus/api/IMixStatusCustomParts;)V", "mLabelNameList", "mLabelRangeindex", "mOtherUserNameList", "mTipDialog", "Landroid/app/ProgressDialog;", "oriVideoFilePathBeforeEdt", "getOriVideoFilePathBeforeEdt", "()Ljava/lang/String;", "setOriVideoFilePathBeforeEdt", "(Ljava/lang/String;)V", "pageType", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$PageType;", "getPageType", "()Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$PageType;", "setPageType", "(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$PageType;)V", "poiId", "getPoiId", "setPoiId", "rangeSource", "scrollShow", "Lcom/tencent/mm/view/MaxHeightScrollView;", "getScrollShow", "()Lcom/tencent/mm/view/MaxHeightScrollView;", "setScrollShow", "(Lcom/tencent/mm/view/MaxHeightScrollView;)V", "setStatusParam", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "getSetStatusParam", "()Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "setSetStatusParam", "(Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;)V", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "smileyRoot", "getSmileyRoot", "smileyRoot$delegate", "style", "getStyle", "setStyle", "textClickListener", "thirdBack", "Lcom/tencent/mm/ui/widget/IPullDownView;", "getThirdBack", "()Lcom/tencent/mm/ui/widget/IPullDownView;", "setThirdBack", "(Lcom/tencent/mm/ui/widget/IPullDownView;)V", "thirdContainerLl", "Landroid/widget/LinearLayout;", "getThirdContainerLl", "()Landroid/widget/LinearLayout;", "thirdContainerLl$delegate", "thirdDescTv", "getThirdDescTv", "thirdDescTv$delegate", "thirdIconContainerFl", "getThirdIconContainerFl", "thirdIconContainerFl$delegate", "tipsPopup", "Lcom/tencent/mm/plugin/textstatus/ui/MMTipsPopupWindow;", "getTipsPopup", "()Lcom/tencent/mm/plugin/textstatus/ui/MMTipsPopupWindow;", "setTipsPopup", "(Lcom/tencent/mm/plugin/textstatus/ui/MMTipsPopupWindow;)V", "topicContainerLl", "getTopicContainerLl", "topicContainerLl$delegate", "tvCancel", "getTvCancel", "setTvCancel", "tvDesc", "getTvDesc", "setTvDesc", "(Landroid/widget/TextView;)V", "tvPoi", "getTvPoi", "setTvPoi", "tvTextStatus", "getTvTextStatus", "setTvTextStatus", "tvVisibility", "getTvVisibility", "setTvVisibility", "updateVPicCallback", "Lcom/tencent/mm/modelimage/UrlImageCacheService$ILoadCallback;", "vBack", "getVBack", "setVBack", "vCamera", "getVCamera", "vCamera$delegate", "vFake", "getVFake", "vFake$delegate", "vMask", "getVMask", "setVMask", "vPic", "getVPic", "vPic$delegate", "vPicLoadUrl", "vPoi", "getVPoi", "setVPoi", "vText", "getVText", "setVText", "vVisibility", "getVVisibility", "setVVisibility", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;", "getVideoLayout", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;", "setVideoLayout", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;)V", "visibilityClickListener", "visiblityUserNames", "Ljava/util/LinkedList;", "applyGalleryResult", "", "mediaType", "filePath", "thumbPath", "chatRoomToUserList", "", "chatRoomNames", "checkCurCustomPartsValid", "topicInfo", "checkCurThirdBackValid", "thirdInfo", "checkIsEditSourceBack", "closeThirdBack", "deleteBack", "destroyCustomPartsManual", "destroyThirdBackManual", "destroyVideo", "doPost", "doWhenLess", "text", "doWhenMore", "doWhenOK", "finish", "genThumbFromVideo", "videoPath", "getBelowAnimator", "height", "getCurTextStatus", "getCustomParts", "getFinderMenuSpan", "", "getForceOrientation", "getLayoutId", "sourceId", "jumpInfos", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getUpAnimator", "getVisibilityInfo", "userList", "goCapture", "goGallery", "goGalleryForSysVideo", "goPickFinder", "handleCaptureResult", "data", "Landroid/content/Intent;", "handleFileLocal", "handleFinderResult", "resultCode", "handleGalleryResult", "handlePoi", "requestCode", "handleReportData", "handleThirdBack", "handleThirdThumb", "handleThumbDownload", "thumbUrl", "succCallback", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$DownLoadSuccCallback;", "hideEmojiKeyboard", "hideSmiley", "initBackGroundResId", "initBlur", "initCameraIcon", "initCurTextStatusExtInfo", "initDesc", "initEditPage", "initEditText", "initMedia", "initMediaByExtInfo", "extInfo", "initMediaByInfo", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "initPoi", "initStatusIcon", "initTopicTips", "initTvTextStatus", "initVisibility", "isBtnOkEnable", "isFromThirdPost", "labelToUserList", "", "labelNames", "loadVisibility", "onActivityResult", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteEmoji", "onDestroy", "onKeyboardHeightChanged", "isResized", "onPause", "onPressEmoji", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onWindowFocusChanged", "hasFocus", "openThirdBack", "pauseVideo", "resumeVideo", "selectPoi", "setDefBackGround", "setForegroundPic", "bitmap", "isGraEffect", "setForegroundPicInner", "setIcon", "setPoiVisibility", "visibility", "setSysInsertionEnabled", "enabled", "setVisibilityWord", "labelRange", "showEducationLayout", "showEmojiKeyboard", "showSmiley", "switchPage", "page", "tryReportPostWhenFinish", "trySetDefBackground", "isMediaValid", "updateBlurStatus", "updatePoi", "updateThirdView", "clearThirdBackInfo", "handleRefTopicInfo", "refTopicInfo", "hasMedia", "updateThirdBackInfo", "target", "Companion", "DownLoadSuccCallback", "MediaStruct", "PageType", "ThirdInfo", "plugin-textstatus_release"})
public final class TextStatusEditActivity
  extends MMSecDataActivity
  implements com.tencent.mm.plugin.textstatus.emoji.c, com.tencent.mm.ui.tools.b.c.a, com.tencent.mm.ui.tools.h
{
  private static Bitmap MMo;
  public static final a MMp;
  private MMTPEffectVideoLayout Bba;
  private ObjectAnimator DCf;
  private ObjectAnimator DCg;
  private final View.OnClickListener Ice;
  private final View.OnClickListener Icf;
  private int KJo;
  private String KJq;
  private String KJr;
  private String KJs;
  private TextView MBS;
  TextView MBT;
  public ImageView MBW;
  private TextView MBY;
  private ImageView MCg;
  private com.tencent.mm.plugin.textstatus.a.c MCv;
  private TextStatusTopicInfo MCw;
  FrameLayout MJb;
  com.tencent.mm.ui.widget.b MJn;
  com.tencent.mm.plugin.textstatus.a.q MKR;
  private View MLA;
  MaxHeightScrollView MLB;
  private View MLC;
  private final kotlin.f MLD;
  private View MLE;
  View MLF;
  public View MLG;
  private final kotlin.f MLH;
  public View MLI;
  public View MLJ;
  public ImageView MLK;
  private final kotlin.f MLL;
  private final kotlin.f MLM;
  private final kotlin.f MLN;
  private final kotlin.f MLO;
  private final kotlin.f MLP;
  private final kotlin.f MLQ;
  private final kotlin.f MLR;
  private final kotlin.f MLS;
  public TextStatusExtInfo MLT;
  private int MLU;
  private Bitmap MLV;
  private boolean MLW;
  private final p MLX;
  private final o MLY;
  private final g MLZ;
  View MLf;
  private final kotlin.f MLg;
  private final kotlin.f MLh;
  private View MLi;
  private View MLj;
  private View MLk;
  private View MLl;
  private View MLm;
  private View MLn;
  private final kotlin.f MLo;
  private View MLp;
  public MMEditText MLq;
  Button MLr;
  private TextView MLs;
  private final kotlin.f MLt;
  private View MLu;
  private final kotlin.f MLv;
  private final kotlin.f MLw;
  private ImageView MLx;
  private View MLy;
  private View MLz;
  e MMa;
  private String MMb;
  private r.a MMc;
  private Integer MMd;
  private d MMe;
  private final View.OnClickListener MMf;
  private final View.OnClickListener MMg;
  private LinkedList<String> MMh;
  private int MMi;
  private boolean MMj;
  private TextStatusEditActivity.e MMk;
  private String MMl;
  private boolean MMm;
  public c MMn;
  private com.tencent.mm.ui.tools.i jij;
  int kFs;
  long lastClickTime;
  int style;
  private ProgressDialog syZ;
  
  static
  {
    AppMethodBeat.i(234171);
    MMp = new a((byte)0);
    AppMethodBeat.o(234171);
  }
  
  public TextStatusEditActivity()
  {
    AppMethodBeat.i(234170);
    com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)new com.tencent.mm.plugin.textstatus.g.k());
    this.MLg = kotlin.g.ar((kotlin.g.a.a)new bk(this));
    this.MLh = kotlin.g.ar((kotlin.g.a.a)new bl(this));
    this.MLo = kotlin.g.ar((kotlin.g.a.a)new af(this));
    this.MLt = kotlin.g.ar((kotlin.g.a.a)new bm(this));
    this.MLv = kotlin.g.ar((kotlin.g.a.a)new ag(this));
    this.MLw = kotlin.g.ar((kotlin.g.a.a)new ah(this));
    this.MLD = kotlin.g.ar((kotlin.g.a.a)new bj(this));
    this.MLH = kotlin.g.ar((kotlin.g.a.a)new j(this));
    this.MLL = kotlin.g.ar((kotlin.g.a.a)new ac(this));
    this.MLM = kotlin.g.ar((kotlin.g.a.a)new ad(this));
    this.MLN = kotlin.g.ar((kotlin.g.a.a)new bg(this));
    this.MLO = kotlin.g.ar((kotlin.g.a.a)new bh(this));
    this.MLP = kotlin.g.ar((kotlin.g.a.a)new bi(this));
    this.MLQ = kotlin.g.ar((kotlin.g.a.a)new ae(this));
    this.MLR = kotlin.g.ar((kotlin.g.a.a)new be(this));
    this.MLS = kotlin.g.ar((kotlin.g.a.a)new i(this));
    com.tencent.mm.plugin.textstatus.k.m localm = com.tencent.mm.plugin.textstatus.k.m.MOX;
    this.MLU = com.tencent.mm.plugin.textstatus.k.m.gnN();
    this.MLX = new p(this);
    this.MLY = new o(this);
    this.MLZ = new g(this);
    this.MMe = d.MMw;
    this.Icf = ((View.OnClickListener)new bf(this));
    this.KJq = "";
    this.KJr = "";
    this.KJs = "";
    this.MMf = ((View.OnClickListener)new bn(this));
    this.Ice = ((View.OnClickListener)new TextStatusEditActivity.ai(this));
    this.MMg = ((View.OnClickListener)new f(this));
    this.MMh = new LinkedList();
    this.MMl = "";
    AppMethodBeat.o(234170);
  }
  
  private final com.tencent.mm.ui.widget.b F(String paramString, List<? extends TextStatusJumpInfo> paramList)
  {
    Object localObject2 = null;
    AppMethodBeat.i(234137);
    com.tencent.mm.plugin.textstatus.proto.d locald = new com.tencent.mm.plugin.textstatus.proto.d();
    locald.kYn = 0;
    locald.MEO = 0;
    Object localObject1 = this.MLT;
    if (localObject1 == null) {
      p.bGy("curTextStatusExtInfo");
    }
    int i = ((TextStatusExtInfo)localObject1).createTime;
    if (i != 0)
    {
      locald.MEQ = i;
      if (paramList == null) {
        break label162;
      }
      paramList = com.tencent.mm.plugin.textstatus.j.e.in(paramList);
      label72:
      localObject1 = com.tencent.mm.plugin.textstatus.j.d.MIW;
      if (paramList == null) {
        break label167;
      }
    }
    label162:
    label167:
    for (localObject1 = paramList.jumpType;; localObject1 = null)
    {
      com.tencent.mm.plugin.textstatus.a.m localm = com.tencent.mm.plugin.textstatus.j.d.beD((String)localObject1);
      localObject1 = localObject2;
      if (localm != null) {
        localObject1 = localm.a(paramString, gmK(), paramList, locald);
      }
      paramString = getContext();
      if (((paramString instanceof MMFragmentActivity)) && (localObject1 != null)) {
        ((com.tencent.mm.ui.widget.b)localObject1).a((MMFragmentActivity)paramString);
      }
      AppMethodBeat.o(234137);
      return localObject1;
      i = cm.bfF();
      break;
      paramList = null;
      break label72;
    }
  }
  
  private final void S(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(234148);
    gnb();
    c localc = this.MMn;
    if (localc == null) {
      p.bGy("curLocalMediaStruct");
    }
    AppCompatActivity localAppCompatActivity = getContext();
    p.j(localAppCompatActivity, "context");
    localc.a(paramInt, paramString1, paramString2, (Context)localAppCompatActivity, this.MMl);
    gv(paramString1, paramInt);
    gmZ();
    gnh();
    AppMethodBeat.o(234148);
  }
  
  private final void a(d paramd)
  {
    AppMethodBeat.i(234088);
    switch (j.jLJ[paramd.ordinal()])
    {
    }
    for (;;)
    {
      this.MMe = paramd;
      AppMethodBeat.o(234088);
      return;
      Object localObject = this.MLz;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.MLy;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.MLA;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = getController();
      p.j(localObject, "controller");
      ((com.tencent.mm.ui.w)localObject).hHH().show();
      continue;
      localObject = this.MLz;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.MLy;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.MLA;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = getController();
      p.j(localObject, "controller");
      ((com.tencent.mm.ui.w)localObject).hHH().hide();
      hideVKB();
    }
  }
  
  private void a(final String paramString, final b paramb)
  {
    AppMethodBeat.i(234062);
    gna();
    Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "trydownload imgback:".concat(String.valueOf(paramString)));
    this.MMc = ((r.a)new s(this, paramString, paramb));
    com.tencent.mm.ay.q.bmk().a(paramString, this.MMc);
    this.MMb = paramString;
    AppMethodBeat.o(234062);
  }
  
  private final boolean a(TextStatusEditActivity.e parame)
  {
    AppMethodBeat.i(234139);
    String str = parame.sourceId;
    Object localObject = this.MMk;
    if (localObject != null) {}
    for (localObject = ((TextStatusEditActivity.e)localObject).sourceId; (p.h(str, localObject) ^ true); localObject = null)
    {
      AppMethodBeat.o(234139);
      return false;
    }
    localObject = this.MMk;
    if (localObject != null)
    {
      localObject = ((TextStatusEditActivity.e)localObject).yNX;
      if ((localObject != null) && (k.B((List)localObject, parame.yNX) == true))
      {
        AppMethodBeat.o(234139);
        return true;
      }
    }
    AppMethodBeat.o(234139);
    return false;
  }
  
  private final ObjectAnimator ajj(int paramInt)
  {
    AppMethodBeat.i(234090);
    if (this.DCg == null)
    {
      this.DCg = ObjectAnimator.ofFloat(gmV(), View.TRANSLATION_Y, new float[] { paramInt, 0.0F });
      localObjectAnimator = this.DCg;
      if (localObjectAnimator != null) {
        localObjectAnimator.setDuration(300L);
      }
      localObjectAnimator = this.DCg;
      if (localObjectAnimator != null) {
        localObjectAnimator.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
      }
      localObjectAnimator = this.DCg;
      if (localObjectAnimator != null) {
        localObjectAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new TextStatusEditActivity.m(this, paramInt));
      }
    }
    ObjectAnimator localObjectAnimator = this.DCg;
    if (localObjectAnimator != null) {
      localObjectAnimator.removeAllListeners();
    }
    localObjectAnimator = this.DCg;
    if (localObjectAnimator != null) {
      localObjectAnimator.addListener((Animator.AnimatorListener)new TextStatusEditActivity.n(this));
    }
    localObjectAnimator = this.DCg;
    AppMethodBeat.o(234090);
    return localObjectAnimator;
  }
  
  private final ObjectAnimator ajk(int paramInt)
  {
    AppMethodBeat.i(234091);
    if (this.DCf == null)
    {
      this.DCf = ObjectAnimator.ofFloat(gmV(), View.TRANSLATION_Y, new float[] { 0.0F, paramInt });
      localObjectAnimator = this.DCf;
      if (localObjectAnimator != null) {
        localObjectAnimator.setDuration(300L);
      }
      localObjectAnimator = this.DCf;
      if (localObjectAnimator != null) {
        localObjectAnimator.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
      }
      localObjectAnimator = this.DCf;
      if (localObjectAnimator != null) {
        localObjectAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new TextStatusEditActivity.k(this, paramInt));
      }
    }
    ObjectAnimator localObjectAnimator = this.DCf;
    if (localObjectAnimator != null) {
      localObjectAnimator.removeAllListeners();
    }
    localObjectAnimator = this.DCf;
    if (localObjectAnimator != null) {
      localObjectAnimator.addListener((Animator.AnimatorListener)new TextStatusEditActivity.l(this));
    }
    localObjectAnimator = this.DCf;
    AppMethodBeat.o(234091);
    return localObjectAnimator;
  }
  
  private final void ajl(int paramInt)
  {
    AppMethodBeat.i(234114);
    TextView localTextView;
    switch (paramInt)
    {
    default: 
      localTextView = this.MLs;
      if (localTextView != null)
      {
        localTextView.setText((CharSequence)getContext().getString(b.h.Mzh));
        AppMethodBeat.o(234114);
        return;
      }
      break;
    case 3: 
      localTextView = this.MLs;
      if (localTextView != null)
      {
        localTextView.setText((CharSequence)getContext().getString(b.h.Mzi));
        AppMethodBeat.o(234114);
        return;
      }
      AppMethodBeat.o(234114);
      return;
    }
    AppMethodBeat.o(234114);
  }
  
  private final void ajm(int paramInt)
  {
    AppMethodBeat.i(234121);
    TextView localTextView = this.MBY;
    if (localTextView != null) {
      localTextView.setVisibility(paramInt);
    }
    if (paramInt == 0)
    {
      gmH().setVisibility(0);
      AppMethodBeat.o(234121);
      return;
    }
    gmH().setVisibility(8);
    AppMethodBeat.o(234121);
  }
  
  private void b(TextStatusTopicInfo paramTextStatusTopicInfo1, TextStatusTopicInfo paramTextStatusTopicInfo2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(234055);
    p.k(paramTextStatusTopicInfo1, "$this$updateThirdBackInfo");
    Object localObject1 = (CharSequence)paramTextStatusTopicInfo1.sourceId;
    if ((localObject1 == null) || (kotlin.n.n.ba((CharSequence)localObject1)))
    {
      i = 1;
      if (i == 0)
      {
        localObject1 = glQ();
        if ((localObject1 != null) && (((com.tencent.mm.plugin.textstatus.a.c)localObject1).gkH() == true))
        {
          localObject1 = glQ();
          if ((localObject1 == null) || (((com.tencent.mm.plugin.textstatus.a.c)localObject1).dDH() != true)) {}
        }
      }
      else
      {
        if (paramTextStatusTopicInfo2 == null) {
          break label295;
        }
        localObject1 = paramTextStatusTopicInfo2.sourceId;
        label94:
        paramTextStatusTopicInfo1.sourceId = ((String)localObject1);
        if (paramTextStatusTopicInfo2 == null) {
          break label301;
        }
        localObject1 = paramTextStatusTopicInfo2.sourceName;
        label110:
        paramTextStatusTopicInfo1.sourceName = ((String)localObject1);
        if (paramTextStatusTopicInfo2 == null) {
          break label307;
        }
        localObject1 = paramTextStatusTopicInfo2.sourceActivityId;
        label126:
        paramTextStatusTopicInfo1.sourceActivityId = ((String)localObject1);
        if (paramTextStatusTopicInfo2 == null) {
          break label313;
        }
        localObject1 = paramTextStatusTopicInfo2.sourceIcon;
        label142:
        paramTextStatusTopicInfo1.sourceIcon = ((String)localObject1);
        if (paramTextStatusTopicInfo2 != null)
        {
          LinkedList localLinkedList = paramTextStatusTopicInfo2.sourceJumpInfos;
          localObject1 = localLinkedList;
          if (localLinkedList != null) {}
        }
        else
        {
          localObject1 = new LinkedList();
        }
        paramTextStatusTopicInfo1.sourceJumpInfos = ((LinkedList)localObject1);
        localObject1 = localObject2;
        if (paramTextStatusTopicInfo2 != null) {
          localObject1 = paramTextStatusTopicInfo2.verifyInfo;
        }
        paramTextStatusTopicInfo1.verifyInfo = ((String)localObject1);
      }
      if (paramTextStatusTopicInfo2 != null)
      {
        localObject1 = paramTextStatusTopicInfo2.jumpInfos;
        paramTextStatusTopicInfo2 = (TextStatusTopicInfo)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        paramTextStatusTopicInfo2 = new LinkedList();
      }
      paramTextStatusTopicInfo1.jumpInfos = paramTextStatusTopicInfo2;
      paramTextStatusTopicInfo2 = (CharSequence)paramTextStatusTopicInfo1.sourceId;
      if ((paramTextStatusTopicInfo2 != null) && (!kotlin.n.n.ba(paramTextStatusTopicInfo2))) {
        break label319;
      }
    }
    label295:
    label301:
    label307:
    label313:
    label319:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (paramTextStatusTopicInfo1.jumpInfos.size() == 0)) {
        paramTextStatusTopicInfo1.jumpInfos.addAll((Collection)paramTextStatusTopicInfo1.sourceJumpInfos);
      }
      AppMethodBeat.o(234055);
      return;
      i = 0;
      break;
      localObject1 = null;
      break label94;
      localObject1 = null;
      break label110;
      localObject1 = null;
      break label126;
      localObject1 = null;
      break label142;
    }
  }
  
  private final String bP(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(234166);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramLinkedList != null)
    {
      localObject1 = localObject2;
      if (paramLinkedList.size() <= 0) {}
    }
    try
    {
      paramLinkedList = new JSONObject();
      paramLinkedList.put("mLabelRangeindex", this.KJo);
      paramLinkedList.put("mLabelNameList", this.KJq);
      paramLinkedList.put("mOtherUserNameList", this.KJr);
      paramLinkedList.put("mChatRoomNameList", this.KJs);
      localObject1 = paramLinkedList.toString();
      AppMethodBeat.o(234166);
      return localObject1;
    }
    catch (Throwable paramLinkedList)
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
  }
  
  private final void beF(String paramString)
  {
    AppMethodBeat.i(234122);
    gmL().removeAllViews();
    com.tencent.mm.plugin.textstatus.a.c localc = glQ();
    boolean bool;
    if (localc != null)
    {
      bool = localc.d(gmL());
      this.MMj = bool;
      paramString = (CharSequence)paramString;
      if ((paramString != null) && (!kotlin.n.n.ba(paramString))) {
        break label114;
      }
    }
    label114:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (this.MMj != true)) {
        break label119;
      }
      gmL().setVisibility(0);
      paramString = com.tencent.mm.plugin.textstatus.k.n.MOY;
      com.tencent.mm.plugin.textstatus.k.n.B((View)gmL(), com.tencent.mm.ci.a.fromDPToPix((Context)this, 12.0F));
      AppMethodBeat.o(234122);
      return;
      bool = false;
      break;
    }
    label119:
    gmL().setVisibility(8);
    AppMethodBeat.o(234122);
  }
  
  /* Error */
  public static String beG(String paramString)
  {
    // Byte code:
    //   0: ldc_w 1308
    //   3: invokestatic 684	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 1310	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 1311	java/lang/StringBuilder:<init>	()V
    //   13: invokestatic 1316	com/tencent/mm/plugin/sns/model/aj:getAccSnsTmpPath	()Ljava/lang/String;
    //   16: invokevirtual 1320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_0
    //   20: invokestatic 1325	com/tencent/mm/vfs/u:buc	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokevirtual 1320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 1326	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: astore_1
    //   30: new 1328	com/tencent/mm/compatible/i/d
    //   33: dup
    //   34: invokespecial 1329	com/tencent/mm/compatible/i/d:<init>	()V
    //   37: checkcast 1331	android/media/MediaMetadataRetriever
    //   40: astore_2
    //   41: aload_2
    //   42: aload_0
    //   43: invokevirtual 1334	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   46: aload_2
    //   47: lconst_0
    //   48: invokevirtual 1338	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   51: astore_0
    //   52: aload_0
    //   53: ifnonnull +26 -> 79
    //   56: ldc_w 1010
    //   59: ldc_w 1340
    //   62: invokestatic 1343	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload_2
    //   66: invokevirtual 1346	android/media/MediaMetadataRetriever:release	()V
    //   69: ldc_w 1308
    //   72: invokestatic 693	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: ldc_w 802
    //   78: areturn
    //   79: ldc_w 1010
    //   82: ldc_w 1348
    //   85: iconst_2
    //   86: anewarray 1350	java/lang/Object
    //   89: dup
    //   90: iconst_0
    //   91: aload_0
    //   92: invokevirtual 1355	android/graphics/Bitmap:getWidth	()I
    //   95: invokestatic 1360	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: aload_0
    //   102: invokevirtual 1363	android/graphics/Bitmap:getHeight	()I
    //   105: invokestatic 1360	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   108: aastore
    //   109: invokestatic 1366	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: aload_0
    //   113: bipush 80
    //   115: getstatic 1372	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   118: aload_1
    //   119: iconst_1
    //   120: invokestatic 1378	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   123: pop
    //   124: aload_1
    //   125: invokestatic 1382	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   128: astore_0
    //   129: ldc_w 1010
    //   132: ldc_w 1384
    //   135: iconst_2
    //   136: anewarray 1350	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: aload_0
    //   142: getfield 1389	android/graphics/BitmapFactory$Options:outWidth	I
    //   145: invokestatic 1360	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   148: aastore
    //   149: dup
    //   150: iconst_1
    //   151: aload_0
    //   152: getfield 1392	android/graphics/BitmapFactory$Options:outHeight	I
    //   155: invokestatic 1360	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   158: aastore
    //   159: invokestatic 1366	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   162: aload_2
    //   163: invokevirtual 1346	android/media/MediaMetadataRetriever:release	()V
    //   166: ldc_w 1308
    //   169: invokestatic 693	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: aload_1
    //   173: areturn
    //   174: astore_0
    //   175: ldc_w 1010
    //   178: ldc_w 1394
    //   181: iconst_1
    //   182: anewarray 1350	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload_0
    //   188: invokevirtual 1397	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   191: aastore
    //   192: invokestatic 1399	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: aload_2
    //   196: invokevirtual 1346	android/media/MediaMetadataRetriever:release	()V
    //   199: goto -33 -> 166
    //   202: astore_0
    //   203: goto -37 -> 166
    //   206: astore_0
    //   207: aload_2
    //   208: invokevirtual 1346	android/media/MediaMetadataRetriever:release	()V
    //   211: ldc_w 1308
    //   214: invokestatic 693	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: aload_0
    //   218: athrow
    //   219: astore_0
    //   220: goto -151 -> 69
    //   223: astore_0
    //   224: goto -58 -> 166
    //   227: astore_1
    //   228: goto -17 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	paramString	String
    //   29	144	1	str	String
    //   227	1	1	localException	Exception
    //   40	168	2	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   41	52	174	java/lang/Exception
    //   56	65	174	java/lang/Exception
    //   79	162	174	java/lang/Exception
    //   195	199	202	java/lang/Exception
    //   41	52	206	finally
    //   56	65	206	finally
    //   79	162	206	finally
    //   175	195	206	finally
    //   65	69	219	java/lang/Exception
    //   162	166	223	java/lang/Exception
    //   207	211	227	java/lang/Exception
  }
  
  private final boolean bo(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(234064);
    if ((paramInt == 0) || (!paramBoolean))
    {
      gna();
      AppMethodBeat.o(234064);
      return true;
    }
    AppMethodBeat.o(234064);
    return false;
  }
  
  private final void d(com.tencent.mm.plugin.textstatus.g.e.a parama)
  {
    AppMethodBeat.i(234063);
    c localc = this.MMn;
    if (localc == null) {
      p.bGy("curLocalMediaStruct");
    }
    AppCompatActivity localAppCompatActivity = getContext();
    p.j(localAppCompatActivity, "context");
    localc.a(parama, (Context)localAppCompatActivity);
    parama = this.MMn;
    if (parama == null) {
      p.bGy("curLocalMediaStruct");
    }
    if (!TextUtils.isEmpty((CharSequence)parama.MMq)) {}
    for (boolean bool = true;; bool = false)
    {
      parama = this.MMn;
      if (parama == null) {
        p.bGy("curLocalMediaStruct");
      }
      if (!bo(parama.mediaType, bool)) {
        break;
      }
      AppMethodBeat.o(234063);
      return;
    }
    parama = this.MLu;
    if (parama != null)
    {
      parama.post((Runnable)new aa(this));
      AppMethodBeat.o(234063);
      return;
    }
    AppMethodBeat.o(234063);
  }
  
  private com.tencent.mm.plugin.textstatus.a.c glQ()
  {
    int i = 1;
    LinkedList localLinkedList = null;
    AppMethodBeat.i(234125);
    Object localObject1 = this.MLT;
    if (localObject1 == null) {
      p.bGy("curTextStatusExtInfo");
    }
    TextStatusTopicInfo localTextStatusTopicInfo = ((TextStatusExtInfo)localObject1).topicInfo;
    if (this.MCv == null) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject1 = this.MCv;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.textstatus.a.c)localObject1).onDetach();
        }
        this.MCv = null;
        this.MCw = null;
      }
      try
      {
        localObject1 = com.tencent.mm.plugin.textstatus.j.d.MIW;
        localObject1 = com.tencent.mm.plugin.textstatus.j.d.gmo();
        this.MCv = ((com.tencent.mm.plugin.textstatus.a.c)localObject1);
        Object localObject3 = this.MCv;
        if (localObject3 != null)
        {
          if (localTextStatusTopicInfo != null)
          {
            localObject1 = localTextStatusTopicInfo.sourceJumpInfos;
            List localList = (List)localObject1;
            if (localTextStatusTopicInfo == null) {
              break label303;
            }
            localObject1 = localTextStatusTopicInfo.jumpInfos;
            ((com.tencent.mm.plugin.textstatus.a.c)localObject3).c(null, localList, (List)localObject1);
          }
        }
        else
        {
          localObject3 = new TextStatusTopicInfo();
          localObject1 = localLinkedList;
          if (localTextStatusTopicInfo != null) {
            localObject1 = localTextStatusTopicInfo.sourceId;
          }
          ((TextStatusTopicInfo)localObject3).sourceId = ((String)localObject1);
          localObject1 = new LinkedList();
          if (localTextStatusTopicInfo != null)
          {
            localLinkedList = localTextStatusTopicInfo.jumpInfos;
            if (localLinkedList != null) {
              ((LinkedList)localObject1).addAll((Collection)localLinkedList);
            }
          }
          ((TextStatusTopicInfo)localObject3).jumpInfos = ((LinkedList)localObject1);
          localObject1 = new LinkedList();
          if (localTextStatusTopicInfo != null)
          {
            localLinkedList = localTextStatusTopicInfo.sourceJumpInfos;
            if (localLinkedList != null) {
              ((LinkedList)localObject1).addAll((Collection)localLinkedList);
            }
          }
          ((TextStatusTopicInfo)localObject3).sourceJumpInfos = ((LinkedList)localObject1);
          this.MCw = ((TextStatusTopicInfo)localObject3);
          localObject1 = this.MCv;
          AppMethodBeat.o(234125);
          return localObject1;
          localObject1 = this.MCw;
          if ((localObject1 != null) && (b.a((TextStatusTopicInfo)localObject1, localTextStatusTopicInfo) == true)) {
            continue;
          }
          i = 0;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.TextStatus.TextStatusEditActivity", localThrowable, "customps err", new Object[0]);
          Object localObject2 = null;
          continue;
          localObject2 = null;
          continue;
          label303:
          localObject2 = null;
        }
      }
    }
  }
  
  private final View gmF()
  {
    AppMethodBeat.i(234009);
    View localView = (View)this.MLg.getValue();
    AppMethodBeat.o(234009);
    return localView;
  }
  
  private final View gmG()
  {
    AppMethodBeat.i(234011);
    View localView = (View)this.MLh.getValue();
    AppMethodBeat.o(234011);
    return localView;
  }
  
  private ImageView gmH()
  {
    AppMethodBeat.i(234015);
    ImageView localImageView = (ImageView)this.MLo.getValue();
    AppMethodBeat.o(234015);
    return localImageView;
  }
  
  private final ImageView gmJ()
  {
    AppMethodBeat.i(234018);
    ImageView localImageView = (ImageView)this.MLt.getValue();
    AppMethodBeat.o(234018);
    return localImageView;
  }
  
  private final FrameLayout gmK()
  {
    AppMethodBeat.i(234021);
    FrameLayout localFrameLayout = (FrameLayout)this.MLv.getValue();
    AppMethodBeat.o(234021);
    return localFrameLayout;
  }
  
  private final FrameLayout gmL()
  {
    AppMethodBeat.i(234024);
    FrameLayout localFrameLayout = (FrameLayout)this.MLw.getValue();
    AppMethodBeat.o(234024);
    return localFrameLayout;
  }
  
  private final View gmO()
  {
    AppMethodBeat.i(234030);
    View localView = (View)this.MLH.getValue();
    AppMethodBeat.o(234030);
    return localView;
  }
  
  private final ImageView gmP()
  {
    AppMethodBeat.i(234034);
    ImageView localImageView = (ImageView)this.MLL.getValue();
    AppMethodBeat.o(234034);
    return localImageView;
  }
  
  private final TextView gmQ()
  {
    AppMethodBeat.i(234035);
    TextView localTextView = (TextView)this.MLM.getValue();
    AppMethodBeat.o(234035);
    return localTextView;
  }
  
  private final LinearLayout gmR()
  {
    AppMethodBeat.i(234038);
    LinearLayout localLinearLayout = (LinearLayout)this.MLN.getValue();
    AppMethodBeat.o(234038);
    return localLinearLayout;
  }
  
  private final TextView gmS()
  {
    AppMethodBeat.i(234039);
    TextView localTextView = (TextView)this.MLO.getValue();
    AppMethodBeat.o(234039);
    return localTextView;
  }
  
  private final FrameLayout gmT()
  {
    AppMethodBeat.i(234041);
    FrameLayout localFrameLayout = (FrameLayout)this.MLP.getValue();
    AppMethodBeat.o(234041);
    return localFrameLayout;
  }
  
  private final ImageView gmU()
  {
    AppMethodBeat.i(234043);
    ImageView localImageView = (ImageView)this.MLQ.getValue();
    AppMethodBeat.o(234043);
    return localImageView;
  }
  
  private final TextStatusEmojiView gmV()
  {
    AppMethodBeat.i(234045);
    TextStatusEmojiView localTextStatusEmojiView = (TextStatusEmojiView)this.MLS.getValue();
    AppMethodBeat.o(234045);
    return localTextStatusEmojiView;
  }
  
  private final void gmX()
  {
    AppMethodBeat.i(234056);
    Object localObject1 = this.MLT;
    if (localObject1 == null) {
      p.bGy("curTextStatusExtInfo");
    }
    localObject1 = ((TextStatusExtInfo)localObject1).topicInfo.iconId;
    Object localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (kotlin.n.n.ba((CharSequence)localObject2))) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject1 = com.tencent.mm.plugin.textstatus.k.c.gnz().beJ((String)localObject1);
      localObject2 = this.MBS;
      if (localObject2 == null) {
        break;
      }
      ((TextView)localObject2).setText((CharSequence)localObject1);
      AppMethodBeat.o(234056);
      return;
    }
    AppMethodBeat.o(234056);
  }
  
  private final void gmY()
  {
    AppMethodBeat.i(234058);
    if (!com.tencent.mm.plugin.textstatus.a.t.glb())
    {
      AppMethodBeat.o(234058);
      return;
    }
    this.MMa = new e((Context)this);
    View localView = this.MLF;
    if (localView != null)
    {
      localView.postDelayed((Runnable)new TextStatusEditActivity.ab(this), 500L);
      AppMethodBeat.o(234058);
      return;
    }
    AppMethodBeat.o(234058);
  }
  
  private final void gmZ()
  {
    AppMethodBeat.i(234060);
    Object localObject = this.MLT;
    if (localObject == null) {
      p.bGy("curTextStatusExtInfo");
    }
    if (k.a((TextStatusExtInfo)localObject))
    {
      localObject = this.MLJ;
      if (localObject == null) {
        p.bGy("layoutBlurOption");
      }
      ((View)localObject).setAlpha(1.0F);
      localObject = this.MLK;
      if (localObject == null) {
        p.bGy("ivBlur");
      }
      ((ImageView)localObject).setVisibility(8);
      gmP().setVisibility(0);
      gmQ().setTextColor(getContext().getResources().getColor(b.b.White));
      localObject = this.MLx;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = this.Bba;
      if (localObject != null)
      {
        localObject = ((MMTPEffectVideoLayout)localObject).getEffectManager();
        if (localObject == null) {}
      }
      for (localObject = ((EffectManager)localObject).ikc();; localObject = null)
      {
        if (localObject != null) {
          ((com.tencent.mm.xeffect.effect.b)localObject).setRadius(5.0F);
        }
        if (localObject != null) {
          ((com.tencent.mm.xeffect.effect.b)localObject).ikb();
        }
        if (MMo == null) {
          break;
        }
        gmJ().setImageBitmap(MMo);
        AppMethodBeat.o(234060);
        return;
      }
    }
    localObject = this.MLJ;
    if (localObject == null) {
      p.bGy("layoutBlurOption");
    }
    ((View)localObject).setAlpha(0.85F);
    localObject = this.MLK;
    if (localObject == null) {
      p.bGy("ivBlur");
    }
    ((ImageView)localObject).setVisibility(0);
    gmP().setVisibility(8);
    gmQ().setTextColor(getContext().getResources().getColor(b.b.BW_100_Alpha_0_6));
    localObject = this.MLx;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = this.Bba;
    if (localObject != null)
    {
      localObject = ((MMTPEffectVideoLayout)localObject).getEffectManager();
      if (localObject != null) {
        ((EffectManager)localObject).b(com.tencent.mm.xeffect.effect.j.YZP);
      }
    }
    if (this.MLV != null) {
      gmJ().setImageBitmap(this.MLV);
    }
    AppMethodBeat.o(234060);
  }
  
  private final void gmq()
  {
    AppMethodBeat.i(234073);
    Object localObject = this.Bba;
    if (localObject != null)
    {
      localObject = ((MMTPEffectVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).stopAsync();
      }
    }
    localObject = this.Bba;
    if (localObject != null)
    {
      localObject = ((MMTPEffectVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).recycle();
      }
    }
    localObject = this.Bba;
    if (localObject != null) {
      ((MMTPEffectVideoLayout)localObject).MUh.YIy.release();
    }
    this.Bba = null;
    localObject = this.MJb;
    if (localObject != null)
    {
      ((FrameLayout)localObject).removeAllViews();
      AppMethodBeat.o(234073);
      return;
    }
    AppMethodBeat.o(234073);
  }
  
  private final void gmr()
  {
    AppMethodBeat.i(234135);
    Object localObject = getContext();
    if ((localObject instanceof MMFragmentActivity))
    {
      com.tencent.mm.ui.widget.b localb = this.MJn;
      if (localb != null) {
        localb.b((MMFragmentActivity)localObject);
      }
    }
    localObject = this.MJn;
    if (localObject != null) {
      ((com.tencent.mm.ui.widget.b)localObject).onDestroy();
    }
    this.MJn = null;
    this.MMk = null;
    AppMethodBeat.o(234135);
  }
  
  private final void gna()
  {
    AppMethodBeat.i(234065);
    gmJ().setImageResource(this.MLU);
    gmJ().setVisibility(0);
    Object localObject = this.MJb;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = this.MLJ;
    if (localObject == null) {
      p.bGy("layoutBlurOption");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(234065);
  }
  
  private final void gnb()
  {
    AppMethodBeat.i(234067);
    Object localObject = this.MMn;
    if (localObject == null) {
      p.bGy("curLocalMediaStruct");
    }
    ((c)localObject).reset();
    localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
    localObject = getContext();
    p.j(localObject, "context");
    localObject = (am)a.a.a((Context)localObject, 8, am.class);
    if (localObject != null)
    {
      if (gnl()) {
        ((am)localObject).MGk = 1L;
      }
      if (this.kFs == 1) {
        ((am)localObject).MGk = 1L;
      }
    }
    localObject = this.MLT;
    if (localObject == null) {
      p.bGy("curTextStatusExtInfo");
    }
    k.b((TextStatusExtInfo)localObject);
    gmq();
    gna();
    localObject = this.MLT;
    if (localObject == null) {
      p.bGy("curTextStatusExtInfo");
    }
    localObject = ((TextStatusExtInfo)localObject).topicInfo;
    p.j(localObject, "curTextStatusExtInfo.topicInfo");
    p.k(localObject, "$this$clearThirdBackInfo");
    b((TextStatusTopicInfo)localObject, null);
    gnh();
    AppMethodBeat.o(234067);
  }
  
  private final void gnc()
  {
    AppMethodBeat.i(234089);
    if (gmV().getVisibility() == 8)
    {
      AppMethodBeat.o(234089);
      return;
    }
    int i = ad.bC((Context)this);
    gmV().getLayoutParams().height = i;
    ObjectAnimator localObjectAnimator = ajj(i);
    if ((localObjectAnimator != null) && (localObjectAnimator.isRunning() == true)) {
      localObjectAnimator.cancel();
    }
    localObjectAnimator = ajk(i);
    if (localObjectAnimator != null)
    {
      localObjectAnimator.start();
      AppMethodBeat.o(234089);
      return;
    }
    AppMethodBeat.o(234089);
  }
  
  private final void gne()
  {
    AppMethodBeat.i(234102);
    if (!com.tencent.mm.pluginsdk.permission.b.a((Activity)this, "android.permission.CAMERA", 18, "", ""))
    {
      AppMethodBeat.o(234102);
      return;
    }
    Object localObject1 = (CaptureDataManager.b)new TextStatusEditActivity.q(this);
    new SightParams(1, 0);
    Object localObject2 = com.tencent.mm.modelvideo.x.XS(com.tencent.mm.plugin.auth.a.a.crN());
    p.j(localObject2, "VideoInfoStorage.genFileName(Account.username())");
    s.bqB();
    Object localObject3 = com.tencent.mm.modelvideo.x.XT((String)localObject2);
    s.bqB();
    localObject2 = RecordConfigProvider.a((String)localObject3, com.tencent.mm.modelvideo.x.XU((String)localObject2), ((com.tencent.mm.plugin.story.c.a.c.a)com.tencent.mm.plugin.story.c.a.c.LFb.aUb()).mfk, ((com.tencent.mm.plugin.story.c.a.c.a)com.tencent.mm.plugin.story.c.a.c.LFb.aUb()).mfk.duration * 1000, 15);
    p.j(localObject2, "RecordConfigProvider.get…ENE_TEXT_STATUS\n        )");
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vFK, false)) {
      ((RecordConfigProvider)localObject2).remuxType = 2;
    }
    localObject3 = new UICustomParam.a();
    ((UICustomParam.a)localObject3).avX();
    ((UICustomParam.a)localObject3).avW();
    ((UICustomParam.a)localObject3).dZ(true);
    ((RecordConfigProvider)localObject2).HKT = ((UICustomParam.a)localObject3).avZ();
    ((RecordConfigProvider)localObject2).HLa = Boolean.FALSE;
    ((RecordConfigProvider)localObject2).HLm = false;
    ((RecordConfigProvider)localObject2).HLn = false;
    ((RecordConfigProvider)localObject2).HLo = true;
    ((RecordConfigProvider)localObject2).HKW = Boolean.TRUE;
    ((RecordConfigProvider)localObject2).HKV = 4;
    ((RecordConfigProvider)localObject2).G(2, TextStatusEditVideoPluginLayout.class.getName());
    ((RecordConfigProvider)localObject2).G(1, TextStatusEditPhotoPluginLayout.class.getName());
    ((RecordConfigProvider)localObject2).G(0, TextStatusRecordPluginLayout.class.getName());
    CaptureDataManager.HKJ.a((CaptureDataManager.b)localObject1);
    localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
    com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)this, 2, com.tencent.mm.plugin.textstatus.b.a.sight_slide_bottom_in, com.tencent.mm.plugin.textstatus.b.a.sight_slide_bottom_out, (RecordConfigProvider)localObject2);
    AppMethodBeat.o(234102);
  }
  
  private final void gnf()
  {
    AppMethodBeat.i(234112);
    this.MMh.clear();
    this.MMi = 0;
    Object localObject;
    if (!Util.isNullOrNil(this.KJs))
    {
      localObject = (CharSequence)this.KJs;
      localObject = ((Collection)new kotlin.n.k(",").u((CharSequence)localObject, 0)).toArray(new String[0]);
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(234112);
        throw ((Throwable)localObject);
      }
      localObject = (String[])localObject;
      localObject = kotlin.a.j.listOf((String[])Arrays.copyOf((Object[])localObject, localObject.length));
      this.MMh.addAll((Collection)ip((List)localObject));
      this.MMi |= 0x1;
    }
    if (!Util.isNullOrNil(this.KJq))
    {
      localObject = (CharSequence)this.KJq;
      localObject = ((Collection)new kotlin.n.k(",").u((CharSequence)localObject, 0)).toArray(new String[0]);
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(234112);
        throw ((Throwable)localObject);
      }
      localObject = (String[])localObject;
      localObject = kotlin.a.j.listOf((String[])Arrays.copyOf((Object[])localObject, localObject.length));
      this.MMh.addAll(io((List)localObject));
      this.MMi |= 0x4;
    }
    if (!Util.isNullOrNil(this.KJr))
    {
      localObject = (CharSequence)this.KJr;
      localObject = ((Collection)new kotlin.n.k(",").u((CharSequence)localObject, 0)).toArray(new String[0]);
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(234112);
        throw ((Throwable)localObject);
      }
      localObject = (String[])localObject;
      localObject = kotlin.a.j.listOf((String[])Arrays.copyOf((Object[])localObject, localObject.length));
      this.MMh.addAll((Collection)localObject);
      this.MMi |= 0x2;
    }
    AppMethodBeat.o(234112);
  }
  
  private final void gng()
  {
    AppMethodBeat.i(234120);
    Object localObject = this.MLT;
    if (localObject == null) {
      p.bGy("curTextStatusExtInfo");
    }
    localObject = ((TextStatusExtInfo)localObject).poiName;
    if (!Util.isNullOrNil((String)localObject))
    {
      TextView localTextView = this.MBY;
      if (localTextView != null) {
        localTextView.setText((CharSequence)localObject);
      }
      ajm(0);
      AppMethodBeat.o(234120);
      return;
    }
    ajm(8);
    AppMethodBeat.o(234120);
  }
  
  private final void gnh()
  {
    AppMethodBeat.i(234128);
    Object localObject1 = this.MLT;
    if (localObject1 == null) {
      p.bGy("curTextStatusExtInfo");
    }
    localObject1 = ((TextStatusExtInfo)localObject1).topicInfo.sourceId;
    beF((String)localObject1);
    Object localObject2 = (CharSequence)localObject1;
    int i;
    if ((localObject2 == null) || (kotlin.n.n.ba((CharSequence)localObject2)))
    {
      i = 1;
      if (i != 0) {
        break label536;
      }
      gmR().setVisibility(0);
      localObject2 = gmS();
      TextStatusExtInfo localTextStatusExtInfo = this.MLT;
      if (localTextStatusExtInfo == null) {
        p.bGy("curTextStatusExtInfo");
      }
      ((TextView)localObject2).setText((CharSequence)localTextStatusExtInfo.topicInfo.sourceName);
      gmT().setVisibility(8);
      localObject2 = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject2 = getContext();
      p.j(localObject2, "context");
      localObject2 = (am)a.a.a((Context)localObject2, 8, am.class);
      if (localObject2 != null)
      {
        ((am)localObject2).MGg = ((String)localObject1);
        localObject1 = this.MLT;
        if (localObject1 == null) {
          p.bGy("curTextStatusExtInfo");
        }
        ((am)localObject2).MGh = ((TextStatusExtInfo)localObject1).topicInfo.sourceActivityId;
        localObject1 = this.MLT;
        if (localObject1 == null) {
          p.bGy("curTextStatusExtInfo");
        }
        ((am)localObject2).sourceName = ((TextStatusExtInfo)localObject1).topicInfo.sourceName;
        localObject1 = this.MLT;
        if (localObject1 == null) {
          p.bGy("curTextStatusExtInfo");
        }
        ((am)localObject2).sourceIcon = ((TextStatusExtInfo)localObject1).topicInfo.sourceIcon;
        localObject1 = this.MLT;
        if (localObject1 == null) {
          p.bGy("curTextStatusExtInfo");
        }
        localObject1 = (CharSequence)((TextStatusExtInfo)localObject1).mediaThumbUrl;
        if ((localObject1 != null) && (!kotlin.n.n.ba((CharSequence)localObject1))) {
          break label419;
        }
        i = 1;
        label265:
        if (i != 0)
        {
          localObject1 = this.MLT;
          if (localObject1 == null) {
            p.bGy("curTextStatusExtInfo");
          }
          localObject1 = (CharSequence)((TextStatusExtInfo)localObject1).mediaUrl;
          if ((localObject1 != null) && (!kotlin.n.n.ba((CharSequence)localObject1))) {
            break label424;
          }
          i = 1;
          label305:
          if (i != 0)
          {
            localObject1 = this.MKR;
            if (localObject1 == null) {
              break label429;
            }
            localObject1 = ((com.tencent.mm.plugin.textstatus.a.q)localObject1).mediaPath;
            label323:
            localObject1 = (CharSequence)localObject1;
            if ((localObject1 != null) && (!kotlin.n.n.ba((CharSequence)localObject1))) {
              break label434;
            }
            i = 1;
            label341:
            if (i != 0) {
              break label352;
            }
          }
        }
        ((am)localObject2).MGe = 4L;
      }
      label352:
      localObject1 = glQ();
      gmT().removeAllViews();
      if ((localObject1 == null) || (((com.tencent.mm.plugin.textstatus.a.c)localObject1).e(gmT()) != true)) {
        break label439;
      }
      i = 1;
      label382:
      if (i == 0) {
        break label444;
      }
      gmT().setVisibility(0);
      gmU().setVisibility(8);
    }
    for (;;)
    {
      gni();
      AppMethodBeat.o(234128);
      return;
      i = 0;
      break;
      label419:
      i = 0;
      break label265;
      label424:
      i = 0;
      break label305;
      label429:
      localObject1 = null;
      break label323;
      label434:
      i = 0;
      break label341;
      label439:
      i = 0;
      break label382;
      label444:
      gmT().setVisibility(8);
      localObject1 = this.MLT;
      if (localObject1 == null) {
        p.bGy("curTextStatusExtInfo");
      }
      localObject1 = ((TextStatusExtInfo)localObject1).topicInfo.sourceIcon;
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (kotlin.n.n.ba((CharSequence)localObject2))) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label524;
        }
        localObject2 = gmU();
        ((ImageView)localObject2).setVisibility(0);
        com.tencent.mm.ay.q.bml().loadImage((String)localObject1, (ImageView)localObject2);
        break;
      }
      label524:
      gmU().setVisibility(8);
      continue;
      label536:
      gmR().setVisibility(8);
    }
  }
  
  private final void gni()
  {
    AppMethodBeat.i(234130);
    Object localObject1 = this.MLT;
    if (localObject1 == null) {
      p.bGy("curTextStatusExtInfo");
    }
    localObject1 = ((TextStatusExtInfo)localObject1).topicInfo.sourceId;
    Object localObject2 = this.MLT;
    if (localObject2 == null) {
      p.bGy("curTextStatusExtInfo");
    }
    localObject2 = new TextStatusEditActivity.e((String)localObject1, (List)((TextStatusExtInfo)localObject2).topicInfo.jumpInfos);
    CharSequence localCharSequence = (CharSequence)localObject1;
    if ((localCharSequence == null) || (kotlin.n.n.ba(localCharSequence))) {}
    for (int i = 1; i == 0; i = 0)
    {
      if (!a((TextStatusEditActivity.e)localObject2))
      {
        gmr();
        gmK().removeAllViews();
        this.MJn = F((String)localObject1, ((TextStatusEditActivity.e)localObject2).yNX);
        this.MMk = ((TextStatusEditActivity.e)localObject2);
      }
      gmK().setVisibility(0);
      localObject1 = com.tencent.mm.plugin.textstatus.k.n.MOY;
      com.tencent.mm.plugin.textstatus.k.n.B((View)gmK(), com.tencent.mm.ci.a.fromDPToPix((Context)this, 12.0F));
      gnj();
      AppMethodBeat.o(234130);
      return;
    }
    gmr();
    gmK().removeAllViews();
    gmK().setVisibility(8);
    AppMethodBeat.o(234130);
  }
  
  private final void gnj()
  {
    AppMethodBeat.i(234132);
    com.tencent.mm.ui.widget.b localb = this.MJn;
    if (localb != null)
    {
      if (!localb.gZ)
      {
        localb.dDB();
        localb.dDE();
      }
      AppMethodBeat.o(234132);
      return;
    }
    AppMethodBeat.o(234132);
  }
  
  private final void gnk()
  {
    AppMethodBeat.i(234142);
    Object localObject1 = this.MLT;
    if (localObject1 == null) {
      p.bGy("curTextStatusExtInfo");
    }
    localObject1 = ((TextStatusExtInfo)localObject1).topicInfo.iconId;
    Object localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (kotlin.n.n.ba((CharSequence)localObject2))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject2 = com.tencent.mm.plugin.secdata.ui.a.JbV;
        localObject2 = (am)a.a.a((Context)this, 8, am.class);
        if (localObject2 != null) {
          ((am)localObject2).MFY.add(localObject1);
        }
        com.tencent.mm.plugin.textstatus.k.a.a(com.tencent.mm.plugin.textstatus.k.c.gnz(), this.MCg, (String)localObject1, null, null, null, 28);
      }
      AppMethodBeat.o(234142);
      return;
    }
  }
  
  private boolean gnl()
  {
    com.tencent.mm.plugin.textstatus.a.q localq = this.MKR;
    return (localq != null) && (localq.MEC == 5L);
  }
  
  private final void gnm()
  {
    AppMethodBeat.i(234152);
    if (!this.MMm)
    {
      gnp();
      Object localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject = getContext();
      p.j(localObject, "context");
      localObject = (am)a.a.a((Context)localObject, 8, am.class);
      if (localObject != null)
      {
        com.tencent.mm.plugin.textstatus.h.a locala = com.tencent.mm.plugin.textstatus.h.a.MGJ;
        com.tencent.mm.plugin.textstatus.h.a.a(this.MLW, (am)localObject);
      }
      this.MMm = true;
    }
    AppMethodBeat.o(234152);
  }
  
  private final void gnp()
  {
    long l2 = 0L;
    AppMethodBeat.i(234167);
    Object localObject1 = this.MLq;
    if (localObject1 == null) {
      p.bGy("etDesc");
    }
    localObject1 = ((MMEditText)localObject1).getText().toString();
    long l1;
    if (gnl())
    {
      localObject2 = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject2 = getContext();
      p.j(localObject2, "context");
      localObject2 = (am)a.a.a((Context)localObject2, 8, am.class);
      if (localObject2 != null)
      {
        if (((am)localObject2).MFY.size() <= 1) {
          break label257;
        }
        l1 = 1L;
        ((am)localObject2).MGj = l1;
      }
    }
    Object localObject2 = com.tencent.mm.plugin.secdata.ui.a.JbV;
    localObject2 = getContext();
    p.j(localObject2, "context");
    localObject2 = (am)a.a.a((Context)localObject2, 8, am.class);
    if (localObject2 != null)
    {
      ((am)localObject2).MGf = com.tencent.mm.ui.tools.g.a((String)localObject1, com.tencent.mm.ui.tools.g.a.XSu);
      TextStatusExtInfo localTextStatusExtInfo = this.MLT;
      if (localTextStatusExtInfo == null) {
        p.bGy("curTextStatusExtInfo");
      }
      if (Util.isNullOrNil(localTextStatusExtInfo.poiName))
      {
        l1 = 0L;
        label190:
        ((am)localObject2).MGs = l1;
        localTextStatusExtInfo = this.MLT;
        if (localTextStatusExtInfo == null) {
          p.bGy("curTextStatusExtInfo");
        }
        if (!k.a(localTextStatusExtInfo)) {
          break label267;
        }
        l1 = 1L;
        label223:
        ((am)localObject2).MGx = l1;
        if (!Util.isEqual(((am)localObject2).MGC, (String)localObject1)) {
          break label272;
        }
      }
      label257:
      label267:
      label272:
      for (l1 = l2;; l1 = 1L)
      {
        ((am)localObject2).MGi = l1;
        AppMethodBeat.o(234167);
        return;
        l1 = 0L;
        break;
        l1 = 1L;
        break label190;
        l1 = 0L;
        break label223;
      }
    }
    AppMethodBeat.o(234167);
  }
  
  private final void gnq()
  {
    AppMethodBeat.i(234168);
    Object localObject = this.MLq;
    if (localObject == null) {
      p.bGy("etDesc");
    }
    ((MMEditText)localObject).setEnableSendBtn(true);
    localObject = this.MLq;
    if (localObject == null) {
      p.bGy("etDesc");
    }
    ((MMEditText)localObject).setImeOptions(6);
    if (com.tencent.mm.plugin.textstatus.a.t.gln())
    {
      if (!gnr())
      {
        Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "initEditText allow input text");
        localObject = this.MLq;
        if (localObject == null) {
          p.bGy("etDesc");
        }
        ((MMEditText)localObject).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this.MLX);
        localObject = this.MLq;
        if (localObject == null) {
          p.bGy("etDesc");
        }
        ((MMEditText)localObject).post((Runnable)new u(this));
        localObject = this.MLF;
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1629L, 0L, 1L, false);
        gmY();
        AppMethodBeat.o(234168);
      }
    }
    else if (!gnr())
    {
      Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "initEditText not allow input text");
      localObject = this.MLq;
      if (localObject == null) {
        p.bGy("etDesc");
      }
      ((MMEditText)localObject).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this.MLY);
      localObject = this.MLq;
      if (localObject == null) {
        p.bGy("etDesc");
      }
      ((MMEditText)localObject).setShowSoftInputOnFocus(false);
      hideVKB();
      localObject = this.MLq;
      if (localObject == null) {
        p.bGy("etDesc");
      }
      ((MMEditText)localObject).setOnLongClickListener((View.OnLongClickListener)TextStatusEditActivity.v.MML);
      localObject = this.MLq;
      if (localObject == null) {
        p.bGy("etDesc");
      }
      ((MMEditText)localObject).setOnTouchListener((View.OnTouchListener)new w(this));
      localObject = this.MLq;
      if (localObject == null) {
        p.bGy("etDesc");
      }
      ((MMEditText)localObject).post((Runnable)new x(this));
      localObject = this.MLF;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1629L, 1L, 1L, false);
      gmY();
    }
    AppMethodBeat.o(234168);
  }
  
  private final boolean gnr()
  {
    AppMethodBeat.i(234169);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    if (((com.tencent.mm.kernel.f)localObject).aHp().getInt(ar.a.VDN, 1) == 1) {}
    for (int i = 1;; i = 0)
    {
      localObject = com.tencent.mm.kernel.h.aHG();
      p.j(localObject, "MMKernel.storage()");
      boolean bool = ((com.tencent.mm.kernel.f)localObject).aHp().getBoolean(ar.a.VDW, false);
      if ((i == 0) || (bool)) {
        break;
      }
      localObject = findViewById(b.e.MuX);
      p.j(localObject, "findViewById<View>(R.id.education_layout)");
      ((View)localObject).setVisibility(0);
      localObject = findViewById(b.e.MuX);
      p.j(localObject, "findViewById<View>(R.id.education_layout)");
      ((View)localObject).setBackground((Drawable)new BitmapDrawable(getResources(), BitmapUtil.getBitmapNative(this.MLU)));
      localObject = this.MLf;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject = (am)a.a.a((Context)this, 8, am.class);
      if (localObject != null) {
        ((am)localObject).MED = 1;
      }
      com.tencent.mm.plugin.textstatus.a.t.gld();
      localObject = com.tencent.mm.kernel.h.aHG();
      p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VDN, Integer.valueOf(0));
      findViewById(b.e.MuW).setOnClickListener((View.OnClickListener)new bd(this));
      Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "show education");
      AppMethodBeat.o(234169);
      return true;
    }
    AppMethodBeat.o(234169);
    return false;
  }
  
  private final void gv(final String paramString, int paramInt)
  {
    AppMethodBeat.i(234072);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (kotlin.n.n.ba((CharSequence)localObject1))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(234072);
      return;
    }
    localObject1 = this.MLJ;
    if (localObject1 == null) {
      p.bGy("layoutBlurOption");
    }
    if ((this.kFs == 2) || (this.MMj))
    {
      i = 8;
      ((View)localObject1).setVisibility(i);
      if (paramInt != 2) {
        break label838;
      }
      Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "handle video file");
      gmJ().setVisibility(8);
      localObject1 = this.MJb;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).setVisibility(0);
      }
      localObject1 = this.MLu;
      if (localObject1 == null) {
        break label237;
      }
      paramInt = ((View)localObject1).getMeasuredWidth();
      label141:
      localObject1 = this.MLu;
      if (localObject1 == null) {
        break label242;
      }
      i = ((View)localObject1).getMeasuredHeight();
      label158:
      localObject1 = new FrameLayout.LayoutParams(paramInt, i);
      ((FrameLayout.LayoutParams)localObject1).gravity = 17;
      if (this.Bba != null) {
        break label247;
      }
      localObject2 = getContext();
      p.j(localObject2, "context");
      this.Bba = new MMTPEffectVideoLayout((Context)localObject2, (byte)0);
    }
    MMTPEffectVideoLayout localMMTPEffectVideoLayout;
    for (;;)
    {
      localMMTPEffectVideoLayout = this.Bba;
      if (localMMTPEffectVideoLayout != null) {
        break label272;
      }
      AppMethodBeat.o(234072);
      return;
      i = 0;
      break;
      label237:
      paramInt = 0;
      break label141;
      label242:
      i = 0;
      break label158;
      label247:
      localObject2 = this.Bba;
      if (localObject2 != null) {
        ((MMTPEffectVideoLayout)localObject2).MUh.YIy.release();
      }
    }
    label272:
    Object localObject2 = this.MJb;
    if (localObject2 != null) {
      ((FrameLayout)localObject2).removeAllViews();
    }
    localObject2 = this.MJb;
    if (localObject2 != null) {
      ((FrameLayout)localObject2).addView((View)localMMTPEffectVideoLayout, (ViewGroup.LayoutParams)localObject1);
    }
    localObject1 = this.MJb;
    if (localObject1 != null) {
      ((FrameLayout)localObject1).setVisibility(0);
    }
    boolean bool = u.agG(paramString);
    label401:
    label406:
    label498:
    long l;
    if (!bool)
    {
      localObject1 = kotlin.n.d.UTF_8;
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(234072);
        throw paramString;
      }
      localObject1 = paramString.getBytes((Charset)localObject1);
      p.j(localObject1, "(this as java.lang.String).getBytes(charset)");
      localObject1 = com.tencent.xweb.util.d.getMessageDigest((byte[])localObject1);
      if (bool) {
        break label727;
      }
      localObject2 = paramString;
      if (!bool) {
        break label735;
      }
      TextStatusExtInfo localTextStatusExtInfo = this.MLT;
      if (localTextStatusExtInfo == null) {
        p.bGy("curTextStatusExtInfo");
      }
      paramInt = localTextStatusExtInfo.mediaWidth;
      localTextStatusExtInfo = this.MLT;
      if (localTextStatusExtInfo == null) {
        p.bGy("curTextStatusExtInfo");
      }
      i = localTextStatusExtInfo.mediaHeight;
      p.j(localObject1, "mediaId");
      localObject1 = new com.tencent.mm.plugin.thumbplayer.e.d((String)localObject1, paramString, (String)localObject2, paramInt, i);
      if (bool)
      {
        paramString = MultiMediaVideoChecker.NmA.bfs(paramString);
        if (paramString == null) {
          break label761;
        }
        paramInt = paramString.width;
        ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).width = paramInt;
        if (paramString == null) {
          break label766;
        }
        paramInt = paramString.height;
        label513:
        ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).height = paramInt;
        if (paramString == null) {
          break label771;
        }
        l = paramString.duration;
        label529:
        ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).sTg = l;
        if (paramString == null) {
          break label777;
        }
      }
    }
    label771:
    label777:
    for (paramInt = paramString.fSM;; paramInt = 0)
    {
      ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).fSM = paramInt;
      ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).fEF = bool;
      Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "[play] isLocal:%s, videoWidth:%s, videoHeight:%s rotate:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).width), Integer.valueOf(((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).height), Integer.valueOf(((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).fSM) });
      localMMTPEffectVideoLayout.goU();
      localMMTPEffectVideoLayout.setMediaInfo((com.tencent.mm.plugin.thumbplayer.e.d)localObject1);
      paramString = localMMTPEffectVideoLayout.getPlayer();
      if (paramString != null) {
        paramString.ALj = true;
      }
      paramString = localMMTPEffectVideoLayout.getPlayer();
      if (paramString != null) {
        paramString.setLoop(true);
      }
      localMMTPEffectVideoLayout.getEffectManager().ikd();
      this.Bba = localMMTPEffectVideoLayout;
      try
      {
        paramString = localMMTPEffectVideoLayout.getPlayer();
        if (paramString != null) {
          paramString.gos();
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.e("MicroMsg.TextStatus.TextStatusEditActivity", "unable to play video! mediaInfo:" + localObject1 + " error:" + paramString.getLocalizedMessage());
          paramString = this.MJb;
          if (paramString != null) {
            paramString.setVisibility(8);
          }
        }
      }
      paramString = com.tencent.mm.plugin.textstatus.k.n.MOY;
      com.tencent.mm.plugin.textstatus.k.n.B((View)this.MJb, com.tencent.mm.ci.a.fromDPToPix((Context)this, 12.0F));
      gmZ();
      AppMethodBeat.o(234072);
      return;
      localObject1 = "";
      break;
      label727:
      localObject2 = "";
      break label401;
      label735:
      paramString = com.tencent.mm.plugin.textstatus.k.f.MOw;
      paramString = com.tencent.mm.plugin.auth.a.a.crN();
      p.j(paramString, "Account.username()");
      paramString = com.tencent.mm.plugin.textstatus.k.f.lD("video", paramString);
      break label406;
      label761:
      paramInt = 0;
      break label498;
      label766:
      paramInt = 0;
      break label513;
      l = 0L;
      break label529;
    }
    label838:
    com.tencent.e.h.ZvG.be((Runnable)new r(this, paramString));
    AppMethodBeat.o(234072);
  }
  
  private static Collection<String> io(List<String> paramList)
  {
    AppMethodBeat.i(234117);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      HashSet localHashSet = new HashSet();
      for (;;)
      {
        if (paramList.hasNext())
        {
          localObject = (String)paramList.next();
          localObject = com.tencent.mm.plugin.label.a.a.eLe().aMR(com.tencent.mm.plugin.label.a.a.eLe().aMO((String)localObject));
          if ((localObject != null) && (((List)localObject).size() != 0)) {}
        }
        else
        {
          paramList = (Collection)new ArrayList((Collection)localHashSet);
          AppMethodBeat.o(234117);
          return paramList;
        }
        Object localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localHashSet.add((String)((Iterator)localObject).next());
        }
      }
    }
    paramList = (Collection)new ArrayList();
    AppMethodBeat.o(234117);
    return paramList;
  }
  
  private static List<String> ip(List<String> paramList)
  {
    AppMethodBeat.i(234118);
    LinkedList localLinkedList = new LinkedList();
    if (!com.tencent.mm.kernel.h.aHE().aGM())
    {
      paramList = (List)localLinkedList;
      AppMethodBeat.o(234118);
      return paramList;
    }
    if (paramList == null)
    {
      paramList = (List)localLinkedList;
      AppMethodBeat.o(234118);
      return paramList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = v.Pt((String)paramList.next());
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if ((!localLinkedList.contains(str)) && (ab.Ql(str))) {
            localLinkedList.add(str);
          }
        }
      }
    }
    paramList = (List)localLinkedList;
    AppMethodBeat.o(234118);
    return paramList;
  }
  
  public final void A(int paramInt, boolean paramBoolean)
  {
    int[] arrayOfInt = null;
    AppMethodBeat.i(234086);
    Log.d("MicroMsg.TextStatus.TextStatusEditActivity", "keyboardHeight " + paramInt + ", " + paramBoolean);
    Object localObject = this.MMd;
    if (localObject == null)
    {
      this.MMd = Integer.valueOf(paramInt);
      localObject = this.MMa;
      if (localObject != null) {
        ((e)localObject).dismiss();
      }
      if (paramInt <= 0) {
        break label279;
      }
      int i = aw.aZ((Context)getContext(), b.c.Edge_2A);
      localObject = this.MLA;
      if (localObject != null) {
        ((View)localObject).setTranslationY(Math.min(-(paramInt - i), 0.0F));
      }
      localObject = this.MLy;
      if (localObject == null) {
        break label273;
      }
      localObject = com.tencent.mm.ae.d.cF((View)localObject);
      label138:
      View localView = this.MLA;
      if (localView != null) {
        arrayOfInt = com.tencent.mm.ae.d.cF(localView);
      }
      localView = this.MLy;
      if ((localObject != null) && (arrayOfInt != null) && (localView != null)) {
        localView.setTranslationY(Math.min((arrayOfInt[1] - localObject[1]) / 2 - localView.getMeasuredHeight() / 3, 0.0F));
      }
    }
    for (;;)
    {
      if ((!com.tencent.mm.plugin.textstatus.a.t.gln()) && (paramInt > 0))
      {
        localObject = this.MLq;
        if (localObject == null) {
          p.bGy("etDesc");
        }
        ((MMEditText)localObject).post((Runnable)new TextStatusEditActivity.aw(this));
      }
      AppMethodBeat.o(234086);
      return;
      if (((Integer)localObject).intValue() != paramInt) {
        break;
      }
      AppMethodBeat.o(234086);
      return;
      label273:
      localObject = null;
      break label138;
      label279:
      localObject = getWindow();
      p.j(localObject, "window");
      ((Window)localObject).setNavigationBarColor(getResources().getColor(b.b.Dark_2));
      localObject = this.MLy;
      if (localObject != null) {
        ((View)localObject).setTranslationY(0.0F);
      }
      localObject = this.MLA;
      if (localObject != null) {
        ((View)localObject).setTranslationY(0.0F);
      }
    }
  }
  
  public final void aLs(String paramString)
  {
    AppMethodBeat.i(234092);
    Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "onPressEmoji : ".concat(String.valueOf(paramString)));
    Object localObject = this.MLq;
    if (localObject == null) {
      p.bGy("etDesc");
    }
    localObject = ((MMEditText)localObject).getText().toString();
    if (com.tencent.mm.ui.tools.g.a((String)localObject + paramString, com.tencent.mm.ui.tools.g.a.XSu) > 64)
    {
      paramString = com.tencent.mm.plugin.secdata.ui.a.JbV;
      paramString = getContext();
      p.j(paramString, "context");
      paramString = (am)a.a.a((Context)paramString, 8, am.class);
      if (paramString != null)
      {
        paramString.MGl = (1L + paramString.MGl);
        AppMethodBeat.o(234092);
        return;
      }
      AppMethodBeat.o(234092);
      return;
    }
    localObject = this.MLq;
    if (localObject == null) {
      p.bGy("etDesc");
    }
    ((MMEditText)localObject).bBa(paramString);
    AppMethodBeat.o(234092);
  }
  
  public final void abc(String paramString)
  {
    AppMethodBeat.i(234165);
    Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "Set New textStatus : " + Util.secPrint(paramString));
    paramString = this.MMn;
    if (paramString == null) {
      p.bGy("curLocalMediaStruct");
    }
    if (paramString.MMs)
    {
      paramString = (Context)this;
      getString(b.h.processing);
      this.syZ = ((ProgressDialog)com.tencent.mm.ui.base.h.a(paramString, getString(b.h.processing), false, null));
      com.tencent.e.h.ZvG.be((Runnable)new h(this));
      AppMethodBeat.o(234165);
      return;
    }
    gno();
    AppMethodBeat.o(234165);
  }
  
  public final void abd(String paramString)
  {
    AppMethodBeat.i(234156);
    if (com.tencent.mm.plugin.textstatus.a.t.gln()) {
      com.tencent.mm.ui.base.w.w((Context)this, getString(b.h.settings_modify_text_status_invalid_less), b.g.icons_outlined_info);
    }
    for (;;)
    {
      paramString = com.tencent.mm.plugin.secdata.ui.a.JbV;
      paramString = getContext();
      p.j(paramString, "context");
      paramString = (am)a.a.a((Context)paramString, 8, am.class);
      if (paramString == null) {
        break;
      }
      paramString.MGm = (1L + paramString.MGm);
      AppMethodBeat.o(234156);
      return;
      com.tencent.mm.ui.base.w.w((Context)this, getString(b.h.settings_modify_text_status_emoji_invalid_less), b.g.icons_outlined_info);
    }
    AppMethodBeat.o(234156);
  }
  
  public final void dN(String paramString)
  {
    AppMethodBeat.i(234159);
    com.tencent.mm.ui.base.w.w((Context)this, getString(b.h.settings_modify_text_status_invalid_more), b.g.icons_outlined_info);
    paramString = com.tencent.mm.plugin.secdata.ui.a.JbV;
    paramString = getContext();
    p.j(paramString, "context");
    paramString = (am)a.a.a((Context)paramString, 8, am.class);
    if (paramString != null)
    {
      paramString.MGl = (1L + paramString.MGl);
      AppMethodBeat.o(234159);
      return;
    }
    AppMethodBeat.o(234159);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(234150);
    hideVKB();
    gnm();
    super.finish();
    AppMethodBeat.o(234150);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.f.MxL;
  }
  
  public final void glC()
  {
    AppMethodBeat.i(234094);
    Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "onDeleteEmoji");
    Object localObject = this.MLq;
    if (localObject == null) {
      p.bGy("etDesc");
    }
    localObject = ((MMEditText)localObject).getInputConnection();
    if (localObject != null)
    {
      ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
      ((InputConnection)localObject).sendKeyEvent(new KeyEvent(1, 67));
      AppMethodBeat.o(234094);
      return;
    }
    AppMethodBeat.o(234094);
  }
  
  public final MMEditText gmI()
  {
    AppMethodBeat.i(234017);
    MMEditText localMMEditText = this.MLq;
    if (localMMEditText == null) {
      p.bGy("etDesc");
    }
    AppMethodBeat.o(234017);
    return localMMEditText;
  }
  
  public final ImageView gmM()
  {
    AppMethodBeat.i(234025);
    ImageView localImageView = this.MBW;
    if (localImageView == null) {
      p.bGy("vBack");
    }
    AppMethodBeat.o(234025);
    return localImageView;
  }
  
  public final View gmN()
  {
    AppMethodBeat.i(234028);
    View localView = this.MLG;
    if (localView == null) {
      p.bGy("btnOk");
    }
    AppMethodBeat.o(234028);
    return localView;
  }
  
  public final TextStatusExtInfo gmW()
  {
    AppMethodBeat.i(234047);
    TextStatusExtInfo localTextStatusExtInfo = this.MLT;
    if (localTextStatusExtInfo == null) {
      p.bGy("curTextStatusExtInfo");
    }
    AppMethodBeat.o(234047);
    return localTextStatusExtInfo;
  }
  
  public final void gnd()
  {
    AppMethodBeat.i(234099);
    Intent localIntent = new Intent();
    Object localObject = this.MLT;
    if (localObject == null) {
      p.bGy("curTextStatusExtInfo");
    }
    localObject = (CharSequence)((TextStatusExtInfo)localObject).poiId;
    if ((localObject == null) || (kotlin.n.n.ba((CharSequence)localObject))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.MLT;
        if (localObject == null) {
          p.bGy("curTextStatusExtInfo");
        }
        localIntent.putExtra("get_poi_classify_id", ((TextStatusExtInfo)localObject).poiId);
      }
      localObject = this.MLT;
      if (localObject == null) {
        p.bGy("curTextStatusExtInfo");
      }
      localIntent.putExtra("get_lat", ((TextStatusExtInfo)localObject).latitude);
      localObject = this.MLT;
      if (localObject == null) {
        p.bGy("curTextStatusExtInfo");
      }
      localIntent.putExtra("get_lng", ((TextStatusExtInfo)localObject).longitude);
      localIntent.putExtra("near_life_scene", 1);
      com.tencent.mm.by.c.b((Context)getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, 10);
      AppMethodBeat.o(234099);
      return;
    }
  }
  
  public final c gnn()
  {
    AppMethodBeat.i(234162);
    c localc = this.MMn;
    if (localc == null) {
      p.bGy("curLocalMediaStruct");
    }
    AppMethodBeat.o(234162);
    return localc;
  }
  
  public final void gno()
  {
    String str = null;
    AppMethodBeat.i(234164);
    hideVKB();
    Object localObject1 = this.MLq;
    if (localObject1 == null) {
      p.bGy("etDesc");
    }
    Object localObject5 = ((MMEditText)localObject1).getText();
    switch (this.KJo)
    {
    }
    Object localObject2;
    al localal;
    int i;
    Object localObject4;
    TextStatusTopicInfo localTextStatusTopicInfo;
    for (localObject1 = null;; localObject1 = this.MMh)
    {
      localObject2 = com.tencent.mm.plugin.textstatus.g.g.d.MEw;
      localal = new al();
      localObject2 = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject2 = getContext();
      p.j(localObject2, "context");
      localObject2 = (am)a.a.a((Context)localObject2, 8, am.class);
      if (localObject2 != null) {
        localal.MFV = ((am)localObject2).MFV;
      }
      localObject2 = this.MMn;
      if (localObject2 == null) {
        p.bGy("curLocalMediaStruct");
      }
      i = ((c)localObject2).mediaType;
      localObject2 = this.MMn;
      if (localObject2 == null) {
        p.bGy("curLocalMediaStruct");
      }
      localObject4 = ((c)localObject2).MMq;
      localObject2 = localObject4;
      if (localObject4 == null) {
        localObject2 = "";
      }
      localal.MFQ = ((String)localObject2);
      localObject2 = this.MMn;
      if (localObject2 == null) {
        p.bGy("curLocalMediaStruct");
      }
      localal.thumbPath = ((c)localObject2).MMr;
      localObject2 = this.MMn;
      if (localObject2 == null) {
        p.bGy("curLocalMediaStruct");
      }
      localal.MFP = ((c)localObject2).MFP;
      localObject4 = this.MLT;
      if (localObject4 == null) {
        p.bGy("curTextStatusExtInfo");
      }
      ((TextStatusExtInfo)localObject4).mediaType = i;
      localTextStatusTopicInfo = ((TextStatusExtInfo)localObject4).topicInfo;
      localObject2 = localTextStatusTopicInfo.topics;
      if (localObject2 != null) {
        ((LinkedList)localObject2).clear();
      }
      localObject2 = com.tencent.mm.plugin.textstatus.k.m.MOX;
      localObject2 = com.tencent.mm.plugin.textstatus.k.m.gnM().matcher((CharSequence)localObject5.toString());
      while (((Matcher)localObject2).find()) {
        localTextStatusTopicInfo.topics.add(((Matcher)localObject2).group(1));
      }
    }
    if (p.h(localTextStatusTopicInfo.iconId, "custom"))
    {
      localObject2 = this.MBS;
      if (localObject2 == null) {
        break label808;
      }
      localObject2 = ((TextView)localObject2).getText();
      if (localObject2 == null) {
        break label808;
      }
      localObject2 = localObject2.toString();
    }
    for (;;)
    {
      localTextStatusTopicInfo.title = ((String)localObject2);
      ((TextStatusExtInfo)localObject4).visibility = 0;
      ((TextStatusExtInfo)localObject4).description = localObject5.toString();
      int j = com.tencent.mm.ui.tools.g.a(((TextStatusExtInfo)localObject4).description, com.tencent.mm.ui.tools.g.a.XSu);
      if (j > 64) {
        localObject2 = com.tencent.mm.ui.tools.g.hV(((TextStatusExtInfo)localObject4).description, 64);
      }
      try
      {
        ((TextStatusExtInfo)localObject4).description = ((TextStatusExtInfo)localObject4).description.subSequence(0, ((String)localObject2).length()).toString();
        Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "check desc " + Util.secPrint(((TextStatusExtInfo)localObject4).description) + " count:" + j);
        if (((TextStatusExtInfo)localObject4).createTime == 0) {
          ((TextStatusExtInfo)localObject4).createTime = cm.bfF();
        }
        ((TextStatusExtInfo)localObject4).expireTime = (((TextStatusExtInfo)localObject4).createTime + 86400);
        if (localal.MFP)
        {
          localObject2 = com.tencent.mm.plugin.textstatus.k.m.MOX;
          ((TextStatusExtInfo)localObject4).backgroundId = com.tencent.mm.plugin.textstatus.k.m.ajo(this.MLU);
          if (this.kFs == 2)
          {
            localObject2 = com.tencent.mm.plugin.textstatus.b.f.MAm;
            localObject2 = this.MKR;
            if (localObject2 == null) {
              break label979;
            }
            localObject2 = ((com.tencent.mm.plugin.textstatus.a.q)localObject2).MEJ;
            localObject5 = com.tencent.mm.plugin.textstatus.b.f.bep((String)localObject2);
            if (localObject5 == null) {
              break label985;
            }
            localObject2 = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject5).field_UserName;
            ((TextStatusExtInfo)localObject4).referenceUsername = ((String)localObject2);
            if (localObject5 == null) {
              break label991;
            }
            localObject2 = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject5).field_StatusID;
            ((TextStatusExtInfo)localObject4).referenceTextStatusId = ((String)localObject2);
          }
          localal.MFN = ((TextStatusExtInfo)localObject4);
          localal.MFO = ((LinkedList)localObject1);
          if (this.kFs == 1)
          {
            localObject2 = com.tencent.mm.plugin.textstatus.b.f.MAm;
            localObject2 = this.MKR;
            if (localObject2 == null) {
              break label997;
            }
            localObject2 = ((com.tencent.mm.plugin.textstatus.a.q)localObject2).MEJ;
            localObject4 = com.tencent.mm.plugin.textstatus.b.f.bep((String)localObject2);
            localObject2 = str;
            if (localObject4 != null) {
              localObject2 = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject4).field_StatusID;
            }
            localal.MEN = ((String)localObject2);
          }
          str = localal.MEN;
          localObject2 = str;
          if (str == null) {
            localObject2 = "";
          }
          localal.MEN = ((String)localObject2);
          localal.MFW = bP((LinkedList)localObject1);
          com.tencent.mm.plugin.textstatus.g.g.d.c(localal);
          if ((gnl()) || (this.kFs == 2)) {
            com.tencent.mm.ui.base.w.w((Context)this, getString(b.h.app_set_success), b.g.icons_outlined_done);
          }
          setResult(-1);
          this.MLW = true;
          finish();
          AppMethodBeat.o(234164);
          return;
          label808:
          localObject2 = null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.TextStatus.TextStatusEditActivity", "doWhenOK replace: " + localException.getMessage());
          continue;
          if ((((TextStatusExtInfo)localObject4).mediaWidth == 0) && (((TextStatusExtInfo)localObject4).mediaHeight == 0))
          {
            Object localObject3;
            if (i == 1)
            {
              localObject3 = BitmapUtil.getImageOptions(localal.MFQ);
              if (localObject3 != null)
              {
                ((TextStatusExtInfo)localObject4).mediaWidth = ((BitmapFactory.Options)localObject3).outWidth;
                ((TextStatusExtInfo)localObject4).mediaHeight = ((BitmapFactory.Options)localObject3).outHeight;
              }
              ((TextStatusExtInfo)localObject4).backgroundId = null;
            }
            else if (i == 2)
            {
              localObject3 = MultiMediaVideoChecker.NmA;
              localObject5 = localal.MFQ;
              p.j(localObject5, "uploadFilePath");
              localObject3 = ((MultiMediaVideoChecker)localObject3).bfs((String)localObject5);
              if (localObject3 != null)
              {
                ((TextStatusExtInfo)localObject4).mediaWidth = ((MultiMediaVideoChecker.a)localObject3).width;
                ((TextStatusExtInfo)localObject4).mediaHeight = ((MultiMediaVideoChecker.a)localObject3).height;
              }
              ((TextStatusExtInfo)localObject4).backgroundId = null;
              continue;
              label979:
              localObject3 = null;
              continue;
              label985:
              localObject3 = null;
              continue;
              label991:
              localObject3 = null;
              continue;
              label997:
              localObject3 = null;
            }
          }
        }
      }
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(234109);
    Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "onActivityResult");
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject1;
    Object localObject2;
    label323:
    label338:
    Object localObject3;
    switch (paramInt1)
    {
    case 5: 
    case 9: 
    default: 
      AppMethodBeat.o(234109);
      return;
    case 8: 
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = paramIntent.getByteArrayExtra("SELECT_OBJECT");
        if (paramIntent != null)
        {
          localObject1 = new FinderObject();
          ((FinderObject)localObject1).parseFrom(paramIntent);
          paramIntent = com.tencent.mm.plugin.secdata.ui.a.JbV;
          paramIntent = getContext();
          p.j(paramIntent, "context");
          paramIntent = (am)a.a.a((Context)paramIntent, 8, am.class);
          if (paramIntent != null)
          {
            paramIntent.MGr = (1L + paramIntent.MGr);
            localObject2 = com.tencent.mm.plugin.finder.gallery.f.xUa;
            paramIntent.MGF = com.tencent.mm.plugin.finder.gallery.f.getSessionId();
          }
          gnb();
          paramIntent = ac.AEJ;
          localObject2 = ((FinderObject)localObject1).nickname;
          paramIntent = ((FinderObject)localObject1).contact;
          if (paramIntent != null) {}
          for (paramIntent = paramIntent.headUrl;; paramIntent = null)
          {
            paramIntent = ac.a.a((String)localObject2, paramIntent, ((FinderObject)localObject1).id, (FinderObject)localObject1).MEA.topicInfo;
            localObject1 = this.MLT;
            if (localObject1 == null) {
              p.bGy("curTextStatusExtInfo");
            }
            localObject1 = ((TextStatusExtInfo)localObject1).topicInfo;
            p.j(localObject1, "curTextStatusExtInfo.topicInfo");
            b((TextStatusTopicInfo)localObject1, paramIntent);
            gnh();
            AppMethodBeat.o(234109);
            return;
          }
        }
      }
      AppMethodBeat.o(234109);
      return;
    case 2: 
      if (paramIntent != null)
      {
        localObject1 = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
        if (localObject1 != null)
        {
          paramIntent = null;
          if (!((SightCaptureResult)localObject1).wRb) {
            break label558;
          }
          paramIntent = ((SightCaptureResult)localObject1).EYc;
          if (!((SightCaptureResult)localObject1).wRb) {
            break label575;
          }
          localObject2 = ((SightCaptureResult)localObject1).EYb;
          Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "[handleCaptureResult]isVideo:%s,thumbPath:%s,filePath:%s", new Object[] { Boolean.valueOf(((SightCaptureResult)localObject1).wRb), paramIntent, localObject2 });
          gnb();
          paramIntent = this.MMn;
          if (paramIntent == null) {
            p.bGy("curLocalMediaStruct");
          }
          localObject3 = getContext();
          p.j(localObject3, "context");
          localObject3 = (Context)localObject3;
          p.k(localObject1, "captureResult");
          p.k(localObject3, "context");
          paramIntent.reset();
          k.b(paramIntent.MLT);
          paramIntent.MFP = false;
          if (!((SightCaptureResult)localObject1).wRb) {
            break label585;
          }
          paramIntent.mediaType = 2;
          paramIntent.MMq = ((SightCaptureResult)localObject1).EYb;
          paramIntent.MMr = ((SightCaptureResult)localObject1).EYc;
          paramIntent.sTg = ((SightCaptureResult)localObject1).EYf;
          paramIntent.MMv = u.bBQ(paramIntent.MMq);
          paramIntent.MMt = paramIntent.MMv;
          paramIntent.MMu = com.tencent.xweb.util.d.getMD5(paramIntent.MMq);
          paramIntent.iw((Context)localObject3);
          if (!((SightCaptureResult)localObject1).wRb) {
            break label607;
          }
        }
      }
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        gv((String)localObject2, paramInt1);
        gmZ();
        gnh();
        AppMethodBeat.o(234109);
        return;
        localObject1 = null;
        break;
        if (!((SightCaptureResult)localObject1).EXZ) {
          break label323;
        }
        paramIntent = ((SightCaptureResult)localObject1).EYh;
        break label323;
        localObject2 = ((SightCaptureResult)localObject1).EYh;
        break label338;
        paramIntent.mediaType = 1;
        paramIntent.MMq = ((SightCaptureResult)localObject1).EYh;
        paramIntent.MMs = true;
        break label484;
      }
    case 6: 
      label484:
      this.MMl = "";
      label558:
      label575:
      label585:
      label607:
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        localObject3 = paramIntent.getStringArrayListExtra("key_select_video_list");
        localObject2 = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
        if (((localObject3 != null) && (((ArrayList)localObject3).size() > 0)) || (!Util.isNullOrNil((String)localObject2))) {
          if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
          {
            localObject1 = ((ArrayList)localObject3).get(0);
            p.j(localObject1, "videoPathList[0]");
            localObject1 = (String)localObject1;
            this.MMl = ((String)localObject1);
            localObject1 = (CharSequence)localObject2;
            if ((localObject1 != null) && (!kotlin.n.n.ba((CharSequence)localObject1))) {
              break label957;
            }
            paramInt1 = 1;
            if (paramInt1 != 0) {
              break label962;
            }
            localObject1 = localObject2;
            label739:
            localObject2 = paramIntent.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
            if ((!Util.isNullOrNil((String)localObject2)) && (u.agG((String)localObject2))) {
              break label1635;
            }
            localObject2 = beG((String)localObject1);
          }
        }
      }
      label703:
      label731:
      break;
    }
    label957:
    label962:
    label1635:
    for (;;)
    {
      Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "video path %s thumb path %s and %s %s ", new Object[] { localObject1, localObject2, Long.valueOf(u.bBQ((String)localObject1)), Long.valueOf(u.bBQ((String)localObject2)) });
      paramIntent = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      if (paramIntent != null)
      {
        localObject3 = com.tencent.mm.plugin.secdata.ui.a.JbV;
        localObject3 = getContext();
        p.j(localObject3, "getContext()");
        localObject3 = (am)a.a.a((Context)localObject3, 8, am.class);
        if (localObject3 != null)
        {
          paramIntent = paramIntent.fvU().x("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", Long.valueOf(0L));
          p.j(paramIntent, "it.reportInfo.getReportV…DIA_DURATION_MS_LONG, 0L)");
          ((am)localObject3).MGb = ((Number)paramIntent).longValue();
          paramIntent = this.MKR;
          if ((paramIntent != null) && (paramIntent.MEC == 5L)) {
            ((am)localObject3).MGk = 1L;
          }
        }
      }
      S(2, (String)localObject1, (String)localObject2);
      AppMethodBeat.o(234109);
      return;
      localObject1 = "";
      break label703;
      paramInt1 = 0;
      break label731;
      if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
      {
        localObject1 = (String)((ArrayList)localObject3).get(0);
        break label739;
      }
      localObject1 = "";
      break label739;
      paramIntent = paramIntent.getStringArrayListExtra("key_select_image_list");
      if ((paramIntent == null) || (paramIntent.size() == 0))
      {
        Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "no image selected");
        AppMethodBeat.o(234109);
        return;
      }
      S(1, (String)paramIntent.get(0), "");
      AppMethodBeat.o(234109);
      return;
      if ((paramInt2 != -1) || (paramIntent == null)) {
        break;
      }
      paramIntent = paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      p.j(paramIntent, "data.getParcelableExtra(…mageUI.KSEGMENTMEDIAINFO)");
      paramIntent = (CaptureDataManager.CaptureVideoNormalModel)paramIntent;
      S(2, paramIntent.getVideoPath(), paramIntent.aZe());
      AppMethodBeat.o(234109);
      return;
      if (paramInt2 != -1) {
        break;
      }
      localObject1 = this.MLT;
      if (localObject1 == null) {
        p.bGy("curTextStatusExtInfo");
      }
      localObject3 = ((TextStatusExtInfo)localObject1).topicInfo;
      if (paramIntent != null)
      {
        localObject2 = paramIntent.getStringExtra("STATUS_TYPE_IMG");
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      ((TextStatusTopicInfo)localObject3).iconId = ((String)localObject1);
      gnk();
      if (paramIntent != null)
      {
        localObject1 = paramIntent.getStringExtra("STATUS_TYPE_NAME");
        paramIntent = (Intent)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        paramIntent = "";
      }
      localObject1 = this.MBS;
      if (localObject1 != null)
      {
        ((TextView)localObject1).setText((CharSequence)paramIntent);
        AppMethodBeat.o(234109);
        return;
      }
      AppMethodBeat.o(234109);
      return;
      Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "intent ".concat(String.valueOf(paramIntent)));
      if (paramIntent != null)
      {
        localObject1 = paramIntent.getStringExtra("get_poi_name");
        localObject2 = paramIntent.getStringExtra("get_city");
        if ((!Util.isNullOrNil((String)localObject1)) || (!Util.isNullOrNil((String)localObject2))) {
          break label1424;
        }
      }
      for (localObject1 = null;; localObject1 = Util.nullAs((String)localObject1, (String)localObject2))
      {
        float f1 = paramIntent.getFloatExtra("get_lat", -1000.0F);
        float f2 = paramIntent.getFloatExtra("get_lng", -1000.0F);
        paramIntent = Util.nullAs(paramIntent.getStringExtra("get_poi_classify_id"), "");
        localObject2 = this.MLT;
        if (localObject2 == null) {
          p.bGy("curTextStatusExtInfo");
        }
        ((TextStatusExtInfo)localObject2).poiId = paramIntent;
        paramIntent = this.MLT;
        if (paramIntent == null) {
          p.bGy("curTextStatusExtInfo");
        }
        paramIntent.poiName = ((String)localObject1);
        paramIntent = this.MLT;
        if (paramIntent == null) {
          p.bGy("curTextStatusExtInfo");
        }
        paramIntent.latitude = f1;
        paramIntent = this.MLT;
        if (paramIntent == null) {
          p.bGy("curTextStatusExtInfo");
        }
        paramIntent.longitude = f2;
        gng();
        AppMethodBeat.o(234109);
        return;
      }
      if (paramIntent == null)
      {
        AppMethodBeat.o(234109);
        return;
      }
      this.KJo = paramIntent.getIntExtra("Ktag_range_index", 0);
      localObject2 = paramIntent.getStringExtra("Klabel_name_list");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.KJq = ((String)localObject1);
      localObject2 = paramIntent.getStringExtra("Kother_user_name_list");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.KJr = ((String)localObject1);
      localObject1 = paramIntent.getStringExtra("Kchat_room_name_list");
      paramIntent = (Intent)localObject1;
      if (localObject1 == null) {
        paramIntent = "";
      }
      this.KJs = paramIntent;
      gnf();
      switch (this.KJo)
      {
      }
      for (;;)
      {
        ajl(this.KJo);
        paramIntent = com.tencent.mm.plugin.secdata.ui.a.JbV;
        paramIntent = getContext();
        p.j(paramIntent, "context");
        paramIntent = (am)a.a.a((Context)paramIntent, 8, am.class);
        if (paramIntent == null) {
          break;
        }
        paramIntent.MGu = this.MMi;
        AppMethodBeat.o(234109);
        return;
        this.MMi = 0;
      }
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(234087);
    d locald = this.MMe;
    switch (j.$EnumSwitchMapping$0[locald.ordinal()])
    {
    default: 
      super.onBackPressed();
      getContext().overridePendingTransition(com.tencent.mm.plugin.textstatus.b.a.anim_not_change, com.tencent.mm.plugin.textstatus.b.a.push_down_out);
      AppMethodBeat.o(234087);
      return;
    }
    a(d.MMw);
    AppMethodBeat.o(234087);
  }
  
  @SuppressLint({"ResourceType"})
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject2 = null;
    boolean bool2 = false;
    AppMethodBeat.i(234054);
    com.tencent.mm.pluginsdk.h.r((MMActivity)this);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle.setNavigationBarColor(getResources().getColor(b.b.Dark_2));
    setActionbarColor(0);
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.j(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    com.tencent.mm.ui.statusbar.d.e(getWindow());
    paramBundle = getController();
    p.j(paramBundle, "controller");
    paramBundle.hHH().w(false);
    paramBundle = com.tencent.mm.plugin.xlabeffect.c.QPp;
    com.tencent.mm.plugin.xlabeffect.c.eON();
    setMMTitle("");
    hideActionbarLine();
    hideActionBarOperationArea();
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    setBackBtn((MenuItem.OnMenuItemClickListener)new TextStatusEditActivity.aj(this));
    paramBundle = com.tencent.mm.ui.component.g.Xox;
    ((com.tencent.mm.plugin.secdata.ui.a)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.secdata.ui.a.class)).a((com.tencent.mm.plugin.secdata.h)new com.tencent.mm.plugin.secdata.c(am.class, 8, (byte)0));
    paramBundle = com.tencent.mm.plugin.secdata.ui.a.JbV;
    paramBundle = (am)a.a.a((Context)this, 8, am.class);
    if (paramBundle != null)
    {
      paramBundle.MFV = String.valueOf(cm.bfE());
      paramBundle.enterTime = cm.bfE();
    }
    this.MCg = ((ImageView)findViewById(b.e.Mvi));
    this.MBS = ((TextView)findViewById(b.e.Mxj));
    this.MLj = findViewById(b.e.Mxx);
    this.MLk = findViewById(b.e.MxA);
    this.MLl = findViewById(b.e.Mvg);
    this.MLn = findViewById(b.e.Mvh);
    this.MLp = findViewById(b.e.Mvj);
    paramBundle = findViewById(b.e.MuZ);
    p.j(paramBundle, "findViewById(R.id.et_desc)");
    this.MLq = ((MMEditText)paramBundle);
    this.MBT = ((TextView)findViewById(b.e.MwQ));
    this.MLu = findViewById(b.e.Mvb);
    paramBundle = findViewById(b.e.Mxr);
    p.j(paramBundle, "findViewById(R.id.v_back)");
    this.MBW = ((ImageView)paramBundle);
    this.MLx = ((ImageView)findViewById(b.e.Mxv));
    this.MBY = ((TextView)findViewById(b.e.Mxf));
    this.MLs = ((TextView)findViewById(b.e.Mxp));
    this.MJb = ((FrameLayout)findViewById(b.e.Mwm));
    this.MLC = findViewById(b.e.Mwk);
    this.MLy = findViewById(b.e.Mwd);
    this.MLA = findViewById(b.e.MvR);
    this.MLF = findViewById(b.e.MuP);
    paramBundle = findViewById(b.e.btn_ok);
    p.j(paramBundle, "findViewById(R.id.btn_ok)");
    this.MLG = paramBundle;
    paramBundle = findViewById(b.e.MuM);
    p.j(paramBundle, "findViewById(R.id.btn_back)");
    this.MLI = paramBundle;
    this.MLf = findViewById(b.e.MuV);
    paramBundle = findViewById(b.e.MvI);
    p.j(paramBundle, "findViewById(R.id.layout_blur_option)");
    this.MLJ = paramBundle;
    paramBundle = findViewById(b.e.Mvp);
    p.j(paramBundle, "findViewById(R.id.iv_blur)");
    this.MLK = ((ImageView)paramBundle);
    paramBundle = this.MBW;
    if (paramBundle == null) {
      p.bGy("vBack");
    }
    if (paramBundle != null) {
      paramBundle.post((Runnable)new TextStatusEditActivity.ar(this));
    }
    ax.getStatusBarHeight((Context)this);
    ax.ew((Context)this);
    ax.aB((Context)this);
    paramBundle = getIntent().getByteArrayExtra("SET_TEXT_PARAMS");
    Object localObject1;
    if (paramBundle != null)
    {
      localObject1 = new q.a().gkO();
      ((com.tencent.mm.plugin.textstatus.a.q)localObject1).parseFrom(paramBundle);
      this.MKR = ((com.tencent.mm.plugin.textstatus.a.q)localObject1);
    }
    paramBundle = this.MKR;
    int i;
    if (paramBundle != null) {
      i = paramBundle.MEI;
    }
    for (;;)
    {
      this.kFs = i;
      label872:
      boolean bool1;
      label961:
      label1137:
      Object localObject5;
      switch (this.kFs)
      {
      default: 
        paramBundle = new TextStatusExtInfo();
        this.MLT = paramBundle;
        paramBundle = this.MLT;
        if (paramBundle == null) {
          p.bGy("curTextStatusExtInfo");
        }
        this.MMn = new c(paramBundle);
        Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "[onCreate] setStatusParam:%s", new Object[] { this.MKR });
        switch (this.kFs)
        {
        default: 
          paramBundle = this.MKR;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.MEA;
            if (paramBundle != null)
            {
              paramBundle = paramBundle.backgroundId;
              if ((paramBundle != null) && (paramBundle != null))
              {
                localObject1 = com.tencent.mm.plugin.textstatus.k.m.MOX;
                this.MLU = com.tencent.mm.plugin.textstatus.k.m.beP(paramBundle);
              }
            }
          }
          paramBundle = this.MKR;
          if (paramBundle != null)
          {
            localObject1 = com.tencent.mm.plugin.secdata.ui.a.JbV;
            localObject1 = (am)a.a.a((Context)this, 8, am.class);
            if (localObject1 != null)
            {
              ((am)localObject1).sessionId = paramBundle.sessionId;
              ((am)localObject1).MEC = paramBundle.MEC;
              ((am)localObject1).MED = paramBundle.MED;
              ((am)localObject1).MEE = paramBundle.MEE;
              if (paramBundle.enterTime != 0L) {
                break label2486;
              }
              ((am)localObject1).enterTime = cm.bfE();
            }
          }
          paramBundle = this.MLG;
          if (paramBundle == null) {
            p.bGy("btnOk");
          }
          paramBundle.setEnabled(true);
          paramBundle = this.MLG;
          if (paramBundle == null) {
            p.bGy("btnOk");
          }
          paramBundle.setOnClickListener((View.OnClickListener)new TextStatusEditActivity.as(this));
          paramBundle = this.MLG;
          if (paramBundle == null) {
            p.bGy("btnOk");
          }
          if (!paramBundle.isEnabled()) {
            gmO().setVisibility(0);
          }
          gmO().setOnClickListener((View.OnClickListener)new TextStatusEditActivity.at(this));
          paramBundle = this.MLI;
          if (paramBundle == null) {
            p.bGy("btnBack");
          }
          paramBundle.setOnClickListener((View.OnClickListener)new TextStatusEditActivity.au(this));
          paramBundle = this.MBW;
          if (paramBundle == null) {
            p.bGy("vBack");
          }
          paramBundle.setOnClickListener((View.OnClickListener)new TextStatusEditActivity.av(this));
          gnk();
          paramBundle = this.MKR;
          if (paramBundle != null)
          {
            bool1 = paramBundle.MEB;
            paramBundle = this.MLT;
            if (paramBundle == null) {
              p.bGy("curTextStatusExtInfo");
            }
            paramBundle = paramBundle.topicInfo.sourceId;
            if ((!com.tencent.mm.plugin.textstatus.a.a.Mzr.contains(paramBundle)) && (bool1)) {
              break label2503;
            }
            gmF().setVisibility(8);
            gmG().setVisibility(0);
            label1193:
            gmX();
            paramBundle = this.MLT;
            if (paramBundle == null) {
              p.bGy("curTextStatusExtInfo");
            }
            paramBundle = paramBundle.description;
            localObject1 = this.MLq;
            if (localObject1 == null) {
              p.bGy("etDesc");
            }
            ((MMEditText)localObject1).setText((CharSequence)paramBundle);
            if (!TextUtils.isEmpty((CharSequence)paramBundle))
            {
              localObject1 = this.MLq;
              if (localObject1 == null) {
                p.bGy("etDesc");
              }
              localObject5 = this.MLq;
              if (localObject5 == null) {
                p.bGy("etDesc");
              }
              ((MMEditText)localObject1).setSelection(((MMEditText)localObject5).length());
            }
            localObject1 = com.tencent.mm.plugin.secdata.ui.a.JbV;
            localObject1 = (am)a.a.a((Context)this, 8, am.class);
            if (localObject1 != null) {
              ((am)localObject1).MGC = paramBundle;
            }
            gnh();
            gng();
            if (this.kFs == 1)
            {
              paramBundle = com.tencent.mm.plugin.textstatus.b.f.MAm;
              paramBundle = this.MKR;
              if (paramBundle == null) {
                break label2523;
              }
              paramBundle = paramBundle.MEJ;
              label1364:
              paramBundle = com.tencent.mm.plugin.textstatus.b.f.bep(paramBundle);
              if (paramBundle == null) {
                break label2528;
              }
              paramBundle = paramBundle.field_visibilityInfo;
              label1378:
              if ((TextUtils.isEmpty((CharSequence)paramBundle)) || (paramBundle == null)) {}
            }
          }
          break;
        }
        break;
      }
      try
      {
        paramBundle = new JSONObject(paramBundle);
        this.KJo = paramBundle.optInt("mLabelRangeindex");
        localObject1 = paramBundle.optString("mLabelNameList");
        p.j(localObject1, "jsonObject.optString(\"mLabelNameList\")");
        this.KJq = ((String)localObject1);
        localObject1 = paramBundle.optString("mOtherUserNameList");
        p.j(localObject1, "jsonObject.optString(\"mOtherUserNameList\")");
        this.KJr = ((String)localObject1);
        paramBundle = paramBundle.optString("mChatRoomNameList");
        p.j(paramBundle, "jsonObject.optString(\"mChatRoomNameList\")");
        this.KJs = paramBundle;
        gnf();
        ajl(this.KJo);
        switch (this.kFs)
        {
        }
        for (;;)
        {
          paramBundle = this.MLI;
          if (paramBundle == null) {
            p.bGy("btnBack");
          }
          paramBundle = paramBundle.getLayoutParams();
          if (paramBundle != null) {
            break label3290;
          }
          paramBundle = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(234054);
          throw paramBundle;
          i = 0;
          break;
          paramBundle = this.MKR;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.MEA;
            if (paramBundle != null) {
              break label3657;
            }
          }
          paramBundle = new TextStatusExtInfo();
          localObject1 = paramBundle.topicInfo;
          if (localObject1 != null)
          {
            localObject1 = ((TextStatusTopicInfo)localObject1).sourceId;
            label1612:
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              break label1644;
            }
          }
          label1644:
          for (i = 1;; i = 2)
          {
            paramBundle.sceneType = i;
            paramBundle.createTime = 0;
            break;
            localObject1 = null;
            break label1612;
          }
          paramBundle = this.MKR;
          if (paramBundle != null) {}
          for (paramBundle = paramBundle.MEJ;; paramBundle = null)
          {
            localObject1 = com.tencent.mm.plugin.textstatus.b.f.MAm;
            localObject1 = com.tencent.mm.plugin.textstatus.b.f.bep(paramBundle);
            paramBundle = new TextStatusExtInfo();
            if (localObject1 != null)
            {
              paramBundle.longitude = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_Longitude;
              paramBundle.latitude = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_Latitude;
              paramBundle.mediaType = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_MediaType;
              paramBundle.topicInfo = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).glY();
              paramBundle.mediaUrl = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_MediaUrl;
              paramBundle.mediaAesKey = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_MediaAESKey;
              paramBundle.mediaThumbUrl = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_MediaThumbUrl;
              paramBundle.mediaThumbAesKey = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_MediaThumbAESKey;
              paramBundle.visibility = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_Visibility;
              paramBundle.description = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_Description;
              paramBundle.createTime = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_CreateTime;
              paramBundle.expireTime = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_ExpireTime;
              paramBundle.poiId = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_PoiID;
              paramBundle.poiName = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_PoiName;
              localObject5 = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_option;
              p.j(localObject5, "it.field_option");
              paramBundle.option = ((Long)localObject5).longValue();
              paramBundle.mediaWidth = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_mediaWidth;
              paramBundle.mediaHeight = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_mediaHeight;
              paramBundle.backgroundId = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_backgroundId;
              paramBundle.sceneType = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_sceneType;
            }
            break;
          }
          paramBundle = this.MKR;
          label1895:
          com.tencent.mm.plugin.textstatus.g.e.a locala;
          Object localObject6;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.MEJ;
            localObject1 = com.tencent.mm.plugin.textstatus.b.f.MAm;
            locala = com.tencent.mm.plugin.textstatus.b.f.bep(paramBundle);
            localObject5 = new TextStatusExtInfo();
            if (locala != null)
            {
              ((TextStatusExtInfo)localObject5).mediaType = locala.field_MediaType;
              ((TextStatusExtInfo)localObject5).mediaUrl = locala.field_MediaUrl;
              ((TextStatusExtInfo)localObject5).mediaAesKey = locala.field_MediaAESKey;
              ((TextStatusExtInfo)localObject5).mediaThumbUrl = locala.field_MediaThumbUrl;
              ((TextStatusExtInfo)localObject5).mediaThumbAesKey = locala.field_MediaThumbAESKey;
              ((TextStatusExtInfo)localObject5).option = (locala.field_option.longValue() & 1L);
              ((TextStatusExtInfo)localObject5).mediaWidth = locala.field_mediaWidth;
              ((TextStatusExtInfo)localObject5).mediaHeight = locala.field_mediaHeight;
              localObject1 = locala.glY();
              localObject6 = new TextStatusTopicInfo();
              p.k(localObject6, "$this$handleRefTopicInfo");
              p.k(localObject1, "refTopicInfo");
              Object localObject7 = com.tencent.mm.plugin.textstatus.j.d.MIW;
              localObject7 = com.tencent.mm.plugin.textstatus.j.d.gmo();
              ((com.tencent.mm.plugin.textstatus.a.c)localObject7).c(null, (List)((TextStatusTopicInfo)localObject1).sourceJumpInfos, (List)((TextStatusTopicInfo)localObject1).jumpInfos);
              if ((((com.tencent.mm.plugin.textstatus.a.c)localObject7).gkH() == true) && (((com.tencent.mm.plugin.textstatus.a.c)localObject7).dDH()))
              {
                ((TextStatusTopicInfo)localObject6).sourceId = ((TextStatusTopicInfo)localObject1).sourceId;
                ((TextStatusTopicInfo)localObject6).sourceActivityId = ((TextStatusTopicInfo)localObject1).sourceActivityId;
                ((TextStatusTopicInfo)localObject6).sourceName = ((TextStatusTopicInfo)localObject1).sourceName;
                ((TextStatusTopicInfo)localObject6).sourceIcon = ((TextStatusTopicInfo)localObject1).sourceIcon;
                ((TextStatusTopicInfo)localObject6).jumpInfos = ((TextStatusTopicInfo)localObject1).jumpInfos;
                ((TextStatusTopicInfo)localObject6).verifyInfo = ((TextStatusTopicInfo)localObject1).verifyInfo;
                ((TextStatusTopicInfo)localObject6).sourceJumpInfos = ((TextStatusTopicInfo)localObject1).sourceJumpInfos;
              }
              if ((!((com.tencent.mm.plugin.textstatus.a.c)localObject7).gkH()) && (((com.tencent.mm.plugin.textstatus.a.c)localObject7).dDH()))
              {
                localObject1 = ((com.tencent.mm.plugin.textstatus.a.c)localObject7).dOY();
                if (localObject1 == null) {
                  break label2407;
                }
                localObject1 = ((com.tencent.mm.plugin.textstatus.a.q)localObject1).MEA;
                if (localObject1 == null) {
                  break label2407;
                }
                localObject1 = ((TextStatusExtInfo)localObject1).topicInfo;
                label2203:
                if (localObject1 != null)
                {
                  ((TextStatusTopicInfo)localObject6).sourceId = ((TextStatusTopicInfo)localObject1).sourceId;
                  ((TextStatusTopicInfo)localObject6).sourceActivityId = ((TextStatusTopicInfo)localObject1).sourceActivityId;
                  ((TextStatusTopicInfo)localObject6).sourceName = ((TextStatusTopicInfo)localObject1).sourceName;
                  ((TextStatusTopicInfo)localObject6).sourceIcon = ((TextStatusTopicInfo)localObject1).sourceIcon;
                  ((TextStatusTopicInfo)localObject6).jumpInfos = ((TextStatusTopicInfo)localObject1).jumpInfos;
                  ((TextStatusTopicInfo)localObject6).verifyInfo = ((TextStatusTopicInfo)localObject1).verifyInfo;
                  ((TextStatusTopicInfo)localObject6).sourceJumpInfos = ((TextStatusTopicInfo)localObject1).sourceJumpInfos;
                }
              }
              localObject1 = this.MKR;
              if (localObject1 == null) {
                break label2413;
              }
              localObject1 = ((com.tencent.mm.plugin.textstatus.a.q)localObject1).MEA;
              if (localObject1 == null) {
                break label2413;
              }
              localObject1 = ((TextStatusExtInfo)localObject1).topicInfo;
              if (localObject1 == null) {
                break label2413;
              }
              localObject1 = ((TextStatusTopicInfo)localObject1).iconId;
              label2320:
              ((TextStatusTopicInfo)localObject6).iconId = ((String)localObject1);
              ((TextStatusExtInfo)localObject5).topicInfo = ((TextStatusTopicInfo)localObject6);
              ((TextStatusExtInfo)localObject5).sceneType = locala.field_sceneType;
            }
            localObject1 = com.tencent.mm.plugin.secdata.ui.a.JbV;
            localObject6 = (am)a.a.a((Context)this, 8, am.class);
            if (localObject6 != null) {
              if (locala == null) {
                break label2419;
              }
            }
          }
          label2407:
          label2413:
          label2419:
          for (localObject1 = locala.field_StatusID;; localObject1 = null)
          {
            ((am)localObject6).MGE = ((String)localObject1);
            ((am)localObject6).MGD = paramBundle;
            paramBundle = (Bundle)localObject5;
            break;
            paramBundle = null;
            break label1895;
            localObject1 = null;
            break label2203;
            localObject1 = null;
            break label2320;
          }
          paramBundle = this.MLT;
          if (paramBundle == null) {
            p.bGy("curTextStatusExtInfo");
          }
          if (TextUtils.isEmpty((CharSequence)paramBundle.backgroundId)) {
            break label872;
          }
          paramBundle = com.tencent.mm.plugin.textstatus.k.m.MOX;
          paramBundle = this.MLT;
          if (paramBundle == null) {
            p.bGy("curTextStatusExtInfo");
          }
          this.MLU = com.tencent.mm.plugin.textstatus.k.m.beP(paramBundle.backgroundId);
          break label872;
          label2486:
          ((am)localObject1).enterTime = paramBundle.enterTime;
          break label961;
          bool1 = true;
          break label1137;
          label2503:
          gmF().setVisibility(0);
          gmG().setVisibility(8);
          break label1193;
          label2523:
          paramBundle = null;
          break label1364;
          label2528:
          paramBundle = null;
          break label1378;
          paramBundle = this.MKR;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.MEA;
            if (paramBundle != null)
            {
              p.k(paramBundle, "$this$hasMedia");
              localObject1 = (CharSequence)paramBundle.mediaThumbUrl;
              if ((localObject1 == null) || (kotlin.n.n.ba((CharSequence)localObject1)))
              {
                i = 1;
                label2582:
                if (i != 0) {
                  break label2829;
                }
                paramBundle = (CharSequence)paramBundle.mediaUrl;
                if ((paramBundle != null) && (!kotlin.n.n.ba(paramBundle))) {
                  break label2824;
                }
                i = 1;
                label2607:
                if (i != 0) {
                  break label2829;
                }
                i = 1;
                label2613:
                if (i != 1) {
                  break label2890;
                }
                paramBundle = this.MKR;
                if (paramBundle == null) {
                  break label2834;
                }
                paramBundle = paramBundle.MEA;
                label2632:
                localObject1 = this.MMn;
                if (localObject1 == null) {
                  p.bGy("curLocalMediaStruct");
                }
                localObject2 = getContext();
                p.j(localObject2, "context");
                p.k((Context)localObject2, "context");
                ((c)localObject1).reset();
                if (paramBundle != null)
                {
                  i = paramBundle.mediaType;
                  if (i != 2) {
                    break label2839;
                  }
                  ((c)localObject1).MMq = paramBundle.mediaUrl;
                  ((c)localObject1).MFP = false;
                }
              }
              for (;;)
              {
                ((c)localObject1).mediaType = i;
                localObject1 = this.MMn;
                if (localObject1 == null) {
                  p.bGy("curLocalMediaStruct");
                }
                bool1 = bool2;
                if (!TextUtils.isEmpty((CharSequence)((c)localObject1).MMq)) {
                  bool1 = true;
                }
                localObject1 = this.MMn;
                if (localObject1 == null) {
                  p.bGy("curLocalMediaStruct");
                }
                if (bo(((c)localObject1).mediaType, bool1)) {
                  break;
                }
                if ((paramBundle == null) || (paramBundle.mediaType != 1)) {
                  break label2862;
                }
                paramBundle = this.MMn;
                if (paramBundle == null) {
                  p.bGy("curLocalMediaStruct");
                }
                a(paramBundle.MMq, null);
                break;
                i = 0;
                break label2582;
                label2824:
                i = 0;
                break label2607;
                label2829:
                i = 0;
                break label2613;
                label2834:
                paramBundle = null;
                break label2632;
                label2839:
                if (i == 1)
                {
                  ((c)localObject1).MMq = paramBundle.mediaUrl;
                  ((c)localObject1).MFP = false;
                }
              }
              label2862:
              paramBundle = this.MLu;
              if (paramBundle == null) {
                continue;
              }
              paramBundle.post((Runnable)new z(this));
              continue;
            }
          }
          label2890:
          paramBundle = this.MKR;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.mediaPath;
            label2904:
            localObject3 = this.MKR;
            localObject1 = localObject2;
            if (localObject3 != null) {
              localObject1 = ((com.tencent.mm.plugin.textstatus.a.q)localObject3).MEA;
            }
            if (localObject1 == null) {
              break label3054;
            }
            i = ((TextStatusExtInfo)localObject1).mediaType;
            label2937:
            if (TextUtils.isEmpty((CharSequence)paramBundle)) {
              break label3059;
            }
          }
          label3054:
          label3059:
          for (bool1 = true; !bo(i, bool1); bool1 = false) {
            switch (i)
            {
            default: 
              break;
            case 1: 
              if (!u.agG(paramBundle)) {
                break label3064;
              }
              gv(paramBundle, i);
              localObject1 = this.MMn;
              if (localObject1 == null) {
                p.bGy("curLocalMediaStruct");
              }
              localObject2 = this.MKR;
              localObject3 = getContext();
              p.j(localObject3, "context");
              ((c)localObject1).a((com.tencent.mm.plugin.textstatus.a.q)localObject2, paramBundle, (Context)localObject3);
              break;
              paramBundle = null;
              break label2904;
              i = 0;
              break label2937;
            }
          }
          label3064:
          a(paramBundle, (b)new y(this));
          continue;
          if (u.agG(paramBundle))
          {
            paramBundle = RecordConfigProvider.ay(paramBundle, "", "");
            paramBundle.HLb = 15000;
            paramBundle.scene = 2;
            localObject1 = new UICustomParam.a();
            ((UICustomParam.a)localObject1).avX();
            ((UICustomParam.a)localObject1).avW();
            ((UICustomParam.a)localObject1).dZ(true);
            paramBundle.HKT = ((UICustomParam.a)localObject1).avZ();
            paramBundle.HLm = false;
            paramBundle.HLn = false;
            paramBundle.HLo = true;
            paramBundle.HKW = Boolean.TRUE;
            paramBundle.HKV = 4;
            paramBundle.G(2, TextStatusEditVideoPluginLayout.class.getName());
            localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
            com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)getContext(), 7, com.tencent.mm.plugin.textstatus.b.a.sight_slide_bottom_in, -1, paramBundle, 2, 0);
          }
          gna();
          continue;
          paramBundle = com.tencent.mm.plugin.textstatus.b.f.MAm;
          localObject1 = this.MKR;
          paramBundle = (Bundle)localObject3;
          if (localObject1 != null) {
            paramBundle = ((com.tencent.mm.plugin.textstatus.a.q)localObject1).MEJ;
          }
          d(com.tencent.mm.plugin.textstatus.b.f.bep(paramBundle));
          continue;
          paramBundle = com.tencent.mm.plugin.textstatus.b.f.MAm;
          localObject1 = this.MKR;
          paramBundle = localObject4;
          if (localObject1 != null) {
            paramBundle = ((com.tencent.mm.plugin.textstatus.a.q)localObject1).MEJ;
          }
          d(com.tencent.mm.plugin.textstatus.b.f.bep(paramBundle));
        }
        label3290:
        paramBundle = (RelativeLayout.LayoutParams)paramBundle;
        i = ax.getStatusBarHeight((Context)getContext());
        paramBundle.topMargin = (aw.fromDPToPix((Context)getContext(), 6) + i);
        paramBundle = this.MLJ;
        if (paramBundle == null) {
          p.bGy("layoutBlurOption");
        }
        paramBundle.setOnClickListener((View.OnClickListener)new t(this));
        paramBundle = this.MBY;
        if (paramBundle != null) {
          paramBundle.setOnClickListener((View.OnClickListener)new TextStatusEditActivity.ak(this));
        }
        paramBundle = this.MLF;
        if (paramBundle != null) {
          paramBundle.setOnClickListener((View.OnClickListener)new TextStatusEditActivity.al(this));
        }
        paramBundle = this.MLq;
        if (paramBundle == null) {
          p.bGy("etDesc");
        }
        if (paramBundle != null) {
          paramBundle.addTextChangedListener((TextWatcher)new TextStatusEditActivity.am(this));
        }
        gnq();
        paramBundle = (View)this.MLD.getValue();
        if (paramBundle != null) {
          paramBundle.setOnClickListener((View.OnClickListener)new an(this));
        }
        paramBundle = gmF();
        if (paramBundle != null) {
          paramBundle.setOnClickListener(this.MMg);
        }
        paramBundle = this.MLj;
        if (paramBundle != null) {
          paramBundle.setOnClickListener((View.OnClickListener)new TextStatusEditActivity.ao(this));
        }
        paramBundle = this.MLk;
        if (paramBundle != null) {
          paramBundle.setOnClickListener(this.MMf);
        }
        paramBundle = this.MLz;
        if (paramBundle != null) {
          paramBundle.setOnClickListener((View.OnClickListener)new TextStatusEditActivity.ap(this));
        }
        paramBundle = this.MLE;
        if (paramBundle != null) {
          paramBundle.setOnClickListener((View.OnClickListener)new TextStatusEditActivity.aq(this));
        }
        paramBundle = this.MLi;
        if (paramBundle != null) {
          paramBundle.setOnClickListener(this.Icf);
        }
        this.jij = new com.tencent.mm.ui.tools.i((Activity)this);
        paramBundle = this.jij;
        if (paramBundle != null) {
          paramBundle.setKeyboardHeightObserver((com.tencent.mm.ui.tools.h)this);
        }
        gmV().setOnKeyboardActionListener((com.tencent.mm.plugin.textstatus.emoji.c)this);
        this.MLZ.alive();
        AppMethodBeat.o(234054);
        return;
      }
      catch (Throwable paramBundle)
      {
        label3657:
        for (;;) {}
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(234077);
    gnm();
    super.onDestroy();
    gmq();
    gmV().setOnKeyboardActionListener(null);
    ObjectAnimator localObjectAnimator = this.DCg;
    if ((localObjectAnimator != null) && (localObjectAnimator.isRunning())) {
      localObjectAnimator.cancel();
    }
    localObjectAnimator = this.DCf;
    if ((localObjectAnimator != null) && (localObjectAnimator.isRunning())) {
      localObjectAnimator.cancel();
    }
    com.tencent.mm.ay.q.bmk().b(this.MMb, this.MMc);
    MMo = null;
    this.MLV = null;
    this.MLZ.dead();
    AppMethodBeat.o(234077);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(234082);
    super.onPause();
    Object localObject = this.jij;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.i)localObject).close();
    }
    gnc();
    localObject = new StringBuilder("[onPause] ");
    if (this.MJn == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.TextStatus.TextStatusEditActivity", bool);
      localObject = this.MJn;
      if ((localObject != null) && (((com.tencent.mm.ui.widget.b)localObject).gZ))
      {
        ((com.tencent.mm.ui.widget.b)localObject).dDC();
        ((com.tencent.mm.ui.widget.b)localObject).onPostClose();
      }
      localObject = this.Bba;
      if (localObject == null) {
        break;
      }
      localObject = ((MMTPEffectVideoLayout)localObject).getPlayer();
      if (localObject == null) {
        break;
      }
      ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).pause();
      AppMethodBeat.o(234082);
      return;
    }
    AppMethodBeat.o(234082);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(234097);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(234097);
      return;
    }
    if ((paramInt == 64) && (paramArrayOfInt[0] == 0))
    {
      gnd();
      AppMethodBeat.o(234097);
      return;
    }
    if (paramInt == 18)
    {
      if (paramArrayOfInt[0] == 0)
      {
        gne();
        super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
        AppMethodBeat.o(234097);
        return;
      }
      if (!p.h("android.permission.CAMERA", paramArrayOfString[0])) {
        break label180;
      }
    }
    label180:
    for (paramInt = b.h.permission_camera_request_again_msg;; paramInt = b.h.permission_microphone_request_again_msg)
    {
      if (paramArrayOfInt[0] != 0) {
        com.tencent.mm.ui.base.h.a((Context)this, getString(paramInt), getString(b.h.permission_tips_title), getString(b.h.jump_to_settings), getString(b.h.app_cancel), false, (DialogInterface.OnClickListener)new TextStatusEditActivity.ax(this), (DialogInterface.OnClickListener)TextStatusEditActivity.ay.MMM);
      }
      AppMethodBeat.o(234097);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(234080);
    super.onResume();
    Object localObject = this.jij;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.i)localObject).start();
    }
    if (!com.tencent.mm.plugin.textstatus.a.t.gln())
    {
      localObject = this.MLq;
      if (localObject == null) {
        p.bGy("etDesc");
      }
      ((MMEditText)localObject).post((Runnable)new TextStatusEditActivity.az(this));
    }
    gnj();
    localObject = this.Bba;
    if (localObject != null)
    {
      localObject = ((MMTPEffectVideoLayout)localObject).getPlayer();
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).gos();
        AppMethodBeat.o(234080);
        return;
      }
    }
    AppMethodBeat.o(234080);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(234085);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      locali = this.jij;
      if (locali != null)
      {
        locali.start();
        AppMethodBeat.o(234085);
        return;
      }
      AppMethodBeat.o(234085);
      return;
    }
    com.tencent.mm.ui.tools.i locali = this.jij;
    if (locali != null)
    {
      locali.close();
      AppMethodBeat.o(234085);
      return;
    }
    AppMethodBeat.o(234085);
  }
  
  public final void setBtnBack(View paramView)
  {
    AppMethodBeat.i(234031);
    p.k(paramView, "<set-?>");
    this.MLI = paramView;
    AppMethodBeat.o(234031);
  }
  
  public final void setBtnOk(View paramView)
  {
    AppMethodBeat.i(234029);
    p.k(paramView, "<set-?>");
    this.MLG = paramView;
    AppMethodBeat.o(234029);
  }
  
  public final void setBtnTag(View paramView)
  {
    this.MLF = paramView;
  }
  
  public final void setEditLayout(View paramView)
  {
    this.MLf = paramView;
  }
  
  public final void setFakePic(View paramView)
  {
    this.MLu = paramView;
  }
  
  public final void setIconCamera(View paramView)
  {
    this.MLl = paramView;
  }
  
  public final void setIconPoi(View paramView)
  {
    this.MLn = paramView;
  }
  
  public final void setIconText(View paramView)
  {
    this.MLm = paramView;
  }
  
  public final void setIconVisibility(View paramView)
  {
    this.MLp = paramView;
  }
  
  public final void setLayoutBlurOption(View paramView)
  {
    AppMethodBeat.i(234032);
    p.k(paramView, "<set-?>");
    this.MLJ = paramView;
    AppMethodBeat.o(234032);
  }
  
  public final void setLayoutEditDesc(View paramView)
  {
    this.MLz = paramView;
  }
  
  public final void setLayoutEditToolContainer(View paramView)
  {
    this.MLA = paramView;
  }
  
  public final void setLayoutShow(View paramView)
  {
    this.MLy = paramView;
  }
  
  public final void setLayoutTopicEdit(View paramView)
  {
    this.MLC = paramView;
  }
  
  public final void setTvCancel(View paramView)
  {
    this.MLE = paramView;
  }
  
  public final void setVPoi(View paramView)
  {
    this.MLj = paramView;
  }
  
  public final void setVText(View paramView)
  {
    this.MLi = paramView;
  }
  
  public final void setVVisibility(View paramView)
  {
    this.MLk = paramView;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$Companion;", "", "()V", "EDIT_TEXT_MAX_NUM", "", "TAG", "", "lastThumbBlurBitmap", "Landroid/graphics/Bitmap;", "getLastThumbBlurBitmap", "()Landroid/graphics/Bitmap;", "setLastThumbBlurBitmap", "(Landroid/graphics/Bitmap;)V", "start", "", "context", "Landroid/content/Context;", "params", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "isForward", "", "startForResult", "Landroid/app/Activity;", "reqCode", "plugin-textstatus_release"})
  public static final class a
  {
    public static void a(Context paramContext, com.tencent.mm.plugin.textstatus.a.q paramq, boolean paramBoolean)
    {
      AppMethodBeat.i(234223);
      p.k(paramContext, "context");
      p.k(paramq, "params");
      Intent localIntent = new Intent(paramContext, TextStatusEditActivity.class);
      if (paramBoolean) {
        localIntent.addFlags(33554432);
      }
      localIntent.putExtra("SET_TEXT_PARAMS", paramq.toByteArray());
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramq = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramq.aFh(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$Companion", "start", "(Landroid/content/Context;Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramq.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$Companion", "start", "(Landroid/content/Context;Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if (!(paramContext instanceof Activity)) {
        paramContext = null;
      }
      for (;;)
      {
        paramContext = (Activity)paramContext;
        if (paramContext != null)
        {
          paramContext.overridePendingTransition(com.tencent.mm.plugin.textstatus.b.a.push_up_in, com.tencent.mm.plugin.textstatus.b.a.anim_not_change);
          AppMethodBeat.o(234223);
          return;
        }
        AppMethodBeat.o(234223);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class aa
    implements Runnable
  {
    aa(TextStatusEditActivity paramTextStatusEditActivity) {}
    
    public final void run()
    {
      AppMethodBeat.i(237083);
      TextStatusEditActivity.a(this.MMz, this.MMz.gnn().MMq, this.MMz.gnn().mediaType);
      AppMethodBeat.o(237083);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ac
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ImageView>
  {
    ac(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ad
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    ad(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ae
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ImageView>
  {
    ae(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class af
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ImageView>
  {
    af(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ag
    extends kotlin.g.b.q
    implements kotlin.g.a.a<FrameLayout>
  {
    ag(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ah
    extends kotlin.g.b.q
    implements kotlin.g.a.a<FrameLayout>
  {
    ah(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class an
    implements View.OnClickListener
  {
    an(TextStatusEditActivity paramTextStatusEditActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(233144);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = com.tencent.mm.plugin.secdata.ui.a.JbV;
      paramView = this.MMz.getContext();
      p.j(paramView, "context");
      paramView = (am)a.a.a((Context)paramView, 8, am.class);
      if (paramView != null) {
        paramView.MGn += 1L;
      }
      if (this.MMz.kFs == 1)
      {
        com.tencent.mm.ui.base.w.w((Context)this.MMz, this.MMz.getString(b.h.settings_modify_text_status_invalid_modify_status_word), b.g.icons_outlined_info);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(233144);
        return;
      }
      paramView = TextStatusDoWhatActivity.MKZ;
      paramView = (Activity)this.MMz;
      int i = TextStatusEditActivity.d(this.MMz);
      p.k(paramView, "context");
      localObject = new Intent((Context)paramView, TextStatusDoWhatActivity.class);
      ((Intent)localObject).putExtra("KEY_DEFAULT_BACKGROUND_ID", i);
      paramView.startActivityForResult((Intent)localObject, 3);
      if (paramView != null) {
        paramView.overridePendingTransition(com.tencent.mm.plugin.textstatus.b.a.push_up_in, com.tencent.mm.plugin.textstatus.b.a.anim_not_change);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(233144);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$DownLoadSuccCallback;", "", "onSucc", "", "path", "", "plugin-textstatus_release"})
  public static abstract interface b
  {
    public abstract void beH(String paramString);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class bc
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    bc(TextStatusEditActivity paramTextStatusEditActivity, Bitmap paramBitmap)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class bd
    implements View.OnClickListener
  {
    bd(TextStatusEditActivity paramTextStatusEditActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(238546);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$showEducationLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.MMz.findViewById(b.e.MuX);
      p.j(paramView, "findViewById<View>(R.id.education_layout)");
      paramView.setVisibility(8);
      paramView = this.MMz.MLf;
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      TextStatusEditActivity.k(this.MMz);
      paramView = com.tencent.mm.plugin.secdata.ui.a.JbV;
      paramView = (am)a.a.a((Context)this.MMz, 8, am.class);
      if (paramView != null) {
        paramView.MEE = 1;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$showEducationLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(238546);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class be
    extends kotlin.g.b.q
    implements kotlin.g.a.a<FrameLayout>
  {
    be(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class bf
    implements View.OnClickListener
  {
    bf(TextStatusEditActivity paramTextStatusEditActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(237203);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$textClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      TextStatusEditActivity.a(this.MMz, TextStatusEditActivity.d.MMx);
      paramView = this.MMz.gmI();
      if (paramView != null) {
        paramView.requestFocus();
      }
      MMActivity.showVKB((Activity)this.MMz);
      paramView = this.MMz.MLr;
      if (paramView != null) {
        paramView.setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            Object localObject1 = null;
            AppMethodBeat.i(238660);
            Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject2).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$textClickListener$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aFi());
            localObject2 = this.MMP.MMz.MBT;
            int i;
            if (localObject2 != null)
            {
              paramAnonymousView = this.MMP.MMz.gmI();
              if (paramAnonymousView != null)
              {
                paramAnonymousView = paramAnonymousView.getText();
                ((TextView)localObject2).setText((CharSequence)paramAnonymousView);
              }
            }
            else
            {
              localObject2 = this.MMP.MMz.MBT;
              paramAnonymousView = localObject1;
              if (localObject2 != null) {
                paramAnonymousView = ((TextView)localObject2).getText();
              }
              if ((paramAnonymousView != null) && (!kotlin.n.n.ba(paramAnonymousView))) {
                break label207;
              }
              i = 1;
              label123:
              if (i == 0) {
                break label212;
              }
              paramAnonymousView = this.MMP.MMz.MBT;
              if (paramAnonymousView != null) {
                paramAnonymousView.setVisibility(8);
              }
            }
            for (;;)
            {
              this.MMP.MMz.hideVKB((View)this.MMP.MMz.gmI());
              TextStatusEditActivity.a(this.MMP.MMz, TextStatusEditActivity.d.MMw);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$textClickListener$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(238660);
              return;
              paramAnonymousView = null;
              break;
              label207:
              i = 0;
              break label123;
              label212:
              paramAnonymousView = this.MMP.MMz.MBT;
              if (paramAnonymousView != null) {
                paramAnonymousView.setVisibility(0);
              }
            }
          }
        });
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$textClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(237203);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class bg
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    bg(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class bh
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    bh(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class bi
    extends kotlin.g.b.q
    implements kotlin.g.a.a<FrameLayout>
  {
    bi(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class bj
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    bj(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class bk
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    bk(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class bl
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    bl(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class bm
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ImageView>
  {
    bm(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class bn
    implements View.OnClickListener
  {
    bn(TextStatusEditActivity paramTextStatusEditActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(232859);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$visibilityClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = new Intent((Context)this.MMz, SnsLabelUI.class);
      paramView.putExtra("KLabel_range_index", TextStatusEditActivity.n(this.MMz));
      paramView.putExtra("Klabel_name_list", TextStatusEditActivity.o(this.MMz));
      paramView.putExtra("Kother_user_name_list", TextStatusEditActivity.p(this.MMz));
      paramView.putExtra("Kchat_room_name_list", TextStatusEditActivity.q(this.MMz));
      paramView.putExtra("Kis_from_text_status", true);
      paramView.putExtra("k_show_private", false);
      paramView.putExtra("k_show_include", false);
      paramView.putExtra("k_sns_label_ui_style", this.MMz.style);
      this.MMz.startActivityForResult(paramView, 4);
      paramView = com.tencent.mm.plugin.secdata.ui.a.JbV;
      paramView = this.MMz.getContext();
      p.j(paramView, "context");
      paramView = (am)a.a.a((Context)paramView, 8, am.class);
      if (paramView != null) {
        paramView.MGt = (1L + paramView.MGt);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$visibilityClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(232859);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$MediaStruct;", "", "curTextStatusExtInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;)V", "getCurTextStatusExtInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;", "setCurTextStatusExtInfo", "finalFileLength", "", "getFinalFileLength", "()J", "setFinalFileLength", "(J)V", "isGenThumbWhenUpload", "", "()Z", "setGenThumbWhenUpload", "(Z)V", "mediaFilePath", "", "getMediaFilePath", "()Ljava/lang/String;", "setMediaFilePath", "(Ljava/lang/String;)V", "mediaThumbPath", "getMediaThumbPath", "setMediaThumbPath", "mediaType", "", "getMediaType", "()I", "setMediaType", "(I)V", "oriFileLength", "getOriFileLength", "setOriFileLength", "oriFileMd5", "getOriFileMd5", "setOriFileMd5", "useDefaultBackground", "getUseDefaultBackground", "setUseDefaultBackground", "videoDuration", "getVideoDuration", "setVideoDuration", "isHasMedia", "prepareMediaReportData", "", "context", "Landroid/content/Context;", "reset", "update", "captureResult", "Lcom/tencent/mm/plugin/mmsight/SightCaptureResult;", "setStatusParam", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "mediaPath", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "extInfo", "updateFromGallery", "filePath", "thumbPath", "oriVideoFilePath", "plugin-textstatus_release"})
  public static final class c
  {
    boolean MFP;
    TextStatusExtInfo MLT;
    String MMq;
    String MMr;
    boolean MMs;
    long MMt;
    String MMu;
    long MMv;
    int mediaType;
    long sTg;
    
    public c(TextStatusExtInfo paramTextStatusExtInfo)
    {
      AppMethodBeat.i(236406);
      this.MLT = paramTextStatusExtInfo;
      this.MFP = true;
      this.MMu = "";
      AppMethodBeat.o(236406);
    }
    
    public final void a(int paramInt, String paramString1, String paramString2, Context paramContext, String paramString3)
    {
      AppMethodBeat.i(236402);
      p.k(paramContext, "context");
      p.k(paramString3, "oriVideoFilePath");
      reset();
      k.b(this.MLT);
      this.MFP = false;
      this.mediaType = paramInt;
      this.MMr = paramString2;
      switch (paramInt)
      {
      }
      int i;
      label185:
      label208:
      do
      {
        for (;;)
        {
          Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "[updateFromGallery] oriLen:" + this.MMt + " finalLen:" + this.MMv + " type:" + paramInt);
          iw(paramContext);
          AppMethodBeat.o(236402);
          return;
          this.MMt = u.bBQ(paramString1);
          this.MMu = com.tencent.xweb.util.d.getMD5(paramString1);
          this.MMq = com.tencent.mm.plugin.textstatus.g.g.d.MEw.beB(paramString1);
          this.MMs = true;
          this.MMv = u.bBQ(this.MMq);
        }
        if (!kotlin.n.n.ba((CharSequence)paramString3)) {
          break;
        }
        i = 1;
        if (i != 0) {
          break label270;
        }
        this.MMt = u.bBQ(paramString3);
        this.MMu = com.tencent.xweb.util.d.getMD5(paramString3);
        this.MMq = paramString1;
        this.MMv = u.bBQ(this.MMq);
        paramString1 = this.MMq;
      } while (paramString1 == null);
      paramString1 = MultiMediaVideoChecker.NmA.bfs(paramString1);
      if (paramString1 != null) {}
      for (long l = paramString1.duration;; l = 0L)
      {
        this.sTg = (l / 1000L);
        break;
        i = 0;
        break label185;
        label270:
        this.MMt = u.bBQ(paramString1);
        this.MMu = com.tencent.xweb.util.d.getMD5(paramString1);
        break label208;
      }
    }
    
    public final void a(com.tencent.mm.plugin.textstatus.a.q paramq, String paramString, Context paramContext)
    {
      AppMethodBeat.i(236399);
      p.k(paramContext, "context");
      reset();
      int i;
      if (paramq != null)
      {
        CharSequence localCharSequence = (CharSequence)paramq.mediaPath;
        if ((localCharSequence != null) && (!kotlin.n.n.ba(localCharSequence))) {
          break label169;
        }
        i = 1;
        if (i != 0) {}
      }
      switch (paramq.MEA.mediaType)
      {
      default: 
      case 1: 
        for (;;)
        {
          this.MMv = u.bBQ(this.MMq);
          this.MMt = this.MMv;
          this.MMu = com.tencent.xweb.util.d.getMD5(this.MMq);
          iw(paramContext);
          Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "[updateFromSetStatusParam] oriLen:" + this.MMt + " finalLen:" + this.MMv + " type:" + this.mediaType);
          AppMethodBeat.o(236399);
          return;
          label169:
          i = 0;
          break;
          this.mediaType = 1;
          if (!TextUtils.isEmpty((CharSequence)paramString))
          {
            this.MMq = paramString;
            this.MMr = paramString;
          }
          this.MFP = false;
        }
      }
      this.mediaType = 2;
      this.MMq = paramString;
      paramq = this.MMq;
      if (paramq != null)
      {
        paramq = MultiMediaVideoChecker.NmA.bfs(paramq);
        if (paramq == null) {
          break label268;
        }
      }
      label268:
      for (long l = paramq.duration;; l = 0L)
      {
        this.sTg = (l / 1000L);
        this.MFP = false;
        this.MMs = true;
        break;
      }
    }
    
    public final void a(com.tencent.mm.plugin.textstatus.g.e.a parama, Context paramContext)
    {
      AppMethodBeat.i(236396);
      p.k(paramContext, "context");
      reset();
      if (parama == null)
      {
        AppMethodBeat.o(236396);
        return;
      }
      int i = parama.field_MediaType;
      String str = parama.field_UserName;
      if (i == 2)
      {
        com.tencent.mm.plugin.textstatus.k.f localf = com.tencent.mm.plugin.textstatus.k.f.MOw;
        p.j(str, "userName");
        this.MMr = com.tencent.mm.plugin.textstatus.k.f.lD("thumb", str);
        if (p.h(com.tencent.mm.plugin.auth.a.a.crN(), str))
        {
          localf = com.tencent.mm.plugin.textstatus.k.f.MOw;
          if (u.agG(com.tencent.mm.plugin.textstatus.k.f.beK(str)))
          {
            parama = com.tencent.mm.plugin.textstatus.k.f.MOw;
            this.MMq = com.tencent.mm.plugin.textstatus.k.f.beK(str);
            this.MFP = false;
          }
        }
      }
      for (;;)
      {
        this.mediaType = i;
        this.MMv = u.bBQ(this.MMq);
        this.MMt = this.MMv;
        this.MMu = com.tencent.xweb.util.d.getMD5(this.MMq);
        iw(paramContext);
        AppMethodBeat.o(236396);
        return;
        this.MMq = parama.field_MediaUrl;
        break;
        this.MMq = parama.field_MediaUrl;
        break;
        if (i == 1)
        {
          parama = com.tencent.mm.plugin.textstatus.k.f.MOw;
          p.j(str, "userName");
          this.MMr = com.tencent.mm.plugin.textstatus.k.f.lD("thumb", str);
          parama = com.tencent.mm.plugin.textstatus.k.f.MOw;
          this.MMq = com.tencent.mm.plugin.textstatus.k.f.lD("image", str);
          this.MFP = false;
        }
      }
    }
    
    final void iw(Context paramContext)
    {
      AppMethodBeat.i(236405);
      a.a locala;
      if (this.mediaType == 2)
      {
        locala = com.tencent.mm.plugin.secdata.ui.a.JbV;
        paramContext = (am)a.a.a(paramContext, 8, am.class);
        if (paramContext != null)
        {
          paramContext.MGc = (this.sTg * 1000L);
          paramContext.MGd = this.MMv;
          paramContext.MGy = ((int)this.MMt);
          paramContext.MGz = this.MMu;
          AppMethodBeat.o(236405);
          return;
        }
        AppMethodBeat.o(236405);
        return;
      }
      if (this.mediaType == 1)
      {
        locala = com.tencent.mm.plugin.secdata.ui.a.JbV;
        paramContext = (am)a.a.a(paramContext, 8, am.class);
        if (paramContext != null)
        {
          paramContext.MGc = 0L;
          paramContext.MGd = this.MMv;
          paramContext.MGy = ((int)this.MMt);
          paramContext.MGz = this.MMu;
          AppMethodBeat.o(236405);
          return;
        }
      }
      AppMethodBeat.o(236405);
    }
    
    public final void reset()
    {
      this.MMq = null;
      this.MMr = null;
      this.mediaType = 0;
      this.MMs = false;
      this.MFP = true;
      this.sTg = 0L;
      this.MMt = 0L;
      this.MMu = "";
      this.MMv = 0L;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$PageType;", "", "(Ljava/lang/String;I)V", "MAIN", "EDT_DESC", "plugin-textstatus_release"})
  public static enum d
  {
    static
    {
      AppMethodBeat.i(235977);
      d locald1 = new d("MAIN", 0);
      MMw = locald1;
      d locald2 = new d("EDT_DESC", 1);
      MMx = locald2;
      MMy = new d[] { locald1, locald2 };
      AppMethodBeat.o(235977);
    }
    
    private d() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(TextStatusEditActivity paramTextStatusEditActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(235809);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$cameraClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      long l = System.currentTimeMillis();
      if (Math.abs(l - this.MMz.lastClickTime) < 1000L)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$cameraClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(235809);
        return;
      }
      this.MMz.lastClickTime = l;
      paramView = new com.tencent.mm.ui.tools.m((Context)this.MMz);
      paramView.a((q.f)new q.f()
      {
        public final void onCreateMMMenu(o paramAnonymouso)
        {
          AppMethodBeat.i(232504);
          paramAnonymouso.a(b.e.Mwr, (CharSequence)this.MMA.MMz.getString(b.h.Myt), (CharSequence)this.MMA.MMz.getString(i.j.app_field_pic_video), 0);
          paramAnonymouso.d(b.e.Mwu, (CharSequence)this.MMA.MMz.getString(b.h.settings_avatar_select_from_album));
          if (com.tencent.mm.plugin.textstatus.a.t.glu()) {
            paramAnonymouso.d(b.e.Mwt, TextStatusEditActivity.r(this.MMA.MMz));
          }
          TextStatusEditActivity.c localc = this.MMA.MMz.gnn();
          int i;
          if (localc.MFP) {
            i = 0;
          }
          for (;;)
          {
            if ((i != 0) || (this.MMA.MMz.MJn != null)) {
              paramAnonymouso.a(b.e.Mws, this.MMA.MMz.getResources().getColor(b.b.Red), (CharSequence)this.MMA.MMz.getString(b.h.Myr));
            }
            AppMethodBeat.o(232504);
            return;
            if (TextUtils.isEmpty((CharSequence)localc.MMq)) {
              i = 0;
            } else {
              i = 1;
            }
          }
        }
      });
      paramView.a((q.g)new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(235976);
          p.j(paramAnonymousMenuItem, "menuItem");
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          if (paramAnonymousInt == b.e.Mwr)
          {
            paramAnonymousMenuItem = com.tencent.mm.plugin.secdata.ui.a.JbV;
            paramAnonymousMenuItem = this.MMA.MMz.getContext();
            p.j(paramAnonymousMenuItem, "context");
            paramAnonymousMenuItem = (am)a.a.a((Context)paramAnonymousMenuItem, 8, am.class);
            if (paramAnonymousMenuItem != null) {
              paramAnonymousMenuItem.MGA += 1;
            }
            TextStatusEditActivity.s(this.MMA.MMz);
            AppMethodBeat.o(235976);
            return;
          }
          if (paramAnonymousInt == b.e.Mwu)
          {
            paramAnonymousMenuItem = com.tencent.mm.plugin.secdata.ui.a.JbV;
            paramAnonymousMenuItem = this.MMA.MMz.getContext();
            p.j(paramAnonymousMenuItem, "context");
            paramAnonymousMenuItem = (am)a.a.a((Context)paramAnonymousMenuItem, 8, am.class);
            if (paramAnonymousMenuItem != null) {
              paramAnonymousMenuItem.MGB += 1;
            }
            TextStatusEditActivity.t(this.MMA.MMz);
            AppMethodBeat.o(235976);
            return;
          }
          if (paramAnonymousInt == b.e.Mwt)
          {
            TextStatusEditActivity.u(this.MMA.MMz);
            AppMethodBeat.o(235976);
            return;
          }
          if (paramAnonymousInt == b.e.Mws) {
            TextStatusEditActivity.v(this.MMA.MMz);
          }
          AppMethodBeat.o(235976);
        }
      });
      paramView.hYu();
      paramView = com.tencent.mm.plugin.secdata.ui.a.JbV;
      paramView = this.MMz.getContext();
      p.j(paramView, "context");
      paramView = (am)a.a.a((Context)paramView, 8, am.class);
      if (paramView != null) {
        paramView.MGp = (1L + paramView.MGp);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$cameraClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(235809);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$configUpdateListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/StatusIconConfigUpdateEvent;", "callback", "", "event", "plugin-textstatus_release"})
  public static final class g
    extends IListener<ye>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$configUpdateListener$1$callback$1$1"})
    static final class a
      implements Runnable
    {
      a(ye paramye, TextStatusEditActivity.g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(232824);
        Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "config update old" + this.MLb.fXv.fXw + " new:" + this.MLb.fXv.fXx);
        TextStatusEditActivity.l(this.MMB.MMz);
        TextStatusEditActivity.m(this.MMB.MMz);
        AppMethodBeat.o(232824);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(TextStatusEditActivity paramTextStatusEditActivity) {}
    
    public final void run()
    {
      AppMethodBeat.i(232512);
      TextStatusEditActivity.c localc = this.MMz.gnn();
      Object localObject1;
      switch (this.MMz.gnn().mediaType)
      {
      default: 
        localObject1 = "";
      }
      for (;;)
      {
        localc.MMr = ((String)localObject1);
        com.tencent.e.h.ZvG.bc((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(238952);
            ProgressDialog localProgressDialog = TextStatusEditActivity.h(this.MMC.MMz);
            if (localProgressDialog != null) {
              localProgressDialog.dismiss();
            }
            this.MMC.MMz.gno();
            AppMethodBeat.o(238952);
          }
        });
        AppMethodBeat.o(232512);
        return;
        com.tencent.mm.plugin.textstatus.g.g.d locald = com.tencent.mm.plugin.textstatus.g.g.d.MEw;
        Object localObject2 = this.MMz.gnn().MMq;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        p.k(localObject1, "thumbnailPath");
        localObject2 = new com.tencent.mm.vfs.q((String)localObject1);
        localObject2 = new com.tencent.mm.vfs.q(((com.tencent.mm.vfs.q)localObject2).ifB(), "thumb" + ((com.tencent.mm.vfs.q)localObject2).getName());
        Log.i("MicroMsg.TextStatus.UploadPackHelper", "[getSendThumbnail]");
        localObject1 = locald.a((String)localObject1, (com.tencent.mm.vfs.q)localObject2, 60);
        continue;
        localObject2 = this.MMz.gnn().MMq;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject1 = TextStatusEditActivity.beG((String)localObject1);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextStatusEmojiView>
  {
    i(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    j(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$globalLayoutListenerMode1$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-textstatus_release"})
  public static final class o
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(236596);
      this.MMz.gmI().post((Runnable)new a(this));
      this.MMz.gmI().getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      AppMethodBeat.o(236596);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(TextStatusEditActivity.o paramo) {}
      
      public final void run()
      {
        AppMethodBeat.i(233155);
        com.tencent.e.h.ZvG.n((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(235587);
            this.MME.MMD.MMz.gmI().requestFocus();
            TextStatusEditActivity.j(this.MME.MMD.MMz);
            this.MME.MMD.MMz.hideVKB();
            AppMethodBeat.o(235587);
          }
        }, 200L);
        AppMethodBeat.o(233155);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$globalLayoutListenerMode2$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-textstatus_release"})
  public static final class p
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(233000);
      this.MMz.gmI().post((Runnable)new a(this));
      this.MMz.gmI().getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      AppMethodBeat.o(233000);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(TextStatusEditActivity.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(238924);
        this.MMF.MMz.gmI().requestFocus();
        com.tencent.e.h.ZvG.n((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(234904);
            Object localObject = this.MMG.MMF.MMz.getContext().getSystemService("input_method");
            if (localObject == null)
            {
              localObject = new kotlin.t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
              AppMethodBeat.o(234904);
              throw ((Throwable)localObject);
            }
            ((InputMethodManager)localObject).showSoftInput((View)this.MMG.MMF.MMz.gmI(), 0);
            AppMethodBeat.o(234904);
          }
        }, 200L);
        AppMethodBeat.o(238924);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(TextStatusEditActivity paramTextStatusEditActivity, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(235219);
      Bitmap localBitmap = com.tencent.mm.plugin.textstatus.f.b.bes(paramString);
      TextStatusEditActivity.a(this.MMz, localBitmap);
      AppMethodBeat.o(235219);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "", "kotlin.jvm.PlatformType", "bitmap", "Landroid/graphics/Bitmap;", "path", "onLoadImageEnd"})
  static final class s
    implements r.a
  {
    s(TextStatusEditActivity paramTextStatusEditActivity, String paramString, TextStatusEditActivity.b paramb) {}
    
    public final void a(String paramString1, final Bitmap paramBitmap, String paramString2)
    {
      AppMethodBeat.i(234297);
      Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "trydownload imgback end:" + paramString + " bitmap:" + paramBitmap + " exist:" + u.agG(paramString2) + " len:" + u.bBQ(paramString2));
      if (paramBitmap == null)
      {
        AppMethodBeat.o(234297);
        return;
      }
      if (!u.agG(paramString2))
      {
        com.tencent.e.h.ZvG.be((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(234773);
            Object localObject = com.tencent.mm.plugin.textstatus.k.f.MOw;
            localObject = com.tencent.mm.plugin.auth.a.a.crN();
            p.j(localObject, "Account.username()");
            localObject = com.tencent.mm.plugin.textstatus.k.f.lD("ptmptmb", (String)localObject);
            com.tencent.mm.plugin.textstatus.f.b.i(paramBitmap, (String)localObject);
            TextStatusEditActivity.f(this.MMI.MMz).post((Runnable)new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(233513);
                TextStatusEditActivity.a(this.MMJ.MMI.MMz, this.MMK, 1);
                TextStatusEditActivity.e(this.MMJ.MMI.MMz);
                TextStatusEditActivity.b localb = this.MMJ.MMI.MMH;
                if (localb != null)
                {
                  localb.beH(this.MMK);
                  AppMethodBeat.o(233513);
                  return;
                }
                AppMethodBeat.o(233513);
              }
            });
            AppMethodBeat.o(234773);
          }
        });
        AppMethodBeat.o(234297);
        return;
      }
      TextStatusEditActivity.a(this.MMz, paramString2, 1);
      TextStatusEditActivity.e(this.MMz);
      paramString1 = paramb;
      if (paramString1 != null)
      {
        p.j(paramString2, "path");
        paramString1.beH(paramString2);
        AppMethodBeat.o(234297);
        return;
      }
      AppMethodBeat.o(234297);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class t
    implements View.OnClickListener
  {
    t(TextStatusEditActivity paramTextStatusEditActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(235251);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$initBlur$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (this.MMz.gnn().mediaType == 0)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$initBlur$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(235251);
        return;
      }
      paramView = com.tencent.mm.plugin.secdata.ui.a.JbV;
      paramView = this.MMz.getContext();
      p.j(paramView, "context");
      paramView = (am)a.a.a((Context)paramView, 8, am.class);
      if (paramView != null)
      {
        if (!k.a(this.MMz.gmW())) {
          break label174;
        }
        paramView.MGw += 1L;
      }
      for (;;)
      {
        paramView = this.MMz.gmW();
        p.k(paramView, "$this$reverseBlur");
        paramView.option ^= 1L;
        TextStatusEditActivity.e(this.MMz);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$initBlur$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(235251);
        return;
        label174:
        paramView.MGv += 1L;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class u
    implements Runnable
  {
    u(TextStatusEditActivity paramTextStatusEditActivity) {}
    
    public final void run()
    {
      AppMethodBeat.i(233701);
      ar.a((Paint)this.MMz.gmI().getPaint(), 0.8F);
      this.MMz.gmI().setHint(b.h.Myy);
      AppMethodBeat.o(233701);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class w
    implements View.OnTouchListener
  {
    w(TextStatusEditActivity paramTextStatusEditActivity) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(234888);
      p.j(paramMotionEvent, "event");
      if (paramMotionEvent.getAction() == 0)
      {
        TextStatusEditActivity.i(this.MMz);
        TextStatusEditActivity.j(this.MMz);
        this.MMz.hideVKB();
      }
      AppMethodBeat.o(234888);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class x
    implements Runnable
  {
    x(TextStatusEditActivity paramTextStatusEditActivity) {}
    
    public final void run()
    {
      AppMethodBeat.i(235224);
      ar.a((Paint)this.MMz.gmI().getPaint(), 0.8F);
      this.MMz.gmI().setHint(b.h.Myx);
      AppMethodBeat.o(235224);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$initMedia$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$DownLoadSuccCallback;", "onSucc", "", "path", "", "plugin-textstatus_release"})
  public static final class y
    implements TextStatusEditActivity.b
  {
    public final void beH(String paramString)
    {
      AppMethodBeat.i(233084);
      p.k(paramString, "path");
      TextStatusEditActivity.c localc = this.MMz.gnn();
      com.tencent.mm.plugin.textstatus.a.q localq = this.MMz.MKR;
      AppCompatActivity localAppCompatActivity = this.MMz.getContext();
      p.j(localAppCompatActivity, "context");
      localc.a(localq, paramString, (Context)localAppCompatActivity);
      AppMethodBeat.o(233084);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class z
    implements Runnable
  {
    z(TextStatusEditActivity paramTextStatusEditActivity) {}
    
    public final void run()
    {
      AppMethodBeat.i(237306);
      TextStatusEditActivity.a(this.MMz, this.MMz.gnn().MMq, this.MMz.gnn().mediaType);
      AppMethodBeat.o(237306);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity
 * JD-Core Version:    0.7.0.1
 */
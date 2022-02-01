package com.tencent.mm.plugin.textstatus.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ae;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.emoji.view.EmojiPanelInputComponent;
import com.tencent.mm.emoji.view.EmojiPanelInputComponent.a;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.model.ab;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelimage.s.a;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.report.q.ch;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.cf;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.ui.SnsLabelUI;
import com.tencent.mm.plugin.textstatus.a.b;
import com.tencent.mm.plugin.textstatus.a.c;
import com.tencent.mm.plugin.textstatus.a.d;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.g;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.plugin.textstatus.a.i;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.plugin.textstatus.a.o;
import com.tencent.mm.plugin.textstatus.a.w;
import com.tencent.mm.plugin.textstatus.emoji.TextStatusEmojiView;
import com.tencent.mm.plugin.textstatus.proto.TextStatusEmojiInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.proto.bg;
import com.tencent.mm.plugin.textstatus.proto.bh;
import com.tencent.mm.plugin.thumbplayer.view.MMTPEffectVideoLayout;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.am.g;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ao.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.component.glocom.b.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.vfs.y;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.b.am;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(32)
@com.tencent.mm.ui.widget.pulldown.c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity;", "Lcom/tencent/mm/plugin/secdata/ui/MMSecDataActivity;", "Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent$InputComponentListener;", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "Lcom/tencent/mm/plugin/textstatus/emoji/ITextStatusEmojiActionListener;", "()V", "animator_move_to_below", "Landroid/animation/ObjectAnimator;", "animator_move_to_up", "arrowIv", "Landroid/widget/ImageView;", "getArrowIv", "()Landroid/widget/ImageView;", "arrowIv$delegate", "Lkotlin/Lazy;", "btnBack", "Landroid/view/View;", "getBtnBack", "()Landroid/view/View;", "setBtnBack", "(Landroid/view/View;)V", "btnDelEmoji", "getBtnDelEmoji", "btnDelEmoji$delegate", "btnEditFinish", "Landroid/widget/Button;", "getBtnEditFinish", "()Landroid/widget/Button;", "setBtnEditFinish", "(Landroid/widget/Button;)V", "btnOk", "getBtnOk", "setBtnOk", "btnTag", "getBtnTag", "setBtnTag", "callback", "Landroid/os/ResultReceiver;", "getCallback", "()Landroid/os/ResultReceiver;", "callback$delegate", "cameraClickListener", "Landroid/view/View$OnClickListener;", "configUpdateListener", "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$configUpdateListener$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$configUpdateListener$1;", "curLocalMediaStruct", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$MediaStruct;", "getCurLocalMediaStruct", "()Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$MediaStruct;", "setCurLocalMediaStruct", "(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$MediaStruct;)V", "curMode", "", "getCurMode", "()I", "setCurMode", "(I)V", "curTextStatusExtInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;", "getCurTextStatusExtInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;", "setCurTextStatusExtInfo", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;)V", "defaultBackgroundImgId", "editContentType", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$EditContentType;", "getEditContentType", "()Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$EditContentType;", "setEditContentType", "(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$EditContentType;)V", "editLayout", "getEditLayout", "setEditLayout", "emojiContainer", "Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView;", "getEmojiContainer", "()Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView;", "emojiContainer$delegate", "emojiView", "Lcom/tencent/mm/emoji/view/EmojiStatusView;", "getEmojiView", "()Lcom/tencent/mm/emoji/view/EmojiStatusView;", "emojiView$delegate", "etDesc", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEtDesc", "()Lcom/tencent/mm/ui/widget/MMEditText;", "setEtDesc", "(Lcom/tencent/mm/ui/widget/MMEditText;)V", "etTextStatus", "Landroid/widget/EditText;", "getEtTextStatus", "()Landroid/widget/EditText;", "setEtTextStatus", "(Landroid/widget/EditText;)V", "fakeBtnOk", "getFakeBtnOk", "fakeBtnOk$delegate", "fakePic", "getFakePic", "setFakePic", "finishByPost", "", "globalLayoutListenerMode1", "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$globalLayoutListenerMode1$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$globalLayoutListenerMode1$1;", "globalLayoutListenerMode2", "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$globalLayoutListenerMode2$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$globalLayoutListenerMode2$1;", "hasReportPostWhenFinish", "getHasReportPostWhenFinish", "()Z", "setHasReportPostWhenFinish", "(Z)V", "hasSetCustomThumb", "getHasSetCustomThumb", "setHasSetCustomThumb", "iconCamera", "getIconCamera", "setIconCamera", "iconPoi", "getIconPoi", "setIconPoi", "iconStatus", "getIconStatus", "setIconStatus", "(Landroid/widget/ImageView;)V", "iconText", "getIconText", "setIconText", "iconVisibility", "getIconVisibility", "setIconVisibility", "imgVideoSource", "", "inputComponent", "Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent;", "getInputComponent", "()Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent;", "setInputComponent", "(Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent;)V", "isBackChanged", "setBackChanged", "ivBlur", "getIvBlur", "setIvBlur", "ivBlurSelect", "getIvBlurSelect", "ivBlurSelect$delegate", "ivBlurText", "Landroid/widget/TextView;", "getIvBlurText", "()Landroid/widget/TextView;", "ivBlurText$delegate", "ivBrand", "getIvBrand", "ivBrand$delegate", "ivPoiSelected", "getIvPoiSelected", "ivPoiSelected$delegate", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "lastClickTime", "getLastClickTime", "()J", "setLastClickTime", "(J)V", "lastGetCustomPartsTopicInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "getLastGetCustomPartsTopicInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "setLastGetCustomPartsTopicInfo", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;)V", "lastKeyboardHeight", "Ljava/lang/Integer;", "lastOriBitmap", "Landroid/graphics/Bitmap;", "lastSetThirdBackInfo", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$ThirdInfo;", "getLastSetThirdBackInfo", "()Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$ThirdInfo;", "setLastSetThirdBackInfo", "(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$ThirdInfo;)V", "layoutBlurOption", "getLayoutBlurOption", "setLayoutBlurOption", "layoutEditDesc", "getLayoutEditDesc", "setLayoutEditDesc", "layoutEditToolContainer", "getLayoutEditToolContainer", "setLayoutEditToolContainer", "layoutEmojiView", "getLayoutEmojiView", "layoutEmojiView$delegate", "layoutShow", "getLayoutShow", "layoutShow$delegate", "layoutThirdContainer", "Landroid/widget/FrameLayout;", "getLayoutThirdContainer", "()Landroid/widget/FrameLayout;", "layoutThirdContainer$delegate", "layoutThirdThumb", "getLayoutThirdThumb", "layoutThirdThumb$delegate", "layoutTopicEdit", "getLayoutTopicEdit", "setLayoutTopicEdit", "layoutVideo", "getLayoutVideo", "setLayoutVideo", "(Landroid/widget/FrameLayout;)V", "locationClickListener", "mChatRoomNameList", "", "mCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IMixStatusCustomParts;", "getMCustomParts", "()Lcom/tencent/mm/plugin/textstatus/api/IMixStatusCustomParts;", "setMCustomParts", "(Lcom/tencent/mm/plugin/textstatus/api/IMixStatusCustomParts;)V", "mLabelNameList", "mLabelRangeindex", "mOtherUserNameList", "mTipDialog", "Landroid/app/ProgressDialog;", "oriVideoFilePathBeforeEdt", "getOriVideoFilePathBeforeEdt", "()Ljava/lang/String;", "setOriVideoFilePathBeforeEdt", "(Ljava/lang/String;)V", "poiId", "getPoiId", "setPoiId", "rangeSource", "scrollShow", "Lcom/tencent/mm/view/MaxHeightScrollView;", "getScrollShow", "()Lcom/tencent/mm/view/MaxHeightScrollView;", "setScrollShow", "(Lcom/tencent/mm/view/MaxHeightScrollView;)V", "setStatusParam", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "getSetStatusParam", "()Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "setSetStatusParam", "(Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;)V", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "smileyPanelLevel", "getSmileyPanelLevel", "setSmileyPanelLevel", "smileyRoot", "getSmileyRoot", "smileyRoot$delegate", "style", "getStyle", "setStyle", "textWatcher", "Landroid/text/TextWatcher;", "getTextWatcher", "()Landroid/text/TextWatcher;", "thirdBack", "Lcom/tencent/mm/ui/widget/IPullDownView;", "getThirdBack", "()Lcom/tencent/mm/ui/widget/IPullDownView;", "setThirdBack", "(Lcom/tencent/mm/ui/widget/IPullDownView;)V", "thirdContainerLl", "Landroid/widget/LinearLayout;", "getThirdContainerLl", "()Landroid/widget/LinearLayout;", "thirdContainerLl$delegate", "thirdDescTv", "getThirdDescTv", "thirdDescTv$delegate", "thirdIconContainerFl", "getThirdIconContainerFl", "thirdIconContainerFl$delegate", "tipsPopup", "Lcom/tencent/mm/plugin/textstatus/ui/MMTipsPopupWindow;", "getTipsPopup", "()Lcom/tencent/mm/plugin/textstatus/ui/MMTipsPopupWindow;", "setTipsPopup", "(Lcom/tencent/mm/plugin/textstatus/ui/MMTipsPopupWindow;)V", "topicContainerLl", "getTopicContainerLl", "topicContainerLl$delegate", "tvCancel", "getTvCancel", "setTvCancel", "tvDesc", "getTvDesc", "setTvDesc", "(Landroid/widget/TextView;)V", "tvPoi", "getTvPoi", "tvPoi$delegate", "tvTextStatus", "getTvTextStatus", "setTvTextStatus", "tvVisibility", "getTvVisibility", "setTvVisibility", "updateVPicCallback", "Lcom/tencent/mm/modelimage/UrlImageCacheService$ILoadCallback;", "vBack", "getVBack", "setVBack", "vBackGroundIcon", "getVBackGroundIcon", "vBackGroundIcon$delegate", "vCamera", "getVCamera", "vCamera$delegate", "vContentCompact", "getVContentCompact", "vContentCompact$delegate", "vEmojiPanelBack", "getVEmojiPanelBack", "vEmojiPanelBack$delegate", "vFake", "getVFake", "vFake$delegate", "vMask", "getVMask", "setVMask", "vPic", "getVPic", "vPic$delegate", "vPicBg", "getVPicBg", "vPicBg$delegate", "vPicLoadUrl", "vPoi", "getVPoi", "setVPoi", "vVisibility", "getVVisibility", "setVVisibility", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;", "getVideoLayout", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;", "setVideoLayout", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;)V", "visibilityClickListener", "visiblityUserNames", "Ljava/util/LinkedList;", "applyGalleryResult", "", "mediaType", "filePath", "thumbPath", "chatRoomToUserList", "", "chatRoomNames", "checkCurCustomPartsValid", "topicInfo", "checkCurThirdBackValid", "thirdInfo", "checkIsEditSourceBack", "closeThirdBack", "deleteBack", "destroyCustomPartsManual", "destroyThirdBackManual", "destroyVideo", "doPost", "doWhenLess", "text", "doWhenMore", "doWhenOK", "finish", "genThumbFromVideo", "videoPath", "getBelowAnimator", "height", "getCurTextStatus", "getCustomParts", "getCustomTitle", "getFinderMenuSpan", "", "getForceOrientation", "getLayoutId", "getReportData", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostReportData;", "sourceId", "jumpInfos", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getUpAnimator", "getVisibilityInfo", "userList", "goCapture", "goGallery", "goGalleryForSysVideo", "goPickFinder", "handleCaptureResult", "data", "Landroid/content/Intent;", "handleEmojiForPanelChange", "handleEmojiInfoSelect", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "handleFileLocal", "handleFinderResult", "resultCode", "handleGalleryResult", "handlePanelChange", "handlePoi", "requestCode", "handleReportData", "handleThirdBack", "handleThirdThumb", "handleThumbDownload", "thumbUrl", "succCallback", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$DownLoadSuccCallback;", "hideEmojiKeyboard", "initBackGroundResId", "initBlur", "initCameraIcon", "initCurTextStatusExtInfo", "initDesc", "initEditText", "initEmojiInfo", "initMedia", "initMediaByExtInfo", "extInfo", "initMediaByInfo", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "initPoi", "initSmileyPanel", "initStatusIcon", "initTopicTips", "initTvTextStatus", "initVisibility", "isBtnOkEnable", "isFromThirdPost", "isHasSmileyPanel", "labelToUserList", "", "labelNames", "loadVisibility", "onActivityResult", "onAttachedToWindow", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteEmoji", "onDestroy", "onInputPanelChange", "isKeyboardShow", "keyboardHeight", "onKeyboardHeightChanged", "isResized", "onPause", "onPressEmoji", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onWindowFocusChanged", "hasFocus", "openThirdBack", "pauseVideo", "resumeVideo", "selectPoi", "setDefBackGround", "setForegroundPic", "bitmap", "isGraEffect", "setForegroundPicInner", "setIcon", "setPoiVisibility", "visibility", "setSysInsertionEnabled", "enabled", "setVisibilityWord", "labelRange", "showAlertDialog", "strId", "showEducationLayout", "showEmojiKeyboard", "switchEditContent", "type", "tryReportPostWhenFinish", "trySetDefBackground", "isMediaValid", "updateBlurStatus", "updateBtnOkEnable", "updateFakeBtnOkVisible", "updatePoi", "updateThirdView", "clearThirdBackInfo", "handleRefTopicInfo", "refTopicInfo", "hasMedia", "updateThirdBackInfo", "target", "Companion", "DownLoadSuccCallback", "EditContentType", "MediaStruct", "ThirdInfo", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusEditActivity
  extends MMSecDataActivity
  implements EmojiPanelInputComponent.a, com.tencent.mm.plugin.textstatus.emoji.c, com.tencent.mm.ui.tools.b.c.a, com.tencent.mm.ui.tools.h
{
  public static final TextStatusEditActivity.a Txz;
  private static Bitmap TyT;
  private MMTPEffectVideoLayout Goz;
  private ObjectAnimator Jvf;
  private ObjectAnimator Jvg;
  private EmojiPanelInputComponent MHO;
  private final View.OnClickListener NYC;
  private int RiP;
  private String RiR;
  private String RiS;
  private String RiT;
  public ImageView TlA;
  private ImageView TlN;
  private TextView Tlw;
  private TextView Tlx;
  private com.tencent.mm.plugin.textstatus.a.e Tmh;
  private TextStatusTopicInfo Tmi;
  FrameLayout Tvm;
  private com.tencent.mm.ui.widget.b Tvz;
  private View TxA;
  private final kotlin.j TxB;
  private final kotlin.j TxC;
  private final kotlin.j TxD;
  private View TxE;
  private View TxF;
  private View TxG;
  private View TxH;
  private View TxI;
  private final kotlin.j TxJ;
  private View TxK;
  public MMEditText TxL;
  private Button TxM;
  private final kotlin.j TxN;
  private TextView TxO;
  private final kotlin.j TxP;
  private final kotlin.j TxQ;
  private final kotlin.j TxR;
  private View TxS;
  private final kotlin.j TxT;
  private final kotlin.j TxU;
  private ImageView TxV;
  private final kotlin.j TxW;
  private final kotlin.j TxX;
  private final kotlin.j TxY;
  private final kotlin.j TxZ;
  w Txn;
  int TyA;
  private boolean TyB;
  private final TextStatusEditActivity.p TyC;
  private final TextStatusEditActivity.o TyD;
  private final TextStatusEditActivity.configUpdateListener.1 TyE;
  c TyF;
  private d TyG;
  private String TyH;
  private s.a TyI;
  private Integer TyJ;
  private final View.OnClickListener TyK;
  private final View.OnClickListener TyL;
  private LinkedList<String> TyM;
  private int TyN;
  private boolean TyO;
  private TextStatusEditActivity.e TyP;
  private String TyQ;
  private boolean TyR;
  public d TyS;
  private final kotlin.j Tya;
  private View Tyb;
  private View Tyc;
  private MaxHeightScrollView Tyd;
  private View Tye;
  private final kotlin.j Tyf;
  private View Tyg;
  private View Tyh;
  public View Tyi;
  private final kotlin.j Tyj;
  public View Tyk;
  public View Tyl;
  public ImageView Tym;
  private final kotlin.j Tyn;
  private final kotlin.j Tyo;
  private final kotlin.j Typ;
  private final kotlin.j Tyq;
  private final kotlin.j Tyr;
  private final kotlin.j Tys;
  private final kotlin.j Tyt;
  private final kotlin.j Tyu;
  private final kotlin.j Tyv;
  private boolean Tyw;
  public TextStatusExtInfo Tyx;
  private int Tyy;
  private Bitmap Tyz;
  private final kotlin.j cEV;
  private com.tencent.mm.ui.tools.i lKz;
  private long lastClickTime;
  private int niy;
  private final TextWatcher pKm;
  private int style;
  private ProgressDialog vEG;
  
  static
  {
    AppMethodBeat.i(292109);
    Txz = new TextStatusEditActivity.a((byte)0);
    AppMethodBeat.o(292109);
  }
  
  public TextStatusEditActivity()
  {
    AppMethodBeat.i(291862);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)new com.tencent.mm.plugin.textstatus.h.l(), 0);
    this.TxB = kotlin.k.cm((kotlin.g.a.a)new al(this));
    this.TxC = kotlin.k.cm((kotlin.g.a.a)new ao(this));
    this.TxD = kotlin.k.cm((kotlin.g.a.a)new an(this));
    this.TxJ = kotlin.k.cm((kotlin.g.a.a)new w(this));
    this.TxN = kotlin.k.cm((kotlin.g.a.a)new aj(this));
    this.TxP = kotlin.k.cm((kotlin.g.a.a)new ap(this));
    this.TxQ = kotlin.k.cm((kotlin.g.a.a)new aq(this));
    this.TxR = kotlin.k.cm((kotlin.g.a.a)new ak(this));
    this.TxT = kotlin.k.cm((kotlin.g.a.a)new z(this));
    this.TxU = kotlin.k.cm((kotlin.g.a.a)new aa(this));
    this.TxW = kotlin.k.cm((kotlin.g.a.a)new y(this));
    this.TxX = kotlin.k.cm((kotlin.g.a.a)new k(this));
    this.TxY = kotlin.k.cm((kotlin.g.a.a)new x(this));
    this.TxZ = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.Tya = kotlin.k.cm((kotlin.g.a.a)new am(this));
    this.Tyf = kotlin.k.cm((kotlin.g.a.a)new ai(this));
    this.Tyj = kotlin.k.cm((kotlin.g.a.a)new l(this));
    this.Tyn = kotlin.k.cm((kotlin.g.a.a)new t(this));
    this.Tyo = kotlin.k.cm((kotlin.g.a.a)new u(this));
    this.Typ = kotlin.k.cm((kotlin.g.a.a)new af(this));
    this.Tyq = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.Tyr = kotlin.k.cm((kotlin.g.a.a)new ag(this));
    this.Tys = kotlin.k.cm((kotlin.g.a.a)new ah(this));
    this.Tyt = kotlin.k.cm((kotlin.g.a.a)new v(this));
    this.Tyu = kotlin.k.cm((kotlin.g.a.a)new ad(this));
    this.Tyv = kotlin.k.cm((kotlin.g.a.a)new j(this));
    this.cEV = kotlin.k.cm((kotlin.g.a.a)new TextStatusEditActivity.i(this));
    com.tencent.mm.plugin.textstatus.util.k localk = com.tencent.mm.plugin.textstatus.util.k.TBx;
    this.Tyy = com.tencent.mm.plugin.textstatus.util.k.hKA();
    this.TyC = new TextStatusEditActivity.p(this);
    this.TyD = new TextStatusEditActivity.o(this);
    this.TyE = new TextStatusEditActivity.configUpdateListener.1(this, com.tencent.mm.app.f.hfK);
    this.TyF = c.TyU;
    this.pKm = ((TextWatcher)new ae(this));
    this.RiR = "";
    this.RiS = "";
    this.RiT = "";
    this.TyK = new TextStatusEditActivity..ExternalSyntheticLambda17(this);
    this.NYC = new TextStatusEditActivity..ExternalSyntheticLambda19(this);
    this.TyL = new TextStatusEditActivity..ExternalSyntheticLambda14(this);
    this.TyM = new LinkedList();
    this.TyQ = "";
    AppMethodBeat.o(291862);
  }
  
  private static final void D(DialogInterface paramDialogInterface) {}
  
  private final com.tencent.mm.ui.widget.b N(String paramString, List<? extends TextStatusJumpInfo> paramList)
  {
    Object localObject2 = null;
    AppMethodBeat.i(291980);
    com.tencent.mm.plugin.textstatus.proto.l locall = new com.tencent.mm.plugin.textstatus.proto.l();
    locall.nDl = 0;
    locall.ToO = 0;
    int i = hJm().createTime;
    label54:
    Object localObject1;
    if (i != 0)
    {
      locall.ToQ = i;
      if (paramList != null) {
        break label120;
      }
      paramList = null;
      localObject1 = com.tencent.mm.plugin.textstatus.third.i.TuX;
      if (paramList != null) {
        break label128;
      }
      localObject1 = null;
      label66:
      localObject1 = com.tencent.mm.plugin.textstatus.third.i.bec((String)localObject1);
      if (localObject1 != null) {
        break label137;
      }
    }
    label128:
    label137:
    for (paramString = localObject2;; paramString = ((o)localObject1).a(paramString, hIT(), paramList, locall))
    {
      paramList = getContext();
      if (((paramList instanceof MMFragmentActivity)) && (paramString != null)) {
        b.a.a(paramString, (MMFragmentActivity)paramList);
      }
      AppMethodBeat.o(291980);
      return paramString;
      i = com.tencent.mm.model.cn.getSyncServerTimeSecond();
      break;
      label120:
      paramList = com.tencent.mm.plugin.textstatus.third.j.lu(paramList);
      break label54;
      localObject1 = paramList.jumpType;
      break label66;
    }
  }
  
  private static final void P(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(292055);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(292055);
  }
  
  private final void V(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(291988);
    hJu();
    d locald = hJK();
    AppCompatActivity localAppCompatActivity = getContext();
    kotlin.g.b.s.s(localAppCompatActivity, "context");
    locald.a(paramInt, paramString1, paramString2, (Context)localAppCompatActivity, this.TyQ);
    hs(paramString1, paramInt);
    hJs();
    hJD();
    hJB();
    AppMethodBeat.o(291988);
  }
  
  private static final void a(Bitmap paramBitmap, TextStatusEditActivity paramTextStatusEditActivity)
  {
    AppMethodBeat.i(292046);
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    if ((paramBitmap.getWidth() != 0) && (paramTextStatusEditActivity.hIQ().getWidth() != 0))
    {
      float f1 = paramBitmap.getHeight() / paramBitmap.getWidth();
      float f2 = paramTextStatusEditActivity.hIQ().getHeight() / paramTextStatusEditActivity.hIQ().getWidth();
      Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "setForegroundPic vpic post end " + paramBitmap.getWidth() + ' ' + paramBitmap.getHeight() + ' ' + f1 + ' ' + paramTextStatusEditActivity.hIQ().getWidth() + ' ' + paramTextStatusEditActivity.hIQ().getHeight() + ' ' + f2);
      if (f1 > f2)
      {
        paramTextStatusEditActivity.aQ(paramBitmap);
        AppMethodBeat.o(292046);
        return;
      }
    }
    Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "setForegroundPic vpic post end " + paramBitmap.getWidth() + ' ' + paramBitmap.getHeight() + ' ' + paramTextStatusEditActivity.hIQ().getWidth() + ' ' + paramTextStatusEditActivity.hIQ().getHeight());
    com.tencent.mm.videocomposition.effect.a locala = new com.tencent.mm.videocomposition.effect.a();
    locala.setInputBitmap(paramBitmap);
    locala.setOutputSize(paramTextStatusEditActivity.hIQ().getWidth(), paramTextStatusEditActivity.hIQ().getHeight());
    locala.HkF.GpO.jQk();
    locala.aW((kotlin.g.a.b)new TextStatusEditActivity.ab(paramTextStatusEditActivity));
    AppMethodBeat.o(292046);
  }
  
  private static final void a(Bitmap paramBitmap, TextStatusEditActivity paramTextStatusEditActivity, TextStatusEditActivity.b paramb)
  {
    AppMethodBeat.i(292037);
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    Object localObject = com.tencent.mm.plugin.textstatus.util.e.TAU;
    localObject = com.tencent.mm.plugin.auth.a.a.cUx();
    kotlin.g.b.s.s(localObject, "username()");
    localObject = com.tencent.mm.plugin.textstatus.util.e.nl("ptmptmb", (String)localObject);
    com.tencent.mm.plugin.textstatus.g.b.m(paramBitmap, (String)localObject);
    paramTextStatusEditActivity.hIQ().post(new TextStatusEditActivity..ExternalSyntheticLambda37(paramTextStatusEditActivity, (String)localObject, paramb));
    AppMethodBeat.o(292037);
  }
  
  private void a(c paramc)
  {
    AppMethodBeat.i(291936);
    kotlin.g.b.s.u(paramc, "type");
    this.TyF = paramc;
    switch (f.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(291936);
      return;
      paramc = hIP().getLayoutParams();
      if (paramc != null)
      {
        paramc.height = -2;
        hIP().setLayoutParams(paramc);
      }
      paramc = this.Tyh;
      if (paramc != null) {
        paramc.setVisibility(0);
      }
      hIY().setVisibility(8);
      hJB();
      hIX().setEmojiInfo(null);
      paramc = this.TyJ;
      if (paramc == null)
      {
        AppMethodBeat.o(291936);
        return;
      }
      if (paramc.intValue() == 0)
      {
        hIZ().setVisibility(0);
        AppMethodBeat.o(291936);
        return;
        hIY().setVisibility(0);
        hJB();
        paramc = hIP().getLayoutParams();
        if (paramc != null)
        {
          paramc.height = 1;
          hIP().setLayoutParams(paramc);
        }
        paramc = this.Tyh;
        if (paramc != null) {
          paramc.setVisibility(8);
        }
      }
    }
  }
  
  private static final void a(TextStatusEditActivity paramTextStatusEditActivity)
  {
    AppMethodBeat.i(292007);
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    MaxHeightScrollView localMaxHeightScrollView;
    if (paramTextStatusEditActivity.hIV() != null)
    {
      localMaxHeightScrollView = paramTextStatusEditActivity.Tyd;
      if (localMaxHeightScrollView != null)
      {
        paramTextStatusEditActivity = paramTextStatusEditActivity.hIV();
        if (paramTextStatusEditActivity != null) {
          break label59;
        }
      }
    }
    label59:
    for (paramTextStatusEditActivity = null;; paramTextStatusEditActivity = Integer.valueOf(paramTextStatusEditActivity.getMeasuredHeight()))
    {
      kotlin.g.b.s.checkNotNull(paramTextStatusEditActivity);
      localMaxHeightScrollView.setMaxHeight(paramTextStatusEditActivity.intValue());
      AppMethodBeat.o(292007);
      return;
    }
  }
  
  private static final void a(TextStatusEditActivity paramTextStatusEditActivity, int paramInt, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(292048);
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    if (paramValueAnimator == null)
    {
      paramValueAnimator = null;
      if (!(paramValueAnimator instanceof Float)) {
        break label62;
      }
      paramValueAnimator = (Float)paramValueAnimator;
      label31:
      if (paramValueAnimator != null) {
        break label67;
      }
    }
    label62:
    label67:
    for (float f = 0.0F;; f = paramValueAnimator.floatValue())
    {
      paramTextStatusEditActivity.onKeyboardHeightChanged((int)(paramInt - f), false);
      AppMethodBeat.o(292048);
      return;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      break;
      paramValueAnimator = null;
      break label31;
    }
  }
  
  private static final void a(TextStatusEditActivity paramTextStatusEditActivity, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(292054);
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    paramDialogInterface.dismiss();
    com.tencent.mm.pluginsdk.permission.b.lx((Context)paramTextStatusEditActivity.getContext());
    AppMethodBeat.o(292054);
  }
  
  private static final void a(TextStatusEditActivity paramTextStatusEditActivity, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(292057);
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    paramInt = paramMenuItem.getItemId();
    if (paramInt == a.e.TdI)
    {
      paramMenuItem = com.tencent.mm.plugin.secdata.ui.a.PlI;
      paramMenuItem = paramTextStatusEditActivity.getContext();
      kotlin.g.b.s.s(paramMenuItem, "context");
      paramMenuItem = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)paramMenuItem, 8, bh.class);
      if (paramMenuItem != null) {
        paramMenuItem.TqU += 1;
      }
      paramTextStatusEditActivity.hJy();
      AppMethodBeat.o(292057);
      return;
    }
    if (paramInt == a.e.TdL)
    {
      paramMenuItem = com.tencent.mm.plugin.secdata.ui.a.PlI;
      paramMenuItem = paramTextStatusEditActivity.getContext();
      kotlin.g.b.s.s(paramMenuItem, "context");
      paramMenuItem = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)paramMenuItem, 8, bh.class);
      if (paramMenuItem != null) {
        paramMenuItem.TqV += 1;
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_edit_video_max_time_length", com.tencent.mm.plugin.recordvideo.c.a.a.NHs.gHD());
      paramMenuItem.putExtra("key_edit_text_color", "#0E9CE6");
      paramMenuItem.putExtra("album_is_from_text_status", true);
      paramMenuItem.putExtra("edt_video_layout_from_text_status", TextStatusEditVideoPluginLayout.class.getName());
      paramTextStatusEditActivity = paramTextStatusEditActivity.getContext();
      if (paramTextStatusEditActivity == null)
      {
        paramTextStatusEditActivity = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(292057);
        throw paramTextStatusEditActivity;
      }
      t.a((Activity)paramTextStatusEditActivity, 6, 1, 22, 3, false, paramMenuItem);
      AppMethodBeat.o(292057);
      return;
    }
    if (paramInt == a.e.TdK)
    {
      paramTextStatusEditActivity.hJx();
      AppMethodBeat.o(292057);
      return;
    }
    if (paramInt == a.e.TdJ)
    {
      paramMenuItem = com.tencent.mm.plugin.secdata.ui.a.PlI;
      paramMenuItem = paramTextStatusEditActivity.getContext();
      kotlin.g.b.s.s(paramMenuItem, "context");
      paramMenuItem = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)paramMenuItem, 8, bh.class);
      if (paramMenuItem != null) {
        paramMenuItem.Trl += 1L;
      }
      paramTextStatusEditActivity.hJu();
    }
    AppMethodBeat.o(292057);
  }
  
  private static final void a(TextStatusEditActivity paramTextStatusEditActivity, View paramView)
  {
    AppMethodBeat.i(292010);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusEditActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    if (!paramTextStatusEditActivity.hJa().isEnabled())
    {
      paramTextStatusEditActivity.Tx(null);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(292010);
      return;
    }
    paramTextStatusEditActivity.Tw(paramTextStatusEditActivity.hIP().getText().toString());
    paramTextStatusEditActivity = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
    if (com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKm() != null)
    {
      if (!((com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class)).bUx()) {
        break label245;
      }
      paramTextStatusEditActivity = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.LO(com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKn() + 1);
      com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKn();
      localObject = new JSONObject();
      paramTextStatusEditActivity = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      paramView = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKm();
      paramTextStatusEditActivity = paramView;
      if (paramView == null) {
        paramTextStatusEditActivity = "";
      }
      ((JSONObject)localObject).put("5", paramTextStatusEditActivity);
      ((ce)com.tencent.mm.kernel.h.ax(ce.class)).a(q.c.Drl, ((JSONObject)localObject).toString());
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(292010);
      return;
      label245:
      paramTextStatusEditActivity = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.LO(com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKn() + 1);
      com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKn();
      paramTextStatusEditActivity = (cf)com.tencent.mm.kernel.h.ax(cf.class);
      paramView = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      paramTextStatusEditActivity.a(com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKm(), q.ch.DFA, ak.kkZ());
    }
  }
  
  private static final void a(TextStatusEditActivity paramTextStatusEditActivity, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(292056);
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    params.a(a.e.TdI, (CharSequence)paramTextStatusEditActivity.getString(a.h.TfY), (CharSequence)paramTextStatusEditActivity.getString(b.j.app_field_pic_video), 0);
    params.c(a.e.TdL, (CharSequence)paramTextStatusEditActivity.getString(a.h.settings_avatar_select_from_album));
    if ((ac.hGn()) && ((!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) || (((bw)com.tencent.mm.kernel.h.ax(bw.class)).eZE())))
    {
      int i = a.e.TdK;
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      Drawable localDrawable = bb.e(paramTextStatusEditActivity.getDrawable(a.d.icons_filled_finder_icon), Color.parseColor("#F99234"));
      int j = paramTextStatusEditActivity.getResources().getDimensionPixelSize(a.c.HeadlineTextSize);
      com.tencent.mm.plugin.textstatus.ui.b.a locala = new com.tencent.mm.plugin.textstatus.ui.b.a(localDrawable);
      localDrawable.setBounds(0, 0, j, j);
      localSpannableStringBuilder.append(' ');
      localSpannableStringBuilder.setSpan(locala, localSpannableStringBuilder.length() - 1, localSpannableStringBuilder.length(), 17);
      localSpannableStringBuilder.append((CharSequence)paramTextStatusEditActivity.getString(a.h.TfT));
      params.c(i, (CharSequence)localSpannableStringBuilder);
    }
    if ((paramTextStatusEditActivity.hJK().hJP()) || (paramTextStatusEditActivity.Tvz != null)) {
      params.a(a.e.TdJ, paramTextStatusEditActivity.getResources().getColor(a.b.Red), (CharSequence)paramTextStatusEditActivity.getString(a.h.TfU));
    }
    AppMethodBeat.o(292056);
  }
  
  private static final void a(TextStatusEditActivity paramTextStatusEditActivity, String paramString, TextStatusEditActivity.b paramb)
  {
    AppMethodBeat.i(292036);
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    kotlin.g.b.s.u(paramString, "$tmpTmbPath");
    paramTextStatusEditActivity.hs(paramString, 1);
    paramTextStatusEditActivity.hJs();
    if (paramb != null) {
      paramb.beg(paramString);
    }
    AppMethodBeat.o(292036);
  }
  
  private void a(String paramString, TextStatusEditActivity.b paramb)
  {
    AppMethodBeat.i(291942);
    hJt();
    Log.i("MicroMsg.TextStatus.TextStatusEditActivity", kotlin.g.b.s.X("trydownload imgback:", paramString));
    this.TyI = new TextStatusEditActivity..ExternalSyntheticLambda24(paramString, this, paramb);
    r.bKd().a(paramString, this.TyI);
    this.TyH = paramString;
    AppMethodBeat.o(291942);
  }
  
  private static final void a(String paramString, TextStatusEditActivity paramTextStatusEditActivity)
  {
    AppMethodBeat.i(292045);
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    paramString = com.tencent.mm.plugin.textstatus.g.b.aXb(paramString);
    Log.i("MicroMsg.TextStatus.TextStatusEditActivity", kotlin.g.b.s.X("handleFileLocal decodeImg bitmap:", paramString));
    if (paramString != null)
    {
      Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "setForegroundPic vpic post start " + paramString + ' ' + true);
      paramTextStatusEditActivity.hIQ().post(new TextStatusEditActivity..ExternalSyntheticLambda28(paramString, paramTextStatusEditActivity));
      AppMethodBeat.o(292045);
      return;
    }
    AppMethodBeat.o(292045);
  }
  
  private static final void a(String paramString1, TextStatusEditActivity paramTextStatusEditActivity, TextStatusEditActivity.b paramb, String paramString2, Bitmap paramBitmap, String paramString3)
  {
    AppMethodBeat.i(292040);
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "trydownload imgback end:" + paramString1 + " bitmap:" + paramBitmap + " exist:" + y.ZC(paramString3) + " len:" + y.bEl(paramString3));
    if (paramBitmap == null)
    {
      AppMethodBeat.o(292040);
      return;
    }
    if (!y.ZC(paramString3))
    {
      com.tencent.threadpool.h.ahAA.bm(new TextStatusEditActivity..ExternalSyntheticLambda29(paramBitmap, paramTextStatusEditActivity, paramb));
      AppMethodBeat.o(292040);
      return;
    }
    paramTextStatusEditActivity.hs(paramString3, 1);
    paramTextStatusEditActivity.hJs();
    if (paramb != null)
    {
      kotlin.g.b.s.s(paramString3, "path");
      paramb.beg(paramString3);
    }
    AppMethodBeat.o(292040);
  }
  
  private final boolean a(TextStatusEditActivity.e parame)
  {
    AppMethodBeat.i(291982);
    String str = parame.sourceId;
    Object localObject = this.TyP;
    if (localObject == null) {}
    for (localObject = null; !kotlin.g.b.s.p(str, localObject); localObject = ((TextStatusEditActivity.e)localObject).sourceId)
    {
      AppMethodBeat.o(291982);
      return false;
    }
    localObject = this.TyP;
    if (localObject != null)
    {
      localObject = ((TextStatusEditActivity.e)localObject).DHi;
      if ((localObject != null) && (com.tencent.mm.plugin.textstatus.d.b.O((List)localObject, parame.DHi) == true))
      {
        AppMethodBeat.o(291982);
        return true;
      }
    }
    AppMethodBeat.o(291982);
    return false;
  }
  
  private static final boolean a(TextStatusEditActivity paramTextStatusEditActivity, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(292006);
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    paramTextStatusEditActivity.finish();
    AppMethodBeat.o(292006);
    return false;
  }
  
  private static final void aC(boolean paramBoolean, String paramString) {}
  
  private final void aQ(Bitmap paramBitmap)
  {
    AppMethodBeat.i(291954);
    paramBitmap = (kotlin.g.a.a)new ac(paramBitmap, this);
    if (kotlin.g.b.s.p(Looper.getMainLooper(), Looper.myLooper()))
    {
      paramBitmap.invoke();
      AppMethodBeat.o(291954);
      return;
    }
    hIQ().post(new TextStatusEditActivity..ExternalSyntheticLambda39(paramBitmap));
    AppMethodBeat.o(291954);
  }
  
  private final ObjectAnimator aot(int paramInt)
  {
    AppMethodBeat.i(291956);
    if (this.Jvg == null)
    {
      this.Jvg = ObjectAnimator.ofFloat(hJk(), View.TRANSLATION_Y, new float[] { paramInt, 0.0F });
      localObjectAnimator = this.Jvg;
      if (localObjectAnimator != null) {
        localObjectAnimator.setDuration(300L);
      }
      localObjectAnimator = this.Jvg;
      if (localObjectAnimator != null) {
        localObjectAnimator.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
      }
      localObjectAnimator = this.Jvg;
      if (localObjectAnimator != null) {
        localObjectAnimator.addUpdateListener(new TextStatusEditActivity..ExternalSyntheticLambda1(this, paramInt));
      }
    }
    ObjectAnimator localObjectAnimator = this.Jvg;
    if (localObjectAnimator != null) {
      localObjectAnimator.removeAllListeners();
    }
    localObjectAnimator = this.Jvg;
    if (localObjectAnimator != null) {
      localObjectAnimator.addListener((Animator.AnimatorListener)new n(this));
    }
    localObjectAnimator = this.Jvg;
    AppMethodBeat.o(291956);
    return localObjectAnimator;
  }
  
  private final ObjectAnimator aou(int paramInt)
  {
    AppMethodBeat.i(291957);
    if (this.Jvf == null)
    {
      this.Jvf = ObjectAnimator.ofFloat(hJk(), View.TRANSLATION_Y, new float[] { 0.0F, paramInt });
      localObjectAnimator = this.Jvf;
      if (localObjectAnimator != null) {
        localObjectAnimator.setDuration(300L);
      }
      localObjectAnimator = this.Jvf;
      if (localObjectAnimator != null) {
        localObjectAnimator.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
      }
      localObjectAnimator = this.Jvf;
      if (localObjectAnimator != null) {
        localObjectAnimator.addUpdateListener(new TextStatusEditActivity..ExternalSyntheticLambda0(this, paramInt));
      }
    }
    ObjectAnimator localObjectAnimator = this.Jvf;
    if (localObjectAnimator != null) {
      localObjectAnimator.removeAllListeners();
    }
    localObjectAnimator = this.Jvf;
    if (localObjectAnimator != null) {
      localObjectAnimator.addListener((Animator.AnimatorListener)new m(this));
    }
    localObjectAnimator = this.Jvf;
    AppMethodBeat.o(291957);
    return localObjectAnimator;
  }
  
  private final void aov(int paramInt)
  {
    AppMethodBeat.i(291962);
    TextView localTextView;
    if (paramInt == 3)
    {
      localTextView = this.TxO;
      if (localTextView != null)
      {
        localTextView.setText((CharSequence)getContext().getString(a.h.Thi));
        AppMethodBeat.o(291962);
      }
    }
    else
    {
      localTextView = this.TxO;
      if (localTextView != null) {
        localTextView.setText((CharSequence)getContext().getString(a.h.Thh));
      }
    }
    AppMethodBeat.o(291962);
  }
  
  private final void aow(int paramInt)
  {
    AppMethodBeat.i(291966);
    hHh().setVisibility(paramInt);
    if (paramInt == 0)
    {
      hIO().setVisibility(0);
      AppMethodBeat.o(291966);
      return;
    }
    hIO().setVisibility(8);
    AppMethodBeat.o(291966);
  }
  
  private final void aox(int paramInt)
  {
    AppMethodBeat.i(292003);
    ViewGroup.LayoutParams localLayoutParams;
    if (hJn())
    {
      localLayoutParams = hIN().getLayoutParams();
      localLayoutParams.height = paramInt;
      hIN().setLayoutParams(localLayoutParams);
      localLayoutParams = hIX().getLayoutParams();
      if (paramInt <= 0) {
        break label82;
      }
    }
    label82:
    for (paramInt = com.tencent.mm.cd.a.br((Context)this, a.c.TbI);; paramInt = com.tencent.mm.cd.a.br((Context)this, a.c.TbH))
    {
      localLayoutParams.width = paramInt;
      localLayoutParams.height = paramInt;
      hIX().setLayoutParams(localLayoutParams);
      AppMethodBeat.o(292003);
      return;
    }
  }
  
  private final void aoy(int paramInt)
  {
    AppMethodBeat.i(292005);
    Object localObject = this.TyJ;
    if (localObject == null)
    {
      this.TyJ = Integer.valueOf(paramInt);
      localObject = this.TyG;
      if (localObject != null) {
        ((d)localObject).dismiss();
      }
      aox(paramInt);
      if (paramInt <= 0) {
        break label206;
      }
      int i = bd.bs((Context)getContext(), a.c.Edge_2A);
      localObject = this.Tyc;
      if (localObject != null) {
        ((View)localObject).setTranslationY(Math.min(-(paramInt - i), 0.0F));
      }
      int[] arrayOfInt = com.tencent.mm.ae.d.da(hIW());
      localObject = this.Tyc;
      if (localObject != null) {
        break label198;
      }
      localObject = null;
      label101:
      View localView = hIW();
      if ((arrayOfInt != null) && (localObject != null) && (localView != null)) {
        localView.setTranslationY(Math.min((localObject[1] - arrayOfInt[1]) / 2 - localView.getMeasuredHeight() / 3, 0.0F));
      }
      label149:
      localObject = hIZ();
      if ((this.TyF != c.TyV) || (paramInt != 0)) {
        break label248;
      }
    }
    label198:
    label206:
    label248:
    for (paramInt = 8;; paramInt = 4)
    {
      ((View)localObject).setVisibility(paramInt);
      AppMethodBeat.o(292005);
      return;
      if (((Integer)localObject).intValue() != paramInt) {
        break;
      }
      AppMethodBeat.o(292005);
      return;
      localObject = com.tencent.mm.ae.d.da((View)localObject);
      break label101;
      getWindow().setNavigationBarColor(getResources().getColor(a.b.Dark_2));
      hIW().setTranslationY(0.0F);
      localObject = this.Tyc;
      if (localObject == null) {
        break label149;
      }
      ((View)localObject).setTranslationY(0.0F);
      break label149;
    }
  }
  
  private void b(TextStatusTopicInfo paramTextStatusTopicInfo1, TextStatusTopicInfo paramTextStatusTopicInfo2)
  {
    AppMethodBeat.i(291937);
    kotlin.g.b.s.u(paramTextStatusTopicInfo1, "<this>");
    Object localObject1 = (CharSequence)paramTextStatusTopicInfo1.sourceId;
    if ((localObject1 == null) || (kotlin.n.n.bp((CharSequence)localObject1)))
    {
      i = 1;
      if (i == 0)
      {
        localObject1 = hHr();
        if ((localObject1 == null) || (((com.tencent.mm.plugin.textstatus.a.e)localObject1).hFt() != true)) {
          break label279;
        }
        i = 1;
        label63:
        if (i != 0)
        {
          localObject1 = hHr();
          if ((localObject1 == null) || (((com.tencent.mm.plugin.textstatus.a.e)localObject1).etQ() != true)) {
            break label284;
          }
          i = 1;
          label89:
          if (i == 0) {}
        }
      }
      else
      {
        if (paramTextStatusTopicInfo2 != null) {
          break label289;
        }
        localObject1 = null;
        label100:
        paramTextStatusTopicInfo1.sourceId = ((String)localObject1);
        if (paramTextStatusTopicInfo2 != null) {
          break label298;
        }
        localObject1 = null;
        label113:
        paramTextStatusTopicInfo1.sourceName = ((String)localObject1);
        if (paramTextStatusTopicInfo2 != null) {
          break label307;
        }
        localObject1 = null;
        label126:
        paramTextStatusTopicInfo1.sourceActivityId = ((String)localObject1);
        if (paramTextStatusTopicInfo2 != null) {
          break label316;
        }
        localObject1 = null;
        label139:
        paramTextStatusTopicInfo1.sourceIcon = ((String)localObject1);
        if (paramTextStatusTopicInfo2 != null) {
          break label325;
        }
        localObject1 = null;
        label152:
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new LinkedList();
        }
        paramTextStatusTopicInfo1.sourceJumpInfos = ((LinkedList)localObject2);
        if (paramTextStatusTopicInfo2 != null) {
          break label334;
        }
        localObject1 = null;
        label183:
        paramTextStatusTopicInfo1.verifyInfo = ((String)localObject1);
      }
      if (paramTextStatusTopicInfo2 != null) {
        break label343;
      }
      paramTextStatusTopicInfo2 = null;
      label195:
      localObject1 = paramTextStatusTopicInfo2;
      if (paramTextStatusTopicInfo2 == null) {
        localObject1 = new LinkedList();
      }
      paramTextStatusTopicInfo1.jumpInfos = ((LinkedList)localObject1);
      paramTextStatusTopicInfo2 = (CharSequence)paramTextStatusTopicInfo1.sourceId;
      if ((paramTextStatusTopicInfo2 != null) && (!kotlin.n.n.bp(paramTextStatusTopicInfo2))) {
        break label351;
      }
    }
    label279:
    label284:
    label289:
    label298:
    label307:
    label316:
    label325:
    label334:
    label343:
    label351:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (paramTextStatusTopicInfo1.jumpInfos.size() == 0)) {
        paramTextStatusTopicInfo1.jumpInfos.addAll((Collection)paramTextStatusTopicInfo1.sourceJumpInfos);
      }
      AppMethodBeat.o(291937);
      return;
      i = 0;
      break;
      i = 0;
      break label63;
      i = 0;
      break label89;
      localObject1 = paramTextStatusTopicInfo2.sourceId;
      break label100;
      localObject1 = paramTextStatusTopicInfo2.sourceName;
      break label113;
      localObject1 = paramTextStatusTopicInfo2.sourceActivityId;
      break label126;
      localObject1 = paramTextStatusTopicInfo2.sourceIcon;
      break label139;
      localObject1 = paramTextStatusTopicInfo2.sourceJumpInfos;
      break label152;
      localObject1 = paramTextStatusTopicInfo2.verifyInfo;
      break label183;
      paramTextStatusTopicInfo2 = paramTextStatusTopicInfo2.jumpInfos;
      break label195;
    }
  }
  
  private static final void b(TextStatusEditActivity paramTextStatusEditActivity)
  {
    AppMethodBeat.i(292035);
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    View localView = paramTextStatusEditActivity.Tyh;
    if (localView != null) {}
    Object localObject1;
    int n;
    int i1;
    int k;
    int j;
    int i2;
    int i3;
    int i;
    int m;
    int i4;
    for (;;)
    {
      try
      {
        if (!paramTextStatusEditActivity.isFinishing())
        {
          localObject1 = new int[2];
          localView.getLocationInWindow((int[])localObject1);
          localObject2 = paramTextStatusEditActivity.TyG;
          if (localObject2 != null) {
            ((d)localObject2).GDy = localObject1[0];
          }
          localObject1 = paramTextStatusEditActivity.TyG;
          if (localObject1 != null) {
            ((d)localObject1).bmv = com.tencent.mm.cd.a.fromDPToPix((Context)paramTextStatusEditActivity, 12);
          }
          paramTextStatusEditActivity = paramTextStatusEditActivity.TyG;
          if (paramTextStatusEditActivity == null) {
            break label514;
          }
          kotlin.g.b.s.u(localView, "anchor");
          if (!paramTextStatusEditActivity.GDx)
          {
            paramTextStatusEditActivity.getContentView().measure(0, 0);
            paramTextStatusEditActivity.GDx = true;
          }
          n = paramTextStatusEditActivity.getContentView().getMeasuredWidth();
          i1 = paramTextStatusEditActivity.getContentView().getMeasuredHeight();
          localObject1 = new int[2];
          localView.getLocationInWindow((int[])localObject1);
          k = localObject1[0] + (localView.getWidth() - n) / 2;
          j = localObject1[1] - i1;
          localObject2 = ao.mX(paramTextStatusEditActivity.context);
          i2 = ((ao.a)localObject2).width;
          i3 = ((ao.a)localObject2).height;
          i = i2 - paramTextStatusEditActivity.GDy - n;
          m = paramTextStatusEditActivity.GDy + 0;
          i4 = paramTextStatusEditActivity.GDy;
          if (k <= i) {
            break label274;
          }
          localObject2 = paramTextStatusEditActivity.GDu.getLayoutParams();
          if (localObject2 != null) {
            break;
          }
          paramTextStatusEditActivity = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(292035);
          throw paramTextStatusEditActivity;
        }
      }
      finally {}
      AppMethodBeat.o(292035);
      return;
      label274:
      i = k;
      if (k < m) {
        i = m;
      }
    }
    Object localObject2 = (RelativeLayout.LayoutParams)localObject2;
    Object localObject3 = paramTextStatusEditActivity.GDw.getLayoutParams();
    if (localObject3 == null)
    {
      paramTextStatusEditActivity = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(292035);
      throw paramTextStatusEditActivity;
    }
    localObject3 = (RelativeLayout.LayoutParams)localObject3;
    ((RelativeLayout.LayoutParams)localObject2).setMarginStart(localObject1[0] + localView.getWidth() / 2 - i - paramTextStatusEditActivity.GDu.getMeasuredWidth() / 2);
    if (j > i3 - i1 - i4)
    {
      if (paramTextStatusEditActivity.TvH == d.b.TvI) {
        break label599;
      }
      ((RelativeLayout.LayoutParams)localObject3).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, a.e.menu_content);
      paramTextStatusEditActivity.GDu.setRotation(paramTextStatusEditActivity.GDu.getRotation() + 180.0F);
      paramTextStatusEditActivity.TvH = d.b.TvI;
    }
    label514:
    label599:
    for (;;)
    {
      paramTextStatusEditActivity.setAnimationStyle(a.i.LWj);
      paramTextStatusEditActivity.showAtLocation(localView, 0, i, j);
      paramTextStatusEditActivity = am.aixg;
      kotlin.g.b.s.s(String.format("popX:%s, popY:%s, sw:%s, sh:%s, pw:%s, ph:%s", Arrays.copyOf(new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(n), Integer.valueOf(i1) }, 6)), "java.lang.String.format(format, *args)");
      ac.hFW();
      AppMethodBeat.o(292035);
      return;
      if (paramTextStatusEditActivity.TvH != d.b.TvJ)
      {
        ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject3).addRule(3, a.e.v_arrow);
        paramTextStatusEditActivity.GDu.setRotation(paramTextStatusEditActivity.GDu.getRotation() + 180.0F);
        paramTextStatusEditActivity.TvH = d.b.TvJ;
      }
      k = localView.getHeight();
      m = paramTextStatusEditActivity.bmv;
      j = k + i1 + m + j;
    }
  }
  
  private static final void b(TextStatusEditActivity paramTextStatusEditActivity, int paramInt, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(292049);
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    if (paramValueAnimator == null)
    {
      paramValueAnimator = null;
      if (!(paramValueAnimator instanceof Float)) {
        break label62;
      }
      paramValueAnimator = (Float)paramValueAnimator;
      label31:
      if (paramValueAnimator != null) {
        break label67;
      }
    }
    label62:
    label67:
    for (float f = 0.0F;; f = paramValueAnimator.floatValue())
    {
      paramTextStatusEditActivity.onKeyboardHeightChanged((int)(paramInt - f), false);
      AppMethodBeat.o(292049);
      return;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      break;
      paramValueAnimator = null;
      break label31;
    }
  }
  
  private static final void b(TextStatusEditActivity paramTextStatusEditActivity, View paramView)
  {
    AppMethodBeat.i(292012);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusEditActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    paramTextStatusEditActivity.Tx(null);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292012);
  }
  
  private static final void bR(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(292047);
    kotlin.g.b.s.u(parama, "$run");
    parama.invoke();
    AppMethodBeat.o(292047);
  }
  
  private final boolean bW(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(291944);
    if ((paramInt == 0) || (!paramBoolean))
    {
      hJt();
      AppMethodBeat.o(291944);
      return true;
    }
    AppMethodBeat.o(291944);
    return false;
  }
  
  private final String bZ(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(291997);
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
      paramLinkedList.put("mLabelRangeindex", this.RiP);
      paramLinkedList.put("mLabelNameList", this.RiR);
      paramLinkedList.put("mOtherUserNameList", this.RiS);
      paramLinkedList.put("mChatRoomNameList", this.RiT);
      localObject1 = paramLinkedList.toString();
      AppMethodBeat.o(291997);
      return localObject1;
    }
    finally
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
  }
  
  private final void bee(String paramString)
  {
    AppMethodBeat.i(291967);
    hIU().removeAllViews();
    com.tencent.mm.plugin.textstatus.a.e locale = hHr();
    boolean bool;
    if (locale == null)
    {
      bool = false;
      this.TyO = bool;
      paramString = (CharSequence)paramString;
      if ((paramString != null) && (!kotlin.n.n.bp(paramString))) {
        break label114;
      }
    }
    label114:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (this.TyO != true)) {
        break label119;
      }
      hIU().setVisibility(0);
      paramString = com.tencent.mm.plugin.textstatus.util.l.TBz;
      com.tencent.mm.plugin.textstatus.util.l.C((View)hIU(), com.tencent.mm.cd.a.fromDPToPix((Context)this, 12.0F));
      AppMethodBeat.o(291967);
      return;
      bool = locale.d(hIU());
      break;
    }
    label119:
    hIU().setVisibility(8);
    AppMethodBeat.o(291967);
  }
  
  /* Error */
  private static String bef(String paramString)
  {
    // Byte code:
    //   0: ldc_w 2331
    //   3: invokestatic 732	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 2336	com/tencent/mm/plugin/sns/model/al:getAccSnsTmpPath	()Ljava/lang/String;
    //   9: aload_0
    //   10: invokestatic 2339	com/tencent/mm/vfs/y:bub	(Ljava/lang/String;)Ljava/lang/String;
    //   13: invokestatic 1801	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   16: astore_1
    //   17: new 2341	com/tencent/mm/compatible/i/d
    //   20: dup
    //   21: invokespecial 2342	com/tencent/mm/compatible/i/d:<init>	()V
    //   24: checkcast 2344	android/media/MediaMetadataRetriever
    //   27: astore_2
    //   28: aload_2
    //   29: aload_0
    //   30: invokevirtual 2347	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   33: aload_2
    //   34: lconst_0
    //   35: invokevirtual 2351	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   38: astore_0
    //   39: aload_0
    //   40: ifnonnull +26 -> 66
    //   43: ldc_w 1251
    //   46: ldc_w 2353
    //   49: invokestatic 2355	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_2
    //   53: invokevirtual 2358	android/media/MediaMetadataRetriever:release	()V
    //   56: ldc_w 2331
    //   59: invokestatic 738	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: ldc_w 1088
    //   65: areturn
    //   66: ldc_w 1251
    //   69: ldc_w 2360
    //   72: iconst_2
    //   73: anewarray 1553	java/lang/Object
    //   76: dup
    //   77: iconst_0
    //   78: aload_0
    //   79: invokevirtual 1239	android/graphics/Bitmap:getWidth	()I
    //   82: invokestatic 1425	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: aload_0
    //   89: invokevirtual 1248	android/graphics/Bitmap:getHeight	()I
    //   92: invokestatic 1425	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   95: aastore
    //   96: invokestatic 2363	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   99: aload_0
    //   100: bipush 80
    //   102: getstatic 2369	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   105: aload_1
    //   106: iconst_1
    //   107: invokestatic 2375	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   110: pop
    //   111: aload_1
    //   112: invokestatic 2379	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   115: astore_0
    //   116: ldc_w 1251
    //   119: ldc_w 2381
    //   122: iconst_2
    //   123: anewarray 1553	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: aload_0
    //   129: getfield 2386	android/graphics/BitmapFactory$Options:outWidth	I
    //   132: invokestatic 1425	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: aastore
    //   136: dup
    //   137: iconst_1
    //   138: aload_0
    //   139: getfield 2389	android/graphics/BitmapFactory$Options:outHeight	I
    //   142: invokestatic 1425	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   145: aastore
    //   146: invokestatic 2363	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   149: aload_2
    //   150: invokevirtual 2358	android/media/MediaMetadataRetriever:release	()V
    //   153: ldc_w 2331
    //   156: invokestatic 738	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aload_1
    //   160: areturn
    //   161: astore_0
    //   162: ldc_w 1251
    //   165: ldc_w 2391
    //   168: iconst_1
    //   169: anewarray 1553	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: aload_0
    //   175: invokevirtual 2394	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   178: aastore
    //   179: invokestatic 2396	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: aload_2
    //   183: invokevirtual 2358	android/media/MediaMetadataRetriever:release	()V
    //   186: goto -33 -> 153
    //   189: astore_0
    //   190: goto -37 -> 153
    //   193: astore_0
    //   194: aload_2
    //   195: invokevirtual 2358	android/media/MediaMetadataRetriever:release	()V
    //   198: ldc_w 2331
    //   201: invokestatic 738	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   204: aload_0
    //   205: athrow
    //   206: astore_0
    //   207: goto -151 -> 56
    //   210: astore_0
    //   211: goto -58 -> 153
    //   214: astore_1
    //   215: goto -17 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	paramString	String
    //   16	144	1	str	String
    //   214	1	1	localException	Exception
    //   27	168	2	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   28	39	161	java/lang/Exception
    //   43	52	161	java/lang/Exception
    //   66	149	161	java/lang/Exception
    //   182	186	189	java/lang/Exception
    //   28	39	193	finally
    //   43	52	193	finally
    //   66	149	193	finally
    //   162	182	193	finally
    //   52	56	206	java/lang/Exception
    //   149	153	210	java/lang/Exception
    //   194	198	214	java/lang/Exception
  }
  
  private static final void c(TextStatusEditActivity paramTextStatusEditActivity)
  {
    AppMethodBeat.i(292042);
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    paramTextStatusEditActivity.hs(paramTextStatusEditActivity.hJK().TyX, paramTextStatusEditActivity.hJK().mediaType);
    AppMethodBeat.o(292042);
  }
  
  private static final void c(TextStatusEditActivity paramTextStatusEditActivity, View paramView)
  {
    AppMethodBeat.i(292014);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusEditActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    paramTextStatusEditActivity.onBackPressed();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292014);
  }
  
  private static final void d(TextStatusEditActivity paramTextStatusEditActivity)
  {
    AppMethodBeat.i(292043);
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    paramTextStatusEditActivity.hs(paramTextStatusEditActivity.hJK().TyX, paramTextStatusEditActivity.hJK().mediaType);
    AppMethodBeat.o(292043);
  }
  
  private static final void d(TextStatusEditActivity paramTextStatusEditActivity, View paramView)
  {
    AppMethodBeat.i(292015);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusEditActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    paramTextStatusEditActivity.hideVKB();
    paramTextStatusEditActivity.hJv();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292015);
  }
  
  private static final void e(TextStatusEditActivity paramTextStatusEditActivity)
  {
    AppMethodBeat.i(292060);
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    ProgressDialog localProgressDialog = paramTextStatusEditActivity.vEG;
    if (localProgressDialog != null) {
      localProgressDialog.dismiss();
    }
    paramTextStatusEditActivity.hJM();
    AppMethodBeat.o(292060);
  }
  
  private static final void e(TextStatusEditActivity paramTextStatusEditActivity, View paramView)
  {
    AppMethodBeat.i(292017);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusEditActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    paramTextStatusEditActivity.NYC.onClick(paramView);
    paramView = com.tencent.mm.plugin.secdata.ui.a.PlI;
    paramTextStatusEditActivity = paramTextStatusEditActivity.getContext();
    kotlin.g.b.s.s(paramTextStatusEditActivity, "context");
    paramTextStatusEditActivity = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)paramTextStatusEditActivity, 8, bh.class);
    if (paramTextStatusEditActivity != null) {
      paramTextStatusEditActivity.TqL = (1L + paramTextStatusEditActivity.TqL);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292017);
  }
  
  private static final void f(TextStatusEditActivity paramTextStatusEditActivity)
  {
    AppMethodBeat.i(292061);
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    d locald = paramTextStatusEditActivity.hJK();
    Object localObject1;
    switch (paramTextStatusEditActivity.hJK().mediaType)
    {
    default: 
      localObject1 = "";
    }
    for (;;)
    {
      locald.TyY = ((String)localObject1);
      com.tencent.threadpool.h.ahAA.bk(new TextStatusEditActivity..ExternalSyntheticLambda36(paramTextStatusEditActivity));
      AppMethodBeat.o(292061);
      return;
      com.tencent.mm.plugin.textstatus.h.h.d locald1 = com.tencent.mm.plugin.textstatus.h.h.d.Tod;
      Object localObject2 = paramTextStatusEditActivity.hJK().TyX;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      kotlin.g.b.s.u(localObject1, "thumbnailPath");
      localObject2 = new com.tencent.mm.vfs.u((String)localObject1);
      localObject2 = new com.tencent.mm.vfs.u(((com.tencent.mm.vfs.u)localObject2).jKP(), kotlin.g.b.s.X("thumb", ((com.tencent.mm.vfs.u)localObject2).getName()));
      Log.i("MicroMsg.TextStatus.UploadPackHelper", "[getSendThumbnail]");
      localObject1 = locald1.a((String)localObject1, (com.tencent.mm.vfs.u)localObject2, 60);
      continue;
      localObject2 = paramTextStatusEditActivity.hJK().TyX;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject1 = bef((String)localObject1);
    }
  }
  
  private static final void f(TextStatusEditActivity paramTextStatusEditActivity, View paramView)
  {
    AppMethodBeat.i(292018);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusEditActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    paramView = paramTextStatusEditActivity.TyG;
    if (paramView != null) {
      paramView.dismiss();
    }
    paramView = paramTextStatusEditActivity.hIP();
    if (paramView != null)
    {
      paramView = paramView.getText();
      if (paramView != null)
      {
        localObject = paramTextStatusEditActivity.hIP();
        if (localObject != null) {
          break label168;
        }
      }
    }
    label168:
    for (int i = 0;; i = ((MMEditText)localObject).getSelectionStart())
    {
      paramView.insert(i, (CharSequence)paramTextStatusEditActivity.getContext().getString(am.g.tag_search_word));
      paramTextStatusEditActivity.hIP().requestFocus();
      paramView = paramTextStatusEditActivity.getContext().getSystemService("input_method");
      if (paramView != null) {
        break;
      }
      paramTextStatusEditActivity = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(292018);
      throw paramTextStatusEditActivity;
    }
    ((InputMethodManager)paramView).showSoftInput((View)paramTextStatusEditActivity.hIP(), 0);
    paramView = com.tencent.mm.plugin.secdata.ui.a.PlI;
    paramTextStatusEditActivity = paramTextStatusEditActivity.getContext();
    kotlin.g.b.s.s(paramTextStatusEditActivity, "context");
    paramTextStatusEditActivity = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)paramTextStatusEditActivity, 8, bh.class);
    if (paramTextStatusEditActivity != null) {
      paramTextStatusEditActivity.TqI = (1L + paramTextStatusEditActivity.TqI);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292018);
  }
  
  private final void g(com.tencent.mm.plugin.textstatus.h.f.b paramb)
  {
    AppMethodBeat.i(291943);
    d locald = hJK();
    AppCompatActivity localAppCompatActivity = getContext();
    kotlin.g.b.s.s(localAppCompatActivity, "context");
    locald.a(paramb, (Context)localAppCompatActivity);
    if (!TextUtils.isEmpty((CharSequence)hJK().TyX)) {}
    for (boolean bool = true; bW(hJK().mediaType, bool); bool = false)
    {
      AppMethodBeat.o(291943);
      return;
    }
    paramb = this.TxS;
    if (paramb != null) {
      paramb.post(new TextStatusEditActivity..ExternalSyntheticLambda31(this));
    }
    AppMethodBeat.o(291943);
  }
  
  private static final void g(TextStatusEditActivity paramTextStatusEditActivity)
  {
    AppMethodBeat.i(292063);
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    aw.a((Paint)paramTextStatusEditActivity.hIP().getPaint(), 0.8F);
    paramTextStatusEditActivity.hIP().setHint(a.h.Tge);
    AppMethodBeat.o(292063);
  }
  
  private static final void g(TextStatusEditActivity paramTextStatusEditActivity, View paramView)
  {
    AppMethodBeat.i(292020);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusEditActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    paramView = com.tencent.mm.plugin.secdata.ui.a.PlI;
    paramView = paramTextStatusEditActivity.getContext();
    kotlin.g.b.s.s(paramView, "context");
    paramView = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)paramView, 8, bh.class);
    if (paramView != null) {
      paramView.TqH += 1L;
    }
    if (paramTextStatusEditActivity.niy == 1)
    {
      com.tencent.mm.ui.base.aa.y((Context)paramTextStatusEditActivity, paramTextStatusEditActivity.getString(a.h.settings_modify_text_status_invalid_modify_status_word), a.g.icons_outlined_info);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(292020);
      return;
    }
    paramView = TextStatusDoWhatActivity.Txk;
    TextStatusDoWhatActivity.a.a((Activity)paramTextStatusEditActivity, paramTextStatusEditActivity.Tyy, paramTextStatusEditActivity.hJm().topicInfo.title);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292020);
  }
  
  private final void grz()
  {
    AppMethodBeat.i(292001);
    hIP().setEnableSendBtn(true);
    hIP().setImeOptions(6);
    if (!hJO())
    {
      Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "initEditText allow input text");
      hIP().getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this.TyC);
      hIP().post(new TextStatusEditActivity..ExternalSyntheticLambda30(this));
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1629L, 0L, 1L, false);
      hJr();
    }
    AppMethodBeat.o(292001);
  }
  
  private static final void h(TextStatusEditActivity paramTextStatusEditActivity, View paramView)
  {
    AppMethodBeat.i(292024);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusEditActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    paramView = TextStatusDoWhatActivity.Txk;
    TextStatusDoWhatActivity.a.a((Activity)paramTextStatusEditActivity, paramTextStatusEditActivity.Tyy, paramTextStatusEditActivity.hJm().topicInfo.title);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292024);
  }
  
  private TextView hHh()
  {
    AppMethodBeat.i(291888);
    TextView localTextView = (TextView)this.TxN.getValue();
    AppMethodBeat.o(291888);
    return localTextView;
  }
  
  /* Error */
  private com.tencent.mm.plugin.textstatus.a.e hHr()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aconst_null
    //   3: astore 4
    //   5: ldc_w 2631
    //   8: invokestatic 732	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: invokespecial 1131	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJm	()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;
    //   15: getfield 2569	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:topicInfo	Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;
    //   18: astore 5
    //   20: aload_0
    //   21: getfield 2633	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Tmh	Lcom/tencent/mm/plugin/textstatus/a/e;
    //   24: ifnonnull +226 -> 250
    //   27: iconst_0
    //   28: istore_1
    //   29: iload_1
    //   30: ifne +207 -> 237
    //   33: aload_0
    //   34: getfield 2633	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Tmh	Lcom/tencent/mm/plugin/textstatus/a/e;
    //   37: astore_3
    //   38: aload_3
    //   39: ifnull +7 -> 46
    //   42: aload_3
    //   43: invokevirtual 2636	com/tencent/mm/plugin/textstatus/a/e:onDetach	()V
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 2633	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Tmh	Lcom/tencent/mm/plugin/textstatus/a/e;
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 2638	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Tmi	Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;
    //   56: getstatic 1145	com/tencent/mm/plugin/textstatus/third/i:TuX	Lcom/tencent/mm/plugin/textstatus/third/i;
    //   59: astore_3
    //   60: invokestatic 2641	com/tencent/mm/plugin/textstatus/third/i:hIb	()Lcom/tencent/mm/plugin/textstatus/a/e;
    //   63: astore_3
    //   64: aload_0
    //   65: aload_3
    //   66: putfield 2633	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Tmh	Lcom/tencent/mm/plugin/textstatus/a/e;
    //   69: aload_0
    //   70: getfield 2633	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Tmh	Lcom/tencent/mm/plugin/textstatus/a/e;
    //   73: astore 6
    //   75: aload 6
    //   77: ifnull +35 -> 112
    //   80: aload 5
    //   82: ifnonnull +223 -> 305
    //   85: aconst_null
    //   86: astore_3
    //   87: aload_3
    //   88: checkcast 2643	java/util/List
    //   91: astore 7
    //   93: aload 5
    //   95: ifnonnull +219 -> 314
    //   98: aconst_null
    //   99: astore_3
    //   100: aload 6
    //   102: aconst_null
    //   103: aload 7
    //   105: aload_3
    //   106: checkcast 2643	java/util/List
    //   109: invokevirtual 2646	com/tencent/mm/plugin/textstatus/a/e:d	(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V
    //   112: new 2102	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo
    //   115: dup
    //   116: invokespecial 2647	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:<init>	()V
    //   119: astore 6
    //   121: aload 5
    //   123: ifnonnull +200 -> 323
    //   126: aload 4
    //   128: astore_3
    //   129: aload 6
    //   131: aload_3
    //   132: putfield 2103	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceId	Ljava/lang/String;
    //   135: new 1111	java/util/LinkedList
    //   138: dup
    //   139: invokespecial 1112	java/util/LinkedList:<init>	()V
    //   142: astore_3
    //   143: aload 5
    //   145: ifnull +25 -> 170
    //   148: aload 5
    //   150: getfield 2138	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:jumpInfos	Ljava/util/LinkedList;
    //   153: astore 4
    //   155: aload 4
    //   157: ifnull +13 -> 170
    //   160: aload_3
    //   161: aload 4
    //   163: checkcast 2143	java/util/Collection
    //   166: invokevirtual 2147	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   169: pop
    //   170: getstatic 2653	kotlin/ah:aiuX	Lkotlin/ah;
    //   173: astore 4
    //   175: aload 6
    //   177: aload_3
    //   178: putfield 2138	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:jumpInfos	Ljava/util/LinkedList;
    //   181: new 1111	java/util/LinkedList
    //   184: dup
    //   185: invokespecial 1112	java/util/LinkedList:<init>	()V
    //   188: astore_3
    //   189: aload 5
    //   191: ifnull +25 -> 216
    //   194: aload 5
    //   196: getfield 2133	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceJumpInfos	Ljava/util/LinkedList;
    //   199: astore 4
    //   201: aload 4
    //   203: ifnull +13 -> 216
    //   206: aload_3
    //   207: aload 4
    //   209: checkcast 2143	java/util/Collection
    //   212: invokevirtual 2147	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   215: pop
    //   216: getstatic 2653	kotlin/ah:aiuX	Lkotlin/ah;
    //   219: astore 4
    //   221: aload 6
    //   223: aload_3
    //   224: putfield 2133	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceJumpInfos	Ljava/util/LinkedList;
    //   227: getstatic 2653	kotlin/ah:aiuX	Lkotlin/ah;
    //   230: astore_3
    //   231: aload_0
    //   232: aload 6
    //   234: putfield 2638	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Tmi	Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;
    //   237: aload_0
    //   238: getfield 2633	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Tmh	Lcom/tencent/mm/plugin/textstatus/a/e;
    //   241: astore_3
    //   242: ldc_w 2631
    //   245: invokestatic 738	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: aload_3
    //   249: areturn
    //   250: aload_0
    //   251: getfield 2638	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Tmi	Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;
    //   254: astore_3
    //   255: aload_3
    //   256: ifnull +24 -> 280
    //   259: aload_3
    //   260: aload 5
    //   262: invokestatic 2658	com/tencent/mm/plugin/textstatus/ui/b:a	(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;)Z
    //   265: iconst_1
    //   266: if_icmpne +14 -> 280
    //   269: iconst_1
    //   270: istore_2
    //   271: iload_2
    //   272: ifne -243 -> 29
    //   275: iconst_0
    //   276: istore_1
    //   277: goto -248 -> 29
    //   280: iconst_0
    //   281: istore_2
    //   282: goto -11 -> 271
    //   285: astore_3
    //   286: ldc_w 1251
    //   289: aload_3
    //   290: ldc_w 2660
    //   293: iconst_0
    //   294: anewarray 1553	java/lang/Object
    //   297: invokestatic 2664	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: aconst_null
    //   301: astore_3
    //   302: goto -238 -> 64
    //   305: aload 5
    //   307: getfield 2133	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceJumpInfos	Ljava/util/LinkedList;
    //   310: astore_3
    //   311: goto -224 -> 87
    //   314: aload 5
    //   316: getfield 2138	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:jumpInfos	Ljava/util/LinkedList;
    //   319: astore_3
    //   320: goto -220 -> 100
    //   323: aload 5
    //   325: getfield 2103	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceId	Ljava/lang/String;
    //   328: astore_3
    //   329: goto -200 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	this	TextStatusEditActivity
    //   1	276	1	i	int
    //   270	12	2	j	int
    //   37	223	3	localObject1	Object
    //   285	5	3	localThrowable	Throwable
    //   301	28	3	localObject2	Object
    //   3	217	4	localObject3	Object
    //   18	306	5	localTextStatusTopicInfo	TextStatusTopicInfo
    //   73	160	6	localObject4	Object
    //   91	13	7	localList	List
    // Exception table:
    //   from	to	target	type
    //   56	64	285	finally
  }
  
  private View hII()
  {
    AppMethodBeat.i(291918);
    View localView = this.Tyk;
    if (localView != null)
    {
      AppMethodBeat.o(291918);
      return localView;
    }
    kotlin.g.b.s.bIx("btnBack");
    AppMethodBeat.o(291918);
    return null;
  }
  
  private final View hIL()
  {
    AppMethodBeat.i(291867);
    View localView = (View)this.TxB.getValue();
    AppMethodBeat.o(291867);
    return localView;
  }
  
  private final View hIM()
  {
    AppMethodBeat.i(291873);
    View localView = (View)this.TxC.getValue();
    AppMethodBeat.o(291873);
    return localView;
  }
  
  private View hIN()
  {
    AppMethodBeat.i(291877);
    View localView = (View)this.TxD.getValue();
    AppMethodBeat.o(291877);
    return localView;
  }
  
  private ImageView hIO()
  {
    AppMethodBeat.i(291883);
    ImageView localImageView = (ImageView)this.TxJ.getValue();
    AppMethodBeat.o(291883);
    return localImageView;
  }
  
  private final ImageView hIQ()
  {
    AppMethodBeat.i(291891);
    ImageView localImageView = (ImageView)this.TxP.getValue();
    AppMethodBeat.o(291891);
    return localImageView;
  }
  
  private final ImageView hIR()
  {
    AppMethodBeat.i(291895);
    ImageView localImageView = (ImageView)this.TxQ.getValue();
    AppMethodBeat.o(291895);
    return localImageView;
  }
  
  private final ImageView hIS()
  {
    AppMethodBeat.i(291898);
    ImageView localImageView = (ImageView)this.TxR.getValue();
    AppMethodBeat.o(291898);
    return localImageView;
  }
  
  private final FrameLayout hIT()
  {
    AppMethodBeat.i(291901);
    FrameLayout localFrameLayout = (FrameLayout)this.TxT.getValue();
    AppMethodBeat.o(291901);
    return localFrameLayout;
  }
  
  private final FrameLayout hIU()
  {
    AppMethodBeat.i(291903);
    FrameLayout localFrameLayout = (FrameLayout)this.TxU.getValue();
    AppMethodBeat.o(291903);
    return localFrameLayout;
  }
  
  private ImageView hIV()
  {
    AppMethodBeat.i(291907);
    ImageView localImageView = this.TlA;
    if (localImageView != null)
    {
      AppMethodBeat.o(291907);
      return localImageView;
    }
    kotlin.g.b.s.bIx("vBack");
    AppMethodBeat.o(291907);
    return null;
  }
  
  private View hIW()
  {
    AppMethodBeat.i(291910);
    View localView = (View)this.TxW.getValue();
    AppMethodBeat.o(291910);
    return localView;
  }
  
  private EmojiStatusView hIX()
  {
    AppMethodBeat.i(291912);
    EmojiStatusView localEmojiStatusView = (EmojiStatusView)this.TxX.getValue();
    AppMethodBeat.o(291912);
    return localEmojiStatusView;
  }
  
  private View hIY()
  {
    AppMethodBeat.i(291914);
    View localView = (View)this.TxY.getValue();
    AppMethodBeat.o(291914);
    return localView;
  }
  
  private View hIZ()
  {
    AppMethodBeat.i(291915);
    View localView = (View)this.Tya.getValue();
    AppMethodBeat.o(291915);
    return localView;
  }
  
  private final void hIi()
  {
    AppMethodBeat.i(291952);
    Object localObject = this.Goz;
    if (localObject != null)
    {
      localObject = ((MMTPEffectVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).stopAsync();
      }
    }
    localObject = this.Goz;
    if (localObject != null)
    {
      localObject = ((MMTPEffectVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).recycle();
      }
    }
    localObject = this.Goz;
    if (localObject != null) {
      ((MMTPEffectVideoLayout)localObject).TGP.HkF.release();
    }
    this.Goz = null;
    localObject = this.Tvm;
    if (localObject != null) {
      ((FrameLayout)localObject).removeAllViews();
    }
    AppMethodBeat.o(291952);
  }
  
  private final void hIj()
  {
    AppMethodBeat.i(291978);
    Object localObject2 = new StringBuilder("destroyThirdBackManual() called thirdBack:").append(this.Tvz).append('@');
    Object localObject1 = this.Tvz;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = Integer.valueOf(((com.tencent.mm.ui.widget.b)localObject1).hashCode()))
    {
      Log.i("MicroMsg.TextStatus.TextStatusEditActivity", localObject1 + " stack:" + Util.getStack());
      localObject1 = getContext();
      if ((localObject1 instanceof MMFragmentActivity))
      {
        localObject2 = this.Tvz;
        if (localObject2 != null) {
          b.a.b((com.tencent.mm.ui.component.glocom.b)localObject2, (MMFragmentActivity)localObject1);
        }
      }
      localObject1 = this.Tvz;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.b)localObject1).onDestroy();
      }
      this.Tvz = null;
      this.TyP = null;
      AppMethodBeat.o(291978);
      return;
    }
  }
  
  private final void hJA()
  {
    AppMethodBeat.i(291965);
    String str = hJm().poiName;
    if (!Util.isNullOrNil(str))
    {
      hHh().setText((CharSequence)str);
      aow(0);
      AppMethodBeat.o(291965);
      return;
    }
    aow(8);
    AppMethodBeat.o(291965);
  }
  
  private final void hJB()
  {
    AppMethodBeat.i(291970);
    hJa().setEnabled(hJq());
    hJC();
    AppMethodBeat.o(291970);
  }
  
  private final void hJC()
  {
    AppMethodBeat.i(291971);
    if (hJa().isEnabled())
    {
      hJb().setVisibility(8);
      AppMethodBeat.o(291971);
      return;
    }
    hJb().setVisibility(0);
    AppMethodBeat.o(291971);
  }
  
  private final void hJD()
  {
    AppMethodBeat.i(291972);
    Object localObject1 = hJm().topicInfo.sourceId;
    bee((String)localObject1);
    Object localObject2 = (CharSequence)localObject1;
    int i;
    if ((localObject2 == null) || (kotlin.n.n.bp((CharSequence)localObject2)))
    {
      i = 1;
      if (i != 0) {
        break label446;
      }
      hJg().setVisibility(0);
      hJh().setText((CharSequence)hJm().topicInfo.sourceName);
      hJi().setVisibility(8);
      localObject2 = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject2 = getContext();
      kotlin.g.b.s.s(localObject2, "context");
      localObject2 = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)localObject2, 8, bh.class);
      if (localObject2 != null)
      {
        ((bh)localObject2).TqA = ((String)localObject1);
        ((bh)localObject2).TqB = hJm().topicInfo.sourceActivityId;
        ((bh)localObject2).sourceName = hJm().topicInfo.sourceName;
        ((bh)localObject2).sourceIcon = hJm().topicInfo.sourceIcon;
        localObject1 = (CharSequence)hJm().mediaThumbUrl;
        if ((localObject1 != null) && (!kotlin.n.n.bp((CharSequence)localObject1))) {
          break label327;
        }
        i = 1;
        label188:
        if (i != 0)
        {
          localObject1 = (CharSequence)hJm().mediaUrl;
          if ((localObject1 != null) && (!kotlin.n.n.bp((CharSequence)localObject1))) {
            break label332;
          }
          i = 1;
          label216:
          if (i != 0)
          {
            localObject1 = this.Txn;
            if (localObject1 != null) {
              break label337;
            }
            localObject1 = null;
            label231:
            localObject1 = (CharSequence)localObject1;
            if ((localObject1 != null) && (!kotlin.n.n.bp((CharSequence)localObject1))) {
              break label345;
            }
            i = 1;
            label249:
            if (i != 0) {
              break label260;
            }
          }
        }
        ((bh)localObject2).Tqy = 4L;
      }
      label260:
      localObject1 = hHr();
      hJi().removeAllViews();
      if ((localObject1 == null) || (((com.tencent.mm.plugin.textstatus.a.e)localObject1).e(hJi()) != true)) {
        break label350;
      }
      i = 1;
      label290:
      if (i == 0) {
        break label355;
      }
      hJi().setVisibility(0);
      hJj().setVisibility(8);
    }
    for (;;)
    {
      hJE();
      AppMethodBeat.o(291972);
      return;
      i = 0;
      break;
      label327:
      i = 0;
      break label188;
      label332:
      i = 0;
      break label216;
      label337:
      localObject1 = ((w)localObject1).mediaPath;
      break label231;
      label345:
      i = 0;
      break label249;
      label350:
      i = 0;
      break label290;
      label355:
      hJi().setVisibility(8);
      localObject1 = hJm().topicInfo.sourceIcon;
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (kotlin.n.n.bp((CharSequence)localObject2))) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label434;
        }
        localObject2 = hJj();
        ((ImageView)localObject2).setVisibility(0);
        r.bKe().loadImage((String)localObject1, (ImageView)localObject2);
        localObject1 = com.tencent.mm.plugin.textstatus.util.l.TBz;
        com.tencent.mm.plugin.textstatus.util.l.km((View)localObject2);
        break;
      }
      label434:
      hJj().setVisibility(8);
      continue;
      label446:
      hJg().setVisibility(8);
    }
  }
  
  private final void hJE()
  {
    AppMethodBeat.i(291975);
    Object localObject = hJm().topicInfo.sourceId;
    TextStatusEditActivity.e locale = new TextStatusEditActivity.e((String)localObject, (List)hJm().topicInfo.jumpInfos);
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (kotlin.n.n.bp(localCharSequence))) {}
    for (int i = 1; i == 0; i = 0)
    {
      if (!a(locale))
      {
        hIj();
        hIT().removeAllViews();
        this.Tvz = N((String)localObject, locale.DHi);
        this.TyP = locale;
      }
      hIT().setVisibility(0);
      localObject = com.tencent.mm.plugin.textstatus.util.l.TBz;
      com.tencent.mm.plugin.textstatus.util.l.C((View)hIT(), com.tencent.mm.cd.a.fromDPToPix((Context)this, 12.0F));
      hJF();
      AppMethodBeat.o(291975);
      return;
    }
    hIj();
    hIT().removeAllViews();
    hIT().setVisibility(8);
    AppMethodBeat.o(291975);
  }
  
  private final void hJF()
  {
    AppMethodBeat.i(291977);
    com.tencent.mm.ui.widget.b localb = this.Tvz;
    if ((localb != null) && (!localb.hU))
    {
      localb.etL();
      localb.etO();
    }
    AppMethodBeat.o(291977);
  }
  
  private final void hJG()
  {
    AppMethodBeat.i(291984);
    String str = hJm().topicInfo.iconId;
    Object localObject = (CharSequence)str;
    int i;
    if ((localObject == null) || (kotlin.n.n.bp((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0)
      {
        localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
        localObject = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)this, 8, bh.class);
        if (localObject != null)
        {
          if (!((bh)localObject).Tqs.contains(str)) {
            ((bh)localObject).Tqs.add(str);
          }
          if ((hJH()) || (this.niy == 2)) {
            if (((bh)localObject).Tqs.size() <= 1) {
              break label159;
            }
          }
        }
      }
    }
    label159:
    for (long l = 1L;; l = 0L)
    {
      ((bh)localObject).TqD = l;
      com.tencent.mm.plugin.textstatus.util.a.a(com.tencent.mm.plugin.textstatus.util.b.hKh(), this.TlN, str, null, null, null, 28);
      AppMethodBeat.o(291984);
      return;
      i = 0;
      break;
    }
  }
  
  private boolean hJH()
  {
    w localw = this.Txn;
    return (localw != null) && (localw.Toi == 5L);
  }
  
  private final void hJI()
  {
    AppMethodBeat.i(291989);
    if (!this.TyR)
    {
      hJN();
      Object localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject = getContext();
      kotlin.g.b.s.s(localObject, "context");
      localObject = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)localObject, 8, bh.class);
      if (localObject != null)
      {
        ((bh)localObject).Ton = hJL();
        com.tencent.mm.plugin.textstatus.i.b localb = com.tencent.mm.plugin.textstatus.i.b.Trt;
        com.tencent.mm.plugin.textstatus.i.b.a(this.TyB, (bh)localObject);
      }
      this.TyR = true;
    }
    AppMethodBeat.o(291989);
  }
  
  private final String hJJ()
  {
    AppMethodBeat.i(291990);
    Object localObject = this.Tlw;
    if (localObject == null)
    {
      AppMethodBeat.o(291990);
      return null;
    }
    localObject = ((TextView)localObject).getText();
    if (localObject == null)
    {
      AppMethodBeat.o(291990);
      return null;
    }
    localObject = localObject.toString();
    AppMethodBeat.o(291990);
    return localObject;
  }
  
  private final String hJL()
  {
    AppMethodBeat.i(291992);
    if (kotlin.g.b.s.p(hJm().topicInfo.iconId, "userdefine"))
    {
      String str = hJJ();
      AppMethodBeat.o(291992);
      return str;
    }
    AppMethodBeat.o(291992);
    return null;
  }
  
  private void hJM()
  {
    Object localObject3 = null;
    AppMethodBeat.i(291996);
    hideVKB();
    Object localObject6 = hIP().getText();
    if (this.RiP == 3) {}
    label427:
    label449:
    label581:
    label1353:
    for (Object localObject2 = this.TyM;; localObject2 = null)
    {
      Object localObject1 = com.tencent.mm.plugin.textstatus.h.h.d.Tod;
      Object localObject5 = new bg();
      localObject1 = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject1 = getContext();
      kotlin.g.b.s.s(localObject1, "context");
      localObject1 = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)localObject1, 8, bh.class);
      if (localObject1 != null)
      {
        ((bg)localObject5).Tqq = ((bh)localObject1).Tqq;
        localObject1 = ah.aiuX;
        localObject1 = ah.aiuX;
      }
      int i = hJK().mediaType;
      Object localObject4 = hJK().TyX;
      localObject1 = localObject4;
      if (localObject4 == null) {
        localObject1 = "";
      }
      ((bg)localObject5).Tql = ((String)localObject1);
      ((bg)localObject5).thumbPath = hJK().TyY;
      ((bg)localObject5).Tqk = hJK().Tqk;
      TextStatusExtInfo localTextStatusExtInfo = hJm();
      localTextStatusExtInfo.mediaType = i;
      localObject1 = localTextStatusExtInfo.topicInfo;
      localObject4 = ((TextStatusTopicInfo)localObject1).topics;
      if (localObject4 != null)
      {
        ((LinkedList)localObject4).clear();
        localObject4 = ah.aiuX;
      }
      localObject4 = com.tencent.mm.plugin.textstatus.util.k.TBx;
      localObject4 = com.tencent.mm.plugin.textstatus.util.k.hKz().matcher((CharSequence)localObject6.toString());
      while (((Matcher)localObject4).find()) {
        ((TextStatusTopicInfo)localObject1).topics.add(((Matcher)localObject4).group(1));
      }
      ((TextStatusTopicInfo)localObject1).title = hJL();
      localObject1 = ah.aiuX;
      localTextStatusExtInfo.visibility = 0;
      localTextStatusExtInfo.description = localObject6.toString();
      if (localTextStatusExtInfo.createTime == 0) {
        localTextStatusExtInfo.createTime = com.tencent.mm.model.cn.getSyncServerTimeSecond();
      }
      localTextStatusExtInfo.expireTime = (localTextStatusExtInfo.createTime + 86400);
      if (((bg)localObject5).Tqk)
      {
        localObject1 = com.tencent.mm.plugin.textstatus.util.k.TBx;
        localTextStatusExtInfo.backgroundId = com.tencent.mm.plugin.textstatus.util.k.aoC(this.Tyy);
        if (this.niy == 2)
        {
          localObject1 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
          localObject1 = this.Txn;
          if (localObject1 != null) {
            break label1201;
          }
          localObject1 = null;
          label350:
          localObject4 = com.tencent.mm.plugin.textstatus.b.f.bdN((String)localObject1);
          if (localObject4 != null) {
            break label1209;
          }
          localObject1 = null;
          label363:
          localTextStatusExtInfo.duplicateUsername = ((String)localObject1);
          if (localObject4 != null) {
            break label1218;
          }
          localObject1 = null;
          label376:
          localTextStatusExtInfo.duplicateTextStatusId = ((String)localObject1);
        }
        if ((this.TyF != c.TyV) || (hIX().getEmojiInfo() == null)) {
          break label1542;
        }
        localObject6 = new TextStatusEmojiInfo();
        localObject1 = hIX().getEmojiInfo();
        if (localObject1 != null) {
          break label1227;
        }
        localObject1 = "";
        ((TextStatusEmojiInfo)localObject6).Md5 = ((String)localObject1);
        localObject1 = hIX().getEmojiInfo();
        if (localObject1 != null) {
          break label1248;
        }
        localObject1 = "";
        ((TextStatusEmojiInfo)localObject6).Url = ((String)localObject1);
        localObject1 = hIX().getEmojiInfo();
        if (localObject1 != null) {
          break label1269;
        }
        localObject1 = "";
        label471:
        ((TextStatusEmojiInfo)localObject6).ThumbUrl = ((String)localObject1);
        localObject1 = hIX().getEmojiInfo();
        if (localObject1 != null) {
          break label1290;
        }
        localObject1 = "";
        label493:
        ((TextStatusEmojiInfo)localObject6).DesignerID = ((String)localObject1);
        localObject1 = hIX().getEmojiInfo();
        if (localObject1 != null) {
          break label1311;
        }
        localObject1 = "";
        ((TextStatusEmojiInfo)localObject6).EncryptUrl = ((String)localObject1);
        localObject1 = hIX().getEmojiInfo();
        if (localObject1 != null) {
          break label1332;
        }
        localObject1 = "";
        ((TextStatusEmojiInfo)localObject6).AesKey = ((String)localObject1);
        localObject1 = hIX().getEmojiInfo();
        if (localObject1 != null) {
          break label1353;
        }
        localObject1 = "";
        ((TextStatusEmojiInfo)localObject6).ProductID = ((String)localObject1);
        localObject1 = hIX().getEmojiInfo();
        if (localObject1 != null) {
          break label1374;
        }
        localObject1 = "";
        ((TextStatusEmojiInfo)localObject6).ExternUrl = ((String)localObject1);
        localObject1 = hIX().getEmojiInfo();
        if (localObject1 != null) {
          break label1395;
        }
        localObject1 = "";
        label603:
        ((TextStatusEmojiInfo)localObject6).ExternMd5 = ((String)localObject1);
        localObject1 = hIX().getEmojiInfo();
        if (localObject1 != null) {
          break label1416;
        }
        localObject1 = "";
        label625:
        ((TextStatusEmojiInfo)localObject6).ActivityID = ((String)localObject1);
        localObject1 = hIX().getEmojiInfo();
        if (localObject1 != null) {
          break label1437;
        }
        localObject1 = "";
        ((TextStatusEmojiInfo)localObject6).AttachedText = ((String)localObject1);
        localObject1 = hIX().getEmojiInfo();
        if (localObject1 != null) {
          break label1458;
        }
        localObject1 = "";
        ((TextStatusEmojiInfo)localObject6).AttachedTextColor = ((String)localObject1);
        localObject1 = hIX().getEmojiInfo();
        if (localObject1 != null) {
          break label1479;
        }
        localObject1 = "";
        ((TextStatusEmojiInfo)localObject6).ActivityID = ((String)localObject1);
        localObject1 = hIX().getEmojiInfo();
        if (localObject1 != null) {
          break label1500;
        }
        localObject1 = "";
        label713:
        ((TextStatusEmojiInfo)localObject6).LensId = ((String)localObject1);
        localObject1 = hIX().getEmojiInfo();
        if (localObject1 != null) {
          break label1521;
        }
        localObject1 = "";
        label735:
        ((TextStatusEmojiInfo)localObject6).EmojiAttr = ((String)localObject1);
        localObject1 = ah.aiuX;
        localTextStatusExtInfo.emojiInfo = ((TextStatusEmojiInfo)localObject6);
        label752:
        localObject1 = ah.aiuX;
        ((bg)localObject5).Tqi = localTextStatusExtInfo;
        ((bg)localObject5).Tqj = ((LinkedList)localObject2);
        if (this.niy == 1)
        {
          localObject1 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
          localObject1 = this.Txn;
          if (localObject1 != null) {
            break label1551;
          }
          localObject1 = null;
          localObject1 = com.tencent.mm.plugin.textstatus.b.f.bdN((String)localObject1);
          if (localObject1 != null) {
            break label1559;
          }
          localObject1 = null;
          ((bg)localObject5).ToK = ((String)localObject1);
        }
        localObject4 = ((bg)localObject5).ToK;
        localObject1 = localObject4;
        if (localObject4 == null) {
          localObject1 = "";
        }
        ((bg)localObject5).ToK = ((String)localObject1);
        ((bg)localObject5).Tqr = bZ((LinkedList)localObject2);
        localObject1 = ah.aiuX;
        com.tencent.mm.plugin.textstatus.h.h.d.c((bg)localObject5);
        if ((hJH()) || (this.niy == 2))
        {
          localObject1 = this.Txn;
          if ((localObject1 == null) || (((w)localObject1).Tor != true)) {
            break label1567;
          }
          i = 1;
          label887:
          if (i == 0) {
            com.tencent.mm.ui.base.aa.y((Context)this, getString(a.h.app_set_success), a.g.icons_outlined_done);
          }
        }
        localObject4 = new Intent();
        localObject5 = new com.tencent.mm.plugin.textstatus.proto.m();
        ((com.tencent.mm.plugin.textstatus.proto.m)localObject5).ToR = hJm().topicInfo.iconId;
        localObject1 = this.Tlw;
        if (localObject1 != null) {
          break label1572;
        }
        localObject1 = "";
        ((com.tencent.mm.plugin.textstatus.proto.m)localObject5).Okz = ((String)localObject1);
        localObject1 = hHr();
        if (localObject1 != null) {
          break label1606;
        }
        localObject1 = null;
        label971:
        if (localObject1 != null) {
          break label1614;
        }
      }
      label1227:
      label1614:
      for (localObject2 = localObject3;; localObject2 = ((com.tencent.mm.plugin.textstatus.a.k)localObject1).hFu())
      {
        ((com.tencent.mm.plugin.textstatus.proto.m)localObject5).ToS = ((String)localObject2);
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.textstatus.a.k)localObject1).a((com.tencent.mm.plugin.textstatus.proto.m)localObject5);
          localObject1 = ah.aiuX;
        }
        ((Intent)localObject4).putExtra("select_status_info", ((com.tencent.mm.plugin.textstatus.proto.m)localObject5).toByteArray());
        localObject1 = ah.aiuX;
        setResult(-1, (Intent)localObject4);
        localObject1 = hJl();
        if (localObject1 != null)
        {
          ((ResultReceiver)localObject1).send(-1, ((Intent)localObject4).getExtras());
          localObject1 = ah.aiuX;
        }
        this.TyB = true;
        finish();
        AppMethodBeat.o(291996);
        return;
        if ((localTextStatusExtInfo.mediaWidth != 0) || (localTextStatusExtInfo.mediaHeight != 0)) {
          break;
        }
        if (i == 1)
        {
          localObject1 = BitmapUtil.getImageOptions(((bg)localObject5).Tql);
          if (localObject1 != null)
          {
            localTextStatusExtInfo.mediaWidth = ((BitmapFactory.Options)localObject1).outWidth;
            localTextStatusExtInfo.mediaHeight = ((BitmapFactory.Options)localObject1).outHeight;
            localObject1 = ah.aiuX;
            localObject1 = ah.aiuX;
          }
          localTextStatusExtInfo.backgroundId = null;
          break;
        }
        if (i != 2) {
          break;
        }
        localObject1 = MultiMediaVideoChecker.ObB;
        localObject4 = ((bg)localObject5).Tql;
        kotlin.g.b.s.s(localObject4, "uploadFilePath");
        localObject1 = ((MultiMediaVideoChecker)localObject1).aTG((String)localObject4);
        if (localObject1 != null)
        {
          localTextStatusExtInfo.mediaWidth = ((MultiMediaVideoChecker.a)localObject1).width;
          localTextStatusExtInfo.mediaHeight = ((MultiMediaVideoChecker.a)localObject1).height;
          localObject1 = ah.aiuX;
          localObject1 = ah.aiuX;
        }
        localTextStatusExtInfo.backgroundId = null;
        break;
        localObject1 = ((w)localObject1).Top;
        break label350;
        localObject1 = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject4).field_UserName;
        break label363;
        localObject1 = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject4).field_StatusID;
        break label376;
        localObject4 = ((EmojiInfo)localObject1).getMd5();
        localObject1 = localObject4;
        if (localObject4 != null) {
          break label427;
        }
        localObject1 = "";
        break label427;
        label1248:
        localObject4 = ((EmojiInfo)localObject1).field_cdnUrl;
        localObject1 = localObject4;
        if (localObject4 != null) {
          break label449;
        }
        localObject1 = "";
        break label449;
        label1269:
        localObject4 = ((EmojiInfo)localObject1).field_thumbUrl;
        localObject1 = localObject4;
        if (localObject4 != null) {
          break label471;
        }
        localObject1 = "";
        break label471;
        localObject4 = ((EmojiInfo)localObject1).field_designerID;
        localObject1 = localObject4;
        if (localObject4 != null) {
          break label493;
        }
        localObject1 = "";
        break label493;
        localObject4 = ((EmojiInfo)localObject1).field_encrypturl;
        localObject1 = localObject4;
        if (localObject4 != null) {
          break label515;
        }
        localObject1 = "";
        break label515;
        localObject4 = ((EmojiInfo)localObject1).field_aeskey;
        localObject1 = localObject4;
        if (localObject4 != null) {
          break label537;
        }
        localObject1 = "";
        break label537;
        localObject4 = ((EmojiInfo)localObject1).field_groupId;
        localObject1 = localObject4;
        if (localObject4 != null) {
          break label559;
        }
        localObject1 = "";
        break label559;
        label1374:
        localObject4 = ((EmojiInfo)localObject1).field_externUrl;
        localObject1 = localObject4;
        if (localObject4 != null) {
          break label581;
        }
        localObject1 = "";
        break label581;
        label1395:
        localObject4 = ((EmojiInfo)localObject1).field_externMd5;
        localObject1 = localObject4;
        if (localObject4 != null) {
          break label603;
        }
        localObject1 = "";
        break label603;
        localObject4 = ((EmojiInfo)localObject1).field_activityid;
        localObject1 = localObject4;
        if (localObject4 != null) {
          break label625;
        }
        localObject1 = "";
        break label625;
        localObject4 = ((EmojiInfo)localObject1).field_attachedText;
        localObject1 = localObject4;
        if (localObject4 != null) {
          break label647;
        }
        localObject1 = "";
        break label647;
        localObject4 = ((EmojiInfo)localObject1).field_attachTextColor;
        localObject1 = localObject4;
        if (localObject4 != null) {
          break label669;
        }
        localObject1 = "";
        break label669;
        localObject4 = ((EmojiInfo)localObject1).field_activityid;
        localObject1 = localObject4;
        if (localObject4 != null) {
          break label691;
        }
        localObject1 = "";
        break label691;
        label1500:
        localObject4 = ((EmojiInfo)localObject1).field_lensId;
        localObject1 = localObject4;
        if (localObject4 != null) {
          break label713;
        }
        localObject1 = "";
        break label713;
        label1521:
        localObject4 = ((EmojiInfo)localObject1).field_attr;
        localObject1 = localObject4;
        if (localObject4 != null) {
          break label735;
        }
        localObject1 = "";
        break label735;
        localTextStatusExtInfo.emojiInfo = null;
        break label752;
        localObject1 = ((w)localObject1).Top;
        break label792;
        localObject1 = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject1).field_StatusID;
        break label803;
        i = 0;
        break label887;
        localObject1 = ((TextView)localObject1).getText();
        if (localObject1 == null)
        {
          localObject1 = "";
          break label954;
        }
        localObject2 = localObject1.toString();
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label954;
        }
        localObject1 = "";
        break label954;
        localObject1 = ((com.tencent.mm.plugin.textstatus.a.e)localObject1).hFs();
        break label971;
      }
    }
  }
  
  private final void hJN()
  {
    long l2 = 0L;
    AppMethodBeat.i(291999);
    String str = hIP().getText().toString();
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
    localObject = getContext();
    kotlin.g.b.s.s(localObject, "context");
    localObject = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)localObject, 8, bh.class);
    if (localObject != null)
    {
      ((bh)localObject).Tqz = com.tencent.mm.ui.tools.g.a(str, com.tencent.mm.ui.tools.g.a.afII);
      if (!Util.isNullOrNil(hJm().poiName)) {
        break label143;
      }
      l1 = 0L;
      ((bh)localObject).TqM = l1;
      if (!com.tencent.mm.plugin.textstatus.d.a.b(hJm())) {
        break label148;
      }
      l1 = 1L;
      label109:
      ((bh)localObject).TqR = l1;
      if (!Util.isEqual(((bh)localObject).TqW, str)) {
        break label153;
      }
    }
    label143:
    label148:
    label153:
    for (long l1 = l2;; l1 = 1L)
    {
      ((bh)localObject).TqC = l1;
      AppMethodBeat.o(291999);
      return;
      l1 = 1L;
      break;
      l1 = 0L;
      break label109;
    }
  }
  
  private final boolean hJO()
  {
    AppMethodBeat.i(292002);
    if (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adgO, 1) == 1) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adgX, false);
      if ((i == 0) || (bool)) {
        break;
      }
      findViewById(a.e.Tcj).setVisibility(0);
      findViewById(a.e.Tcj).setBackground((Drawable)new BitmapDrawable(getResources(), BitmapUtil.getBitmapNative(this.Tyy)));
      Object localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)this, 8, bh.class);
      if (localObject != null) {
        ((bh)localObject).Toj = 1;
      }
      ac.hFX();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adgO, Integer.valueOf(0));
      findViewById(a.e.Tci).setOnClickListener(new TextStatusEditActivity..ExternalSyntheticLambda13(this));
      Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "show education");
      AppMethodBeat.o(292002);
      return true;
    }
    AppMethodBeat.o(292002);
    return false;
  }
  
  private final View hJb()
  {
    AppMethodBeat.i(291917);
    View localView = (View)this.Tyj.getValue();
    AppMethodBeat.o(291917);
    return localView;
  }
  
  private View hJc()
  {
    AppMethodBeat.i(291919);
    View localView = this.Tyl;
    if (localView != null)
    {
      AppMethodBeat.o(291919);
      return localView;
    }
    kotlin.g.b.s.bIx("layoutBlurOption");
    AppMethodBeat.o(291919);
    return null;
  }
  
  private ImageView hJd()
  {
    AppMethodBeat.i(291921);
    ImageView localImageView = this.Tym;
    if (localImageView != null)
    {
      AppMethodBeat.o(291921);
      return localImageView;
    }
    kotlin.g.b.s.bIx("ivBlur");
    AppMethodBeat.o(291921);
    return null;
  }
  
  private final ImageView hJe()
  {
    AppMethodBeat.i(291922);
    ImageView localImageView = (ImageView)this.Tyn.getValue();
    AppMethodBeat.o(291922);
    return localImageView;
  }
  
  private final TextView hJf()
  {
    AppMethodBeat.i(291924);
    TextView localTextView = (TextView)this.Tyo.getValue();
    AppMethodBeat.o(291924);
    return localTextView;
  }
  
  private final LinearLayout hJg()
  {
    AppMethodBeat.i(291925);
    LinearLayout localLinearLayout = (LinearLayout)this.Typ.getValue();
    AppMethodBeat.o(291925);
    return localLinearLayout;
  }
  
  private final TextView hJh()
  {
    AppMethodBeat.i(291927);
    TextView localTextView = (TextView)this.Tyr.getValue();
    AppMethodBeat.o(291927);
    return localTextView;
  }
  
  private final FrameLayout hJi()
  {
    AppMethodBeat.i(291929);
    FrameLayout localFrameLayout = (FrameLayout)this.Tys.getValue();
    AppMethodBeat.o(291929);
    return localFrameLayout;
  }
  
  private final ImageView hJj()
  {
    AppMethodBeat.i(291931);
    ImageView localImageView = (ImageView)this.Tyt.getValue();
    AppMethodBeat.o(291931);
    return localImageView;
  }
  
  private final TextStatusEmojiView hJk()
  {
    AppMethodBeat.i(291932);
    TextStatusEmojiView localTextStatusEmojiView = (TextStatusEmojiView)this.Tyv.getValue();
    AppMethodBeat.o(291932);
    return localTextStatusEmojiView;
  }
  
  private final ResultReceiver hJl()
  {
    AppMethodBeat.i(291934);
    ResultReceiver localResultReceiver = (ResultReceiver)this.cEV.getValue();
    AppMethodBeat.o(291934);
    return localResultReceiver;
  }
  
  private TextStatusExtInfo hJm()
  {
    AppMethodBeat.i(291935);
    TextStatusExtInfo localTextStatusExtInfo = this.Tyx;
    if (localTextStatusExtInfo != null)
    {
      AppMethodBeat.o(291935);
      return localTextStatusExtInfo;
    }
    kotlin.g.b.s.bIx("curTextStatusExtInfo");
    AppMethodBeat.o(291935);
    return null;
  }
  
  private boolean hJn()
  {
    return this.TyA > 0;
  }
  
  private final void hJp()
  {
    AppMethodBeat.i(291938);
    Object localObject = (CharSequence)hJm().topicInfo.iconId;
    if ((localObject == null) || (kotlin.n.n.bp((CharSequence)localObject))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = com.tencent.mm.plugin.textstatus.util.b.hKh().f(hJm().topicInfo);
        TextView localTextView = this.Tlw;
        if (localTextView != null) {
          localTextView.setText((CharSequence)localObject);
        }
      }
      AppMethodBeat.o(291938);
      return;
    }
  }
  
  private final boolean hJq()
  {
    AppMethodBeat.i(291939);
    if ((ac.hGp()) && (kotlin.g.b.s.p(hJm().topicInfo.iconId, "userdefine")))
    {
      Object localObject = this.Tlw;
      if (localObject != null)
      {
        localObject = ((TextView)localObject).getText();
        if ((localObject != null) && (kotlin.n.n.bp((CharSequence)localObject) == true))
        {
          i = 1;
          if ((i == 0) || (hIY().getVisibility() == 0)) {
            break label147;
          }
          localObject = hIP().getText();
          kotlin.g.b.s.s(localObject, "etDesc.text");
          if (kotlin.n.n.bp((CharSequence)localObject)) {
            break label134;
          }
        }
      }
      label134:
      for (int i = 1;; i = 0)
      {
        if ((i == 0) && (!hJK().hJP()) && (this.Tvz == null)) {
          break label139;
        }
        AppMethodBeat.o(291939);
        return true;
        i = 0;
        break;
      }
      label139:
      AppMethodBeat.o(291939);
      return false;
    }
    label147:
    AppMethodBeat.o(291939);
    return true;
  }
  
  private final void hJr()
  {
    AppMethodBeat.i(291940);
    Object localObject = this.Txn;
    int i;
    if ((localObject != null) && (((w)localObject).Toi == 11L))
    {
      i = 1;
      if (i != 0) {
        break label88;
      }
      localObject = hJm().topicInfo;
      if (localObject != null) {
        break label70;
      }
      localObject = "";
    }
    for (;;)
    {
      if (kotlin.n.n.rs((String)localObject, "@weapp")) {
        break label88;
      }
      AppMethodBeat.o(291940);
      return;
      i = 0;
      break;
      label70:
      String str = ((TextStatusTopicInfo)localObject).sourceId;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
    label88:
    if (!ac.hFV())
    {
      AppMethodBeat.o(291940);
      return;
    }
    this.TyG = new d((Context)this);
    localObject = this.Tyh;
    if (localObject != null) {
      ((View)localObject).postDelayed(new TextStatusEditActivity..ExternalSyntheticLambda33(this), 800L);
    }
    AppMethodBeat.o(291940);
  }
  
  private final void hJs()
  {
    Object localObject1 = null;
    AppMethodBeat.i(291941);
    if (com.tencent.mm.plugin.textstatus.d.a.b(hJm()))
    {
      hJc().setAlpha(1.0F);
      hJd().setVisibility(8);
      hJe().setVisibility(0);
      hJf().setTextColor(getContext().getResources().getColor(a.b.White));
      Object localObject2 = this.TxV;
      if (localObject2 != null) {
        ((ImageView)localObject2).setVisibility(8);
      }
      localObject2 = this.Goz;
      if (localObject2 == null) {}
      for (;;)
      {
        if (localObject1 != null) {
          ((com.tencent.mm.xeffect.effect.b)localObject1).setRadius(5.0F);
        }
        if (localObject1 != null) {
          ((com.tencent.mm.xeffect.effect.b)localObject1).eC(1.0F);
        }
        if (TyT == null) {
          break;
        }
        hIQ().setImageBitmap(TyT);
        AppMethodBeat.o(291941);
        return;
        localObject2 = ((MMTPEffectVideoLayout)localObject2).getEffectManager();
        if (localObject2 != null) {
          localObject1 = ((EffectManager)localObject2).jQj();
        }
      }
    }
    hJc().setAlpha(0.85F);
    hJd().setVisibility(0);
    hJe().setVisibility(8);
    hJf().setTextColor(getContext().getResources().getColor(a.b.BW_100_Alpha_0_6));
    localObject1 = this.TxV;
    if (localObject1 != null) {
      ((ImageView)localObject1).setVisibility(0);
    }
    localObject1 = this.Goz;
    if (localObject1 != null)
    {
      localObject1 = ((MMTPEffectVideoLayout)localObject1).getEffectManager();
      if (localObject1 != null) {
        ((EffectManager)localObject1).b(com.tencent.mm.xeffect.effect.j.agYb);
      }
    }
    if (this.Tyz != null) {
      hIQ().setImageBitmap(this.Tyz);
    }
    AppMethodBeat.o(291941);
  }
  
  private final void hJt()
  {
    AppMethodBeat.i(291946);
    hIQ().setImageResource(this.Tyy);
    hIQ().setVisibility(0);
    hIS().setVisibility(0);
    FrameLayout localFrameLayout = this.Tvm;
    if (localFrameLayout != null) {
      localFrameLayout.setVisibility(8);
    }
    hJc().setVisibility(8);
    AppMethodBeat.o(291946);
  }
  
  private final void hJu()
  {
    AppMethodBeat.i(291948);
    this.Tyw = true;
    com.tencent.mm.plugin.textstatus.d.a.a(hJm(), false);
    hJK().reset();
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
    localObject = getContext();
    kotlin.g.b.s.s(localObject, "context");
    localObject = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)localObject, 8, bh.class);
    if (localObject != null)
    {
      if (hJH()) {
        ((bh)localObject).TqE = 1L;
      }
      if ((this.niy == 1) || (this.niy == 2)) {
        ((bh)localObject).TqE = 1L;
      }
    }
    com.tencent.mm.plugin.textstatus.d.a.c(hJm());
    hIi();
    hJt();
    localObject = hJm().topicInfo;
    kotlin.g.b.s.s(localObject, "curTextStatusExtInfo.topicInfo");
    kotlin.g.b.s.u(localObject, "<this>");
    b((TextStatusTopicInfo)localObject, null);
    hJD();
    hJB();
    hIR().setVisibility(8);
    AppMethodBeat.o(291948);
  }
  
  private final void hJv()
  {
    AppMethodBeat.i(291955);
    if (hJk().getVisibility() == 8)
    {
      AppMethodBeat.o(291955);
      return;
    }
    int j = ae.cp((Context)this);
    hJk().getLayoutParams().height = j;
    ObjectAnimator localObjectAnimator = aot(j);
    if ((localObjectAnimator != null) && (localObjectAnimator.isRunning() == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localObjectAnimator.cancel();
      }
      localObjectAnimator = aou(j);
      if (localObjectAnimator != null) {
        localObjectAnimator.start();
      }
      AppMethodBeat.o(291955);
      return;
    }
  }
  
  private void hJw()
  {
    AppMethodBeat.i(291958);
    Intent localIntent = new Intent();
    CharSequence localCharSequence = (CharSequence)hJm().poiId;
    if ((localCharSequence == null) || (kotlin.n.n.bp(localCharSequence))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        localIntent.putExtra("get_poi_classify_id", hJm().poiId);
      }
      localIntent.putExtra("get_lat", hJm().latitude);
      localIntent.putExtra("get_lng", hJm().longitude);
      localIntent.putExtra("near_life_scene", 1);
      com.tencent.mm.br.c.b((Context)getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, 10);
      com.tencent.mm.plugin.report.service.l.kK(12, 10);
      AppMethodBeat.o(291958);
      return;
    }
  }
  
  private final void hJx()
  {
    AppMethodBeat.i(291959);
    Editable localEditable = hIP().getText();
    Object localObject3 = new com.tencent.mm.plugin.textstatus.proto.n();
    ((com.tencent.mm.plugin.textstatus.proto.n)localObject3).ToW = hJm().topicInfo.iconId;
    Object localObject1 = com.tencent.mm.plugin.textstatus.util.k.TBx;
    localObject1 = com.tencent.mm.plugin.textstatus.util.k.hKz().matcher((CharSequence)localEditable.toString());
    while (((Matcher)localObject1).find()) {
      ((com.tencent.mm.plugin.textstatus.proto.n)localObject3).ToZ.add(((Matcher)localObject1).group(1));
    }
    localObject1 = this.Tlw;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = "";
      ((com.tencent.mm.plugin.textstatus.proto.n)localObject3).ToX = ((String)localObject1);
      ((com.tencent.mm.plugin.textstatus.proto.n)localObject3).ToY = localEditable.toString();
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("BIZ_SCENE", 1);
      ((Intent)localObject2).putExtra("EXT_BUFF", ((com.tencent.mm.plugin.textstatus.proto.n)localObject3).toByteArray());
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(Integer.valueOf(2));
      ((ArrayList)localObject1).add(Integer.valueOf(4));
      ((ArrayList)localObject1).add(Integer.valueOf(1));
      ((ArrayList)localObject1).add(Integer.valueOf(5));
      ((ArrayList)localObject1).add(Integer.valueOf(3));
      localObject3 = ah.aiuX;
      ((Intent)localObject2).putIntegerArrayListExtra("TAB_LIST", (ArrayList)localObject1);
      if (!(this instanceof Activity)) {
        break label289;
      }
    }
    label289:
    for (localObject1 = (Activity)this;; localObject1 = null)
    {
      if (localObject1 != null) {
        ((Activity)localObject1).overridePendingTransition(com.tencent.mm.plugin.textstatus.a.a.push_up_in, com.tencent.mm.plugin.textstatus.a.a.anim_not_change);
      }
      ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).enterFinderGallery((Context)this, (Intent)localObject2, 8);
      AppMethodBeat.o(291959);
      return;
      localObject1 = ((TextView)localObject1).getText();
      if (localObject1 == null)
      {
        localObject1 = "";
        break;
      }
      localObject2 = localObject1.toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
    }
  }
  
  private final void hJy()
  {
    AppMethodBeat.i(291960);
    if (!com.tencent.mm.pluginsdk.permission.b.a((Activity)this, "android.permission.CAMERA", 18, ""))
    {
      AppMethodBeat.o(291960);
      return;
    }
    Object localObject1 = (CaptureDataManager.b)new TextStatusEditActivity.q(this);
    new SightParams(1, 0);
    Object localObject2 = com.tencent.mm.modelvideo.aa.PW(com.tencent.mm.plugin.auth.a.a.cUx());
    kotlin.g.b.s.s(localObject2, "genFileName(Account.username())");
    com.tencent.mm.modelvideo.v.bOh();
    Object localObject3 = com.tencent.mm.modelvideo.aa.PX((String)localObject2);
    com.tencent.mm.modelvideo.v.bOh();
    localObject2 = RecordConfigProvider.a((String)localObject3, com.tencent.mm.modelvideo.aa.PY((String)localObject2), ((com.tencent.mm.plugin.story.c.a.c.a)com.tencent.mm.plugin.story.c.a.c.SiN.boF()).oXZ, ((com.tencent.mm.plugin.story.c.a.c.a)com.tencent.mm.plugin.story.c.a.c.SiN.boF()).oXZ.duration * 1000, 15);
    kotlin.g.b.s.s(localObject2, "getRecordMediaConfig(\n  …ENE_TEXT_STATUS\n        )");
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yVj, false)) {
      ((RecordConfigProvider)localObject2).remuxType = 2;
    }
    localObject3 = new UICustomParam.a();
    ((UICustomParam.a)localObject3).aQw();
    ((UICustomParam.a)localObject3).aQv();
    ((UICustomParam.a)localObject3).eL(true);
    ((RecordConfigProvider)localObject2).NHR = ((UICustomParam.a)localObject3).lZB;
    ((RecordConfigProvider)localObject2).NHY = Boolean.FALSE;
    ((RecordConfigProvider)localObject2).NIk = false;
    ((RecordConfigProvider)localObject2).NIl = false;
    ((RecordConfigProvider)localObject2).NIm = true;
    ((RecordConfigProvider)localObject2).NHU = Boolean.TRUE;
    ((RecordConfigProvider)localObject2).NHT = 4;
    ((RecordConfigProvider)localObject2).cD(2, TextStatusEditVideoPluginLayout.class.getName());
    ((RecordConfigProvider)localObject2).cD(1, TextStatusEditPhotoPluginLayout.class.getName());
    ((RecordConfigProvider)localObject2).cD(0, TextStatusRecordPluginLayout.class.getName());
    CaptureDataManager.NHH.NHG = ((CaptureDataManager.b)localObject1);
    localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
    com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)this, 2, com.tencent.mm.plugin.textstatus.a.a.sight_slide_bottom_in, com.tencent.mm.plugin.textstatus.a.a.sight_slide_bottom_out, (RecordConfigProvider)localObject2);
    AppMethodBeat.o(291960);
  }
  
  private final void hJz()
  {
    AppMethodBeat.i(291961);
    this.TyM.clear();
    this.TyN = 0;
    Object localObject;
    if (!Util.isNullOrNil(this.RiT))
    {
      localObject = (CharSequence)this.RiT;
      localObject = ((Collection)new kotlin.n.k(",").o((CharSequence)localObject, 0)).toArray(new String[0]);
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(291961);
        throw ((Throwable)localObject);
      }
      localObject = (String[])localObject;
      localObject = kotlin.a.p.listOf(Arrays.copyOf((Object[])localObject, localObject.length));
      this.TyM.addAll((Collection)lw((List)localObject));
      this.TyN |= 0x1;
    }
    if (!Util.isNullOrNil(this.RiR))
    {
      localObject = (CharSequence)this.RiR;
      localObject = ((Collection)new kotlin.n.k(",").o((CharSequence)localObject, 0)).toArray(new String[0]);
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(291961);
        throw ((Throwable)localObject);
      }
      localObject = (String[])localObject;
      localObject = kotlin.a.p.listOf(Arrays.copyOf((Object[])localObject, localObject.length));
      this.TyM.addAll(lv((List)localObject));
      this.TyN |= 0x4;
    }
    if (!Util.isNullOrNil(this.RiS))
    {
      localObject = (CharSequence)this.RiS;
      localObject = ((Collection)new kotlin.n.k(",").o((CharSequence)localObject, 0)).toArray(new String[0]);
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(291961);
        throw ((Throwable)localObject);
      }
      localObject = (String[])localObject;
      localObject = kotlin.a.p.listOf(Arrays.copyOf((Object[])localObject, localObject.length));
      this.TyM.addAll((Collection)localObject);
      this.TyN |= 0x2;
    }
    AppMethodBeat.o(291961);
  }
  
  private final void hs(String paramString, int paramInt)
  {
    AppMethodBeat.i(291950);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (kotlin.n.n.bp((CharSequence)localObject1))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(291950);
      return;
    }
    localObject1 = hJc();
    if (((this.niy == 2) && (!this.Tyw)) || (this.TyO) || (com.tencent.mm.plugin.textstatus.d.a.a(hJm())))
    {
      i = 8;
      ((View)localObject1).setVisibility(i);
      if (paramInt != 2) {
        break label792;
      }
      Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "handle video file");
      hIQ().setVisibility(8);
      localObject1 = this.Tvm;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).setVisibility(0);
      }
      localObject1 = this.TxS;
      if (localObject1 != null) {
        break label235;
      }
      paramInt = 0;
      label143:
      localObject1 = this.TxS;
      if (localObject1 != null) {
        break label244;
      }
      i = 0;
      label156:
      localObject1 = new FrameLayout.LayoutParams(paramInt, i);
      ((FrameLayout.LayoutParams)localObject1).gravity = 17;
      if (this.Goz != null) {
        break label253;
      }
      localObject2 = getContext();
      kotlin.g.b.s.s(localObject2, "context");
      this.Goz = new MMTPEffectVideoLayout((Context)localObject2, (byte)0);
    }
    MMTPEffectVideoLayout localMMTPEffectVideoLayout;
    for (;;)
    {
      localMMTPEffectVideoLayout = this.Goz;
      if (localMMTPEffectVideoLayout != null) {
        break label278;
      }
      AppMethodBeat.o(291950);
      return;
      i = 0;
      break;
      label235:
      paramInt = ((View)localObject1).getMeasuredWidth();
      break label143;
      label244:
      i = ((View)localObject1).getMeasuredHeight();
      break label156;
      label253:
      localObject2 = this.Goz;
      if (localObject2 != null) {
        ((MMTPEffectVideoLayout)localObject2).TGP.HkF.release();
      }
    }
    label278:
    Object localObject2 = this.Tvm;
    if (localObject2 != null) {
      ((FrameLayout)localObject2).removeAllViews();
    }
    localObject2 = this.Tvm;
    if (localObject2 != null) {
      ((FrameLayout)localObject2).addView((View)localMMTPEffectVideoLayout, (ViewGroup.LayoutParams)localObject1);
    }
    localObject1 = this.Tvm;
    if (localObject1 != null) {
      ((FrameLayout)localObject1).setVisibility(0);
    }
    boolean bool = y.ZC(paramString);
    label407:
    label412:
    label459:
    label471:
    long l;
    if (!bool)
    {
      localObject1 = kotlin.n.d.UTF_8;
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(291950);
        throw paramString;
      }
      localObject1 = paramString.getBytes((Charset)localObject1);
      kotlin.g.b.s.s(localObject1, "(this as java.lang.String).getBytes(charset)");
      localObject1 = com.tencent.mm.b.g.getMessageDigest((byte[])localObject1);
      if (bool) {
        break label679;
      }
      localObject2 = paramString;
      if (!bool) {
        break label687;
      }
      localObject1 = new com.tencent.mm.plugin.thumbplayer.a.b((String)localObject1, paramString, (String)localObject2, hJm().mediaWidth, hJm().mediaHeight);
      if (bool)
      {
        paramString = MultiMediaVideoChecker.ObB.aTG(paramString);
        if (paramString != null) {
          break label703;
        }
        paramInt = 0;
        ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).width = paramInt;
        if (paramString != null) {
          break label711;
        }
        paramInt = 0;
        ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).height = paramInt;
        if (paramString != null) {
          break label719;
        }
        l = 0L;
        label484:
        ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).vYw = l;
        if (paramString != null) {
          break label728;
        }
      }
    }
    label679:
    label687:
    label703:
    label711:
    label719:
    label728:
    for (paramInt = 0;; paramInt = paramString.hYK)
    {
      ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).hYK = paramInt;
      ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).hJv = bool;
      Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "[play] isLocal:%s, videoWidth:%s, videoHeight:%s rotate:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).width), Integer.valueOf(((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).height), Integer.valueOf(((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).hYK) });
      localMMTPEffectVideoLayout.fva();
      localMMTPEffectVideoLayout.setMediaInfo((com.tencent.mm.plugin.thumbplayer.a.b)localObject1);
      paramString = localMMTPEffectVideoLayout.getPlayer();
      if (paramString != null) {
        paramString.Flr = true;
      }
      paramString = localMMTPEffectVideoLayout.getPlayer();
      if (paramString != null) {
        paramString.setLoop(true);
      }
      localMMTPEffectVideoLayout.getEffectManager().jQk();
      this.Goz = localMMTPEffectVideoLayout;
      try
      {
        paramString = localMMTPEffectVideoLayout.getPlayer();
        if (paramString != null) {
          paramString.hLh();
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          com.tencent.mm.plugin.textstatus.util.e locale;
          Log.e("MicroMsg.TextStatus.TextStatusEditActivity", "unable to play video! mediaInfo:" + localObject1 + " error:" + paramString.getLocalizedMessage());
          paramString = this.Tvm;
          if (paramString != null) {
            paramString.setVisibility(8);
          }
        }
      }
      paramString = com.tencent.mm.plugin.textstatus.util.l.TBz;
      com.tencent.mm.plugin.textstatus.util.l.C((View)this.Tvm, com.tencent.mm.cd.a.fromDPToPix((Context)this, 12.0F));
      hJs();
      AppMethodBeat.o(291950);
      return;
      localObject1 = "";
      break;
      localObject2 = "";
      break label407;
      locale = com.tencent.mm.plugin.textstatus.util.e.TAU;
      paramString = com.tencent.mm.plugin.textstatus.util.e.nl("video_online", paramString);
      break label412;
      paramInt = paramString.width;
      break label459;
      paramInt = paramString.height;
      break label471;
      l = paramString.duration;
      break label484;
    }
    label792:
    com.tencent.threadpool.h.ahAA.bm(new TextStatusEditActivity..ExternalSyntheticLambda38(paramString, this));
    AppMethodBeat.o(291950);
  }
  
  private static final void i(TextStatusEditActivity paramTextStatusEditActivity, View paramView)
  {
    AppMethodBeat.i(292026);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusEditActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    paramTextStatusEditActivity.NYC.onClick(paramView);
    paramView = com.tencent.mm.plugin.secdata.ui.a.PlI;
    paramTextStatusEditActivity = paramTextStatusEditActivity.getContext();
    kotlin.g.b.s.s(paramTextStatusEditActivity, "context");
    paramTextStatusEditActivity = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)paramTextStatusEditActivity, 8, bh.class);
    if (paramTextStatusEditActivity != null) {
      paramTextStatusEditActivity.TqK = (1L + paramTextStatusEditActivity.TqK);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292026);
  }
  
  private static final void j(TextStatusEditActivity paramTextStatusEditActivity, View paramView)
  {
    AppMethodBeat.i(292028);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusEditActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    paramTextStatusEditActivity = paramTextStatusEditActivity.TxM;
    if (paramTextStatusEditActivity != null) {
      paramTextStatusEditActivity.performClick();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292028);
  }
  
  private static final void k(TextStatusEditActivity paramTextStatusEditActivity, View paramView)
  {
    AppMethodBeat.i(292030);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusEditActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    paramTextStatusEditActivity.onBackPressed();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292030);
  }
  
  private static final void l(TextStatusEditActivity paramTextStatusEditActivity, View paramView)
  {
    AppMethodBeat.i(292031);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusEditActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    paramTextStatusEditActivity.a(c.TyU);
    paramTextStatusEditActivity = paramTextStatusEditActivity.hJo();
    if (paramTextStatusEditActivity != null) {
      paramTextStatusEditActivity.Tre += 1;
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292031);
  }
  
  private static Collection<String> lv(List<String> paramList)
  {
    AppMethodBeat.i(291963);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      HashSet localHashSet = new HashSet();
      for (;;)
      {
        if (paramList.hasNext())
        {
          localObject = (String)paramList.next();
          localObject = com.tencent.mm.plugin.label.a.a.fTb().aJK(com.tencent.mm.plugin.label.a.a.fTb().aJH((String)localObject));
          if ((localObject != null) && (((List)localObject).size() != 0)) {}
        }
        else
        {
          paramList = (Collection)new ArrayList((Collection)localHashSet);
          AppMethodBeat.o(291963);
          return paramList;
        }
        Object localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localHashSet.add((String)((Iterator)localObject).next());
        }
      }
    }
    paramList = (Collection)new ArrayList();
    AppMethodBeat.o(291963);
    return paramList;
  }
  
  private static List<String> lw(List<String> paramList)
  {
    AppMethodBeat.i(291964);
    LinkedList localLinkedList = new LinkedList();
    if (!com.tencent.mm.kernel.h.baC().aZN())
    {
      paramList = (List)localLinkedList;
      AppMethodBeat.o(291964);
      return paramList;
    }
    if (paramList == null)
    {
      paramList = (List)localLinkedList;
      AppMethodBeat.o(291964);
      return paramList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = com.tencent.mm.model.v.Im((String)paramList.next());
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if ((!localLinkedList.contains(str)) && (ab.IR(str))) {
            localLinkedList.add(str);
          }
        }
      }
    }
    paramList = (List)localLinkedList;
    AppMethodBeat.o(291964);
    return paramList;
  }
  
  private static final void m(TextStatusEditActivity paramTextStatusEditActivity, View paramView)
  {
    AppMethodBeat.i(292032);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusEditActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    int i;
    if (paramTextStatusEditActivity.TyF == c.TyV)
    {
      paramView = paramTextStatusEditActivity.MHO;
      if ((paramView == null) || (paramView.getVisibility() != 0)) {
        break label148;
      }
      i = 1;
      if (i == 0) {
        break label153;
      }
      paramView = paramTextStatusEditActivity.MHO;
      if (paramView != null) {
        paramView.setVisibility(4);
      }
      paramTextStatusEditActivity.onInputPanelChange(false, 0);
      paramTextStatusEditActivity.hideVKB();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(292032);
      return;
      label148:
      i = 0;
      break;
      label153:
      paramTextStatusEditActivity.showVKB();
    }
  }
  
  private static final void n(TextStatusEditActivity paramTextStatusEditActivity, View paramView)
  {
    AppMethodBeat.i(292033);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusEditActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    if (paramTextStatusEditActivity.hJK().mediaType == 0)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(292033);
      return;
    }
    paramView = com.tencent.mm.plugin.secdata.ui.a.PlI;
    paramView = paramTextStatusEditActivity.getContext();
    kotlin.g.b.s.s(paramView, "context");
    paramView = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)paramView, 8, bh.class);
    if (paramView != null)
    {
      if (!com.tencent.mm.plugin.textstatus.d.a.b(paramTextStatusEditActivity.hJm())) {
        break label209;
      }
      paramView.TqQ += 1L;
    }
    for (;;)
    {
      paramView = paramTextStatusEditActivity.hJm();
      kotlin.g.b.s.u(paramView, "<this>");
      paramView.option ^= 1L;
      paramTextStatusEditActivity.hJs();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(292033);
      return;
      label209:
      paramView.TqP += 1L;
    }
  }
  
  private static final void o(TextStatusEditActivity paramTextStatusEditActivity, View paramView)
  {
    AppMethodBeat.i(292050);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusEditActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    paramView = new Intent((Context)paramTextStatusEditActivity, SnsLabelUI.class);
    paramView.putExtra("KLabel_range_index", paramTextStatusEditActivity.RiP);
    paramView.putExtra("Klabel_name_list", paramTextStatusEditActivity.RiR);
    paramView.putExtra("Kother_user_name_list", paramTextStatusEditActivity.RiS);
    paramView.putExtra("Kchat_room_name_list", paramTextStatusEditActivity.RiT);
    paramView.putExtra("Kis_from_text_status", true);
    paramView.putExtra("k_show_private", false);
    paramView.putExtra("k_show_include", false);
    paramView.putExtra("k_sns_label_ui_style", paramTextStatusEditActivity.style);
    paramTextStatusEditActivity.startActivityForResult(paramView, 4);
    paramView = com.tencent.mm.plugin.secdata.ui.a.PlI;
    paramTextStatusEditActivity = paramTextStatusEditActivity.getContext();
    kotlin.g.b.s.s(paramTextStatusEditActivity, "context");
    paramTextStatusEditActivity = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)paramTextStatusEditActivity, 8, bh.class);
    if (paramTextStatusEditActivity != null) {
      paramTextStatusEditActivity.TqN = (1L + paramTextStatusEditActivity.TqN);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292050);
  }
  
  private static final void p(TextStatusEditActivity paramTextStatusEditActivity, View paramView)
  {
    AppMethodBeat.i(292053);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusEditActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    paramView = com.tencent.mm.kernel.h.baE().ban().d(274436, null);
    int i;
    if ((paramView instanceof String))
    {
      paramView = (String)paramView;
      if (!com.tencent.mm.au.b.OE(paramView)) {
        break label261;
      }
      if ((!com.tencent.mm.pluginsdk.permission.b.s((Context)paramTextStatusEditActivity.getContext(), "android.permission.ACCESS_FINE_LOCATION")) || (!com.tencent.mm.pluginsdk.permission.b.s((Context)paramTextStatusEditActivity.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {
        break label225;
      }
      i = 1;
      label132:
      if (i != 0) {
        break label344;
      }
      if (!kotlin.g.b.s.p(com.tencent.mm.kernel.h.baE().ban().get(at.a.acXn, Boolean.FALSE), Boolean.FALSE)) {
        break label230;
      }
      com.tencent.mm.plugin.account.sdk.c.a.b((Context)paramTextStatusEditActivity.getContext(), paramTextStatusEditActivity.getString(a.h.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 30764, true);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(292053);
      return;
      paramView = null;
      break;
      label225:
      i = 0;
      break label132;
      label230:
      com.tencent.mm.pluginsdk.permission.b.a((Activity)paramTextStatusEditActivity.getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 64);
    }
    label261:
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)paramTextStatusEditActivity.getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 64, null);
    Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(292053);
      return;
    }
    label344:
    paramTextStatusEditActivity.hJw();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292053);
  }
  
  private static final void q(TextStatusEditActivity paramTextStatusEditActivity, View paramView)
  {
    AppMethodBeat.i(292059);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusEditActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    long l = System.currentTimeMillis();
    if (Math.abs(l - paramTextStatusEditActivity.lastClickTime) < 1000L)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(292059);
      return;
    }
    paramTextStatusEditActivity.lastClickTime = l;
    paramView = new com.tencent.mm.ui.tools.l((Context)paramTextStatusEditActivity);
    paramView.Vtg = new TextStatusEditActivity..ExternalSyntheticLambda25(paramTextStatusEditActivity);
    paramView.GAC = new TextStatusEditActivity..ExternalSyntheticLambda26(paramTextStatusEditActivity);
    paramView.jDd();
    paramView = com.tencent.mm.plugin.secdata.ui.a.PlI;
    paramTextStatusEditActivity = paramTextStatusEditActivity.getContext();
    kotlin.g.b.s.s(paramTextStatusEditActivity, "context");
    paramTextStatusEditActivity = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)paramTextStatusEditActivity, 8, bh.class);
    if (paramTextStatusEditActivity != null) {
      paramTextStatusEditActivity.TqJ = (1L + paramTextStatusEditActivity.TqJ);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292059);
  }
  
  private static final void r(TextStatusEditActivity paramTextStatusEditActivity, View paramView)
  {
    AppMethodBeat.i(292064);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusEditActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTextStatusEditActivity, "this$0");
    paramTextStatusEditActivity.findViewById(a.e.Tcj).setVisibility(8);
    paramView = paramTextStatusEditActivity.TxA;
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    paramTextStatusEditActivity.grz();
    paramView = com.tencent.mm.plugin.secdata.ui.a.PlI;
    paramTextStatusEditActivity = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)paramTextStatusEditActivity, 8, bh.class);
    if (paramTextStatusEditActivity != null) {
      paramTextStatusEditActivity.Tok = 1;
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292064);
  }
  
  public final void D(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(292321);
    Object localObject = (CharSequence)hIP().getText();
    if ((localObject == null) || (kotlin.n.n.bp((CharSequence)localObject))) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramEmojiInfo = hJo();
      if (paramEmojiInfo != null) {
        paramEmojiInfo.Trg += 1;
      }
      aos(a.h.Tgg);
      AppMethodBeat.o(292321);
      return;
    }
    a(c.TyV);
    hIX().setEmojiInfo(paramEmojiInfo);
    bh localbh = hJo();
    if (localbh != null)
    {
      if (paramEmojiInfo != null) {
        break label119;
      }
      paramEmojiInfo = "";
    }
    for (;;)
    {
      localbh.Tri = paramEmojiInfo;
      AppMethodBeat.o(292321);
      return;
      label119:
      localObject = paramEmojiInfo.getMd5();
      paramEmojiInfo = (EmojiInfo)localObject;
      if (localObject == null) {
        paramEmojiInfo = "";
      }
    }
  }
  
  public final void Tw(String paramString)
  {
    AppMethodBeat.i(292399);
    Log.i("MicroMsg.TextStatus.TextStatusEditActivity", kotlin.g.b.s.X("Set New textStatus : ", Util.secPrint(paramString)));
    if (hJK().TyZ)
    {
      paramString = (Context)this;
      getString(a.h.processing);
      this.vEG = ((ProgressDialog)com.tencent.mm.ui.base.k.a(paramString, getString(a.h.processing), false, null));
      com.tencent.threadpool.h.ahAA.bm(new TextStatusEditActivity..ExternalSyntheticLambda34(this));
      AppMethodBeat.o(292399);
      return;
    }
    hJM();
    AppMethodBeat.o(292399);
  }
  
  public final void Tx(String paramString)
  {
    AppMethodBeat.i(292386);
    if ((ac.hGp()) && (kotlin.g.b.s.p(hJm().topicInfo.iconId, "userdefine")))
    {
      paramString = this.Tlw;
      if (paramString != null)
      {
        paramString = paramString.getText();
        if ((paramString != null) && (kotlin.n.n.bp(paramString) == true))
        {
          i = 1;
          if ((i == 0) || (hIY().getVisibility() == 0)) {
            break label155;
          }
          paramString = hIP().getText();
          kotlin.g.b.s.s(paramString, "etDesc.text");
          if (kotlin.n.n.bp((CharSequence)paramString)) {
            break label150;
          }
        }
      }
      label150:
      for (int i = 1;; i = 0)
      {
        if ((i == 0) && (!hJK().hJP()) && (this.Tvz == null)) {
          com.tencent.mm.ui.base.aa.y((Context)this, getString(a.h.settings_modify_text_status_skip_selector_invalid_less), a.g.icons_outlined_info);
        }
        AppMethodBeat.o(292386);
        return;
        i = 0;
        break;
      }
    }
    label155:
    com.tencent.mm.ui.base.aa.y((Context)this, getString(a.h.settings_modify_text_status_invalid_less), a.g.icons_outlined_info);
    paramString = com.tencent.mm.plugin.secdata.ui.a.PlI;
    paramString = getContext();
    kotlin.g.b.s.s(paramString, "context");
    paramString = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)paramString, 8, bh.class);
    if (paramString != null) {
      paramString.TqG = (1L + paramString.TqG);
    }
    AppMethodBeat.o(292386);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void aIj(String paramString)
  {
    AppMethodBeat.i(292353);
    Log.i("MicroMsg.TextStatus.TextStatusEditActivity", kotlin.g.b.s.X("onPressEmoji : ", paramString));
    if (com.tencent.mm.ui.tools.g.a(kotlin.g.b.s.X(hIP().getText().toString(), paramString), com.tencent.mm.ui.tools.g.a.afII) > 64)
    {
      paramString = com.tencent.mm.plugin.secdata.ui.a.PlI;
      paramString = getContext();
      kotlin.g.b.s.s(paramString, "context");
      paramString = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)paramString, 8, bh.class);
      if (paramString != null)
      {
        paramString.TqF = (1L + paramString.TqF);
        AppMethodBeat.o(292353);
      }
    }
    else
    {
      hIP().bDt(paramString);
    }
    AppMethodBeat.o(292353);
  }
  
  public final void aos(int paramInt)
  {
    AppMethodBeat.i(292317);
    Object localObject = new com.tencent.mm.ui.widget.a.g.a((Context)this);
    ((com.tencent.mm.ui.widget.a.g.a)localObject).bDE(getString(paramInt)).NF(true);
    com.tencent.mm.ui.widget.a.g.a locala = ((com.tencent.mm.ui.widget.a.g.a)localObject).c(TextStatusEditActivity..ExternalSyntheticLambda27.INSTANCE).d(TextStatusEditActivity..ExternalSyntheticLambda4.INSTANCE);
    locala.Xdm = true;
    locala.show();
    localObject = ((com.tencent.mm.ui.widget.a.g.a)localObject).pRv;
    ((com.tencent.mm.ui.widget.a.e)localObject).cX(-2, false);
    ((com.tencent.mm.ui.widget.a.e)localObject).show();
    AppMethodBeat.o(292317);
  }
  
  public final void eY(String paramString)
  {
    AppMethodBeat.i(292392);
    com.tencent.mm.ui.base.aa.y((Context)this, getString(a.h.settings_modify_text_status_invalid_more), a.g.icons_outlined_info);
    paramString = com.tencent.mm.plugin.secdata.ui.a.PlI;
    paramString = getContext();
    kotlin.g.b.s.s(paramString, "context");
    paramString = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)paramString, 8, bh.class);
    if (paramString != null) {
      paramString.TqF = (1L + paramString.TqF);
    }
    AppMethodBeat.o(292392);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(292381);
    hideVKB();
    hJI();
    if (!this.TyB)
    {
      ResultReceiver localResultReceiver = hJl();
      if (localResultReceiver != null) {
        localResultReceiver.send(0, null);
      }
    }
    super.finish();
    AppMethodBeat.o(292381);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return a.f.Tfp;
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(292358);
    Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "onDeleteEmoji");
    InputConnection localInputConnection = hIP().getInputConnection();
    if (localInputConnection != null)
    {
      localInputConnection.sendKeyEvent(new KeyEvent(0, 67));
      localInputConnection.sendKeyEvent(new KeyEvent(1, 67));
    }
    AppMethodBeat.o(292358);
  }
  
  public final MMEditText hIP()
  {
    AppMethodBeat.i(292215);
    MMEditText localMMEditText = this.TxL;
    if (localMMEditText != null)
    {
      AppMethodBeat.o(292215);
      return localMMEditText;
    }
    kotlin.g.b.s.bIx("etDesc");
    AppMethodBeat.o(292215);
    return null;
  }
  
  public final d hJK()
  {
    AppMethodBeat.i(292397);
    d locald = this.TyS;
    if (locald != null)
    {
      AppMethodBeat.o(292397);
      return locald;
    }
    kotlin.g.b.s.bIx("curLocalMediaStruct");
    AppMethodBeat.o(292397);
    return null;
  }
  
  public final View hJa()
  {
    AppMethodBeat.i(292230);
    View localView = this.Tyi;
    if (localView != null)
    {
      AppMethodBeat.o(292230);
      return localView;
    }
    kotlin.g.b.s.bIx("btnOk");
    AppMethodBeat.o(292230);
    return null;
  }
  
  public final bh hJo()
  {
    AppMethodBeat.i(292303);
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
    localObject = getContext();
    kotlin.g.b.s.s(localObject, "context");
    localObject = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)localObject, 8, bh.class);
    AppMethodBeat.o(292303);
    return localObject;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(292376);
    Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "onActivityResult");
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject2;
    Object localObject3;
    Object localObject1;
    label265:
    label421:
    label436:
    label572:
    label832:
    switch (paramInt1)
    {
    case 5: 
    case 9: 
    default: 
      AppMethodBeat.o(292376);
      return;
    case 8: 
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = paramIntent.getByteArrayExtra("SELECT_OBJECT");
        if (paramIntent != null)
        {
          localObject2 = new FinderObject();
          ((FinderObject)localObject2).parseFrom(paramIntent);
          paramIntent = com.tencent.mm.plugin.secdata.ui.a.PlI;
          paramIntent = getContext();
          kotlin.g.b.s.s(paramIntent, "context");
          localObject3 = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)paramIntent, 8, bh.class);
          if (localObject3 != null)
          {
            ((bh)localObject3).TqL = (1L + ((bh)localObject3).TqL);
            paramIntent = ((bh)localObject3).TqZ;
            if (paramIntent != null) {
              break label336;
            }
            paramIntent = "";
            localObject1 = (CharSequence)((bh)localObject3).TqZ;
            if ((localObject1 != null) && (!kotlin.n.n.bp((CharSequence)localObject1))) {
              break label339;
            }
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break label344;
            }
            localObject1 = com.tencent.mm.plugin.finder.gallery.f.BuT;
            localObject1 = com.tencent.mm.plugin.finder.gallery.f.getSessionId();
            ((bh)localObject3).TqZ = kotlin.g.b.s.X(paramIntent, localObject1);
          }
          paramIntent = ((FinderObject)localObject2).contact;
          if (paramIntent != null) {
            break label363;
          }
          localObject1 = null;
          hJu();
          localObject3 = (com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
          if (localObject1 != null) {
            break label374;
          }
          paramIntent = null;
          if (localObject1 != null) {
            break label383;
          }
        }
      }
      for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.finder.api.m)localObject1).amx())
      {
        paramIntent = ((com.tencent.mm.plugin.h)localObject3).a(paramIntent, (String)localObject1, ((FinderObject)localObject2).id, (FinderObject)localObject2).Tog.topicInfo;
        localObject1 = hJm().topicInfo;
        kotlin.g.b.s.s(localObject1, "curTextStatusExtInfo.topicInfo");
        b((TextStatusTopicInfo)localObject1, paramIntent);
        hJD();
        hJB();
        AppMethodBeat.o(292376);
        return;
        break;
        paramInt1 = 0;
        break label205;
        localObject1 = com.tencent.mm.plugin.finder.gallery.f.BuT;
        localObject1 = kotlin.g.b.s.X(";", com.tencent.mm.plugin.finder.gallery.f.getSessionId());
        break label219;
        localObject1 = com.tencent.mm.plugin.finder.api.c.a(paramIntent, null, false);
        break label243;
        paramIntent = ((com.tencent.mm.plugin.finder.api.m)localObject1).getNickname();
        break label265;
      }
    case 2: 
      if (paramIntent == null)
      {
        localObject1 = null;
        if (localObject1 != null)
        {
          paramIntent = null;
          if (!((SightCaptureResult)localObject1).AnF) {
            break label659;
          }
          paramIntent = ((SightCaptureResult)localObject1).KTO;
          if (!((SightCaptureResult)localObject1).AnF) {
            break label676;
          }
          localObject2 = ((SightCaptureResult)localObject1).KTN;
          Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "[handleCaptureResult]isVideo:%s,thumbPath:%s,filePath:%s", new Object[] { Boolean.valueOf(((SightCaptureResult)localObject1).AnF), paramIntent, localObject2 });
          hJu();
          paramIntent = hJK();
          localObject3 = getContext();
          kotlin.g.b.s.s(localObject3, "context");
          localObject3 = (Context)localObject3;
          kotlin.g.b.s.u(localObject1, "captureResult");
          kotlin.g.b.s.u(localObject3, "context");
          paramIntent.reset();
          com.tencent.mm.plugin.textstatus.d.a.c(paramIntent.Tyx);
          paramIntent.Tqk = false;
          if (!((SightCaptureResult)localObject1).AnF) {
            break label686;
          }
          paramIntent.mediaType = 2;
          paramIntent.TyX = ((SightCaptureResult)localObject1).KTN;
          paramIntent.TyY = ((SightCaptureResult)localObject1).KTO;
          paramIntent.vYw = ((SightCaptureResult)localObject1).KTR;
          paramIntent.Tzc = y.bEl(paramIntent.TyX);
          paramIntent.Tza = paramIntent.Tzc;
          paramIntent.Tzb = com.tencent.mm.b.g.getMD5(paramIntent.TyX);
          paramIntent.kq((Context)localObject3);
          if (!((SightCaptureResult)localObject1).AnF) {
            break label708;
          }
        }
      }
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        hs((String)localObject2, paramInt1);
        hJs();
        hJD();
        hJB();
        AppMethodBeat.o(292376);
        return;
        localObject1 = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
        break;
        if (!((SightCaptureResult)localObject1).KTL) {
          break label421;
        }
        paramIntent = ((SightCaptureResult)localObject1).KTT;
        break label421;
        localObject2 = ((SightCaptureResult)localObject1).KTT;
        break label436;
        paramIntent.mediaType = 1;
        paramIntent.TyX = ((SightCaptureResult)localObject1).KTT;
        paramIntent.TyZ = true;
        break label572;
      }
    case 6: 
      label205:
      label219:
      label243:
      label374:
      label383:
      this.TyQ = "";
      label336:
      label339:
      label344:
      label363:
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        localObject3 = paramIntent.getStringArrayListExtra("key_select_video_list");
        localObject2 = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
        if (((localObject3 != null) && (((ArrayList)localObject3).size() > 0)) || (!Util.isNullOrNil((String)localObject2))) {
          if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
          {
            localObject1 = ((ArrayList)localObject3).get(0);
            kotlin.g.b.s.s(localObject1, "{\n                videoPathList[0]\n            }");
            localObject1 = (String)localObject1;
            this.TyQ = ((String)localObject1);
            localObject1 = (CharSequence)localObject2;
            if ((localObject1 != null) && (!kotlin.n.n.bp((CharSequence)localObject1))) {
              break label1032;
            }
            paramInt1 = 1;
            if (paramInt1 != 0) {
              break label1037;
            }
            localObject1 = localObject2;
            localObject2 = paramIntent.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
            if ((!Util.isNullOrNil((String)localObject2)) && (y.ZC((String)localObject2))) {
              break label1775;
            }
            localObject2 = bef((String)localObject1);
          }
        }
      }
      label708:
      label840:
      break;
    }
    label659:
    label676:
    label686:
    label1222:
    label1233:
    label1260:
    label1775:
    for (;;)
    {
      Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "video path %s thumb path %s and %s %s ", new Object[] { localObject1, localObject2, Long.valueOf(y.bEl((String)localObject1)), Long.valueOf(y.bEl((String)localObject2)) });
      paramIntent = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      if (paramIntent != null)
      {
        localObject3 = com.tencent.mm.plugin.secdata.ui.a.PlI;
        localObject3 = getContext();
        kotlin.g.b.s.s(localObject3, "getContext()");
        localObject3 = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)localObject3, 8, bh.class);
        if (localObject3 != null)
        {
          paramIntent = paramIntent.gHE().J("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", Long.valueOf(0L));
          kotlin.g.b.s.s(paramIntent, "it.reportInfo.getReportV…DIA_DURATION_MS_LONG, 0L)");
          ((bh)localObject3).Tqv = ((Number)paramIntent).longValue();
        }
      }
      V(2, (String)localObject1, (String)localObject2);
      AppMethodBeat.o(292376);
      return;
      localObject1 = "";
      break label804;
      paramInt1 = 0;
      break label832;
      if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
      {
        localObject1 = (String)((ArrayList)localObject3).get(0);
        break label840;
      }
      localObject1 = "";
      break label840;
      paramIntent = paramIntent.getStringArrayListExtra("key_select_image_list");
      if ((paramIntent == null) || (paramIntent.size() == 0))
      {
        Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "no image selected");
        AppMethodBeat.o(292376);
        return;
      }
      V(1, (String)paramIntent.get(0), "");
      AppMethodBeat.o(292376);
      return;
      if ((paramInt2 != -1) || (paramIntent == null)) {
        break;
      }
      paramIntent = paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      kotlin.g.b.s.checkNotNull(paramIntent);
      kotlin.g.b.s.s(paramIntent, "data.getParcelableExtra(…geUI.KSEGMENTMEDIAINFO)!!");
      paramIntent = (CaptureDataManager.CaptureVideoNormalModel)paramIntent;
      V(2, paramIntent.videoPath, paramIntent.thumbPath);
      AppMethodBeat.o(292376);
      return;
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          break label1339;
        }
        localObject2 = "";
        hJm().topicInfo.iconId = ((String)localObject2);
        hJG();
        if (paramIntent != null) {
          break label1365;
        }
        localObject1 = "";
        if (!kotlin.g.b.s.p(localObject2, "userdefine")) {
          break label1391;
        }
        localObject2 = this.Tlw;
        if (localObject2 != null) {
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
      }
      if (paramIntent == null)
      {
        paramInt1 = 0;
        if (paramIntent != null) {
          break label1416;
        }
      }
      for (paramInt2 = 0;; paramInt2 = paramIntent.getIntExtra("CustomTitleTooLongCount", 0))
      {
        paramIntent = com.tencent.mm.plugin.secdata.ui.a.PlI;
        paramIntent = getContext();
        kotlin.g.b.s.s(paramIntent, "context");
        paramIntent = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)paramIntent, 8, bh.class);
        if (paramIntent != null)
        {
          long l = paramIntent.Tra;
          paramIntent.Tra = (paramInt1 + l);
          paramIntent.Trb += paramInt2;
        }
        hJB();
        AppMethodBeat.o(292376);
        return;
        localObject1 = paramIntent.getStringExtra("STATUS_TYPE_IMG");
        localObject2 = localObject1;
        if (localObject1 != null) {
          break;
        }
        localObject2 = "";
        break;
        localObject3 = paramIntent.getStringExtra("STATUS_TYPE_CUSTOM_TITLE");
        localObject1 = localObject3;
        if (localObject3 != null) {
          break label1222;
        }
        localObject1 = "";
        break label1222;
        label1391:
        localObject1 = com.tencent.mm.plugin.textstatus.util.b.hKh().bei((String)localObject2);
        break label1233;
        paramInt1 = paramIntent.getIntExtra("ClkCustomIconCount", 0);
        break label1260;
      }
      Log.i("MicroMsg.TextStatus.TextStatusEditActivity", kotlin.g.b.s.X("intent ", paramIntent));
      if (paramIntent != null)
      {
        localObject1 = paramIntent.getStringExtra("get_poi_name");
        localObject2 = paramIntent.getStringExtra("get_city");
        if ((!Util.isNullOrNil((String)localObject1)) || (!Util.isNullOrNil((String)localObject2))) {
          break label1568;
        }
      }
      for (localObject1 = null;; localObject1 = Util.nullAs((String)localObject1, (String)localObject2))
      {
        float f1 = paramIntent.getFloatExtra("get_lat", -1000.0F);
        float f2 = paramIntent.getFloatExtra("get_lng", -1000.0F);
        paramIntent = Util.nullAs(paramIntent.getStringExtra("get_poi_classify_id"), "");
        hJm().poiId = paramIntent;
        hJm().poiName = ((String)localObject1);
        hJm().latitude = f1;
        hJm().longitude = f2;
        hJA();
        AppMethodBeat.o(292376);
        return;
      }
      if (paramIntent == null)
      {
        AppMethodBeat.o(292376);
        return;
      }
      this.RiP = paramIntent.getIntExtra("Ktag_range_index", 0);
      localObject2 = paramIntent.getStringExtra("Klabel_name_list");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.RiR = ((String)localObject1);
      localObject2 = paramIntent.getStringExtra("Kother_user_name_list");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.RiS = ((String)localObject1);
      localObject1 = paramIntent.getStringExtra("Kchat_room_name_list");
      paramIntent = (Intent)localObject1;
      if (localObject1 == null) {
        paramIntent = "";
      }
      this.RiT = paramIntent;
      hJz();
      switch (this.RiP)
      {
      }
      for (;;)
      {
        aov(this.RiP);
        paramIntent = com.tencent.mm.plugin.secdata.ui.a.PlI;
        paramIntent = getContext();
        kotlin.g.b.s.s(paramIntent, "context");
        paramIntent = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)paramIntent, 8, bh.class);
        if (paramIntent == null) {
          break;
        }
        paramIntent.TqO = this.TyN;
        break;
        this.TyN = 0;
      }
    }
  }
  
  public final void onAttachedToWindow()
  {
    AppMethodBeat.i(292323);
    super.onAttachedToWindow();
    Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "onAttachedToWindow() called");
    AppMethodBeat.o(292323);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(292347);
    super.onBackPressed();
    getContext().overridePendingTransition(com.tencent.mm.plugin.textstatus.a.a.anim_not_change, com.tencent.mm.plugin.textstatus.a.a.push_down_out);
    AppMethodBeat.o(292347);
  }
  
  /* Error */
  public final void onCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: iconst_1
    //   10: istore 4
    //   12: ldc_w 4467
    //   15: invokestatic 732	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   18: aload_0
    //   19: checkcast 4469	com/tencent/mm/ui/MMActivity
    //   22: invokestatic 4475	com/tencent/mm/pluginsdk/h:w	(Lcom/tencent/mm/ui/MMActivity;)V
    //   25: aload_0
    //   26: aload_1
    //   27: invokespecial 4477	com/tencent/mm/plugin/secdata/ui/MMSecDataActivity:onCreate	(Landroid/os/Bundle;)V
    //   30: aload_0
    //   31: invokevirtual 2088	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:getWindow	()Landroid/view/Window;
    //   34: aload_0
    //   35: invokevirtual 1727	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:getResources	()Landroid/content/res/Resources;
    //   38: getstatic 2091	com/tencent/mm/plugin/textstatus/a$b:Dark_2	I
    //   41: invokevirtual 1778	android/content/res/Resources:getColor	(I)I
    //   44: invokevirtual 2096	android/view/Window:setNavigationBarColor	(I)V
    //   47: aload_0
    //   48: iconst_0
    //   49: invokevirtual 4480	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:setActionbarColor	(I)V
    //   52: aload_0
    //   53: invokevirtual 2088	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:getWindow	()Landroid/view/Window;
    //   56: invokevirtual 4483	android/view/Window:getDecorView	()Landroid/view/View;
    //   59: sipush 1280
    //   62: invokevirtual 4486	android/view/View:setSystemUiVisibility	(I)V
    //   65: aload_0
    //   66: invokevirtual 2088	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:getWindow	()Landroid/view/Window;
    //   69: invokestatic 4491	com/tencent/mm/ui/statusbar/d:g	(Landroid/view/Window;)V
    //   72: aload_0
    //   73: invokevirtual 4495	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:getController	()Lcom/tencent/mm/ui/y;
    //   76: getfield 4501	com/tencent/mm/ui/y:mActionBar	Landroidx/appcompat/app/ActionBar;
    //   79: iconst_0
    //   80: invokevirtual 4506	androidx/appcompat/app/ActionBar:A	(Z)V
    //   83: getstatic 4512	com/tencent/mm/plugin/xlabeffect/c:XJQ	Lcom/tencent/mm/plugin/xlabeffect/c;
    //   86: astore_1
    //   87: invokestatic 4515	com/tencent/mm/plugin/xlabeffect/c:fXr	()V
    //   90: aload_0
    //   91: ldc_w 1088
    //   94: invokevirtual 4518	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:setMMTitle	(Ljava/lang/String;)V
    //   97: aload_0
    //   98: invokevirtual 4521	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hideActionbarLine	()V
    //   101: aload_0
    //   102: invokevirtual 4524	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hideActionBarOperationArea	()V
    //   105: aload_0
    //   106: invokevirtual 4528	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:getSupportActionBar	()Landroidx/appcompat/app/ActionBar;
    //   109: astore_1
    //   110: aload_1
    //   111: ifnull +7 -> 118
    //   114: aload_1
    //   115: invokevirtual 4531	androidx/appcompat/app/ActionBar:hide	()V
    //   118: aload_0
    //   119: new 4533	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda5
    //   122: dup
    //   123: aload_0
    //   124: invokespecial 4534	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda5:<init>	(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity;)V
    //   127: invokevirtual 4538	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:setBackBtn	(Landroid/view/MenuItem$OnMenuItemClickListener;)V
    //   130: getstatic 4544	com/tencent/mm/ui/component/k:aeZF	Lcom/tencent/mm/ui/component/k;
    //   133: astore_1
    //   134: aload_0
    //   135: checkcast 1995	androidx/appcompat/app/AppCompatActivity
    //   138: invokestatic 4547	com/tencent/mm/ui/component/k:d	(Landroidx/appcompat/app/AppCompatActivity;)Lcom/tencent/mm/ui/component/k$b;
    //   141: ldc_w 1464
    //   144: invokevirtual 4552	com/tencent/mm/ui/component/k$b:q	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   147: checkcast 1464	com/tencent/mm/plugin/secdata/ui/a
    //   150: new 4554	com/tencent/mm/plugin/secdata/c
    //   153: dup
    //   154: ldc_w 1470
    //   157: bipush 8
    //   159: iconst_0
    //   160: invokespecial 4557	com/tencent/mm/plugin/secdata/c:<init>	(Ljava/lang/Class;IB)V
    //   163: checkcast 4559	com/tencent/mm/plugin/secdata/h
    //   166: invokevirtual 4562	com/tencent/mm/plugin/secdata/ui/a:a	(Lcom/tencent/mm/plugin/secdata/h;)V
    //   169: getstatic 1468	com/tencent/mm/plugin/secdata/ui/a:PlI	Lcom/tencent/mm/plugin/secdata/ui/a$a;
    //   172: astore_1
    //   173: aload_0
    //   174: checkcast 1212	android/content/Context
    //   177: bipush 8
    //   179: ldc_w 1470
    //   182: invokestatic 1475	com/tencent/mm/plugin/secdata/ui/a$a:a	(Landroid/content/Context;ILjava/lang/Class;)Lcom/tencent/mm/bx/a;
    //   185: checkcast 1470	com/tencent/mm/plugin/textstatus/proto/bh
    //   188: astore_1
    //   189: aload_1
    //   190: ifnull +20 -> 210
    //   193: aload_1
    //   194: invokestatic 4565	com/tencent/mm/model/cn:bDw	()J
    //   197: invokestatic 4568	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   200: putfield 2935	com/tencent/mm/plugin/textstatus/proto/bh:Tqq	Ljava/lang/String;
    //   203: aload_1
    //   204: invokestatic 4565	com/tencent/mm/model/cn:bDw	()J
    //   207: putfield 4571	com/tencent/mm/plugin/textstatus/proto/bh:enterTime	J
    //   210: aload_0
    //   211: aload_0
    //   212: getstatic 4574	com/tencent/mm/plugin/textstatus/a$e:Tcu	I
    //   215: invokevirtual 3280	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:findViewById	(I)Landroid/view/View;
    //   218: checkcast 1244	android/widget/ImageView
    //   221: putfield 2882	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TlN	Landroid/widget/ImageView;
    //   224: aload_0
    //   225: aload_0
    //   226: getstatic 4577	com/tencent/mm/plugin/textstatus/a$e:TeC	I
    //   229: invokevirtual 3280	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:findViewById	(I)Landroid/view/View;
    //   232: checkcast 1998	android/widget/TextView
    //   235: putfield 2920	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Tlw	Landroid/widget/TextView;
    //   238: aload_0
    //   239: aload_0
    //   240: getstatic 4580	com/tencent/mm/plugin/textstatus/a$e:TeT	I
    //   243: invokevirtual 3280	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:findViewById	(I)Landroid/view/View;
    //   246: putfield 4582	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TxE	Landroid/view/View;
    //   249: aload_0
    //   250: aload_0
    //   251: getstatic 4585	com/tencent/mm/plugin/textstatus/a$e:TeX	I
    //   254: invokevirtual 3280	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:findViewById	(I)Landroid/view/View;
    //   257: putfield 4587	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TxF	Landroid/view/View;
    //   260: aload_0
    //   261: aload_0
    //   262: getstatic 4590	com/tencent/mm/plugin/textstatus/a$e:Tcs	I
    //   265: invokevirtual 3280	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:findViewById	(I)Landroid/view/View;
    //   268: putfield 4592	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TxG	Landroid/view/View;
    //   271: aload_0
    //   272: aload_0
    //   273: getstatic 4595	com/tencent/mm/plugin/textstatus/a$e:Tct	I
    //   276: invokevirtual 3280	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:findViewById	(I)Landroid/view/View;
    //   279: putfield 4597	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TxI	Landroid/view/View;
    //   282: aload_0
    //   283: aload_0
    //   284: getstatic 4600	com/tencent/mm/plugin/textstatus/a$e:Tcv	I
    //   287: invokevirtual 3280	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:findViewById	(I)Landroid/view/View;
    //   290: putfield 4602	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TxK	Landroid/view/View;
    //   293: aload_0
    //   294: getstatic 4605	com/tencent/mm/plugin/textstatus/a$e:Tcm	I
    //   297: invokevirtual 3280	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:findViewById	(I)Landroid/view/View;
    //   300: checkcast 1362	com/tencent/mm/ui/widget/MMEditText
    //   303: astore_1
    //   304: aload_1
    //   305: ldc_w 4607
    //   308: invokestatic 1234	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   311: aload_0
    //   312: aload_1
    //   313: putfield 4227	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TxL	Lcom/tencent/mm/ui/widget/MMEditText;
    //   316: aload_0
    //   317: aload_0
    //   318: getstatic 4610	com/tencent/mm/plugin/textstatus/a$e:gaN	I
    //   321: invokevirtual 3280	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:findViewById	(I)Landroid/view/View;
    //   324: checkcast 1998	android/widget/TextView
    //   327: putfield 4612	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Tlx	Landroid/widget/TextView;
    //   330: aload_0
    //   331: aload_0
    //   332: getstatic 4615	com/tencent/mm/plugin/textstatus/a$e:Tco	I
    //   335: invokevirtual 3280	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:findViewById	(I)Landroid/view/View;
    //   338: putfield 2518	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TxS	Landroid/view/View;
    //   341: aload_0
    //   342: getstatic 4618	com/tencent/mm/plugin/textstatus/a$e:TeJ	I
    //   345: invokevirtual 3280	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:findViewById	(I)Landroid/view/View;
    //   348: checkcast 1244	android/widget/ImageView
    //   351: astore_1
    //   352: aload_1
    //   353: ldc_w 4607
    //   356: invokestatic 1234	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   359: aload_0
    //   360: aload_1
    //   361: putfield 2688	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TlA	Landroid/widget/ImageView;
    //   364: aload_0
    //   365: aload_0
    //   366: getstatic 4621	com/tencent/mm/plugin/textstatus/a$e:TeQ	I
    //   369: invokevirtual 3280	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:findViewById	(I)Landroid/view/View;
    //   372: checkcast 1244	android/widget/ImageView
    //   375: putfield 3400	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TxV	Landroid/widget/ImageView;
    //   378: aload_0
    //   379: aload_0
    //   380: getstatic 4624	com/tencent/mm/plugin/textstatus/a$e:TeG	I
    //   383: invokevirtual 3280	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:findViewById	(I)Landroid/view/View;
    //   386: checkcast 1998	android/widget/TextView
    //   389: putfield 1990	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TxO	Landroid/widget/TextView;
    //   392: aload_0
    //   393: aload_0
    //   394: getstatic 4627	com/tencent/mm/plugin/textstatus/a$e:TdB	I
    //   397: invokevirtual 3280	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:findViewById	(I)Landroid/view/View;
    //   400: checkcast 2303	android/widget/FrameLayout
    //   403: putfield 2723	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Tvm	Landroid/widget/FrameLayout;
    //   406: aload_0
    //   407: aload_0
    //   408: getstatic 4630	com/tencent/mm/plugin/textstatus/a$e:Tdz	I
    //   411: invokevirtual 3280	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:findViewById	(I)Landroid/view/View;
    //   414: putfield 4632	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Tye	Landroid/view/View;
    //   417: aload_0
    //   418: aload_0
    //   419: getstatic 4635	com/tencent/mm/plugin/textstatus/a$e:Tdf	I
    //   422: invokevirtual 3280	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:findViewById	(I)Landroid/view/View;
    //   425: putfield 2061	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Tyc	Landroid/view/View;
    //   428: aload_0
    //   429: aload_0
    //   430: getstatic 4638	com/tencent/mm/plugin/textstatus/a$e:Tcc	I
    //   433: invokevirtual 3280	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:findViewById	(I)Landroid/view/View;
    //   436: putfield 1376	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Tyh	Landroid/view/View;
    //   439: aload_0
    //   440: aload_0
    //   441: getstatic 4641	com/tencent/mm/plugin/textstatus/a$e:btn_ok	I
    //   444: invokevirtual 3280	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:findViewById	(I)Landroid/view/View;
    //   447: invokevirtual 4643	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:setBtnOk	(Landroid/view/View;)V
    //   450: aload_0
    //   451: aload_0
    //   452: getstatic 4646	com/tencent/mm/plugin/textstatus/a$e:btn_back	I
    //   455: invokevirtual 3280	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:findViewById	(I)Landroid/view/View;
    //   458: invokevirtual 4648	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:setBtnBack	(Landroid/view/View;)V
    //   461: aload_0
    //   462: aload_0
    //   463: getstatic 4651	com/tencent/mm/plugin/textstatus/a$e:Tch	I
    //   466: invokevirtual 3280	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:findViewById	(I)Landroid/view/View;
    //   469: putfield 4090	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TxA	Landroid/view/View;
    //   472: aload_0
    //   473: aload_0
    //   474: getstatic 4654	com/tencent/mm/plugin/textstatus/a$e:TcX	I
    //   477: invokevirtual 3280	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:findViewById	(I)Landroid/view/View;
    //   480: invokevirtual 4656	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:setLayoutBlurOption	(Landroid/view/View;)V
    //   483: aload_0
    //   484: getstatic 4659	com/tencent/mm/plugin/textstatus/a$e:TcB	I
    //   487: invokevirtual 3280	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:findViewById	(I)Landroid/view/View;
    //   490: checkcast 1244	android/widget/ImageView
    //   493: astore_1
    //   494: aload_1
    //   495: ldc_w 4607
    //   498: invokestatic 1234	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   501: aload_0
    //   502: aload_1
    //   503: putfield 3324	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Tym	Landroid/widget/ImageView;
    //   506: aload_0
    //   507: aload_0
    //   508: getstatic 4662	com/tencent/mm/plugin/textstatus/a$e:input_component	I
    //   511: invokevirtual 3280	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:findViewById	(I)Landroid/view/View;
    //   514: checkcast 3946	com/tencent/mm/emoji/view/EmojiPanelInputComponent
    //   517: putfield 3944	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:MHO	Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent;
    //   520: aload_0
    //   521: invokespecial 1407	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hIV	()Landroid/widget/ImageView;
    //   524: astore_1
    //   525: aload_1
    //   526: ifnull +16 -> 542
    //   529: aload_1
    //   530: new 4664	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda32
    //   533: dup
    //   534: aload_0
    //   535: invokespecial 4665	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda32:<init>	(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity;)V
    //   538: invokevirtual 1347	android/widget/ImageView:post	(Ljava/lang/Runnable;)Z
    //   541: pop
    //   542: aload_0
    //   543: checkcast 1212	android/content/Context
    //   546: invokestatic 4670	com/tencent/mm/ui/bf:getStatusBarHeight	(Landroid/content/Context;)I
    //   549: pop
    //   550: aload_0
    //   551: checkcast 1212	android/content/Context
    //   554: invokestatic 4673	com/tencent/mm/ui/bf:fs	(Landroid/content/Context;)I
    //   557: pop
    //   558: aload_0
    //   559: checkcast 1212	android/content/Context
    //   562: invokestatic 4675	com/tencent/mm/ui/bf:bk	(Landroid/content/Context;)I
    //   565: pop
    //   566: aload_0
    //   567: invokevirtual 4679	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:getIntent	()Landroid/content/Intent;
    //   570: ldc_w 4681
    //   573: invokevirtual 4248	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   576: astore 5
    //   578: aload 5
    //   580: ifnull +31 -> 611
    //   583: new 4683	com/tencent/mm/plugin/textstatus/a/w$a
    //   586: dup
    //   587: invokespecial 4684	com/tencent/mm/plugin/textstatus/a/w$a:<init>	()V
    //   590: getfield 4687	com/tencent/mm/plugin/textstatus/a/w$a:ThS	Lcom/tencent/mm/plugin/textstatus/a/w;
    //   593: astore_1
    //   594: aload_1
    //   595: aload 5
    //   597: invokevirtual 4688	com/tencent/mm/plugin/textstatus/a/w:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   600: pop
    //   601: getstatic 2653	kotlin/ah:aiuX	Lkotlin/ah;
    //   604: astore 5
    //   606: aload_0
    //   607: aload_1
    //   608: putfield 2799	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Txn	Lcom/tencent/mm/plugin/textstatus/a/w;
    //   611: aload_0
    //   612: getfield 2799	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Txn	Lcom/tencent/mm/plugin/textstatus/a/w;
    //   615: astore_1
    //   616: aload_1
    //   617: ifnonnull +894 -> 1511
    //   620: iconst_0
    //   621: istore_2
    //   622: aload_0
    //   623: iload_2
    //   624: putfield 2547	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:niy	I
    //   627: aload_0
    //   628: getfield 2547	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:niy	I
    //   631: tableswitch	default:+25 -> 656, 0:+888->1519, 1:+982->1613, 2:+1247->1878
    //   657: iconst_1
    //   658: ldiv
    //   659: dup
    //   660: invokespecial 4689	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:<init>	()V
    //   663: astore_1
    //   664: aload_1
    //   665: ldc_w 4607
    //   668: invokestatic 1234	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   671: aload_0
    //   672: aload_1
    //   673: putfield 3340	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Tyx	Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;
    //   676: new 53	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$d
    //   679: dup
    //   680: aload_0
    //   681: invokespecial 1131	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJm	()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;
    //   684: invokespecial 4691	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$d:<init>	(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;)V
    //   687: astore_1
    //   688: aload_1
    //   689: ldc_w 4607
    //   692: invokestatic 1234	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   695: aload_0
    //   696: aload_1
    //   697: putfield 4231	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TyS	Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$d;
    //   700: ldc_w 1251
    //   703: ldc_w 4693
    //   706: iconst_1
    //   707: anewarray 1553	java/lang/Object
    //   710: dup
    //   711: iconst_0
    //   712: aload_0
    //   713: getfield 2799	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Txn	Lcom/tencent/mm/plugin/textstatus/a/w;
    //   716: aastore
    //   717: invokestatic 2363	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   720: aload_0
    //   721: getfield 2547	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:niy	I
    //   724: iconst_1
    //   725: if_icmpne +1793 -> 2518
    //   728: aload_0
    //   729: invokespecial 1131	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJm	()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;
    //   732: getfield 2985	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:backgroundId	Ljava/lang/String;
    //   735: checkcast 1669	java/lang/CharSequence
    //   738: invokestatic 2514	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   741: ifne +21 -> 762
    //   744: getstatic 1050	com/tencent/mm/plugin/textstatus/util/k:TBx	Lcom/tencent/mm/plugin/textstatus/util/k;
    //   747: astore_1
    //   748: aload_0
    //   749: aload_0
    //   750: invokespecial 1131	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJm	()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;
    //   753: getfield 2985	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:backgroundId	Ljava/lang/String;
    //   756: invokestatic 4696	com/tencent/mm/plugin/textstatus/util/k:bep	(Ljava/lang/String;)I
    //   759: putfield 1055	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Tyy	I
    //   762: aload_0
    //   763: invokespecial 1131	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJm	()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;
    //   766: getfield 2569	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:topicInfo	Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;
    //   769: getfield 2858	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:iconId	Ljava/lang/String;
    //   772: ldc_w 4698
    //   775: invokestatic 1892	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   778: ifeq +21 -> 799
    //   781: aload_0
    //   782: invokespecial 3461	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hIR	()Landroid/widget/ImageView;
    //   785: iconst_0
    //   786: invokevirtual 2015	android/widget/ImageView:setVisibility	(I)V
    //   789: aload_0
    //   790: invokespecial 3461	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hIR	()Landroid/widget/ImageView;
    //   793: getstatic 4701	com/tencent/mm/plugin/textstatus/a$d:TbJ	I
    //   796: invokevirtual 3437	android/widget/ImageView:setImageResource	(I)V
    //   799: aload_0
    //   800: getfield 2799	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Txn	Lcom/tencent/mm/plugin/textstatus/a/w;
    //   803: astore_1
    //   804: aload_1
    //   805: ifnull +130 -> 935
    //   808: getstatic 1468	com/tencent/mm/plugin/secdata/ui/a:PlI	Lcom/tencent/mm/plugin/secdata/ui/a$a;
    //   811: astore 5
    //   813: aload_0
    //   814: checkcast 1212	android/content/Context
    //   817: bipush 8
    //   819: ldc_w 1470
    //   822: invokestatic 1475	com/tencent/mm/plugin/secdata/ui/a$a:a	(Landroid/content/Context;ILjava/lang/Class;)Lcom/tencent/mm/bx/a;
    //   825: checkcast 1470	com/tencent/mm/plugin/textstatus/proto/bh
    //   828: astore 5
    //   830: aload 5
    //   832: ifnull +103 -> 935
    //   835: aload 5
    //   837: aload_1
    //   838: getfield 4704	com/tencent/mm/plugin/textstatus/a/w:sessionId	Ljava/lang/String;
    //   841: putfield 4705	com/tencent/mm/plugin/textstatus/proto/bh:sessionId	Ljava/lang/String;
    //   844: aload 5
    //   846: aload_1
    //   847: getfield 2890	com/tencent/mm/plugin/textstatus/a/w:Toi	J
    //   850: putfield 4706	com/tencent/mm/plugin/textstatus/proto/bh:Toi	J
    //   853: aload 5
    //   855: aload_1
    //   856: getfield 4707	com/tencent/mm/plugin/textstatus/a/w:Toj	I
    //   859: putfield 3295	com/tencent/mm/plugin/textstatus/proto/bh:Toj	I
    //   862: aload 5
    //   864: aload_1
    //   865: getfield 4708	com/tencent/mm/plugin/textstatus/a/w:Tok	I
    //   868: putfield 4095	com/tencent/mm/plugin/textstatus/proto/bh:Tok	I
    //   871: aload 5
    //   873: aload_1
    //   874: getfield 4711	com/tencent/mm/plugin/textstatus/a/w:Tol	I
    //   877: i2l
    //   878: putfield 4411	com/tencent/mm/plugin/textstatus/proto/bh:Tra	J
    //   881: aload 5
    //   883: aload_1
    //   884: getfield 4714	com/tencent/mm/plugin/textstatus/a/w:Tom	I
    //   887: i2l
    //   888: putfield 4414	com/tencent/mm/plugin/textstatus/proto/bh:Trb	J
    //   891: aload 5
    //   893: aload_1
    //   894: getfield 4717	com/tencent/mm/plugin/textstatus/a/w:Tot	Ljava/lang/String;
    //   897: putfield 4720	com/tencent/mm/plugin/textstatus/proto/bh:Trj	Ljava/lang/String;
    //   900: aload 5
    //   902: aload_1
    //   903: getfield 4723	com/tencent/mm/plugin/textstatus/a/w:Tou	Ljava/lang/String;
    //   906: putfield 4726	com/tencent/mm/plugin/textstatus/proto/bh:Trk	Ljava/lang/String;
    //   909: aload_1
    //   910: getfield 4727	com/tencent/mm/plugin/textstatus/a/w:enterTime	J
    //   913: lconst_0
    //   914: lcmp
    //   915: ifne +1646 -> 2561
    //   918: aload 5
    //   920: invokestatic 4565	com/tencent/mm/model/cn:bDw	()J
    //   923: putfield 4571	com/tencent/mm/plugin/textstatus/proto/bh:enterTime	J
    //   926: aload 5
    //   928: aload_1
    //   929: getfield 4730	com/tencent/mm/plugin/textstatus/a/w:Tos	I
    //   932: putfield 4733	com/tencent/mm/plugin/textstatus/proto/bh:Trc	I
    //   935: aload_0
    //   936: invokevirtual 1578	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJa	()Landroid/view/View;
    //   939: aload_0
    //   940: invokespecial 2758	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJq	()Z
    //   943: invokevirtual 2761	android/view/View:setEnabled	(Z)V
    //   946: aload_0
    //   947: invokevirtual 1578	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJa	()Landroid/view/View;
    //   950: new 4735	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda12
    //   953: dup
    //   954: aload_0
    //   955: invokespecial 4736	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda12:<init>	(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity;)V
    //   958: invokevirtual 3312	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   961: aload_0
    //   962: invokevirtual 1578	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJa	()Landroid/view/View;
    //   965: invokevirtual 1581	android/view/View:isEnabled	()Z
    //   968: ifne +1605 -> 2573
    //   971: aload_0
    //   972: invokespecial 2768	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJb	()Landroid/view/View;
    //   975: iconst_0
    //   976: invokevirtual 1381	android/view/View:setVisibility	(I)V
    //   979: aload_0
    //   980: invokespecial 2768	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJb	()Landroid/view/View;
    //   983: new 4738	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda16
    //   986: dup
    //   987: aload_0
    //   988: invokespecial 4739	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda16:<init>	(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity;)V
    //   991: invokevirtual 3312	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   994: aload_0
    //   995: invokespecial 4741	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hII	()Landroid/view/View;
    //   998: new 4743	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda10
    //   1001: dup
    //   1002: aload_0
    //   1003: invokespecial 4744	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda10:<init>	(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity;)V
    //   1006: invokevirtual 3312	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1009: aload_0
    //   1010: invokespecial 1407	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hIV	()Landroid/widget/ImageView;
    //   1013: new 4746	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda20
    //   1016: dup
    //   1017: aload_0
    //   1018: invokespecial 4747	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda20:<init>	(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity;)V
    //   1021: invokevirtual 4748	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1024: aload_0
    //   1025: invokespecial 3870	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJG	()V
    //   1028: aload_0
    //   1029: getfield 2799	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Txn	Lcom/tencent/mm/plugin/textstatus/a/w;
    //   1032: astore_1
    //   1033: aload_1
    //   1034: ifnonnull +1551 -> 2585
    //   1037: iconst_1
    //   1038: istore_3
    //   1039: aload_0
    //   1040: getfield 2547	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:niy	I
    //   1043: ifne +1560 -> 2603
    //   1046: aload_0
    //   1047: invokespecial 2113	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hHr	()Lcom/tencent/mm/plugin/textstatus/a/e;
    //   1050: astore_1
    //   1051: aload_1
    //   1052: ifnull +1541 -> 2593
    //   1055: aload_1
    //   1056: invokevirtual 2118	com/tencent/mm/plugin/textstatus/a/e:hFt	()Z
    //   1059: iconst_1
    //   1060: if_icmpne +1533 -> 2593
    //   1063: iconst_1
    //   1064: istore_2
    //   1065: iload_2
    //   1066: ifeq +1537 -> 2603
    //   1069: aload_0
    //   1070: invokespecial 2113	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hHr	()Lcom/tencent/mm/plugin/textstatus/a/e;
    //   1073: astore_1
    //   1074: aload_1
    //   1075: ifnull +1523 -> 2598
    //   1078: aload_1
    //   1079: invokevirtual 2121	com/tencent/mm/plugin/textstatus/a/e:etQ	()Z
    //   1082: iconst_1
    //   1083: if_icmpne +1515 -> 2598
    //   1086: iconst_1
    //   1087: istore_2
    //   1088: iload_2
    //   1089: ifeq +1514 -> 2603
    //   1092: iconst_1
    //   1093: istore_2
    //   1094: iload_2
    //   1095: ifne +7 -> 1102
    //   1098: iload_3
    //   1099: ifne +1509 -> 2608
    //   1102: aload_0
    //   1103: invokespecial 4750	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hIL	()Landroid/view/View;
    //   1106: bipush 8
    //   1108: invokevirtual 1381	android/view/View:setVisibility	(I)V
    //   1111: aload_0
    //   1112: invokespecial 4752	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hIM	()Landroid/view/View;
    //   1115: iconst_0
    //   1116: invokevirtual 1381	android/view/View:setVisibility	(I)V
    //   1119: aload_0
    //   1120: invokespecial 3941	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJp	()V
    //   1123: aload_0
    //   1124: invokespecial 1131	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJm	()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;
    //   1127: getfield 2975	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:description	Ljava/lang/String;
    //   1130: astore_1
    //   1131: aload_0
    //   1132: invokevirtual 1360	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hIP	()Lcom/tencent/mm/ui/widget/MMEditText;
    //   1135: aload_0
    //   1136: checkcast 1212	android/content/Context
    //   1139: aload_1
    //   1140: checkcast 1669	java/lang/CharSequence
    //   1143: invokestatic 4757	com/tencent/mm/pluginsdk/ui/span/p:b	(Landroid/content/Context;Ljava/lang/CharSequence;)Landroid/text/SpannableString;
    //   1146: checkcast 1669	java/lang/CharSequence
    //   1149: invokevirtual 4758	com/tencent/mm/ui/widget/MMEditText:setText	(Ljava/lang/CharSequence;)V
    //   1152: aload_1
    //   1153: checkcast 1669	java/lang/CharSequence
    //   1156: invokestatic 2514	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1159: ifne +17 -> 1176
    //   1162: aload_0
    //   1163: invokevirtual 1360	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hIP	()Lcom/tencent/mm/ui/widget/MMEditText;
    //   1166: aload_0
    //   1167: invokevirtual 1360	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hIP	()Lcom/tencent/mm/ui/widget/MMEditText;
    //   1170: invokevirtual 4759	com/tencent/mm/ui/widget/MMEditText:length	()I
    //   1173: invokevirtual 4762	com/tencent/mm/ui/widget/MMEditText:setSelection	(I)V
    //   1176: getstatic 1468	com/tencent/mm/plugin/secdata/ui/a:PlI	Lcom/tencent/mm/plugin/secdata/ui/a$a;
    //   1179: astore 5
    //   1181: aload_0
    //   1182: checkcast 1212	android/content/Context
    //   1185: bipush 8
    //   1187: ldc_w 1470
    //   1190: invokestatic 1475	com/tencent/mm/plugin/secdata/ui/a$a:a	(Landroid/content/Context;ILjava/lang/Class;)Lcom/tencent/mm/bx/a;
    //   1193: checkcast 1470	com/tencent/mm/plugin/textstatus/proto/bh
    //   1196: astore 5
    //   1198: aload 5
    //   1200: ifnull +9 -> 1209
    //   1203: aload 5
    //   1205: aload_1
    //   1206: putfield 3236	com/tencent/mm/plugin/textstatus/proto/bh:TqW	Ljava/lang/String;
    //   1209: aload_0
    //   1210: invokespecial 1131	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJm	()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;
    //   1213: getfield 3054	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:emojiInfo	Lcom/tencent/mm/plugin/textstatus/proto/TextStatusEmojiInfo;
    //   1216: astore 9
    //   1218: aload 9
    //   1220: ifnull +77 -> 1297
    //   1223: aload 9
    //   1225: getfield 3011	com/tencent/mm/plugin/textstatus/proto/TextStatusEmojiInfo:Md5	Ljava/lang/String;
    //   1228: checkcast 1669	java/lang/CharSequence
    //   1231: astore_1
    //   1232: aload_1
    //   1233: ifnull +10 -> 1243
    //   1236: aload_1
    //   1237: invokestatic 2109	kotlin/n/n:bp	(Ljava/lang/CharSequence;)Z
    //   1240: ifeq +1388 -> 2628
    //   1243: iconst_1
    //   1244: istore_2
    //   1245: iload_2
    //   1246: ifne +51 -> 1297
    //   1249: aload_0
    //   1250: invokevirtual 1360	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hIP	()Lcom/tencent/mm/ui/widget/MMEditText;
    //   1253: ldc_w 1088
    //   1256: checkcast 1669	java/lang/CharSequence
    //   1259: invokevirtual 4758	com/tencent/mm/ui/widget/MMEditText:setText	(Ljava/lang/CharSequence;)V
    //   1262: invokestatic 4768	com/tencent/mm/storage/bl:jba	()Lcom/tencent/mm/storage/bl;
    //   1265: getfield 4772	com/tencent/mm/storage/bl:adju	Lcom/tencent/mm/storage/emotion/f;
    //   1268: aload 9
    //   1270: getfield 3011	com/tencent/mm/plugin/textstatus/proto/TextStatusEmojiInfo:Md5	Ljava/lang/String;
    //   1273: invokevirtual 4778	com/tencent/mm/storage/emotion/f:bza	(Ljava/lang/String;)Lcom/tencent/mm/storage/emotion/EmojiInfo;
    //   1276: astore 5
    //   1278: aload 5
    //   1280: astore_1
    //   1281: aload 5
    //   1283: ifnonnull +9 -> 1292
    //   1286: aload 9
    //   1288: invokestatic 4783	com/tencent/mm/plugin/textstatus/d/a/a:a	(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusEmojiInfo;)Lcom/tencent/mm/storage/emotion/EmojiInfo;
    //   1291: astore_1
    //   1292: aload_0
    //   1293: aload_1
    //   1294: invokevirtual 4785	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:D	(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V
    //   1297: aload_0
    //   1298: invokespecial 1225	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJD	()V
    //   1301: aload_0
    //   1302: invokespecial 4445	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJA	()V
    //   1305: aload_0
    //   1306: getfield 2547	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:niy	I
    //   1309: iconst_1
    //   1310: if_icmpne +129 -> 1439
    //   1313: getstatic 2991	com/tencent/mm/plugin/textstatus/b/f:TjQ	Lcom/tencent/mm/plugin/textstatus/b/f;
    //   1316: astore_1
    //   1317: aload_0
    //   1318: getfield 2799	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Txn	Lcom/tencent/mm/plugin/textstatus/a/w;
    //   1321: astore_1
    //   1322: aload_1
    //   1323: ifnonnull +1310 -> 2633
    //   1326: aconst_null
    //   1327: astore_1
    //   1328: aload_1
    //   1329: invokestatic 2995	com/tencent/mm/plugin/textstatus/b/f:bdN	(Ljava/lang/String;)Lcom/tencent/mm/plugin/textstatus/h/f/b;
    //   1332: astore_1
    //   1333: aload_1
    //   1334: ifnonnull +1307 -> 2641
    //   1337: aconst_null
    //   1338: astore_1
    //   1339: aload_1
    //   1340: checkcast 1669	java/lang/CharSequence
    //   1343: invokestatic 2514	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1346: ifne +93 -> 1439
    //   1349: aload_1
    //   1350: ifnull +89 -> 1439
    //   1353: new 1621	org/json/JSONObject
    //   1356: dup
    //   1357: aload_1
    //   1358: invokespecial 4786	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1361: astore_1
    //   1362: aload_0
    //   1363: aload_1
    //   1364: ldc_w 2287
    //   1367: invokevirtual 4789	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1370: putfield 2289	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:RiP	I
    //   1373: aload_1
    //   1374: ldc_w 2293
    //   1377: invokevirtual 4792	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1380: astore 5
    //   1382: aload 5
    //   1384: ldc_w 4794
    //   1387: invokestatic 1210	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1390: aload_0
    //   1391: aload 5
    //   1393: putfield 1090	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:RiR	Ljava/lang/String;
    //   1396: aload_1
    //   1397: ldc_w 2294
    //   1400: invokevirtual 4792	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1403: astore 5
    //   1405: aload 5
    //   1407: ldc_w 4796
    //   1410: invokestatic 1210	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1413: aload_0
    //   1414: aload 5
    //   1416: putfield 1092	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:RiS	Ljava/lang/String;
    //   1419: aload_1
    //   1420: ldc_w 2295
    //   1423: invokevirtual 4792	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1426: astore_1
    //   1427: aload_1
    //   1428: ldc_w 4798
    //   1431: invokestatic 1210	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1434: aload_0
    //   1435: aload_1
    //   1436: putfield 1094	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:RiT	Ljava/lang/String;
    //   1439: aload_0
    //   1440: invokespecial 4449	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJz	()V
    //   1443: aload_0
    //   1444: aload_0
    //   1445: getfield 2289	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:RiP	I
    //   1448: invokespecial 4451	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:aov	(I)V
    //   1451: aload_0
    //   1452: getfield 2547	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:niy	I
    //   1455: tableswitch	default:+25 -> 1480, 0:+1194->2649, 1:+1894->3349, 2:+1929->3384
    //   1481: invokespecial 4741	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hII	()Landroid/view/View;
    //   1484: invokevirtual 2024	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1487: astore_1
    //   1488: aload_1
    //   1489: ifnonnull +1930 -> 3419
    //   1492: new 1528	java/lang/NullPointerException
    //   1495: dup
    //   1496: ldc_w 2197
    //   1499: invokespecial 1531	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   1502: astore_1
    //   1503: ldc_w 4467
    //   1506: invokestatic 738	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1509: aload_1
    //   1510: athrow
    //   1511: aload_1
    //   1512: getfield 4801	com/tencent/mm/plugin/textstatus/a/w:Too	I
    //   1515: istore_2
    //   1516: goto -894 -> 622
    //   1519: aload_0
    //   1520: getfield 2799	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Txn	Lcom/tencent/mm/plugin/textstatus/a/w;
    //   1523: astore_1
    //   1524: aload_1
    //   1525: ifnonnull +62 -> 1587
    //   1528: aconst_null
    //   1529: astore_1
    //   1530: aload_1
    //   1531: ifnonnull +64 -> 1595
    //   1534: new 1133	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo
    //   1537: dup
    //   1538: invokespecial 4689	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:<init>	()V
    //   1541: astore_1
    //   1542: aload_1
    //   1543: getfield 2569	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:topicInfo	Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;
    //   1546: astore 5
    //   1548: aload 5
    //   1550: ifnonnull +48 -> 1598
    //   1553: aconst_null
    //   1554: astore 5
    //   1556: aload 5
    //   1558: checkcast 1669	java/lang/CharSequence
    //   1561: invokestatic 2514	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1564: ifeq +44 -> 1608
    //   1567: iconst_1
    //   1568: istore_2
    //   1569: aload_1
    //   1570: iload_2
    //   1571: putfield 4804	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:sceneType	I
    //   1574: aload_1
    //   1575: iconst_0
    //   1576: putfield 1136	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:createTime	I
    //   1579: getstatic 2653	kotlin/ah:aiuX	Lkotlin/ah;
    //   1582: astore 5
    //   1584: goto -920 -> 664
    //   1587: aload_1
    //   1588: getfield 4282	com/tencent/mm/plugin/textstatus/a/w:Tog	Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;
    //   1591: astore_1
    //   1592: goto -62 -> 1530
    //   1595: goto -53 -> 1542
    //   1598: aload 5
    //   1600: getfield 2103	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceId	Ljava/lang/String;
    //   1603: astore 5
    //   1605: goto -49 -> 1556
    //   1608: iconst_2
    //   1609: istore_2
    //   1610: goto -41 -> 1569
    //   1613: aload_0
    //   1614: getfield 2799	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Txn	Lcom/tencent/mm/plugin/textstatus/a/w;
    //   1617: astore_1
    //   1618: aload_1
    //   1619: ifnonnull +243 -> 1862
    //   1622: aconst_null
    //   1623: astore_1
    //   1624: getstatic 2991	com/tencent/mm/plugin/textstatus/b/f:TjQ	Lcom/tencent/mm/plugin/textstatus/b/f;
    //   1627: astore 5
    //   1629: aload_1
    //   1630: invokestatic 2995	com/tencent/mm/plugin/textstatus/b/f:bdN	(Ljava/lang/String;)Lcom/tencent/mm/plugin/textstatus/h/f/b;
    //   1633: astore_1
    //   1634: aload_1
    //   1635: ifnonnull +235 -> 1870
    //   1638: aconst_null
    //   1639: astore_1
    //   1640: new 1133	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo
    //   1643: dup
    //   1644: invokespecial 4689	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:<init>	()V
    //   1647: astore 5
    //   1649: aload_1
    //   1650: ifnull +202 -> 1852
    //   1653: aload 5
    //   1655: aload_1
    //   1656: getfield 4807	com/tencent/mm/plugin/textstatus/h/f/b:field_Longitude	D
    //   1659: putfield 3502	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:longitude	D
    //   1662: aload 5
    //   1664: aload_1
    //   1665: getfield 4810	com/tencent/mm/plugin/textstatus/h/f/b:field_Latitude	D
    //   1668: putfield 3494	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:latitude	D
    //   1671: aload 5
    //   1673: aload_1
    //   1674: getfield 4813	com/tencent/mm/plugin/textstatus/h/f/b:field_MediaType	I
    //   1677: putfield 2946	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:mediaType	I
    //   1680: aload 5
    //   1682: aload_1
    //   1683: iconst_1
    //   1684: invokevirtual 4817	com/tencent/mm/plugin/textstatus/h/f/b:Fz	(Z)Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;
    //   1687: putfield 2569	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:topicInfo	Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;
    //   1690: aload 5
    //   1692: aload_1
    //   1693: getfield 4820	com/tencent/mm/plugin/textstatus/h/f/b:field_MediaUrl	Ljava/lang/String;
    //   1696: putfield 2797	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:mediaUrl	Ljava/lang/String;
    //   1699: aload 5
    //   1701: aload_1
    //   1702: getfield 4823	com/tencent/mm/plugin/textstatus/h/f/b:field_MediaAESKey	Ljava/lang/String;
    //   1705: putfield 4826	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:mediaAesKey	Ljava/lang/String;
    //   1708: aload 5
    //   1710: aload_1
    //   1711: getfield 4829	com/tencent/mm/plugin/textstatus/h/f/b:field_MediaThumbUrl	Ljava/lang/String;
    //   1714: putfield 2794	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:mediaThumbUrl	Ljava/lang/String;
    //   1717: aload 5
    //   1719: aload_1
    //   1720: getfield 4832	com/tencent/mm/plugin/textstatus/h/f/b:field_MediaThumbAESKey	Ljava/lang/String;
    //   1723: putfield 4835	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:mediaThumbAesKey	Ljava/lang/String;
    //   1726: aload 5
    //   1728: aload_1
    //   1729: getfield 4838	com/tencent/mm/plugin/textstatus/h/f/b:field_Visibility	I
    //   1732: putfield 2972	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:visibility	I
    //   1735: aload 5
    //   1737: aload_1
    //   1738: getfield 4841	com/tencent/mm/plugin/textstatus/h/f/b:field_Description	Ljava/lang/String;
    //   1741: putfield 2975	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:description	Ljava/lang/String;
    //   1744: aload 5
    //   1746: aload_1
    //   1747: getfield 4844	com/tencent/mm/plugin/textstatus/h/f/b:field_CreateTime	I
    //   1750: putfield 1136	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:createTime	I
    //   1753: aload 5
    //   1755: aload_1
    //   1756: getfield 4847	com/tencent/mm/plugin/textstatus/h/f/b:field_ExpireTime	I
    //   1759: putfield 2979	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:expireTime	I
    //   1762: aload 5
    //   1764: aload_1
    //   1765: getfield 4850	com/tencent/mm/plugin/textstatus/h/f/b:field_PoiID	Ljava/lang/String;
    //   1768: putfield 3487	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:poiId	Ljava/lang/String;
    //   1771: aload 5
    //   1773: aload_1
    //   1774: getfield 4853	com/tencent/mm/plugin/textstatus/h/f/b:field_PoiName	Ljava/lang/String;
    //   1777: putfield 2749	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:poiName	Ljava/lang/String;
    //   1780: aload_1
    //   1781: getfield 4857	com/tencent/mm/plugin/textstatus/h/f/b:field_option	Ljava/lang/Long;
    //   1784: astore 9
    //   1786: aload 9
    //   1788: ldc_w 4859
    //   1791: invokestatic 1210	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1794: aload 5
    //   1796: aload 9
    //   1798: checkcast 4391	java/lang/Number
    //   1801: invokevirtual 4394	java/lang/Number:longValue	()J
    //   1804: putfield 3961	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:option	J
    //   1807: aload 5
    //   1809: aload_1
    //   1810: getfield 4862	com/tencent/mm/plugin/textstatus/h/f/b:field_mediaWidth	I
    //   1813: putfield 3126	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:mediaWidth	I
    //   1816: aload 5
    //   1818: aload_1
    //   1819: getfield 4865	com/tencent/mm/plugin/textstatus/h/f/b:field_mediaHeight	I
    //   1822: putfield 3129	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:mediaHeight	I
    //   1825: aload 5
    //   1827: aload_1
    //   1828: getfield 4868	com/tencent/mm/plugin/textstatus/h/f/b:field_backgroundId	Ljava/lang/String;
    //   1831: putfield 2985	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:backgroundId	Ljava/lang/String;
    //   1834: aload 5
    //   1836: aload_1
    //   1837: getfield 4871	com/tencent/mm/plugin/textstatus/h/f/b:field_sceneType	I
    //   1840: putfield 4804	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:sceneType	I
    //   1843: aload 5
    //   1845: aload_1
    //   1846: invokevirtual 4875	com/tencent/mm/plugin/textstatus/h/f/b:hHD	()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusEmojiInfo;
    //   1849: putfield 3054	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:emojiInfo	Lcom/tencent/mm/plugin/textstatus/proto/TextStatusEmojiInfo;
    //   1852: getstatic 2653	kotlin/ah:aiuX	Lkotlin/ah;
    //   1855: astore_1
    //   1856: aload 5
    //   1858: astore_1
    //   1859: goto -1195 -> 664
    //   1862: aload_1
    //   1863: getfield 3148	com/tencent/mm/plugin/textstatus/a/w:Top	Ljava/lang/String;
    //   1866: astore_1
    //   1867: goto -243 -> 1624
    //   1870: aload_1
    //   1871: invokevirtual 4879	com/tencent/mm/plugin/textstatus/h/f/b:hHJ	()Lcom/tencent/mm/plugin/textstatus/h/f/b;
    //   1874: astore_1
    //   1875: goto -235 -> 1640
    //   1878: aload_0
    //   1879: getfield 2799	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Txn	Lcom/tencent/mm/plugin/textstatus/a/w;
    //   1882: astore_1
    //   1883: aload_1
    //   1884: ifnonnull +509 -> 2393
    //   1887: aconst_null
    //   1888: astore 5
    //   1890: getstatic 2991	com/tencent/mm/plugin/textstatus/b/f:TjQ	Lcom/tencent/mm/plugin/textstatus/b/f;
    //   1893: astore_1
    //   1894: aload 5
    //   1896: invokestatic 2995	com/tencent/mm/plugin/textstatus/b/f:bdN	(Ljava/lang/String;)Lcom/tencent/mm/plugin/textstatus/h/f/b;
    //   1899: astore 10
    //   1901: new 1133	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo
    //   1904: dup
    //   1905: invokespecial 4689	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:<init>	()V
    //   1908: astore 9
    //   1910: aload 10
    //   1912: ifnull +411 -> 2323
    //   1915: aload 9
    //   1917: aload 10
    //   1919: getfield 4813	com/tencent/mm/plugin/textstatus/h/f/b:field_MediaType	I
    //   1922: putfield 2946	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:mediaType	I
    //   1925: aload 9
    //   1927: aload 10
    //   1929: getfield 4820	com/tencent/mm/plugin/textstatus/h/f/b:field_MediaUrl	Ljava/lang/String;
    //   1932: putfield 2797	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:mediaUrl	Ljava/lang/String;
    //   1935: aload 9
    //   1937: aload 10
    //   1939: getfield 4823	com/tencent/mm/plugin/textstatus/h/f/b:field_MediaAESKey	Ljava/lang/String;
    //   1942: putfield 4826	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:mediaAesKey	Ljava/lang/String;
    //   1945: aload 9
    //   1947: aload 10
    //   1949: getfield 4829	com/tencent/mm/plugin/textstatus/h/f/b:field_MediaThumbUrl	Ljava/lang/String;
    //   1952: putfield 2794	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:mediaThumbUrl	Ljava/lang/String;
    //   1955: aload 9
    //   1957: aload 10
    //   1959: getfield 4832	com/tencent/mm/plugin/textstatus/h/f/b:field_MediaThumbAESKey	Ljava/lang/String;
    //   1962: putfield 4835	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:mediaThumbAesKey	Ljava/lang/String;
    //   1965: aload 9
    //   1967: aload 10
    //   1969: getfield 4857	com/tencent/mm/plugin/textstatus/h/f/b:field_option	Ljava/lang/Long;
    //   1972: invokevirtual 4880	java/lang/Long:longValue	()J
    //   1975: lconst_1
    //   1976: land
    //   1977: putfield 3961	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:option	J
    //   1980: aload 9
    //   1982: aload 10
    //   1984: getfield 4862	com/tencent/mm/plugin/textstatus/h/f/b:field_mediaWidth	I
    //   1987: putfield 3126	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:mediaWidth	I
    //   1990: aload 9
    //   1992: aload 10
    //   1994: getfield 4865	com/tencent/mm/plugin/textstatus/h/f/b:field_mediaHeight	I
    //   1997: putfield 3129	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:mediaHeight	I
    //   2000: aload 10
    //   2002: invokestatic 4883	com/tencent/mm/plugin/textstatus/h/f/b:b	(Lcom/tencent/mm/plugin/textstatus/h/f/b;)Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;
    //   2005: astore 11
    //   2007: new 2102	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo
    //   2010: dup
    //   2011: invokespecial 2647	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:<init>	()V
    //   2014: astore 12
    //   2016: aload 12
    //   2018: ldc_w 2100
    //   2021: invokestatic 1234	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   2024: aload 11
    //   2026: ldc_w 4884
    //   2029: invokestatic 1234	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   2032: getstatic 1145	com/tencent/mm/plugin/textstatus/third/i:TuX	Lcom/tencent/mm/plugin/textstatus/third/i;
    //   2035: astore_1
    //   2036: invokestatic 2641	com/tencent/mm/plugin/textstatus/third/i:hIb	()Lcom/tencent/mm/plugin/textstatus/a/e;
    //   2039: astore 13
    //   2041: aload 13
    //   2043: ifnull +25 -> 2068
    //   2046: aload 13
    //   2048: aconst_null
    //   2049: aload 11
    //   2051: getfield 2133	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceJumpInfos	Ljava/util/LinkedList;
    //   2054: checkcast 2643	java/util/List
    //   2057: aload 11
    //   2059: getfield 2138	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:jumpInfos	Ljava/util/LinkedList;
    //   2062: checkcast 2643	java/util/List
    //   2065: invokevirtual 2646	com/tencent/mm/plugin/textstatus/a/e:d	(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V
    //   2068: aload 13
    //   2070: ifnull +332 -> 2402
    //   2073: aload 13
    //   2075: invokevirtual 2118	com/tencent/mm/plugin/textstatus/a/e:hFt	()Z
    //   2078: iconst_1
    //   2079: if_icmpne +323 -> 2402
    //   2082: iconst_1
    //   2083: istore_2
    //   2084: iload_2
    //   2085: ifeq +87 -> 2172
    //   2088: aload 13
    //   2090: ifnonnull +317 -> 2407
    //   2093: aconst_null
    //   2094: astore_1
    //   2095: aload_1
    //   2096: invokevirtual 4887	java/lang/Boolean:booleanValue	()Z
    //   2099: ifeq +73 -> 2172
    //   2102: aload 12
    //   2104: aload 11
    //   2106: getfield 2103	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceId	Ljava/lang/String;
    //   2109: putfield 2103	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceId	Ljava/lang/String;
    //   2112: aload 12
    //   2114: aload 11
    //   2116: getfield 2127	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceActivityId	Ljava/lang/String;
    //   2119: putfield 2127	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceActivityId	Ljava/lang/String;
    //   2122: aload 12
    //   2124: aload 11
    //   2126: getfield 2124	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceName	Ljava/lang/String;
    //   2129: putfield 2124	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceName	Ljava/lang/String;
    //   2132: aload 12
    //   2134: aload 11
    //   2136: getfield 2130	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceIcon	Ljava/lang/String;
    //   2139: putfield 2130	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceIcon	Ljava/lang/String;
    //   2142: aload 12
    //   2144: aload 11
    //   2146: getfield 2138	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:jumpInfos	Ljava/util/LinkedList;
    //   2149: putfield 2138	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:jumpInfos	Ljava/util/LinkedList;
    //   2152: aload 12
    //   2154: aload 11
    //   2156: getfield 2136	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:verifyInfo	Ljava/lang/String;
    //   2159: putfield 2136	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:verifyInfo	Ljava/lang/String;
    //   2162: aload 12
    //   2164: aload 11
    //   2166: getfield 2133	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceJumpInfos	Ljava/util/LinkedList;
    //   2169: putfield 2133	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceJumpInfos	Ljava/util/LinkedList;
    //   2172: aload 13
    //   2174: ifnull +245 -> 2419
    //   2177: aload 13
    //   2179: invokevirtual 2118	com/tencent/mm/plugin/textstatus/a/e:hFt	()Z
    //   2182: ifne +237 -> 2419
    //   2185: iconst_1
    //   2186: istore_2
    //   2187: iload_2
    //   2188: ifeq +91 -> 2279
    //   2191: aload 13
    //   2193: ifnonnull +231 -> 2424
    //   2196: aconst_null
    //   2197: astore_1
    //   2198: aload_1
    //   2199: invokevirtual 4887	java/lang/Boolean:booleanValue	()Z
    //   2202: ifeq +77 -> 2279
    //   2205: aload 13
    //   2207: ifnonnull +229 -> 2436
    //   2210: aconst_null
    //   2211: astore_1
    //   2212: aload_1
    //   2213: ifnull +66 -> 2279
    //   2216: aload 12
    //   2218: aload_1
    //   2219: getfield 2103	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceId	Ljava/lang/String;
    //   2222: putfield 2103	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceId	Ljava/lang/String;
    //   2225: aload 12
    //   2227: aload_1
    //   2228: getfield 2127	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceActivityId	Ljava/lang/String;
    //   2231: putfield 2127	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceActivityId	Ljava/lang/String;
    //   2234: aload 12
    //   2236: aload_1
    //   2237: getfield 2124	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceName	Ljava/lang/String;
    //   2240: putfield 2124	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceName	Ljava/lang/String;
    //   2243: aload 12
    //   2245: aload_1
    //   2246: getfield 2130	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceIcon	Ljava/lang/String;
    //   2249: putfield 2130	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceIcon	Ljava/lang/String;
    //   2252: aload 12
    //   2254: aload_1
    //   2255: getfield 2138	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:jumpInfos	Ljava/util/LinkedList;
    //   2258: putfield 2138	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:jumpInfos	Ljava/util/LinkedList;
    //   2261: aload 12
    //   2263: aload_1
    //   2264: getfield 2136	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:verifyInfo	Ljava/lang/String;
    //   2267: putfield 2136	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:verifyInfo	Ljava/lang/String;
    //   2270: aload 12
    //   2272: aload_1
    //   2273: getfield 2133	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceJumpInfos	Ljava/util/LinkedList;
    //   2276: putfield 2133	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceJumpInfos	Ljava/util/LinkedList;
    //   2279: aload_0
    //   2280: getfield 2799	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Txn	Lcom/tencent/mm/plugin/textstatus/a/w;
    //   2283: astore_1
    //   2284: aload_1
    //   2285: ifnonnull +188 -> 2473
    //   2288: aconst_null
    //   2289: astore_1
    //   2290: aload 12
    //   2292: aload_1
    //   2293: putfield 2858	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:iconId	Ljava/lang/String;
    //   2296: aload 12
    //   2298: aload 11
    //   2300: getfield 2572	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:title	Ljava/lang/String;
    //   2303: putfield 2572	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:title	Ljava/lang/String;
    //   2306: aload 9
    //   2308: aload 12
    //   2310: putfield 2569	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:topicInfo	Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;
    //   2313: aload 9
    //   2315: aload 10
    //   2317: getfield 4871	com/tencent/mm/plugin/textstatus/h/f/b:field_sceneType	I
    //   2320: putfield 4804	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:sceneType	I
    //   2323: getstatic 1468	com/tencent/mm/plugin/secdata/ui/a:PlI	Lcom/tencent/mm/plugin/secdata/ui/a$a;
    //   2326: astore_1
    //   2327: aload_0
    //   2328: checkcast 1212	android/content/Context
    //   2331: bipush 8
    //   2333: ldc_w 1470
    //   2336: invokestatic 1475	com/tencent/mm/plugin/secdata/ui/a$a:a	(Landroid/content/Context;ILjava/lang/Class;)Lcom/tencent/mm/bx/a;
    //   2339: checkcast 1470	com/tencent/mm/plugin/textstatus/proto/bh
    //   2342: astore 11
    //   2344: aload 11
    //   2346: ifnull +23 -> 2369
    //   2349: aload 10
    //   2351: ifnonnull +158 -> 2509
    //   2354: aconst_null
    //   2355: astore_1
    //   2356: aload 11
    //   2358: aload_1
    //   2359: putfield 4890	com/tencent/mm/plugin/textstatus/proto/bh:TqY	Ljava/lang/String;
    //   2362: aload 11
    //   2364: aload 5
    //   2366: putfield 4893	com/tencent/mm/plugin/textstatus/proto/bh:TqX	Ljava/lang/String;
    //   2369: aload 9
    //   2371: getfield 2946	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:mediaType	I
    //   2374: ifeq +9 -> 2383
    //   2377: aload 9
    //   2379: iconst_1
    //   2380: invokestatic 3445	com/tencent/mm/plugin/textstatus/d/a:a	(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;Z)V
    //   2383: getstatic 2653	kotlin/ah:aiuX	Lkotlin/ah;
    //   2386: astore_1
    //   2387: aload 9
    //   2389: astore_1
    //   2390: goto -1726 -> 664
    //   2393: aload_1
    //   2394: getfield 3148	com/tencent/mm/plugin/textstatus/a/w:Top	Ljava/lang/String;
    //   2397: astore 5
    //   2399: goto -509 -> 1890
    //   2402: iconst_0
    //   2403: istore_2
    //   2404: goto -320 -> 2084
    //   2407: aload 13
    //   2409: invokevirtual 2121	com/tencent/mm/plugin/textstatus/a/e:etQ	()Z
    //   2412: invokestatic 3818	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2415: astore_1
    //   2416: goto -321 -> 2095
    //   2419: iconst_0
    //   2420: istore_2
    //   2421: goto -234 -> 2187
    //   2424: aload 13
    //   2426: invokevirtual 2121	com/tencent/mm/plugin/textstatus/a/e:etQ	()Z
    //   2429: invokestatic 3818	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2432: astore_1
    //   2433: goto -235 -> 2198
    //   2436: aload 13
    //   2438: invokevirtual 4897	com/tencent/mm/plugin/textstatus/a/e:eKW	()Lcom/tencent/mm/plugin/textstatus/a/w;
    //   2441: astore_1
    //   2442: aload_1
    //   2443: ifnonnull +8 -> 2451
    //   2446: aconst_null
    //   2447: astore_1
    //   2448: goto -236 -> 2212
    //   2451: aload_1
    //   2452: getfield 4282	com/tencent/mm/plugin/textstatus/a/w:Tog	Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;
    //   2455: astore_1
    //   2456: aload_1
    //   2457: ifnonnull +8 -> 2465
    //   2460: aconst_null
    //   2461: astore_1
    //   2462: goto -250 -> 2212
    //   2465: aload_1
    //   2466: getfield 2569	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:topicInfo	Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;
    //   2469: astore_1
    //   2470: goto -258 -> 2212
    //   2473: aload_1
    //   2474: getfield 4282	com/tencent/mm/plugin/textstatus/a/w:Tog	Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;
    //   2477: astore_1
    //   2478: aload_1
    //   2479: ifnonnull +8 -> 2487
    //   2482: aconst_null
    //   2483: astore_1
    //   2484: goto -194 -> 2290
    //   2487: aload_1
    //   2488: getfield 2569	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:topicInfo	Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;
    //   2491: astore_1
    //   2492: aload_1
    //   2493: ifnonnull +8 -> 2501
    //   2496: aconst_null
    //   2497: astore_1
    //   2498: goto -208 -> 2290
    //   2501: aload_1
    //   2502: getfield 2858	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:iconId	Ljava/lang/String;
    //   2505: astore_1
    //   2506: goto -216 -> 2290
    //   2509: aload 10
    //   2511: getfield 3156	com/tencent/mm/plugin/textstatus/h/f/b:field_StatusID	Ljava/lang/String;
    //   2514: astore_1
    //   2515: goto -159 -> 2356
    //   2518: aload_0
    //   2519: getfield 2799	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Txn	Lcom/tencent/mm/plugin/textstatus/a/w;
    //   2522: astore_1
    //   2523: aload_1
    //   2524: ifnull -1762 -> 762
    //   2527: aload_1
    //   2528: getfield 4282	com/tencent/mm/plugin/textstatus/a/w:Tog	Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;
    //   2531: astore_1
    //   2532: aload_1
    //   2533: ifnull -1771 -> 762
    //   2536: aload_1
    //   2537: getfield 2985	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:backgroundId	Ljava/lang/String;
    //   2540: astore_1
    //   2541: aload_1
    //   2542: ifnull -1780 -> 762
    //   2545: getstatic 1050	com/tencent/mm/plugin/textstatus/util/k:TBx	Lcom/tencent/mm/plugin/textstatus/util/k;
    //   2548: astore 5
    //   2550: aload_0
    //   2551: aload_1
    //   2552: invokestatic 4696	com/tencent/mm/plugin/textstatus/util/k:bep	(Ljava/lang/String;)I
    //   2555: putfield 1055	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Tyy	I
    //   2558: goto -1796 -> 762
    //   2561: aload 5
    //   2563: aload_1
    //   2564: getfield 4727	com/tencent/mm/plugin/textstatus/a/w:enterTime	J
    //   2567: putfield 4571	com/tencent/mm/plugin/textstatus/proto/bh:enterTime	J
    //   2570: goto -1644 -> 926
    //   2573: aload_0
    //   2574: invokespecial 2768	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJb	()Landroid/view/View;
    //   2577: bipush 8
    //   2579: invokevirtual 1381	android/view/View:setVisibility	(I)V
    //   2582: goto -1603 -> 979
    //   2585: aload_1
    //   2586: getfield 4900	com/tencent/mm/plugin/textstatus/a/w:Toh	Z
    //   2589: istore_3
    //   2590: goto -1551 -> 1039
    //   2593: iconst_0
    //   2594: istore_2
    //   2595: goto -1530 -> 1065
    //   2598: iconst_0
    //   2599: istore_2
    //   2600: goto -1512 -> 1088
    //   2603: iconst_0
    //   2604: istore_2
    //   2605: goto -1511 -> 1094
    //   2608: aload_0
    //   2609: invokespecial 4750	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hIL	()Landroid/view/View;
    //   2612: iconst_0
    //   2613: invokevirtual 1381	android/view/View:setVisibility	(I)V
    //   2616: aload_0
    //   2617: invokespecial 4752	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hIM	()Landroid/view/View;
    //   2620: bipush 8
    //   2622: invokevirtual 1381	android/view/View:setVisibility	(I)V
    //   2625: goto -1506 -> 1119
    //   2628: iconst_0
    //   2629: istore_2
    //   2630: goto -1385 -> 1245
    //   2633: aload_1
    //   2634: getfield 3148	com/tencent/mm/plugin/textstatus/a/w:Top	Ljava/lang/String;
    //   2637: astore_1
    //   2638: goto -1310 -> 1328
    //   2641: aload_1
    //   2642: getfield 4903	com/tencent/mm/plugin/textstatus/h/f/b:field_visibilityInfo	Ljava/lang/String;
    //   2645: astore_1
    //   2646: goto -1307 -> 1339
    //   2649: aload_0
    //   2650: getfield 2799	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Txn	Lcom/tencent/mm/plugin/textstatus/a/w;
    //   2653: astore_1
    //   2654: aload_1
    //   2655: ifnull +252 -> 2907
    //   2658: aload_1
    //   2659: getfield 4282	com/tencent/mm/plugin/textstatus/a/w:Tog	Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;
    //   2662: astore_1
    //   2663: aload_1
    //   2664: ifnull +243 -> 2907
    //   2667: aload_1
    //   2668: ldc_w 2100
    //   2671: invokestatic 1234	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   2674: aload_1
    //   2675: getfield 2794	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:mediaThumbUrl	Ljava/lang/String;
    //   2678: checkcast 1669	java/lang/CharSequence
    //   2681: astore 5
    //   2683: aload 5
    //   2685: ifnull +11 -> 2696
    //   2688: aload 5
    //   2690: invokestatic 2109	kotlin/n/n:bp	(Ljava/lang/CharSequence;)Z
    //   2693: ifeq +199 -> 2892
    //   2696: iconst_1
    //   2697: istore_2
    //   2698: iload_2
    //   2699: ifne +203 -> 2902
    //   2702: aload_1
    //   2703: getfield 2797	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:mediaUrl	Ljava/lang/String;
    //   2706: checkcast 1669	java/lang/CharSequence
    //   2709: astore_1
    //   2710: aload_1
    //   2711: ifnull +10 -> 2721
    //   2714: aload_1
    //   2715: invokestatic 2109	kotlin/n/n:bp	(Ljava/lang/CharSequence;)Z
    //   2718: ifeq +179 -> 2897
    //   2721: iconst_1
    //   2722: istore_2
    //   2723: iload_2
    //   2724: ifne +178 -> 2902
    //   2727: iconst_1
    //   2728: istore_2
    //   2729: iload_2
    //   2730: iconst_1
    //   2731: if_icmpne +176 -> 2907
    //   2734: iconst_1
    //   2735: istore_2
    //   2736: iload_2
    //   2737: ifeq +254 -> 2991
    //   2740: aload_0
    //   2741: getfield 2799	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Txn	Lcom/tencent/mm/plugin/textstatus/a/w;
    //   2744: astore_1
    //   2745: aload_1
    //   2746: ifnonnull +166 -> 2912
    //   2749: aconst_null
    //   2750: astore_1
    //   2751: aload_0
    //   2752: invokevirtual 1202	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJK	()Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$d;
    //   2755: astore 5
    //   2757: aload_0
    //   2758: invokevirtual 1153	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   2761: astore 6
    //   2763: aload 6
    //   2765: ldc_w 1204
    //   2768: invokestatic 1210	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   2771: aload 6
    //   2773: checkcast 1212	android/content/Context
    //   2776: ldc_w 1204
    //   2779: invokestatic 1234	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   2782: aload 5
    //   2784: invokevirtual 3448	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$d:reset	()V
    //   2787: aload_1
    //   2788: ifnull +38 -> 2826
    //   2791: aload_1
    //   2792: getfield 2946	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:mediaType	I
    //   2795: istore_2
    //   2796: iload_2
    //   2797: tableswitch	default:+23 -> 2820, 1:+141->2938, 2:+123->2920
    //   2821: iconst_2
    //   2822: iload_2
    //   2823: putfield 2402	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$d:mediaType	I
    //   2826: aload_0
    //   2827: invokevirtual 1202	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJK	()Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$d;
    //   2830: getfield 2400	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$d:TyX	Ljava/lang/String;
    //   2833: checkcast 1669	java/lang/CharSequence
    //   2836: invokestatic 2514	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2839: ifne +117 -> 2956
    //   2842: iconst_1
    //   2843: istore_3
    //   2844: aload_0
    //   2845: aload_0
    //   2846: invokevirtual 1202	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJK	()Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$d;
    //   2849: getfield 2402	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$d:mediaType	I
    //   2852: iload_3
    //   2853: invokespecial 2516	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:bW	(IZ)Z
    //   2856: ifne -1376 -> 1480
    //   2859: aload_1
    //   2860: ifnull +101 -> 2961
    //   2863: aload_1
    //   2864: getfield 2946	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:mediaType	I
    //   2867: iconst_1
    //   2868: if_icmpne +93 -> 2961
    //   2871: iconst_1
    //   2872: istore_2
    //   2873: iload_2
    //   2874: ifeq +92 -> 2966
    //   2877: aload_0
    //   2878: aload_0
    //   2879: invokevirtual 1202	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJK	()Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$d;
    //   2882: getfield 2400	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$d:TyX	Ljava/lang/String;
    //   2885: aconst_null
    //   2886: invokespecial 4905	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$b;)V
    //   2889: goto -1409 -> 1480
    //   2892: iconst_0
    //   2893: istore_2
    //   2894: goto -196 -> 2698
    //   2897: iconst_0
    //   2898: istore_2
    //   2899: goto -176 -> 2723
    //   2902: iconst_0
    //   2903: istore_2
    //   2904: goto -175 -> 2729
    //   2907: iconst_0
    //   2908: istore_2
    //   2909: goto -173 -> 2736
    //   2912: aload_1
    //   2913: getfield 4282	com/tencent/mm/plugin/textstatus/a/w:Tog	Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;
    //   2916: astore_1
    //   2917: goto -166 -> 2751
    //   2920: aload 5
    //   2922: aload_1
    //   2923: getfield 2797	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:mediaUrl	Ljava/lang/String;
    //   2926: putfield 2400	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$d:TyX	Ljava/lang/String;
    //   2929: aload 5
    //   2931: iconst_0
    //   2932: putfield 2944	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$d:Tqk	Z
    //   2935: goto -115 -> 2820
    //   2938: aload 5
    //   2940: aload_1
    //   2941: getfield 2797	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:mediaUrl	Ljava/lang/String;
    //   2944: putfield 2400	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$d:TyX	Ljava/lang/String;
    //   2947: aload 5
    //   2949: iconst_0
    //   2950: putfield 2944	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$d:Tqk	Z
    //   2953: goto -133 -> 2820
    //   2956: iconst_0
    //   2957: istore_3
    //   2958: goto -114 -> 2844
    //   2961: iconst_0
    //   2962: istore_2
    //   2963: goto -90 -> 2873
    //   2966: aload_0
    //   2967: getfield 2518	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TxS	Landroid/view/View;
    //   2970: astore_1
    //   2971: aload_1
    //   2972: ifnull -1492 -> 1480
    //   2975: aload_1
    //   2976: new 4907	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda35
    //   2979: dup
    //   2980: aload_0
    //   2981: invokespecial 4908	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda35:<init>	(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity;)V
    //   2984: invokevirtual 2522	android/view/View:post	(Ljava/lang/Runnable;)Z
    //   2987: pop
    //   2988: goto -1508 -> 1480
    //   2991: aload_0
    //   2992: getfield 2799	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Txn	Lcom/tencent/mm/plugin/textstatus/a/w;
    //   2995: astore_1
    //   2996: aload_1
    //   2997: ifnonnull +164 -> 3161
    //   3000: aconst_null
    //   3001: astore_1
    //   3002: aload_0
    //   3003: getfield 2799	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Txn	Lcom/tencent/mm/plugin/textstatus/a/w;
    //   3006: astore 5
    //   3008: aload 5
    //   3010: ifnonnull +159 -> 3169
    //   3013: aload 6
    //   3015: astore 5
    //   3017: aload 5
    //   3019: ifnonnull +160 -> 3179
    //   3022: iconst_0
    //   3023: istore_2
    //   3024: aload_1
    //   3025: checkcast 1669	java/lang/CharSequence
    //   3028: invokestatic 2514	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3031: ifne +157 -> 3188
    //   3034: iconst_1
    //   3035: istore_3
    //   3036: aload_0
    //   3037: iload_2
    //   3038: iload_3
    //   3039: invokespecial 2516	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:bW	(IZ)Z
    //   3042: ifne -1562 -> 1480
    //   3045: iload_2
    //   3046: tableswitch	default:+22 -> 3068, 1:+25->3071, 2:+166->3212
    //   3069: <illegal opcode>
    //   3070: <illegal opcode>
    //   3071: aload_1
    //   3072: invokestatic 1856	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   3075: istore_3
    //   3076: ldc_w 1251
    //   3079: new 1253	java/lang/StringBuilder
    //   3082: dup
    //   3083: ldc_w 4910
    //   3086: invokespecial 1257	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3089: iload_3
    //   3090: invokevirtual 1836	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3093: ldc_w 4912
    //   3096: invokevirtual 1848	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3099: aload_1
    //   3100: invokevirtual 1833	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3103: invokevirtual 1270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3106: invokestatic 1275	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3109: iload_3
    //   3110: ifeq +83 -> 3193
    //   3113: aload_0
    //   3114: aload_1
    //   3115: iload_2
    //   3116: invokespecial 1219	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hs	(Ljava/lang/String;I)V
    //   3119: aload_0
    //   3120: invokevirtual 1202	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJK	()Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$d;
    //   3123: astore 5
    //   3125: aload_0
    //   3126: getfield 2799	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Txn	Lcom/tencent/mm/plugin/textstatus/a/w;
    //   3129: astore 6
    //   3131: aload_0
    //   3132: invokevirtual 1153	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   3135: astore 7
    //   3137: aload 7
    //   3139: ldc_w 1204
    //   3142: invokestatic 1210	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   3145: aload 5
    //   3147: aload 6
    //   3149: aload_1
    //   3150: aload 7
    //   3152: checkcast 1212	android/content/Context
    //   3155: invokevirtual 4915	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$d:a	(Lcom/tencent/mm/plugin/textstatus/a/w;Ljava/lang/String;Landroid/content/Context;)V
    //   3158: goto -1678 -> 1480
    //   3161: aload_1
    //   3162: getfield 2817	com/tencent/mm/plugin/textstatus/a/w:mediaPath	Ljava/lang/String;
    //   3165: astore_1
    //   3166: goto -164 -> 3002
    //   3169: aload 5
    //   3171: getfield 4282	com/tencent/mm/plugin/textstatus/a/w:Tog	Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;
    //   3174: astore 5
    //   3176: goto -159 -> 3017
    //   3179: aload 5
    //   3181: getfield 2946	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:mediaType	I
    //   3184: istore_2
    //   3185: goto -161 -> 3024
    //   3188: iconst_0
    //   3189: istore_3
    //   3190: goto -154 -> 3036
    //   3193: aload_0
    //   3194: aload_1
    //   3195: new 75	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$r
    //   3198: dup
    //   3199: aload_0
    //   3200: invokespecial 4916	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$r:<init>	(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity;)V
    //   3203: checkcast 48	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$b
    //   3206: invokespecial 4905	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$b;)V
    //   3209: goto -1729 -> 1480
    //   3212: aload_1
    //   3213: invokestatic 1856	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   3216: ifeq +126 -> 3342
    //   3219: aload_1
    //   3220: ldc_w 1088
    //   3223: ldc_w 1088
    //   3226: invokestatic 4920	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:aM	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   3229: astore_1
    //   3230: aload_1
    //   3231: sipush 15000
    //   3234: putfield 4923	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:NHZ	I
    //   3237: aload_1
    //   3238: iconst_2
    //   3239: putfield 4926	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:scene	I
    //   3242: new 3647	com/tencent/mm/component/api/jumper/UICustomParam$a
    //   3245: dup
    //   3246: invokespecial 3648	com/tencent/mm/component/api/jumper/UICustomParam$a:<init>	()V
    //   3249: astore 5
    //   3251: aload 5
    //   3253: invokevirtual 3652	com/tencent/mm/component/api/jumper/UICustomParam$a:aQw	()Lcom/tencent/mm/component/api/jumper/UICustomParam$a;
    //   3256: pop
    //   3257: aload 5
    //   3259: invokevirtual 3655	com/tencent/mm/component/api/jumper/UICustomParam$a:aQv	()Lcom/tencent/mm/component/api/jumper/UICustomParam$a;
    //   3262: pop
    //   3263: aload 5
    //   3265: iconst_1
    //   3266: invokevirtual 3659	com/tencent/mm/component/api/jumper/UICustomParam$a:eL	(Z)Lcom/tencent/mm/component/api/jumper/UICustomParam$a;
    //   3269: pop
    //   3270: aload_1
    //   3271: aload 5
    //   3273: getfield 3663	com/tencent/mm/component/api/jumper/UICustomParam$a:lZB	Lcom/tencent/mm/component/api/jumper/UICustomParam;
    //   3276: putfield 3666	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:NHR	Lcom/tencent/mm/component/api/jumper/UICustomParam;
    //   3279: aload_1
    //   3280: iconst_0
    //   3281: putfield 3678	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:NIk	Z
    //   3284: aload_1
    //   3285: iconst_0
    //   3286: putfield 3681	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:NIl	Z
    //   3289: aload_1
    //   3290: iconst_1
    //   3291: putfield 3684	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:NIm	Z
    //   3294: aload_1
    //   3295: getstatic 3687	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   3298: putfield 3690	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:NHU	Ljava/lang/Boolean;
    //   3301: aload_1
    //   3302: iconst_4
    //   3303: putfield 3693	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:NHT	I
    //   3306: aload_1
    //   3307: iconst_2
    //   3308: ldc_w 1521
    //   3311: invokevirtual 1526	java/lang/Class:getName	()Ljava/lang/String;
    //   3314: invokevirtual 3697	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:cD	(ILjava/lang/String;)V
    //   3317: getstatic 3717	com/tencent/mm/plugin/recordvideo/jumper/a:NIr	Lcom/tencent/mm/plugin/recordvideo/jumper/a;
    //   3320: astore 5
    //   3322: aload_0
    //   3323: invokevirtual 1153	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   3326: checkcast 1212	android/content/Context
    //   3329: bipush 7
    //   3331: getstatic 3720	com/tencent/mm/plugin/textstatus/a$a:sight_slide_bottom_in	I
    //   3334: iconst_m1
    //   3335: aload_1
    //   3336: iconst_2
    //   3337: iconst_0
    //   3338: invokestatic 4929	com/tencent/mm/plugin/recordvideo/jumper/a:a	(Landroid/content/Context;IIILcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;II)Z
    //   3341: pop
    //   3342: aload_0
    //   3343: invokespecial 1795	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJt	()V
    //   3346: goto -1866 -> 1480
    //   3349: getstatic 2991	com/tencent/mm/plugin/textstatus/b/f:TjQ	Lcom/tencent/mm/plugin/textstatus/b/f;
    //   3352: astore_1
    //   3353: aload_0
    //   3354: getfield 2799	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Txn	Lcom/tencent/mm/plugin/textstatus/a/w;
    //   3357: astore_1
    //   3358: aload_1
    //   3359: ifnonnull +17 -> 3376
    //   3362: aload 7
    //   3364: astore_1
    //   3365: aload_0
    //   3366: aload_1
    //   3367: invokestatic 2995	com/tencent/mm/plugin/textstatus/b/f:bdN	(Ljava/lang/String;)Lcom/tencent/mm/plugin/textstatus/h/f/b;
    //   3370: invokespecial 4931	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:g	(Lcom/tencent/mm/plugin/textstatus/h/f/b;)V
    //   3373: goto -1893 -> 1480
    //   3376: aload_1
    //   3377: getfield 3148	com/tencent/mm/plugin/textstatus/a/w:Top	Ljava/lang/String;
    //   3380: astore_1
    //   3381: goto -16 -> 3365
    //   3384: getstatic 2991	com/tencent/mm/plugin/textstatus/b/f:TjQ	Lcom/tencent/mm/plugin/textstatus/b/f;
    //   3387: astore_1
    //   3388: aload_0
    //   3389: getfield 2799	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Txn	Lcom/tencent/mm/plugin/textstatus/a/w;
    //   3392: astore_1
    //   3393: aload_1
    //   3394: ifnonnull +17 -> 3411
    //   3397: aload 8
    //   3399: astore_1
    //   3400: aload_0
    //   3401: aload_1
    //   3402: invokestatic 2995	com/tencent/mm/plugin/textstatus/b/f:bdN	(Ljava/lang/String;)Lcom/tencent/mm/plugin/textstatus/h/f/b;
    //   3405: invokespecial 4931	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:g	(Lcom/tencent/mm/plugin/textstatus/h/f/b;)V
    //   3408: goto -1928 -> 1480
    //   3411: aload_1
    //   3412: getfield 3148	com/tencent/mm/plugin/textstatus/a/w:Top	Ljava/lang/String;
    //   3415: astore_1
    //   3416: goto -16 -> 3400
    //   3419: aload_1
    //   3420: checkcast 2199	android/widget/RelativeLayout$LayoutParams
    //   3423: astore_1
    //   3424: aload_0
    //   3425: invokevirtual 1153	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   3428: checkcast 1212	android/content/Context
    //   3431: invokestatic 4670	com/tencent/mm/ui/bf:getStatusBarHeight	(Landroid/content/Context;)I
    //   3434: istore_2
    //   3435: aload_1
    //   3436: aload_0
    //   3437: invokevirtual 1153	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   3440: checkcast 1212	android/content/Context
    //   3443: bipush 6
    //   3445: invokestatic 4932	com/tencent/mm/ui/bd:fromDPToPix	(Landroid/content/Context;I)I
    //   3448: iload_2
    //   3449: iadd
    //   3450: putfield 4935	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   3453: aload_0
    //   3454: invokespecial 3382	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJc	()Landroid/view/View;
    //   3457: new 4937	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda6
    //   3460: dup
    //   3461: aload_0
    //   3462: invokespecial 4938	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda6:<init>	(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity;)V
    //   3465: invokevirtual 3312	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   3468: aload_0
    //   3469: invokespecial 2010	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hHh	()Landroid/widget/TextView;
    //   3472: new 4940	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda7
    //   3475: dup
    //   3476: aload_0
    //   3477: invokespecial 4941	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda7:<init>	(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity;)V
    //   3480: invokevirtual 4942	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   3483: aload_0
    //   3484: getfield 1376	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Tyh	Landroid/view/View;
    //   3487: astore_1
    //   3488: aload_1
    //   3489: ifnull +15 -> 3504
    //   3492: aload_1
    //   3493: new 4944	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda9
    //   3496: dup
    //   3497: aload_0
    //   3498: invokespecial 4945	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda9:<init>	(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity;)V
    //   3501: invokevirtual 3312	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   3504: aload_0
    //   3505: invokevirtual 1360	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hIP	()Lcom/tencent/mm/ui/widget/MMEditText;
    //   3508: astore_1
    //   3509: aload_1
    //   3510: ifnull +11 -> 3521
    //   3513: aload_1
    //   3514: aload_0
    //   3515: getfield 1087	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:pKm	Landroid/text/TextWatcher;
    //   3518: invokevirtual 4949	com/tencent/mm/ui/widget/MMEditText:addTextChangedListener	(Landroid/text/TextWatcher;)V
    //   3521: aload_0
    //   3522: invokestatic 4952	com/tencent/mm/plugin/textstatus/a/ac:hGk	()I
    //   3525: putfield 3343	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TyA	I
    //   3528: aload_0
    //   3529: invokespecial 2020	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJn	()Z
    //   3532: ifeq +526 -> 4058
    //   3535: aload_0
    //   3536: invokevirtual 1360	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hIP	()Lcom/tencent/mm/ui/widget/MMEditText;
    //   3539: invokevirtual 1591	com/tencent/mm/ui/widget/MMEditText:getText	()Landroid/text/Editable;
    //   3542: astore_1
    //   3543: aload_1
    //   3544: ldc_w 3357
    //   3547: invokestatic 1210	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   3550: aload_1
    //   3551: checkcast 1669	java/lang/CharSequence
    //   3554: invokeinterface 4953 1 0
    //   3559: ifle +457 -> 4016
    //   3562: iconst_1
    //   3563: istore_2
    //   3564: iload_2
    //   3565: ifeq +456 -> 4021
    //   3568: aload_0
    //   3569: getfield 3944	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:MHO	Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent;
    //   3572: astore_1
    //   3573: aload_1
    //   3574: ifnull +8 -> 3582
    //   3577: aload_1
    //   3578: iconst_1
    //   3579: invokevirtual 4956	com/tencent/mm/emoji/view/EmojiPanelInputComponent:setSmileySendButtonEnable	(Z)V
    //   3582: aload_0
    //   3583: getfield 3944	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:MHO	Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent;
    //   3586: astore_1
    //   3587: aload_1
    //   3588: ifnull +14 -> 3602
    //   3591: aload_1
    //   3592: aload_0
    //   3593: invokevirtual 1360	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hIP	()Lcom/tencent/mm/ui/widget/MMEditText;
    //   3596: checkcast 4958	com/tencent/mm/ui/widget/cedit/api/c
    //   3599: invokevirtual 4962	com/tencent/mm/emoji/view/EmojiPanelInputComponent:setMMEditText	(Lcom/tencent/mm/ui/widget/cedit/api/c;)V
    //   3602: aload_0
    //   3603: getfield 3944	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:MHO	Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent;
    //   3606: astore_1
    //   3607: aload_1
    //   3608: ifnull +8 -> 3616
    //   3611: aload_1
    //   3612: iconst_4
    //   3613: invokevirtual 3948	com/tencent/mm/emoji/view/EmojiPanelInputComponent:setVisibility	(I)V
    //   3616: aload_0
    //   3617: getfield 3944	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:MHO	Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent;
    //   3620: astore_1
    //   3621: aload_1
    //   3622: ifnull +11 -> 3633
    //   3625: aload_1
    //   3626: aload_0
    //   3627: checkcast 6	com/tencent/mm/emoji/view/EmojiPanelInputComponent$a
    //   3630: invokevirtual 4966	com/tencent/mm/emoji/view/EmojiPanelInputComponent:setInputComponentListener	(Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent$a;)V
    //   3633: aload_0
    //   3634: getfield 3944	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:MHO	Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent;
    //   3637: astore_1
    //   3638: aload_1
    //   3639: ifnull +29 -> 3668
    //   3642: aload_1
    //   3643: getstatic 4969	com/tencent/mm/plugin/textstatus/a$e:layout_emoji_btns	I
    //   3646: invokevirtual 4970	com/tencent/mm/emoji/view/EmojiPanelInputComponent:findViewById	(I)Landroid/view/View;
    //   3649: astore_1
    //   3650: aload_1
    //   3651: ifnull +17 -> 3668
    //   3654: aload_1
    //   3655: aload_0
    //   3656: invokevirtual 1727	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:getResources	()Landroid/content/res/Resources;
    //   3659: getstatic 4973	com/tencent/mm/plugin/textstatus/a$b:BW_93	I
    //   3662: invokevirtual 1778	android/content/res/Resources:getColor	(I)I
    //   3665: invokevirtual 4976	android/view/View:setBackgroundColor	(I)V
    //   3668: aload_0
    //   3669: getfield 3944	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:MHO	Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent;
    //   3672: astore_1
    //   3673: aload_1
    //   3674: ifnull +88 -> 3762
    //   3677: aload_1
    //   3678: invokevirtual 4980	com/tencent/mm/emoji/view/EmojiPanelInputComponent:getSmileyPanel	()Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;
    //   3681: astore_1
    //   3682: aload_1
    //   3683: ifnull +79 -> 3762
    //   3686: aload_0
    //   3687: getfield 3343	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TyA	I
    //   3690: iconst_3
    //   3691: if_icmplt +347 -> 4038
    //   3694: iconst_1
    //   3695: istore_3
    //   3696: aload_1
    //   3697: iload_3
    //   3698: invokevirtual 4985	com/tencent/mm/pluginsdk/ui/ChatFooterPanel:Jy	(Z)V
    //   3701: aload_0
    //   3702: getfield 3343	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TyA	I
    //   3705: iconst_3
    //   3706: if_icmplt +337 -> 4043
    //   3709: iconst_1
    //   3710: istore_3
    //   3711: aload_1
    //   3712: iload_3
    //   3713: invokevirtual 4988	com/tencent/mm/pluginsdk/ui/ChatFooterPanel:Jz	(Z)V
    //   3716: aload_0
    //   3717: getfield 3343	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TyA	I
    //   3720: iconst_2
    //   3721: if_icmplt +327 -> 4048
    //   3724: iconst_1
    //   3725: istore_3
    //   3726: aload_1
    //   3727: iload_3
    //   3728: invokevirtual 4991	com/tencent/mm/pluginsdk/ui/ChatFooterPanel:setShowStore	(Z)V
    //   3731: aload_0
    //   3732: getfield 3343	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TyA	I
    //   3735: iconst_2
    //   3736: if_icmplt +317 -> 4053
    //   3739: iload 4
    //   3741: istore_3
    //   3742: aload_1
    //   3743: iload_3
    //   3744: invokevirtual 4994	com/tencent/mm/pluginsdk/ui/ChatFooterPanel:setShowSearch	(Z)V
    //   3747: aload_1
    //   3748: new 77	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$s
    //   3751: dup
    //   3752: aload_0
    //   3753: invokespecial 4995	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$s:<init>	(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity;)V
    //   3756: checkcast 4997	com/tencent/mm/pluginsdk/ui/chat/f
    //   3759: invokevirtual 5001	com/tencent/mm/pluginsdk/ui/ChatFooterPanel:setCallback	(Lcom/tencent/mm/pluginsdk/ui/chat/f;)V
    //   3762: aload_0
    //   3763: getfield 1003	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TxZ	Lkotlin/j;
    //   3766: invokeinterface 2630 1 0
    //   3771: checkcast 1378	android/view/View
    //   3774: new 5003	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda23
    //   3777: dup
    //   3778: aload_0
    //   3779: invokespecial 5004	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda23:<init>	(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity;)V
    //   3782: invokevirtual 3312	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   3785: aload_0
    //   3786: invokespecial 1384	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hIY	()Landroid/view/View;
    //   3789: new 5006	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda8
    //   3792: dup
    //   3793: aload_0
    //   3794: invokespecial 5007	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda8:<init>	(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity;)V
    //   3797: invokevirtual 3312	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   3800: aload_0
    //   3801: invokespecial 4092	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:grz	()V
    //   3804: aload_0
    //   3805: getfield 1009	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Tyf	Lkotlin/j;
    //   3808: invokeinterface 2630 1 0
    //   3813: checkcast 1378	android/view/View
    //   3816: astore_1
    //   3817: aload_1
    //   3818: ifnull +15 -> 3833
    //   3821: aload_1
    //   3822: new 5009	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda11
    //   3825: dup
    //   3826: aload_0
    //   3827: invokespecial 5010	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda11:<init>	(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity;)V
    //   3830: invokevirtual 3312	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   3833: aload_0
    //   3834: getfield 1024	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Tyq	Lkotlin/j;
    //   3837: invokeinterface 2630 1 0
    //   3842: checkcast 1244	android/widget/ImageView
    //   3845: astore_1
    //   3846: aload_1
    //   3847: ifnull +15 -> 3862
    //   3850: aload_1
    //   3851: new 5012	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda22
    //   3854: dup
    //   3855: aload_0
    //   3856: invokespecial 5013	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda22:<init>	(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity;)V
    //   3859: invokevirtual 4748	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   3862: aload_0
    //   3863: invokespecial 4750	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hIL	()Landroid/view/View;
    //   3866: astore_1
    //   3867: aload_1
    //   3868: ifnull +11 -> 3879
    //   3871: aload_1
    //   3872: aload_0
    //   3873: getfield 1109	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TyL	Landroid/view/View$OnClickListener;
    //   3876: invokevirtual 3312	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   3879: aload_0
    //   3880: getfield 4582	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TxE	Landroid/view/View;
    //   3883: astore_1
    //   3884: aload_1
    //   3885: ifnull +15 -> 3900
    //   3888: aload_1
    //   3889: new 5015	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda15
    //   3892: dup
    //   3893: aload_0
    //   3894: invokespecial 5016	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda15:<init>	(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity;)V
    //   3897: invokevirtual 3312	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   3900: aload_0
    //   3901: getfield 4587	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TxF	Landroid/view/View;
    //   3904: astore_1
    //   3905: aload_1
    //   3906: ifnull +11 -> 3917
    //   3909: aload_1
    //   3910: aload_0
    //   3911: getfield 1099	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TyK	Landroid/view/View$OnClickListener;
    //   3914: invokevirtual 3312	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   3917: aload_0
    //   3918: getfield 5018	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Tyb	Landroid/view/View;
    //   3921: astore_1
    //   3922: aload_1
    //   3923: ifnull +15 -> 3938
    //   3926: aload_1
    //   3927: new 5020	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda18
    //   3930: dup
    //   3931: aload_0
    //   3932: invokespecial 5021	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda18:<init>	(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity;)V
    //   3935: invokevirtual 3312	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   3938: aload_0
    //   3939: getfield 5023	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:Tyg	Landroid/view/View;
    //   3942: astore_1
    //   3943: aload_1
    //   3944: ifnull +15 -> 3959
    //   3947: aload_1
    //   3948: new 5025	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda21
    //   3951: dup
    //   3952: aload_0
    //   3953: invokespecial 5026	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$ExternalSyntheticLambda21:<init>	(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity;)V
    //   3956: invokevirtual 3312	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   3959: aload_0
    //   3960: new 5028	com/tencent/mm/ui/tools/i
    //   3963: dup
    //   3964: aload_0
    //   3965: checkcast 1533	android/app/Activity
    //   3968: invokespecial 5031	com/tencent/mm/ui/tools/i:<init>	(Landroid/app/Activity;)V
    //   3971: putfield 5033	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:lKz	Lcom/tencent/mm/ui/tools/i;
    //   3974: aload_0
    //   3975: getfield 5033	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:lKz	Lcom/tencent/mm/ui/tools/i;
    //   3978: astore_1
    //   3979: aload_1
    //   3980: ifnull +11 -> 3991
    //   3983: aload_1
    //   3984: aload_0
    //   3985: checkcast 12	com/tencent/mm/ui/tools/h
    //   3988: putfield 5037	com/tencent/mm/ui/tools/i:afIL	Lcom/tencent/mm/ui/tools/h;
    //   3991: aload_0
    //   3992: invokespecial 1934	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:hJk	()Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView;
    //   3995: aload_0
    //   3996: checkcast 8	com/tencent/mm/plugin/textstatus/emoji/c
    //   3999: invokevirtual 5041	com/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView:setOnKeyboardActionListener	(Lcom/tencent/mm/plugin/textstatus/emoji/c;)V
    //   4002: aload_0
    //   4003: getfield 1077	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:TyE	Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$configUpdateListener$1;
    //   4006: invokevirtual 5044	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$configUpdateListener$1:alive	()V
    //   4009: ldc_w 4467
    //   4012: invokestatic 738	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4015: return
    //   4016: iconst_0
    //   4017: istore_2
    //   4018: goto -454 -> 3564
    //   4021: aload_0
    //   4022: getfield 3944	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:MHO	Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent;
    //   4025: astore_1
    //   4026: aload_1
    //   4027: ifnull -445 -> 3582
    //   4030: aload_1
    //   4031: iconst_0
    //   4032: invokevirtual 4956	com/tencent/mm/emoji/view/EmojiPanelInputComponent:setSmileySendButtonEnable	(Z)V
    //   4035: goto -453 -> 3582
    //   4038: iconst_0
    //   4039: istore_3
    //   4040: goto -344 -> 3696
    //   4043: iconst_0
    //   4044: istore_3
    //   4045: goto -334 -> 3711
    //   4048: iconst_0
    //   4049: istore_3
    //   4050: goto -324 -> 3726
    //   4053: iconst_0
    //   4054: istore_3
    //   4055: goto -313 -> 3742
    //   4058: aload_0
    //   4059: getfield 3944	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:MHO	Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent;
    //   4062: astore_1
    //   4063: aload_1
    //   4064: ifnull +8 -> 4072
    //   4067: aload_1
    //   4068: iconst_4
    //   4069: invokevirtual 3948	com/tencent/mm/emoji/view/EmojiPanelInputComponent:setVisibility	(I)V
    //   4072: aload_0
    //   4073: getfield 3944	com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity:MHO	Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent;
    //   4076: astore_1
    //   4077: aload_1
    //   4078: ifnull -316 -> 3762
    //   4081: aload_1
    //   4082: bipush 8
    //   4084: invokevirtual 3948	com/tencent/mm/emoji/view/EmojiPanelInputComponent:setVisibility	(I)V
    //   4087: goto -325 -> 3762
    //   4090: astore_1
    //   4091: goto -2652 -> 1439
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4094	0	this	TextStatusEditActivity
    //   0	4094	1	paramBundle	android.os.Bundle
    //   621	3397	2	i	int
    //   1038	3017	3	bool1	boolean
    //   10	3730	4	bool2	boolean
    //   576	2745	5	localObject1	Object
    //   7	3141	6	localObject2	Object
    //   1	3362	7	localAppCompatActivity	AppCompatActivity
    //   4	3394	8	localObject3	Object
    //   1216	1172	9	localObject4	Object
    //   1899	611	10	localb	com.tencent.mm.plugin.textstatus.h.f.b
    //   2005	358	11	localObject5	Object
    //   2014	295	12	localTextStatusTopicInfo	TextStatusTopicInfo
    //   2039	398	13	locale	com.tencent.mm.plugin.textstatus.a.e
    // Exception table:
    //   from	to	target	type
    //   1353	1439	4090	finally
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(292326);
    hJI();
    super.onDestroy();
    hIi();
    hJk().setOnKeyboardActionListener(null);
    ObjectAnimator localObjectAnimator = this.Jvg;
    if ((localObjectAnimator != null) && (localObjectAnimator.isRunning())) {
      localObjectAnimator.cancel();
    }
    localObjectAnimator = this.Jvf;
    if ((localObjectAnimator != null) && (localObjectAnimator.isRunning())) {
      localObjectAnimator.cancel();
    }
    r.bKd().b(this.TyH, this.TyI);
    TyT = null;
    this.Tyz = null;
    this.TyE.dead();
    AppMethodBeat.o(292326);
  }
  
  public final void onInputPanelChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(292402);
    Log.d("MicroMsg.TextStatus.TextStatusEditActivity", "onInputPanelChange " + paramBoolean + ", " + paramInt);
    if (!hJn())
    {
      AppMethodBeat.o(292402);
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      aoy(paramInt);
      AppMethodBeat.o(292402);
      return;
      paramInt = 0;
    }
  }
  
  public final void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(292343);
    Log.d("MicroMsg.TextStatus.TextStatusEditActivity", "onKeyboardHeightChanged " + paramInt + ", " + paramBoolean);
    if (hJn())
    {
      AppMethodBeat.o(292343);
      return;
    }
    aoy(paramInt);
    AppMethodBeat.o(292343);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(292335);
    super.hideVKB();
    super.onPause();
    Object localObject = this.lKz;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.i)localObject).close();
    }
    hJv();
    if (this.Tvz == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.TextStatus.TextStatusEditActivity", kotlin.g.b.s.X("[onPause] ", Boolean.valueOf(bool)));
      localObject = this.Tvz;
      if ((localObject != null) && (((com.tencent.mm.ui.widget.b)localObject).hU))
      {
        ((com.tencent.mm.ui.widget.b)localObject).etM();
        ((com.tencent.mm.ui.widget.b)localObject).onPostClose();
      }
      localObject = this.Goz;
      if (localObject != null)
      {
        localObject = ((MMTPEffectVideoLayout)localObject).getPlayer();
        if (localObject != null) {
          com.tencent.mm.plugin.thumbplayer.e.b.b((com.tencent.mm.plugin.thumbplayer.e.b)localObject);
        }
      }
      AppMethodBeat.o(292335);
      return;
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(292364);
    kotlin.g.b.s.u(paramArrayOfString, "permissions");
    kotlin.g.b.s.u(paramArrayOfInt, "grantResults");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(292364);
      return;
    }
    if ((paramInt == 64) && (paramArrayOfInt[0] == 0))
    {
      hJw();
      AppMethodBeat.o(292364);
      return;
    }
    if (paramInt == 18)
    {
      if (paramArrayOfInt[0] == 0)
      {
        hJy();
        super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
        AppMethodBeat.o(292364);
        return;
      }
      if (!kotlin.g.b.s.p("android.permission.CAMERA", paramArrayOfString[0])) {
        break label174;
      }
    }
    label174:
    for (paramInt = a.h.permission_camera_request_again_msg;; paramInt = a.h.permission_microphone_request_again_msg)
    {
      if (paramArrayOfInt[0] != 0) {
        com.tencent.mm.ui.base.k.a((Context)this, getString(paramInt), getString(a.h.permission_tips_title), getString(a.h.jump_to_settings), getString(a.h.app_cancel), false, new TextStatusEditActivity..ExternalSyntheticLambda2(this), TextStatusEditActivity..ExternalSyntheticLambda3.INSTANCE);
      }
      AppMethodBeat.o(292364);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(292331);
    super.onResume();
    Object localObject = this.lKz;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.i)localObject).start();
    }
    hJF();
    localObject = this.Goz;
    if (localObject != null)
    {
      localObject = ((MMTPEffectVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).hLh();
      }
    }
    hJB();
    AppMethodBeat.o(292331);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(292340);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    com.tencent.mm.ui.tools.i locali;
    if (paramBoolean)
    {
      locali = this.lKz;
      if (locali != null)
      {
        locali.start();
        AppMethodBeat.o(292340);
      }
    }
    else
    {
      locali = this.lKz;
      if (locali != null) {
        locali.close();
      }
    }
    AppMethodBeat.o(292340);
  }
  
  public final void setBtnBack(View paramView)
  {
    AppMethodBeat.i(292237);
    kotlin.g.b.s.u(paramView, "<set-?>");
    this.Tyk = paramView;
    AppMethodBeat.o(292237);
  }
  
  public final void setBtnOk(View paramView)
  {
    AppMethodBeat.i(292234);
    kotlin.g.b.s.u(paramView, "<set-?>");
    this.Tyi = paramView;
    AppMethodBeat.o(292234);
  }
  
  public final void setBtnTag(View paramView)
  {
    this.Tyh = paramView;
  }
  
  public final void setEditLayout(View paramView)
  {
    this.TxA = paramView;
  }
  
  public final void setFakePic(View paramView)
  {
    this.TxS = paramView;
  }
  
  public final void setIconCamera(View paramView)
  {
    this.TxG = paramView;
  }
  
  public final void setIconPoi(View paramView)
  {
    this.TxI = paramView;
  }
  
  public final void setIconText(View paramView)
  {
    this.TxH = paramView;
  }
  
  public final void setIconVisibility(View paramView)
  {
    this.TxK = paramView;
  }
  
  public final void setLayoutBlurOption(View paramView)
  {
    AppMethodBeat.i(292242);
    kotlin.g.b.s.u(paramView, "<set-?>");
    this.Tyl = paramView;
    AppMethodBeat.o(292242);
  }
  
  public final void setLayoutEditDesc(View paramView)
  {
    this.Tyb = paramView;
  }
  
  public final void setLayoutEditToolContainer(View paramView)
  {
    this.Tyc = paramView;
  }
  
  public final void setLayoutTopicEdit(View paramView)
  {
    this.Tye = paramView;
  }
  
  public final void setTvCancel(View paramView)
  {
    this.Tyg = paramView;
  }
  
  public final void setVPoi(View paramView)
  {
    this.TxE = paramView;
  }
  
  public final void setVVisibility(View paramView)
  {
    this.TxF = paramView;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/FrameLayout;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class aa
    extends kotlin.g.b.u
    implements kotlin.g.a.a<FrameLayout>
  {
    aa(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ac
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    ac(Bitmap paramBitmap, TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/FrameLayout;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ad
    extends kotlin.g.b.u
    implements kotlin.g.a.a<FrameLayout>
  {
    ad(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class ae
    implements TextWatcher
  {
    ae(TextStatusEditActivity paramTextStatusEditActivity) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(291133);
      Object localObject = this.Tzd.hIP();
      if (localObject != null) {
        ((MMEditText)localObject).removeTextChangedListener((TextWatcher)this);
      }
      this.Tzd.hJa().setEnabled(TextStatusEditActivity.n(this.Tzd));
      if (this.Tzd.hJa().isEnabled()) {
        TextStatusEditActivity.o(this.Tzd).setVisibility(8);
      }
      for (;;)
      {
        localObject = new com.tencent.mm.plugin.emoji.e(String.valueOf(paramEditable), (int)this.Tzd.hIP().getPaint().getTextSize());
        int i = ((com.tencent.mm.plugin.emoji.e)localObject).a(com.tencent.mm.ui.tools.g.a.afII);
        String.valueOf(paramEditable);
        if (i > 64)
        {
          paramEditable = ((com.tencent.mm.plugin.emoji.e)localObject).b(64, com.tencent.mm.ui.tools.g.a.afII);
          this.Tzd.hIP().setText(com.tencent.mm.ui.i.c.b.a((Context)this.Tzd, (CharSequence)paramEditable, (int)this.Tzd.hIP().getPaint().getTextSize()));
          this.Tzd.hIP().setSelection(this.Tzd.hIP().getText().length());
          com.tencent.mm.ui.base.aa.y((Context)this.Tzd, this.Tzd.getString(a.h.settings_modify_text_status_invalid_more), a.g.icons_outlined_info);
          paramEditable = com.tencent.mm.plugin.secdata.ui.a.PlI;
          paramEditable = this.Tzd.getContext();
          kotlin.g.b.s.s(paramEditable, "context");
          paramEditable = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)paramEditable, 8, bh.class);
          if (paramEditable != null) {
            paramEditable.TqF = (1L + paramEditable.TqF);
          }
        }
        if (this.Tzd.TyF == TextStatusEditActivity.c.TyV)
        {
          this.Tzd.hIP().setText((CharSequence)"");
          this.Tzd.aos(a.h.Thb);
          paramEditable = this.Tzd.hJo();
          if (paramEditable != null) {
            paramEditable.Trh += 1;
          }
        }
        paramEditable = this.Tzd.hIP();
        if (paramEditable != null) {
          paramEditable.addTextChangedListener((TextWatcher)this);
        }
        AppMethodBeat.o(291133);
        return;
        TextStatusEditActivity.o(this.Tzd).setVisibility(0);
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class af
    extends kotlin.g.b.u
    implements kotlin.g.a.a<LinearLayout>
  {
    af(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ag
    extends kotlin.g.b.u
    implements kotlin.g.a.a<TextView>
  {
    ag(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/FrameLayout;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ah
    extends kotlin.g.b.u
    implements kotlin.g.a.a<FrameLayout>
  {
    ah(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ai
    extends kotlin.g.b.u
    implements kotlin.g.a.a<View>
  {
    ai(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class aj
    extends kotlin.g.b.u
    implements kotlin.g.a.a<TextView>
  {
    aj(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ak
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ImageView>
  {
    ak(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class al
    extends kotlin.g.b.u
    implements kotlin.g.a.a<View>
  {
    al(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class am
    extends kotlin.g.b.u
    implements kotlin.g.a.a<View>
  {
    am(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class an
    extends kotlin.g.b.u
    implements kotlin.g.a.a<View>
  {
    an(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ao
    extends kotlin.g.b.u
    implements kotlin.g.a.a<View>
  {
    ao(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ap
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ImageView>
  {
    ap(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class aq
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ImageView>
  {
    aq(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$EditContentType;", "", "(Ljava/lang/String;I)V", "NORMAL", "BIG_EMOJI", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum c
  {
    static
    {
      AppMethodBeat.i(291238);
      TyU = new c("NORMAL", 0);
      TyV = new c("BIG_EMOJI", 1);
      TyW = new c[] { TyU, TyV };
      AppMethodBeat.o(291238);
    }
    
    private c() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$MediaStruct;", "", "curTextStatusExtInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;)V", "getCurTextStatusExtInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;", "setCurTextStatusExtInfo", "finalFileLength", "", "getFinalFileLength", "()J", "setFinalFileLength", "(J)V", "isGenThumbWhenUpload", "", "()Z", "setGenThumbWhenUpload", "(Z)V", "mediaFilePath", "", "getMediaFilePath", "()Ljava/lang/String;", "setMediaFilePath", "(Ljava/lang/String;)V", "mediaThumbPath", "getMediaThumbPath", "setMediaThumbPath", "mediaType", "", "getMediaType", "()I", "setMediaType", "(I)V", "oriFileLength", "getOriFileLength", "setOriFileLength", "oriFileMd5", "getOriFileMd5", "setOriFileMd5", "useDefaultBackground", "getUseDefaultBackground", "setUseDefaultBackground", "videoDuration", "getVideoDuration", "setVideoDuration", "isHasMedia", "prepareMediaReportData", "", "context", "Landroid/content/Context;", "reset", "update", "captureResult", "Lcom/tencent/mm/plugin/mmsight/SightCaptureResult;", "setStatusParam", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "mediaPath", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "extInfo", "updateFromGallery", "filePath", "thumbPath", "oriVideoFilePath", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
  {
    boolean Tqk;
    String TyX;
    String TyY;
    boolean TyZ;
    TextStatusExtInfo Tyx;
    long Tza;
    String Tzb;
    long Tzc;
    int mediaType;
    long vYw;
    
    public d(TextStatusExtInfo paramTextStatusExtInfo)
    {
      AppMethodBeat.i(291229);
      this.Tyx = paramTextStatusExtInfo;
      this.Tqk = true;
      this.Tzb = "";
      AppMethodBeat.o(291229);
    }
    
    public final void a(int paramInt, String paramString1, String paramString2, Context paramContext, String paramString3)
    {
      AppMethodBeat.i(291262);
      kotlin.g.b.s.u(paramContext, "context");
      kotlin.g.b.s.u(paramString3, "oriVideoFilePath");
      reset();
      com.tencent.mm.plugin.textstatus.d.a.c(this.Tyx);
      this.Tqk = false;
      this.mediaType = paramInt;
      this.TyY = paramString2;
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
          Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "[updateFromGallery] oriLen:" + this.Tza + " finalLen:" + this.Tzc + " type:" + paramInt);
          kq(paramContext);
          AppMethodBeat.o(291262);
          return;
          this.Tza = y.bEl(paramString1);
          this.Tzb = com.tencent.mm.b.g.getMD5(paramString1);
          this.TyX = com.tencent.mm.plugin.textstatus.h.h.d.Tod.bea(paramString1);
          this.TyZ = true;
          this.Tzc = y.bEl(this.TyX);
        }
        if (!kotlin.n.n.bp((CharSequence)paramString3)) {
          break;
        }
        i = 1;
        if (i != 0) {
          break label267;
        }
        this.Tza = y.bEl(paramString3);
        this.Tzb = com.tencent.mm.b.g.getMD5(paramString3);
        this.TyX = paramString1;
        this.Tzc = y.bEl(this.TyX);
        paramString1 = this.TyX;
      } while (paramString1 == null);
      paramString1 = MultiMediaVideoChecker.ObB.aTG(paramString1);
      if (paramString1 == null) {}
      for (long l = 0L;; l = paramString1.duration)
      {
        this.vYw = (l / 1000L);
        break;
        i = 0;
        break label185;
        label267:
        this.Tza = y.bEl(paramString1);
        this.Tzb = com.tencent.mm.b.g.getMD5(paramString1);
        break label208;
      }
    }
    
    public final void a(w paramw, String paramString, Context paramContext)
    {
      AppMethodBeat.i(291254);
      kotlin.g.b.s.u(paramContext, "context");
      reset();
      int i;
      if (paramw != null)
      {
        CharSequence localCharSequence = (CharSequence)paramw.mediaPath;
        if ((localCharSequence != null) && (!kotlin.n.n.bp(localCharSequence))) {
          break label169;
        }
        i = 1;
        if (i != 0) {}
      }
      switch (paramw.Tog.mediaType)
      {
      default: 
      case 1: 
        for (;;)
        {
          this.Tzc = y.bEl(this.TyX);
          this.Tza = this.Tzc;
          this.Tzb = com.tencent.mm.b.g.getMD5(this.TyX);
          kq(paramContext);
          Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "[updateFromSetStatusParam] oriLen:" + this.Tza + " finalLen:" + this.Tzc + " type:" + this.mediaType);
          AppMethodBeat.o(291254);
          return;
          label169:
          i = 0;
          break;
          this.mediaType = 1;
          if (!TextUtils.isEmpty((CharSequence)paramString))
          {
            this.TyX = com.tencent.mm.plugin.textstatus.h.h.d.Tod.bea(paramString);
            this.TyY = this.TyX;
          }
          this.Tqk = false;
        }
      }
      this.mediaType = 2;
      this.TyX = paramString;
      paramw = this.TyX;
      if (paramw != null)
      {
        paramw = MultiMediaVideoChecker.ObB.aTG(paramw);
        if (paramw != null) {
          break label274;
        }
      }
      label274:
      for (long l = 0L;; l = paramw.duration)
      {
        this.vYw = (l / 1000L);
        this.Tqk = false;
        this.TyZ = true;
        break;
      }
    }
    
    public final void a(com.tencent.mm.plugin.textstatus.h.f.b paramb, Context paramContext)
    {
      AppMethodBeat.i(291245);
      kotlin.g.b.s.u(paramContext, "context");
      reset();
      if (paramb == null)
      {
        AppMethodBeat.o(291245);
        return;
      }
      int i = paramb.field_MediaType;
      String str = paramb.field_UserName;
      switch (i)
      {
      }
      for (;;)
      {
        this.mediaType = i;
        this.Tzc = y.bEl(this.TyX);
        this.Tza = this.Tzc;
        this.Tzb = com.tencent.mm.b.g.getMD5(this.TyX);
        kq(paramContext);
        AppMethodBeat.o(291245);
        return;
        com.tencent.mm.plugin.textstatus.util.e locale = com.tencent.mm.plugin.textstatus.util.e.TAU;
        kotlin.g.b.s.s(str, "userName");
        this.TyY = com.tencent.mm.plugin.textstatus.util.e.nl("thumb", str);
        if (kotlin.g.b.s.p(com.tencent.mm.plugin.auth.a.a.cUx(), str))
        {
          locale = com.tencent.mm.plugin.textstatus.util.e.TAU;
          if (y.ZC(com.tencent.mm.plugin.textstatus.util.e.bek(str)))
          {
            paramb = com.tencent.mm.plugin.textstatus.util.e.TAU;
            this.TyX = com.tencent.mm.plugin.textstatus.util.e.bek(str);
          }
        }
        for (;;)
        {
          this.Tqk = false;
          break;
          this.TyX = paramb.field_MediaUrl;
          continue;
          this.TyX = paramb.field_MediaUrl;
        }
        paramb = com.tencent.mm.plugin.textstatus.util.e.TAU;
        kotlin.g.b.s.s(str, "userName");
        this.TyY = com.tencent.mm.plugin.textstatus.util.e.nl("thumb", str);
        paramb = com.tencent.mm.plugin.textstatus.util.e.TAU;
        this.TyX = com.tencent.mm.plugin.textstatus.util.e.nl("image", str);
        this.Tqk = false;
      }
    }
    
    public final boolean hJP()
    {
      AppMethodBeat.i(291235);
      if (this.Tqk)
      {
        AppMethodBeat.o(291235);
        return false;
      }
      if (TextUtils.isEmpty((CharSequence)this.TyX))
      {
        AppMethodBeat.o(291235);
        return false;
      }
      AppMethodBeat.o(291235);
      return true;
    }
    
    final void kq(Context paramContext)
    {
      AppMethodBeat.i(291272);
      com.tencent.mm.plugin.secdata.ui.a.a locala;
      if (this.mediaType == 2)
      {
        locala = com.tencent.mm.plugin.secdata.ui.a.PlI;
        paramContext = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a(paramContext, 8, bh.class);
        if (paramContext != null)
        {
          paramContext.Tqw = (this.vYw * 1000L);
          paramContext.Tqx = this.Tzc;
          paramContext.TqS = ((int)this.Tza);
          paramContext.TqT = this.Tzb;
          AppMethodBeat.o(291272);
        }
      }
      else if (this.mediaType == 1)
      {
        locala = com.tencent.mm.plugin.secdata.ui.a.PlI;
        paramContext = (bh)com.tencent.mm.plugin.secdata.ui.a.a.a(paramContext, 8, bh.class);
        if (paramContext != null)
        {
          paramContext.Tqw = 0L;
          paramContext.Tqx = this.Tzc;
          paramContext.TqS = ((int)this.Tza);
          paramContext.TqT = this.Tzb;
        }
      }
      AppMethodBeat.o(291272);
    }
    
    public final void reset()
    {
      this.TyX = null;
      this.TyY = null;
      this.mediaType = 0;
      this.TyZ = false;
      this.Tqk = true;
      this.vYw = 0L;
      this.Tza = 0L;
      this.Tzb = "";
      this.Tzc = 0L;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ImageView>
  {
    g(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<View>
  {
    h(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.a<TextStatusEmojiView>
  {
    j(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/emoji/view/EmojiStatusView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.a<EmojiStatusView>
  {
    k(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.a<View>
  {
    l(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$getBelowAnimator$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    implements Animator.AnimatorListener
  {
    m(TextStatusEditActivity paramTextStatusEditActivity) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(291169);
      kotlin.g.b.s.u(paramAnimator, "animation");
      AppMethodBeat.o(291169);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(291160);
      kotlin.g.b.s.u(paramAnimator, "animation");
      TextStatusEditActivity.j(this.Tzd).setVisibility(8);
      AppMethodBeat.o(291160);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(291175);
      kotlin.g.b.s.u(paramAnimator, "animation");
      AppMethodBeat.o(291175);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(291156);
      kotlin.g.b.s.u(paramAnimator, "animation");
      TextStatusEditActivity.j(this.Tzd).setVisibility(0);
      AppMethodBeat.o(291156);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$getUpAnimator$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class n
    implements Animator.AnimatorListener
  {
    n(TextStatusEditActivity paramTextStatusEditActivity) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(291174);
      kotlin.g.b.s.u(paramAnimator, "animation");
      AppMethodBeat.o(291174);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(291168);
      kotlin.g.b.s.u(paramAnimator, "animation");
      AppMethodBeat.o(291168);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(291182);
      kotlin.g.b.s.u(paramAnimator, "animation");
      AppMethodBeat.o(291182);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(291164);
      kotlin.g.b.s.u(paramAnimator, "animation");
      TextStatusEditActivity.j(this.Tzd).setVisibility(0);
      AppMethodBeat.o(291164);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$initMedia$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$DownLoadSuccCallback;", "onSucc", "", "path", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class r
    implements TextStatusEditActivity.b
  {
    r(TextStatusEditActivity paramTextStatusEditActivity) {}
    
    public final void beg(String paramString)
    {
      AppMethodBeat.i(291142);
      kotlin.g.b.s.u(paramString, "path");
      TextStatusEditActivity.d locald = this.Tzd.hJK();
      w localw = this.Tzd.Txn;
      AppCompatActivity localAppCompatActivity = this.Tzd.getContext();
      kotlin.g.b.s.s(localAppCompatActivity, "context");
      locald.a(localw, paramString, (Context)localAppCompatActivity);
      AppMethodBeat.o(291142);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$initSmileyPanel$1$1", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "isCustomSmileyEnable", "", "isDirectlyReturnEmojiInfoInSimilarUI", "isHideSosSearch", "isOpenCustomSmileyEnable", "onClearEditTextView", "", "onCustomEmojiSelected", "onHidePanel", "onSearchDialogShow", "isShow", "dialogHeight", "", "onSendAppMsgCustomEmoji", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "onSendCustomEmoji", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class s
    implements com.tencent.mm.pluginsdk.ui.chat.j
  {
    s(TextStatusEditActivity paramTextStatusEditActivity) {}
    
    public final void cSg()
    {
      AppMethodBeat.i(291140);
      Log.d("MicroMsg.TextStatus.TextStatusEditActivity", "onHidePanel() called");
      AppMethodBeat.o(291140);
    }
    
    public final void cSh()
    {
      AppMethodBeat.i(291152);
      Log.d("MicroMsg.TextStatus.TextStatusEditActivity", "onClearEditTextView() called");
      AppMethodBeat.o(291152);
    }
    
    public final boolean cSi()
    {
      return true;
    }
    
    public final boolean cSj()
    {
      return this.Tzd.TyA < 3;
    }
    
    public final void o(EmojiInfo paramEmojiInfo)
    {
      AppMethodBeat.i(291137);
      Log.d("MicroMsg.TextStatus.TextStatusEditActivity", kotlin.g.b.s.X("onSendCustomEmoji() called with: emoji = ", paramEmojiInfo));
      bh localbh = this.Tzd.hJo();
      if (localbh != null) {
        localbh.Trd += 1;
      }
      this.Tzd.D(paramEmojiInfo);
      AppMethodBeat.o(291137);
    }
    
    public final void y(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(291147);
      Log.d("MicroMsg.TextStatus.TextStatusEditActivity", "onSearchDialogShow() called with: isShow = " + paramBoolean + ", dialogHeight = " + paramInt);
      bh localbh = this.Tzd.hJo();
      if (localbh != null) {
        localbh.Trf += 1;
      }
      AppMethodBeat.o(291147);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ImageView>
  {
    t(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends kotlin.g.b.u
    implements kotlin.g.a.a<TextView>
  {
    u(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ImageView>
  {
    v(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class w
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ImageView>
  {
    w(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class x
    extends kotlin.g.b.u
    implements kotlin.g.a.a<View>
  {
    x(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class y
    extends kotlin.g.b.u
    implements kotlin.g.a.a<View>
  {
    y(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/FrameLayout;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class z
    extends kotlin.g.b.u
    implements kotlin.g.a.a<FrameLayout>
  {
    z(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity
 * JD-Core Version:    0.7.0.1
 */
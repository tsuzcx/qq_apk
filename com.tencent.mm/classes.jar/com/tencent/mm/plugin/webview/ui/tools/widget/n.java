package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.protocal.protobuf.ace;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.fl;
import com.tencent.mm.protocal.protobuf.fm;
import com.tencent.mm.protocal.protobuf.fu;
import com.tencent.mm.protocal.protobuf.fv;
import com.tencent.mm.protocal.protobuf.fy;
import com.tencent.mm.protocal.protobuf.fz;
import com.tencent.mm.protocal.protobuf.of;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g.b.q;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewKeyboardLinearLayout;", "webView", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "isDark", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;ZLandroid/content/Context;Landroid/util/AttributeSet;)V", "actionView", "Landroid/view/View;", "adapter", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;", "callback", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "getCallback", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "setCallback", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;)V", "cancelTv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "commentTopicId", "", "getCommentTopicId", "()J", "setCommentTopicId", "(J)V", "commitBt", "Landroid/widget/Button;", "contentEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "currentKbState", "", "enterId", "getEnterId", "()I", "setEnterId", "(I)V", "hasReadOpenCfg", "isDoingGetMyComment", "isHaokan", "isReplyOpen", "itemShowType", "getItemShowType", "setItemShowType", "kbLayout", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "minHeaderHeight", "getMinHeaderHeight", "setMinHeaderHeight", "myCommentOffset", "getMyCommentOffset", "setMyCommentOffset", "myCommentTitleTv", "Landroid/widget/TextView;", "myCommentTv", "myCommentView", "recyclerView", "Landroid/widget/ListView;", "replyPersonalCommentId", "replyTip", "root", "savePortHeight", "sayFooter", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter;", "getSayFooter", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter;", "sayFooter$delegate", "Lkotlin/Lazy;", "scene", "getScene", "setScene", "subScene", "getSubScene", "setSubScene", "timeLineSessionId", "getTimeLineSessionId", "setTimeLineSessionId", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "weakThis", "Ljava/lang/ref/WeakReference;", "getWeakThis$plugin_webview_release", "()Ljava/lang/ref/WeakReference;", "setWeakThis$plugin_webview_release", "(Ljava/lang/ref/WeakReference;)V", "getWebView", "()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "caculateHeight", "", "newMarginBottom", "checkHeight", "h", "clearPersonalComment", "refreshHeight", "closeComment", "contentEtOnClick", "dealOrientaion", "orientation", "doAppMsgLikeComment", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgLikeCommentReq;", "doAppMsgOperateComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "doReport", "actionType", "fixKeyBoardMargin", "getAppMsgCommentList", "getNavHeightByDisplay", "getReplyHeight", "getRootHeight", "hide", "hideAnimation", "initKeyboardListener", "isShow", "onAddCommentSuccess", "onAppMsgLikeComment", "errType", "errCode", "errMsg", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "onAppMsgOperateComment", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDeleteComment", "onDeleteCommentReply", "onDestroy", "onGetCommentList", "onKeyBackPress", "onNoComment", "onResume", "onTouchClose", "replyToPersonalComment", "replyContent", "personalCommentId", "saveRootHeight", "height", "setData", "setRootHeight", "show", "showAnimation", "showCommentView", "showLayout", "showLayoutReply", "updateData", "resp", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommentListResp;", "clearUpdate", "updateUrl", "curUrl", "Companion", "MPMyCommentItemAdapter", "MPWriteCommentLayoutCallback", "plugin-webview_release"})
public final class n
  extends WebViewKeyboardLinearLayout
{
  public static final n.a JzB;
  private static final String TAG = "MicroMsg.MPWriteCommentLayout";
  private final WebViewKeyboardLinearLayout Jic;
  public int JjT;
  public final WebViewUI JzA;
  private final f Jzh;
  private final WeImageView Jzi;
  private final Button Jzj;
  public final MMEditText Jzk;
  private final ListView Jzl;
  private final View Jzm;
  private final TextView Jzn;
  private final TextView Jzo;
  private final TextView Jzp;
  private b Jzq;
  private boolean Jzr;
  private int Jzs;
  private int Jzt;
  private int Jzu;
  private c Jzv;
  private boolean Jzw;
  private int Jzx;
  private boolean Jzy;
  private boolean Jzz;
  private final boolean dZO;
  private final View gvQ;
  private long iAH;
  int iwc;
  private final View kcT;
  int pHu;
  int pHw;
  int pHx;
  private WeakReference<n> peA;
  int scene;
  private String title;
  String url;
  
  static
  {
    AppMethodBeat.i(82720);
    JzB = new n.a((byte)0);
    TAG = "MicroMsg.MPWriteCommentLayout";
    AppMethodBeat.o(82720);
  }
  
  public n(WebViewUI paramWebViewUI, Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(175710);
    this.JzA = paramWebViewUI;
    this.dZO = false;
    paramWebViewUI = View.inflate(paramContext, 2131495702, (ViewGroup)this);
    if (paramWebViewUI == null)
    {
      paramWebViewUI = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout");
      AppMethodBeat.o(175710);
      throw paramWebViewUI;
    }
    this.Jic = ((WebViewKeyboardLinearLayout)paramWebViewUI);
    paramWebViewUI = findViewById(2131304929);
    kotlin.g.b.p.g(paramWebViewUI, "findViewById(R.id.mp_video_comment_action_layout)");
    this.kcT = paramWebViewUI;
    this.Jzh = kotlin.g.ah((kotlin.g.a.a)new n.j(this));
    paramWebViewUI = findViewById(2131304930);
    kotlin.g.b.p.g(paramWebViewUI, "findViewById(R.id.mp_video_comment_cancel)");
    this.Jzi = ((WeImageView)paramWebViewUI);
    paramWebViewUI = findViewById(2131304932);
    kotlin.g.b.p.g(paramWebViewUI, "findViewById(R.id.mp_video_comment_ok)");
    this.Jzj = ((Button)paramWebViewUI);
    paramWebViewUI = findViewById(2131304931);
    kotlin.g.b.p.g(paramWebViewUI, "findViewById(R.id.mp_video_comment_et)");
    this.Jzk = ((MMEditText)paramWebViewUI);
    paramWebViewUI = findViewById(2131297612);
    kotlin.g.b.p.g(paramWebViewUI, "findViewById(R.id.biz_video_my_comment_list)");
    this.Jzl = ((ListView)paramWebViewUI);
    paramWebViewUI = findViewById(2131304946);
    kotlin.g.b.p.g(paramWebViewUI, "findViewById(R.id.mp_write_comment_root)");
    this.gvQ = paramWebViewUI;
    paramWebViewUI = findViewById(2131304945);
    kotlin.g.b.p.g(paramWebViewUI, "findViewById(R.id.mp_vid…rite_comment_scroll_view)");
    this.Jzm = paramWebViewUI;
    paramWebViewUI = findViewById(2131297613);
    kotlin.g.b.p.g(paramWebViewUI, "findViewById(R.id.biz_video_my_comment_tv)");
    this.Jzn = ((TextView)paramWebViewUI);
    paramWebViewUI = findViewById(2131304935);
    kotlin.g.b.p.g(paramWebViewUI, "findViewById(R.id.mp_video_my_comment_title)");
    this.Jzo = ((TextView)paramWebViewUI);
    paramWebViewUI = findViewById(2131297619);
    kotlin.g.b.p.g(paramWebViewUI, "findViewById(R.id.biz_video_reply_tip)");
    this.Jzp = ((TextView)paramWebViewUI);
    this.JjT = -1;
    this.url = "";
    this.title = "";
    this.peA = new WeakReference(this);
    getSayFooter().setMMEditText(this.Jzk);
    getSayFooter().setVisibility(8);
    this.Jzk.setOnClickListener((View.OnClickListener)new n.1(this));
    this.Jzk.setOnLongClickListener((View.OnLongClickListener)new n.2(this));
    this.Jic.setOnTouchListener((View.OnTouchListener)new n.3(this));
    this.gvQ.setOnClickListener((View.OnClickListener)n.4.JzD);
    int i = getRootHeight();
    if (i > 0)
    {
      paramWebViewUI = this.gvQ.getLayoutParams();
      if (paramWebViewUI == null)
      {
        paramWebViewUI = new t("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        AppMethodBeat.o(175710);
        throw paramWebViewUI;
      }
      paramWebViewUI.height = i;
      this.gvQ.setLayoutParams(paramWebViewUI);
    }
    if (!KeyBoardUtil.isPortOrientation(paramContext)) {
      ahg(2);
    }
    this.Jzi.setOnClickListener((View.OnClickListener)new n.5(this));
    this.Jzj.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82697);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if (n.j(this.JzC))
        {
          paramAnonymousView = n.b(this.JzC).getText().toString();
          localObject = this.JzC.getWebView().IBw;
          if (localObject != null) {
            ((com.tencent.mm.plugin.webview.d.h)localObject).w(1, paramAnonymousView, 1);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(82697);
          return;
          this.JzC.getWebView().hideVKB();
          if (n.d(this.JzC).fjI()) {
            n.d(this.JzC).fjJ();
          }
          paramAnonymousView = new fy();
          paramAnonymousView.content = n.b(this.JzC).getText().toString();
          paramAnonymousView.pTI = 1;
          if (n.k(this.JzC) != 0)
          {
            paramAnonymousView.pTI = 3;
            paramAnonymousView.KJJ = n.k(this.JzC);
          }
          this.JzC.a(paramAnonymousView);
          com.tencent.mm.plugin.webview.i.a.agn(10);
        }
      }
    });
    this.Jzk.addTextChangedListener((TextWatcher)new n.7(this));
    paramWebViewUI = this.Jzj;
    paramContext = this.Jzk.getText();
    kotlin.g.b.p.g(paramContext, "contentEt.text");
    if (((CharSequence)paramContext).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramWebViewUI.setEnabled(bool);
      this.Jzk.setOnTouchListener((View.OnTouchListener)new n.8(this));
      this.Jzp.setVisibility(8);
      AppMethodBeat.o(175710);
      return;
    }
  }
  
  private final void ahg(int paramInt)
  {
    AppMethodBeat.i(82729);
    switch (paramInt)
    {
    default: 
      if (this.Jic.geD()) {
        ahh(this.Jic.getKeyBoardHeight());
      }
      break;
    }
    for (;;)
    {
      this.Jzk.setMinLines(5);
      AppMethodBeat.o(82729);
      return;
      paramInt = au.getStatusBarHeight(getContext());
      setRootHeight(au.az(getContext()).y - paramInt);
      this.Jzk.setMinLines(3);
      AppMethodBeat.o(82729);
      return;
      if (this.Jzs != 0) {
        setRootHeight(this.Jzs);
      } else {
        ahh(0);
      }
    }
  }
  
  private final void ahh(int paramInt)
  {
    AppMethodBeat.i(82730);
    Object localObject = this.gvQ.getLayoutParams();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(82730);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.LayoutParams)localObject).height = (this.Jzk.getHeight() + this.kcT.getHeight() + getNavHeightByDisplay() + com.tencent.mm.cb.a.fromDPToPix(getContext(), com.tencent.mm.cb.a.E(getContext(), 60) + 16) + getReplyHeight() + paramInt);
    ((ViewGroup.LayoutParams)localObject).height = ahi(((ViewGroup.LayoutParams)localObject).height);
    this.gvQ.setLayoutParams((ViewGroup.LayoutParams)localObject);
    ahj(((ViewGroup.LayoutParams)localObject).height);
    AppMethodBeat.o(82730);
  }
  
  private final int ahi(int paramInt)
  {
    AppMethodBeat.i(82732);
    int j = au.getStatusBarHeight(getContext());
    int k = au.az(getContext()).y;
    int i = k - j;
    if (paramInt > i) {}
    for (;;)
    {
      AppMethodBeat.o(82732);
      return i;
      i = paramInt;
      if (this.Jzu > 0)
      {
        int m = com.tencent.mm.cb.a.fromDPToPix(getContext(), 20);
        i = paramInt;
        if (paramInt < k - this.Jzu - j + m) {
          i = k - j - this.Jzu + m;
        }
      }
    }
  }
  
  private final void ahj(int paramInt)
  {
    AppMethodBeat.i(82733);
    if (KeyBoardUtil.isPortOrientation(getContext())) {
      this.Jzs = paramInt;
    }
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("MPWriteCommentLayout");
    localMultiProcessMMKV.encode("MPWriteCommentRootHeight", paramInt);
    localMultiProcessMMKV.apply();
    AppMethodBeat.o(82733);
  }
  
  private final int getNavHeightByDisplay()
  {
    AppMethodBeat.i(82739);
    Point localPoint = au.az(getContext());
    Object localObject = this.JzA.getWindow();
    if (localObject != null) {}
    for (localObject = ((Window)localObject).getDecorView();; localObject = null)
    {
      Rect localRect = new Rect();
      if (localObject != null) {
        ((View)localObject).getWindowVisibleDisplayFrame(localRect);
      }
      int i = localRect.bottom;
      int j = localPoint.y - i - this.Jic.getKeyBoardHeight();
      Log.v(TAG, "getNavHeightByDisplay screenHeight = " + i + ", realSize = " + localPoint.y);
      i = j;
      if (j < 0)
      {
        i = au.aD(getContext());
        Log.v(TAG, "getNavHeightByDisplay error");
      }
      Log.v(TAG, "getNavHeightByDisplay h = %s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(82739);
      return i;
    }
  }
  
  private final int getReplyHeight()
  {
    AppMethodBeat.i(182681);
    if (this.Jzt != 0)
    {
      int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 38);
      AppMethodBeat.o(182681);
      return i;
    }
    AppMethodBeat.o(182681);
    return 0;
  }
  
  private final int getRootHeight()
  {
    AppMethodBeat.i(82734);
    int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 635);
    AppMethodBeat.o(82734);
    return i;
  }
  
  private final void giA()
  {
    AppMethodBeat.i(182680);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(250L);
    localTranslateAnimation.setFillAfter(false);
    this.gvQ.clearAnimation();
    this.gvQ.startAnimation((Animation)localTranslateAnimation);
    AppMethodBeat.o(182680);
  }
  
  private final void giB()
  {
    AppMethodBeat.i(82737);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    localTranslateAnimation.setDuration(150L);
    localTranslateAnimation.setFillAfter(false);
    localTranslateAnimation.setAnimationListener((Animation.AnimationListener)new g(this));
    this.gvQ.clearAnimation();
    this.gvQ.startAnimation((Animation)localTranslateAnimation);
    AppMethodBeat.o(82737);
  }
  
  private final void gix()
  {
    AppMethodBeat.i(82723);
    View localView = this.Jzm;
    Context localContext = getContext();
    kotlin.g.b.p.g(localContext, "context");
    localView.setBackgroundColor(o.e(2130968857, localContext));
    this.Jzn.setVisibility(8);
    AppMethodBeat.o(82723);
  }
  
  private void giz()
  {
    AppMethodBeat.i(175703);
    this.Jzk.setText((CharSequence)"");
    this.Jzx = 0;
    getAppMsgCommentList();
    AppMethodBeat.o(175703);
  }
  
  private final void setRootHeight(int paramInt)
  {
    AppMethodBeat.i(82731);
    Object localObject = this.gvQ.getLayoutParams();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(82731);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.LayoutParams)localObject).height = ahi(paramInt);
    this.gvQ.setLayoutParams((ViewGroup.LayoutParams)localObject);
    ahj(((ViewGroup.LayoutParams)localObject).height);
    AppMethodBeat.o(82731);
  }
  
  private final void show()
  {
    AppMethodBeat.i(82735);
    this.gvQ.clearAnimation();
    setVisibility(0);
    giA();
    c localc = this.Jzv;
    if (localc != null)
    {
      localc.onShow();
      AppMethodBeat.o(82735);
      return;
    }
    AppMethodBeat.o(82735);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2)
  {
    this.scene = paramInt1;
    this.pHw = paramInt2;
    this.iwc = paramInt3;
    this.pHu = paramInt4;
    this.url = paramString1;
    this.title = paramString2;
  }
  
  public final void a(fy paramfy)
  {
    AppMethodBeat.i(82741);
    kotlin.g.b.p.h(paramfy, "req");
    paramfy.scene = this.scene;
    paramfy.KIL = this.pHw;
    paramfy.url = this.url;
    paramfy.title = this.title;
    paramfy.KJO = System.currentTimeMillis();
    paramfy.KIJ = this.iwc;
    paramfy.session_id = this.pHx;
    paramfy.KIK = this.pHu;
    paramfy.KIM = this.iAH;
    Object localObject = new com.tencent.mm.ak.d.a();
    ((com.tencent.mm.ak.d.a)localObject).c((com.tencent.mm.bw.a)paramfy);
    ((com.tencent.mm.ak.d.a)localObject).d((com.tencent.mm.bw.a)new fz());
    ((com.tencent.mm.ak.d.a)localObject).MB("/cgi-bin/mmbiz-bin/appmsg/appmsg_operate_comment");
    ((com.tencent.mm.ak.d.a)localObject).sG(2617);
    ((com.tencent.mm.ak.d.a)localObject).sI(0);
    ((com.tencent.mm.ak.d.a)localObject).sJ(0);
    IPCRunCgi.a(((com.tencent.mm.ak.d.a)localObject).aXF(), (IPCRunCgi.a)new e(this));
    paramfy = this.JzA;
    localObject = p.JAu;
    localObject = getContext().getString(2131756029);
    kotlin.g.b.p.g(localObject, "context.getString(R.string.app_waiting)");
    Context localContext = getContext();
    kotlin.g.b.p.g(localContext, "context");
    paramfy.a(p.a((String)localObject, localContext, this.JzA.gfk()));
    AppMethodBeat.o(82741);
  }
  
  public final boolean bJw()
  {
    AppMethodBeat.i(82738);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(82738);
      return true;
    }
    AppMethodBeat.o(82738);
    return false;
  }
  
  public final void bbn(String paramString)
  {
    AppMethodBeat.i(175701);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(175701);
      return;
    }
    this.url = paramString;
    AppMethodBeat.o(175701);
  }
  
  public final void getAppMsgCommentList()
  {
    AppMethodBeat.i(82740);
    fl localfl = new fl();
    localfl.url = this.url;
    if (this.Jzw)
    {
      AppMethodBeat.o(82740);
      return;
    }
    localfl.offset = this.Jzx;
    if (this.Jzx == -1)
    {
      Log.i(TAG, "no more my comment");
      AppMethodBeat.o(82740);
      return;
    }
    this.Jzw = true;
    localfl.pTI = 2;
    localfl.scene = this.scene;
    localfl.KIL = this.pHw;
    localfl.KIJ = this.iwc;
    localfl.session_id = this.pHx;
    localfl.KIK = this.pHu;
    localfl.KIM = this.iAH;
    com.tencent.mm.ak.d.a locala = new com.tencent.mm.ak.d.a();
    locala.c((com.tencent.mm.bw.a)localfl);
    locala.d((com.tencent.mm.bw.a)new fm());
    locala.MB("/cgi-bin/mmbiz-bin/appmsg/appmsg_comment_list");
    locala.sG(2866);
    locala.sI(0);
    locala.sJ(0);
    IPCRunCgi.a(locala.aXF(), (IPCRunCgi.a)new f(this));
    com.tencent.mm.plugin.webview.i.a.agn(7);
    AppMethodBeat.o(82740);
  }
  
  public final c getCallback()
  {
    return this.Jzv;
  }
  
  public final long getCommentTopicId()
  {
    return this.iAH;
  }
  
  public final int getEnterId()
  {
    return this.pHu;
  }
  
  public final int getItemShowType()
  {
    return this.iwc;
  }
  
  public final int getMinHeaderHeight()
  {
    return this.Jzu;
  }
  
  public final int getMyCommentOffset()
  {
    return this.Jzx;
  }
  
  public final MPSmileyFooter getSayFooter()
  {
    AppMethodBeat.i(82721);
    MPSmileyFooter localMPSmileyFooter = (MPSmileyFooter)this.Jzh.getValue();
    AppMethodBeat.o(82721);
    return localMPSmileyFooter;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final int getSubScene()
  {
    return this.pHw;
  }
  
  public final int getTimeLineSessionId()
  {
    return this.pHx;
  }
  
  public final String getTitle()
  {
    return this.title;
  }
  
  public final String getUrl()
  {
    return this.url;
  }
  
  public final WeakReference<n> getWeakThis$plugin_webview_release()
  {
    return this.peA;
  }
  
  public final WebViewUI getWebView()
  {
    return this.JzA;
  }
  
  public final boolean giC()
  {
    AppMethodBeat.i(175708);
    if (!this.Jzy) {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rTY, 0) != 1) {
        break label86;
      }
    }
    label86:
    for (boolean bool = true;; bool = false)
    {
      this.Jzz = bool;
      this.Jzy = true;
      Log.v(TAG, "isReplyOpen = " + this.Jzz);
      bool = this.Jzz;
      AppMethodBeat.o(175708);
      return bool;
    }
  }
  
  public final void giy()
  {
    AppMethodBeat.i(82724);
    this.Jic.setOnkbdStateListener((KeyboardLinearLayout.a)new h(this));
    AppMethodBeat.o(82724);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(82736);
    if (!bJw())
    {
      AppMethodBeat.o(82736);
      return;
    }
    if (getSayFooter().fjI()) {
      getSayFooter().fjJ();
    }
    giB();
    this.JzA.hideVKB();
    this.Jzx = 0;
    Object localObject = this.Jzq;
    if (localObject != null) {
      ((b)localObject).clear();
    }
    localObject = this.Jzv;
    if (localObject != null)
    {
      ((c)localObject).onHide();
      AppMethodBeat.o(82736);
      return;
    }
    AppMethodBeat.o(82736);
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(82728);
    kotlin.g.b.p.h(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    ahg(paramConfiguration.orientation);
    if (getSayFooter().fjI()) {
      getSayFooter().fjJ();
    }
    AppMethodBeat.o(82728);
  }
  
  public final void setCallback(c paramc)
  {
    this.Jzv = paramc;
  }
  
  public final void setCommentTopicId(long paramLong)
  {
    this.iAH = paramLong;
  }
  
  public final void setEnterId(int paramInt)
  {
    this.pHu = paramInt;
  }
  
  public final void setItemShowType(int paramInt)
  {
    this.iwc = paramInt;
  }
  
  public final void setMinHeaderHeight(int paramInt)
  {
    this.Jzu = paramInt;
  }
  
  public final void setMyCommentOffset(int paramInt)
  {
    this.Jzx = paramInt;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public final void setSubScene(int paramInt)
  {
    this.pHw = paramInt;
  }
  
  public final void setTimeLineSessionId(int paramInt)
  {
    this.pHx = paramInt;
  }
  
  public final void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public final void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public final void setWeakThis$plugin_webview_release(WeakReference<n> paramWeakReference)
  {
    AppMethodBeat.i(82722);
    kotlin.g.b.p.h(paramWeakReference, "<set-?>");
    this.peA = paramWeakReference;
    AppMethodBeat.o(82722);
  }
  
  public final void x(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(175705);
    kotlin.g.b.p.h(paramString, "replyContent");
    this.Jzt = paramInt;
    this.Jzo.setText((CharSequence)getContext().getString(2131756711));
    this.Jzp.setVisibility(0);
    TextView localTextView = this.Jzp;
    Context localContext = getContext();
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = "";
    }
    localTextView.setText((CharSequence)localContext.getString(2131756710, new Object[] { str }));
    this.Jzk.setHint((CharSequence)getContext().getString(2131756709));
    if (paramBoolean)
    {
      this.Jzm.scrollTo(0, 0);
      this.Jzk.requestFocus();
      paramString = getContext().getSystemService("input_method");
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        AppMethodBeat.o(175705);
        throw paramString;
      }
      paramString = (InputMethodManager)paramString;
      if (paramString != null)
      {
        paramString.showSoftInput((View)this.Jzk, 0);
        AppMethodBeat.o(175705);
        return;
      }
    }
    AppMethodBeat.o(175705);
  }
  
  public final void xV(int paramInt)
  {
    AppMethodBeat.i(175709);
    String str2 = Uri.parse(this.url).getQueryParameter("clicktime");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.url);
    localStringBuilder.append(",");
    localStringBuilder.append(this.scene);
    localStringBuilder.append(",");
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = "";
    }
    localStringBuilder.append(str1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",");
    localStringBuilder.append(System.currentTimeMillis());
    str1 = localStringBuilder.toString();
    Log.v(TAG, str1);
    com.tencent.mm.plugin.report.service.h.CyF.kvStat(19265, str1);
    AppMethodBeat.o(175709);
  }
  
  public final void zw(boolean paramBoolean)
  {
    AppMethodBeat.i(82725);
    xV(1);
    zy(false);
    zx(paramBoolean);
    AppMethodBeat.o(82725);
  }
  
  public final void zx(boolean paramBoolean)
  {
    AppMethodBeat.i(175702);
    this.Jzr = paramBoolean;
    show();
    if (paramBoolean)
    {
      this.Jzn.setVisibility(8);
      this.Jzo.setText((CharSequence)getContext().getString(2131756812));
      this.Jzk.setHint(2131756814);
      this.Jzj.setText(2131755976);
      localObject = this.Jzj;
      localContext = getContext();
      kotlin.g.b.p.g(localContext, "context");
      ((Button)localObject).setBackground(localContext.getResources().getDrawable(2131231357));
      localObject = (InputFilter)new InputFilter.LengthFilter(200);
      this.Jzk.setFilters(new InputFilter[] { localObject });
      AppMethodBeat.o(175702);
      return;
    }
    getAppMsgCommentList();
    this.Jzj.setText(2131756804);
    Object localObject = this.Jzj;
    Context localContext = getContext();
    kotlin.g.b.p.g(localContext, "context");
    ((Button)localObject).setBackground(o.ia(localContext));
    AppMethodBeat.o(175702);
  }
  
  public final void zy(boolean paramBoolean)
  {
    AppMethodBeat.i(175707);
    if (this.Jzt != 0)
    {
      this.Jzt = 0;
      if (paramBoolean) {
        ahg(KeyBoardUtil.getScreenOrientation(getContext()));
      }
    }
    this.Jzp.setText((CharSequence)"");
    this.Jzp.setVisibility(8);
    this.Jzk.setHint((CharSequence)getContext().getString(2131756824));
    this.Jzo.setText((CharSequence)getContext().getString(2131756822));
    AppMethodBeat.o(175707);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "controller", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "isDarkPanel", "", "(Landroid/content/Context;Ljava/util/LinkedList;Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;Z)V", "getController", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "setController", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;)V", "viewPool", "Ljava/util/ArrayList;", "Landroid/view/View;", "getViewPool", "()Ljava/util/ArrayList;", "clear", "", "getCommentView", "getCount", "", "getItem", "position", "getItemId", "", "i", "getLastInvalidReply", "", "info", "getView", "convertView", "viewGroup", "Landroid/view/ViewGroup;", "onDeleteComment", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "onDeleteCommentReply", "showLikeStatus", "itemView", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "reply", "Lcom/tencent/mm/protocal/protobuf/CommentReply;", "isReply", "update", "items", "", "clearUpdate", "updateCommentContentView", "updateReplyView", "index", "BizCommentContent", "BizCommentViewHolder", "Companion", "plugin-webview_release"})
  public static final class b
    extends BaseAdapter
  {
    private static com.tencent.mm.av.a.a.c JzH;
    public static final n.b.c JzI;
    static final String TAG = "MicroMsg.MPMyCommentItemAdapter";
    final ArrayList<View> JzE;
    n JzF;
    private boolean JzG;
    private final Context context;
    final LinkedList<of> gCs;
    
    static
    {
      AppMethodBeat.i(82709);
      JzI = new n.b.c((byte)0);
      TAG = "MicroMsg.MPMyCommentItemAdapter";
      JzH = new c.a().tz(2131100173).bdp().dr(120, 120).a((com.tencent.mm.av.a.c.c)new com.tencent.mm.pluginsdk.ui.applet.n()).a((com.tencent.mm.av.a.c.a)new e()).bdt().aw(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 3)).bdv();
      AppMethodBeat.o(82709);
    }
    
    public b(Context paramContext, LinkedList<of> paramLinkedList, n paramn, boolean paramBoolean)
    {
      AppMethodBeat.i(162324);
      this.context = paramContext;
      this.gCs = paramLinkedList;
      this.JzF = paramn;
      this.JzG = paramBoolean;
      this.JzE = new ArrayList();
      AppMethodBeat.o(162324);
    }
    
    public static String a(of paramof)
    {
      AppMethodBeat.i(182678);
      kotlin.g.b.p.h(paramof, "info");
      String str = paramof.content;
      int i;
      if ((paramof.KTJ != null) && (!Util.isNullOrNil((List)paramof.KTJ.LmP)))
      {
        i = paramof.KTJ.LmP.size() - 1;
        if (i >= 0) {
          if (((ace)paramof.KTJ.LmP.get(i)).LmO != 0) {}
        }
      }
      for (paramof = ((ace)paramof.KTJ.LmP.get(i)).content;; paramof = str)
      {
        kotlin.g.b.p.g(paramof, "reply");
        AppMethodBeat.o(182678);
        return paramof;
        i -= 1;
        break;
      }
    }
    
    private void a(final a parama, final of paramof, final ace paramace, final boolean paramBoolean)
    {
      AppMethodBeat.i(175697);
      kotlin.g.b.p.h(parama, "itemView");
      kotlin.g.b.p.h(paramof, "info");
      Object localObject;
      Integer localInteger1;
      label55:
      Integer localInteger2;
      label73:
      String str1;
      label105:
      int i;
      if (paramBoolean) {
        if (paramace != null)
        {
          localObject = Integer.valueOf(paramace.LmN);
          if (!paramBoolean) {
            break label352;
          }
          if (paramace == null) {
            break label346;
          }
          localInteger1 = Integer.valueOf(paramace.LmL);
          if (!paramBoolean) {
            break label370;
          }
          if (paramace == null) {
            break label364;
          }
          localInteger2 = Integer.valueOf(paramace.LmM);
          String str2 = TAG;
          StringBuilder localStringBuilder = new StringBuilder("showLikeStatus content = ");
          if (!paramBoolean) {
            break label388;
          }
          if (paramace == null) {
            break label382;
          }
          str1 = paramace.content;
          Log.v(str2, str1 + ", isElected = " + localObject + ", likeNum = " + localInteger1 + ", likeStatus = " + localInteger2);
          parama.JzM.setOnClickListener(null);
          if (localObject != null) {
            break label397;
          }
          label166:
          localObject = parama.JzO;
          kotlin.g.b.p.g(localObject, "itemView.notChosen");
          ((TextView)localObject).setVisibility(8);
          localObject = parama.JzM;
          kotlin.g.b.p.g(localObject, "itemView.likeThumb");
          ((ImageView)localObject).setVisibility(0);
          localObject = parama.hPG;
          kotlin.g.b.p.g(localObject, "itemView.likeTv");
          ((TextView)localObject).setVisibility(8);
          if (localInteger1 != null)
          {
            localObject = parama.hPG;
            kotlin.g.b.p.g(localObject, "itemView.likeTv");
            if (localInteger1.intValue() <= 0) {
              break label465;
            }
            i = 0;
            label258:
            ((TextView)localObject).setVisibility(i);
            parama.hPG.setText((CharSequence)String.valueOf(localInteger1.intValue()));
          }
          if (localInteger2 != null) {
            break label472;
          }
          label288:
          parama.JzM.setImageResource(2131689713);
        }
      }
      for (;;)
      {
        parama.JzM.setOnClickListener((View.OnClickListener)new d(this, paramBoolean, paramace, paramof, parama));
        AppMethodBeat.o(175697);
        return;
        localObject = null;
        break;
        localObject = Integer.valueOf(paramof.KTI);
        break;
        label346:
        localInteger1 = null;
        break label55;
        label352:
        localInteger1 = Integer.valueOf(paramof.KSR);
        break label55;
        label364:
        localInteger2 = null;
        break label73;
        label370:
        localInteger2 = Integer.valueOf(paramof.KSS);
        break label73;
        label382:
        str1 = null;
        break label105;
        label388:
        str1 = paramof.content;
        break label105;
        label397:
        if (((Integer)localObject).intValue() != 0) {
          break label166;
        }
        paramof = parama.JzO;
        kotlin.g.b.p.g(paramof, "itemView.notChosen");
        paramof.setVisibility(0);
        paramof = parama.JzM;
        kotlin.g.b.p.g(paramof, "itemView.likeThumb");
        paramof.setVisibility(8);
        parama = parama.hPG;
        kotlin.g.b.p.g(parama, "itemView.likeTv");
        parama.setVisibility(8);
        AppMethodBeat.o(175697);
        return;
        label465:
        i = 8;
        break label258;
        label472:
        if (localInteger2.intValue() != 0) {
          break label288;
        }
        parama.JzM.setImageResource(2131689712);
      }
    }
    
    private of ahk(int paramInt)
    {
      AppMethodBeat.i(82704);
      of localof = (of)j.L((List)this.gCs, paramInt);
      AppMethodBeat.o(82704);
      return localof;
    }
    
    public final void clear()
    {
      AppMethodBeat.i(82703);
      this.gCs.clear();
      notifyDataSetChanged();
      AppMethodBeat.o(82703);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(82706);
      int i = this.gCs.size();
      AppMethodBeat.o(82706);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(82707);
      kotlin.g.b.p.h(paramViewGroup, "viewGroup");
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.context).inflate(2131495690, null, false);
        kotlin.g.b.p.g(paramView, "convertView");
        paramViewGroup = new b(paramView);
        paramView.setTag(paramViewGroup);
      }
      final of localof;
      Object localObject2;
      Object localObject1;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      for (;;)
      {
        localof = ahk(paramInt);
        if (localof == null) {
          break label1444;
        }
        kotlin.g.b.p.h(localof, "info");
        com.tencent.mm.av.a.a.bdb().a(localof.iwv, paramViewGroup.keC, JzH);
        localObject2 = paramViewGroup.JzR;
        localObject1 = paramViewGroup.JzU;
        kotlin.g.b.p.h(localObject1, "itemView");
        if (localof != null)
        {
          localObject3 = ((b)localObject2).context;
          localObject4 = (CharSequence)localof.qFU;
          localObject5 = ((a)localObject1).qbF;
          kotlin.g.b.p.g(localObject5, "itemView.nickName");
          localObject3 = com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject3, (CharSequence)localObject4, ((TextView)localObject5).getTextSize());
          localObject4 = ((a)localObject1).qbF;
          kotlin.g.b.p.g(localObject4, "itemView.nickName");
          ((TextView)localObject4).setText((CharSequence)localObject3);
          localObject3 = ((b)localObject2).context;
          localObject4 = (CharSequence)localof.content;
          localObject5 = ((a)localObject1).JzJ;
          kotlin.g.b.p.g(localObject5, "itemView.desc");
          localObject3 = com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject3, (CharSequence)localObject4, ((NeatTextView)localObject5).getTextSize());
          ((a)localObject1).JzJ.aw((CharSequence)localObject3);
          ((a)localObject1).JzK.setIconColor(((b)localObject2).context.getResources().getColor(2131099783));
          localObject3 = ((a)localObject1).JzK;
          kotlin.g.b.p.g(localObject3, "itemView.deleteIv");
          ((WeImageView)localObject3).setVisibility(0);
          localObject3 = ((a)localObject1).JzL;
          kotlin.g.b.p.g(localObject3, "itemView.deleteSplit");
          ((ImageView)localObject3).setVisibility(0);
          ((a)localObject1).JzK.setOnClickListener((View.OnClickListener)new e((b)localObject2, localof));
          ((b)localObject2).a((a)localObject1, localof, null, false);
          localObject2 = ((a)localObject1).JzP;
          kotlin.g.b.p.g(localObject2, "itemView.replyPrefix");
          ((ImageView)localObject2).setVisibility(8);
          localObject1 = ((a)localObject1).JzQ;
          kotlin.g.b.p.g(localObject1, "itemView.sameReplyPrefix");
          ((ImageView)localObject1).setVisibility(4);
        }
        localObject1 = paramViewGroup.JzV;
        kotlin.g.b.p.g(localObject1, "txtReply");
        ((TextView)localObject1).setVisibility(8);
        if (!n.a(paramViewGroup.JzR.JzF)) {
          break label1444;
        }
        localObject1 = paramViewGroup.JzV;
        kotlin.g.b.p.g(localObject1, "txtReply");
        ((TextView)localObject1).setVisibility(0);
        paramViewGroup.JzV.setOnClickListener((View.OnClickListener)new n.b.b.a(paramViewGroup, localof));
        localObject1 = ((Iterable)paramViewGroup.hXy).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (View)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            paramViewGroup.EAe.removeView((View)localObject2);
            paramViewGroup.JzR.JzE.add(localObject2);
          }
        }
        paramViewGroup = paramView.getTag();
        if (paramViewGroup == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout.MPMyCommentItemAdapter.BizCommentViewHolder");
          AppMethodBeat.o(82707);
          throw paramView;
        }
        paramViewGroup = (b)paramViewGroup;
      }
      paramViewGroup.hXy.clear();
      int i;
      if ((localof.KTJ != null) && (localof.KTJ.LmP != null) && (localof.KTJ.LmP.size() > 0))
      {
        localObject1 = localof.KTJ.LmP;
        kotlin.g.b.p.g(localObject1, "replyList");
        localObject2 = ((Iterable)localObject1).iterator();
        i = 0;
      }
      for (;;)
      {
        int j;
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = ((Iterator)localObject2).next();
          j = i + 1;
          if (i < 0) {
            j.hxH();
          }
          localObject3 = (ace)localObject1;
          localObject1 = paramViewGroup.JzR;
          label719:
          Context localContext;
          CharSequence localCharSequence;
          Object localObject6;
          if (((b)localObject1).JzE.size() > 0)
          {
            localObject1 = ((b)localObject1).JzE.remove(0);
            kotlin.g.b.p.g(localObject1, "viewPool.removeAt(0)");
            localObject1 = (View)localObject1;
            paramViewGroup.hXy.add(localObject1);
            paramViewGroup.EAe.addView((View)localObject1);
            localObject4 = paramViewGroup.JzR;
            kotlin.g.b.p.g(localObject3, "reply");
            localObject1 = new a(paramViewGroup.JzR, (View)localObject1);
            kotlin.g.b.p.h(localObject3, "reply");
            kotlin.g.b.p.h(localObject1, "itemView");
            if (localof == null) {
              break label1507;
            }
            localObject5 = (kotlin.g.a.b)new g((b)localObject4, (a)localObject1, localof);
            if (kotlin.g.b.p.j(localof.openid, ((ace)localObject3).openid) != true) {
              break label1220;
            }
            if (!((Boolean)((kotlin.g.a.b)localObject5).invoke(Integer.valueOf(((ace)localObject3).LmO))).booleanValue())
            {
              localObject5 = ((a)localObject1).qbF;
              kotlin.g.b.p.g(localObject5, "itemView.nickName");
              localContext = ((b)localObject4).context;
              localCharSequence = (CharSequence)localof.qFU;
              localObject6 = ((a)localObject1).qbF;
              kotlin.g.b.p.g(localObject6, "itemView.nickName");
              ((TextView)localObject5).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(localContext, localCharSequence, ((TextView)localObject6).getTextSize()));
              localObject5 = ((a)localObject1).JzJ;
              localContext = ((b)localObject4).context;
              localCharSequence = (CharSequence)((ace)localObject3).content;
              localObject6 = ((a)localObject1).JzJ;
              kotlin.g.b.p.g(localObject6, "itemView.desc");
              ((NeatTextView)localObject5).aw((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(localContext, localCharSequence, ((NeatTextView)localObject6).getTextSize()));
              ((a)localObject1).JzK.setIconColor(((b)localObject4).context.getResources().getColor(2131099783));
              localObject5 = ((a)localObject1).JzK;
              kotlin.g.b.p.g(localObject5, "itemView.deleteIv");
              ((WeImageView)localObject5).setVisibility(0);
              localObject5 = ((a)localObject1).JzL;
              kotlin.g.b.p.g(localObject5, "itemView.deleteSplit");
              ((ImageView)localObject5).setVisibility(0);
              ((b)localObject4).a((a)localObject1, localof, (ace)localObject3, true);
              ((a)localObject1).JzK.setOnClickListener((View.OnClickListener)new f((b)localObject4, localof, (ace)localObject3));
            }
            label1071:
            localObject4 = ((a)localObject1).JzP;
            kotlin.g.b.p.g(localObject4, "itemView.replyPrefix");
            ((ImageView)localObject4).setVisibility(0);
            localObject4 = ((a)localObject1).JzQ;
            kotlin.g.b.p.g(localObject4, "itemView.sameReplyPrefix");
            ((ImageView)localObject4).setVisibility(4);
            if (i + 1 < localof.KTJ.LmP.size())
            {
              localObject1 = ((a)localObject1).JzQ;
              kotlin.g.b.p.g(localObject1, "itemView.sameReplyPrefix");
              if (!kotlin.g.b.p.j(((ace)localObject3).openid, ((ace)localof.KTJ.LmP.get(i + 1)).openid)) {
                break label1438;
              }
            }
          }
          label1438:
          for (i = 0;; i = 4)
          {
            ((ImageView)localObject1).setVisibility(i);
            i = j;
            break;
            localObject1 = View.inflate(((b)localObject1).context, 2131495689, null);
            kotlin.g.b.p.g(localObject1, "View.inflate(context, R.…mment_content_item, null)");
            break label719;
            label1220:
            if (((Boolean)((kotlin.g.a.b)localObject5).invoke(Integer.valueOf(((ace)localObject3).LmO))).booleanValue()) {
              break label1071;
            }
            localObject5 = ((a)localObject1).qbF;
            kotlin.g.b.p.g(localObject5, "itemView.nickName");
            localContext = ((b)localObject4).context;
            localCharSequence = (CharSequence)((b)localObject4).context.getResources().getString(2131763166);
            localObject6 = ((a)localObject1).qbF;
            kotlin.g.b.p.g(localObject6, "itemView.nickName");
            ((TextView)localObject5).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(localContext, localCharSequence, ((TextView)localObject6).getTextSize()));
            localObject5 = ((a)localObject1).JzJ;
            localContext = ((b)localObject4).context;
            localCharSequence = (CharSequence)((ace)localObject3).content;
            localObject6 = ((a)localObject1).JzJ;
            kotlin.g.b.p.g(localObject6, "itemView.desc");
            ((NeatTextView)localObject5).aw((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(localContext, localCharSequence, ((NeatTextView)localObject6).getTextSize()));
            localObject5 = ((a)localObject1).JzK;
            kotlin.g.b.p.g(localObject5, "itemView.deleteIv");
            ((WeImageView)localObject5).setVisibility(8);
            localObject5 = ((a)localObject1).JzL;
            kotlin.g.b.p.g(localObject5, "itemView.deleteSplit");
            ((ImageView)localObject5).setVisibility(8);
            ((b)localObject4).a((a)localObject1, localof, (ace)localObject3, true);
            break label1071;
          }
        }
        else
        {
          label1444:
          if (paramInt == getCount() - 1)
          {
            paramViewGroup = paramViewGroup.JzT;
            kotlin.g.b.p.g(paramViewGroup, "holder.endlineLayout");
            paramViewGroup.setVisibility(0);
            this.JzF.getAppMsgCommentList();
          }
          for (;;)
          {
            AppMethodBeat.o(82707);
            return paramView;
            paramViewGroup = paramViewGroup.JzT;
            kotlin.g.b.p.g(paramViewGroup, "holder.endlineLayout");
            paramViewGroup.setVisibility(8);
          }
        }
        label1507:
        i = j;
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;Landroid/view/View;)V", "deleteIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getDeleteIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setDeleteIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "deleteSplit", "Landroid/widget/ImageView;", "getDeleteSplit", "()Landroid/widget/ImageView;", "desc", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "getDesc", "()Lcom/tencent/neattextview/textview/view/NeatTextView;", "setDesc", "(Lcom/tencent/neattextview/textview/view/NeatTextView;)V", "likeThumb", "getLikeThumb", "likeTv", "Landroid/widget/TextView;", "getLikeTv", "()Landroid/widget/TextView;", "setLikeTv", "(Landroid/widget/TextView;)V", "nickName", "getNickName", "setNickName", "notChosen", "getNotChosen", "replyDelete", "getReplyDelete", "replyPrefix", "getReplyPrefix", "sameReplyPrefix", "getSameReplyPrefix", "plugin-webview_release"})
    public final class a
    {
      NeatTextView JzJ;
      WeImageView JzK;
      final ImageView JzL;
      final ImageView JzM;
      final TextView JzN;
      final TextView JzO;
      final ImageView JzP;
      final ImageView JzQ;
      TextView hPG;
      TextView qbF;
      
      public a()
      {
        AppMethodBeat.i(82699);
        this.qbF = ((TextView)((View)localObject).findViewById(2131297600));
        this.hPG = ((TextView)((View)localObject).findViewById(2131297599));
        this.JzJ = ((NeatTextView)((View)localObject).findViewById(2131297596));
        this.JzK = ((WeImageView)((View)localObject).findViewById(2131297597));
        this.JzL = ((ImageView)((View)localObject).findViewById(2131297434));
        this.JzM = ((ImageView)((View)localObject).findViewById(2131297436));
        this.JzN = ((TextView)((View)localObject).findViewById(2131297439));
        this.JzO = ((TextView)((View)localObject).findViewById(2131297437));
        this.JzP = ((ImageView)((View)localObject).findViewById(2131297503));
        this.JzQ = ((ImageView)((View)localObject).findViewById(2131297504));
        this$1 = ((View)localObject).getContext();
        Object localObject = this.JzJ;
        kotlin.g.b.p.g(n.b.this, "context");
        ((NeatTextView)localObject).setTextColor(o.e(2130968865, n.b.this));
        AppMethodBeat.o(82699);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentViewHolder;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAvatar", "()Landroid/widget/ImageView;", "commentList", "Ljava/util/ArrayList;", "getCommentList", "()Ljava/util/ArrayList;", "content", "Landroid/widget/LinearLayout;", "getContent", "()Landroid/widget/LinearLayout;", "endlineLayout", "getEndlineLayout", "setEndlineLayout", "(Landroid/widget/LinearLayout;)V", "fansContent", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;", "getFansContent", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "setFansContent", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;)V", "fansLayout", "getFansLayout", "setFansLayout", "txtReply", "Landroid/widget/TextView;", "getTxtReply", "()Landroid/widget/TextView;", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "plugin-webview_release"})
    public final class b
    {
      final LinearLayout EAe;
      private LinearLayout JzS;
      LinearLayout JzT;
      n.b.a JzU;
      final TextView JzV;
      final ArrayList<View> hXy;
      final ImageView keC;
      
      public b()
      {
        AppMethodBeat.i(82700);
        this.keC = ((ImageView)localObject.findViewById(2131297592));
        this.EAe = ((LinearLayout)localObject.findViewById(2131297595));
        this.JzS = ((LinearLayout)localObject.findViewById(2131297607));
        this.JzT = ((LinearLayout)localObject.findViewById(2131300124));
        LinearLayout localLinearLayout = this.JzS;
        kotlin.g.b.p.g(localLinearLayout, "fansLayout");
        this.JzU = new n.b.a(n.b.this, (View)localLinearLayout);
        this.JzV = ((TextView)localObject.findViewById(2131297438));
        this.hXy = new ArrayList();
        AppMethodBeat.o(82700);
      }
      
      @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
      static final class a
        implements View.OnClickListener
      {
        a(n.b.b paramb, of paramof) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(175691);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentViewHolder$update$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          this.JzW.JzR.JzF.xV(3);
          this.JzW.JzR.JzF.x(n.b.a(this.JzX), this.JzX.KJJ, true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentViewHolder$update$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(175691);
        }
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d
      implements View.OnClickListener
    {
      d(n.b paramb, boolean paramBoolean, ace paramace, of paramof, n.b.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(175692);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$showLikeStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        n.b(this.JzR.JzF).clearFocus();
        int i;
        if (paramBoolean)
        {
          paramView = paramace;
          if (paramView != null)
          {
            paramView = Integer.valueOf(paramView.LmL);
            if (paramView == null) {
              kotlin.g.b.p.hyc();
            }
            i = paramView.intValue();
            label86:
            if (!paramBoolean) {
              break label544;
            }
            paramView = paramace;
            if (paramView == null) {
              break label539;
            }
            paramView = Integer.valueOf(paramView.LmM);
            label110:
            if (paramView != null) {
              break label558;
            }
            label114:
            parama.JzM.setImageResource(2131689712);
            i -= 1;
            label130:
            if (i >= 0) {
              break label646;
            }
            i = 0;
          }
        }
        label646:
        for (;;)
        {
          parama.hPG.setText((CharSequence)String.valueOf(i));
          localObject = parama.hPG;
          kotlin.g.b.p.g(localObject, "itemView.likeTv");
          int j;
          if (i > 0)
          {
            j = 0;
            label175:
            ((TextView)localObject).setVisibility(j);
            fu localfu = new fu();
            localfu.KJJ = paramof.KJJ;
            localfu.openid = paramof.openid;
            localfu.pTI = 1;
            if (paramBoolean)
            {
              localObject = paramace;
              if (localObject == null) {
                break label591;
              }
              localObject = Integer.valueOf(((ace)localObject).KJL);
              label248:
              if (localObject == null) {
                kotlin.g.b.p.hyc();
              }
              localfu.KJL = ((Integer)localObject).intValue();
              localfu.pTI = 2;
            }
            if (paramView != null) {
              break label597;
            }
            label276:
            j = 0;
            label278:
            localfu.KJK = j;
            localObject = this.JzR.JzF;
            kotlin.g.b.p.h(localfu, "req");
            localfu.scene = ((n)localObject).scene;
            localfu.KIL = ((n)localObject).pHw;
            localfu.url = ((n)localObject).url;
            localfu.KIJ = ((n)localObject).iwc;
            localfu.session_id = ((n)localObject).pHx;
            localfu.KIK = ((n)localObject).pHu;
            com.tencent.mm.ak.d.a locala = new com.tencent.mm.ak.d.a();
            locala.c((com.tencent.mm.bw.a)localfu);
            locala.d((com.tencent.mm.bw.a)new fv());
            locala.MB("/cgi-bin/mmbiz-bin/appmsg/appmsg_like_comment");
            locala.sG(2759);
            locala.sI(0);
            locala.sJ(0);
            IPCRunCgi.a(locala.aXF(), (IPCRunCgi.a)new n.d((n)localObject));
            if (paramView != null) {
              break label609;
            }
            label459:
            paramView = Integer.valueOf(0);
            label464:
            if (!paramBoolean) {
              break label624;
            }
            localObject = paramace;
            if (localObject != null) {
              ((ace)localObject).LmM = paramView.intValue();
            }
            paramView = paramace;
            if (paramView != null) {
              paramView.LmL = i;
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$showLikeStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(175692);
            return;
            paramView = null;
            break;
            i = paramof.KSR;
            break label86;
            label539:
            paramView = null;
            break label110;
            label544:
            paramView = Integer.valueOf(paramof.KSS);
            break label110;
            label558:
            if (paramView.intValue() != 0) {
              break label114;
            }
            parama.JzM.setImageResource(2131689713);
            i += 1;
            break label130;
            j = 8;
            break label175;
            label591:
            localObject = null;
            break label248;
            label597:
            if (paramView.intValue() != 0) {
              break label276;
            }
            j = 1;
            break label278;
            label609:
            if (paramView.intValue() != 0) {
              break label459;
            }
            paramView = Integer.valueOf(1);
            break label464;
            label624:
            paramof.KSS = paramView.intValue();
            paramof.KSR = i;
          }
        }
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(n.b paramb, of paramof) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(82702);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$updateCommentContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        new com.tencent.mm.ui.widget.a.d.a(n.b.a(this.JzR)).bon(n.b.a(this.JzR).getString(2131756805)).boo("").aoX(n.b.a(this.JzR).getResources().getColor(2131099819)).aoV(2131755778).c((DialogInterface.OnClickListener)new a(this)).aoW(2131756918).hbn().show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$updateCommentContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82702);
      }
      
      @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
      static final class a
        implements DialogInterface.OnClickListener
      {
        a(n.b.e parame) {}
        
        public final void onClick(DialogInterface paramDialogInterface, int paramInt)
        {
          AppMethodBeat.i(82701);
          paramDialogInterface = new fy();
          paramDialogInterface.KJJ = this.JAa.JzX.KJJ;
          paramDialogInterface.pTI = 2;
          this.JAa.JzR.JzF.a(paramDialogInterface);
          com.tencent.mm.plugin.webview.i.a.agn(13);
          AppMethodBeat.o(82701);
        }
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f
      implements View.OnClickListener
    {
      f(n.b paramb, of paramof, ace paramace) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(175694);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$updateReplyView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        new com.tencent.mm.ui.widget.a.d.a(n.b.a(this.JzR)).bon(n.b.a(this.JzR).getString(2131756707)).boo("").aoX(n.b.a(this.JzR).getResources().getColor(2131099819)).aoV(2131755778).c((DialogInterface.OnClickListener)new a(this)).aoW(2131756918).hbn().show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$updateReplyView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(175694);
      }
      
      @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
      static final class a
        implements DialogInterface.OnClickListener
      {
        a(n.b.f paramf) {}
        
        public final void onClick(DialogInterface paramDialogInterface, int paramInt)
        {
          AppMethodBeat.i(175693);
          paramDialogInterface = new fy();
          paramDialogInterface.KJJ = this.JAb.JzX.KJJ;
          paramDialogInterface.KJL = this.JAb.JzY.KJL;
          paramDialogInterface.pTI = 4;
          this.JAb.JzR.JzF.a(paramDialogInterface);
          com.tencent.mm.plugin.webview.i.a.agn(13);
          AppMethodBeat.o(175693);
        }
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "", "delFlag", "", "invoke"})
    static final class g
      extends q
      implements kotlin.g.a.b<Integer, Boolean>
    {
      g(n.b paramb, n.b.a parama, of paramof)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "", "onHide", "", "onShow", "plugin-webview_release"})
  public static abstract interface c
  {
    public abstract void onHide();
    
    public abstract void onShow();
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class d
    implements IPCRunCgi.a
  {
    d(n paramn) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.ak.d paramd)
    {
      AppMethodBeat.i(175699);
      MMHandlerThread.postToMainThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(175698);
          Object localObject = p.JAu;
          p.b(this.JAc.JzC.getWebView().gfk());
          if (this.JAc.JzC.getWeakThis$plugin_webview_release().get() != null)
          {
            localObject = this.JAc.JzC.getWeakThis$plugin_webview_release().get();
            if (localObject == null)
            {
              localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout");
              AppMethodBeat.o(175698);
              throw ((Throwable)localObject);
            }
            localObject = (n)localObject;
            int i = paramInt1;
            int j = paramInt2;
            String str = paramString;
            com.tencent.mm.ak.d locald = paramd;
            kotlin.g.b.p.g(locald, "rr");
            n.b((n)localObject, i, j, str, locald);
          }
          AppMethodBeat.o(175698);
        }
      });
      AppMethodBeat.o(175699);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class e
    implements IPCRunCgi.a
  {
    e(n paramn) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.ak.d paramd)
    {
      AppMethodBeat.i(82711);
      MMHandlerThread.postToMainThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(82710);
          Object localObject = p.JAu;
          p.b(this.JAd.JzC.getWebView().gfk());
          if (this.JAd.JzC.getWeakThis$plugin_webview_release().get() != null)
          {
            localObject = this.JAd.JzC.getWeakThis$plugin_webview_release().get();
            if (localObject == null)
            {
              localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout");
              AppMethodBeat.o(82710);
              throw ((Throwable)localObject);
            }
            localObject = (n)localObject;
            int i = paramInt1;
            int j = paramInt2;
            String str = paramString;
            com.tencent.mm.ak.d locald = paramd;
            kotlin.g.b.p.g(locald, "rr");
            n.a((n)localObject, i, j, str, locald);
          }
          AppMethodBeat.o(82710);
        }
      });
      AppMethodBeat.o(82711);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class f
    implements IPCRunCgi.a
  {
    f(n paramn) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.d paramd)
    {
      AppMethodBeat.i(82713);
      n.f(this.JzC);
      MMHandlerThread.postToMainThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(82712);
          Object localObject = p.JAu;
          p.b(this.JAe.JzC.getWebView().gfk());
          if (this.JAe.JzC.getWeakThis$plugin_webview_release().get() != null)
          {
            localObject = this.JAe.JzC.getWeakThis$plugin_webview_release().get();
            if (localObject == null)
            {
              localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout");
              AppMethodBeat.o(82712);
              throw ((Throwable)localObject);
            }
            localObject = (n)localObject;
            com.tencent.mm.ak.d locald = paramd;
            kotlin.g.b.p.g(locald, "rr");
            n.a((n)localObject, locald);
          }
          AppMethodBeat.o(82712);
        }
      });
      if (paramInt1 == 2)
      {
        com.tencent.mm.plugin.webview.i.a.agn(8);
        AppMethodBeat.o(82713);
        return;
      }
      if (paramInt1 != 0) {
        com.tencent.mm.plugin.webview.i.a.agn(9);
      }
      AppMethodBeat.o(82713);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$hideAnimation$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "ani", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"})
  public static final class g
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(82714);
      kotlin.g.b.p.h(paramAnimation, "ani");
      paramAnimation = this.JzC.getWeakThis$plugin_webview_release().get();
      if (paramAnimation == null)
      {
        paramAnimation = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout");
        AppMethodBeat.o(82714);
        throw paramAnimation;
      }
      ((n)paramAnimation).setVisibility(8);
      n.e(this.JzC).clearAnimation();
      AppMethodBeat.o(82714);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation) {}
    
    public final void onAnimationStart(Animation paramAnimation) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "state", "", "onKeyBoardStateChange"})
  static final class h
    implements KeyboardLinearLayout.a
  {
    h(n paramn) {}
    
    public final void Ns(int paramInt)
    {
      AppMethodBeat.i(82717);
      n.a locala = n.JzB;
      Log.i(n.access$getTAG$cp(), "onKeyBoardStateChange, state = ".concat(String.valueOf(paramInt)));
      if (paramInt == -3)
      {
        int i = n.c(this.JzC).getKeyBoardHeight();
        if (i > 0)
        {
          n.a(this.JzC, i);
          n.a(this.JzC, i);
        }
        new MMHandler().postDelayed((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(82715);
            n.d(this.JAf.JzC).fjH();
            n.d(this.JAf.JzC).postInvalidate();
            n.e(this.JAf.JzC).postInvalidate();
            AppMethodBeat.o(82715);
          }
        }, 10L);
      }
      for (;;)
      {
        n.b(this.JzC, paramInt);
        AppMethodBeat.o(82717);
        return;
        n.a(this.JzC, 0);
        n.a(this.JzC, 0);
        new MMHandler().postDelayed((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(82716);
            n.d(this.JAf.JzC).giv();
            n.d(this.JAf.JzC).postInvalidate();
            n.e(this.JAf.JzC).postInvalidate();
            AppMethodBeat.o(82716);
          }
        }, 10L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.n
 * JD-Core Version:    0.7.0.1
 */
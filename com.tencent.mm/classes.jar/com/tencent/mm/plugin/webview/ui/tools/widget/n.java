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
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.aam;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.protocal.protobuf.ey;
import com.tencent.mm.protocal.protobuf.ez;
import com.tencent.mm.protocal.protobuf.fh;
import com.tencent.mm.protocal.protobuf.fi;
import com.tencent.mm.protocal.protobuf.fl;
import com.tencent.mm.protocal.protobuf.fm;
import com.tencent.mm.protocal.protobuf.nm;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.neattextview.textview.view.NeatTextView;
import d.a.j;
import d.g.b.q;
import d.l;
import d.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewKeyboardLinearLayout;", "webView", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "isDark", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;ZLandroid/content/Context;Landroid/util/AttributeSet;)V", "actionView", "Landroid/view/View;", "adapter", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;", "callback", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "getCallback", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "setCallback", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;)V", "cancelTv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "commentTopicId", "", "getCommentTopicId", "()J", "setCommentTopicId", "(J)V", "commitBt", "Landroid/widget/Button;", "contentEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "currentKbState", "", "enterId", "getEnterId", "()I", "setEnterId", "(I)V", "hasReadOpenCfg", "isDoingGetMyComment", "isHaokan", "isReplyOpen", "itemShowType", "getItemShowType", "setItemShowType", "kbLayout", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "minHeaderHeight", "getMinHeaderHeight", "setMinHeaderHeight", "myCommentOffset", "getMyCommentOffset", "setMyCommentOffset", "myCommentTitleTv", "Landroid/widget/TextView;", "myCommentTv", "myCommentView", "recyclerView", "Landroid/widget/ListView;", "replyPersonalCommentId", "replyTip", "root", "savePortHeight", "sayFooter", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter;", "getSayFooter", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter;", "sayFooter$delegate", "Lkotlin/Lazy;", "scene", "getScene", "setScene", "subScene", "getSubScene", "setSubScene", "timeLineSessionId", "getTimeLineSessionId", "setTimeLineSessionId", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "weakThis", "Ljava/lang/ref/WeakReference;", "getWeakThis$plugin_webview_release", "()Ljava/lang/ref/WeakReference;", "setWeakThis$plugin_webview_release", "(Ljava/lang/ref/WeakReference;)V", "getWebView", "()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "caculateHeight", "", "newMarginBottom", "checkHeight", "h", "clearPersonalComment", "refreshHeight", "closeComment", "contentEtOnClick", "dealOrientaion", "orientation", "doAppMsgLikeComment", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgLikeCommentReq;", "doAppMsgOperateComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "doReport", "actionType", "fixKeyBoardMargin", "getAppMsgCommentList", "getNavHeightByDisplay", "getReplyHeight", "getRootHeight", "hide", "hideAnimation", "initKeyboardListener", "isShow", "onAddCommentSuccess", "onAppMsgLikeComment", "errType", "errCode", "errMsg", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "onAppMsgOperateComment", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDeleteComment", "onDeleteCommentReply", "onDestroy", "onGetCommentList", "onKeyBackPress", "onNoComment", "onResume", "onTouchClose", "replyToPersonalComment", "replyContent", "personalCommentId", "saveRootHeight", "height", "setData", "setRootHeight", "show", "showAnimation", "showCommentView", "showLayout", "showLayoutReply", "updateData", "resp", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommentListResp;", "clearUpdate", "updateUrl", "curUrl", "Companion", "MPMyCommentItemAdapter", "MPWriteCommentLayoutCallback", "plugin-webview_release"})
public final class n
  extends WebViewKeyboardLinearLayout
{
  public static final n.a EJM;
  private static final String TAG = "MicroMsg.MPWriteCommentLayout";
  private b EJA;
  private boolean EJB;
  private int EJC;
  private int EJD;
  private int EJE;
  private long EJF;
  private c EJG;
  private boolean EJH;
  private int EJI;
  private boolean EJJ;
  private boolean EJK;
  public final WebViewUI EJL;
  private final d.f EJr;
  private final WeImageView EJs;
  private final Button EJt;
  public final MMEditText EJu;
  private final ListView EJv;
  private final View EJw;
  private final TextView EJx;
  private final TextView EJy;
  private final TextView EJz;
  private final WebViewKeyboardLinearLayout EuJ;
  public int Ewz;
  private final boolean dIc;
  private final View fQH;
  int hBV;
  private final View jeQ;
  private WeakReference<n> nTM;
  int otX;
  int otZ;
  int oua;
  int scene;
  private String title;
  String url;
  
  static
  {
    AppMethodBeat.i(82720);
    EJM = new n.a((byte)0);
    TAG = "MicroMsg.MPWriteCommentLayout";
    AppMethodBeat.o(82720);
  }
  
  public n(WebViewUI paramWebViewUI, Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(175710);
    this.EJL = paramWebViewUI;
    this.dIc = false;
    paramWebViewUI = View.inflate(paramContext, 2131494959, (ViewGroup)this);
    if (paramWebViewUI == null)
    {
      paramWebViewUI = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout");
      AppMethodBeat.o(175710);
      throw paramWebViewUI;
    }
    this.EuJ = ((WebViewKeyboardLinearLayout)paramWebViewUI);
    paramWebViewUI = findViewById(2131302501);
    d.g.b.p.g(paramWebViewUI, "findViewById(R.id.mp_video_comment_action_layout)");
    this.jeQ = paramWebViewUI;
    this.EJr = d.g.O((d.g.a.a)new n.j(this));
    paramWebViewUI = findViewById(2131302502);
    d.g.b.p.g(paramWebViewUI, "findViewById(R.id.mp_video_comment_cancel)");
    this.EJs = ((WeImageView)paramWebViewUI);
    paramWebViewUI = findViewById(2131302504);
    d.g.b.p.g(paramWebViewUI, "findViewById(R.id.mp_video_comment_ok)");
    this.EJt = ((Button)paramWebViewUI);
    paramWebViewUI = findViewById(2131302503);
    d.g.b.p.g(paramWebViewUI, "findViewById(R.id.mp_video_comment_et)");
    this.EJu = ((MMEditText)paramWebViewUI);
    paramWebViewUI = findViewById(2131297394);
    d.g.b.p.g(paramWebViewUI, "findViewById(R.id.biz_video_my_comment_list)");
    this.EJv = ((ListView)paramWebViewUI);
    paramWebViewUI = findViewById(2131302518);
    d.g.b.p.g(paramWebViewUI, "findViewById(R.id.mp_write_comment_root)");
    this.fQH = paramWebViewUI;
    paramWebViewUI = findViewById(2131302517);
    d.g.b.p.g(paramWebViewUI, "findViewById(R.id.mp_vid…rite_comment_scroll_view)");
    this.EJw = paramWebViewUI;
    paramWebViewUI = findViewById(2131297395);
    d.g.b.p.g(paramWebViewUI, "findViewById(R.id.biz_video_my_comment_tv)");
    this.EJx = ((TextView)paramWebViewUI);
    paramWebViewUI = findViewById(2131302507);
    d.g.b.p.g(paramWebViewUI, "findViewById(R.id.mp_video_my_comment_title)");
    this.EJy = ((TextView)paramWebViewUI);
    paramWebViewUI = findViewById(2131297401);
    d.g.b.p.g(paramWebViewUI, "findViewById(R.id.biz_video_reply_tip)");
    this.EJz = ((TextView)paramWebViewUI);
    this.Ewz = -1;
    this.url = "";
    this.title = "";
    this.nTM = new WeakReference(this);
    getSayFooter().setMMEditText(this.EJu);
    getSayFooter().setVisibility(8);
    this.EJu.setOnClickListener((View.OnClickListener)new n.1(this));
    this.EJu.setOnLongClickListener((View.OnLongClickListener)new n.2(this));
    this.EuJ.setOnTouchListener((View.OnTouchListener)new n.3(this));
    this.fQH.setOnClickListener((View.OnClickListener)n.4.EJO);
    int i = getRootHeight();
    if (i > 0)
    {
      paramWebViewUI = this.fQH.getLayoutParams();
      if (paramWebViewUI == null)
      {
        paramWebViewUI = new v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        AppMethodBeat.o(175710);
        throw paramWebViewUI;
      }
      paramWebViewUI.height = i;
      this.fQH.setLayoutParams(paramWebViewUI);
    }
    if (!aa.iP(paramContext)) {
      Yv(2);
    }
    this.EJs.setOnClickListener((View.OnClickListener)new n.5(this));
    this.EJt.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82697);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if (n.j(this.EJN))
        {
          paramAnonymousView = n.b(this.EJN).getText().toString();
          localObject = this.EJN.getWebView().DRx;
          if (localObject != null) {
            ((com.tencent.mm.plugin.webview.c.f)localObject).u(1, paramAnonymousView, 1);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(82697);
          return;
          this.EJN.getWebView().hideVKB();
          if (n.d(this.EJN).ehg()) {
            n.d(this.EJN).ehh();
          }
          paramAnonymousView = new fl();
          paramAnonymousView.content = n.b(this.EJN).getText().toString();
          paramAnonymousView.oGc = 1;
          if (n.k(this.EJN) != 0)
          {
            paramAnonymousView.oGc = 3;
            paramAnonymousView.FQb = n.k(this.EJN);
          }
          this.EJN.a(paramAnonymousView);
          com.tencent.mm.plugin.webview.h.a.XF(10);
        }
      }
    });
    this.EJu.addTextChangedListener((TextWatcher)new n.7(this));
    paramWebViewUI = this.EJt;
    paramContext = this.EJu.getText();
    d.g.b.p.g(paramContext, "contentEt.text");
    if (((CharSequence)paramContext).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramWebViewUI.setEnabled(bool);
      this.EJu.setOnTouchListener((View.OnTouchListener)new n.8(this));
      this.EJz.setVisibility(8);
      AppMethodBeat.o(175710);
      return;
    }
  }
  
  private final void Yv(int paramInt)
  {
    AppMethodBeat.i(82729);
    switch (paramInt)
    {
    default: 
      if (this.EuJ.eVK()) {
        Yw(this.EuJ.getKeyBoardHeight());
      }
      break;
    }
    for (;;)
    {
      this.EJu.setMinLines(5);
      AppMethodBeat.o(82729);
      return;
      paramInt = com.tencent.mm.ui.ar.jN(getContext());
      setRootHeight(com.tencent.mm.ui.ar.ck(getContext()).y - paramInt);
      this.EJu.setMinLines(3);
      AppMethodBeat.o(82729);
      return;
      if (this.EJC != 0) {
        setRootHeight(this.EJC);
      } else {
        Yw(0);
      }
    }
  }
  
  private final void Yw(int paramInt)
  {
    AppMethodBeat.i(82730);
    Object localObject = this.fQH.getLayoutParams();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(82730);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.LayoutParams)localObject).height = (this.EJu.getHeight() + this.jeQ.getHeight() + getNavHeightByDisplay() + com.tencent.mm.cb.a.fromDPToPix(getContext(), com.tencent.mm.cb.a.aA(getContext(), 60) + 16) + getReplyHeight() + paramInt);
    ((ViewGroup.LayoutParams)localObject).height = Yx(((ViewGroup.LayoutParams)localObject).height);
    this.fQH.setLayoutParams((ViewGroup.LayoutParams)localObject);
    Yy(((ViewGroup.LayoutParams)localObject).height);
    AppMethodBeat.o(82730);
  }
  
  private final int Yx(int paramInt)
  {
    AppMethodBeat.i(82732);
    int j = com.tencent.mm.ui.ar.jN(getContext());
    int k = com.tencent.mm.ui.ar.ck(getContext()).y;
    int i = k - j;
    if (paramInt > i) {}
    for (;;)
    {
      AppMethodBeat.o(82732);
      return i;
      i = paramInt;
      if (this.EJE > 0)
      {
        int m = com.tencent.mm.cb.a.fromDPToPix(getContext(), 20);
        i = paramInt;
        if (paramInt < k - this.EJE - j + m) {
          i = k - j - this.EJE + m;
        }
      }
    }
  }
  
  private final void Yy(int paramInt)
  {
    AppMethodBeat.i(82733);
    if (aa.iP(getContext())) {
      this.EJC = paramInt;
    }
    ay localay = ay.aRX("MPWriteCommentLayout");
    localay.encode("MPWriteCommentRootHeight", paramInt);
    localay.apply();
    AppMethodBeat.o(82733);
  }
  
  private final void eZr()
  {
    AppMethodBeat.i(82723);
    View localView = this.EJw;
    Context localContext = getContext();
    d.g.b.p.g(localContext, "context");
    localView.setBackgroundColor(o.c(2130968842, localContext));
    this.EJx.setVisibility(8);
    AppMethodBeat.o(82723);
  }
  
  private void eZt()
  {
    AppMethodBeat.i(175703);
    this.EJu.setText((CharSequence)"");
    this.EJI = 0;
    getAppMsgCommentList();
    AppMethodBeat.o(175703);
  }
  
  private final void eZu()
  {
    AppMethodBeat.i(182680);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(250L);
    localTranslateAnimation.setFillAfter(false);
    this.fQH.clearAnimation();
    this.fQH.startAnimation((Animation)localTranslateAnimation);
    AppMethodBeat.o(182680);
  }
  
  private final void eZv()
  {
    AppMethodBeat.i(82737);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    localTranslateAnimation.setDuration(150L);
    localTranslateAnimation.setFillAfter(false);
    localTranslateAnimation.setAnimationListener((Animation.AnimationListener)new g(this));
    this.fQH.clearAnimation();
    this.fQH.startAnimation((Animation)localTranslateAnimation);
    AppMethodBeat.o(82737);
  }
  
  private final int getNavHeightByDisplay()
  {
    AppMethodBeat.i(82739);
    Point localPoint = com.tencent.mm.ui.ar.ck(getContext());
    Object localObject = this.EJL.getWindow();
    if (localObject != null) {}
    for (localObject = ((Window)localObject).getDecorView();; localObject = null)
    {
      Rect localRect = new Rect();
      if (localObject != null) {
        ((View)localObject).getWindowVisibleDisplayFrame(localRect);
      }
      int i = localRect.bottom;
      int j = localPoint.y - i - this.EuJ.getKeyBoardHeight();
      ae.v(TAG, "getNavHeightByDisplay screenHeight = " + i + ", realSize = " + localPoint.y);
      i = j;
      if (j < 0)
      {
        i = com.tencent.mm.ui.ar.en(getContext());
        ae.v(TAG, "getNavHeightByDisplay error");
      }
      ae.v(TAG, "getNavHeightByDisplay h = %s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(82739);
      return i;
    }
  }
  
  private final int getReplyHeight()
  {
    AppMethodBeat.i(182681);
    if (this.EJD != 0)
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
  
  private final void setRootHeight(int paramInt)
  {
    AppMethodBeat.i(82731);
    Object localObject = this.fQH.getLayoutParams();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(82731);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.LayoutParams)localObject).height = Yx(paramInt);
    this.fQH.setLayoutParams((ViewGroup.LayoutParams)localObject);
    Yy(((ViewGroup.LayoutParams)localObject).height);
    AppMethodBeat.o(82731);
  }
  
  private final void show()
  {
    AppMethodBeat.i(82735);
    this.fQH.clearAnimation();
    setVisibility(0);
    eZu();
    c localc = this.EJG;
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
    this.otZ = paramInt2;
    this.hBV = paramInt3;
    this.otX = paramInt4;
    this.url = paramString1;
    this.title = paramString2;
  }
  
  public final void a(fl paramfl)
  {
    AppMethodBeat.i(82741);
    d.g.b.p.h(paramfl, "req");
    paramfl.scene = this.scene;
    paramfl.FPd = this.otZ;
    paramfl.url = this.url;
    paramfl.title = this.title;
    paramfl.FQh = System.currentTimeMillis();
    paramfl.FPb = this.hBV;
    paramfl.session_id = this.oua;
    paramfl.FPc = this.otX;
    paramfl.FPe = this.EJF;
    Object localObject = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject).c((com.tencent.mm.bw.a)paramfl);
    ((com.tencent.mm.ak.b.a)localObject).d((com.tencent.mm.bw.a)new fm());
    ((com.tencent.mm.ak.b.a)localObject).DN("/cgi-bin/mmbiz-bin/appmsg/appmsg_operate_comment");
    ((com.tencent.mm.ak.b.a)localObject).oS(2617);
    ((com.tencent.mm.ak.b.a)localObject).oU(0);
    ((com.tencent.mm.ak.b.a)localObject).oV(0);
    IPCRunCgi.a(((com.tencent.mm.ak.b.a)localObject).aDS(), (IPCRunCgi.a)new e(this));
    paramfl = this.EJL;
    localObject = p.EKF;
    localObject = getContext().getString(2131755936);
    d.g.b.p.g(localObject, "context.getString(R.string.app_waiting)");
    Context localContext = getContext();
    d.g.b.p.g(localContext, "context");
    paramfl.a(p.a((String)localObject, localContext, this.EJL.eWn()));
    AppMethodBeat.o(82741);
  }
  
  public final void aKX(String paramString)
  {
    AppMethodBeat.i(175701);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(175701);
      return;
    }
    this.url = paramString;
    AppMethodBeat.o(175701);
  }
  
  public final boolean bnS()
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
  
  public final void eZs()
  {
    AppMethodBeat.i(82724);
    this.EuJ.setOnkbdStateListener((KeyboardLinearLayout.a)new h(this));
    AppMethodBeat.o(82724);
  }
  
  public final boolean eZw()
  {
    AppMethodBeat.i(175708);
    if (!this.EJJ) {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qBp, 0) != 1) {
        break label86;
      }
    }
    label86:
    for (boolean bool = true;; bool = false)
    {
      this.EJK = bool;
      this.EJJ = true;
      ae.v(TAG, "isReplyOpen = " + this.EJK);
      bool = this.EJK;
      AppMethodBeat.o(175708);
      return bool;
    }
  }
  
  public final void getAppMsgCommentList()
  {
    AppMethodBeat.i(82740);
    ey localey = new ey();
    localey.url = this.url;
    if (this.EJH)
    {
      AppMethodBeat.o(82740);
      return;
    }
    localey.offset = this.EJI;
    if (this.EJI == -1)
    {
      ae.i(TAG, "no more my comment");
      AppMethodBeat.o(82740);
      return;
    }
    this.EJH = true;
    localey.oGc = 2;
    localey.scene = this.scene;
    localey.FPd = this.otZ;
    localey.FPb = this.hBV;
    localey.session_id = this.oua;
    localey.FPc = this.otX;
    localey.FPe = this.EJF;
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    locala.c((com.tencent.mm.bw.a)localey);
    locala.d((com.tencent.mm.bw.a)new ez());
    locala.DN("/cgi-bin/mmbiz-bin/appmsg/appmsg_comment_list");
    locala.oS(2866);
    locala.oU(0);
    locala.oV(0);
    IPCRunCgi.a(locala.aDS(), (IPCRunCgi.a)new f(this));
    com.tencent.mm.plugin.webview.h.a.XF(7);
    AppMethodBeat.o(82740);
  }
  
  public final c getCallback()
  {
    return this.EJG;
  }
  
  public final long getCommentTopicId()
  {
    return this.EJF;
  }
  
  public final int getEnterId()
  {
    return this.otX;
  }
  
  public final int getItemShowType()
  {
    return this.hBV;
  }
  
  public final int getMinHeaderHeight()
  {
    return this.EJE;
  }
  
  public final int getMyCommentOffset()
  {
    return this.EJI;
  }
  
  public final MPSmileyFooter getSayFooter()
  {
    AppMethodBeat.i(82721);
    MPSmileyFooter localMPSmileyFooter = (MPSmileyFooter)this.EJr.getValue();
    AppMethodBeat.o(82721);
    return localMPSmileyFooter;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final int getSubScene()
  {
    return this.otZ;
  }
  
  public final int getTimeLineSessionId()
  {
    return this.oua;
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
    return this.nTM;
  }
  
  public final WebViewUI getWebView()
  {
    return this.EJL;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(82736);
    if (!bnS())
    {
      AppMethodBeat.o(82736);
      return;
    }
    if (getSayFooter().ehg()) {
      getSayFooter().ehh();
    }
    eZv();
    this.EJL.hideVKB();
    this.EJI = 0;
    Object localObject = this.EJA;
    if (localObject != null) {
      ((b)localObject).clear();
    }
    localObject = this.EJG;
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
    d.g.b.p.h(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Yv(paramConfiguration.orientation);
    if (getSayFooter().ehg()) {
      getSayFooter().ehh();
    }
    AppMethodBeat.o(82728);
  }
  
  public final void setCallback(c paramc)
  {
    this.EJG = paramc;
  }
  
  public final void setCommentTopicId(long paramLong)
  {
    this.EJF = paramLong;
  }
  
  public final void setEnterId(int paramInt)
  {
    this.otX = paramInt;
  }
  
  public final void setItemShowType(int paramInt)
  {
    this.hBV = paramInt;
  }
  
  public final void setMinHeaderHeight(int paramInt)
  {
    this.EJE = paramInt;
  }
  
  public final void setMyCommentOffset(int paramInt)
  {
    this.EJI = paramInt;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public final void setSubScene(int paramInt)
  {
    this.otZ = paramInt;
  }
  
  public final void setTimeLineSessionId(int paramInt)
  {
    this.oua = paramInt;
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
    d.g.b.p.h(paramWeakReference, "<set-?>");
    this.nTM = paramWeakReference;
    AppMethodBeat.o(82722);
  }
  
  public final void tW(int paramInt)
  {
    AppMethodBeat.i(175709);
    String str2 = Uri.parse(this.url).getQueryParameter("clicktime");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.url);
    localStringBuilder.append(",");
    localStringBuilder.append(this.scene);
    localStringBuilder.append(",");
    String str1 = str2;
    if (bu.isNullOrNil(str2)) {
      str1 = "";
    }
    localStringBuilder.append(str1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",");
    localStringBuilder.append(System.currentTimeMillis());
    str1 = localStringBuilder.toString();
    ae.v(TAG, str1);
    com.tencent.mm.plugin.report.service.g.yxI.kvStat(19265, str1);
    AppMethodBeat.o(175709);
  }
  
  public final void u(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(175705);
    d.g.b.p.h(paramString, "replyContent");
    this.EJD = paramInt;
    this.EJy.setText((CharSequence)getContext().getString(2131756575));
    this.EJz.setVisibility(0);
    TextView localTextView = this.EJz;
    Context localContext = getContext();
    String str = paramString;
    if (bu.isNullOrNil(paramString)) {
      str = "";
    }
    localTextView.setText((CharSequence)localContext.getString(2131756574, new Object[] { str }));
    this.EJu.setHint((CharSequence)getContext().getString(2131756573));
    if (paramBoolean)
    {
      this.EJw.scrollTo(0, 0);
      this.EJu.requestFocus();
      paramString = getContext().getSystemService("input_method");
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        AppMethodBeat.o(175705);
        throw paramString;
      }
      paramString = (InputMethodManager)paramString;
      if (paramString != null)
      {
        paramString.showSoftInput((View)this.EJu, 0);
        AppMethodBeat.o(175705);
        return;
      }
    }
    AppMethodBeat.o(175705);
  }
  
  public final void vA(boolean paramBoolean)
  {
    AppMethodBeat.i(82725);
    tW(1);
    vC(false);
    vB(paramBoolean);
    AppMethodBeat.o(82725);
  }
  
  public final void vB(boolean paramBoolean)
  {
    AppMethodBeat.i(175702);
    this.EJB = paramBoolean;
    show();
    if (paramBoolean)
    {
      this.EJx.setVisibility(8);
      this.EJy.setText((CharSequence)getContext().getString(2131756657));
      this.EJu.setHint(2131756659);
      this.EJt.setText(2131755884);
      localObject = this.EJt;
      localContext = getContext();
      d.g.b.p.g(localContext, "context");
      ((Button)localObject).setBackground(localContext.getResources().getDrawable(2131231294));
      localObject = (InputFilter)new InputFilter.LengthFilter(200);
      this.EJu.setFilters(new InputFilter[] { localObject });
      AppMethodBeat.o(175702);
      return;
    }
    getAppMsgCommentList();
    this.EJt.setText(2131756649);
    Object localObject = this.EJt;
    Context localContext = getContext();
    d.g.b.p.g(localContext, "context");
    ((Button)localObject).setBackground(o.hg(localContext));
    AppMethodBeat.o(175702);
  }
  
  public final void vC(boolean paramBoolean)
  {
    AppMethodBeat.i(175707);
    if (this.EJD != 0)
    {
      this.EJD = 0;
      if (paramBoolean) {
        Yv(aa.iQ(getContext()));
      }
    }
    this.EJz.setText((CharSequence)"");
    this.EJz.setVisibility(8);
    this.EJu.setHint((CharSequence)getContext().getString(2131756669));
    this.EJy.setText((CharSequence)getContext().getString(2131756667));
    AppMethodBeat.o(175707);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "controller", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "isDarkPanel", "", "(Landroid/content/Context;Ljava/util/LinkedList;Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;Z)V", "getController", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "setController", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;)V", "viewPool", "Ljava/util/ArrayList;", "Landroid/view/View;", "getViewPool", "()Ljava/util/ArrayList;", "clear", "", "getCommentView", "getCount", "", "getItem", "position", "getItemId", "", "i", "getLastInvalidReply", "", "info", "getView", "convertView", "viewGroup", "Landroid/view/ViewGroup;", "onDeleteComment", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "onDeleteCommentReply", "showLikeStatus", "itemView", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "reply", "Lcom/tencent/mm/protocal/protobuf/CommentReply;", "isReply", "update", "items", "", "clearUpdate", "updateCommentContentView", "updateReplyView", "index", "BizCommentContent", "BizCommentViewHolder", "Companion", "plugin-webview_release"})
  public static final class b
    extends BaseAdapter
  {
    private static com.tencent.mm.av.a.a.c EJS;
    public static final n.b.c EJT;
    static final String TAG = "MicroMsg.MPMyCommentItemAdapter";
    final ArrayList<View> EJP;
    n EJQ;
    private boolean EJR;
    private final Context context;
    final LinkedList<nm> fXm;
    
    static
    {
      AppMethodBeat.i(82709);
      EJT = new n.b.c((byte)0);
      TAG = "MicroMsg.MPMyCommentItemAdapter";
      EJS = new c.a().pL(2131100141).aJq().dh(120, 120).a((com.tencent.mm.av.a.c.c)new com.tencent.mm.pluginsdk.ui.applet.n()).a((com.tencent.mm.av.a.c.a)new e()).aJs().an(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 3)).aJu();
      AppMethodBeat.o(82709);
    }
    
    public b(Context paramContext, LinkedList<nm> paramLinkedList, n paramn, boolean paramBoolean)
    {
      AppMethodBeat.i(162324);
      this.context = paramContext;
      this.fXm = paramLinkedList;
      this.EJQ = paramn;
      this.EJR = paramBoolean;
      this.EJP = new ArrayList();
      AppMethodBeat.o(162324);
    }
    
    private nm Yz(int paramInt)
    {
      AppMethodBeat.i(82704);
      nm localnm = (nm)j.F((List)this.fXm, paramInt);
      AppMethodBeat.o(82704);
      return localnm;
    }
    
    public static String a(nm paramnm)
    {
      AppMethodBeat.i(182678);
      d.g.b.p.h(paramnm, "info");
      String str = paramnm.content;
      int i;
      if ((paramnm.FZP != null) && (!bu.ht((List)paramnm.FZP.GrP)))
      {
        i = paramnm.FZP.GrP.size() - 1;
        if (i >= 0) {
          if (((aam)paramnm.FZP.GrP.get(i)).GrO != 0) {}
        }
      }
      for (paramnm = ((aam)paramnm.FZP.GrP.get(i)).content;; paramnm = str)
      {
        d.g.b.p.g(paramnm, "reply");
        AppMethodBeat.o(182678);
        return paramnm;
        i -= 1;
        break;
      }
    }
    
    private void a(final a parama, final nm paramnm, final aam paramaam, final boolean paramBoolean)
    {
      AppMethodBeat.i(175697);
      d.g.b.p.h(parama, "itemView");
      d.g.b.p.h(paramnm, "info");
      Object localObject;
      Integer localInteger1;
      label55:
      Integer localInteger2;
      label73:
      String str1;
      label105:
      int i;
      if (paramBoolean) {
        if (paramaam != null)
        {
          localObject = Integer.valueOf(paramaam.GrN);
          if (!paramBoolean) {
            break label352;
          }
          if (paramaam == null) {
            break label346;
          }
          localInteger1 = Integer.valueOf(paramaam.GrL);
          if (!paramBoolean) {
            break label370;
          }
          if (paramaam == null) {
            break label364;
          }
          localInteger2 = Integer.valueOf(paramaam.GrM);
          String str2 = TAG;
          StringBuilder localStringBuilder = new StringBuilder("showLikeStatus content = ");
          if (!paramBoolean) {
            break label388;
          }
          if (paramaam == null) {
            break label382;
          }
          str1 = paramaam.content;
          ae.v(str2, str1 + ", isElected = " + localObject + ", likeNum = " + localInteger1 + ", likeStatus = " + localInteger2);
          parama.EJX.setOnClickListener(null);
          if (localObject != null) {
            break label397;
          }
          label166:
          localObject = parama.EJZ;
          d.g.b.p.g(localObject, "itemView.notChosen");
          ((TextView)localObject).setVisibility(8);
          localObject = parama.EJX;
          d.g.b.p.g(localObject, "itemView.likeThumb");
          ((ImageView)localObject).setVisibility(0);
          localObject = parama.gWM;
          d.g.b.p.g(localObject, "itemView.likeTv");
          ((TextView)localObject).setVisibility(8);
          if (localInteger1 != null)
          {
            localObject = parama.gWM;
            d.g.b.p.g(localObject, "itemView.likeTv");
            if (localInteger1.intValue() <= 0) {
              break label465;
            }
            i = 0;
            label258:
            ((TextView)localObject).setVisibility(i);
            parama.gWM.setText((CharSequence)String.valueOf(localInteger1.intValue()));
          }
          if (localInteger2 != null) {
            break label472;
          }
          label288:
          parama.EJX.setImageResource(2131689706);
        }
      }
      for (;;)
      {
        parama.EJX.setOnClickListener((View.OnClickListener)new d(this, paramBoolean, paramaam, paramnm, parama));
        AppMethodBeat.o(175697);
        return;
        localObject = null;
        break;
        localObject = Integer.valueOf(paramnm.FZO);
        break;
        label346:
        localInteger1 = null;
        break label55;
        label352:
        localInteger1 = Integer.valueOf(paramnm.FYW);
        break label55;
        label364:
        localInteger2 = null;
        break label73;
        label370:
        localInteger2 = Integer.valueOf(paramnm.FYX);
        break label73;
        label382:
        str1 = null;
        break label105;
        label388:
        str1 = paramnm.content;
        break label105;
        label397:
        if (((Integer)localObject).intValue() != 0) {
          break label166;
        }
        paramnm = parama.EJZ;
        d.g.b.p.g(paramnm, "itemView.notChosen");
        paramnm.setVisibility(0);
        paramnm = parama.EJX;
        d.g.b.p.g(paramnm, "itemView.likeThumb");
        paramnm.setVisibility(8);
        parama = parama.gWM;
        d.g.b.p.g(parama, "itemView.likeTv");
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
        parama.EJX.setImageResource(2131689705);
      }
    }
    
    public final void clear()
    {
      AppMethodBeat.i(82703);
      this.fXm.clear();
      notifyDataSetChanged();
      AppMethodBeat.o(82703);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(82706);
      int i = this.fXm.size();
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
      d.g.b.p.h(paramViewGroup, "viewGroup");
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.context).inflate(2131494947, null, false);
        d.g.b.p.g(paramView, "convertView");
        paramViewGroup = new b(paramView);
        paramView.setTag(paramViewGroup);
      }
      final nm localnm;
      Object localObject2;
      Object localObject1;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      for (;;)
      {
        localnm = Yz(paramInt);
        if (localnm == null) {
          break label1446;
        }
        d.g.b.p.h(localnm, "info");
        com.tencent.mm.av.a.a.aJh().a(localnm.hCp, paramViewGroup.jgy, EJS);
        localObject2 = paramViewGroup.EKc;
        localObject1 = paramViewGroup.EKf;
        d.g.b.p.h(localObject1, "itemView");
        if (localnm != null)
        {
          localObject3 = ((b)localObject2).context;
          localObject4 = (CharSequence)localnm.pqp;
          localObject5 = ((a)localObject1).oNR;
          d.g.b.p.g(localObject5, "itemView.nickName");
          localObject3 = k.b((Context)localObject3, (CharSequence)localObject4, ((TextView)localObject5).getTextSize());
          localObject4 = ((a)localObject1).oNR;
          d.g.b.p.g(localObject4, "itemView.nickName");
          ((TextView)localObject4).setText((CharSequence)localObject3);
          localObject3 = ((b)localObject2).context;
          localObject4 = (CharSequence)localnm.content;
          localObject5 = ((a)localObject1).EJU;
          d.g.b.p.g(localObject5, "itemView.desc");
          localObject3 = k.b((Context)localObject3, (CharSequence)localObject4, ((NeatTextView)localObject5).getTextSize());
          ((a)localObject1).EJU.aq((CharSequence)localObject3);
          ((a)localObject1).EJV.setIconColor(((b)localObject2).context.getResources().getColor(2131099769));
          localObject3 = ((a)localObject1).EJV;
          d.g.b.p.g(localObject3, "itemView.deleteIv");
          ((WeImageView)localObject3).setVisibility(0);
          localObject3 = ((a)localObject1).EJW;
          d.g.b.p.g(localObject3, "itemView.deleteSplit");
          ((ImageView)localObject3).setVisibility(0);
          ((a)localObject1).EJV.setOnClickListener((View.OnClickListener)new e((b)localObject2, localnm));
          ((b)localObject2).a((a)localObject1, localnm, null, false);
          localObject2 = ((a)localObject1).EKa;
          d.g.b.p.g(localObject2, "itemView.replyPrefix");
          ((ImageView)localObject2).setVisibility(8);
          localObject1 = ((a)localObject1).EKb;
          d.g.b.p.g(localObject1, "itemView.sameReplyPrefix");
          ((ImageView)localObject1).setVisibility(4);
        }
        localObject1 = paramViewGroup.EKg;
        d.g.b.p.g(localObject1, "txtReply");
        ((TextView)localObject1).setVisibility(8);
        if (!n.a(paramViewGroup.EKc.EJQ)) {
          break label1446;
        }
        localObject1 = paramViewGroup.EKg;
        d.g.b.p.g(localObject1, "txtReply");
        ((TextView)localObject1).setVisibility(0);
        paramViewGroup.EKg.setOnClickListener((View.OnClickListener)new n.b.b.a(paramViewGroup, localnm));
        localObject1 = ((Iterable)paramViewGroup.heL).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (View)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            paramViewGroup.Arf.removeView((View)localObject2);
            paramViewGroup.EKc.EJP.add(localObject2);
          }
        }
        paramViewGroup = paramView.getTag();
        if (paramViewGroup == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout.MPMyCommentItemAdapter.BizCommentViewHolder");
          AppMethodBeat.o(82707);
          throw paramView;
        }
        paramViewGroup = (b)paramViewGroup;
      }
      paramViewGroup.heL.clear();
      int i;
      if ((localnm.FZP != null) && (localnm.FZP.GrP != null) && (localnm.FZP.GrP.size() > 0))
      {
        localObject1 = localnm.FZP.GrP;
        d.g.b.p.g(localObject1, "replyList");
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
            j.gkd();
          }
          localObject3 = (aam)localObject1;
          localObject1 = paramViewGroup.EKc;
          label719:
          Context localContext;
          CharSequence localCharSequence;
          Object localObject6;
          if (((b)localObject1).EJP.size() > 0)
          {
            localObject1 = ((b)localObject1).EJP.remove(0);
            d.g.b.p.g(localObject1, "viewPool.removeAt(0)");
            localObject1 = (View)localObject1;
            paramViewGroup.heL.add(localObject1);
            paramViewGroup.Arf.addView((View)localObject1);
            localObject4 = paramViewGroup.EKc;
            d.g.b.p.g(localObject3, "reply");
            localObject1 = new a(paramViewGroup.EKc, (View)localObject1);
            d.g.b.p.h(localObject3, "reply");
            d.g.b.p.h(localObject1, "itemView");
            if (localnm == null) {
              break label1509;
            }
            localObject5 = (d.g.a.b)new g((b)localObject4, (a)localObject1, localnm);
            if (d.g.b.p.i(localnm.FQc, ((aam)localObject3).FQc) != true) {
              break label1222;
            }
            if (!((Boolean)((d.g.a.b)localObject5).invoke(Integer.valueOf(((aam)localObject3).GrO))).booleanValue())
            {
              localObject5 = ((a)localObject1).oNR;
              d.g.b.p.g(localObject5, "itemView.nickName");
              localContext = ((b)localObject4).context;
              localCharSequence = (CharSequence)localnm.pqp;
              localObject6 = ((a)localObject1).oNR;
              d.g.b.p.g(localObject6, "itemView.nickName");
              ((TextView)localObject5).setText((CharSequence)k.b(localContext, localCharSequence, ((TextView)localObject6).getTextSize()));
              localObject5 = ((a)localObject1).EJU;
              localContext = ((b)localObject4).context;
              localCharSequence = (CharSequence)((aam)localObject3).content;
              localObject6 = ((a)localObject1).EJU;
              d.g.b.p.g(localObject6, "itemView.desc");
              ((NeatTextView)localObject5).aq((CharSequence)k.b(localContext, localCharSequence, ((NeatTextView)localObject6).getTextSize()));
              ((a)localObject1).EJV.setIconColor(((b)localObject4).context.getResources().getColor(2131099769));
              localObject5 = ((a)localObject1).EJV;
              d.g.b.p.g(localObject5, "itemView.deleteIv");
              ((WeImageView)localObject5).setVisibility(0);
              localObject5 = ((a)localObject1).EJW;
              d.g.b.p.g(localObject5, "itemView.deleteSplit");
              ((ImageView)localObject5).setVisibility(0);
              ((b)localObject4).a((a)localObject1, localnm, (aam)localObject3, true);
              ((a)localObject1).EJV.setOnClickListener((View.OnClickListener)new f((b)localObject4, localnm, (aam)localObject3));
            }
            label1073:
            localObject4 = ((a)localObject1).EKa;
            d.g.b.p.g(localObject4, "itemView.replyPrefix");
            ((ImageView)localObject4).setVisibility(0);
            localObject4 = ((a)localObject1).EKb;
            d.g.b.p.g(localObject4, "itemView.sameReplyPrefix");
            ((ImageView)localObject4).setVisibility(4);
            if (i + 1 < localnm.FZP.GrP.size())
            {
              localObject1 = ((a)localObject1).EKb;
              d.g.b.p.g(localObject1, "itemView.sameReplyPrefix");
              if (!d.g.b.p.i(((aam)localObject3).FQc, ((aam)localnm.FZP.GrP.get(i + 1)).FQc)) {
                break label1440;
              }
            }
          }
          label1440:
          for (i = 0;; i = 4)
          {
            ((ImageView)localObject1).setVisibility(i);
            i = j;
            break;
            localObject1 = View.inflate(((b)localObject1).context, 2131494946, null);
            d.g.b.p.g(localObject1, "View.inflate(context, R.…mment_content_item, null)");
            break label719;
            label1222:
            if (((Boolean)((d.g.a.b)localObject5).invoke(Integer.valueOf(((aam)localObject3).GrO))).booleanValue()) {
              break label1073;
            }
            localObject5 = ((a)localObject1).oNR;
            d.g.b.p.g(localObject5, "itemView.nickName");
            localContext = ((b)localObject4).context;
            localCharSequence = (CharSequence)((b)localObject4).context.getResources().getString(2131761339);
            localObject6 = ((a)localObject1).oNR;
            d.g.b.p.g(localObject6, "itemView.nickName");
            ((TextView)localObject5).setText((CharSequence)k.b(localContext, localCharSequence, ((TextView)localObject6).getTextSize()));
            localObject5 = ((a)localObject1).EJU;
            localContext = ((b)localObject4).context;
            localCharSequence = (CharSequence)((aam)localObject3).content;
            localObject6 = ((a)localObject1).EJU;
            d.g.b.p.g(localObject6, "itemView.desc");
            ((NeatTextView)localObject5).aq((CharSequence)k.b(localContext, localCharSequence, ((NeatTextView)localObject6).getTextSize()));
            localObject5 = ((a)localObject1).EJV;
            d.g.b.p.g(localObject5, "itemView.deleteIv");
            ((WeImageView)localObject5).setVisibility(8);
            localObject5 = ((a)localObject1).EJW;
            d.g.b.p.g(localObject5, "itemView.deleteSplit");
            ((ImageView)localObject5).setVisibility(8);
            ((b)localObject4).a((a)localObject1, localnm, (aam)localObject3, true);
            break label1073;
          }
        }
        else
        {
          label1446:
          if (paramInt == getCount() - 1)
          {
            paramViewGroup = paramViewGroup.EKe;
            d.g.b.p.g(paramViewGroup, "holder.endlineLayout");
            paramViewGroup.setVisibility(0);
            this.EJQ.getAppMsgCommentList();
          }
          for (;;)
          {
            AppMethodBeat.o(82707);
            return paramView;
            paramViewGroup = paramViewGroup.EKe;
            d.g.b.p.g(paramViewGroup, "holder.endlineLayout");
            paramViewGroup.setVisibility(8);
          }
        }
        label1509:
        i = j;
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;Landroid/view/View;)V", "deleteIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getDeleteIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setDeleteIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "deleteSplit", "Landroid/widget/ImageView;", "getDeleteSplit", "()Landroid/widget/ImageView;", "desc", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "getDesc", "()Lcom/tencent/neattextview/textview/view/NeatTextView;", "setDesc", "(Lcom/tencent/neattextview/textview/view/NeatTextView;)V", "likeThumb", "getLikeThumb", "likeTv", "Landroid/widget/TextView;", "getLikeTv", "()Landroid/widget/TextView;", "setLikeTv", "(Landroid/widget/TextView;)V", "nickName", "getNickName", "setNickName", "notChosen", "getNotChosen", "replyDelete", "getReplyDelete", "replyPrefix", "getReplyPrefix", "sameReplyPrefix", "getSameReplyPrefix", "plugin-webview_release"})
    public final class a
    {
      NeatTextView EJU;
      WeImageView EJV;
      final ImageView EJW;
      final ImageView EJX;
      final TextView EJY;
      final TextView EJZ;
      final ImageView EKa;
      final ImageView EKb;
      TextView gWM;
      TextView oNR;
      
      public a()
      {
        AppMethodBeat.i(82699);
        this.oNR = ((TextView)((View)localObject).findViewById(2131297382));
        this.gWM = ((TextView)((View)localObject).findViewById(2131297381));
        this.EJU = ((NeatTextView)((View)localObject).findViewById(2131297378));
        this.EJV = ((WeImageView)((View)localObject).findViewById(2131297379));
        this.EJW = ((ImageView)((View)localObject).findViewById(2131297277));
        this.EJX = ((ImageView)((View)localObject).findViewById(2131297279));
        this.EJY = ((TextView)((View)localObject).findViewById(2131297282));
        this.EJZ = ((TextView)((View)localObject).findViewById(2131297280));
        this.EKa = ((ImageView)((View)localObject).findViewById(2131297300));
        this.EKb = ((ImageView)((View)localObject).findViewById(2131297301));
        this$1 = ((View)localObject).getContext();
        Object localObject = this.EJU;
        d.g.b.p.g(n.b.this, "context");
        ((NeatTextView)localObject).setTextColor(o.c(2130968850, n.b.this));
        AppMethodBeat.o(82699);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentViewHolder;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAvatar", "()Landroid/widget/ImageView;", "commentList", "Ljava/util/ArrayList;", "getCommentList", "()Ljava/util/ArrayList;", "content", "Landroid/widget/LinearLayout;", "getContent", "()Landroid/widget/LinearLayout;", "endlineLayout", "getEndlineLayout", "setEndlineLayout", "(Landroid/widget/LinearLayout;)V", "fansContent", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;", "getFansContent", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "setFansContent", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;)V", "fansLayout", "getFansLayout", "setFansLayout", "txtReply", "Landroid/widget/TextView;", "getTxtReply", "()Landroid/widget/TextView;", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "plugin-webview_release"})
    public final class b
    {
      final LinearLayout Arf;
      private LinearLayout EKd;
      LinearLayout EKe;
      n.b.a EKf;
      final TextView EKg;
      final ArrayList<View> heL;
      final ImageView jgy;
      
      public b()
      {
        AppMethodBeat.i(82700);
        this.jgy = ((ImageView)localObject.findViewById(2131297374));
        this.Arf = ((LinearLayout)localObject.findViewById(2131297377));
        this.EKd = ((LinearLayout)localObject.findViewById(2131297389));
        this.EKe = ((LinearLayout)localObject.findViewById(2131299488));
        LinearLayout localLinearLayout = this.EKd;
        d.g.b.p.g(localLinearLayout, "fansLayout");
        this.EKf = new n.b.a(n.b.this, (View)localLinearLayout);
        this.EKg = ((TextView)localObject.findViewById(2131297281));
        this.heL = new ArrayList();
        AppMethodBeat.o(82700);
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
      static final class a
        implements View.OnClickListener
      {
        a(n.b.b paramb, nm paramnm) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(175691);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentViewHolder$update$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          this.EKh.EKc.EJQ.tW(3);
          this.EKh.EKc.EJQ.u(n.b.a(this.EKi), this.EKi.FQb, true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentViewHolder$update$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(175691);
        }
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d
      implements View.OnClickListener
    {
      d(n.b paramb, boolean paramBoolean, aam paramaam, nm paramnm, n.b.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(175692);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$showLikeStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        n.b(this.EKc.EJQ).clearFocus();
        int i;
        if (paramBoolean)
        {
          paramView = paramaam;
          if (paramView != null)
          {
            paramView = Integer.valueOf(paramView.GrL);
            if (paramView == null) {
              d.g.b.p.gkB();
            }
            i = paramView.intValue();
            label86:
            if (!paramBoolean) {
              break label544;
            }
            paramView = paramaam;
            if (paramView == null) {
              break label539;
            }
            paramView = Integer.valueOf(paramView.GrM);
            label110:
            if (paramView != null) {
              break label558;
            }
            label114:
            parama.EJX.setImageResource(2131689705);
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
          parama.gWM.setText((CharSequence)String.valueOf(i));
          localObject = parama.gWM;
          d.g.b.p.g(localObject, "itemView.likeTv");
          int j;
          if (i > 0)
          {
            j = 0;
            label175:
            ((TextView)localObject).setVisibility(j);
            fh localfh = new fh();
            localfh.FQb = paramnm.FQb;
            localfh.FQc = paramnm.FQc;
            localfh.oGc = 1;
            if (paramBoolean)
            {
              localObject = paramaam;
              if (localObject == null) {
                break label591;
              }
              localObject = Integer.valueOf(((aam)localObject).FQe);
              label248:
              if (localObject == null) {
                d.g.b.p.gkB();
              }
              localfh.FQe = ((Integer)localObject).intValue();
              localfh.oGc = 2;
            }
            if (paramView != null) {
              break label597;
            }
            label276:
            j = 0;
            label278:
            localfh.FQd = j;
            localObject = this.EKc.EJQ;
            d.g.b.p.h(localfh, "req");
            localfh.scene = ((n)localObject).scene;
            localfh.FPd = ((n)localObject).otZ;
            localfh.url = ((n)localObject).url;
            localfh.FPb = ((n)localObject).hBV;
            localfh.session_id = ((n)localObject).oua;
            localfh.FPc = ((n)localObject).otX;
            com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
            locala.c((com.tencent.mm.bw.a)localfh);
            locala.d((com.tencent.mm.bw.a)new fi());
            locala.DN("/cgi-bin/mmbiz-bin/appmsg/appmsg_like_comment");
            locala.oS(2759);
            locala.oU(0);
            locala.oV(0);
            IPCRunCgi.a(locala.aDS(), (IPCRunCgi.a)new n.d((n)localObject));
            if (paramView != null) {
              break label609;
            }
            label459:
            paramView = Integer.valueOf(0);
            label464:
            if (!paramBoolean) {
              break label624;
            }
            localObject = paramaam;
            if (localObject != null) {
              ((aam)localObject).GrM = paramView.intValue();
            }
            paramView = paramaam;
            if (paramView != null) {
              paramView.GrL = i;
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$showLikeStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(175692);
            return;
            paramView = null;
            break;
            i = paramnm.FYW;
            break label86;
            label539:
            paramView = null;
            break label110;
            label544:
            paramView = Integer.valueOf(paramnm.FYX);
            break label110;
            label558:
            if (paramView.intValue() != 0) {
              break label114;
            }
            parama.EJX.setImageResource(2131689706);
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
            paramnm.FYX = paramView.intValue();
            paramnm.FYW = i;
          }
        }
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(n.b paramb, nm paramnm) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(82702);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$updateCommentContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        new d.a(n.b.a(this.EKc)).aZh(n.b.a(this.EKc).getString(2131756650)).aZi("").afW(n.b.a(this.EKc).getResources().getColor(2131099804)).afU(2131755707).c((DialogInterface.OnClickListener)new a(this)).afV(2131756755).fQv().show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$updateCommentContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82702);
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
      static final class a
        implements DialogInterface.OnClickListener
      {
        a(n.b.e parame) {}
        
        public final void onClick(DialogInterface paramDialogInterface, int paramInt)
        {
          AppMethodBeat.i(82701);
          paramDialogInterface = new fl();
          paramDialogInterface.FQb = this.EKl.EKi.FQb;
          paramDialogInterface.oGc = 2;
          this.EKl.EKc.EJQ.a(paramDialogInterface);
          com.tencent.mm.plugin.webview.h.a.XF(13);
          AppMethodBeat.o(82701);
        }
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f
      implements View.OnClickListener
    {
      f(n.b paramb, nm paramnm, aam paramaam) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(175694);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$updateReplyView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        new d.a(n.b.a(this.EKc)).aZh(n.b.a(this.EKc).getString(2131756571)).aZi("").afW(n.b.a(this.EKc).getResources().getColor(2131099804)).afU(2131755707).c((DialogInterface.OnClickListener)new a(this)).afV(2131756755).fQv().show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$updateReplyView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(175694);
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
      static final class a
        implements DialogInterface.OnClickListener
      {
        a(n.b.f paramf) {}
        
        public final void onClick(DialogInterface paramDialogInterface, int paramInt)
        {
          AppMethodBeat.i(175693);
          paramDialogInterface = new fl();
          paramDialogInterface.FQb = this.EKm.EKi.FQb;
          paramDialogInterface.FQe = this.EKm.EKj.FQe;
          paramDialogInterface.oGc = 4;
          this.EKm.EKc.EJQ.a(paramDialogInterface);
          com.tencent.mm.plugin.webview.h.a.XF(13);
          AppMethodBeat.o(175693);
        }
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<no name provided>", "", "delFlag", "", "invoke"})
    static final class g
      extends q
      implements d.g.a.b<Integer, Boolean>
    {
      g(n.b paramb, n.b.a parama, nm paramnm)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "", "onHide", "", "onShow", "plugin-webview_release"})
  public static abstract interface c
  {
    public abstract void onHide();
    
    public abstract void onShow();
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class d
    implements IPCRunCgi.a
  {
    d(n paramn) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(175699);
      com.tencent.mm.sdk.platformtools.ar.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(175698);
          Object localObject = p.EKF;
          p.b(this.EKn.EJN.getWebView().eWn());
          if (this.EKn.EJN.getWeakThis$plugin_webview_release().get() != null)
          {
            localObject = this.EKn.EJN.getWeakThis$plugin_webview_release().get();
            if (localObject == null)
            {
              localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout");
              AppMethodBeat.o(175698);
              throw ((Throwable)localObject);
            }
            localObject = (n)localObject;
            int i = paramInt1;
            int j = paramInt2;
            String str = paramString;
            com.tencent.mm.ak.b localb = paramb;
            d.g.b.p.g(localb, "rr");
            n.b((n)localObject, i, j, str, localb);
          }
          AppMethodBeat.o(175698);
        }
      });
      AppMethodBeat.o(175699);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class e
    implements IPCRunCgi.a
  {
    e(n paramn) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(82711);
      com.tencent.mm.sdk.platformtools.ar.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(82710);
          Object localObject = p.EKF;
          p.b(this.EKo.EJN.getWebView().eWn());
          if (this.EKo.EJN.getWeakThis$plugin_webview_release().get() != null)
          {
            localObject = this.EKo.EJN.getWeakThis$plugin_webview_release().get();
            if (localObject == null)
            {
              localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout");
              AppMethodBeat.o(82710);
              throw ((Throwable)localObject);
            }
            localObject = (n)localObject;
            int i = paramInt1;
            int j = paramInt2;
            String str = paramString;
            com.tencent.mm.ak.b localb = paramb;
            d.g.b.p.g(localb, "rr");
            n.a((n)localObject, i, j, str, localb);
          }
          AppMethodBeat.o(82710);
        }
      });
      AppMethodBeat.o(82711);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class f
    implements IPCRunCgi.a
  {
    f(n paramn) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(82713);
      n.f(this.EJN);
      com.tencent.mm.sdk.platformtools.ar.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(82712);
          Object localObject = p.EKF;
          p.b(this.EKp.EJN.getWebView().eWn());
          if (this.EKp.EJN.getWeakThis$plugin_webview_release().get() != null)
          {
            localObject = this.EKp.EJN.getWeakThis$plugin_webview_release().get();
            if (localObject == null)
            {
              localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout");
              AppMethodBeat.o(82712);
              throw ((Throwable)localObject);
            }
            localObject = (n)localObject;
            com.tencent.mm.ak.b localb = paramb;
            d.g.b.p.g(localb, "rr");
            n.a((n)localObject, localb);
          }
          AppMethodBeat.o(82712);
        }
      });
      if (paramInt1 == 2)
      {
        com.tencent.mm.plugin.webview.h.a.XF(8);
        AppMethodBeat.o(82713);
        return;
      }
      if (paramInt1 != 0) {
        com.tencent.mm.plugin.webview.h.a.XF(9);
      }
      AppMethodBeat.o(82713);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$hideAnimation$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "ani", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"})
  public static final class g
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(82714);
      d.g.b.p.h(paramAnimation, "ani");
      paramAnimation = this.EJN.getWeakThis$plugin_webview_release().get();
      if (paramAnimation == null)
      {
        paramAnimation = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout");
        AppMethodBeat.o(82714);
        throw paramAnimation;
      }
      ((n)paramAnimation).setVisibility(8);
      n.e(this.EJN).clearAnimation();
      AppMethodBeat.o(82714);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation) {}
    
    public final void onAnimationStart(Animation paramAnimation) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "state", "", "onKeyBoardStateChange"})
  static final class h
    implements KeyboardLinearLayout.a
  {
    h(n paramn) {}
    
    public final void Hs(int paramInt)
    {
      AppMethodBeat.i(82717);
      n.a locala = n.EJM;
      ae.i(n.access$getTAG$cp(), "onKeyBoardStateChange, state = ".concat(String.valueOf(paramInt)));
      if (paramInt == -3)
      {
        int i = n.c(this.EJN).getKeyBoardHeight();
        if (i > 0)
        {
          n.a(this.EJN, i);
          n.a(this.EJN, i);
        }
        new aq().postDelayed((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(82715);
            n.d(this.EKq.EJN).ehf();
            n.d(this.EKq.EJN).postInvalidate();
            n.e(this.EKq.EJN).postInvalidate();
            AppMethodBeat.o(82715);
          }
        }, 10L);
      }
      for (;;)
      {
        n.b(this.EJN, paramInt);
        AppMethodBeat.o(82717);
        return;
        n.a(this.EJN, 0);
        n.a(this.EJN, 0);
        new aq().postDelayed((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(82716);
            n.d(this.EKq.EJN).eZp();
            n.d(this.EKq.EJN).postInvalidate();
            n.e(this.EKq.EJN).postInvalidate();
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
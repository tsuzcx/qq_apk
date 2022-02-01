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
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.protocal.protobuf.es;
import com.tencent.mm.protocal.protobuf.et;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.protocal.protobuf.fb;
import com.tencent.mm.protocal.protobuf.fe;
import com.tencent.mm.protocal.protobuf.ff;
import com.tencent.mm.protocal.protobuf.mm;
import com.tencent.mm.protocal.protobuf.xs;
import com.tencent.mm.protocal.protobuf.xt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.neattextview.textview.view.NeatTextView;
import d.a.j;
import d.g.b.u;
import d.g.b.w;
import d.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewKeyboardLinearLayout;", "webView", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "isDark", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;ZLandroid/content/Context;Landroid/util/AttributeSet;)V", "actionView", "Landroid/view/View;", "adapter", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;", "callback", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "getCallback", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "setCallback", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;)V", "cancelTv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "commentTopicId", "", "getCommentTopicId", "()J", "setCommentTopicId", "(J)V", "commitBt", "Landroid/widget/Button;", "contentEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "currentKbState", "", "enterId", "getEnterId", "()I", "setEnterId", "(I)V", "hasReadOpenCfg", "isDoingGetMyComment", "isHaokan", "isReplyOpen", "itemShowType", "getItemShowType", "setItemShowType", "kbLayout", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "minHeaderHeight", "getMinHeaderHeight", "setMinHeaderHeight", "myCommentOffset", "getMyCommentOffset", "setMyCommentOffset", "myCommentTitleTv", "Landroid/widget/TextView;", "myCommentTv", "myCommentView", "recyclerView", "Landroid/widget/ListView;", "replyPersonalCommentId", "replyTip", "root", "savePortHeight", "sayFooter", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter;", "getSayFooter", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter;", "sayFooter$delegate", "Lkotlin/Lazy;", "scene", "getScene", "setScene", "subScene", "getSubScene", "setSubScene", "timeLineSessionId", "getTimeLineSessionId", "setTimeLineSessionId", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "weakThis", "Ljava/lang/ref/WeakReference;", "getWeakThis$plugin_webview_release", "()Ljava/lang/ref/WeakReference;", "setWeakThis$plugin_webview_release", "(Ljava/lang/ref/WeakReference;)V", "getWebView", "()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "caculateHeight", "", "newMarginBottom", "checkHeight", "h", "clearPersonalComment", "refreshHeight", "closeComment", "contentEtOnClick", "dealOrientaion", "orientation", "doAppMsgLikeComment", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgLikeCommentReq;", "doAppMsgOperateComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "doReport", "actionType", "fixKeyBoardMargin", "getAppMsgCommentList", "getNavHeightByDisplay", "getReplyHeight", "getRootHeight", "hide", "hideAnimation", "initKeyboardListener", "isShow", "onAddCommentSuccess", "onAppMsgLikeComment", "errType", "errCode", "errMsg", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "onAppMsgOperateComment", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDeleteComment", "onDeleteCommentReply", "onDestroy", "onGetCommentList", "onKeyBackPress", "onNoComment", "onResume", "onTouchClose", "replyToPersonalComment", "replyContent", "personalCommentId", "saveRootHeight", "height", "setData", "setRootHeight", "show", "showAnimation", "showCommentView", "showLayout", "showLayoutReply", "updateData", "resp", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommentListResp;", "clearUpdate", "updateUrl", "curUrl", "Companion", "MPMyCommentItemAdapter", "MPWriteCommentLayoutCallback", "plugin-webview_release"})
public final class n
  extends WebViewKeyboardLinearLayout
{
  public static final n.a Bvn;
  private static final String TAG = "MicroMsg.MPWriteCommentLayout";
  private final WebViewKeyboardLinearLayout BgL;
  public int BiC;
  private final d.f BuS;
  private final WeImageView BuT;
  private final Button BuU;
  public final MMEditText BuV;
  private final ListView BuW;
  private final View BuX;
  private final TextView BuY;
  private final TextView BuZ;
  private final TextView Bva;
  private b Bvb;
  private boolean Bvc;
  private int Bvd;
  private int Bve;
  private int Bvf;
  private long Bvg;
  private c Bvh;
  private boolean Bvi;
  private int Bvj;
  private boolean Bvk;
  private boolean Bvl;
  public final WebViewUI Bvm;
  private final boolean dxi;
  private final View frN;
  int gGx;
  private final View iiG;
  private WeakReference<n> mLl;
  int niH;
  int niJ;
  int niK;
  int scene;
  private String title;
  String url;
  
  static
  {
    AppMethodBeat.i(82720);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(n.class), "sayFooter", "getSayFooter()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter;")) };
    Bvn = new n.a((byte)0);
    TAG = "MicroMsg.MPWriteCommentLayout";
    AppMethodBeat.o(82720);
  }
  
  public n(WebViewUI paramWebViewUI, Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(175710);
    this.Bvm = paramWebViewUI;
    this.dxi = false;
    paramWebViewUI = View.inflate(paramContext, 2131494959, (ViewGroup)this);
    if (paramWebViewUI == null)
    {
      paramWebViewUI = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout");
      AppMethodBeat.o(175710);
      throw paramWebViewUI;
    }
    this.BgL = ((WebViewKeyboardLinearLayout)paramWebViewUI);
    paramWebViewUI = findViewById(2131302501);
    d.g.b.k.g(paramWebViewUI, "findViewById(R.id.mp_video_comment_action_layout)");
    this.iiG = paramWebViewUI;
    this.BuS = d.g.E((d.g.a.a)new n.j(this));
    paramWebViewUI = findViewById(2131302502);
    d.g.b.k.g(paramWebViewUI, "findViewById(R.id.mp_video_comment_cancel)");
    this.BuT = ((WeImageView)paramWebViewUI);
    paramWebViewUI = findViewById(2131302504);
    d.g.b.k.g(paramWebViewUI, "findViewById(R.id.mp_video_comment_ok)");
    this.BuU = ((Button)paramWebViewUI);
    paramWebViewUI = findViewById(2131302503);
    d.g.b.k.g(paramWebViewUI, "findViewById(R.id.mp_video_comment_et)");
    this.BuV = ((MMEditText)paramWebViewUI);
    paramWebViewUI = findViewById(2131297394);
    d.g.b.k.g(paramWebViewUI, "findViewById(R.id.biz_video_my_comment_list)");
    this.BuW = ((ListView)paramWebViewUI);
    paramWebViewUI = findViewById(2131302518);
    d.g.b.k.g(paramWebViewUI, "findViewById(R.id.mp_write_comment_root)");
    this.frN = paramWebViewUI;
    paramWebViewUI = findViewById(2131302517);
    d.g.b.k.g(paramWebViewUI, "findViewById(R.id.mp_vid…rite_comment_scroll_view)");
    this.BuX = paramWebViewUI;
    paramWebViewUI = findViewById(2131297395);
    d.g.b.k.g(paramWebViewUI, "findViewById(R.id.biz_video_my_comment_tv)");
    this.BuY = ((TextView)paramWebViewUI);
    paramWebViewUI = findViewById(2131302507);
    d.g.b.k.g(paramWebViewUI, "findViewById(R.id.mp_video_my_comment_title)");
    this.BuZ = ((TextView)paramWebViewUI);
    paramWebViewUI = findViewById(2131297401);
    d.g.b.k.g(paramWebViewUI, "findViewById(R.id.biz_video_reply_tip)");
    this.Bva = ((TextView)paramWebViewUI);
    this.BiC = -1;
    this.url = "";
    this.title = "";
    this.mLl = new WeakReference(this);
    getSayFooter().setMMEditText(this.BuV);
    getSayFooter().setVisibility(8);
    this.BuV.setOnClickListener((View.OnClickListener)new n.1(this));
    this.BuV.setOnLongClickListener((View.OnLongClickListener)new n.2(this));
    this.BgL.setOnTouchListener((View.OnTouchListener)new n.3(this));
    this.frN.setOnClickListener((View.OnClickListener)n.4.Bvp);
    int i = getRootHeight();
    if (i > 0)
    {
      paramWebViewUI = this.frN.getLayoutParams();
      if (paramWebViewUI == null)
      {
        paramWebViewUI = new v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        AppMethodBeat.o(175710);
        throw paramWebViewUI;
      }
      paramWebViewUI.height = i;
      this.frN.setLayoutParams(paramWebViewUI);
    }
    if (!z.ip(paramContext)) {
      TQ(2);
    }
    this.BuT.setOnClickListener((View.OnClickListener)new n.5(this));
    this.BuU.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82697);
        if (n.j(this.Bvo))
        {
          paramAnonymousView = n.b(this.Bvo).getText().toString();
          com.tencent.mm.plugin.webview.c.f localf = this.Bvo.getWebView().AQP;
          if (localf != null)
          {
            localf.t(1, paramAnonymousView, 1);
            AppMethodBeat.o(82697);
            return;
          }
          AppMethodBeat.o(82697);
          return;
        }
        this.Bvo.getWebView().hideVKB();
        if (n.d(this.Bvo).dCK()) {
          n.d(this.Bvo).dCL();
        }
        paramAnonymousView = new fe();
        paramAnonymousView.content = n.b(this.Bvo).getText().toString();
        paramAnonymousView.ntg = 1;
        if (n.k(this.Bvo) != 0)
        {
          paramAnonymousView.ntg = 3;
          paramAnonymousView.CzO = n.k(this.Bvo);
        }
        this.Bvo.a(paramAnonymousView);
        com.tencent.mm.plugin.webview.h.a.Tb(10);
        AppMethodBeat.o(82697);
      }
    });
    this.BuV.addTextChangedListener((TextWatcher)new n.7(this));
    paramWebViewUI = this.BuU;
    paramContext = this.BuV.getText();
    d.g.b.k.g(paramContext, "contentEt.text");
    if (((CharSequence)paramContext).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramWebViewUI.setEnabled(bool);
      this.BuV.setOnTouchListener((View.OnTouchListener)new n.8(this));
      this.Bva.setVisibility(8);
      AppMethodBeat.o(175710);
      return;
    }
  }
  
  private final void TQ(int paramInt)
  {
    AppMethodBeat.i(82729);
    switch (paramInt)
    {
    default: 
      if (this.BgL.enN()) {
        TR(this.BgL.getKeyBoardHeight());
      }
      break;
    }
    for (;;)
    {
      this.BuV.setMinLines(5);
      AppMethodBeat.o(82729);
      return;
      paramInt = com.tencent.mm.ui.ap.iX(getContext());
      setRootHeight(com.tencent.mm.ui.ap.cf(getContext()).y - paramInt);
      this.BuV.setMinLines(3);
      AppMethodBeat.o(82729);
      return;
      if (this.Bvd != 0) {
        setRootHeight(this.Bvd);
      } else {
        TR(0);
      }
    }
  }
  
  private final void TR(int paramInt)
  {
    AppMethodBeat.i(82730);
    Object localObject = this.frN.getLayoutParams();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(82730);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.LayoutParams)localObject).height = (this.BuV.getHeight() + this.iiG.getHeight() + getNavHeightByDisplay() + com.tencent.mm.cd.a.fromDPToPix(getContext(), com.tencent.mm.cd.a.ar(getContext(), 60) + 16) + getReplyHeight() + paramInt);
    ((ViewGroup.LayoutParams)localObject).height = TS(((ViewGroup.LayoutParams)localObject).height);
    this.frN.setLayoutParams((ViewGroup.LayoutParams)localObject);
    TT(((ViewGroup.LayoutParams)localObject).height);
    AppMethodBeat.o(82730);
  }
  
  private final int TS(int paramInt)
  {
    AppMethodBeat.i(82732);
    int j = com.tencent.mm.ui.ap.iX(getContext());
    int k = com.tencent.mm.ui.ap.cf(getContext()).y;
    int i = k - j;
    if (paramInt > i) {}
    for (;;)
    {
      AppMethodBeat.o(82732);
      return i;
      i = paramInt;
      if (this.Bvf > 0)
      {
        int m = com.tencent.mm.cd.a.fromDPToPix(getContext(), 20);
        i = paramInt;
        if (paramInt < k - this.Bvf - j + m) {
          i = k - j - this.Bvf + m;
        }
      }
    }
  }
  
  private final void TT(int paramInt)
  {
    AppMethodBeat.i(82733);
    if (z.ip(getContext())) {
      this.Bvd = paramInt;
    }
    ax localax = ax.aFD("MPWriteCommentLayout");
    localax.encode("MPWriteCommentRootHeight", paramInt);
    localax.apply();
    AppMethodBeat.o(82733);
  }
  
  private final void erk()
  {
    AppMethodBeat.i(82723);
    View localView = this.BuX;
    Context localContext = getContext();
    d.g.b.k.g(localContext, "context");
    localView.setBackgroundColor(o.c(2130968842, localContext));
    this.BuY.setVisibility(8);
    AppMethodBeat.o(82723);
  }
  
  private void erm()
  {
    AppMethodBeat.i(175703);
    this.BuV.setText((CharSequence)"");
    this.Bvj = 0;
    getAppMsgCommentList();
    AppMethodBeat.o(175703);
  }
  
  private final void ern()
  {
    AppMethodBeat.i(182680);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(250L);
    localTranslateAnimation.setFillAfter(false);
    this.frN.clearAnimation();
    this.frN.startAnimation((Animation)localTranslateAnimation);
    AppMethodBeat.o(182680);
  }
  
  private final void ero()
  {
    AppMethodBeat.i(82737);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    localTranslateAnimation.setDuration(150L);
    localTranslateAnimation.setFillAfter(false);
    localTranslateAnimation.setAnimationListener((Animation.AnimationListener)new g(this));
    this.frN.clearAnimation();
    this.frN.startAnimation((Animation)localTranslateAnimation);
    AppMethodBeat.o(82737);
  }
  
  private final int getNavHeightByDisplay()
  {
    AppMethodBeat.i(82739);
    Point localPoint = com.tencent.mm.ui.ap.cf(getContext());
    Object localObject = this.Bvm.getWindow();
    if (localObject != null) {}
    for (localObject = ((Window)localObject).getDecorView();; localObject = null)
    {
      Rect localRect = new Rect();
      if (localObject != null) {
        ((View)localObject).getWindowVisibleDisplayFrame(localRect);
      }
      int i = localRect.bottom;
      int j = localPoint.y - i - this.BgL.getKeyBoardHeight();
      ad.v(TAG, "getNavHeightByDisplay screenHeight = " + i + ", realSize = " + localPoint.y);
      i = j;
      if (j < 0)
      {
        i = com.tencent.mm.ui.ap.eb(getContext());
        ad.v(TAG, "getNavHeightByDisplay error");
      }
      ad.v(TAG, "getNavHeightByDisplay h = %s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(82739);
      return i;
    }
  }
  
  private final int getReplyHeight()
  {
    AppMethodBeat.i(182681);
    if (this.Bve != 0)
    {
      int i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 38);
      AppMethodBeat.o(182681);
      return i;
    }
    AppMethodBeat.o(182681);
    return 0;
  }
  
  private final int getRootHeight()
  {
    AppMethodBeat.i(82734);
    int i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 635);
    AppMethodBeat.o(82734);
    return i;
  }
  
  private final void setRootHeight(int paramInt)
  {
    AppMethodBeat.i(82731);
    Object localObject = this.frN.getLayoutParams();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(82731);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.LayoutParams)localObject).height = TS(paramInt);
    this.frN.setLayoutParams((ViewGroup.LayoutParams)localObject);
    TT(((ViewGroup.LayoutParams)localObject).height);
    AppMethodBeat.o(82731);
  }
  
  private final void show()
  {
    AppMethodBeat.i(82735);
    this.frN.clearAnimation();
    setVisibility(0);
    ern();
    c localc = this.Bvh;
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
    this.niJ = paramInt2;
    this.gGx = paramInt3;
    this.niH = paramInt4;
    this.url = paramString1;
    this.title = paramString2;
  }
  
  public final void a(fe paramfe)
  {
    AppMethodBeat.i(82741);
    d.g.b.k.h(paramfe, "req");
    paramfe.scene = this.scene;
    paramfe.CyR = this.niJ;
    paramfe.url = this.url;
    paramfe.title = this.title;
    paramfe.CzU = System.currentTimeMillis();
    paramfe.CyP = this.gGx;
    paramfe.session_id = this.niK;
    paramfe.CyQ = this.niH;
    paramfe.CyS = this.Bvg;
    Object localObject = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject).c((com.tencent.mm.bx.a)paramfe);
    ((com.tencent.mm.al.b.a)localObject).d((com.tencent.mm.bx.a)new ff());
    ((com.tencent.mm.al.b.a)localObject).wg("/cgi-bin/mmbiz-bin/appmsg/appmsg_operate_comment");
    ((com.tencent.mm.al.b.a)localObject).nB(2617);
    ((com.tencent.mm.al.b.a)localObject).nD(0);
    ((com.tencent.mm.al.b.a)localObject).nE(0);
    IPCRunCgi.a(((com.tencent.mm.al.b.a)localObject).atI(), (IPCRunCgi.a)new e(this));
    paramfe = this.Bvm;
    localObject = p.Bwh;
    localObject = getContext().getString(2131755936);
    d.g.b.k.g(localObject, "context.getString(R.string.app_waiting)");
    Context localContext = getContext();
    d.g.b.k.g(localContext, "context");
    paramfe.a(p.a((String)localObject, localContext, this.Bvm.eoo()));
    AppMethodBeat.o(82741);
  }
  
  public final void ayI(String paramString)
  {
    AppMethodBeat.i(175701);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(175701);
      return;
    }
    this.url = paramString;
    AppMethodBeat.o(175701);
  }
  
  public final boolean bcB()
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
  
  public final void erl()
  {
    AppMethodBeat.i(82724);
    this.BgL.setOnkbdStateListener((KeyboardLinearLayout.a)new h(this));
    AppMethodBeat.o(82724);
  }
  
  public final boolean erp()
  {
    AppMethodBeat.i(175708);
    if (!this.Bvk) {
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pmL, 0) != 1) {
        break label86;
      }
    }
    label86:
    for (boolean bool = true;; bool = false)
    {
      this.Bvl = bool;
      this.Bvk = true;
      ad.v(TAG, "isReplyOpen = " + this.Bvl);
      bool = this.Bvl;
      AppMethodBeat.o(175708);
      return bool;
    }
  }
  
  public final void getAppMsgCommentList()
  {
    AppMethodBeat.i(82740);
    es locales = new es();
    locales.url = this.url;
    if (this.Bvi)
    {
      AppMethodBeat.o(82740);
      return;
    }
    locales.offset = this.Bvj;
    if (this.Bvj == -1)
    {
      ad.i(TAG, "no more my comment");
      AppMethodBeat.o(82740);
      return;
    }
    this.Bvi = true;
    locales.ntg = 2;
    locales.scene = this.scene;
    locales.CyR = this.niJ;
    locales.CyP = this.gGx;
    locales.session_id = this.niK;
    locales.CyQ = this.niH;
    locales.CyS = this.Bvg;
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    locala.c((com.tencent.mm.bx.a)locales);
    locala.d((com.tencent.mm.bx.a)new et());
    locala.wg("/cgi-bin/mmbiz-bin/appmsg/appmsg_comment_list");
    locala.nB(2866);
    locala.nD(0);
    locala.nE(0);
    IPCRunCgi.a(locala.atI(), (IPCRunCgi.a)new f(this));
    com.tencent.mm.plugin.webview.h.a.Tb(7);
    AppMethodBeat.o(82740);
  }
  
  public final c getCallback()
  {
    return this.Bvh;
  }
  
  public final long getCommentTopicId()
  {
    return this.Bvg;
  }
  
  public final int getEnterId()
  {
    return this.niH;
  }
  
  public final int getItemShowType()
  {
    return this.gGx;
  }
  
  public final int getMinHeaderHeight()
  {
    return this.Bvf;
  }
  
  public final int getMyCommentOffset()
  {
    return this.Bvj;
  }
  
  public final MPSmileyFooter getSayFooter()
  {
    AppMethodBeat.i(82721);
    MPSmileyFooter localMPSmileyFooter = (MPSmileyFooter)this.BuS.getValue();
    AppMethodBeat.o(82721);
    return localMPSmileyFooter;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final int getSubScene()
  {
    return this.niJ;
  }
  
  public final int getTimeLineSessionId()
  {
    return this.niK;
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
    return this.mLl;
  }
  
  public final WebViewUI getWebView()
  {
    return this.Bvm;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(82736);
    if (!bcB())
    {
      AppMethodBeat.o(82736);
      return;
    }
    if (getSayFooter().dCK()) {
      getSayFooter().dCL();
    }
    ero();
    this.Bvm.hideVKB();
    this.Bvj = 0;
    Object localObject = this.Bvb;
    if (localObject != null) {
      ((b)localObject).clear();
    }
    localObject = this.Bvh;
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
    d.g.b.k.h(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    TQ(paramConfiguration.orientation);
    if (getSayFooter().dCK()) {
      getSayFooter().dCL();
    }
    AppMethodBeat.o(82728);
  }
  
  public final void setCallback(c paramc)
  {
    this.Bvh = paramc;
  }
  
  public final void setCommentTopicId(long paramLong)
  {
    this.Bvg = paramLong;
  }
  
  public final void setEnterId(int paramInt)
  {
    this.niH = paramInt;
  }
  
  public final void setItemShowType(int paramInt)
  {
    this.gGx = paramInt;
  }
  
  public final void setMinHeaderHeight(int paramInt)
  {
    this.Bvf = paramInt;
  }
  
  public final void setMyCommentOffset(int paramInt)
  {
    this.Bvj = paramInt;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public final void setSubScene(int paramInt)
  {
    this.niJ = paramInt;
  }
  
  public final void setTimeLineSessionId(int paramInt)
  {
    this.niK = paramInt;
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
    d.g.b.k.h(paramWeakReference, "<set-?>");
    this.mLl = paramWeakReference;
    AppMethodBeat.o(82722);
  }
  
  public final void sw(int paramInt)
  {
    AppMethodBeat.i(175709);
    String str2 = Uri.parse(this.url).getQueryParameter("clicktime");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.url);
    localStringBuilder.append(",");
    localStringBuilder.append(this.scene);
    localStringBuilder.append(",");
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = "";
    }
    localStringBuilder.append(str1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",");
    localStringBuilder.append(System.currentTimeMillis());
    str1 = localStringBuilder.toString();
    ad.v(TAG, str1);
    h.vKh.kvStat(19265, str1);
    AppMethodBeat.o(175709);
  }
  
  public final void tE(boolean paramBoolean)
  {
    AppMethodBeat.i(82725);
    sw(1);
    tG(false);
    tF(paramBoolean);
    AppMethodBeat.o(82725);
  }
  
  public final void tF(boolean paramBoolean)
  {
    AppMethodBeat.i(175702);
    this.Bvc = paramBoolean;
    show();
    if (paramBoolean)
    {
      this.BuY.setVisibility(8);
      this.BuZ.setText((CharSequence)getContext().getString(2131756657));
      this.BuV.setHint(2131756659);
      this.BuU.setText(2131755884);
      localObject = this.BuU;
      localContext = getContext();
      d.g.b.k.g(localContext, "context");
      ((Button)localObject).setBackground(localContext.getResources().getDrawable(2131231294));
      localObject = (InputFilter)new InputFilter.LengthFilter(200);
      this.BuV.setFilters(new InputFilter[] { localObject });
      AppMethodBeat.o(175702);
      return;
    }
    getAppMsgCommentList();
    this.BuU.setText(2131756649);
    Object localObject = this.BuU;
    Context localContext = getContext();
    d.g.b.k.g(localContext, "context");
    ((Button)localObject).setBackground(o.gK(localContext));
    AppMethodBeat.o(175702);
  }
  
  public final void tG(boolean paramBoolean)
  {
    AppMethodBeat.i(175707);
    if (this.Bve != 0)
    {
      this.Bve = 0;
      if (paramBoolean) {
        TQ(z.iq(getContext()));
      }
    }
    this.Bva.setText((CharSequence)"");
    this.Bva.setVisibility(8);
    this.BuV.setHint((CharSequence)getContext().getString(2131756669));
    this.BuZ.setText((CharSequence)getContext().getString(2131756667));
    AppMethodBeat.o(175707);
  }
  
  public final void u(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(175705);
    d.g.b.k.h(paramString, "replyContent");
    this.Bve = paramInt;
    this.BuZ.setText((CharSequence)getContext().getString(2131756575));
    this.Bva.setVisibility(0);
    TextView localTextView = this.Bva;
    Context localContext = getContext();
    String str = paramString;
    if (bt.isNullOrNil(paramString)) {
      str = "";
    }
    localTextView.setText((CharSequence)localContext.getString(2131756574, new Object[] { str }));
    this.BuV.setHint((CharSequence)getContext().getString(2131756573));
    if (paramBoolean)
    {
      this.BuX.scrollTo(0, 0);
      this.BuV.requestFocus();
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
        paramString.showSoftInput((View)this.BuV, 0);
        AppMethodBeat.o(175705);
        return;
      }
    }
    AppMethodBeat.o(175705);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "controller", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "isDarkPanel", "", "(Landroid/content/Context;Ljava/util/LinkedList;Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;Z)V", "getController", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "setController", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;)V", "viewPool", "Ljava/util/ArrayList;", "Landroid/view/View;", "getViewPool", "()Ljava/util/ArrayList;", "clear", "", "getCommentView", "getCount", "", "getItem", "position", "getItemId", "", "i", "getLastInvalidReply", "", "info", "getView", "convertView", "viewGroup", "Landroid/view/ViewGroup;", "onDeleteComment", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "onDeleteCommentReply", "showLikeStatus", "itemView", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "reply", "Lcom/tencent/mm/protocal/protobuf/CommentReply;", "isReply", "update", "items", "", "clearUpdate", "updateCommentContentView", "updateReplyView", "index", "BizCommentContent", "BizCommentViewHolder", "Companion", "plugin-webview_release"})
  public static final class b
    extends BaseAdapter
  {
    private static com.tencent.mm.aw.a.a.c Bvt;
    public static final n.b.c Bvu;
    static final String TAG = "MicroMsg.MPMyCommentItemAdapter";
    final ArrayList<View> Bvq;
    n Bvr;
    private boolean Bvs;
    private final Context context;
    final LinkedList<mm> fyl;
    
    static
    {
      AppMethodBeat.i(82709);
      Bvu = new n.b.c((byte)0);
      TAG = "MicroMsg.MPMyCommentItemAdapter";
      Bvt = new c.a().or(2131100141).ayY().de(120, 120).a((com.tencent.mm.aw.a.c.c)new com.tencent.mm.pluginsdk.ui.applet.n()).a((com.tencent.mm.aw.a.c.a)new e()).aza().ag(com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 3)).azc();
      AppMethodBeat.o(82709);
    }
    
    public b(Context paramContext, LinkedList<mm> paramLinkedList, n paramn, boolean paramBoolean)
    {
      AppMethodBeat.i(162324);
      this.context = paramContext;
      this.fyl = paramLinkedList;
      this.Bvr = paramn;
      this.Bvs = paramBoolean;
      this.Bvq = new ArrayList();
      AppMethodBeat.o(162324);
    }
    
    private mm TU(int paramInt)
    {
      AppMethodBeat.i(82704);
      mm localmm = (mm)j.C((List)this.fyl, paramInt);
      AppMethodBeat.o(82704);
      return localmm;
    }
    
    public static String a(mm parammm)
    {
      AppMethodBeat.i(182678);
      d.g.b.k.h(parammm, "info");
      String str = parammm.content;
      int i;
      if ((parammm.CJf != null) && (!bt.gL((List)parammm.CJf.CZt)))
      {
        i = parammm.CJf.CZt.size() - 1;
        if (i >= 0) {
          if (((xs)parammm.CJf.CZt.get(i)).CZs != 0) {}
        }
      }
      for (parammm = ((xs)parammm.CJf.CZt.get(i)).content;; parammm = str)
      {
        d.g.b.k.g(parammm, "reply");
        AppMethodBeat.o(182678);
        return parammm;
        i -= 1;
        break;
      }
    }
    
    private void a(final a parama, final mm parammm, final xs paramxs, final boolean paramBoolean)
    {
      AppMethodBeat.i(175697);
      d.g.b.k.h(parama, "itemView");
      d.g.b.k.h(parammm, "info");
      Object localObject;
      Integer localInteger1;
      label55:
      Integer localInteger2;
      label73:
      String str1;
      label105:
      int i;
      if (paramBoolean) {
        if (paramxs != null)
        {
          localObject = Integer.valueOf(paramxs.CZr);
          if (!paramBoolean) {
            break label352;
          }
          if (paramxs == null) {
            break label346;
          }
          localInteger1 = Integer.valueOf(paramxs.CZp);
          if (!paramBoolean) {
            break label370;
          }
          if (paramxs == null) {
            break label364;
          }
          localInteger2 = Integer.valueOf(paramxs.CZq);
          String str2 = TAG;
          StringBuilder localStringBuilder = new StringBuilder("showLikeStatus content = ");
          if (!paramBoolean) {
            break label388;
          }
          if (paramxs == null) {
            break label382;
          }
          str1 = paramxs.content;
          ad.v(str2, str1 + ", isElected = " + localObject + ", likeNum = " + localInteger1 + ", likeStatus = " + localInteger2);
          parama.Bvy.setOnClickListener(null);
          if (localObject != null) {
            break label397;
          }
          label166:
          localObject = parama.BvA;
          d.g.b.k.g(localObject, "itemView.notChosen");
          ((TextView)localObject).setVisibility(8);
          localObject = parama.Bvy;
          d.g.b.k.g(localObject, "itemView.likeThumb");
          ((ImageView)localObject).setVisibility(0);
          localObject = parama.qWT;
          d.g.b.k.g(localObject, "itemView.likeTv");
          ((TextView)localObject).setVisibility(8);
          if (localInteger1 != null)
          {
            localObject = parama.qWT;
            d.g.b.k.g(localObject, "itemView.likeTv");
            if (localInteger1.intValue() <= 0) {
              break label465;
            }
            i = 0;
            label258:
            ((TextView)localObject).setVisibility(i);
            parama.qWT.setText((CharSequence)String.valueOf(localInteger1.intValue()));
          }
          if (localInteger2 != null) {
            break label472;
          }
          label288:
          parama.Bvy.setImageResource(2131689706);
        }
      }
      for (;;)
      {
        parama.Bvy.setOnClickListener((View.OnClickListener)new d(this, paramBoolean, paramxs, parammm, parama));
        AppMethodBeat.o(175697);
        return;
        localObject = null;
        break;
        localObject = Integer.valueOf(parammm.CJe);
        break;
        label346:
        localInteger1 = null;
        break label55;
        label352:
        localInteger1 = Integer.valueOf(parammm.CIp);
        break label55;
        label364:
        localInteger2 = null;
        break label73;
        label370:
        localInteger2 = Integer.valueOf(parammm.CIq);
        break label73;
        label382:
        str1 = null;
        break label105;
        label388:
        str1 = parammm.content;
        break label105;
        label397:
        if (((Integer)localObject).intValue() != 0) {
          break label166;
        }
        parammm = parama.BvA;
        d.g.b.k.g(parammm, "itemView.notChosen");
        parammm.setVisibility(0);
        parammm = parama.Bvy;
        d.g.b.k.g(parammm, "itemView.likeThumb");
        parammm.setVisibility(8);
        parama = parama.qWT;
        d.g.b.k.g(parama, "itemView.likeTv");
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
        parama.Bvy.setImageResource(2131689705);
      }
    }
    
    public final void clear()
    {
      AppMethodBeat.i(82703);
      this.fyl.clear();
      notifyDataSetChanged();
      AppMethodBeat.o(82703);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(82706);
      int i = this.fyl.size();
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
      d.g.b.k.h(paramViewGroup, "viewGroup");
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.context).inflate(2131494947, null, false);
        d.g.b.k.g(paramView, "convertView");
        paramViewGroup = new b(paramView);
        paramView.setTag(paramViewGroup);
      }
      final mm localmm;
      Object localObject2;
      Object localObject1;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      for (;;)
      {
        localmm = TU(paramInt);
        if (localmm == null) {
          break label1446;
        }
        d.g.b.k.h(localmm, "info");
        com.tencent.mm.aw.a.a.ayO().a(localmm.gGR, paramViewGroup.ikp, Bvt);
        localObject2 = paramViewGroup.BvD;
        localObject1 = paramViewGroup.BvG;
        d.g.b.k.h(localObject1, "itemView");
        if (localmm != null)
        {
          localObject3 = ((b)localObject2).context;
          localObject4 = (CharSequence)localmm.ocH;
          localObject5 = ((a)localObject1).mWl;
          d.g.b.k.g(localObject5, "itemView.nickName");
          localObject3 = com.tencent.mm.pluginsdk.ui.span.k.b((Context)localObject3, (CharSequence)localObject4, ((TextView)localObject5).getTextSize());
          localObject4 = ((a)localObject1).mWl;
          d.g.b.k.g(localObject4, "itemView.nickName");
          ((TextView)localObject4).setText((CharSequence)localObject3);
          localObject3 = ((b)localObject2).context;
          localObject4 = (CharSequence)localmm.content;
          localObject5 = ((a)localObject1).Bvv;
          d.g.b.k.g(localObject5, "itemView.desc");
          localObject3 = com.tencent.mm.pluginsdk.ui.span.k.b((Context)localObject3, (CharSequence)localObject4, ((NeatTextView)localObject5).getTextSize());
          ((a)localObject1).Bvv.aq((CharSequence)localObject3);
          ((a)localObject1).Bvw.setIconColor(((b)localObject2).context.getResources().getColor(2131099769));
          localObject3 = ((a)localObject1).Bvw;
          d.g.b.k.g(localObject3, "itemView.deleteIv");
          ((WeImageView)localObject3).setVisibility(0);
          localObject3 = ((a)localObject1).Bvx;
          d.g.b.k.g(localObject3, "itemView.deleteSplit");
          ((ImageView)localObject3).setVisibility(0);
          ((a)localObject1).Bvw.setOnClickListener((View.OnClickListener)new e((b)localObject2, localmm));
          ((b)localObject2).a((a)localObject1, localmm, null, false);
          localObject2 = ((a)localObject1).BvB;
          d.g.b.k.g(localObject2, "itemView.replyPrefix");
          ((ImageView)localObject2).setVisibility(8);
          localObject1 = ((a)localObject1).BvC;
          d.g.b.k.g(localObject1, "itemView.sameReplyPrefix");
          ((ImageView)localObject1).setVisibility(4);
        }
        localObject1 = paramViewGroup.BvH;
        d.g.b.k.g(localObject1, "txtReply");
        ((TextView)localObject1).setVisibility(8);
        if (!n.a(paramViewGroup.BvD.Bvr)) {
          break label1446;
        }
        localObject1 = paramViewGroup.BvH;
        d.g.b.k.g(localObject1, "txtReply");
        ((TextView)localObject1).setVisibility(0);
        paramViewGroup.BvH.setOnClickListener((View.OnClickListener)new n.b.b.a(paramViewGroup, localmm));
        localObject1 = ((Iterable)paramViewGroup.BvI).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (View)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            paramViewGroup.xvI.removeView((View)localObject2);
            paramViewGroup.BvD.Bvq.add(localObject2);
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
      paramViewGroup.BvI.clear();
      int i;
      if ((localmm.CJf != null) && (localmm.CJf.CZt != null) && (localmm.CJf.CZt.size() > 0))
      {
        localObject1 = localmm.CJf.CZt;
        d.g.b.k.g(localObject1, "replyList");
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
            j.fvx();
          }
          localObject3 = (xs)localObject1;
          localObject1 = paramViewGroup.BvD;
          label719:
          Context localContext;
          CharSequence localCharSequence;
          Object localObject6;
          if (((b)localObject1).Bvq.size() > 0)
          {
            localObject1 = ((b)localObject1).Bvq.remove(0);
            d.g.b.k.g(localObject1, "viewPool.removeAt(0)");
            localObject1 = (View)localObject1;
            paramViewGroup.BvI.add(localObject1);
            paramViewGroup.xvI.addView((View)localObject1);
            localObject4 = paramViewGroup.BvD;
            d.g.b.k.g(localObject3, "reply");
            localObject1 = new a(paramViewGroup.BvD, (View)localObject1);
            d.g.b.k.h(localObject3, "reply");
            d.g.b.k.h(localObject1, "itemView");
            if (localmm == null) {
              break label1509;
            }
            localObject5 = (d.g.a.b)new g((b)localObject4, (a)localObject1, localmm);
            if (d.g.b.k.g(localmm.CzP, ((xs)localObject3).CzP) != true) {
              break label1222;
            }
            if (!((Boolean)((d.g.a.b)localObject5).aA(Integer.valueOf(((xs)localObject3).CZs))).booleanValue())
            {
              localObject5 = ((a)localObject1).mWl;
              d.g.b.k.g(localObject5, "itemView.nickName");
              localContext = ((b)localObject4).context;
              localCharSequence = (CharSequence)localmm.ocH;
              localObject6 = ((a)localObject1).mWl;
              d.g.b.k.g(localObject6, "itemView.nickName");
              ((TextView)localObject5).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(localContext, localCharSequence, ((TextView)localObject6).getTextSize()));
              localObject5 = ((a)localObject1).Bvv;
              localContext = ((b)localObject4).context;
              localCharSequence = (CharSequence)((xs)localObject3).content;
              localObject6 = ((a)localObject1).Bvv;
              d.g.b.k.g(localObject6, "itemView.desc");
              ((NeatTextView)localObject5).aq((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(localContext, localCharSequence, ((NeatTextView)localObject6).getTextSize()));
              ((a)localObject1).Bvw.setIconColor(((b)localObject4).context.getResources().getColor(2131099769));
              localObject5 = ((a)localObject1).Bvw;
              d.g.b.k.g(localObject5, "itemView.deleteIv");
              ((WeImageView)localObject5).setVisibility(0);
              localObject5 = ((a)localObject1).Bvx;
              d.g.b.k.g(localObject5, "itemView.deleteSplit");
              ((ImageView)localObject5).setVisibility(0);
              ((b)localObject4).a((a)localObject1, localmm, (xs)localObject3, true);
              ((a)localObject1).Bvw.setOnClickListener((View.OnClickListener)new f((b)localObject4, localmm, (xs)localObject3));
            }
            label1073:
            localObject4 = ((a)localObject1).BvB;
            d.g.b.k.g(localObject4, "itemView.replyPrefix");
            ((ImageView)localObject4).setVisibility(0);
            localObject4 = ((a)localObject1).BvC;
            d.g.b.k.g(localObject4, "itemView.sameReplyPrefix");
            ((ImageView)localObject4).setVisibility(4);
            if (i + 1 < localmm.CJf.CZt.size())
            {
              localObject1 = ((a)localObject1).BvC;
              d.g.b.k.g(localObject1, "itemView.sameReplyPrefix");
              if (!d.g.b.k.g(((xs)localObject3).CzP, ((xs)localmm.CJf.CZt.get(i + 1)).CzP)) {
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
            d.g.b.k.g(localObject1, "View.inflate(context, R.…mment_content_item, null)");
            break label719;
            label1222:
            if (((Boolean)((d.g.a.b)localObject5).aA(Integer.valueOf(((xs)localObject3).CZs))).booleanValue()) {
              break label1073;
            }
            localObject5 = ((a)localObject1).mWl;
            d.g.b.k.g(localObject5, "itemView.nickName");
            localContext = ((b)localObject4).context;
            localCharSequence = (CharSequence)((b)localObject4).context.getResources().getString(2131761339);
            localObject6 = ((a)localObject1).mWl;
            d.g.b.k.g(localObject6, "itemView.nickName");
            ((TextView)localObject5).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(localContext, localCharSequence, ((TextView)localObject6).getTextSize()));
            localObject5 = ((a)localObject1).Bvv;
            localContext = ((b)localObject4).context;
            localCharSequence = (CharSequence)((xs)localObject3).content;
            localObject6 = ((a)localObject1).Bvv;
            d.g.b.k.g(localObject6, "itemView.desc");
            ((NeatTextView)localObject5).aq((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(localContext, localCharSequence, ((NeatTextView)localObject6).getTextSize()));
            localObject5 = ((a)localObject1).Bvw;
            d.g.b.k.g(localObject5, "itemView.deleteIv");
            ((WeImageView)localObject5).setVisibility(8);
            localObject5 = ((a)localObject1).Bvx;
            d.g.b.k.g(localObject5, "itemView.deleteSplit");
            ((ImageView)localObject5).setVisibility(8);
            ((b)localObject4).a((a)localObject1, localmm, (xs)localObject3, true);
            break label1073;
          }
        }
        else
        {
          label1446:
          if (paramInt == getCount() - 1)
          {
            paramViewGroup = paramViewGroup.BvF;
            d.g.b.k.g(paramViewGroup, "holder.endlineLayout");
            paramViewGroup.setVisibility(0);
            this.Bvr.getAppMsgCommentList();
          }
          for (;;)
          {
            AppMethodBeat.o(82707);
            return paramView;
            paramViewGroup = paramViewGroup.BvF;
            d.g.b.k.g(paramViewGroup, "holder.endlineLayout");
            paramViewGroup.setVisibility(8);
          }
        }
        label1509:
        i = j;
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;Landroid/view/View;)V", "deleteIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getDeleteIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setDeleteIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "deleteSplit", "Landroid/widget/ImageView;", "getDeleteSplit", "()Landroid/widget/ImageView;", "desc", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "getDesc", "()Lcom/tencent/neattextview/textview/view/NeatTextView;", "setDesc", "(Lcom/tencent/neattextview/textview/view/NeatTextView;)V", "likeThumb", "getLikeThumb", "likeTv", "Landroid/widget/TextView;", "getLikeTv", "()Landroid/widget/TextView;", "setLikeTv", "(Landroid/widget/TextView;)V", "nickName", "getNickName", "setNickName", "notChosen", "getNotChosen", "replyDelete", "getReplyDelete", "replyPrefix", "getReplyPrefix", "sameReplyPrefix", "getSameReplyPrefix", "plugin-webview_release"})
    public final class a
    {
      final TextView BvA;
      final ImageView BvB;
      final ImageView BvC;
      NeatTextView Bvv;
      WeImageView Bvw;
      final ImageView Bvx;
      final ImageView Bvy;
      final TextView Bvz;
      TextView mWl;
      TextView qWT;
      
      public a()
      {
        AppMethodBeat.i(82699);
        this.mWl = ((TextView)((View)localObject).findViewById(2131297382));
        this.qWT = ((TextView)((View)localObject).findViewById(2131297381));
        this.Bvv = ((NeatTextView)((View)localObject).findViewById(2131297378));
        this.Bvw = ((WeImageView)((View)localObject).findViewById(2131297379));
        this.Bvx = ((ImageView)((View)localObject).findViewById(2131297277));
        this.Bvy = ((ImageView)((View)localObject).findViewById(2131297279));
        this.Bvz = ((TextView)((View)localObject).findViewById(2131297282));
        this.BvA = ((TextView)((View)localObject).findViewById(2131297280));
        this.BvB = ((ImageView)((View)localObject).findViewById(2131297300));
        this.BvC = ((ImageView)((View)localObject).findViewById(2131297301));
        this$1 = ((View)localObject).getContext();
        Object localObject = this.Bvv;
        d.g.b.k.g(n.b.this, "context");
        ((NeatTextView)localObject).setTextColor(o.c(2130968850, n.b.this));
        AppMethodBeat.o(82699);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentViewHolder;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAvatar", "()Landroid/widget/ImageView;", "commentList", "Ljava/util/ArrayList;", "getCommentList", "()Ljava/util/ArrayList;", "content", "Landroid/widget/LinearLayout;", "getContent", "()Landroid/widget/LinearLayout;", "endlineLayout", "getEndlineLayout", "setEndlineLayout", "(Landroid/widget/LinearLayout;)V", "fansContent", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;", "getFansContent", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "setFansContent", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;)V", "fansLayout", "getFansLayout", "setFansLayout", "txtReply", "Landroid/widget/TextView;", "getTxtReply", "()Landroid/widget/TextView;", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "plugin-webview_release"})
    public final class b
    {
      private LinearLayout BvE;
      LinearLayout BvF;
      n.b.a BvG;
      final TextView BvH;
      final ArrayList<View> BvI;
      final ImageView ikp;
      final LinearLayout xvI;
      
      public b()
      {
        AppMethodBeat.i(82700);
        this.ikp = ((ImageView)localObject.findViewById(2131297374));
        this.xvI = ((LinearLayout)localObject.findViewById(2131297377));
        this.BvE = ((LinearLayout)localObject.findViewById(2131297389));
        this.BvF = ((LinearLayout)localObject.findViewById(2131299488));
        LinearLayout localLinearLayout = this.BvE;
        d.g.b.k.g(localLinearLayout, "fansLayout");
        this.BvG = new n.b.a(n.b.this, (View)localLinearLayout);
        this.BvH = ((TextView)localObject.findViewById(2131297281));
        this.BvI = new ArrayList();
        AppMethodBeat.o(82700);
      }
      
      @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
      static final class a
        implements View.OnClickListener
      {
        a(n.b.b paramb, mm parammm) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(175691);
          this.BvJ.BvD.Bvr.sw(3);
          this.BvJ.BvD.Bvr.u(n.b.a(this.BvK), this.BvK.CzO, true);
          AppMethodBeat.o(175691);
        }
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d
      implements View.OnClickListener
    {
      d(n.b paramb, boolean paramBoolean, xs paramxs, mm parammm, n.b.a parama) {}
      
      public final void onClick(View paramView)
      {
        Object localObject1 = null;
        AppMethodBeat.i(175692);
        n.b(this.BvD.Bvr).clearFocus();
        int i;
        if (paramBoolean)
        {
          paramView = paramxs;
          if (paramView != null)
          {
            paramView = Integer.valueOf(paramView.CZp);
            if (paramView == null) {
              d.g.b.k.fvU();
            }
            i = paramView.intValue();
            label57:
            if (!paramBoolean) {
              break label503;
            }
            paramView = paramxs;
            if (paramView == null) {
              break label498;
            }
            paramView = Integer.valueOf(paramView.CZq);
            label81:
            if (paramView != null) {
              break label517;
            }
            label85:
            parama.Bvy.setImageResource(2131689705);
            i -= 1;
            label101:
            if (i >= 0) {
              break label608;
            }
            i = 0;
          }
        }
        label146:
        label430:
        label562:
        label608:
        for (;;)
        {
          parama.qWT.setText((CharSequence)String.valueOf(i));
          Object localObject2 = parama.qWT;
          d.g.b.k.g(localObject2, "itemView.likeTv");
          int j;
          if (i > 0)
          {
            j = 0;
            ((TextView)localObject2).setVisibility(j);
            localObject2 = new fa();
            ((fa)localObject2).CzO = parammm.CzO;
            ((fa)localObject2).CzP = parammm.CzP;
            ((fa)localObject2).ntg = 1;
            if (paramBoolean)
            {
              localObject3 = paramxs;
              if (localObject3 != null) {
                localObject1 = Integer.valueOf(((xs)localObject3).CzR);
              }
              if (localObject1 == null) {
                d.g.b.k.fvU();
              }
              ((fa)localObject2).CzR = ((Integer)localObject1).intValue();
              ((fa)localObject2).ntg = 2;
            }
            if (paramView != null) {
              break label550;
            }
            label247:
            j = 0;
            label249:
            ((fa)localObject2).CzQ = j;
            localObject1 = this.BvD.Bvr;
            d.g.b.k.h(localObject2, "req");
            ((fa)localObject2).scene = ((n)localObject1).scene;
            ((fa)localObject2).CyR = ((n)localObject1).niJ;
            ((fa)localObject2).url = ((n)localObject1).url;
            ((fa)localObject2).CyP = ((n)localObject1).gGx;
            ((fa)localObject2).session_id = ((n)localObject1).niK;
            ((fa)localObject2).CyQ = ((n)localObject1).niH;
            Object localObject3 = new com.tencent.mm.al.b.a();
            ((com.tencent.mm.al.b.a)localObject3).c((com.tencent.mm.bx.a)localObject2);
            ((com.tencent.mm.al.b.a)localObject3).d((com.tencent.mm.bx.a)new fb());
            ((com.tencent.mm.al.b.a)localObject3).wg("/cgi-bin/mmbiz-bin/appmsg/appmsg_like_comment");
            ((com.tencent.mm.al.b.a)localObject3).nB(2759);
            ((com.tencent.mm.al.b.a)localObject3).nD(0);
            ((com.tencent.mm.al.b.a)localObject3).nE(0);
            IPCRunCgi.a(((com.tencent.mm.al.b.a)localObject3).atI(), (IPCRunCgi.a)new n.d((n)localObject1));
            if (paramView != null) {
              break label562;
            }
            paramView = Integer.valueOf(0);
          }
          for (;;)
          {
            if (paramBoolean)
            {
              localObject1 = paramxs;
              if (localObject1 != null) {
                ((xs)localObject1).CZq = paramView.intValue();
              }
              paramView = paramxs;
              if (paramView != null)
              {
                paramView.CZp = i;
                AppMethodBeat.o(175692);
                return;
                paramView = null;
                break;
                i = parammm.CIp;
                break label57;
                label498:
                paramView = null;
                break label81;
                label503:
                paramView = Integer.valueOf(parammm.CIq);
                break label81;
                if (paramView.intValue() != 0) {
                  break label85;
                }
                parama.Bvy.setImageResource(2131689706);
                i += 1;
                break label101;
                j = 8;
                break label146;
                if (paramView.intValue() != 0) {
                  break label247;
                }
                j = 1;
                break label249;
                if (paramView.intValue() != 0) {
                  break label430;
                }
                paramView = Integer.valueOf(1);
                continue;
              }
              AppMethodBeat.o(175692);
              return;
            }
          }
          parammm.CIq = paramView.intValue();
          parammm.CIp = i;
          AppMethodBeat.o(175692);
          return;
        }
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(n.b paramb, mm parammm) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(82702);
        new d.a(n.b.a(this.BvD)).aMf(n.b.a(this.BvD).getString(2131756650)).aMg("").aaD(n.b.a(this.BvD).getResources().getColor(2131099804)).aaB(2131755707).b((DialogInterface.OnClickListener)new a(this)).aaC(2131756755).fft().show();
        AppMethodBeat.o(82702);
      }
      
      @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
      static final class a
        implements DialogInterface.OnClickListener
      {
        a(n.b.e parame) {}
        
        public final void onClick(DialogInterface paramDialogInterface, int paramInt)
        {
          AppMethodBeat.i(82701);
          paramDialogInterface = new fe();
          paramDialogInterface.CzO = this.BvN.BvK.CzO;
          paramDialogInterface.ntg = 2;
          this.BvN.BvD.Bvr.a(paramDialogInterface);
          com.tencent.mm.plugin.webview.h.a.Tb(13);
          AppMethodBeat.o(82701);
        }
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f
      implements View.OnClickListener
    {
      f(n.b paramb, mm parammm, xs paramxs) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(175694);
        new d.a(n.b.a(this.BvD)).aMf(n.b.a(this.BvD).getString(2131756571)).aMg("").aaD(n.b.a(this.BvD).getResources().getColor(2131099804)).aaB(2131755707).b((DialogInterface.OnClickListener)new a(this)).aaC(2131756755).fft().show();
        AppMethodBeat.o(175694);
      }
      
      @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
      static final class a
        implements DialogInterface.OnClickListener
      {
        a(n.b.f paramf) {}
        
        public final void onClick(DialogInterface paramDialogInterface, int paramInt)
        {
          AppMethodBeat.i(175693);
          paramDialogInterface = new fe();
          paramDialogInterface.CzO = this.BvO.BvK.CzO;
          paramDialogInterface.CzR = this.BvO.BvL.CzR;
          paramDialogInterface.ntg = 4;
          this.BvO.BvD.Bvr.a(paramDialogInterface);
          com.tencent.mm.plugin.webview.h.a.Tb(13);
          AppMethodBeat.o(175693);
        }
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<no name provided>", "", "delFlag", "", "invoke"})
    static final class g
      extends d.g.b.l
      implements d.g.a.b<Integer, Boolean>
    {
      g(n.b paramb, n.b.a parama, mm parammm)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "", "onHide", "", "onShow", "plugin-webview_release"})
  public static abstract interface c
  {
    public abstract void onHide();
    
    public abstract void onShow();
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class d
    implements IPCRunCgi.a
  {
    d(n paramn) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.al.b paramb)
    {
      AppMethodBeat.i(175699);
      aq.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(175698);
          Object localObject = p.Bwh;
          p.b(this.BvP.Bvo.getWebView().eoo());
          if (this.BvP.Bvo.getWeakThis$plugin_webview_release().get() != null)
          {
            localObject = this.BvP.Bvo.getWeakThis$plugin_webview_release().get();
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
            com.tencent.mm.al.b localb = paramb;
            d.g.b.k.g(localb, "rr");
            n.b((n)localObject, i, j, str, localb);
          }
          AppMethodBeat.o(175698);
        }
      });
      AppMethodBeat.o(175699);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class e
    implements IPCRunCgi.a
  {
    e(n paramn) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.al.b paramb)
    {
      AppMethodBeat.i(82711);
      aq.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(82710);
          Object localObject = p.Bwh;
          p.b(this.BvQ.Bvo.getWebView().eoo());
          if (this.BvQ.Bvo.getWeakThis$plugin_webview_release().get() != null)
          {
            localObject = this.BvQ.Bvo.getWeakThis$plugin_webview_release().get();
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
            com.tencent.mm.al.b localb = paramb;
            d.g.b.k.g(localb, "rr");
            n.a((n)localObject, i, j, str, localb);
          }
          AppMethodBeat.o(82710);
        }
      });
      AppMethodBeat.o(82711);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class f
    implements IPCRunCgi.a
  {
    f(n paramn) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.al.b paramb)
    {
      AppMethodBeat.i(82713);
      n.f(this.Bvo);
      aq.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(82712);
          Object localObject = p.Bwh;
          p.b(this.BvR.Bvo.getWebView().eoo());
          if (this.BvR.Bvo.getWeakThis$plugin_webview_release().get() != null)
          {
            localObject = this.BvR.Bvo.getWeakThis$plugin_webview_release().get();
            if (localObject == null)
            {
              localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout");
              AppMethodBeat.o(82712);
              throw ((Throwable)localObject);
            }
            localObject = (n)localObject;
            com.tencent.mm.al.b localb = paramb;
            d.g.b.k.g(localb, "rr");
            n.a((n)localObject, localb);
          }
          AppMethodBeat.o(82712);
        }
      });
      if (paramInt1 == 2)
      {
        com.tencent.mm.plugin.webview.h.a.Tb(8);
        AppMethodBeat.o(82713);
        return;
      }
      if (paramInt1 != 0) {
        com.tencent.mm.plugin.webview.h.a.Tb(9);
      }
      AppMethodBeat.o(82713);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$hideAnimation$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "ani", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"})
  public static final class g
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(82714);
      d.g.b.k.h(paramAnimation, "ani");
      paramAnimation = this.Bvo.getWeakThis$plugin_webview_release().get();
      if (paramAnimation == null)
      {
        paramAnimation = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout");
        AppMethodBeat.o(82714);
        throw paramAnimation;
      }
      ((n)paramAnimation).setVisibility(8);
      n.e(this.Bvo).clearAnimation();
      AppMethodBeat.o(82714);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation) {}
    
    public final void onAnimationStart(Animation paramAnimation) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "state", "", "onKeyBoardStateChange"})
  static final class h
    implements KeyboardLinearLayout.a
  {
    h(n paramn) {}
    
    public final void DK(int paramInt)
    {
      AppMethodBeat.i(82717);
      n.a locala = n.Bvn;
      ad.i(n.access$getTAG$cp(), "onKeyBoardStateChange, state = ".concat(String.valueOf(paramInt)));
      if (paramInt == -3)
      {
        int i = n.c(this.Bvo).getKeyBoardHeight();
        if (i > 0)
        {
          n.a(this.Bvo, i);
          n.a(this.Bvo, i);
        }
        new com.tencent.mm.sdk.platformtools.ap().postDelayed((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(82715);
            n.d(this.BvS.Bvo).dCJ();
            n.d(this.BvS.Bvo).postInvalidate();
            n.e(this.BvS.Bvo).postInvalidate();
            AppMethodBeat.o(82715);
          }
        }, 10L);
      }
      for (;;)
      {
        n.b(this.Bvo, paramInt);
        AppMethodBeat.o(82717);
        return;
        n.a(this.Bvo, 0);
        n.a(this.Bvo, 0);
        new com.tencent.mm.sdk.platformtools.ap().postDelayed((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(82716);
            n.d(this.BvS.Bvo).eri();
            n.d(this.BvS.Bvo).postInvalidate();
            n.e(this.BvS.Bvo).postInvalidate();
            AppMethodBeat.o(82716);
          }
        }, 10L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.n
 * JD-Core Version:    0.7.0.1
 */
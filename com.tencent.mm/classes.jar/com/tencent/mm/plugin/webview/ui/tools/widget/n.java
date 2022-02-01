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
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.aaj;
import com.tencent.mm.protocal.protobuf.aak;
import com.tencent.mm.protocal.protobuf.ey;
import com.tencent.mm.protocal.protobuf.ez;
import com.tencent.mm.protocal.protobuf.fh;
import com.tencent.mm.protocal.protobuf.fi;
import com.tencent.mm.protocal.protobuf.fl;
import com.tencent.mm.protocal.protobuf.fm;
import com.tencent.mm.protocal.protobuf.nk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.ar;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewKeyboardLinearLayout;", "webView", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "isDark", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;ZLandroid/content/Context;Landroid/util/AttributeSet;)V", "actionView", "Landroid/view/View;", "adapter", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;", "callback", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "getCallback", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "setCallback", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;)V", "cancelTv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "commentTopicId", "", "getCommentTopicId", "()J", "setCommentTopicId", "(J)V", "commitBt", "Landroid/widget/Button;", "contentEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "currentKbState", "", "enterId", "getEnterId", "()I", "setEnterId", "(I)V", "hasReadOpenCfg", "isDoingGetMyComment", "isHaokan", "isReplyOpen", "itemShowType", "getItemShowType", "setItemShowType", "kbLayout", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "minHeaderHeight", "getMinHeaderHeight", "setMinHeaderHeight", "myCommentOffset", "getMyCommentOffset", "setMyCommentOffset", "myCommentTitleTv", "Landroid/widget/TextView;", "myCommentTv", "myCommentView", "recyclerView", "Landroid/widget/ListView;", "replyPersonalCommentId", "replyTip", "root", "savePortHeight", "sayFooter", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter;", "getSayFooter", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter;", "sayFooter$delegate", "Lkotlin/Lazy;", "scene", "getScene", "setScene", "subScene", "getSubScene", "setSubScene", "timeLineSessionId", "getTimeLineSessionId", "setTimeLineSessionId", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "weakThis", "Ljava/lang/ref/WeakReference;", "getWeakThis$plugin_webview_release", "()Ljava/lang/ref/WeakReference;", "setWeakThis$plugin_webview_release", "(Ljava/lang/ref/WeakReference;)V", "getWebView", "()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "caculateHeight", "", "newMarginBottom", "checkHeight", "h", "clearPersonalComment", "refreshHeight", "closeComment", "contentEtOnClick", "dealOrientaion", "orientation", "doAppMsgLikeComment", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgLikeCommentReq;", "doAppMsgOperateComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "doReport", "actionType", "fixKeyBoardMargin", "getAppMsgCommentList", "getNavHeightByDisplay", "getReplyHeight", "getRootHeight", "hide", "hideAnimation", "initKeyboardListener", "isShow", "onAddCommentSuccess", "onAppMsgLikeComment", "errType", "errCode", "errMsg", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "onAppMsgOperateComment", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDeleteComment", "onDeleteCommentReply", "onDestroy", "onGetCommentList", "onKeyBackPress", "onNoComment", "onResume", "onTouchClose", "replyToPersonalComment", "replyContent", "personalCommentId", "saveRootHeight", "height", "setData", "setRootHeight", "show", "showAnimation", "showCommentView", "showLayout", "showLayoutReply", "updateData", "resp", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommentListResp;", "clearUpdate", "updateUrl", "curUrl", "Companion", "MPMyCommentItemAdapter", "MPWriteCommentLayoutCallback", "plugin-webview_release"})
public final class n
  extends WebViewKeyboardLinearLayout
{
  public static final n.a Erw;
  private static final String TAG = "MicroMsg.MPWriteCommentLayout";
  private final WebViewKeyboardLinearLayout EcH;
  public int Eex;
  private final d.f Erb;
  private final WeImageView Erc;
  private final Button Erd;
  public final MMEditText Ere;
  private final ListView Erf;
  private final View Erg;
  private final TextView Erh;
  private final TextView Eri;
  private final TextView Erj;
  private b Erk;
  private boolean Erl;
  private int Erm;
  private int Ern;
  private int Ero;
  private long Erp;
  private c Erq;
  private boolean Err;
  private int Ers;
  private boolean Ert;
  private boolean Eru;
  public final WebViewUI Erv;
  private final boolean dGW;
  private final View fOB;
  int hzh;
  private final View jbX;
  private WeakReference<n> nOh;
  int oog;
  int ooi;
  int ooj;
  int scene;
  private String title;
  String url;
  
  static
  {
    AppMethodBeat.i(82720);
    Erw = new n.a((byte)0);
    TAG = "MicroMsg.MPWriteCommentLayout";
    AppMethodBeat.o(82720);
  }
  
  public n(WebViewUI paramWebViewUI, Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(175710);
    this.Erv = paramWebViewUI;
    this.dGW = false;
    paramWebViewUI = View.inflate(paramContext, 2131494959, (ViewGroup)this);
    if (paramWebViewUI == null)
    {
      paramWebViewUI = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout");
      AppMethodBeat.o(175710);
      throw paramWebViewUI;
    }
    this.EcH = ((WebViewKeyboardLinearLayout)paramWebViewUI);
    paramWebViewUI = findViewById(2131302501);
    d.g.b.p.g(paramWebViewUI, "findViewById(R.id.mp_video_comment_action_layout)");
    this.jbX = paramWebViewUI;
    this.Erb = d.g.O((d.g.a.a)new n.j(this));
    paramWebViewUI = findViewById(2131302502);
    d.g.b.p.g(paramWebViewUI, "findViewById(R.id.mp_video_comment_cancel)");
    this.Erc = ((WeImageView)paramWebViewUI);
    paramWebViewUI = findViewById(2131302504);
    d.g.b.p.g(paramWebViewUI, "findViewById(R.id.mp_video_comment_ok)");
    this.Erd = ((Button)paramWebViewUI);
    paramWebViewUI = findViewById(2131302503);
    d.g.b.p.g(paramWebViewUI, "findViewById(R.id.mp_video_comment_et)");
    this.Ere = ((MMEditText)paramWebViewUI);
    paramWebViewUI = findViewById(2131297394);
    d.g.b.p.g(paramWebViewUI, "findViewById(R.id.biz_video_my_comment_list)");
    this.Erf = ((ListView)paramWebViewUI);
    paramWebViewUI = findViewById(2131302518);
    d.g.b.p.g(paramWebViewUI, "findViewById(R.id.mp_write_comment_root)");
    this.fOB = paramWebViewUI;
    paramWebViewUI = findViewById(2131302517);
    d.g.b.p.g(paramWebViewUI, "findViewById(R.id.mp_vid…rite_comment_scroll_view)");
    this.Erg = paramWebViewUI;
    paramWebViewUI = findViewById(2131297395);
    d.g.b.p.g(paramWebViewUI, "findViewById(R.id.biz_video_my_comment_tv)");
    this.Erh = ((TextView)paramWebViewUI);
    paramWebViewUI = findViewById(2131302507);
    d.g.b.p.g(paramWebViewUI, "findViewById(R.id.mp_video_my_comment_title)");
    this.Eri = ((TextView)paramWebViewUI);
    paramWebViewUI = findViewById(2131297401);
    d.g.b.p.g(paramWebViewUI, "findViewById(R.id.biz_video_reply_tip)");
    this.Erj = ((TextView)paramWebViewUI);
    this.Eex = -1;
    this.url = "";
    this.title = "";
    this.nOh = new WeakReference(this);
    getSayFooter().setMMEditText(this.Ere);
    getSayFooter().setVisibility(8);
    this.Ere.setOnClickListener((View.OnClickListener)new n.1(this));
    this.Ere.setOnLongClickListener((View.OnLongClickListener)new n.2(this));
    this.EcH.setOnTouchListener((View.OnTouchListener)new n.3(this));
    this.fOB.setOnClickListener((View.OnClickListener)n.4.Ery);
    int i = getRootHeight();
    if (i > 0)
    {
      paramWebViewUI = this.fOB.getLayoutParams();
      if (paramWebViewUI == null)
      {
        paramWebViewUI = new v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        AppMethodBeat.o(175710);
        throw paramWebViewUI;
      }
      paramWebViewUI.height = i;
      this.fOB.setLayoutParams(paramWebViewUI);
    }
    if (!z.iK(paramContext)) {
      XP(2);
    }
    this.Erc.setOnClickListener((View.OnClickListener)new n.5(this));
    this.Erd.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82697);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if (n.j(this.Erx))
        {
          paramAnonymousView = n.b(this.Erx).getText().toString();
          localObject = this.Erx.getWebView().DzP;
          if (localObject != null) {
            ((com.tencent.mm.plugin.webview.c.f)localObject).u(1, paramAnonymousView, 1);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(82697);
          return;
          this.Erx.getWebView().hideVKB();
          if (n.d(this.Erx).edz()) {
            n.d(this.Erx).edA();
          }
          paramAnonymousView = new fl();
          paramAnonymousView.content = n.b(this.Erx).getText().toString();
          paramAnonymousView.ozA = 1;
          if (n.k(this.Erx) != 0)
          {
            paramAnonymousView.ozA = 3;
            paramAnonymousView.FxD = n.k(this.Erx);
          }
          this.Erx.a(paramAnonymousView);
          com.tencent.mm.plugin.webview.h.a.WZ(10);
        }
      }
    });
    this.Ere.addTextChangedListener((TextWatcher)new n.7(this));
    paramWebViewUI = this.Erd;
    paramContext = this.Ere.getText();
    d.g.b.p.g(paramContext, "contentEt.text");
    if (((CharSequence)paramContext).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramWebViewUI.setEnabled(bool);
      this.Ere.setOnTouchListener((View.OnTouchListener)new n.8(this));
      this.Erj.setVisibility(8);
      AppMethodBeat.o(175710);
      return;
    }
  }
  
  private final void XP(int paramInt)
  {
    AppMethodBeat.i(82729);
    switch (paramInt)
    {
    default: 
      if (this.EcH.eRY()) {
        XQ(this.EcH.getKeyBoardHeight());
      }
      break;
    }
    for (;;)
    {
      this.Ere.setMinLines(5);
      AppMethodBeat.o(82729);
      return;
      paramInt = ar.jG(getContext());
      setRootHeight(ar.ci(getContext()).y - paramInt);
      this.Ere.setMinLines(3);
      AppMethodBeat.o(82729);
      return;
      if (this.Erm != 0) {
        setRootHeight(this.Erm);
      } else {
        XQ(0);
      }
    }
  }
  
  private final void XQ(int paramInt)
  {
    AppMethodBeat.i(82730);
    Object localObject = this.fOB.getLayoutParams();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(82730);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.LayoutParams)localObject).height = (this.Ere.getHeight() + this.jbX.getHeight() + getNavHeightByDisplay() + com.tencent.mm.cc.a.fromDPToPix(getContext(), com.tencent.mm.cc.a.aA(getContext(), 60) + 16) + getReplyHeight() + paramInt);
    ((ViewGroup.LayoutParams)localObject).height = XR(((ViewGroup.LayoutParams)localObject).height);
    this.fOB.setLayoutParams((ViewGroup.LayoutParams)localObject);
    XS(((ViewGroup.LayoutParams)localObject).height);
    AppMethodBeat.o(82730);
  }
  
  private final int XR(int paramInt)
  {
    AppMethodBeat.i(82732);
    int j = ar.jG(getContext());
    int k = ar.ci(getContext()).y;
    int i = k - j;
    if (paramInt > i) {}
    for (;;)
    {
      AppMethodBeat.o(82732);
      return i;
      i = paramInt;
      if (this.Ero > 0)
      {
        int m = com.tencent.mm.cc.a.fromDPToPix(getContext(), 20);
        i = paramInt;
        if (paramInt < k - this.Ero - j + m) {
          i = k - j - this.Ero + m;
        }
      }
    }
  }
  
  private final void XS(int paramInt)
  {
    AppMethodBeat.i(82733);
    if (z.iK(getContext())) {
      this.Erm = paramInt;
    }
    ax localax = ax.aQA("MPWriteCommentLayout");
    localax.encode("MPWriteCommentRootHeight", paramInt);
    localax.apply();
    AppMethodBeat.o(82733);
  }
  
  private final void eVE()
  {
    AppMethodBeat.i(82723);
    View localView = this.Erg;
    Context localContext = getContext();
    d.g.b.p.g(localContext, "context");
    localView.setBackgroundColor(o.c(2130968842, localContext));
    this.Erh.setVisibility(8);
    AppMethodBeat.o(82723);
  }
  
  private void eVG()
  {
    AppMethodBeat.i(175703);
    this.Ere.setText((CharSequence)"");
    this.Ers = 0;
    getAppMsgCommentList();
    AppMethodBeat.o(175703);
  }
  
  private final void eVH()
  {
    AppMethodBeat.i(182680);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(250L);
    localTranslateAnimation.setFillAfter(false);
    this.fOB.clearAnimation();
    this.fOB.startAnimation((Animation)localTranslateAnimation);
    AppMethodBeat.o(182680);
  }
  
  private final void eVI()
  {
    AppMethodBeat.i(82737);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    localTranslateAnimation.setDuration(150L);
    localTranslateAnimation.setFillAfter(false);
    localTranslateAnimation.setAnimationListener((Animation.AnimationListener)new g(this));
    this.fOB.clearAnimation();
    this.fOB.startAnimation((Animation)localTranslateAnimation);
    AppMethodBeat.o(82737);
  }
  
  private final int getNavHeightByDisplay()
  {
    AppMethodBeat.i(82739);
    Point localPoint = ar.ci(getContext());
    Object localObject = this.Erv.getWindow();
    if (localObject != null) {}
    for (localObject = ((Window)localObject).getDecorView();; localObject = null)
    {
      Rect localRect = new Rect();
      if (localObject != null) {
        ((View)localObject).getWindowVisibleDisplayFrame(localRect);
      }
      int i = localRect.bottom;
      int j = localPoint.y - i - this.EcH.getKeyBoardHeight();
      ad.v(TAG, "getNavHeightByDisplay screenHeight = " + i + ", realSize = " + localPoint.y);
      i = j;
      if (j < 0)
      {
        i = ar.ej(getContext());
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
    if (this.Ern != 0)
    {
      int i = com.tencent.mm.cc.a.fromDPToPix(getContext(), 38);
      AppMethodBeat.o(182681);
      return i;
    }
    AppMethodBeat.o(182681);
    return 0;
  }
  
  private final int getRootHeight()
  {
    AppMethodBeat.i(82734);
    int i = com.tencent.mm.cc.a.fromDPToPix(getContext(), 635);
    AppMethodBeat.o(82734);
    return i;
  }
  
  private final void setRootHeight(int paramInt)
  {
    AppMethodBeat.i(82731);
    Object localObject = this.fOB.getLayoutParams();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(82731);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.LayoutParams)localObject).height = XR(paramInt);
    this.fOB.setLayoutParams((ViewGroup.LayoutParams)localObject);
    XS(((ViewGroup.LayoutParams)localObject).height);
    AppMethodBeat.o(82731);
  }
  
  private final void show()
  {
    AppMethodBeat.i(82735);
    this.fOB.clearAnimation();
    setVisibility(0);
    eVH();
    c localc = this.Erq;
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
    this.ooi = paramInt2;
    this.hzh = paramInt3;
    this.oog = paramInt4;
    this.url = paramString1;
    this.title = paramString2;
  }
  
  public final void a(fl paramfl)
  {
    AppMethodBeat.i(82741);
    d.g.b.p.h(paramfl, "req");
    paramfl.scene = this.scene;
    paramfl.FwF = this.ooi;
    paramfl.url = this.url;
    paramfl.title = this.title;
    paramfl.FxJ = System.currentTimeMillis();
    paramfl.FwD = this.hzh;
    paramfl.session_id = this.ooj;
    paramfl.FwE = this.oog;
    paramfl.FwG = this.Erp;
    Object localObject = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject).c((com.tencent.mm.bx.a)paramfl);
    ((com.tencent.mm.al.b.a)localObject).d((com.tencent.mm.bx.a)new fm());
    ((com.tencent.mm.al.b.a)localObject).Dl("/cgi-bin/mmbiz-bin/appmsg/appmsg_operate_comment");
    ((com.tencent.mm.al.b.a)localObject).oP(2617);
    ((com.tencent.mm.al.b.a)localObject).oR(0);
    ((com.tencent.mm.al.b.a)localObject).oS(0);
    IPCRunCgi.a(((com.tencent.mm.al.b.a)localObject).aDC(), (IPCRunCgi.a)new e(this));
    paramfl = this.Erv;
    localObject = p.Esp;
    localObject = getContext().getString(2131755936);
    d.g.b.p.g(localObject, "context.getString(R.string.app_waiting)");
    Context localContext = getContext();
    d.g.b.p.g(localContext, "context");
    paramfl.a(p.a((String)localObject, localContext, this.Erv.eSB()));
    AppMethodBeat.o(82741);
  }
  
  public final void aJB(String paramString)
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
  
  public final boolean bni()
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
  
  public final void eVF()
  {
    AppMethodBeat.i(82724);
    this.EcH.setOnkbdStateListener((KeyboardLinearLayout.a)new h(this));
    AppMethodBeat.o(82724);
  }
  
  public final boolean eVJ()
  {
    AppMethodBeat.i(175708);
    if (!this.Ert) {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.quy, 0) != 1) {
        break label86;
      }
    }
    label86:
    for (boolean bool = true;; bool = false)
    {
      this.Eru = bool;
      this.Ert = true;
      ad.v(TAG, "isReplyOpen = " + this.Eru);
      bool = this.Eru;
      AppMethodBeat.o(175708);
      return bool;
    }
  }
  
  public final void getAppMsgCommentList()
  {
    AppMethodBeat.i(82740);
    ey localey = new ey();
    localey.url = this.url;
    if (this.Err)
    {
      AppMethodBeat.o(82740);
      return;
    }
    localey.offset = this.Ers;
    if (this.Ers == -1)
    {
      ad.i(TAG, "no more my comment");
      AppMethodBeat.o(82740);
      return;
    }
    this.Err = true;
    localey.ozA = 2;
    localey.scene = this.scene;
    localey.FwF = this.ooi;
    localey.FwD = this.hzh;
    localey.session_id = this.ooj;
    localey.FwE = this.oog;
    localey.FwG = this.Erp;
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    locala.c((com.tencent.mm.bx.a)localey);
    locala.d((com.tencent.mm.bx.a)new ez());
    locala.Dl("/cgi-bin/mmbiz-bin/appmsg/appmsg_comment_list");
    locala.oP(2866);
    locala.oR(0);
    locala.oS(0);
    IPCRunCgi.a(locala.aDC(), (IPCRunCgi.a)new f(this));
    com.tencent.mm.plugin.webview.h.a.WZ(7);
    AppMethodBeat.o(82740);
  }
  
  public final c getCallback()
  {
    return this.Erq;
  }
  
  public final long getCommentTopicId()
  {
    return this.Erp;
  }
  
  public final int getEnterId()
  {
    return this.oog;
  }
  
  public final int getItemShowType()
  {
    return this.hzh;
  }
  
  public final int getMinHeaderHeight()
  {
    return this.Ero;
  }
  
  public final int getMyCommentOffset()
  {
    return this.Ers;
  }
  
  public final MPSmileyFooter getSayFooter()
  {
    AppMethodBeat.i(82721);
    MPSmileyFooter localMPSmileyFooter = (MPSmileyFooter)this.Erb.getValue();
    AppMethodBeat.o(82721);
    return localMPSmileyFooter;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final int getSubScene()
  {
    return this.ooi;
  }
  
  public final int getTimeLineSessionId()
  {
    return this.ooj;
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
    return this.nOh;
  }
  
  public final WebViewUI getWebView()
  {
    return this.Erv;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(82736);
    if (!bni())
    {
      AppMethodBeat.o(82736);
      return;
    }
    if (getSayFooter().edz()) {
      getSayFooter().edA();
    }
    eVI();
    this.Erv.hideVKB();
    this.Ers = 0;
    Object localObject = this.Erk;
    if (localObject != null) {
      ((b)localObject).clear();
    }
    localObject = this.Erq;
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
    XP(paramConfiguration.orientation);
    if (getSayFooter().edz()) {
      getSayFooter().edA();
    }
    AppMethodBeat.o(82728);
  }
  
  public final void setCallback(c paramc)
  {
    this.Erq = paramc;
  }
  
  public final void setCommentTopicId(long paramLong)
  {
    this.Erp = paramLong;
  }
  
  public final void setEnterId(int paramInt)
  {
    this.oog = paramInt;
  }
  
  public final void setItemShowType(int paramInt)
  {
    this.hzh = paramInt;
  }
  
  public final void setMinHeaderHeight(int paramInt)
  {
    this.Ero = paramInt;
  }
  
  public final void setMyCommentOffset(int paramInt)
  {
    this.Ers = paramInt;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public final void setSubScene(int paramInt)
  {
    this.ooi = paramInt;
  }
  
  public final void setTimeLineSessionId(int paramInt)
  {
    this.ooj = paramInt;
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
    this.nOh = paramWeakReference;
    AppMethodBeat.o(82722);
  }
  
  public final void tQ(int paramInt)
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
    com.tencent.mm.plugin.report.service.g.yhR.kvStat(19265, str1);
    AppMethodBeat.o(175709);
  }
  
  public final void u(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(175705);
    d.g.b.p.h(paramString, "replyContent");
    this.Ern = paramInt;
    this.Eri.setText((CharSequence)getContext().getString(2131756575));
    this.Erj.setVisibility(0);
    TextView localTextView = this.Erj;
    Context localContext = getContext();
    String str = paramString;
    if (bt.isNullOrNil(paramString)) {
      str = "";
    }
    localTextView.setText((CharSequence)localContext.getString(2131756574, new Object[] { str }));
    this.Ere.setHint((CharSequence)getContext().getString(2131756573));
    if (paramBoolean)
    {
      this.Erg.scrollTo(0, 0);
      this.Ere.requestFocus();
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
        paramString.showSoftInput((View)this.Ere, 0);
        AppMethodBeat.o(175705);
        return;
      }
    }
    AppMethodBeat.o(175705);
  }
  
  public final void vr(boolean paramBoolean)
  {
    AppMethodBeat.i(82725);
    tQ(1);
    vt(false);
    vs(paramBoolean);
    AppMethodBeat.o(82725);
  }
  
  public final void vs(boolean paramBoolean)
  {
    AppMethodBeat.i(175702);
    this.Erl = paramBoolean;
    show();
    if (paramBoolean)
    {
      this.Erh.setVisibility(8);
      this.Eri.setText((CharSequence)getContext().getString(2131756657));
      this.Ere.setHint(2131756659);
      this.Erd.setText(2131755884);
      localObject = this.Erd;
      localContext = getContext();
      d.g.b.p.g(localContext, "context");
      ((Button)localObject).setBackground(localContext.getResources().getDrawable(2131231294));
      localObject = (InputFilter)new InputFilter.LengthFilter(200);
      this.Ere.setFilters(new InputFilter[] { localObject });
      AppMethodBeat.o(175702);
      return;
    }
    getAppMsgCommentList();
    this.Erd.setText(2131756649);
    Object localObject = this.Erd;
    Context localContext = getContext();
    d.g.b.p.g(localContext, "context");
    ((Button)localObject).setBackground(o.ha(localContext));
    AppMethodBeat.o(175702);
  }
  
  public final void vt(boolean paramBoolean)
  {
    AppMethodBeat.i(175707);
    if (this.Ern != 0)
    {
      this.Ern = 0;
      if (paramBoolean) {
        XP(z.iL(getContext()));
      }
    }
    this.Erj.setText((CharSequence)"");
    this.Erj.setVisibility(8);
    this.Ere.setHint((CharSequence)getContext().getString(2131756669));
    this.Eri.setText((CharSequence)getContext().getString(2131756667));
    AppMethodBeat.o(175707);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "controller", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "isDarkPanel", "", "(Landroid/content/Context;Ljava/util/LinkedList;Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;Z)V", "getController", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "setController", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;)V", "viewPool", "Ljava/util/ArrayList;", "Landroid/view/View;", "getViewPool", "()Ljava/util/ArrayList;", "clear", "", "getCommentView", "getCount", "", "getItem", "position", "getItemId", "", "i", "getLastInvalidReply", "", "info", "getView", "convertView", "viewGroup", "Landroid/view/ViewGroup;", "onDeleteComment", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "onDeleteCommentReply", "showLikeStatus", "itemView", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "reply", "Lcom/tencent/mm/protocal/protobuf/CommentReply;", "isReply", "update", "items", "", "clearUpdate", "updateCommentContentView", "updateReplyView", "index", "BizCommentContent", "BizCommentViewHolder", "Companion", "plugin-webview_release"})
  public static final class b
    extends BaseAdapter
  {
    private static com.tencent.mm.aw.a.a.c ErC;
    public static final n.b.c ErD;
    static final String TAG = "MicroMsg.MPMyCommentItemAdapter";
    n ErA;
    private boolean ErB;
    final ArrayList<View> Erz;
    private final Context context;
    final LinkedList<nk> fVg;
    
    static
    {
      AppMethodBeat.i(82709);
      ErD = new n.b.c((byte)0);
      TAG = "MicroMsg.MPMyCommentItemAdapter";
      ErC = new c.a().pI(2131100141).aIY().dh(120, 120).a((com.tencent.mm.aw.a.c.c)new com.tencent.mm.pluginsdk.ui.applet.n()).a((com.tencent.mm.aw.a.c.a)new e()).aJa().an(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 3)).aJc();
      AppMethodBeat.o(82709);
    }
    
    public b(Context paramContext, LinkedList<nk> paramLinkedList, n paramn, boolean paramBoolean)
    {
      AppMethodBeat.i(162324);
      this.context = paramContext;
      this.fVg = paramLinkedList;
      this.ErA = paramn;
      this.ErB = paramBoolean;
      this.Erz = new ArrayList();
      AppMethodBeat.o(162324);
    }
    
    private nk XT(int paramInt)
    {
      AppMethodBeat.i(82704);
      nk localnk = (nk)j.E((List)this.fVg, paramInt);
      AppMethodBeat.o(82704);
      return localnk;
    }
    
    public static String a(nk paramnk)
    {
      AppMethodBeat.i(182678);
      d.g.b.p.h(paramnk, "info");
      String str = paramnk.content;
      int i;
      if ((paramnk.FHt != null) && (!bt.hj((List)paramnk.FHt.FZp)))
      {
        i = paramnk.FHt.FZp.size() - 1;
        if (i >= 0) {
          if (((aaj)paramnk.FHt.FZp.get(i)).FZo != 0) {}
        }
      }
      for (paramnk = ((aaj)paramnk.FHt.FZp.get(i)).content;; paramnk = str)
      {
        d.g.b.p.g(paramnk, "reply");
        AppMethodBeat.o(182678);
        return paramnk;
        i -= 1;
        break;
      }
    }
    
    private void a(final a parama, final nk paramnk, final aaj paramaaj, final boolean paramBoolean)
    {
      AppMethodBeat.i(175697);
      d.g.b.p.h(parama, "itemView");
      d.g.b.p.h(paramnk, "info");
      Object localObject;
      Integer localInteger1;
      label55:
      Integer localInteger2;
      label73:
      String str1;
      label105:
      int i;
      if (paramBoolean) {
        if (paramaaj != null)
        {
          localObject = Integer.valueOf(paramaaj.FZn);
          if (!paramBoolean) {
            break label352;
          }
          if (paramaaj == null) {
            break label346;
          }
          localInteger1 = Integer.valueOf(paramaaj.FZl);
          if (!paramBoolean) {
            break label370;
          }
          if (paramaaj == null) {
            break label364;
          }
          localInteger2 = Integer.valueOf(paramaaj.FZm);
          String str2 = TAG;
          StringBuilder localStringBuilder = new StringBuilder("showLikeStatus content = ");
          if (!paramBoolean) {
            break label388;
          }
          if (paramaaj == null) {
            break label382;
          }
          str1 = paramaaj.content;
          ad.v(str2, str1 + ", isElected = " + localObject + ", likeNum = " + localInteger1 + ", likeStatus = " + localInteger2);
          parama.ErH.setOnClickListener(null);
          if (localObject != null) {
            break label397;
          }
          label166:
          localObject = parama.ErJ;
          d.g.b.p.g(localObject, "itemView.notChosen");
          ((TextView)localObject).setVisibility(8);
          localObject = parama.ErH;
          d.g.b.p.g(localObject, "itemView.likeThumb");
          ((ImageView)localObject).setVisibility(0);
          localObject = parama.gUd;
          d.g.b.p.g(localObject, "itemView.likeTv");
          ((TextView)localObject).setVisibility(8);
          if (localInteger1 != null)
          {
            localObject = parama.gUd;
            d.g.b.p.g(localObject, "itemView.likeTv");
            if (localInteger1.intValue() <= 0) {
              break label465;
            }
            i = 0;
            label258:
            ((TextView)localObject).setVisibility(i);
            parama.gUd.setText((CharSequence)String.valueOf(localInteger1.intValue()));
          }
          if (localInteger2 != null) {
            break label472;
          }
          label288:
          parama.ErH.setImageResource(2131689706);
        }
      }
      for (;;)
      {
        parama.ErH.setOnClickListener((View.OnClickListener)new d(this, paramBoolean, paramaaj, paramnk, parama));
        AppMethodBeat.o(175697);
        return;
        localObject = null;
        break;
        localObject = Integer.valueOf(paramnk.FHs);
        break;
        label346:
        localInteger1 = null;
        break label55;
        label352:
        localInteger1 = Integer.valueOf(paramnk.FGA);
        break label55;
        label364:
        localInteger2 = null;
        break label73;
        label370:
        localInteger2 = Integer.valueOf(paramnk.FGB);
        break label73;
        label382:
        str1 = null;
        break label105;
        label388:
        str1 = paramnk.content;
        break label105;
        label397:
        if (((Integer)localObject).intValue() != 0) {
          break label166;
        }
        paramnk = parama.ErJ;
        d.g.b.p.g(paramnk, "itemView.notChosen");
        paramnk.setVisibility(0);
        paramnk = parama.ErH;
        d.g.b.p.g(paramnk, "itemView.likeThumb");
        paramnk.setVisibility(8);
        parama = parama.gUd;
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
        parama.ErH.setImageResource(2131689705);
      }
    }
    
    public final void clear()
    {
      AppMethodBeat.i(82703);
      this.fVg.clear();
      notifyDataSetChanged();
      AppMethodBeat.o(82703);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(82706);
      int i = this.fVg.size();
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
      final nk localnk;
      Object localObject2;
      Object localObject1;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      for (;;)
      {
        localnk = XT(paramInt);
        if (localnk == null) {
          break label1446;
        }
        d.g.b.p.h(localnk, "info");
        com.tencent.mm.aw.a.a.aIP().a(localnk.hzB, paramViewGroup.jdF, ErC);
        localObject2 = paramViewGroup.ErM;
        localObject1 = paramViewGroup.ErP;
        d.g.b.p.h(localObject1, "itemView");
        if (localnk != null)
        {
          localObject3 = ((b)localObject2).context;
          localObject4 = (CharSequence)localnk.pjK;
          localObject5 = ((a)localObject1).oHp;
          d.g.b.p.g(localObject5, "itemView.nickName");
          localObject3 = k.b((Context)localObject3, (CharSequence)localObject4, ((TextView)localObject5).getTextSize());
          localObject4 = ((a)localObject1).oHp;
          d.g.b.p.g(localObject4, "itemView.nickName");
          ((TextView)localObject4).setText((CharSequence)localObject3);
          localObject3 = ((b)localObject2).context;
          localObject4 = (CharSequence)localnk.content;
          localObject5 = ((a)localObject1).ErE;
          d.g.b.p.g(localObject5, "itemView.desc");
          localObject3 = k.b((Context)localObject3, (CharSequence)localObject4, ((NeatTextView)localObject5).getTextSize());
          ((a)localObject1).ErE.ar((CharSequence)localObject3);
          ((a)localObject1).ErF.setIconColor(((b)localObject2).context.getResources().getColor(2131099769));
          localObject3 = ((a)localObject1).ErF;
          d.g.b.p.g(localObject3, "itemView.deleteIv");
          ((WeImageView)localObject3).setVisibility(0);
          localObject3 = ((a)localObject1).ErG;
          d.g.b.p.g(localObject3, "itemView.deleteSplit");
          ((ImageView)localObject3).setVisibility(0);
          ((a)localObject1).ErF.setOnClickListener((View.OnClickListener)new e((b)localObject2, localnk));
          ((b)localObject2).a((a)localObject1, localnk, null, false);
          localObject2 = ((a)localObject1).ErK;
          d.g.b.p.g(localObject2, "itemView.replyPrefix");
          ((ImageView)localObject2).setVisibility(8);
          localObject1 = ((a)localObject1).ErL;
          d.g.b.p.g(localObject1, "itemView.sameReplyPrefix");
          ((ImageView)localObject1).setVisibility(4);
        }
        localObject1 = paramViewGroup.ErQ;
        d.g.b.p.g(localObject1, "txtReply");
        ((TextView)localObject1).setVisibility(8);
        if (!n.a(paramViewGroup.ErM.ErA)) {
          break label1446;
        }
        localObject1 = paramViewGroup.ErQ;
        d.g.b.p.g(localObject1, "txtReply");
        ((TextView)localObject1).setVisibility(0);
        paramViewGroup.ErQ.setOnClickListener((View.OnClickListener)new n.b.b.a(paramViewGroup, localnk));
        localObject1 = ((Iterable)paramViewGroup.hbX).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (View)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            paramViewGroup.zZS.removeView((View)localObject2);
            paramViewGroup.ErM.Erz.add(localObject2);
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
      paramViewGroup.hbX.clear();
      int i;
      if ((localnk.FHt != null) && (localnk.FHt.FZp != null) && (localnk.FHt.FZp.size() > 0))
      {
        localObject1 = localnk.FHt.FZp;
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
            j.gfB();
          }
          localObject3 = (aaj)localObject1;
          localObject1 = paramViewGroup.ErM;
          label719:
          Context localContext;
          CharSequence localCharSequence;
          Object localObject6;
          if (((b)localObject1).Erz.size() > 0)
          {
            localObject1 = ((b)localObject1).Erz.remove(0);
            d.g.b.p.g(localObject1, "viewPool.removeAt(0)");
            localObject1 = (View)localObject1;
            paramViewGroup.hbX.add(localObject1);
            paramViewGroup.zZS.addView((View)localObject1);
            localObject4 = paramViewGroup.ErM;
            d.g.b.p.g(localObject3, "reply");
            localObject1 = new a(paramViewGroup.ErM, (View)localObject1);
            d.g.b.p.h(localObject3, "reply");
            d.g.b.p.h(localObject1, "itemView");
            if (localnk == null) {
              break label1509;
            }
            localObject5 = (d.g.a.b)new g((b)localObject4, (a)localObject1, localnk);
            if (d.g.b.p.i(localnk.FxE, ((aaj)localObject3).FxE) != true) {
              break label1222;
            }
            if (!((Boolean)((d.g.a.b)localObject5).invoke(Integer.valueOf(((aaj)localObject3).FZo))).booleanValue())
            {
              localObject5 = ((a)localObject1).oHp;
              d.g.b.p.g(localObject5, "itemView.nickName");
              localContext = ((b)localObject4).context;
              localCharSequence = (CharSequence)localnk.pjK;
              localObject6 = ((a)localObject1).oHp;
              d.g.b.p.g(localObject6, "itemView.nickName");
              ((TextView)localObject5).setText((CharSequence)k.b(localContext, localCharSequence, ((TextView)localObject6).getTextSize()));
              localObject5 = ((a)localObject1).ErE;
              localContext = ((b)localObject4).context;
              localCharSequence = (CharSequence)((aaj)localObject3).content;
              localObject6 = ((a)localObject1).ErE;
              d.g.b.p.g(localObject6, "itemView.desc");
              ((NeatTextView)localObject5).ar((CharSequence)k.b(localContext, localCharSequence, ((NeatTextView)localObject6).getTextSize()));
              ((a)localObject1).ErF.setIconColor(((b)localObject4).context.getResources().getColor(2131099769));
              localObject5 = ((a)localObject1).ErF;
              d.g.b.p.g(localObject5, "itemView.deleteIv");
              ((WeImageView)localObject5).setVisibility(0);
              localObject5 = ((a)localObject1).ErG;
              d.g.b.p.g(localObject5, "itemView.deleteSplit");
              ((ImageView)localObject5).setVisibility(0);
              ((b)localObject4).a((a)localObject1, localnk, (aaj)localObject3, true);
              ((a)localObject1).ErF.setOnClickListener((View.OnClickListener)new f((b)localObject4, localnk, (aaj)localObject3));
            }
            label1073:
            localObject4 = ((a)localObject1).ErK;
            d.g.b.p.g(localObject4, "itemView.replyPrefix");
            ((ImageView)localObject4).setVisibility(0);
            localObject4 = ((a)localObject1).ErL;
            d.g.b.p.g(localObject4, "itemView.sameReplyPrefix");
            ((ImageView)localObject4).setVisibility(4);
            if (i + 1 < localnk.FHt.FZp.size())
            {
              localObject1 = ((a)localObject1).ErL;
              d.g.b.p.g(localObject1, "itemView.sameReplyPrefix");
              if (!d.g.b.p.i(((aaj)localObject3).FxE, ((aaj)localnk.FHt.FZp.get(i + 1)).FxE)) {
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
            if (((Boolean)((d.g.a.b)localObject5).invoke(Integer.valueOf(((aaj)localObject3).FZo))).booleanValue()) {
              break label1073;
            }
            localObject5 = ((a)localObject1).oHp;
            d.g.b.p.g(localObject5, "itemView.nickName");
            localContext = ((b)localObject4).context;
            localCharSequence = (CharSequence)((b)localObject4).context.getResources().getString(2131761339);
            localObject6 = ((a)localObject1).oHp;
            d.g.b.p.g(localObject6, "itemView.nickName");
            ((TextView)localObject5).setText((CharSequence)k.b(localContext, localCharSequence, ((TextView)localObject6).getTextSize()));
            localObject5 = ((a)localObject1).ErE;
            localContext = ((b)localObject4).context;
            localCharSequence = (CharSequence)((aaj)localObject3).content;
            localObject6 = ((a)localObject1).ErE;
            d.g.b.p.g(localObject6, "itemView.desc");
            ((NeatTextView)localObject5).ar((CharSequence)k.b(localContext, localCharSequence, ((NeatTextView)localObject6).getTextSize()));
            localObject5 = ((a)localObject1).ErF;
            d.g.b.p.g(localObject5, "itemView.deleteIv");
            ((WeImageView)localObject5).setVisibility(8);
            localObject5 = ((a)localObject1).ErG;
            d.g.b.p.g(localObject5, "itemView.deleteSplit");
            ((ImageView)localObject5).setVisibility(8);
            ((b)localObject4).a((a)localObject1, localnk, (aaj)localObject3, true);
            break label1073;
          }
        }
        else
        {
          label1446:
          if (paramInt == getCount() - 1)
          {
            paramViewGroup = paramViewGroup.ErO;
            d.g.b.p.g(paramViewGroup, "holder.endlineLayout");
            paramViewGroup.setVisibility(0);
            this.ErA.getAppMsgCommentList();
          }
          for (;;)
          {
            AppMethodBeat.o(82707);
            return paramView;
            paramViewGroup = paramViewGroup.ErO;
            d.g.b.p.g(paramViewGroup, "holder.endlineLayout");
            paramViewGroup.setVisibility(8);
          }
        }
        label1509:
        i = j;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;Landroid/view/View;)V", "deleteIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getDeleteIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setDeleteIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "deleteSplit", "Landroid/widget/ImageView;", "getDeleteSplit", "()Landroid/widget/ImageView;", "desc", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "getDesc", "()Lcom/tencent/neattextview/textview/view/NeatTextView;", "setDesc", "(Lcom/tencent/neattextview/textview/view/NeatTextView;)V", "likeThumb", "getLikeThumb", "likeTv", "Landroid/widget/TextView;", "getLikeTv", "()Landroid/widget/TextView;", "setLikeTv", "(Landroid/widget/TextView;)V", "nickName", "getNickName", "setNickName", "notChosen", "getNotChosen", "replyDelete", "getReplyDelete", "replyPrefix", "getReplyPrefix", "sameReplyPrefix", "getSameReplyPrefix", "plugin-webview_release"})
    public final class a
    {
      NeatTextView ErE;
      WeImageView ErF;
      final ImageView ErG;
      final ImageView ErH;
      final TextView ErI;
      final TextView ErJ;
      final ImageView ErK;
      final ImageView ErL;
      TextView gUd;
      TextView oHp;
      
      public a()
      {
        AppMethodBeat.i(82699);
        this.oHp = ((TextView)((View)localObject).findViewById(2131297382));
        this.gUd = ((TextView)((View)localObject).findViewById(2131297381));
        this.ErE = ((NeatTextView)((View)localObject).findViewById(2131297378));
        this.ErF = ((WeImageView)((View)localObject).findViewById(2131297379));
        this.ErG = ((ImageView)((View)localObject).findViewById(2131297277));
        this.ErH = ((ImageView)((View)localObject).findViewById(2131297279));
        this.ErI = ((TextView)((View)localObject).findViewById(2131297282));
        this.ErJ = ((TextView)((View)localObject).findViewById(2131297280));
        this.ErK = ((ImageView)((View)localObject).findViewById(2131297300));
        this.ErL = ((ImageView)((View)localObject).findViewById(2131297301));
        this$1 = ((View)localObject).getContext();
        Object localObject = this.ErE;
        d.g.b.p.g(n.b.this, "context");
        ((NeatTextView)localObject).setTextColor(o.c(2130968850, n.b.this));
        AppMethodBeat.o(82699);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentViewHolder;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAvatar", "()Landroid/widget/ImageView;", "commentList", "Ljava/util/ArrayList;", "getCommentList", "()Ljava/util/ArrayList;", "content", "Landroid/widget/LinearLayout;", "getContent", "()Landroid/widget/LinearLayout;", "endlineLayout", "getEndlineLayout", "setEndlineLayout", "(Landroid/widget/LinearLayout;)V", "fansContent", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;", "getFansContent", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "setFansContent", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;)V", "fansLayout", "getFansLayout", "setFansLayout", "txtReply", "Landroid/widget/TextView;", "getTxtReply", "()Landroid/widget/TextView;", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "plugin-webview_release"})
    public final class b
    {
      private LinearLayout ErN;
      LinearLayout ErO;
      n.b.a ErP;
      final TextView ErQ;
      final ArrayList<View> hbX;
      final ImageView jdF;
      final LinearLayout zZS;
      
      public b()
      {
        AppMethodBeat.i(82700);
        this.jdF = ((ImageView)localObject.findViewById(2131297374));
        this.zZS = ((LinearLayout)localObject.findViewById(2131297377));
        this.ErN = ((LinearLayout)localObject.findViewById(2131297389));
        this.ErO = ((LinearLayout)localObject.findViewById(2131299488));
        LinearLayout localLinearLayout = this.ErN;
        d.g.b.p.g(localLinearLayout, "fansLayout");
        this.ErP = new n.b.a(n.b.this, (View)localLinearLayout);
        this.ErQ = ((TextView)localObject.findViewById(2131297281));
        this.hbX = new ArrayList();
        AppMethodBeat.o(82700);
      }
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
      static final class a
        implements View.OnClickListener
      {
        a(n.b.b paramb, nk paramnk) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(175691);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentViewHolder$update$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          this.ErR.ErM.ErA.tQ(3);
          this.ErR.ErM.ErA.u(n.b.a(this.ErS), this.ErS.FxD, true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentViewHolder$update$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(175691);
        }
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d
      implements View.OnClickListener
    {
      d(n.b paramb, boolean paramBoolean, aaj paramaaj, nk paramnk, n.b.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(175692);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$showLikeStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        n.b(this.ErM.ErA).clearFocus();
        int i;
        if (paramBoolean)
        {
          paramView = paramaaj;
          if (paramView != null)
          {
            paramView = Integer.valueOf(paramView.FZl);
            if (paramView == null) {
              d.g.b.p.gfZ();
            }
            i = paramView.intValue();
            label86:
            if (!paramBoolean) {
              break label544;
            }
            paramView = paramaaj;
            if (paramView == null) {
              break label539;
            }
            paramView = Integer.valueOf(paramView.FZm);
            label110:
            if (paramView != null) {
              break label558;
            }
            label114:
            parama.ErH.setImageResource(2131689705);
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
          parama.gUd.setText((CharSequence)String.valueOf(i));
          localObject = parama.gUd;
          d.g.b.p.g(localObject, "itemView.likeTv");
          int j;
          if (i > 0)
          {
            j = 0;
            label175:
            ((TextView)localObject).setVisibility(j);
            fh localfh = new fh();
            localfh.FxD = paramnk.FxD;
            localfh.FxE = paramnk.FxE;
            localfh.ozA = 1;
            if (paramBoolean)
            {
              localObject = paramaaj;
              if (localObject == null) {
                break label591;
              }
              localObject = Integer.valueOf(((aaj)localObject).FxG);
              label248:
              if (localObject == null) {
                d.g.b.p.gfZ();
              }
              localfh.FxG = ((Integer)localObject).intValue();
              localfh.ozA = 2;
            }
            if (paramView != null) {
              break label597;
            }
            label276:
            j = 0;
            label278:
            localfh.FxF = j;
            localObject = this.ErM.ErA;
            d.g.b.p.h(localfh, "req");
            localfh.scene = ((n)localObject).scene;
            localfh.FwF = ((n)localObject).ooi;
            localfh.url = ((n)localObject).url;
            localfh.FwD = ((n)localObject).hzh;
            localfh.session_id = ((n)localObject).ooj;
            localfh.FwE = ((n)localObject).oog;
            com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
            locala.c((com.tencent.mm.bx.a)localfh);
            locala.d((com.tencent.mm.bx.a)new fi());
            locala.Dl("/cgi-bin/mmbiz-bin/appmsg/appmsg_like_comment");
            locala.oP(2759);
            locala.oR(0);
            locala.oS(0);
            IPCRunCgi.a(locala.aDC(), (IPCRunCgi.a)new n.d((n)localObject));
            if (paramView != null) {
              break label609;
            }
            label459:
            paramView = Integer.valueOf(0);
            label464:
            if (!paramBoolean) {
              break label624;
            }
            localObject = paramaaj;
            if (localObject != null) {
              ((aaj)localObject).FZm = paramView.intValue();
            }
            paramView = paramaaj;
            if (paramView != null) {
              paramView.FZl = i;
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$showLikeStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(175692);
            return;
            paramView = null;
            break;
            i = paramnk.FGA;
            break label86;
            label539:
            paramView = null;
            break label110;
            label544:
            paramView = Integer.valueOf(paramnk.FGB);
            break label110;
            label558:
            if (paramView.intValue() != 0) {
              break label114;
            }
            parama.ErH.setImageResource(2131689706);
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
            paramnk.FGB = paramView.intValue();
            paramnk.FGA = i;
          }
        }
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(n.b paramb, nk paramnk) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(82702);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$updateCommentContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        new d.a(n.b.a(this.ErM)).aXF(n.b.a(this.ErM).getString(2131756650)).aXG("").afn(n.b.a(this.ErM).getResources().getColor(2131099804)).afl(2131755707).c((DialogInterface.OnClickListener)new a(this)).afm(2131756755).fMb().show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$updateCommentContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82702);
      }
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
      static final class a
        implements DialogInterface.OnClickListener
      {
        a(n.b.e parame) {}
        
        public final void onClick(DialogInterface paramDialogInterface, int paramInt)
        {
          AppMethodBeat.i(82701);
          paramDialogInterface = new fl();
          paramDialogInterface.FxD = this.ErV.ErS.FxD;
          paramDialogInterface.ozA = 2;
          this.ErV.ErM.ErA.a(paramDialogInterface);
          com.tencent.mm.plugin.webview.h.a.WZ(13);
          AppMethodBeat.o(82701);
        }
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f
      implements View.OnClickListener
    {
      f(n.b paramb, nk paramnk, aaj paramaaj) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(175694);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$updateReplyView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        new d.a(n.b.a(this.ErM)).aXF(n.b.a(this.ErM).getString(2131756571)).aXG("").afn(n.b.a(this.ErM).getResources().getColor(2131099804)).afl(2131755707).c((DialogInterface.OnClickListener)new a(this)).afm(2131756755).fMb().show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$updateReplyView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(175694);
      }
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
      static final class a
        implements DialogInterface.OnClickListener
      {
        a(n.b.f paramf) {}
        
        public final void onClick(DialogInterface paramDialogInterface, int paramInt)
        {
          AppMethodBeat.i(175693);
          paramDialogInterface = new fl();
          paramDialogInterface.FxD = this.ErW.ErS.FxD;
          paramDialogInterface.FxG = this.ErW.ErT.FxG;
          paramDialogInterface.ozA = 4;
          this.ErW.ErM.ErA.a(paramDialogInterface);
          com.tencent.mm.plugin.webview.h.a.WZ(13);
          AppMethodBeat.o(175693);
        }
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<no name provided>", "", "delFlag", "", "invoke"})
    static final class g
      extends q
      implements d.g.a.b<Integer, Boolean>
    {
      g(n.b paramb, n.b.a parama, nk paramnk)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "", "onHide", "", "onShow", "plugin-webview_release"})
  public static abstract interface c
  {
    public abstract void onHide();
    
    public abstract void onShow();
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
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
          Object localObject = p.Esp;
          p.b(this.ErX.Erx.getWebView().eSB());
          if (this.ErX.Erx.getWeakThis$plugin_webview_release().get() != null)
          {
            localObject = this.ErX.Erx.getWeakThis$plugin_webview_release().get();
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
            d.g.b.p.g(localb, "rr");
            n.b((n)localObject, i, j, str, localb);
          }
          AppMethodBeat.o(175698);
        }
      });
      AppMethodBeat.o(175699);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
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
          Object localObject = p.Esp;
          p.b(this.ErY.Erx.getWebView().eSB());
          if (this.ErY.Erx.getWeakThis$plugin_webview_release().get() != null)
          {
            localObject = this.ErY.Erx.getWeakThis$plugin_webview_release().get();
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
            d.g.b.p.g(localb, "rr");
            n.a((n)localObject, i, j, str, localb);
          }
          AppMethodBeat.o(82710);
        }
      });
      AppMethodBeat.o(82711);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class f
    implements IPCRunCgi.a
  {
    f(n paramn) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.al.b paramb)
    {
      AppMethodBeat.i(82713);
      n.f(this.Erx);
      aq.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(82712);
          Object localObject = p.Esp;
          p.b(this.ErZ.Erx.getWebView().eSB());
          if (this.ErZ.Erx.getWeakThis$plugin_webview_release().get() != null)
          {
            localObject = this.ErZ.Erx.getWeakThis$plugin_webview_release().get();
            if (localObject == null)
            {
              localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout");
              AppMethodBeat.o(82712);
              throw ((Throwable)localObject);
            }
            localObject = (n)localObject;
            com.tencent.mm.al.b localb = paramb;
            d.g.b.p.g(localb, "rr");
            n.a((n)localObject, localb);
          }
          AppMethodBeat.o(82712);
        }
      });
      if (paramInt1 == 2)
      {
        com.tencent.mm.plugin.webview.h.a.WZ(8);
        AppMethodBeat.o(82713);
        return;
      }
      if (paramInt1 != 0) {
        com.tencent.mm.plugin.webview.h.a.WZ(9);
      }
      AppMethodBeat.o(82713);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$hideAnimation$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "ani", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"})
  public static final class g
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(82714);
      d.g.b.p.h(paramAnimation, "ani");
      paramAnimation = this.Erx.getWeakThis$plugin_webview_release().get();
      if (paramAnimation == null)
      {
        paramAnimation = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout");
        AppMethodBeat.o(82714);
        throw paramAnimation;
      }
      ((n)paramAnimation).setVisibility(8);
      n.e(this.Erx).clearAnimation();
      AppMethodBeat.o(82714);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation) {}
    
    public final void onAnimationStart(Animation paramAnimation) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "state", "", "onKeyBoardStateChange"})
  static final class h
    implements KeyboardLinearLayout.a
  {
    h(n paramn) {}
    
    public final void GV(int paramInt)
    {
      AppMethodBeat.i(82717);
      n.a locala = n.Erw;
      ad.i(n.access$getTAG$cp(), "onKeyBoardStateChange, state = ".concat(String.valueOf(paramInt)));
      if (paramInt == -3)
      {
        int i = n.c(this.Erx).getKeyBoardHeight();
        if (i > 0)
        {
          n.a(this.Erx, i);
          n.a(this.Erx, i);
        }
        new ap().postDelayed((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(82715);
            n.d(this.Esa.Erx).edy();
            n.d(this.Esa.Erx).postInvalidate();
            n.e(this.Esa.Erx).postInvalidate();
            AppMethodBeat.o(82715);
          }
        }, 10L);
      }
      for (;;)
      {
        n.b(this.Erx, paramInt);
        AppMethodBeat.o(82717);
        return;
        n.a(this.Erx, 0);
        n.a(this.Erx, 0);
        new ap().postDelayed((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(82716);
            n.d(this.Esa.Erx).eVC();
            n.d(this.Esa.Erx).postInvalidate();
            n.e(this.Esa.Erx).postInvalidate();
            AppMethodBeat.o(82716);
          }
        }, 10L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.n
 * JD-Core Version:    0.7.0.1
 */
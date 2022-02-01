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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.protocal.protobuf.ev;
import com.tencent.mm.protocal.protobuf.fc;
import com.tencent.mm.protocal.protobuf.fd;
import com.tencent.mm.protocal.protobuf.fg;
import com.tencent.mm.protocal.protobuf.fh;
import com.tencent.mm.protocal.protobuf.mt;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.protocal.protobuf.yl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.y;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewKeyboardLinearLayout;", "webView", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "isDark", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;ZLandroid/content/Context;Landroid/util/AttributeSet;)V", "actionView", "Landroid/view/View;", "adapter", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;", "callback", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "getCallback", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "setCallback", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;)V", "cancelTv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "commentTopicId", "", "getCommentTopicId", "()J", "setCommentTopicId", "(J)V", "commitBt", "Landroid/widget/Button;", "contentEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "currentKbState", "", "enterId", "getEnterId", "()I", "setEnterId", "(I)V", "hasReadOpenCfg", "isDoingGetMyComment", "isHaokan", "isReplyOpen", "itemShowType", "getItemShowType", "setItemShowType", "kbLayout", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "minHeaderHeight", "getMinHeaderHeight", "setMinHeaderHeight", "myCommentOffset", "getMyCommentOffset", "setMyCommentOffset", "myCommentTitleTv", "Landroid/widget/TextView;", "myCommentTv", "myCommentView", "recyclerView", "Landroid/widget/ListView;", "replyPersonalCommentId", "replyTip", "root", "savePortHeight", "sayFooter", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter;", "getSayFooter", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter;", "sayFooter$delegate", "Lkotlin/Lazy;", "scene", "getScene", "setScene", "subScene", "getSubScene", "setSubScene", "timeLineSessionId", "getTimeLineSessionId", "setTimeLineSessionId", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "weakThis", "Ljava/lang/ref/WeakReference;", "getWeakThis$plugin_webview_release", "()Ljava/lang/ref/WeakReference;", "setWeakThis$plugin_webview_release", "(Ljava/lang/ref/WeakReference;)V", "getWebView", "()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "caculateHeight", "", "newMarginBottom", "checkHeight", "h", "clearPersonalComment", "refreshHeight", "closeComment", "contentEtOnClick", "dealOrientaion", "orientation", "doAppMsgLikeComment", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgLikeCommentReq;", "doAppMsgOperateComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "doReport", "actionType", "fixKeyBoardMargin", "getAppMsgCommentList", "getNavHeightByDisplay", "getReplyHeight", "getRootHeight", "hide", "hideAnimation", "initKeyboardListener", "isShow", "onAddCommentSuccess", "onAppMsgLikeComment", "errType", "errCode", "errMsg", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "onAppMsgOperateComment", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDeleteComment", "onDeleteCommentReply", "onDestroy", "onGetCommentList", "onKeyBackPress", "onNoComment", "onResume", "onTouchClose", "replyToPersonalComment", "replyContent", "personalCommentId", "saveRootHeight", "height", "setData", "setRootHeight", "show", "showAnimation", "showCommentView", "showLayout", "showLayoutReply", "updateData", "resp", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommentListResp;", "clearUpdate", "updateUrl", "curUrl", "Companion", "MPMyCommentItemAdapter", "MPWriteCommentLayoutCallback", "plugin-webview_release"})
public final class n
  extends WebViewKeyboardLinearLayout
{
  public static final n.a CNw;
  private static final String TAG = "MicroMsg.MPWriteCommentLayout";
  public int CAP;
  private final d.f CNb;
  private final WeImageView CNc;
  private final Button CNd;
  public final MMEditText CNe;
  private final ListView CNf;
  private final View CNg;
  private final TextView CNh;
  private final TextView CNi;
  private final TextView CNj;
  private b CNk;
  private boolean CNl;
  private int CNm;
  private int CNn;
  private int CNo;
  private long CNp;
  private c CNq;
  private boolean CNr;
  private int CNs;
  private boolean CNt;
  private boolean CNu;
  public final WebViewUI CNv;
  private final WebViewKeyboardLinearLayout CyY;
  private final boolean duV;
  private final View fvu;
  int hgY;
  private final View iIO;
  int nLA;
  int nLC;
  int nLD;
  private WeakReference<n> nnu;
  int scene;
  private String title;
  String url;
  
  static
  {
    AppMethodBeat.i(82720);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(n.class), "sayFooter", "getSayFooter()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter;")) };
    CNw = new n.a((byte)0);
    TAG = "MicroMsg.MPWriteCommentLayout";
    AppMethodBeat.o(82720);
  }
  
  public n(WebViewUI paramWebViewUI, Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(175710);
    this.CNv = paramWebViewUI;
    this.duV = false;
    paramWebViewUI = View.inflate(paramContext, 2131494959, (ViewGroup)this);
    if (paramWebViewUI == null)
    {
      paramWebViewUI = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout");
      AppMethodBeat.o(175710);
      throw paramWebViewUI;
    }
    this.CyY = ((WebViewKeyboardLinearLayout)paramWebViewUI);
    paramWebViewUI = findViewById(2131302501);
    d.g.b.k.g(paramWebViewUI, "findViewById(R.id.mp_video_comment_action_layout)");
    this.iIO = paramWebViewUI;
    this.CNb = d.g.K((d.g.a.a)new n.j(this));
    paramWebViewUI = findViewById(2131302502);
    d.g.b.k.g(paramWebViewUI, "findViewById(R.id.mp_video_comment_cancel)");
    this.CNc = ((WeImageView)paramWebViewUI);
    paramWebViewUI = findViewById(2131302504);
    d.g.b.k.g(paramWebViewUI, "findViewById(R.id.mp_video_comment_ok)");
    this.CNd = ((Button)paramWebViewUI);
    paramWebViewUI = findViewById(2131302503);
    d.g.b.k.g(paramWebViewUI, "findViewById(R.id.mp_video_comment_et)");
    this.CNe = ((MMEditText)paramWebViewUI);
    paramWebViewUI = findViewById(2131297394);
    d.g.b.k.g(paramWebViewUI, "findViewById(R.id.biz_video_my_comment_list)");
    this.CNf = ((ListView)paramWebViewUI);
    paramWebViewUI = findViewById(2131302518);
    d.g.b.k.g(paramWebViewUI, "findViewById(R.id.mp_write_comment_root)");
    this.fvu = paramWebViewUI;
    paramWebViewUI = findViewById(2131302517);
    d.g.b.k.g(paramWebViewUI, "findViewById(R.id.mp_vid…rite_comment_scroll_view)");
    this.CNg = paramWebViewUI;
    paramWebViewUI = findViewById(2131297395);
    d.g.b.k.g(paramWebViewUI, "findViewById(R.id.biz_video_my_comment_tv)");
    this.CNh = ((TextView)paramWebViewUI);
    paramWebViewUI = findViewById(2131302507);
    d.g.b.k.g(paramWebViewUI, "findViewById(R.id.mp_video_my_comment_title)");
    this.CNi = ((TextView)paramWebViewUI);
    paramWebViewUI = findViewById(2131297401);
    d.g.b.k.g(paramWebViewUI, "findViewById(R.id.biz_video_reply_tip)");
    this.CNj = ((TextView)paramWebViewUI);
    this.CAP = -1;
    this.url = "";
    this.title = "";
    this.nnu = new WeakReference(this);
    getSayFooter().setMMEditText(this.CNe);
    getSayFooter().setVisibility(8);
    this.CNe.setOnClickListener((View.OnClickListener)new n.1(this));
    this.CNe.setOnLongClickListener((View.OnLongClickListener)new n.2(this));
    this.CyY.setOnTouchListener((View.OnTouchListener)new n.3(this));
    this.fvu.setOnClickListener((View.OnClickListener)n.4.CNy);
    int i = getRootHeight();
    if (i > 0)
    {
      paramWebViewUI = this.fvu.getLayoutParams();
      if (paramWebViewUI == null)
      {
        paramWebViewUI = new v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        AppMethodBeat.o(175710);
        throw paramWebViewUI;
      }
      paramWebViewUI.height = i;
      this.fvu.setLayoutParams(paramWebViewUI);
    }
    if (!y.iA(paramContext)) {
      VY(2);
    }
    this.CNc.setOnClickListener((View.OnClickListener)new n.5(this));
    this.CNd.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82697);
        if (n.j(this.CNx))
        {
          paramAnonymousView = n.b(this.CNx).getText().toString();
          com.tencent.mm.plugin.webview.c.f localf = this.CNx.getWebView().Cjc;
          if (localf != null)
          {
            localf.v(1, paramAnonymousView, 1);
            AppMethodBeat.o(82697);
            return;
          }
          AppMethodBeat.o(82697);
          return;
        }
        this.CNx.getWebView().hideVKB();
        if (n.d(this.CNx).dRh()) {
          n.d(this.CNx).dRi();
        }
        paramAnonymousView = new fg();
        paramAnonymousView.content = n.b(this.CNx).getText().toString();
        paramAnonymousView.nWg = 1;
        if (n.k(this.CNx) != 0)
        {
          paramAnonymousView.nWg = 3;
          paramAnonymousView.DSk = n.k(this.CNx);
        }
        this.CNx.a(paramAnonymousView);
        com.tencent.mm.plugin.webview.h.a.Vj(10);
        AppMethodBeat.o(82697);
      }
    });
    this.CNe.addTextChangedListener((TextWatcher)new n.7(this));
    paramWebViewUI = this.CNd;
    paramContext = this.CNe.getText();
    d.g.b.k.g(paramContext, "contentEt.text");
    if (((CharSequence)paramContext).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramWebViewUI.setEnabled(bool);
      this.CNe.setOnTouchListener((View.OnTouchListener)new n.8(this));
      this.CNj.setVisibility(8);
      AppMethodBeat.o(175710);
      return;
    }
  }
  
  private final void VY(int paramInt)
  {
    AppMethodBeat.i(82729);
    switch (paramInt)
    {
    default: 
      if (this.CyY.eDg()) {
        VZ(this.CyY.getKeyBoardHeight());
      }
      break;
    }
    for (;;)
    {
      this.CNe.setMinLines(5);
      AppMethodBeat.o(82729);
      return;
      paramInt = com.tencent.mm.ui.ap.ji(getContext());
      setRootHeight(com.tencent.mm.ui.ap.cl(getContext()).y - paramInt);
      this.CNe.setMinLines(3);
      AppMethodBeat.o(82729);
      return;
      if (this.CNm != 0) {
        setRootHeight(this.CNm);
      } else {
        VZ(0);
      }
    }
  }
  
  private final void VZ(int paramInt)
  {
    AppMethodBeat.i(82730);
    Object localObject = this.fvu.getLayoutParams();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(82730);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.LayoutParams)localObject).height = (this.CNe.getHeight() + this.iIO.getHeight() + getNavHeightByDisplay() + com.tencent.mm.cc.a.fromDPToPix(getContext(), com.tencent.mm.cc.a.ax(getContext(), 60) + 16) + getReplyHeight() + paramInt);
    ((ViewGroup.LayoutParams)localObject).height = Wa(((ViewGroup.LayoutParams)localObject).height);
    this.fvu.setLayoutParams((ViewGroup.LayoutParams)localObject);
    Wb(((ViewGroup.LayoutParams)localObject).height);
    AppMethodBeat.o(82730);
  }
  
  private final int Wa(int paramInt)
  {
    AppMethodBeat.i(82732);
    int j = com.tencent.mm.ui.ap.ji(getContext());
    int k = com.tencent.mm.ui.ap.cl(getContext()).y;
    int i = k - j;
    if (paramInt > i) {}
    for (;;)
    {
      AppMethodBeat.o(82732);
      return i;
      i = paramInt;
      if (this.CNo > 0)
      {
        int m = com.tencent.mm.cc.a.fromDPToPix(getContext(), 20);
        i = paramInt;
        if (paramInt < k - this.CNo - j + m) {
          i = k - j - this.CNo + m;
        }
      }
    }
  }
  
  private final void Wb(int paramInt)
  {
    AppMethodBeat.i(82733);
    if (y.iA(getContext())) {
      this.CNm = paramInt;
    }
    aw localaw = aw.aKU("MPWriteCommentLayout");
    localaw.encode("MPWriteCommentRootHeight", paramInt);
    localaw.apply();
    AppMethodBeat.o(82733);
  }
  
  private final void eGE()
  {
    AppMethodBeat.i(82723);
    View localView = this.CNg;
    Context localContext = getContext();
    d.g.b.k.g(localContext, "context");
    localView.setBackgroundColor(o.c(2130968842, localContext));
    this.CNh.setVisibility(8);
    AppMethodBeat.o(82723);
  }
  
  private void eGG()
  {
    AppMethodBeat.i(175703);
    this.CNe.setText((CharSequence)"");
    this.CNs = 0;
    getAppMsgCommentList();
    AppMethodBeat.o(175703);
  }
  
  private final void eGH()
  {
    AppMethodBeat.i(182680);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(250L);
    localTranslateAnimation.setFillAfter(false);
    this.fvu.clearAnimation();
    this.fvu.startAnimation((Animation)localTranslateAnimation);
    AppMethodBeat.o(182680);
  }
  
  private final void eGI()
  {
    AppMethodBeat.i(82737);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    localTranslateAnimation.setDuration(150L);
    localTranslateAnimation.setFillAfter(false);
    localTranslateAnimation.setAnimationListener((Animation.AnimationListener)new g(this));
    this.fvu.clearAnimation();
    this.fvu.startAnimation((Animation)localTranslateAnimation);
    AppMethodBeat.o(82737);
  }
  
  private final int getNavHeightByDisplay()
  {
    AppMethodBeat.i(82739);
    Point localPoint = com.tencent.mm.ui.ap.cl(getContext());
    Object localObject = this.CNv.getWindow();
    if (localObject != null) {}
    for (localObject = ((Window)localObject).getDecorView();; localObject = null)
    {
      Rect localRect = new Rect();
      if (localObject != null) {
        ((View)localObject).getWindowVisibleDisplayFrame(localRect);
      }
      int i = localRect.bottom;
      int j = localPoint.y - i - this.CyY.getKeyBoardHeight();
      ac.v(TAG, "getNavHeightByDisplay screenHeight = " + i + ", realSize = " + localPoint.y);
      i = j;
      if (j < 0)
      {
        i = com.tencent.mm.ui.ap.ej(getContext());
        ac.v(TAG, "getNavHeightByDisplay error");
      }
      ac.v(TAG, "getNavHeightByDisplay h = %s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(82739);
      return i;
    }
  }
  
  private final int getReplyHeight()
  {
    AppMethodBeat.i(182681);
    if (this.CNn != 0)
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
    Object localObject = this.fvu.getLayoutParams();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(82731);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.LayoutParams)localObject).height = Wa(paramInt);
    this.fvu.setLayoutParams((ViewGroup.LayoutParams)localObject);
    Wb(((ViewGroup.LayoutParams)localObject).height);
    AppMethodBeat.o(82731);
  }
  
  private final void show()
  {
    AppMethodBeat.i(82735);
    this.fvu.clearAnimation();
    setVisibility(0);
    eGH();
    c localc = this.CNq;
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
    this.nLC = paramInt2;
    this.hgY = paramInt3;
    this.nLA = paramInt4;
    this.url = paramString1;
    this.title = paramString2;
  }
  
  public final void a(fg paramfg)
  {
    AppMethodBeat.i(82741);
    d.g.b.k.h(paramfg, "req");
    paramfg.scene = this.scene;
    paramfg.DRn = this.nLC;
    paramfg.url = this.url;
    paramfg.title = this.title;
    paramfg.DSq = System.currentTimeMillis();
    paramfg.DRl = this.hgY;
    paramfg.session_id = this.nLD;
    paramfg.DRm = this.nLA;
    paramfg.DRo = this.CNp;
    Object localObject = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject).c((com.tencent.mm.bw.a)paramfg);
    ((com.tencent.mm.ak.b.a)localObject).d((com.tencent.mm.bw.a)new fh());
    ((com.tencent.mm.ak.b.a)localObject).Am("/cgi-bin/mmbiz-bin/appmsg/appmsg_operate_comment");
    ((com.tencent.mm.ak.b.a)localObject).op(2617);
    ((com.tencent.mm.ak.b.a)localObject).or(0);
    ((com.tencent.mm.ak.b.a)localObject).os(0);
    IPCRunCgi.a(((com.tencent.mm.ak.b.a)localObject).aAz(), (IPCRunCgi.a)new e(this));
    paramfg = this.CNv;
    localObject = p.COp;
    localObject = getContext().getString(2131755936);
    d.g.b.k.g(localObject, "context.getString(R.string.app_waiting)");
    Context localContext = getContext();
    d.g.b.k.g(localContext, "context");
    paramfg.a(p.a((String)localObject, localContext, this.CNv.eDJ()));
    AppMethodBeat.o(82741);
  }
  
  public final void aDZ(String paramString)
  {
    AppMethodBeat.i(175701);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(175701);
      return;
    }
    this.url = paramString;
    AppMethodBeat.o(175701);
  }
  
  public final boolean bjw()
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
  
  public final void eGF()
  {
    AppMethodBeat.i(82724);
    this.CyY.setOnkbdStateListener((KeyboardLinearLayout.a)new h(this));
    AppMethodBeat.o(82724);
  }
  
  public final boolean eGJ()
  {
    AppMethodBeat.i(175708);
    if (!this.CNt) {
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pQl, 0) != 1) {
        break label86;
      }
    }
    label86:
    for (boolean bool = true;; bool = false)
    {
      this.CNu = bool;
      this.CNt = true;
      ac.v(TAG, "isReplyOpen = " + this.CNu);
      bool = this.CNu;
      AppMethodBeat.o(175708);
      return bool;
    }
  }
  
  public final void getAppMsgCommentList()
  {
    AppMethodBeat.i(82740);
    eu localeu = new eu();
    localeu.url = this.url;
    if (this.CNr)
    {
      AppMethodBeat.o(82740);
      return;
    }
    localeu.offset = this.CNs;
    if (this.CNs == -1)
    {
      ac.i(TAG, "no more my comment");
      AppMethodBeat.o(82740);
      return;
    }
    this.CNr = true;
    localeu.nWg = 2;
    localeu.scene = this.scene;
    localeu.DRn = this.nLC;
    localeu.DRl = this.hgY;
    localeu.session_id = this.nLD;
    localeu.DRm = this.nLA;
    localeu.DRo = this.CNp;
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    locala.c((com.tencent.mm.bw.a)localeu);
    locala.d((com.tencent.mm.bw.a)new ev());
    locala.Am("/cgi-bin/mmbiz-bin/appmsg/appmsg_comment_list");
    locala.op(2866);
    locala.or(0);
    locala.os(0);
    IPCRunCgi.a(locala.aAz(), (IPCRunCgi.a)new f(this));
    com.tencent.mm.plugin.webview.h.a.Vj(7);
    AppMethodBeat.o(82740);
  }
  
  public final c getCallback()
  {
    return this.CNq;
  }
  
  public final long getCommentTopicId()
  {
    return this.CNp;
  }
  
  public final int getEnterId()
  {
    return this.nLA;
  }
  
  public final int getItemShowType()
  {
    return this.hgY;
  }
  
  public final int getMinHeaderHeight()
  {
    return this.CNo;
  }
  
  public final int getMyCommentOffset()
  {
    return this.CNs;
  }
  
  public final MPSmileyFooter getSayFooter()
  {
    AppMethodBeat.i(82721);
    MPSmileyFooter localMPSmileyFooter = (MPSmileyFooter)this.CNb.getValue();
    AppMethodBeat.o(82721);
    return localMPSmileyFooter;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final int getSubScene()
  {
    return this.nLC;
  }
  
  public final int getTimeLineSessionId()
  {
    return this.nLD;
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
    return this.nnu;
  }
  
  public final WebViewUI getWebView()
  {
    return this.CNv;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(82736);
    if (!bjw())
    {
      AppMethodBeat.o(82736);
      return;
    }
    if (getSayFooter().dRh()) {
      getSayFooter().dRi();
    }
    eGI();
    this.CNv.hideVKB();
    this.CNs = 0;
    Object localObject = this.CNk;
    if (localObject != null) {
      ((b)localObject).clear();
    }
    localObject = this.CNq;
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
    VY(paramConfiguration.orientation);
    if (getSayFooter().dRh()) {
      getSayFooter().dRi();
    }
    AppMethodBeat.o(82728);
  }
  
  public final void setCallback(c paramc)
  {
    this.CNq = paramc;
  }
  
  public final void setCommentTopicId(long paramLong)
  {
    this.CNp = paramLong;
  }
  
  public final void setEnterId(int paramInt)
  {
    this.nLA = paramInt;
  }
  
  public final void setItemShowType(int paramInt)
  {
    this.hgY = paramInt;
  }
  
  public final void setMinHeaderHeight(int paramInt)
  {
    this.CNo = paramInt;
  }
  
  public final void setMyCommentOffset(int paramInt)
  {
    this.CNs = paramInt;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public final void setSubScene(int paramInt)
  {
    this.nLC = paramInt;
  }
  
  public final void setTimeLineSessionId(int paramInt)
  {
    this.nLD = paramInt;
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
    this.nnu = paramWeakReference;
    AppMethodBeat.o(82722);
  }
  
  public final void tn(int paramInt)
  {
    AppMethodBeat.i(175709);
    String str2 = Uri.parse(this.url).getQueryParameter("clicktime");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.url);
    localStringBuilder.append(",");
    localStringBuilder.append(this.scene);
    localStringBuilder.append(",");
    String str1 = str2;
    if (bs.isNullOrNil(str2)) {
      str1 = "";
    }
    localStringBuilder.append(str1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",");
    localStringBuilder.append(System.currentTimeMillis());
    str1 = localStringBuilder.toString();
    ac.v(TAG, str1);
    h.wUl.kvStat(19265, str1);
    AppMethodBeat.o(175709);
  }
  
  public final void u(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(175705);
    d.g.b.k.h(paramString, "replyContent");
    this.CNn = paramInt;
    this.CNi.setText((CharSequence)getContext().getString(2131756575));
    this.CNj.setVisibility(0);
    TextView localTextView = this.CNj;
    Context localContext = getContext();
    String str = paramString;
    if (bs.isNullOrNil(paramString)) {
      str = "";
    }
    localTextView.setText((CharSequence)localContext.getString(2131756574, new Object[] { str }));
    this.CNe.setHint((CharSequence)getContext().getString(2131756573));
    if (paramBoolean)
    {
      this.CNg.scrollTo(0, 0);
      this.CNe.requestFocus();
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
        paramString.showSoftInput((View)this.CNe, 0);
        AppMethodBeat.o(175705);
        return;
      }
    }
    AppMethodBeat.o(175705);
  }
  
  public final void uG(boolean paramBoolean)
  {
    AppMethodBeat.i(82725);
    tn(1);
    uI(false);
    uH(paramBoolean);
    AppMethodBeat.o(82725);
  }
  
  public final void uH(boolean paramBoolean)
  {
    AppMethodBeat.i(175702);
    this.CNl = paramBoolean;
    show();
    if (paramBoolean)
    {
      this.CNh.setVisibility(8);
      this.CNi.setText((CharSequence)getContext().getString(2131756657));
      this.CNe.setHint(2131756659);
      this.CNd.setText(2131755884);
      localObject = this.CNd;
      localContext = getContext();
      d.g.b.k.g(localContext, "context");
      ((Button)localObject).setBackground(localContext.getResources().getDrawable(2131231294));
      localObject = (InputFilter)new InputFilter.LengthFilter(200);
      this.CNe.setFilters(new InputFilter[] { localObject });
      AppMethodBeat.o(175702);
      return;
    }
    getAppMsgCommentList();
    this.CNd.setText(2131756649);
    Object localObject = this.CNd;
    Context localContext = getContext();
    d.g.b.k.g(localContext, "context");
    ((Button)localObject).setBackground(o.gV(localContext));
    AppMethodBeat.o(175702);
  }
  
  public final void uI(boolean paramBoolean)
  {
    AppMethodBeat.i(175707);
    if (this.CNn != 0)
    {
      this.CNn = 0;
      if (paramBoolean) {
        VY(y.iB(getContext()));
      }
    }
    this.CNj.setText((CharSequence)"");
    this.CNj.setVisibility(8);
    this.CNe.setHint((CharSequence)getContext().getString(2131756669));
    this.CNi.setText((CharSequence)getContext().getString(2131756667));
    AppMethodBeat.o(175707);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "controller", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "isDarkPanel", "", "(Landroid/content/Context;Ljava/util/LinkedList;Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;Z)V", "getController", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "setController", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;)V", "viewPool", "Ljava/util/ArrayList;", "Landroid/view/View;", "getViewPool", "()Ljava/util/ArrayList;", "clear", "", "getCommentView", "getCount", "", "getItem", "position", "getItemId", "", "i", "getLastInvalidReply", "", "info", "getView", "convertView", "viewGroup", "Landroid/view/ViewGroup;", "onDeleteComment", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "onDeleteCommentReply", "showLikeStatus", "itemView", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "reply", "Lcom/tencent/mm/protocal/protobuf/CommentReply;", "isReply", "update", "items", "", "clearUpdate", "updateCommentContentView", "updateReplyView", "index", "BizCommentContent", "BizCommentViewHolder", "Companion", "plugin-webview_release"})
  public static final class b
    extends BaseAdapter
  {
    private static com.tencent.mm.av.a.a.c CNC;
    public static final n.b.c CND;
    static final String TAG = "MicroMsg.MPMyCommentItemAdapter";
    n CNA;
    private boolean CNB;
    final ArrayList<View> CNz;
    private final Context context;
    final LinkedList<mt> fBS;
    
    static
    {
      AppMethodBeat.i(82709);
      CND = new n.b.c((byte)0);
      TAG = "MicroMsg.MPMyCommentItemAdapter";
      CNC = new c.a().pf(2131100141).aFP().de(120, 120).a((com.tencent.mm.av.a.c.c)new com.tencent.mm.pluginsdk.ui.applet.n()).a((com.tencent.mm.av.a.c.a)new e()).aFR().ak(com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 3)).aFT();
      AppMethodBeat.o(82709);
    }
    
    public b(Context paramContext, LinkedList<mt> paramLinkedList, n paramn, boolean paramBoolean)
    {
      AppMethodBeat.i(162324);
      this.context = paramContext;
      this.fBS = paramLinkedList;
      this.CNA = paramn;
      this.CNB = paramBoolean;
      this.CNz = new ArrayList();
      AppMethodBeat.o(162324);
    }
    
    private mt Wc(int paramInt)
    {
      AppMethodBeat.i(82704);
      mt localmt = (mt)j.C((List)this.fBS, paramInt);
      AppMethodBeat.o(82704);
      return localmt;
    }
    
    public static String a(mt parammt)
    {
      AppMethodBeat.i(182678);
      d.g.b.k.h(parammt, "info");
      String str = parammt.content;
      int i;
      if ((parammt.EbH != null) && (!bs.gY((List)parammt.EbH.Esg)))
      {
        i = parammt.EbH.Esg.size() - 1;
        if (i >= 0) {
          if (((yk)parammt.EbH.Esg.get(i)).Esf != 0) {}
        }
      }
      for (parammt = ((yk)parammt.EbH.Esg.get(i)).content;; parammt = str)
      {
        d.g.b.k.g(parammt, "reply");
        AppMethodBeat.o(182678);
        return parammt;
        i -= 1;
        break;
      }
    }
    
    private void a(final a parama, final mt parammt, final yk paramyk, final boolean paramBoolean)
    {
      AppMethodBeat.i(175697);
      d.g.b.k.h(parama, "itemView");
      d.g.b.k.h(parammt, "info");
      Object localObject;
      Integer localInteger1;
      label55:
      Integer localInteger2;
      label73:
      String str1;
      label105:
      int i;
      if (paramBoolean) {
        if (paramyk != null)
        {
          localObject = Integer.valueOf(paramyk.Ese);
          if (!paramBoolean) {
            break label352;
          }
          if (paramyk == null) {
            break label346;
          }
          localInteger1 = Integer.valueOf(paramyk.Esc);
          if (!paramBoolean) {
            break label370;
          }
          if (paramyk == null) {
            break label364;
          }
          localInteger2 = Integer.valueOf(paramyk.Esd);
          String str2 = TAG;
          StringBuilder localStringBuilder = new StringBuilder("showLikeStatus content = ");
          if (!paramBoolean) {
            break label388;
          }
          if (paramyk == null) {
            break label382;
          }
          str1 = paramyk.content;
          ac.v(str2, str1 + ", isElected = " + localObject + ", likeNum = " + localInteger1 + ", likeStatus = " + localInteger2);
          parama.CNH.setOnClickListener(null);
          if (localObject != null) {
            break label397;
          }
          label166:
          localObject = parama.CNJ;
          d.g.b.k.g(localObject, "itemView.notChosen");
          ((TextView)localObject).setVisibility(8);
          localObject = parama.CNH;
          d.g.b.k.g(localObject, "itemView.likeThumb");
          ((ImageView)localObject).setVisibility(0);
          localObject = parama.gAt;
          d.g.b.k.g(localObject, "itemView.likeTv");
          ((TextView)localObject).setVisibility(8);
          if (localInteger1 != null)
          {
            localObject = parama.gAt;
            d.g.b.k.g(localObject, "itemView.likeTv");
            if (localInteger1.intValue() <= 0) {
              break label465;
            }
            i = 0;
            label258:
            ((TextView)localObject).setVisibility(i);
            parama.gAt.setText((CharSequence)String.valueOf(localInteger1.intValue()));
          }
          if (localInteger2 != null) {
            break label472;
          }
          label288:
          parama.CNH.setImageResource(2131689706);
        }
      }
      for (;;)
      {
        parama.CNH.setOnClickListener((View.OnClickListener)new d(this, paramBoolean, paramyk, parammt, parama));
        AppMethodBeat.o(175697);
        return;
        localObject = null;
        break;
        localObject = Integer.valueOf(parammt.EbG);
        break;
        label346:
        localInteger1 = null;
        break label55;
        label352:
        localInteger1 = Integer.valueOf(parammt.EaR);
        break label55;
        label364:
        localInteger2 = null;
        break label73;
        label370:
        localInteger2 = Integer.valueOf(parammt.EaS);
        break label73;
        label382:
        str1 = null;
        break label105;
        label388:
        str1 = parammt.content;
        break label105;
        label397:
        if (((Integer)localObject).intValue() != 0) {
          break label166;
        }
        parammt = parama.CNJ;
        d.g.b.k.g(parammt, "itemView.notChosen");
        parammt.setVisibility(0);
        parammt = parama.CNH;
        d.g.b.k.g(parammt, "itemView.likeThumb");
        parammt.setVisibility(8);
        parama = parama.gAt;
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
        parama.CNH.setImageResource(2131689705);
      }
    }
    
    public final void clear()
    {
      AppMethodBeat.i(82703);
      this.fBS.clear();
      notifyDataSetChanged();
      AppMethodBeat.o(82703);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(82706);
      int i = this.fBS.size();
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
      final mt localmt;
      Object localObject2;
      Object localObject1;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      for (;;)
      {
        localmt = Wc(paramInt);
        if (localmt == null) {
          break label1446;
        }
        d.g.b.k.h(localmt, "info");
        com.tencent.mm.av.a.a.aFG().a(localmt.hhs, paramViewGroup.iKw, CNC);
        localObject2 = paramViewGroup.CNM;
        localObject1 = paramViewGroup.CNP;
        d.g.b.k.h(localObject1, "itemView");
        if (localmt != null)
        {
          localObject3 = ((b)localObject2).context;
          localObject4 = (CharSequence)localmt.oGg;
          localObject5 = ((a)localObject1).nyK;
          d.g.b.k.g(localObject5, "itemView.nickName");
          localObject3 = com.tencent.mm.pluginsdk.ui.span.k.b((Context)localObject3, (CharSequence)localObject4, ((TextView)localObject5).getTextSize());
          localObject4 = ((a)localObject1).nyK;
          d.g.b.k.g(localObject4, "itemView.nickName");
          ((TextView)localObject4).setText((CharSequence)localObject3);
          localObject3 = ((b)localObject2).context;
          localObject4 = (CharSequence)localmt.content;
          localObject5 = ((a)localObject1).CNE;
          d.g.b.k.g(localObject5, "itemView.desc");
          localObject3 = com.tencent.mm.pluginsdk.ui.span.k.b((Context)localObject3, (CharSequence)localObject4, ((NeatTextView)localObject5).getTextSize());
          ((a)localObject1).CNE.ar((CharSequence)localObject3);
          ((a)localObject1).CNF.setIconColor(((b)localObject2).context.getResources().getColor(2131099769));
          localObject3 = ((a)localObject1).CNF;
          d.g.b.k.g(localObject3, "itemView.deleteIv");
          ((WeImageView)localObject3).setVisibility(0);
          localObject3 = ((a)localObject1).CNG;
          d.g.b.k.g(localObject3, "itemView.deleteSplit");
          ((ImageView)localObject3).setVisibility(0);
          ((a)localObject1).CNF.setOnClickListener((View.OnClickListener)new e((b)localObject2, localmt));
          ((b)localObject2).a((a)localObject1, localmt, null, false);
          localObject2 = ((a)localObject1).CNK;
          d.g.b.k.g(localObject2, "itemView.replyPrefix");
          ((ImageView)localObject2).setVisibility(8);
          localObject1 = ((a)localObject1).CNL;
          d.g.b.k.g(localObject1, "itemView.sameReplyPrefix");
          ((ImageView)localObject1).setVisibility(4);
        }
        localObject1 = paramViewGroup.CNQ;
        d.g.b.k.g(localObject1, "txtReply");
        ((TextView)localObject1).setVisibility(8);
        if (!n.a(paramViewGroup.CNM.CNA)) {
          break label1446;
        }
        localObject1 = paramViewGroup.CNQ;
        d.g.b.k.g(localObject1, "txtReply");
        ((TextView)localObject1).setVisibility(0);
        paramViewGroup.CNQ.setOnClickListener((View.OnClickListener)new n.b.b.a(paramViewGroup, localmt));
        localObject1 = ((Iterable)paramViewGroup.gIn).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (View)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            paramViewGroup.yIy.removeView((View)localObject2);
            paramViewGroup.CNM.CNz.add(localObject2);
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
      paramViewGroup.gIn.clear();
      int i;
      if ((localmt.EbH != null) && (localmt.EbH.Esg != null) && (localmt.EbH.Esg.size() > 0))
      {
        localObject1 = localmt.EbH.Esg;
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
            j.fOc();
          }
          localObject3 = (yk)localObject1;
          localObject1 = paramViewGroup.CNM;
          label719:
          Context localContext;
          CharSequence localCharSequence;
          Object localObject6;
          if (((b)localObject1).CNz.size() > 0)
          {
            localObject1 = ((b)localObject1).CNz.remove(0);
            d.g.b.k.g(localObject1, "viewPool.removeAt(0)");
            localObject1 = (View)localObject1;
            paramViewGroup.gIn.add(localObject1);
            paramViewGroup.yIy.addView((View)localObject1);
            localObject4 = paramViewGroup.CNM;
            d.g.b.k.g(localObject3, "reply");
            localObject1 = new a(paramViewGroup.CNM, (View)localObject1);
            d.g.b.k.h(localObject3, "reply");
            d.g.b.k.h(localObject1, "itemView");
            if (localmt == null) {
              break label1509;
            }
            localObject5 = (d.g.a.b)new g((b)localObject4, (a)localObject1, localmt);
            if (d.g.b.k.g(localmt.DSl, ((yk)localObject3).DSl) != true) {
              break label1222;
            }
            if (!((Boolean)((d.g.a.b)localObject5).ay(Integer.valueOf(((yk)localObject3).Esf))).booleanValue())
            {
              localObject5 = ((a)localObject1).nyK;
              d.g.b.k.g(localObject5, "itemView.nickName");
              localContext = ((b)localObject4).context;
              localCharSequence = (CharSequence)localmt.oGg;
              localObject6 = ((a)localObject1).nyK;
              d.g.b.k.g(localObject6, "itemView.nickName");
              ((TextView)localObject5).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(localContext, localCharSequence, ((TextView)localObject6).getTextSize()));
              localObject5 = ((a)localObject1).CNE;
              localContext = ((b)localObject4).context;
              localCharSequence = (CharSequence)((yk)localObject3).content;
              localObject6 = ((a)localObject1).CNE;
              d.g.b.k.g(localObject6, "itemView.desc");
              ((NeatTextView)localObject5).ar((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(localContext, localCharSequence, ((NeatTextView)localObject6).getTextSize()));
              ((a)localObject1).CNF.setIconColor(((b)localObject4).context.getResources().getColor(2131099769));
              localObject5 = ((a)localObject1).CNF;
              d.g.b.k.g(localObject5, "itemView.deleteIv");
              ((WeImageView)localObject5).setVisibility(0);
              localObject5 = ((a)localObject1).CNG;
              d.g.b.k.g(localObject5, "itemView.deleteSplit");
              ((ImageView)localObject5).setVisibility(0);
              ((b)localObject4).a((a)localObject1, localmt, (yk)localObject3, true);
              ((a)localObject1).CNF.setOnClickListener((View.OnClickListener)new f((b)localObject4, localmt, (yk)localObject3));
            }
            label1073:
            localObject4 = ((a)localObject1).CNK;
            d.g.b.k.g(localObject4, "itemView.replyPrefix");
            ((ImageView)localObject4).setVisibility(0);
            localObject4 = ((a)localObject1).CNL;
            d.g.b.k.g(localObject4, "itemView.sameReplyPrefix");
            ((ImageView)localObject4).setVisibility(4);
            if (i + 1 < localmt.EbH.Esg.size())
            {
              localObject1 = ((a)localObject1).CNL;
              d.g.b.k.g(localObject1, "itemView.sameReplyPrefix");
              if (!d.g.b.k.g(((yk)localObject3).DSl, ((yk)localmt.EbH.Esg.get(i + 1)).DSl)) {
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
            if (((Boolean)((d.g.a.b)localObject5).ay(Integer.valueOf(((yk)localObject3).Esf))).booleanValue()) {
              break label1073;
            }
            localObject5 = ((a)localObject1).nyK;
            d.g.b.k.g(localObject5, "itemView.nickName");
            localContext = ((b)localObject4).context;
            localCharSequence = (CharSequence)((b)localObject4).context.getResources().getString(2131761339);
            localObject6 = ((a)localObject1).nyK;
            d.g.b.k.g(localObject6, "itemView.nickName");
            ((TextView)localObject5).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(localContext, localCharSequence, ((TextView)localObject6).getTextSize()));
            localObject5 = ((a)localObject1).CNE;
            localContext = ((b)localObject4).context;
            localCharSequence = (CharSequence)((yk)localObject3).content;
            localObject6 = ((a)localObject1).CNE;
            d.g.b.k.g(localObject6, "itemView.desc");
            ((NeatTextView)localObject5).ar((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(localContext, localCharSequence, ((NeatTextView)localObject6).getTextSize()));
            localObject5 = ((a)localObject1).CNF;
            d.g.b.k.g(localObject5, "itemView.deleteIv");
            ((WeImageView)localObject5).setVisibility(8);
            localObject5 = ((a)localObject1).CNG;
            d.g.b.k.g(localObject5, "itemView.deleteSplit");
            ((ImageView)localObject5).setVisibility(8);
            ((b)localObject4).a((a)localObject1, localmt, (yk)localObject3, true);
            break label1073;
          }
        }
        else
        {
          label1446:
          if (paramInt == getCount() - 1)
          {
            paramViewGroup = paramViewGroup.CNO;
            d.g.b.k.g(paramViewGroup, "holder.endlineLayout");
            paramViewGroup.setVisibility(0);
            this.CNA.getAppMsgCommentList();
          }
          for (;;)
          {
            AppMethodBeat.o(82707);
            return paramView;
            paramViewGroup = paramViewGroup.CNO;
            d.g.b.k.g(paramViewGroup, "holder.endlineLayout");
            paramViewGroup.setVisibility(8);
          }
        }
        label1509:
        i = j;
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;Landroid/view/View;)V", "deleteIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getDeleteIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setDeleteIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "deleteSplit", "Landroid/widget/ImageView;", "getDeleteSplit", "()Landroid/widget/ImageView;", "desc", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "getDesc", "()Lcom/tencent/neattextview/textview/view/NeatTextView;", "setDesc", "(Lcom/tencent/neattextview/textview/view/NeatTextView;)V", "likeThumb", "getLikeThumb", "likeTv", "Landroid/widget/TextView;", "getLikeTv", "()Landroid/widget/TextView;", "setLikeTv", "(Landroid/widget/TextView;)V", "nickName", "getNickName", "setNickName", "notChosen", "getNotChosen", "replyDelete", "getReplyDelete", "replyPrefix", "getReplyPrefix", "sameReplyPrefix", "getSameReplyPrefix", "plugin-webview_release"})
    public final class a
    {
      NeatTextView CNE;
      WeImageView CNF;
      final ImageView CNG;
      final ImageView CNH;
      final TextView CNI;
      final TextView CNJ;
      final ImageView CNK;
      final ImageView CNL;
      TextView gAt;
      TextView nyK;
      
      public a()
      {
        AppMethodBeat.i(82699);
        this.nyK = ((TextView)((View)localObject).findViewById(2131297382));
        this.gAt = ((TextView)((View)localObject).findViewById(2131297381));
        this.CNE = ((NeatTextView)((View)localObject).findViewById(2131297378));
        this.CNF = ((WeImageView)((View)localObject).findViewById(2131297379));
        this.CNG = ((ImageView)((View)localObject).findViewById(2131297277));
        this.CNH = ((ImageView)((View)localObject).findViewById(2131297279));
        this.CNI = ((TextView)((View)localObject).findViewById(2131297282));
        this.CNJ = ((TextView)((View)localObject).findViewById(2131297280));
        this.CNK = ((ImageView)((View)localObject).findViewById(2131297300));
        this.CNL = ((ImageView)((View)localObject).findViewById(2131297301));
        this$1 = ((View)localObject).getContext();
        Object localObject = this.CNE;
        d.g.b.k.g(n.b.this, "context");
        ((NeatTextView)localObject).setTextColor(o.c(2130968850, n.b.this));
        AppMethodBeat.o(82699);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentViewHolder;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAvatar", "()Landroid/widget/ImageView;", "commentList", "Ljava/util/ArrayList;", "getCommentList", "()Ljava/util/ArrayList;", "content", "Landroid/widget/LinearLayout;", "getContent", "()Landroid/widget/LinearLayout;", "endlineLayout", "getEndlineLayout", "setEndlineLayout", "(Landroid/widget/LinearLayout;)V", "fansContent", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;", "getFansContent", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "setFansContent", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;)V", "fansLayout", "getFansLayout", "setFansLayout", "txtReply", "Landroid/widget/TextView;", "getTxtReply", "()Landroid/widget/TextView;", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "plugin-webview_release"})
    public final class b
    {
      private LinearLayout CNN;
      LinearLayout CNO;
      n.b.a CNP;
      final TextView CNQ;
      final ArrayList<View> gIn;
      final ImageView iKw;
      final LinearLayout yIy;
      
      public b()
      {
        AppMethodBeat.i(82700);
        this.iKw = ((ImageView)localObject.findViewById(2131297374));
        this.yIy = ((LinearLayout)localObject.findViewById(2131297377));
        this.CNN = ((LinearLayout)localObject.findViewById(2131297389));
        this.CNO = ((LinearLayout)localObject.findViewById(2131299488));
        LinearLayout localLinearLayout = this.CNN;
        d.g.b.k.g(localLinearLayout, "fansLayout");
        this.CNP = new n.b.a(n.b.this, (View)localLinearLayout);
        this.CNQ = ((TextView)localObject.findViewById(2131297281));
        this.gIn = new ArrayList();
        AppMethodBeat.o(82700);
      }
      
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
      static final class a
        implements View.OnClickListener
      {
        a(n.b.b paramb, mt parammt) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(175691);
          this.CNR.CNM.CNA.tn(3);
          this.CNR.CNM.CNA.u(n.b.a(this.CNS), this.CNS.DSk, true);
          AppMethodBeat.o(175691);
        }
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d
      implements View.OnClickListener
    {
      d(n.b paramb, boolean paramBoolean, yk paramyk, mt parammt, n.b.a parama) {}
      
      public final void onClick(View paramView)
      {
        Object localObject1 = null;
        AppMethodBeat.i(175692);
        n.b(this.CNM.CNA).clearFocus();
        int i;
        if (paramBoolean)
        {
          paramView = paramyk;
          if (paramView != null)
          {
            paramView = Integer.valueOf(paramView.Esc);
            if (paramView == null) {
              d.g.b.k.fOy();
            }
            i = paramView.intValue();
            label57:
            if (!paramBoolean) {
              break label503;
            }
            paramView = paramyk;
            if (paramView == null) {
              break label498;
            }
            paramView = Integer.valueOf(paramView.Esd);
            label81:
            if (paramView != null) {
              break label517;
            }
            label85:
            parama.CNH.setImageResource(2131689705);
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
          parama.gAt.setText((CharSequence)String.valueOf(i));
          Object localObject2 = parama.gAt;
          d.g.b.k.g(localObject2, "itemView.likeTv");
          int j;
          if (i > 0)
          {
            j = 0;
            ((TextView)localObject2).setVisibility(j);
            localObject2 = new fc();
            ((fc)localObject2).DSk = parammt.DSk;
            ((fc)localObject2).DSl = parammt.DSl;
            ((fc)localObject2).nWg = 1;
            if (paramBoolean)
            {
              localObject3 = paramyk;
              if (localObject3 != null) {
                localObject1 = Integer.valueOf(((yk)localObject3).DSn);
              }
              if (localObject1 == null) {
                d.g.b.k.fOy();
              }
              ((fc)localObject2).DSn = ((Integer)localObject1).intValue();
              ((fc)localObject2).nWg = 2;
            }
            if (paramView != null) {
              break label550;
            }
            label247:
            j = 0;
            label249:
            ((fc)localObject2).DSm = j;
            localObject1 = this.CNM.CNA;
            d.g.b.k.h(localObject2, "req");
            ((fc)localObject2).scene = ((n)localObject1).scene;
            ((fc)localObject2).DRn = ((n)localObject1).nLC;
            ((fc)localObject2).url = ((n)localObject1).url;
            ((fc)localObject2).DRl = ((n)localObject1).hgY;
            ((fc)localObject2).session_id = ((n)localObject1).nLD;
            ((fc)localObject2).DRm = ((n)localObject1).nLA;
            Object localObject3 = new com.tencent.mm.ak.b.a();
            ((com.tencent.mm.ak.b.a)localObject3).c((com.tencent.mm.bw.a)localObject2);
            ((com.tencent.mm.ak.b.a)localObject3).d((com.tencent.mm.bw.a)new fd());
            ((com.tencent.mm.ak.b.a)localObject3).Am("/cgi-bin/mmbiz-bin/appmsg/appmsg_like_comment");
            ((com.tencent.mm.ak.b.a)localObject3).op(2759);
            ((com.tencent.mm.ak.b.a)localObject3).or(0);
            ((com.tencent.mm.ak.b.a)localObject3).os(0);
            IPCRunCgi.a(((com.tencent.mm.ak.b.a)localObject3).aAz(), (IPCRunCgi.a)new n.d((n)localObject1));
            if (paramView != null) {
              break label562;
            }
            paramView = Integer.valueOf(0);
          }
          for (;;)
          {
            if (paramBoolean)
            {
              localObject1 = paramyk;
              if (localObject1 != null) {
                ((yk)localObject1).Esd = paramView.intValue();
              }
              paramView = paramyk;
              if (paramView != null)
              {
                paramView.Esc = i;
                AppMethodBeat.o(175692);
                return;
                paramView = null;
                break;
                i = parammt.EaR;
                break label57;
                label498:
                paramView = null;
                break label81;
                label503:
                paramView = Integer.valueOf(parammt.EaS);
                break label81;
                if (paramView.intValue() != 0) {
                  break label85;
                }
                parama.CNH.setImageResource(2131689706);
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
          parammt.EaS = paramView.intValue();
          parammt.EaR = i;
          AppMethodBeat.o(175692);
          return;
        }
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(n.b paramb, mt parammt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(82702);
        new d.a(n.b.a(this.CNM)).aRH(n.b.a(this.CNM).getString(2131756650)).aRI("").acO(n.b.a(this.CNM).getResources().getColor(2131099804)).acM(2131755707).b((DialogInterface.OnClickListener)new a(this)).acN(2131756755).fvp().show();
        AppMethodBeat.o(82702);
      }
      
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
      static final class a
        implements DialogInterface.OnClickListener
      {
        a(n.b.e parame) {}
        
        public final void onClick(DialogInterface paramDialogInterface, int paramInt)
        {
          AppMethodBeat.i(82701);
          paramDialogInterface = new fg();
          paramDialogInterface.DSk = this.CNV.CNS.DSk;
          paramDialogInterface.nWg = 2;
          this.CNV.CNM.CNA.a(paramDialogInterface);
          com.tencent.mm.plugin.webview.h.a.Vj(13);
          AppMethodBeat.o(82701);
        }
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f
      implements View.OnClickListener
    {
      f(n.b paramb, mt parammt, yk paramyk) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(175694);
        new d.a(n.b.a(this.CNM)).aRH(n.b.a(this.CNM).getString(2131756571)).aRI("").acO(n.b.a(this.CNM).getResources().getColor(2131099804)).acM(2131755707).b((DialogInterface.OnClickListener)new a(this)).acN(2131756755).fvp().show();
        AppMethodBeat.o(175694);
      }
      
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
      static final class a
        implements DialogInterface.OnClickListener
      {
        a(n.b.f paramf) {}
        
        public final void onClick(DialogInterface paramDialogInterface, int paramInt)
        {
          AppMethodBeat.i(175693);
          paramDialogInterface = new fg();
          paramDialogInterface.DSk = this.CNW.CNS.DSk;
          paramDialogInterface.DSn = this.CNW.CNT.DSn;
          paramDialogInterface.nWg = 4;
          this.CNW.CNM.CNA.a(paramDialogInterface);
          com.tencent.mm.plugin.webview.h.a.Vj(13);
          AppMethodBeat.o(175693);
        }
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<no name provided>", "", "delFlag", "", "invoke"})
    static final class g
      extends d.g.b.l
      implements d.g.a.b<Integer, Boolean>
    {
      g(n.b paramb, n.b.a parama, mt parammt)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "", "onHide", "", "onShow", "plugin-webview_release"})
  public static abstract interface c
  {
    public abstract void onHide();
    
    public abstract void onShow();
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class d
    implements IPCRunCgi.a
  {
    d(n paramn) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(175699);
      com.tencent.mm.sdk.platformtools.ap.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(175698);
          Object localObject = p.COp;
          p.b(this.CNX.CNx.getWebView().eDJ());
          if (this.CNX.CNx.getWeakThis$plugin_webview_release().get() != null)
          {
            localObject = this.CNX.CNx.getWeakThis$plugin_webview_release().get();
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
            d.g.b.k.g(localb, "rr");
            n.b((n)localObject, i, j, str, localb);
          }
          AppMethodBeat.o(175698);
        }
      });
      AppMethodBeat.o(175699);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class e
    implements IPCRunCgi.a
  {
    e(n paramn) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(82711);
      com.tencent.mm.sdk.platformtools.ap.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(82710);
          Object localObject = p.COp;
          p.b(this.CNY.CNx.getWebView().eDJ());
          if (this.CNY.CNx.getWeakThis$plugin_webview_release().get() != null)
          {
            localObject = this.CNY.CNx.getWeakThis$plugin_webview_release().get();
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
            d.g.b.k.g(localb, "rr");
            n.a((n)localObject, i, j, str, localb);
          }
          AppMethodBeat.o(82710);
        }
      });
      AppMethodBeat.o(82711);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class f
    implements IPCRunCgi.a
  {
    f(n paramn) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(82713);
      n.f(this.CNx);
      com.tencent.mm.sdk.platformtools.ap.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(82712);
          Object localObject = p.COp;
          p.b(this.CNZ.CNx.getWebView().eDJ());
          if (this.CNZ.CNx.getWeakThis$plugin_webview_release().get() != null)
          {
            localObject = this.CNZ.CNx.getWeakThis$plugin_webview_release().get();
            if (localObject == null)
            {
              localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout");
              AppMethodBeat.o(82712);
              throw ((Throwable)localObject);
            }
            localObject = (n)localObject;
            com.tencent.mm.ak.b localb = paramb;
            d.g.b.k.g(localb, "rr");
            n.a((n)localObject, localb);
          }
          AppMethodBeat.o(82712);
        }
      });
      if (paramInt1 == 2)
      {
        com.tencent.mm.plugin.webview.h.a.Vj(8);
        AppMethodBeat.o(82713);
        return;
      }
      if (paramInt1 != 0) {
        com.tencent.mm.plugin.webview.h.a.Vj(9);
      }
      AppMethodBeat.o(82713);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$hideAnimation$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "ani", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"})
  public static final class g
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(82714);
      d.g.b.k.h(paramAnimation, "ani");
      paramAnimation = this.CNx.getWeakThis$plugin_webview_release().get();
      if (paramAnimation == null)
      {
        paramAnimation = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout");
        AppMethodBeat.o(82714);
        throw paramAnimation;
      }
      ((n)paramAnimation).setVisibility(8);
      n.e(this.CNx).clearAnimation();
      AppMethodBeat.o(82714);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation) {}
    
    public final void onAnimationStart(Animation paramAnimation) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "state", "", "onKeyBoardStateChange"})
  static final class h
    implements KeyboardLinearLayout.a
  {
    h(n paramn) {}
    
    public final void FG(int paramInt)
    {
      AppMethodBeat.i(82717);
      n.a locala = n.CNw;
      ac.i(n.access$getTAG$cp(), "onKeyBoardStateChange, state = ".concat(String.valueOf(paramInt)));
      if (paramInt == -3)
      {
        int i = n.c(this.CNx).getKeyBoardHeight();
        if (i > 0)
        {
          n.a(this.CNx, i);
          n.a(this.CNx, i);
        }
        new ao().postDelayed((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(82715);
            n.d(this.COa.CNx).dRg();
            n.d(this.COa.CNx).postInvalidate();
            n.e(this.COa.CNx).postInvalidate();
            AppMethodBeat.o(82715);
          }
        }, 10L);
      }
      for (;;)
      {
        n.b(this.CNx, paramInt);
        AppMethodBeat.o(82717);
        return;
        n.a(this.CNx, 0);
        n.a(this.CNx, 0);
        new ao().postDelayed((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(82716);
            n.d(this.COa.CNx).eGC();
            n.d(this.COa.CNx).postInvalidate();
            n.e(this.COa.CNx).postInvalidate();
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
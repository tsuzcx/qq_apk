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
import android.view.MotionEvent;
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
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.c.b;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.e;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.protocal.protobuf.acl;
import com.tencent.mm.protocal.protobuf.acm;
import com.tencent.mm.protocal.protobuf.ff;
import com.tencent.mm.protocal.protobuf.fg;
import com.tencent.mm.protocal.protobuf.fk;
import com.tencent.mm.protocal.protobuf.fl;
import com.tencent.mm.protocal.protobuf.fm;
import com.tencent.mm.protocal.protobuf.fn;
import com.tencent.mm.protocal.protobuf.nv;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.ax;
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
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewKeyboardLinearLayout;", "webView", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "isDark", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;ZLandroid/content/Context;Landroid/util/AttributeSet;)V", "actionView", "Landroid/view/View;", "adapter", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;", "callback", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "getCallback", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "setCallback", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;)V", "cancelTv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "commentTopicId", "", "getCommentTopicId", "()J", "setCommentTopicId", "(J)V", "commitBt", "Landroid/widget/Button;", "contentEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "currentKbState", "", "enterId", "getEnterId", "()I", "setEnterId", "(I)V", "hasReadOpenCfg", "isDoingGetMyComment", "isHaokan", "isReplyOpen", "itemShowType", "getItemShowType", "setItemShowType", "kbLayout", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "minHeaderHeight", "getMinHeaderHeight", "setMinHeaderHeight", "myCommentOffset", "getMyCommentOffset", "setMyCommentOffset", "myCommentTitleTv", "Landroid/widget/TextView;", "myCommentTv", "myCommentView", "recyclerView", "Landroid/widget/ListView;", "replyPersonalCommentId", "replyTip", "root", "savePortHeight", "sayFooter", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter;", "getSayFooter", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter;", "sayFooter$delegate", "Lkotlin/Lazy;", "scene", "getScene", "setScene", "subScene", "getSubScene", "setSubScene", "timeLineSessionId", "getTimeLineSessionId", "setTimeLineSessionId", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "weakThis", "Ljava/lang/ref/WeakReference;", "getWeakThis$plugin_webview_release", "()Ljava/lang/ref/WeakReference;", "setWeakThis$plugin_webview_release", "(Ljava/lang/ref/WeakReference;)V", "getWebView", "()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "caculateHeight", "", "newMarginBottom", "checkHeight", "h", "clearPersonalComment", "refreshHeight", "closeComment", "contentEtOnClick", "dealOrientaion", "orientation", "doAppMsgLikeComment", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgLikeCommentReq;", "doAppMsgOperateComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "doReport", "actionType", "fixKeyBoardMargin", "getAppMsgCommentList", "getNavHeightByDisplay", "getReplyHeight", "getRootHeight", "hide", "hideAnimation", "initKeyboardListener", "isShow", "onAddCommentSuccess", "onAppMsgLikeComment", "errType", "errCode", "errMsg", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "onAppMsgOperateComment", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDeleteComment", "onDeleteCommentReply", "onDestroy", "onGetCommentList", "onKeyBackPress", "onNoComment", "onResume", "onTouchClose", "replyToPersonalComment", "replyContent", "personalCommentId", "saveRootHeight", "height", "setData", "setRootHeight", "show", "showAnimation", "showCommentView", "showLayout", "showLayoutReply", "updateData", "resp", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommentListResp;", "clearUpdate", "updateUrl", "curUrl", "Companion", "MPMyCommentItemAdapter", "MPWriteCommentLayoutCallback", "plugin-webview_release"})
public final class n
  extends WebViewKeyboardLinearLayout
{
  public static final n.a QxN;
  private static final String TAG = "MicroMsg.MPWriteCommentLayout";
  public final WebViewKeyboardLinearLayout Qfa;
  int QgT;
  public int QtB;
  private final TextView QxA;
  private b QxB;
  private boolean QxC;
  private int QxD;
  private int QxE;
  private int QxF;
  int QxG;
  private n.c QxH;
  private boolean QxI;
  private int QxJ;
  private boolean QxK;
  private boolean QxL;
  final WebViewUI QxM;
  private final f Qxs;
  private final WeImageView Qxt;
  private final Button Qxu;
  public final MMEditText Qxv;
  private final ListView Qxw;
  private final View Qxx;
  private final TextView Qxy;
  private final TextView Qxz;
  private final boolean fTI;
  private final View jac;
  public int llp;
  private long lqf;
  private final View mUs;
  public int scene;
  private WeakReference<n> sgE;
  public String title;
  public String url;
  public int wGA;
  
  static
  {
    AppMethodBeat.i(82720);
    QxN = new n.a((byte)0);
    TAG = "MicroMsg.MPWriteCommentLayout";
    AppMethodBeat.o(82720);
  }
  
  public n(WebViewUI paramWebViewUI, Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(175710);
    this.QxM = paramWebViewUI;
    this.fTI = false;
    paramWebViewUI = View.inflate(paramContext, c.g.mp_video_write_comment_view, (ViewGroup)this);
    if (paramWebViewUI == null)
    {
      paramWebViewUI = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout");
      AppMethodBeat.o(175710);
      throw paramWebViewUI;
    }
    this.Qfa = ((WebViewKeyboardLinearLayout)paramWebViewUI);
    paramWebViewUI = findViewById(c.f.mp_video_comment_action_layout);
    p.j(paramWebViewUI, "findViewById(R.id.mp_video_comment_action_layout)");
    this.mUs = paramWebViewUI;
    this.Qxs = g.ar((kotlin.g.a.a)new n.j(this));
    paramWebViewUI = findViewById(c.f.mp_video_comment_cancel);
    p.j(paramWebViewUI, "findViewById(R.id.mp_video_comment_cancel)");
    this.Qxt = ((WeImageView)paramWebViewUI);
    paramWebViewUI = findViewById(c.f.mp_video_comment_ok);
    p.j(paramWebViewUI, "findViewById(R.id.mp_video_comment_ok)");
    this.Qxu = ((Button)paramWebViewUI);
    paramWebViewUI = findViewById(c.f.mp_video_comment_et);
    p.j(paramWebViewUI, "findViewById(R.id.mp_video_comment_et)");
    this.Qxv = ((MMEditText)paramWebViewUI);
    paramWebViewUI = findViewById(c.f.biz_video_my_comment_list);
    p.j(paramWebViewUI, "findViewById(R.id.biz_video_my_comment_list)");
    this.Qxw = ((ListView)paramWebViewUI);
    paramWebViewUI = findViewById(c.f.mp_write_comment_root);
    p.j(paramWebViewUI, "findViewById(R.id.mp_write_comment_root)");
    this.jac = paramWebViewUI;
    paramWebViewUI = findViewById(c.f.mp_video_write_comment_scroll_view);
    p.j(paramWebViewUI, "findViewById(R.id.mp_vid…rite_comment_scroll_view)");
    this.Qxx = paramWebViewUI;
    paramWebViewUI = findViewById(c.f.biz_video_my_comment_tv);
    p.j(paramWebViewUI, "findViewById(R.id.biz_video_my_comment_tv)");
    this.Qxy = ((TextView)paramWebViewUI);
    paramWebViewUI = findViewById(c.f.mp_video_my_comment_title);
    p.j(paramWebViewUI, "findViewById(R.id.mp_video_my_comment_title)");
    this.Qxz = ((TextView)paramWebViewUI);
    paramWebViewUI = findViewById(c.f.biz_video_reply_tip);
    p.j(paramWebViewUI, "findViewById(R.id.biz_video_reply_tip)");
    this.QxA = ((TextView)paramWebViewUI);
    this.QgT = -1;
    this.url = "";
    this.title = "";
    this.sgE = new WeakReference(this);
    getSayFooter().setMMEditText(this.Qxv);
    getSayFooter().setVisibility(8);
    this.Qxv.setOnClickListener((View.OnClickListener)new n.1(this));
    this.Qxv.setOnLongClickListener((View.OnLongClickListener)new n.2(this));
    this.Qfa.setOnTouchListener((View.OnTouchListener)new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(82693);
        p.j(paramAnonymousMotionEvent, "event");
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          paramAnonymousView = this.QxO;
          if (paramAnonymousView.QgT != -3) {
            break label46;
          }
          paramAnonymousView.QxM.hideVKB();
        }
        for (;;)
        {
          AppMethodBeat.o(82693);
          return true;
          label46:
          if ((paramAnonymousView.getSayFooter().hbX()) && (paramAnonymousView.bVd())) {
            paramAnonymousView.getSayFooter().aDK();
          } else {
            paramAnonymousView.hide();
          }
        }
      }
    });
    this.jac.setOnClickListener((View.OnClickListener)n.4.QxP);
    int i = getRootHeight();
    if (i > 0)
    {
      paramWebViewUI = this.jac.getLayoutParams();
      if (paramWebViewUI == null)
      {
        paramWebViewUI = new t("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        AppMethodBeat.o(175710);
        throw paramWebViewUI;
      }
      paramWebViewUI.height = i;
      this.jac.setLayoutParams(paramWebViewUI);
    }
    if (!KeyBoardUtil.isPortOrientation(paramContext)) {
      aoX(2);
    }
    this.Qxt.setOnClickListener((View.OnClickListener)new n.5(this));
    this.Qxu.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82697);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if (n.j(this.QxO))
        {
          paramAnonymousView = n.b(this.QxO).getText().toString();
          localObject = this.QxO.getWebView().PvJ;
          if (localObject != null) {
            ((com.tencent.mm.plugin.webview.d.h)localObject).y(1, paramAnonymousView, 1);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(82697);
          return;
          this.QxO.getWebView().hideVKB();
          if (n.d(this.QxO).fXU()) {
            n.d(this.QxO).aDK();
          }
          paramAnonymousView = new fm();
          paramAnonymousView.content = n.b(this.QxO).getText().toString();
          paramAnonymousView.tpK = 1;
          if (n.k(this.QxO) != 0)
          {
            paramAnonymousView.tpK = 3;
            paramAnonymousView.RKB = n.k(this.QxO);
          }
          this.QxO.a(paramAnonymousView);
          com.tencent.mm.plugin.webview.i.a.aoc(10);
        }
      }
    });
    this.Qxv.addTextChangedListener((TextWatcher)new n.7(this));
    paramWebViewUI = this.Qxu;
    paramContext = this.Qxv.getText();
    p.j(paramContext, "contentEt.text");
    if (((CharSequence)paramContext).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramWebViewUI.setEnabled(bool);
      this.Qxv.setOnTouchListener((View.OnTouchListener)new n.8(this));
      this.QxA.setVisibility(8);
      AppMethodBeat.o(175710);
      return;
    }
  }
  
  private final void aoX(int paramInt)
  {
    AppMethodBeat.i(82729);
    switch (paramInt)
    {
    default: 
      if (this.Qfa.gXJ()) {
        aoY(this.Qfa.getKeyBoardHeight());
      }
      break;
    }
    for (;;)
    {
      this.Qxv.setMinLines(5);
      AppMethodBeat.o(82729);
      return;
      paramInt = ax.getStatusBarHeight(getContext());
      setRootHeight(ax.au(getContext()).y - paramInt);
      this.Qxv.setMinLines(3);
      AppMethodBeat.o(82729);
      return;
      if (this.QxD != 0) {
        setRootHeight(this.QxD);
      } else {
        aoY(0);
      }
    }
  }
  
  private final void aoY(int paramInt)
  {
    AppMethodBeat.i(82730);
    Object localObject = this.jac.getLayoutParams();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(82730);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.LayoutParams)localObject).height = (this.Qxv.getHeight() + this.mUs.getHeight() + getNavHeightByDisplay() + com.tencent.mm.ci.a.fromDPToPix(getContext(), com.tencent.mm.ci.a.H(getContext(), 60) + 16) + getReplyHeight() + paramInt);
    ((ViewGroup.LayoutParams)localObject).height = aoZ(((ViewGroup.LayoutParams)localObject).height);
    this.jac.setLayoutParams((ViewGroup.LayoutParams)localObject);
    apa(((ViewGroup.LayoutParams)localObject).height);
    AppMethodBeat.o(82730);
  }
  
  private final int aoZ(int paramInt)
  {
    AppMethodBeat.i(82732);
    int j = ax.getStatusBarHeight(getContext());
    int k = ax.au(getContext()).y;
    int i = k - j;
    if (paramInt > i) {}
    for (;;)
    {
      AppMethodBeat.o(82732);
      return i;
      i = paramInt;
      if (this.QxF > 0)
      {
        int m = com.tencent.mm.ci.a.fromDPToPix(getContext(), 20);
        i = paramInt;
        if (paramInt < k - this.QxF - j + m) {
          i = k - j - this.QxF + m;
        }
      }
    }
  }
  
  private final void apa(int paramInt)
  {
    AppMethodBeat.i(82733);
    if (KeyBoardUtil.isPortOrientation(getContext())) {
      this.QxD = paramInt;
    }
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("MPWriteCommentLayout");
    localMultiProcessMMKV.encode("MPWriteCommentRootHeight", paramInt);
    localMultiProcessMMKV.apply();
    AppMethodBeat.o(82733);
  }
  
  private final int getNavHeightByDisplay()
  {
    AppMethodBeat.i(82739);
    Point localPoint = ax.au(getContext());
    Object localObject = this.QxM.getWindow();
    if (localObject != null) {}
    for (localObject = ((Window)localObject).getDecorView();; localObject = null)
    {
      Rect localRect = new Rect();
      if (localObject != null) {
        ((View)localObject).getWindowVisibleDisplayFrame(localRect);
      }
      int i = localRect.bottom;
      int j = localPoint.y - i - this.Qfa.getKeyBoardHeight();
      Log.v(TAG, "getNavHeightByDisplay screenHeight = " + i + ", realSize = " + localPoint.y);
      i = j;
      if (j < 0)
      {
        i = ax.aB(getContext());
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
    if (this.QxE != 0)
    {
      int i = com.tencent.mm.ci.a.fromDPToPix(getContext(), 38);
      AppMethodBeat.o(182681);
      return i;
    }
    AppMethodBeat.o(182681);
    return 0;
  }
  
  private final int getRootHeight()
  {
    AppMethodBeat.i(82734);
    int i = com.tencent.mm.ci.a.fromDPToPix(getContext(), 635);
    AppMethodBeat.o(82734);
    return i;
  }
  
  private final void hbY()
  {
    AppMethodBeat.i(82723);
    View localView = this.Qxx;
    int i = c.b.comment_panel_background_color;
    Context localContext = getContext();
    p.j(localContext, "context");
    localView.setBackgroundColor(o.g(i, localContext));
    this.Qxy.setVisibility(8);
    AppMethodBeat.o(82723);
  }
  
  private void hbZ()
  {
    AppMethodBeat.i(175703);
    this.Qxv.setText((CharSequence)"");
    this.QxJ = 0;
    getAppMsgCommentList();
    AppMethodBeat.o(175703);
  }
  
  private final void hca()
  {
    AppMethodBeat.i(182680);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(250L);
    localTranslateAnimation.setFillAfter(false);
    this.jac.clearAnimation();
    this.jac.startAnimation((Animation)localTranslateAnimation);
    AppMethodBeat.o(182680);
  }
  
  private final void hcb()
  {
    AppMethodBeat.i(82737);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    localTranslateAnimation.setDuration(150L);
    localTranslateAnimation.setFillAfter(false);
    localTranslateAnimation.setAnimationListener((Animation.AnimationListener)new g(this));
    this.jac.clearAnimation();
    this.jac.startAnimation((Animation)localTranslateAnimation);
    AppMethodBeat.o(82737);
  }
  
  private final void setRootHeight(int paramInt)
  {
    AppMethodBeat.i(82731);
    Object localObject = this.jac.getLayoutParams();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(82731);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.LayoutParams)localObject).height = aoZ(paramInt);
    this.jac.setLayoutParams((ViewGroup.LayoutParams)localObject);
    apa(((ViewGroup.LayoutParams)localObject).height);
    AppMethodBeat.o(82731);
  }
  
  private final void show()
  {
    AppMethodBeat.i(82735);
    this.jac.clearAnimation();
    setVisibility(0);
    hca();
    AppMethodBeat.o(82735);
  }
  
  public final void B(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(175705);
    p.k(paramString, "replyContent");
    this.QxE = paramInt;
    this.Qxz.setText((CharSequence)getContext().getString(c.i.biz_comment_write_reply));
    this.QxA.setVisibility(0);
    TextView localTextView = this.QxA;
    Context localContext = getContext();
    paramInt = c.i.biz_comment_reply_personal;
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = "";
    }
    localTextView.setText((CharSequence)localContext.getString(paramInt, new Object[] { str }));
    this.Qxv.setHint((CharSequence)getContext().getString(c.i.biz_comment_reply_hint));
    if (paramBoolean)
    {
      this.Qxx.scrollTo(0, 0);
      this.Qxv.requestFocus();
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
        paramString.showSoftInput((View)this.Qxv, 0);
        AppMethodBeat.o(175705);
        return;
      }
    }
    AppMethodBeat.o(175705);
  }
  
  public final void Bv(int paramInt)
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
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(19265, str1);
    AppMethodBeat.o(175709);
  }
  
  public final void Du(boolean paramBoolean)
  {
    AppMethodBeat.i(82725);
    Bv(1);
    Dw(false);
    Dv(paramBoolean);
    AppMethodBeat.o(82725);
  }
  
  public final void Dv(boolean paramBoolean)
  {
    AppMethodBeat.i(175702);
    this.QxC = paramBoolean;
    show();
    if (paramBoolean)
    {
      this.Qxy.setVisibility(8);
      this.Qxz.setText((CharSequence)getContext().getString(c.i.biz_video_share_to_wow));
      this.Qxv.setHint(c.i.biz_video_share_to_wow_hint);
      this.Qxu.setText(c.i.app_send);
      localObject = this.Qxu;
      localContext = getContext();
      p.j(localContext, "context");
      ((Button)localObject).setBackground(localContext.getResources().getDrawable(c.e.biz_video_btn_solid_yellow_small));
      localObject = (InputFilter)new InputFilter.LengthFilter(200);
      this.Qxv.setFilters(new InputFilter[] { localObject });
      AppMethodBeat.o(175702);
      return;
    }
    getAppMsgCommentList();
    this.Qxu.setText(c.i.biz_video_commit_comment);
    Object localObject = this.Qxu;
    int i = c.b.comment_panel_action_button_style_selector;
    Context localContext = getContext();
    p.j(localContext, "context");
    ((Button)localObject).setBackground(o.f(i, localContext));
    AppMethodBeat.o(175702);
  }
  
  public final void Dw(boolean paramBoolean)
  {
    AppMethodBeat.i(175707);
    if (this.QxE != 0)
    {
      this.QxE = 0;
      if (paramBoolean) {
        aoX(KeyBoardUtil.getScreenOrientation(getContext()));
      }
    }
    this.QxA.setText((CharSequence)"");
    this.QxA.setVisibility(8);
    this.Qxv.setHint((CharSequence)getContext().getString(c.i.biz_video_write_comment_hint));
    this.Qxz.setText((CharSequence)getContext().getString(c.i.biz_video_write_comment));
    AppMethodBeat.o(175707);
  }
  
  public final void a(fm paramfm)
  {
    AppMethodBeat.i(82741);
    p.k(paramfm, "req");
    paramfm.scene = this.scene;
    paramfm.RJZ = this.wGA;
    paramfm.url = this.url;
    paramfm.title = this.title;
    paramfm.RKE = System.currentTimeMillis();
    paramfm.RKb = this.llp;
    paramfm.session_id = this.QxG;
    paramfm.RKa = this.QtB;
    paramfm.RKc = this.lqf;
    Object localObject = new com.tencent.mm.an.d.a();
    ((com.tencent.mm.an.d.a)localObject).c((com.tencent.mm.cd.a)paramfm);
    ((com.tencent.mm.an.d.a)localObject).d((com.tencent.mm.cd.a)new fn());
    ((com.tencent.mm.an.d.a)localObject).TW("/cgi-bin/mmbiz-bin/appmsg/appmsg_operate_comment");
    ((com.tencent.mm.an.d.a)localObject).vD(2617);
    ((com.tencent.mm.an.d.a)localObject).vF(0);
    ((com.tencent.mm.an.d.a)localObject).vG(0);
    IPCRunCgi.a(((com.tencent.mm.an.d.a)localObject).bgN(), (IPCRunCgi.a)new e(this));
    paramfm = this.QxM;
    localObject = com.tencent.mm.plugin.webview.k.d.QzO;
    localObject = getContext().getString(c.i.app_waiting);
    p.j(localObject, "context.getString(R.string.app_waiting)");
    Context localContext = getContext();
    p.j(localContext, "context");
    paramfm.b(com.tencent.mm.plugin.webview.k.d.a((String)localObject, localContext, this.QxM.gYu()));
    AppMethodBeat.o(82741);
  }
  
  public final boolean bVd()
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
  
  public final void bnl(String paramString)
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
    ff localff = new ff();
    localff.url = this.url;
    if (this.QxI)
    {
      AppMethodBeat.o(82740);
      return;
    }
    localff.offset = this.QxJ;
    if (this.QxJ == -1)
    {
      Log.i(TAG, "no more my comment");
      AppMethodBeat.o(82740);
      return;
    }
    this.QxI = true;
    localff.tpK = 2;
    localff.scene = this.scene;
    localff.RJZ = this.wGA;
    localff.RKb = this.llp;
    localff.session_id = this.QxG;
    localff.RKa = this.QtB;
    localff.RKc = this.lqf;
    com.tencent.mm.an.d.a locala = new com.tencent.mm.an.d.a();
    locala.c((com.tencent.mm.cd.a)localff);
    locala.d((com.tencent.mm.cd.a)new fg());
    locala.TW("/cgi-bin/mmbiz-bin/appmsg/appmsg_comment_list");
    locala.vD(2866);
    locala.vF(0);
    locala.vG(0);
    IPCRunCgi.a(locala.bgN(), (IPCRunCgi.a)new f(this));
    com.tencent.mm.plugin.webview.i.a.aoc(7);
    AppMethodBeat.o(82740);
  }
  
  public final n.c getCallback()
  {
    return this.QxH;
  }
  
  public final long getCommentTopicId()
  {
    return this.lqf;
  }
  
  public final int getEnterId()
  {
    return this.QtB;
  }
  
  public final int getItemShowType()
  {
    return this.llp;
  }
  
  public final int getMinHeaderHeight()
  {
    return this.QxF;
  }
  
  public final int getMyCommentOffset()
  {
    return this.QxJ;
  }
  
  final MPSmileyFooter getSayFooter()
  {
    AppMethodBeat.i(82721);
    MPSmileyFooter localMPSmileyFooter = (MPSmileyFooter)this.Qxs.getValue();
    AppMethodBeat.o(82721);
    return localMPSmileyFooter;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final int getSubScene()
  {
    return this.wGA;
  }
  
  public final int getTimeLineSessionId()
  {
    return this.QxG;
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
    return this.sgE;
  }
  
  public final WebViewUI getWebView()
  {
    return this.QxM;
  }
  
  public final boolean hcc()
  {
    AppMethodBeat.i(175708);
    if (!this.QxK) {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vAD, 0) != 1) {
        break label86;
      }
    }
    label86:
    for (boolean bool = true;; bool = false)
    {
      this.QxL = bool;
      this.QxK = true;
      Log.v(TAG, "isReplyOpen = " + this.QxL);
      bool = this.QxL;
      AppMethodBeat.o(175708);
      return bool;
    }
  }
  
  public final void hide()
  {
    AppMethodBeat.i(82736);
    if (!bVd())
    {
      AppMethodBeat.o(82736);
      return;
    }
    if (getSayFooter().fXU()) {
      getSayFooter().aDK();
    }
    hcb();
    this.QxM.hideVKB();
    this.QxJ = 0;
    b localb = this.QxB;
    if (localb != null)
    {
      localb.clear();
      AppMethodBeat.o(82736);
      return;
    }
    AppMethodBeat.o(82736);
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(82728);
    p.k(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    aoX(paramConfiguration.orientation);
    if (getSayFooter().fXU()) {
      getSayFooter().aDK();
    }
    AppMethodBeat.o(82728);
  }
  
  public final void setCallback(n.c paramc)
  {
    this.QxH = paramc;
  }
  
  public final void setCommentTopicId(long paramLong)
  {
    this.lqf = paramLong;
  }
  
  public final void setEnterId(int paramInt)
  {
    this.QtB = paramInt;
  }
  
  public final void setItemShowType(int paramInt)
  {
    this.llp = paramInt;
  }
  
  public final void setMinHeaderHeight(int paramInt)
  {
    this.QxF = paramInt;
  }
  
  public final void setMyCommentOffset(int paramInt)
  {
    this.QxJ = paramInt;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public final void setSubScene(int paramInt)
  {
    this.wGA = paramInt;
  }
  
  public final void setTimeLineSessionId(int paramInt)
  {
    this.QxG = paramInt;
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
    p.k(paramWeakReference, "<set-?>");
    this.sgE = paramWeakReference;
    AppMethodBeat.o(82722);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "controller", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "isDarkPanel", "", "(Landroid/content/Context;Ljava/util/LinkedList;Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;Z)V", "getController", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "setController", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;)V", "viewPool", "Ljava/util/ArrayList;", "Landroid/view/View;", "getViewPool", "()Ljava/util/ArrayList;", "clear", "", "getCommentView", "getCount", "", "getItem", "position", "getItemId", "", "i", "getLastInvalidReply", "", "info", "getView", "convertView", "viewGroup", "Landroid/view/ViewGroup;", "onDeleteComment", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "onDeleteCommentReply", "showLikeStatus", "itemView", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "reply", "Lcom/tencent/mm/protocal/protobuf/CommentReply;", "isReply", "update", "items", "", "clearUpdate", "updateCommentContentView", "updateReplyView", "index", "BizCommentContent", "BizCommentViewHolder", "Companion", "plugin-webview_release"})
  public static final class b
    extends BaseAdapter
  {
    private static com.tencent.mm.ay.a.a.c QxT;
    public static final n.b.c QxU;
    static final String TAG = "MicroMsg.MPMyCommentItemAdapter";
    final ArrayList<View> QxQ;
    n QxR;
    private boolean QxS;
    private final Context context;
    final LinkedList<nv> jmy;
    
    static
    {
      AppMethodBeat.i(82709);
      QxU = new n.b.c((byte)0);
      TAG = "MicroMsg.MPMyCommentItemAdapter";
      QxT = new c.a().wz(c.c.chatting_item_biz_default_bg).bmF().dO(120, 120).a((com.tencent.mm.ay.a.c.c)new com.tencent.mm.pluginsdk.ui.applet.n()).a((com.tencent.mm.ay.a.c.a)new e()).bmJ().aw(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 3)).bmL();
      AppMethodBeat.o(82709);
    }
    
    public b(Context paramContext, LinkedList<nv> paramLinkedList, n paramn, boolean paramBoolean)
    {
      AppMethodBeat.i(162324);
      this.context = paramContext;
      this.jmy = paramLinkedList;
      this.QxR = paramn;
      this.QxS = paramBoolean;
      this.QxQ = new ArrayList();
      AppMethodBeat.o(162324);
    }
    
    public static String a(nv paramnv)
    {
      AppMethodBeat.i(182678);
      p.k(paramnv, "info");
      String str = paramnv.content;
      int i;
      if ((paramnv.RUH != null) && (!Util.isNullOrNil((List)paramnv.RUH.Sog)))
      {
        i = paramnv.RUH.Sog.size() - 1;
        if (i >= 0) {
          if (((acl)paramnv.RUH.Sog.get(i)).Sof != 0) {}
        }
      }
      for (paramnv = ((acl)paramnv.RUH.Sog.get(i)).content;; paramnv = str)
      {
        p.j(paramnv, "reply");
        AppMethodBeat.o(182678);
        return paramnv;
        i -= 1;
        break;
      }
    }
    
    private void a(final a parama, final nv paramnv, final acl paramacl, final boolean paramBoolean)
    {
      AppMethodBeat.i(175697);
      p.k(parama, "itemView");
      p.k(paramnv, "info");
      Object localObject;
      Integer localInteger1;
      label55:
      Integer localInteger2;
      label73:
      String str1;
      label105:
      int i;
      if (paramBoolean) {
        if (paramacl != null)
        {
          localObject = Integer.valueOf(paramacl.Soe);
          if (!paramBoolean) {
            break label352;
          }
          if (paramacl == null) {
            break label346;
          }
          localInteger1 = Integer.valueOf(paramacl.Soc);
          if (!paramBoolean) {
            break label370;
          }
          if (paramacl == null) {
            break label364;
          }
          localInteger2 = Integer.valueOf(paramacl.Sod);
          String str2 = TAG;
          StringBuilder localStringBuilder = new StringBuilder("showLikeStatus content = ");
          if (!paramBoolean) {
            break label388;
          }
          if (paramacl == null) {
            break label382;
          }
          str1 = paramacl.content;
          Log.v(str2, str1 + ", isElected = " + localObject + ", likeNum = " + localInteger1 + ", likeStatus = " + localInteger2);
          parama.QxY.setOnClickListener(null);
          if (localObject != null) {
            break label397;
          }
          label166:
          localObject = parama.Qya;
          p.j(localObject, "itemView.notChosen");
          ((TextView)localObject).setVisibility(8);
          localObject = parama.QxY;
          p.j(localObject, "itemView.likeThumb");
          ((ImageView)localObject).setVisibility(0);
          localObject = parama.kEc;
          p.j(localObject, "itemView.likeTv");
          ((TextView)localObject).setVisibility(8);
          if (localInteger1 != null)
          {
            localObject = parama.kEc;
            p.j(localObject, "itemView.likeTv");
            if (localInteger1.intValue() <= 0) {
              break label465;
            }
            i = 0;
            label258:
            ((TextView)localObject).setVisibility(i);
            parama.kEc.setText((CharSequence)String.valueOf(localInteger1.intValue()));
          }
          if (localInteger2 != null) {
            break label472;
          }
          label288:
          parama.QxY.setImageResource(c.h.approve_highlight);
        }
      }
      for (;;)
      {
        parama.QxY.setOnClickListener((View.OnClickListener)new d(this, paramBoolean, paramacl, paramnv, parama));
        AppMethodBeat.o(175697);
        return;
        localObject = null;
        break;
        localObject = Integer.valueOf(paramnv.RUE);
        break;
        label346:
        localInteger1 = null;
        break label55;
        label352:
        localInteger1 = Integer.valueOf(paramnv.RUF);
        break label55;
        label364:
        localInteger2 = null;
        break label73;
        label370:
        localInteger2 = Integer.valueOf(paramnv.RUG);
        break label73;
        label382:
        str1 = null;
        break label105;
        label388:
        str1 = paramnv.content;
        break label105;
        label397:
        if (((Integer)localObject).intValue() != 0) {
          break label166;
        }
        paramnv = parama.Qya;
        p.j(paramnv, "itemView.notChosen");
        paramnv.setVisibility(0);
        paramnv = parama.QxY;
        p.j(paramnv, "itemView.likeThumb");
        paramnv.setVisibility(8);
        parama = parama.kEc;
        p.j(parama, "itemView.likeTv");
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
        parama.QxY.setImageResource(c.h.approve_default);
      }
    }
    
    private nv apb(int paramInt)
    {
      AppMethodBeat.i(82704);
      nv localnv = (nv)j.M((List)this.jmy, paramInt);
      AppMethodBeat.o(82704);
      return localnv;
    }
    
    public final void clear()
    {
      AppMethodBeat.i(82703);
      this.jmy.clear();
      notifyDataSetChanged();
      AppMethodBeat.o(82703);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(82706);
      int i = this.jmy.size();
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
      p.k(paramViewGroup, "viewGroup");
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.context).inflate(c.g.mp_comment_view_item, null, false);
        p.j(paramView, "convertView");
        paramViewGroup = new b(paramView);
        paramView.setTag(paramViewGroup);
      }
      final nv localnv;
      Object localObject2;
      Object localObject1;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      for (;;)
      {
        localnv = apb(paramInt);
        if (localnv == null) {
          break label1446;
        }
        p.k(localnv, "info");
        com.tencent.mm.ay.a.a.bms().a(localnv.llI, paramViewGroup.mWb, QxT);
        localObject2 = paramViewGroup.Qyd;
        localObject1 = paramViewGroup.Qyg;
        p.k(localObject1, "itemView");
        if (localnv != null)
        {
          localObject3 = ((b)localObject2).context;
          localObject4 = (CharSequence)localnv.ueW;
          localObject5 = ((a)localObject1).txD;
          p.j(localObject5, "itemView.nickName");
          localObject3 = com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject3, (CharSequence)localObject4, ((TextView)localObject5).getTextSize());
          localObject4 = ((a)localObject1).txD;
          p.j(localObject4, "itemView.nickName");
          ((TextView)localObject4).setText((CharSequence)localObject3);
          localObject3 = ((b)localObject2).context;
          localObject4 = (CharSequence)localnv.content;
          localObject5 = ((a)localObject1).QxV;
          p.j(localObject5, "itemView.desc");
          localObject3 = com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject3, (CharSequence)localObject4, ((NeatTextView)localObject5).getTextSize());
          ((a)localObject1).QxV.aL((CharSequence)localObject3);
          ((a)localObject1).QxW.setIconColor(((b)localObject2).context.getResources().getColor(c.c.Link));
          localObject3 = ((a)localObject1).QxW;
          p.j(localObject3, "itemView.deleteIv");
          ((WeImageView)localObject3).setVisibility(0);
          localObject3 = ((a)localObject1).QxX;
          p.j(localObject3, "itemView.deleteSplit");
          ((ImageView)localObject3).setVisibility(0);
          ((a)localObject1).QxW.setOnClickListener((View.OnClickListener)new e((b)localObject2, localnv));
          ((b)localObject2).a((a)localObject1, localnv, null, false);
          localObject2 = ((a)localObject1).Qyb;
          p.j(localObject2, "itemView.replyPrefix");
          ((ImageView)localObject2).setVisibility(8);
          localObject1 = ((a)localObject1).Qyc;
          p.j(localObject1, "itemView.sameReplyPrefix");
          ((ImageView)localObject1).setVisibility(4);
        }
        localObject1 = paramViewGroup.Qyh;
        p.j(localObject1, "txtReply");
        ((TextView)localObject1).setVisibility(8);
        if (!n.a(paramViewGroup.Qyd.QxR)) {
          break label1446;
        }
        localObject1 = paramViewGroup.Qyh;
        p.j(localObject1, "txtReply");
        ((TextView)localObject1).setVisibility(0);
        paramViewGroup.Qyh.setOnClickListener((View.OnClickListener)new n.b.b.a(paramViewGroup, localnv));
        localObject1 = ((Iterable)paramViewGroup.kMd).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (View)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            paramViewGroup.KNS.removeView((View)localObject2);
            paramViewGroup.Qyd.QxQ.add(localObject2);
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
      paramViewGroup.kMd.clear();
      int i;
      if ((localnv.RUH != null) && (localnv.RUH.Sog != null) && (localnv.RUH.Sog.size() > 0))
      {
        localObject1 = localnv.RUH.Sog;
        p.j(localObject1, "replyList");
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
            j.iBO();
          }
          localObject3 = (acl)localObject1;
          localObject1 = paramViewGroup.Qyd;
          label719:
          Context localContext;
          CharSequence localCharSequence;
          Object localObject6;
          if (((b)localObject1).QxQ.size() > 0)
          {
            localObject1 = ((b)localObject1).QxQ.remove(0);
            p.j(localObject1, "viewPool.removeAt(0)");
            localObject1 = (View)localObject1;
            paramViewGroup.kMd.add(localObject1);
            paramViewGroup.KNS.addView((View)localObject1);
            localObject4 = paramViewGroup.Qyd;
            p.j(localObject3, "reply");
            localObject1 = new a(paramViewGroup.Qyd, (View)localObject1);
            p.k(localObject3, "reply");
            p.k(localObject1, "itemView");
            if (localnv == null) {
              break label1509;
            }
            localObject5 = (kotlin.g.a.b)new g((b)localObject4, (a)localObject1, localnv);
            if (p.h(localnv.openid, ((acl)localObject3).openid) != true) {
              break label1222;
            }
            if (!((Boolean)((kotlin.g.a.b)localObject5).invoke(Integer.valueOf(((acl)localObject3).Sof))).booleanValue())
            {
              localObject5 = ((a)localObject1).txD;
              p.j(localObject5, "itemView.nickName");
              localContext = ((b)localObject4).context;
              localCharSequence = (CharSequence)localnv.ueW;
              localObject6 = ((a)localObject1).txD;
              p.j(localObject6, "itemView.nickName");
              ((TextView)localObject5).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(localContext, localCharSequence, ((TextView)localObject6).getTextSize()));
              localObject5 = ((a)localObject1).QxV;
              localContext = ((b)localObject4).context;
              localCharSequence = (CharSequence)((acl)localObject3).content;
              localObject6 = ((a)localObject1).QxV;
              p.j(localObject6, "itemView.desc");
              ((NeatTextView)localObject5).aL((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(localContext, localCharSequence, ((NeatTextView)localObject6).getTextSize()));
              ((a)localObject1).QxW.setIconColor(((b)localObject4).context.getResources().getColor(c.c.Link));
              localObject5 = ((a)localObject1).QxW;
              p.j(localObject5, "itemView.deleteIv");
              ((WeImageView)localObject5).setVisibility(0);
              localObject5 = ((a)localObject1).QxX;
              p.j(localObject5, "itemView.deleteSplit");
              ((ImageView)localObject5).setVisibility(0);
              ((b)localObject4).a((a)localObject1, localnv, (acl)localObject3, true);
              ((a)localObject1).QxW.setOnClickListener((View.OnClickListener)new f((b)localObject4, localnv, (acl)localObject3));
            }
            label1073:
            localObject4 = ((a)localObject1).Qyb;
            p.j(localObject4, "itemView.replyPrefix");
            ((ImageView)localObject4).setVisibility(0);
            localObject4 = ((a)localObject1).Qyc;
            p.j(localObject4, "itemView.sameReplyPrefix");
            ((ImageView)localObject4).setVisibility(4);
            if (i + 1 < localnv.RUH.Sog.size())
            {
              localObject1 = ((a)localObject1).Qyc;
              p.j(localObject1, "itemView.sameReplyPrefix");
              if (!p.h(((acl)localObject3).openid, ((acl)localnv.RUH.Sog.get(i + 1)).openid)) {
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
            localObject1 = View.inflate(((b)localObject1).context, c.g.mp_comment_content_item, null);
            p.j(localObject1, "View.inflate(context, R.…mment_content_item, null)");
            break label719;
            label1222:
            if (((Boolean)((kotlin.g.a.b)localObject5).invoke(Integer.valueOf(((acl)localObject3).Sof))).booleanValue()) {
              break label1073;
            }
            localObject5 = ((a)localObject1).txD;
            p.j(localObject5, "itemView.nickName");
            localContext = ((b)localObject4).context;
            localCharSequence = (CharSequence)((b)localObject4).context.getResources().getString(c.i.mp_author);
            localObject6 = ((a)localObject1).txD;
            p.j(localObject6, "itemView.nickName");
            ((TextView)localObject5).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(localContext, localCharSequence, ((TextView)localObject6).getTextSize()));
            localObject5 = ((a)localObject1).QxV;
            localContext = ((b)localObject4).context;
            localCharSequence = (CharSequence)((acl)localObject3).content;
            localObject6 = ((a)localObject1).QxV;
            p.j(localObject6, "itemView.desc");
            ((NeatTextView)localObject5).aL((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(localContext, localCharSequence, ((NeatTextView)localObject6).getTextSize()));
            localObject5 = ((a)localObject1).QxW;
            p.j(localObject5, "itemView.deleteIv");
            ((WeImageView)localObject5).setVisibility(8);
            localObject5 = ((a)localObject1).QxX;
            p.j(localObject5, "itemView.deleteSplit");
            ((ImageView)localObject5).setVisibility(8);
            ((b)localObject4).a((a)localObject1, localnv, (acl)localObject3, true);
            break label1073;
          }
        }
        else
        {
          label1446:
          if (paramInt == getCount() - 1)
          {
            paramViewGroup = paramViewGroup.Qyf;
            p.j(paramViewGroup, "holder.endlineLayout");
            paramViewGroup.setVisibility(0);
            this.QxR.getAppMsgCommentList();
          }
          for (;;)
          {
            AppMethodBeat.o(82707);
            return paramView;
            paramViewGroup = paramViewGroup.Qyf;
            p.j(paramViewGroup, "holder.endlineLayout");
            paramViewGroup.setVisibility(8);
          }
        }
        label1509:
        i = j;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;Landroid/view/View;)V", "deleteIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getDeleteIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setDeleteIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "deleteSplit", "Landroid/widget/ImageView;", "getDeleteSplit", "()Landroid/widget/ImageView;", "desc", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "getDesc", "()Lcom/tencent/neattextview/textview/view/NeatTextView;", "setDesc", "(Lcom/tencent/neattextview/textview/view/NeatTextView;)V", "likeThumb", "getLikeThumb", "likeTv", "Landroid/widget/TextView;", "getLikeTv", "()Landroid/widget/TextView;", "setLikeTv", "(Landroid/widget/TextView;)V", "nickName", "getNickName", "setNickName", "notChosen", "getNotChosen", "replyDelete", "getReplyDelete", "replyPrefix", "getReplyPrefix", "sameReplyPrefix", "getSameReplyPrefix", "plugin-webview_release"})
    public final class a
    {
      NeatTextView QxV;
      WeImageView QxW;
      final ImageView QxX;
      final ImageView QxY;
      final TextView QxZ;
      final TextView Qya;
      final ImageView Qyb;
      final ImageView Qyc;
      TextView kEc;
      TextView txD;
      
      public a()
      {
        AppMethodBeat.i(82699);
        this.txD = ((TextView)((View)localObject).findViewById(c.f.biz_video_comment_nickname_tv));
        this.kEc = ((TextView)((View)localObject).findViewById(c.f.biz_video_comment_like_tv));
        this.QxV = ((NeatTextView)((View)localObject).findViewById(c.f.biz_video_comment_content_tv));
        this.QxW = ((WeImageView)((View)localObject).findViewById(c.f.biz_video_comment_delete_tv));
        this.QxX = ((ImageView)((View)localObject).findViewById(c.f.biz_comment_delete_split));
        this.QxY = ((ImageView)((View)localObject).findViewById(c.f.biz_comment_like_thumb));
        this.QxZ = ((TextView)((View)localObject).findViewById(c.f.biz_comment_reply_delete));
        this.Qya = ((TextView)((View)localObject).findViewById(c.f.biz_comment_not_chosen));
        this.Qyb = ((ImageView)((View)localObject).findViewById(c.f.biz_reply_prefix));
        this.Qyc = ((ImageView)((View)localObject).findViewById(c.f.biz_same_reply_prefix));
        this$1 = ((View)localObject).getContext();
        Object localObject = this.QxV;
        int i = c.b.comment_panel_text_color;
        p.j(n.b.this, "context");
        ((NeatTextView)localObject).setTextColor(o.g(i, n.b.this));
        AppMethodBeat.o(82699);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentViewHolder;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAvatar", "()Landroid/widget/ImageView;", "commentList", "Ljava/util/ArrayList;", "getCommentList", "()Ljava/util/ArrayList;", "content", "Landroid/widget/LinearLayout;", "getContent", "()Landroid/widget/LinearLayout;", "endlineLayout", "getEndlineLayout", "setEndlineLayout", "(Landroid/widget/LinearLayout;)V", "fansContent", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;", "getFansContent", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "setFansContent", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;)V", "fansLayout", "getFansLayout", "setFansLayout", "txtReply", "Landroid/widget/TextView;", "getTxtReply", "()Landroid/widget/TextView;", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "plugin-webview_release"})
    public final class b
    {
      final LinearLayout KNS;
      private LinearLayout Qye;
      LinearLayout Qyf;
      n.b.a Qyg;
      final TextView Qyh;
      final ArrayList<View> kMd;
      final ImageView mWb;
      
      public b()
      {
        AppMethodBeat.i(82700);
        this.mWb = ((ImageView)localObject.findViewById(c.f.biz_video_avatar_iv));
        this.KNS = ((LinearLayout)localObject.findViewById(c.f.biz_video_comment_content_layout));
        this.Qye = ((LinearLayout)localObject.findViewById(c.f.biz_video_fans_comment_layout));
        this.Qyf = ((LinearLayout)localObject.findViewById(c.f.end_line_layout));
        LinearLayout localLinearLayout = this.Qye;
        p.j(localLinearLayout, "fansLayout");
        this.Qyg = new n.b.a(n.b.this, (View)localLinearLayout);
        this.Qyh = ((TextView)localObject.findViewById(c.f.biz_comment_reply));
        this.kMd = new ArrayList();
        AppMethodBeat.o(82700);
      }
      
      @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
      static final class a
        implements View.OnClickListener
      {
        a(n.b.b paramb, nv paramnv) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(175691);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentViewHolder$update$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          this.Qyi.Qyd.QxR.Bv(3);
          this.Qyi.Qyd.QxR.B(n.b.a(this.Qyj), this.Qyj.RKB, true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentViewHolder$update$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(175691);
        }
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d
      implements View.OnClickListener
    {
      d(n.b paramb, boolean paramBoolean, acl paramacl, nv paramnv, n.b.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(175692);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$showLikeStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        n.b(this.Qyd.QxR).clearFocus();
        int i;
        if (paramBoolean)
        {
          paramView = paramacl;
          if (paramView != null)
          {
            paramView = Integer.valueOf(paramView.Soc);
            if (paramView == null) {
              p.iCn();
            }
            i = paramView.intValue();
            label86:
            if (!paramBoolean) {
              break label545;
            }
            paramView = paramacl;
            if (paramView == null) {
              break label540;
            }
            paramView = Integer.valueOf(paramView.Sod);
            label110:
            if (paramView != null) {
              break label559;
            }
            label114:
            parama.QxY.setImageResource(c.h.approve_default);
            i -= 1;
            label131:
            if (i >= 0) {
              break label647;
            }
            i = 0;
          }
        }
        label647:
        for (;;)
        {
          parama.kEc.setText((CharSequence)String.valueOf(i));
          localObject = parama.kEc;
          p.j(localObject, "itemView.likeTv");
          int j;
          if (i > 0)
          {
            j = 0;
            label176:
            ((TextView)localObject).setVisibility(j);
            fk localfk = new fk();
            localfk.RKB = paramnv.RKB;
            localfk.openid = paramnv.openid;
            localfk.tpK = 1;
            if (paramBoolean)
            {
              localObject = paramacl;
              if (localObject == null) {
                break label592;
              }
              localObject = Integer.valueOf(((acl)localObject).RKD);
              label249:
              if (localObject == null) {
                p.iCn();
              }
              localfk.RKD = ((Integer)localObject).intValue();
              localfk.tpK = 2;
            }
            if (paramView != null) {
              break label598;
            }
            label277:
            j = 0;
            label279:
            localfk.RKC = j;
            localObject = this.Qyd.QxR;
            p.k(localfk, "req");
            localfk.scene = ((n)localObject).scene;
            localfk.RJZ = ((n)localObject).wGA;
            localfk.url = ((n)localObject).url;
            localfk.RKb = ((n)localObject).llp;
            localfk.session_id = ((n)localObject).QxG;
            localfk.RKa = ((n)localObject).QtB;
            com.tencent.mm.an.d.a locala = new com.tencent.mm.an.d.a();
            locala.c((com.tencent.mm.cd.a)localfk);
            locala.d((com.tencent.mm.cd.a)new fl());
            locala.TW("/cgi-bin/mmbiz-bin/appmsg/appmsg_like_comment");
            locala.vD(2759);
            locala.vF(0);
            locala.vG(0);
            IPCRunCgi.a(locala.bgN(), (IPCRunCgi.a)new n.d((n)localObject));
            if (paramView != null) {
              break label610;
            }
            label460:
            paramView = Integer.valueOf(0);
            label465:
            if (!paramBoolean) {
              break label625;
            }
            localObject = paramacl;
            if (localObject != null) {
              ((acl)localObject).Sod = paramView.intValue();
            }
            paramView = paramacl;
            if (paramView != null) {
              paramView.Soc = i;
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$showLikeStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(175692);
            return;
            paramView = null;
            break;
            i = paramnv.RUF;
            break label86;
            label540:
            paramView = null;
            break label110;
            label545:
            paramView = Integer.valueOf(paramnv.RUG);
            break label110;
            label559:
            if (paramView.intValue() != 0) {
              break label114;
            }
            parama.QxY.setImageResource(c.h.approve_highlight);
            i += 1;
            break label131;
            j = 8;
            break label176;
            label592:
            localObject = null;
            break label249;
            label598:
            if (paramView.intValue() != 0) {
              break label277;
            }
            j = 1;
            break label279;
            label610:
            if (paramView.intValue() != 0) {
              break label460;
            }
            paramView = Integer.valueOf(1);
            break label465;
            label625:
            paramnv.RUG = paramView.intValue();
            paramnv.RUF = i;
          }
        }
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(n.b paramb, nv paramnv) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(82702);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$updateCommentContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        new com.tencent.mm.ui.widget.a.d.a(n.b.a(this.Qyd)).bBc(n.b.a(this.Qyd).getString(c.i.biz_video_delete_comment_confirm)).bBd("").ayl(n.b.a(this.Qyd).getResources().getColor(c.c.Red_100)).ayj(c.i.app_delete).c((DialogInterface.OnClickListener)new a(this)).ayk(c.i.button_cancel).icu().show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$updateCommentContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82702);
      }
      
      @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
      static final class a
        implements DialogInterface.OnClickListener
      {
        a(n.b.e parame) {}
        
        public final void onClick(DialogInterface paramDialogInterface, int paramInt)
        {
          AppMethodBeat.i(82701);
          paramDialogInterface = new fm();
          paramDialogInterface.RKB = this.Qym.Qyj.RKB;
          paramDialogInterface.tpK = 2;
          this.Qym.Qyd.QxR.a(paramDialogInterface);
          com.tencent.mm.plugin.webview.i.a.aoc(13);
          AppMethodBeat.o(82701);
        }
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f
      implements View.OnClickListener
    {
      f(n.b paramb, nv paramnv, acl paramacl) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(175694);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$updateReplyView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        new com.tencent.mm.ui.widget.a.d.a(n.b.a(this.Qyd)).bBc(n.b.a(this.Qyd).getString(c.i.biz_comment_delete_reply_confirm)).bBd("").ayl(n.b.a(this.Qyd).getResources().getColor(c.c.Red_100)).ayj(c.i.app_delete).c((DialogInterface.OnClickListener)new a(this)).ayk(c.i.button_cancel).icu().show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$updateReplyView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(175694);
      }
      
      @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
      static final class a
        implements DialogInterface.OnClickListener
      {
        a(n.b.f paramf) {}
        
        public final void onClick(DialogInterface paramDialogInterface, int paramInt)
        {
          AppMethodBeat.i(175693);
          paramDialogInterface = new fm();
          paramDialogInterface.RKB = this.Qyn.Qyj.RKB;
          paramDialogInterface.RKD = this.Qyn.Qyk.RKD;
          paramDialogInterface.tpK = 4;
          this.Qyn.Qyd.QxR.a(paramDialogInterface);
          com.tencent.mm.plugin.webview.i.a.aoc(13);
          AppMethodBeat.o(175693);
        }
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "", "delFlag", "", "invoke"})
    static final class g
      extends q
      implements kotlin.g.a.b<Integer, Boolean>
    {
      g(n.b paramb, n.b.a parama, nv paramnv)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class d
    implements IPCRunCgi.a
  {
    d(n paramn) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.an.d paramd)
    {
      AppMethodBeat.i(175699);
      MMHandlerThread.postToMainThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(175698);
          Object localObject = com.tencent.mm.plugin.webview.k.d.QzO;
          com.tencent.mm.plugin.webview.k.d.c(this.Qyo.QxO.getWebView().gYu());
          if (this.Qyo.QxO.getWeakThis$plugin_webview_release().get() != null)
          {
            localObject = this.Qyo.QxO.getWeakThis$plugin_webview_release().get();
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
            com.tencent.mm.an.d locald = paramd;
            p.j(locald, "rr");
            n.b((n)localObject, i, j, str, locald);
          }
          AppMethodBeat.o(175698);
        }
      });
      AppMethodBeat.o(175699);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class e
    implements IPCRunCgi.a
  {
    e(n paramn) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.an.d paramd)
    {
      AppMethodBeat.i(82711);
      MMHandlerThread.postToMainThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(82710);
          Object localObject = com.tencent.mm.plugin.webview.k.d.QzO;
          com.tencent.mm.plugin.webview.k.d.c(this.Qyp.QxO.getWebView().gYu());
          if (this.Qyp.QxO.getWeakThis$plugin_webview_release().get() != null)
          {
            localObject = this.Qyp.QxO.getWeakThis$plugin_webview_release().get();
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
            com.tencent.mm.an.d locald = paramd;
            p.j(locald, "rr");
            n.a((n)localObject, i, j, str, locald);
          }
          AppMethodBeat.o(82710);
        }
      });
      AppMethodBeat.o(82711);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class f
    implements IPCRunCgi.a
  {
    f(n paramn) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.an.d paramd)
    {
      AppMethodBeat.i(82713);
      n.f(this.QxO);
      MMHandlerThread.postToMainThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(82712);
          Object localObject = com.tencent.mm.plugin.webview.k.d.QzO;
          com.tencent.mm.plugin.webview.k.d.c(this.Qyq.QxO.getWebView().gYu());
          if (this.Qyq.QxO.getWeakThis$plugin_webview_release().get() != null)
          {
            localObject = this.Qyq.QxO.getWeakThis$plugin_webview_release().get();
            if (localObject == null)
            {
              localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout");
              AppMethodBeat.o(82712);
              throw ((Throwable)localObject);
            }
            localObject = (n)localObject;
            com.tencent.mm.an.d locald = paramd;
            p.j(locald, "rr");
            n.a((n)localObject, locald);
          }
          AppMethodBeat.o(82712);
        }
      });
      if (paramInt1 == 2)
      {
        com.tencent.mm.plugin.webview.i.a.aoc(8);
        AppMethodBeat.o(82713);
        return;
      }
      if (paramInt1 != 0) {
        com.tencent.mm.plugin.webview.i.a.aoc(9);
      }
      AppMethodBeat.o(82713);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$hideAnimation$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "ani", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"})
  public static final class g
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(82714);
      p.k(paramAnimation, "ani");
      paramAnimation = this.QxO.getWeakThis$plugin_webview_release().get();
      if (paramAnimation == null)
      {
        paramAnimation = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout");
        AppMethodBeat.o(82714);
        throw paramAnimation;
      }
      ((n)paramAnimation).setVisibility(8);
      n.e(this.QxO).clearAnimation();
      AppMethodBeat.o(82714);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation) {}
    
    public final void onAnimationStart(Animation paramAnimation) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "state", "", "onKeyBoardStateChange"})
  public static final class h
    implements KeyboardLinearLayout.a
  {
    public h(n paramn) {}
    
    public final void SG(int paramInt)
    {
      AppMethodBeat.i(82717);
      n.a locala = n.QxN;
      Log.i(n.access$getTAG$cp(), "onKeyBoardStateChange, state = ".concat(String.valueOf(paramInt)));
      if (paramInt == -3)
      {
        int i = n.c(this.QxO).getKeyBoardHeight();
        if (i > 0)
        {
          n.a(this.QxO, i);
          n.a(this.QxO, i);
        }
        new MMHandler().postDelayed((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(82715);
            n.d(this.Qyr.QxO).aDG();
            n.d(this.Qyr.QxO).postInvalidate();
            n.e(this.Qyr.QxO).postInvalidate();
            AppMethodBeat.o(82715);
          }
        }, 10L);
      }
      for (;;)
      {
        n.b(this.QxO, paramInt);
        AppMethodBeat.o(82717);
        return;
        n.a(this.QxO, 0);
        n.a(this.QxO, 0);
        new MMHandler().postDelayed((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(82716);
            n.d(this.Qyr.QxO).aDH();
            n.d(this.Qyr.QxO).postInvalidate();
            n.e(this.Qyr.QxO).postInvalidate();
            AppMethodBeat.o(82716);
          }
        }, 10L);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(n paramn) {}
    
    public final void run()
    {
      AppMethodBeat.i(182679);
      n.g(this.QxO);
      Object localObject = this.QxO.getContext().getSystemService("input_method");
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        AppMethodBeat.o(182679);
        throw ((Throwable)localObject);
      }
      localObject = (InputMethodManager)localObject;
      if (localObject != null)
      {
        ((InputMethodManager)localObject).showSoftInput((View)n.b(this.QxO), 0);
        AppMethodBeat.o(182679);
        return;
      }
      AppMethodBeat.o(182679);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.n
 * JD-Core Version:    0.7.0.1
 */
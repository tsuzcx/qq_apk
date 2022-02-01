package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.webview.c.e;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.protocal.protobuf.fz;
import com.tencent.mm.protocal.protobuf.ga;
import com.tencent.mm.protocal.protobuf.ge;
import com.tencent.mm.protocal.protobuf.gf;
import com.tencent.mm.protocal.protobuf.gg;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.protocal.protobuf.pb;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewKeyboardLinearLayout;", "webView", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "isDark", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;ZLandroid/content/Context;Landroid/util/AttributeSet;)V", "actionView", "Landroid/view/View;", "adapter", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;", "callback", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "getCallback", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "setCallback", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;)V", "cancelTv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "commentTopicId", "", "getCommentTopicId", "()J", "setCommentTopicId", "(J)V", "commitBt", "Landroid/widget/Button;", "contentEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "currentKbState", "", "enterId", "getEnterId", "()I", "setEnterId", "(I)V", "hasReadOpenCfg", "isDoingGetMyComment", "isHaokan", "isReplyOpen", "itemShowType", "getItemShowType", "setItemShowType", "kbLayout", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "minHeaderHeight", "getMinHeaderHeight", "setMinHeaderHeight", "myCommentOffset", "getMyCommentOffset", "setMyCommentOffset", "myCommentTitleTv", "Landroid/widget/TextView;", "myCommentTv", "myCommentView", "recyclerView", "Landroid/widget/ListView;", "replyPersonalCommentId", "replyTip", "root", "savePortHeight", "sayFooter", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter;", "getSayFooter", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter;", "sayFooter$delegate", "Lkotlin/Lazy;", "scene", "getScene", "setScene", "subScene", "getSubScene", "setSubScene", "timeLineSessionId", "getTimeLineSessionId", "setTimeLineSessionId", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "weakThis", "Ljava/lang/ref/WeakReference;", "getWeakThis$plugin_webview_release", "()Ljava/lang/ref/WeakReference;", "setWeakThis$plugin_webview_release", "(Ljava/lang/ref/WeakReference;)V", "getWebView", "()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "caculateHeight", "", "newMarginBottom", "checkHeight", "h", "clearPersonalComment", "refreshHeight", "closeComment", "contentEtOnClick", "dealOrientaion", "orientation", "doAppMsgLikeComment", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgLikeCommentReq;", "doAppMsgOperateComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "doReport", "actionType", "fixKeyBoardMargin", "getAppMsgCommentList", "getNavHeightByDisplay", "getReplyHeight", "getRootHeight", "hide", "hideAnimation", "initKeyboardListener", "isShow", "onAddCommentSuccess", "onAppMsgLikeComment", "errType", "errCode", "errMsg", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "onAppMsgOperateComment", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDeleteComment", "onDeleteCommentReply", "onDestroy", "onGetCommentList", "onKeyBackPress", "onNoComment", "onResume", "onTouchClose", "replyToPersonalComment", "replyContent", "personalCommentId", "saveRootHeight", "height", "setData", "setRootHeight", "show", "showAnimation", "showCommentView", "showLayout", "showLayoutReply", "updateData", "resp", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommentListResp;", "clearUpdate", "updateUrl", "curUrl", "Companion", "MPMyCommentItemAdapter", "MPWriteCommentLayoutCallback", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends WebViewKeyboardLinearLayout
{
  private static final String TAG;
  public static final q.a Xqm;
  public int AcJ;
  private final WebViewKeyboardLinearLayout WWX;
  private int WYR;
  public int XlS;
  private int XqA;
  private int XqB;
  private int XqC;
  private q.c XqD;
  private boolean XqE;
  private int XqF;
  private boolean XqG;
  private boolean XqH;
  private final WebViewUI Xqn;
  private final kotlin.j Xqo;
  private final WeImageView Xqp;
  private final Button Xqq;
  public final MMEditText Xqr;
  private final ListView Xqs;
  private final View Xqt;
  private final TextView Xqu;
  private final TextView Xqv;
  private final TextView Xqw;
  private b Xqx;
  private boolean Xqy;
  private int Xqz;
  private final boolean hZG;
  private final View lBX;
  public int nQm;
  private long nVh;
  private final View pRa;
  public int scene;
  public String title;
  public String url;
  private WeakReference<q> vsw;
  
  static
  {
    AppMethodBeat.i(82720);
    Xqm = new q.a((byte)0);
    TAG = "MicroMsg.MPWriteCommentLayout";
    AppMethodBeat.o(82720);
  }
  
  public q(WebViewUI paramWebViewUI, Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(175710);
    this.Xqn = paramWebViewUI;
    this.hZG = false;
    paramWebViewUI = View.inflate(paramContext, c.g.mp_video_write_comment_view, (ViewGroup)this);
    if (paramWebViewUI == null)
    {
      paramWebViewUI = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout");
      AppMethodBeat.o(175710);
      throw paramWebViewUI;
    }
    this.WWX = ((WebViewKeyboardLinearLayout)paramWebViewUI);
    paramWebViewUI = findViewById(c.f.mp_video_comment_action_layout);
    s.s(paramWebViewUI, "findViewById(R.id.mp_video_comment_action_layout)");
    this.pRa = paramWebViewUI;
    this.Xqo = kotlin.k.cm((kotlin.g.a.a)new e(this));
    paramWebViewUI = findViewById(c.f.mp_video_comment_cancel);
    s.s(paramWebViewUI, "findViewById(R.id.mp_video_comment_cancel)");
    this.Xqp = ((WeImageView)paramWebViewUI);
    paramWebViewUI = findViewById(c.f.mp_video_comment_ok);
    s.s(paramWebViewUI, "findViewById(R.id.mp_video_comment_ok)");
    this.Xqq = ((Button)paramWebViewUI);
    paramWebViewUI = findViewById(c.f.mp_video_comment_et);
    s.s(paramWebViewUI, "findViewById(R.id.mp_video_comment_et)");
    this.Xqr = ((MMEditText)paramWebViewUI);
    paramWebViewUI = findViewById(c.f.biz_video_my_comment_list);
    s.s(paramWebViewUI, "findViewById(R.id.biz_video_my_comment_list)");
    this.Xqs = ((ListView)paramWebViewUI);
    paramWebViewUI = findViewById(c.f.mp_write_comment_root);
    s.s(paramWebViewUI, "findViewById(R.id.mp_write_comment_root)");
    this.lBX = paramWebViewUI;
    paramWebViewUI = findViewById(c.f.mp_video_write_comment_scroll_view);
    s.s(paramWebViewUI, "findViewById(R.id.mp_vid…rite_comment_scroll_view)");
    this.Xqt = paramWebViewUI;
    paramWebViewUI = findViewById(c.f.biz_video_my_comment_tv);
    s.s(paramWebViewUI, "findViewById(R.id.biz_video_my_comment_tv)");
    this.Xqu = ((TextView)paramWebViewUI);
    paramWebViewUI = findViewById(c.f.mp_video_my_comment_title);
    s.s(paramWebViewUI, "findViewById(R.id.mp_video_my_comment_title)");
    this.Xqv = ((TextView)paramWebViewUI);
    paramWebViewUI = findViewById(c.f.biz_video_reply_tip);
    s.s(paramWebViewUI, "findViewById(R.id.biz_video_reply_tip)");
    this.Xqw = ((TextView)paramWebViewUI);
    this.WYR = -1;
    this.url = "";
    this.title = "";
    this.vsw = new WeakReference(this);
    getSayFooter().setMMEditText(this.Xqr);
    getSayFooter().setVisibility(8);
    this.Xqr.setOnClickListener(new q..ExternalSyntheticLambda2(this));
    this.Xqr.setOnLongClickListener(new q..ExternalSyntheticLambda4(this));
    this.WWX.setOnTouchListener(new q..ExternalSyntheticLambda5(this));
    this.lBX.setOnClickListener(q..ExternalSyntheticLambda3.INSTANCE);
    int i = getRootHeight();
    if (i > 0)
    {
      paramWebViewUI = this.lBX.getLayoutParams();
      if (paramWebViewUI == null)
      {
        paramWebViewUI = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        AppMethodBeat.o(175710);
        throw paramWebViewUI;
      }
      paramWebViewUI.height = i;
      this.lBX.setLayoutParams(paramWebViewUI);
    }
    if (!KeyBoardUtil.isPortOrientation(paramContext)) {
      auV(2);
    }
    this.Xqp.setOnClickListener(new q..ExternalSyntheticLambda0(this));
    this.Xqq.setOnClickListener(new q..ExternalSyntheticLambda1(this));
    this.Xqr.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(82698);
        paramAnonymousCharSequence = q.i(this.XqI);
        Editable localEditable = q.f(this.XqI).getText();
        s.s(localEditable, "contentEt.text");
        if (((CharSequence)localEditable).length() > 0) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousCharSequence.setEnabled(bool);
          AppMethodBeat.o(82698);
          return;
        }
      }
    });
    paramWebViewUI = this.Xqq;
    paramContext = this.Xqr.getText();
    s.s(paramContext, "contentEt.text");
    if (((CharSequence)paramContext).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramWebViewUI.setEnabled(bool);
      this.Xqr.setOnTouchListener((View.OnTouchListener)new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(175690);
          s.u(paramAnonymousView, "view");
          s.u(paramAnonymousMotionEvent, "event");
          if ((paramAnonymousView.getId() == c.f.mp_video_comment_et) && (q.f(this.XqI).getLineCount() >= 5))
          {
            paramAnonymousView.getParent().requestDisallowInterceptTouchEvent(true);
            if (paramAnonymousMotionEvent.getAction() == 1) {
              paramAnonymousView.getParent().requestDisallowInterceptTouchEvent(false);
            }
          }
          AppMethodBeat.o(175690);
          return false;
        }
      });
      this.Xqw.setVisibility(8);
      AppMethodBeat.o(175710);
      return;
    }
  }
  
  private String a(gg paramgg)
  {
    Object localObject = null;
    AppMethodBeat.i(298047);
    s.u(paramgg, "req");
    b localb = this.Xqx;
    int i;
    if (localb == null)
    {
      paramgg = (gg)localObject;
      localObject = this.Xqx;
      if ((localObject != null) && (((b)localObject).getCount() == 0))
      {
        i = 1;
        label46:
        if (i != 0) {
          iCr();
        }
        AppMethodBeat.o(298047);
        return paramgg;
      }
    }
    else
    {
      s.u(paramgg, "req");
      Iterator localIterator = localb.lPK.iterator();
      while (localIterator.hasNext())
      {
        localObject = (pb)localIterator.next();
        if (paramgg.YHV == ((pb)localObject).YHV)
        {
          paramgg = ((pb)localObject).openid;
          localb.lPK.remove(localObject);
          localb.notifyDataSetChanged();
        }
      }
    }
    for (;;)
    {
      break;
      i = 0;
      break label46;
      paramgg = null;
    }
  }
  
  private static final void a(q paramq)
  {
    AppMethodBeat.i(298079);
    s.u(paramq, "this$0");
    MPSmileyFooter localMPSmileyFooter = paramq.getSayFooter();
    localMPSmileyFooter.setVisibility(0);
    if (localMPSmileyFooter.Mif != null) {
      localMPSmileyFooter.Mif.setImageResource(localMPSmileyFooter.auT(com.tencent.mm.plugin.webview.c.b.comment_panel_smiley_icon));
    }
    paramq.getSayFooter().postInvalidate();
    paramq.lBX.postInvalidate();
    AppMethodBeat.o(298079);
  }
  
  private static final void a(q paramq, int paramInt)
  {
    AppMethodBeat.i(298082);
    s.u(paramq, "this$0");
    Log.i(TAG, s.X("onKeyBoardStateChange, state = ", Integer.valueOf(paramInt)));
    if (paramInt == -3)
    {
      int i = paramq.WWX.getKeyBoardHeight();
      if (i > 0)
      {
        paramq.auU(i);
        paramq.auU(i);
      }
      new MMHandler().postDelayed(new q..ExternalSyntheticLambda10(paramq), 10L);
    }
    for (;;)
    {
      paramq.WYR = paramInt;
      AppMethodBeat.o(298082);
      return;
      paramq.auU(0);
      paramq.auU(0);
      new MMHandler().postDelayed(new q..ExternalSyntheticLambda11(paramq), 10L);
    }
  }
  
  private static final void a(q paramq, int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc)
  {
    AppMethodBeat.i(298088);
    s.u(paramq, "this$0");
    paramq.XqE = false;
    MMHandlerThread.postToMainThread(new q..ExternalSyntheticLambda15(paramq, paramc));
    if (paramInt1 == 2)
    {
      com.tencent.mm.plugin.webview.h.a.atU(8);
      AppMethodBeat.o(298088);
      return;
    }
    if (paramInt1 != 0) {
      com.tencent.mm.plugin.webview.h.a.atU(9);
    }
    AppMethodBeat.o(298088);
  }
  
  private static final void a(q paramq, View paramView)
  {
    AppMethodBeat.i(298065);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramq);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramq, "this$0");
    paramq.iCt();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(298065);
  }
  
  private static final void a(q paramq, com.tencent.mm.am.c paramc)
  {
    AppMethodBeat.i(298084);
    s.u(paramq, "this$0");
    Object localObject1 = com.tencent.mm.plugin.webview.k.e.XsJ;
    com.tencent.mm.plugin.webview.k.e.d(paramq.getWebView().psR);
    int i;
    if (paramq.getWeakThis$plugin_webview_release().get() != null)
    {
      paramq = paramq.getWeakThis$plugin_webview_release().get();
      if (paramq == null)
      {
        paramq = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout");
        AppMethodBeat.o(298084);
        throw paramq;
      }
      paramq = (q)paramq;
      s.s(paramc, "rr");
      if ((!(com.tencent.mm.am.c.b.b(paramc.otB) instanceof fz)) || (!(com.tencent.mm.am.c.c.b(paramc.otC) instanceof ga)))
      {
        AppMethodBeat.o(298084);
        return;
      }
      localObject1 = com.tencent.mm.am.c.b.b(paramc.otB);
      if (localObject1 == null)
      {
        paramq = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgCommentListReq");
        AppMethodBeat.o(298084);
        throw paramq;
      }
      localObject1 = (fz)localObject1;
      paramc = com.tencent.mm.am.c.c.b(paramc.otC);
      if (paramc == null)
      {
        paramq = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgCommentListResp");
        AppMethodBeat.o(298084);
        throw paramq;
      }
      paramc = (ga)paramc;
      localObject2 = TAG;
      if (paramc.YHx == null) {
        break label335;
      }
      LinkedList localLinkedList = paramc.YHx;
      s.checkNotNull(localLinkedList);
      i = localLinkedList.size();
      Log.i((String)localObject2, s.X("url_info size is ", Integer.valueOf(i)));
      if (((fz)localObject1).wuj == 2)
      {
        i = paramq.XqF;
        paramq.XqF = paramc.xlj;
        if (i != 0) {
          break label340;
        }
        i = 1;
        label257:
        s.u(paramc, "resp");
        if (!paramq.Xqy)
        {
          if (!Util.isNullOrNil((List)paramc.YHx)) {
            break label345;
          }
          paramq.iCr();
        }
      }
    }
    label335:
    label340:
    label345:
    do
    {
      for (;;)
      {
        if ((paramc.YHx == null) || (paramc.YHx.size() <= 0) || (paramq.XqA != 0)) {
          paramq.postDelayed(new q..ExternalSyntheticLambda12(paramq), 10L);
        }
        AppMethodBeat.o(298084);
        return;
        i = 0;
        break;
        i = 0;
        break label257;
        paramq.Xqt.setBackgroundColor(paramq.getResources().getColor(com.tencent.mm.plugin.webview.c.c.BW_97));
        paramq.Xqu.setVisibility(0);
        if (paramq.Xqx != null) {
          break label439;
        }
        localObject1 = paramq.getContext();
        s.s(localObject1, "context");
        localObject2 = paramc.YHx;
        s.s(localObject2, "resp.comment");
        paramq.Xqx = new b((Context)localObject1, (LinkedList)localObject2, paramq, paramq.hZG);
        paramq.Xqs.setAdapter((ListAdapter)paramq.Xqx);
      }
      localObject1 = paramq.Xqx;
    } while (localObject1 == null);
    label439:
    Object localObject2 = paramc.YHx;
    s.s(localObject2, "resp.comment");
    localObject2 = (List)localObject2;
    s.u(localObject2, "items");
    Log.i(b.TAG, s.X("update: ", Integer.valueOf(((List)localObject2).size())));
    if (i != 0)
    {
      ((b)localObject1).lPK.clear();
      ((b)localObject1).lPK.addAll((Collection)localObject2);
    }
    for (;;)
    {
      ((b)localObject1).notifyDataSetChanged();
      break;
      ((b)localObject1).lPK.addAll((Collection)localObject2);
    }
  }
  
  private static final boolean a(q paramq, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(298069);
    s.u(paramq, "this$0");
    if (paramMotionEvent.getAction() == 0)
    {
      if (paramq.WYR != -3) {
        break label44;
      }
      paramq.Xqn.hideVKB();
    }
    for (;;)
    {
      AppMethodBeat.o(298069);
      return true;
      label44:
      paramView = paramq.getSayFooter();
      if ((paramView.hqp()) || (paramView.getVisibility() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (!paramq.cvt())) {
          break label91;
        }
        paramq.getSayFooter().aWI();
        break;
      }
      label91:
      paramq.hide();
    }
  }
  
  private final void auU(int paramInt)
  {
    AppMethodBeat.i(298018);
    if ((paramInt > 0) && (KeyBoardUtil.getScreenOrientation(getContext()) != 2)) {
      auW(paramInt);
    }
    AppMethodBeat.o(298018);
  }
  
  private final void auV(int paramInt)
  {
    AppMethodBeat.i(82729);
    if (paramInt == 2)
    {
      paramInt = bf.getStatusBarHeight(getContext());
      setRootHeight(bf.bf(getContext()).y - paramInt);
      this.Xqr.setMinLines(3);
      AppMethodBeat.o(82729);
      return;
    }
    if (this.WWX.WUW) {
      auW(this.WWX.getKeyBoardHeight());
    }
    for (;;)
    {
      this.Xqr.setMinLines(5);
      AppMethodBeat.o(82729);
      return;
      if (this.Xqz != 0) {
        setRootHeight(this.Xqz);
      } else {
        auW(0);
      }
    }
  }
  
  private final void auW(int paramInt)
  {
    AppMethodBeat.i(82730);
    Object localObject = this.lBX.getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(82730);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.LayoutParams)localObject).height = (this.Xqr.getHeight() + this.pRa.getHeight() + getNavHeightByDisplay() + com.tencent.mm.cd.a.fromDPToPix(getContext(), com.tencent.mm.cd.a.K(getContext(), 60) + 16) + getReplyHeight() + paramInt);
    ((ViewGroup.LayoutParams)localObject).height = auX(((ViewGroup.LayoutParams)localObject).height);
    this.lBX.setLayoutParams((ViewGroup.LayoutParams)localObject);
    auY(((ViewGroup.LayoutParams)localObject).height);
    AppMethodBeat.o(82730);
  }
  
  private final int auX(int paramInt)
  {
    AppMethodBeat.i(82732);
    int k = bf.getStatusBarHeight(getContext());
    int m = bf.bf(getContext()).y;
    int j = m - k;
    int i;
    if (paramInt > j) {
      i = j;
    }
    for (;;)
    {
      AppMethodBeat.o(82732);
      return i;
      i = paramInt;
      if (this.XqB > 0)
      {
        int n = com.tencent.mm.cd.a.fromDPToPix(getContext(), 20);
        i = paramInt;
        if (paramInt < m - this.XqB - k + n) {
          i = j - this.XqB + n;
        }
      }
    }
  }
  
  private final void auY(int paramInt)
  {
    AppMethodBeat.i(82733);
    if (KeyBoardUtil.isPortOrientation(getContext())) {
      this.Xqz = paramInt;
    }
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("MPWriteCommentLayout");
    localMultiProcessMMKV.encode("MPWriteCommentRootHeight", paramInt);
    localMultiProcessMMKV.apply();
    AppMethodBeat.o(82733);
  }
  
  private String b(gg paramgg)
  {
    Object localObject1 = null;
    AppMethodBeat.i(175704);
    s.u(paramgg, "req");
    b localb = this.Xqx;
    int i;
    if (localb == null)
    {
      paramgg = (gg)localObject1;
      localObject1 = this.Xqx;
      if ((localObject1 != null) && (((b)localObject1).getCount() == 0))
      {
        i = 1;
        label46:
        if (i != 0) {
          iCr();
        }
        AppMethodBeat.o(175704);
        return paramgg;
      }
    }
    else
    {
      s.u(paramgg, "req");
      localObject1 = localb.lPK.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (pb)((Iterator)localObject1).next();
        if (paramgg.YHV == ((pb)localObject2).YHV)
        {
          localObject1 = ((pb)localObject2).openid;
          localObject2 = ((pb)localObject2).YSg.ZmL;
          s.s(localObject2, "comment.reply.reply_list");
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            aeq localaeq = (aeq)((Iterator)localObject2).next();
            if (localaeq.YHX == paramgg.YHX) {
              localaeq.ZmK = 1;
            }
          }
        }
      }
    }
    for (paramgg = (gg)localObject1;; paramgg = null)
    {
      localb.notifyDataSetChanged();
      break;
      i = 0;
      break label46;
    }
  }
  
  private static final void b(q paramq)
  {
    AppMethodBeat.i(298080);
    s.u(paramq, "this$0");
    paramq.getSayFooter().iCq();
    paramq.getSayFooter().postInvalidate();
    paramq.lBX.postInvalidate();
    AppMethodBeat.o(298080);
  }
  
  private static final void b(q paramq, int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc)
  {
    boolean bool = false;
    AppMethodBeat.i(298095);
    s.u(paramq, "this$0");
    Object localObject = com.tencent.mm.plugin.webview.k.e.XsJ;
    com.tencent.mm.plugin.webview.k.e.d(paramq.getWebView().psR);
    if (paramq.getWeakThis$plugin_webview_release().get() != null)
    {
      paramq = paramq.getWeakThis$plugin_webview_release().get();
      if (paramq == null)
      {
        paramq = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout");
        AppMethodBeat.o(298095);
        throw paramq;
      }
      paramq = (q)paramq;
      s.s(paramc, "rr");
      if ((paramInt2 != 0) && (!Util.isNullOrNil(paramString)))
      {
        com.tencent.mm.ui.base.k.a(paramq.getContext(), paramString, "", paramq.getContext().getString(c.i.app_ok), null);
        paramq = paramq.Xqq;
        if (paramInt2 != 60005) {
          bool = true;
        }
        paramq.setEnabled(bool);
        AppMethodBeat.o(298095);
        return;
      }
      paramString = com.tencent.mm.am.c.b.b(paramc.otB);
      if (paramString == null)
      {
        paramq = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgOperateCommentReq");
        AppMethodBeat.o(298095);
        throw paramq;
      }
      paramString = (gg)paramString;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        switch (paramString.wuj)
        {
        case 2: 
        default: 
          paramc = paramq.a(paramString);
          localObject = paramq.Xqn.WlX;
          if (localObject != null) {
            ((com.tencent.mm.plugin.webview.jsapi.j)localObject).b("deleteComment", paramString.YHV, paramc, 0, 0);
          }
          paramq.Je(true);
        }
        for (;;)
        {
          paramq.Xqr.clearFocus();
          AppMethodBeat.o(298095);
          return;
          aa.db(paramq.getContext(), paramq.getContext().getString(c.i.biz_video_write_comment_sucess));
          paramq.iCu();
          continue;
          aa.db(paramq.getContext(), paramq.getContext().getString(c.i.biz_video_write_reply_sucess));
          paramq.Je(true);
          paramq.iCu();
          continue;
          paramc = paramq.b(paramString);
          localObject = paramq.Xqn.WlX;
          if (localObject != null) {
            ((com.tencent.mm.plugin.webview.jsapi.j)localObject).b("deleteCommentReply", paramString.YHV, paramc, paramString.YHX, 0);
          }
          paramq.Je(true);
        }
      }
      if (paramString.wuj == 1)
      {
        com.tencent.mm.ui.base.k.cZ(paramq.getContext(), paramq.getContext().getString(c.i.biz_video_write_comment_fail, new Object[] { Integer.valueOf(paramInt2) }));
        if (paramInt1 == 2)
        {
          com.tencent.mm.plugin.webview.h.a.atU(11);
          AppMethodBeat.o(298095);
          return;
        }
        com.tencent.mm.plugin.webview.h.a.atU(12);
        AppMethodBeat.o(298095);
        return;
      }
      com.tencent.mm.ui.base.k.cZ(paramq.getContext(), paramq.getContext().getString(c.i.biz_video_delete_comment_fail, new Object[] { Integer.valueOf(paramInt2) }));
      if (paramInt1 == 2)
      {
        com.tencent.mm.plugin.webview.h.a.atU(14);
        AppMethodBeat.o(298095);
        return;
      }
      com.tencent.mm.plugin.webview.h.a.atU(15);
    }
    AppMethodBeat.o(298095);
  }
  
  private static final boolean b(q paramq, View paramView)
  {
    AppMethodBeat.i(298066);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramq);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    s.u(paramq, "this$0");
    paramq.iCt();
    com.tencent.mm.hellhoundlib.a.a.a(false, new Object(), "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(298066);
    return false;
  }
  
  private static final void c(q paramq)
  {
    AppMethodBeat.i(298089);
    s.u(paramq, "this$0");
    paramq.iCt();
    Object localObject = paramq.getContext().getSystemService("input_method");
    if (localObject == null)
    {
      paramq = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(298089);
      throw paramq;
    }
    ((InputMethodManager)localObject).showSoftInput((View)paramq.Xqr, 0);
    AppMethodBeat.o(298089);
  }
  
  private static final void c(q paramq, int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc)
  {
    AppMethodBeat.i(298097);
    s.u(paramq, "this$0");
    MMHandlerThread.postToMainThread(new q..ExternalSyntheticLambda13(paramq, paramInt1, paramInt2, paramString, paramc));
    AppMethodBeat.o(298097);
  }
  
  private static final void c(q paramq, View paramView)
  {
    AppMethodBeat.i(298076);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramq);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramq, "this$0");
    paramq.hide();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(298076);
  }
  
  private static final void d(q paramq, int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc)
  {
    AppMethodBeat.i(298100);
    s.u(paramq, "this$0");
    com.tencent.mm.plugin.webview.k.e locale = com.tencent.mm.plugin.webview.k.e.XsJ;
    com.tencent.mm.plugin.webview.k.e.d(paramq.getWebView().psR);
    if (paramq.getWeakThis$plugin_webview_release().get() != null)
    {
      paramq = paramq.getWeakThis$plugin_webview_release().get();
      if (paramq == null)
      {
        paramq = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout");
        AppMethodBeat.o(298100);
        throw paramq;
      }
      paramq = (q)paramq;
      s.s(paramc, "rr");
      if ((paramInt2 != 0) && (!Util.isNullOrNil(paramString)))
      {
        com.tencent.mm.ui.base.k.a(paramq.getContext(), paramString, "", paramq.getContext().getString(c.i.app_ok), null);
        AppMethodBeat.o(298100);
        return;
      }
      paramString = com.tencent.mm.am.c.b.b(paramc.otB);
      if (paramString == null)
      {
        paramq = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgLikeCommentReq");
        AppMethodBeat.o(298100);
        throw paramq;
      }
      paramString = (ge)paramString;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        switch (paramString.wuj)
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(298100);
      return;
      paramq = paramq.Xqn.WlX;
      if (paramq != null)
      {
        paramq.b("praiseComment", paramString.YHV, "", 0, paramString.YHW);
        AppMethodBeat.o(298100);
        return;
        paramq = paramq.Xqn.WlX;
        if (paramq != null) {
          paramq.b("praiseComment", paramString.YHV, "", paramString.YHX, paramString.YHW);
        }
      }
    }
  }
  
  private static final void d(q paramq, View paramView)
  {
    AppMethodBeat.i(298078);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramq);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramq, "this$0");
    if (paramq.Xqy)
    {
      paramView = paramq.Xqr.getText().toString();
      paramq = paramq.getWebView().WlX;
      if (paramq != null) {
        paramq.D(1, paramView, 1);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(298078);
      return;
      paramq.getWebView().hideVKB();
      if (paramq.getSayFooter().hqp()) {
        paramq.getSayFooter().aWI();
      }
      paramView = new gg();
      paramView.content = paramq.Xqr.getText().toString();
      paramView.wuj = 1;
      if (paramq.XqA != 0)
      {
        paramView.wuj = 3;
        paramView.YHV = paramq.XqA;
      }
      paramq.c(paramView);
      com.tencent.mm.plugin.webview.h.a.atU(10);
    }
  }
  
  private static final void e(q paramq, int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc)
  {
    AppMethodBeat.i(298103);
    s.u(paramq, "this$0");
    MMHandlerThread.postToMainThread(new q..ExternalSyntheticLambda14(paramq, paramInt1, paramInt2, paramString, paramc));
    AppMethodBeat.o(298103);
  }
  
  private final int getNavHeightByDisplay()
  {
    AppMethodBeat.i(82739);
    Point localPoint = bf.bf(getContext());
    Object localObject = this.Xqn.getWindow();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((Window)localObject).getDecorView())
    {
      s.s(localObject, "webView.window?.decorView");
      Rect localRect = new Rect();
      ((View)localObject).getWindowVisibleDisplayFrame(localRect);
      int i = localRect.bottom;
      int j = localPoint.y - i - this.WWX.getKeyBoardHeight();
      Log.v(TAG, "getNavHeightByDisplay screenHeight = " + i + ", realSize = " + localPoint.y);
      i = j;
      if (j < 0)
      {
        i = bf.bk(getContext());
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
    if (this.XqA != 0)
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
  
  private final MPSmileyFooter getSayFooter()
  {
    AppMethodBeat.i(82721);
    Object localObject = this.Xqo.getValue();
    s.s(localObject, "<get-sayFooter>(...)");
    localObject = (MPSmileyFooter)localObject;
    AppMethodBeat.o(82721);
    return localObject;
  }
  
  private final void iCr()
  {
    AppMethodBeat.i(82723);
    View localView = this.Xqt;
    int i = com.tencent.mm.plugin.webview.c.b.comment_panel_background_color;
    Context localContext = getContext();
    s.s(localContext, "context");
    localView.setBackgroundColor(r.h(i, localContext));
    this.Xqu.setVisibility(8);
    AppMethodBeat.o(82723);
  }
  
  private final void iCt()
  {
    AppMethodBeat.i(298008);
    this.Xqr.requestFocus();
    Log.d(TAG, "request fouces");
    if (getSayFooter().hqp()) {
      getSayFooter().aWI();
    }
    if (!KeyBoardUtil.isPortOrientation(getContext())) {
      getSayFooter().iCq();
    }
    this.lBX.postInvalidate();
    AppMethodBeat.o(298008);
  }
  
  private void iCu()
  {
    AppMethodBeat.i(175703);
    this.Xqr.setText((CharSequence)"");
    this.XqF = 0;
    getAppMsgCommentList();
    AppMethodBeat.o(175703);
  }
  
  private final void iCv()
  {
    AppMethodBeat.i(182680);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(250L);
    localTranslateAnimation.setFillAfter(false);
    this.lBX.clearAnimation();
    this.lBX.startAnimation((Animation)localTranslateAnimation);
    AppMethodBeat.o(182680);
  }
  
  private final void iCw()
  {
    AppMethodBeat.i(82737);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    localTranslateAnimation.setDuration(150L);
    localTranslateAnimation.setFillAfter(false);
    localTranslateAnimation.setAnimationListener((Animation.AnimationListener)new d(this));
    this.lBX.clearAnimation();
    this.lBX.startAnimation((Animation)localTranslateAnimation);
    AppMethodBeat.o(82737);
  }
  
  private static final void kF(View paramView)
  {
    AppMethodBeat.i(298072);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(298072);
  }
  
  private final void setRootHeight(int paramInt)
  {
    AppMethodBeat.i(82731);
    Object localObject = this.lBX.getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(82731);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.LayoutParams)localObject).height = auX(paramInt);
    this.lBX.setLayoutParams((ViewGroup.LayoutParams)localObject);
    auY(((ViewGroup.LayoutParams)localObject).height);
    AppMethodBeat.o(82731);
  }
  
  private final void show()
  {
    AppMethodBeat.i(82735);
    this.lBX.clearAnimation();
    setVisibility(0);
    iCv();
    AppMethodBeat.o(82735);
  }
  
  public final void BI(int paramInt)
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
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(19265, str1);
    AppMethodBeat.o(175709);
  }
  
  public final void D(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(175705);
    s.u(paramString, "replyContent");
    this.XqA = paramInt;
    this.Xqv.setText((CharSequence)getContext().getString(c.i.biz_comment_write_reply));
    this.Xqw.setVisibility(0);
    TextView localTextView = this.Xqw;
    Context localContext = getContext();
    paramInt = c.i.biz_comment_reply_personal;
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = "";
    }
    localTextView.setText((CharSequence)localContext.getString(paramInt, new Object[] { str }));
    this.Xqr.setHint((CharSequence)getContext().getString(c.i.biz_comment_reply_hint));
    if (paramBoolean)
    {
      this.Xqt.scrollTo(0, 0);
      this.Xqr.requestFocus();
      paramString = getContext().getSystemService("input_method");
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        AppMethodBeat.o(175705);
        throw paramString;
      }
      ((InputMethodManager)paramString).showSoftInput((View)this.Xqr, 0);
    }
    AppMethodBeat.o(175705);
  }
  
  public final void Jc(boolean paramBoolean)
  {
    AppMethodBeat.i(82725);
    BI(1);
    Je(false);
    Jd(paramBoolean);
    AppMethodBeat.o(82725);
  }
  
  public final void Jd(boolean paramBoolean)
  {
    AppMethodBeat.i(175702);
    this.Xqy = paramBoolean;
    show();
    if (paramBoolean)
    {
      this.Xqu.setVisibility(8);
      this.Xqv.setText((CharSequence)getContext().getString(c.i.biz_video_share_to_wow));
      this.Xqr.setHint(c.i.biz_video_share_to_wow_hint);
      this.Xqq.setText(c.i.app_send);
      this.Xqq.setBackground(getContext().getResources().getDrawable(c.e.biz_video_btn_solid_yellow_small));
      localObject = (InputFilter)new InputFilter.LengthFilter(200);
      this.Xqr.setFilters(new InputFilter[] { localObject });
      AppMethodBeat.o(175702);
      return;
    }
    getAppMsgCommentList();
    this.Xqq.setText(c.i.biz_video_commit_comment);
    Object localObject = this.Xqq;
    int i = com.tencent.mm.plugin.webview.c.b.comment_panel_action_button_style_selector;
    Context localContext = getContext();
    s.s(localContext, "context");
    ((Button)localObject).setBackground(r.g(i, localContext));
    AppMethodBeat.o(175702);
  }
  
  public final void Je(boolean paramBoolean)
  {
    AppMethodBeat.i(175707);
    if (this.XqA != 0)
    {
      this.XqA = 0;
      if (paramBoolean) {
        auV(KeyBoardUtil.getScreenOrientation(getContext()));
      }
    }
    this.Xqw.setText((CharSequence)"");
    this.Xqw.setVisibility(8);
    this.Xqr.setHint((CharSequence)getContext().getString(c.i.biz_video_write_comment_hint));
    this.Xqv.setText((CharSequence)getContext().getString(c.i.biz_video_write_comment));
    AppMethodBeat.o(175707);
  }
  
  public final void a(ge paramge)
  {
    AppMethodBeat.i(298327);
    s.u(paramge, "req");
    paramge.scene = this.scene;
    paramge.YHt = this.AcJ;
    paramge.url = this.url;
    paramge.YHv = this.nQm;
    paramge.session_id = s.X("", Integer.valueOf(this.XqC));
    paramge.YHu = this.XlS;
    com.tencent.mm.am.c.a locala = new com.tencent.mm.am.c.a();
    locala.otE = ((com.tencent.mm.bx.a)paramge);
    locala.otF = ((com.tencent.mm.bx.a)new gf());
    locala.uri = "/cgi-bin/mmbiz-bin/appmsg/appmsg_like_comment";
    locala.funcId = 2759;
    locala.otG = 0;
    locala.respCmdId = 0;
    IPCRunCgi.a(locala.bEF(), new q..ExternalSyntheticLambda7(this));
    AppMethodBeat.o(298327);
  }
  
  public final void bmS(String paramString)
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
  
  public final void c(gg paramgg)
  {
    AppMethodBeat.i(82741);
    s.u(paramgg, "req");
    paramgg.scene = this.scene;
    paramgg.YHt = this.AcJ;
    paramgg.url = this.url;
    paramgg.title = this.title;
    paramgg.YHY = System.currentTimeMillis();
    paramgg.YHv = this.nQm;
    paramgg.session_id = s.X("", Integer.valueOf(this.XqC));
    paramgg.YHu = this.XlS;
    paramgg.YHw = this.nVh;
    Object localObject = new com.tencent.mm.am.c.a();
    ((com.tencent.mm.am.c.a)localObject).otE = ((com.tencent.mm.bx.a)paramgg);
    ((com.tencent.mm.am.c.a)localObject).otF = ((com.tencent.mm.bx.a)new gh());
    ((com.tencent.mm.am.c.a)localObject).uri = "/cgi-bin/mmbiz-bin/appmsg/appmsg_operate_comment";
    ((com.tencent.mm.am.c.a)localObject).funcId = 2617;
    ((com.tencent.mm.am.c.a)localObject).otG = 0;
    ((com.tencent.mm.am.c.a)localObject).respCmdId = 0;
    IPCRunCgi.a(((com.tencent.mm.am.c.a)localObject).bEF(), new q..ExternalSyntheticLambda6(this));
    paramgg = this.Xqn;
    localObject = com.tencent.mm.plugin.webview.k.e.XsJ;
    localObject = getContext().getString(c.i.app_waiting);
    s.s(localObject, "context.getString(R.string.app_waiting)");
    Context localContext = getContext();
    s.s(localContext, "context");
    paramgg.psR = com.tencent.mm.plugin.webview.k.e.a((String)localObject, localContext, this.Xqn.psR);
    AppMethodBeat.o(82741);
  }
  
  public final boolean cvt()
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
  
  public final void getAppMsgCommentList()
  {
    AppMethodBeat.i(82740);
    fz localfz = new fz();
    localfz.url = this.url;
    if (this.XqE)
    {
      AppMethodBeat.o(82740);
      return;
    }
    localfz.offset = this.XqF;
    if (this.XqF == -1)
    {
      Log.i(TAG, "no more my comment");
      AppMethodBeat.o(82740);
      return;
    }
    this.XqE = true;
    localfz.wuj = 2;
    localfz.scene = this.scene;
    localfz.YHt = this.AcJ;
    localfz.YHv = this.nQm;
    localfz.session_id = s.X("", Integer.valueOf(this.XqC));
    localfz.YHu = this.XlS;
    localfz.YHw = this.nVh;
    com.tencent.mm.am.c.a locala = new com.tencent.mm.am.c.a();
    locala.otE = ((com.tencent.mm.bx.a)localfz);
    locala.otF = ((com.tencent.mm.bx.a)new ga());
    locala.uri = "/cgi-bin/mmbiz-bin/appmsg/appmsg_comment_list";
    locala.funcId = 2866;
    locala.otG = 0;
    locala.respCmdId = 0;
    IPCRunCgi.a(locala.bEF(), new q..ExternalSyntheticLambda8(this));
    com.tencent.mm.plugin.webview.h.a.atU(7);
    AppMethodBeat.o(82740);
  }
  
  public final q.c getCallback()
  {
    return this.XqD;
  }
  
  public final long getCommentTopicId()
  {
    return this.nVh;
  }
  
  public final int getEnterId()
  {
    return this.XlS;
  }
  
  public final int getItemShowType()
  {
    return this.nQm;
  }
  
  public final int getMinHeaderHeight()
  {
    return this.XqB;
  }
  
  public final int getMyCommentOffset()
  {
    return this.XqF;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final int getSubScene()
  {
    return this.AcJ;
  }
  
  public final int getTimeLineSessionId()
  {
    return this.XqC;
  }
  
  public final String getTitle()
  {
    return this.title;
  }
  
  public final String getUrl()
  {
    return this.url;
  }
  
  public final WeakReference<q> getWeakThis$plugin_webview_release()
  {
    return this.vsw;
  }
  
  public final WebViewUI getWebView()
  {
    return this.Xqn;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(82736);
    if (!cvt())
    {
      AppMethodBeat.o(82736);
      return;
    }
    if (getSayFooter().hqp()) {
      getSayFooter().aWI();
    }
    iCw();
    this.Xqn.hideVKB();
    this.XqF = 0;
    b localb = this.Xqx;
    if (localb != null) {
      localb.clear();
    }
    AppMethodBeat.o(82736);
  }
  
  public final void iCs()
  {
    AppMethodBeat.i(82724);
    this.WWX.setOnkbdStateListener(new q..ExternalSyntheticLambda9(this));
    AppMethodBeat.o(82724);
  }
  
  public final boolean iCx()
  {
    AppMethodBeat.i(175708);
    if (!this.XqG) {
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yOs, 1) != 1) {
        break label79;
      }
    }
    label79:
    for (boolean bool = true;; bool = false)
    {
      this.XqH = bool;
      this.XqG = true;
      Log.v(TAG, s.X("isReplyOpen = ", Boolean.valueOf(this.XqH)));
      bool = this.XqH;
      AppMethodBeat.o(175708);
      return bool;
    }
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(82728);
    s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    auV(paramConfiguration.orientation);
    if (getSayFooter().hqp()) {
      getSayFooter().aWI();
    }
    AppMethodBeat.o(82728);
  }
  
  public final void setCallback(q.c paramc)
  {
    this.XqD = paramc;
  }
  
  public final void setCommentTopicId(long paramLong)
  {
    this.nVh = paramLong;
  }
  
  public final void setEnterId(int paramInt)
  {
    this.XlS = paramInt;
  }
  
  public final void setItemShowType(int paramInt)
  {
    this.nQm = paramInt;
  }
  
  public final void setMinHeaderHeight(int paramInt)
  {
    this.XqB = paramInt;
  }
  
  public final void setMyCommentOffset(int paramInt)
  {
    this.XqF = paramInt;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public final void setSubScene(int paramInt)
  {
    this.AcJ = paramInt;
  }
  
  public final void setTimeLineSessionId(int paramInt)
  {
    this.XqC = paramInt;
  }
  
  public final void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public final void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public final void setWeakThis$plugin_webview_release(WeakReference<q> paramWeakReference)
  {
    AppMethodBeat.i(82722);
    s.u(paramWeakReference, "<set-?>");
    this.vsw = paramWeakReference;
    AppMethodBeat.o(82722);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "controller", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "isDarkPanel", "", "(Landroid/content/Context;Ljava/util/LinkedList;Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;Z)V", "getController", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "setController", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;)V", "viewPool", "Ljava/util/ArrayList;", "Landroid/view/View;", "getViewPool", "()Ljava/util/ArrayList;", "clear", "", "getCommentView", "getCount", "", "getItem", "position", "getItemId", "", "i", "getLastInvalidReply", "", "info", "getView", "convertView", "viewGroup", "Landroid/view/ViewGroup;", "onDeleteComment", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "onDeleteCommentReply", "showLikeStatus", "itemView", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "reply", "Lcom/tencent/mm/protocal/protobuf/CommentReply;", "isReply", "update", "items", "", "clearUpdate", "updateCommentContentView", "updateReplyView", "index", "BizCommentContent", "BizCommentViewHolder", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends BaseAdapter
  {
    static final String TAG;
    public static final q.b.c XqJ;
    private static com.tencent.mm.modelimage.loader.a.c XqN;
    q XqK;
    private boolean XqL;
    final ArrayList<View> XqM;
    final Context context;
    final LinkedList<pb> lPK;
    
    static
    {
      AppMethodBeat.i(82709);
      XqJ = new q.b.c((byte)0);
      TAG = "MicroMsg.MPMyCommentItemAdapter";
      Object localObject = new com.tencent.mm.modelimage.loader.a.c.a();
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKE = com.tencent.mm.plugin.webview.c.c.chatting_item_biz_default_bg;
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKp = true;
      localObject = ((com.tencent.mm.modelimage.loader.a.c.a)localObject).eG(120, 120);
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKe = ((com.tencent.mm.modelimage.loader.b.c)new n());
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKN = ((com.tencent.mm.modelimage.loader.b.a)new com.tencent.mm.pluginsdk.ui.applet.e());
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).nrc = true;
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKI = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 3);
      localObject = ((com.tencent.mm.modelimage.loader.a.c.a)localObject).bKx();
      s.checkNotNull(localObject);
      XqN = (com.tencent.mm.modelimage.loader.a.c)localObject;
      AppMethodBeat.o(82709);
    }
    
    public b(Context paramContext, LinkedList<pb> paramLinkedList, q paramq, boolean paramBoolean)
    {
      AppMethodBeat.i(162324);
      this.context = paramContext;
      this.lPK = paramLinkedList;
      this.XqK = paramq;
      this.XqL = paramBoolean;
      this.XqM = new ArrayList();
      AppMethodBeat.o(162324);
    }
    
    public static String a(pb parampb)
    {
      AppMethodBeat.i(182678);
      s.u(parampb, "info");
      String str = parampb.content;
      int i;
      if ((parampb.YSg != null) && (!Util.isNullOrNil((List)parampb.YSg.ZmL)))
      {
        i = parampb.YSg.ZmL.size() - 1;
        if (i < 0) {}
      }
      for (;;)
      {
        int j = i - 1;
        if (((aeq)parampb.YSg.ZmL.get(i)).ZmK == 0) {}
        for (parampb = ((aeq)parampb.YSg.ZmL.get(i)).content;; parampb = str)
        {
          s.s(parampb, "reply");
          AppMethodBeat.o(182678);
          return parampb;
          if (j >= 0) {
            break;
          }
        }
        i = j;
      }
    }
    
    private void a(a parama, pb parampb, aeq paramaeq, boolean paramBoolean)
    {
      AppMethodBeat.i(175697);
      s.u(parama, "itemView");
      s.u(parampb, "info");
      Object localObject1;
      Object localObject2;
      label43:
      Object localObject3;
      label55:
      Object localObject4;
      label84:
      int i;
      if (paramBoolean) {
        if (paramaeq == null)
        {
          localObject1 = null;
          if (!paramBoolean) {
            break label293;
          }
          if (paramaeq != null) {
            break label281;
          }
          localObject2 = null;
          if (!paramBoolean) {
            break label317;
          }
          if (paramaeq != null) {
            break label305;
          }
          localObject3 = null;
          String str = TAG;
          StringBuilder localStringBuilder = new StringBuilder("showLikeStatus content = ");
          if (!paramBoolean) {
            break label338;
          }
          if (paramaeq != null) {
            break label329;
          }
          localObject4 = null;
          Log.v(str, localObject4 + ", isElected = " + localObject1 + ", likeNum = " + localObject2 + ", likeStatus = " + localObject3);
          parama.XqR.setOnClickListener(null);
          if (localObject1 != null) {
            break label347;
          }
          label145:
          parama.XqT.setVisibility(8);
          parama.XqR.setVisibility(0);
          parama.nhq.setVisibility(8);
          if (localObject2 != null)
          {
            localObject1 = parama.nhq;
            if (((Integer)localObject2).intValue() <= 0) {
              break label388;
            }
            i = 0;
            label193:
            ((TextView)localObject1).setVisibility(i);
            parama.nhq.setText((CharSequence)((Integer)localObject2).toString());
          }
          if (localObject3 != null) {
            break label395;
          }
          label220:
          parama.XqR.setImageResource(c.h.approve_highlight);
        }
      }
      for (;;)
      {
        parama.XqR.setOnClickListener(new q.b..ExternalSyntheticLambda4(this, paramBoolean, paramaeq, parampb, parama));
        AppMethodBeat.o(175697);
        return;
        localObject1 = Integer.valueOf(paramaeq.ZmJ);
        break;
        localObject1 = Integer.valueOf(parampb.YSd);
        break;
        label281:
        localObject2 = Integer.valueOf(paramaeq.ZmH);
        break label43;
        label293:
        localObject2 = Integer.valueOf(parampb.YSe);
        break label43;
        label305:
        localObject3 = Integer.valueOf(paramaeq.ZmI);
        break label55;
        label317:
        localObject3 = Integer.valueOf(parampb.YSf);
        break label55;
        label329:
        localObject4 = paramaeq.content;
        break label84;
        label338:
        localObject4 = parampb.content;
        break label84;
        label347:
        if (((Integer)localObject1).intValue() != 0) {
          break label145;
        }
        parama.XqT.setVisibility(0);
        parama.XqR.setVisibility(8);
        parama.nhq.setVisibility(8);
        AppMethodBeat.o(175697);
        return;
        label388:
        i = 8;
        break label193;
        label395:
        if (((Integer)localObject3).intValue() != 0) {
          break label220;
        }
        parama.XqR.setImageResource(c.h.approve_default);
      }
    }
    
    private static final void a(b paramb, pb parampb, View paramView)
    {
      AppMethodBeat.i(297939);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramb);
      localb.cH(parampb);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramb, "this$0");
      new e.a(paramb.context).bDv(paramb.context.getString(c.i.biz_video_delete_comment_confirm)).bDw("").aET(paramb.context.getResources().getColor(com.tencent.mm.plugin.webview.c.c.Red_100)).aER(c.i.app_delete).c(new q.b..ExternalSyntheticLambda0(parampb, paramb)).aES(c.i.button_cancel).jHH().show();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(297939);
    }
    
    private static final void a(b paramb, pb parampb, aeq paramaeq, View paramView)
    {
      AppMethodBeat.i(297949);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramb);
      localb.cH(parampb);
      localb.cH(paramaeq);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramb, "this$0");
      s.u(paramaeq, "$reply");
      new e.a(paramb.context).bDv(paramb.context.getString(c.i.biz_comment_delete_reply_confirm)).bDw("").aET(paramb.context.getResources().getColor(com.tencent.mm.plugin.webview.c.c.Red_100)).aER(c.i.app_delete).c(new q.b..ExternalSyntheticLambda1(parampb, paramaeq, paramb)).aES(c.i.button_cancel).jHH().show();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(297949);
    }
    
    private static final void a(b paramb, boolean paramBoolean, aeq paramaeq, pb parampb, a parama, View paramView)
    {
      Object localObject1 = null;
      AppMethodBeat.i(297956);
      Object localObject2 = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramb);
      localb.fv(paramBoolean);
      localb.cH(paramaeq);
      localb.cH(parampb);
      localb.cH(parama);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, localb.aYj());
      s.u(paramb, "this$0");
      s.u(parampb, "$info");
      s.u(parama, "$itemView");
      q.f(paramb.XqK).clearFocus();
      int i;
      if (paramBoolean) {
        if (paramaeq == null)
        {
          paramView = null;
          s.checkNotNull(paramView);
          i = paramView.intValue();
          label142:
          if (!paramBoolean) {
            break label409;
          }
          if (paramaeq != null) {
            break label397;
          }
          paramView = null;
          label153:
          if (paramView != null) {
            break label421;
          }
          label158:
          parama.XqR.setImageResource(c.h.approve_default);
          i -= 1;
          label175:
          if (i >= 0) {
            break label515;
          }
          i = 0;
        }
      }
      label515:
      for (;;)
      {
        parama.nhq.setText((CharSequence)String.valueOf(i));
        parama = parama.nhq;
        int j;
        if (i > 0)
        {
          j = 0;
          label214:
          parama.setVisibility(j);
          localObject2 = new ge();
          ((ge)localObject2).YHV = parampb.YHV;
          ((ge)localObject2).openid = parampb.openid;
          ((ge)localObject2).wuj = 1;
          if (paramBoolean)
          {
            if (paramaeq != null) {
              break label456;
            }
            parama = localObject1;
            label266:
            s.checkNotNull(parama);
            ((ge)localObject2).YHX = parama.intValue();
            ((ge)localObject2).wuj = 2;
          }
          if (paramView != null) {
            break label468;
          }
          label292:
          j = 0;
          label295:
          ((ge)localObject2).YHW = j;
          paramb.XqK.a((ge)localObject2);
          if (paramView != null) {
            break label482;
          }
          label316:
          paramb = Integer.valueOf(0);
          label321:
          if (!paramBoolean) {
            break label498;
          }
          if (paramaeq != null) {
            paramaeq.ZmI = paramb.intValue();
          }
          if (paramaeq != null) {
            paramaeq.ZmH = i;
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(297956);
          return;
          paramView = Integer.valueOf(paramaeq.ZmH);
          break;
          i = parampb.YSe;
          break label142;
          label397:
          paramView = Integer.valueOf(paramaeq.ZmI);
          break label153;
          label409:
          paramView = Integer.valueOf(parampb.YSf);
          break label153;
          label421:
          if (paramView.intValue() != 0) {
            break label158;
          }
          parama.XqR.setImageResource(c.h.approve_highlight);
          i += 1;
          break label175;
          j = 8;
          break label214;
          label456:
          parama = Integer.valueOf(paramaeq.YHX);
          break label266;
          label468:
          if (paramView.intValue() != 0) {
            break label292;
          }
          j = 1;
          break label295;
          label482:
          if (paramView.intValue() != 0) {
            break label316;
          }
          paramb = Integer.valueOf(1);
          break label321;
          label498:
          parampb.YSf = paramb.intValue();
          parampb.YSe = i;
        }
      }
    }
    
    private static final void a(pb parampb, b paramb, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(297933);
      s.u(paramb, "this$0");
      paramDialogInterface = new gg();
      paramDialogInterface.YHV = parampb.YHV;
      paramDialogInterface.wuj = 2;
      paramb.XqK.c(paramDialogInterface);
      com.tencent.mm.plugin.webview.h.a.atU(13);
      AppMethodBeat.o(297933);
    }
    
    private static final void a(pb parampb, aeq paramaeq, b paramb, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(297946);
      s.u(paramaeq, "$reply");
      s.u(paramb, "this$0");
      paramDialogInterface = new gg();
      paramDialogInterface.YHV = parampb.YHV;
      paramDialogInterface.YHX = paramaeq.YHX;
      paramDialogInterface.wuj = 4;
      paramb.XqK.c(paramDialogInterface);
      com.tencent.mm.plugin.webview.h.a.atU(13);
      AppMethodBeat.o(297946);
    }
    
    private pb auZ(int paramInt)
    {
      AppMethodBeat.i(82704);
      pb localpb = (pb)kotlin.a.p.ae((List)this.lPK, paramInt);
      AppMethodBeat.o(82704);
      return localpb;
    }
    
    public final void a(pb parampb, a parama)
    {
      AppMethodBeat.i(297995);
      s.u(parama, "itemView");
      if (parampb == null)
      {
        AppMethodBeat.o(297995);
        return;
      }
      SpannableString localSpannableString = com.tencent.mm.pluginsdk.ui.span.p.b(this.context, (CharSequence)parampb.xkX, parama.wBZ.getTextSize());
      parama.wBZ.setText((CharSequence)localSpannableString);
      localSpannableString = com.tencent.mm.pluginsdk.ui.span.p.b(this.context, (CharSequence)parampb.content, parama.XqO.getTextSize());
      parama.XqO.aZ((CharSequence)localSpannableString);
      parama.XqP.setIconColor(this.context.getResources().getColor(com.tencent.mm.plugin.webview.c.c.Link));
      parama.XqP.setVisibility(0);
      parama.XqQ.setVisibility(0);
      parama.XqP.setOnClickListener(new q.b..ExternalSyntheticLambda2(this, parampb));
      a(parama, parampb, null, false);
      parama.XqU.setVisibility(8);
      parama.XqV.setVisibility(4);
      AppMethodBeat.o(297995);
    }
    
    public final void a(final pb parampb, aeq paramaeq, a parama, int paramInt)
    {
      AppMethodBeat.i(298001);
      s.u(paramaeq, "reply");
      s.u(parama, "itemView");
      if (parampb == null)
      {
        AppMethodBeat.o(298001);
        return;
      }
      kotlin.g.a.b localb = (kotlin.g.a.b)new d(parama, this, parampb);
      if (s.p(parampb.openid, paramaeq.openid) == true)
      {
        if (!((Boolean)localb.invoke(Integer.valueOf(paramaeq.ZmK))).booleanValue())
        {
          parama.wBZ.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(this.context, (CharSequence)parampb.xkX, parama.wBZ.getTextSize()));
          parama.XqO.aZ((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(this.context, (CharSequence)paramaeq.content, parama.XqO.getTextSize()));
          parama.XqP.setIconColor(this.context.getResources().getColor(com.tencent.mm.plugin.webview.c.c.Link));
          parama.XqP.setVisibility(0);
          parama.XqQ.setVisibility(0);
          a(parama, parampb, paramaeq, true);
          parama.XqP.setOnClickListener(new q.b..ExternalSyntheticLambda3(this, parampb, paramaeq));
        }
        parama.XqU.setVisibility(0);
        parama.XqV.setVisibility(4);
        if (paramInt + 1 < parampb.YSg.ZmL.size())
        {
          parama = parama.XqV;
          if (!s.p(paramaeq.openid, ((aeq)parampb.YSg.ZmL.get(paramInt + 1)).openid)) {
            break label414;
          }
        }
      }
      label414:
      for (paramInt = 0;; paramInt = 4)
      {
        parama.setVisibility(paramInt);
        AppMethodBeat.o(298001);
        return;
        if (((Boolean)localb.invoke(Integer.valueOf(paramaeq.ZmK))).booleanValue()) {
          break;
        }
        parama.wBZ.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(this.context, (CharSequence)this.context.getResources().getString(c.i.mp_author), parama.wBZ.getTextSize()));
        parama.XqO.aZ((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(this.context, (CharSequence)paramaeq.content, parama.XqO.getTextSize()));
        parama.XqP.setVisibility(8);
        parama.XqQ.setVisibility(8);
        a(parama, parampb, paramaeq, true);
        break;
      }
    }
    
    public final void clear()
    {
      AppMethodBeat.i(82703);
      this.lPK.clear();
      notifyDataSetChanged();
      AppMethodBeat.o(82703);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(82706);
      int i = this.lPK.size();
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
      s.u(paramViewGroup, "viewGroup");
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.context).inflate(c.g.mp_comment_view_item, null, false);
        paramViewGroup = new b(paramView);
        paramView.setTag(paramViewGroup);
        pb localpb = auZ(paramInt);
        if (localpb != null) {
          paramViewGroup.b(localpb);
        }
        if (paramInt != getCount() - 1) {
          break label135;
        }
        paramViewGroup.XqY.setVisibility(0);
        this.XqK.getAppMsgCommentList();
      }
      for (;;)
      {
        AppMethodBeat.o(82707);
        return paramView;
        paramViewGroup = paramView.getTag();
        if (paramViewGroup == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout.MPMyCommentItemAdapter.BizCommentViewHolder");
          AppMethodBeat.o(82707);
          throw paramView;
        }
        paramViewGroup = (b)paramViewGroup;
        break;
        label135:
        paramViewGroup.XqY.setVisibility(8);
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;Landroid/view/View;)V", "deleteIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getDeleteIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setDeleteIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "deleteSplit", "Landroid/widget/ImageView;", "getDeleteSplit", "()Landroid/widget/ImageView;", "desc", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "getDesc", "()Lcom/tencent/neattextview/textview/view/NeatTextView;", "setDesc", "(Lcom/tencent/neattextview/textview/view/NeatTextView;)V", "likeThumb", "getLikeThumb", "likeTv", "Landroid/widget/TextView;", "getLikeTv", "()Landroid/widget/TextView;", "setLikeTv", "(Landroid/widget/TextView;)V", "nickName", "getNickName", "setNickName", "notChosen", "getNotChosen", "replyDelete", "getReplyDelete", "replyPrefix", "getReplyPrefix", "sameReplyPrefix", "getSameReplyPrefix", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public final class a
    {
      NeatTextView XqO;
      WeImageView XqP;
      final ImageView XqQ;
      final ImageView XqR;
      final TextView XqS;
      final TextView XqT;
      final ImageView XqU;
      final ImageView XqV;
      TextView nhq;
      TextView wBZ;
      
      public a()
      {
        AppMethodBeat.i(82699);
        this.wBZ = ((TextView)((View)localObject).findViewById(c.f.biz_video_comment_nickname_tv));
        this.nhq = ((TextView)((View)localObject).findViewById(c.f.biz_video_comment_like_tv));
        this.XqO = ((NeatTextView)((View)localObject).findViewById(c.f.biz_video_comment_content_tv));
        this.XqP = ((WeImageView)((View)localObject).findViewById(c.f.biz_video_comment_delete_tv));
        this.XqQ = ((ImageView)((View)localObject).findViewById(c.f.biz_comment_delete_split));
        this.XqR = ((ImageView)((View)localObject).findViewById(c.f.biz_comment_like_thumb));
        this.XqS = ((TextView)((View)localObject).findViewById(c.f.biz_comment_reply_delete));
        this.XqT = ((TextView)((View)localObject).findViewById(c.f.biz_comment_not_chosen));
        this.XqU = ((ImageView)((View)localObject).findViewById(c.f.biz_reply_prefix));
        this.XqV = ((ImageView)((View)localObject).findViewById(c.f.biz_same_reply_prefix));
        this$1 = ((View)localObject).getContext();
        Object localObject = this.XqO;
        int i = com.tencent.mm.plugin.webview.c.b.comment_panel_text_color;
        s.s(q.b.this, "context");
        ((NeatTextView)localObject).setTextColor(r.h(i, q.b.this));
        AppMethodBeat.o(82699);
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentViewHolder;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAvatar", "()Landroid/widget/ImageView;", "commentList", "Ljava/util/ArrayList;", "getCommentList", "()Ljava/util/ArrayList;", "content", "Landroid/widget/LinearLayout;", "getContent", "()Landroid/widget/LinearLayout;", "endlineLayout", "getEndlineLayout", "setEndlineLayout", "(Landroid/widget/LinearLayout;)V", "fansContent", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter;", "getFansContent", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;", "setFansContent", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentContent;)V", "fansLayout", "getFansLayout", "setFansLayout", "txtReply", "Landroid/widget/TextView;", "getTxtReply", "()Landroid/widget/TextView;", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public final class b
    {
      private final LinearLayout RnD;
      private LinearLayout XqX;
      LinearLayout XqY;
      private q.b.a XqZ;
      private final TextView Xra;
      private final ImageView avatar;
      private final ArrayList<View> nnY;
      
      public b()
      {
        AppMethodBeat.i(82700);
        this.avatar = ((ImageView)localObject.findViewById(c.f.biz_video_avatar_iv));
        this.RnD = ((LinearLayout)localObject.findViewById(c.f.biz_video_comment_content_layout));
        this.XqX = ((LinearLayout)localObject.findViewById(c.f.biz_video_fans_comment_layout));
        this.XqY = ((LinearLayout)localObject.findViewById(c.f.end_line_layout));
        this$1 = q.b.this;
        LinearLayout localLinearLayout = this.XqX;
        s.s(localLinearLayout, "fansLayout");
        this.XqZ = new q.b.a(q.b.this, (View)localLinearLayout);
        this.Xra = ((TextView)localObject.findViewById(c.f.biz_comment_reply));
        this.nnY = new ArrayList();
        AppMethodBeat.o(82700);
      }
      
      private static final void b(q.b paramb, pb parampb, View paramView)
      {
        AppMethodBeat.i(298051);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramb);
        localb.cH(parampb);
        localb.cH(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
        s.u(paramb, "this$0");
        s.u(parampb, "$info");
        paramb.XqK.BI(3);
        paramb.XqK.D(q.b.a(parampb), parampb.YHV, true);
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPMyCommentItemAdapter$BizCommentViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(298051);
      }
      
      public final void b(pb parampb)
      {
        AppMethodBeat.i(298067);
        s.u(parampb, "info");
        Object localObject1 = com.tencent.mm.modelimage.loader.a.bKl();
        Object localObject2 = parampb.nQG;
        Object localObject3 = this.avatar;
        Object localObject4 = q.b.XqJ;
        ((com.tencent.mm.modelimage.loader.a)localObject1).a((String)localObject2, (ImageView)localObject3, q.b.iCy());
        q.b.this.a(parampb, this.XqZ);
        this.Xra.setVisibility(8);
        if (q.e(q.b.this.XqK))
        {
          this.Xra.setVisibility(0);
          this.Xra.setOnClickListener(new q.b.b..ExternalSyntheticLambda0(q.b.this, parampb));
          localObject2 = (Iterable)this.nnY;
          localObject1 = q.b.this;
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (View)((Iterator)localObject2).next();
            if (localObject3 != null)
            {
              this.RnD.removeView((View)localObject3);
              ((q.b)localObject1).XqM.add(localObject3);
            }
          }
          this.nnY.clear();
          if ((parampb.YSg != null) && (parampb.YSg.ZmL != null) && (parampb.YSg.ZmL.size() > 0))
          {
            localObject1 = parampb.YSg.ZmL;
            s.s(localObject1, "replyList");
            localObject1 = (Iterable)localObject1;
            localObject2 = q.b.this;
            localObject3 = ((Iterable)localObject1).iterator();
            int i = 0;
            if (((Iterator)localObject3).hasNext())
            {
              localObject1 = ((Iterator)localObject3).next();
              if (i < 0) {
                kotlin.a.p.kkW();
              }
              localObject4 = (aeq)localObject1;
              if (((q.b)localObject2).XqM.size() > 0)
              {
                localObject1 = ((q.b)localObject2).XqM.remove(0);
                s.s(localObject1, "viewPool.removeAt(0)");
                localObject1 = (View)localObject1;
              }
              for (;;)
              {
                this.nnY.add(localObject1);
                this.RnD.addView((View)localObject1);
                s.s(localObject4, "reply");
                ((q.b)localObject2).a(parampb, (aeq)localObject4, new q.b.a((q.b)localObject2, (View)localObject1), i);
                i += 1;
                break;
                localObject1 = View.inflate(((q.b)localObject2).context, c.g.mp_comment_content_item, null);
                s.s(localObject1, "inflate(context, R.layou…mment_content_item, null)");
              }
            }
          }
        }
        AppMethodBeat.o(298067);
      }
    }
    
    @Metadata(d1={""}, d2={"<no name provided>", "", "delFlag", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends u
      implements kotlin.g.a.b<Integer, Boolean>
    {
      d(q.b.a parama, q.b paramb, pb parampb)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$hideAnimation$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "ani", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Animation.AnimationListener
  {
    d(q paramq) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(82714);
      s.u(paramAnimation, "ani");
      paramAnimation = this.XqI.getWeakThis$plugin_webview_release().get();
      if (paramAnimation == null)
      {
        paramAnimation = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MPWriteCommentLayout");
        AppMethodBeat.o(82714);
        throw paramAnimation;
      }
      ((q)paramAnimation).setVisibility(8);
      q.d(this.XqI).clearAnimation();
      AppMethodBeat.o(82714);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation) {}
    
    public final void onAnimationStart(Animation paramAnimation) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<MPSmileyFooter>
  {
    e(q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.q
 * JD-Core Version:    0.7.0.1
 */
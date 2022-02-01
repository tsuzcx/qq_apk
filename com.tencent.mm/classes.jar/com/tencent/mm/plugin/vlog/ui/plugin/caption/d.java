package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.protocal.protobuf.rt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ao;
import d.a.j;
import d.f;
import d.g;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapters", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter;", "captionPanel", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "getCaptionPanel", "()Landroid/view/ViewGroup;", "captionPanel$delegate", "Lkotlin/Lazy;", "captionTab", "getCaptionTab", "captionTab$delegate", "captionTabIndicator", "Landroid/view/View;", "getCaptionTabIndicator", "()Landroid/view/View;", "captionTabIndicator$delegate", "captionTabSpace", "getCaptionTabSpace", "captionTabSpace$delegate", "captionTabText", "Landroid/widget/TextView;", "getCaptionTabText", "()Landroid/widget/TextView;", "captionTabText$delegate", "captionViews", "Landroid/support/v7/widget/RecyclerView;", "getCaptionViews", "()Ljava/util/List;", "captionViews$delegate", "clearRecordBtn", "getClearRecordBtn", "clearRecordBtn$delegate", "clearTransListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "type", "", "hasTranslate", "", "getClearTransListener", "()Lkotlin/jvm/functions/Function2;", "setClearTransListener", "(Lkotlin/jvm/functions/Function2;)V", "contentLayout", "Landroid/widget/LinearLayout;", "getContentLayout", "()Landroid/widget/LinearLayout;", "contentLayout$delegate", "curTab", "currentPos", "", "dismissListener", "Lkotlin/Function0;", "getDismissListener", "()Lkotlin/jvm/functions/Function0;", "setDismissListener", "(Lkotlin/jvm/functions/Function0;)V", "emptyLayout", "getEmptyLayout", "emptyLayout$delegate", "emptyTipTxt", "getEmptyTipTxt", "emptyTipTxt$delegate", "itemClickListener", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "result", "getItemClickListener", "setItemClickListener", "loadingView", "getLoadingView", "loadingView$delegate", "onTouchingView", "recordCaptionPanel", "getRecordCaptionPanel", "recordCaptionPanel$delegate", "recordCaptionTab", "getRecordCaptionTab", "recordCaptionTab$delegate", "recordCaptionTabIndicator", "getRecordCaptionTabIndicator", "recordCaptionTabIndicator$delegate", "recordCaptionTabText", "getRecordCaptionTabText", "recordCaptionTabText$delegate", "recordContentLayout", "getRecordContentLayout", "recordContentLayout$delegate", "recordEmptyLayout", "getRecordEmptyLayout", "recordEmptyLayout$delegate", "recordLoadingView", "getRecordLoadingView", "recordLoadingView$delegate", "recordTransBtn", "getRecordTransBtn", "recordTransBtn$delegate", "startTransListener", "Lkotlin/Function1;", "getStartTransListener", "()Lkotlin/jvm/functions/Function1;", "setStartTransListener", "(Lkotlin/jvm/functions/Function1;)V", "transBtn", "getTransBtn", "transBtn$delegate", "videoPauseListener", "getVideoPauseListener", "setVideoPauseListener", "videoSeekListener", "", "timestampMs", "getVideoSeekListener", "setVideoSeekListener", "addCaptionItemData", "items", "clearCaption", "tip", "", "clearCaptionData", "disableRecordCaption", "enableRecordCaption", "ifCenter", "view", "notifyDataSetChanged", "scrollToMid", "scrollToTimeMs", "timeStampMs", "showCaption", "showLoading", "switchTab", "tabIndex", "time2Pos", "updateSelectItemData", "transResult", "CaptionScrollListener", "Companion", "EditorCaptionAdapter", "plugin-vlog_release"})
public final class d
  extends RelativeLayout
{
  public static final d.b BQV;
  private final f BQA;
  private final f BQB;
  private final f BQC;
  private final f BQD;
  private final f BQE;
  private final f BQF;
  private final f BQG;
  private final f BQH;
  private final f BQI;
  private final f BQJ;
  private final f BQK;
  private final f BQL;
  final List<c> BQM;
  private d.g.a.a<z> BQN;
  private d.g.a.b<? super Long, z> BQO;
  private d.g.a.b<? super Integer, z> BQP;
  private m<? super Integer, ? super Boolean, z> BQQ;
  private d.g.a.a<z> BQR;
  private List<Integer> BQS;
  private boolean BQT;
  private int BQU;
  private final f BQs;
  private final f BQt;
  private final f BQu;
  private final f BQv;
  private final f BQw;
  private final f BQx;
  private final f BQy;
  private final f BQz;
  private m<? super Integer, ? super rt, z> pVb;
  
  static
  {
    AppMethodBeat.i(196583);
    BQV = new d.b((byte)0);
    AppMethodBeat.o(196583);
  }
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(196582);
    this.BQs = g.O((d.g.a.a)new e(this));
    this.BQt = g.O((d.g.a.a)new h(this));
    this.BQu = g.O((d.g.a.a)new f(this));
    this.BQv = g.O((d.g.a.a)new p(this));
    this.BQw = g.O((d.g.a.a)new r(this));
    this.BQx = g.O((d.g.a.a)new q(this));
    this.BQy = g.O((d.g.a.a)new g(this));
    this.BQz = g.O((d.g.a.a)new d(this));
    this.BQA = g.O((d.g.a.a)new o(this));
    this.BQB = g.O((d.g.a.a)new w(this));
    this.BQC = g.O((d.g.a.a)new v(this));
    this.BQD = g.O((d.g.a.a)new s(this));
    this.BQE = g.O((d.g.a.a)new u(this));
    this.BQF = g.O((d.g.a.a)new t(this));
    this.BQG = g.O((d.g.a.a)new j(this));
    this.BQH = g.O((d.g.a.a)new i(this));
    this.BQI = g.O((d.g.a.a)new l(this));
    this.BQJ = g.O((d.g.a.a)new m(this));
    this.BQK = g.O((d.g.a.a)new k(this));
    this.BQL = g.O((d.g.a.a)new n(this));
    this.BQM = j.listOf(new c[] { new c(0, paramContext), new c(1, paramContext) });
    this.BQS = j.mutableListOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(0) });
    LayoutInflater.from(paramContext).inflate(2131496169, (ViewGroup)this, true);
    Object localObject = getContentLayout();
    p.g(localObject, "contentLayout");
    ((LinearLayout)localObject).setVisibility(4);
    localObject = getEmptyLayout();
    p.g(localObject, "emptyLayout");
    ((LinearLayout)localObject).setVisibility(0);
    getCaptionTab().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196515);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        d.c(this.BQW, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196515);
      }
    });
    getRecordCaptionTab().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196516);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        d.c(this.BQW, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196516);
      }
    });
    findViewById(2131308236).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196517);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = this.BQW.getDismissListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196517);
      }
    });
    findViewById(2131306059).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196518);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = d.e(this.BQW);
        p.g(paramAnonymousView, "contentLayout");
        paramAnonymousView.setVisibility(0);
        paramAnonymousView = d.f(this.BQW);
        p.g(paramAnonymousView, "emptyLayout");
        paramAnonymousView.setVisibility(4);
        paramAnonymousView = this.BQW.getStartTransListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(0));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196518);
      }
    });
    findViewById(2131308260).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196519);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        d.a(this.BQW, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196519);
      }
    });
    getRecordTransBtn().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196520);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = d.g(this.BQW);
        p.g(paramAnonymousView, "recordContentLayout");
        paramAnonymousView.setVisibility(0);
        paramAnonymousView = d.h(this.BQW);
        p.g(paramAnonymousView, "recordEmptyLayout");
        paramAnonymousView.setVisibility(4);
        paramAnonymousView = this.BQW.getStartTransListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(1));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196520);
      }
    });
    getClearRecordBtn().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196521);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        d.a(this.BQW, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196521);
      }
    });
    int i = 0;
    while (i < 2)
    {
      localObject = getCaptionViews().get(i);
      p.g(localObject, "captionViews[i]");
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.i)new EditorCaptionLayoutManager(paramContext));
      localObject = getCaptionViews().get(i);
      p.g(localObject, "captionViews[i]");
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.BQM.get(i));
      ((RecyclerView)getCaptionViews().get(i)).a((RecyclerView.m)new a(i));
      i += 1;
    }
    AppMethodBeat.o(196582);
  }
  
  private final int aG(int paramInt, long paramLong)
  {
    AppMethodBeat.i(196580);
    if (((Number)this.BQS.get(paramInt)).intValue() >= ((c)this.BQM.get(paramInt)).BQn.size())
    {
      ad.i("MicroMsg.EditorTextCaptionView", "maybe clear captionItems");
      this.BQS.set(paramInt, Integer.valueOf(((c)this.BQM.get(paramInt)).BQn.size() - 1));
    }
    int i;
    if (((rt)((c)this.BQM.get(paramInt)).BQn.get(((Number)this.BQS.get(paramInt)).intValue())).FNR > paramLong)
    {
      this.BQS.set(paramInt, Integer.valueOf(0));
      i = 1;
    }
    for (;;)
    {
      Object localObject;
      if (((rt)((c)this.BQM.get(paramInt)).BQn.get(((Number)this.BQS.get(paramInt)).intValue())).FNS < paramLong)
      {
        localObject = this.BQS;
        ((List)localObject).set(paramInt, Integer.valueOf(((Number)((List)localObject).get(paramInt)).intValue() + 1));
      }
      else
      {
        ((c)this.BQM.get(paramInt)).adl = ((Number)this.BQS.get(paramInt)).intValue();
        if (i != 0)
        {
          localObject = (RecyclerView)getCaptionViews().get(paramInt);
          com.tencent.mm.hellhoundlib.b.a locala = c.a(((Number)this.BQS.get(paramInt)).intValue(), new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "time2Pos", "(IJ)I", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerView)localObject).ca(((Integer)locala.mq(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "time2Pos", "(IJ)I", "Undefined", "scrollToPosition", "(I)V");
        }
        paramInt = ((Number)this.BQS.get(paramInt)).intValue();
        AppMethodBeat.o(196580);
        return paramInt;
        i = 0;
      }
    }
  }
  
  private final ViewGroup getCaptionPanel()
  {
    AppMethodBeat.i(196562);
    ViewGroup localViewGroup = (ViewGroup)this.BQz.getValue();
    AppMethodBeat.o(196562);
    return localViewGroup;
  }
  
  private final ViewGroup getCaptionTab()
  {
    AppMethodBeat.i(196555);
    ViewGroup localViewGroup = (ViewGroup)this.BQs.getValue();
    AppMethodBeat.o(196555);
    return localViewGroup;
  }
  
  private final List<RecyclerView> getCaptionViews()
  {
    AppMethodBeat.i(196570);
    List localList = (List)this.BQH.getValue();
    AppMethodBeat.o(196570);
    return localList;
  }
  
  private final ViewGroup getClearRecordBtn()
  {
    AppMethodBeat.i(196569);
    ViewGroup localViewGroup = (ViewGroup)this.BQG.getValue();
    AppMethodBeat.o(196569);
    return localViewGroup;
  }
  
  private final TextView getEmptyTipTxt()
  {
    AppMethodBeat.i(196572);
    TextView localTextView = (TextView)this.BQJ.getValue();
    AppMethodBeat.o(196572);
    return localTextView;
  }
  
  private final ViewGroup getRecordCaptionPanel()
  {
    AppMethodBeat.i(196563);
    ViewGroup localViewGroup = (ViewGroup)this.BQA.getValue();
    AppMethodBeat.o(196563);
    return localViewGroup;
  }
  
  private final View getRecordCaptionTabIndicator()
  {
    AppMethodBeat.i(196560);
    View localView = (View)this.BQx.getValue();
    AppMethodBeat.o(196560);
    return localView;
  }
  
  private final TextView getRecordCaptionTabText()
  {
    AppMethodBeat.i(196559);
    TextView localTextView = (TextView)this.BQw.getValue();
    AppMethodBeat.o(196559);
    return localTextView;
  }
  
  private final TextView getRecordTransBtn()
  {
    AppMethodBeat.i(196565);
    TextView localTextView = (TextView)this.BQC.getValue();
    AppMethodBeat.o(196565);
    return localTextView;
  }
  
  final void NS(int paramInt)
  {
    AppMethodBeat.i(196581);
    this.BQU = paramInt;
    if (this.BQU == 0)
    {
      localObject = getCaptionTabIndicator();
      p.g(localObject, "captionTabIndicator");
      ((View)localObject).setVisibility(0);
      localObject = getRecordCaptionTabIndicator();
      p.g(localObject, "recordCaptionTabIndicator");
      ((View)localObject).setVisibility(4);
      localObject = getCaptionTabText();
      localContext = getContext();
      p.g(localContext, "context");
      ((TextView)localObject).setTextColor(localContext.getResources().getColor(2131101182));
      localObject = getRecordCaptionTabText();
      localContext = getContext();
      p.g(localContext, "context");
      ((TextView)localObject).setTextColor(localContext.getResources().getColor(2131101183));
      localObject = getCaptionPanel();
      p.g(localObject, "captionPanel");
      ((ViewGroup)localObject).setVisibility(0);
      localObject = getRecordCaptionPanel();
      p.g(localObject, "recordCaptionPanel");
      ((ViewGroup)localObject).setVisibility(8);
      AppMethodBeat.o(196581);
      return;
    }
    Object localObject = getCaptionTabIndicator();
    p.g(localObject, "captionTabIndicator");
    ((View)localObject).setVisibility(4);
    localObject = getRecordCaptionTabIndicator();
    p.g(localObject, "recordCaptionTabIndicator");
    ((View)localObject).setVisibility(0);
    localObject = getCaptionTabText();
    Context localContext = getContext();
    p.g(localContext, "context");
    ((TextView)localObject).setTextColor(localContext.getResources().getColor(2131101183));
    localObject = getRecordCaptionTabText();
    localContext = getContext();
    p.g(localContext, "context");
    ((TextView)localObject).setTextColor(localContext.getResources().getColor(2131101182));
    localObject = getCaptionPanel();
    p.g(localObject, "captionPanel");
    ((ViewGroup)localObject).setVisibility(8);
    localObject = getRecordCaptionPanel();
    p.g(localObject, "recordCaptionPanel");
    ((ViewGroup)localObject).setVisibility(0);
    AppMethodBeat.o(196581);
  }
  
  final void TH(int paramInt)
  {
    AppMethodBeat.i(196577);
    ((c)this.BQM.get(paramInt)).BQn.clear();
    AppMethodBeat.o(196577);
  }
  
  public final void TI(int paramInt)
  {
    AppMethodBeat.i(196578);
    ((c)this.BQM.get(paramInt)).notifyDataSetChanged();
    AppMethodBeat.o(196578);
  }
  
  public final void aF(int paramInt, long paramLong)
  {
    AppMethodBeat.i(196579);
    if ((this.BQT) || (((c)this.BQM.get(paramInt)).BQn.isEmpty()))
    {
      AppMethodBeat.o(196579);
      return;
    }
    int i = ((Number)this.BQS.get(paramInt)).intValue();
    aG(paramInt, paramLong);
    Object localObject = getCaptionViews().get(paramInt);
    p.g(localObject, "captionViews[type]");
    localObject = ((RecyclerView)localObject).getLayoutManager();
    if (localObject != null)
    {
      ((RecyclerView.i)localObject).a((RecyclerView)getCaptionViews().get(paramInt), new RecyclerView.t(), ((Number)this.BQS.get(paramInt)).intValue());
      this.BQM.get(paramInt);
      c.fI(((RecyclerView.i)localObject).bY(i));
      this.BQM.get(paramInt);
      c.fH(((RecyclerView.i)localObject).bY(((Number)this.BQS.get(paramInt)).intValue()));
      AppMethodBeat.o(196579);
      return;
    }
    AppMethodBeat.o(196579);
  }
  
  public final void cn(int paramInt, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(196575);
    TH(paramInt);
    TI(paramInt);
    Object localObject;
    if (paramInt == 0)
    {
      localObject = getLoadingView();
      p.g(localObject, "loadingView");
      ((View)localObject).setVisibility(4);
      localObject = getContentLayout();
      p.g(localObject, "contentLayout");
      ((LinearLayout)localObject).setVisibility(4);
      localObject = getEmptyLayout();
      p.g(localObject, "emptyLayout");
      ((LinearLayout)localObject).setVisibility(0);
    }
    for (;;)
    {
      if (paramString != null)
      {
        localObject = getEmptyTipTxt();
        p.g(localObject, "emptyTipTxt");
        ((TextView)localObject).setText((CharSequence)paramString);
      }
      paramString = this.BQQ;
      if (paramString == null) {
        break;
      }
      localObject = getEmptyLayout();
      p.g(localObject, "emptyLayout");
      if (((LinearLayout)localObject).getVisibility() != 4)
      {
        localObject = getRecordEmptyLayout();
        p.g(localObject, "recordEmptyLayout");
        if (((ViewGroup)localObject).getVisibility() != 4) {}
      }
      else
      {
        bool = true;
      }
      paramString.p(Integer.valueOf(paramInt), Boolean.valueOf(bool));
      AppMethodBeat.o(196575);
      return;
      localObject = getRecordLoadingView();
      p.g(localObject, "recordLoadingView");
      ((View)localObject).setVisibility(4);
      localObject = getRecordContentLayout();
      p.g(localObject, "recordContentLayout");
      ((ViewGroup)localObject).setVisibility(4);
      localObject = getRecordEmptyLayout();
      p.g(localObject, "recordEmptyLayout");
      ((ViewGroup)localObject).setVisibility(0);
    }
    AppMethodBeat.o(196575);
  }
  
  final View getCaptionTabIndicator()
  {
    AppMethodBeat.i(196557);
    View localView = (View)this.BQu.getValue();
    AppMethodBeat.o(196557);
    return localView;
  }
  
  final View getCaptionTabSpace()
  {
    AppMethodBeat.i(196561);
    View localView = (View)this.BQy.getValue();
    AppMethodBeat.o(196561);
    return localView;
  }
  
  final TextView getCaptionTabText()
  {
    AppMethodBeat.i(196556);
    TextView localTextView = (TextView)this.BQt.getValue();
    AppMethodBeat.o(196556);
    return localTextView;
  }
  
  public final m<Integer, Boolean, z> getClearTransListener()
  {
    return this.BQQ;
  }
  
  final LinearLayout getContentLayout()
  {
    AppMethodBeat.i(196573);
    LinearLayout localLinearLayout = (LinearLayout)this.BQK.getValue();
    AppMethodBeat.o(196573);
    return localLinearLayout;
  }
  
  public final d.g.a.a<z> getDismissListener()
  {
    return this.BQR;
  }
  
  final LinearLayout getEmptyLayout()
  {
    AppMethodBeat.i(196571);
    LinearLayout localLinearLayout = (LinearLayout)this.BQI.getValue();
    AppMethodBeat.o(196571);
    return localLinearLayout;
  }
  
  public final m<Integer, rt, z> getItemClickListener()
  {
    return this.pVb;
  }
  
  final View getLoadingView()
  {
    AppMethodBeat.i(196574);
    View localView = (View)this.BQL.getValue();
    AppMethodBeat.o(196574);
    return localView;
  }
  
  final ViewGroup getRecordCaptionTab()
  {
    AppMethodBeat.i(196558);
    ViewGroup localViewGroup = (ViewGroup)this.BQv.getValue();
    AppMethodBeat.o(196558);
    return localViewGroup;
  }
  
  final ViewGroup getRecordContentLayout()
  {
    AppMethodBeat.i(196566);
    ViewGroup localViewGroup = (ViewGroup)this.BQD.getValue();
    AppMethodBeat.o(196566);
    return localViewGroup;
  }
  
  final ViewGroup getRecordEmptyLayout()
  {
    AppMethodBeat.i(196568);
    ViewGroup localViewGroup = (ViewGroup)this.BQF.getValue();
    AppMethodBeat.o(196568);
    return localViewGroup;
  }
  
  final View getRecordLoadingView()
  {
    AppMethodBeat.i(196567);
    View localView = (View)this.BQE.getValue();
    AppMethodBeat.o(196567);
    return localView;
  }
  
  public final d.g.a.b<Integer, z> getStartTransListener()
  {
    return this.BQP;
  }
  
  final TextView getTransBtn()
  {
    AppMethodBeat.i(196564);
    TextView localTextView = (TextView)this.BQB.getValue();
    AppMethodBeat.o(196564);
    return localTextView;
  }
  
  public final d.g.a.a<z> getVideoPauseListener()
  {
    return this.BQN;
  }
  
  public final d.g.a.b<Long, z> getVideoSeekListener()
  {
    return this.BQO;
  }
  
  public final void setClearTransListener(m<? super Integer, ? super Boolean, z> paramm)
  {
    this.BQQ = paramm;
  }
  
  public final void setDismissListener(d.g.a.a<z> parama)
  {
    this.BQR = parama;
  }
  
  public final void setItemClickListener(m<? super Integer, ? super rt, z> paramm)
  {
    this.pVb = paramm;
  }
  
  public final void setStartTransListener(d.g.a.b<? super Integer, z> paramb)
  {
    this.BQP = paramb;
  }
  
  public final void setVideoPauseListener(d.g.a.a<z> parama)
  {
    this.BQN = parama;
  }
  
  public final void setVideoSeekListener(d.g.a.b<? super Long, z> paramb)
  {
    this.BQO = paramb;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener;", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "type", "", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView;I)V", "getType", "()I", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "plugin-vlog_release"})
  public final class a
    extends RecyclerView.m
  {
    private final int type;
    
    public a()
    {
      int i;
      this.type = i;
    }
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(196523);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt1);
      localb.mr(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
      p.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      if (!d.a(d.this))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(196523);
        return;
      }
      paramInt2 = ((Number)d.c(d.this).get(this.type)).intValue();
      paramRecyclerView = d.d(d.this).get(this.type);
      p.g(paramRecyclerView, "captionViews[type]");
      paramRecyclerView = ((RecyclerView)paramRecyclerView).getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(196523);
        throw paramRecyclerView;
      }
      paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
      int i = (paramRecyclerView.km() + paramRecyclerView.ko()) / 2;
      if (i == ((d.c)d.b(d.this).get(this.type)).adl)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(196523);
        return;
      }
      paramInt1 = i - 1;
      i += 1;
      if (paramInt1 <= i) {}
      for (;;)
      {
        if (d.a(d.this, this.type, paramRecyclerView.bY(paramInt1)))
        {
          d.c(d.this).set(this.type, Integer.valueOf(paramInt1));
          ((d.c)d.b(d.this).get(this.type)).adl = ((Number)d.c(d.this).get(this.type)).intValue();
          d.b(d.this).get(this.type);
          d.c.fI(paramRecyclerView.bY(paramInt2));
          d.b(d.this).get(this.type);
          d.c.fH(paramRecyclerView.bY(((Number)d.c(d.this).get(this.type)).intValue()));
          ad.d("MicroMsg.EditorTextCaptionView", "onScrolled currentPos  " + d.c(d.this) + ' ' + paramInt2);
        }
        while (paramInt1 == i)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(196523);
          return;
        }
        paramInt1 += 1;
      }
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(196522);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
      p.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      switch (paramInt)
      {
      }
      do
      {
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(196522);
          return;
          ad.d("MicroMsg.EditorTextCaptionView", "SCROLL_STATE_DRAGGING");
          d.a(d.this, true);
          paramRecyclerView = d.this.getVideoPauseListener();
          if (paramRecyclerView != null) {
            paramRecyclerView.invoke();
          }
        }
      } while (!d.a(d.this));
      long l = ((rt)((d.c)d.b(d.this).get(this.type)).BQn.get(((Number)d.c(d.this).get(this.type)).intValue())).FNR;
      paramRecyclerView = d.this.getVideoSeekListener();
      if (paramRecyclerView != null) {
        if (l >= 2147483637L) {
          break label252;
        }
      }
      for (;;)
      {
        paramRecyclerView.invoke(Long.valueOf(l));
        d.a(d.this, false);
        d.b(d.this, this.type);
        break;
        label252:
        l = 0L;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "type", "", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView;ILandroid/content/Context;)V", "captionItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "getCaptionItems", "()Ljava/util/ArrayList;", "setCaptionItems", "(Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "currentPos", "getCurrentPos", "()I", "setCurrentPos", "(I)V", "getItemCount", "getString", "", "byte", "Lcom/tencent/mm/protobuf/ByteString;", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "selectView", "itemView", "Landroid/view/View;", "ccTransResult", "unSelectView", "plugin-vlog_release"})
  public final class c
    extends RecyclerView.a<RecyclerView.w>
  {
    ArrayList<rt> BQn;
    int adl;
    private Context context;
    private final int type;
    
    public c(Context paramContext)
    {
      AppMethodBeat.i(196532);
      this.type = paramContext;
      this.context = localObject;
      this.BQn = new ArrayList();
      AppMethodBeat.o(196532);
    }
    
    private static void a(View paramView, rt paramrt)
    {
      AppMethodBeat.i(196528);
      if (paramView == null)
      {
        AppMethodBeat.o(196528);
        return;
      }
      paramView.setAlpha(1.0F);
      paramView = (ImageView)paramView.findViewById(2131307290);
      if ((paramrt != null) && (paramrt.FNT == true))
      {
        p.g(paramView, "img");
        paramView.setVisibility(4);
        AppMethodBeat.o(196528);
        return;
      }
      p.g(paramView, "img");
      paramView.setImageDrawable(ao.k(paramView.getContext(), 2131690457, -1));
      paramView.setVisibility(0);
      AppMethodBeat.o(196528);
    }
    
    private static String b(com.tencent.mm.bx.b paramb)
    {
      AppMethodBeat.i(196531);
      if (paramb == null)
      {
        AppMethodBeat.o(196531);
        return "";
      }
      paramb = paramb.toString("UTF-8");
      p.g(paramb, "byte.toString(\"UTF-8\")");
      AppMethodBeat.o(196531);
      return paramb;
    }
    
    public static void fI(View paramView)
    {
      AppMethodBeat.i(196530);
      if (paramView == null)
      {
        AppMethodBeat.o(196530);
        return;
      }
      paramView.setAlpha(0.5F);
      paramView = paramView.findViewById(2131307290);
      p.g(paramView, "itemView.findViewById<Im…eView>(R.id.caption_edit)");
      ((ImageView)paramView).setVisibility(4);
      AppMethodBeat.o(196530);
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(196525);
      p.h(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(this.context).inflate(2131496168, paramViewGroup, false);
      if (paramViewGroup == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(196525);
        throw paramViewGroup;
      }
      paramViewGroup = (ViewGroup)paramViewGroup;
      paramViewGroup = (RecyclerView.w)new b(paramViewGroup, (View)paramViewGroup);
      AppMethodBeat.o(196525);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, final int paramInt)
    {
      AppMethodBeat.i(196527);
      p.h(paramw, "viewHolder");
      Object localObject = paramw.auu;
      p.g(localObject, "viewHolder.itemView");
      if ((TextUtils.isEmpty((CharSequence)b(((rt)this.BQn.get(paramInt)).FNQ))) || (((rt)this.BQn.get(paramInt)).FNT))
      {
        ((View)localObject).setVisibility(4);
        paramw.auu.setOnClickListener((View.OnClickListener)new a(this, paramInt));
        AppMethodBeat.o(196527);
        return;
      }
      ((View)localObject).setVisibility(0);
      if (this.adl == paramInt) {
        a((View)localObject, (rt)this.BQn.get(paramInt));
      }
      for (;;)
      {
        localObject = (TextView)((View)localObject).findViewById(2131307289);
        p.g(localObject, "contentView");
        ((TextView)localObject).setText((CharSequence)b(((rt)this.BQn.get(paramInt)).FNQ));
        break;
        fI((View)localObject);
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(196526);
      int i = this.BQn.size();
      AppMethodBeat.o(196526);
      return i;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(d.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(196524);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if (!((rt)this.BQX.BQn.get(paramInt)).FNT)
        {
          paramView = this.BQX.BQW.getItemClickListener();
          if (paramView != null)
          {
            int i = d.c.a(this.BQX);
            localObject = this.BQX.BQn.get(paramInt);
            p.g(localObject, "captionItems[position]");
            paramView.p(Integer.valueOf(i), localObject);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196524);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter$onCreateViewHolder$1", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-vlog_release"})
    public static final class b
      extends RecyclerView.w
    {
      b(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<ViewGroup>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<ViewGroup>
  {
    e(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<View>
  {
    f(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<View>
  {
    g(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<TextView>
  {
    h(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements d.g.a.a<List<? extends RecyclerView>>
  {
    i(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends q
    implements d.g.a.a<ViewGroup>
  {
    j(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements d.g.a.a<LinearLayout>
  {
    k(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements d.g.a.a<LinearLayout>
  {
    l(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends q
    implements d.g.a.a<TextView>
  {
    m(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends q
    implements d.g.a.a<View>
  {
    n(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class o
    extends q
    implements d.g.a.a<ViewGroup>
  {
    o(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class p
    extends q
    implements d.g.a.a<ViewGroup>
  {
    p(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class q
    extends q
    implements d.g.a.a<View>
  {
    q(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class r
    extends q
    implements d.g.a.a<TextView>
  {
    r(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class s
    extends q
    implements d.g.a.a<ViewGroup>
  {
    s(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class t
    extends q
    implements d.g.a.a<ViewGroup>
  {
    t(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class u
    extends q
    implements d.g.a.a<View>
  {
    u(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class v
    extends q
    implements d.g.a.a<TextView>
  {
    v(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class w
    extends q
    implements d.g.a.a<TextView>
  {
    w(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.d
 * JD-Core Version:    0.7.0.1
 */
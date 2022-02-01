package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapters", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter;", "captionPanel", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "getCaptionPanel", "()Landroid/view/ViewGroup;", "captionPanel$delegate", "Lkotlin/Lazy;", "captionTab", "getCaptionTab", "captionTab$delegate", "captionTabIndicator", "Landroid/view/View;", "getCaptionTabIndicator", "()Landroid/view/View;", "captionTabIndicator$delegate", "captionTabSpace", "getCaptionTabSpace", "captionTabSpace$delegate", "captionTabText", "Landroid/widget/TextView;", "getCaptionTabText", "()Landroid/widget/TextView;", "captionTabText$delegate", "captionViews", "Landroid/support/v7/widget/RecyclerView;", "getCaptionViews", "()Ljava/util/List;", "captionViews$delegate", "clearRecordBtn", "getClearRecordBtn", "clearRecordBtn$delegate", "clearTransListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "type", "", "hasTranslate", "", "getClearTransListener", "()Lkotlin/jvm/functions/Function2;", "setClearTransListener", "(Lkotlin/jvm/functions/Function2;)V", "contentLayout", "getContentLayout", "()Landroid/widget/LinearLayout;", "contentLayout$delegate", "curTab", "currentPos", "", "dismissListener", "Lkotlin/Function0;", "getDismissListener", "()Lkotlin/jvm/functions/Function0;", "setDismissListener", "(Lkotlin/jvm/functions/Function0;)V", "emptyLayout", "getEmptyLayout", "emptyLayout$delegate", "emptyTipTxt", "getEmptyTipTxt", "emptyTipTxt$delegate", "itemClickListener", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "result", "getItemClickListener", "setItemClickListener", "loadingView", "getLoadingView", "loadingView$delegate", "onTouchingView", "recordCaptionPanel", "getRecordCaptionPanel", "recordCaptionPanel$delegate", "recordCaptionTab", "getRecordCaptionTab", "recordCaptionTab$delegate", "recordCaptionTabIndicator", "getRecordCaptionTabIndicator", "recordCaptionTabIndicator$delegate", "recordCaptionTabText", "getRecordCaptionTabText", "recordCaptionTabText$delegate", "recordContentLayout", "getRecordContentLayout", "recordContentLayout$delegate", "recordEmptyLayout", "getRecordEmptyLayout", "recordEmptyLayout$delegate", "recordLoadingView", "getRecordLoadingView", "recordLoadingView$delegate", "recordTransBtn", "getRecordTransBtn", "recordTransBtn$delegate", "startTransListener", "Lkotlin/Function1;", "getStartTransListener", "()Lkotlin/jvm/functions/Function1;", "setStartTransListener", "(Lkotlin/jvm/functions/Function1;)V", "transBtn", "getTransBtn", "transBtn$delegate", "videoPauseListener", "getVideoPauseListener", "setVideoPauseListener", "videoSeekListener", "", "timestampMs", "getVideoSeekListener", "setVideoSeekListener", "addCaptionItemData", "items", "clearCaption", "tip", "", "clearCaptionData", "disableRecordCaption", "enableRecordCaption", "ifCenter", "view", "notifyDataSetChanged", "scrollToMid", "scrollToTimeMs", "timeStampMs", "showCaption", "showLoading", "switchTab", "tabIndex", "time2Pos", "updateSelectItemData", "transResult", "CaptionScrollListener", "Companion", "EditorCaptionAdapter", "plugin-vlog_release"})
public final class d
  extends LinearLayout
{
  public static final d.b GLf;
  private final f GKD;
  private final f GKE;
  private final f GKF;
  private final f GKG;
  private final f GKH;
  private final f GKI;
  private final f GKJ;
  private final f GKK;
  private final f GKL;
  private final f GKM;
  private final f GKN;
  private final f GKO;
  private final f GKP;
  private final f GKQ;
  private final f GKR;
  private final f GKS;
  private final f GKT;
  private final f GKU;
  private final f GKV;
  final List<c> GKW;
  private kotlin.g.a.a<x> GKX;
  private kotlin.g.a.b<? super Long, x> GKY;
  private kotlin.g.a.b<? super Integer, x> GKZ;
  private m<? super Integer, ? super Boolean, x> GLa;
  private kotlin.g.a.a<x> GLb;
  private List<Integer> GLc;
  private boolean GLd;
  private int GLe;
  private m<? super Integer, ? super sy, x> rsD;
  private final f uZY;
  
  static
  {
    AppMethodBeat.i(191731);
    GLf = new d.b((byte)0);
    AppMethodBeat.o(191731);
  }
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(191730);
    this.GKD = g.ah((kotlin.g.a.a)new e(this));
    this.GKE = g.ah((kotlin.g.a.a)new h(this));
    this.GKF = g.ah((kotlin.g.a.a)new f(this));
    this.GKG = g.ah((kotlin.g.a.a)new p(this));
    this.GKH = g.ah((kotlin.g.a.a)new r(this));
    this.GKI = g.ah((kotlin.g.a.a)new q(this));
    this.GKJ = g.ah((kotlin.g.a.a)new g(this));
    this.GKK = g.ah((kotlin.g.a.a)new d(this));
    this.GKL = g.ah((kotlin.g.a.a)new o(this));
    this.GKM = g.ah((kotlin.g.a.a)new w(this));
    this.GKN = g.ah((kotlin.g.a.a)new v(this));
    this.GKO = g.ah((kotlin.g.a.a)new s(this));
    this.GKP = g.ah((kotlin.g.a.a)new u(this));
    this.GKQ = g.ah((kotlin.g.a.a)new t(this));
    this.GKR = g.ah((kotlin.g.a.a)new j(this));
    this.GKS = g.ah((kotlin.g.a.a)new i(this));
    this.GKT = g.ah((kotlin.g.a.a)new l(this));
    this.GKU = g.ah((kotlin.g.a.a)new m(this));
    this.uZY = g.ah((kotlin.g.a.a)new k(this));
    this.GKV = g.ah((kotlin.g.a.a)new n(this));
    this.GKW = j.listOf(new c[] { new c(0, paramContext), new c(1, paramContext) });
    this.GLc = j.mutableListOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(0) });
    LayoutInflater.from(paramContext).inflate(2131493895, (ViewGroup)this, true);
    setBackgroundResource(2131231174);
    setOrientation(1);
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
        AppMethodBeat.i(191663);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        d.c(this.GLg, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191663);
      }
    });
    getRecordCaptionTab().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191664);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        d.c(this.GLg, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191664);
      }
    });
    findViewById(2131297975).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191665);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = this.GLg.getDismissListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191665);
      }
    });
    findViewById(2131309388).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191666);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = d.e(this.GLg);
        p.g(paramAnonymousView, "contentLayout");
        paramAnonymousView.setVisibility(0);
        paramAnonymousView = d.f(this.GLg);
        p.g(paramAnonymousView, "emptyLayout");
        paramAnonymousView.setVisibility(4);
        paramAnonymousView = this.GLg.getStartTransListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(0));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191666);
      }
    });
    findViewById(2131298745).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191667);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        d.a(this.GLg, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191667);
      }
    });
    getRecordTransBtn().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191668);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = d.g(this.GLg);
        p.g(paramAnonymousView, "recordContentLayout");
        paramAnonymousView.setVisibility(0);
        paramAnonymousView = d.h(this.GLg);
        p.g(paramAnonymousView, "recordEmptyLayout");
        paramAnonymousView.setVisibility(4);
        paramAnonymousView = this.GLg.getStartTransListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(1));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191668);
      }
    });
    getClearRecordBtn().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191669);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        d.a(this.GLg, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191669);
      }
    });
    int i = 0;
    while (i < 2)
    {
      localObject = getCaptionViews().get(i);
      p.g(localObject, "captionViews[i]");
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new EditorCaptionLayoutManager(paramContext));
      localObject = getCaptionViews().get(i);
      p.g(localObject, "captionViews[i]");
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.GKW.get(i));
      ((RecyclerView)getCaptionViews().get(i)).a((RecyclerView.l)new a(i));
      i += 1;
    }
    AppMethodBeat.o(191730);
  }
  
  private final int aM(int paramInt, long paramLong)
  {
    AppMethodBeat.i(191728);
    if (((Number)this.GLc.get(paramInt)).intValue() >= ((c)this.GKW.get(paramInt)).GKy.size())
    {
      Log.i("MicroMsg.EditorTextCaptionView", "maybe clear captionItems");
      this.GLc.set(paramInt, Integer.valueOf(((c)this.GKW.get(paramInt)).GKy.size() - 1));
    }
    int i;
    if (((sy)((c)this.GKW.get(paramInt)).GKy.get(((Number)this.GLc.get(paramInt)).intValue())).LaT > paramLong)
    {
      this.GLc.set(paramInt, Integer.valueOf(0));
      i = 1;
    }
    for (;;)
    {
      Object localObject;
      if (((sy)((c)this.GKW.get(paramInt)).GKy.get(((Number)this.GLc.get(paramInt)).intValue())).LaU < paramLong)
      {
        localObject = this.GLc;
        ((List)localObject).set(paramInt, Integer.valueOf(((Number)((List)localObject).get(paramInt)).intValue() + 1));
      }
      else
      {
        ((c)this.GKW.get(paramInt)).ady = ((Number)this.GLc.get(paramInt)).intValue();
        if (i != 0)
        {
          localObject = (RecyclerView)getCaptionViews().get(paramInt);
          com.tencent.mm.hellhoundlib.b.a locala = c.a(((Number)this.GLc.get(paramInt)).intValue(), new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "time2Pos", "(IJ)I", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerView)localObject).scrollToPosition(((Integer)locala.pG(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "time2Pos", "(IJ)I", "Undefined", "scrollToPosition", "(I)V");
        }
        paramInt = ((Number)this.GLc.get(paramInt)).intValue();
        AppMethodBeat.o(191728);
        return paramInt;
        i = 0;
      }
    }
  }
  
  private final ViewGroup getCaptionPanel()
  {
    AppMethodBeat.i(191710);
    ViewGroup localViewGroup = (ViewGroup)this.GKK.getValue();
    AppMethodBeat.o(191710);
    return localViewGroup;
  }
  
  private final ViewGroup getCaptionTab()
  {
    AppMethodBeat.i(191703);
    ViewGroup localViewGroup = (ViewGroup)this.GKD.getValue();
    AppMethodBeat.o(191703);
    return localViewGroup;
  }
  
  private final List<RecyclerView> getCaptionViews()
  {
    AppMethodBeat.i(191718);
    List localList = (List)this.GKS.getValue();
    AppMethodBeat.o(191718);
    return localList;
  }
  
  private final ViewGroup getClearRecordBtn()
  {
    AppMethodBeat.i(191717);
    ViewGroup localViewGroup = (ViewGroup)this.GKR.getValue();
    AppMethodBeat.o(191717);
    return localViewGroup;
  }
  
  private final TextView getEmptyTipTxt()
  {
    AppMethodBeat.i(191720);
    TextView localTextView = (TextView)this.GKU.getValue();
    AppMethodBeat.o(191720);
    return localTextView;
  }
  
  private final ViewGroup getRecordCaptionPanel()
  {
    AppMethodBeat.i(191711);
    ViewGroup localViewGroup = (ViewGroup)this.GKL.getValue();
    AppMethodBeat.o(191711);
    return localViewGroup;
  }
  
  private final View getRecordCaptionTabIndicator()
  {
    AppMethodBeat.i(191708);
    View localView = (View)this.GKI.getValue();
    AppMethodBeat.o(191708);
    return localView;
  }
  
  private final TextView getRecordCaptionTabText()
  {
    AppMethodBeat.i(191707);
    TextView localTextView = (TextView)this.GKH.getValue();
    AppMethodBeat.o(191707);
    return localTextView;
  }
  
  private final TextView getRecordTransBtn()
  {
    AppMethodBeat.i(191713);
    TextView localTextView = (TextView)this.GKN.getValue();
    AppMethodBeat.o(191713);
    return localTextView;
  }
  
  final void VT(int paramInt)
  {
    AppMethodBeat.i(191729);
    this.GLe = paramInt;
    if (this.GLe == 0)
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
      ((TextView)localObject).setTextColor(localContext.getResources().getColor(2131101427));
      localObject = getRecordCaptionTabText();
      localContext = getContext();
      p.g(localContext, "context");
      ((TextView)localObject).setTextColor(localContext.getResources().getColor(2131101428));
      localObject = getCaptionPanel();
      p.g(localObject, "captionPanel");
      ((ViewGroup)localObject).setVisibility(0);
      localObject = getRecordCaptionPanel();
      p.g(localObject, "recordCaptionPanel");
      ((ViewGroup)localObject).setVisibility(8);
      AppMethodBeat.o(191729);
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
    ((TextView)localObject).setTextColor(localContext.getResources().getColor(2131101428));
    localObject = getRecordCaptionTabText();
    localContext = getContext();
    p.g(localContext, "context");
    ((TextView)localObject).setTextColor(localContext.getResources().getColor(2131101427));
    localObject = getCaptionPanel();
    p.g(localObject, "captionPanel");
    ((ViewGroup)localObject).setVisibility(8);
    localObject = getRecordCaptionPanel();
    p.g(localObject, "recordCaptionPanel");
    ((ViewGroup)localObject).setVisibility(0);
    AppMethodBeat.o(191729);
  }
  
  public final void aL(int paramInt, long paramLong)
  {
    AppMethodBeat.i(191727);
    if ((this.GLd) || (((c)this.GKW.get(paramInt)).GKy.isEmpty()))
    {
      AppMethodBeat.o(191727);
      return;
    }
    int i = ((Number)this.GLc.get(paramInt)).intValue();
    aM(paramInt, paramLong);
    Object localObject = getCaptionViews().get(paramInt);
    p.g(localObject, "captionViews[type]");
    localObject = ((RecyclerView)localObject).getLayoutManager();
    if (localObject != null)
    {
      ((RecyclerView.LayoutManager)localObject).smoothScrollToPosition((RecyclerView)getCaptionViews().get(paramInt), new RecyclerView.s(), ((Number)this.GLc.get(paramInt)).intValue());
      this.GKW.get(paramInt);
      c.fZ(((RecyclerView.LayoutManager)localObject).findViewByPosition(i));
      this.GKW.get(paramInt);
      c.fY(((RecyclerView.LayoutManager)localObject).findViewByPosition(((Number)this.GLc.get(paramInt)).intValue()));
      AppMethodBeat.o(191727);
      return;
    }
    AppMethodBeat.o(191727);
  }
  
  final void acH(int paramInt)
  {
    AppMethodBeat.i(191725);
    ((c)this.GKW.get(paramInt)).GKy.clear();
    AppMethodBeat.o(191725);
  }
  
  public final void acI(int paramInt)
  {
    AppMethodBeat.i(191726);
    ((c)this.GKW.get(paramInt)).notifyDataSetChanged();
    AppMethodBeat.o(191726);
  }
  
  public final void cE(int paramInt, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(191723);
    acH(paramInt);
    acI(paramInt);
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
      paramString = this.GLa;
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
      paramString.invoke(Integer.valueOf(paramInt), Boolean.valueOf(bool));
      AppMethodBeat.o(191723);
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
    AppMethodBeat.o(191723);
  }
  
  final View getCaptionTabIndicator()
  {
    AppMethodBeat.i(191705);
    View localView = (View)this.GKF.getValue();
    AppMethodBeat.o(191705);
    return localView;
  }
  
  final View getCaptionTabSpace()
  {
    AppMethodBeat.i(191709);
    View localView = (View)this.GKJ.getValue();
    AppMethodBeat.o(191709);
    return localView;
  }
  
  final TextView getCaptionTabText()
  {
    AppMethodBeat.i(191704);
    TextView localTextView = (TextView)this.GKE.getValue();
    AppMethodBeat.o(191704);
    return localTextView;
  }
  
  public final m<Integer, Boolean, x> getClearTransListener()
  {
    return this.GLa;
  }
  
  final LinearLayout getContentLayout()
  {
    AppMethodBeat.i(191721);
    LinearLayout localLinearLayout = (LinearLayout)this.uZY.getValue();
    AppMethodBeat.o(191721);
    return localLinearLayout;
  }
  
  public final kotlin.g.a.a<x> getDismissListener()
  {
    return this.GLb;
  }
  
  final LinearLayout getEmptyLayout()
  {
    AppMethodBeat.i(191719);
    LinearLayout localLinearLayout = (LinearLayout)this.GKT.getValue();
    AppMethodBeat.o(191719);
    return localLinearLayout;
  }
  
  public final m<Integer, sy, x> getItemClickListener()
  {
    return this.rsD;
  }
  
  final View getLoadingView()
  {
    AppMethodBeat.i(191722);
    View localView = (View)this.GKV.getValue();
    AppMethodBeat.o(191722);
    return localView;
  }
  
  final ViewGroup getRecordCaptionTab()
  {
    AppMethodBeat.i(191706);
    ViewGroup localViewGroup = (ViewGroup)this.GKG.getValue();
    AppMethodBeat.o(191706);
    return localViewGroup;
  }
  
  final ViewGroup getRecordContentLayout()
  {
    AppMethodBeat.i(191714);
    ViewGroup localViewGroup = (ViewGroup)this.GKO.getValue();
    AppMethodBeat.o(191714);
    return localViewGroup;
  }
  
  final ViewGroup getRecordEmptyLayout()
  {
    AppMethodBeat.i(191716);
    ViewGroup localViewGroup = (ViewGroup)this.GKQ.getValue();
    AppMethodBeat.o(191716);
    return localViewGroup;
  }
  
  final View getRecordLoadingView()
  {
    AppMethodBeat.i(191715);
    View localView = (View)this.GKP.getValue();
    AppMethodBeat.o(191715);
    return localView;
  }
  
  public final kotlin.g.a.b<Integer, x> getStartTransListener()
  {
    return this.GKZ;
  }
  
  final TextView getTransBtn()
  {
    AppMethodBeat.i(191712);
    TextView localTextView = (TextView)this.GKM.getValue();
    AppMethodBeat.o(191712);
    return localTextView;
  }
  
  public final kotlin.g.a.a<x> getVideoPauseListener()
  {
    return this.GKX;
  }
  
  public final kotlin.g.a.b<Long, x> getVideoSeekListener()
  {
    return this.GKY;
  }
  
  public final void setClearTransListener(m<? super Integer, ? super Boolean, x> paramm)
  {
    this.GLa = paramm;
  }
  
  public final void setDismissListener(kotlin.g.a.a<x> parama)
  {
    this.GLb = parama;
  }
  
  public final void setItemClickListener(m<? super Integer, ? super sy, x> paramm)
  {
    this.rsD = paramm;
  }
  
  public final void setStartTransListener(kotlin.g.a.b<? super Integer, x> paramb)
  {
    this.GKZ = paramb;
  }
  
  public final void setVideoPauseListener(kotlin.g.a.a<x> parama)
  {
    this.GKX = parama;
  }
  
  public final void setVideoSeekListener(kotlin.g.a.b<? super Long, x> paramb)
  {
    this.GKY = paramb;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener;", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "type", "", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView;I)V", "getType", "()I", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "plugin-vlog_release"})
  public final class a
    extends RecyclerView.l
  {
    private final int type;
    
    public a()
    {
      int i;
      this.type = i;
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(191670);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      switch (paramInt)
      {
      }
      do
      {
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(191670);
          return;
          Log.d("MicroMsg.EditorTextCaptionView", "SCROLL_STATE_DRAGGING");
          d.a(d.this, true);
          paramRecyclerView = d.this.getVideoPauseListener();
          if (paramRecyclerView != null) {
            paramRecyclerView.invoke();
          }
        }
      } while (!d.a(d.this));
      long l = ((sy)((d.c)d.b(d.this).get(this.type)).GKy.get(((Number)d.c(d.this).get(this.type)).intValue())).LaT;
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
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(191671);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      if (!d.a(d.this))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(191671);
        return;
      }
      paramInt2 = ((Number)d.c(d.this).get(this.type)).intValue();
      paramRecyclerView = d.d(d.this).get(this.type);
      p.g(paramRecyclerView, "captionViews[type]");
      paramRecyclerView = ((RecyclerView)paramRecyclerView).getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(191671);
        throw paramRecyclerView;
      }
      paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
      int i = (paramRecyclerView.ks() + paramRecyclerView.ku()) / 2;
      if (i == ((d.c)d.b(d.this).get(this.type)).ady)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(191671);
        return;
      }
      paramInt1 = i - 1;
      i += 1;
      if (paramInt1 <= i) {}
      for (;;)
      {
        if (d.a(d.this, this.type, paramRecyclerView.findViewByPosition(paramInt1)))
        {
          d.c(d.this).set(this.type, Integer.valueOf(paramInt1));
          ((d.c)d.b(d.this).get(this.type)).ady = ((Number)d.c(d.this).get(this.type)).intValue();
          d.b(d.this).get(this.type);
          d.c.fZ(paramRecyclerView.findViewByPosition(paramInt2));
          d.b(d.this).get(this.type);
          d.c.fY(paramRecyclerView.findViewByPosition(((Number)d.c(d.this).get(this.type)).intValue()));
          Log.d("MicroMsg.EditorTextCaptionView", "onScrolled currentPos  " + d.c(d.this) + ' ' + paramInt2);
        }
        while (paramInt1 == i)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(191671);
          return;
        }
        paramInt1 += 1;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "type", "", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView;ILandroid/content/Context;)V", "captionItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "getCaptionItems", "()Ljava/util/ArrayList;", "setCaptionItems", "(Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "currentPos", "getCurrentPos", "()I", "setCurrentPos", "(I)V", "getItemCount", "getString", "", "byte", "Lcom/tencent/mm/protobuf/ByteString;", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "selectView", "itemView", "Landroid/view/View;", "ccTransResult", "unSelectView", "plugin-vlog_release"})
  public final class c
    extends RecyclerView.a<RecyclerView.v>
  {
    ArrayList<sy> GKy;
    int ady;
    private Context context;
    private final int type;
    
    public c(Context paramContext)
    {
      AppMethodBeat.i(191680);
      this.type = paramContext;
      this.context = localObject;
      this.GKy = new ArrayList();
      AppMethodBeat.o(191680);
    }
    
    private static void a(View paramView, sy paramsy)
    {
      AppMethodBeat.i(191676);
      if (paramView == null)
      {
        AppMethodBeat.o(191676);
        return;
      }
      paramView.setAlpha(1.0F);
      paramView = (ImageView)paramView.findViewById(2131297978);
      if ((paramsy != null) && (paramsy.LaV == true))
      {
        p.g(paramView, "img");
        paramView.setVisibility(4);
        AppMethodBeat.o(191676);
        return;
      }
      p.g(paramView, "img");
      paramView.setImageDrawable(ar.m(paramView.getContext(), 2131690644, -1));
      paramView.setVisibility(0);
      AppMethodBeat.o(191676);
    }
    
    private static String d(com.tencent.mm.bw.b paramb)
    {
      AppMethodBeat.i(191679);
      if (paramb == null)
      {
        AppMethodBeat.o(191679);
        return "";
      }
      paramb = paramb.toString("UTF-8");
      p.g(paramb, "byte.toString(\"UTF-8\")");
      AppMethodBeat.o(191679);
      return paramb;
    }
    
    public static void fZ(View paramView)
    {
      AppMethodBeat.i(191678);
      if (paramView == null)
      {
        AppMethodBeat.o(191678);
        return;
      }
      paramView.setAlpha(0.5F);
      paramView = paramView.findViewById(2131297978);
      p.g(paramView, "itemView.findViewById<Im…eView>(R.id.caption_edit)");
      ((ImageView)paramView).setVisibility(4);
      AppMethodBeat.o(191678);
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(191673);
      p.h(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(this.context).inflate(2131493894, paramViewGroup, false);
      if (paramViewGroup == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(191673);
        throw paramViewGroup;
      }
      paramViewGroup = (ViewGroup)paramViewGroup;
      paramViewGroup = (RecyclerView.v)new b(paramViewGroup, (View)paramViewGroup);
      AppMethodBeat.o(191673);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, final int paramInt)
    {
      AppMethodBeat.i(191675);
      p.h(paramv, "viewHolder");
      Object localObject = paramv.aus;
      p.g(localObject, "viewHolder.itemView");
      if ((TextUtils.isEmpty((CharSequence)d(((sy)this.GKy.get(paramInt)).LaS))) || (((sy)this.GKy.get(paramInt)).LaV))
      {
        ((View)localObject).setVisibility(4);
        paramv.aus.setOnClickListener((View.OnClickListener)new a(this, paramInt));
        AppMethodBeat.o(191675);
        return;
      }
      ((View)localObject).setVisibility(0);
      if (this.ady == paramInt) {
        a((View)localObject, (sy)this.GKy.get(paramInt));
      }
      for (;;)
      {
        localObject = (TextView)((View)localObject).findViewById(2131297976);
        p.g(localObject, "contentView");
        ((TextView)localObject).setText((CharSequence)d(((sy)this.GKy.get(paramInt)).LaS));
        break;
        fZ((View)localObject);
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(191674);
      int i = this.GKy.size();
      AppMethodBeat.o(191674);
      return i;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(d.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(191672);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if (!((sy)this.GLh.GKy.get(paramInt)).LaV)
        {
          paramView = this.GLh.GLg.getItemClickListener();
          if (paramView != null)
          {
            int i = d.c.a(this.GLh);
            localObject = this.GLh.GKy.get(paramInt);
            p.g(localObject, "captionItems[position]");
            paramView.invoke(Integer.valueOf(i), localObject);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191672);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter$onCreateViewHolder$1", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-vlog_release"})
    public static final class b
      extends RecyclerView.v
    {
      b(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    e(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<View>
  {
    f(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<View>
  {
    g(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<TextView>
  {
    h(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<List<? extends RecyclerView>>
  {
    i(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    j(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<LinearLayout>
  {
    k(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<LinearLayout>
  {
    l(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<TextView>
  {
    m(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<View>
  {
    n(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    o(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    p(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<View>
  {
    q(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class r
    extends q
    implements kotlin.g.a.a<TextView>
  {
    r(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class s
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    s(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class t
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    t(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class u
    extends q
    implements kotlin.g.a.a<View>
  {
    u(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class v
    extends q
    implements kotlin.g.a.a<TextView>
  {
    v(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class w
    extends q
    implements kotlin.g.a.a<TextView>
  {
    w(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.d
 * JD-Core Version:    0.7.0.1
 */
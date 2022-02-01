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
import com.tencent.mm.protocal.protobuf.rv;
import com.tencent.mm.sdk.platformtools.ae;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapters", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter;", "captionPanel", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "getCaptionPanel", "()Landroid/view/ViewGroup;", "captionPanel$delegate", "Lkotlin/Lazy;", "captionTab", "getCaptionTab", "captionTab$delegate", "captionTabIndicator", "Landroid/view/View;", "getCaptionTabIndicator", "()Landroid/view/View;", "captionTabIndicator$delegate", "captionTabSpace", "getCaptionTabSpace", "captionTabSpace$delegate", "captionTabText", "Landroid/widget/TextView;", "getCaptionTabText", "()Landroid/widget/TextView;", "captionTabText$delegate", "captionViews", "Landroid/support/v7/widget/RecyclerView;", "getCaptionViews", "()Ljava/util/List;", "captionViews$delegate", "clearRecordBtn", "getClearRecordBtn", "clearRecordBtn$delegate", "clearTransListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "type", "", "hasTranslate", "", "getClearTransListener", "()Lkotlin/jvm/functions/Function2;", "setClearTransListener", "(Lkotlin/jvm/functions/Function2;)V", "contentLayout", "Landroid/widget/LinearLayout;", "getContentLayout", "()Landroid/widget/LinearLayout;", "contentLayout$delegate", "curTab", "currentPos", "", "dismissListener", "Lkotlin/Function0;", "getDismissListener", "()Lkotlin/jvm/functions/Function0;", "setDismissListener", "(Lkotlin/jvm/functions/Function0;)V", "emptyLayout", "getEmptyLayout", "emptyLayout$delegate", "emptyTipTxt", "getEmptyTipTxt", "emptyTipTxt$delegate", "itemClickListener", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "result", "getItemClickListener", "setItemClickListener", "loadingView", "getLoadingView", "loadingView$delegate", "onTouchingView", "recordCaptionPanel", "getRecordCaptionPanel", "recordCaptionPanel$delegate", "recordCaptionTab", "getRecordCaptionTab", "recordCaptionTab$delegate", "recordCaptionTabIndicator", "getRecordCaptionTabIndicator", "recordCaptionTabIndicator$delegate", "recordCaptionTabText", "getRecordCaptionTabText", "recordCaptionTabText$delegate", "recordContentLayout", "getRecordContentLayout", "recordContentLayout$delegate", "recordEmptyLayout", "getRecordEmptyLayout", "recordEmptyLayout$delegate", "recordLoadingView", "getRecordLoadingView", "recordLoadingView$delegate", "recordTransBtn", "getRecordTransBtn", "recordTransBtn$delegate", "startTransListener", "Lkotlin/Function1;", "getStartTransListener", "()Lkotlin/jvm/functions/Function1;", "setStartTransListener", "(Lkotlin/jvm/functions/Function1;)V", "transBtn", "getTransBtn", "transBtn$delegate", "videoPauseListener", "getVideoPauseListener", "setVideoPauseListener", "videoSeekListener", "", "timestampMs", "getVideoSeekListener", "setVideoSeekListener", "addCaptionItemData", "items", "clearCaption", "tip", "", "clearCaptionData", "disableRecordCaption", "enableRecordCaption", "ifCenter", "view", "notifyDataSetChanged", "scrollToMid", "scrollToTimeMs", "timeStampMs", "showCaption", "showLoading", "switchTab", "tabIndex", "time2Pos", "updateSelectItemData", "transResult", "CaptionScrollListener", "Companion", "EditorCaptionAdapter", "plugin-vlog_release"})
public final class d
  extends RelativeLayout
{
  public static final d.b Ciu;
  private final f ChR;
  private final f ChS;
  private final f ChT;
  private final f ChU;
  private final f ChV;
  private final f ChW;
  private final f ChX;
  private final f ChY;
  private final f ChZ;
  private final f Cia;
  private final f Cib;
  private final f Cic;
  private final f Cid;
  private final f Cie;
  private final f Cif;
  private final f Cig;
  private final f Cih;
  private final f Cii;
  private final f Cij;
  private final f Cik;
  final List<c> Cil;
  private d.g.a.a<z> Cim;
  private d.g.a.b<? super Long, z> Cin;
  private d.g.a.b<? super Integer, z> Cio;
  private m<? super Integer, ? super Boolean, z> Cip;
  private d.g.a.a<z> Ciq;
  private List<Integer> Cir;
  private boolean Cis;
  private int Cit;
  private m<? super Integer, ? super rv, z> qbG;
  
  static
  {
    AppMethodBeat.i(192042);
    Ciu = new d.b((byte)0);
    AppMethodBeat.o(192042);
  }
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(192041);
    this.ChR = g.O((d.g.a.a)new e(this));
    this.ChS = g.O((d.g.a.a)new h(this));
    this.ChT = g.O((d.g.a.a)new f(this));
    this.ChU = g.O((d.g.a.a)new p(this));
    this.ChV = g.O((d.g.a.a)new r(this));
    this.ChW = g.O((d.g.a.a)new q(this));
    this.ChX = g.O((d.g.a.a)new g(this));
    this.ChY = g.O((d.g.a.a)new d(this));
    this.ChZ = g.O((d.g.a.a)new o(this));
    this.Cia = g.O((d.g.a.a)new w(this));
    this.Cib = g.O((d.g.a.a)new v(this));
    this.Cic = g.O((d.g.a.a)new s(this));
    this.Cid = g.O((d.g.a.a)new u(this));
    this.Cie = g.O((d.g.a.a)new t(this));
    this.Cif = g.O((d.g.a.a)new j(this));
    this.Cig = g.O((d.g.a.a)new i(this));
    this.Cih = g.O((d.g.a.a)new l(this));
    this.Cii = g.O((d.g.a.a)new m(this));
    this.Cij = g.O((d.g.a.a)new k(this));
    this.Cik = g.O((d.g.a.a)new n(this));
    this.Cil = j.listOf(new c[] { new c(0, paramContext), new c(1, paramContext) });
    this.Cir = j.mutableListOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(0) });
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
        AppMethodBeat.i(191974);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        d.c(this.Civ, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191974);
      }
    });
    getRecordCaptionTab().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191975);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        d.c(this.Civ, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191975);
      }
    });
    findViewById(2131308236).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191976);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = this.Civ.getDismissListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191976);
      }
    });
    findViewById(2131306059).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191977);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = d.e(this.Civ);
        p.g(paramAnonymousView, "contentLayout");
        paramAnonymousView.setVisibility(0);
        paramAnonymousView = d.f(this.Civ);
        p.g(paramAnonymousView, "emptyLayout");
        paramAnonymousView.setVisibility(4);
        paramAnonymousView = this.Civ.getStartTransListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(0));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191977);
      }
    });
    findViewById(2131308260).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191978);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        d.a(this.Civ, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191978);
      }
    });
    getRecordTransBtn().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191979);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = d.g(this.Civ);
        p.g(paramAnonymousView, "recordContentLayout");
        paramAnonymousView.setVisibility(0);
        paramAnonymousView = d.h(this.Civ);
        p.g(paramAnonymousView, "recordEmptyLayout");
        paramAnonymousView.setVisibility(4);
        paramAnonymousView = this.Civ.getStartTransListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(1));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191979);
      }
    });
    getClearRecordBtn().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191980);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        d.a(this.Civ, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191980);
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
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.Cil.get(i));
      ((RecyclerView)getCaptionViews().get(i)).a((RecyclerView.m)new a(i));
      i += 1;
    }
    AppMethodBeat.o(192041);
  }
  
  private final int aG(int paramInt, long paramLong)
  {
    AppMethodBeat.i(192039);
    if (((Number)this.Cir.get(paramInt)).intValue() >= ((c)this.Cil.get(paramInt)).ChM.size())
    {
      ae.i("MicroMsg.EditorTextCaptionView", "maybe clear captionItems");
      this.Cir.set(paramInt, Integer.valueOf(((c)this.Cil.get(paramInt)).ChM.size() - 1));
    }
    int i;
    if (((rv)((c)this.Cil.get(paramInt)).ChM.get(((Number)this.Cir.get(paramInt)).intValue())).Ggq > paramLong)
    {
      this.Cir.set(paramInt, Integer.valueOf(0));
      i = 1;
    }
    for (;;)
    {
      Object localObject;
      if (((rv)((c)this.Cil.get(paramInt)).ChM.get(((Number)this.Cir.get(paramInt)).intValue())).Ggr < paramLong)
      {
        localObject = this.Cir;
        ((List)localObject).set(paramInt, Integer.valueOf(((Number)((List)localObject).get(paramInt)).intValue() + 1));
      }
      else
      {
        ((c)this.Cil.get(paramInt)).adl = ((Number)this.Cir.get(paramInt)).intValue();
        if (i != 0)
        {
          localObject = (RecyclerView)getCaptionViews().get(paramInt);
          com.tencent.mm.hellhoundlib.b.a locala = c.a(((Number)this.Cir.get(paramInt)).intValue(), new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "time2Pos", "(IJ)I", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerView)localObject).ca(((Integer)locala.mt(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "time2Pos", "(IJ)I", "Undefined", "scrollToPosition", "(I)V");
        }
        paramInt = ((Number)this.Cir.get(paramInt)).intValue();
        AppMethodBeat.o(192039);
        return paramInt;
        i = 0;
      }
    }
  }
  
  private final ViewGroup getCaptionPanel()
  {
    AppMethodBeat.i(192021);
    ViewGroup localViewGroup = (ViewGroup)this.ChY.getValue();
    AppMethodBeat.o(192021);
    return localViewGroup;
  }
  
  private final ViewGroup getCaptionTab()
  {
    AppMethodBeat.i(192014);
    ViewGroup localViewGroup = (ViewGroup)this.ChR.getValue();
    AppMethodBeat.o(192014);
    return localViewGroup;
  }
  
  private final List<RecyclerView> getCaptionViews()
  {
    AppMethodBeat.i(192029);
    List localList = (List)this.Cig.getValue();
    AppMethodBeat.o(192029);
    return localList;
  }
  
  private final ViewGroup getClearRecordBtn()
  {
    AppMethodBeat.i(192028);
    ViewGroup localViewGroup = (ViewGroup)this.Cif.getValue();
    AppMethodBeat.o(192028);
    return localViewGroup;
  }
  
  private final TextView getEmptyTipTxt()
  {
    AppMethodBeat.i(192031);
    TextView localTextView = (TextView)this.Cii.getValue();
    AppMethodBeat.o(192031);
    return localTextView;
  }
  
  private final ViewGroup getRecordCaptionPanel()
  {
    AppMethodBeat.i(192022);
    ViewGroup localViewGroup = (ViewGroup)this.ChZ.getValue();
    AppMethodBeat.o(192022);
    return localViewGroup;
  }
  
  private final View getRecordCaptionTabIndicator()
  {
    AppMethodBeat.i(192019);
    View localView = (View)this.ChW.getValue();
    AppMethodBeat.o(192019);
    return localView;
  }
  
  private final TextView getRecordCaptionTabText()
  {
    AppMethodBeat.i(192018);
    TextView localTextView = (TextView)this.ChV.getValue();
    AppMethodBeat.o(192018);
    return localTextView;
  }
  
  private final TextView getRecordTransBtn()
  {
    AppMethodBeat.i(192024);
    TextView localTextView = (TextView)this.Cib.getValue();
    AppMethodBeat.o(192024);
    return localTextView;
  }
  
  final void Oy(int paramInt)
  {
    AppMethodBeat.i(192040);
    this.Cit = paramInt;
    if (this.Cit == 0)
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
      AppMethodBeat.o(192040);
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
    AppMethodBeat.o(192040);
  }
  
  final void Uo(int paramInt)
  {
    AppMethodBeat.i(192036);
    ((c)this.Cil.get(paramInt)).ChM.clear();
    AppMethodBeat.o(192036);
  }
  
  public final void Up(int paramInt)
  {
    AppMethodBeat.i(192037);
    ((c)this.Cil.get(paramInt)).notifyDataSetChanged();
    AppMethodBeat.o(192037);
  }
  
  public final void aF(int paramInt, long paramLong)
  {
    AppMethodBeat.i(192038);
    if ((this.Cis) || (((c)this.Cil.get(paramInt)).ChM.isEmpty()))
    {
      AppMethodBeat.o(192038);
      return;
    }
    int i = ((Number)this.Cir.get(paramInt)).intValue();
    aG(paramInt, paramLong);
    Object localObject = getCaptionViews().get(paramInt);
    p.g(localObject, "captionViews[type]");
    localObject = ((RecyclerView)localObject).getLayoutManager();
    if (localObject != null)
    {
      ((RecyclerView.i)localObject).a((RecyclerView)getCaptionViews().get(paramInt), new RecyclerView.t(), ((Number)this.Cir.get(paramInt)).intValue());
      this.Cil.get(paramInt);
      c.fH(((RecyclerView.i)localObject).bY(i));
      this.Cil.get(paramInt);
      c.fG(((RecyclerView.i)localObject).bY(((Number)this.Cir.get(paramInt)).intValue()));
      AppMethodBeat.o(192038);
      return;
    }
    AppMethodBeat.o(192038);
  }
  
  public final void cn(int paramInt, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(192034);
    Uo(paramInt);
    Up(paramInt);
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
      paramString = this.Cip;
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
      AppMethodBeat.o(192034);
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
    AppMethodBeat.o(192034);
  }
  
  final View getCaptionTabIndicator()
  {
    AppMethodBeat.i(192016);
    View localView = (View)this.ChT.getValue();
    AppMethodBeat.o(192016);
    return localView;
  }
  
  final View getCaptionTabSpace()
  {
    AppMethodBeat.i(192020);
    View localView = (View)this.ChX.getValue();
    AppMethodBeat.o(192020);
    return localView;
  }
  
  final TextView getCaptionTabText()
  {
    AppMethodBeat.i(192015);
    TextView localTextView = (TextView)this.ChS.getValue();
    AppMethodBeat.o(192015);
    return localTextView;
  }
  
  public final m<Integer, Boolean, z> getClearTransListener()
  {
    return this.Cip;
  }
  
  final LinearLayout getContentLayout()
  {
    AppMethodBeat.i(192032);
    LinearLayout localLinearLayout = (LinearLayout)this.Cij.getValue();
    AppMethodBeat.o(192032);
    return localLinearLayout;
  }
  
  public final d.g.a.a<z> getDismissListener()
  {
    return this.Ciq;
  }
  
  final LinearLayout getEmptyLayout()
  {
    AppMethodBeat.i(192030);
    LinearLayout localLinearLayout = (LinearLayout)this.Cih.getValue();
    AppMethodBeat.o(192030);
    return localLinearLayout;
  }
  
  public final m<Integer, rv, z> getItemClickListener()
  {
    return this.qbG;
  }
  
  final View getLoadingView()
  {
    AppMethodBeat.i(192033);
    View localView = (View)this.Cik.getValue();
    AppMethodBeat.o(192033);
    return localView;
  }
  
  final ViewGroup getRecordCaptionTab()
  {
    AppMethodBeat.i(192017);
    ViewGroup localViewGroup = (ViewGroup)this.ChU.getValue();
    AppMethodBeat.o(192017);
    return localViewGroup;
  }
  
  final ViewGroup getRecordContentLayout()
  {
    AppMethodBeat.i(192025);
    ViewGroup localViewGroup = (ViewGroup)this.Cic.getValue();
    AppMethodBeat.o(192025);
    return localViewGroup;
  }
  
  final ViewGroup getRecordEmptyLayout()
  {
    AppMethodBeat.i(192027);
    ViewGroup localViewGroup = (ViewGroup)this.Cie.getValue();
    AppMethodBeat.o(192027);
    return localViewGroup;
  }
  
  final View getRecordLoadingView()
  {
    AppMethodBeat.i(192026);
    View localView = (View)this.Cid.getValue();
    AppMethodBeat.o(192026);
    return localView;
  }
  
  public final d.g.a.b<Integer, z> getStartTransListener()
  {
    return this.Cio;
  }
  
  final TextView getTransBtn()
  {
    AppMethodBeat.i(192023);
    TextView localTextView = (TextView)this.Cia.getValue();
    AppMethodBeat.o(192023);
    return localTextView;
  }
  
  public final d.g.a.a<z> getVideoPauseListener()
  {
    return this.Cim;
  }
  
  public final d.g.a.b<Long, z> getVideoSeekListener()
  {
    return this.Cin;
  }
  
  public final void setClearTransListener(m<? super Integer, ? super Boolean, z> paramm)
  {
    this.Cip = paramm;
  }
  
  public final void setDismissListener(d.g.a.a<z> parama)
  {
    this.Ciq = parama;
  }
  
  public final void setItemClickListener(m<? super Integer, ? super rv, z> paramm)
  {
    this.qbG = paramm;
  }
  
  public final void setStartTransListener(d.g.a.b<? super Integer, z> paramb)
  {
    this.Cio = paramb;
  }
  
  public final void setVideoPauseListener(d.g.a.a<z> parama)
  {
    this.Cim = parama;
  }
  
  public final void setVideoSeekListener(d.g.a.b<? super Long, z> paramb)
  {
    this.Cin = paramb;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener;", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "type", "", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView;I)V", "getType", "()I", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "plugin-vlog_release"})
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
      AppMethodBeat.i(191982);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt1);
      localb.mu(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
      p.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      if (!d.a(d.this))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(191982);
        return;
      }
      paramInt2 = ((Number)d.c(d.this).get(this.type)).intValue();
      paramRecyclerView = d.d(d.this).get(this.type);
      p.g(paramRecyclerView, "captionViews[type]");
      paramRecyclerView = ((RecyclerView)paramRecyclerView).getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(191982);
        throw paramRecyclerView;
      }
      paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
      int i = (paramRecyclerView.km() + paramRecyclerView.ko()) / 2;
      if (i == ((d.c)d.b(d.this).get(this.type)).adl)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(191982);
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
          d.c.fH(paramRecyclerView.bY(paramInt2));
          d.b(d.this).get(this.type);
          d.c.fG(paramRecyclerView.bY(((Number)d.c(d.this).get(this.type)).intValue()));
          ae.d("MicroMsg.EditorTextCaptionView", "onScrolled currentPos  " + d.c(d.this) + ' ' + paramInt2);
        }
        while (paramInt1 == i)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(191982);
          return;
        }
        paramInt1 += 1;
      }
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(191981);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
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
          AppMethodBeat.o(191981);
          return;
          ae.d("MicroMsg.EditorTextCaptionView", "SCROLL_STATE_DRAGGING");
          d.a(d.this, true);
          paramRecyclerView = d.this.getVideoPauseListener();
          if (paramRecyclerView != null) {
            paramRecyclerView.invoke();
          }
        }
      } while (!d.a(d.this));
      long l = ((rv)((d.c)d.b(d.this).get(this.type)).ChM.get(((Number)d.c(d.this).get(this.type)).intValue())).Ggq;
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "type", "", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView;ILandroid/content/Context;)V", "captionItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "getCaptionItems", "()Ljava/util/ArrayList;", "setCaptionItems", "(Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "currentPos", "getCurrentPos", "()I", "setCurrentPos", "(I)V", "getItemCount", "getString", "", "byte", "Lcom/tencent/mm/protobuf/ByteString;", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "selectView", "itemView", "Landroid/view/View;", "ccTransResult", "unSelectView", "plugin-vlog_release"})
  public final class c
    extends RecyclerView.a<RecyclerView.w>
  {
    ArrayList<rv> ChM;
    int adl;
    private Context context;
    private final int type;
    
    public c(Context paramContext)
    {
      AppMethodBeat.i(191991);
      this.type = paramContext;
      this.context = localObject;
      this.ChM = new ArrayList();
      AppMethodBeat.o(191991);
    }
    
    private static void a(View paramView, rv paramrv)
    {
      AppMethodBeat.i(191987);
      if (paramView == null)
      {
        AppMethodBeat.o(191987);
        return;
      }
      paramView.setAlpha(1.0F);
      paramView = (ImageView)paramView.findViewById(2131307290);
      if ((paramrv != null) && (paramrv.Ggs == true))
      {
        p.g(paramView, "img");
        paramView.setVisibility(4);
        AppMethodBeat.o(191987);
        return;
      }
      p.g(paramView, "img");
      paramView.setImageDrawable(ao.k(paramView.getContext(), 2131690457, -1));
      paramView.setVisibility(0);
      AppMethodBeat.o(191987);
    }
    
    private static String b(com.tencent.mm.bw.b paramb)
    {
      AppMethodBeat.i(191990);
      if (paramb == null)
      {
        AppMethodBeat.o(191990);
        return "";
      }
      paramb = paramb.toString("UTF-8");
      p.g(paramb, "byte.toString(\"UTF-8\")");
      AppMethodBeat.o(191990);
      return paramb;
    }
    
    public static void fH(View paramView)
    {
      AppMethodBeat.i(191989);
      if (paramView == null)
      {
        AppMethodBeat.o(191989);
        return;
      }
      paramView.setAlpha(0.5F);
      paramView = paramView.findViewById(2131307290);
      p.g(paramView, "itemView.findViewById<Im…eView>(R.id.caption_edit)");
      ((ImageView)paramView).setVisibility(4);
      AppMethodBeat.o(191989);
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(191984);
      p.h(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(this.context).inflate(2131496168, paramViewGroup, false);
      if (paramViewGroup == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(191984);
        throw paramViewGroup;
      }
      paramViewGroup = (ViewGroup)paramViewGroup;
      paramViewGroup = (RecyclerView.w)new b(paramViewGroup, (View)paramViewGroup);
      AppMethodBeat.o(191984);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, final int paramInt)
    {
      AppMethodBeat.i(191986);
      p.h(paramw, "viewHolder");
      Object localObject = paramw.auu;
      p.g(localObject, "viewHolder.itemView");
      if ((TextUtils.isEmpty((CharSequence)b(((rv)this.ChM.get(paramInt)).Ggp))) || (((rv)this.ChM.get(paramInt)).Ggs))
      {
        ((View)localObject).setVisibility(4);
        paramw.auu.setOnClickListener((View.OnClickListener)new a(this, paramInt));
        AppMethodBeat.o(191986);
        return;
      }
      ((View)localObject).setVisibility(0);
      if (this.adl == paramInt) {
        a((View)localObject, (rv)this.ChM.get(paramInt));
      }
      for (;;)
      {
        localObject = (TextView)((View)localObject).findViewById(2131307289);
        p.g(localObject, "contentView");
        ((TextView)localObject).setText((CharSequence)b(((rv)this.ChM.get(paramInt)).Ggp));
        break;
        fH((View)localObject);
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(191985);
      int i = this.ChM.size();
      AppMethodBeat.o(191985);
      return i;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(d.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(191983);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if (!((rv)this.Ciw.ChM.get(paramInt)).Ggs)
        {
          paramView = this.Ciw.Civ.getItemClickListener();
          if (paramView != null)
          {
            int i = d.c.a(this.Ciw);
            localObject = this.Ciw.ChM.get(paramInt);
            p.g(localObject, "captionItems[position]");
            paramView.p(Integer.valueOf(i), localObject);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191983);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter$onCreateViewHolder$1", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-vlog_release"})
    public static final class b
      extends RecyclerView.w
    {
      b(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<ViewGroup>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<ViewGroup>
  {
    e(d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<View>
  {
    f(d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<View>
  {
    g(d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<TextView>
  {
    h(d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements d.g.a.a<List<? extends RecyclerView>>
  {
    i(d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends q
    implements d.g.a.a<ViewGroup>
  {
    j(d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements d.g.a.a<LinearLayout>
  {
    k(d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements d.g.a.a<LinearLayout>
  {
    l(d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends q
    implements d.g.a.a<TextView>
  {
    m(d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends q
    implements d.g.a.a<View>
  {
    n(d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class o
    extends q
    implements d.g.a.a<ViewGroup>
  {
    o(d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class p
    extends q
    implements d.g.a.a<ViewGroup>
  {
    p(d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class q
    extends q
    implements d.g.a.a<View>
  {
    q(d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class r
    extends q
    implements d.g.a.a<TextView>
  {
    r(d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class s
    extends q
    implements d.g.a.a<ViewGroup>
  {
    s(d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class t
    extends q
    implements d.g.a.a<ViewGroup>
  {
    t(d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class u
    extends q
    implements d.g.a.a<View>
  {
    u(d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class v
    extends q
    implements d.g.a.a<TextView>
  {
    v(d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
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
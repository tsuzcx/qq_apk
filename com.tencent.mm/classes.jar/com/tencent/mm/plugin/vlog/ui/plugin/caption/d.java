package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.recordvideo.b.d;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.protocal.protobuf.ta;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapters", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter;", "captionPanel", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "getCaptionPanel", "()Landroid/view/ViewGroup;", "captionPanel$delegate", "Lkotlin/Lazy;", "captionTab", "getCaptionTab", "captionTab$delegate", "captionTabIndicator", "Landroid/view/View;", "getCaptionTabIndicator", "()Landroid/view/View;", "captionTabIndicator$delegate", "captionTabSpace", "getCaptionTabSpace", "captionTabSpace$delegate", "captionTabText", "Landroid/widget/TextView;", "getCaptionTabText", "()Landroid/widget/TextView;", "captionTabText$delegate", "captionViews", "Landroidx/recyclerview/widget/RecyclerView;", "getCaptionViews", "()Ljava/util/List;", "captionViews$delegate", "clearRecordBtn", "getClearRecordBtn", "clearRecordBtn$delegate", "clearTransListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "type", "", "hasTranslate", "", "getClearTransListener", "()Lkotlin/jvm/functions/Function2;", "setClearTransListener", "(Lkotlin/jvm/functions/Function2;)V", "contentLayout", "getContentLayout", "()Landroid/widget/LinearLayout;", "contentLayout$delegate", "curTab", "currentPos", "", "dismissListener", "Lkotlin/Function0;", "getDismissListener", "()Lkotlin/jvm/functions/Function0;", "setDismissListener", "(Lkotlin/jvm/functions/Function0;)V", "emptyLayout", "getEmptyLayout", "emptyLayout$delegate", "emptyTipTxt", "getEmptyTipTxt", "emptyTipTxt$delegate", "itemClickListener", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "result", "getItemClickListener", "setItemClickListener", "loadingView", "getLoadingView", "loadingView$delegate", "onTouchingView", "recordCaptionPanel", "getRecordCaptionPanel", "recordCaptionPanel$delegate", "recordCaptionTab", "getRecordCaptionTab", "recordCaptionTab$delegate", "recordCaptionTabIndicator", "getRecordCaptionTabIndicator", "recordCaptionTabIndicator$delegate", "recordCaptionTabText", "getRecordCaptionTabText", "recordCaptionTabText$delegate", "recordContentLayout", "getRecordContentLayout", "recordContentLayout$delegate", "recordEmptyLayout", "getRecordEmptyLayout", "recordEmptyLayout$delegate", "recordLoadingView", "getRecordLoadingView", "recordLoadingView$delegate", "recordTransBtn", "getRecordTransBtn", "recordTransBtn$delegate", "startTransListener", "Lkotlin/Function1;", "getStartTransListener", "()Lkotlin/jvm/functions/Function1;", "setStartTransListener", "(Lkotlin/jvm/functions/Function1;)V", "transBtn", "getTransBtn", "transBtn$delegate", "videoPauseListener", "getVideoPauseListener", "setVideoPauseListener", "videoSeekListener", "", "timestampMs", "getVideoSeekListener", "setVideoSeekListener", "addCaptionItemData", "items", "clearCaption", "tip", "", "clearCaptionData", "disableRecordCaption", "enableRecordCaption", "hasInit", "ifCenter", "view", "notifyDataSetChanged", "scrollToMid", "scrollToTimeMs", "timeStampMs", "showCaption", "showLoading", "switchTab", "tabIndex", "time2Pos", "updateSelectItemData", "transResult", "CaptionScrollListener", "Companion", "EditorCaptionAdapter", "plugin-vlog_release"})
public final class d
  extends LinearLayout
{
  public static final b NyF;
  private m<? super Integer, ? super Boolean, x> NyA;
  private kotlin.g.a.a<x> NyB;
  private List<Integer> NyC;
  private boolean NyD;
  private int NyE;
  private final f Nyd;
  private final f Nye;
  private final f Nyf;
  private final f Nyg;
  private final f Nyh;
  private final f Nyi;
  private final f Nyj;
  private final f Nyk;
  private final f Nyl;
  private final f Nym;
  private final f Nyn;
  private final f Nyo;
  private final f Nyp;
  private final f Nyq;
  private final f Nyr;
  private final f Nys;
  private final f Nyt;
  private final f Nyu;
  private final f Nyv;
  final List<c> Nyw;
  private kotlin.g.a.a<x> Nyx;
  private kotlin.g.a.b<? super Long, x> Nyy;
  private kotlin.g.a.b<? super Integer, x> Nyz;
  m<? super Integer, ? super ta, x> uYj;
  private final f zQn;
  
  static
  {
    AppMethodBeat.i(229435);
    NyF = new b((byte)0);
    AppMethodBeat.o(229435);
  }
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(229433);
    this.Nyd = g.ar((kotlin.g.a.a)new e(this));
    this.Nye = g.ar((kotlin.g.a.a)new h(this));
    this.Nyf = g.ar((kotlin.g.a.a)new f(this));
    this.Nyg = g.ar((kotlin.g.a.a)new p(this));
    this.Nyh = g.ar((kotlin.g.a.a)new r(this));
    this.Nyi = g.ar((kotlin.g.a.a)new q(this));
    this.Nyj = g.ar((kotlin.g.a.a)new g(this));
    this.Nyk = g.ar((kotlin.g.a.a)new d(this));
    this.Nyl = g.ar((kotlin.g.a.a)new o(this));
    this.Nym = g.ar((kotlin.g.a.a)new w(this));
    this.Nyn = g.ar((kotlin.g.a.a)new v(this));
    this.Nyo = g.ar((kotlin.g.a.a)new s(this));
    this.Nyp = g.ar((kotlin.g.a.a)new u(this));
    this.Nyq = g.ar((kotlin.g.a.a)new t(this));
    this.Nyr = g.ar((kotlin.g.a.a)new j(this));
    this.Nys = g.ar((kotlin.g.a.a)new i(this));
    this.Nyt = g.ar((kotlin.g.a.a)new l(this));
    this.Nyu = g.ar((kotlin.g.a.a)new m(this));
    this.zQn = g.ar((kotlin.g.a.a)new k(this));
    this.Nyv = g.ar((kotlin.g.a.a)new n(this));
    this.Nyw = j.listOf(new c[] { new c(0, paramContext), new c(1, paramContext) });
    this.NyC = j.mutableListOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(0) });
    LayoutInflater.from(paramContext).inflate(b.f.editor_text_caption_view, (ViewGroup)this, true);
    setBackgroundResource(b.d.bg_black_corner);
    setOrientation(1);
    Object localObject = getContentLayout();
    p.j(localObject, "contentLayout");
    ((LinearLayout)localObject).setVisibility(4);
    localObject = getEmptyLayout();
    p.j(localObject, "emptyLayout");
    ((LinearLayout)localObject).setVisibility(0);
    getCaptionTab().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(243548);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        d.c(this.NyG, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(243548);
      }
    });
    getRecordCaptionTab().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(251891);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        d.c(this.NyG, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(251891);
      }
    });
    findViewById(b.e.caption_close).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(251375);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.NyG.getDismissListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(251375);
      }
    });
    findViewById(b.e.trans_btn).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(248554);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = d.e(this.NyG);
        p.j(paramAnonymousView, "contentLayout");
        paramAnonymousView.setVisibility(0);
        paramAnonymousView = d.f(this.NyG);
        p.j(paramAnonymousView, "emptyLayout");
        paramAnonymousView.setVisibility(4);
        paramAnonymousView = this.NyG.getStartTransListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(0));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(248554);
      }
    });
    findViewById(b.e.clear_caption).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(250108);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        d.a(this.NyG, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(250108);
      }
    });
    getRecordTransBtn().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(244203);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = d.g(this.NyG);
        p.j(paramAnonymousView, "recordContentLayout");
        paramAnonymousView.setVisibility(0);
        paramAnonymousView = d.h(this.NyG);
        p.j(paramAnonymousView, "recordEmptyLayout");
        paramAnonymousView.setVisibility(4);
        paramAnonymousView = this.NyG.getStartTransListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(1));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(244203);
      }
    });
    getClearRecordBtn().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(223890);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        d.a(this.NyG, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(223890);
      }
    });
    int i = 0;
    while (i < 2)
    {
      localObject = getCaptionViews().get(i);
      p.j(localObject, "captionViews[i]");
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new EditorCaptionLayoutManager(paramContext));
      localObject = getCaptionViews().get(i);
      p.j(localObject, "captionViews[i]");
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.Nyw.get(i));
      ((RecyclerView)getCaptionViews().get(i)).a((RecyclerView.l)new a(i));
      i += 1;
    }
    AppMethodBeat.o(229433);
  }
  
  private final int aY(int paramInt, long paramLong)
  {
    AppMethodBeat.i(229430);
    if (((Number)this.NyC.get(paramInt)).intValue() >= ((c)this.Nyw.get(paramInt)).NxY.size())
    {
      Log.i("MicroMsg.EditorTextCaptionView", "maybe clear captionItems");
      this.NyC.set(paramInt, Integer.valueOf(((c)this.Nyw.get(paramInt)).NxY.size() - 1));
    }
    int i;
    if (((ta)((c)this.Nyw.get(paramInt)).NxY.get(((Number)this.NyC.get(paramInt)).intValue())).Scf > paramLong)
    {
      this.NyC.set(paramInt, Integer.valueOf(0));
      i = 1;
    }
    for (;;)
    {
      Object localObject;
      if (((ta)((c)this.Nyw.get(paramInt)).NxY.get(((Number)this.NyC.get(paramInt)).intValue())).Scg < paramLong)
      {
        localObject = this.NyC;
        ((List)localObject).set(paramInt, Integer.valueOf(((Number)((List)localObject).get(paramInt)).intValue() + 1));
      }
      else
      {
        ((c)this.Nyw.get(paramInt)).agM = ((Number)this.NyC.get(paramInt)).intValue();
        if (i != 0)
        {
          localObject = (RecyclerView)getCaptionViews().get(paramInt);
          com.tencent.mm.hellhoundlib.b.a locala = c.a(((Number)this.NyC.get(paramInt)).intValue(), new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "time2Pos", "(IJ)I", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerView)localObject).scrollToPosition(((Integer)locala.sf(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "time2Pos", "(IJ)I", "Undefined", "scrollToPosition", "(I)V");
        }
        paramInt = ((Number)this.NyC.get(paramInt)).intValue();
        AppMethodBeat.o(229430);
        return paramInt;
        i = 0;
      }
    }
  }
  
  private final ViewGroup getCaptionPanel()
  {
    AppMethodBeat.i(229378);
    ViewGroup localViewGroup = (ViewGroup)this.Nyk.getValue();
    AppMethodBeat.o(229378);
    return localViewGroup;
  }
  
  private final ViewGroup getCaptionTab()
  {
    AppMethodBeat.i(229369);
    ViewGroup localViewGroup = (ViewGroup)this.Nyd.getValue();
    AppMethodBeat.o(229369);
    return localViewGroup;
  }
  
  private final View getCaptionTabIndicator()
  {
    AppMethodBeat.i(229371);
    View localView = (View)this.Nyf.getValue();
    AppMethodBeat.o(229371);
    return localView;
  }
  
  private final View getCaptionTabSpace()
  {
    AppMethodBeat.i(229376);
    View localView = (View)this.Nyj.getValue();
    AppMethodBeat.o(229376);
    return localView;
  }
  
  private final TextView getCaptionTabText()
  {
    AppMethodBeat.i(229370);
    TextView localTextView = (TextView)this.Nye.getValue();
    AppMethodBeat.o(229370);
    return localTextView;
  }
  
  private final List<RecyclerView> getCaptionViews()
  {
    AppMethodBeat.i(229395);
    List localList = (List)this.Nys.getValue();
    AppMethodBeat.o(229395);
    return localList;
  }
  
  private final ViewGroup getClearRecordBtn()
  {
    AppMethodBeat.i(229393);
    ViewGroup localViewGroup = (ViewGroup)this.Nyr.getValue();
    AppMethodBeat.o(229393);
    return localViewGroup;
  }
  
  private final TextView getEmptyTipTxt()
  {
    AppMethodBeat.i(229398);
    TextView localTextView = (TextView)this.Nyu.getValue();
    AppMethodBeat.o(229398);
    return localTextView;
  }
  
  private final ViewGroup getRecordCaptionPanel()
  {
    AppMethodBeat.i(229379);
    ViewGroup localViewGroup = (ViewGroup)this.Nyl.getValue();
    AppMethodBeat.o(229379);
    return localViewGroup;
  }
  
  private final ViewGroup getRecordCaptionTab()
  {
    AppMethodBeat.i(229372);
    ViewGroup localViewGroup = (ViewGroup)this.Nyg.getValue();
    AppMethodBeat.o(229372);
    return localViewGroup;
  }
  
  private final View getRecordCaptionTabIndicator()
  {
    AppMethodBeat.i(229375);
    View localView = (View)this.Nyi.getValue();
    AppMethodBeat.o(229375);
    return localView;
  }
  
  private final TextView getRecordCaptionTabText()
  {
    AppMethodBeat.i(229374);
    TextView localTextView = (TextView)this.Nyh.getValue();
    AppMethodBeat.o(229374);
    return localTextView;
  }
  
  private final TextView getRecordTransBtn()
  {
    AppMethodBeat.i(229385);
    TextView localTextView = (TextView)this.Nyn.getValue();
    AppMethodBeat.o(229385);
    return localTextView;
  }
  
  private final TextView getTransBtn()
  {
    AppMethodBeat.i(229382);
    TextView localTextView = (TextView)this.Nym.getValue();
    AppMethodBeat.o(229382);
    return localTextView;
  }
  
  public final void aX(int paramInt, long paramLong)
  {
    AppMethodBeat.i(229427);
    if ((this.NyD) || (((c)this.Nyw.get(paramInt)).NxY.isEmpty()))
    {
      AppMethodBeat.o(229427);
      return;
    }
    int i = ((Number)this.NyC.get(paramInt)).intValue();
    aY(paramInt, paramLong);
    Object localObject = getCaptionViews().get(paramInt);
    p.j(localObject, "captionViews[type]");
    localObject = ((RecyclerView)localObject).getLayoutManager();
    if (localObject != null)
    {
      ((RecyclerView.LayoutManager)localObject).smoothScrollToPosition((RecyclerView)getCaptionViews().get(paramInt), new RecyclerView.s(), ((Number)this.NyC.get(paramInt)).intValue());
      this.Nyw.get(paramInt);
      c.hi(((RecyclerView.LayoutManager)localObject).findViewByPosition(i));
      this.Nyw.get(paramInt);
      c.hh(((RecyclerView.LayoutManager)localObject).findViewByPosition(((Number)this.NyC.get(paramInt)).intValue()));
      AppMethodBeat.o(229427);
      return;
    }
    AppMethodBeat.o(229427);
  }
  
  final void akq(int paramInt)
  {
    AppMethodBeat.i(229420);
    ((c)this.Nyw.get(paramInt)).NxY.clear();
    AppMethodBeat.o(229420);
  }
  
  public final void akr(int paramInt)
  {
    AppMethodBeat.i(229424);
    ((c)this.Nyw.get(paramInt)).notifyDataSetChanged();
    AppMethodBeat.o(229424);
  }
  
  public final void cF(int paramInt, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(229415);
    akq(paramInt);
    akr(paramInt);
    Object localObject;
    if (paramInt == 0)
    {
      localObject = getLoadingView();
      p.j(localObject, "loadingView");
      ((View)localObject).setVisibility(4);
      localObject = getContentLayout();
      p.j(localObject, "contentLayout");
      ((LinearLayout)localObject).setVisibility(4);
      localObject = getEmptyLayout();
      p.j(localObject, "emptyLayout");
      ((LinearLayout)localObject).setVisibility(0);
    }
    for (;;)
    {
      if (paramString != null)
      {
        localObject = getEmptyTipTxt();
        p.j(localObject, "emptyTipTxt");
        ((TextView)localObject).setText((CharSequence)paramString);
      }
      paramString = this.NyA;
      if (paramString == null) {
        break;
      }
      localObject = getEmptyLayout();
      p.j(localObject, "emptyLayout");
      if (((LinearLayout)localObject).getVisibility() != 4)
      {
        localObject = getRecordEmptyLayout();
        p.j(localObject, "recordEmptyLayout");
        if (((ViewGroup)localObject).getVisibility() != 4) {}
      }
      else
      {
        bool = true;
      }
      paramString.invoke(Integer.valueOf(paramInt), Boolean.valueOf(bool));
      AppMethodBeat.o(229415);
      return;
      localObject = getRecordLoadingView();
      p.j(localObject, "recordLoadingView");
      ((View)localObject).setVisibility(4);
      localObject = getRecordContentLayout();
      p.j(localObject, "recordContentLayout");
      ((ViewGroup)localObject).setVisibility(4);
      localObject = getRecordEmptyLayout();
      p.j(localObject, "recordEmptyLayout");
      ((ViewGroup)localObject).setVisibility(0);
    }
    AppMethodBeat.o(229415);
  }
  
  public final m<Integer, Boolean, x> getClearTransListener()
  {
    return this.NyA;
  }
  
  final LinearLayout getContentLayout()
  {
    AppMethodBeat.i(229400);
    LinearLayout localLinearLayout = (LinearLayout)this.zQn.getValue();
    AppMethodBeat.o(229400);
    return localLinearLayout;
  }
  
  public final kotlin.g.a.a<x> getDismissListener()
  {
    return this.NyB;
  }
  
  final LinearLayout getEmptyLayout()
  {
    AppMethodBeat.i(229396);
    LinearLayout localLinearLayout = (LinearLayout)this.Nyt.getValue();
    AppMethodBeat.o(229396);
    return localLinearLayout;
  }
  
  public final m<Integer, ta, x> getItemClickListener()
  {
    return this.uYj;
  }
  
  final View getLoadingView()
  {
    AppMethodBeat.i(229402);
    View localView = (View)this.Nyv.getValue();
    AppMethodBeat.o(229402);
    return localView;
  }
  
  final ViewGroup getRecordContentLayout()
  {
    AppMethodBeat.i(229387);
    ViewGroup localViewGroup = (ViewGroup)this.Nyo.getValue();
    AppMethodBeat.o(229387);
    return localViewGroup;
  }
  
  final ViewGroup getRecordEmptyLayout()
  {
    AppMethodBeat.i(229391);
    ViewGroup localViewGroup = (ViewGroup)this.Nyq.getValue();
    AppMethodBeat.o(229391);
    return localViewGroup;
  }
  
  final View getRecordLoadingView()
  {
    AppMethodBeat.i(229390);
    View localView = (View)this.Nyp.getValue();
    AppMethodBeat.o(229390);
    return localView;
  }
  
  public final kotlin.g.a.b<Integer, x> getStartTransListener()
  {
    return this.Nyz;
  }
  
  public final kotlin.g.a.a<x> getVideoPauseListener()
  {
    return this.Nyx;
  }
  
  public final kotlin.g.a.b<Long, x> getVideoSeekListener()
  {
    return this.Nyy;
  }
  
  public final void setClearTransListener(m<? super Integer, ? super Boolean, x> paramm)
  {
    this.NyA = paramm;
  }
  
  public final void setDismissListener(kotlin.g.a.a<x> parama)
  {
    this.NyB = parama;
  }
  
  public final void setItemClickListener(m<? super Integer, ? super ta, x> paramm)
  {
    this.uYj = paramm;
  }
  
  public final void setStartTransListener(kotlin.g.a.b<? super Integer, x> paramb)
  {
    this.Nyz = paramb;
  }
  
  public final void setVideoPauseListener(kotlin.g.a.a<x> parama)
  {
    this.Nyx = parama;
  }
  
  public final void setVideoSeekListener(kotlin.g.a.b<? super Long, x> paramb)
  {
    this.Nyy = paramb;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "type", "", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView;I)V", "getType", "()I", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "plugin-vlog_release"})
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
      AppMethodBeat.i(250866);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      switch (paramInt)
      {
      }
      do
      {
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(250866);
          return;
          Log.d("MicroMsg.EditorTextCaptionView", "SCROLL_STATE_DRAGGING");
          d.a(d.this, true);
          paramRecyclerView = d.this.getVideoPauseListener();
          if (paramRecyclerView != null) {
            paramRecyclerView.invoke();
          }
        }
      } while (!d.a(d.this));
      long l = ((ta)((d.c)d.b(d.this).get(this.type)).NxY.get(((Number)d.c(d.this).get(this.type)).intValue())).Scf;
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
      AppMethodBeat.i(250868);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      if (!d.a(d.this))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(250868);
        return;
      }
      paramInt2 = ((Number)d.c(d.this).get(this.type)).intValue();
      paramRecyclerView = d.d(d.this).get(this.type);
      p.j(paramRecyclerView, "captionViews[type]");
      paramRecyclerView = ((RecyclerView)paramRecyclerView).getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(250868);
        throw paramRecyclerView;
      }
      paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
      int i = (paramRecyclerView.kJ() + paramRecyclerView.kL()) / 2;
      if (i == ((d.c)d.b(d.this).get(this.type)).agM)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(250868);
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
          ((d.c)d.b(d.this).get(this.type)).agM = ((Number)d.c(d.this).get(this.type)).intValue();
          d.b(d.this).get(this.type);
          d.c.hi(paramRecyclerView.findViewByPosition(paramInt2));
          d.b(d.this).get(this.type);
          d.c.hh(paramRecyclerView.findViewByPosition(((Number)d.c(d.this).get(this.type)).intValue()));
          Log.d("MicroMsg.EditorTextCaptionView", "onScrolled currentPos  " + d.c(d.this) + ' ' + paramInt2);
        }
        while (paramInt1 == i)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(250868);
          return;
        }
        paramInt1 += 1;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$Companion;", "", "()V", "LIST_ROW", "", "TAG", "", "TYPE_CAPTION", "TYPE_RECORD_CAPTION", "UNSELECTED_ALPHA", "", "plugin-vlog_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "type", "", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView;ILandroid/content/Context;)V", "captionItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "getCaptionItems", "()Ljava/util/ArrayList;", "setCaptionItems", "(Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "currentPos", "getCurrentPos", "()I", "setCurrentPos", "(I)V", "getItemCount", "getString", "", "byte", "Lcom/tencent/mm/protobuf/ByteString;", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "selectView", "itemView", "Landroid/view/View;", "ccTransResult", "unSelectView", "plugin-vlog_release"})
  public final class c
    extends RecyclerView.a<RecyclerView.v>
  {
    ArrayList<ta> NxY;
    int agM;
    private Context context;
    private final int type;
    
    public c(Context paramContext)
    {
      AppMethodBeat.i(234855);
      this.type = paramContext;
      this.context = localObject;
      this.NxY = new ArrayList();
      AppMethodBeat.o(234855);
    }
    
    private static void a(View paramView, ta paramta)
    {
      AppMethodBeat.i(234849);
      if (paramView == null)
      {
        AppMethodBeat.o(234849);
        return;
      }
      paramView.setAlpha(1.0F);
      paramView = (ImageView)paramView.findViewById(b.e.caption_edit);
      if ((paramta != null) && (paramta.Sch == true))
      {
        p.j(paramView, "img");
        paramView.setVisibility(4);
        AppMethodBeat.o(234849);
        return;
      }
      p.j(paramView, "img");
      paramView.setImageDrawable(au.o(paramView.getContext(), b.g.icons_filled_pencil, -1));
      paramView.setVisibility(0);
      AppMethodBeat.o(234849);
    }
    
    private static String e(com.tencent.mm.cd.b paramb)
    {
      AppMethodBeat.i(234854);
      if (paramb == null)
      {
        AppMethodBeat.o(234854);
        return "";
      }
      paramb = paramb.toString("UTF-8");
      p.j(paramb, "byte.toString(\"UTF-8\")");
      AppMethodBeat.o(234854);
      return paramb;
    }
    
    public static void hi(View paramView)
    {
      AppMethodBeat.i(234852);
      if (paramView == null)
      {
        AppMethodBeat.o(234852);
        return;
      }
      paramView.setAlpha(0.5F);
      paramView = paramView.findViewById(b.e.caption_edit);
      p.j(paramView, "itemView.findViewById<Im…eView>(R.id.caption_edit)");
      ((ImageView)paramView).setVisibility(4);
      AppMethodBeat.o(234852);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(234842);
      p.k(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(this.context).inflate(b.f.editor_text_caption_item, paramViewGroup, false);
      if (paramViewGroup == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(234842);
        throw paramViewGroup;
      }
      paramViewGroup = (ViewGroup)paramViewGroup;
      paramViewGroup = (RecyclerView.v)new b(paramViewGroup, (View)paramViewGroup);
      AppMethodBeat.o(234842);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, final int paramInt)
    {
      AppMethodBeat.i(234846);
      p.k(paramv, "viewHolder");
      Object localObject = paramv.amk;
      p.j(localObject, "viewHolder.itemView");
      if ((TextUtils.isEmpty((CharSequence)e(((ta)this.NxY.get(paramInt)).Sce))) || (((ta)this.NxY.get(paramInt)).Sch))
      {
        ((View)localObject).setVisibility(4);
        paramv.amk.setOnClickListener((View.OnClickListener)new a(this, paramInt));
        AppMethodBeat.o(234846);
        return;
      }
      ((View)localObject).setVisibility(0);
      if (this.agM == paramInt) {
        a((View)localObject, (ta)this.NxY.get(paramInt));
      }
      for (;;)
      {
        localObject = (TextView)((View)localObject).findViewById(b.e.caption_content);
        p.j(localObject, "contentView");
        ((TextView)localObject).setText((CharSequence)e(((ta)this.NxY.get(paramInt)).Sce));
        break;
        hi((View)localObject);
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(234845);
      int i = this.NxY.size();
      AppMethodBeat.o(234845);
      return i;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(d.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(237967);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if (!((ta)this.NyH.NxY.get(paramInt)).Sch)
        {
          paramView = this.NyH.NyG.getItemClickListener();
          if (paramView != null)
          {
            int i = d.c.a(this.NyH);
            localObject = this.NyH.NxY.get(paramInt);
            p.j(localObject, "captionItems[position]");
            paramView.invoke(Integer.valueOf(i), localObject);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(237967);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter$onCreateViewHolder$1", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-vlog_release"})
    public static final class b
      extends RecyclerView.v
    {
      b(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    e(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<View>
  {
    f(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<View>
  {
    g(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<TextView>
  {
    h(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<List<? extends RecyclerView>>
  {
    i(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    j(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<LinearLayout>
  {
    k(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<LinearLayout>
  {
    l(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<TextView>
  {
    m(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<View>
  {
    n(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    o(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    p(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<View>
  {
    q(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class r
    extends q
    implements kotlin.g.a.a<TextView>
  {
    r(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class s
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    s(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class t
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    t(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class u
    extends q
    implements kotlin.g.a.a<View>
  {
    u(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class v
    extends q
    implements kotlin.g.a.a<TextView>
  {
    v(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.b.d;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bb;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapters", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter;", "captionPanel", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "getCaptionPanel", "()Landroid/view/ViewGroup;", "captionPanel$delegate", "Lkotlin/Lazy;", "captionTab", "getCaptionTab", "captionTab$delegate", "captionTabIndicator", "Landroid/view/View;", "getCaptionTabIndicator", "()Landroid/view/View;", "captionTabIndicator$delegate", "captionTabSpace", "getCaptionTabSpace", "captionTabSpace$delegate", "captionTabText", "Landroid/widget/TextView;", "getCaptionTabText", "()Landroid/widget/TextView;", "captionTabText$delegate", "captionViews", "Landroidx/recyclerview/widget/RecyclerView;", "getCaptionViews", "()Ljava/util/List;", "captionViews$delegate", "clearRecordBtn", "getClearRecordBtn", "clearRecordBtn$delegate", "clearTransListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "type", "", "hasTranslate", "", "getClearTransListener", "()Lkotlin/jvm/functions/Function2;", "setClearTransListener", "(Lkotlin/jvm/functions/Function2;)V", "contentLayout", "getContentLayout", "()Landroid/widget/LinearLayout;", "contentLayout$delegate", "curTab", "currentPos", "", "dismissListener", "Lkotlin/Function0;", "getDismissListener", "()Lkotlin/jvm/functions/Function0;", "setDismissListener", "(Lkotlin/jvm/functions/Function0;)V", "emptyLayout", "getEmptyLayout", "emptyLayout$delegate", "emptyTipTxt", "getEmptyTipTxt", "emptyTipTxt$delegate", "itemClickListener", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "result", "getItemClickListener", "setItemClickListener", "loadingView", "getLoadingView", "loadingView$delegate", "onTouchingView", "recordCaptionPanel", "getRecordCaptionPanel", "recordCaptionPanel$delegate", "recordCaptionTab", "getRecordCaptionTab", "recordCaptionTab$delegate", "recordCaptionTabIndicator", "getRecordCaptionTabIndicator", "recordCaptionTabIndicator$delegate", "recordCaptionTabText", "getRecordCaptionTabText", "recordCaptionTabText$delegate", "recordContentLayout", "getRecordContentLayout", "recordContentLayout$delegate", "recordEmptyLayout", "getRecordEmptyLayout", "recordEmptyLayout$delegate", "recordLoadingView", "getRecordLoadingView", "recordLoadingView$delegate", "recordTransBtn", "getRecordTransBtn", "recordTransBtn$delegate", "startTransListener", "Lkotlin/Function1;", "getStartTransListener", "()Lkotlin/jvm/functions/Function1;", "setStartTransListener", "(Lkotlin/jvm/functions/Function1;)V", "transBtn", "getTransBtn", "transBtn$delegate", "videoPauseListener", "getVideoPauseListener", "setVideoPauseListener", "videoSeekListener", "", "timestampMs", "getVideoSeekListener", "setVideoSeekListener", "addCaptionItemData", "items", "clearCaption", "tip", "", "clearCaptionData", "disableRecordCaption", "enableRecordCaption", "hasInit", "ifCenter", "view", "notifyDataSetChanged", "scrollToMid", "scrollToTimeMs", "timeStampMs", "showCaption", "showLoading", "switchTab", "tabIndex", "time2Pos", "updateSelectItemData", "transResult", "CaptionScrollListener", "Companion", "EditorCaptionAdapter", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends LinearLayout
{
  public static final d.b Ulc;
  private kotlin.g.a.b<? super Integer, ah> UlA;
  private m<? super Integer, ? super Boolean, ah> UlB;
  private kotlin.g.a.a<ah> UlC;
  private List<Integer> UlD;
  private boolean UlE;
  private int UlF;
  private final j Uld;
  private final j Ule;
  private final j Ulf;
  private final j Ulg;
  private final j Ulh;
  private final j Uli;
  private final j Ulj;
  private final j Ulk;
  private final j Ull;
  private final j Ulm;
  private final j Uln;
  private final j Ulo;
  private final j Ulp;
  private final j Ulq;
  private final j Ulr;
  private final j Uls;
  private final j Ult;
  private final j Ulu;
  private final j Ulv;
  private final j Ulw;
  final List<c> Ulx;
  private kotlin.g.a.a<ah> Uly;
  private kotlin.g.a.b<? super Long, ah> Ulz;
  m<? super Integer, ? super uq, ah> ykx;
  
  static
  {
    AppMethodBeat.i(283508);
    Ulc = new d.b((byte)0);
    AppMethodBeat.o(283508);
  }
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(283280);
    this.Uld = k.cm((kotlin.g.a.a)new e(this));
    this.Ule = k.cm((kotlin.g.a.a)new h(this));
    this.Ulf = k.cm((kotlin.g.a.a)new f(this));
    this.Ulg = k.cm((kotlin.g.a.a)new p(this));
    this.Ulh = k.cm((kotlin.g.a.a)new r(this));
    this.Uli = k.cm((kotlin.g.a.a)new q(this));
    this.Ulj = k.cm((kotlin.g.a.a)new g(this));
    this.Ulk = k.cm((kotlin.g.a.a)new d(this));
    this.Ull = k.cm((kotlin.g.a.a)new o(this));
    this.Ulm = k.cm((kotlin.g.a.a)new w(this));
    this.Uln = k.cm((kotlin.g.a.a)new v(this));
    this.Ulo = k.cm((kotlin.g.a.a)new s(this));
    this.Ulp = k.cm((kotlin.g.a.a)new u(this));
    this.Ulq = k.cm((kotlin.g.a.a)new t(this));
    this.Ulr = k.cm((kotlin.g.a.a)new j(this));
    this.Uls = k.cm((kotlin.g.a.a)new i(this));
    this.Ult = k.cm((kotlin.g.a.a)new l(this));
    this.Ulu = k.cm((kotlin.g.a.a)new m(this));
    this.Ulv = k.cm((kotlin.g.a.a)new k(this));
    this.Ulw = k.cm((kotlin.g.a.a)new n(this));
    this.Ulx = p.listOf(new c[] { new c(0, paramContext), new c(1, paramContext) });
    this.UlD = p.mutableListOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(0) });
    LayoutInflater.from(paramContext).inflate(b.f.editor_text_caption_view, (ViewGroup)this, true);
    setBackgroundResource(b.d.bg_black_corner);
    setOrientation(1);
    getContentLayout().setVisibility(4);
    getEmptyLayout().setVisibility(0);
    getCaptionTab().setOnClickListener(new d..ExternalSyntheticLambda0(this));
    getRecordCaptionTab().setOnClickListener(new d..ExternalSyntheticLambda3(this));
    findViewById(b.e.caption_close).setOnClickListener(new d..ExternalSyntheticLambda4(this));
    findViewById(b.e.trans_btn).setOnClickListener(new d..ExternalSyntheticLambda5(this));
    findViewById(b.e.clear_caption).setOnClickListener(new d..ExternalSyntheticLambda6(this));
    getRecordTransBtn().setOnClickListener(new d..ExternalSyntheticLambda1(this));
    getClearRecordBtn().setOnClickListener(new d..ExternalSyntheticLambda2(this));
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      ((RecyclerView)getCaptionViews().get(i)).setLayoutManager((RecyclerView.LayoutManager)new EditorCaptionLayoutManager(paramContext));
      ((RecyclerView)getCaptionViews().get(i)).setAdapter((RecyclerView.a)this.Ulx.get(i));
      ((RecyclerView)getCaptionViews().get(i)).a((RecyclerView.l)new a(i));
      if (j >= 2)
      {
        AppMethodBeat.o(283280);
        return;
      }
    }
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(283406);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    paramd.apM(0);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(283406);
  }
  
  private final void apM(int paramInt)
  {
    AppMethodBeat.i(283397);
    this.UlF = paramInt;
    if (this.UlF == 0)
    {
      getCaptionTabIndicator().setVisibility(0);
      getRecordCaptionTabIndicator().setVisibility(4);
      getCaptionTabText().setTextColor(getContext().getResources().getColor(b.b.white_text_color));
      getRecordCaptionTabText().setTextColor(getContext().getResources().getColor(b.b.white_text_color_disabled));
      getCaptionPanel().setVisibility(0);
      getRecordCaptionPanel().setVisibility(8);
      AppMethodBeat.o(283397);
      return;
    }
    getCaptionTabIndicator().setVisibility(4);
    getRecordCaptionTabIndicator().setVisibility(0);
    getCaptionTabText().setTextColor(getContext().getResources().getColor(b.b.white_text_color_disabled));
    getRecordCaptionTabText().setTextColor(getContext().getResources().getColor(b.b.white_text_color));
    getCaptionPanel().setVisibility(8);
    getRecordCaptionPanel().setVisibility(0);
    AppMethodBeat.o(283397);
  }
  
  private static final void b(d paramd, View paramView)
  {
    AppMethodBeat.i(283415);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    paramd.apM(1);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(283415);
  }
  
  private final int bg(int paramInt, long paramLong)
  {
    AppMethodBeat.i(283387);
    if (((Number)this.UlD.get(paramInt)).intValue() >= ((c)this.Ulx.get(paramInt)).UkY.size())
    {
      Log.i("MicroMsg.EditorTextCaptionView", "maybe clear captionItems");
      this.UlD.set(paramInt, Integer.valueOf(((c)this.Ulx.get(paramInt)).UkY.size() - 1));
    }
    int i;
    if (((uq)((c)this.Ulx.get(paramInt)).UkY.get(((Number)this.UlD.get(paramInt)).intValue())).YZX > paramLong)
    {
      this.UlD.set(paramInt, Integer.valueOf(0));
      i = 1;
    }
    for (;;)
    {
      Object localObject;
      if (((uq)((c)this.Ulx.get(paramInt)).UkY.get(((Number)this.UlD.get(paramInt)).intValue())).YZY < paramLong)
      {
        localObject = this.UlD;
        ((List)localObject).set(paramInt, Integer.valueOf(((Number)((List)localObject).get(paramInt)).intValue() + 1));
      }
      else
      {
        ((c)this.Ulx.get(paramInt)).bVs = ((Number)this.UlD.get(paramInt)).intValue();
        if (i != 0)
        {
          localObject = (RecyclerView)getCaptionViews().get(paramInt);
          com.tencent.mm.hellhoundlib.b.a locala = c.a(((Number)this.UlD.get(paramInt)).intValue(), new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "time2Pos", "(IJ)I", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerView)localObject).scrollToPosition(((Integer)locala.sb(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "time2Pos", "(IJ)I", "Undefined", "scrollToPosition", "(I)V");
        }
        paramInt = ((Number)this.UlD.get(paramInt)).intValue();
        AppMethodBeat.o(283387);
        return paramInt;
        i = 0;
      }
    }
  }
  
  private static final void c(d paramd, View paramView)
  {
    AppMethodBeat.i(283422);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    paramd = paramd.getDismissListener();
    if (paramd != null) {
      paramd.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(283422);
  }
  
  private static final void d(d paramd, View paramView)
  {
    AppMethodBeat.i(283427);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    paramd.getContentLayout().setVisibility(0);
    paramd.getEmptyLayout().setVisibility(4);
    paramd = paramd.getStartTransListener();
    if (paramd != null) {
      paramd.invoke(Integer.valueOf(0));
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(283427);
  }
  
  private static final void e(d paramd, View paramView)
  {
    AppMethodBeat.i(283432);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    paramd.dv(0, null);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(283432);
  }
  
  private static final void f(d paramd, View paramView)
  {
    AppMethodBeat.i(283438);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    paramd.getRecordContentLayout().setVisibility(0);
    paramd.getRecordEmptyLayout().setVisibility(4);
    paramd = paramd.getStartTransListener();
    if (paramd != null) {
      paramd.invoke(Integer.valueOf(1));
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(283438);
  }
  
  private static final void g(d paramd, View paramView)
  {
    AppMethodBeat.i(283447);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    paramd.dv(1, null);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(283447);
  }
  
  private final ViewGroup getCaptionPanel()
  {
    AppMethodBeat.i(283339);
    ViewGroup localViewGroup = (ViewGroup)this.Ulk.getValue();
    AppMethodBeat.o(283339);
    return localViewGroup;
  }
  
  private final ViewGroup getCaptionTab()
  {
    AppMethodBeat.i(283288);
    ViewGroup localViewGroup = (ViewGroup)this.Uld.getValue();
    AppMethodBeat.o(283288);
    return localViewGroup;
  }
  
  private final View getCaptionTabIndicator()
  {
    AppMethodBeat.i(283302);
    View localView = (View)this.Ulf.getValue();
    AppMethodBeat.o(283302);
    return localView;
  }
  
  private final View getCaptionTabSpace()
  {
    AppMethodBeat.i(283333);
    View localView = (View)this.Ulj.getValue();
    AppMethodBeat.o(283333);
    return localView;
  }
  
  private final TextView getCaptionTabText()
  {
    AppMethodBeat.i(283296);
    TextView localTextView = (TextView)this.Ule.getValue();
    AppMethodBeat.o(283296);
    return localTextView;
  }
  
  private final List<RecyclerView> getCaptionViews()
  {
    AppMethodBeat.i(283366);
    List localList = (List)this.Uls.getValue();
    AppMethodBeat.o(283366);
    return localList;
  }
  
  private final ViewGroup getClearRecordBtn()
  {
    AppMethodBeat.i(283359);
    ViewGroup localViewGroup = (ViewGroup)this.Ulr.getValue();
    AppMethodBeat.o(283359);
    return localViewGroup;
  }
  
  private final TextView getEmptyTipTxt()
  {
    AppMethodBeat.i(283372);
    TextView localTextView = (TextView)this.Ulu.getValue();
    AppMethodBeat.o(283372);
    return localTextView;
  }
  
  private final ViewGroup getRecordCaptionPanel()
  {
    AppMethodBeat.i(283344);
    ViewGroup localViewGroup = (ViewGroup)this.Ull.getValue();
    AppMethodBeat.o(283344);
    return localViewGroup;
  }
  
  private final ViewGroup getRecordCaptionTab()
  {
    AppMethodBeat.i(283312);
    ViewGroup localViewGroup = (ViewGroup)this.Ulg.getValue();
    AppMethodBeat.o(283312);
    return localViewGroup;
  }
  
  private final View getRecordCaptionTabIndicator()
  {
    AppMethodBeat.i(283326);
    View localView = (View)this.Uli.getValue();
    AppMethodBeat.o(283326);
    return localView;
  }
  
  private final TextView getRecordCaptionTabText()
  {
    AppMethodBeat.i(283318);
    TextView localTextView = (TextView)this.Ulh.getValue();
    AppMethodBeat.o(283318);
    return localTextView;
  }
  
  private final TextView getRecordTransBtn()
  {
    AppMethodBeat.i(283355);
    TextView localTextView = (TextView)this.Uln.getValue();
    AppMethodBeat.o(283355);
    return localTextView;
  }
  
  private final TextView getTransBtn()
  {
    AppMethodBeat.i(283347);
    TextView localTextView = (TextView)this.Ulm.getValue();
    AppMethodBeat.o(283347);
    return localTextView;
  }
  
  final void apK(int paramInt)
  {
    AppMethodBeat.i(283667);
    ((c)this.Ulx.get(paramInt)).UkY.clear();
    AppMethodBeat.o(283667);
  }
  
  public final void apL(int paramInt)
  {
    AppMethodBeat.i(283677);
    ((c)this.Ulx.get(paramInt)).bZE.notifyChanged();
    AppMethodBeat.o(283677);
  }
  
  public final void bf(int paramInt, long paramLong)
  {
    AppMethodBeat.i(283686);
    if ((this.UlE) || (((c)this.Ulx.get(paramInt)).UkY.isEmpty()))
    {
      AppMethodBeat.o(283686);
      return;
    }
    int i = ((Number)this.UlD.get(paramInt)).intValue();
    bg(paramInt, paramLong);
    RecyclerView.LayoutManager localLayoutManager = ((RecyclerView)getCaptionViews().get(paramInt)).getLayoutManager();
    if (localLayoutManager != null)
    {
      localLayoutManager.smoothScrollToPosition((RecyclerView)getCaptionViews().get(paramInt), new RecyclerView.s(), ((Number)this.UlD.get(paramInt)).intValue());
      this.Ulx.get(paramInt);
      c.kt(localLayoutManager.findViewByPosition(i));
      this.Ulx.get(paramInt);
      c.ks(localLayoutManager.findViewByPosition(((Number)this.UlD.get(paramInt)).intValue()));
    }
    AppMethodBeat.o(283686);
  }
  
  public final void dv(int paramInt, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(283660);
    apK(paramInt);
    apL(paramInt);
    if (paramInt == 0)
    {
      getLoadingView().setVisibility(4);
      getContentLayout().setVisibility(4);
      getEmptyLayout().setVisibility(0);
    }
    for (;;)
    {
      if (paramString != null) {
        getEmptyTipTxt().setText((CharSequence)paramString);
      }
      paramString = this.UlB;
      if (paramString != null)
      {
        if ((getEmptyLayout().getVisibility() == 4) || (getRecordEmptyLayout().getVisibility() == 4)) {
          bool = true;
        }
        paramString.invoke(Integer.valueOf(paramInt), Boolean.valueOf(bool));
      }
      AppMethodBeat.o(283660);
      return;
      getRecordLoadingView().setVisibility(4);
      getRecordContentLayout().setVisibility(4);
      getRecordEmptyLayout().setVisibility(0);
    }
  }
  
  public final m<Integer, Boolean, ah> getClearTransListener()
  {
    return this.UlB;
  }
  
  final LinearLayout getContentLayout()
  {
    AppMethodBeat.i(283593);
    LinearLayout localLinearLayout = (LinearLayout)this.Ulv.getValue();
    AppMethodBeat.o(283593);
    return localLinearLayout;
  }
  
  public final kotlin.g.a.a<ah> getDismissListener()
  {
    return this.UlC;
  }
  
  final LinearLayout getEmptyLayout()
  {
    AppMethodBeat.i(283586);
    LinearLayout localLinearLayout = (LinearLayout)this.Ult.getValue();
    AppMethodBeat.o(283586);
    return localLinearLayout;
  }
  
  public final m<Integer, uq, ah> getItemClickListener()
  {
    return this.ykx;
  }
  
  final View getLoadingView()
  {
    AppMethodBeat.i(283598);
    View localView = (View)this.Ulw.getValue();
    AppMethodBeat.o(283598);
    return localView;
  }
  
  final ViewGroup getRecordContentLayout()
  {
    AppMethodBeat.i(283567);
    ViewGroup localViewGroup = (ViewGroup)this.Ulo.getValue();
    AppMethodBeat.o(283567);
    return localViewGroup;
  }
  
  final ViewGroup getRecordEmptyLayout()
  {
    AppMethodBeat.i(283580);
    ViewGroup localViewGroup = (ViewGroup)this.Ulq.getValue();
    AppMethodBeat.o(283580);
    return localViewGroup;
  }
  
  final View getRecordLoadingView()
  {
    AppMethodBeat.i(283573);
    View localView = (View)this.Ulp.getValue();
    AppMethodBeat.o(283573);
    return localView;
  }
  
  public final kotlin.g.a.b<Integer, ah> getStartTransListener()
  {
    return this.UlA;
  }
  
  public final kotlin.g.a.a<ah> getVideoPauseListener()
  {
    return this.Uly;
  }
  
  public final kotlin.g.a.b<Long, ah> getVideoSeekListener()
  {
    return this.Ulz;
  }
  
  public final void setClearTransListener(m<? super Integer, ? super Boolean, ah> paramm)
  {
    this.UlB = paramm;
  }
  
  public final void setDismissListener(kotlin.g.a.a<ah> parama)
  {
    this.UlC = parama;
  }
  
  public final void setItemClickListener(m<? super Integer, ? super uq, ah> paramm)
  {
    this.ykx = paramm;
  }
  
  public final void setStartTransListener(kotlin.g.a.b<? super Integer, ah> paramb)
  {
    this.UlA = paramb;
  }
  
  public final void setVideoPauseListener(kotlin.g.a.a<ah> parama)
  {
    this.Uly = parama;
  }
  
  public final void setVideoSeekListener(kotlin.g.a.b<? super Long, ah> paramb)
  {
    this.Ulz = paramb;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "type", "", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView;I)V", "getType", "()I", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends RecyclerView.l
  {
    private final int type;
    
    public a()
    {
      AppMethodBeat.i(283164);
      int i;
      this.type = i;
      AppMethodBeat.o(283164);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(283174);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      switch (paramInt)
      {
      }
      do
      {
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(283174);
          return;
          Log.d("MicroMsg.EditorTextCaptionView", "SCROLL_STATE_DRAGGING");
          d.a(d.this, true);
          paramRecyclerView = d.this.getVideoPauseListener();
          if (paramRecyclerView != null) {
            paramRecyclerView.invoke();
          }
        }
      } while (!d.a(d.this));
      long l = ((uq)((d.c)d.b(d.this).get(this.type)).UkY.get(((Number)d.c(d.this).get(this.type)).intValue())).YZX;
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
      AppMethodBeat.i(283190);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      if (!d.a(d.this))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(283190);
        return;
      }
      paramInt2 = ((Number)d.c(d.this).get(this.type)).intValue();
      paramRecyclerView = ((RecyclerView)d.d(d.this).get(this.type)).getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(283190);
        throw paramRecyclerView;
      }
      paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
      int i = (paramRecyclerView.Ju() + paramRecyclerView.Jw()) / 2;
      if (i == ((d.c)d.b(d.this).get(this.type)).bVs)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(283190);
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
          ((d.c)d.b(d.this).get(this.type)).bVs = ((Number)d.c(d.this).get(this.type)).intValue();
          d.b(d.this).get(this.type);
          d.c.kt(paramRecyclerView.findViewByPosition(paramInt2));
          d.b(d.this).get(this.type);
          d.c.ks(paramRecyclerView.findViewByPosition(((Number)d.c(d.this).get(this.type)).intValue()));
          Log.d("MicroMsg.EditorTextCaptionView", "onScrolled currentPos  " + d.c(d.this) + ' ' + paramInt2);
        }
        while (paramInt1 == i)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(283190);
          return;
        }
        paramInt1 += 1;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "type", "", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView;ILandroid/content/Context;)V", "captionItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "getCaptionItems", "()Ljava/util/ArrayList;", "setCaptionItems", "(Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "currentPos", "getCurrentPos", "()I", "setCurrentPos", "(I)V", "getItemCount", "getString", "", "byte", "Lcom/tencent/mm/protobuf/ByteString;", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "selectView", "itemView", "Landroid/view/View;", "ccTransResult", "unSelectView", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends RecyclerView.a<RecyclerView.v>
  {
    ArrayList<uq> UkY;
    int bVs;
    private Context context;
    private final int type;
    
    public c(Context paramContext)
    {
      AppMethodBeat.i(283166);
      this.type = paramContext;
      this.context = localObject;
      this.UkY = new ArrayList();
      AppMethodBeat.o(283166);
    }
    
    private static void a(View paramView, uq paramuq)
    {
      int i = 1;
      AppMethodBeat.i(283173);
      if (paramView == null)
      {
        AppMethodBeat.o(283173);
        return;
      }
      paramView.setAlpha(1.0F);
      paramView = (ImageView)paramView.findViewById(b.e.caption_edit);
      if ((paramuq != null) && (paramuq.YZZ == true)) {}
      while (i != 0)
      {
        paramView.setVisibility(4);
        AppMethodBeat.o(283173);
        return;
        i = 0;
      }
      paramView.setImageDrawable(bb.m(paramView.getContext(), b.g.icons_filled_pencil, -1));
      paramView.setVisibility(0);
      AppMethodBeat.o(283173);
    }
    
    private static final void a(c paramc, int paramInt, d paramd, View paramView)
    {
      AppMethodBeat.i(283200);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramc);
      localb.sc(paramInt);
      localb.cH(paramd);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramc, "this$0");
      s.u(paramd, "this$1");
      if (!((uq)paramc.UkY.get(paramInt)).YZZ)
      {
        paramd = paramd.getItemClickListener();
        if (paramd != null)
        {
          int i = paramc.type;
          paramc = paramc.UkY.get(paramInt);
          s.s(paramc, "captionItems[position]");
          paramd.invoke(Integer.valueOf(i), paramc);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(283200);
    }
    
    private static String j(com.tencent.mm.bx.b paramb)
    {
      AppMethodBeat.i(283192);
      if (paramb == null)
      {
        AppMethodBeat.o(283192);
        return "";
      }
      paramb = paramb.toString("UTF-8");
      s.s(paramb, "byte.toString(\"UTF-8\")");
      AppMethodBeat.o(283192);
      return paramb;
    }
    
    public static void kt(View paramView)
    {
      AppMethodBeat.i(283189);
      if (paramView == null)
      {
        AppMethodBeat.o(283189);
        return;
      }
      paramView.setAlpha(0.5F);
      ((ImageView)paramView.findViewById(b.e.caption_edit)).setVisibility(4);
      AppMethodBeat.o(283189);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(283214);
      s.u(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(this.context).inflate(b.f.editor_text_caption_item, paramViewGroup, false);
      if (paramViewGroup == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(283214);
        throw paramViewGroup;
      }
      paramViewGroup = (RecyclerView.v)new a((ViewGroup)paramViewGroup);
      AppMethodBeat.o(283214);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(283229);
      s.u(paramv, "viewHolder");
      View localView = paramv.caK;
      s.s(localView, "viewHolder.itemView");
      if ((TextUtils.isEmpty((CharSequence)j(((uq)this.UkY.get(paramInt)).YZW))) || (((uq)this.UkY.get(paramInt)).YZZ))
      {
        localView.setVisibility(4);
        paramv.caK.setOnClickListener(new d.c..ExternalSyntheticLambda0(this, paramInt, d.this));
        AppMethodBeat.o(283229);
        return;
      }
      localView.setVisibility(0);
      if (this.bVs == paramInt) {
        a(localView, (uq)this.UkY.get(paramInt));
      }
      for (;;)
      {
        ((TextView)localView.findViewById(b.e.caption_content)).setText((CharSequence)j(((uq)this.UkY.get(paramInt)).YZW));
        break;
        kt(localView);
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(283219);
      int i = this.UkY.size();
      AppMethodBeat.o(283219);
      return i;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter$onCreateViewHolder$1", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends RecyclerView.v
    {
      a(ViewGroup paramViewGroup)
      {
        super();
        AppMethodBeat.i(283142);
        AppMethodBeat.o(283142);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    e(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<View>
  {
    f(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<View>
  {
    g(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<TextView>
  {
    h(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<List<? extends RecyclerView>>
  {
    i(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    j(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    k(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    l(d paramd)
    {
      super();
    }
    
    private static final void ku(View paramView)
    {
      AppMethodBeat.i(283225);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$emptyLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$emptyLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(283225);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<TextView>
  {
    m(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<View>
  {
    n(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    o(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    p(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements kotlin.g.a.a<View>
  {
    q(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends u
    implements kotlin.g.a.a<TextView>
  {
    r(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    s(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    t(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends u
    implements kotlin.g.a.a<View>
  {
    u(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends u
    implements kotlin.g.a.a<TextView>
  {
    v(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class w
    extends u
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
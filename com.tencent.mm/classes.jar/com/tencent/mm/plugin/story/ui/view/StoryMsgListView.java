package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.plugin.story.ui.a.f;
import com.tencent.mm.ui.at;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/StoryMsgListView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "commentsRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "emptyTipView", "Landroid/widget/TextView;", "mode", "offsetY", "onBlankClick", "Lkotlin/Function0;", "", "getOnBlankClick", "()Lkotlin/jvm/functions/Function0;", "setOnBlankClick", "(Lkotlin/jvm/functions/Function0;)V", "onCommentItemClick", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/ParameterName;", "name", "commentItem", "getOnCommentItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnCommentItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onContentTopOverScroll", "dy", "getOnContentTopOverScroll", "setOnContentTopOverScroll", "onContentTopOverScrollStop", "getOnContentTopOverScrollStop", "setOnContentTopOverScrollStop", "viewConfig", "Landroid/view/ViewConfiguration;", "adjustContentLayout", "bottomMargin", "copyDataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "oriDataList", "", "onNestedPreScroll", "target", "Landroid/view/View;", "dx", "consumed", "", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "", "nestedScrollAxes", "onStopNestedScroll", "setup", "comments", "bubbles", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "updateCommentListId", "datas", "updateMsgList", "Companion", "plugin-story_release"})
public final class StoryMsgListView
  extends RelativeLayout
{
  private static final int FDt = 0;
  private static final int FDu = 1;
  public static final StoryMsgListView.a FDv;
  private final RecyclerView FDq;
  private final TextView FDr;
  private ViewConfiguration FDs;
  private kotlin.g.a.b<? super com.tencent.mm.plugin.story.f.b.a, x> Fyo;
  private kotlin.g.a.a<x> Fyp;
  private kotlin.g.a.b<? super Integer, x> Fyq;
  private kotlin.g.a.a<x> Fyr;
  private int mba;
  private int mode;
  
  static
  {
    AppMethodBeat.i(120243);
    FDv = new StoryMsgListView.a((byte)0);
    FDu = 1;
    AppMethodBeat.o(120243);
  }
  
  public StoryMsgListView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(120241);
    AppMethodBeat.o(120241);
  }
  
  public StoryMsgListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(120242);
    AppMethodBeat.o(120242);
  }
  
  public StoryMsgListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120240);
    this.mode = -1;
    View.inflate(paramContext, 2131496614, (ViewGroup)this);
    paramAttributeSet = findViewById(2131308683);
    p.g(paramAttributeSet, "findViewById(R.id.story_msg_recycler_view)");
    this.FDq = ((RecyclerView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308680);
    p.g(paramAttributeSet, "findViewById(R.id.story_msg_empty_tip_tv)");
    this.FDr = ((TextView)paramAttributeSet);
    paramContext = ViewConfiguration.get(paramContext);
    p.g(paramContext, "ViewConfiguration.get(context)");
    this.FDs = paramContext;
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120229);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryMsgListView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = this.FDw.getOnBlankClick();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120229);
      }
    });
    AppMethodBeat.o(120240);
  }
  
  private static ArrayList<com.tencent.mm.plugin.story.f.b.a> hz(List<com.tencent.mm.plugin.story.f.b.a> paramList)
  {
    AppMethodBeat.i(120233);
    ArrayList localArrayList = new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new com.tencent.mm.plugin.story.f.b.a((com.tencent.mm.plugin.story.f.b.a)paramList.next()));
    }
    AppMethodBeat.o(120233);
    return localArrayList;
  }
  
  public final void a(int paramInt, ArrayList<com.tencent.mm.plugin.story.f.b.a> paramArrayList1, ArrayList<com.tencent.mm.plugin.story.f.b.a> paramArrayList2, j paramj)
  {
    AppMethodBeat.i(120234);
    p.h(paramArrayList1, "comments");
    p.h(paramArrayList2, "bubbles");
    this.mode = paramInt;
    if (paramInt == FDt)
    {
      paramArrayList1 = new com.tencent.mm.plugin.story.ui.a.l(hz((List)paramArrayList2));
      paramj = this.FDq;
      getContext();
      paramj.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(4));
      this.FDq.setAdapter((RecyclerView.a)paramArrayList1);
      paramArrayList1 = this.FDq.getLayoutParams();
      if (paramArrayList1 == null)
      {
        paramArrayList1 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(120234);
        throw paramArrayList1;
      }
      ((ViewGroup.MarginLayoutParams)paramArrayList1).setMarginStart(at.fromDPToPix(getContext(), 40));
      paramArrayList1 = this.FDq.getLayoutParams();
      if (paramArrayList1 == null)
      {
        paramArrayList1 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(120234);
        throw paramArrayList1;
      }
      ((ViewGroup.MarginLayoutParams)paramArrayList1).setMarginEnd(at.fromDPToPix(getContext(), 40));
      paramArrayList1 = this.FDr;
      paramj = getContext();
      p.g(paramj, "context");
      paramArrayList1.setText((CharSequence)paramj.getResources().getString(2131766525));
      if (paramArrayList2.isEmpty())
      {
        this.FDr.setVisibility(0);
        this.FDq.setVisibility(8);
      }
    }
    for (;;)
    {
      this.FDq.post((Runnable)new b(this));
      AppMethodBeat.o(120234);
      return;
      this.FDr.setVisibility(8);
      this.FDq.setVisibility(0);
      continue;
      if (paramInt == FDu)
      {
        paramArrayList2 = new f(hz((List)paramArrayList1));
        paramArrayList2.FxM = paramj;
        paramArrayList2.FxY = this.Fyo;
        paramj = this.FDq;
        getContext();
        paramj.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
        this.FDq.setAdapter((RecyclerView.a)paramArrayList2);
        paramArrayList2 = this.FDr;
        paramj = getContext();
        p.g(paramj, "context");
        paramArrayList2.setText((CharSequence)paramj.getResources().getString(2131766528));
        if (paramArrayList1.isEmpty())
        {
          this.FDr.setVisibility(0);
          this.FDq.setVisibility(8);
        }
        else
        {
          this.FDr.setVisibility(8);
          this.FDq.setVisibility(0);
        }
      }
    }
  }
  
  public final void abe(int paramInt)
  {
    AppMethodBeat.i(120237);
    Object localObject = this.FDq.getLayoutParams();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120237);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = paramInt;
    requestLayout();
    AppMethodBeat.o(120237);
  }
  
  public final kotlin.g.a.a<x> getOnBlankClick()
  {
    return this.Fyp;
  }
  
  public final kotlin.g.a.b<com.tencent.mm.plugin.story.f.b.a, x> getOnCommentItemClick()
  {
    return this.Fyo;
  }
  
  public final kotlin.g.a.b<Integer, x> getOnContentTopOverScroll()
  {
    return this.Fyq;
  }
  
  public final kotlin.g.a.a<x> getOnContentTopOverScrollStop()
  {
    return this.Fyr;
  }
  
  public final void hA(final List<com.tencent.mm.plugin.story.f.b.a> paramList)
  {
    AppMethodBeat.i(120235);
    p.h(paramList, "datas");
    if (((Collection)paramList).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.FDr.setVisibility(0);
      this.FDq.setVisibility(8);
      AppMethodBeat.o(120235);
      return;
    }
    this.FDr.setVisibility(8);
    this.FDq.setVisibility(0);
    RecyclerView.a locala;
    if (this.mode == FDt)
    {
      locala = this.FDq.getAdapter();
      if (locala != null)
      {
        if (locala == null)
        {
          paramList = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.adapter.StoryVisitorListAdapter");
          AppMethodBeat.o(120235);
          throw paramList;
        }
        ((com.tencent.mm.plugin.story.ui.a.l)locala).hx((List)hz(paramList));
        this.FDq.post((Runnable)new c(this, paramList));
        AppMethodBeat.o(120235);
        return;
      }
      AppMethodBeat.o(120235);
      return;
    }
    if (this.mode == FDu)
    {
      locala = this.FDq.getAdapter();
      if (locala != null)
      {
        if (locala == null)
        {
          paramList = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.adapter.StoryCommentListAdapter");
          AppMethodBeat.o(120235);
          throw paramList;
        }
        ((f)locala).aj((List)hz(paramList));
        this.FDq.post((Runnable)new d(this, paramList));
        AppMethodBeat.o(120235);
        return;
      }
    }
    AppMethodBeat.o(120235);
  }
  
  public final void hB(List<com.tencent.mm.plugin.story.f.b.a> paramList)
  {
    AppMethodBeat.i(120236);
    p.h(paramList, "datas");
    if (this.mode == FDu)
    {
      RecyclerView.a locala = this.FDq.getAdapter();
      if (locala != null)
      {
        if (locala == null)
        {
          paramList = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.adapter.StoryCommentListAdapter");
          AppMethodBeat.o(120236);
          throw paramList;
        }
        ((f)locala).aj((List)hz(paramList));
        AppMethodBeat.o(120236);
        return;
      }
    }
    AppMethodBeat.o(120236);
  }
  
  public final void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(120239);
    paramView = this.FDq.getLayoutManager();
    int i;
    if ((paramView instanceof GridLayoutManager))
    {
      paramView = this.FDq.getLayoutManager();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
        AppMethodBeat.o(120239);
        throw paramView;
      }
      i = ((GridLayoutManager)paramView).kt();
    }
    while (paramInt2 > 0)
    {
      if (this.mba == 0) {
        break label258;
      }
      this.mba += paramInt2;
      paramView = this.Fyq;
      if (paramView != null) {
        paramView.invoke(Integer.valueOf(paramInt2));
      }
      if (paramArrayOfInt != null) {
        paramArrayOfInt[0] = paramInt1;
      }
      if (paramArrayOfInt != null)
      {
        paramArrayOfInt[1] = paramInt2;
        AppMethodBeat.o(120239);
        return;
        if ((paramView instanceof LinearLayoutManager))
        {
          paramView = this.FDq.getLayoutManager();
          if (paramView == null)
          {
            paramView = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
            AppMethodBeat.o(120239);
            throw paramView;
          }
          i = ((LinearLayoutManager)paramView).kt();
        }
        else
        {
          i = -1;
        }
      }
      else
      {
        AppMethodBeat.o(120239);
        return;
      }
    }
    if ((paramInt2 < 0) && (i == 0))
    {
      this.mba += paramInt2;
      paramView = this.Fyq;
      if (paramView != null) {
        paramView.invoke(Integer.valueOf(paramInt2));
      }
      if (paramArrayOfInt != null) {
        paramArrayOfInt[0] = paramInt1;
      }
      if (paramArrayOfInt != null)
      {
        paramArrayOfInt[1] = paramInt2;
        AppMethodBeat.o(120239);
        return;
      }
    }
    label258:
    AppMethodBeat.o(120239);
  }
  
  public final void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.mba = 0;
  }
  
  public final boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public final void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(120238);
    paramView = this.FDq.getLayoutManager();
    int i;
    if ((paramView instanceof GridLayoutManager))
    {
      paramView = this.FDq.getLayoutManager();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
        AppMethodBeat.o(120238);
        throw paramView;
      }
      i = ((GridLayoutManager)paramView).kt();
    }
    while (i == 0)
    {
      paramView = this.Fyr;
      if (paramView == null) {
        break;
      }
      paramView.invoke();
      AppMethodBeat.o(120238);
      return;
      if ((paramView instanceof LinearLayoutManager))
      {
        paramView = this.FDq.getLayoutManager();
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(120238);
          throw paramView;
        }
        i = ((LinearLayoutManager)paramView).kt();
      }
      else
      {
        i = -1;
      }
    }
    AppMethodBeat.o(120238);
  }
  
  public final void setOnBlankClick(kotlin.g.a.a<x> parama)
  {
    this.Fyp = parama;
  }
  
  public final void setOnCommentItemClick(kotlin.g.a.b<? super com.tencent.mm.plugin.story.f.b.a, x> paramb)
  {
    this.Fyo = paramb;
  }
  
  public final void setOnContentTopOverScroll(kotlin.g.a.b<? super Integer, x> paramb)
  {
    this.Fyq = paramb;
  }
  
  public final void setOnContentTopOverScrollStop(kotlin.g.a.a<x> parama)
  {
    this.Fyr = parama;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(StoryMsgListView paramStoryMsgListView) {}
    
    public final void run()
    {
      AppMethodBeat.i(120230);
      Object localObject = StoryMsgListView.a(this.FDw).getAdapter();
      if (localObject != null)
      {
        RecyclerView.LayoutManager localLayoutManager = StoryMsgListView.a(this.FDw).getLayoutManager();
        if (localLayoutManager != null)
        {
          p.g(localObject, "it");
          localObject = c.a(((RecyclerView.a)localObject).getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localLayoutManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$setup$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
          localLayoutManager.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localLayoutManager, "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$setup$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
          AppMethodBeat.o(120230);
          return;
        }
        AppMethodBeat.o(120230);
        return;
      }
      AppMethodBeat.o(120230);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$1$1"})
  static final class c
    implements Runnable
  {
    c(StoryMsgListView paramStoryMsgListView, List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(120231);
      RecyclerView.LayoutManager localLayoutManager = StoryMsgListView.a(this.FDw).getLayoutManager();
      if (localLayoutManager != null)
      {
        com.tencent.mm.hellhoundlib.b.a locala = c.a(paramList.size() - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localLayoutManager, locala.axQ(), "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$$inlined$apply$lambda$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        localLayoutManager.scrollToPosition(((Integer)locala.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localLayoutManager, "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$$inlined$apply$lambda$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(120231);
        return;
      }
      AppMethodBeat.o(120231);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$2$1"})
  static final class d
    implements Runnable
  {
    d(StoryMsgListView paramStoryMsgListView, List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(120232);
      RecyclerView.LayoutManager localLayoutManager = StoryMsgListView.a(this.FDw).getLayoutManager();
      if (localLayoutManager != null)
      {
        com.tencent.mm.hellhoundlib.b.a locala = c.a(paramList.size() - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localLayoutManager, locala.axQ(), "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$$inlined$apply$lambda$2", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        localLayoutManager.scrollToPosition(((Integer)locala.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localLayoutManager, "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$$inlined$apply$lambda$2", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(120232);
        return;
      }
      AppMethodBeat.o(120232);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryMsgListView
 * JD-Core Version:    0.7.0.1
 */
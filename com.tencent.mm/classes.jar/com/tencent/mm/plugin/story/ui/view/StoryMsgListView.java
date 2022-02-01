package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.plugin.story.ui.a.f;
import com.tencent.mm.ui.aw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/StoryMsgListView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "commentsRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "emptyTipView", "Landroid/widget/TextView;", "mode", "offsetY", "onBlankClick", "Lkotlin/Function0;", "", "getOnBlankClick", "()Lkotlin/jvm/functions/Function0;", "setOnBlankClick", "(Lkotlin/jvm/functions/Function0;)V", "onCommentItemClick", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/ParameterName;", "name", "commentItem", "getOnCommentItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnCommentItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onContentTopOverScroll", "dy", "getOnContentTopOverScroll", "setOnContentTopOverScroll", "onContentTopOverScrollStop", "getOnContentTopOverScrollStop", "setOnContentTopOverScrollStop", "viewConfig", "Landroid/view/ViewConfiguration;", "adjustContentLayout", "bottomMargin", "copyDataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "oriDataList", "", "onNestedPreScroll", "target", "Landroid/view/View;", "dx", "consumed", "", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "", "nestedScrollAxes", "onStopNestedScroll", "setup", "comments", "bubbles", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "updateCommentListId", "datas", "updateMsgList", "Companion", "plugin-story_release"})
public final class StoryMsgListView
  extends RelativeLayout
{
  private static final int LXw = 0;
  private static final int LXx = 1;
  public static final a LXy;
  private kotlin.g.a.b<? super com.tencent.mm.plugin.story.f.b.a, x> LSq;
  private kotlin.g.a.a<x> LSr;
  private kotlin.g.a.b<? super Integer, x> LSs;
  private kotlin.g.a.a<x> LSt;
  private final RecyclerView LXt;
  private final TextView LXu;
  private ViewConfiguration LXv;
  private int mode;
  private int oYR;
  
  static
  {
    AppMethodBeat.i(120243);
    LXy = new a((byte)0);
    LXx = 1;
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
    View.inflate(paramContext, a.e.LDg, (ViewGroup)this);
    paramAttributeSet = findViewById(a.d.LCh);
    p.j(paramAttributeSet, "findViewById(R.id.story_msg_recycler_view)");
    this.LXt = ((RecyclerView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LCe);
    p.j(paramAttributeSet, "findViewById(R.id.story_msg_empty_tip_tv)");
    this.LXu = ((TextView)paramAttributeSet);
    paramContext = ViewConfiguration.get(paramContext);
    p.j(paramContext, "ViewConfiguration.get(context)");
    this.LXv = paramContext;
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120229);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/StoryMsgListView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.LXz.getOnBlankClick();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120229);
      }
    });
    AppMethodBeat.o(120240);
  }
  
  private static ArrayList<com.tencent.mm.plugin.story.f.b.a> ih(List<com.tencent.mm.plugin.story.f.b.a> paramList)
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
    p.k(paramArrayList1, "comments");
    p.k(paramArrayList2, "bubbles");
    this.mode = paramInt;
    if (paramInt == LXw)
    {
      paramArrayList1 = new com.tencent.mm.plugin.story.ui.a.l(ih((List)paramArrayList2));
      paramj = this.LXt;
      getContext();
      paramj.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(4));
      this.LXt.setAdapter((RecyclerView.a)paramArrayList1);
      paramArrayList1 = this.LXt.getLayoutParams();
      if (paramArrayList1 == null)
      {
        paramArrayList1 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(120234);
        throw paramArrayList1;
      }
      ((ViewGroup.MarginLayoutParams)paramArrayList1).setMarginStart(aw.fromDPToPix(getContext(), 40));
      paramArrayList1 = this.LXt.getLayoutParams();
      if (paramArrayList1 == null)
      {
        paramArrayList1 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(120234);
        throw paramArrayList1;
      }
      ((ViewGroup.MarginLayoutParams)paramArrayList1).setMarginEnd(aw.fromDPToPix(getContext(), 40));
      paramArrayList1 = this.LXu;
      paramj = getContext();
      p.j(paramj, "context");
      paramArrayList1.setText((CharSequence)paramj.getResources().getString(a.g.LDZ));
      if (paramArrayList2.isEmpty())
      {
        this.LXu.setVisibility(0);
        this.LXt.setVisibility(8);
      }
    }
    for (;;)
    {
      this.LXt.post((Runnable)new b(this));
      AppMethodBeat.o(120234);
      return;
      this.LXu.setVisibility(8);
      this.LXt.setVisibility(0);
      continue;
      if (paramInt == LXx)
      {
        paramArrayList2 = new f(ih((List)paramArrayList1));
        paramArrayList2.LRO = paramj;
        paramArrayList2.LSa = this.LSq;
        paramj = this.LXt;
        getContext();
        paramj.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
        this.LXt.setAdapter((RecyclerView.a)paramArrayList2);
        paramArrayList2 = this.LXu;
        paramj = getContext();
        p.j(paramj, "context");
        paramArrayList2.setText((CharSequence)paramj.getResources().getString(a.g.LEc));
        if (paramArrayList1.isEmpty())
        {
          this.LXu.setVisibility(0);
          this.LXt.setVisibility(8);
        }
        else
        {
          this.LXu.setVisibility(8);
          this.LXt.setVisibility(0);
        }
      }
    }
  }
  
  public final void aiz(int paramInt)
  {
    AppMethodBeat.i(120237);
    Object localObject = this.LXt.getLayoutParams();
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
    return this.LSr;
  }
  
  public final kotlin.g.a.b<com.tencent.mm.plugin.story.f.b.a, x> getOnCommentItemClick()
  {
    return this.LSq;
  }
  
  public final kotlin.g.a.b<Integer, x> getOnContentTopOverScroll()
  {
    return this.LSs;
  }
  
  public final kotlin.g.a.a<x> getOnContentTopOverScrollStop()
  {
    return this.LSt;
  }
  
  public final void ii(final List<com.tencent.mm.plugin.story.f.b.a> paramList)
  {
    AppMethodBeat.i(120235);
    p.k(paramList, "datas");
    if (((Collection)paramList).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.LXu.setVisibility(0);
      this.LXt.setVisibility(8);
      AppMethodBeat.o(120235);
      return;
    }
    this.LXu.setVisibility(8);
    this.LXt.setVisibility(0);
    RecyclerView.a locala;
    if (this.mode == LXw)
    {
      locala = this.LXt.getAdapter();
      if (locala != null)
      {
        if (locala == null)
        {
          paramList = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.adapter.StoryVisitorListAdapter");
          AppMethodBeat.o(120235);
          throw paramList;
        }
        ((com.tencent.mm.plugin.story.ui.a.l)locala).jdMethod_if((List)ih(paramList));
        this.LXt.post((Runnable)new c(this, paramList));
        AppMethodBeat.o(120235);
        return;
      }
      AppMethodBeat.o(120235);
      return;
    }
    if (this.mode == LXx)
    {
      locala = this.LXt.getAdapter();
      if (locala != null)
      {
        if (locala == null)
        {
          paramList = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.adapter.StoryCommentListAdapter");
          AppMethodBeat.o(120235);
          throw paramList;
        }
        ((f)locala).ah((List)ih(paramList));
        this.LXt.post((Runnable)new d(this, paramList));
        AppMethodBeat.o(120235);
        return;
      }
    }
    AppMethodBeat.o(120235);
  }
  
  public final void ij(List<com.tencent.mm.plugin.story.f.b.a> paramList)
  {
    AppMethodBeat.i(120236);
    p.k(paramList, "datas");
    if (this.mode == LXx)
    {
      RecyclerView.a locala = this.LXt.getAdapter();
      if (locala != null)
      {
        if (locala == null)
        {
          paramList = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.adapter.StoryCommentListAdapter");
          AppMethodBeat.o(120236);
          throw paramList;
        }
        ((f)locala).ah((List)ih(paramList));
        AppMethodBeat.o(120236);
        return;
      }
    }
    AppMethodBeat.o(120236);
  }
  
  public final void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(120239);
    paramView = this.LXt.getLayoutManager();
    int i;
    if ((paramView instanceof GridLayoutManager))
    {
      paramView = this.LXt.getLayoutManager();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        AppMethodBeat.o(120239);
        throw paramView;
      }
      i = ((GridLayoutManager)paramView).kK();
    }
    while (paramInt2 > 0)
    {
      if (this.oYR == 0) {
        break label258;
      }
      this.oYR += paramInt2;
      paramView = this.LSs;
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
          paramView = this.LXt.getLayoutManager();
          if (paramView == null)
          {
            paramView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            AppMethodBeat.o(120239);
            throw paramView;
          }
          i = ((LinearLayoutManager)paramView).kK();
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
      this.oYR += paramInt2;
      paramView = this.LSs;
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
    this.oYR = 0;
  }
  
  public final boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public final void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(120238);
    paramView = this.LXt.getLayoutManager();
    int i;
    if ((paramView instanceof GridLayoutManager))
    {
      paramView = this.LXt.getLayoutManager();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        AppMethodBeat.o(120238);
        throw paramView;
      }
      i = ((GridLayoutManager)paramView).kK();
    }
    while (i == 0)
    {
      paramView = this.LSt;
      if (paramView == null) {
        break;
      }
      paramView.invoke();
      AppMethodBeat.o(120238);
      return;
      if ((paramView instanceof LinearLayoutManager))
      {
        paramView = this.LXt.getLayoutManager();
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(120238);
          throw paramView;
        }
        i = ((LinearLayoutManager)paramView).kK();
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
    this.LSr = parama;
  }
  
  public final void setOnCommentItemClick(kotlin.g.a.b<? super com.tencent.mm.plugin.story.f.b.a, x> paramb)
  {
    this.LSq = paramb;
  }
  
  public final void setOnContentTopOverScroll(kotlin.g.a.b<? super Integer, x> paramb)
  {
    this.LSs = paramb;
  }
  
  public final void setOnContentTopOverScrollStop(kotlin.g.a.a<x> parama)
  {
    this.LSt = parama;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/StoryMsgListView$Companion;", "", "()V", "VIEW_MODE_BUBBLE", "", "getVIEW_MODE_BUBBLE", "()I", "VIEW_MODE_COMMENT", "getVIEW_MODE_COMMENT", "plugin-story_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(StoryMsgListView paramStoryMsgListView) {}
    
    public final void run()
    {
      AppMethodBeat.i(120230);
      Object localObject = StoryMsgListView.a(this.LXz).getAdapter();
      if (localObject != null)
      {
        RecyclerView.LayoutManager localLayoutManager = StoryMsgListView.a(this.LXz).getLayoutManager();
        if (localLayoutManager != null)
        {
          p.j(localObject, "it");
          localObject = c.a(((RecyclerView.a)localObject).getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(localLayoutManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$setup$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
          localLayoutManager.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localLayoutManager, "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$setup$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
          AppMethodBeat.o(120230);
          return;
        }
        AppMethodBeat.o(120230);
        return;
      }
      AppMethodBeat.o(120230);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$1$1"})
  static final class c
    implements Runnable
  {
    c(StoryMsgListView paramStoryMsgListView, List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(120231);
      RecyclerView.LayoutManager localLayoutManager = StoryMsgListView.a(this.LXz).getLayoutManager();
      if (localLayoutManager != null)
      {
        com.tencent.mm.hellhoundlib.b.a locala = c.a(paramList.size() - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localLayoutManager, locala.aFh(), "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$$inlined$apply$lambda$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        localLayoutManager.scrollToPosition(((Integer)locala.sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localLayoutManager, "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$$inlined$apply$lambda$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(120231);
        return;
      }
      AppMethodBeat.o(120231);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$2$1"})
  static final class d
    implements Runnable
  {
    d(StoryMsgListView paramStoryMsgListView, List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(120232);
      RecyclerView.LayoutManager localLayoutManager = StoryMsgListView.a(this.LXz).getLayoutManager();
      if (localLayoutManager != null)
      {
        com.tencent.mm.hellhoundlib.b.a locala = c.a(paramList.size() - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localLayoutManager, locala.aFh(), "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$$inlined$apply$lambda$2", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        localLayoutManager.scrollToPosition(((Integer)locala.sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localLayoutManager, "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$$inlined$apply$lambda$2", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(120232);
        return;
      }
      AppMethodBeat.o(120232);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryMsgListView
 * JD-Core Version:    0.7.0.1
 */
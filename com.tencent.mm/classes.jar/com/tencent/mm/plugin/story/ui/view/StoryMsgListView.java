package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
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
import com.tencent.mm.ui.aq;
import d.g.b.p;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/StoryMsgListView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "commentsRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "emptyTipView", "Landroid/widget/TextView;", "mode", "offsetY", "onBlankClick", "Lkotlin/Function0;", "", "getOnBlankClick", "()Lkotlin/jvm/functions/Function0;", "setOnBlankClick", "(Lkotlin/jvm/functions/Function0;)V", "onCommentItemClick", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/ParameterName;", "name", "commentItem", "getOnCommentItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnCommentItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onContentTopOverScroll", "dy", "getOnContentTopOverScroll", "setOnContentTopOverScroll", "onContentTopOverScrollStop", "getOnContentTopOverScrollStop", "setOnContentTopOverScrollStop", "viewConfig", "Landroid/view/ViewConfiguration;", "adjustContentLayout", "bottomMargin", "copyDataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "oriDataList", "", "onNestedPreScroll", "target", "Landroid/view/View;", "dx", "consumed", "", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "", "nestedScrollAxes", "onStopNestedScroll", "setup", "comments", "bubbles", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "updateCommentListId", "datas", "updateMsgList", "Companion", "plugin-story_release"})
public final class StoryMsgListView
  extends RelativeLayout
{
  private static final int Bbi = 0;
  private static final int Bbj = 1;
  public static final StoryMsgListView.a Bbk;
  private d.g.a.b<? super com.tencent.mm.plugin.story.f.b.a, z> AWa;
  private d.g.a.a<z> AWb;
  private d.g.a.b<? super Integer, z> AWc;
  private d.g.a.a<z> AWd;
  private final RecyclerView Bbf;
  private final TextView Bbg;
  private ViewConfiguration Bbh;
  private int kSi;
  private int mode;
  
  static
  {
    AppMethodBeat.i(120243);
    Bbk = new StoryMsgListView.a((byte)0);
    Bbj = 1;
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
    View.inflate(paramContext, 2131495709, (ViewGroup)this);
    paramAttributeSet = findViewById(2131305477);
    p.g(paramAttributeSet, "findViewById(R.id.story_msg_recycler_view)");
    this.Bbf = ((RecyclerView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305474);
    p.g(paramAttributeSet, "findViewById(R.id.story_msg_empty_tip_tv)");
    this.Bbg = ((TextView)paramAttributeSet);
    paramContext = ViewConfiguration.get(paramContext);
    p.g(paramContext, "ViewConfiguration.get(context)");
    this.Bbh = paramContext;
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120229);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryMsgListView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = this.Bbl.getOnBlankClick();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120229);
      }
    });
    AppMethodBeat.o(120240);
  }
  
  private static ArrayList<com.tencent.mm.plugin.story.f.b.a> gt(List<com.tencent.mm.plugin.story.f.b.a> paramList)
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
  
  public final void SB(int paramInt)
  {
    AppMethodBeat.i(120237);
    Object localObject = this.Bbf.getLayoutParams();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120237);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = paramInt;
    requestLayout();
    AppMethodBeat.o(120237);
  }
  
  public final void a(int paramInt, ArrayList<com.tencent.mm.plugin.story.f.b.a> paramArrayList1, ArrayList<com.tencent.mm.plugin.story.f.b.a> paramArrayList2, j paramj)
  {
    AppMethodBeat.i(120234);
    p.h(paramArrayList1, "comments");
    p.h(paramArrayList2, "bubbles");
    this.mode = paramInt;
    if (paramInt == Bbi)
    {
      paramArrayList1 = new com.tencent.mm.plugin.story.ui.a.l(gt((List)paramArrayList2));
      paramj = this.Bbf;
      getContext();
      paramj.setLayoutManager((RecyclerView.i)new GridLayoutManager(4));
      this.Bbf.setAdapter((RecyclerView.a)paramArrayList1);
      paramArrayList1 = this.Bbf.getLayoutParams();
      if (paramArrayList1 == null)
      {
        paramArrayList1 = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(120234);
        throw paramArrayList1;
      }
      ((ViewGroup.MarginLayoutParams)paramArrayList1).setMarginStart(aq.fromDPToPix(getContext(), 40));
      paramArrayList1 = this.Bbf.getLayoutParams();
      if (paramArrayList1 == null)
      {
        paramArrayList1 = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(120234);
        throw paramArrayList1;
      }
      ((ViewGroup.MarginLayoutParams)paramArrayList1).setMarginEnd(aq.fromDPToPix(getContext(), 40));
      paramArrayList1 = this.Bbg;
      paramj = getContext();
      p.g(paramj, "context");
      paramArrayList1.setText((CharSequence)paramj.getResources().getString(2131764267));
      if (paramArrayList2.isEmpty())
      {
        this.Bbg.setVisibility(0);
        this.Bbf.setVisibility(8);
      }
    }
    for (;;)
    {
      this.Bbf.post((Runnable)new b(this));
      AppMethodBeat.o(120234);
      return;
      this.Bbg.setVisibility(8);
      this.Bbf.setVisibility(0);
      continue;
      if (paramInt == Bbj)
      {
        paramArrayList2 = new f(gt((List)paramArrayList1));
        paramArrayList2.AVy = paramj;
        paramArrayList2.AVK = this.AWa;
        paramj = this.Bbf;
        getContext();
        paramj.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
        this.Bbf.setAdapter((RecyclerView.a)paramArrayList2);
        paramArrayList2 = this.Bbg;
        paramj = getContext();
        p.g(paramj, "context");
        paramArrayList2.setText((CharSequence)paramj.getResources().getString(2131764270));
        if (paramArrayList1.isEmpty())
        {
          this.Bbg.setVisibility(0);
          this.Bbf.setVisibility(8);
        }
        else
        {
          this.Bbg.setVisibility(8);
          this.Bbf.setVisibility(0);
        }
      }
    }
  }
  
  public final d.g.a.a<z> getOnBlankClick()
  {
    return this.AWb;
  }
  
  public final d.g.a.b<com.tencent.mm.plugin.story.f.b.a, z> getOnCommentItemClick()
  {
    return this.AWa;
  }
  
  public final d.g.a.b<Integer, z> getOnContentTopOverScroll()
  {
    return this.AWc;
  }
  
  public final d.g.a.a<z> getOnContentTopOverScrollStop()
  {
    return this.AWd;
  }
  
  public final void gu(final List<com.tencent.mm.plugin.story.f.b.a> paramList)
  {
    AppMethodBeat.i(120235);
    p.h(paramList, "datas");
    if (((Collection)paramList).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.Bbg.setVisibility(0);
      this.Bbf.setVisibility(8);
      AppMethodBeat.o(120235);
      return;
    }
    this.Bbg.setVisibility(8);
    this.Bbf.setVisibility(0);
    RecyclerView.a locala;
    if (this.mode == Bbi)
    {
      locala = this.Bbf.getAdapter();
      if (locala != null)
      {
        if (locala == null)
        {
          paramList = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.adapter.StoryVisitorListAdapter");
          AppMethodBeat.o(120235);
          throw paramList;
        }
        ((com.tencent.mm.plugin.story.ui.a.l)locala).gr((List)gt(paramList));
        this.Bbf.post((Runnable)new c(this, paramList));
        AppMethodBeat.o(120235);
        return;
      }
      AppMethodBeat.o(120235);
      return;
    }
    if (this.mode == Bbj)
    {
      locala = this.Bbf.getAdapter();
      if (locala != null)
      {
        if (locala == null)
        {
          paramList = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.adapter.StoryCommentListAdapter");
          AppMethodBeat.o(120235);
          throw paramList;
        }
        ((f)locala).ab((List)gt(paramList));
        this.Bbf.post((Runnable)new d(this, paramList));
        AppMethodBeat.o(120235);
        return;
      }
    }
    AppMethodBeat.o(120235);
  }
  
  public final void gv(List<com.tencent.mm.plugin.story.f.b.a> paramList)
  {
    AppMethodBeat.i(120236);
    p.h(paramList, "datas");
    if (this.mode == Bbj)
    {
      RecyclerView.a locala = this.Bbf.getAdapter();
      if (locala != null)
      {
        if (locala == null)
        {
          paramList = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.adapter.StoryCommentListAdapter");
          AppMethodBeat.o(120236);
          throw paramList;
        }
        ((f)locala).ab((List)gt(paramList));
        AppMethodBeat.o(120236);
        return;
      }
    }
    AppMethodBeat.o(120236);
  }
  
  public final void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(120239);
    paramView = this.Bbf.getLayoutManager();
    int i;
    if ((paramView instanceof GridLayoutManager))
    {
      paramView = this.Bbf.getLayoutManager();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
        AppMethodBeat.o(120239);
        throw paramView;
      }
      i = ((GridLayoutManager)paramView).kn();
    }
    while (paramInt2 > 0)
    {
      if (this.kSi == 0) {
        break label258;
      }
      this.kSi += paramInt2;
      paramView = this.AWc;
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
          paramView = this.Bbf.getLayoutManager();
          if (paramView == null)
          {
            paramView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
            AppMethodBeat.o(120239);
            throw paramView;
          }
          i = ((LinearLayoutManager)paramView).kn();
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
      this.kSi += paramInt2;
      paramView = this.AWc;
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
    this.kSi = 0;
  }
  
  public final boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public final void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(120238);
    paramView = this.Bbf.getLayoutManager();
    int i;
    if ((paramView instanceof GridLayoutManager))
    {
      paramView = this.Bbf.getLayoutManager();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
        AppMethodBeat.o(120238);
        throw paramView;
      }
      i = ((GridLayoutManager)paramView).kn();
    }
    while (i == 0)
    {
      paramView = this.AWd;
      if (paramView == null) {
        break;
      }
      paramView.invoke();
      AppMethodBeat.o(120238);
      return;
      if ((paramView instanceof LinearLayoutManager))
      {
        paramView = this.Bbf.getLayoutManager();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(120238);
          throw paramView;
        }
        i = ((LinearLayoutManager)paramView).kn();
      }
      else
      {
        i = -1;
      }
    }
    AppMethodBeat.o(120238);
  }
  
  public final void setOnBlankClick(d.g.a.a<z> parama)
  {
    this.AWb = parama;
  }
  
  public final void setOnCommentItemClick(d.g.a.b<? super com.tencent.mm.plugin.story.f.b.a, z> paramb)
  {
    this.AWa = paramb;
  }
  
  public final void setOnContentTopOverScroll(d.g.a.b<? super Integer, z> paramb)
  {
    this.AWc = paramb;
  }
  
  public final void setOnContentTopOverScrollStop(d.g.a.a<z> parama)
  {
    this.AWd = parama;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(StoryMsgListView paramStoryMsgListView) {}
    
    public final void run()
    {
      AppMethodBeat.i(120230);
      Object localObject = StoryMsgListView.a(this.Bbl).getAdapter();
      if (localObject != null)
      {
        RecyclerView.i locali = StoryMsgListView.a(this.Bbl).getLayoutManager();
        if (locali != null)
        {
          p.g(localObject, "it");
          localObject = c.a(((RecyclerView.a)localObject).getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(locali, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$setup$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
          locali.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(locali, "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$setup$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
          AppMethodBeat.o(120230);
          return;
        }
        AppMethodBeat.o(120230);
        return;
      }
      AppMethodBeat.o(120230);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$1$1"})
  static final class c
    implements Runnable
  {
    c(StoryMsgListView paramStoryMsgListView, List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(120231);
      RecyclerView.i locali = StoryMsgListView.a(this.Bbl).getLayoutManager();
      if (locali != null)
      {
        com.tencent.mm.hellhoundlib.b.a locala = c.a(paramList.size() - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(locali, locala.ahp(), "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$$inlined$apply$lambda$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        locali.ca(((Integer)locala.mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(locali, "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$$inlined$apply$lambda$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(120231);
        return;
      }
      AppMethodBeat.o(120231);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$2$1"})
  static final class d
    implements Runnable
  {
    d(StoryMsgListView paramStoryMsgListView, List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(120232);
      RecyclerView.i locali = StoryMsgListView.a(this.Bbl).getLayoutManager();
      if (locali != null)
      {
        com.tencent.mm.hellhoundlib.b.a locala = c.a(paramList.size() - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(locali, locala.ahp(), "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$$inlined$apply$lambda$2", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        locali.ca(((Integer)locala.mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(locali, "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$$inlined$apply$lambda$2", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
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
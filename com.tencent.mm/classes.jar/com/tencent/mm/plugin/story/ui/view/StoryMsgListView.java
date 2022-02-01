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
import d.g.a.b;
import d.g.b.p;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/StoryMsgListView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "commentsRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "emptyTipView", "Landroid/widget/TextView;", "mode", "offsetY", "onBlankClick", "Lkotlin/Function0;", "", "getOnBlankClick", "()Lkotlin/jvm/functions/Function0;", "setOnBlankClick", "(Lkotlin/jvm/functions/Function0;)V", "onCommentItemClick", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/ParameterName;", "name", "commentItem", "getOnCommentItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnCommentItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onContentTopOverScroll", "dy", "getOnContentTopOverScroll", "setOnContentTopOverScroll", "onContentTopOverScrollStop", "getOnContentTopOverScrollStop", "setOnContentTopOverScrollStop", "viewConfig", "Landroid/view/ViewConfiguration;", "adjustContentLayout", "bottomMargin", "copyDataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "oriDataList", "", "onNestedPreScroll", "target", "Landroid/view/View;", "dx", "consumed", "", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "", "nestedScrollAxes", "onStopNestedScroll", "setup", "comments", "bubbles", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "updateCommentListId", "datas", "updateMsgList", "Companion", "plugin-story_release"})
public final class StoryMsgListView
  extends RelativeLayout
{
  private static final int BsG = 0;
  private static final int BsH = 1;
  public static final StoryMsgListView.a BsI;
  private b<? super Integer, z> BnA;
  private d.g.a.a<z> BnB;
  private b<? super com.tencent.mm.plugin.story.f.b.a, z> Bny;
  private d.g.a.a<z> Bnz;
  private final RecyclerView BsD;
  private final TextView BsE;
  private ViewConfiguration BsF;
  private int kVR;
  private int mode;
  
  static
  {
    AppMethodBeat.i(120243);
    BsI = new StoryMsgListView.a((byte)0);
    BsH = 1;
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
    this.BsD = ((RecyclerView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305474);
    p.g(paramAttributeSet, "findViewById(R.id.story_msg_empty_tip_tv)");
    this.BsE = ((TextView)paramAttributeSet);
    paramContext = ViewConfiguration.get(paramContext);
    p.g(paramContext, "ViewConfiguration.get(context)");
    this.BsF = paramContext;
    setOnClickListener((View.OnClickListener)new StoryMsgListView.1(this));
    AppMethodBeat.o(120240);
  }
  
  private static ArrayList<com.tencent.mm.plugin.story.f.b.a> gC(List<com.tencent.mm.plugin.story.f.b.a> paramList)
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
  
  public final void Ti(int paramInt)
  {
    AppMethodBeat.i(120237);
    Object localObject = this.BsD.getLayoutParams();
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
    if (paramInt == BsG)
    {
      paramArrayList1 = new com.tencent.mm.plugin.story.ui.a.l(gC((List)paramArrayList2));
      paramj = this.BsD;
      getContext();
      paramj.setLayoutManager((RecyclerView.i)new GridLayoutManager(4));
      this.BsD.setAdapter((RecyclerView.a)paramArrayList1);
      paramArrayList1 = this.BsD.getLayoutParams();
      if (paramArrayList1 == null)
      {
        paramArrayList1 = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(120234);
        throw paramArrayList1;
      }
      ((ViewGroup.MarginLayoutParams)paramArrayList1).setMarginStart(aq.fromDPToPix(getContext(), 40));
      paramArrayList1 = this.BsD.getLayoutParams();
      if (paramArrayList1 == null)
      {
        paramArrayList1 = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(120234);
        throw paramArrayList1;
      }
      ((ViewGroup.MarginLayoutParams)paramArrayList1).setMarginEnd(aq.fromDPToPix(getContext(), 40));
      paramArrayList1 = this.BsE;
      paramj = getContext();
      p.g(paramj, "context");
      paramArrayList1.setText((CharSequence)paramj.getResources().getString(2131764267));
      if (paramArrayList2.isEmpty())
      {
        this.BsE.setVisibility(0);
        this.BsD.setVisibility(8);
      }
    }
    for (;;)
    {
      this.BsD.post((Runnable)new b(this));
      AppMethodBeat.o(120234);
      return;
      this.BsE.setVisibility(8);
      this.BsD.setVisibility(0);
      continue;
      if (paramInt == BsH)
      {
        paramArrayList2 = new f(gC((List)paramArrayList1));
        paramArrayList2.BmW = paramj;
        paramArrayList2.Bni = this.Bny;
        paramj = this.BsD;
        getContext();
        paramj.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
        this.BsD.setAdapter((RecyclerView.a)paramArrayList2);
        paramArrayList2 = this.BsE;
        paramj = getContext();
        p.g(paramj, "context");
        paramArrayList2.setText((CharSequence)paramj.getResources().getString(2131764270));
        if (paramArrayList1.isEmpty())
        {
          this.BsE.setVisibility(0);
          this.BsD.setVisibility(8);
        }
        else
        {
          this.BsE.setVisibility(8);
          this.BsD.setVisibility(0);
        }
      }
    }
  }
  
  public final void gD(final List<com.tencent.mm.plugin.story.f.b.a> paramList)
  {
    AppMethodBeat.i(120235);
    p.h(paramList, "datas");
    if (((Collection)paramList).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.BsE.setVisibility(0);
      this.BsD.setVisibility(8);
      AppMethodBeat.o(120235);
      return;
    }
    this.BsE.setVisibility(8);
    this.BsD.setVisibility(0);
    RecyclerView.a locala;
    if (this.mode == BsG)
    {
      locala = this.BsD.getAdapter();
      if (locala != null)
      {
        if (locala == null)
        {
          paramList = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.adapter.StoryVisitorListAdapter");
          AppMethodBeat.o(120235);
          throw paramList;
        }
        ((com.tencent.mm.plugin.story.ui.a.l)locala).gA((List)gC(paramList));
        this.BsD.post((Runnable)new c(this, paramList));
        AppMethodBeat.o(120235);
        return;
      }
      AppMethodBeat.o(120235);
      return;
    }
    if (this.mode == BsH)
    {
      locala = this.BsD.getAdapter();
      if (locala != null)
      {
        if (locala == null)
        {
          paramList = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.adapter.StoryCommentListAdapter");
          AppMethodBeat.o(120235);
          throw paramList;
        }
        ((f)locala).ab((List)gC(paramList));
        this.BsD.post((Runnable)new d(this, paramList));
        AppMethodBeat.o(120235);
        return;
      }
    }
    AppMethodBeat.o(120235);
  }
  
  public final void gE(List<com.tencent.mm.plugin.story.f.b.a> paramList)
  {
    AppMethodBeat.i(120236);
    p.h(paramList, "datas");
    if (this.mode == BsH)
    {
      RecyclerView.a locala = this.BsD.getAdapter();
      if (locala != null)
      {
        if (locala == null)
        {
          paramList = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.adapter.StoryCommentListAdapter");
          AppMethodBeat.o(120236);
          throw paramList;
        }
        ((f)locala).ab((List)gC(paramList));
        AppMethodBeat.o(120236);
        return;
      }
    }
    AppMethodBeat.o(120236);
  }
  
  public final d.g.a.a<z> getOnBlankClick()
  {
    return this.Bnz;
  }
  
  public final b<com.tencent.mm.plugin.story.f.b.a, z> getOnCommentItemClick()
  {
    return this.Bny;
  }
  
  public final b<Integer, z> getOnContentTopOverScroll()
  {
    return this.BnA;
  }
  
  public final d.g.a.a<z> getOnContentTopOverScrollStop()
  {
    return this.BnB;
  }
  
  public final void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(120239);
    paramView = this.BsD.getLayoutManager();
    int i;
    if ((paramView instanceof GridLayoutManager))
    {
      paramView = this.BsD.getLayoutManager();
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
      if (this.kVR == 0) {
        break label258;
      }
      this.kVR += paramInt2;
      paramView = this.BnA;
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
          paramView = this.BsD.getLayoutManager();
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
      this.kVR += paramInt2;
      paramView = this.BnA;
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
    this.kVR = 0;
  }
  
  public final boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public final void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(120238);
    paramView = this.BsD.getLayoutManager();
    int i;
    if ((paramView instanceof GridLayoutManager))
    {
      paramView = this.BsD.getLayoutManager();
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
      paramView = this.BnB;
      if (paramView == null) {
        break;
      }
      paramView.invoke();
      AppMethodBeat.o(120238);
      return;
      if ((paramView instanceof LinearLayoutManager))
      {
        paramView = this.BsD.getLayoutManager();
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
    this.Bnz = parama;
  }
  
  public final void setOnCommentItemClick(b<? super com.tencent.mm.plugin.story.f.b.a, z> paramb)
  {
    this.Bny = paramb;
  }
  
  public final void setOnContentTopOverScroll(b<? super Integer, z> paramb)
  {
    this.BnA = paramb;
  }
  
  public final void setOnContentTopOverScrollStop(d.g.a.a<z> parama)
  {
    this.BnB = parama;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(StoryMsgListView paramStoryMsgListView) {}
    
    public final void run()
    {
      AppMethodBeat.i(120230);
      Object localObject = StoryMsgListView.a(this.BsJ).getAdapter();
      if (localObject != null)
      {
        RecyclerView.i locali = StoryMsgListView.a(this.BsJ).getLayoutManager();
        if (locali != null)
        {
          p.g(localObject, "it");
          localObject = c.a(((RecyclerView.a)localObject).getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(locali, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$setup$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
          locali.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0)).intValue());
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$1$1"})
  static final class c
    implements Runnable
  {
    c(StoryMsgListView paramStoryMsgListView, List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(120231);
      RecyclerView.i locali = StoryMsgListView.a(this.BsJ).getLayoutManager();
      if (locali != null)
      {
        com.tencent.mm.hellhoundlib.b.a locala = c.a(paramList.size() - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(locali, locala.ahE(), "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$$inlined$apply$lambda$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        locali.ca(((Integer)locala.mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(locali, "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$$inlined$apply$lambda$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(120231);
        return;
      }
      AppMethodBeat.o(120231);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$2$1"})
  static final class d
    implements Runnable
  {
    d(StoryMsgListView paramStoryMsgListView, List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(120232);
      RecyclerView.i locali = StoryMsgListView.a(this.BsJ).getLayoutManager();
      if (locali != null)
      {
        com.tencent.mm.hellhoundlib.b.a locala = c.a(paramList.size() - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(locali, locala.ahE(), "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$$inlined$apply$lambda$2", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        locali.ca(((Integer)locala.mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(locali, "com/tencent/mm/plugin/story/ui/view/StoryMsgListView$updateMsgList$$inlined$apply$lambda$2", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(120232);
        return;
      }
      AppMethodBeat.o(120232);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryMsgListView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
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
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.g.a;
import androidx.recyclerview.widget.g.b;
import androidx.recyclerview.widget.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.ui.a.l;
import com.tencent.mm.plugin.story.ui.a.l.b;
import com.tencent.mm.plugin.story.ui.a.l.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/StoryMsgListView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "commentsRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "emptyTipView", "Landroid/widget/TextView;", "mode", "offsetY", "onBlankClick", "Lkotlin/Function0;", "", "getOnBlankClick", "()Lkotlin/jvm/functions/Function0;", "setOnBlankClick", "(Lkotlin/jvm/functions/Function0;)V", "onCommentItemClick", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/ParameterName;", "name", "commentItem", "getOnCommentItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnCommentItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onContentTopOverScroll", "dy", "getOnContentTopOverScroll", "setOnContentTopOverScroll", "onContentTopOverScrollStop", "getOnContentTopOverScrollStop", "setOnContentTopOverScrollStop", "viewConfig", "Landroid/view/ViewConfiguration;", "adjustContentLayout", "bottomMargin", "copyDataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "oriDataList", "", "onNestedPreScroll", "target", "Landroid/view/View;", "dx", "consumed", "", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "", "nestedScrollAxes", "onStopNestedScroll", "setup", "comments", "bubbles", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "updateCommentListId", "datas", "updateMsgList", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryMsgListView
  extends RelativeLayout
{
  public static final StoryMsgListView.a Szc;
  private static final int Szg = 0;
  private static final int Szh;
  private kotlin.g.a.b<? super com.tencent.mm.plugin.story.model.b.a, ah> SuH;
  private kotlin.g.a.a<ah> SuI;
  private kotlin.g.a.b<? super Integer, ah> SuJ;
  private kotlin.g.a.a<ah> SuK;
  private final RecyclerView Szd;
  private final TextView Sze;
  private ViewConfiguration Szf;
  private int mode;
  private int ser;
  
  static
  {
    AppMethodBeat.i(120243);
    Szc = new StoryMsgListView.a((byte)0);
    Szh = 1;
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
    View.inflate(paramContext, a.e.SgR, (ViewGroup)this);
    paramAttributeSet = findViewById(a.d.SfS);
    s.s(paramAttributeSet, "findViewById(R.id.story_msg_recycler_view)");
    this.Szd = ((RecyclerView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.SfP);
    s.s(paramAttributeSet, "findViewById(R.id.story_msg_empty_tip_tv)");
    this.Sze = ((TextView)paramAttributeSet);
    paramContext = ViewConfiguration.get(paramContext);
    s.s(paramContext, "get(context)");
    this.Szf = paramContext;
    setOnClickListener(new StoryMsgListView..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(120240);
  }
  
  private static final void a(StoryMsgListView paramStoryMsgListView, View paramView)
  {
    AppMethodBeat.i(367458);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramStoryMsgListView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/StoryMsgListView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramStoryMsgListView, "this$0");
    paramStoryMsgListView = paramStoryMsgListView.getOnBlankClick();
    if (paramStoryMsgListView != null) {
      paramStoryMsgListView.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/StoryMsgListView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367458);
  }
  
  private static final void a(StoryMsgListView paramStoryMsgListView, List paramList)
  {
    AppMethodBeat.i(367466);
    s.u(paramStoryMsgListView, "this$0");
    s.u(paramList, "$datas");
    paramStoryMsgListView = paramStoryMsgListView.Szd.getLayoutManager();
    if (paramStoryMsgListView != null)
    {
      paramList = c.a(paramList.size() - 1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramStoryMsgListView, paramList.aYi(), "com/tencent/mm/plugin/story/ui/view/StoryMsgListView", "updateMsgList$lambda-5$lambda-4", "(Lcom/tencent/mm/plugin/story/ui/view/StoryMsgListView;Ljava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
      paramStoryMsgListView.scrollToPosition(((Integer)paramList.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramStoryMsgListView, "com/tencent/mm/plugin/story/ui/view/StoryMsgListView", "updateMsgList$lambda-5$lambda-4", "(Lcom/tencent/mm/plugin/story/ui/view/StoryMsgListView;Ljava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
    }
    AppMethodBeat.o(367466);
  }
  
  private static final void b(StoryMsgListView paramStoryMsgListView, List paramList)
  {
    AppMethodBeat.i(367469);
    s.u(paramStoryMsgListView, "this$0");
    s.u(paramList, "$datas");
    paramStoryMsgListView = paramStoryMsgListView.Szd.getLayoutManager();
    if (paramStoryMsgListView != null)
    {
      paramList = c.a(paramList.size() - 1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramStoryMsgListView, paramList.aYi(), "com/tencent/mm/plugin/story/ui/view/StoryMsgListView", "updateMsgList$lambda-7$lambda-6", "(Lcom/tencent/mm/plugin/story/ui/view/StoryMsgListView;Ljava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
      paramStoryMsgListView.scrollToPosition(((Integer)paramList.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramStoryMsgListView, "com/tencent/mm/plugin/story/ui/view/StoryMsgListView", "updateMsgList$lambda-7$lambda-6", "(Lcom/tencent/mm/plugin/story/ui/view/StoryMsgListView;Ljava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
    }
    AppMethodBeat.o(367469);
  }
  
  private static ArrayList<com.tencent.mm.plugin.story.model.b.a> ll(List<com.tencent.mm.plugin.story.model.b.a> paramList)
  {
    AppMethodBeat.i(120233);
    ArrayList localArrayList = new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new com.tencent.mm.plugin.story.model.b.a((com.tencent.mm.plugin.story.model.b.a)paramList.next()));
    }
    AppMethodBeat.o(120233);
    return localArrayList;
  }
  
  private static final void setup$lambda-3(StoryMsgListView paramStoryMsgListView)
  {
    AppMethodBeat.i(367463);
    s.u(paramStoryMsgListView, "this$0");
    Object localObject = paramStoryMsgListView.Szd.getAdapter();
    if (localObject != null)
    {
      paramStoryMsgListView = paramStoryMsgListView.Szd.getLayoutManager();
      if (paramStoryMsgListView != null)
      {
        localObject = c.a(((RecyclerView.a)localObject).getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(paramStoryMsgListView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/story/ui/view/StoryMsgListView", "setup$lambda-3", "(Lcom/tencent/mm/plugin/story/ui/view/StoryMsgListView;)V", "Undefined", "scrollToPosition", "(I)V");
        paramStoryMsgListView.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(paramStoryMsgListView, "com/tencent/mm/plugin/story/ui/view/StoryMsgListView", "setup$lambda-3", "(Lcom/tencent/mm/plugin/story/ui/view/StoryMsgListView;)V", "Undefined", "scrollToPosition", "(I)V");
      }
    }
    AppMethodBeat.o(367463);
  }
  
  public final void a(int paramInt, ArrayList<com.tencent.mm.plugin.story.model.b.a> paramArrayList1, ArrayList<com.tencent.mm.plugin.story.model.b.a> paramArrayList2, j paramj)
  {
    AppMethodBeat.i(120234);
    s.u(paramArrayList1, "comments");
    s.u(paramArrayList2, "bubbles");
    this.mode = paramInt;
    if (paramInt == Szg)
    {
      paramArrayList1 = new l(ll((List)paramArrayList2));
      paramj = this.Szd;
      getContext();
      paramj.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(4));
      this.Szd.setAdapter((RecyclerView.a)paramArrayList1);
      paramArrayList1 = this.Szd.getLayoutParams();
      if (paramArrayList1 == null)
      {
        paramArrayList1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(120234);
        throw paramArrayList1;
      }
      ((ViewGroup.MarginLayoutParams)paramArrayList1).setMarginStart(bd.fromDPToPix(getContext(), 40));
      paramArrayList1 = this.Szd.getLayoutParams();
      if (paramArrayList1 == null)
      {
        paramArrayList1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(120234);
        throw paramArrayList1;
      }
      ((ViewGroup.MarginLayoutParams)paramArrayList1).setMarginEnd(bd.fromDPToPix(getContext(), 40));
      this.Sze.setText((CharSequence)getContext().getResources().getString(a.g.ShK));
      if (paramArrayList2.isEmpty())
      {
        this.Sze.setVisibility(0);
        this.Szd.setVisibility(8);
      }
    }
    for (;;)
    {
      this.Szd.post(new StoryMsgListView..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(120234);
      return;
      this.Sze.setVisibility(8);
      this.Szd.setVisibility(0);
      continue;
      if (paramInt == Szh)
      {
        paramArrayList2 = new com.tencent.mm.plugin.story.ui.a.f(ll((List)paramArrayList1));
        paramArrayList2.Suk = paramj;
        paramArrayList2.Fau = this.SuH;
        paramj = this.Szd;
        getContext();
        paramj.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
        this.Szd.setAdapter((RecyclerView.a)paramArrayList2);
        this.Sze.setText((CharSequence)getContext().getResources().getString(a.g.ShN));
        if (paramArrayList1.isEmpty())
        {
          this.Sze.setVisibility(0);
          this.Szd.setVisibility(8);
        }
        else
        {
          this.Sze.setVisibility(8);
          this.Szd.setVisibility(0);
        }
      }
    }
  }
  
  public final void anA(int paramInt)
  {
    AppMethodBeat.i(120237);
    Object localObject = this.Szd.getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(120237);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = paramInt;
    requestLayout();
    AppMethodBeat.o(120237);
  }
  
  public final kotlin.g.a.a<ah> getOnBlankClick()
  {
    return this.SuI;
  }
  
  public final kotlin.g.a.b<com.tencent.mm.plugin.story.model.b.a, ah> getOnCommentItemClick()
  {
    return this.SuH;
  }
  
  public final kotlin.g.a.b<Integer, ah> getOnContentTopOverScroll()
  {
    return this.SuJ;
  }
  
  public final kotlin.g.a.a<ah> getOnContentTopOverScrollStop()
  {
    return this.SuK;
  }
  
  public final void lm(List<com.tencent.mm.plugin.story.model.b.a> paramList)
  {
    int j = 1;
    AppMethodBeat.i(120235);
    s.u(paramList, "datas");
    if (((Collection)paramList).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.Sze.setVisibility(0);
      this.Szd.setVisibility(8);
      AppMethodBeat.o(120235);
      return;
    }
    this.Sze.setVisibility(8);
    this.Szd.setVisibility(0);
    Object localObject1;
    List localList;
    Object localObject2;
    Object localObject4;
    boolean bool;
    if (this.mode == Szg)
    {
      localObject1 = this.Szd.getAdapter();
      if (localObject1 == null) {
        break label466;
      }
      localObject1 = (l)localObject1;
      localList = (List)ll(paramList);
      s.u(localList, "newBubbles");
      Log.d(((l)localObject1).TAG, "updateBubbles");
      localObject2 = ((l)localObject1).Sus.entrySet().iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label473;
      }
      Object localObject3 = ((Iterator)localObject2).next();
      s.s(localObject3, "it.next()");
      localObject3 = (Map.Entry)localObject3;
      localObject4 = StoryCore.SjP;
      if (!Util.isEqual(StoryCore.b.hgg(), (String)((Map.Entry)localObject3).getKey()))
      {
        localObject4 = StoryCore.SjP;
        localObject4 = StoryCore.b.hvS();
        Object localObject5 = ((Map.Entry)localObject3).getKey();
        s.s(localObject5, "entry.key");
        localObject4 = ((com.tencent.mm.plugin.story.h.g)localObject4).bcm((String)localObject5);
        if (localObject4 == null)
        {
          bool = false;
          label258:
          if (!bool) {
            break label354;
          }
          bool = true;
          label266:
          if (s.p(Boolean.valueOf(bool), ((Map.Entry)localObject3).getValue())) {
            break label358;
          }
        }
      }
    }
    label466:
    label473:
    for (i = j;; i = 0)
    {
      if (i != 0)
      {
        ((l)localObject1).SuL.clear();
        ((l)localObject1).SuL.addAll((Collection)localList);
        ((RecyclerView.a)localObject1).bZE.notifyChanged();
      }
      for (;;)
      {
        this.Szd.post(new StoryMsgListView..ExternalSyntheticLambda2(this, paramList));
        AppMethodBeat.o(120235);
        return;
        bool = ((com.tencent.mm.plugin.story.h.f)localObject4).hzn();
        break label258;
        label354:
        bool = false;
        break label266;
        label358:
        break;
        localObject2 = androidx.recyclerview.widget.g.a((g.a)new l.c((l)localObject1, localList), false);
        s.s(localObject2, "fun updateBubbles(newBub…      })\n        }\n\n    }");
        ((g.b)localObject2).a((q)new l.b((l)localObject1, localList));
      }
      if (this.mode == Szh)
      {
        localObject1 = this.Szd.getAdapter();
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.story.ui.a.f)localObject1).bI((List)ll(paramList));
          this.Szd.post(new StoryMsgListView..ExternalSyntheticLambda3(this, paramList));
        }
      }
      AppMethodBeat.o(120235);
      return;
    }
  }
  
  public final void ln(List<com.tencent.mm.plugin.story.model.b.a> paramList)
  {
    AppMethodBeat.i(120236);
    s.u(paramList, "datas");
    if (this.mode == Szh)
    {
      RecyclerView.a locala = this.Szd.getAdapter();
      if (locala != null) {
        ((com.tencent.mm.plugin.story.ui.a.f)locala).bI((List)ll(paramList));
      }
    }
    AppMethodBeat.o(120236);
  }
  
  public final void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(120239);
    paramView = this.Szd.getLayoutManager();
    int i;
    if ((paramView instanceof GridLayoutManager))
    {
      paramView = this.Szd.getLayoutManager();
      if (paramView == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        AppMethodBeat.o(120239);
        throw paramView;
      }
      i = ((GridLayoutManager)paramView).Jv();
    }
    while (paramInt2 > 0)
    {
      if (this.ser == 0) {
        break label244;
      }
      this.ser += paramInt2;
      paramView = this.SuJ;
      if (paramView != null) {
        paramView.invoke(Integer.valueOf(paramInt2));
      }
      if (paramArrayOfInt != null) {
        paramArrayOfInt[0] = paramInt1;
      }
      if (paramArrayOfInt == null) {
        break label244;
      }
      paramArrayOfInt[1] = paramInt2;
      AppMethodBeat.o(120239);
      return;
      if ((paramView instanceof LinearLayoutManager))
      {
        paramView = this.Szd.getLayoutManager();
        if (paramView == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(120239);
          throw paramView;
        }
        i = ((LinearLayoutManager)paramView).Jv();
      }
      else
      {
        i = -1;
      }
    }
    if ((paramInt2 < 0) && (i == 0))
    {
      this.ser += paramInt2;
      paramView = this.SuJ;
      if (paramView != null) {
        paramView.invoke(Integer.valueOf(paramInt2));
      }
      if (paramArrayOfInt != null) {
        paramArrayOfInt[0] = paramInt1;
      }
      if (paramArrayOfInt != null) {
        paramArrayOfInt[1] = paramInt2;
      }
    }
    label244:
    AppMethodBeat.o(120239);
  }
  
  public final void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.ser = 0;
  }
  
  public final boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public final void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(120238);
    paramView = this.Szd.getLayoutManager();
    int i;
    if ((paramView instanceof GridLayoutManager))
    {
      paramView = this.Szd.getLayoutManager();
      if (paramView == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        AppMethodBeat.o(120238);
        throw paramView;
      }
      i = ((GridLayoutManager)paramView).Jv();
    }
    for (;;)
    {
      if (i == 0)
      {
        paramView = this.SuK;
        if (paramView != null) {
          paramView.invoke();
        }
      }
      AppMethodBeat.o(120238);
      return;
      if ((paramView instanceof LinearLayoutManager))
      {
        paramView = this.Szd.getLayoutManager();
        if (paramView == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(120238);
          throw paramView;
        }
        i = ((LinearLayoutManager)paramView).Jv();
      }
      else
      {
        i = -1;
      }
    }
  }
  
  public final void setOnBlankClick(kotlin.g.a.a<ah> parama)
  {
    this.SuI = parama;
  }
  
  public final void setOnCommentItemClick(kotlin.g.a.b<? super com.tencent.mm.plugin.story.model.b.a, ah> paramb)
  {
    this.SuH = paramb;
  }
  
  public final void setOnContentTopOverScroll(kotlin.g.a.b<? super Integer, ah> paramb)
  {
    this.SuJ = paramb;
  }
  
  public final void setOnContentTopOverScrollStop(kotlin.g.a.a<ah> parama)
  {
    this.SuK = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryMsgListView
 * JD-Core Version:    0.7.0.1
 */
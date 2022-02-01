package com.tencent.mm.plugin.story.ui.a;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.plugin.story.ui.view.StoryMsgListView;
import com.tencent.mm.plugin.story.ui.view.StoryMsgListView.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import java.util.ArrayList;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryMsgListAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "isSelf", "", "visitors", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "comments", "pages", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgListView;", "(ZLjava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "TAG", "", "getComments", "()Ljava/util/ArrayList;", "setComments", "(Ljava/util/ArrayList;)V", "hostStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getHostStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setHostStory", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "()Z", "setSelf", "(Z)V", "onBlankClick", "Lkotlin/Function0;", "", "getOnBlankClick", "()Lkotlin/jvm/functions/Function0;", "setOnBlankClick", "(Lkotlin/jvm/functions/Function0;)V", "onCommentItemClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "commentItem", "getOnCommentItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnCommentItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onContentTopOverScroll", "", "dy", "getOnContentTopOverScroll", "setOnContentTopOverScroll", "onContentTopOverScrollStop", "getOnContentTopOverScrollStop", "setOnContentTopOverScrollStop", "getPages", "setPages", "getVisitors", "setVisitors", "destroyItem", "container", "Landroid/view/ViewGroup;", "position", "view", "", "getCount", "getItemPosition", "obj", "instantiateItem", "isViewFromObject", "Landroid/view/View;", "plugin-story_release"})
public final class k
  extends androidx.viewpager.widget.a
{
  public j LRO;
  public ArrayList<com.tencent.mm.plugin.story.f.b.a> LRa;
  public b<? super com.tencent.mm.plugin.story.f.b.a, x> LSq;
  public kotlin.g.a.a<x> LSr;
  public b<? super Integer, x> LSs;
  public kotlin.g.a.a<x> LSt;
  public ArrayList<com.tencent.mm.plugin.story.f.b.a> LSu;
  public ArrayList<StoryMsgListView> LSv;
  private final String TAG;
  public boolean fCB;
  
  private k(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.story.f.b.a> paramArrayList1, ArrayList<com.tencent.mm.plugin.story.f.b.a> paramArrayList2, ArrayList<StoryMsgListView> paramArrayList)
  {
    AppMethodBeat.i(119786);
    this.fCB = paramBoolean;
    this.LSu = paramArrayList1;
    this.LRa = paramArrayList2;
    this.LSv = paramArrayList;
    this.TAG = "MicroMsg.StoryMsgListAdapter";
    AppMethodBeat.o(119786);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(119784);
    p.k(paramViewGroup, "container");
    p.k(paramObject, "view");
    Log.d(this.TAG, "destroyItem ".concat(String.valueOf(paramInt)));
    paramViewGroup.removeView((View)paramObject);
    AppMethodBeat.o(119784);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(119782);
    int i = this.LSv.size();
    AppMethodBeat.o(119782);
    return i;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    AppMethodBeat.i(119785);
    p.k(paramObject, "obj");
    AppMethodBeat.o(119785);
    return -2;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(119783);
    p.k(paramViewGroup, "container");
    Log.d(this.TAG, "instantiateItem isSelf:" + this.fCB);
    StoryMsgListView localStoryMsgListView;
    StoryMsgListView.a locala;
    if (this.fCB) {
      if (paramInt == 0)
      {
        localStoryMsgListView = (StoryMsgListView)this.LSv.get(paramInt);
        locala = StoryMsgListView.LXy;
        localStoryMsgListView.a(StoryMsgListView.ggE(), this.LRa, this.LSu, this.LRO);
        ((StoryMsgListView)this.LSv.get(paramInt)).setOnBlankClick(this.LSr);
        ((StoryMsgListView)this.LSv.get(paramInt)).setOnContentTopOverScroll(this.LSs);
        ((StoryMsgListView)this.LSv.get(paramInt)).setOnContentTopOverScrollStop(this.LSt);
        ((StoryMsgListView)this.LSv.get(paramInt)).aiz(ax.aB(paramViewGroup.getContext()) + aw.fromDPToPix(paramViewGroup.getContext(), 48) + aw.fromDPToPix(paramViewGroup.getContext(), 24));
      }
    }
    for (;;)
    {
      paramViewGroup.addView((View)this.LSv.get(paramInt));
      paramViewGroup = this.LSv.get(paramInt);
      p.j(paramViewGroup, "pages[position]");
      AppMethodBeat.o(119783);
      return paramViewGroup;
      ((StoryMsgListView)this.LSv.get(paramInt)).setOnCommentItemClick(this.LSq);
      ((StoryMsgListView)this.LSv.get(paramInt)).setOnBlankClick(this.LSr);
      ((StoryMsgListView)this.LSv.get(paramInt)).setOnContentTopOverScroll(this.LSs);
      ((StoryMsgListView)this.LSv.get(paramInt)).setOnContentTopOverScrollStop(this.LSt);
      localStoryMsgListView = (StoryMsgListView)this.LSv.get(paramInt);
      locala = StoryMsgListView.LXy;
      localStoryMsgListView.a(StoryMsgListView.ggF(), this.LRa, this.LSu, this.LRO);
      break;
      ((StoryMsgListView)this.LSv.get(paramInt)).setOnCommentItemClick(this.LSq);
      ((StoryMsgListView)this.LSv.get(paramInt)).setOnBlankClick(this.LSr);
      ((StoryMsgListView)this.LSv.get(paramInt)).setOnContentTopOverScroll(this.LSs);
      ((StoryMsgListView)this.LSv.get(paramInt)).setOnContentTopOverScrollStop(this.LSt);
      localStoryMsgListView = (StoryMsgListView)this.LSv.get(paramInt);
      locala = StoryMsgListView.LXy;
      localStoryMsgListView.a(StoryMsgListView.ggF(), this.LRa, this.LSu, this.LRO);
      ((StoryMsgListView)this.LSv.get(paramInt)).aiz(ax.aB(paramViewGroup.getContext()) + aw.fromDPToPix(paramViewGroup.getContext(), 24));
    }
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    AppMethodBeat.i(119781);
    p.k(paramView, "view");
    p.k(paramObject, "obj");
    boolean bool = p.h(paramView, paramObject);
    AppMethodBeat.o(119781);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.k
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.story.ui.a;

import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.plugin.story.ui.view.StoryMsgListView;
import com.tencent.mm.plugin.story.ui.view.StoryMsgListView.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import d.g.a.b;
import d.l;
import d.y;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryMsgListAdapter;", "Landroid/support/v4/view/PagerAdapter;", "isSelf", "", "visitors", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "comments", "pages", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgListView;", "(ZLjava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "TAG", "", "getComments", "()Ljava/util/ArrayList;", "setComments", "(Ljava/util/ArrayList;)V", "hostStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getHostStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setHostStory", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "()Z", "setSelf", "(Z)V", "onBlankClick", "Lkotlin/Function0;", "", "getOnBlankClick", "()Lkotlin/jvm/functions/Function0;", "setOnBlankClick", "(Lkotlin/jvm/functions/Function0;)V", "onCommentItemClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "commentItem", "getOnCommentItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnCommentItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onContentTopOverScroll", "", "dy", "getOnContentTopOverScroll", "setOnContentTopOverScroll", "onContentTopOverScrollStop", "getOnContentTopOverScrollStop", "setOnContentTopOverScrollStop", "getPages", "setPages", "getVisitors", "setVisitors", "destroyItem", "container", "Landroid/view/ViewGroup;", "position", "view", "", "getCount", "getItemPosition", "obj", "instantiateItem", "isViewFromObject", "Landroid/view/View;", "plugin-story_release"})
public final class k
  extends q
{
  private final String TAG;
  public boolean diE;
  public ArrayList<com.tencent.mm.plugin.story.f.b.a> ypM;
  public j yqB;
  public b<? super com.tencent.mm.plugin.story.f.b.a, y> yre;
  public d.g.a.a<y> yrf;
  public b<? super Integer, y> yrg;
  public d.g.a.a<y> yrh;
  public ArrayList<com.tencent.mm.plugin.story.f.b.a> yri;
  public ArrayList<StoryMsgListView> yrj;
  
  private k(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.story.f.b.a> paramArrayList1, ArrayList<com.tencent.mm.plugin.story.f.b.a> paramArrayList2, ArrayList<StoryMsgListView> paramArrayList)
  {
    AppMethodBeat.i(119786);
    this.diE = paramBoolean;
    this.yri = paramArrayList1;
    this.ypM = paramArrayList2;
    this.yrj = paramArrayList;
    this.TAG = "MicroMsg.StoryMsgListAdapter";
    AppMethodBeat.o(119786);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(119784);
    d.g.b.k.h(paramViewGroup, "container");
    d.g.b.k.h(paramObject, "view");
    ad.d(this.TAG, "destroyItem ".concat(String.valueOf(paramInt)));
    paramViewGroup.removeView((View)paramObject);
    AppMethodBeat.o(119784);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(119782);
    int i = this.yrj.size();
    AppMethodBeat.o(119782);
    return i;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    AppMethodBeat.i(119785);
    d.g.b.k.h(paramObject, "obj");
    AppMethodBeat.o(119785);
    return -2;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(119783);
    d.g.b.k.h(paramViewGroup, "container");
    ad.d(this.TAG, "instantiateItem isSelf:" + this.diE);
    StoryMsgListView localStoryMsgListView;
    StoryMsgListView.a locala;
    if (this.diE) {
      if (paramInt == 0)
      {
        localStoryMsgListView = (StoryMsgListView)this.yrj.get(paramInt);
        locala = StoryMsgListView.ywt;
        localStoryMsgListView.a(StoryMsgListView.dLj(), this.ypM, this.yri, this.yqB);
        ((StoryMsgListView)this.yrj.get(paramInt)).setOnBlankClick(this.yrf);
        ((StoryMsgListView)this.yrj.get(paramInt)).setOnContentTopOverScroll(this.yrg);
        ((StoryMsgListView)this.yrj.get(paramInt)).setOnContentTopOverScrollStop(this.yrh);
        ((StoryMsgListView)this.yrj.get(paramInt)).OM(ap.eb(paramViewGroup.getContext()) + ao.fromDPToPix(paramViewGroup.getContext(), 48) + ao.fromDPToPix(paramViewGroup.getContext(), 24));
      }
    }
    for (;;)
    {
      paramViewGroup.addView((View)this.yrj.get(paramInt));
      paramViewGroup = this.yrj.get(paramInt);
      d.g.b.k.g(paramViewGroup, "pages[position]");
      AppMethodBeat.o(119783);
      return paramViewGroup;
      ((StoryMsgListView)this.yrj.get(paramInt)).setOnCommentItemClick(this.yre);
      ((StoryMsgListView)this.yrj.get(paramInt)).setOnBlankClick(this.yrf);
      ((StoryMsgListView)this.yrj.get(paramInt)).setOnContentTopOverScroll(this.yrg);
      ((StoryMsgListView)this.yrj.get(paramInt)).setOnContentTopOverScrollStop(this.yrh);
      localStoryMsgListView = (StoryMsgListView)this.yrj.get(paramInt);
      locala = StoryMsgListView.ywt;
      localStoryMsgListView.a(StoryMsgListView.dLk(), this.ypM, this.yri, this.yqB);
      break;
      ((StoryMsgListView)this.yrj.get(paramInt)).setOnCommentItemClick(this.yre);
      ((StoryMsgListView)this.yrj.get(paramInt)).setOnBlankClick(this.yrf);
      ((StoryMsgListView)this.yrj.get(paramInt)).setOnContentTopOverScroll(this.yrg);
      ((StoryMsgListView)this.yrj.get(paramInt)).setOnContentTopOverScrollStop(this.yrh);
      localStoryMsgListView = (StoryMsgListView)this.yrj.get(paramInt);
      locala = StoryMsgListView.ywt;
      localStoryMsgListView.a(StoryMsgListView.dLk(), this.ypM, this.yri, this.yqB);
      ((StoryMsgListView)this.yrj.get(paramInt)).OM(ap.eb(paramViewGroup.getContext()) + ao.fromDPToPix(paramViewGroup.getContext(), 24));
    }
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    AppMethodBeat.i(119781);
    d.g.b.k.h(paramView, "view");
    d.g.b.k.h(paramObject, "obj");
    boolean bool = d.g.b.k.g(paramView, paramObject);
    AppMethodBeat.o(119781);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.k
 * JD-Core Version:    0.7.0.1
 */
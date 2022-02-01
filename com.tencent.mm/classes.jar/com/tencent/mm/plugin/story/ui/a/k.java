package com.tencent.mm.plugin.story.ui.a;

import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.plugin.story.ui.view.StoryMsgListView;
import com.tencent.mm.plugin.story.ui.view.StoryMsgListView.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryMsgListAdapter;", "Landroid/support/v4/view/PagerAdapter;", "isSelf", "", "visitors", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "comments", "pages", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgListView;", "(ZLjava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "TAG", "", "getComments", "()Ljava/util/ArrayList;", "setComments", "(Ljava/util/ArrayList;)V", "hostStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getHostStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setHostStory", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "()Z", "setSelf", "(Z)V", "onBlankClick", "Lkotlin/Function0;", "", "getOnBlankClick", "()Lkotlin/jvm/functions/Function0;", "setOnBlankClick", "(Lkotlin/jvm/functions/Function0;)V", "onCommentItemClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "commentItem", "getOnCommentItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnCommentItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onContentTopOverScroll", "", "dy", "getOnContentTopOverScroll", "setOnContentTopOverScroll", "onContentTopOverScrollStop", "getOnContentTopOverScrollStop", "setOnContentTopOverScrollStop", "getPages", "setPages", "getVisitors", "setVisitors", "destroyItem", "container", "Landroid/view/ViewGroup;", "position", "view", "", "getCount", "getItemPosition", "obj", "instantiateItem", "isViewFromObject", "Landroid/view/View;", "plugin-story_release"})
public final class k
  extends q
{
  public ArrayList<com.tencent.mm.plugin.story.f.b.a> AUK;
  public j AVy;
  public b<? super com.tencent.mm.plugin.story.f.b.a, z> AWa;
  public d.g.a.a<z> AWb;
  public b<? super Integer, z> AWc;
  public d.g.a.a<z> AWd;
  public ArrayList<com.tencent.mm.plugin.story.f.b.a> AWe;
  public ArrayList<StoryMsgListView> AWf;
  private final String TAG;
  public boolean drv;
  
  private k(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.story.f.b.a> paramArrayList1, ArrayList<com.tencent.mm.plugin.story.f.b.a> paramArrayList2, ArrayList<StoryMsgListView> paramArrayList)
  {
    AppMethodBeat.i(119786);
    this.drv = paramBoolean;
    this.AWe = paramArrayList1;
    this.AUK = paramArrayList2;
    this.AWf = paramArrayList;
    this.TAG = "MicroMsg.StoryMsgListAdapter";
    AppMethodBeat.o(119786);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(119784);
    p.h(paramViewGroup, "container");
    p.h(paramObject, "view");
    ad.d(this.TAG, "destroyItem ".concat(String.valueOf(paramInt)));
    paramViewGroup.removeView((View)paramObject);
    AppMethodBeat.o(119784);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(119782);
    int i = this.AWf.size();
    AppMethodBeat.o(119782);
    return i;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    AppMethodBeat.i(119785);
    p.h(paramObject, "obj");
    AppMethodBeat.o(119785);
    return -2;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(119783);
    p.h(paramViewGroup, "container");
    ad.d(this.TAG, "instantiateItem isSelf:" + this.drv);
    StoryMsgListView localStoryMsgListView;
    StoryMsgListView.a locala;
    if (this.drv) {
      if (paramInt == 0)
      {
        localStoryMsgListView = (StoryMsgListView)this.AWf.get(paramInt);
        locala = StoryMsgListView.Bbk;
        localStoryMsgListView.a(StoryMsgListView.elY(), this.AUK, this.AWe, this.AVy);
        ((StoryMsgListView)this.AWf.get(paramInt)).setOnBlankClick(this.AWb);
        ((StoryMsgListView)this.AWf.get(paramInt)).setOnContentTopOverScroll(this.AWc);
        ((StoryMsgListView)this.AWf.get(paramInt)).setOnContentTopOverScrollStop(this.AWd);
        ((StoryMsgListView)this.AWf.get(paramInt)).SB(ar.ej(paramViewGroup.getContext()) + aq.fromDPToPix(paramViewGroup.getContext(), 48) + aq.fromDPToPix(paramViewGroup.getContext(), 24));
      }
    }
    for (;;)
    {
      paramViewGroup.addView((View)this.AWf.get(paramInt));
      paramViewGroup = this.AWf.get(paramInt);
      p.g(paramViewGroup, "pages[position]");
      AppMethodBeat.o(119783);
      return paramViewGroup;
      ((StoryMsgListView)this.AWf.get(paramInt)).setOnCommentItemClick(this.AWa);
      ((StoryMsgListView)this.AWf.get(paramInt)).setOnBlankClick(this.AWb);
      ((StoryMsgListView)this.AWf.get(paramInt)).setOnContentTopOverScroll(this.AWc);
      ((StoryMsgListView)this.AWf.get(paramInt)).setOnContentTopOverScrollStop(this.AWd);
      localStoryMsgListView = (StoryMsgListView)this.AWf.get(paramInt);
      locala = StoryMsgListView.Bbk;
      localStoryMsgListView.a(StoryMsgListView.elZ(), this.AUK, this.AWe, this.AVy);
      break;
      ((StoryMsgListView)this.AWf.get(paramInt)).setOnCommentItemClick(this.AWa);
      ((StoryMsgListView)this.AWf.get(paramInt)).setOnBlankClick(this.AWb);
      ((StoryMsgListView)this.AWf.get(paramInt)).setOnContentTopOverScroll(this.AWc);
      ((StoryMsgListView)this.AWf.get(paramInt)).setOnContentTopOverScrollStop(this.AWd);
      localStoryMsgListView = (StoryMsgListView)this.AWf.get(paramInt);
      locala = StoryMsgListView.Bbk;
      localStoryMsgListView.a(StoryMsgListView.elZ(), this.AUK, this.AWe, this.AVy);
      ((StoryMsgListView)this.AWf.get(paramInt)).SB(ar.ej(paramViewGroup.getContext()) + aq.fromDPToPix(paramViewGroup.getContext(), 24));
    }
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    AppMethodBeat.i(119781);
    p.h(paramView, "view");
    p.h(paramObject, "obj");
    boolean bool = p.i(paramView, paramObject);
    AppMethodBeat.o(119781);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.k
 * JD-Core Version:    0.7.0.1
 */
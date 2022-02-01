package com.tencent.mm.plugin.story.ui.a;

import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.plugin.story.ui.view.StoryMsgListView;
import com.tencent.mm.plugin.story.ui.view.StoryMsgListView.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryMsgListAdapter;", "Landroid/support/v4/view/PagerAdapter;", "isSelf", "", "visitors", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "comments", "pages", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgListView;", "(ZLjava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "TAG", "", "getComments", "()Ljava/util/ArrayList;", "setComments", "(Ljava/util/ArrayList;)V", "hostStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getHostStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setHostStory", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "()Z", "setSelf", "(Z)V", "onBlankClick", "Lkotlin/Function0;", "", "getOnBlankClick", "()Lkotlin/jvm/functions/Function0;", "setOnBlankClick", "(Lkotlin/jvm/functions/Function0;)V", "onCommentItemClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "commentItem", "getOnCommentItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnCommentItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onContentTopOverScroll", "", "dy", "getOnContentTopOverScroll", "setOnContentTopOverScroll", "onContentTopOverScrollStop", "getOnContentTopOverScrollStop", "setOnContentTopOverScrollStop", "getPages", "setPages", "getVisitors", "setVisitors", "destroyItem", "container", "Landroid/view/ViewGroup;", "position", "view", "", "getCount", "getItemPosition", "obj", "instantiateItem", "isViewFromObject", "Landroid/view/View;", "plugin-story_release"})
public final class k
  extends q
{
  public j BmW;
  public ArrayList<com.tencent.mm.plugin.story.f.b.a> Bmi;
  public b<? super Integer, z> BnA;
  public d.g.a.a<z> BnB;
  public ArrayList<com.tencent.mm.plugin.story.f.b.a> BnC;
  public ArrayList<StoryMsgListView> BnD;
  public b<? super com.tencent.mm.plugin.story.f.b.a, z> Bny;
  public d.g.a.a<z> Bnz;
  private final String TAG;
  public boolean dsB;
  
  private k(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.story.f.b.a> paramArrayList1, ArrayList<com.tencent.mm.plugin.story.f.b.a> paramArrayList2, ArrayList<StoryMsgListView> paramArrayList)
  {
    AppMethodBeat.i(119786);
    this.dsB = paramBoolean;
    this.BnC = paramArrayList1;
    this.Bmi = paramArrayList2;
    this.BnD = paramArrayList;
    this.TAG = "MicroMsg.StoryMsgListAdapter";
    AppMethodBeat.o(119786);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(119784);
    p.h(paramViewGroup, "container");
    p.h(paramObject, "view");
    ae.d(this.TAG, "destroyItem ".concat(String.valueOf(paramInt)));
    paramViewGroup.removeView((View)paramObject);
    AppMethodBeat.o(119784);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(119782);
    int i = this.BnD.size();
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
    ae.d(this.TAG, "instantiateItem isSelf:" + this.dsB);
    StoryMsgListView localStoryMsgListView;
    StoryMsgListView.a locala;
    if (this.dsB) {
      if (paramInt == 0)
      {
        localStoryMsgListView = (StoryMsgListView)this.BnD.get(paramInt);
        locala = StoryMsgListView.BsI;
        localStoryMsgListView.a(StoryMsgListView.epH(), this.Bmi, this.BnC, this.BmW);
        ((StoryMsgListView)this.BnD.get(paramInt)).setOnBlankClick(this.Bnz);
        ((StoryMsgListView)this.BnD.get(paramInt)).setOnContentTopOverScroll(this.BnA);
        ((StoryMsgListView)this.BnD.get(paramInt)).setOnContentTopOverScrollStop(this.BnB);
        ((StoryMsgListView)this.BnD.get(paramInt)).Ti(ar.en(paramViewGroup.getContext()) + aq.fromDPToPix(paramViewGroup.getContext(), 48) + aq.fromDPToPix(paramViewGroup.getContext(), 24));
      }
    }
    for (;;)
    {
      paramViewGroup.addView((View)this.BnD.get(paramInt));
      paramViewGroup = this.BnD.get(paramInt);
      p.g(paramViewGroup, "pages[position]");
      AppMethodBeat.o(119783);
      return paramViewGroup;
      ((StoryMsgListView)this.BnD.get(paramInt)).setOnCommentItemClick(this.Bny);
      ((StoryMsgListView)this.BnD.get(paramInt)).setOnBlankClick(this.Bnz);
      ((StoryMsgListView)this.BnD.get(paramInt)).setOnContentTopOverScroll(this.BnA);
      ((StoryMsgListView)this.BnD.get(paramInt)).setOnContentTopOverScrollStop(this.BnB);
      localStoryMsgListView = (StoryMsgListView)this.BnD.get(paramInt);
      locala = StoryMsgListView.BsI;
      localStoryMsgListView.a(StoryMsgListView.epI(), this.Bmi, this.BnC, this.BmW);
      break;
      ((StoryMsgListView)this.BnD.get(paramInt)).setOnCommentItemClick(this.Bny);
      ((StoryMsgListView)this.BnD.get(paramInt)).setOnBlankClick(this.Bnz);
      ((StoryMsgListView)this.BnD.get(paramInt)).setOnContentTopOverScroll(this.BnA);
      ((StoryMsgListView)this.BnD.get(paramInt)).setOnContentTopOverScrollStop(this.BnB);
      localStoryMsgListView = (StoryMsgListView)this.BnD.get(paramInt);
      locala = StoryMsgListView.BsI;
      localStoryMsgListView.a(StoryMsgListView.epI(), this.Bmi, this.BnC, this.BmW);
      ((StoryMsgListView)this.BnD.get(paramInt)).Ti(ar.en(paramViewGroup.getContext()) + aq.fromDPToPix(paramViewGroup.getContext(), 24));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.k
 * JD-Core Version:    0.7.0.1
 */
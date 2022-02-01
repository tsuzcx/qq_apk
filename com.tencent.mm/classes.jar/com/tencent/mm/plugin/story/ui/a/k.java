package com.tencent.mm.plugin.story.ui.a;

import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.plugin.story.ui.view.StoryMsgListView;
import com.tencent.mm.plugin.story.ui.view.StoryMsgListView.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryMsgListAdapter;", "Landroid/support/v4/view/PagerAdapter;", "isSelf", "", "visitors", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "comments", "pages", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgListView;", "(ZLjava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "TAG", "", "getComments", "()Ljava/util/ArrayList;", "setComments", "(Ljava/util/ArrayList;)V", "hostStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getHostStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setHostStory", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "()Z", "setSelf", "(Z)V", "onBlankClick", "Lkotlin/Function0;", "", "getOnBlankClick", "()Lkotlin/jvm/functions/Function0;", "setOnBlankClick", "(Lkotlin/jvm/functions/Function0;)V", "onCommentItemClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "commentItem", "getOnCommentItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnCommentItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onContentTopOverScroll", "", "dy", "getOnContentTopOverScroll", "setOnContentTopOverScroll", "onContentTopOverScrollStop", "getOnContentTopOverScrollStop", "setOnContentTopOverScrollStop", "getPages", "setPages", "getVisitors", "setVisitors", "destroyItem", "container", "Landroid/view/ViewGroup;", "position", "view", "", "getCount", "getItemPosition", "obj", "instantiateItem", "isViewFromObject", "Landroid/view/View;", "plugin-story_release"})
public final class k
  extends q
{
  public ArrayList<com.tencent.mm.plugin.story.f.b.a> FwY;
  public j FxM;
  public b<? super com.tencent.mm.plugin.story.f.b.a, x> Fyo;
  public kotlin.g.a.a<x> Fyp;
  public b<? super Integer, x> Fyq;
  public kotlin.g.a.a<x> Fyr;
  public ArrayList<com.tencent.mm.plugin.story.f.b.a> Fys;
  public ArrayList<StoryMsgListView> Fyt;
  private final String TAG;
  public boolean dJM;
  
  private k(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.story.f.b.a> paramArrayList1, ArrayList<com.tencent.mm.plugin.story.f.b.a> paramArrayList2, ArrayList<StoryMsgListView> paramArrayList)
  {
    AppMethodBeat.i(119786);
    this.dJM = paramBoolean;
    this.Fys = paramArrayList1;
    this.FwY = paramArrayList2;
    this.Fyt = paramArrayList;
    this.TAG = "MicroMsg.StoryMsgListAdapter";
    AppMethodBeat.o(119786);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(119784);
    p.h(paramViewGroup, "container");
    p.h(paramObject, "view");
    Log.d(this.TAG, "destroyItem ".concat(String.valueOf(paramInt)));
    paramViewGroup.removeView((View)paramObject);
    AppMethodBeat.o(119784);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(119782);
    int i = this.Fyt.size();
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
    Log.d(this.TAG, "instantiateItem isSelf:" + this.dJM);
    StoryMsgListView localStoryMsgListView;
    StoryMsgListView.a locala;
    if (this.dJM) {
      if (paramInt == 0)
      {
        localStoryMsgListView = (StoryMsgListView)this.Fyt.get(paramInt);
        locala = StoryMsgListView.FDv;
        localStoryMsgListView.a(StoryMsgListView.fsg(), this.FwY, this.Fys, this.FxM);
        ((StoryMsgListView)this.Fyt.get(paramInt)).setOnBlankClick(this.Fyp);
        ((StoryMsgListView)this.Fyt.get(paramInt)).setOnContentTopOverScroll(this.Fyq);
        ((StoryMsgListView)this.Fyt.get(paramInt)).setOnContentTopOverScrollStop(this.Fyr);
        ((StoryMsgListView)this.Fyt.get(paramInt)).abe(au.aD(paramViewGroup.getContext()) + at.fromDPToPix(paramViewGroup.getContext(), 48) + at.fromDPToPix(paramViewGroup.getContext(), 24));
      }
    }
    for (;;)
    {
      paramViewGroup.addView((View)this.Fyt.get(paramInt));
      paramViewGroup = this.Fyt.get(paramInt);
      p.g(paramViewGroup, "pages[position]");
      AppMethodBeat.o(119783);
      return paramViewGroup;
      ((StoryMsgListView)this.Fyt.get(paramInt)).setOnCommentItemClick(this.Fyo);
      ((StoryMsgListView)this.Fyt.get(paramInt)).setOnBlankClick(this.Fyp);
      ((StoryMsgListView)this.Fyt.get(paramInt)).setOnContentTopOverScroll(this.Fyq);
      ((StoryMsgListView)this.Fyt.get(paramInt)).setOnContentTopOverScrollStop(this.Fyr);
      localStoryMsgListView = (StoryMsgListView)this.Fyt.get(paramInt);
      locala = StoryMsgListView.FDv;
      localStoryMsgListView.a(StoryMsgListView.fsh(), this.FwY, this.Fys, this.FxM);
      break;
      ((StoryMsgListView)this.Fyt.get(paramInt)).setOnCommentItemClick(this.Fyo);
      ((StoryMsgListView)this.Fyt.get(paramInt)).setOnBlankClick(this.Fyp);
      ((StoryMsgListView)this.Fyt.get(paramInt)).setOnContentTopOverScroll(this.Fyq);
      ((StoryMsgListView)this.Fyt.get(paramInt)).setOnContentTopOverScrollStop(this.Fyr);
      localStoryMsgListView = (StoryMsgListView)this.Fyt.get(paramInt);
      locala = StoryMsgListView.FDv;
      localStoryMsgListView.a(StoryMsgListView.fsh(), this.FwY, this.Fys, this.FxM);
      ((StoryMsgListView)this.Fyt.get(paramInt)).abe(au.aD(paramViewGroup.getContext()) + at.fromDPToPix(paramViewGroup.getContext(), 24));
    }
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    AppMethodBeat.i(119781);
    p.h(paramView, "view");
    p.h(paramObject, "obj");
    boolean bool = p.j(paramView, paramObject);
    AppMethodBeat.o(119781);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.k
 * JD-Core Version:    0.7.0.1
 */
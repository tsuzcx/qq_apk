package com.tencent.mm.plugin.story.ui.a;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.ui.view.StoryMsgListView;
import com.tencent.mm.plugin.story.ui.view.StoryMsgListView.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryMsgListAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "isSelf", "", "visitors", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "comments", "pages", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgListView;", "(ZLjava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "TAG", "", "getComments", "()Ljava/util/ArrayList;", "setComments", "(Ljava/util/ArrayList;)V", "hostStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getHostStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setHostStory", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "()Z", "setSelf", "(Z)V", "onBlankClick", "Lkotlin/Function0;", "", "getOnBlankClick", "()Lkotlin/jvm/functions/Function0;", "setOnBlankClick", "(Lkotlin/jvm/functions/Function0;)V", "onCommentItemClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "commentItem", "getOnCommentItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnCommentItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onContentTopOverScroll", "", "dy", "getOnContentTopOverScroll", "setOnContentTopOverScroll", "onContentTopOverScrollStop", "getOnContentTopOverScrollStop", "setOnContentTopOverScrollStop", "getPages", "setPages", "getVisitors", "setVisitors", "destroyItem", "container", "Landroid/view/ViewGroup;", "position", "view", "", "getCount", "getItemPosition", "obj", "instantiateItem", "isViewFromObject", "Landroid/view/View;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends androidx.viewpager.widget.a
{
  public ArrayList<com.tencent.mm.plugin.story.model.b.a> StI;
  public ArrayList<com.tencent.mm.plugin.story.model.b.a> SuF;
  public ArrayList<StoryMsgListView> SuG;
  public b<? super com.tencent.mm.plugin.story.model.b.a, ah> SuH;
  public kotlin.g.a.a<ah> SuI;
  public b<? super Integer, ah> SuJ;
  public kotlin.g.a.a<ah> SuK;
  public j Suk;
  private final String TAG;
  public boolean hHq;
  
  private k(boolean paramBoolean, ArrayList<com.tencent.mm.plugin.story.model.b.a> paramArrayList1, ArrayList<com.tencent.mm.plugin.story.model.b.a> paramArrayList2, ArrayList<StoryMsgListView> paramArrayList)
  {
    AppMethodBeat.i(119786);
    this.hHq = paramBoolean;
    this.SuF = paramArrayList1;
    this.StI = paramArrayList2;
    this.SuG = paramArrayList;
    this.TAG = "MicroMsg.StoryMsgListAdapter";
    AppMethodBeat.o(119786);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(119784);
    s.u(paramViewGroup, "container");
    s.u(paramObject, "view");
    Log.d(this.TAG, s.X("destroyItem ", Integer.valueOf(paramInt)));
    paramViewGroup.removeView((View)paramObject);
    AppMethodBeat.o(119784);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(119782);
    int i = this.SuG.size();
    AppMethodBeat.o(119782);
    return i;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    AppMethodBeat.i(119785);
    s.u(paramObject, "obj");
    AppMethodBeat.o(119785);
    return -2;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(119783);
    s.u(paramViewGroup, "container");
    Log.d(this.TAG, s.X("instantiateItem isSelf:", Boolean.valueOf(this.hHq)));
    StoryMsgListView localStoryMsgListView;
    StoryMsgListView.a locala;
    if (this.hHq) {
      if (paramInt == 0)
      {
        localStoryMsgListView = (StoryMsgListView)this.SuG.get(paramInt);
        locala = StoryMsgListView.Szc;
        localStoryMsgListView.a(StoryMsgListView.hzX(), this.StI, this.SuF, this.Suk);
        ((StoryMsgListView)this.SuG.get(paramInt)).setOnBlankClick(this.SuI);
        ((StoryMsgListView)this.SuG.get(paramInt)).setOnContentTopOverScroll(this.SuJ);
        ((StoryMsgListView)this.SuG.get(paramInt)).setOnContentTopOverScrollStop(this.SuK);
        ((StoryMsgListView)this.SuG.get(paramInt)).anA(bf.bk(paramViewGroup.getContext()) + bd.fromDPToPix(paramViewGroup.getContext(), 48) + bd.fromDPToPix(paramViewGroup.getContext(), 24));
      }
    }
    for (;;)
    {
      paramViewGroup.addView((View)this.SuG.get(paramInt));
      paramViewGroup = this.SuG.get(paramInt);
      s.s(paramViewGroup, "pages[position]");
      AppMethodBeat.o(119783);
      return paramViewGroup;
      ((StoryMsgListView)this.SuG.get(paramInt)).setOnCommentItemClick(this.SuH);
      ((StoryMsgListView)this.SuG.get(paramInt)).setOnBlankClick(this.SuI);
      ((StoryMsgListView)this.SuG.get(paramInt)).setOnContentTopOverScroll(this.SuJ);
      ((StoryMsgListView)this.SuG.get(paramInt)).setOnContentTopOverScrollStop(this.SuK);
      localStoryMsgListView = (StoryMsgListView)this.SuG.get(paramInt);
      locala = StoryMsgListView.Szc;
      localStoryMsgListView.a(StoryMsgListView.hzY(), this.StI, this.SuF, this.Suk);
      break;
      ((StoryMsgListView)this.SuG.get(paramInt)).setOnCommentItemClick(this.SuH);
      ((StoryMsgListView)this.SuG.get(paramInt)).setOnBlankClick(this.SuI);
      ((StoryMsgListView)this.SuG.get(paramInt)).setOnContentTopOverScroll(this.SuJ);
      ((StoryMsgListView)this.SuG.get(paramInt)).setOnContentTopOverScrollStop(this.SuK);
      localStoryMsgListView = (StoryMsgListView)this.SuG.get(paramInt);
      locala = StoryMsgListView.Szc;
      localStoryMsgListView.a(StoryMsgListView.hzY(), this.StI, this.SuF, this.Suk);
      ((StoryMsgListView)this.SuG.get(paramInt)).anA(bf.bk(paramViewGroup.getContext()) + bd.fromDPToPix(paramViewGroup.getContext(), 24));
    }
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    AppMethodBeat.i(119781);
    s.u(paramView, "view");
    s.u(paramObject, "obj");
    boolean bool = s.p(paramView, paramObject);
    AppMethodBeat.o(119781);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.k
 * JD-Core Version:    0.7.0.1
 */
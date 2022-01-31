package com.tencent.mm.plugin.story.ui.a;

import a.f.a.m;
import a.l;
import a.y;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "()V", "animStartPosition", "", "animateOnBind", "", "bindMaxPosition", "blankAreaClickListener", "Lkotlin/Function0;", "", "getBlankAreaClickListener", "()Lkotlin/jvm/functions/Function0;", "setBlankAreaClickListener", "(Lkotlin/jvm/functions/Function0;)V", "comments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "hostStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getHostStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setHostStory", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "replyClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "comment", "isReply", "getReplyClickListener", "()Lkotlin/jvm/functions/Function2;", "setReplyClickListener", "(Lkotlin/jvm/functions/Function2;)V", "filterFavItem", "filterValidItem", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAnimateEnable", "enable", "update", "storyComments", "", "BaseStoryCommentViewHolder", "Companion", "StoryBubbleViewHolder", "StoryCommentViewHolder", "plugin-story_release"})
public final class f
  extends RecyclerView.a<f.a>
{
  private static final int lxS = 0;
  private static final int sIy = 1;
  public static final f.b sIz;
  private final ArrayList<com.tencent.mm.plugin.story.model.b.a> sHA;
  public boolean sIu;
  public com.tencent.mm.plugin.story.h.j sIv;
  public m<? super com.tencent.mm.plugin.story.model.b.a, ? super Boolean, y> sIw;
  public a.f.a.a<y> sIx;
  
  static
  {
    AppMethodBeat.i(110130);
    sIz = new f.b((byte)0);
    sIy = 1;
    AppMethodBeat.o(110130);
  }
  
  public f()
  {
    AppMethodBeat.i(110129);
    this.sHA = new ArrayList();
    AppMethodBeat.o(110129);
  }
  
  public final void dH(List<com.tencent.mm.plugin.story.model.b.a> paramList)
  {
    AppMethodBeat.i(138860);
    a.f.b.j.q(paramList, "storyComments");
    this.sHA.clear();
    this.sHA.addAll((Collection)paramList);
    AppMethodBeat.o(138860);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(110125);
    int i = this.sHA.size();
    AppMethodBeat.o(110125);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(110126);
    if (((com.tencent.mm.plugin.story.model.b.a)this.sHA.get(paramInt)).sxz)
    {
      paramInt = sIy;
      AppMethodBeat.o(110126);
      return paramInt;
    }
    paramInt = lxS;
    AppMethodBeat.o(110126);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.f
 * JD-Core Version:    0.7.0.1
 */
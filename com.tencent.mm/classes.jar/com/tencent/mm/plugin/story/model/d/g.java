package com.tencent.mm.plugin.story.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.b.a;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "", "()V", "bubbleList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "getBubbleList", "()Ljava/util/LinkedList;", "commentList", "getCommentList", "commentType", "", "getCommentType", "()I", "setCommentType", "(I)V", "commentUser", "", "getCommentUser", "()Ljava/lang/String;", "setCommentUser", "(Ljava/lang/String;)V", "isCommentUnread", "", "()Z", "setCommentUnread", "(Z)V", "isUnread", "setUnread", "isVisitorUnread", "setVisitorUnread", "msgList", "getMsgList", "showIndicator", "getShowIndicator", "setShowIndicator", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "storyOwner", "getStoryOwner", "setStoryOwner", "visitorList", "getVisitorList", "equals", "other", "toString", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public final LinkedList<a> PmC;
  int Rph;
  public String SlC;
  public boolean Sly;
  private String Smh;
  public boolean Smi;
  public boolean Smj;
  boolean Smk;
  final LinkedList<a> Sml;
  public final LinkedList<a> Smm;
  public final LinkedList<a> commentList;
  public long idH;
  
  public g()
  {
    AppMethodBeat.i(118918);
    this.SlC = "";
    this.commentList = new LinkedList();
    this.PmC = new LinkedList();
    this.Sml = new LinkedList();
    this.Smm = new LinkedList();
    AppMethodBeat.o(118918);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(118917);
    if (!(paramObject instanceof g))
    {
      AppMethodBeat.o(118917);
      return false;
    }
    if (this == paramObject)
    {
      AppMethodBeat.o(118917);
      return true;
    }
    if ((this.idH == ((g)paramObject).idH) && (this.commentList.size() == ((g)paramObject).commentList.size()) && (this.Smi == ((g)paramObject).Smi) && (this.Sly == ((g)paramObject).Sly))
    {
      AppMethodBeat.o(118917);
      return true;
    }
    AppMethodBeat.o(118917);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118916);
    String str = "StoryGalleryComment(fromUser='" + this.SlC + "', storyId=" + this.idH + ", commentType=" + this.Rph + ", commentUser=" + this.Smh + ", isUnread=" + this.Smi + ", commentList=" + this.commentList + ')';
    AppMethodBeat.o(118916);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.d.g
 * JD-Core Version:    0.7.0.1
 */
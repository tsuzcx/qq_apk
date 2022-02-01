package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.b.a;
import d.l;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "", "()V", "bubbleList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "getBubbleList", "()Ljava/util/LinkedList;", "commentList", "getCommentList", "commentType", "", "getCommentType", "()I", "setCommentType", "(I)V", "commentUser", "", "getCommentUser", "()Ljava/lang/String;", "setCommentUser", "(Ljava/lang/String;)V", "isCommentUnread", "", "()Z", "setCommentUnread", "(Z)V", "isUnread", "setUnread", "isVisitorUnread", "setVisitorUnread", "msgList", "getMsgList", "showIndicator", "getShowIndicator", "setShowIndicator", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "storyOwner", "getStoryOwner", "setStoryOwner", "visitorList", "getVisitorList", "equals", "other", "toString", "plugin-story_release"})
public final class g
{
  public boolean ALC;
  public String ALG;
  private String AMt;
  public boolean AMu;
  public boolean AMv;
  boolean AMw;
  public final LinkedList<a> AMx;
  final LinkedList<a> AMy;
  public final LinkedList<a> AMz;
  int Abl;
  public final LinkedList<a> commentList;
  public long dKt;
  
  public g()
  {
    AppMethodBeat.i(118918);
    this.ALG = "";
    this.commentList = new LinkedList();
    this.AMx = new LinkedList();
    this.AMy = new LinkedList();
    this.AMz = new LinkedList();
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
    if ((g)this == paramObject)
    {
      AppMethodBeat.o(118917);
      return true;
    }
    if ((this.dKt == ((g)paramObject).dKt) && (this.commentList.size() == ((g)paramObject).commentList.size()) && (this.AMu == ((g)paramObject).AMu) && (this.ALC == ((g)paramObject).ALC))
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
    String str = "StoryGalleryComment(fromUser='" + this.ALG + "', storyId=" + this.dKt + ", commentType=" + this.Abl + ", commentUser=" + this.AMt + ", isUnread=" + this.AMu + ", commentList=" + this.commentList + ')';
    AppMethodBeat.o(118916);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d.g
 * JD-Core Version:    0.7.0.1
 */
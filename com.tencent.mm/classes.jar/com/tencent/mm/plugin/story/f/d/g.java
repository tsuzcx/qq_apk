package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.b.a;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "", "()V", "bubbleList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "getBubbleList", "()Ljava/util/LinkedList;", "commentList", "getCommentList", "commentType", "", "getCommentType", "()I", "setCommentType", "(I)V", "commentUser", "", "getCommentUser", "()Ljava/lang/String;", "setCommentUser", "(Ljava/lang/String;)V", "isCommentUnread", "", "()Z", "setCommentUnread", "(Z)V", "isUnread", "setUnread", "isVisitorUnread", "setVisitorUnread", "msgList", "getMsgList", "showIndicator", "getShowIndicator", "setShowIndicator", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "storyOwner", "getStoryOwner", "setStoryOwner", "visitorList", "getVisitorList", "equals", "other", "toString", "plugin-story_release"})
public final class g
{
  int Asy;
  private String BdV;
  public boolean BdW;
  public boolean BdX;
  boolean BdY;
  public final LinkedList<a> BdZ;
  public boolean Bdf;
  public String Bdj;
  final LinkedList<a> Bea;
  public final LinkedList<a> Beb;
  public final LinkedList<a> commentList;
  public long dLI;
  
  public g()
  {
    AppMethodBeat.i(118918);
    this.Bdj = "";
    this.commentList = new LinkedList();
    this.BdZ = new LinkedList();
    this.Bea = new LinkedList();
    this.Beb = new LinkedList();
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
    if ((this.dLI == ((g)paramObject).dLI) && (this.commentList.size() == ((g)paramObject).commentList.size()) && (this.BdW == ((g)paramObject).BdW) && (this.Bdf == ((g)paramObject).Bdf))
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
    String str = "StoryGalleryComment(fromUser='" + this.Bdj + "', storyId=" + this.dLI + ", commentType=" + this.Asy + ", commentUser=" + this.BdV + ", isUnread=" + this.BdW + ", commentList=" + this.commentList + ')';
    AppMethodBeat.o(118916);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d.g
 * JD-Core Version:    0.7.0.1
 */
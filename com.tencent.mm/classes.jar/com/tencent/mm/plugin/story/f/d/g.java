package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.b.a;
import d.l;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "", "()V", "bubbleList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "getBubbleList", "()Ljava/util/LinkedList;", "commentList", "getCommentList", "commentType", "", "getCommentType", "()I", "setCommentType", "(I)V", "commentUser", "", "getCommentUser", "()Ljava/lang/String;", "setCommentUser", "(Ljava/lang/String;)V", "isCommentUnread", "", "()Z", "setCommentUnread", "(Z)V", "isUnread", "setUnread", "isVisitorUnread", "setVisitorUnread", "msgList", "getMsgList", "showIndicator", "getShowIndicator", "setShowIndicator", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "storyOwner", "getStoryOwner", "setStoryOwner", "visitorList", "getVisitorList", "equals", "other", "toString", "plugin-story_release"})
public final class g
{
  public final LinkedList<a> commentList;
  public long dAu;
  int xxb;
  public boolean ygI;
  public String ygM;
  public boolean yhA;
  boolean yhB;
  public final LinkedList<a> yhC;
  final LinkedList<a> yhD;
  public final LinkedList<a> yhE;
  private String yhy;
  public boolean yhz;
  
  public g()
  {
    AppMethodBeat.i(118918);
    this.ygM = "";
    this.commentList = new LinkedList();
    this.yhC = new LinkedList();
    this.yhD = new LinkedList();
    this.yhE = new LinkedList();
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
    if ((this.dAu == ((g)paramObject).dAu) && (this.commentList.size() == ((g)paramObject).commentList.size()) && (this.yhz == ((g)paramObject).yhz) && (this.ygI == ((g)paramObject).ygI))
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
    String str = "StoryGalleryComment(fromUser='" + this.ygM + "', storyId=" + this.dAu + ", commentType=" + this.xxb + ", commentUser=" + this.yhy + ", isUnread=" + this.yhz + ", commentList=" + this.commentList + ')';
    AppMethodBeat.o(118916);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d.g
 * JD-Core Version:    0.7.0.1
 */
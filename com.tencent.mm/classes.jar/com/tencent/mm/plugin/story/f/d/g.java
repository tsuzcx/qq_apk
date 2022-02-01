package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.b.a;
import java.util.LinkedList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "", "()V", "bubbleList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "getBubbleList", "()Ljava/util/LinkedList;", "commentList", "getCommentList", "commentType", "", "getCommentType", "()I", "setCommentType", "(I)V", "commentUser", "", "getCommentUser", "()Ljava/lang/String;", "setCommentUser", "(Ljava/lang/String;)V", "isCommentUnread", "", "()Z", "setCommentUnread", "(Z)V", "isUnread", "setUnread", "isVisitorUnread", "setVisitorUnread", "msgList", "getMsgList", "showIndicator", "getShowIndicator", "setShowIndicator", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "storyOwner", "getStoryOwner", "setStoryOwner", "visitorList", "getVisitorList", "equals", "other", "toString", "plugin-story_release"})
public final class g
{
  int KPv;
  public boolean LHX;
  private String LIO;
  public boolean LIP;
  public boolean LIQ;
  boolean LIR;
  public final LinkedList<a> LIS;
  final LinkedList<a> LIT;
  public final LinkedList<a> LIU;
  public String LIb;
  public final LinkedList<a> commentList;
  public long fXG;
  
  public g()
  {
    AppMethodBeat.i(118918);
    this.LIb = "";
    this.commentList = new LinkedList();
    this.LIS = new LinkedList();
    this.LIT = new LinkedList();
    this.LIU = new LinkedList();
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
    if ((this.fXG == ((g)paramObject).fXG) && (this.commentList.size() == ((g)paramObject).commentList.size()) && (this.LIP == ((g)paramObject).LIP) && (this.LHX == ((g)paramObject).LHX))
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
    String str = "StoryGalleryComment(fromUser='" + this.LIb + "', storyId=" + this.fXG + ", commentType=" + this.KPv + ", commentUser=" + this.LIO + ", isUnread=" + this.LIP + ", commentList=" + this.commentList + ')';
    AppMethodBeat.o(118916);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d.g
 * JD-Core Version:    0.7.0.1
 */
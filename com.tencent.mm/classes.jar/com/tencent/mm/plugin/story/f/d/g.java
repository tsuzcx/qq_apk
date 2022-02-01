package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.b.a;
import java.util.LinkedList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "", "()V", "bubbleList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "getBubbleList", "()Ljava/util/LinkedList;", "commentList", "getCommentList", "commentType", "", "getCommentType", "()I", "setCommentType", "(I)V", "commentUser", "", "getCommentUser", "()Ljava/lang/String;", "setCommentUser", "(Ljava/lang/String;)V", "isCommentUnread", "", "()Z", "setCommentUnread", "(Z)V", "isUnread", "setUnread", "isVisitorUnread", "setVisitorUnread", "msgList", "getMsgList", "showIndicator", "getShowIndicator", "setShowIndicator", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "storyOwner", "getStoryOwner", "setStoryOwner", "visitorList", "getVisitorList", "equals", "other", "toString", "plugin-story_release"})
public final class g
{
  int EBD;
  public boolean FnW;
  private String FoM;
  public boolean FoN;
  public boolean FoO;
  boolean FoP;
  public final LinkedList<a> FoQ;
  final LinkedList<a> FoR;
  public final LinkedList<a> FoS;
  public String Foa;
  public final LinkedList<a> commentList;
  public long edx;
  
  public g()
  {
    AppMethodBeat.i(118918);
    this.Foa = "";
    this.commentList = new LinkedList();
    this.FoQ = new LinkedList();
    this.FoR = new LinkedList();
    this.FoS = new LinkedList();
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
    if ((this.edx == ((g)paramObject).edx) && (this.commentList.size() == ((g)paramObject).commentList.size()) && (this.FoN == ((g)paramObject).FoN) && (this.FnW == ((g)paramObject).FnW))
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
    String str = "StoryGalleryComment(fromUser='" + this.Foa + "', storyId=" + this.edx + ", commentType=" + this.EBD + ", commentUser=" + this.FoM + ", isUnread=" + this.FoN + ", commentList=" + this.commentList + ')';
    AppMethodBeat.o(118916);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d.g
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.story.model.d;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.b.a;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "", "()V", "commentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "getCommentList", "()Ljava/util/LinkedList;", "commentType", "", "getCommentType", "()I", "setCommentType", "(I)V", "commentUser", "", "getCommentUser", "()Ljava/lang/String;", "setCommentUser", "(Ljava/lang/String;)V", "isUnread", "", "()Z", "setUnread", "(Z)V", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "storyOwner", "getStoryOwner", "setStoryOwner", "equals", "other", "toString", "plugin-story_release"})
public final class f
{
  public long cJA;
  public final LinkedList<a> rPQ;
  int rPd;
  public String sxC;
  public boolean sxy;
  private String syq;
  
  public f()
  {
    AppMethodBeat.i(109311);
    this.sxC = "";
    this.rPQ = new LinkedList();
    AppMethodBeat.o(109311);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(109310);
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(109310);
      return false;
    }
    if ((f)this == paramObject)
    {
      AppMethodBeat.o(109310);
      return true;
    }
    if ((this.cJA == ((f)paramObject).cJA) && (this.rPQ.size() == ((f)paramObject).rPQ.size()))
    {
      AppMethodBeat.o(109310);
      return true;
    }
    AppMethodBeat.o(109310);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(109309);
    String str = "StoryGalleryComment(fromUser='" + this.sxC + "', storyId=" + this.cJA + ", commentType=" + this.rPd + ", commentUser=" + this.syq + ", isUnread=" + this.sxy + ", commentList=" + this.rPQ + ')';
    AppMethodBeat.o(109309);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.d.f
 * JD-Core Version:    0.7.0.1
 */
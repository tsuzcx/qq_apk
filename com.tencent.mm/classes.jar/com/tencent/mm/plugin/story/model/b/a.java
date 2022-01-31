package com.tencent.mm.plugin.story.model.b;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cgw;
import com.tencent.mm.protocal.protobuf.cgx;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "", "commentDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "(Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;)V", "commentOp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;", "(Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;)V", "()V", "color", "", "getColor", "()I", "setColor", "(I)V", "commentId", "getCommentId", "setCommentId", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "createTime", "getCreateTime", "setCreateTime", "fromUser", "getFromUser", "setFromUser", "isBubble", "", "()Z", "setBubble", "(Z)V", "isEnhance", "setEnhance", "isSelf", "setSelf", "isStoryDeprecated", "setStoryDeprecated", "isUnread", "setUnread", "localId", "getLocalId", "setLocalId", "needShake", "getNeedShake", "setNeedShake", "replyCommentId", "getReplyCommentId", "setReplyCommentId", "state", "getState", "setState", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "storyOwner", "getStoryOwner", "setStoryOwner", "thumbUrl", "getThumbUrl", "setThumbUrl", "toUser", "getToUser", "setToUser", "toString", "plugin-story_release"})
public final class a
{
  public long cJA;
  private int color = -1;
  public String content = "";
  private String ctV = "";
  public String czp = "";
  public int fDT;
  public boolean sxA;
  public boolean sxB;
  String sxC = "";
  public int sxD;
  public boolean sxE;
  public int sxu;
  public boolean sxy;
  public boolean sxz;
  public String toUser = "";
  
  public a() {}
  
  public a(cgw paramcgw)
  {
    this();
    AppMethodBeat.i(109260);
    this.cJA = paramcgw.Id;
    this.fDT = paramcgw.CreateTime;
    this.sxu = paramcgw.xNY;
    String str = paramcgw.num;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.czp = ((String)localObject);
    str = paramcgw.ntu;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.content = ((String)localObject);
    localObject = (CharSequence)paramcgw.ntu;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      bool1 = true;
      this.sxz = bool1;
      if (paramcgw.xRH != 1) {
        break label181;
      }
    }
    label181:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.sxB = bool1;
      str = paramcgw.nul;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.toUser = ((String)localObject);
      this.sxD = paramcgw.xNX;
      AppMethodBeat.o(109260);
      return;
      bool1 = false;
      break;
    }
  }
  
  public a(cgx paramcgx)
  {
    this();
    AppMethodBeat.i(109261);
    this.cJA = paramcgx.cJA;
    String str = paramcgx.czp;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.czp = ((String)localObject);
    str = paramcgx.content;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.content = ((String)localObject);
    this.fDT = paramcgx.fDT;
    localObject = (CharSequence)paramcgx.content;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.sxz = bool;
      str = paramcgx.toUser;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.toUser = ((String)localObject);
      str = paramcgx.sxC;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.sxC = ((String)localObject);
      this.sxD = paramcgx.sxD;
      this.sxE = false;
      AppMethodBeat.o(109261);
      return;
    }
  }
  
  public final void adk(String paramString)
  {
    AppMethodBeat.i(138750);
    j.q(paramString, "<set-?>");
    this.sxC = paramString;
    AppMethodBeat.o(138750);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(109259);
    String str = "StoryCommentItem(fromUser='" + this.czp + "', content='" + this.content + "', createTime=" + this.fDT + ", commentId=" + this.sxu + ", isUnread=" + this.sxy + " )";
    AppMethodBeat.o(109259);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.b.a
 * JD-Core Version:    0.7.0.1
 */
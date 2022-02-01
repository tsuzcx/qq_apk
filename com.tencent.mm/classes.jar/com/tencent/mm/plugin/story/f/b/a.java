package com.tencent.mm.plugin.story.f.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cxy;
import com.tencent.mm.protocal.protobuf.cxz;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "", "commentDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "(Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;)V", "commentOp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;", "(Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;)V", "storyCommentItem", "(Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "()V", "color", "", "getColor", "()I", "setColor", "(I)V", "commentId", "getCommentId", "setCommentId", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "createTime", "getCreateTime", "setCreateTime", "fromUser", "getFromUser", "setFromUser", "isBubble", "", "()Z", "setBubble", "(Z)V", "isEnhance", "setEnhance", "isSelf", "setSelf", "isStoryDeprecated", "setStoryDeprecated", "isUnread", "setUnread", "localId", "getLocalId", "setLocalId", "needShake", "getNeedShake", "setNeedShake", "replyCommentId", "getReplyCommentId", "setReplyCommentId", "state", "getState", "setState", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "storyOwner", "getStoryOwner", "setStoryOwner", "thumbUrl", "getThumbUrl", "setThumbUrl", "toUser", "getToUser", "setToUser", "toString", "plugin-story_release"})
public final class a
{
  private int color = -1;
  public String content = "";
  public long dAu;
  private boolean diE;
  private String diQ = "";
  public String dpv = "";
  public int hgr;
  private int state;
  private String thumbUrl;
  public String toUser = "";
  public int ygE;
  public boolean ygI;
  public boolean ygJ;
  public boolean ygK;
  public boolean ygL;
  String ygM = "";
  public int ygN;
  public boolean ygO;
  
  public a() {}
  
  public a(a parama)
  {
    this();
    AppMethodBeat.i(118848);
    this.diE = parama.diE;
    this.dpv = parama.dpv;
    this.content = parama.content;
    this.hgr = parama.hgr;
    this.dAu = parama.dAu;
    this.thumbUrl = parama.thumbUrl;
    this.ygE = parama.ygE;
    this.diQ = parama.diQ;
    this.ygI = parama.ygI;
    this.color = parama.color;
    this.state = parama.state;
    this.ygJ = parama.ygJ;
    this.ygK = parama.ygK;
    this.ygL = parama.ygL;
    this.toUser = parama.toUser;
    this.ygM = parama.ygM;
    this.ygN = parama.ygN;
    this.ygO = parama.ygO;
    AppMethodBeat.o(118848);
  }
  
  public a(cxy paramcxy)
  {
    this();
    AppMethodBeat.i(118846);
    this.dAu = paramcxy.Id;
    this.hgr = paramcxy.CreateTime;
    this.ygE = paramcxy.Ema;
    String str = paramcxy.sdQ;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.dpv = ((String)localObject);
    str = paramcxy.gKr;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.content = ((String)localObject);
    localObject = (CharSequence)paramcxy.gKr;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      bool1 = true;
      this.ygJ = bool1;
      if (paramcxy.Eqb != 1) {
        break label181;
      }
    }
    label181:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.ygL = bool1;
      str = paramcxy.sdP;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.toUser = ((String)localObject);
      this.ygN = paramcxy.ElZ;
      AppMethodBeat.o(118846);
      return;
      bool1 = false;
      break;
    }
  }
  
  public a(cxz paramcxz)
  {
    this();
    AppMethodBeat.i(118847);
    this.dAu = paramcxz.dAu;
    String str = paramcxz.dpv;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.dpv = ((String)localObject);
    str = paramcxz.content;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.content = ((String)localObject);
    this.hgr = paramcxz.hgr;
    localObject = (CharSequence)paramcxz.content;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.ygJ = bool;
      str = paramcxz.toUser;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.toUser = ((String)localObject);
      str = paramcxz.ygM;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.ygM = ((String)localObject);
      this.ygN = paramcxz.ygN;
      this.ygO = false;
      AppMethodBeat.o(118847);
      return;
    }
  }
  
  public final void arC(String paramString)
  {
    AppMethodBeat.i(118844);
    k.h(paramString, "<set-?>");
    this.ygM = paramString;
    AppMethodBeat.o(118844);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118845);
    String str = "StoryCommentItem(fromUser='" + this.dpv + "', content='" + this.content + "', createTime=" + this.hgr + ", commentId=" + this.ygE + ", isUnread=" + this.ygI + " )";
    AppMethodBeat.o(118845);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.b.a
 * JD-Core Version:    0.7.0.1
 */
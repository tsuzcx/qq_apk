package com.tencent.mm.plugin.story.f.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ddk;
import com.tencent.mm.protocal.protobuf.ddl;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "", "commentDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "(Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;)V", "commentOp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;", "(Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;)V", "storyCommentItem", "(Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "()V", "color", "", "getColor", "()I", "setColor", "(I)V", "commentId", "getCommentId", "setCommentId", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "createTime", "getCreateTime", "setCreateTime", "fromUser", "getFromUser", "setFromUser", "isBubble", "", "()Z", "setBubble", "(Z)V", "isEnhance", "setEnhance", "isSelf", "setSelf", "isStoryDeprecated", "setStoryDeprecated", "isUnread", "setUnread", "localId", "getLocalId", "setLocalId", "needShake", "getNeedShake", "setNeedShake", "replyCommentId", "getReplyCommentId", "setReplyCommentId", "state", "getState", "setState", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "storyOwner", "getStoryOwner", "setStoryOwner", "thumbUrl", "getThumbUrl", "setThumbUrl", "toUser", "getToUser", "setToUser", "toString", "plugin-story_release"})
public final class a
{
  private int color = -1;
  public String content = "";
  private boolean dfZ;
  private String dgl = "";
  public String dng = "";
  public long dyg;
  public int hGU;
  private int state;
  private String thumbUrl;
  public String toUser = "";
  public int ztE;
  public boolean ztI;
  public boolean ztJ;
  public boolean ztK;
  public boolean ztL;
  String ztM = "";
  public int ztN;
  public boolean ztO;
  
  public a() {}
  
  public a(a parama)
  {
    this();
    AppMethodBeat.i(118848);
    this.dfZ = parama.dfZ;
    this.dng = parama.dng;
    this.content = parama.content;
    this.hGU = parama.hGU;
    this.dyg = parama.dyg;
    this.thumbUrl = parama.thumbUrl;
    this.ztE = parama.ztE;
    this.dgl = parama.dgl;
    this.ztI = parama.ztI;
    this.color = parama.color;
    this.state = parama.state;
    this.ztJ = parama.ztJ;
    this.ztK = parama.ztK;
    this.ztL = parama.ztL;
    this.toUser = parama.toUser;
    this.ztM = parama.ztM;
    this.ztN = parama.ztN;
    this.ztO = parama.ztO;
    AppMethodBeat.o(118848);
  }
  
  public a(ddk paramddk)
  {
    this();
    AppMethodBeat.i(118846);
    this.dyg = paramddk.Id;
    this.hGU = paramddk.CreateTime;
    this.ztE = paramddk.FIZ;
    String str = paramddk.tlK;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.dng = ((String)localObject);
    str = paramddk.hkR;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.content = ((String)localObject);
    localObject = (CharSequence)paramddk.hkR;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      bool1 = true;
      this.ztJ = bool1;
      if (paramddk.FNd != 1) {
        break label181;
      }
    }
    label181:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.ztL = bool1;
      str = paramddk.tlJ;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.toUser = ((String)localObject);
      this.ztN = paramddk.FIY;
      AppMethodBeat.o(118846);
      return;
      bool1 = false;
      break;
    }
  }
  
  public a(ddl paramddl)
  {
    this();
    AppMethodBeat.i(118847);
    this.dyg = paramddl.dyg;
    String str = paramddl.dng;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.dng = ((String)localObject);
    str = paramddl.content;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.content = ((String)localObject);
    this.hGU = paramddl.hGU;
    localObject = (CharSequence)paramddl.content;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.ztJ = bool;
      str = paramddl.toUser;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.toUser = ((String)localObject);
      str = paramddl.ztM;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.ztM = ((String)localObject);
      this.ztN = paramddl.ztN;
      this.ztO = false;
      AppMethodBeat.o(118847);
      return;
    }
  }
  
  public final void awL(String paramString)
  {
    AppMethodBeat.i(118844);
    k.h(paramString, "<set-?>");
    this.ztM = paramString;
    AppMethodBeat.o(118844);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118845);
    String str = "StoryCommentItem(fromUser='" + this.dng + "', content='" + this.content + "', createTime=" + this.hGU + ", commentId=" + this.ztE + ", isUnread=" + this.ztI + " )";
    AppMethodBeat.o(118845);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.b.a
 * JD-Core Version:    0.7.0.1
 */
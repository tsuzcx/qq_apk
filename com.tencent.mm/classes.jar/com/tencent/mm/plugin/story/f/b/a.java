package com.tencent.mm.plugin.story.f.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.diy;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "", "commentDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "(Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;)V", "commentOp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;", "(Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;)V", "storyCommentItem", "(Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "()V", "color", "", "getColor", "()I", "setColor", "(I)V", "commentId", "getCommentId", "setCommentId", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "createTime", "getCreateTime", "setCreateTime", "fromUser", "getFromUser", "setFromUser", "isBubble", "", "()Z", "setBubble", "(Z)V", "isEnhance", "setEnhance", "isSelf", "setSelf", "isStoryDeprecated", "setStoryDeprecated", "isUnread", "setUnread", "localId", "getLocalId", "setLocalId", "needShake", "getNeedShake", "setNeedShake", "replyCommentId", "getReplyCommentId", "setReplyCommentId", "state", "getState", "setState", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "storyOwner", "getStoryOwner", "setStoryOwner", "thumbUrl", "getThumbUrl", "setThumbUrl", "toUser", "getToUser", "setToUser", "toString", "plugin-story_release"})
public final class a
{
  public boolean ALC;
  public boolean ALD;
  public boolean ALE;
  public boolean ALF;
  String ALG = "";
  public int ALH;
  public boolean ALI;
  public int ALy;
  private int color = -1;
  public String content = "";
  public long dKt;
  private String drH = "";
  private boolean drv;
  public String dyU = "";
  public int hZE;
  private int state;
  private String thumbUrl;
  public String toUser = "";
  
  public a() {}
  
  public a(a parama)
  {
    this();
    AppMethodBeat.i(118848);
    this.drv = parama.drv;
    this.dyU = parama.dyU;
    this.content = parama.content;
    this.hZE = parama.hZE;
    this.dKt = parama.dKt;
    this.thumbUrl = parama.thumbUrl;
    this.ALy = parama.ALy;
    this.drH = parama.drH;
    this.ALC = parama.ALC;
    this.color = parama.color;
    this.state = parama.state;
    this.ALD = parama.ALD;
    this.ALE = parama.ALE;
    this.ALF = parama.ALF;
    this.toUser = parama.toUser;
    this.ALG = parama.ALG;
    this.ALH = parama.ALH;
    this.ALI = parama.ALI;
    AppMethodBeat.o(118848);
  }
  
  public a(dix paramdix)
  {
    this();
    AppMethodBeat.i(118846);
    this.dKt = paramdix.Id;
    this.hZE = paramdix.CreateTime;
    this.ALy = paramdix.HtH;
    String str = paramdix.ukj;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.dyU = ((String)localObject);
    str = paramdix.hDa;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.content = ((String)localObject);
    localObject = (CharSequence)paramdix.hDa;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      bool1 = true;
      this.ALD = bool1;
      if (paramdix.HxO != 1) {
        break label181;
      }
    }
    label181:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.ALF = bool1;
      str = paramdix.uki;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.toUser = ((String)localObject);
      this.ALH = paramdix.HtG;
      AppMethodBeat.o(118846);
      return;
      bool1 = false;
      break;
    }
  }
  
  public a(diy paramdiy)
  {
    this();
    AppMethodBeat.i(118847);
    this.dKt = paramdiy.dKt;
    String str = paramdiy.dyU;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.dyU = ((String)localObject);
    str = paramdiy.content;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.content = ((String)localObject);
    this.hZE = paramdiy.hZE;
    localObject = (CharSequence)paramdiy.content;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.ALD = bool;
      str = paramdiy.toUser;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.toUser = ((String)localObject);
      str = paramdiy.ALG;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.ALG = ((String)localObject);
      this.ALH = paramdiy.ALH;
      this.ALI = false;
      AppMethodBeat.o(118847);
      return;
    }
  }
  
  public final void aBP(String paramString)
  {
    AppMethodBeat.i(118844);
    p.h(paramString, "<set-?>");
    this.ALG = paramString;
    AppMethodBeat.o(118844);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118845);
    String str = "StoryCommentItem(fromUser='" + this.dyU + "', content='" + this.content + "', createTime=" + this.hZE + ", commentId=" + this.ALy + ", isUnread=" + this.ALC + " )";
    AppMethodBeat.o(118845);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.b.a
 * JD-Core Version:    0.7.0.1
 */
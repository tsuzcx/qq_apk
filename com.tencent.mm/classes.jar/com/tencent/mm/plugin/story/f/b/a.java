package com.tencent.mm.plugin.story.f.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.protocal.protobuf.djt;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "", "commentDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "(Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;)V", "commentOp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;", "(Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;)V", "storyCommentItem", "(Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "()V", "color", "", "getColor", "()I", "setColor", "(I)V", "commentId", "getCommentId", "setCommentId", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "createTime", "getCreateTime", "setCreateTime", "fromUser", "getFromUser", "setFromUser", "isBubble", "", "()Z", "setBubble", "(Z)V", "isEnhance", "setEnhance", "isSelf", "setSelf", "isStoryDeprecated", "setStoryDeprecated", "isUnread", "setUnread", "localId", "getLocalId", "setLocalId", "needShake", "getNeedShake", "setNeedShake", "replyCommentId", "getReplyCommentId", "setReplyCommentId", "state", "getState", "setState", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "storyOwner", "getStoryOwner", "setStoryOwner", "thumbUrl", "getThumbUrl", "setThumbUrl", "toUser", "getToUser", "setToUser", "toString", "plugin-story_release"})
public final class a
{
  public int Bdb;
  public boolean Bdf;
  public boolean Bdg;
  public boolean Bdh;
  public boolean Bdi;
  String Bdj = "";
  public int Bdk;
  public boolean Bdl;
  private int color = -1;
  public String content = "";
  public long dLI;
  private boolean dsB;
  private String dsN = "";
  public String dzZ = "";
  public int icw;
  private int state;
  private String thumbUrl;
  public String toUser = "";
  
  public a() {}
  
  public a(a parama)
  {
    this();
    AppMethodBeat.i(118848);
    this.dsB = parama.dsB;
    this.dzZ = parama.dzZ;
    this.content = parama.content;
    this.icw = parama.icw;
    this.dLI = parama.dLI;
    this.thumbUrl = parama.thumbUrl;
    this.Bdb = parama.Bdb;
    this.dsN = parama.dsN;
    this.Bdf = parama.Bdf;
    this.color = parama.color;
    this.state = parama.state;
    this.Bdg = parama.Bdg;
    this.Bdh = parama.Bdh;
    this.Bdi = parama.Bdi;
    this.toUser = parama.toUser;
    this.Bdj = parama.Bdj;
    this.Bdk = parama.Bdk;
    this.Bdl = parama.Bdl;
    AppMethodBeat.o(118848);
  }
  
  public a(djs paramdjs)
  {
    this();
    AppMethodBeat.i(118846);
    this.dLI = paramdjs.Id;
    this.icw = paramdjs.CreateTime;
    this.Bdb = paramdjs.HNk;
    String str = paramdjs.uvG;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.dzZ = ((String)localObject);
    str = paramdjs.hFS;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.content = ((String)localObject);
    localObject = (CharSequence)paramdjs.hFS;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      bool1 = true;
      this.Bdg = bool1;
      if (paramdjs.HRz != 1) {
        break label181;
      }
    }
    label181:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.Bdi = bool1;
      str = paramdjs.uvF;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.toUser = ((String)localObject);
      this.Bdk = paramdjs.HNj;
      AppMethodBeat.o(118846);
      return;
      bool1 = false;
      break;
    }
  }
  
  public a(djt paramdjt)
  {
    this();
    AppMethodBeat.i(118847);
    this.dLI = paramdjt.dLI;
    String str = paramdjt.dzZ;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.dzZ = ((String)localObject);
    str = paramdjt.content;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.content = ((String)localObject);
    this.icw = paramdjt.icw;
    localObject = (CharSequence)paramdjt.content;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.Bdg = bool;
      str = paramdjt.toUser;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.toUser = ((String)localObject);
      str = paramdjt.Bdj;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.Bdj = ((String)localObject);
      this.Bdk = paramdjt.Bdk;
      this.Bdl = false;
      AppMethodBeat.o(118847);
      return;
    }
  }
  
  public final void aDi(String paramString)
  {
    AppMethodBeat.i(118844);
    p.h(paramString, "<set-?>");
    this.Bdj = paramString;
    AppMethodBeat.o(118844);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118845);
    String str = "StoryCommentItem(fromUser='" + this.dzZ + "', content='" + this.content + "', createTime=" + this.icw + ", commentId=" + this.Bdb + ", isUnread=" + this.Bdf + " )";
    AppMethodBeat.o(118845);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.b.a
 * JD-Core Version:    0.7.0.1
 */
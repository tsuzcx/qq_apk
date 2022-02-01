package com.tencent.mm.plugin.story.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fie;
import com.tencent.mm.protocal.protobuf.fif;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "", "commentDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "(Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;)V", "commentOp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;", "(Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;)V", "storyCommentItem", "(Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "()V", "color", "", "getColor", "()I", "setColor", "(I)V", "commentId", "getCommentId", "setCommentId", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "createTime", "getCreateTime", "setCreateTime", "fromUser", "getFromUser", "setFromUser", "isBubble", "", "()Z", "setBubble", "(Z)V", "isEnhance", "setEnhance", "isSelf", "setSelf", "isStoryDeprecated", "setStoryDeprecated", "isUnread", "setUnread", "localId", "getLocalId", "setLocalId", "needShake", "getNeedShake", "setNeedShake", "replyCommentId", "getReplyCommentId", "setReplyCommentId", "state", "getState", "setState", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "storyOwner", "getStoryOwner", "setStoryOwner", "thumbUrl", "getThumbUrl", "setThumbUrl", "toUser", "getToUser", "setToUser", "toString", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public boolean SlA;
  public boolean SlB;
  String SlC = "";
  public int SlD;
  public boolean SlE;
  public int Slv;
  public boolean Sly;
  public boolean Slz;
  private int color = -1;
  public String content = "";
  public int createTime;
  private String hHB = "";
  private boolean hHq;
  public String hQQ = "";
  public long idH;
  private int state;
  private String thumbUrl;
  public String toUser = "";
  
  public a() {}
  
  public a(a parama)
  {
    this();
    AppMethodBeat.i(118848);
    this.hHq = parama.hHq;
    this.hQQ = parama.hQQ;
    this.content = parama.content;
    this.createTime = parama.createTime;
    this.idH = parama.idH;
    this.thumbUrl = parama.thumbUrl;
    this.Slv = parama.Slv;
    this.hHB = parama.hHB;
    this.Sly = parama.Sly;
    this.color = parama.color;
    this.state = parama.state;
    this.Slz = parama.Slz;
    this.SlA = parama.SlA;
    this.SlB = parama.SlB;
    this.toUser = parama.toUser;
    this.SlC = parama.SlC;
    this.SlD = parama.SlD;
    this.SlE = parama.SlE;
    AppMethodBeat.o(118848);
  }
  
  public a(fie paramfie)
  {
    this();
    AppMethodBeat.i(118846);
    this.idH = paramfie.Id;
    this.createTime = paramfie.CreateTime;
    this.Slv = paramfie.abDh;
    String str = paramfie.IMh;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.hQQ = ((String)localObject);
    str = paramfie.nUB;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.content = ((String)localObject);
    localObject = (CharSequence)paramfie.nUB;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      bool1 = true;
      this.Slz = bool1;
      if (paramfie.abIZ != 1) {
        break label181;
      }
    }
    label181:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.SlB = bool1;
      str = paramfie.IMg;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.toUser = ((String)localObject);
      this.SlD = paramfie.abDg;
      AppMethodBeat.o(118846);
      return;
      bool1 = false;
      break;
    }
  }
  
  public a(fif paramfif)
  {
    this();
    AppMethodBeat.i(118847);
    this.idH = paramfif.idH;
    String str = paramfif.hQQ;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.hQQ = ((String)localObject);
    str = paramfif.content;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.content = ((String)localObject);
    this.createTime = paramfif.createTime;
    localObject = (CharSequence)paramfif.content;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.Slz = bool;
      str = paramfif.toUser;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.toUser = ((String)localObject);
      str = paramfif.SlC;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.SlC = ((String)localObject);
      this.SlD = paramfif.SlD;
      this.SlE = false;
      AppMethodBeat.o(118847);
      return;
    }
  }
  
  public final void bbU(String paramString)
  {
    AppMethodBeat.i(118844);
    s.u(paramString, "<set-?>");
    this.SlC = paramString;
    AppMethodBeat.o(118844);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118845);
    String str = "StoryCommentItem(fromUser='" + this.hQQ + "', content='" + this.content + "', createTime=" + this.createTime + ", commentId=" + this.Slv + ", isUnread=" + this.Sly + " )";
    AppMethodBeat.o(118845);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.b.a
 * JD-Core Version:    0.7.0.1
 */
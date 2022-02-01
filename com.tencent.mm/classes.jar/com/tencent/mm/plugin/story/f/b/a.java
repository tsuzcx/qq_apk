package com.tencent.mm.plugin.story.f.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eng;
import com.tencent.mm.protocal.protobuf.enh;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "", "commentDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "(Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;)V", "commentOp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;", "(Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;)V", "storyCommentItem", "(Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "()V", "color", "", "getColor", "()I", "setColor", "(I)V", "commentId", "getCommentId", "setCommentId", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "createTime", "getCreateTime", "setCreateTime", "fromUser", "getFromUser", "setFromUser", "isBubble", "", "()Z", "setBubble", "(Z)V", "isEnhance", "setEnhance", "isSelf", "setSelf", "isStoryDeprecated", "setStoryDeprecated", "isUnread", "setUnread", "localId", "getLocalId", "setLocalId", "needShake", "getNeedShake", "setNeedShake", "replyCommentId", "getReplyCommentId", "setReplyCommentId", "state", "getState", "setState", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "storyOwner", "getStoryOwner", "setStoryOwner", "thumbUrl", "getThumbUrl", "setThumbUrl", "toUser", "getToUser", "setToUser", "toString", "plugin-story_release"})
public final class a
{
  public int LHU;
  public boolean LHX;
  public boolean LHY;
  public boolean LHZ;
  public boolean LIa;
  String LIb = "";
  public int LIc;
  public boolean LId;
  private int color = -1;
  public String content = "";
  public int createTime;
  private boolean fCB;
  private String fCM = "";
  public String fLi = "";
  public long fXG;
  private int state;
  private String thumbUrl;
  public String toUser = "";
  
  public a() {}
  
  public a(a parama)
  {
    this();
    AppMethodBeat.i(118848);
    this.fCB = parama.fCB;
    this.fLi = parama.fLi;
    this.content = parama.content;
    this.createTime = parama.createTime;
    this.fXG = parama.fXG;
    this.thumbUrl = parama.thumbUrl;
    this.LHU = parama.LHU;
    this.fCM = parama.fCM;
    this.LHX = parama.LHX;
    this.color = parama.color;
    this.state = parama.state;
    this.LHY = parama.LHY;
    this.LHZ = parama.LHZ;
    this.LIa = parama.LIa;
    this.toUser = parama.toUser;
    this.LIb = parama.LIb;
    this.LIc = parama.LIc;
    this.LId = parama.LId;
    AppMethodBeat.o(118848);
  }
  
  public a(eng parameng)
  {
    this();
    AppMethodBeat.i(118846);
    this.fXG = parameng.Id;
    this.createTime = parameng.CreateTime;
    this.LHU = parameng.Uln;
    String str = parameng.CRR;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.fLi = ((String)localObject);
    str = parameng.lpy;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.content = ((String)localObject);
    localObject = (CharSequence)parameng.lpy;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      bool1 = true;
      this.LHY = bool1;
      if (parameng.Uqa != 1) {
        break label181;
      }
    }
    label181:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.LIa = bool1;
      str = parameng.CRQ;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.toUser = ((String)localObject);
      this.LIc = parameng.Ulm;
      AppMethodBeat.o(118846);
      return;
      bool1 = false;
      break;
    }
  }
  
  public a(enh paramenh)
  {
    this();
    AppMethodBeat.i(118847);
    this.fXG = paramenh.fXG;
    String str = paramenh.fLi;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.fLi = ((String)localObject);
    str = paramenh.content;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.content = ((String)localObject);
    this.createTime = paramenh.createTime;
    localObject = (CharSequence)paramenh.content;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.LHY = bool;
      str = paramenh.toUser;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.toUser = ((String)localObject);
      str = paramenh.LIb;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.LIb = ((String)localObject);
      this.LIc = paramenh.LIc;
      this.LId = false;
      AppMethodBeat.o(118847);
      return;
    }
  }
  
  public final void bdh(String paramString)
  {
    AppMethodBeat.i(118844);
    p.k(paramString, "<set-?>");
    this.LIb = paramString;
    AppMethodBeat.o(118844);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118845);
    String str = "StoryCommentItem(fromUser='" + this.fLi + "', content='" + this.content + "', createTime=" + this.createTime + ", commentId=" + this.LHU + ", isUnread=" + this.LHX + " )";
    AppMethodBeat.o(118845);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.b.a
 * JD-Core Version:    0.7.0.1
 */
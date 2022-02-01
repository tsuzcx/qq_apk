package com.tencent.mm.plugin.story.f.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.edf;
import com.tencent.mm.protocal.protobuf.edg;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "", "commentDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "(Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;)V", "commentOp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;", "(Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;)V", "storyCommentItem", "(Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "()V", "color", "", "getColor", "()I", "setColor", "(I)V", "commentId", "getCommentId", "setCommentId", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "createTime", "getCreateTime", "setCreateTime", "fromUser", "getFromUser", "setFromUser", "isBubble", "", "()Z", "setBubble", "(Z)V", "isEnhance", "setEnhance", "isSelf", "setSelf", "isStoryDeprecated", "setStoryDeprecated", "isUnread", "setUnread", "localId", "getLocalId", "setLocalId", "needShake", "getNeedShake", "setNeedShake", "replyCommentId", "getReplyCommentId", "setReplyCommentId", "state", "getState", "setState", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "storyOwner", "getStoryOwner", "setStoryOwner", "thumbUrl", "getThumbUrl", "setThumbUrl", "toUser", "getToUser", "setToUser", "toString", "plugin-story_release"})
public final class a
{
  public int FnS;
  public boolean FnW;
  public boolean FnX;
  public boolean FnY;
  public boolean FnZ;
  String Foa = "";
  public int Fob;
  public boolean Foc;
  private int color = -1;
  public String content = "";
  private boolean dJM;
  private String dJX = "";
  public String dRL = "";
  public long edx;
  public int iXu;
  private int state;
  private String thumbUrl;
  public String toUser = "";
  
  public a() {}
  
  public a(a parama)
  {
    this();
    AppMethodBeat.i(118848);
    this.dJM = parama.dJM;
    this.dRL = parama.dRL;
    this.content = parama.content;
    this.iXu = parama.iXu;
    this.edx = parama.edx;
    this.thumbUrl = parama.thumbUrl;
    this.FnS = parama.FnS;
    this.dJX = parama.dJX;
    this.FnW = parama.FnW;
    this.color = parama.color;
    this.state = parama.state;
    this.FnX = parama.FnX;
    this.FnY = parama.FnY;
    this.FnZ = parama.FnZ;
    this.toUser = parama.toUser;
    this.Foa = parama.Foa;
    this.Fob = parama.Fob;
    this.Foc = parama.Foc;
    AppMethodBeat.o(118848);
  }
  
  public a(edf paramedf)
  {
    this();
    AppMethodBeat.i(118846);
    this.edx = paramedf.Id;
    this.iXu = paramedf.CreateTime;
    this.FnS = paramedf.MYT;
    String str = paramedf.xNH;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.dRL = ((String)localObject);
    str = paramedf.iAc;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.content = ((String)localObject);
    localObject = (CharSequence)paramedf.iAc;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      bool1 = true;
      this.FnX = bool1;
      if (paramedf.NdD != 1) {
        break label181;
      }
    }
    label181:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.FnZ = bool1;
      str = paramedf.xNG;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.toUser = ((String)localObject);
      this.Fob = paramedf.MYS;
      AppMethodBeat.o(118846);
      return;
      bool1 = false;
      break;
    }
  }
  
  public a(edg paramedg)
  {
    this();
    AppMethodBeat.i(118847);
    this.edx = paramedg.edx;
    String str = paramedg.dRL;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.dRL = ((String)localObject);
    str = paramedg.content;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.content = ((String)localObject);
    this.iXu = paramedg.iXu;
    localObject = (CharSequence)paramedg.content;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.FnX = bool;
      str = paramedg.toUser;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.toUser = ((String)localObject);
      str = paramedg.Foa;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      this.Foa = ((String)localObject);
      this.Fob = paramedg.Fob;
      this.Foc = false;
      AppMethodBeat.o(118847);
      return;
    }
  }
  
  public final void aSd(String paramString)
  {
    AppMethodBeat.i(118844);
    p.h(paramString, "<set-?>");
    this.Foa = paramString;
    AppMethodBeat.o(118844);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118845);
    String str = "StoryCommentItem(fromUser='" + this.dRL + "', content='" + this.content + "', createTime=" + this.iXu + ", commentId=" + this.FnS + ", isUnread=" + this.FnW + " )";
    AppMethodBeat.o(118845);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.b.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.chatting.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$ChattingStatInfo;", "", "sessionId", "", "chatName", "chatType", "", "chatRoomUserCountOnEnter", "(Ljava/lang/String;Ljava/lang/String;II)V", "getChatName", "()Ljava/lang/String;", "getChatRoomUserCountOnEnter", "()I", "getChatType", "enterTime", "", "getEnterTime", "()J", "<set-?>", "exitTime", "getExitTime", "getSessionId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "markExitChatting", "", "toString", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
final class c$a$h
{
  long GdW;
  final int aeoQ;
  final int chatType;
  private final long enterTime;
  final String lxj;
  final String sessionId;
  
  public c$a$h(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255931);
    this.sessionId = paramString1;
    this.lxj = paramString2;
    this.chatType = paramInt1;
    this.aeoQ = paramInt2;
    this.enterTime = System.currentTimeMillis();
    this.GdW = -1L;
    AppMethodBeat.o(255931);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(255946);
    if (this == paramObject)
    {
      AppMethodBeat.o(255946);
      return true;
    }
    if (!(paramObject instanceof h))
    {
      AppMethodBeat.o(255946);
      return false;
    }
    paramObject = (h)paramObject;
    if (!s.p(this.sessionId, paramObject.sessionId))
    {
      AppMethodBeat.o(255946);
      return false;
    }
    if (!s.p(this.lxj, paramObject.lxj))
    {
      AppMethodBeat.o(255946);
      return false;
    }
    if (this.chatType != paramObject.chatType)
    {
      AppMethodBeat.o(255946);
      return false;
    }
    if (this.aeoQ != paramObject.aeoQ)
    {
      AppMethodBeat.o(255946);
      return false;
    }
    AppMethodBeat.o(255946);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(255945);
    int i = this.sessionId.hashCode();
    int j = this.lxj.hashCode();
    int k = this.chatType;
    int m = this.aeoQ;
    AppMethodBeat.o(255945);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(255939);
    String str = "ChattingStatInfo(sessionId='" + this.sessionId + "', chatName='" + this.lxj + "', chatType=" + this.chatType + ", chatRoomUserCountOnEnter=" + this.aeoQ + ", enterTime=" + this.enterTime + ", exitTime=" + this.GdW + ')';
    AppMethodBeat.o(255939);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.c.a.h
 * JD-Core Version:    0.7.0.1
 */
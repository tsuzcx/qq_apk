package com.tencent.mm.plugin.textstatus.h.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/data/TextStatusNotifyShowInfo$NewMsgInfo;", "", "sessionId", "", "(Ljava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$b
{
  final String sessionId;
  
  public a$b(String paramString)
  {
    this.sessionId = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(290614);
    if (this == paramObject)
    {
      AppMethodBeat.o(290614);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(290614);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.sessionId, paramObject.sessionId))
    {
      AppMethodBeat.o(290614);
      return false;
    }
    AppMethodBeat.o(290614);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(290604);
    if (this.sessionId == null)
    {
      AppMethodBeat.o(290604);
      return 0;
    }
    int i = this.sessionId.hashCode();
    AppMethodBeat.o(290604);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(290592);
    String str = "NewMsgInfo(sessionId=" + this.sessionId + ')';
    AppMethodBeat.o(290592);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.b.a.b
 * JD-Core Version:    0.7.0.1
 */
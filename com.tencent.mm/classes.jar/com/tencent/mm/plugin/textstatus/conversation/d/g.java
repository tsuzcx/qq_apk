package com.tencent.mm.plugin.textstatus.conversation.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.j.f;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusSessionInfo;", "Lcom/tencent/mm/plugin/textstatus/storage/BaseTextStatusSessionInfo;", "Lcom/tencent/mm/plugin/textstatus/api/ITextStatusSessionInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getSessionId", "", "getTalker", "toString", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends f
{
  public static final a Tji;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(290928);
    Tji = new a((byte)0);
    info = f.aJm();
    AppMethodBeat.o(290928);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(290939);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    s.s(localMAutoDBInfo, "info");
    AppMethodBeat.o(290939);
    return localMAutoDBInfo;
  }
  
  public final String toString()
  {
    return "";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusSessionInfo$Companion;", "", "()V", "TAG", "", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.d.g
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.storage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.cg;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/file/FileMsgInfo;", "Lcom/tencent/mm/autogen/table/BaseFileMsgInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-messenger-foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends cg
{
  public static final a admO;
  private static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(248860);
    admO = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = cg.aJm();
    s.s(localMAutoDBInfo, "initAutoDBInfo(FileMsgInfo::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(248860);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/file/FileMsgInfo$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "setInfo", "(Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;)V", "plugin-messenger-foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.a.a
 * JD-Core Version:    0.7.0.1
 */
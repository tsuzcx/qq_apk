package com.tencent.mm.storage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.cd;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/storage/file/FileMsgInfo;", "Lcom/tencent/mm/autogen/table/BaseFileMsgInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-messenger-foundation_release"})
public final class a
  extends cd
{
  public static final a.a VIQ;
  private static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(188256);
    VIQ = new a.a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = cd.aoY();
    p.j(localMAutoDBInfo, "BaseFileMsgInfo.initAuto…(FileMsgInfo::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(188256);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.a.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.textstatus.g.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.aa;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"toTextStatusItem", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusHistory;", "plugin-textstatus_release"})
public final class b
{
  public static final com.tencent.mm.plugin.textstatus.g.e.a a(aa paramaa)
  {
    AppMethodBeat.i(237373);
    p.k(paramaa, "$this$toTextStatusItem");
    com.tencent.mm.plugin.textstatus.g.e.a locala = new com.tencent.mm.plugin.textstatus.g.e.a();
    locala.field_UserName = com.tencent.mm.plugin.auth.a.a.crN();
    locala.field_StatusID = paramaa.MEN;
    TextStatusExtInfo localTextStatusExtInfo = new TextStatusExtInfo();
    try
    {
      localTextStatusExtInfo.parseFrom(Base64.decode(paramaa.MFj, 0));
      f localf = f.MAm;
      f.a(locala, localTextStatusExtInfo);
      AppMethodBeat.o(237373);
      return locala;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.printErrStackTrace("TextStatusHistory", localThrowable, "parse TextStatusHistory err id" + paramaa.MEN, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.a.b
 * JD-Core Version:    0.7.0.1
 */
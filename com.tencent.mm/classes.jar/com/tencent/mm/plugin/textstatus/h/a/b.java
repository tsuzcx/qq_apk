package com.tencent.mm.plugin.textstatus.h.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.auth.a.a;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.an;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"toTextStatusItem", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusHistory;", "plugin-textstatus_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final com.tencent.mm.plugin.textstatus.h.f.b a(an paraman)
  {
    AppMethodBeat.i(290430);
    s.u(paraman, "<this>");
    com.tencent.mm.plugin.textstatus.h.f.b localb = new com.tencent.mm.plugin.textstatus.h.f.b();
    localb.field_UserName = a.cUx();
    localb.field_StatusID = paraman.ToK;
    TextStatusExtInfo localTextStatusExtInfo = new TextStatusExtInfo();
    try
    {
      localTextStatusExtInfo.parseFrom(Base64.decode(paraman.ext_info, 0));
      f localf = f.TjQ;
      f.a(localb, localTextStatusExtInfo);
      AppMethodBeat.o(290430);
      return localb;
    }
    finally
    {
      for (;;)
      {
        Log.printErrStackTrace("TextStatusHistory", localThrowable, s.X("parse TextStatusHistory err id", paraman.ToK), new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.a.b
 * JD-Core Version:    0.7.0.1
 */
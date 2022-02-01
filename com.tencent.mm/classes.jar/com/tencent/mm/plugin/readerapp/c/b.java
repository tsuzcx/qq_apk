package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.model.br;
import com.tencent.mm.model.v;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class b
{
  public static boolean a(cw paramcw, br parambr)
  {
    AppMethodBeat.i(102661);
    if ((paramcw == null) || (parambr == null))
    {
      ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or readerAppInfo is null");
      if (paramcw != null) {
        paramcw.doL.doQ = 2131758885;
      }
      AppMethodBeat.o(102661);
      return false;
    }
    akn localakn = new akn();
    akt localakt = new akt();
    ajx localajx = new ajx();
    localakt.aQC("newsapp");
    localakt.aQD(v.aAC());
    localakt.aQD(v.aAC());
    localakt.aax(1);
    localakt.Dk(parambr.hKz);
    localakt.aQG(parambr.hKE);
    localakt.aQJ(parambr.getUrl());
    localakt.aQK("newsapp");
    localajx.aPI(parambr.getUrl());
    localajx.aPC(parambr.getTitle());
    localajx.aPD(parambr.getDigest());
    localajx.aPL(parambr.aCF());
    localajx.ws(true);
    localajx.wt(true);
    localajx.aao(5);
    localakn.a(localakt);
    localakn.oeJ.add(localajx);
    paramcw.doL.desc = parambr.getTitle();
    paramcw.doL.doN = localakn;
    paramcw.doL.type = 5;
    AppMethodBeat.o(102661);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.b
 * JD-Core Version:    0.7.0.1
 */
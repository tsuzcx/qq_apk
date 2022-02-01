package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class b
{
  public static boolean a(cv paramcv, bp parambp)
  {
    AppMethodBeat.i(102661);
    if ((paramcv == null) || (parambp == null))
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or readerAppInfo is null");
      if (paramcv != null) {
        paramcv.dnG.dnL = 2131758885;
      }
      AppMethodBeat.o(102661);
      return false;
    }
    akd localakd = new akd();
    akj localakj = new akj();
    ajn localajn = new ajn();
    localakj.aPf("newsapp");
    localakj.aPg(u.aAm());
    localakj.aPg(u.aAm());
    localakj.ZR(1);
    localakj.CM(parambp.hHH);
    localakj.aPj(parambp.hHM);
    localakj.aPm(parambp.getUrl());
    localakj.aPn("newsapp");
    localajn.aOl(parambp.getUrl());
    localajn.aOf(parambp.getTitle());
    localajn.aOg(parambp.getDigest());
    localajn.aOo(parambp.aCp());
    localajn.wk(true);
    localajn.wl(true);
    localajn.ZI(5);
    localakd.a(localakj);
    localakd.nZa.add(localajn);
    paramcv.dnG.desc = parambp.getTitle();
    paramcv.dnG.dnI = localakd;
    paramcv.dnG.type = 5;
    AppMethodBeat.o(102661);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.b
 * JD-Core Version:    0.7.0.1
 */
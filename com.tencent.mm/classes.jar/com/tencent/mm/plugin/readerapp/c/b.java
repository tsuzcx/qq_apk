package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

public final class b
{
  public static boolean a(cm paramcm, bl parambl)
  {
    AppMethodBeat.i(141043);
    if ((paramcm == null) || (parambl == null))
    {
      ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or readerAppInfo is null");
      if (paramcm != null) {
        paramcm.cpR.cpX = 2131299713;
      }
      AppMethodBeat.o(141043);
      return false;
    }
    acq localacq = new acq();
    acw localacw = new acw();
    aca localaca = new aca();
    localacw.aon("newsapp");
    localacw.aoo(r.Zn());
    localacw.aoo(r.Zn());
    localacw.MR(1);
    localacw.nI(parambl.fno);
    localacw.aor(parambl.fnt);
    localacw.aou(parambl.getUrl());
    localacw.aov("newsapp");
    localaca.anI(String.valueOf(parambl.fnt));
    Object localObject = p.aln(parambl.aaZ());
    if (e.cN((String)localObject)) {
      localaca.anF((String)localObject);
    }
    for (;;)
    {
      localaca.MI(5);
      localaca.anq(parambl.getTitle());
      localaca.anr(parambl.getDigest());
      localaca.py(true);
      localacq.a(localacw);
      localacq.wVc.add(localaca);
      paramcm.cpR.desc = parambl.getTitle();
      paramcm.cpR.cpT = localacq;
      paramcm.cpR.type = 5;
      AppMethodBeat.o(141043);
      return true;
      localaca.pz(true);
      localaca.anz(parambl.aaZ());
      localObject = new adf();
      ((adf)localObject).aoD(parambl.aaZ());
      localacq.b((adf)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.b
 * JD-Core Version:    0.7.0.1
 */
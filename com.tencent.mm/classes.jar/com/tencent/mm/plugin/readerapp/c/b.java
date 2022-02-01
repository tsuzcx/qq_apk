package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.readerapp.a.h;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class b
{
  public static boolean a(dd paramdd, bw parambw)
  {
    AppMethodBeat.i(102661);
    if ((paramdd == null) || (parambw == null))
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or readerAppInfo is null");
      if (paramdd != null) {
        paramdd.fyI.fyO = a.h.favorite_fail_argument_error;
      }
      AppMethodBeat.o(102661);
      return false;
    }
    aoc localaoc = new aoc();
    aoi localaoi = new aoi();
    anm localanm = new anm();
    localaoi.btx("newsapp");
    localaoi.bty(z.bcZ());
    localaoi.bty(z.bcZ());
    localaoi.arz(1);
    localaoi.Ue(parambw.lvp);
    localaoi.btB(parambw.lvs);
    localaoi.btE(parambw.getUrl());
    localaoi.btF("newsapp");
    localanm.bsD(parambw.getUrl());
    localanm.bsx(parambw.getTitle());
    localanm.bsy(parambw.getDigest());
    localanm.bsG(parambw.bfg());
    localanm.Ex(true);
    localanm.Ey(true);
    localanm.arq(5);
    localaoc.a(localaoi);
    localaoc.syG.add(localanm);
    paramdd.fyI.desc = parambw.getTitle();
    paramdd.fyI.fyK = localaoc;
    paramdd.fyI.type = 5;
    AppMethodBeat.o(102661);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class b
{
  public static boolean a(cz paramcz, bv parambv)
  {
    AppMethodBeat.i(102661);
    if ((paramcz == null) || (parambv == null))
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or readerAppInfo is null");
      if (paramcz != null) {
        paramcz.dFZ.dGe = 2131759209;
      }
      AppMethodBeat.o(102661);
      return false;
    }
    anb localanb = new anb();
    anh localanh = new anh();
    aml localaml = new aml();
    localanh.bhf("newsapp");
    localanh.bhg(z.aTY());
    localanh.bhg(z.aTY());
    localanh.ajm(1);
    localanh.MA(parambv.iFn);
    localanh.bhj(parambv.iFs);
    localanh.bhm(parambv.getUrl());
    localanh.bhn("newsapp");
    localaml.bgl(parambv.getUrl());
    localaml.bgf(parambv.getTitle());
    localaml.bgg(parambv.getDigest());
    localaml.bgo(parambv.aWd());
    localaml.As(true);
    localaml.At(true);
    localaml.ajd(5);
    localanb.a(localanh);
    localanb.ppH.add(localaml);
    paramcz.dFZ.desc = parambv.getTitle();
    paramcz.dFZ.dGb = localanb;
    paramcz.dFZ.type = 5;
    AppMethodBeat.o(102661);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.b
 * JD-Core Version:    0.7.0.1
 */
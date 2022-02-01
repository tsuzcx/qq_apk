package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class b
{
  public static boolean a(cs paramcs, bo parambo)
  {
    AppMethodBeat.i(102661);
    if ((paramcs == null) || (parambo == null))
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or readerAppInfo is null");
      if (paramcs != null) {
        paramcs.deQ.deV = 2131758885;
      }
      AppMethodBeat.o(102661);
      return false;
    }
    ago localago = new ago();
    agu localagu = new agu();
    afy localafy = new afy();
    localagu.aEl("newsapp");
    localagu.aEm(u.aqG());
    localagu.aEm(u.aqG());
    localagu.VM(1);
    localagu.vv(parambo.gOP);
    localagu.aEp(parambo.gOU);
    localagu.aEs(parambo.getUrl());
    localagu.aEt("newsapp");
    localafy.aDr(parambo.getUrl());
    localafy.aDl(parambo.getTitle());
    localafy.aDm(parambo.getDigest());
    localafy.aDu(parambo.asu());
    localafy.uw(true);
    localafy.ux(true);
    localafy.VD(5);
    localago.a(localagu);
    localago.mVb.add(localafy);
    paramcs.deQ.desc = parambo.getTitle();
    paramcs.deQ.deS = localago;
    paramcs.deQ.type = 5;
    AppMethodBeat.o(102661);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.b
 * JD-Core Version:    0.7.0.1
 */
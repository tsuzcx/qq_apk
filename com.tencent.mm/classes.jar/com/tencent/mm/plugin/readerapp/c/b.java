package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class b
{
  public static boolean a(cs paramcs, bo parambo)
  {
    AppMethodBeat.i(102661);
    if ((paramcs == null) || (parambo == null))
    {
      ac.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or readerAppInfo is null");
      if (paramcs != null) {
        paramcs.dck.dcp = 2131758885;
      }
      AppMethodBeat.o(102661);
      return false;
    }
    ahn localahn = new ahn();
    aht localaht = new aht();
    agx localagx = new agx();
    localaht.aJC("newsapp");
    localaht.aJD(u.axw());
    localaht.aJD(u.axw());
    localaht.XV(1);
    localaht.zY(parambo.hpp);
    localaht.aJG(parambo.hpu);
    localaht.aJJ(parambo.getUrl());
    localaht.aJK("newsapp");
    localagx.aII(parambo.getUrl());
    localagx.aIC(parambo.getTitle());
    localagx.aID(parambo.getDigest());
    localagx.aIL(parambo.azl());
    localagx.vy(true);
    localagx.vz(true);
    localagx.XM(5);
    localahn.a(localaht);
    localahn.nxC.add(localagx);
    paramcs.dck.desc = parambo.getTitle();
    paramcs.dck.dcm = localahn;
    paramcs.dck.type = 5;
    AppMethodBeat.o(102661);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.b
 * JD-Core Version:    0.7.0.1
 */
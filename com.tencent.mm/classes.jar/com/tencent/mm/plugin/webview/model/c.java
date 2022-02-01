package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.y;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class c
{
  public static boolean a(cs paramcs, y paramy)
  {
    AppMethodBeat.i(78838);
    if (paramy == null)
    {
      ac.w("MicroMsg.GetFavDataSource", "fillMpVideoEventInfo mpMsgItem is null");
      AppMethodBeat.o(78838);
      return false;
    }
    ahn localahn = new ahn();
    Object localObject = new aht();
    ((aht)localObject).aJC(u.axw());
    ((aht)localObject).aJD(u.axw());
    ((aht)localObject).XV(4);
    ((aht)localObject).zY(bs.eWj());
    ((aht)localObject).aJJ(paramy.url);
    localahn.a((aht)localObject);
    localObject = new agx();
    ((agx)localObject).aIQ("");
    ((agx)localObject).aIL(paramy.hld);
    ((agx)localObject).aIU(ah.dg(paramy.DWG + paramy.DWF));
    ((agx)localObject).XL(paramy.videoDuration);
    ((agx)localObject).aIC(paramy.title);
    ((agx)localObject).aII(paramy.url);
    ((agx)localObject).vy(true);
    ((agx)localObject).vz(true);
    ahf localahf = new ahf();
    localahf.hhd = paramy.DWG;
    localahf.videoUrl = paramy.videoUrl;
    localahf.DWF = paramy.DWF;
    localahf.ddo = paramy.ddo;
    localahf.hkV = paramy.hkV;
    localahf.hld = paramy.hld;
    localahf.videoWidth = paramy.width;
    localahf.videoHeight = paramy.height;
    localahf.duration = paramy.videoDuration;
    paramy = new agy();
    paramy.e(localahf);
    ((agx)localObject).a(paramy);
    paramy = new LinkedList();
    paramy.add(localObject);
    localahn.bk(paramy);
    paramcs.dck.dcm = localahn;
    paramcs.dck.type = 4;
    ((agx)localObject).XM(4);
    AppMethodBeat.o(78838);
    return true;
  }
  
  public static boolean a(cs paramcs, c.a parama)
  {
    AppMethodBeat.i(78837);
    if (!parama.valid())
    {
      ac.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or wrapper is invalid");
      paramcs.dck.dcp = 2131758885;
      AppMethodBeat.o(78837);
      return false;
    }
    ahn localahn = new ahn();
    aht localaht = new aht();
    agx localagx = new agx();
    localagx.aII(parama.url);
    localagx.aIC(parama.title);
    localagx.aID(parama.desc);
    localagx.aIL(parama.thumbUrl);
    localagx.aJa(parama.dvs);
    localagx.vy(true);
    localagx.vz(true);
    localagx.XM(5);
    aic localaic = new aic();
    localaic.aJS(parama.thumbUrl);
    localaic.aJP(parama.title);
    localaic.aJQ(parama.desc);
    localahn.b(localaic);
    localahn.f(parama.CoY);
    localaht.aJC(u.axw());
    localaht.aJD(u.axw());
    localaht.XV(3);
    localaht.zY(bs.eWj());
    localaht.aJI(parama.djj);
    localaht.aJJ(parama.url);
    paramcs.dck.title = localagx.title;
    paramcs.dck.dcm = localahn;
    paramcs.dck.type = 5;
    localahn.a(localaht);
    localahn.nxC.add(localagx);
    AppMethodBeat.o(78837);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.c
 * JD-Core Version:    0.7.0.1
 */
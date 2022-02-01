package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.y;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class c
{
  public static boolean a(cs paramcs, y paramy)
  {
    AppMethodBeat.i(78838);
    if (paramy == null)
    {
      ad.w("MicroMsg.GetFavDataSource", "fillMpVideoEventInfo mpMsgItem is null");
      AppMethodBeat.o(78838);
      return false;
    }
    ago localago = new ago();
    Object localObject = new agu();
    ((agu)localObject).aEl(u.aqG());
    ((agu)localObject).aEm(u.aqG());
    ((agu)localObject).VM(4);
    ((agu)localObject).vv(bt.eGO());
    ((agu)localObject).aEs(paramy.url);
    localago.a((agu)localObject);
    localObject = new afy();
    ((afy)localObject).aDz("");
    ((afy)localObject).aDu(paramy.gKD);
    ((afy)localObject).aDD(ai.du(paramy.CEg + paramy.CEf));
    ((afy)localObject).VC(paramy.videoDuration);
    ((afy)localObject).aDl(paramy.title);
    ((afy)localObject).aDr(paramy.url);
    ((afy)localObject).uw(true);
    ((afy)localObject).ux(true);
    agg localagg = new agg();
    localagg.gGC = paramy.CEg;
    localagg.videoUrl = paramy.videoUrl;
    localagg.CEf = paramy.CEf;
    localagg.dfT = paramy.dfT;
    localagg.gKv = paramy.gKv;
    localagg.gKD = paramy.gKD;
    localagg.videoWidth = paramy.width;
    localagg.videoHeight = paramy.height;
    localagg.duration = paramy.videoDuration;
    paramy = new afz();
    paramy.e(localagg);
    ((afy)localObject).a(paramy);
    paramy = new LinkedList();
    paramy.add(localObject);
    localago.bd(paramy);
    paramcs.deQ.deS = localago;
    paramcs.deQ.type = 4;
    ((afy)localObject).VD(4);
    AppMethodBeat.o(78838);
    return true;
  }
  
  public static boolean a(cs paramcs, c.a parama)
  {
    AppMethodBeat.i(78837);
    if (!parama.valid())
    {
      ad.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or wrapper is invalid");
      paramcs.deQ.deV = 2131758885;
      AppMethodBeat.o(78837);
      return false;
    }
    ago localago = new ago();
    agu localagu = new agu();
    afy localafy = new afy();
    localafy.aDr(parama.url);
    localafy.aDl(parama.title);
    localafy.aDm(parama.desc);
    localafy.aDu(parama.thumbUrl);
    localafy.aDJ(parama.dxG);
    localafy.uw(true);
    localafy.ux(true);
    localafy.VD(5);
    ahd localahd = new ahd();
    localahd.aEB(parama.thumbUrl);
    localahd.aEy(parama.title);
    localahd.aEz(parama.desc);
    localago.b(localahd);
    localago.f(parama.AWL);
    localagu.aEl(u.aqG());
    localagu.aEm(u.aqG());
    localagu.VM(3);
    localagu.vv(bt.eGO());
    localagu.aEr(parama.dlB);
    localagu.aEs(parama.url);
    paramcs.deQ.title = localafy.title;
    paramcs.deQ.deS = localago;
    paramcs.deQ.type = 5;
    localago.a(localagu);
    localago.mVb.add(localafy);
    AppMethodBeat.o(78837);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.c
 * JD-Core Version:    0.7.0.1
 */
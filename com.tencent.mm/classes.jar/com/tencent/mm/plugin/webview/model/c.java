package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.model.v;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class c
{
  public static boolean a(cw paramcw, c.a parama)
  {
    AppMethodBeat.i(78837);
    if (!parama.valid())
    {
      ae.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or wrapper is invalid");
      paramcw.doL.doQ = 2131758885;
      AppMethodBeat.o(78837);
      return false;
    }
    akn localakn = new akn();
    akt localakt = new akt();
    ajx localajx = new ajx();
    localajx.aPI(parama.url);
    localajx.aPC(parama.title);
    localajx.aPD(parama.desc);
    localajx.aPL(parama.thumbUrl);
    localajx.aQa(parama.dIA);
    localajx.ws(true);
    localajx.wt(true);
    localajx.aao(5);
    alc localalc = new alc();
    localalc.aQS(parama.thumbUrl);
    localalc.aQP(parama.title);
    localalc.aQQ(parama.desc);
    localakn.b(localalc);
    localakn.f(parama.Ekw);
    localakt.aQC(v.aAC());
    localakt.aQD(v.aAC());
    localakt.aax(3);
    localakt.Dk(bu.fpO());
    localakt.aQI(parama.dwb);
    localakt.aQJ(parama.url);
    paramcw.doL.title = localajx.title;
    paramcw.doL.doN = localakn;
    paramcw.doL.type = 5;
    localakn.a(localakt);
    localakn.oeJ.add(localajx);
    AppMethodBeat.o(78837);
    return true;
  }
  
  public static boolean a(cw paramcw, jb paramjb)
  {
    AppMethodBeat.i(198112);
    if (paramjb == null)
    {
      ae.w("MicroMsg.GetFavDataSource", "fillMpVideoEventInfo mpMsgItem is null");
      AppMethodBeat.o(198112);
      return false;
    }
    akn localakn = new akn();
    Object localObject = new akt();
    ((akt)localObject).aQC(v.aAC());
    ((akt)localObject).aQD(v.aAC());
    ((akt)localObject).aax(4);
    ((akt)localObject).Dk(bu.fpO());
    ((akt)localObject).aQJ(paramjb.url);
    localakn.a((akt)localObject);
    localObject = new ajx();
    ((ajx)localObject).aPQ("");
    ((ajx)localObject).aPL(paramjb.hGe);
    ((ajx)localObject).aPU(aj.ej(paramjb.FUx + paramjb.FUw));
    ((ajx)localObject).aan(paramjb.videoDuration);
    ((ajx)localObject).aPC(paramjb.title);
    ((ajx)localObject).aPI(paramjb.url);
    ((ajx)localObject).ws(true);
    ((ajx)localObject).wt(true);
    akf localakf = new akf();
    localakf.hCa = paramjb.FUx;
    localakf.videoUrl = paramjb.videoUrl;
    localakf.FUw = paramjb.FUw;
    localakf.dpP = paramjb.dpP;
    localakf.hFW = paramjb.hFW;
    localakf.hGe = paramjb.hGe;
    localakf.videoWidth = paramjb.width;
    localakf.videoHeight = paramjb.height;
    localakf.duration = paramjb.videoDuration;
    paramjb = new ajy();
    paramjb.e(localakf);
    ((ajx)localObject).a(paramjb);
    paramjb = new LinkedList();
    paramjb.add(localObject);
    localakn.bm(paramjb);
    paramcw.doL.doN = localakn;
    paramcw.doL.type = 4;
    ((ajx)localObject).aao(4);
    AppMethodBeat.o(198112);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.c
 * JD-Core Version:    0.7.0.1
 */
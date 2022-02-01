package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class c
{
  public static boolean a(cv paramcv, c.a parama)
  {
    AppMethodBeat.i(78837);
    if (!parama.valid())
    {
      ad.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or wrapper is invalid");
      paramcv.dnG.dnL = 2131758885;
      AppMethodBeat.o(78837);
      return false;
    }
    akd localakd = new akd();
    akj localakj = new akj();
    ajn localajn = new ajn();
    localajn.aOl(parama.url);
    localajn.aOf(parama.title);
    localajn.aOg(parama.desc);
    localajn.aOo(parama.thumbUrl);
    localajn.aOD(parama.dHv);
    localajn.wk(true);
    localajn.wl(true);
    localajn.ZI(5);
    aks localaks = new aks();
    localaks.aPv(parama.thumbUrl);
    localaks.aPs(parama.title);
    localaks.aPt(parama.desc);
    localakd.b(localaks);
    localakd.f(parama.DSw);
    localakj.aPf(u.aAm());
    localakj.aPg(u.aAm());
    localakj.ZR(3);
    localakj.CM(bt.flT());
    localakj.aPl(parama.duW);
    localakj.aPm(parama.url);
    paramcv.dnG.title = localajn.title;
    paramcv.dnG.dnI = localakd;
    paramcv.dnG.type = 5;
    localakd.a(localakj);
    localakd.nZa.add(localajn);
    AppMethodBeat.o(78837);
    return true;
  }
  
  public static boolean a(cv paramcv, jb paramjb)
  {
    AppMethodBeat.i(207932);
    if (paramjb == null)
    {
      ad.w("MicroMsg.GetFavDataSource", "fillMpVideoEventInfo mpMsgItem is null");
      AppMethodBeat.o(207932);
      return false;
    }
    akd localakd = new akd();
    Object localObject = new akj();
    ((akj)localObject).aPf(u.aAm());
    ((akj)localObject).aPg(u.aAm());
    ((akj)localObject).ZR(4);
    ((akj)localObject).CM(bt.flT());
    ((akj)localObject).aPm(paramjb.url);
    localakd.a((akj)localObject);
    localObject = new ajn();
    ((ajn)localObject).aOt("");
    ((ajn)localObject).aOo(paramjb.hDm);
    ((ajn)localObject).aOx(ai.ee(paramjb.FCc + paramjb.FCb));
    ((ajn)localObject).ZH(paramjb.videoDuration);
    ((ajn)localObject).aOf(paramjb.title);
    ((ajn)localObject).aOl(paramjb.url);
    ((ajn)localObject).wk(true);
    ((ajn)localObject).wl(true);
    ajv localajv = new ajv();
    localajv.hzm = paramjb.FCc;
    localajv.videoUrl = paramjb.videoUrl;
    localajv.FCb = paramjb.FCb;
    localajv.doK = paramjb.doK;
    localajv.hDe = paramjb.hDe;
    localajv.hDm = paramjb.hDm;
    localajv.videoWidth = paramjb.width;
    localajv.videoHeight = paramjb.height;
    localajv.duration = paramjb.videoDuration;
    paramjb = new ajo();
    paramjb.e(localajv);
    ((ajn)localObject).a(paramjb);
    paramjb = new LinkedList();
    paramjb.add(localObject);
    localakd.bl(paramjb);
    paramcv.dnG.dnI = localakd;
    paramcv.dnG.type = 4;
    ((ajn)localObject).ZI(4);
    AppMethodBeat.o(207932);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.model.r;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class c
{
  public static boolean a(cm paramcm, a parama)
  {
    AppMethodBeat.i(6572);
    if (!parama.valid())
    {
      ab.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or wrapper is invalid");
      paramcm.cpR.cpX = 2131299713;
      AppMethodBeat.o(6572);
      return false;
    }
    acq localacq = new acq();
    acw localacw = new acw();
    aca localaca = new aca();
    localaca.anw(parama.url);
    localaca.anq(parama.title);
    localaca.anr(parama.desc);
    localaca.anz(parama.thumbUrl);
    localaca.anO(parama.cGU);
    localaca.py(true);
    localaca.pz(true);
    localaca.MI(5);
    adf localadf = new adf();
    localadf.aoD(parama.thumbUrl);
    localadf.aoA(parama.title);
    localadf.aoB(parama.desc);
    localacq.b(localadf);
    localacq.c(parama.uVl);
    localacw.aon(r.Zn());
    localacw.aoo(r.Zn());
    localacw.MR(3);
    localacw.nI(bo.aoy());
    localacw.aot(parama.cwc);
    localacw.aou(parama.url);
    paramcm.cpR.title = localaca.title;
    paramcm.cpR.cpT = localacq;
    paramcm.cpR.type = 5;
    localacq.a(localacw);
    localacq.wVc.add(localaca);
    AppMethodBeat.o(6572);
    return true;
  }
  
  public static final class a
  {
    public String cGU;
    public String cwc;
    public String desc;
    public String thumbUrl;
    public String title;
    public aci uVl;
    public String url;
    
    public final boolean valid()
    {
      AppMethodBeat.i(6571);
      if (!bo.isNullOrNil(this.url))
      {
        AppMethodBeat.o(6571);
        return true;
      }
      AppMethodBeat.o(6571);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.c
 * JD-Core Version:    0.7.0.1
 */
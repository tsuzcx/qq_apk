package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class c
{
  public static boolean a(dn paramdn, c.a parama)
  {
    AppMethodBeat.i(78837);
    if (!parama.boj())
    {
      Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or wrapper is invalid");
      paramdn.hDr.hDx = c.i.favorite_fail_argument_error;
      AppMethodBeat.o(78837);
      return false;
    }
    arv localarv = new arv();
    asb localasb = new asb();
    arf localarf = new arf();
    localarf.bsu(parama.url);
    localarf.bso(parama.title);
    localarf.bsp(parama.desc);
    localarf.bsx(parama.thumbUrl);
    localarf.bsM(parama.iah);
    localarf.Kj(true);
    localarf.Kk(true);
    localarf.axy(5);
    ask localask = new ask();
    localask.btE(parama.thumbUrl);
    localask.btB(parama.title);
    localask.btC(parama.desc);
    localarv.c(localask);
    localarv.f(parama.WKx);
    localasb.bto(z.bAM());
    localasb.btp(z.bAM());
    localasb.axH(3);
    localasb.yu(Util.nowMilliSecond());
    localasb.btu(parama.appid);
    localasb.btv(parama.url);
    paramdn.hDr.title = localarf.title;
    paramdn.hDr.hDt = localarv;
    paramdn.hDr.type = 5;
    localarv.a(localasb);
    localarv.vEn.add(localarf);
    AppMethodBeat.o(78837);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.readerapp.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.readerapp.a.h;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class a
{
  public static boolean a(dn paramdn, bx parambx)
  {
    AppMethodBeat.i(102661);
    if ((paramdn == null) || (parambx == null))
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or readerAppInfo is null");
      if (paramdn != null) {
        paramdn.hDr.hDx = a.h.favorite_fail_argument_error;
      }
      AppMethodBeat.o(102661);
      return false;
    }
    arv localarv = new arv();
    asb localasb = new asb();
    arf localarf = new arf();
    localasb.bto("newsapp");
    localasb.btp(z.bAM());
    localasb.btp(z.bAM());
    localasb.axH(1);
    localasb.yu(parambx.omM);
    localasb.bts(parambx.omP);
    localasb.btv(parambx.getUrl());
    localasb.btw("newsapp");
    localarf.bsu(parambx.getUrl());
    localarf.bso(parambx.getTitle());
    localarf.bsp(parambx.getDigest());
    localarf.bsx(parambx.bCX());
    localarf.Kj(true);
    localarf.Kk(true);
    localarf.axy(5);
    localarv.a(localasb);
    localarv.vEn.add(localarf);
    paramdn.hDr.desc = parambx.getTitle();
    paramdn.hDr.hDt = localarv;
    paramdn.hDr.type = 5;
    AppMethodBeat.o(102661);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.model.a
 * JD-Core Version:    0.7.0.1
 */
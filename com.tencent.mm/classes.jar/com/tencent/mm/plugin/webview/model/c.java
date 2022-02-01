package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class c
{
  public static boolean a(cz paramcz, c.a parama)
  {
    AppMethodBeat.i(78837);
    if (!parama.valid())
    {
      Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or wrapper is invalid");
      paramcz.dFZ.dGe = 2131759209;
      AppMethodBeat.o(78837);
      return false;
    }
    anb localanb = new anb();
    anh localanh = new anh();
    aml localaml = new aml();
    localaml.bgl(parama.url);
    localaml.bgf(parama.title);
    localaml.bgg(parama.desc);
    localaml.bgo(parama.thumbUrl);
    localaml.bgD(parama.ean);
    localaml.As(true);
    localaml.At(true);
    localaml.ajd(5);
    anq localanq = new anq();
    localanq.bhv(parama.thumbUrl);
    localanq.bhs(parama.title);
    localanq.bht(parama.desc);
    localanb.b(localanq);
    localanb.f(parama.IXu);
    localanh.bhf(z.aTY());
    localanh.bhg(z.aTY());
    localanh.ajm(3);
    localanh.MA(Util.nowMilliSecond());
    localanh.bhl(parama.dNI);
    localanh.bhm(parama.url);
    paramcz.dFZ.title = localaml.title;
    paramcz.dFZ.dGb = localanb;
    paramcz.dFZ.type = 5;
    localanb.a(localanh);
    localanb.ppH.add(localaml);
    AppMethodBeat.o(78837);
    return true;
  }
  
  public static boolean a(cz paramcz, jo paramjo)
  {
    AppMethodBeat.i(210971);
    if (paramjo == null)
    {
      Log.w("MicroMsg.GetFavDataSource", "fillMpVideoEventInfo mpMsgItem is null");
      AppMethodBeat.o(210971);
      return false;
    }
    anb localanb = new anb();
    Object localObject = new anh();
    ((anh)localObject).bhf(z.aTY());
    ((anh)localObject).bhg(z.aTY());
    ((anh)localObject).ajm(4);
    ((anh)localObject).MA(Util.nowMilliSecond());
    ((anh)localObject).bhm(paramjo.url);
    localanb.a((anh)localObject);
    localObject = new aml();
    ((aml)localObject).bgt("");
    ((aml)localObject).bgo(paramjo.iAo);
    ((aml)localObject).bgx(MD5Util.getMD5String(paramjo.KOf + paramjo.KOe));
    ((aml)localObject).ajc(paramjo.videoDuration);
    ((aml)localObject).bgf(paramjo.title);
    ((aml)localObject).bgl(paramjo.url);
    ((aml)localObject).As(true);
    ((aml)localObject).At(true);
    amt localamt = new amt();
    localamt.vid = paramjo.KOf;
    localamt.videoUrl = paramjo.videoUrl;
    localamt.KOe = paramjo.KOe;
    localamt.dHc = paramjo.dHc;
    localamt.iAg = paramjo.iAg;
    localamt.iAo = paramjo.iAo;
    localamt.videoWidth = paramjo.width;
    localamt.videoHeight = paramjo.height;
    localamt.duration = paramjo.videoDuration;
    paramjo = new amm();
    paramjo.e(localamt);
    ((aml)localObject).a(paramjo);
    paramjo = new LinkedList();
    paramjo.add(localObject);
    localanb.bH(paramjo);
    paramcz.dFZ.dGb = localanb;
    paramcz.dFZ.type = 4;
    ((aml)localObject).ajd(4);
    AppMethodBeat.o(210971);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.c
 * JD-Core Version:    0.7.0.1
 */
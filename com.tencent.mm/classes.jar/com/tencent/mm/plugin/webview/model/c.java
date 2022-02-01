package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class c
{
  public static boolean a(dd paramdd, c.a parama)
  {
    AppMethodBeat.i(78837);
    if (!parama.fCF())
    {
      Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or wrapper is invalid");
      paramdd.fyI.fyO = c.i.favorite_fail_argument_error;
      AppMethodBeat.o(78837);
      return false;
    }
    aoc localaoc = new aoc();
    aoi localaoi = new aoi();
    anm localanm = new anm();
    localanm.bsD(parama.url);
    localanm.bsx(parama.title);
    localanm.bsy(parama.desc);
    localanm.bsG(parama.thumbUrl);
    localanm.bsV(parama.fUk);
    localanm.Ex(true);
    localanm.Ey(true);
    localanm.arq(5);
    aor localaor = new aor();
    localaor.btN(parama.thumbUrl);
    localaor.btK(parama.title);
    localaor.btL(parama.desc);
    localaoc.c(localaor);
    localaoc.f(parama.PTL);
    localaoi.btx(z.bcZ());
    localaoi.bty(z.bcZ());
    localaoi.arz(3);
    localaoi.Ue(Util.nowMilliSecond());
    localaoi.btD(parama.appid);
    localaoi.btE(parama.url);
    paramdd.fyI.title = localanm.title;
    paramdd.fyI.fyK = localaoc;
    paramdd.fyI.type = 5;
    localaoc.a(localaoi);
    localaoc.syG.add(localanm);
    AppMethodBeat.o(78837);
    return true;
  }
  
  public static boolean a(dd paramdd, jd paramjd)
  {
    AppMethodBeat.i(218718);
    if (paramjd == null)
    {
      Log.w("MicroMsg.GetFavDataSource", "fillMpVideoEventInfo mpMsgItem is null");
      AppMethodBeat.o(218718);
      return false;
    }
    aoc localaoc = new aoc();
    Object localObject = new aoi();
    ((aoi)localObject).btx(z.bcZ());
    ((aoi)localObject).bty(z.bcZ());
    ((aoi)localObject).arz(4);
    ((aoi)localObject).Ue(Util.nowMilliSecond());
    ((aoi)localObject).btE(paramjd.url);
    localaoc.a((aoi)localObject);
    localObject = new anm();
    ((anm)localObject).bsL("");
    ((anm)localObject).bsG(paramjd.lpK);
    ((anm)localObject).bsP(MD5Util.getMD5String(paramjd.RPa + paramjd.ROZ));
    ((anm)localObject).arp(paramjd.videoDuration);
    ((anm)localObject).bsx(paramjd.title);
    ((anm)localObject).bsD(paramjd.url);
    ((anm)localObject).Ex(true);
    ((anm)localObject).Ey(true);
    anu localanu = new anu();
    localanu.vid = paramjd.RPa;
    localanu.videoUrl = paramjd.videoUrl;
    localanu.ROZ = paramjd.ROZ;
    localanu.fzT = paramjd.fzT;
    localanu.lpC = paramjd.lpC;
    localanu.lpK = paramjd.lpK;
    localanu.videoWidth = paramjd.width;
    localanu.videoHeight = paramjd.height;
    localanu.duration = paramjd.videoDuration;
    paramjd = new ann();
    paramjd.e(localanu);
    ((anm)localObject).a(paramjd);
    paramjd = new LinkedList();
    paramjd.add(localObject);
    localaoc.cg(paramjd);
    paramdd.fyI.fyK = localaoc;
    paramdd.fyI.type = 4;
    ((anm)localObject).arq(4);
    AppMethodBeat.o(218718);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.c
 * JD-Core Version:    0.7.0.1
 */
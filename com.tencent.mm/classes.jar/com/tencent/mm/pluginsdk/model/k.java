package com.tencent.mm.pluginsdk.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class k
  implements ae
{
  public final boolean a(dd paramdd, int paramInt, String paramString)
  {
    AppMethodBeat.i(30966);
    boolean bool = j.a(paramdd, paramInt, paramString);
    AppMethodBeat.o(30966);
    return bool;
  }
  
  public final boolean a(dd paramdd, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(257582);
    boolean bool = j.a(paramdd, paramInt, paramString1, paramString2, paramString3, true);
    AppMethodBeat.o(257582);
    return bool;
  }
  
  public final boolean a(dd paramdd, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    AppMethodBeat.i(30964);
    aoc localaoc = new aoc();
    aoi localaoi = new aoi();
    anm localanm = new anm();
    localanm.arq(5);
    localanm.bsM(paramString7);
    localanm.bsD(paramString3);
    localanm.arp(paramInt);
    localanm.bsx(paramString1);
    localanm.bsy(paramString2);
    localanm.bsV(paramString11);
    paramString2 = new anp();
    paramString2.lot = paramString1;
    paramString2.SAk = paramInt;
    paramString2.lor = paramString3;
    paramString2.lov = paramString5;
    paramString2.lou = paramString4;
    paramString2.low = paramString6;
    paramString2.lox = paramString9;
    paramString2.loy = paramString10;
    localanm.a(paramString2);
    localaoi.btx(paramString8);
    localaoi.bty(z.bcZ());
    localaoi.arz(0);
    localaoi.Ue(Util.nowMilliSecond());
    localaoc.a(localaoi);
    localaoc.syG.add(localanm);
    paramdd.fyI.title = localanm.title;
    paramdd.fyI.desc = localanm.title;
    paramdd.fyI.fyK = localaoc;
    paramdd.fyI.type = 4;
    AppMethodBeat.o(30964);
    return true;
  }
  
  public final boolean a(dd paramdd, long paramLong)
  {
    AppMethodBeat.i(30967);
    boolean bool = j.a(paramdd, paramLong);
    AppMethodBeat.o(30967);
    return bool;
  }
  
  public final boolean a(dd paramdd, Intent paramIntent)
  {
    AppMethodBeat.i(30965);
    boolean bool = j.a(paramdd, paramIntent);
    AppMethodBeat.o(30965);
    return bool;
  }
  
  public final boolean a(dd paramdd, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(257581);
    boolean bool = j.a(paramdd, 6, paramString1, paramString2, paramInt, paramString3, paramString4, true);
    AppMethodBeat.o(257581);
    return bool;
  }
  
  public final boolean a(dd paramdd, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(30968);
    String str = String.format("%s#%s", new Object[] { paramString1, "" });
    aoc localaoc = new aoc();
    aoi localaoi = new aoi();
    localaoi.btx(paramString2);
    localaoi.arz(2);
    localaoi.Ue(System.currentTimeMillis());
    localaoi.btC(String.valueOf(paramString1));
    localaoi.btz(str);
    paramString1 = new anm();
    paramString1.bsP(str);
    paramString1.Ey(true);
    paramString1.arq(5);
    paramString1.bsx(paramString3);
    paramString1.bsy(paramString4);
    paramString1.bsW(paramString5);
    paramString1.Ex(true);
    localaoc.syG.add(paramString1);
    paramString1 = new aor();
    paramString1.btN(paramString6);
    paramString1.btM(paramString7);
    localaoc.c(paramString1);
    localaoc.a(localaoi);
    paramdd.fyI.fyK = localaoc;
    paramdd.fyI.desc = paramString3;
    paramdd.fyI.type = 5;
    AppMethodBeat.o(30968);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.k
 * JD-Core Version:    0.7.0.1
 */
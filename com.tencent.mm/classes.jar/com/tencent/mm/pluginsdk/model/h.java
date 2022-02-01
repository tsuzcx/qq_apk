package com.tencent.mm.pluginsdk.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class h
  implements ad
{
  public final boolean a(cs paramcs, int paramInt, String paramString)
  {
    AppMethodBeat.i(30966);
    boolean bool = g.a(paramcs, paramInt, paramString);
    AppMethodBeat.o(30966);
    return bool;
  }
  
  public final boolean a(cs paramcs, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    AppMethodBeat.i(30964);
    ago localago = new ago();
    agu localagu = new agu();
    afy localafy = new afy();
    localafy.VD(5);
    localafy.aDA(paramString7);
    localafy.aDr(paramString3);
    localafy.VC(paramInt);
    localafy.aDl(paramString1);
    localafy.aDm(paramString2);
    localafy.aDJ(paramString11);
    paramString2 = new agb();
    paramString2.gJx = paramString1;
    paramString2.Dim = paramInt;
    paramString2.gJv = paramString3;
    paramString2.gJz = paramString5;
    paramString2.gJy = paramString4;
    paramString2.gJA = paramString6;
    paramString2.gJB = paramString9;
    paramString2.gJC = paramString10;
    localafy.a(paramString2);
    localagu.aEl(paramString8);
    localagu.aEm(u.aqG());
    localagu.VM(0);
    localagu.vv(bt.eGO());
    localago.a(localagu);
    localago.mVb.add(localafy);
    paramcs.deQ.title = localafy.title;
    paramcs.deQ.desc = localafy.title;
    paramcs.deQ.deS = localago;
    paramcs.deQ.type = 4;
    AppMethodBeat.o(30964);
    return true;
  }
  
  public final boolean a(cs paramcs, long paramLong)
  {
    AppMethodBeat.i(30967);
    boolean bool = g.a(paramcs, paramLong);
    AppMethodBeat.o(30967);
    return bool;
  }
  
  public final boolean a(cs paramcs, Intent paramIntent)
  {
    AppMethodBeat.i(30965);
    boolean bool = g.a(paramcs, paramIntent);
    AppMethodBeat.o(30965);
    return bool;
  }
  
  public final boolean a(cs paramcs, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(169777);
    boolean bool = g.a(paramcs, paramString1, paramString2, paramString3, true);
    AppMethodBeat.o(169777);
    return bool;
  }
  
  public final boolean a(cs paramcs, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(30968);
    String str = String.format("%s#%s", new Object[] { paramString1, "" });
    ago localago = new ago();
    agu localagu = new agu();
    localagu.aEl(paramString2);
    localagu.VM(2);
    localagu.vv(System.currentTimeMillis());
    localagu.aEq(String.valueOf(paramString1));
    localagu.aEn(str);
    paramString1 = new afy();
    paramString1.aDD(str);
    paramString1.ux(true);
    paramString1.VD(5);
    paramString1.aDl(paramString3);
    paramString1.aDm(paramString4);
    paramString1.aDK(paramString5);
    paramString1.uw(true);
    localago.mVb.add(paramString1);
    paramString1 = new ahd();
    paramString1.aEB(paramString6);
    paramString1.aEA(paramString7);
    localago.b(paramString1);
    localago.a(localagu);
    paramcs.deQ.deS = localago;
    paramcs.deQ.desc = paramString3;
    paramcs.deQ.type = 5;
    AppMethodBeat.o(30968);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.h
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.pluginsdk.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.aha;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.sdk.platformtools.bs;
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
    ahn localahn = new ahn();
    aht localaht = new aht();
    agx localagx = new agx();
    localagx.XM(5);
    localagx.aIR(paramString7);
    localagx.aII(paramString3);
    localagx.XL(paramInt);
    localagx.aIC(paramString1);
    localagx.aID(paramString2);
    localagx.aJa(paramString11);
    paramString2 = new aha();
    paramString2.hjX = paramString1;
    paramString2.EBs = paramInt;
    paramString2.hjV = paramString3;
    paramString2.hjZ = paramString5;
    paramString2.hjY = paramString4;
    paramString2.hka = paramString6;
    paramString2.hkb = paramString9;
    paramString2.hkc = paramString10;
    localagx.a(paramString2);
    localaht.aJC(paramString8);
    localaht.aJD(u.axw());
    localaht.XV(0);
    localaht.zY(bs.eWj());
    localahn.a(localaht);
    localahn.nxC.add(localagx);
    paramcs.dck.title = localagx.title;
    paramcs.dck.desc = localagx.title;
    paramcs.dck.dcm = localahn;
    paramcs.dck.type = 4;
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
    ahn localahn = new ahn();
    aht localaht = new aht();
    localaht.aJC(paramString2);
    localaht.XV(2);
    localaht.zY(System.currentTimeMillis());
    localaht.aJH(String.valueOf(paramString1));
    localaht.aJE(str);
    paramString1 = new agx();
    paramString1.aIU(str);
    paramString1.vz(true);
    paramString1.XM(5);
    paramString1.aIC(paramString3);
    paramString1.aID(paramString4);
    paramString1.aJb(paramString5);
    paramString1.vy(true);
    localahn.nxC.add(paramString1);
    paramString1 = new aic();
    paramString1.aJS(paramString6);
    paramString1.aJR(paramString7);
    localahn.b(paramString1);
    localahn.a(localaht);
    paramcs.dck.dcm = localahn;
    paramcs.dck.desc = paramString3;
    paramcs.dck.type = 5;
    AppMethodBeat.o(30968);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.h
 * JD-Core Version:    0.7.0.1
 */
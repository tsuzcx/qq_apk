package com.tencent.mm.pluginsdk.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class h
  implements ad
{
  public final boolean a(cw paramcw, int paramInt, String paramString)
  {
    AppMethodBeat.i(30966);
    boolean bool = g.a(paramcw, paramInt, paramString);
    AppMethodBeat.o(30966);
    return bool;
  }
  
  public final boolean a(cw paramcw, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    AppMethodBeat.i(30964);
    akn localakn = new akn();
    akt localakt = new akt();
    ajx localajx = new ajx();
    localajx.aao(5);
    localajx.aPR(paramString7);
    localajx.aPI(paramString3);
    localajx.aan(paramInt);
    localajx.aPC(paramString1);
    localajx.aPD(paramString2);
    localajx.aQa(paramString11);
    paramString2 = new aka();
    paramString2.hEV = paramString1;
    paramString2.GBN = paramInt;
    paramString2.hET = paramString3;
    paramString2.hEX = paramString5;
    paramString2.hEW = paramString4;
    paramString2.hEY = paramString6;
    paramString2.hEZ = paramString9;
    paramString2.hFa = paramString10;
    localajx.a(paramString2);
    localakt.aQC(paramString8);
    localakt.aQD(v.aAC());
    localakt.aax(0);
    localakt.Dk(bu.fpO());
    localakn.a(localakt);
    localakn.oeJ.add(localajx);
    paramcw.doL.title = localajx.title;
    paramcw.doL.desc = localajx.title;
    paramcw.doL.doN = localakn;
    paramcw.doL.type = 4;
    AppMethodBeat.o(30964);
    return true;
  }
  
  public final boolean a(cw paramcw, long paramLong)
  {
    AppMethodBeat.i(30967);
    boolean bool = g.a(paramcw, paramLong);
    AppMethodBeat.o(30967);
    return bool;
  }
  
  public final boolean a(cw paramcw, Intent paramIntent)
  {
    AppMethodBeat.i(30965);
    boolean bool = g.a(paramcw, paramIntent);
    AppMethodBeat.o(30965);
    return bool;
  }
  
  public final boolean a(cw paramcw, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(169777);
    boolean bool = g.a(paramcw, paramString1, paramString2, paramString3, true);
    AppMethodBeat.o(169777);
    return bool;
  }
  
  public final boolean a(cw paramcw, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(30968);
    String str = String.format("%s#%s", new Object[] { paramString1, "" });
    akn localakn = new akn();
    akt localakt = new akt();
    localakt.aQC(paramString2);
    localakt.aax(2);
    localakt.Dk(System.currentTimeMillis());
    localakt.aQH(String.valueOf(paramString1));
    localakt.aQE(str);
    paramString1 = new ajx();
    paramString1.aPU(str);
    paramString1.wt(true);
    paramString1.aao(5);
    paramString1.aPC(paramString3);
    paramString1.aPD(paramString4);
    paramString1.aQb(paramString5);
    paramString1.ws(true);
    localakn.oeJ.add(paramString1);
    paramString1 = new alc();
    paramString1.aQS(paramString6);
    paramString1.aQR(paramString7);
    localakn.b(paramString1);
    localakn.a(localakt);
    paramcw.doL.doN = localakn;
    paramcw.doL.desc = paramString3;
    paramcw.doL.type = 5;
    AppMethodBeat.o(30968);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.h
 * JD-Core Version:    0.7.0.1
 */
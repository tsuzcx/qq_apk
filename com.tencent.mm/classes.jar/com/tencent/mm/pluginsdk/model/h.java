package com.tencent.mm.pluginsdk.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class h
  implements ad
{
  public final boolean a(cv paramcv, int paramInt, String paramString)
  {
    AppMethodBeat.i(30966);
    boolean bool = g.a(paramcv, paramInt, paramString);
    AppMethodBeat.o(30966);
    return bool;
  }
  
  public final boolean a(cv paramcv, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    AppMethodBeat.i(30964);
    akd localakd = new akd();
    akj localakj = new akj();
    ajn localajn = new ajn();
    localajn.ZI(5);
    localajn.aOu(paramString7);
    localajn.aOl(paramString3);
    localajn.ZH(paramInt);
    localajn.aOf(paramString1);
    localajn.aOg(paramString2);
    localajn.aOD(paramString11);
    paramString2 = new ajq();
    paramString2.hCg = paramString1;
    paramString2.Gje = paramInt;
    paramString2.hCe = paramString3;
    paramString2.hCi = paramString5;
    paramString2.hCh = paramString4;
    paramString2.hCj = paramString6;
    paramString2.hCk = paramString9;
    paramString2.hCl = paramString10;
    localajn.a(paramString2);
    localakj.aPf(paramString8);
    localakj.aPg(u.aAm());
    localakj.ZR(0);
    localakj.CM(bt.flT());
    localakd.a(localakj);
    localakd.nZa.add(localajn);
    paramcv.dnG.title = localajn.title;
    paramcv.dnG.desc = localajn.title;
    paramcv.dnG.dnI = localakd;
    paramcv.dnG.type = 4;
    AppMethodBeat.o(30964);
    return true;
  }
  
  public final boolean a(cv paramcv, long paramLong)
  {
    AppMethodBeat.i(30967);
    boolean bool = g.a(paramcv, paramLong);
    AppMethodBeat.o(30967);
    return bool;
  }
  
  public final boolean a(cv paramcv, Intent paramIntent)
  {
    AppMethodBeat.i(30965);
    boolean bool = g.a(paramcv, paramIntent);
    AppMethodBeat.o(30965);
    return bool;
  }
  
  public final boolean a(cv paramcv, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(169777);
    boolean bool = g.a(paramcv, paramString1, paramString2, paramString3, true);
    AppMethodBeat.o(169777);
    return bool;
  }
  
  public final boolean a(cv paramcv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(30968);
    String str = String.format("%s#%s", new Object[] { paramString1, "" });
    akd localakd = new akd();
    akj localakj = new akj();
    localakj.aPf(paramString2);
    localakj.ZR(2);
    localakj.CM(System.currentTimeMillis());
    localakj.aPk(String.valueOf(paramString1));
    localakj.aPh(str);
    paramString1 = new ajn();
    paramString1.aOx(str);
    paramString1.wl(true);
    paramString1.ZI(5);
    paramString1.aOf(paramString3);
    paramString1.aOg(paramString4);
    paramString1.aOE(paramString5);
    paramString1.wk(true);
    localakd.nZa.add(paramString1);
    paramString1 = new aks();
    paramString1.aPv(paramString6);
    paramString1.aPu(paramString7);
    localakd.b(paramString1);
    localakd.a(localakj);
    paramcv.dnG.dnI = localakd;
    paramcv.dnG.desc = paramString3;
    paramcv.dnG.type = 5;
    AppMethodBeat.o(30968);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.h
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.pluginsdk.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class f
  implements ad
{
  public final boolean a(cm paramcm, int paramInt, String paramString)
  {
    AppMethodBeat.i(27274);
    boolean bool = e.a(paramcm, paramInt, paramString);
    AppMethodBeat.o(27274);
    return bool;
  }
  
  public final boolean a(cm paramcm, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    AppMethodBeat.i(27272);
    acq localacq = new acq();
    acw localacw = new acw();
    aca localaca = new aca();
    localaca.MI(5);
    localaca.anF(paramString7);
    localaca.anw(paramString3);
    localaca.MH(paramInt);
    localaca.anq(paramString1);
    localaca.anr(paramString2);
    localaca.anO(paramString11);
    paramString2 = new acd();
    paramString2.fiQ = paramString1;
    paramString2.wUJ = paramInt;
    paramString2.fiO = paramString3;
    paramString2.fiS = paramString5;
    paramString2.fiR = paramString4;
    paramString2.fiT = paramString6;
    paramString2.fiU = paramString9;
    paramString2.fiV = paramString10;
    localaca.a(paramString2);
    localacw.aon(paramString8);
    localacw.aoo(r.Zn());
    localacw.MR(0);
    localacw.nI(bo.aoy());
    localacq.a(localacw);
    localacq.wVc.add(localaca);
    paramcm.cpR.title = localaca.title;
    paramcm.cpR.desc = localaca.title;
    paramcm.cpR.cpT = localacq;
    paramcm.cpR.type = 4;
    AppMethodBeat.o(27272);
    return true;
  }
  
  public final boolean a(cm paramcm, long paramLong)
  {
    AppMethodBeat.i(27275);
    boolean bool = e.a(paramcm, paramLong);
    AppMethodBeat.o(27275);
    return bool;
  }
  
  public final boolean a(cm paramcm, Intent paramIntent)
  {
    AppMethodBeat.i(27273);
    boolean bool = e.a(paramcm, paramIntent);
    AppMethodBeat.o(27273);
    return bool;
  }
  
  public final boolean a(cm paramcm, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(27276);
    String str = String.format("%s#%s", new Object[] { paramString1, "" });
    acq localacq = new acq();
    acw localacw = new acw();
    localacw.aon(paramString2);
    localacw.MR(2);
    localacw.nI(System.currentTimeMillis());
    localacw.aos(String.valueOf(paramString1));
    localacw.aop(str);
    paramString1 = new aca();
    paramString1.anI(str);
    paramString1.pz(true);
    paramString1.MI(5);
    paramString1.anq(paramString3);
    paramString1.anr(paramString4);
    paramString1.anP(paramString5);
    paramString1.py(true);
    localacq.wVc.add(paramString1);
    paramString1 = new adf();
    paramString1.aoD(paramString6);
    paramString1.aoC(paramString7);
    localacq.b(paramString1);
    localacq.a(localacw);
    paramcm.cpR.cpT = localacq;
    paramcm.cpR.desc = paramString3;
    paramcm.cpR.type = 5;
    AppMethodBeat.o(27276);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.f
 * JD-Core Version:    0.7.0.1
 */
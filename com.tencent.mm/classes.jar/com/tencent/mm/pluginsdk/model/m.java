package com.tencent.mm.pluginsdk.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class m
  implements af
{
  public final boolean a(dn paramdn, int paramInt, String paramString)
  {
    AppMethodBeat.i(30966);
    boolean bool = l.a(paramdn, paramInt, paramString);
    AppMethodBeat.o(30966);
    return bool;
  }
  
  public final boolean a(dn paramdn, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(244742);
    boolean bool = l.a(paramdn, paramInt, paramString1, paramString2, paramString3, true);
    AppMethodBeat.o(244742);
    return bool;
  }
  
  public final boolean a(dn paramdn, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    AppMethodBeat.i(30964);
    arv localarv = new arv();
    asb localasb = new asb();
    arf localarf = new arf();
    localarf.axy(5);
    localarf.bsD(paramString7);
    localarf.bsu(paramString3);
    localarf.axx(paramInt);
    localarf.bso(paramString1);
    localarf.bsp(paramString2);
    localarf.bsM(paramString11);
    paramString2 = new ari();
    paramString2.nTw = paramString1;
    paramString2.ZBc = paramInt;
    paramString2.nTu = paramString3;
    paramString2.nTy = paramString5;
    paramString2.nTx = paramString4;
    paramString2.nTz = paramString6;
    paramString2.nTA = paramString9;
    paramString2.nTB = paramString10;
    localarf.a(paramString2);
    localasb.bto(paramString8);
    localasb.btp(z.bAM());
    localasb.axH(0);
    localasb.yu(Util.nowMilliSecond());
    localarv.a(localasb);
    localarv.vEn.add(localarf);
    paramdn.hDr.title = localarf.title;
    paramdn.hDr.desc = localarf.title;
    paramdn.hDr.hDt = localarv;
    paramdn.hDr.type = 4;
    AppMethodBeat.o(30964);
    return true;
  }
  
  public final boolean a(dn paramdn, long paramLong)
  {
    AppMethodBeat.i(30967);
    boolean bool = l.a(paramdn, paramLong);
    AppMethodBeat.o(30967);
    return bool;
  }
  
  public final boolean a(dn paramdn, Intent paramIntent)
  {
    AppMethodBeat.i(30965);
    boolean bool = l.a(paramdn, paramIntent);
    AppMethodBeat.o(30965);
    return bool;
  }
  
  public final boolean a(dn paramdn, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(244737);
    boolean bool = l.a(paramdn, 6, paramString1, paramString2, paramInt, paramString3, paramString4, true);
    AppMethodBeat.o(244737);
    return bool;
  }
  
  public final boolean a(dn paramdn, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(30968);
    String str = String.format("%s#%s", new Object[] { paramString1, "" });
    arv localarv = new arv();
    asb localasb = new asb();
    localasb.bto(paramString2);
    localasb.axH(2);
    localasb.yu(System.currentTimeMillis());
    localasb.btt(String.valueOf(paramString1));
    localasb.btq(str);
    paramString1 = new arf();
    paramString1.bsG(str);
    paramString1.Kk(true);
    paramString1.axy(5);
    paramString1.bso(paramString3);
    paramString1.bsp(paramString4);
    paramString1.bsN(paramString5);
    paramString1.Kj(true);
    localarv.vEn.add(paramString1);
    paramString1 = new ask();
    paramString1.btE(paramString6);
    paramString1.btD(paramString7);
    localarv.c(paramString1);
    localarv.a(localasb);
    paramdn.hDr.hDt = localarv;
    paramdn.hDr.desc = paramString3;
    paramdn.hDr.type = 5;
    AppMethodBeat.o(30968);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.m
 * JD-Core Version:    0.7.0.1
 */
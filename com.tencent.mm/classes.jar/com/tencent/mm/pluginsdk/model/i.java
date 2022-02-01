package com.tencent.mm.pluginsdk.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class i
  implements ad
{
  public final boolean a(cz paramcz, int paramInt, String paramString)
  {
    AppMethodBeat.i(30966);
    boolean bool = h.a(paramcz, paramInt, paramString);
    AppMethodBeat.o(30966);
    return bool;
  }
  
  public final boolean a(cz paramcz, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(232144);
    boolean bool = h.a(paramcz, paramInt, paramString1, paramString2, paramString3, true);
    AppMethodBeat.o(232144);
    return bool;
  }
  
  public final boolean a(cz paramcz, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    AppMethodBeat.i(30964);
    anb localanb = new anb();
    anh localanh = new anh();
    aml localaml = new aml();
    localaml.ajd(5);
    localaml.bgu(paramString7);
    localaml.bgl(paramString3);
    localaml.ajc(paramInt);
    localaml.bgf(paramString1);
    localaml.bgg(paramString2);
    localaml.bgD(paramString11);
    paramString2 = new amo();
    paramString2.izb = paramString1;
    paramString2.LxJ = paramInt;
    paramString2.iyZ = paramString3;
    paramString2.izd = paramString5;
    paramString2.izc = paramString4;
    paramString2.ize = paramString6;
    paramString2.izf = paramString9;
    paramString2.izg = paramString10;
    localaml.a(paramString2);
    localanh.bhf(paramString8);
    localanh.bhg(z.aTY());
    localanh.ajm(0);
    localanh.MA(Util.nowMilliSecond());
    localanb.a(localanh);
    localanb.ppH.add(localaml);
    paramcz.dFZ.title = localaml.title;
    paramcz.dFZ.desc = localaml.title;
    paramcz.dFZ.dGb = localanb;
    paramcz.dFZ.type = 4;
    AppMethodBeat.o(30964);
    return true;
  }
  
  public final boolean a(cz paramcz, long paramLong)
  {
    AppMethodBeat.i(30967);
    boolean bool = h.a(paramcz, paramLong);
    AppMethodBeat.o(30967);
    return bool;
  }
  
  public final boolean a(cz paramcz, Intent paramIntent)
  {
    AppMethodBeat.i(30965);
    boolean bool = h.a(paramcz, paramIntent);
    AppMethodBeat.o(30965);
    return bool;
  }
  
  public final boolean a(cz paramcz, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(232143);
    boolean bool = h.a(paramcz, 6, paramString1, paramString2, paramInt, paramString3, paramString4, true);
    AppMethodBeat.o(232143);
    return bool;
  }
  
  public final boolean a(cz paramcz, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(30968);
    String str = String.format("%s#%s", new Object[] { paramString1, "" });
    anb localanb = new anb();
    anh localanh = new anh();
    localanh.bhf(paramString2);
    localanh.ajm(2);
    localanh.MA(System.currentTimeMillis());
    localanh.bhk(String.valueOf(paramString1));
    localanh.bhh(str);
    paramString1 = new aml();
    paramString1.bgx(str);
    paramString1.At(true);
    paramString1.ajd(5);
    paramString1.bgf(paramString3);
    paramString1.bgg(paramString4);
    paramString1.bgE(paramString5);
    paramString1.As(true);
    localanb.ppH.add(paramString1);
    paramString1 = new anq();
    paramString1.bhv(paramString6);
    paramString1.bhu(paramString7);
    localanb.b(paramString1);
    localanb.a(localanh);
    paramcz.dFZ.dGb = localanb;
    paramcz.dFZ.desc = paramString3;
    paramcz.dFZ.type = 5;
    AppMethodBeat.o(30968);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.i
 * JD-Core Version:    0.7.0.1
 */
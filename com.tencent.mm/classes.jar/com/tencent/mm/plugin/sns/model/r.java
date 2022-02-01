package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.ekc;
import com.tencent.mm.protocal.protobuf.ekd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import java.util.Vector;

public final class r
  extends q
  implements m
{
  public static List<Long> JVb;
  public boolean JVr;
  public h JVs;
  public i callback;
  private long fWg;
  public d rr;
  
  static
  {
    AppMethodBeat.i(95600);
    JVb = new Vector();
    AppMethodBeat.o(95600);
  }
  
  public r(long paramLong)
  {
    AppMethodBeat.i(95597);
    this.JVr = false;
    this.JVs = null;
    this.fWg = paramLong;
    d.a locala = new d.a();
    locala.lBU = new ekc();
    locala.lBV = new ekd();
    locala.uri = "/cgi-bin/micromsg-bin/mmsnsobjectdetail";
    locala.funcId = 210;
    locala.lBW = 101;
    locala.respCmdId = 1000000101;
    this.rr = locala.bgN();
    ((ekc)d.b.b(this.rr.lBR)).Id = paramLong;
    Log.d("MicroMsg.NetSceneSnsObjectDetial", "req snsId ".concat(String.valueOf(paramLong)));
    AppMethodBeat.o(95597);
  }
  
  private static boolean QC(long paramLong)
  {
    AppMethodBeat.i(95596);
    JVb.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95596);
    return true;
  }
  
  public static boolean QD(long paramLong)
  {
    AppMethodBeat.i(95595);
    if (JVb.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95595);
      return false;
    }
    JVb.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95595);
    return true;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(95598);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95598);
    return i;
  }
  
  public final int getType()
  {
    return 210;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95599);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      QC(this.fWg);
      AppMethodBeat.o(95599);
      return;
    }
    params = ((ekd)d.c.b(this.rr.lBS)).UlS;
    if (params != null) {
      Log.i("MicroMsg.NetSceneSnsObjectDetial", "snsdetail xml " + z.b(params.ObjectDesc));
    }
    an.g(params);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    QC(this.fWg);
    AppMethodBeat.o(95599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.r
 * JD-Core Version:    0.7.0.1
 */
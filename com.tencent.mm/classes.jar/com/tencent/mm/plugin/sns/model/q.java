package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cee;
import com.tencent.mm.protocal.protobuf.cef;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;
import java.util.Vector;

public final class q
  extends m
  implements k
{
  public static List<Long> reu;
  private long cIo;
  public f callback;
  public b rr;
  
  static
  {
    AppMethodBeat.i(36275);
    reu = new Vector();
    AppMethodBeat.o(36275);
  }
  
  public q(long paramLong)
  {
    AppMethodBeat.i(36272);
    this.cIo = paramLong;
    b.a locala = new b.a();
    locala.fsX = new cee();
    locala.fsY = new cef();
    locala.uri = "/cgi-bin/micromsg-bin/mmsnsobjectdetail";
    locala.funcId = 210;
    locala.reqCmdId = 101;
    locala.respCmdId = 1000000101;
    this.rr = locala.ado();
    ((cee)this.rr.fsV.fta).Id = paramLong;
    ab.d("MicroMsg.NetSceneSnsObjectDetial", "req snsId ".concat(String.valueOf(paramLong)));
    AppMethodBeat.o(36272);
  }
  
  private static boolean lA(long paramLong)
  {
    AppMethodBeat.i(36271);
    reu.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(36271);
    return true;
  }
  
  public static boolean lB(long paramLong)
  {
    AppMethodBeat.i(36270);
    if (reu.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(36270);
      return false;
    }
    reu.add(Long.valueOf(paramLong));
    AppMethodBeat.o(36270);
    return true;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(36273);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(36273);
    return i;
  }
  
  public final int getType()
  {
    return 210;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(36274);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      lA(this.cIo);
      AppMethodBeat.o(36274);
      return;
    }
    paramq = ((cef)this.rr.fsW.fta).xOF;
    if (paramq != null) {
      ab.i("MicroMsg.NetSceneSnsObjectDetial", "snsdetail xml " + aa.b(paramq.ObjectDesc));
    }
    ak.d(paramq);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    lA(this.cIo);
    AppMethodBeat.o(36274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.q
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dan;
import com.tencent.mm.protocal.protobuf.dao;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.List;
import java.util.Vector;

public final class p
  extends n
  implements k
{
  public static List<Long> xRl;
  public g callback;
  private long dwQ;
  public b rr;
  public j xRA;
  public boolean xRz;
  
  static
  {
    AppMethodBeat.i(95600);
    xRl = new Vector();
    AppMethodBeat.o(95600);
  }
  
  public p(long paramLong)
  {
    AppMethodBeat.i(95597);
    this.xRz = false;
    this.xRA = null;
    this.dwQ = paramLong;
    b.a locala = new b.a();
    locala.hvt = new dan();
    locala.hvu = new dao();
    locala.uri = "/cgi-bin/micromsg-bin/mmsnsobjectdetail";
    locala.funcId = 210;
    locala.reqCmdId = 101;
    locala.respCmdId = 1000000101;
    this.rr = locala.aAz();
    ((dan)this.rr.hvr.hvw).Id = paramLong;
    ac.d("MicroMsg.NetSceneSnsObjectDetial", "req snsId ".concat(String.valueOf(paramLong)));
    AppMethodBeat.o(95597);
  }
  
  private static boolean xg(long paramLong)
  {
    AppMethodBeat.i(95596);
    xRl.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95596);
    return true;
  }
  
  public static boolean xh(long paramLong)
  {
    AppMethodBeat.i(95595);
    if (xRl.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95595);
      return false;
    }
    xRl.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95595);
    return true;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(95598);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(95598);
    return i;
  }
  
  public final int getType()
  {
    return 210;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95599);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      xg(this.dwQ);
      AppMethodBeat.o(95599);
      return;
    }
    paramq = ((dao)this.rr.hvs.hvw).FJG;
    if (paramq != null) {
      ac.i("MicroMsg.NetSceneSnsObjectDetial", "snsdetail xml " + z.b(paramq.ObjectDesc));
    }
    aj.d(paramq);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    xg(this.dwQ);
    AppMethodBeat.o(95599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.p
 * JD-Core Version:    0.7.0.1
 */
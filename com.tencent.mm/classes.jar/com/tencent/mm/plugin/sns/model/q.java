package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dgu;
import com.tencent.mm.protocal.protobuf.dgv;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.List;
import java.util.Vector;

public final class q
  extends n
  implements k
{
  public static List<Long> zxU;
  public f callback;
  private long dKq;
  public b rr;
  public boolean zyi;
  public j zyj;
  
  static
  {
    AppMethodBeat.i(95600);
    zxU = new Vector();
    AppMethodBeat.o(95600);
  }
  
  public q(long paramLong)
  {
    AppMethodBeat.i(95597);
    this.zyi = false;
    this.zyj = null;
    this.dKq = paramLong;
    b.a locala = new b.a();
    locala.hQF = new dgu();
    locala.hQG = new dgv();
    locala.uri = "/cgi-bin/micromsg-bin/mmsnsobjectdetail";
    locala.funcId = 210;
    locala.hQH = 101;
    locala.respCmdId = 1000000101;
    this.rr = locala.aDS();
    ((dgu)this.rr.hQD.hQJ).Id = paramLong;
    ae.d("MicroMsg.NetSceneSnsObjectDetial", "req snsId ".concat(String.valueOf(paramLong)));
    AppMethodBeat.o(95597);
  }
  
  private static boolean Ad(long paramLong)
  {
    AppMethodBeat.i(95596);
    zxU.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95596);
    return true;
  }
  
  public static boolean Ae(long paramLong)
  {
    AppMethodBeat.i(95595);
    if (zxU.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95595);
      return false;
    }
    zxU.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95595);
    return true;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(95598);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(95598);
    return i;
  }
  
  public final int getType()
  {
    return 210;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95599);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      Ad(this.dKq);
      AppMethodBeat.o(95599);
      return;
    }
    paramq = ((dgv)this.rr.hQE.hQJ).HNR;
    if (paramq != null) {
      ae.i("MicroMsg.NetSceneSnsObjectDetial", "snsdetail xml " + z.b(paramq.ObjectDesc));
    }
    al.e(paramq);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    Ad(this.dKq);
    AppMethodBeat.o(95599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.q
 * JD-Core Version:    0.7.0.1
 */
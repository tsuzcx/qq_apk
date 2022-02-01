package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cvb;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.List;
import java.util.Vector;

public final class p
  extends n
  implements k
{
  public static List<Long> wEQ;
  public g callback;
  private long dze;
  public b rr;
  public boolean wFe;
  public j wFf;
  
  static
  {
    AppMethodBeat.i(95600);
    wEQ = new Vector();
    AppMethodBeat.o(95600);
  }
  
  public p(long paramLong)
  {
    AppMethodBeat.i(95597);
    this.wFe = false;
    this.wFf = null;
    this.dze = paramLong;
    b.a locala = new b.a();
    locala.gUU = new cvb();
    locala.gUV = new cvc();
    locala.uri = "/cgi-bin/micromsg-bin/mmsnsobjectdetail";
    locala.funcId = 210;
    locala.reqCmdId = 101;
    locala.respCmdId = 1000000101;
    this.rr = locala.atI();
    ((cvb)this.rr.gUS.gUX).Id = paramLong;
    ad.d("MicroMsg.NetSceneSnsObjectDetial", "req snsId ".concat(String.valueOf(paramLong)));
    AppMethodBeat.o(95597);
  }
  
  private static boolean sD(long paramLong)
  {
    AppMethodBeat.i(95596);
    wEQ.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95596);
    return true;
  }
  
  public static boolean sE(long paramLong)
  {
    AppMethodBeat.i(95595);
    if (wEQ.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95595);
      return false;
    }
    wEQ.add(Long.valueOf(paramLong));
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
      sD(this.dze);
      AppMethodBeat.o(95599);
      return;
    }
    paramq = ((cvc)this.rr.gUT.gUX).EmH;
    if (paramq != null) {
      ad.i("MicroMsg.NetSceneSnsObjectDetial", "snsdetail xml " + z.b(paramq.ObjectDesc));
    }
    aj.d(paramq);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    sD(this.dze);
    AppMethodBeat.o(95599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.p
 * JD-Core Version:    0.7.0.1
 */
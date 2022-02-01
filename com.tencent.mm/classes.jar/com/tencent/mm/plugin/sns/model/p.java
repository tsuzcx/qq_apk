package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dga;
import com.tencent.mm.protocal.protobuf.dgb;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.List;
import java.util.Vector;

public final class p
  extends n
  implements k
{
  public static List<Long> zhf;
  public f callback;
  private long dJc;
  public b rr;
  public boolean zht;
  public j zhu;
  
  static
  {
    AppMethodBeat.i(95600);
    zhf = new Vector();
    AppMethodBeat.o(95600);
  }
  
  public p(long paramLong)
  {
    AppMethodBeat.i(95597);
    this.zht = false;
    this.zhu = null;
    this.dJc = paramLong;
    b.a locala = new b.a();
    locala.hNM = new dga();
    locala.hNN = new dgb();
    locala.uri = "/cgi-bin/micromsg-bin/mmsnsobjectdetail";
    locala.funcId = 210;
    locala.hNO = 101;
    locala.respCmdId = 1000000101;
    this.rr = locala.aDC();
    ((dga)this.rr.hNK.hNQ).Id = paramLong;
    ad.d("MicroMsg.NetSceneSnsObjectDetial", "req snsId ".concat(String.valueOf(paramLong)));
    AppMethodBeat.o(95597);
  }
  
  private static boolean zF(long paramLong)
  {
    AppMethodBeat.i(95596);
    zhf.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95596);
    return true;
  }
  
  public static boolean zG(long paramLong)
  {
    AppMethodBeat.i(95595);
    if (zhf.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95595);
      return false;
    }
    zhf.add(Long.valueOf(paramLong));
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95599);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      zF(this.dJc);
      AppMethodBeat.o(95599);
      return;
    }
    paramq = ((dgb)this.rr.hNL.hNQ).Huo;
    if (paramq != null) {
      ad.i("MicroMsg.NetSceneSnsObjectDetial", "snsdetail xml " + z.b(paramq.ObjectDesc));
    }
    ak.d(paramq);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    zF(this.dJc);
    AppMethodBeat.o(95599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.p
 * JD-Core Version:    0.7.0.1
 */
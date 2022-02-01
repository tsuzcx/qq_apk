package com.tencent.mm.plugin.sns.ad.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bsk;
import com.tencent.mm.protocal.protobuf.bsl;
import com.tencent.mm.protocal.protobuf.by;
import com.tencent.mm.protocal.protobuf.bz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends n
  implements k
{
  public f callback;
  public List<bsl> mHf;
  private b rr;
  
  public g(List<bsl> paramList)
  {
    AppMethodBeat.i(94982);
    Object localObject = new b.a();
    this.mHf = paramList;
    ((b.a)localObject).hNM = new by();
    ((b.a)localObject).hNN = new bz();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/adlog";
    ((b.a)localObject).funcId = 1802;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (by)this.rr.hNK.hNQ;
    bsk localbsk = new bsk();
    localbsk.gsM = d.Fne;
    localbsk.gsN = d.Fnd;
    localbsk.gsO = d.Fng;
    localbsk.gsP = d.Fnh;
    localbsk.gsQ = ac.fks();
    localbsk.Gro = ((int)(System.currentTimeMillis() / 1000L));
    ((by)localObject).Fux = localbsk;
    while (i < paramList.size())
    {
      ((by)localObject).Fuy.add(paramList.get(i));
      i += 1;
    }
    ad.i("MicroMsg.NetSceneAdLog", "report count: " + ((by)localObject).Fuy.size());
    AppMethodBeat.o(94982);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(94983);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(94983);
    return i;
  }
  
  public final int getType()
  {
    return 1802;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94984);
    ad.d("MicroMsg.NetSceneAdLog", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = ((bz)((b)paramq).hNL.hNQ).Fuz;
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Ist, Integer.valueOf(paramInt1));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(94984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.g
 * JD-Core Version:    0.7.0.1
 */
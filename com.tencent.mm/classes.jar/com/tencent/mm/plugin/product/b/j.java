package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.protocal.protobuf.au;
import com.tencent.mm.protocal.protobuf.bnl;
import com.tencent.mm.protocal.protobuf.bnm;
import com.tencent.mm.protocal.protobuf.bwh;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class j
  extends m
  implements k
{
  private f callback;
  public String ptW;
  public LinkedList<aan> puj;
  public LinkedList<au> puk;
  private b rr;
  
  public j(LinkedList<bwh> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(43994);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bnl();
    ((b.a)localObject).fsY = new bnm();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/presubmitorder";
    ((b.a)localObject).funcId = 554;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bnl)this.rr.fsV.fta;
    ((bnl)localObject).wDE = paramLinkedList;
    if (paramLinkedList != null) {
      i = paramLinkedList.size();
    }
    ((bnl)localObject).pql = i;
    ((bnl)localObject).xBG = paramInt;
    AppMethodBeat.o(43994);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(43996);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(43996);
    return i;
  }
  
  public final int getType()
  {
    return 554;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(43995);
    paramArrayOfByte = (bnm)((b)paramq).fsW.fta;
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.wuD == 0))
    {
      ab.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.ExpressCount " + paramArrayOfByte.xct);
      ab.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.LockId " + paramArrayOfByte.wDF);
      this.puj = paramArrayOfByte.xBH;
      this.ptW = paramArrayOfByte.wDF;
      this.puk = paramArrayOfByte.xBI;
    }
    paramInt1 = paramInt3;
    paramq = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      paramq = paramString;
      if (paramArrayOfByte.wuD != 0)
      {
        paramInt1 = paramArrayOfByte.wuD;
        paramq = paramArrayOfByte.wuE;
      }
    }
    ab.d("MicroMsg.NetSceneMallPreSubmitOrder", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(43995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.j
 * JD-Core Version:    0.7.0.1
 */
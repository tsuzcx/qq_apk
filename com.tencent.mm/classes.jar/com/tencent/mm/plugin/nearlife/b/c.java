package com.tencent.mm.plugin.nearlife.b;

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
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.btm;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class c
  extends n
  implements k
{
  private b hNF;
  private f wpW;
  public String wpX;
  
  public c(String paramString1, String paramString2, String paramString3, btm parambtm, int paramInt, LinkedList<cwt> paramLinkedList, String paramString4)
  {
    AppMethodBeat.i(26548);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new aca();
    ((b.a)localObject).hNN = new acb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/createpoi";
    ((b.a)localObject).funcId = 650;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hNF = ((b.a)localObject).aDC();
    paramString4 = bt.bI(paramString4, "");
    localObject = bt.bI(null, "");
    aca localaca = (aca)this.hNF.hNK.hNQ;
    localaca.Name = paramString1;
    localaca.GbA = paramString2;
    localaca.GbC = parambtm;
    localaca.nDi = paramInt;
    if (paramLinkedList != null) {
      localaca.GbD = paramLinkedList;
    }
    localaca.GbE = paramString4;
    localaca.GbF = ((String)localObject);
    localaca.GbB = paramString3;
    ad.d("MicroMsg.NetSceneCreatePoi", "[req] name:%s, district:%s, Street: %s lat:%f, long:%f, count:%d, tel:%s, url:%s", new Object[] { paramString1, paramString2, paramString3, Float.valueOf(parambtm.FOB), Float.valueOf(parambtm.FOA), Integer.valueOf(paramInt), paramString4, localObject });
    AppMethodBeat.o(26548);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(26549);
    this.wpW = paramf;
    int i = dispatch(parame, this.hNF, this);
    AppMethodBeat.o(26549);
    return i;
  }
  
  public final int getType()
  {
    return 650;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26550);
    ad.d("MicroMsg.NetSceneCreatePoi", "netId:%d, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (acb)this.hNF.hNL.hNQ;
    if (this.hNF.hNL.getRetCode() != 0)
    {
      this.wpW.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26550);
      return;
    }
    this.wpX = paramq.GbG;
    ad.d("MicroMsg.NetSceneCreatePoi", "poi:" + this.wpX);
    this.wpW.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.c
 * JD-Core Version:    0.7.0.1
 */
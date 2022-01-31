package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.vz;
import com.tencent.mm.protocal.protobuf.wa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class b
  extends m
  implements k
{
  private com.tencent.mm.ai.b fsQ;
  private f peg;
  public String peh;
  
  public b(String paramString1, String paramString2, String paramString3, azt paramazt, int paramInt, LinkedList<bwc> paramLinkedList, String paramString4)
  {
    AppMethodBeat.i(22924);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new vz();
    ((b.a)localObject).fsY = new wa();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/createpoi";
    ((b.a)localObject).funcId = 650;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fsQ = ((b.a)localObject).ado();
    paramString4 = bo.bf(paramString4, "");
    localObject = bo.bf(null, "");
    vz localvz = (vz)this.fsQ.fsV.fta;
    localvz.Name = paramString1;
    localvz.wOC = paramString2;
    localvz.wOE = paramazt;
    localvz.jJu = paramInt;
    if (paramLinkedList != null) {
      localvz.wOF = paramLinkedList;
    }
    localvz.wOG = paramString4;
    localvz.wOH = ((String)localObject);
    localvz.wOD = paramString3;
    ab.d("MicroMsg.NetSceneCreatePoi", "[req] name:%s, district:%s, Street: %s lat:%f, long:%f, count:%d, tel:%s, url:%s", new Object[] { paramString1, paramString2, paramString3, Float.valueOf(paramazt.wDi), Float.valueOf(paramazt.wDh), Integer.valueOf(paramInt), paramString4, localObject });
    AppMethodBeat.o(22924);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(22925);
    this.peg = paramf;
    int i = dispatch(parame, this.fsQ, this);
    AppMethodBeat.o(22925);
    return i;
  }
  
  public final int getType()
  {
    return 650;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22926);
    ab.d("MicroMsg.NetSceneCreatePoi", "netId:%d, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (wa)this.fsQ.fsW.fta;
    if (this.fsQ.fsW.getRetCode() != 0)
    {
      this.peg.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(22926);
      return;
    }
    this.peh = paramq.wOI;
    ab.d("MicroMsg.NetSceneCreatePoi", "poi:" + this.peh);
    this.peg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(22926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.b
 * JD-Core Version:    0.7.0.1
 */
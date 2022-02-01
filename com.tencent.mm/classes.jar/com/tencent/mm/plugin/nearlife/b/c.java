package com.tencent.mm.plugin.nearlife.b;

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
import com.tencent.mm.protocal.protobuf.aes;
import com.tencent.mm.protocal.protobuf.aet;
import com.tencent.mm.protocal.protobuf.cqg;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class c
  extends q
  implements m
{
  private i GtS;
  public String GtT;
  private d lBM;
  
  public c(String paramString1, String paramString2, String paramString3, cqg paramcqg, int paramInt, LinkedList<eaf> paramLinkedList, String paramString4)
  {
    AppMethodBeat.i(26548);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new aes();
    ((d.a)localObject).lBV = new aet();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/createpoi";
    ((d.a)localObject).funcId = 650;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.lBM = ((d.a)localObject).bgN();
    paramString4 = Util.nullAs(paramString4, "");
    localObject = Util.nullAs(null, "");
    aes localaes = (aes)d.b.b(this.lBM.lBR);
    localaes.CMP = paramString1;
    localaes.Srf = paramString2;
    localaes.Srh = paramcqg;
    localaes.rVx = paramInt;
    if (paramLinkedList != null) {
      localaes.Sri = paramLinkedList;
    }
    localaes.Srj = paramString4;
    localaes.Srk = ((String)localObject);
    localaes.Srg = paramString3;
    Log.d("MicroMsg.NetSceneCreatePoi", "[req] name:%s, district:%s, Street: %s lat:%f, long:%f, count:%d, tel:%s, url:%s", new Object[] { paramString1, paramString2, paramString3, Float.valueOf(paramcqg.ScP), Float.valueOf(paramcqg.ScO), Integer.valueOf(paramInt), paramString4, localObject });
    AppMethodBeat.o(26548);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(26549);
    this.GtS = parami;
    int i = dispatch(paramg, this.lBM, this);
    AppMethodBeat.o(26549);
    return i;
  }
  
  public final int getType()
  {
    return 650;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26550);
    Log.d("MicroMsg.NetSceneCreatePoi", "netId:%d, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = (aet)d.c.b(this.lBM.lBS);
    if (this.lBM.lBS.getRetCode() != 0)
    {
      this.GtS.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26550);
      return;
    }
    this.GtT = params.Srl;
    Log.d("MicroMsg.NetSceneCreatePoi", "poi:" + this.GtT);
    this.GtS.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.nearlife.b;

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
import com.tencent.mm.protocal.protobuf.bld;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.zd;
import com.tencent.mm.protocal.protobuf.ze;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class c
  extends n
  implements k
{
  private b gUN;
  private g ubG;
  public String ubH;
  
  public c(String paramString1, String paramString2, String paramString3, bld parambld, int paramInt, LinkedList<cmf> paramLinkedList, String paramString4)
  {
    AppMethodBeat.i(26548);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new zd();
    ((b.a)localObject).gUV = new ze();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/createpoi";
    ((b.a)localObject).funcId = 650;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gUN = ((b.a)localObject).atI();
    paramString4 = bt.by(paramString4, "");
    localObject = bt.by(null, "");
    zd localzd = (zd)this.gUN.gUS.gUX;
    localzd.Name = paramString1;
    localzd.Dbi = paramString2;
    localzd.Dbk = parambld;
    localzd.mAK = paramInt;
    if (paramLinkedList != null) {
      localzd.Dbl = paramLinkedList;
    }
    localzd.Dbm = paramString4;
    localzd.Dbn = ((String)localObject);
    localzd.Dbj = paramString3;
    ad.d("MicroMsg.NetSceneCreatePoi", "[req] name:%s, district:%s, Street: %s lat:%f, long:%f, count:%d, tel:%s, url:%s", new Object[] { paramString1, paramString2, paramString3, Float.valueOf(parambld.COJ), Float.valueOf(parambld.COI), Integer.valueOf(paramInt), paramString4, localObject });
    AppMethodBeat.o(26548);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(26549);
    this.ubG = paramg;
    int i = dispatch(parame, this.gUN, this);
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
    paramq = (ze)this.gUN.gUT.gUX;
    if (this.gUN.gUT.getRetCode() != 0)
    {
      this.ubG.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26550);
      return;
    }
    this.ubH = paramq.Dbo;
    ad.d("MicroMsg.NetSceneCreatePoi", "poi:" + this.ubH);
    this.ubG.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.c
 * JD-Core Version:    0.7.0.1
 */
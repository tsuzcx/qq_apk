package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.xi;
import com.tencent.mm.protocal.protobuf.xj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class e
  extends n
  implements k
{
  private f callback;
  private b rr;
  private a xqz;
  
  public e(String paramString1, String paramString2, String paramString3, int paramInt, a parama)
  {
    AppMethodBeat.i(9462);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new xi();
    ((b.a)localObject).hNN = new xj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkmd5";
    ((b.a)localObject).funcId = 939;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (xi)this.rr.hNK.hNQ;
    ((xi)localObject).fileid = paramString1;
    ((xi)localObject).md5 = paramString2;
    ((xi)localObject).FNC = paramString3;
    ((xi)localObject).FWN = paramInt;
    this.xqz = parama;
    ad.i("MicroMsg.NetSceneCheckMd5", "summersafecdn NetSceneCheckMd5 fileid[%s], md5[%s], newmd5[%s], crc[%d], stack[%s]", new Object[] { ((xi)localObject).fileid, ((xi)localObject).md5, ((xi)localObject).FNC, Integer.valueOf(((xi)localObject).FWN), bt.flS() });
    AppMethodBeat.o(9462);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(9463);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(9463);
    return i;
  }
  
  public final int getType()
  {
    return 939;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(9464);
    ad.i("MicroMsg.NetSceneCheckMd5", "summersafecdn onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (this.xqz != null)
    {
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label101;
      }
      paramString = this.xqz;
    }
    for (;;)
    {
      paramArrayOfByte = "";
      paramq = paramString;
      for (paramString = paramArrayOfByte;; paramString = paramArrayOfByte)
      {
        paramq.at(paramString, paramInt2, paramInt3);
        AppMethodBeat.o(9464);
        return;
        label101:
        paramq = (xj)((b)paramq).hNL.hNQ;
        paramString = this.xqz;
        if (paramq == null) {
          break;
        }
        paramArrayOfByte = paramq.aeskey;
        paramq = paramString;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void at(String paramString, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.e
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.record.b;

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
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.protocal.protobuf.va;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class d
  extends n
  implements k
{
  private g callback;
  private b rr;
  private a vaa;
  
  public d(String paramString1, String paramString2, String paramString3, int paramInt, a parama)
  {
    AppMethodBeat.i(9462);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new uz();
    ((b.a)localObject).gUV = new va();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkmd5";
    ((b.a)localObject).funcId = 939;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (uz)this.rr.gUS.gUX;
    ((uz)localObject).fileid = paramString1;
    ((uz)localObject).md5 = paramString2;
    ((uz)localObject).CWS = paramString3;
    ((uz)localObject).CWT = paramInt;
    this.vaa = parama;
    ad.i("MicroMsg.NetSceneCheckMd5", "summersafecdn NetSceneCheckMd5 fileid[%s], md5[%s], newmd5[%s], crc[%d], stack[%s]", new Object[] { ((uz)localObject).fileid, ((uz)localObject).md5, ((uz)localObject).CWS, Integer.valueOf(((uz)localObject).CWT), bt.eGN() });
    AppMethodBeat.o(9462);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(9463);
    this.callback = paramg;
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
    if (this.vaa != null)
    {
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label101;
      }
      paramString = this.vaa;
    }
    for (;;)
    {
      paramArrayOfByte = "";
      paramq = paramString;
      for (paramString = paramArrayOfByte;; paramString = paramArrayOfByte)
      {
        paramq.ar(paramString, paramInt2, paramInt3);
        AppMethodBeat.o(9464);
        return;
        label101:
        paramq = (va)((b)paramq).gUT.gUX;
        paramString = this.vaa;
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
    public abstract void ar(String paramString, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.d
 * JD-Core Version:    0.7.0.1
 */
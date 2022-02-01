package com.tencent.mm.plugin.record.b;

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
import com.tencent.mm.protocal.protobuf.zb;
import com.tencent.mm.protocal.protobuf.zc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
  extends q
  implements m
{
  private a HCA;
  private i callback;
  private d rr;
  
  public e(String paramString1, String paramString2, String paramString3, int paramInt, a parama)
  {
    AppMethodBeat.i(9462);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new zb();
    ((d.a)localObject).lBV = new zc();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/checkmd5";
    ((d.a)localObject).funcId = 939;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (zb)d.b.b(this.rr.lBR);
    ((zb)localObject).fileid = paramString1;
    ((zb)localObject).md5 = paramString2;
    ((zb)localObject).SbN = paramString3;
    ((zb)localObject).Slf = paramInt;
    this.HCA = parama;
    Log.i("MicroMsg.NetSceneCheckMd5", "summersafecdn NetSceneCheckMd5 fileid[%s], md5[%s], newmd5[%s], crc[%d], stack[%s]", new Object[] { ((zb)localObject).fileid, ((zb)localObject).md5, ((zb)localObject).SbN, Integer.valueOf(((zb)localObject).Slf), Util.getStack() });
    AppMethodBeat.o(9462);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(9463);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(9463);
    return i;
  }
  
  public final int getType()
  {
    return 939;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(9464);
    Log.i("MicroMsg.NetSceneCheckMd5", "summersafecdn onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (this.HCA != null)
    {
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label101;
      }
      paramString = this.HCA;
    }
    for (;;)
    {
      paramArrayOfByte = "";
      params = paramString;
      for (paramString = paramArrayOfByte;; paramString = paramArrayOfByte)
      {
        params.aA(paramString, paramInt2, paramInt3);
        AppMethodBeat.o(9464);
        return;
        label101:
        params = (zc)d.c.b(((d)params).lBS);
        paramString = this.HCA;
        if (params == null) {
          break;
        }
        paramArrayOfByte = params.aeskey;
        params = paramString;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void aA(String paramString, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.e
 * JD-Core Version:    0.7.0.1
 */
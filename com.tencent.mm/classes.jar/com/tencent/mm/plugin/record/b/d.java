package com.tencent.mm.plugin.record.b;

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
import com.tencent.mm.protocal.protobuf.sh;
import com.tencent.mm.protocal.protobuf.si;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class d
  extends m
  implements k
{
  private f callback;
  private d.a pYh;
  private b rr;
  
  public d(String paramString1, String paramString2, String paramString3, int paramInt, d.a parama)
  {
    AppMethodBeat.i(135642);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new sh();
    ((b.a)localObject).fsY = new si();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkmd5";
    ((b.a)localObject).funcId = 939;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (sh)this.rr.fsV.fta;
    ((sh)localObject).fileid = paramString1;
    ((sh)localObject).cqq = paramString2;
    ((sh)localObject).wKF = paramString3;
    ((sh)localObject).wKG = paramInt;
    this.pYh = parama;
    ab.i("MicroMsg.NetSceneCheckMd5", "summersafecdn NetSceneCheckMd5 fileid[%s], md5[%s], newmd5[%s], crc[%d], stack[%s]", new Object[] { ((sh)localObject).fileid, ((sh)localObject).cqq, ((sh)localObject).wKF, Integer.valueOf(((sh)localObject).wKG), bo.dtY() });
    AppMethodBeat.o(135642);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(135643);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(135643);
    return i;
  }
  
  public final int getType()
  {
    return 939;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(135644);
    ab.i("MicroMsg.NetSceneCheckMd5", "summersafecdn onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (this.pYh != null)
    {
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label99;
      }
      paramString = this.pYh;
    }
    for (;;)
    {
      paramArrayOfByte = "";
      paramq = paramString;
      for (paramString = paramArrayOfByte;; paramString = paramArrayOfByte)
      {
        paramq.ar(paramString, paramInt2, paramInt3);
        AppMethodBeat.o(135644);
        return;
        label99:
        paramq = (si)((b)paramq).fsW.fta;
        paramString = this.pYh;
        if (paramq == null) {
          break;
        }
        paramArrayOfByte = paramq.aeskey;
        paramq = paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.d
 * JD-Core Version:    0.7.0.1
 */
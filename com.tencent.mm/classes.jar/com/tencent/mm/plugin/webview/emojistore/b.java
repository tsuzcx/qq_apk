package com.tencent.mm.plugin.webview.emojistore;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.drx;
import com.tencent.mm.protocal.protobuf.dry;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
  extends q
  implements m
{
  int INw;
  boolean INx;
  private i heq;
  private long rbH;
  private byte[] rcO;
  private String rcQ;
  private int rcy;
  private final d rr;
  
  public b(int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(77868);
    this.rcO = null;
    this.INw = -1;
    this.INx = true;
    this.rbH = 0L;
    d.a locala = new d.a();
    locala.iLN = new drx();
    locala.iLO = new dry();
    locala.uri = "/cgi-bin/micromsg-bin/mmsearchemotion";
    locala.funcId = 234;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.rcy = paramInt1;
    this.rcQ = paramString;
    this.rcO = paramArrayOfByte;
    this.INw = paramInt2;
    this.rbH = paramLong;
    AppMethodBeat.o(77868);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(77869);
    this.heq = parami;
    drx localdrx = (drx)this.rr.iLK.iLR;
    if (!Util.isNullOrNil(this.rcO))
    {
      localdrx.LUY = z.aC(this.rcO);
      this.INx = false;
      localdrx.LVb = this.rbH;
      if (localdrx.LUY != null) {
        break label134;
      }
    }
    label134:
    for (parami = "Buf is NULL";; parami = localdrx.LUY.toString())
    {
      Log.d("MicroMsg.emoji.NetSceneSearchEmotion", parami);
      localdrx.ReqType = this.rcy;
      localdrx.LUZ = this.rcQ;
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(77869);
      return i;
      localdrx.LUY = new SKBuiltinBuffer_t();
      this.INx = true;
      break;
    }
  }
  
  public final dry gap()
  {
    if (this.rr == null) {
      return null;
    }
    return (dry)this.rr.iLL.iLR;
  }
  
  public final int getType()
  {
    return 234;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77870);
    Log.i("MicroMsg.emoji.NetSceneSearchEmotion", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(77870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.b
 * JD-Core Version:    0.7.0.1
 */
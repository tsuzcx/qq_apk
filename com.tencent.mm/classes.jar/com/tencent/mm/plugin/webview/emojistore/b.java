package com.tencent.mm.plugin.webview.emojistore;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.csv;
import com.tencent.mm.protocal.protobuf.csw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class b
  extends n
  implements k
{
  int Cgj;
  boolean Cgk;
  private g gfX;
  private int pbR;
  private long pbb;
  private byte[] pcg;
  private String pci;
  private final com.tencent.mm.ak.b rr;
  
  public b(int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(77868);
    this.pcg = null;
    this.Cgj = -1;
    this.Cgk = true;
    this.pbb = 0L;
    b.a locala = new b.a();
    locala.hvt = new csv();
    locala.hvu = new csw();
    locala.uri = "/cgi-bin/micromsg-bin/mmsearchemotion";
    locala.funcId = 234;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.pbR = paramInt1;
    this.pci = paramString;
    this.pcg = paramArrayOfByte;
    this.Cgj = paramInt2;
    this.pbb = paramLong;
    AppMethodBeat.o(77868);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(77869);
    this.gfX = paramg;
    csv localcsv = (csv)this.rr.hvr.hvw;
    if (!bs.cv(this.pcg))
    {
      localcsv.EOe = z.al(this.pcg);
      this.Cgk = false;
      localcsv.EOh = this.pbb;
      if (localcsv.EOe != null) {
        break label134;
      }
    }
    label134:
    for (paramg = "Buf is NULL";; paramg = localcsv.EOe.toString())
    {
      ac.d("MicroMsg.emoji.NetSceneSearchEmotion", paramg);
      localcsv.ReqType = this.pbR;
      localcsv.EOf = this.pci;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(77869);
      return i;
      localcsv.EOe = new SKBuiltinBuffer_t();
      this.Cgk = true;
      break;
    }
  }
  
  public final csw ezh()
  {
    if (this.rr == null) {
      return null;
    }
    return (csw)this.rr.hvs.hvw;
  }
  
  public final int getType()
  {
    return 234;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77870);
    ac.i("MicroMsg.emoji.NetSceneSearchEmotion", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(77870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.b
 * JD-Core Version:    0.7.0.1
 */
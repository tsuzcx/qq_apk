package com.tencent.mm.plugin.webview.emojistore;

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
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.ebt;
import com.tencent.mm.protocal.protobuf.ebu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
  extends q
  implements m
{
  int PJP;
  boolean PJQ;
  private i jQg;
  private final d rr;
  private long uEM;
  private int uFD;
  private byte[] uFT;
  private String uFV;
  
  public b(int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(77868);
    this.uFT = null;
    this.PJP = -1;
    this.PJQ = true;
    this.uEM = 0L;
    d.a locala = new d.a();
    locala.lBU = new ebt();
    locala.lBV = new ebu();
    locala.uri = "/cgi-bin/micromsg-bin/mmsearchemotion";
    locala.funcId = 234;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    this.uFD = paramInt1;
    this.uFV = paramString;
    this.uFT = paramArrayOfByte;
    this.PJP = paramInt2;
    this.uEM = paramLong;
    AppMethodBeat.o(77868);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(77869);
    this.jQg = parami;
    ebt localebt = (ebt)d.b.b(this.rr.lBR);
    if (!Util.isNullOrNil(this.uFT))
    {
      localebt.TdH = z.aN(this.uFT);
      this.PJQ = false;
      localebt.TdK = this.uEM;
      if (localebt.TdH != null) {
        break label134;
      }
    }
    label134:
    for (parami = "Buf is NULL";; parami = localebt.TdH.toString())
    {
      Log.d("MicroMsg.emoji.NetSceneSearchEmotion", parami);
      localebt.lpw = this.uFD;
      localebt.TdI = this.uFV;
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(77869);
      return i;
      localebt.TdH = new eae();
      this.PJQ = true;
      break;
    }
  }
  
  public final ebu gTj()
  {
    AppMethodBeat.i(264350);
    if (this.rr == null)
    {
      AppMethodBeat.o(264350);
      return null;
    }
    ebu localebu = (ebu)d.c.b(this.rr.lBS);
    AppMethodBeat.o(264350);
    return localebu;
  }
  
  public final int getType()
  {
    return 234;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77870);
    Log.i("MicroMsg.emoji.NetSceneSearchEmotion", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(77870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.b
 * JD-Core Version:    0.7.0.1
 */
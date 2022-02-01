package com.tencent.mm.plugin.webview.emojistore;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.evk;
import com.tencent.mm.protocal.protobuf.evl;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
  extends p
  implements m
{
  int WAh;
  boolean WAi;
  private h mAY;
  private final c rr;
  private long xNo;
  private int xOf;
  private byte[] xOw;
  private String xOy;
  
  public b(int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(77868);
    this.xOw = null;
    this.WAh = -1;
    this.WAi = true;
    this.xNo = 0L;
    c.a locala = new c.a();
    locala.otE = new evk();
    locala.otF = new evl();
    locala.uri = "/cgi-bin/micromsg-bin/mmsearchemotion";
    locala.funcId = 234;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.xOf = paramInt1;
    this.xOy = paramString;
    this.xOw = paramArrayOfByte;
    this.WAh = paramInt2;
    this.xNo = paramLong;
    AppMethodBeat.o(77868);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(77869);
    this.mAY = paramh;
    evk localevk = (evk)c.b.b(this.rr.otB);
    if (!Util.isNullOrNil(this.xOw))
    {
      localevk.aaqV = w.aN(this.xOw);
      this.WAi = false;
      localevk.aaqY = this.xNo;
      if (localevk.aaqV != null) {
        break label134;
      }
    }
    label134:
    for (paramh = "Buf is NULL";; paramh = localevk.aaqV.toString())
    {
      Log.d("MicroMsg.emoji.NetSceneSearchEmotion", paramh);
      localevk.nUz = this.xOf;
      localevk.aaqW = this.xOy;
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(77869);
      return i;
      localevk.aaqV = new gol();
      this.WAi = true;
      break;
    }
  }
  
  public final int getType()
  {
    return 234;
  }
  
  public final evl isX()
  {
    AppMethodBeat.i(294768);
    if (this.rr == null)
    {
      AppMethodBeat.o(294768);
      return null;
    }
    evl localevl = (evl)c.c.b(this.rr.otC);
    AppMethodBeat.o(294768);
    return localevl;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77870);
    Log.i("MicroMsg.emoji.NetSceneSearchEmotion", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(77870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.b
 * JD-Core Version:    0.7.0.1
 */
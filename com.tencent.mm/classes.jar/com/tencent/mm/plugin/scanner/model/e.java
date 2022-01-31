package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bgd;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.clu;
import java.util.List;

public final class e
  extends m
  implements k
{
  public float angle;
  private f callback;
  public int cnU;
  public List<clu> quk;
  public long qul;
  public b rr;
  
  public e(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this(paramInt1, paramInt2, paramString1, paramString2, (byte)0);
  }
  
  private e(int paramInt1, int paramInt2, String paramString1, String paramString2, byte paramByte)
  {
    AppMethodBeat.i(80837);
    b.a locala = new b.a();
    bgd localbgd = new bgd();
    localbgd.wzU = paramInt1;
    localbgd.xuW = paramInt2;
    localbgd.xvb = paramString1;
    localbgd.xvc = paramString2;
    localbgd.Scene = 0;
    locala.fsX = localbgd;
    locala.fsY = new bge();
    locala.uri = "/cgi-bin/micromsg-bin/newocrtranslation";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.cnU = paramInt1;
    AppMethodBeat.o(80837);
  }
  
  public final String cie()
  {
    return ((bge)this.rr.fsW.fta).quo;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(80838);
    this.callback = paramf;
    this.qul = System.currentTimeMillis();
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(80838);
    return i;
  }
  
  public final int getType()
  {
    return 294;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(80839);
    this.angle = ((bge)((b)paramq).fsW.fta).xvd;
    this.quk = ((bge)((b)paramq).fsW.fta).xcb;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(80839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.e
 * JD-Core Version:    0.7.0.1
 */
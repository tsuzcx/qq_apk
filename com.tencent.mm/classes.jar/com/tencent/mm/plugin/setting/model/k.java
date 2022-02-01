package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.cul;
import com.tencent.mm.protocal.protobuf.cum;
import com.tencent.mm.protocal.protobuf.fun;
import com.tencent.mm.protocal.protobuf.fup;
import com.tencent.mm.protocal.protobuf.gol;
import java.util.Collections;
import java.util.List;

public final class k
  extends p
  implements m
{
  private boolean PnC;
  private cum PnH;
  private byte[] PnI;
  private h callback;
  
  public k(byte[] paramArrayOfByte)
  {
    this.PnI = paramArrayOfByte;
  }
  
  public k(byte[] paramArrayOfByte, byte paramByte)
  {
    this(paramArrayOfByte);
    this.PnC = true;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(73771);
    this.callback = paramh;
    paramh = new c.a();
    cul localcul = new cul();
    if (this.PnI != null) {
      localcul.aazX = w.aN(this.PnI).aaxD;
    }
    localcul.ZqT = this.PnC;
    paramh.otE = localcul;
    this.PnH = new cum();
    paramh.otF = this.PnH;
    paramh.uri = "/cgi-bin/mmbiz-bin/getuserauthlist";
    paramh.funcId = getType();
    paramh.otG = 0;
    paramh.respCmdId = 0;
    int i = dispatch(paramg, paramh.bEF(), this);
    AppMethodBeat.o(73771);
    return i;
  }
  
  public final List<fun> gUV()
  {
    AppMethodBeat.i(298558);
    if (this.PnH != null)
    {
      localObject = this.PnH.aazY;
      AppMethodBeat.o(298558);
      return localObject;
    }
    Object localObject = Collections.emptyList();
    AppMethodBeat.o(298558);
    return localObject;
  }
  
  public final byte[] gUW()
  {
    AppMethodBeat.i(298560);
    if ((this.PnH != null) && (this.PnH.aazZ == 1))
    {
      byte[] arrayOfByte = this.PnH.aazX.toByteArray();
      AppMethodBeat.o(298560);
      return arrayOfByte;
    }
    AppMethodBeat.o(298560);
    return null;
  }
  
  public final boolean gUX()
  {
    return this.PnI != null;
  }
  
  public final int getType()
  {
    return 1146;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73772);
    this.PnH = ((cum)c.c.b(((c)params).otC));
    if (this.PnH.ZqU != null)
    {
      paramInt3 = this.PnH.ZqU.hGE;
      paramString = this.PnH.ZqU.errmsg;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.k
 * JD-Core Version:    0.7.0.1
 */
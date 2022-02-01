package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.ewh;
import com.tencent.mm.protocal.protobuf.ewi;
import com.tencent.mm.protocal.protobuf.fup;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class n
  extends p
  implements m
{
  private boolean PnC;
  public byte[] PnI;
  public ewi PnL;
  private h callback;
  private String hAB;
  
  public n(String paramString, byte[] paramArrayOfByte)
  {
    this.hAB = paramString;
    this.PnI = paramArrayOfByte;
    this.PnC = true;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(73778);
    this.callback = paramh;
    paramh = new c.a();
    ewh localewh = new ewh();
    localewh.hAB = this.hAB;
    localewh.ZqT = this.PnC;
    if (this.PnI != null) {
      localewh.aazX = w.aN(this.PnI).aaxD;
    }
    paramh.otE = localewh;
    paramh.otF = new ewi();
    paramh.funcId = getType();
    paramh.uri = "/cgi-bin/mmbiz-bin/searchuserauth";
    paramh.otG = 0;
    paramh.respCmdId = 0;
    int i = dispatch(paramg, paramh.bEF(), this);
    AppMethodBeat.o(73778);
    return i;
  }
  
  public final int getType()
  {
    return 1169;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73779);
    this.PnL = ((ewi)c.c.b(((c)params).otC));
    int i;
    if (this.PnL != null)
    {
      params = this.PnL.aazX;
      i = this.PnL.aazZ;
      if (this.PnL.aazY == null) {
        break label153;
      }
    }
    label153:
    for (paramInt1 = this.PnL.aazY.size();; paramInt1 = 0)
    {
      Log.i("MicroMsg.NetSceneSearchUserAuth", "searchUserAuth nextPageData: %s, flag: %s, size: %s", new Object[] { params, Integer.valueOf(i), Integer.valueOf(paramInt1) });
      if (this.PnL.ZqU != null)
      {
        paramInt3 = this.PnL.ZqU.hGE;
        paramString = this.PnL.ZqU.errmsg;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(73779);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.n
 * JD-Core Version:    0.7.0.1
 */
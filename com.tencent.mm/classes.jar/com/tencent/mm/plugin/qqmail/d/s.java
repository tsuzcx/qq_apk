package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class s
  extends q
  implements m
{
  private String Hmk;
  private i callback;
  private final boolean fZd;
  private d rr;
  
  public s(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(122719);
    this.Hmk = "";
    this.fZd = paramBoolean;
    this.Hmk = Util.nullAsNil(paramString);
    AppMethodBeat.o(122719);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(122720);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ad();
    ((d.a)localObject).lBV = new ae();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/switchpushmail";
    ((d.a)localObject).funcId = 129;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ad)d.b.b(this.rr.lBR);
    if (this.fZd) {}
    for (int i = 1;; i = 2)
    {
      ((ad)localObject).HmX = i;
      ((ad)localObject).HmY = this.Hmk;
      this.callback = parami;
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(122720);
      return i;
    }
  }
  
  public final int getType()
  {
    return 129;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(122721);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (ae)d.c.b(this.rr.lBS);
      h.aHG().aHp().i(17, Integer.valueOf(params.HmX));
    }
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(122721);
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.s
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;

public final class r
  extends p
  implements m
{
  private String NjY;
  private com.tencent.mm.am.h callback;
  private final boolean hAJ;
  private c rr;
  
  public r(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(122719);
    this.NjY = "";
    this.hAJ = paramBoolean;
    this.NjY = Util.nullAsNil(paramString);
    AppMethodBeat.o(122719);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(122720);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ac();
    ((c.a)localObject).otF = new ad();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/switchpushmail";
    ((c.a)localObject).funcId = 129;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ac)c.b.b(this.rr.otB);
    if (this.hAJ) {}
    for (int i = 1;; i = 2)
    {
      ((ac)localObject).NkL = i;
      ((ac)localObject).NkM = this.NjY;
      this.callback = paramh;
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(122720);
      return i;
    }
  }
  
  public final int getType()
  {
    return 129;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(122721);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (ad)c.c.b(this.rr.otC);
      com.tencent.mm.kernel.h.baE().ban().B(17, Integer.valueOf(params.NkL));
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
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.r
 * JD-Core Version:    0.7.0.1
 */
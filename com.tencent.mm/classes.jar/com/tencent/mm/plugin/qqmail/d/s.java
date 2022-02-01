package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class s
  extends q
  implements m
{
  private String BrR;
  private i callback;
  private final boolean eeO;
  private d rr;
  
  public s(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(122719);
    this.BrR = "";
    this.eeO = paramBoolean;
    this.BrR = Util.nullAsNil(paramString);
    AppMethodBeat.o(122719);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(122720);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ad();
    ((d.a)localObject).iLO = new ae();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/switchpushmail";
    ((d.a)localObject).funcId = 129;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ad)this.rr.iLK.iLR;
    if (this.eeO) {}
    for (int i = 1;; i = 2)
    {
      ((ad)localObject).BsD = i;
      ((ad)localObject).BsE = this.BrR;
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
      params = (ae)this.rr.iLL.iLR;
      com.tencent.mm.kernel.g.aAh().azQ().set(17, Integer.valueOf(params.BsD));
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
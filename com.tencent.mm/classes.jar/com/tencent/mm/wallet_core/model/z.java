package com.tencent.mm.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.c;
import com.tencent.mm.am.p;
import com.tencent.mm.cp.f;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.wallet_core.ui.g;

public class z<_Resp extends esc>
  extends b<_Resp>
{
  public final void a(int paramInt1, int paramInt2, String paramString, _Resp param_Resp, p paramp)
  {
    AppMethodBeat.i(242146);
    super.a(paramInt1, paramInt2, paramString, param_Resp, paramp);
    if (this.rr != null) {
      g.aGu(this.rr.getType());
    }
    AppMethodBeat.o(242146);
  }
  
  public final f<b.a<_Resp>> bFJ()
  {
    try
    {
      AppMethodBeat.i(242144);
      if (this.rr != null) {
        g.aGt(this.rr.getType());
      }
      f localf = super.bFJ();
      AppMethodBeat.o(242144);
      return localf;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.model.z
 * JD-Core Version:    0.7.0.1
 */
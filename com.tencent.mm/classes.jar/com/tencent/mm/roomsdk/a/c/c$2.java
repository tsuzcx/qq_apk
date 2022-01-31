package com.tencent.mm.roomsdk.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.roomsdk.a.b.a;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.ui.base.p;

final class c$2
  implements i.a
{
  c$2(c paramc) {}
  
  public final void x(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(80265);
    ((j)g.E(j.class)).Yz().b(this.yjP.yjM.getCmdId(), this.yjP.yjO);
    if (this.yjP.yjN)
    {
      AppMethodBeat.o(80265);
      return;
    }
    this.yjP.yjN = true;
    if (this.yjP.yjK != null)
    {
      if ((this.yjP.yjK instanceof e))
      {
        e locale = (e)this.yjP.yjK;
        locale.ret = paramInt;
        locale.title = paramString1;
        locale.content = paramString2;
      }
      this.yjP.yjK.a(0, paramInt, "", this.yjP.yjK);
    }
    if (this.yjP.tipDialog != null) {
      this.yjP.tipDialog.dismiss();
    }
    AppMethodBeat.o(80265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.c.2
 * JD-Core Version:    0.7.0.1
 */
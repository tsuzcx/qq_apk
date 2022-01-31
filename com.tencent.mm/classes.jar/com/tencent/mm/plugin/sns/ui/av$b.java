package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vending.base.Vending;

public final class av$b
  implements ao.b.a
{
  int mPosition;
  w rXg = null;
  
  public av$b(w paramw, int paramInt)
  {
    this.rXg = paramw;
    this.mPosition = paramInt;
  }
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(39414);
    if (paramBoolean)
    {
      g.RM();
      if (g.RJ().QU()) {
        ag.bEf().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(39413);
            if (av.b.this.rXg.ctE() != null) {
              av.b.this.rXg.ctE().request(Integer.valueOf(av.b.this.mPosition));
            }
            av.b.this.rXg.notifyDataSetChanged();
            AppMethodBeat.o(39413);
          }
        });
      }
    }
    AppMethodBeat.o(39414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.av.b
 * JD-Core Version:    0.7.0.1
 */
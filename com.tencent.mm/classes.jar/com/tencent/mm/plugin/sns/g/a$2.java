package com.tencent.mm.plugin.sns.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bx;

final class a$2
  implements Runnable
{
  a$2(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(307303);
    try
    {
      if ((int)this.Qkx.xVS.maN == 0) {
        this.Qkx.onc.aC(this.Qkx.xVS);
      }
      if ((int)this.Qkx.xVS.maN <= 0)
      {
        Log.e("HalfScreenAddBrandController", "addContact : insert contact failed");
        AppMethodBeat.o(307303);
        return;
      }
      ab.I(this.Qkx.xVS);
      AppMethodBeat.o(307303);
      return;
    }
    finally
    {
      Log.e("HalfScreenAddBrandController", localObject.toString());
      AppMethodBeat.o(307303);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.a.2
 * JD-Core Version:    0.7.0.1
 */
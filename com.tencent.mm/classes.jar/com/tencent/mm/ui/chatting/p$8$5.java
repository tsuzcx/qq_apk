package com.tencent.mm.ui.chatting;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d.a;

final class p$8$5
  implements d.a
{
  p$8$5(p.8 param8) {}
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(156117);
    if (paramInt1 == 227) {
      p.a(this.zyW.zyT, p.e(this.zyW.zyT), paramInt2, paramIntent);
    }
    AppMethodBeat.o(156117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.p.8.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.chatting;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d.a;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.d.a;

final class n$1
  implements d.a
{
  n$1(a parama) {}
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(30617);
    paramIntent = (i)this.zyx.ay(i.class);
    if ((-1 == paramInt2) && (paramIntent != null) && (paramIntent.dHW())) {
      paramIntent.dHU();
    }
    AppMethodBeat.o(30617);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.1
 * JD-Core Version:    0.7.0.1
 */
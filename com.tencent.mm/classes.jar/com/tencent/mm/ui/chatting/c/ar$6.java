package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.c.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;

final class ar$6
  implements c.a
{
  ar$6(ar paramar) {}
  
  public final void b(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(31850);
    if (paramInt1 == -50002) {
      Toast.makeText(this.zJf.caz.zJz.getContext(), this.zJf.caz.zJz.getContext().getString(2131304514), 0).show();
    }
    for (;;)
    {
      this.zJf.caz.dismissDialog();
      AppMethodBeat.o(31850);
      return;
      if (paramInt1 < 0)
      {
        Toast.makeText(this.zJf.caz.zJz.getContext(), this.zJf.caz.zJz.getContext().getString(2131304513), 0).show();
      }
      else
      {
        u.c(paramString1, paramInt2, this.zJf.caz.getTalkerUserName(), paramString2);
        u.vm(paramString1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ar.6
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.music.f;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.plugin.music.c.b.b;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.h.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;

final class d$2
  implements b.b
{
  d$2(d paramd) {}
  
  public final void Ad(final int paramInt)
  {
    AppMethodBeat.i(137584);
    if (paramInt == 1)
    {
      if ((this.paL.pao != null) && (!this.paL.oXo) && (this.paL.paG != null))
      {
        Object localObject = com.tencent.mm.plugin.music.h.b.bc(this.paL.pao.oYB.fKj, this.paL.pao.muY);
        this.paL.paG.VE((String)localObject);
        localObject = this.paL;
        if (k.bVJ().requestFocus())
        {
          ab.i("MicroMsg.Music.MusicPlayer", "startPlay");
          try
          {
            if (((d)localObject).paG != null) {
              ((d)localObject).paG.play();
            }
            ((d)localObject).oXo = true;
            ((d)localObject).paH = false;
            AppMethodBeat.o(137584);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ab.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "startPlay", new Object[0]);
            }
          }
        }
        ab.e("MicroMsg.Music.MusicPlayer", "request focus error");
        AppMethodBeat.o(137584);
      }
    }
    else
    {
      if ((paramInt == -2) || (paramInt == 5) || (paramInt == 19))
      {
        al.d(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(137582);
            Toast.makeText(ah.getContext(), ah.getContext().getString(2131301735), 0).show();
            d.a(d.2.this.paL, d.2.this.paL.oYI, paramInt);
            AppMethodBeat.o(137582);
          }
        });
        AppMethodBeat.o(137584);
        return;
      }
      if ((paramInt == -1) || (paramInt == 6) || (paramInt == 4))
      {
        al.d(new d.2.2(this));
        d.a(this.paL, this.paL.oYI, paramInt);
      }
    }
    AppMethodBeat.o(137584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.d.2
 * JD-Core Version:    0.7.0.1
 */
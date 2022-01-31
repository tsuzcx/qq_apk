package com.tencent.mm.plugin.voip.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class VoipBaseFragment$c$1
  implements ap.a
{
  VoipBaseFragment$c$1(VoipBaseFragment.c paramc) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(4848);
    int i = this.tCK.tCH[(this.tCK.tCJ % this.tCK.tCH.length)];
    if (this.tCK.md != null)
    {
      if (-1 != i) {
        break label80;
      }
      this.tCK.md.setText(null);
    }
    for (;;)
    {
      VoipBaseFragment.c localc = this.tCK;
      localc.tCJ += 1;
      AppMethodBeat.o(4848);
      return true;
      label80:
      this.tCK.md.setText(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBaseFragment.c.1
 * JD-Core Version:    0.7.0.1
 */
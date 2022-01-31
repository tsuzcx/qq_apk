package com.tencent.mm.plugin.voip_cs.b.a;

import android.os.Message;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class b$4
  extends ak
{
  b$4(b paramb) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(135321);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(135321);
      return;
      if (this.tLv.tLu != null)
      {
        b.g(this.tLv).setImageDrawable(this.tLv.tLu);
        AppMethodBeat.o(135321);
        return;
      }
      b.g(this.tLv).setImageResource(2130838493);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.b.4
 * JD-Core Version:    0.7.0.1
 */
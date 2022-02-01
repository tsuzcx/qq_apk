package com.tencent.mm.plugin.notification.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.f.a.hb;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.EventCenter;

final class f$7
  extends o.a
{
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(26801);
    if ((h.aHB()) && (h.aHE().kbT))
    {
      h.aHE();
      if (!b.aGE())
      {
        paramString = new hb();
        paramString.fDE.isActive = false;
        EventCenter.instance.publish(paramString);
      }
    }
    AppMethodBeat.o(26801);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(26800);
    if ((h.aHB()) && (h.aHE().kbT))
    {
      h.aHE();
      if (!b.aGE())
      {
        paramString = new hb();
        paramString.fDE.isActive = true;
        EventCenter.instance.publish(paramString);
      }
    }
    AppMethodBeat.o(26800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.f.7
 * JD-Core Version:    0.7.0.1
 */
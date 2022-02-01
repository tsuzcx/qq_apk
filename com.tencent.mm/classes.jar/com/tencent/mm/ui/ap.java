package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.zf;
import com.tencent.mm.sdk.event.EventCenter;

public final class ap
{
  public static void dk(int paramInt, String paramString)
  {
    AppMethodBeat.i(141491);
    if (EventCenter.instance != null)
    {
      zf localzf = new zf();
      localzf.fYB.className = paramString;
      localzf.fYB.fYC = paramInt;
      EventCenter.instance.publish(localzf);
    }
    AppMethodBeat.o(141491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.ap
 * JD-Core Version:    0.7.0.1
 */
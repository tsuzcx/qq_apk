package com.tencent.mm.plugin.offline.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ak;

public final class d
  extends c<tg>
{
  private ak mHandler;
  
  public d()
  {
    AppMethodBeat.i(43501);
    this.mHandler = new ak(Looper.getMainLooper());
    this.__eventId = tg.class.getName().hashCode();
    AppMethodBeat.o(43501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.d
 * JD-Core Version:    0.7.0.1
 */
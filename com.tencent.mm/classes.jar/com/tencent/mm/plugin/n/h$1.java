package com.tencent.mm.plugin.n;

import android.os.Process;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class h$1
  implements Runnable
{
  h$1(h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(208742);
    Toast.makeText(MMApplicationContext.getContext(), String.format("MediaCodecProxy queueInputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) }), 1).show();
    AppMethodBeat.o(208742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.n.h.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.o;

import android.os.Process;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class h$2
  implements Runnable
{
  h$2(h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(220262);
    Toast.makeText(ak.getContext(), String.format("MediaCodecProxy dequeueInputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) }), 1).show();
    AppMethodBeat.o(220262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.o.h.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher.PhoneCallListener;
import java.util.ArrayList;
import java.util.Iterator;

final class i$9
  implements PhoneStatusWatcher.PhoneCallListener
{
  i$9(i parami) {}
  
  public final void onPhoneCall(int paramInt)
  {
    AppMethodBeat.i(257171);
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "onPhoneCall state:%d", new Object[] { Integer.valueOf(paramInt) });
    synchronized (this.FOz.FOg)
    {
      Iterator localIterator = this.FOz.FOg.iterator();
      if (localIterator.hasNext()) {
        ((k)localIterator.next()).onPhoneCall(paramInt);
      }
    }
    AppMethodBeat.o(257171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.i.9
 * JD-Core Version:    0.7.0.1
 */
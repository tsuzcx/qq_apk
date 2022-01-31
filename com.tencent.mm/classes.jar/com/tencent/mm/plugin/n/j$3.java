package com.tencent.mm.plugin.n;

import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;

final class j$3
  implements ak.a
{
  j$3(j paramj) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(117894);
    if (this.oFs.oFo == null)
    {
      AppMethodBeat.o(117894);
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(117894);
      return false;
      if (!this.oFs.oFo.prepare())
      {
        ab.i("MicroMsg.VideoPlayerImpl", "%s audio track prepare error, release now.", new Object[] { this.oFs.oEN.bau() });
        this.oFs.oFo.release();
        this.oFs.oFn = true;
        this.oFs.oFo = null;
      }
      j.a(this.oFs, this.oFs.oFi, SystemClock.elapsedRealtime(), 0L);
      continue;
      if (d.zd(this.oFs.oFo.state))
      {
        this.oFs.oFj.obtainMessage(9).sendToTarget();
        this.oFs.oFi.removeMessages(2);
      }
      else
      {
        if (d.yZ(this.oFs.oFo.O(this.oFs.axe, this.oFs.oFk))) {
          this.oFs.oFj.sendMessageDelayed(this.oFs.oFj.obtainMessage(2), 10L);
        }
        if (this.oFs.state == 3)
        {
          j.a(this.oFs, this.oFs.oFi, SystemClock.elapsedRealtime(), this.oFs.oEN.oEI);
        }
        else if (this.oFs.state == 5)
        {
          j.a(this.oFs, this.oFs.oFi, SystemClock.elapsedRealtime(), 0L);
        }
        else if (this.oFs.state == 1)
        {
          j.a(this.oFs, this.oFs.oFi, SystemClock.elapsedRealtime(), 0L);
        }
        else if (this.oFs.state == 0)
        {
          j.a(this.oFs, this.oFs.oFi, SystemClock.elapsedRealtime(), 0L);
        }
        else
        {
          this.oFs.oFi.removeMessages(2);
          continue;
          this.oFs.oFo.start();
          j.a(this.oFs, this.oFs.oFi, SystemClock.elapsedRealtime(), 0L);
          continue;
          j.a(this.oFs, this.oFs.oFi, SystemClock.elapsedRealtime(), 0L);
          this.oFs.oFo.pause();
          continue;
          this.oFs.oFo.release();
          this.oFs.oFn = true;
          this.oFs.oFj.obtainMessage(0).sendToTarget();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.n.j.3
 * JD-Core Version:    0.7.0.1
 */
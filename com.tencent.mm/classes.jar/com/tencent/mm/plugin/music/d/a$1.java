package com.tencent.mm.plugin.music.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.v;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  extends Handler
{
  a$1(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (100 == paramMessage.what)
    {
      y.i("MicroMsg.Music.ExoMusicPlayer", "duration:%d, position:%d, bufferSize:%d, percent:%d", new Object[] { Long.valueOf(this.myP.myE.getDuration()), Long.valueOf(this.myP.myE.getCurrentPosition()), Long.valueOf(this.myP.myE.getBufferedPosition()), Long.valueOf(this.myP.myE.getBufferedPercentage()) });
      this.myP.gmh.removeMessages(100);
      if (this.myP.mxr) {
        this.myP.gmh.sendEmptyMessageDelayed(100, 5000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.d.a.1
 * JD-Core Version:    0.7.0.1
 */
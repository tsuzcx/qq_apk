package com.tencent.qqmusic.mediaplayer;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/qqmusic/mediaplayer/PlayStuckMonitor;", "", "()V", "mCallback", "Lkotlin/Function3;", "", "", "", "mEnable", "mHandler", "Landroid/os/Handler;", "mHandlerThread", "Landroid/os/HandlerThread;", "init", "onPlayStuck", "decodeTime", "playTime", "continuous", "setOnPlayStuckListener", "callback", "player_qqmusic_release"})
public final class PlayStuckMonitor
{
  public static final PlayStuckMonitor INSTANCE;
  private static q<? super Long, ? super Long, ? super Boolean, x> mCallback;
  private static boolean mEnable;
  private static Handler mHandler;
  private static HandlerThread mHandlerThread;
  
  static
  {
    AppMethodBeat.i(244947);
    INSTANCE = new PlayStuckMonitor();
    AppMethodBeat.o(244947);
  }
  
  public final void init()
  {
    AppMethodBeat.i(244940);
    HandlerThread localHandlerThread = new HandlerThread("PlayStuckMonitor");
    mHandlerThread = localHandlerThread;
    localHandlerThread.start();
    localHandlerThread = mHandlerThread;
    if (localHandlerThread == null) {
      p.bGy("mHandlerThread");
    }
    mHandler = new Handler(localHandlerThread.getLooper());
    AppMethodBeat.o(244940);
  }
  
  public final void onPlayStuck(long paramLong1, long paramLong2, final boolean paramBoolean)
  {
    AppMethodBeat.i(244945);
    if (mEnable)
    {
      Handler localHandler = mHandler;
      if (localHandler == null) {
        p.bGy("mHandler");
      }
      localHandler.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(244907);
          PlayStuckMonitor.access$getMCallback$p(PlayStuckMonitor.INSTANCE).c(Long.valueOf(this.$decodeTime), Long.valueOf(paramBoolean), Boolean.valueOf(this.$continuous));
          AppMethodBeat.o(244907);
        }
      });
    }
    AppMethodBeat.o(244945);
  }
  
  public final void setOnPlayStuckListener(q<? super Long, ? super Long, ? super Boolean, x> paramq)
  {
    AppMethodBeat.i(244943);
    p.k(paramq, "callback");
    mCallback = paramq;
    mEnable = true;
    AppMethodBeat.o(244943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.PlayStuckMonitor
 * JD-Core Version:    0.7.0.1
 */
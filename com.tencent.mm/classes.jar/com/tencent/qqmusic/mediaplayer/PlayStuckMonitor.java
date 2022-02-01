package com.tencent.qqmusic.mediaplayer;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmusic/mediaplayer/PlayStuckMonitor;", "", "()V", "mCallback", "Lkotlin/Function3;", "", "", "", "mEnable", "mHandler", "Landroid/os/Handler;", "mHandlerThread", "Landroid/os/HandlerThread;", "init", "onPlayStuck", "decodeTime", "playTime", "continuous", "setOnPlayStuckListener", "callback", "player_qqmusic_release"}, k=1, mv={1, 1, 16})
public final class PlayStuckMonitor
{
  public static final PlayStuckMonitor INSTANCE;
  private static q<? super Long, ? super Long, ? super Boolean, ah> mCallback;
  private static boolean mEnable;
  private static Handler mHandler;
  private static HandlerThread mHandlerThread;
  
  static
  {
    AppMethodBeat.i(212348);
    INSTANCE = new PlayStuckMonitor();
    AppMethodBeat.o(212348);
  }
  
  public final void init()
  {
    AppMethodBeat.i(212354);
    HandlerThread localHandlerThread = new HandlerThread("PlayStuckMonitor");
    mHandlerThread = localHandlerThread;
    localHandlerThread.start();
    localHandlerThread = mHandlerThread;
    if (localHandlerThread == null) {
      s.bIx("mHandlerThread");
    }
    mHandler = new Handler(localHandlerThread.getLooper());
    AppMethodBeat.o(212354);
  }
  
  public final void onPlayStuck(long paramLong1, long paramLong2, final boolean paramBoolean)
  {
    AppMethodBeat.i(212356);
    if (mEnable)
    {
      Handler localHandler = mHandler;
      if (localHandler == null) {
        s.bIx("mHandler");
      }
      localHandler.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(212343);
          PlayStuckMonitor.access$getMCallback$p(PlayStuckMonitor.INSTANCE).invoke(Long.valueOf(this.$decodeTime), Long.valueOf(paramBoolean), Boolean.valueOf(this.$continuous));
          AppMethodBeat.o(212343);
        }
      });
    }
    AppMethodBeat.o(212356);
  }
  
  public final void setOnPlayStuckListener(q<? super Long, ? super Long, ? super Boolean, ah> paramq)
  {
    AppMethodBeat.i(212355);
    s.t(paramq, "callback");
    mCallback = paramq;
    mEnable = true;
    AppMethodBeat.o(212355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.PlayStuckMonitor
 * JD-Core Version:    0.7.0.1
 */
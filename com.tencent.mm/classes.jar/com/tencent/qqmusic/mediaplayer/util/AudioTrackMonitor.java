package com.tencent.qqmusic.mediaplayer.util;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class AudioTrackMonitor
{
  private static final boolean ENABLE = false;
  private static final String TAG = "AudioTrackMonitor";
  private WeakReference<AudioTrack> mAudioTrackRef;
  private StringBuilder mBuilder;
  private long mLastPosition;
  private long mLastTime;
  private int mLooperTime;
  private Thread mMonitorThread;
  private boolean mStop;
  
  public AudioTrackMonitor(AudioTrack paramAudioTrack)
  {
    AppMethodBeat.i(114163);
    this.mLastTime = System.nanoTime();
    this.mLastPosition = 0L;
    this.mLooperTime = 200;
    this.mAudioTrackRef = null;
    this.mStop = false;
    this.mBuilder = new StringBuilder(100);
    this.mMonitorThread = new Thread("Monitor-AudioTrack")
    {
      public void run()
      {
        AppMethodBeat.i(114169);
        super.run();
        while (!AudioTrackMonitor.this.mStop) {
          try
          {
            Thread.currentThread();
            Thread.sleep(AudioTrackMonitor.this.mLooperTime);
            try
            {
              if ((AudioTrackMonitor.this.mAudioTrackRef != null) && (AudioTrackMonitor.this.mAudioTrackRef.get() != null))
              {
                AudioTrack localAudioTrack = (AudioTrack)AudioTrackMonitor.this.mAudioTrackRef.get();
                if (localAudioTrack == null) {
                  continue;
                }
                int i = localAudioTrack.getPlaybackHeadPosition();
                long l1 = i;
                long l2 = AudioTrackMonitor.this.mLastPosition;
                AudioTrackMonitor.access$302(AudioTrackMonitor.this, i);
                long l3 = System.nanoTime();
                long l4 = AudioTrackMonitor.this.mLastTime;
                AudioTrackMonitor.access$402(AudioTrackMonitor.this, System.nanoTime());
                AudioTrackMonitor.this.mBuilder.append("play-speedTime-").append(l3 - l4).append(",play-speedPosition-").append(l1 - l2);
                AudioTrackMonitor.this.mBuilder.append(",playstate-").append(localAudioTrack.getPlayState());
                Logger.e("AudioTrackMonitor", AudioTrackMonitor.this.mBuilder.toString());
                AudioTrackMonitor.this.mBuilder.delete(0, AudioTrackMonitor.this.mBuilder.length());
              }
            }
            catch (Throwable localThrowable1)
            {
              Logger.e("AudioTrackMonitor", localThrowable1);
            }
          }
          catch (Throwable localThrowable2)
          {
            for (;;)
            {
              Logger.e("AudioTrackMonitor", localThrowable2);
            }
            AppMethodBeat.o(114169);
            return;
          }
        }
        AppMethodBeat.o(114169);
      }
    };
    this.mAudioTrackRef = new WeakReference(paramAudioTrack);
    AppMethodBeat.o(114163);
  }
  
  public void start() {}
  
  public void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.AudioTrackMonitor
 * JD-Core Version:    0.7.0.1
 */
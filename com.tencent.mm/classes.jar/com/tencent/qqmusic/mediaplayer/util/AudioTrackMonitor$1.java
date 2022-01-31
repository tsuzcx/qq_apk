package com.tencent.qqmusic.mediaplayer.util;

import android.media.AudioTrack;
import java.lang.ref.WeakReference;

class AudioTrackMonitor$1
  extends Thread
{
  AudioTrackMonitor$1(AudioTrackMonitor paramAudioTrackMonitor, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    super.run();
    for (;;)
    {
      if (!AudioTrackMonitor.access$000(this.this$0)) {
        try
        {
          Thread.currentThread();
          Thread.sleep(AudioTrackMonitor.access$100(this.this$0));
          try
          {
            if ((AudioTrackMonitor.access$200(this.this$0) != null) && (AudioTrackMonitor.access$200(this.this$0).get() != null))
            {
              AudioTrack localAudioTrack = (AudioTrack)AudioTrackMonitor.access$200(this.this$0).get();
              if (localAudioTrack != null)
              {
                int i = localAudioTrack.getPlaybackHeadPosition();
                long l1 = i;
                long l2 = AudioTrackMonitor.access$300(this.this$0);
                AudioTrackMonitor.access$302(this.this$0, i);
                long l3 = System.nanoTime();
                long l4 = AudioTrackMonitor.access$400(this.this$0);
                AudioTrackMonitor.access$402(this.this$0, System.nanoTime());
                AudioTrackMonitor.access$500(this.this$0).append("play-speedTime-").append(l3 - l4).append(",play-speedPosition-").append(l1 - l2);
                AudioTrackMonitor.access$500(this.this$0).append(",playstate-").append(localAudioTrack.getPlayState());
                Logger.e("AudioTrackMonitor", AudioTrackMonitor.access$500(this.this$0).toString());
                AudioTrackMonitor.access$500(this.this$0).delete(0, AudioTrackMonitor.access$500(this.this$0).length());
              }
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
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.AudioTrackMonitor.1
 * JD-Core Version:    0.7.0.1
 */
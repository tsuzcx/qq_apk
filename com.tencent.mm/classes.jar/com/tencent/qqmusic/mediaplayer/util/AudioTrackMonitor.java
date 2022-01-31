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
    AppMethodBeat.i(128387);
    this.mLastTime = System.nanoTime();
    this.mLastPosition = 0L;
    this.mLooperTime = 200;
    this.mAudioTrackRef = null;
    this.mStop = false;
    this.mBuilder = new StringBuilder(100);
    this.mMonitorThread = new AudioTrackMonitor.1(this, "Monitor-AudioTrack");
    this.mAudioTrackRef = new WeakReference(paramAudioTrack);
    AppMethodBeat.o(128387);
  }
  
  public void start() {}
  
  public void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.AudioTrackMonitor
 * JD-Core Version:    0.7.0.1
 */
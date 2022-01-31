package com.tencent.qqmusic.mediaplayer.util;

import android.media.AudioTrack;
import java.lang.ref.WeakReference;

public class AudioTrackMonitor
{
  private static final boolean ENABLE = false;
  private static final String TAG = "AudioTrackMonitor";
  private WeakReference<AudioTrack> mAudioTrackRef = null;
  private StringBuilder mBuilder = new StringBuilder(100);
  private long mLastPosition = 0L;
  private long mLastTime = System.nanoTime();
  private int mLooperTime = 200;
  private Thread mMonitorThread = new AudioTrackMonitor.1(this, "Monitor-AudioTrack");
  private boolean mStop = false;
  
  public AudioTrackMonitor(AudioTrack paramAudioTrack)
  {
    this.mAudioTrackRef = new WeakReference(paramAudioTrack);
  }
  
  public void start() {}
  
  public void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.AudioTrackMonitor
 * JD-Core Version:    0.7.0.1
 */
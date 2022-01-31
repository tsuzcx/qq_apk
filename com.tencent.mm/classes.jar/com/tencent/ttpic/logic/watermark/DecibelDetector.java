package com.tencent.ttpic.logic.watermark;

import android.media.MediaRecorder;
import com.tencent.util.g;

public class DecibelDetector
{
  public static final int MAX_LENGTH = 600000;
  private static final String TAG = DecibelDetector.class.getSimpleName();
  private static DecibelDetector mInstance;
  private String filePath = "/dev/null";
  private final Object lock = new Object();
  private MediaRecorder mMediaRecorder;
  
  public static DecibelDetector getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DecibelDetector();
      }
      DecibelDetector localDecibelDetector = mInstance;
      return localDecibelDetector;
    }
    finally {}
  }
  
  public void destroy()
  {
    synchronized (this.lock)
    {
      try
      {
        if (this.mMediaRecorder != null)
        {
          this.mMediaRecorder.stop();
          this.mMediaRecorder.reset();
          this.mMediaRecorder.release();
          this.mMediaRecorder = null;
        }
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (this.mMediaRecorder != null)
          {
            this.mMediaRecorder.reset();
            this.mMediaRecorder.release();
            this.mMediaRecorder = null;
          }
        }
      }
    }
  }
  
  public int getDecibel()
  {
    int i = 0;
    if (this.mMediaRecorder == null) {
      init();
    }
    double d = this.mMediaRecorder.getMaxAmplitude();
    if (d > 1.0D) {
      i = (int)(20.0D * Math.log10(d));
    }
    return i;
  }
  
  public void init()
  {
    synchronized (this.lock)
    {
      if (this.mMediaRecorder != null) {
        return;
      }
      startRecord();
      return;
    }
  }
  
  public void startRecord()
  {
    if (this.mMediaRecorder == null) {
      this.mMediaRecorder = new MediaRecorder();
    }
    try
    {
      this.mMediaRecorder.setAudioSource(1);
      this.mMediaRecorder.setOutputFormat(0);
      this.mMediaRecorder.setAudioEncoder(1);
      this.mMediaRecorder.setOutputFile(this.filePath);
      this.mMediaRecorder.setMaxDuration(600000);
      this.mMediaRecorder.prepare();
      this.mMediaRecorder.start();
      return;
    }
    catch (Exception localException)
    {
      g.i(TAG, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.logic.watermark.DecibelDetector
 * JD-Core Version:    0.7.0.1
 */
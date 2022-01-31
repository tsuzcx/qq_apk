package com.tencent.ttpic.util;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;

final class AudioUtils$5
  implements MediaRecorder.OnErrorListener
{
  public final void onError(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2)
  {
    AudioUtils.destroyRecorder((AudioUtils.Recorder)paramMediaRecorder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.AudioUtils.5
 * JD-Core Version:    0.7.0.1
 */
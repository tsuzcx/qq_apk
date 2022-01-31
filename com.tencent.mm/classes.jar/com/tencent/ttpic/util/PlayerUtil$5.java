package com.tencent.ttpic.util;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class PlayerUtil$5
  implements MediaRecorder.OnErrorListener
{
  public final void onError(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50275);
    PlayerUtil.destroyRecorder((PlayerUtil.Recorder)paramMediaRecorder);
    AppMethodBeat.o(50275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.util.PlayerUtil.5
 * JD-Core Version:    0.7.0.1
 */
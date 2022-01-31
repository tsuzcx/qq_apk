package com.tencent.ttpic.recorder;

import android.annotation.TargetApi;
import android.hardware.Camera.Parameters;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class VideoParam
{
  private static final int BPS = 4194304;
  private static final int FPS = 25;
  private static final int IFI = 5;
  private static final String MIME = "video/avc";
  private static final String SDCARD;
  private static final String TAG = "VideoParam";
  private static final int VIDEO_H = 480;
  private static final int VIDEO_W = 640;
  public int mBps = 4194304;
  public int[] mFpsRange;
  public int mIfi = 5;
  public String mMime = "video/avc";
  
  static
  {
    AppMethodBeat.i(83728);
    SDCARD = Environment.getExternalStorageDirectory().getPath();
    AppMethodBeat.o(83728);
  }
  
  public int getMaxFps()
  {
    if ((this.mFpsRange == null) || (this.mFpsRange.length <= 1)) {
      return 25;
    }
    return this.mFpsRange[1] / 1000;
  }
  
  @TargetApi(18)
  public void init(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(83727);
    if (paramParameters == null)
    {
      AppMethodBeat.o(83727);
      return;
    }
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramParameters.getSupportedPreviewFpsRange() != null)
    {
      Iterator localIterator = paramParameters.getSupportedPreviewFpsRange().iterator();
      paramParameters = localObject2;
      localObject1 = paramParameters;
      if (localIterator.hasNext())
      {
        localObject1 = (int[])localIterator.next();
        if (localObject1[1] < 25000) {
          break label109;
        }
        paramParameters = (Camera.Parameters)localObject1;
      }
    }
    label109:
    for (;;)
    {
      break;
      if (localObject1 == null) {
        String.format("Not support fps: %d", new Object[] { Integer.valueOf(25) });
      }
      this.mFpsRange = ((int[])localObject1);
      AppMethodBeat.o(83727);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.recorder.VideoParam
 * JD-Core Version:    0.7.0.1
 */
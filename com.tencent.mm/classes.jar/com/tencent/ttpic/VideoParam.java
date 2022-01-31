package com.tencent.ttpic;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

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
  public static int mBps;
  public static int mIfi;
  public static String mMime;
  public int[] mFpsRange;
  
  static
  {
    AppMethodBeat.i(49576);
    SDCARD = Environment.getExternalStorageDirectory().getPath();
    mMime = "video/avc";
    mBps = 4194304;
    mIfi = 5;
    AppMethodBeat.o(49576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.VideoParam
 * JD-Core Version:    0.7.0.1
 */
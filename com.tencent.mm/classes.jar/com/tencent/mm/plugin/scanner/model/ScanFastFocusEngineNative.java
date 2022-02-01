package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.sdk.platformtools.ad;

public class ScanFastFocusEngineNative
{
  private static final String TAG = "MicroMsg.ScanFastFocusEngineNative";
  public byte[] bestImageData;
  public int bestImageId;
  public GoodsObject cropObject;
  public int height;
  public int pointCount;
  public ScanPoint[] points;
  public int result;
  public int width;
  
  static
  {
    AppMethodBeat.i(51649);
    try
    {
      System.loadLibrary("ffengine");
      System.loadLibrary("focusEngineJni");
      AppMethodBeat.o(51649);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.ScanFastFocusEngineNative", localException, "alvinluo FocusEngine init exception", new Object[0]);
      AppMethodBeat.o(51649);
    }
  }
  
  public ScanFastFocusEngineNative()
  {
    AppMethodBeat.i(51647);
    this.result = 0;
    this.width = 0;
    this.height = 0;
    this.points = new ScanPoint[10];
    this.pointCount = 0;
    this.cropObject = new GoodsObject();
    ad.i("MicroMsg.ScanFastFocusEngineNative", "alvinluo ScanFastFocusEngineNative constructor %s", new Object[] { Integer.valueOf(hashCode()) });
    init();
    AppMethodBeat.o(51647);
  }
  
  private void init()
  {
    AppMethodBeat.i(51648);
    int i = 0;
    while (i < this.points.length)
    {
      this.points[i] = new ScanPoint();
      i += 1;
    }
    AppMethodBeat.o(51648);
  }
  
  public native ScanImagePHashInfo computeImagePHash(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public native ScanPoint[] getPointObjects();
  
  public native String getReportString();
  
  public native boolean isAICrop();
  
  public native boolean isUsingAI();
  
  public native int nativeInit(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2, boolean paramBoolean);
  
  public native void nativeRelease();
  
  public native ScanFastFocusEngineNative process(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native void reset();
  
  public void resetStatus()
  {
    this.bestImageData = null;
  }
  
  public native void setConfig(String paramString);
  
  public native void setNetSpeed(int paramInt);
  
  public native void setServerState(int paramInt);
  
  public native ScanFrameProcessResult shouldJump(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ScanFastFocusEngineNative
 * JD-Core Version:    0.7.0.1
 */
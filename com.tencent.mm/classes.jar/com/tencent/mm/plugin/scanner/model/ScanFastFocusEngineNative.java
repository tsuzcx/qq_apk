package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expansions.e;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.sdk.platformtools.Log;

public class ScanFastFocusEngineNative
{
  private static final String TAG = "MicroMsg.ScanFastFocusEngineNative";
  private static boolean isSoLoaded;
  public byte[] bestImageData;
  public int bestImageId;
  public GoodsObject cropObject;
  public int detectType;
  public byte[] fullImageData;
  public int height;
  public int pointCount;
  public ScanPoint[] points;
  public int result;
  public int trackInfoCount;
  public ScanProductInfo[] trackInfoList;
  public int width;
  
  static
  {
    AppMethodBeat.i(51649);
    isSoLoaded = false;
    tryLoadLibrary();
    AppMethodBeat.o(51649);
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
    this.trackInfoList = new ScanProductInfo[5];
    this.trackInfoCount = 0;
    this.detectType = 0;
    Log.i("MicroMsg.ScanFastFocusEngineNative", "alvinluo ScanFastFocusEngineNative constructor %s", new Object[] { Integer.valueOf(hashCode()) });
    init();
    AppMethodBeat.o(51647);
  }
  
  private void init()
  {
    int k = 0;
    AppMethodBeat.i(51648);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.points.length) {
        break;
      }
      this.points[i] = new ScanPoint();
      i += 1;
    }
    while (j < this.trackInfoList.length)
    {
      this.trackInfoList[j] = new ScanProductInfo();
      j += 1;
    }
    AppMethodBeat.o(51648);
  }
  
  public static boolean isSoLoaded()
  {
    return isSoLoaded;
  }
  
  static boolean tryLoadLibrary()
  {
    AppMethodBeat.i(314217);
    if (!e.aQh())
    {
      AppMethodBeat.o(314217);
      return false;
    }
    try
    {
      if ((e.tryLoadLibrary("ffengine")) && (e.tryLoadLibrary("focusEngineJni"))) {}
      for (boolean bool = true;; bool = false)
      {
        isSoLoaded = bool;
        AppMethodBeat.o(314217);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.ScanFastFocusEngineNative", localException, "alvinluo FocusEngine init exception", new Object[0]);
      isSoLoaded = false;
      AppMethodBeat.o(314217);
    }
  }
  
  public native ScanImagePHashInfo computeImagePHash(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public native ScanFastFocusEngineNative getCropRGBAByTrackId(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public native ScanFastFocusEngineNative getCropYUVByTrackId(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public native int getModelConfigIntValue(String paramString1, String paramString2, String paramString3, int paramInt);
  
  public native ScanPoint[] getPointObjects();
  
  public native String getReportString();
  
  public native ScanProductInfo[] getScanProductInfoList(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native ScanProductInfo[] getScanProductInfoListForFullImage(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public native ScanFastFocusEngineNative getUploadFullRGBAImage(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, float paramFloat);
  
  public native ScanFastFocusEngineNative getUploadFullYUVImage(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, float paramFloat);
  
  public native boolean isAICrop();
  
  public native boolean isUsingAI();
  
  public native int nativeInit(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2);
  
  public native void nativeRelease();
  
  public native ScanFastFocusEngineNative process(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native void reset();
  
  public native void resetNoBoxCount();
  
  public void resetStatus()
  {
    this.bestImageData = null;
    this.fullImageData = null;
    this.trackInfoCount = 0;
    this.detectType = 0;
  }
  
  public native void setConfig(String paramString);
  
  public native void setNetSpeed(int paramInt);
  
  public native void setPHashConfig(String paramString);
  
  public native void setServerDetectFrameCount(int paramInt);
  
  public native void setServerState(int paramInt);
  
  public native ScanFrameProcessResult shouldJump(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ScanFastFocusEngineNative
 * JD-Core Version:    0.7.0.1
 */
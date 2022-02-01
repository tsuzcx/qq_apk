package com.tencent.thumbplayer.core.common;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TPScreenRefreshRateCallBackToNative
  implements TPScreenRefreshRateDetector.ScreenRefreshRateChangedListener
{
  private static final String TAG = "TPScreenRefreshRateCallBack";
  private long mNativeContext;
  
  private TPScreenRefreshRateCallBackToNative(long paramLong)
  {
    this.mNativeContext = paramLong;
  }
  
  private native void _onScreenRefreshRateChanged(float paramFloat);
  
  @TPMethodCalledByNative
  private long getNativeContext()
  {
    return this.mNativeContext;
  }
  
  @TPMethodCalledByNative
  private void registerCallback()
  {
    AppMethodBeat.i(189793);
    TPScreenRefreshRateDetector.addListener(this);
    AppMethodBeat.o(189793);
  }
  
  @TPMethodCalledByNative
  private void unregisterCallback()
  {
    AppMethodBeat.i(189794);
    TPScreenRefreshRateDetector.removeListener(this);
    AppMethodBeat.o(189794);
  }
  
  public void onScreenRefreshRateChanged(float paramFloat)
  {
    AppMethodBeat.i(189795);
    TPNativeLog.printLog(2, "TPScreenRefreshRateCallBack", "onScreenRefreshRateChanged refreshRate:".concat(String.valueOf(paramFloat)));
    _onScreenRefreshRateChanged(paramFloat);
    AppMethodBeat.o(189795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPScreenRefreshRateCallBackToNative
 * JD-Core Version:    0.7.0.1
 */
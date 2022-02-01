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
    AppMethodBeat.i(223022);
    TPScreenRefreshRateDetector.addListener(this);
    AppMethodBeat.o(223022);
  }
  
  @TPMethodCalledByNative
  private void unregisterCallback()
  {
    AppMethodBeat.i(223024);
    TPScreenRefreshRateDetector.removeListener(this);
    AppMethodBeat.o(223024);
  }
  
  public void onScreenRefreshRateChanged(float paramFloat)
  {
    AppMethodBeat.i(223028);
    TPNativeLog.printLog(2, "TPScreenRefreshRateCallBack", "onScreenRefreshRateChanged refreshRate:".concat(String.valueOf(paramFloat)));
    _onScreenRefreshRateChanged(paramFloat);
    AppMethodBeat.o(223028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPScreenRefreshRateCallBackToNative
 * JD-Core Version:    0.7.0.1
 */
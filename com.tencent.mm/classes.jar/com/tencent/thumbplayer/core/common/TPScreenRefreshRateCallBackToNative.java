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
  
  private long getNativeContext()
  {
    return this.mNativeContext;
  }
  
  private void registerCallback()
  {
    AppMethodBeat.i(227782);
    TPScreenRefreshRateDetector.addListener(this);
    AppMethodBeat.o(227782);
  }
  
  private void unregisterCallback()
  {
    AppMethodBeat.i(227787);
    TPScreenRefreshRateDetector.removeListener(this);
    AppMethodBeat.o(227787);
  }
  
  public void onScreenRefreshRateChanged(float paramFloat)
  {
    AppMethodBeat.i(227797);
    TPNativeLog.printLog(2, "TPScreenRefreshRateCallBack", "onScreenRefreshRateChanged refreshRate:".concat(String.valueOf(paramFloat)));
    _onScreenRefreshRateChanged(paramFloat);
    AppMethodBeat.o(227797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPScreenRefreshRateCallBackToNative
 * JD-Core Version:    0.7.0.1
 */
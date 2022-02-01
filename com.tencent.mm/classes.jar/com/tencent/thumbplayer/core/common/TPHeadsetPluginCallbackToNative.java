package com.tencent.thumbplayer.core.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public class TPHeadsetPluginCallbackToNative
  implements TPHeadsetPluginDetector.HeadsetPluginListener
{
  private static final String TAG = "TPHeadsetPluginCallback";
  private long mNativeContext;
  
  private TPHeadsetPluginCallbackToNative(long paramLong)
  {
    this.mNativeContext = paramLong;
  }
  
  private native void _onAudioRouteChanged(Set<Integer> paramSet1, Set<Integer> paramSet2);
  
  @TPMethodCalledByNative
  private long getNativeContext()
  {
    return this.mNativeContext;
  }
  
  @TPMethodCalledByNative
  private void registerCallback()
  {
    AppMethodBeat.i(220414);
    TPHeadsetPluginDetector.addHeadsetPluginListener(this);
    AppMethodBeat.o(220414);
  }
  
  @TPMethodCalledByNative
  private void unregisterCallback()
  {
    AppMethodBeat.i(220415);
    TPHeadsetPluginDetector.removeHeadsetPluginListener(this);
    AppMethodBeat.o(220415);
  }
  
  public void onHeadsetPlugin(Set<Integer> paramSet1, Set<Integer> paramSet2)
  {
    AppMethodBeat.i(220416);
    TPNativeLog.printLog(2, "TPHeadsetPluginCallback", "onHeadsetPlugin: oldOutputs: " + paramSet1 + ", newOutputs: " + paramSet2);
    _onAudioRouteChanged(paramSet1, paramSet2);
    AppMethodBeat.o(220416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPHeadsetPluginCallbackToNative
 * JD-Core Version:    0.7.0.1
 */
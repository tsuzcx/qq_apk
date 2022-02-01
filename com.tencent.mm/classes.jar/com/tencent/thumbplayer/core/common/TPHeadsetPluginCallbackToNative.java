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
  
  private long getNativeContext()
  {
    return this.mNativeContext;
  }
  
  private void registerCallback()
  {
    AppMethodBeat.i(227552);
    TPHeadsetPluginDetector.addHeadsetPluginListener(this);
    AppMethodBeat.o(227552);
  }
  
  private void unregisterCallback()
  {
    AppMethodBeat.i(227569);
    TPHeadsetPluginDetector.removeHeadsetPluginListener(this);
    AppMethodBeat.o(227569);
  }
  
  public void onHeadsetPlugin(Set<Integer> paramSet1, Set<Integer> paramSet2)
  {
    AppMethodBeat.i(227593);
    TPNativeLog.printLog(2, "TPHeadsetPluginCallback", "onHeadsetPlugin: oldOutputs: " + paramSet1 + ", newOutputs: " + paramSet2);
    _onAudioRouteChanged(paramSet1, paramSet2);
    AppMethodBeat.o(227593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPHeadsetPluginCallbackToNative
 * JD-Core Version:    0.7.0.1
 */
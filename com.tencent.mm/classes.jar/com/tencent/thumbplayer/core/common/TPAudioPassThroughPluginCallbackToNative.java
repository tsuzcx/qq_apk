package com.tencent.thumbplayer.core.common;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TPAudioPassThroughPluginCallbackToNative
  implements TPAudioPassThroughPluginDetector.AudioPassThroughPluginListener
{
  private static final String TAG = "TPAudioPassThroughPluginCallback";
  private long mNativeContext;
  
  private TPAudioPassThroughPluginCallbackToNative(long paramLong)
  {
    this.mNativeContext = paramLong;
  }
  
  private native void _onAudioPassThroughStateChanged(boolean paramBoolean);
  
  @TPMethodCalledByNative
  private long getNativeContext()
  {
    return this.mNativeContext;
  }
  
  @TPMethodCalledByNative
  private void registerCallback()
  {
    AppMethodBeat.i(197299);
    TPAudioPassThroughPluginDetector.addListener(this);
    AppMethodBeat.o(197299);
  }
  
  @TPMethodCalledByNative
  private void unregisterCallback()
  {
    AppMethodBeat.i(197300);
    TPAudioPassThroughPluginDetector.removeListener(this);
    AppMethodBeat.o(197300);
  }
  
  public void onAudioPassThroughPlugin(boolean paramBoolean)
  {
    AppMethodBeat.i(197301);
    TPNativeLog.printLog(2, "TPAudioPassThroughPluginCallback", "onAudioPassThroughPlugin bPlugin:".concat(String.valueOf(paramBoolean)));
    _onAudioPassThroughStateChanged(paramBoolean);
    AppMethodBeat.o(197301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPAudioPassThroughPluginCallbackToNative
 * JD-Core Version:    0.7.0.1
 */
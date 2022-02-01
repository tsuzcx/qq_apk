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
    AppMethodBeat.i(220360);
    TPAudioPassThroughPluginDetector.addListener(this);
    AppMethodBeat.o(220360);
  }
  
  @TPMethodCalledByNative
  private void unregisterCallback()
  {
    AppMethodBeat.i(220361);
    TPAudioPassThroughPluginDetector.removeListener(this);
    AppMethodBeat.o(220361);
  }
  
  public void onAudioPassThroughPlugin(boolean paramBoolean)
  {
    AppMethodBeat.i(220362);
    TPNativeLog.printLog(2, "TPAudioPassThroughPluginCallback", "onAudioPassThroughPlugin bPlugin:".concat(String.valueOf(paramBoolean)));
    _onAudioPassThroughStateChanged(paramBoolean);
    AppMethodBeat.o(220362);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPAudioPassThroughPluginCallbackToNative
 * JD-Core Version:    0.7.0.1
 */
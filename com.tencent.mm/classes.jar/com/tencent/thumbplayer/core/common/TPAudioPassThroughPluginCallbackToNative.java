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
  
  private long getNativeContext()
  {
    return this.mNativeContext;
  }
  
  private void registerCallback()
  {
    AppMethodBeat.i(227620);
    TPAudioPassThroughPluginDetector.addListener(this);
    AppMethodBeat.o(227620);
  }
  
  private void unregisterCallback()
  {
    AppMethodBeat.i(227627);
    TPAudioPassThroughPluginDetector.removeListener(this);
    AppMethodBeat.o(227627);
  }
  
  public void onAudioPassThroughPlugin(boolean paramBoolean)
  {
    AppMethodBeat.i(227639);
    TPNativeLog.printLog(2, "TPAudioPassThroughPluginCallback", "onAudioPassThroughPlugin bPlugin:".concat(String.valueOf(paramBoolean)));
    _onAudioPassThroughStateChanged(paramBoolean);
    AppMethodBeat.o(227639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPAudioPassThroughPluginCallbackToNative
 * JD-Core Version:    0.7.0.1
 */
package io.clipworks.analytics;

import com.facebook.jni.HybridData;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ALManager
{
  private static ALManager _sInstance = null;
  private ALEventBridge _eventBridge;
  private final HybridData mHybridData;
  
  private ALManager()
  {
    AppMethodBeat.i(189496);
    this._eventBridge = null;
    this.mHybridData = initHybrid();
    AppMethodBeat.o(189496);
  }
  
  private native HybridData initHybrid();
  
  private native void nativeInitReporter();
  
  private native void nativeRegisterDefaultFileSink();
  
  private native void nativeRegisterEventBridge(ALEventBridge paramALEventBridge);
  
  private native void nativeShutdownReporter();
  
  private native void nativeUnregisterEventBridge();
  
  public static ALManager sharedInstance()
  {
    AppMethodBeat.i(189487);
    if (_sInstance == null) {
      _sInstance = new ALManager();
    }
    ALManager localALManager = _sInstance;
    AppMethodBeat.o(189487);
    return localALManager;
  }
  
  public void initReporter()
  {
    AppMethodBeat.i(189567);
    nativeInitReporter();
    AppMethodBeat.o(189567);
  }
  
  public void registerDefaultFileSink()
  {
    AppMethodBeat.i(189578);
    nativeRegisterDefaultFileSink();
    AppMethodBeat.o(189578);
  }
  
  public void registerEventSink(b paramb)
  {
    AppMethodBeat.i(189586);
    if (paramb == null)
    {
      AppMethodBeat.o(189586);
      return;
    }
    if (this._eventBridge == null)
    {
      this._eventBridge = new ALEventBridge();
      nativeRegisterEventBridge(this._eventBridge);
    }
    this._eventBridge.addEventSink(paramb);
    AppMethodBeat.o(189586);
  }
  
  public void shutdownReporter()
  {
    AppMethodBeat.i(189574);
    nativeShutdownReporter();
    AppMethodBeat.o(189574);
  }
  
  public void unregisterEventSink(b paramb)
  {
    AppMethodBeat.i(189594);
    if (paramb == null)
    {
      AppMethodBeat.o(189594);
      return;
    }
    if (this._eventBridge == null)
    {
      AppMethodBeat.o(189594);
      return;
    }
    this._eventBridge.removeEventSink(paramb);
    if (!this._eventBridge.hasAnyEventSink())
    {
      nativeUnregisterEventBridge();
      this._eventBridge = null;
    }
    AppMethodBeat.o(189594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     io.clipworks.analytics.ALManager
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.thumbplayer.core.connection;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.player.TPNativePlayer;

public class TPNativePlayerConnectionMgr
{
  private boolean mInited;
  private boolean mIsLibLoaded;
  private long mNativeContext;
  
  public TPNativePlayerConnectionMgr()
  {
    AppMethodBeat.i(227436);
    this.mInited = false;
    this.mIsLibLoaded = false;
    this.mNativeContext = 0L;
    try
    {
      TPNativeLibraryLoader.loadLibIfNeeded(null);
      this.mIsLibLoaded = true;
      AppMethodBeat.o(227436);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      this.mIsLibLoaded = false;
      AppMethodBeat.o(227436);
    }
  }
  
  private native int _activeAllConnections();
  
  private native int _activeConnection(int paramInt);
  
  private native int _addConnection(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4);
  
  private native int _addConnectionWithAddr(long paramLong1, Object paramObject1, long paramLong2, Object paramObject2);
  
  private native void _deactiveAllConnections();
  
  private native void _deactiveConnection(int paramInt);
  
  private native void _init();
  
  private native void _removeConnection(int paramInt);
  
  private native void _unInit();
  
  public int activeAllConnections()
  {
    AppMethodBeat.i(227517);
    Object localObject;
    if (!this.mIsLibLoaded)
    {
      localObject = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(227517);
      throw ((Throwable)localObject);
    }
    if (!this.mInited)
    {
      localObject = new IllegalStateException("Failed to addConnection due to invalid state.");
      AppMethodBeat.o(227517);
      throw ((Throwable)localObject);
    }
    int i = _activeAllConnections();
    AppMethodBeat.o(227517);
    return i;
  }
  
  public int activeConnection(int paramInt)
  {
    AppMethodBeat.i(227509);
    Object localObject;
    if (!this.mIsLibLoaded)
    {
      localObject = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(227509);
      throw ((Throwable)localObject);
    }
    if (!this.mInited)
    {
      localObject = new IllegalStateException("Failed to addConnection due to invalid state.");
      AppMethodBeat.o(227509);
      throw ((Throwable)localObject);
    }
    paramInt = _activeConnection(paramInt);
    AppMethodBeat.o(227509);
    return paramInt;
  }
  
  public int addConnection(long paramLong1, TPNativePlayerConnectionNode paramTPNativePlayerConnectionNode1, long paramLong2, TPNativePlayerConnectionNode paramTPNativePlayerConnectionNode2)
  {
    AppMethodBeat.i(227486);
    if (!this.mIsLibLoaded)
    {
      paramTPNativePlayerConnectionNode1 = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(227486);
      throw paramTPNativePlayerConnectionNode1;
    }
    if (!this.mInited)
    {
      paramTPNativePlayerConnectionNode1 = new IllegalStateException("Failed to addConnection due to invalid state.");
      AppMethodBeat.o(227486);
      throw paramTPNativePlayerConnectionNode1;
    }
    int i = _addConnectionWithAddr(paramLong1, paramTPNativePlayerConnectionNode1, paramLong2, paramTPNativePlayerConnectionNode2);
    AppMethodBeat.o(227486);
    return i;
  }
  
  public int addConnection(TPNativePlayer paramTPNativePlayer1, TPNativePlayerConnectionNode paramTPNativePlayerConnectionNode1, TPNativePlayer paramTPNativePlayer2, TPNativePlayerConnectionNode paramTPNativePlayerConnectionNode2)
  {
    AppMethodBeat.i(227478);
    if (!this.mIsLibLoaded)
    {
      paramTPNativePlayer1 = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(227478);
      throw paramTPNativePlayer1;
    }
    if (!this.mInited)
    {
      paramTPNativePlayer1 = new IllegalStateException("Failed to addConnection due to invalid state.");
      AppMethodBeat.o(227478);
      throw paramTPNativePlayer1;
    }
    int i = _addConnection(paramTPNativePlayer1, paramTPNativePlayerConnectionNode1, paramTPNativePlayer2, paramTPNativePlayerConnectionNode2);
    AppMethodBeat.o(227478);
    return i;
  }
  
  public void deactiveAllConnections()
  {
    AppMethodBeat.i(227535);
    Object localObject;
    if (!this.mIsLibLoaded)
    {
      localObject = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(227535);
      throw ((Throwable)localObject);
    }
    if (!this.mInited)
    {
      localObject = new IllegalStateException("Failed to addConnection due to invalid state.");
      AppMethodBeat.o(227535);
      throw ((Throwable)localObject);
    }
    _deactiveAllConnections();
    AppMethodBeat.o(227535);
  }
  
  public void deactiveConnection(int paramInt)
  {
    AppMethodBeat.i(227528);
    Object localObject;
    if (!this.mIsLibLoaded)
    {
      localObject = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(227528);
      throw ((Throwable)localObject);
    }
    if (!this.mInited)
    {
      localObject = new IllegalStateException("Failed to addConnection due to invalid state.");
      AppMethodBeat.o(227528);
      throw ((Throwable)localObject);
    }
    _deactiveConnection(paramInt);
    AppMethodBeat.o(227528);
  }
  
  public void init()
  {
    AppMethodBeat.i(227451);
    Object localObject;
    if (!this.mIsLibLoaded)
    {
      localObject = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(227451);
      throw ((Throwable)localObject);
    }
    if (this.mInited)
    {
      localObject = new IllegalStateException("Failed to init due to invalid state.");
      AppMethodBeat.o(227451);
      throw ((Throwable)localObject);
    }
    this.mInited = true;
    _init();
    AppMethodBeat.o(227451);
  }
  
  public void removeConnection(int paramInt)
  {
    AppMethodBeat.i(227496);
    Object localObject;
    if (!this.mIsLibLoaded)
    {
      localObject = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(227496);
      throw ((Throwable)localObject);
    }
    if (!this.mInited)
    {
      localObject = new IllegalStateException("Failed to addConnection due to invalid state.");
      AppMethodBeat.o(227496);
      throw ((Throwable)localObject);
    }
    _removeConnection(paramInt);
    AppMethodBeat.o(227496);
  }
  
  public void unInit()
  {
    AppMethodBeat.i(227461);
    if (!this.mIsLibLoaded)
    {
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(227461);
      throw localUnsupportedOperationException;
    }
    if (!this.mInited)
    {
      AppMethodBeat.o(227461);
      return;
    }
    this.mInited = false;
    _unInit();
    AppMethodBeat.o(227461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.connection.TPNativePlayerConnectionMgr
 * JD-Core Version:    0.7.0.1
 */
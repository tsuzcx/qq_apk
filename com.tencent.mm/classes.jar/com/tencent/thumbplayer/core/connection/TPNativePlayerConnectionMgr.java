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
    AppMethodBeat.i(223303);
    this.mInited = false;
    this.mIsLibLoaded = false;
    this.mNativeContext = 0L;
    try
    {
      TPNativeLibraryLoader.loadLibIfNeeded(null);
      this.mIsLibLoaded = true;
      AppMethodBeat.o(223303);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      this.mIsLibLoaded = false;
      AppMethodBeat.o(223303);
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
    AppMethodBeat.i(223327);
    Object localObject;
    if (!this.mIsLibLoaded)
    {
      localObject = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(223327);
      throw ((Throwable)localObject);
    }
    if (!this.mInited)
    {
      localObject = new IllegalStateException("Failed to addConnection due to invalid state.");
      AppMethodBeat.o(223327);
      throw ((Throwable)localObject);
    }
    int i = _activeAllConnections();
    AppMethodBeat.o(223327);
    return i;
  }
  
  public int activeConnection(int paramInt)
  {
    AppMethodBeat.i(223324);
    Object localObject;
    if (!this.mIsLibLoaded)
    {
      localObject = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(223324);
      throw ((Throwable)localObject);
    }
    if (!this.mInited)
    {
      localObject = new IllegalStateException("Failed to addConnection due to invalid state.");
      AppMethodBeat.o(223324);
      throw ((Throwable)localObject);
    }
    paramInt = _activeConnection(paramInt);
    AppMethodBeat.o(223324);
    return paramInt;
  }
  
  public int addConnection(long paramLong1, TPNativePlayerConnectionNode paramTPNativePlayerConnectionNode1, long paramLong2, TPNativePlayerConnectionNode paramTPNativePlayerConnectionNode2)
  {
    AppMethodBeat.i(223313);
    if (!this.mIsLibLoaded)
    {
      paramTPNativePlayerConnectionNode1 = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(223313);
      throw paramTPNativePlayerConnectionNode1;
    }
    if (!this.mInited)
    {
      paramTPNativePlayerConnectionNode1 = new IllegalStateException("Failed to addConnection due to invalid state.");
      AppMethodBeat.o(223313);
      throw paramTPNativePlayerConnectionNode1;
    }
    int i = _addConnectionWithAddr(paramLong1, paramTPNativePlayerConnectionNode1, paramLong2, paramTPNativePlayerConnectionNode2);
    AppMethodBeat.o(223313);
    return i;
  }
  
  public int addConnection(TPNativePlayer paramTPNativePlayer1, TPNativePlayerConnectionNode paramTPNativePlayerConnectionNode1, TPNativePlayer paramTPNativePlayer2, TPNativePlayerConnectionNode paramTPNativePlayerConnectionNode2)
  {
    AppMethodBeat.i(223311);
    if (!this.mIsLibLoaded)
    {
      paramTPNativePlayer1 = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(223311);
      throw paramTPNativePlayer1;
    }
    if (!this.mInited)
    {
      paramTPNativePlayer1 = new IllegalStateException("Failed to addConnection due to invalid state.");
      AppMethodBeat.o(223311);
      throw paramTPNativePlayer1;
    }
    int i = _addConnection(paramTPNativePlayer1, paramTPNativePlayerConnectionNode1, paramTPNativePlayer2, paramTPNativePlayerConnectionNode2);
    AppMethodBeat.o(223311);
    return i;
  }
  
  public void deactiveAllConnections()
  {
    AppMethodBeat.i(223335);
    Object localObject;
    if (!this.mIsLibLoaded)
    {
      localObject = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(223335);
      throw ((Throwable)localObject);
    }
    if (!this.mInited)
    {
      localObject = new IllegalStateException("Failed to addConnection due to invalid state.");
      AppMethodBeat.o(223335);
      throw ((Throwable)localObject);
    }
    _deactiveAllConnections();
    AppMethodBeat.o(223335);
  }
  
  public void deactiveConnection(int paramInt)
  {
    AppMethodBeat.i(223332);
    Object localObject;
    if (!this.mIsLibLoaded)
    {
      localObject = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(223332);
      throw ((Throwable)localObject);
    }
    if (!this.mInited)
    {
      localObject = new IllegalStateException("Failed to addConnection due to invalid state.");
      AppMethodBeat.o(223332);
      throw ((Throwable)localObject);
    }
    _deactiveConnection(paramInt);
    AppMethodBeat.o(223332);
  }
  
  public void init()
  {
    AppMethodBeat.i(223305);
    Object localObject;
    if (!this.mIsLibLoaded)
    {
      localObject = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(223305);
      throw ((Throwable)localObject);
    }
    if (this.mInited)
    {
      localObject = new IllegalStateException("Failed to init due to invalid state.");
      AppMethodBeat.o(223305);
      throw ((Throwable)localObject);
    }
    this.mInited = true;
    _init();
    AppMethodBeat.o(223305);
  }
  
  public void removeConnection(int paramInt)
  {
    AppMethodBeat.i(223318);
    Object localObject;
    if (!this.mIsLibLoaded)
    {
      localObject = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(223318);
      throw ((Throwable)localObject);
    }
    if (!this.mInited)
    {
      localObject = new IllegalStateException("Failed to addConnection due to invalid state.");
      AppMethodBeat.o(223318);
      throw ((Throwable)localObject);
    }
    _removeConnection(paramInt);
    AppMethodBeat.o(223318);
  }
  
  public void unInit()
  {
    AppMethodBeat.i(223308);
    if (!this.mIsLibLoaded)
    {
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(223308);
      throw localUnsupportedOperationException;
    }
    if (!this.mInited)
    {
      AppMethodBeat.o(223308);
      return;
    }
    this.mInited = false;
    _unInit();
    AppMethodBeat.o(223308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.connection.TPNativePlayerConnectionMgr
 * JD-Core Version:    0.7.0.1
 */
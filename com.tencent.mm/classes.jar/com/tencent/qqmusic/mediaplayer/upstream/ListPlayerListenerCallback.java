package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListPlayerListenerCallback
  implements PlayerListenerCallback
{
  private final CopyOnWriteArrayList<PlayerListenerCallback> mCallbacks;
  
  public ListPlayerListenerCallback()
  {
    AppMethodBeat.i(76526);
    this.mCallbacks = new CopyOnWriteArrayList();
    AppMethodBeat.o(76526);
  }
  
  public void add(PlayerListenerCallback paramPlayerListenerCallback)
  {
    try
    {
      AppMethodBeat.i(76527);
      this.mCallbacks.add(paramPlayerListenerCallback);
      AppMethodBeat.o(76527);
      return;
    }
    finally
    {
      paramPlayerListenerCallback = finally;
      throw paramPlayerListenerCallback;
    }
  }
  
  public void add(ListPlayerListenerCallback paramListPlayerListenerCallback)
  {
    try
    {
      AppMethodBeat.i(76528);
      this.mCallbacks.addAll(paramListPlayerListenerCallback.toCollection());
      AppMethodBeat.o(76528);
      return;
    }
    finally
    {
      paramListPlayerListenerCallback = finally;
      throw paramListPlayerListenerCallback;
    }
  }
  
  public void addAll(List<PlayerListenerCallback> paramList)
  {
    try
    {
      AppMethodBeat.i(76529);
      this.mCallbacks.addAll(paramList);
      AppMethodBeat.o(76529);
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public void clear()
  {
    try
    {
      AppMethodBeat.i(76532);
      this.mCallbacks.clear();
      AppMethodBeat.o(76532);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onBufferingUpdate(BaseMediaPlayer paramBaseMediaPlayer, int paramInt)
  {
    AppMethodBeat.i(76533);
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((PlayerListenerCallback)localIterator.next()).onBufferingUpdate(paramBaseMediaPlayer, paramInt);
    }
    AppMethodBeat.o(76533);
  }
  
  public void onCompletion(BaseMediaPlayer paramBaseMediaPlayer)
  {
    AppMethodBeat.i(76534);
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((PlayerListenerCallback)localIterator.next()).onCompletion(paramBaseMediaPlayer);
    }
    AppMethodBeat.o(76534);
  }
  
  public void onError(BaseMediaPlayer paramBaseMediaPlayer, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(76536);
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((PlayerListenerCallback)localIterator.next()).onError(paramBaseMediaPlayer, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(76536);
  }
  
  public void onPrepared(BaseMediaPlayer paramBaseMediaPlayer)
  {
    AppMethodBeat.i(76537);
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((PlayerListenerCallback)localIterator.next()).onPrepared(paramBaseMediaPlayer);
    }
    AppMethodBeat.o(76537);
  }
  
  public void onSeekComplete(BaseMediaPlayer paramBaseMediaPlayer, int paramInt)
  {
    AppMethodBeat.i(76535);
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((PlayerListenerCallback)localIterator.next()).onSeekComplete(paramBaseMediaPlayer, paramInt);
    }
    AppMethodBeat.o(76535);
  }
  
  public void onStarted(BaseMediaPlayer paramBaseMediaPlayer)
  {
    AppMethodBeat.i(76538);
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((PlayerListenerCallback)localIterator.next()).onStarted(paramBaseMediaPlayer);
    }
    AppMethodBeat.o(76538);
  }
  
  public void onStateChanged(BaseMediaPlayer paramBaseMediaPlayer, int paramInt)
  {
    AppMethodBeat.i(76539);
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((PlayerListenerCallback)localIterator.next()).onStateChanged(paramBaseMediaPlayer, paramInt);
    }
    AppMethodBeat.o(76539);
  }
  
  public void remove(PlayerListenerCallback paramPlayerListenerCallback)
  {
    try
    {
      AppMethodBeat.i(76531);
      this.mCallbacks.remove(paramPlayerListenerCallback);
      AppMethodBeat.o(76531);
      return;
    }
    finally
    {
      paramPlayerListenerCallback = finally;
      throw paramPlayerListenerCallback;
    }
  }
  
  public List<PlayerListenerCallback> toCollection()
  {
    try
    {
      AppMethodBeat.i(76530);
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.mCallbacks);
      AppMethodBeat.o(76530);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.ListPlayerListenerCallback
 * JD-Core Version:    0.7.0.1
 */
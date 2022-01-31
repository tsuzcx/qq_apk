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
    AppMethodBeat.i(104566);
    this.mCallbacks = new CopyOnWriteArrayList();
    AppMethodBeat.o(104566);
  }
  
  public void add(PlayerListenerCallback paramPlayerListenerCallback)
  {
    try
    {
      AppMethodBeat.i(104567);
      this.mCallbacks.add(paramPlayerListenerCallback);
      AppMethodBeat.o(104567);
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
      AppMethodBeat.i(104568);
      this.mCallbacks.addAll(paramListPlayerListenerCallback.toCollection());
      AppMethodBeat.o(104568);
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
      AppMethodBeat.i(104569);
      this.mCallbacks.addAll(paramList);
      AppMethodBeat.o(104569);
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
      AppMethodBeat.i(104572);
      this.mCallbacks.clear();
      AppMethodBeat.o(104572);
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
    AppMethodBeat.i(104573);
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((PlayerListenerCallback)localIterator.next()).onBufferingUpdate(paramBaseMediaPlayer, paramInt);
    }
    AppMethodBeat.o(104573);
  }
  
  public void onCompletion(BaseMediaPlayer paramBaseMediaPlayer)
  {
    AppMethodBeat.i(104574);
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((PlayerListenerCallback)localIterator.next()).onCompletion(paramBaseMediaPlayer);
    }
    AppMethodBeat.o(104574);
  }
  
  public void onError(BaseMediaPlayer paramBaseMediaPlayer, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(104576);
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((PlayerListenerCallback)localIterator.next()).onError(paramBaseMediaPlayer, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(104576);
  }
  
  public void onPrepared(BaseMediaPlayer paramBaseMediaPlayer)
  {
    AppMethodBeat.i(104577);
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((PlayerListenerCallback)localIterator.next()).onPrepared(paramBaseMediaPlayer);
    }
    AppMethodBeat.o(104577);
  }
  
  public void onSeekComplete(BaseMediaPlayer paramBaseMediaPlayer, int paramInt)
  {
    AppMethodBeat.i(104575);
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((PlayerListenerCallback)localIterator.next()).onSeekComplete(paramBaseMediaPlayer, paramInt);
    }
    AppMethodBeat.o(104575);
  }
  
  public void onStarted(BaseMediaPlayer paramBaseMediaPlayer)
  {
    AppMethodBeat.i(104578);
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((PlayerListenerCallback)localIterator.next()).onStarted(paramBaseMediaPlayer);
    }
    AppMethodBeat.o(104578);
  }
  
  public void onStateChanged(BaseMediaPlayer paramBaseMediaPlayer, int paramInt)
  {
    AppMethodBeat.i(104579);
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((PlayerListenerCallback)localIterator.next()).onStateChanged(paramBaseMediaPlayer, paramInt);
    }
    AppMethodBeat.o(104579);
  }
  
  public void remove(PlayerListenerCallback paramPlayerListenerCallback)
  {
    try
    {
      AppMethodBeat.i(104571);
      this.mCallbacks.remove(paramPlayerListenerCallback);
      AppMethodBeat.o(104571);
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
      AppMethodBeat.i(104570);
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.mCallbacks);
      AppMethodBeat.o(104570);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.ListPlayerListenerCallback
 * JD-Core Version:    0.7.0.1
 */
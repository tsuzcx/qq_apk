package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class TraeAudioSessionHost
{
  private ArrayList<TraeAudioSessionHost.a> _sessionInfoList;
  private ReentrantLock mLock;
  
  public TraeAudioSessionHost()
  {
    AppMethodBeat.i(65669);
    this._sessionInfoList = new ArrayList();
    this.mLock = new ReentrantLock();
    AppMethodBeat.o(65669);
  }
  
  public void add(TraeAudioSession paramTraeAudioSession, long paramLong, Context paramContext)
  {
    AppMethodBeat.i(146948);
    if (find(paramLong) != null)
    {
      AppMethodBeat.o(146948);
      return;
    }
    paramContext = new TraeAudioSessionHost.a(this);
    paramContext.a = paramLong;
    paramContext.b = paramTraeAudioSession;
    this.mLock.lock();
    this._sessionInfoList.add(paramContext);
    this.mLock.unlock();
    AppMethodBeat.o(146948);
  }
  
  public TraeAudioSessionHost.a find(long paramLong)
  {
    AppMethodBeat.i(65670);
    this.mLock.lock();
    int i = 0;
    TraeAudioSessionHost.a locala;
    if (i < this._sessionInfoList.size())
    {
      locala = (TraeAudioSessionHost.a)this._sessionInfoList.get(i);
      if (locala.a != paramLong) {}
    }
    for (;;)
    {
      this.mLock.unlock();
      AppMethodBeat.o(65670);
      return locala;
      i += 1;
      break;
      locala = null;
    }
  }
  
  public void remove(long paramLong)
  {
    AppMethodBeat.i(65672);
    this.mLock.lock();
    int i = 0;
    for (;;)
    {
      if (i < this._sessionInfoList.size())
      {
        if (((TraeAudioSessionHost.a)this._sessionInfoList.get(i)).a == paramLong) {
          this._sessionInfoList.remove(i);
        }
      }
      else
      {
        this.mLock.unlock();
        AppMethodBeat.o(65672);
        return;
      }
      i += 1;
    }
  }
  
  public void sendToAudioSessionMessage(Intent paramIntent)
  {
    AppMethodBeat.i(146949);
    this.mLock.lock();
    int i = 0;
    while (i < this._sessionInfoList.size())
    {
      ((TraeAudioSessionHost.a)this._sessionInfoList.get(i)).b.onReceiveCallback(paramIntent);
      i += 1;
    }
    this.mLock.unlock();
    AppMethodBeat.o(146949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioSessionHost
 * JD-Core Version:    0.7.0.1
 */
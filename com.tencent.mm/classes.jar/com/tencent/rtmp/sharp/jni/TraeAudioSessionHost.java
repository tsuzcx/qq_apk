package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class TraeAudioSessionHost
{
  private ArrayList<TraeAudioSessionHost.a> _sessionInfoList = new ArrayList();
  private ReentrantLock mLock = new ReentrantLock();
  
  public void add(long paramLong, Context paramContext)
  {
    if (find(paramLong) != null) {
      return;
    }
    paramContext = new TraeAudioSessionHost.a(this);
    paramContext.a = paramLong;
    this.mLock.lock();
    this._sessionInfoList.add(paramContext);
    this.mLock.unlock();
  }
  
  public TraeAudioSessionHost.a find(long paramLong)
  {
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
      return locala;
      i += 1;
      break;
      locala = null;
    }
  }
  
  public void remove(long paramLong)
  {
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
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioSessionHost
 * JD-Core Version:    0.7.0.1
 */
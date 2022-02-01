package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class TraeAudioSessionHost
{
  private ArrayList<SessionInfo> _sessionInfoList;
  private ReentrantLock mLock;
  
  public TraeAudioSessionHost()
  {
    AppMethodBeat.i(13785);
    this._sessionInfoList = new ArrayList();
    this.mLock = new ReentrantLock();
    AppMethodBeat.o(13785);
  }
  
  public void add(TraeAudioSession paramTraeAudioSession, long paramLong, Context paramContext)
  {
    AppMethodBeat.i(13787);
    if (find(paramLong) != null)
    {
      AppMethodBeat.o(13787);
      return;
    }
    paramContext = new SessionInfo();
    paramContext.sessionId = paramLong;
    paramContext._traeAs = paramTraeAudioSession;
    this.mLock.lock();
    this._sessionInfoList.add(paramContext);
    this.mLock.unlock();
    AppMethodBeat.o(13787);
  }
  
  public SessionInfo find(long paramLong)
  {
    AppMethodBeat.i(13786);
    this.mLock.lock();
    int i = 0;
    SessionInfo localSessionInfo;
    if (i < this._sessionInfoList.size())
    {
      localSessionInfo = (SessionInfo)this._sessionInfoList.get(i);
      if (localSessionInfo.sessionId != paramLong) {}
    }
    for (;;)
    {
      this.mLock.unlock();
      AppMethodBeat.o(13786);
      return localSessionInfo;
      i += 1;
      break;
      localSessionInfo = null;
    }
  }
  
  public void remove(long paramLong)
  {
    AppMethodBeat.i(13788);
    this.mLock.lock();
    int i = 0;
    for (;;)
    {
      if (i < this._sessionInfoList.size())
      {
        if (((SessionInfo)this._sessionInfoList.get(i)).sessionId == paramLong) {
          this._sessionInfoList.remove(i);
        }
      }
      else
      {
        this.mLock.unlock();
        AppMethodBeat.o(13788);
        return;
      }
      i += 1;
    }
  }
  
  public void sendToAudioSessionMessage(Intent paramIntent)
  {
    AppMethodBeat.i(13789);
    this.mLock.lock();
    int i = 0;
    while (i < this._sessionInfoList.size())
    {
      ((SessionInfo)this._sessionInfoList.get(i))._traeAs.onReceiveCallback(paramIntent);
      i += 1;
    }
    this.mLock.unlock();
    AppMethodBeat.o(13789);
  }
  
  public class SessionInfo
  {
    public TraeAudioSession _traeAs;
    public long sessionId;
    
    public SessionInfo() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioSessionHost
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.rtmp.sharp.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class TraeAudioCodecList
{
  private ArrayList<TraeAudioCodecList.a> _sessionInfoList;
  private ReentrantLock mLock;
  
  public TraeAudioCodecList()
  {
    AppMethodBeat.i(146940);
    this._sessionInfoList = new ArrayList();
    this.mLock = new ReentrantLock();
    AppMethodBeat.o(146940);
  }
  
  public TraeAudioCodecList.a add(long paramLong)
  {
    AppMethodBeat.i(146942);
    TraeAudioCodecList.a locala = find(paramLong);
    if (locala != null)
    {
      AppMethodBeat.o(146942);
      return locala;
    }
    locala = new TraeAudioCodecList.a(this);
    locala.a = paramLong;
    locala.b = new AudioDecoder();
    locala.c = new byte[3840];
    this.mLock.lock();
    this._sessionInfoList.add(locala);
    this.mLock.unlock();
    locala = find(paramLong);
    AppMethodBeat.o(146942);
    return locala;
  }
  
  public TraeAudioCodecList.a find(long paramLong)
  {
    AppMethodBeat.i(146941);
    this.mLock.lock();
    int i = 0;
    TraeAudioCodecList.a locala;
    if (i < this._sessionInfoList.size())
    {
      locala = (TraeAudioCodecList.a)this._sessionInfoList.get(i);
      if (locala.a != paramLong) {}
    }
    for (;;)
    {
      this.mLock.unlock();
      AppMethodBeat.o(146941);
      return locala;
      i += 1;
      break;
      locala = null;
    }
  }
  
  public void remove(long paramLong)
  {
    AppMethodBeat.i(146943);
    this.mLock.lock();
    int i = 0;
    for (;;)
    {
      if (i < this._sessionInfoList.size())
      {
        if (((TraeAudioCodecList.a)this._sessionInfoList.get(i)).a == paramLong) {
          this._sessionInfoList.remove(i);
        }
      }
      else
      {
        this.mLock.unlock();
        AppMethodBeat.o(146943);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioCodecList
 * JD-Core Version:    0.7.0.1
 */
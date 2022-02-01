package com.tencent.rtmp.sharp.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class TraeAudioCodecList
{
  private ArrayList<CodecInfo> _sessionInfoList;
  private ReentrantLock mLock;
  
  public TraeAudioCodecList()
  {
    AppMethodBeat.i(13780);
    this._sessionInfoList = new ArrayList();
    this.mLock = new ReentrantLock();
    AppMethodBeat.o(13780);
  }
  
  public CodecInfo add(long paramLong)
  {
    AppMethodBeat.i(13782);
    CodecInfo localCodecInfo = find(paramLong);
    if (localCodecInfo != null)
    {
      AppMethodBeat.o(13782);
      return localCodecInfo;
    }
    localCodecInfo = new CodecInfo();
    localCodecInfo.sessionId = paramLong;
    localCodecInfo.audioDecoder = new AudioDecoder();
    localCodecInfo._tempBufdec = new byte[3840];
    this.mLock.lock();
    this._sessionInfoList.add(localCodecInfo);
    this.mLock.unlock();
    localCodecInfo = find(paramLong);
    AppMethodBeat.o(13782);
    return localCodecInfo;
  }
  
  public CodecInfo find(long paramLong)
  {
    AppMethodBeat.i(13781);
    this.mLock.lock();
    int i = 0;
    CodecInfo localCodecInfo;
    if (i < this._sessionInfoList.size())
    {
      localCodecInfo = (CodecInfo)this._sessionInfoList.get(i);
      if (localCodecInfo.sessionId != paramLong) {}
    }
    for (;;)
    {
      this.mLock.unlock();
      AppMethodBeat.o(13781);
      return localCodecInfo;
      i += 1;
      break;
      localCodecInfo = null;
    }
  }
  
  public void remove(long paramLong)
  {
    AppMethodBeat.i(13783);
    this.mLock.lock();
    int i = 0;
    for (;;)
    {
      if (i < this._sessionInfoList.size())
      {
        if (((CodecInfo)this._sessionInfoList.get(i)).sessionId == paramLong) {
          this._sessionInfoList.remove(i);
        }
      }
      else
      {
        this.mLock.unlock();
        AppMethodBeat.o(13783);
        return;
      }
      i += 1;
    }
  }
  
  public class CodecInfo
  {
    public byte[] _tempBufdec;
    public AudioDecoder audioDecoder;
    public long sessionId;
    
    public CodecInfo() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioCodecList
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class PlayerStateRunner
{
  private static final String TAG = "StateRunner";
  private WeakReference<AudioTrack> mAudioTrack;
  private final ReadWriteLock mLock;
  private Integer mState;
  
  PlayerStateRunner(Integer paramInteger)
  {
    AppMethodBeat.i(76670);
    this.mLock = new ReentrantReadWriteLock();
    this.mAudioTrack = new WeakReference(null);
    this.mState = paramInteger;
    AppMethodBeat.o(76670);
  }
  
  Integer get()
  {
    AppMethodBeat.i(76674);
    this.mLock.readLock().lock();
    for (;;)
    {
      try
      {
        i = this.mState.intValue();
        AudioTrack localAudioTrack = (AudioTrack)this.mAudioTrack.get();
        if (localAudioTrack == null) {
          break label178;
        }
        switch (localAudioTrack.getPlayState())
        {
        case 2: 
          j = i;
          if (!this.mState.equals(Integer.valueOf(i)))
          {
            Logger.e("StateRunner", "!mState.equals(state), mstate = " + this.mState.toString() + "   state = " + i);
            j = i;
          }
          return Integer.valueOf(j);
        }
      }
      finally
      {
        this.mLock.readLock().unlock();
        AppMethodBeat.o(76674);
      }
      int i = 5;
      continue;
      i = 4;
      continue;
      label178:
      int j = i;
    }
  }
  
  boolean isEqual(Integer... paramVarArgs)
  {
    AppMethodBeat.i(76673);
    this.mLock.readLock().lock();
    try
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        Integer localInteger = paramVarArgs[i];
        boolean bool = this.mState.equals(localInteger);
        if (bool) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    finally
    {
      this.mLock.readLock().unlock();
      AppMethodBeat.o(76673);
    }
  }
  
  public void setAudioTrack(AudioTrack paramAudioTrack)
  {
    AppMethodBeat.i(76675);
    this.mAudioTrack = new WeakReference(paramAudioTrack);
    AppMethodBeat.o(76675);
  }
  
  Integer transfer(Integer paramInteger)
  {
    AppMethodBeat.i(76671);
    this.mLock.writeLock().lock();
    try
    {
      Integer localInteger = this.mState;
      this.mState = paramInteger;
      Logger.i("StateRunner", localInteger.toString() + " -> " + this.mState.toString());
      return localInteger;
    }
    finally
    {
      this.mLock.writeLock().unlock();
      AppMethodBeat.o(76671);
    }
  }
  
  boolean transfer(Integer paramInteger, Integer... paramVarArgs)
  {
    AppMethodBeat.i(76672);
    this.mLock.writeLock().lock();
    try
    {
      if (isEqual(paramVarArgs))
      {
        transfer(paramInteger);
        return true;
      }
      return false;
    }
    finally
    {
      this.mLock.writeLock().unlock();
      AppMethodBeat.o(76672);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.PlayerStateRunner
 * JD-Core Version:    0.7.0.1
 */
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
    AppMethodBeat.i(104781);
    this.mLock = new ReentrantReadWriteLock();
    this.mAudioTrack = new WeakReference(null);
    this.mState = paramInteger;
    AppMethodBeat.o(104781);
  }
  
  Integer get()
  {
    AppMethodBeat.i(104785);
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
        AppMethodBeat.o(104785);
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
    AppMethodBeat.i(104784);
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
      AppMethodBeat.o(104784);
    }
  }
  
  public void setAudioTrack(AudioTrack paramAudioTrack)
  {
    AppMethodBeat.i(104786);
    this.mAudioTrack = new WeakReference(paramAudioTrack);
    AppMethodBeat.o(104786);
  }
  
  Integer transfer(Integer paramInteger)
  {
    AppMethodBeat.i(104782);
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
      AppMethodBeat.o(104782);
    }
  }
  
  boolean transfer(Integer paramInteger, Integer... paramVarArgs)
  {
    AppMethodBeat.i(104783);
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
      AppMethodBeat.o(104783);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.PlayerStateRunner
 * JD-Core Version:    0.7.0.1
 */
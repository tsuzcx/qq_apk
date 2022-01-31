package com.tencent.qqmusic.mediaplayer;

import android.os.Looper;
import android.util.Pair;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.TrackDataSource.TrackStateCallback;
import com.tencent.qqmusic.mediaplayer.util.Logger;

class TrackCorePlayer
  extends CorePlayer
  implements TrackDataSource.TrackStateCallback
{
  private static final String TAG = "TrackCorePlayer";
  private long mStartPosition = 0L;
  
  TrackCorePlayer(IDataSource paramIDataSource, PlayerCallback paramPlayerCallback, Looper paramLooper)
  {
    super(paramIDataSource, null, paramPlayerCallback, paramLooper, new NativeDecoder());
  }
  
  long getCurPosition()
  {
    return super.getCurPosition() - this.mStartPosition;
  }
  
  public void onTrackPrepared(TrackInfo paramTrackInfo)
  {
    this.mStartPosition = ((Long)paramTrackInfo.getRange().first).longValue();
    long l1 = ((Long)paramTrackInfo.getRange().second).longValue();
    long l2 = ((Long)paramTrackInfo.getRange().first).longValue();
    Logger.i("TrackCorePlayer", "onTrackPrepared, start byte: " + l2 + ", end byte: " + l1);
    this.mInformation.setDuration(l1 - l2);
  }
  
  public void seek(int paramInt)
  {
    int i = (int)(paramInt + this.mStartPosition);
    Logger.i("TrackCorePlayer", "seek, position: " + paramInt + " ,realseek: " + i);
    super.seek(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.TrackCorePlayer
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmusic.mediaplayer;

import android.os.Looper;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private long mStartPosition;
  
  TrackCorePlayer(IDataSource paramIDataSource, PlayerCallback paramPlayerCallback, Looper paramLooper, QMThreadExecutor paramQMThreadExecutor)
  {
    super(paramIDataSource, null, paramPlayerCallback, paramLooper, new NativeDecoder(), paramQMThreadExecutor);
    AppMethodBeat.i(76571);
    this.mStartPosition = 0L;
    AppMethodBeat.o(76571);
  }
  
  long getCurPosition()
  {
    AppMethodBeat.i(76572);
    long l1 = super.getCurPosition();
    long l2 = this.mStartPosition;
    AppMethodBeat.o(76572);
    return l1 - l2;
  }
  
  public void onTrackPrepared(TrackInfo paramTrackInfo)
  {
    AppMethodBeat.i(76574);
    this.mStartPosition = ((Long)paramTrackInfo.getRange().first).longValue();
    long l1 = ((Long)paramTrackInfo.getRange().second).longValue();
    long l2 = ((Long)paramTrackInfo.getRange().first).longValue();
    Logger.i("TrackCorePlayer", "onTrackPrepared, start byte: " + l2 + ", end byte: " + l1);
    this.mInformation.setDuration(l1 - l2);
    AppMethodBeat.o(76574);
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(76573);
    int i = (int)(paramInt + this.mStartPosition);
    Logger.i("TrackCorePlayer", "seek, position: " + paramInt + " ,realseek: " + i);
    super.seek(i);
    AppMethodBeat.o(76573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.TrackCorePlayer
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmusic.mediaplayer.upstream;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.IOException;

public class TrackDataSource
  implements PlayerListenerCallback, IDataSource
{
  private static final String TAG = "TrackDataSource";
  private IDataSource mDataSource;
  private long mEndBytePosition;
  private long mStartBytePosition;
  private long mStartTimePosition;
  private TrackInfo mTrackInfo;
  private TrackStateCallback mTrackStateCallback;
  
  public TrackDataSource(TrackInfo paramTrackInfo)
  {
    String str = paramTrackInfo.getUri();
    if (TextUtils.isEmpty(paramTrackInfo.getUri())) {
      throw new DataSourceException(-1, "track info has no media file path!", null);
    }
    if (!new File(str).exists()) {
      throw new DataSourceException(-1, "track info's media file not exists!", null);
    }
    this.mDataSource = new FileDataSource(paramTrackInfo.getUri());
    this.mTrackInfo = paramTrackInfo;
  }
  
  public void close()
  {
    this.mDataSource.close();
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    return this.mDataSource.getAudioType();
  }
  
  public long getSize()
  {
    return this.mDataSource.getSize();
  }
  
  public void onBufferingUpdate(BaseMediaPlayer paramBaseMediaPlayer, int paramInt) {}
  
  public void onCompletion(BaseMediaPlayer paramBaseMediaPlayer) {}
  
  public void onError(BaseMediaPlayer paramBaseMediaPlayer, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onPrepared(BaseMediaPlayer paramBaseMediaPlayer)
  {
    do
    {
      long l2;
      Pair localPair;
      try
      {
        this.mDataSource.open();
        l2 = this.mDataSource.getSize();
        paramBaseMediaPlayer = paramBaseMediaPlayer.createSeekTable();
        localPair = this.mTrackInfo.getRange();
        Logger.i("TrackDataSource", "start time: " + localPair.first + ", end time: " + localPair.second);
        if (((Long)localPair.first).longValue() > ((Long)localPair.second).longValue())
        {
          Logger.e("TrackDataSource", "start range larger, return");
          return;
        }
      }
      catch (IOException paramBaseMediaPlayer)
      {
        Logger.e("TrackDataSource", "dataSource open failed!", paramBaseMediaPlayer);
        return;
      }
      this.mStartTimePosition = ((Long)localPair.first).longValue();
      long l4 = paramBaseMediaPlayer.seek(((Long)localPair.first).longValue());
      long l3 = paramBaseMediaPlayer.seek(((Long)localPair.second).longValue());
      if ((l2 > 0L) && (l4 > l2))
      {
        Logger.e("TrackDataSource", "startBytePosition larger than size!");
        return;
      }
      long l1 = l3;
      if (l2 > 0L)
      {
        l1 = l3;
        if (l3 > l2) {
          l1 = l2;
        }
      }
      this.mStartBytePosition = l4;
      this.mEndBytePosition = l1;
      Logger.i("TrackDataSource", "start byte: " + this.mStartBytePosition + ", end byte: " + this.mEndBytePosition);
    } while (this.mTrackStateCallback == null);
    this.mTrackStateCallback.onTrackPrepared(this.mTrackInfo);
  }
  
  public void onSeekComplete(BaseMediaPlayer paramBaseMediaPlayer, int paramInt) {}
  
  public void onStarted(BaseMediaPlayer paramBaseMediaPlayer)
  {
    paramBaseMediaPlayer.seekTo(0);
  }
  
  public void onStateChanged(BaseMediaPlayer paramBaseMediaPlayer, int paramInt) {}
  
  public void open()
  {
    this.mDataSource.open();
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((this.mEndBytePosition > 0L) && (paramLong > this.mEndBytePosition)) {
      return -1;
    }
    return this.mDataSource.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void setEndBytePosition(long paramLong)
  {
    this.mEndBytePosition = paramLong;
  }
  
  public void setTrackStateCallback(TrackStateCallback paramTrackStateCallback)
  {
    this.mTrackStateCallback = paramTrackStateCallback;
  }
  
  public static abstract interface TrackStateCallback
  {
    public abstract void onTrackPrepared(TrackInfo paramTrackInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.TrackDataSource
 * JD-Core Version:    0.7.0.1
 */
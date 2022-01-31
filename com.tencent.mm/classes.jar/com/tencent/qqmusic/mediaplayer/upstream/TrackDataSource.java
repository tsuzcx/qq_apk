package com.tencent.qqmusic.mediaplayer.upstream;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private TrackDataSource.TrackStateCallback mTrackStateCallback;
  
  public TrackDataSource(TrackInfo paramTrackInfo)
  {
    AppMethodBeat.i(104554);
    String str = paramTrackInfo.getUri();
    if (TextUtils.isEmpty(paramTrackInfo.getUri()))
    {
      paramTrackInfo = new DataSourceException(-1, "track info has no media file path!", null);
      AppMethodBeat.o(104554);
      throw paramTrackInfo;
    }
    if (!new File(str).exists())
    {
      paramTrackInfo = new DataSourceException(-1, "track info's media file not exists!", null);
      AppMethodBeat.o(104554);
      throw paramTrackInfo;
    }
    this.mDataSource = new FileDataSource(paramTrackInfo.getUri());
    this.mTrackInfo = paramTrackInfo;
    AppMethodBeat.o(104554);
  }
  
  public void close()
  {
    AppMethodBeat.i(104558);
    this.mDataSource.close();
    AppMethodBeat.o(104558);
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    AppMethodBeat.i(104559);
    AudioFormat.AudioType localAudioType = this.mDataSource.getAudioType();
    AppMethodBeat.o(104559);
    return localAudioType;
  }
  
  public long getSize()
  {
    AppMethodBeat.i(104557);
    long l = this.mDataSource.getSize();
    AppMethodBeat.o(104557);
    return l;
  }
  
  public void onBufferingUpdate(BaseMediaPlayer paramBaseMediaPlayer, int paramInt) {}
  
  public void onCompletion(BaseMediaPlayer paramBaseMediaPlayer) {}
  
  public void onError(BaseMediaPlayer paramBaseMediaPlayer, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onPrepared(BaseMediaPlayer paramBaseMediaPlayer)
  {
    AppMethodBeat.i(104560);
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
        AppMethodBeat.o(104560);
        return;
      }
    }
    catch (IOException paramBaseMediaPlayer)
    {
      Logger.e("TrackDataSource", "dataSource open failed!", paramBaseMediaPlayer);
      AppMethodBeat.o(104560);
      return;
    }
    this.mStartTimePosition = ((Long)localPair.first).longValue();
    long l4 = paramBaseMediaPlayer.seek(((Long)localPair.first).longValue());
    long l3 = paramBaseMediaPlayer.seek(((Long)localPair.second).longValue());
    if ((l2 > 0L) && (l4 > l2))
    {
      Logger.e("TrackDataSource", "startBytePosition larger than size!");
      AppMethodBeat.o(104560);
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
    if (this.mTrackStateCallback != null) {
      this.mTrackStateCallback.onTrackPrepared(this.mTrackInfo);
    }
    AppMethodBeat.o(104560);
  }
  
  public void onSeekComplete(BaseMediaPlayer paramBaseMediaPlayer, int paramInt) {}
  
  public void onStarted(BaseMediaPlayer paramBaseMediaPlayer)
  {
    AppMethodBeat.i(104561);
    paramBaseMediaPlayer.seekTo(0);
    AppMethodBeat.o(104561);
  }
  
  public void onStateChanged(BaseMediaPlayer paramBaseMediaPlayer, int paramInt) {}
  
  public void open()
  {
    AppMethodBeat.i(104555);
    this.mDataSource.open();
    AppMethodBeat.o(104555);
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104556);
    if ((this.mEndBytePosition > 0L) && (paramLong > this.mEndBytePosition))
    {
      AppMethodBeat.o(104556);
      return -1;
    }
    paramInt1 = this.mDataSource.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(104556);
    return paramInt1;
  }
  
  public void setEndBytePosition(long paramLong)
  {
    this.mEndBytePosition = paramLong;
  }
  
  public void setTrackStateCallback(TrackDataSource.TrackStateCallback paramTrackStateCallback)
  {
    this.mTrackStateCallback = paramTrackStateCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.TrackDataSource
 * JD-Core Version:    0.7.0.1
 */
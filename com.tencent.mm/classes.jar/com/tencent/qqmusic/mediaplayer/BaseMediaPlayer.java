package com.tencent.qqmusic.mediaplayer;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory;
import com.tencent.qqmusic.mediaplayer.upstream.UriLoader;
import java.io.FileDescriptor;

public abstract class BaseMediaPlayer
{
  private static final String TAG = "BaseMediaPlayer";
  private long duration = 0L;
  private boolean isPaused = false;
  private long startTime = 0L;
  
  protected abstract void TransferStateTo(int paramInt);
  
  public abstract void addAudioListener(IAudioListener paramIAudioListener);
  
  public abstract SeekTable createSeekTable();
  
  public abstract void flush();
  
  public long getCurPlayTime()
  {
    if (this.startTime <= 0L) {
      return 0L;
    }
    if (this.isPaused) {
      return this.duration;
    }
    return this.duration + SystemClock.elapsedRealtime() - this.startTime;
  }
  
  public abstract AudioInformation getCurrentAudioInformation();
  
  public abstract long getCurrentPosition();
  
  public abstract long getCurrentPositionFromFile();
  
  public abstract int getDuration();
  
  public abstract int getPlayerState();
  
  public abstract int getSessionId();
  
  public abstract boolean isPlaying();
  
  public abstract boolean isSoftDecoder();
  
  protected void notifyPauseSong()
  {
    this.isPaused = true;
    if (this.startTime > 0L) {
      this.duration += SystemClock.elapsedRealtime() - this.startTime;
    }
  }
  
  protected void notifyStartPlaySong()
  {
    this.isPaused = false;
    this.startTime = SystemClock.elapsedRealtime();
  }
  
  public abstract void pause();
  
  public abstract void prepare();
  
  public abstract void prepareAsync();
  
  public abstract void release();
  
  public abstract void removeAudioListener(IAudioListener paramIAudioListener);
  
  public abstract void reset();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void setAudioStreamType(int paramInt);
  
  public abstract void setDataSource(Context paramContext, Uri paramUri);
  
  public abstract void setDataSource(Context paramContext, UriLoader paramUriLoader);
  
  public abstract void setDataSource(TrackInfo paramTrackInfo);
  
  public abstract void setDataSource(IMediaHTTPService paramIMediaHTTPService, Uri paramUri);
  
  public abstract void setDataSource(IDataSourceFactory paramIDataSourceFactory);
  
  public abstract void setDataSource(FileDescriptor paramFileDescriptor);
  
  public abstract void setDataSource(String paramString);
  
  public abstract void setPlayerListenerCallback(PlayerListenerCallback paramPlayerListenerCallback);
  
  public abstract void setVolume(float paramFloat1, float paramFloat2);
  
  public abstract void setWakeMode(Context paramContext, int paramInt);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
 * JD-Core Version:    0.7.0.1
 */
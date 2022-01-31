package com.tencent.qqmusic.mediaplayer.audiofx;

import android.content.Context;
import android.os.Bundle;

public abstract interface IAudioListenerBuilder
{
  public abstract IAudioListener createAudioEffect(Bundle paramBundle);
  
  public abstract Bundle getConfiguration(int paramInt, Bundle paramBundle);
  
  public abstract String getId();
  
  public abstract void init(Context paramContext);
  
  public abstract boolean isEnabled();
  
  public abstract void release();
  
  public abstract void setConfiguration(int paramInt, Bundle paramBundle);
  
  public abstract boolean setEnabled(boolean paramBoolean);
  
  public abstract void setListener(OnBuilderStateChangedListener paramOnBuilderStateChangedListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audiofx.IAudioListenerBuilder
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tav.player;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AudioFocusHelper
{
  private AudioManager.OnAudioFocusChangeListener mAudioFocusListener;
  private AudioManager mAudioManager;
  private Context mContext;
  private boolean mIsAudioFocus;
  private Player mPlayer;
  
  public AudioFocusHelper(Context paramContext, Player paramPlayer)
  {
    this.mContext = paramContext;
    this.mPlayer = paramPlayer;
  }
  
  private void ensureAudioManager()
  {
    AppMethodBeat.i(215180);
    if (this.mAudioManager == null) {
      this.mAudioManager = ((AudioManager)this.mContext.getSystemService("audio"));
    }
    AppMethodBeat.o(215180);
  }
  
  private AudioManager.OnAudioFocusChangeListener getAudioFocusChangeListener()
  {
    AppMethodBeat.i(215181);
    if (this.mAudioFocusListener == null) {
      this.mAudioFocusListener = new AudioManager.OnAudioFocusChangeListener()
      {
        public void onAudioFocusChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(215177);
          if (AudioFocusHelper.this.mPlayer == null)
          {
            AppMethodBeat.o(215177);
            return;
          }
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(215177);
            return;
            try
            {
              AudioFocusHelper.access$102(AudioFocusHelper.this, true);
              AppMethodBeat.o(215177);
              return;
            }
            catch (Exception localException)
            {
              AppMethodBeat.o(215177);
              return;
            }
            AudioFocusHelper.access$200(AudioFocusHelper.this, false);
            AppMethodBeat.o(215177);
            return;
            AudioFocusHelper.access$200(AudioFocusHelper.this, true);
          }
        }
      };
    }
    AudioManager.OnAudioFocusChangeListener localOnAudioFocusChangeListener = this.mAudioFocusListener;
    AppMethodBeat.o(215181);
    return localOnAudioFocusChangeListener;
  }
  
  private void onAudioFocusLoss(boolean paramBoolean)
  {
    AppMethodBeat.i(215182);
    if (!paramBoolean)
    {
      this.mAudioManager.abandonAudioFocus(this.mAudioFocusListener);
      this.mIsAudioFocus = false;
    }
    if ((this.mPlayer != null) && (this.mPlayer.isPlaying())) {
      this.mPlayer.pause();
    }
    AppMethodBeat.o(215182);
  }
  
  public void release()
  {
    AppMethodBeat.i(215179);
    if (this.mAudioManager != null)
    {
      this.mAudioManager.abandonAudioFocus(this.mAudioFocusListener);
      this.mAudioManager = null;
      this.mAudioFocusListener = null;
      this.mIsAudioFocus = false;
    }
    if (this.mPlayer != null) {
      this.mPlayer = null;
    }
    AppMethodBeat.o(215179);
  }
  
  public void requestFocus()
  {
    boolean bool = true;
    AppMethodBeat.i(215178);
    ensureAudioManager();
    if (!this.mIsAudioFocus) {
      if (this.mAudioManager.requestAudioFocus(getAudioFocusChangeListener(), 3, 1) != 1) {
        break label46;
      }
    }
    for (;;)
    {
      this.mIsAudioFocus = bool;
      AppMethodBeat.o(215178);
      return;
      label46:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.player.AudioFocusHelper
 * JD-Core Version:    0.7.0.1
 */
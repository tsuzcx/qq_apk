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
    AppMethodBeat.i(218540);
    if (this.mAudioManager == null) {
      this.mAudioManager = ((AudioManager)this.mContext.getSystemService("audio"));
    }
    AppMethodBeat.o(218540);
  }
  
  private AudioManager.OnAudioFocusChangeListener getAudioFocusChangeListener()
  {
    AppMethodBeat.i(218541);
    if (this.mAudioFocusListener == null) {
      this.mAudioFocusListener = new AudioManager.OnAudioFocusChangeListener()
      {
        public void onAudioFocusChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(218537);
          if (AudioFocusHelper.this.mPlayer == null)
          {
            AppMethodBeat.o(218537);
            return;
          }
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(218537);
            return;
            try
            {
              AudioFocusHelper.access$102(AudioFocusHelper.this, true);
              AppMethodBeat.o(218537);
              return;
            }
            catch (Exception localException)
            {
              AppMethodBeat.o(218537);
              return;
            }
            AudioFocusHelper.access$200(AudioFocusHelper.this, false);
            AppMethodBeat.o(218537);
            return;
            AudioFocusHelper.access$200(AudioFocusHelper.this, true);
          }
        }
      };
    }
    AudioManager.OnAudioFocusChangeListener localOnAudioFocusChangeListener = this.mAudioFocusListener;
    AppMethodBeat.o(218541);
    return localOnAudioFocusChangeListener;
  }
  
  private void onAudioFocusLoss(boolean paramBoolean)
  {
    AppMethodBeat.i(218542);
    if (!paramBoolean)
    {
      this.mAudioManager.abandonAudioFocus(this.mAudioFocusListener);
      this.mIsAudioFocus = false;
    }
    if ((this.mPlayer != null) && (this.mPlayer.isPlaying())) {
      this.mPlayer.pause();
    }
    AppMethodBeat.o(218542);
  }
  
  public void release()
  {
    AppMethodBeat.i(218539);
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
    AppMethodBeat.o(218539);
  }
  
  public void requestFocus()
  {
    boolean bool = true;
    AppMethodBeat.i(218538);
    ensureAudioManager();
    if (!this.mIsAudioFocus) {
      if (this.mAudioManager.requestAudioFocus(getAudioFocusChangeListener(), 3, 1) != 1) {
        break label46;
      }
    }
    for (;;)
    {
      this.mIsAudioFocus = bool;
      AppMethodBeat.o(218538);
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
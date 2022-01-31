package com.tencent.mm.plugin.music.ui;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

final class MusicSeekBar$2
  implements SeekBar.OnSeekBarChangeListener
{
  MusicSeekBar$2(MusicSeekBar paramMusicSeekBar) {}
  
  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public final void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.mCm.mCi = true;
  }
  
  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.mCm.mCi = false;
    if (MusicSeekBar.b(this.mCm) != null) {
      MusicSeekBar.b(this.mCm).uZ(paramSeekBar.getProgress());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicSeekBar.2
 * JD-Core Version:    0.7.0.1
 */
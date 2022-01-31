package com.tencent.mm.plugin.music.b.b;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
{
  public AudioManager dui = (AudioManager)ae.getContext().getSystemService("audio");
  public boolean mxR = false;
  public AudioManager.OnAudioFocusChangeListener mxS = new a.1(this);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.b.a
 * JD-Core Version:    0.7.0.1
 */
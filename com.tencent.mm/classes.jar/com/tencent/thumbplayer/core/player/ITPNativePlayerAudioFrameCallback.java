package com.tencent.thumbplayer.core.player;

import com.tencent.thumbplayer.core.common.TPAudioFrame;

public abstract interface ITPNativePlayerAudioFrameCallback
{
  public static final int FLAG_EOS = 1;
  
  public abstract void onAudioFrame(TPAudioFrame paramTPAudioFrame, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.core.player.ITPNativePlayerAudioFrameCallback
 * JD-Core Version:    0.7.0.1
 */
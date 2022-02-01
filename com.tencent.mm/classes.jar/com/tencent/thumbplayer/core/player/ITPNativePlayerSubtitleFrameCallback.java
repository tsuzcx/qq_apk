package com.tencent.thumbplayer.core.player;

import com.tencent.thumbplayer.core.common.TPSubtitleFrame;

public abstract interface ITPNativePlayerSubtitleFrameCallback
{
  public static final int FLAG_EOS = 1;
  
  public abstract void onSubtitleFrame(TPSubtitleFrame paramTPSubtitleFrame, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.core.player.ITPNativePlayerSubtitleFrameCallback
 * JD-Core Version:    0.7.0.1
 */
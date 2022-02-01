package com.tencent.tav.player;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.VideoTexture;
import java.util.HashMap;

public class PlayerItemVideoOutput
  extends PlayerItemOutput
{
  PlayerItemVideoOutput(HashMap<String, Object> paramHashMap) {}
  
  public VideoTexture copyPixelBufferForItemTime(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    return null;
  }
  
  public boolean hasNewPixelBufferForItemTime(CMTime paramCMTime)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.player.PlayerItemVideoOutput
 * JD-Core Version:    0.7.0.1
 */
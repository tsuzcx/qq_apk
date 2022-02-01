package com.tencent.mm.plugin.ringtone;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.kernel.b.d;

public abstract interface a
  extends d, com.tencent.mm.kernel.c.a
{
  public abstract int checkPlayerStatus();
  
  public abstract com.tencent.mm.plugin.ringtone.a.a getPlayInfo();
  
  public abstract int getStreamType();
  
  public abstract void jumpToRingtoneSettingUI(Context paramContext, int paramInt);
  
  public abstract boolean pausePlay();
  
  public abstract boolean responseSence(a.a parama, Bundle paramBundle);
  
  public abstract boolean resumePlay();
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setRingSpeakerStatus(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.a
 * JD-Core Version:    0.7.0.1
 */
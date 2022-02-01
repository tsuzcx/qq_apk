package com.tencent.mm.plugin.musicchat.a;

import android.content.Context;
import com.tencent.mm.aw.f;

public abstract interface a
  extends com.tencent.mm.kernel.b.a
{
  public abstract b getMusicSender();
  
  public abstract boolean isEnableMusicChat();
  
  public abstract void onExitChat();
  
  public abstract void setMusicSender(b paramb);
  
  public abstract void startSendMusic(Context paramContext);
  
  public abstract void writMusicHistory(f paramf);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.musicchat.a.a
 * JD-Core Version:    0.7.0.1
 */
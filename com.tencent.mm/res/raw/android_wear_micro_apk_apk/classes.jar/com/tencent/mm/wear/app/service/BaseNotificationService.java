package com.tencent.mm.wear.app.service;

import android.content.Intent;
import com.tencent.mm.wear.a.c.d;

public abstract class BaseNotificationService
  extends BaseWearService
{
  private int aep;
  private int agB;
  private String agG;
  
  protected abstract void a(Intent paramIntent, int paramInt1, String paramString, int paramInt2);
  
  protected final void e(Intent paramIntent)
  {
    this.agG = paramIntent.getStringExtra("key_talker");
    this.agB = paramIntent.getIntExtra("key_notification_id", 0);
    this.aep = paramIntent.getIntExtra("key_fun_id", 0);
    d.c("MicroMsg.BaseGACService", "send request: talker=%s | notificationId=%d | funId=%d", new Object[] { this.agG, Integer.valueOf(this.agB), Integer.valueOf(this.aep) });
    a(paramIntent, this.agB, this.agG, this.aep);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.service.BaseNotificationService
 * JD-Core Version:    0.7.0.1
 */
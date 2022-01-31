package com.tencent.mm.wear.app.service;

import android.content.Intent;
import com.tencent.mm.wear.a.c.d;

public abstract class BaseNotificationService
  extends BaseWearService
{
  private int aaO;
  private int ada;
  private String adf;
  
  protected abstract void a(Intent paramIntent, int paramInt1, String paramString, int paramInt2);
  
  protected final void c(Intent paramIntent)
  {
    this.adf = paramIntent.getStringExtra("key_talker");
    this.ada = paramIntent.getIntExtra("key_notification_id", 0);
    this.aaO = paramIntent.getIntExtra("key_fun_id", 0);
    d.c("MicroMsg.BaseGACService", "send request: talker=%s | notificationId=%d | funId=%d", new Object[] { this.adf, Integer.valueOf(this.ada), Integer.valueOf(this.aaO) });
    a(paramIntent, this.ada, this.adf, this.aaO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.service.BaseNotificationService
 * JD-Core Version:    0.7.0.1
 */
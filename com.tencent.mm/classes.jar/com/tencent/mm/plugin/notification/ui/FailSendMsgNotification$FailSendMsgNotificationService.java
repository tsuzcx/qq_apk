package com.tencent.mm.plugin.notification.ui;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class FailSendMsgNotification$FailSendMsgNotificationService
  extends Service
{
  protected com.tencent.mm.sdk.b.c pjQ = new FailSendMsgNotification.FailSendMsgNotificationService.1(this);
  protected FailSendMsgNotification pjR = null;
  
  protected abstract int bYu();
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    ab.d("MicroMsg.FailSendMsgNotification", "onCreate FailSendMsgNotificationService");
    com.tencent.mm.sdk.b.a.ymk.c(this.pjQ);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ab.d("MicroMsg.FailSendMsgNotification", "onDestroy FailSendMsgNotificationService");
    com.tencent.mm.sdk.b.a.ymk.d(this.pjQ);
  }
  
  @TargetApi(16)
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    ab.d("MicroMsg.FailSendMsgNotification", "onStartCommand");
    if ((paramIntent == null) || (paramIntent.getExtras() == null)) {
      ab.d("MicroMsg.FailSendMsgNotification", "handle action button, intent is null");
    }
    String str;
    label362:
    do
    {
      do
      {
        do
        {
          do
          {
            return 2;
            str = paramIntent.getAction();
            if (bo.isNullOrNil(str))
            {
              ab.d("MicroMsg.FailSendMsgNotification", "handle action button, action is null");
              return 2;
            }
            paramInt1 = paramIntent.getExtras().getInt("notification_type", -1);
            ab.d("MicroMsg.FailSendMsgNotification", "handle action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
            if (f.AV(paramInt1) == null)
            {
              ab.d("MicroMsg.FailSendMsgNotification", "handle action button, notification not exist");
              return 2;
            }
            ab.d("MicroMsg.FailSendMsgNotification", "action:%s", new Object[] { str });
            this.pjR = f.AV(paramInt1);
            if (!str.startsWith("com.tencent.failnotification.omit")) {
              break;
            }
          } while (this.pjR.pjE == null);
          ab.d("MicroMsg.FailSendMsgNotification", "handle omit action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
          this.pjR.pjE.bYf();
          return 2;
          if (!str.startsWith("com.tencent.failnotificaiton.resend")) {
            break;
          }
        } while (this.pjR.pjE == null);
        boolean bool1;
        if (this.pjR.yC == null)
        {
          bool1 = true;
          if (this.pjR.pjB != null) {
            break label362;
          }
        }
        for (boolean bool2 = true;; bool2 = false)
        {
          ab.d("MicroMsg.FailSendMsgNotification", "handle resend action button, type:%d, notification==null:%b, notificationBuilder==null:%b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if (this.pjR != null) {
            this.pjR.bNX = true;
          }
          if ((this.pjR.yC != null) && (Build.VERSION.SDK_INT >= 16)) {
            this.pjR.yC.priority = 0;
          }
          if (this.pjR.yC == null) {
            this.pjR.show();
          }
          startForeground(paramInt1, this.pjR.yC);
          this.pjR.pjE.bYe();
          ab.d("MicroMsg.FailSendMsgNotification", "finish handle resend action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
          return 2;
          bool1 = false;
          break;
        }
        if (!str.startsWith("com.tencent.failnotification.click")) {
          break;
        }
      } while (this.pjR.pjF == null);
      ab.d("MicroMsg.FailSendMsgNotification", "handle click notification, type:%d", new Object[] { Integer.valueOf(paramInt1) });
      this.pjR.pjF.bYg();
      return 2;
    } while (!str.startsWith("com.tencent.failnotification.dismiss"));
    this.pjR.pjN = false;
    this.pjR.bNX = false;
    if (this.pjR.pjG != null)
    {
      ab.d("MicroMsg.FailSendMsgNotification", "handle notification dismiss");
      this.pjR.pjG.onDismiss();
    }
    stopSelf();
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.ui.FailSendMsgNotification.FailSendMsgNotificationService
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.notification.ui;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public abstract class FailSendMsgNotification$FailSendMsgNotificationService
  extends Service
{
  protected com.tencent.mm.sdk.b.c mJB = new FailSendMsgNotification.FailSendMsgNotificationService.1(this);
  protected FailSendMsgNotification mJC = null;
  
  protected abstract int bpO();
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    y.d("MicroMsg.FailSendMsgNotification", "onCreate FailSendMsgNotificationService");
    com.tencent.mm.sdk.b.a.udP.c(this.mJB);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    y.d("MicroMsg.FailSendMsgNotification", "onDestroy FailSendMsgNotificationService");
    com.tencent.mm.sdk.b.a.udP.d(this.mJB);
  }
  
  @TargetApi(16)
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.FailSendMsgNotification", "onStartCommand");
    if ((paramIntent == null) || (paramIntent.getExtras() == null)) {
      y.d("MicroMsg.FailSendMsgNotification", "handle action button, intent is null");
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
            if (bk.bl(str))
            {
              y.d("MicroMsg.FailSendMsgNotification", "handle action button, action is null");
              return 2;
            }
            paramInt1 = paramIntent.getExtras().getInt("notification_type", -1);
            y.d("MicroMsg.FailSendMsgNotification", "handle action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
            if (f.vx(paramInt1) == null)
            {
              y.d("MicroMsg.FailSendMsgNotification", "handle action button, notification not exist");
              return 2;
            }
            y.d("MicroMsg.FailSendMsgNotification", "action:%s", new Object[] { str });
            this.mJC = f.vx(paramInt1);
            if (!str.startsWith("com.tencent.failnotification.omit")) {
              break;
            }
          } while (this.mJC.mJp == null);
          y.d("MicroMsg.FailSendMsgNotification", "handle omit action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
          this.mJC.mJp.bpz();
          return 2;
          if (!str.startsWith("com.tencent.failnotificaiton.resend")) {
            break;
          }
        } while (this.mJC.mJp == null);
        boolean bool1;
        if (this.mJC.yb == null)
        {
          bool1 = true;
          if (this.mJC.mJm != null) {
            break label362;
          }
        }
        for (boolean bool2 = true;; bool2 = false)
        {
          y.d("MicroMsg.FailSendMsgNotification", "handle resend action button, type:%d, notification==null:%b, notificationBuilder==null:%b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if (this.mJC != null) {
            this.mJC.bqV = true;
          }
          if ((this.mJC.yb != null) && (Build.VERSION.SDK_INT >= 16)) {
            this.mJC.yb.priority = 0;
          }
          if (this.mJC.yb == null) {
            this.mJC.show();
          }
          startForeground(paramInt1, this.mJC.yb);
          this.mJC.mJp.bpy();
          y.d("MicroMsg.FailSendMsgNotification", "finish handle resend action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
          return 2;
          bool1 = false;
          break;
        }
        if (!str.startsWith("com.tencent.failnotification.click")) {
          break;
        }
      } while (this.mJC.mJq == null);
      y.d("MicroMsg.FailSendMsgNotification", "handle click notification, type:%d", new Object[] { Integer.valueOf(paramInt1) });
      this.mJC.mJq.bpA();
      return 2;
    } while (!str.startsWith("com.tencent.failnotification.dismiss"));
    this.mJC.mJy = false;
    this.mJC.bqV = false;
    if (this.mJC.mJr != null)
    {
      y.d("MicroMsg.FailSendMsgNotification", "handle notification dismiss");
      this.mJC.mJr.onDismiss();
    }
    stopSelf();
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.ui.FailSendMsgNotification.FailSendMsgNotificationService
 * JD-Core Version:    0.7.0.1
 */
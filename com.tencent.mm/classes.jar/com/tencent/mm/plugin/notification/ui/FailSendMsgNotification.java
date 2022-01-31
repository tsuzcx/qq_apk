package com.tencent.mm.plugin.notification.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.app.x.c;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

@SuppressLint({"InlinedApi"})
public final class FailSendMsgNotification
{
  boolean bqV = false;
  public Context mContext;
  private boolean mIsInit = false;
  public boolean mJA = true;
  public x.c mJm = null;
  private Intent mJn = null;
  private int mJo = 0;
  public a mJp = null;
  public b mJq = null;
  public c mJr = null;
  public String mJs = null;
  public String mJt = null;
  private PendingIntent mJu = null;
  private PendingIntent mJv = null;
  private PendingIntent mJw = null;
  private PendingIntent mJx = null;
  public boolean mJy = false;
  public boolean mJz = false;
  private int mType;
  Notification yb = null;
  
  public FailSendMsgNotification() {}
  
  public FailSendMsgNotification(int paramInt)
  {
    this.mType = paramInt;
    this.mContext = ae.getContext();
    this.mJm = new x.c(this.mContext, (byte)0);
    this.mJA = true;
    this.mJt = "";
    try
    {
      if (this.mJA) {
        bpJ();
      }
      bpK();
      this.mIsInit = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.FailSendMsgNotification", "init FailSendMsgNotification error, e:%s", new Object[] { localException.getMessage() });
        this.mIsInit = false;
        continue;
        boolean bool = false;
      }
    }
    if (this.mContext == null)
    {
      bool = true;
      y.d("MicroMsg.FailSendMsgNotification", "create FailSendMsgNotification, type:%d, context==null:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      this.mJy = false;
      return;
    }
  }
  
  private void bpJ()
  {
    this.mJm.xQ = true;
    Intent localIntent = new Intent();
    if (this.mType == 1)
    {
      localIntent.setAction("com.tencent.failnotification.omit_msg");
      localIntent.setClass(this.mContext, FailSendMsgNotification.FailSendNormalMsgNotificationService.class);
      localIntent.putExtra("notification_type", this.mType);
      this.mJw = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.mJm.a(R.g.notification_message_ignore_icon, this.mContext.getString(R.l.notification_fail_send_msg_omit), this.mJw);
      localIntent = new Intent();
      if (this.mType != 1) {
        break label229;
      }
      localIntent.setAction("com.tencent.failnotificaiton.resend_msg");
      localIntent.setClass(this.mContext, FailSendMsgNotification.FailSendNormalMsgNotificationService.class);
    }
    for (;;)
    {
      localIntent.putExtra("notification_type", this.mType);
      if (Build.VERSION.SDK_INT >= 16) {
        localIntent.addFlags(268435456);
      }
      this.mJx = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.mJm.a(R.g.notification_message_resend_icon, this.mContext.getString(R.l.notification_fail_send_msg_resend), this.mJx);
      return;
      if (this.mType != 2) {
        break;
      }
      localIntent.setAction("com.tencent.failnotification.omit_sns");
      localIntent.setClass(this.mContext, FailSendMsgNotification.FailSendSnsMsgNotificationService.class);
      break;
      label229:
      if (this.mType == 2)
      {
        localIntent.setAction("com.tencent.failnotificaiton.resend_sns");
        localIntent.setClass(this.mContext, FailSendMsgNotification.FailSendSnsMsgNotificationService.class);
      }
    }
  }
  
  public final void Kj(String paramString)
  {
    this.mJs = paramString;
    show();
  }
  
  public final void bpK()
  {
    Object localObject = new Intent();
    if (this.mType == 1)
    {
      ((Intent)localObject).setAction("com.tencent.failnotification.click_msg");
      ((Intent)localObject).setClass(this.mContext, FailSendMsgNotification.FailSendNormalMsgNotificationService.class);
      ((Intent)localObject).putExtra("notification_type", this.mType);
      this.mJu = PendingIntent.getService(this.mContext, this.mType, (Intent)localObject, 134217728);
      this.mJm.xz = this.mJu;
      localObject = new Intent();
      if (this.mType != 1) {
        break label185;
      }
      ((Intent)localObject).setAction("com.tencent.failnotification.dismiss_msg");
      ((Intent)localObject).setClass(this.mContext, FailSendMsgNotification.FailSendNormalMsgNotificationService.class);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("notification_type", this.mType);
      this.mJv = PendingIntent.getService(this.mContext, this.mType, (Intent)localObject, 134217728);
      localObject = this.mJm;
      PendingIntent localPendingIntent = this.mJv;
      ((x.c)localObject).yb.deleteIntent = localPendingIntent;
      return;
      if (this.mType != 2) {
        break;
      }
      ((Intent)localObject).setAction("com.tencent.failnotification.click_sns");
      ((Intent)localObject).setClass(this.mContext, FailSendMsgNotification.FailSendSnsMsgNotificationService.class);
      break;
      label185:
      if (this.mType == 2)
      {
        ((Intent)localObject).setAction("com.tencent.failnotification.dismiss_sns");
        ((Intent)localObject).setClass(this.mContext, FailSendMsgNotification.FailSendSnsMsgNotificationService.class);
      }
    }
  }
  
  public final void bpL()
  {
    y.d("MicroMsg.FailSendMsgNotification", "setIsForeground:%b", new Object[] { Boolean.valueOf(false) });
    this.bqV = false;
  }
  
  public final void bpM()
  {
    this.mJm.l(2, false);
    this.mJz = false;
    show();
    y.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, unLockInNotificationBar");
  }
  
  public final void bpN()
  {
    this.mJA = true;
    this.mJm = new x.c(this.mContext, (byte)0);
    bpJ();
    bpK();
  }
  
  public final void dismiss()
  {
    au.getNotification().cancel(this.mType);
    Intent localIntent = new Intent();
    if (this.mType == 1)
    {
      localIntent.setClass(this.mContext, FailSendMsgNotification.FailSendNormalMsgNotificationService.class);
      this.mContext.stopService(localIntent);
    }
    for (;;)
    {
      this.bqV = false;
      this.mJy = false;
      return;
      if (this.mType == 2)
      {
        localIntent.setClass(this.mContext, FailSendMsgNotification.FailSendSnsMsgNotificationService.class);
        this.mContext.stopService(localIntent);
      }
    }
  }
  
  @TargetApi(16)
  public final void show()
  {
    if (!this.mIsInit)
    {
      y.e("MicroMsg.FailSendMsgNotification", "when show notification, is not init yet");
      return;
    }
    this.mJm.e(this.mJt);
    this.mJm.c(this.mContext.getText(R.l.app_name));
    x.c localc = this.mJm;
    if (Build.VERSION.SDK_INT < 19) {}
    for (int i = R.g.notification_icon;; i = R.g.notification_icon_gray)
    {
      localc.ah(i);
      this.mJm.d(this.mJs);
      this.mJm.z(false);
      this.yb = this.mJm.build();
      if ((Build.VERSION.SDK_INT >= 16) && (!this.bqV))
      {
        this.yb.priority = 2;
        y.d("MicroMsg.FailSendMsgNotification", "show notification, set priority to max");
      }
      y.d("MicroMsg.FailSendMsgNotification", "show notification, mIsForeground:%b", new Object[] { Boolean.valueOf(this.bqV) });
      au.getNotification().a(this.mType, this.yb, false);
      this.mJy = true;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.ui.FailSendMsgNotification
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.notification.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mm;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

@SuppressLint({"InlinedApi"})
public final class FailSendMsgNotification
{
  Notification FW;
  boolean ctA;
  private Intent cwE;
  public Context mContext;
  private boolean mIsInit;
  private int mType;
  public s.c vrc;
  private int vrd;
  public a vre;
  public b vrf;
  public c vrg;
  public String vrh;
  public String vri;
  private PendingIntent vrj;
  private PendingIntent vrk;
  private PendingIntent vrl;
  private PendingIntent vrm;
  public boolean vrn;
  public boolean vro;
  public boolean vrp;
  
  public FailSendMsgNotification()
  {
    this.FW = null;
    this.vrc = null;
    this.cwE = null;
    this.vrd = 0;
    this.vre = null;
    this.vrf = null;
    this.vrg = null;
    this.vrh = null;
    this.vri = null;
    this.vrj = null;
    this.vrk = null;
    this.vrl = null;
    this.vrm = null;
    this.vrn = false;
    this.vro = false;
    this.ctA = false;
    this.mIsInit = false;
    this.vrp = true;
  }
  
  public FailSendMsgNotification(int paramInt)
  {
    AppMethodBeat.i(26811);
    this.FW = null;
    this.vrc = null;
    this.cwE = null;
    this.vrd = 0;
    this.vre = null;
    this.vrf = null;
    this.vrg = null;
    this.vrh = null;
    this.vri = null;
    this.vrj = null;
    this.vrk = null;
    this.vrl = null;
    this.vrm = null;
    this.vrn = false;
    this.vro = false;
    this.ctA = false;
    this.mIsInit = false;
    this.vrp = true;
    this.mType = paramInt;
    this.mContext = ai.getContext();
    this.vrc = com.tencent.mm.bq.a.bE(this.mContext, com.tencent.mm.bq.a.eJR());
    this.vrp = true;
    this.vri = "";
    try
    {
      if (this.vrp) {
        dlI();
      }
      dlJ();
      this.mIsInit = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.FailSendMsgNotification", "init FailSendMsgNotification error, e:%s", new Object[] { localException.getMessage() });
        this.mIsInit = false;
        continue;
        boolean bool = false;
      }
    }
    if (this.mContext == null)
    {
      bool = true;
      ac.d("MicroMsg.FailSendMsgNotification", "create FailSendMsgNotification, type:%d, context==null:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      this.vrn = false;
      AppMethodBeat.o(26811);
      return;
    }
  }
  
  private void dlI()
  {
    AppMethodBeat.i(26812);
    this.vrc.FL = true;
    Intent localIntent = new Intent();
    if (this.mType == 1)
    {
      localIntent.setAction("com.tencent.failnotification.omit_msg");
      localIntent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
      localIntent.putExtra("notification_type", this.mType);
      this.vrl = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.vrc.a(2131233504, this.mContext.getString(2131761683), this.vrl);
      localIntent = new Intent();
      if (this.mType != 1) {
        break label237;
      }
      localIntent.setAction("com.tencent.failnotificaiton.resend_msg");
      localIntent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
    }
    for (;;)
    {
      localIntent.putExtra("notification_type", this.mType);
      if (Build.VERSION.SDK_INT >= 16) {
        localIntent.addFlags(268435456);
      }
      this.vrm = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.vrc.a(2131233505, this.mContext.getString(2131761684), this.vrm);
      AppMethodBeat.o(26812);
      return;
      if (this.mType != 2) {
        break;
      }
      localIntent.setAction("com.tencent.failnotification.omit_sns");
      localIntent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
      break;
      label237:
      if (this.mType == 2)
      {
        localIntent.setAction("com.tencent.failnotificaiton.resend_sns");
        localIntent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
      }
    }
  }
  
  private static int dlN()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 2131233500;
    }
    return 2131233502;
  }
  
  public final void aoA(String paramString)
  {
    AppMethodBeat.i(26814);
    this.vrh = paramString;
    show();
    AppMethodBeat.o(26814);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(26817);
    az.getNotification().cancel(this.mType);
    Intent localIntent = new Intent();
    if (this.mType == 1)
    {
      localIntent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
      this.mContext.stopService(localIntent);
    }
    for (;;)
    {
      this.ctA = false;
      this.vrn = false;
      AppMethodBeat.o(26817);
      return;
      if (this.mType == 2)
      {
        localIntent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        this.mContext.stopService(localIntent);
      }
    }
  }
  
  public final void dlJ()
  {
    AppMethodBeat.i(26813);
    Intent localIntent = new Intent();
    if (this.mType == 1)
    {
      localIntent.setAction("com.tencent.failnotification.click_msg");
      localIntent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
      localIntent.putExtra("notification_type", this.mType);
      this.vrj = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.vrc.Fu = this.vrj;
      localIntent = new Intent();
      if (this.mType != 1) {
        break label192;
      }
      localIntent.setAction("com.tencent.failnotification.dismiss_msg");
      localIntent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
    }
    for (;;)
    {
      localIntent.putExtra("notification_type", this.mType);
      this.vrk = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.vrc.b(this.vrk);
      AppMethodBeat.o(26813);
      return;
      if (this.mType != 2) {
        break;
      }
      localIntent.setAction("com.tencent.failnotification.click_sns");
      localIntent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
      break;
      label192:
      if (this.mType == 2)
      {
        localIntent.setAction("com.tencent.failnotification.dismiss_sns");
        localIntent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
      }
    }
  }
  
  public final void dlK()
  {
    AppMethodBeat.i(26815);
    ac.d("MicroMsg.FailSendMsgNotification", "setIsForeground:%b", new Object[] { Boolean.FALSE });
    this.ctA = false;
    AppMethodBeat.o(26815);
  }
  
  public final void dlL()
  {
    AppMethodBeat.i(26818);
    this.vrc.f(2, false);
    this.vro = false;
    show();
    ac.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, unLockInNotificationBar");
    AppMethodBeat.o(26818);
  }
  
  public final void dlM()
  {
    AppMethodBeat.i(26819);
    this.vrp = true;
    this.vrc = com.tencent.mm.bq.a.bE(this.mContext, com.tencent.mm.bq.a.eJR());
    dlI();
    dlJ();
    AppMethodBeat.o(26819);
  }
  
  @TargetApi(16)
  public final void show()
  {
    AppMethodBeat.i(26816);
    if (!this.mIsInit)
    {
      ac.e("MicroMsg.FailSendMsgNotification", "when show notification, is not init yet");
      AppMethodBeat.o(26816);
      return;
    }
    this.vrc.i(this.vri);
    this.vrc.f(this.mContext.getText(2131755822));
    this.vrc.as(dlN());
    this.vrc.g(this.vrh);
    this.vrc.F(false);
    this.FW = this.vrc.build();
    if ((Build.VERSION.SDK_INT >= 16) && (!this.ctA))
    {
      this.FW.priority = 2;
      ac.d("MicroMsg.FailSendMsgNotification", "show notification, set priority to max");
    }
    ac.d("MicroMsg.FailSendMsgNotification", "show notification, mIsForeground:%b", new Object[] { Boolean.valueOf(this.ctA) });
    az.getNotification().a(this.mType, this.FW, false);
    this.vrn = true;
    AppMethodBeat.o(26816);
  }
  
  public static abstract class FailSendMsgNotificationService
    extends Service
  {
    protected com.tencent.mm.sdk.b.c vrq = new com.tencent.mm.sdk.b.c() {};
    protected FailSendMsgNotification vrr = null;
    
    protected abstract int dlO();
    
    public IBinder onBind(Intent paramIntent)
    {
      return null;
    }
    
    public void onCreate()
    {
      super.onCreate();
      ac.d("MicroMsg.FailSendMsgNotification", "onCreate FailSendMsgNotificationService");
      com.tencent.mm.sdk.b.a.GpY.c(this.vrq);
    }
    
    public void onDestroy()
    {
      super.onDestroy();
      ac.d("MicroMsg.FailSendMsgNotification", "onDestroy FailSendMsgNotificationService");
      com.tencent.mm.sdk.b.a.GpY.d(this.vrq);
    }
    
    @TargetApi(16)
    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
    {
      ac.d("MicroMsg.FailSendMsgNotification", "onStartCommand");
      if ((paramIntent == null) || (paramIntent.getExtras() == null)) {
        ac.d("MicroMsg.FailSendMsgNotification", "handle action button, intent is null");
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
              if (bs.isNullOrNil(str))
              {
                ac.d("MicroMsg.FailSendMsgNotification", "handle action button, action is null");
                return 2;
              }
              paramInt1 = paramIntent.getExtras().getInt("notification_type", -1);
              ac.d("MicroMsg.FailSendMsgNotification", "handle action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
              if (f.KD(paramInt1) == null)
              {
                ac.d("MicroMsg.FailSendMsgNotification", "handle action button, notification not exist");
                return 2;
              }
              ac.d("MicroMsg.FailSendMsgNotification", "action:%s", new Object[] { str });
              this.vrr = f.KD(paramInt1);
              if (!str.startsWith("com.tencent.failnotification.omit")) {
                break;
              }
            } while (this.vrr.vre == null);
            ac.d("MicroMsg.FailSendMsgNotification", "handle omit action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
            this.vrr.vre.dlz();
            return 2;
            if (!str.startsWith("com.tencent.failnotificaiton.resend")) {
              break;
            }
          } while (this.vrr.vre == null);
          boolean bool1;
          if (this.vrr.FW == null)
          {
            bool1 = true;
            if (this.vrr.vrc != null) {
              break label362;
            }
          }
          for (boolean bool2 = true;; bool2 = false)
          {
            ac.d("MicroMsg.FailSendMsgNotification", "handle resend action button, type:%d, notification==null:%b, notificationBuilder==null:%b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            if (this.vrr != null) {
              this.vrr.ctA = true;
            }
            if ((this.vrr.FW != null) && (Build.VERSION.SDK_INT >= 16)) {
              this.vrr.FW.priority = 0;
            }
            if (this.vrr.FW == null) {
              this.vrr.show();
            }
            startForeground(paramInt1, this.vrr.FW);
            this.vrr.vre.dly();
            ac.d("MicroMsg.FailSendMsgNotification", "finish handle resend action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
            return 2;
            bool1 = false;
            break;
          }
          if (!str.startsWith("com.tencent.failnotification.click")) {
            break;
          }
        } while (this.vrr.vrf == null);
        ac.d("MicroMsg.FailSendMsgNotification", "handle click notification, type:%d", new Object[] { Integer.valueOf(paramInt1) });
        this.vrr.vrf.dlA();
        return 2;
      } while (!str.startsWith("com.tencent.failnotification.dismiss"));
      this.vrr.vrn = false;
      this.vrr.ctA = false;
      if (this.vrr.vrg != null)
      {
        ac.d("MicroMsg.FailSendMsgNotification", "handle notification dismiss");
        this.vrr.vrg.onDismiss();
      }
      stopSelf();
      return 2;
    }
  }
  
  public static class FailSendNormalMsgNotificationService
    extends FailSendMsgNotification.FailSendMsgNotificationService
  {
    protected final int dlO()
    {
      return 1;
    }
  }
  
  public static class FailSendSnsMsgNotificationService
    extends FailSendMsgNotification.FailSendMsgNotificationService
  {
    protected final int dlO()
    {
      return 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.ui.FailSendMsgNotification
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.g.a.mw;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

@SuppressLint({"InlinedApi"})
public final class FailSendMsgNotification
{
  Notification HN;
  boolean cFc;
  private Intent cIi;
  public Context mContext;
  private boolean mIsInit;
  private int mType;
  public s.c wMf;
  private int wMg;
  public a wMh;
  public b wMi;
  public c wMj;
  public String wMk;
  public String wMl;
  private PendingIntent wMm;
  private PendingIntent wMn;
  private PendingIntent wMo;
  private PendingIntent wMp;
  public boolean wMq;
  public boolean wMr;
  public boolean wMs;
  
  public FailSendMsgNotification()
  {
    this.HN = null;
    this.wMf = null;
    this.cIi = null;
    this.wMg = 0;
    this.wMh = null;
    this.wMi = null;
    this.wMj = null;
    this.wMk = null;
    this.wMl = null;
    this.wMm = null;
    this.wMn = null;
    this.wMo = null;
    this.wMp = null;
    this.wMq = false;
    this.wMr = false;
    this.cFc = false;
    this.mIsInit = false;
    this.wMs = true;
  }
  
  public FailSendMsgNotification(int paramInt)
  {
    AppMethodBeat.i(26811);
    this.HN = null;
    this.wMf = null;
    this.cIi = null;
    this.wMg = 0;
    this.wMh = null;
    this.wMi = null;
    this.wMj = null;
    this.wMk = null;
    this.wMl = null;
    this.wMm = null;
    this.wMn = null;
    this.wMo = null;
    this.wMp = null;
    this.wMq = false;
    this.wMr = false;
    this.cFc = false;
    this.mIsInit = false;
    this.wMs = true;
    this.mType = paramInt;
    this.mContext = ak.getContext();
    this.wMf = com.tencent.mm.bq.a.bJ(this.mContext, com.tencent.mm.bq.a.fct());
    this.wMs = true;
    this.wMl = "";
    try
    {
      if (this.wMs) {
        dzp();
      }
      dzq();
      this.mIsInit = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.FailSendMsgNotification", "init FailSendMsgNotification error, e:%s", new Object[] { localException.getMessage() });
        this.mIsInit = false;
        continue;
        boolean bool = false;
      }
    }
    if (this.mContext == null)
    {
      bool = true;
      ae.d("MicroMsg.FailSendMsgNotification", "create FailSendMsgNotification, type:%d, context==null:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      this.wMq = false;
      AppMethodBeat.o(26811);
      return;
    }
  }
  
  private void dzp()
  {
    AppMethodBeat.i(26812);
    this.wMf.HC = true;
    Intent localIntent = new Intent();
    if (this.mType == 1)
    {
      localIntent.setAction("com.tencent.failnotification.omit_msg");
      localIntent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
      localIntent.putExtra("notification_type", this.mType);
      this.wMo = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.wMf.a(2131233504, this.mContext.getString(2131761683), this.wMo);
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
      this.wMp = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.wMf.a(2131233505, this.mContext.getString(2131761684), this.wMp);
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
  
  private static int dzu()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 2131233500;
    }
    return 2131233502;
  }
  
  public final void auP(String paramString)
  {
    AppMethodBeat.i(26814);
    this.wMk = paramString;
    show();
    AppMethodBeat.o(26814);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(26817);
    bc.getNotification().cancel(this.mType);
    Intent localIntent = new Intent();
    if (this.mType == 1)
    {
      localIntent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
      this.mContext.stopService(localIntent);
    }
    for (;;)
    {
      this.cFc = false;
      this.wMq = false;
      AppMethodBeat.o(26817);
      return;
      if (this.mType == 2)
      {
        localIntent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        this.mContext.stopService(localIntent);
      }
    }
  }
  
  public final void dzq()
  {
    AppMethodBeat.i(26813);
    Intent localIntent = new Intent();
    if (this.mType == 1)
    {
      localIntent.setAction("com.tencent.failnotification.click_msg");
      localIntent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
      localIntent.putExtra("notification_type", this.mType);
      this.wMm = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.wMf.Hl = this.wMm;
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
      this.wMn = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.wMf.b(this.wMn);
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
  
  public final void dzr()
  {
    AppMethodBeat.i(26815);
    ae.d("MicroMsg.FailSendMsgNotification", "setIsForeground:%b", new Object[] { Boolean.FALSE });
    this.cFc = false;
    AppMethodBeat.o(26815);
  }
  
  public final void dzs()
  {
    AppMethodBeat.i(26818);
    this.wMf.f(2, false);
    this.wMr = false;
    show();
    ae.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, unLockInNotificationBar");
    AppMethodBeat.o(26818);
  }
  
  public final void dzt()
  {
    AppMethodBeat.i(26819);
    this.wMs = true;
    this.wMf = com.tencent.mm.bq.a.bJ(this.mContext, com.tencent.mm.bq.a.fct());
    dzp();
    dzq();
    AppMethodBeat.o(26819);
  }
  
  @TargetApi(16)
  public final void show()
  {
    AppMethodBeat.i(26816);
    if (!this.mIsInit)
    {
      ae.e("MicroMsg.FailSendMsgNotification", "when show notification, is not init yet");
      AppMethodBeat.o(26816);
      return;
    }
    this.wMf.i(this.wMl);
    this.wMf.f(this.mContext.getText(2131755822));
    this.wMf.as(dzu());
    this.wMf.g(this.wMk);
    this.wMf.F(false);
    this.HN = this.wMf.build();
    if ((Build.VERSION.SDK_INT >= 16) && (!this.cFc))
    {
      this.HN.priority = 2;
      ae.d("MicroMsg.FailSendMsgNotification", "show notification, set priority to max");
    }
    ae.d("MicroMsg.FailSendMsgNotification", "show notification, mIsForeground:%b", new Object[] { Boolean.valueOf(this.cFc) });
    bc.getNotification().a(this.mType, this.HN, false);
    this.wMq = true;
    AppMethodBeat.o(26816);
  }
  
  public static abstract class FailSendMsgNotificationService
    extends Service
  {
    protected com.tencent.mm.sdk.b.c wMt = new com.tencent.mm.sdk.b.c() {};
    protected FailSendMsgNotification wMu = null;
    
    protected abstract int dzv();
    
    public IBinder onBind(Intent paramIntent)
    {
      return null;
    }
    
    public void onCreate()
    {
      super.onCreate();
      ae.d("MicroMsg.FailSendMsgNotification", "onCreate FailSendMsgNotificationService");
      com.tencent.mm.sdk.b.a.IvT.c(this.wMt);
    }
    
    public void onDestroy()
    {
      super.onDestroy();
      ae.d("MicroMsg.FailSendMsgNotification", "onDestroy FailSendMsgNotificationService");
      com.tencent.mm.sdk.b.a.IvT.d(this.wMt);
    }
    
    @TargetApi(16)
    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
    {
      ae.d("MicroMsg.FailSendMsgNotification", "onStartCommand");
      if ((paramIntent == null) || (paramIntent.getExtras() == null)) {
        ae.d("MicroMsg.FailSendMsgNotification", "handle action button, intent is null");
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
              if (bu.isNullOrNil(str))
              {
                ae.d("MicroMsg.FailSendMsgNotification", "handle action button, action is null");
                return 2;
              }
              paramInt1 = paramIntent.getExtras().getInt("notification_type", -1);
              ae.d("MicroMsg.FailSendMsgNotification", "handle action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
              if (f.MK(paramInt1) == null)
              {
                ae.d("MicroMsg.FailSendMsgNotification", "handle action button, notification not exist");
                return 2;
              }
              ae.d("MicroMsg.FailSendMsgNotification", "action:%s", new Object[] { str });
              this.wMu = f.MK(paramInt1);
              if (!str.startsWith("com.tencent.failnotification.omit")) {
                break;
              }
            } while (this.wMu.wMh == null);
            ae.d("MicroMsg.FailSendMsgNotification", "handle omit action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
            this.wMu.wMh.dzf();
            return 2;
            if (!str.startsWith("com.tencent.failnotificaiton.resend")) {
              break;
            }
          } while (this.wMu.wMh == null);
          boolean bool1;
          if (this.wMu.HN == null)
          {
            bool1 = true;
            if (this.wMu.wMf != null) {
              break label362;
            }
          }
          for (boolean bool2 = true;; bool2 = false)
          {
            ae.d("MicroMsg.FailSendMsgNotification", "handle resend action button, type:%d, notification==null:%b, notificationBuilder==null:%b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            if (this.wMu != null) {
              this.wMu.cFc = true;
            }
            if ((this.wMu.HN != null) && (Build.VERSION.SDK_INT >= 16)) {
              this.wMu.HN.priority = 0;
            }
            if (this.wMu.HN == null) {
              this.wMu.show();
            }
            startForeground(paramInt1, this.wMu.HN);
            this.wMu.wMh.dze();
            ae.d("MicroMsg.FailSendMsgNotification", "finish handle resend action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
            return 2;
            bool1 = false;
            break;
          }
          if (!str.startsWith("com.tencent.failnotification.click")) {
            break;
          }
        } while (this.wMu.wMi == null);
        ae.d("MicroMsg.FailSendMsgNotification", "handle click notification, type:%d", new Object[] { Integer.valueOf(paramInt1) });
        this.wMu.wMi.dzg();
        return 2;
      } while (!str.startsWith("com.tencent.failnotification.dismiss"));
      this.wMu.wMq = false;
      this.wMu.cFc = false;
      if (this.wMu.wMj != null)
      {
        ae.d("MicroMsg.FailSendMsgNotification", "handle notification dismiss");
        this.wMu.wMj.onDismiss();
      }
      stopSelf();
      return 2;
    }
  }
  
  public static class FailSendNormalMsgNotificationService
    extends FailSendMsgNotification.FailSendMsgNotificationService
  {
    protected final int dzv()
    {
      return 1;
    }
  }
  
  public static class FailSendSnsMsgNotificationService
    extends FailSendMsgNotification.FailSendMsgNotificationService
  {
    protected final int dzv()
    {
      return 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.ui.FailSendMsgNotification
 * JD-Core Version:    0.7.0.1
 */
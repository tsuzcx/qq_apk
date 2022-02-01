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
import com.tencent.mm.g.a.md;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

@SuppressLint({"InlinedApi"})
public final class FailSendMsgNotification
{
  Notification EY;
  boolean cwr;
  private Intent czv;
  public Context mContext;
  private boolean mIsInit;
  private int mType;
  public s.c uif;
  private int uig;
  public a uih;
  public b uii;
  public c uij;
  public String uik;
  public String uil;
  private PendingIntent uim;
  private PendingIntent uio;
  private PendingIntent uip;
  private PendingIntent uiq;
  public boolean uir;
  public boolean uis;
  public boolean uit;
  
  public FailSendMsgNotification()
  {
    this.EY = null;
    this.uif = null;
    this.czv = null;
    this.uig = 0;
    this.uih = null;
    this.uii = null;
    this.uij = null;
    this.uik = null;
    this.uil = null;
    this.uim = null;
    this.uio = null;
    this.uip = null;
    this.uiq = null;
    this.uir = false;
    this.uis = false;
    this.cwr = false;
    this.mIsInit = false;
    this.uit = true;
  }
  
  public FailSendMsgNotification(int paramInt)
  {
    AppMethodBeat.i(26811);
    this.EY = null;
    this.uif = null;
    this.czv = null;
    this.uig = 0;
    this.uih = null;
    this.uii = null;
    this.uij = null;
    this.uik = null;
    this.uil = null;
    this.uim = null;
    this.uio = null;
    this.uip = null;
    this.uiq = null;
    this.uir = false;
    this.uis = false;
    this.cwr = false;
    this.mIsInit = false;
    this.uit = true;
    this.mType = paramInt;
    this.mContext = aj.getContext();
    this.uif = com.tencent.mm.br.a.bD(this.mContext, com.tencent.mm.br.a.euy());
    this.uit = true;
    this.uil = "";
    try
    {
      if (this.uit) {
        cYa();
      }
      cYb();
      this.mIsInit = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.FailSendMsgNotification", "init FailSendMsgNotification error, e:%s", new Object[] { localException.getMessage() });
        this.mIsInit = false;
        continue;
        boolean bool = false;
      }
    }
    if (this.mContext == null)
    {
      bool = true;
      ad.d("MicroMsg.FailSendMsgNotification", "create FailSendMsgNotification, type:%d, context==null:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      this.uir = false;
      AppMethodBeat.o(26811);
      return;
    }
  }
  
  private void cYa()
  {
    AppMethodBeat.i(26812);
    this.uif.EN = true;
    Intent localIntent = new Intent();
    if (this.mType == 1)
    {
      localIntent.setAction("com.tencent.failnotification.omit_msg");
      localIntent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
      localIntent.putExtra("notification_type", this.mType);
      this.uip = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.uif.a(2131233504, this.mContext.getString(2131761683), this.uip);
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
      this.uiq = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.uif.a(2131233505, this.mContext.getString(2131761684), this.uiq);
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
  
  private static int cYf()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 2131233500;
    }
    return 2131233502;
  }
  
  public final void ajC(String paramString)
  {
    AppMethodBeat.i(26814);
    this.uik = paramString;
    show();
    AppMethodBeat.o(26814);
  }
  
  public final void cYb()
  {
    AppMethodBeat.i(26813);
    Intent localIntent = new Intent();
    if (this.mType == 1)
    {
      localIntent.setAction("com.tencent.failnotification.click_msg");
      localIntent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
      localIntent.putExtra("notification_type", this.mType);
      this.uim = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.uif.Ew = this.uim;
      localIntent = new Intent();
      if (this.mType != 1) {
        break label191;
      }
      localIntent.setAction("com.tencent.failnotification.dismiss_msg");
      localIntent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
    }
    for (;;)
    {
      localIntent.putExtra("notification_type", this.mType);
      this.uio = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.uif.b(this.uio);
      AppMethodBeat.o(26813);
      return;
      if (this.mType != 2) {
        break;
      }
      localIntent.setAction("com.tencent.failnotification.click_sns");
      localIntent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
      break;
      label191:
      if (this.mType == 2)
      {
        localIntent.setAction("com.tencent.failnotification.dismiss_sns");
        localIntent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
      }
    }
  }
  
  public final void cYc()
  {
    AppMethodBeat.i(26815);
    ad.d("MicroMsg.FailSendMsgNotification", "setIsForeground:%b", new Object[] { Boolean.FALSE });
    this.cwr = false;
    AppMethodBeat.o(26815);
  }
  
  public final void cYd()
  {
    AppMethodBeat.i(26818);
    this.uif.f(2, false);
    this.uis = false;
    show();
    ad.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, unLockInNotificationBar");
    AppMethodBeat.o(26818);
  }
  
  public final void cYe()
  {
    AppMethodBeat.i(26819);
    this.uit = true;
    this.uif = com.tencent.mm.br.a.bD(this.mContext, com.tencent.mm.br.a.euy());
    cYa();
    cYb();
    AppMethodBeat.o(26819);
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
      this.cwr = false;
      this.uir = false;
      AppMethodBeat.o(26817);
      return;
      if (this.mType == 2)
      {
        localIntent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        this.mContext.stopService(localIntent);
      }
    }
  }
  
  @TargetApi(16)
  public final void show()
  {
    AppMethodBeat.i(26816);
    if (!this.mIsInit)
    {
      ad.e("MicroMsg.FailSendMsgNotification", "when show notification, is not init yet");
      AppMethodBeat.o(26816);
      return;
    }
    this.uif.i(this.uil);
    this.uif.f(this.mContext.getText(2131755822));
    this.uif.as(cYf());
    this.uif.g(this.uik);
    this.uif.F(false);
    this.EY = this.uif.build();
    if ((Build.VERSION.SDK_INT >= 16) && (!this.cwr))
    {
      this.EY.priority = 2;
      ad.d("MicroMsg.FailSendMsgNotification", "show notification, set priority to max");
    }
    ad.d("MicroMsg.FailSendMsgNotification", "show notification, mIsForeground:%b", new Object[] { Boolean.valueOf(this.cwr) });
    az.getNotification().a(this.mType, this.EY, false);
    this.uir = true;
    AppMethodBeat.o(26816);
  }
  
  public static abstract class FailSendMsgNotificationService
    extends Service
  {
    protected com.tencent.mm.sdk.b.c uiu = new com.tencent.mm.sdk.b.c() {};
    protected FailSendMsgNotification uiv = null;
    
    protected abstract int cYg();
    
    public IBinder onBind(Intent paramIntent)
    {
      return null;
    }
    
    public void onCreate()
    {
      super.onCreate();
      ad.d("MicroMsg.FailSendMsgNotification", "onCreate FailSendMsgNotificationService");
      com.tencent.mm.sdk.b.a.ESL.c(this.uiu);
    }
    
    public void onDestroy()
    {
      super.onDestroy();
      ad.d("MicroMsg.FailSendMsgNotification", "onDestroy FailSendMsgNotificationService");
      com.tencent.mm.sdk.b.a.ESL.d(this.uiu);
    }
    
    @TargetApi(16)
    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
    {
      ad.d("MicroMsg.FailSendMsgNotification", "onStartCommand");
      if ((paramIntent == null) || (paramIntent.getExtras() == null)) {
        ad.d("MicroMsg.FailSendMsgNotification", "handle action button, intent is null");
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
              if (bt.isNullOrNil(str))
              {
                ad.d("MicroMsg.FailSendMsgNotification", "handle action button, action is null");
                return 2;
              }
              paramInt1 = paramIntent.getExtras().getInt("notification_type", -1);
              ad.d("MicroMsg.FailSendMsgNotification", "handle action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
              if (f.IE(paramInt1) == null)
              {
                ad.d("MicroMsg.FailSendMsgNotification", "handle action button, notification not exist");
                return 2;
              }
              ad.d("MicroMsg.FailSendMsgNotification", "action:%s", new Object[] { str });
              this.uiv = f.IE(paramInt1);
              if (!str.startsWith("com.tencent.failnotification.omit")) {
                break;
              }
            } while (this.uiv.uih == null);
            ad.d("MicroMsg.FailSendMsgNotification", "handle omit action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
            this.uiv.uih.cXR();
            return 2;
            if (!str.startsWith("com.tencent.failnotificaiton.resend")) {
              break;
            }
          } while (this.uiv.uih == null);
          boolean bool1;
          if (this.uiv.EY == null)
          {
            bool1 = true;
            if (this.uiv.uif != null) {
              break label362;
            }
          }
          for (boolean bool2 = true;; bool2 = false)
          {
            ad.d("MicroMsg.FailSendMsgNotification", "handle resend action button, type:%d, notification==null:%b, notificationBuilder==null:%b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            if (this.uiv != null) {
              this.uiv.cwr = true;
            }
            if ((this.uiv.EY != null) && (Build.VERSION.SDK_INT >= 16)) {
              this.uiv.EY.priority = 0;
            }
            if (this.uiv.EY == null) {
              this.uiv.show();
            }
            startForeground(paramInt1, this.uiv.EY);
            this.uiv.uih.cXQ();
            ad.d("MicroMsg.FailSendMsgNotification", "finish handle resend action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
            return 2;
            bool1 = false;
            break;
          }
          if (!str.startsWith("com.tencent.failnotification.click")) {
            break;
          }
        } while (this.uiv.uii == null);
        ad.d("MicroMsg.FailSendMsgNotification", "handle click notification, type:%d", new Object[] { Integer.valueOf(paramInt1) });
        this.uiv.uii.cXS();
        return 2;
      } while (!str.startsWith("com.tencent.failnotification.dismiss"));
      this.uiv.uir = false;
      this.uiv.cwr = false;
      if (this.uiv.uij != null)
      {
        ad.d("MicroMsg.FailSendMsgNotification", "handle notification dismiss");
        this.uiv.uij.onDismiss();
      }
      stopSelf();
      return 2;
    }
  }
  
  public static class FailSendNormalMsgNotificationService
    extends FailSendMsgNotification.FailSendMsgNotificationService
  {
    protected final int cYg()
    {
      return 1;
    }
  }
  
  public static class FailSendSnsMsgNotificationService
    extends FailSendMsgNotification.FailSendMsgNotificationService
  {
    protected final int cYg()
    {
      return 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.ui.FailSendMsgNotification
 * JD-Core Version:    0.7.0.1
 */
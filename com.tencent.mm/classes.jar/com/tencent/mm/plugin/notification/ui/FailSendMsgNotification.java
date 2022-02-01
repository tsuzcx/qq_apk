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
import com.tencent.mm.g.a.mv;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

@SuppressLint({"InlinedApi"})
public final class FailSendMsgNotification
{
  Notification HN;
  boolean cEv;
  private Intent cHz;
  public Context mContext;
  private boolean mIsInit;
  private int mType;
  public String wwA;
  private PendingIntent wwB;
  private PendingIntent wwC;
  private PendingIntent wwD;
  private PendingIntent wwE;
  public boolean wwF;
  public boolean wwG;
  public boolean wwH;
  public s.c wwu;
  private int wwv;
  public a www;
  public b wwx;
  public c wwy;
  public String wwz;
  
  public FailSendMsgNotification()
  {
    this.HN = null;
    this.wwu = null;
    this.cHz = null;
    this.wwv = 0;
    this.www = null;
    this.wwx = null;
    this.wwy = null;
    this.wwz = null;
    this.wwA = null;
    this.wwB = null;
    this.wwC = null;
    this.wwD = null;
    this.wwE = null;
    this.wwF = false;
    this.wwG = false;
    this.cEv = false;
    this.mIsInit = false;
    this.wwH = true;
  }
  
  public FailSendMsgNotification(int paramInt)
  {
    AppMethodBeat.i(26811);
    this.HN = null;
    this.wwu = null;
    this.cHz = null;
    this.wwv = 0;
    this.www = null;
    this.wwx = null;
    this.wwy = null;
    this.wwz = null;
    this.wwA = null;
    this.wwB = null;
    this.wwC = null;
    this.wwD = null;
    this.wwE = null;
    this.wwF = false;
    this.wwG = false;
    this.cEv = false;
    this.mIsInit = false;
    this.wwH = true;
    this.mType = paramInt;
    this.mContext = aj.getContext();
    this.wwu = com.tencent.mm.br.a.bI(this.mContext, com.tencent.mm.br.a.eYF());
    this.wwH = true;
    this.wwA = "";
    try
    {
      if (this.wwH) {
        dvZ();
      }
      dwa();
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
      this.wwF = false;
      AppMethodBeat.o(26811);
      return;
    }
  }
  
  private void dvZ()
  {
    AppMethodBeat.i(26812);
    this.wwu.HC = true;
    Intent localIntent = new Intent();
    if (this.mType == 1)
    {
      localIntent.setAction("com.tencent.failnotification.omit_msg");
      localIntent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
      localIntent.putExtra("notification_type", this.mType);
      this.wwD = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.wwu.a(2131233504, this.mContext.getString(2131761683), this.wwD);
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
      this.wwE = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.wwu.a(2131233505, this.mContext.getString(2131761684), this.wwE);
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
  
  private static int dwe()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 2131233500;
    }
    return 2131233502;
  }
  
  public final void atA(String paramString)
  {
    AppMethodBeat.i(26814);
    this.wwz = paramString;
    show();
    AppMethodBeat.o(26814);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(26817);
    ba.getNotification().cancel(this.mType);
    Intent localIntent = new Intent();
    if (this.mType == 1)
    {
      localIntent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
      this.mContext.stopService(localIntent);
    }
    for (;;)
    {
      this.cEv = false;
      this.wwF = false;
      AppMethodBeat.o(26817);
      return;
      if (this.mType == 2)
      {
        localIntent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        this.mContext.stopService(localIntent);
      }
    }
  }
  
  public final void dwa()
  {
    AppMethodBeat.i(26813);
    Intent localIntent = new Intent();
    if (this.mType == 1)
    {
      localIntent.setAction("com.tencent.failnotification.click_msg");
      localIntent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
      localIntent.putExtra("notification_type", this.mType);
      this.wwB = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.wwu.Hl = this.wwB;
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
      this.wwC = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.wwu.b(this.wwC);
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
  
  public final void dwb()
  {
    AppMethodBeat.i(26815);
    ad.d("MicroMsg.FailSendMsgNotification", "setIsForeground:%b", new Object[] { Boolean.FALSE });
    this.cEv = false;
    AppMethodBeat.o(26815);
  }
  
  public final void dwc()
  {
    AppMethodBeat.i(26818);
    this.wwu.f(2, false);
    this.wwG = false;
    show();
    ad.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, unLockInNotificationBar");
    AppMethodBeat.o(26818);
  }
  
  public final void dwd()
  {
    AppMethodBeat.i(26819);
    this.wwH = true;
    this.wwu = com.tencent.mm.br.a.bI(this.mContext, com.tencent.mm.br.a.eYF());
    dvZ();
    dwa();
    AppMethodBeat.o(26819);
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
    this.wwu.i(this.wwA);
    this.wwu.f(this.mContext.getText(2131755822));
    this.wwu.as(dwe());
    this.wwu.g(this.wwz);
    this.wwu.F(false);
    this.HN = this.wwu.build();
    if ((Build.VERSION.SDK_INT >= 16) && (!this.cEv))
    {
      this.HN.priority = 2;
      ad.d("MicroMsg.FailSendMsgNotification", "show notification, set priority to max");
    }
    ad.d("MicroMsg.FailSendMsgNotification", "show notification, mIsForeground:%b", new Object[] { Boolean.valueOf(this.cEv) });
    ba.getNotification().a(this.mType, this.HN, false);
    this.wwF = true;
    AppMethodBeat.o(26816);
  }
  
  public static abstract class FailSendMsgNotificationService
    extends Service
  {
    protected com.tencent.mm.sdk.b.c wwI = new com.tencent.mm.sdk.b.c() {};
    protected FailSendMsgNotification wwJ = null;
    
    protected abstract int dwf();
    
    public IBinder onBind(Intent paramIntent)
    {
      return null;
    }
    
    public void onCreate()
    {
      super.onCreate();
      ad.d("MicroMsg.FailSendMsgNotification", "onCreate FailSendMsgNotificationService");
      com.tencent.mm.sdk.b.a.IbL.c(this.wwI);
    }
    
    public void onDestroy()
    {
      super.onDestroy();
      ad.d("MicroMsg.FailSendMsgNotification", "onDestroy FailSendMsgNotificationService");
      com.tencent.mm.sdk.b.a.IbL.d(this.wwI);
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
              if (f.Mf(paramInt1) == null)
              {
                ad.d("MicroMsg.FailSendMsgNotification", "handle action button, notification not exist");
                return 2;
              }
              ad.d("MicroMsg.FailSendMsgNotification", "action:%s", new Object[] { str });
              this.wwJ = f.Mf(paramInt1);
              if (!str.startsWith("com.tencent.failnotification.omit")) {
                break;
              }
            } while (this.wwJ.www == null);
            ad.d("MicroMsg.FailSendMsgNotification", "handle omit action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
            this.wwJ.www.dvQ();
            return 2;
            if (!str.startsWith("com.tencent.failnotificaiton.resend")) {
              break;
            }
          } while (this.wwJ.www == null);
          boolean bool1;
          if (this.wwJ.HN == null)
          {
            bool1 = true;
            if (this.wwJ.wwu != null) {
              break label362;
            }
          }
          for (boolean bool2 = true;; bool2 = false)
          {
            ad.d("MicroMsg.FailSendMsgNotification", "handle resend action button, type:%d, notification==null:%b, notificationBuilder==null:%b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            if (this.wwJ != null) {
              this.wwJ.cEv = true;
            }
            if ((this.wwJ.HN != null) && (Build.VERSION.SDK_INT >= 16)) {
              this.wwJ.HN.priority = 0;
            }
            if (this.wwJ.HN == null) {
              this.wwJ.show();
            }
            startForeground(paramInt1, this.wwJ.HN);
            this.wwJ.www.dvP();
            ad.d("MicroMsg.FailSendMsgNotification", "finish handle resend action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
            return 2;
            bool1 = false;
            break;
          }
          if (!str.startsWith("com.tencent.failnotification.click")) {
            break;
          }
        } while (this.wwJ.wwx == null);
        ad.d("MicroMsg.FailSendMsgNotification", "handle click notification, type:%d", new Object[] { Integer.valueOf(paramInt1) });
        this.wwJ.wwx.dvR();
        return 2;
      } while (!str.startsWith("com.tencent.failnotification.dismiss"));
      this.wwJ.wwF = false;
      this.wwJ.cEv = false;
      if (this.wwJ.wwy != null)
      {
        ad.d("MicroMsg.FailSendMsgNotification", "handle notification dismiss");
        this.wwJ.wwy.onDismiss();
      }
      stopSelf();
      return 2;
    }
  }
  
  public static class FailSendNormalMsgNotificationService
    extends FailSendMsgNotification.FailSendMsgNotificationService
  {
    protected final int dwf()
    {
      return 1;
    }
  }
  
  public static class FailSendSnsMsgNotificationService
    extends FailSendMsgNotification.FailSendMsgNotificationService
  {
    protected final int dwf()
    {
      return 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.ui.FailSendMsgNotification
 * JD-Core Version:    0.7.0.1
 */
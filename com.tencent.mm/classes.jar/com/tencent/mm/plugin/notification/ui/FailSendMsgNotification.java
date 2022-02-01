package com.tencent.mm.plugin.notification.ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.f.d;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.ps;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class FailSendMsgNotification
{
  public String Bmi;
  public f.d Mxa;
  private Intent Mxb;
  private int Mxc;
  public a Mxd;
  public b Mxe;
  public c Mxf;
  public String Mxg;
  private PendingIntent Mxh;
  private PendingIntent Mxi;
  private PendingIntent Mxj;
  private PendingIntent Mxk;
  public boolean Mxl;
  public boolean Mxm;
  public boolean Mxn;
  Notification boX;
  public Context mContext;
  boolean mIsForeground;
  private boolean mIsInit;
  private int mType;
  
  public FailSendMsgNotification()
  {
    this.boX = null;
    this.Mxa = null;
    this.Mxb = null;
    this.Mxc = 0;
    this.Mxd = null;
    this.Mxe = null;
    this.Mxf = null;
    this.Bmi = null;
    this.Mxg = null;
    this.Mxh = null;
    this.Mxi = null;
    this.Mxj = null;
    this.Mxk = null;
    this.Mxl = false;
    this.Mxm = false;
    this.mIsForeground = false;
    this.mIsInit = false;
    this.Mxn = true;
  }
  
  public FailSendMsgNotification(int paramInt)
  {
    AppMethodBeat.i(26811);
    this.boX = null;
    this.Mxa = null;
    this.Mxb = null;
    this.Mxc = 0;
    this.Mxd = null;
    this.Mxe = null;
    this.Mxf = null;
    this.Bmi = null;
    this.Mxg = null;
    this.Mxh = null;
    this.Mxi = null;
    this.Mxj = null;
    this.Mxk = null;
    this.Mxl = false;
    this.Mxm = false;
    this.mIsForeground = false;
    this.mIsInit = false;
    this.Mxn = true;
    this.mType = paramInt;
    this.mContext = MMApplicationContext.getContext();
    this.Mxa = com.tencent.mm.bq.a.cA(this.mContext, com.tencent.mm.bq.a.iGp());
    this.Mxn = true;
    this.Mxg = "";
    try
    {
      if (this.Mxn) {
        guS();
      }
      guT();
      this.mIsInit = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.FailSendMsgNotification", "init FailSendMsgNotification error, e:%s", new Object[] { localException.getMessage() });
        this.mIsInit = false;
        continue;
        boolean bool = false;
      }
    }
    if (this.mContext == null)
    {
      bool = true;
      Log.d("MicroMsg.FailSendMsgNotification", "create FailSendMsgNotification, type:%d, context==null:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      this.Mxl = false;
      AppMethodBeat.o(26811);
      return;
    }
  }
  
  private void guS()
  {
    AppMethodBeat.i(26812);
    this.Mxa.boJ = true;
    Intent localIntent = new Intent();
    if (this.mType == 1)
    {
      localIntent.setAction("com.tencent.failnotification.omit_msg");
      localIntent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
      localIntent.putExtra("notification_type", this.mType);
      this.Mxj = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.Mxa.a(R.g.notification_message_ignore_icon, this.mContext.getString(R.l.gPC), this.Mxj);
      localIntent = new Intent();
      if (this.mType != 1) {
        break label241;
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
      this.Mxk = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.Mxa.a(R.g.notification_message_resend_icon, this.mContext.getString(R.l.gPD), this.Mxk);
      AppMethodBeat.o(26812);
      return;
      if (this.mType != 2) {
        break;
      }
      localIntent.setAction("com.tencent.failnotification.omit_sns");
      localIntent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
      break;
      label241:
      if (this.mType == 2)
      {
        localIntent.setAction("com.tencent.failnotificaiton.resend_sns");
        localIntent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
      }
    }
  }
  
  private static int guX()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return R.g.notification_icon;
    }
    return R.g.notification_icon_gray;
  }
  
  public final void aQy(String paramString)
  {
    AppMethodBeat.i(26814);
    this.Bmi = paramString;
    show();
    AppMethodBeat.o(26814);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(26817);
    bh.getNotification().cancel(this.mType);
    Intent localIntent = new Intent();
    if (this.mType == 1)
    {
      localIntent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
      this.mContext.stopService(localIntent);
    }
    for (;;)
    {
      this.mIsForeground = false;
      this.Mxl = false;
      AppMethodBeat.o(26817);
      return;
      if (this.mType == 2)
      {
        localIntent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        this.mContext.stopService(localIntent);
      }
    }
  }
  
  public final void guT()
  {
    AppMethodBeat.i(26813);
    Intent localIntent = new Intent();
    if (this.mType == 1)
    {
      localIntent.setAction("com.tencent.failnotification.click_msg");
      localIntent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
      localIntent.putExtra("notification_type", this.mType);
      this.Mxh = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.Mxa.bor = this.Mxh;
      localIntent = new Intent();
      if (this.mType != 1) {
        break label194;
      }
      localIntent.setAction("com.tencent.failnotification.dismiss_msg");
      localIntent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
    }
    for (;;)
    {
      localIntent.putExtra("notification_type", this.mType);
      this.Mxi = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.Mxa.b(this.Mxi);
      AppMethodBeat.o(26813);
      return;
      if (this.mType != 2) {
        break;
      }
      localIntent.setAction("com.tencent.failnotification.click_sns");
      localIntent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
      break;
      label194:
      if (this.mType == 2)
      {
        localIntent.setAction("com.tencent.failnotification.dismiss_sns");
        localIntent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
      }
    }
  }
  
  public final void guU()
  {
    AppMethodBeat.i(26815);
    Log.d("MicroMsg.FailSendMsgNotification", "setIsForeground:%b", new Object[] { Boolean.FALSE });
    this.mIsForeground = false;
    AppMethodBeat.o(26815);
  }
  
  public final void guV()
  {
    AppMethodBeat.i(26818);
    this.Mxa.q(2, false);
    this.Mxm = false;
    show();
    Log.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, unLockInNotificationBar");
    AppMethodBeat.o(26818);
  }
  
  public final void guW()
  {
    AppMethodBeat.i(26819);
    this.Mxn = true;
    this.Mxa = com.tencent.mm.bq.a.cA(this.mContext, com.tencent.mm.bq.a.iGp());
    guS();
    guT();
    AppMethodBeat.o(26819);
  }
  
  public final void show()
  {
    AppMethodBeat.i(26816);
    if (!this.mIsInit)
    {
      Log.e("MicroMsg.FailSendMsgNotification", "when show notification, is not init yet");
      AppMethodBeat.o(26816);
      return;
    }
    this.Mxa.o(this.Mxg);
    this.Mxa.l(this.mContext.getText(R.l.app_name));
    this.Mxa.eb(guX());
    this.Mxa.m(this.Bmi);
    this.Mxa.aC(false);
    this.boX = this.Mxa.DA();
    if ((Build.VERSION.SDK_INT >= 16) && (!this.mIsForeground))
    {
      this.boX.priority = 2;
      Log.d("MicroMsg.FailSendMsgNotification", "show notification, set priority to max");
    }
    Log.d("MicroMsg.FailSendMsgNotification", "show notification, mIsForeground:%b", new Object[] { Boolean.valueOf(this.mIsForeground) });
    bh.getNotification().a(this.mType, this.boX, false);
    this.Mxl = true;
    AppMethodBeat.o(26816);
  }
  
  public static abstract class FailSendMsgNotificationService
    extends Service
  {
    protected IListener Mxo = new IListener(com.tencent.mm.app.f.hfK) {};
    protected FailSendMsgNotification Mxp = null;
    
    protected abstract int guY();
    
    public IBinder onBind(Intent paramIntent)
    {
      return null;
    }
    
    public void onCreate()
    {
      super.onCreate();
      Log.d("MicroMsg.FailSendMsgNotification", "onCreate FailSendMsgNotificationService");
      this.Mxo.alive();
    }
    
    public void onDestroy()
    {
      super.onDestroy();
      Log.d("MicroMsg.FailSendMsgNotification", "onDestroy FailSendMsgNotificationService");
      this.Mxo.dead();
    }
    
    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
    {
      Log.d("MicroMsg.FailSendMsgNotification", "onStartCommand");
      if ((paramIntent == null) || (paramIntent.getExtras() == null)) {
        Log.d("MicroMsg.FailSendMsgNotification", "handle action button, intent is null");
      }
      String str;
      label350:
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
              if (Util.isNullOrNil(str))
              {
                Log.d("MicroMsg.FailSendMsgNotification", "handle action button, action is null");
                return 2;
              }
              paramInt1 = paramIntent.getExtras().getInt("notification_type", -1);
              Log.d("MicroMsg.FailSendMsgNotification", "handle action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
              if (com.tencent.mm.plugin.notification.model.f.afa(paramInt1) == null)
              {
                Log.d("MicroMsg.FailSendMsgNotification", "handle action button, notification not exist");
                return 2;
              }
              Log.d("MicroMsg.FailSendMsgNotification", "action:%s", new Object[] { str });
              this.Mxp = com.tencent.mm.plugin.notification.model.f.afa(paramInt1);
              if (!str.startsWith("com.tencent.failnotification.omit")) {
                break;
              }
            } while (this.Mxp.Mxd == null);
            Log.d("MicroMsg.FailSendMsgNotification", "handle omit action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
            this.Mxp.Mxd.guI();
            return 2;
            if (!str.startsWith("com.tencent.failnotificaiton.resend")) {
              break;
            }
          } while (this.Mxp.Mxd == null);
          boolean bool1;
          if (this.Mxp.boX == null)
          {
            bool1 = true;
            if (this.Mxp.Mxa != null) {
              break label350;
            }
          }
          for (boolean bool2 = true;; bool2 = false)
          {
            Log.d("MicroMsg.FailSendMsgNotification", "handle resend action button, type:%d, notification==null:%b, notificationBuilder==null:%b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            if (this.Mxp != null) {
              this.Mxp.mIsForeground = true;
            }
            if ((this.Mxp.boX != null) && (Build.VERSION.SDK_INT >= 16)) {
              this.Mxp.boX.priority = 0;
            }
            if (this.Mxp.boX == null) {
              this.Mxp.show();
            }
            this.Mxp.Mxd.guH();
            Log.d("MicroMsg.FailSendMsgNotification", "finish handle resend action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
            return 2;
            bool1 = false;
            break;
          }
          if (!str.startsWith("com.tencent.failnotification.click")) {
            break;
          }
        } while (this.Mxp.Mxe == null);
        Log.d("MicroMsg.FailSendMsgNotification", "handle click notification, type:%d", new Object[] { Integer.valueOf(paramInt1) });
        this.Mxp.Mxe.guJ();
        return 2;
      } while (!str.startsWith("com.tencent.failnotification.dismiss"));
      this.Mxp.Mxl = false;
      this.Mxp.mIsForeground = false;
      if (this.Mxp.Mxf != null)
      {
        Log.d("MicroMsg.FailSendMsgNotification", "handle notification dismiss");
        this.Mxp.Mxf.onDismiss();
      }
      stopSelf();
      return 2;
    }
  }
  
  public static class FailSendNormalMsgNotificationService
    extends FailSendMsgNotification.FailSendMsgNotificationService
  {
    protected final int guY()
    {
      return 1;
    }
  }
  
  public static class FailSendSnsMsgNotificationService
    extends FailSendMsgNotification.FailSendMsgNotificationService
  {
    protected final int guY()
    {
      return 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.ui.FailSendMsgNotification
 * JD-Core Version:    0.7.0.1
 */
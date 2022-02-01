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
import com.tencent.mm.g.a.nn;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

@SuppressLint({"InlinedApi"})
public final class FailSendMsgNotification
{
  public s.c AHH;
  private int AHI;
  public a AHJ;
  public b AHK;
  public c AHL;
  public String AHM;
  public String AHN;
  private PendingIntent AHO;
  private PendingIntent AHP;
  private PendingIntent AHQ;
  private PendingIntent AHR;
  public boolean AHS;
  public boolean AHT;
  public boolean AHU;
  Notification HX;
  private Intent cYF;
  public Context mContext;
  boolean mIsForeground;
  private boolean mIsInit;
  private int mType;
  
  public FailSendMsgNotification()
  {
    this.HX = null;
    this.AHH = null;
    this.cYF = null;
    this.AHI = 0;
    this.AHJ = null;
    this.AHK = null;
    this.AHL = null;
    this.AHM = null;
    this.AHN = null;
    this.AHO = null;
    this.AHP = null;
    this.AHQ = null;
    this.AHR = null;
    this.AHS = false;
    this.AHT = false;
    this.mIsForeground = false;
    this.mIsInit = false;
    this.AHU = true;
  }
  
  public FailSendMsgNotification(int paramInt)
  {
    AppMethodBeat.i(26811);
    this.HX = null;
    this.AHH = null;
    this.cYF = null;
    this.AHI = 0;
    this.AHJ = null;
    this.AHK = null;
    this.AHL = null;
    this.AHM = null;
    this.AHN = null;
    this.AHO = null;
    this.AHP = null;
    this.AHQ = null;
    this.AHR = null;
    this.AHS = false;
    this.AHT = false;
    this.mIsForeground = false;
    this.mIsInit = false;
    this.AHU = true;
    this.mType = paramInt;
    this.mContext = MMApplicationContext.getContext();
    this.AHH = com.tencent.mm.bq.a.cd(this.mContext, com.tencent.mm.bq.a.glE());
    this.AHU = true;
    this.AHN = "";
    try
    {
      if (this.AHU) {
        eyW();
      }
      eyX();
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
      this.AHS = false;
      AppMethodBeat.o(26811);
      return;
    }
  }
  
  private void eyW()
  {
    AppMethodBeat.i(26812);
    this.AHH.HM = true;
    Intent localIntent = new Intent();
    if (this.mType == 1)
    {
      localIntent.setAction("com.tencent.failnotification.omit_msg");
      localIntent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
      localIntent.putExtra("notification_type", this.mType);
      this.AHQ = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.AHH.a(2131234307, this.mContext.getString(2131763651), this.AHQ);
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
      this.AHR = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.AHH.a(2131234308, this.mContext.getString(2131763652), this.AHR);
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
  
  private static int ezb()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 2131234303;
    }
    return 2131234305;
  }
  
  public final void aJb(String paramString)
  {
    AppMethodBeat.i(26814);
    this.AHM = paramString;
    show();
    AppMethodBeat.o(26814);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(26817);
    bg.getNotification().cancel(this.mType);
    Intent localIntent = new Intent();
    if (this.mType == 1)
    {
      localIntent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
      this.mContext.stopService(localIntent);
    }
    for (;;)
    {
      this.mIsForeground = false;
      this.AHS = false;
      AppMethodBeat.o(26817);
      return;
      if (this.mType == 2)
      {
        localIntent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        this.mContext.stopService(localIntent);
      }
    }
  }
  
  public final void eyX()
  {
    AppMethodBeat.i(26813);
    Intent localIntent = new Intent();
    if (this.mType == 1)
    {
      localIntent.setAction("com.tencent.failnotification.click_msg");
      localIntent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
      localIntent.putExtra("notification_type", this.mType);
      this.AHO = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.AHH.Hv = this.AHO;
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
      this.AHP = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.AHH.b(this.AHP);
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
  
  public final void eyY()
  {
    AppMethodBeat.i(26815);
    Log.d("MicroMsg.FailSendMsgNotification", "setIsForeground:%b", new Object[] { Boolean.FALSE });
    this.mIsForeground = false;
    AppMethodBeat.o(26815);
  }
  
  public final void eyZ()
  {
    AppMethodBeat.i(26818);
    this.AHH.g(2, false);
    this.AHT = false;
    show();
    Log.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, unLockInNotificationBar");
    AppMethodBeat.o(26818);
  }
  
  public final void eza()
  {
    AppMethodBeat.i(26819);
    this.AHU = true;
    this.AHH = com.tencent.mm.bq.a.cd(this.mContext, com.tencent.mm.bq.a.glE());
    eyW();
    eyX();
    AppMethodBeat.o(26819);
  }
  
  @TargetApi(16)
  public final void show()
  {
    AppMethodBeat.i(26816);
    if (!this.mIsInit)
    {
      Log.e("MicroMsg.FailSendMsgNotification", "when show notification, is not init yet");
      AppMethodBeat.o(26816);
      return;
    }
    this.AHH.i(this.AHN);
    this.AHH.f(this.mContext.getText(2131755908));
    this.AHH.as(ezb());
    this.AHH.g(this.AHM);
    this.AHH.E(false);
    this.HX = this.AHH.build();
    if ((Build.VERSION.SDK_INT >= 16) && (!this.mIsForeground))
    {
      this.HX.priority = 2;
      Log.d("MicroMsg.FailSendMsgNotification", "show notification, set priority to max");
    }
    Log.d("MicroMsg.FailSendMsgNotification", "show notification, mIsForeground:%b", new Object[] { Boolean.valueOf(this.mIsForeground) });
    bg.getNotification().a(this.mType, this.HX, false);
    this.AHS = true;
    AppMethodBeat.o(26816);
  }
  
  public static abstract class FailSendMsgNotificationService
    extends Service
  {
    protected IListener AHV = new IListener() {};
    protected FailSendMsgNotification AHW = null;
    
    protected abstract int ezc();
    
    public IBinder onBind(Intent paramIntent)
    {
      return null;
    }
    
    public void onCreate()
    {
      super.onCreate();
      Log.d("MicroMsg.FailSendMsgNotification", "onCreate FailSendMsgNotificationService");
      EventCenter.instance.addListener(this.AHV);
    }
    
    public void onDestroy()
    {
      super.onDestroy();
      Log.d("MicroMsg.FailSendMsgNotification", "onDestroy FailSendMsgNotificationService");
      EventCenter.instance.removeListener(this.AHV);
    }
    
    @TargetApi(16)
    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
    {
      Log.d("MicroMsg.FailSendMsgNotification", "onStartCommand");
      if ((paramIntent == null) || (paramIntent.getExtras() == null)) {
        Log.d("MicroMsg.FailSendMsgNotification", "handle action button, intent is null");
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
              if (Util.isNullOrNil(str))
              {
                Log.d("MicroMsg.FailSendMsgNotification", "handle action button, action is null");
                return 2;
              }
              paramInt1 = paramIntent.getExtras().getInt("notification_type", -1);
              Log.d("MicroMsg.FailSendMsgNotification", "handle action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
              if (f.TU(paramInt1) == null)
              {
                Log.d("MicroMsg.FailSendMsgNotification", "handle action button, notification not exist");
                return 2;
              }
              Log.d("MicroMsg.FailSendMsgNotification", "action:%s", new Object[] { str });
              this.AHW = f.TU(paramInt1);
              if (!str.startsWith("com.tencent.failnotification.omit")) {
                break;
              }
            } while (this.AHW.AHJ == null);
            Log.d("MicroMsg.FailSendMsgNotification", "handle omit action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
            this.AHW.AHJ.eyM();
            return 2;
            if (!str.startsWith("com.tencent.failnotificaiton.resend")) {
              break;
            }
          } while (this.AHW.AHJ == null);
          boolean bool1;
          if (this.AHW.HX == null)
          {
            bool1 = true;
            if (this.AHW.AHH != null) {
              break label362;
            }
          }
          for (boolean bool2 = true;; bool2 = false)
          {
            Log.d("MicroMsg.FailSendMsgNotification", "handle resend action button, type:%d, notification==null:%b, notificationBuilder==null:%b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            if (this.AHW != null) {
              this.AHW.mIsForeground = true;
            }
            if ((this.AHW.HX != null) && (Build.VERSION.SDK_INT >= 16)) {
              this.AHW.HX.priority = 0;
            }
            if (this.AHW.HX == null) {
              this.AHW.show();
            }
            startForeground(paramInt1, this.AHW.HX);
            this.AHW.AHJ.eyL();
            Log.d("MicroMsg.FailSendMsgNotification", "finish handle resend action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
            return 2;
            bool1 = false;
            break;
          }
          if (!str.startsWith("com.tencent.failnotification.click")) {
            break;
          }
        } while (this.AHW.AHK == null);
        Log.d("MicroMsg.FailSendMsgNotification", "handle click notification, type:%d", new Object[] { Integer.valueOf(paramInt1) });
        this.AHW.AHK.eyN();
        return 2;
      } while (!str.startsWith("com.tencent.failnotification.dismiss"));
      this.AHW.AHS = false;
      this.AHW.mIsForeground = false;
      if (this.AHW.AHL != null)
      {
        Log.d("MicroMsg.FailSendMsgNotification", "handle notification dismiss");
        this.AHW.AHL.onDismiss();
      }
      stopSelf();
      return 2;
    }
  }
  
  public static class FailSendNormalMsgNotificationService
    extends FailSendMsgNotification.FailSendMsgNotificationService
  {
    protected final int ezc()
    {
      return 1;
    }
  }
  
  public static class FailSendSnsMsgNotificationService
    extends FailSendMsgNotification.FailSendMsgNotificationService
  {
    protected final int ezc()
    {
      return 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.ui.FailSendMsgNotification
 * JD-Core Version:    0.7.0.1
 */
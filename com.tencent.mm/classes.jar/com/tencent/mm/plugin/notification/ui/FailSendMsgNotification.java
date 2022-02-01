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
import androidx.core.app.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.oj;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

@SuppressLint({"InlinedApi"})
public final class FailSendMsgNotification
{
  public e.d GAQ;
  private Intent GAR;
  private int GAS;
  public a GAT;
  public b GAU;
  public c GAV;
  public String GAW;
  public String GAX;
  private PendingIntent GAY;
  private PendingIntent GAZ;
  private PendingIntent GBa;
  private PendingIntent GBb;
  public boolean GBc;
  public boolean GBd;
  public boolean GBe;
  Notification IV;
  public Context mContext;
  boolean mIsForeground;
  private boolean mIsInit;
  private int mType;
  
  public FailSendMsgNotification()
  {
    this.IV = null;
    this.GAQ = null;
    this.GAR = null;
    this.GAS = 0;
    this.GAT = null;
    this.GAU = null;
    this.GAV = null;
    this.GAW = null;
    this.GAX = null;
    this.GAY = null;
    this.GAZ = null;
    this.GBa = null;
    this.GBb = null;
    this.GBc = false;
    this.GBd = false;
    this.mIsForeground = false;
    this.mIsInit = false;
    this.GBe = true;
  }
  
  public FailSendMsgNotification(int paramInt)
  {
    AppMethodBeat.i(26811);
    this.IV = null;
    this.GAQ = null;
    this.GAR = null;
    this.GAS = 0;
    this.GAT = null;
    this.GAU = null;
    this.GAV = null;
    this.GAW = null;
    this.GAX = null;
    this.GAY = null;
    this.GAZ = null;
    this.GBa = null;
    this.GBb = null;
    this.GBc = false;
    this.GBd = false;
    this.mIsForeground = false;
    this.mIsInit = false;
    this.GBe = true;
    this.mType = paramInt;
    this.mContext = MMApplicationContext.getContext();
    this.GAQ = com.tencent.mm.bx.a.cp(this.mContext, com.tencent.mm.bx.a.hfv());
    this.GBe = true;
    this.GAX = "";
    try
    {
      if (this.GBe) {
        fkB();
      }
      fkC();
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
      this.GBc = false;
      AppMethodBeat.o(26811);
      return;
    }
  }
  
  private void fkB()
  {
    AppMethodBeat.i(26812);
    this.GAQ.IH = true;
    Intent localIntent = new Intent();
    if (this.mType == 1)
    {
      localIntent.setAction("com.tencent.failnotification.omit_msg");
      localIntent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
      localIntent.putExtra("notification_type", this.mType);
      this.GBa = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.GAQ.a(R.g.notification_message_ignore_icon, this.mContext.getString(R.l.eNp), this.GBa);
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
      this.GBb = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.GAQ.a(R.g.notification_message_resend_icon, this.mContext.getString(R.l.eNq), this.GBb);
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
  
  private static int fkG()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return R.g.notification_icon;
    }
    return R.g.notification_icon_gray;
  }
  
  public final void aTx(String paramString)
  {
    AppMethodBeat.i(26814);
    this.GAW = paramString;
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
      this.GBc = false;
      AppMethodBeat.o(26817);
      return;
      if (this.mType == 2)
      {
        localIntent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        this.mContext.stopService(localIntent);
      }
    }
  }
  
  public final void fkC()
  {
    AppMethodBeat.i(26813);
    Intent localIntent = new Intent();
    if (this.mType == 1)
    {
      localIntent.setAction("com.tencent.failnotification.click_msg");
      localIntent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
      localIntent.putExtra("notification_type", this.mType);
      this.GAY = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.GAQ.Ip = this.GAY;
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
      this.GAZ = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.GAQ.b(this.GAZ);
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
  
  public final void fkD()
  {
    AppMethodBeat.i(26815);
    Log.d("MicroMsg.FailSendMsgNotification", "setIsForeground:%b", new Object[] { Boolean.FALSE });
    this.mIsForeground = false;
    AppMethodBeat.o(26815);
  }
  
  public final void fkE()
  {
    AppMethodBeat.i(26818);
    this.GAQ.e(2, false);
    this.GBd = false;
    show();
    Log.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, unLockInNotificationBar");
    AppMethodBeat.o(26818);
  }
  
  public final void fkF()
  {
    AppMethodBeat.i(26819);
    this.GBe = true;
    this.GAQ = com.tencent.mm.bx.a.cp(this.mContext, com.tencent.mm.bx.a.hfv());
    fkB();
    fkC();
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
    this.GAQ.n(this.GAX);
    this.GAQ.k(this.mContext.getText(R.l.app_name));
    this.GAQ.bn(fkG());
    this.GAQ.l(this.GAW);
    this.GAQ.W(false);
    this.IV = this.GAQ.gr();
    if ((Build.VERSION.SDK_INT >= 16) && (!this.mIsForeground))
    {
      this.IV.priority = 2;
      Log.d("MicroMsg.FailSendMsgNotification", "show notification, set priority to max");
    }
    Log.d("MicroMsg.FailSendMsgNotification", "show notification, mIsForeground:%b", new Object[] { Boolean.valueOf(this.mIsForeground) });
    bh.getNotification().a(this.mType, this.IV, false);
    this.GBc = true;
    AppMethodBeat.o(26816);
  }
  
  public static abstract class FailSendMsgNotificationService
    extends Service
  {
    protected IListener GBf = new IListener() {};
    protected FailSendMsgNotification GBg = null;
    
    protected abstract int fkH();
    
    public IBinder onBind(Intent paramIntent)
    {
      return null;
    }
    
    public void onCreate()
    {
      super.onCreate();
      Log.d("MicroMsg.FailSendMsgNotification", "onCreate FailSendMsgNotificationService");
      EventCenter.instance.addListener(this.GBf);
    }
    
    public void onDestroy()
    {
      super.onDestroy();
      Log.d("MicroMsg.FailSendMsgNotification", "onDestroy FailSendMsgNotificationService");
      EventCenter.instance.removeListener(this.GBf);
    }
    
    @TargetApi(16)
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
              if (f.aaH(paramInt1) == null)
              {
                Log.d("MicroMsg.FailSendMsgNotification", "handle action button, notification not exist");
                return 2;
              }
              Log.d("MicroMsg.FailSendMsgNotification", "action:%s", new Object[] { str });
              this.GBg = f.aaH(paramInt1);
              if (!str.startsWith("com.tencent.failnotification.omit")) {
                break;
              }
            } while (this.GBg.GAT == null);
            Log.d("MicroMsg.FailSendMsgNotification", "handle omit action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
            this.GBg.GAT.fkr();
            return 2;
            if (!str.startsWith("com.tencent.failnotificaiton.resend")) {
              break;
            }
          } while (this.GBg.GAT == null);
          boolean bool1;
          if (this.GBg.IV == null)
          {
            bool1 = true;
            if (this.GBg.GAQ != null) {
              break label350;
            }
          }
          for (boolean bool2 = true;; bool2 = false)
          {
            Log.d("MicroMsg.FailSendMsgNotification", "handle resend action button, type:%d, notification==null:%b, notificationBuilder==null:%b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            if (this.GBg != null) {
              this.GBg.mIsForeground = true;
            }
            if ((this.GBg.IV != null) && (Build.VERSION.SDK_INT >= 16)) {
              this.GBg.IV.priority = 0;
            }
            if (this.GBg.IV == null) {
              this.GBg.show();
            }
            this.GBg.GAT.fkq();
            Log.d("MicroMsg.FailSendMsgNotification", "finish handle resend action button, type:%d", new Object[] { Integer.valueOf(paramInt1) });
            return 2;
            bool1 = false;
            break;
          }
          if (!str.startsWith("com.tencent.failnotification.click")) {
            break;
          }
        } while (this.GBg.GAU == null);
        Log.d("MicroMsg.FailSendMsgNotification", "handle click notification, type:%d", new Object[] { Integer.valueOf(paramInt1) });
        this.GBg.GAU.fks();
        return 2;
      } while (!str.startsWith("com.tencent.failnotification.dismiss"));
      this.GBg.GBc = false;
      this.GBg.mIsForeground = false;
      if (this.GBg.GAV != null)
      {
        Log.d("MicroMsg.FailSendMsgNotification", "handle notification dismiss");
        this.GBg.GAV.onDismiss();
      }
      stopSelf();
      return 2;
    }
  }
  
  public static class FailSendNormalMsgNotificationService
    extends FailSendMsgNotification.FailSendMsgNotificationService
  {
    protected final int fkH()
    {
      return 1;
    }
  }
  
  public static class FailSendSnsMsgNotificationService
    extends FailSendMsgNotification.FailSendMsgNotificationService
  {
    protected final int fkH()
    {
      return 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.ui.FailSendMsgNotification
 * JD-Core Version:    0.7.0.1
 */
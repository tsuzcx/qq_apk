package com.tencent.mm.plugin.notification.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.an;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

@SuppressLint({"InlinedApi"})
public final class FailSendMsgNotification
{
  boolean bNX;
  public Context mContext;
  private boolean mIsInit;
  private int mType;
  public s.c pjB;
  private Intent pjC;
  private int pjD;
  public a pjE;
  public b pjF;
  public c pjG;
  public String pjH;
  public String pjI;
  private PendingIntent pjJ;
  private PendingIntent pjK;
  private PendingIntent pjL;
  private PendingIntent pjM;
  public boolean pjN;
  public boolean pjO;
  public boolean pjP;
  Notification yC;
  
  public FailSendMsgNotification()
  {
    this.yC = null;
    this.pjB = null;
    this.pjC = null;
    this.pjD = 0;
    this.pjE = null;
    this.pjF = null;
    this.pjG = null;
    this.pjH = null;
    this.pjI = null;
    this.pjJ = null;
    this.pjK = null;
    this.pjL = null;
    this.pjM = null;
    this.pjN = false;
    this.pjO = false;
    this.bNX = false;
    this.mIsInit = false;
    this.pjP = true;
  }
  
  public FailSendMsgNotification(int paramInt)
  {
    AppMethodBeat.i(23194);
    this.yC = null;
    this.pjB = null;
    this.pjC = null;
    this.pjD = 0;
    this.pjE = null;
    this.pjF = null;
    this.pjG = null;
    this.pjH = null;
    this.pjI = null;
    this.pjJ = null;
    this.pjK = null;
    this.pjL = null;
    this.pjM = null;
    this.pjN = false;
    this.pjO = false;
    this.bNX = false;
    this.mIsInit = false;
    this.pjP = true;
    this.mType = paramInt;
    this.mContext = ah.getContext();
    this.pjB = com.tencent.mm.bp.a.br(this.mContext, com.tencent.mm.bp.a.dkN());
    this.pjP = true;
    this.pjI = "";
    try
    {
      if (this.pjP) {
        bYo();
      }
      bYp();
      this.mIsInit = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.FailSendMsgNotification", "init FailSendMsgNotification error, e:%s", new Object[] { localException.getMessage() });
        this.mIsInit = false;
        continue;
        boolean bool = false;
      }
    }
    if (this.mContext == null)
    {
      bool = true;
      ab.d("MicroMsg.FailSendMsgNotification", "create FailSendMsgNotification, type:%d, context==null:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      this.pjN = false;
      AppMethodBeat.o(23194);
      return;
    }
  }
  
  private void bYo()
  {
    AppMethodBeat.i(23195);
    this.pjB.yr = true;
    Intent localIntent = new Intent();
    if (this.mType == 1)
    {
      localIntent.setAction("com.tencent.failnotification.omit_msg");
      localIntent.setClass(this.mContext, FailSendMsgNotification.FailSendNormalMsgNotificationService.class);
      localIntent.putExtra("notification_type", this.mType);
      this.pjL = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.pjB.a(2130839849, this.mContext.getString(2131301921), this.pjL);
      localIntent = new Intent();
      if (this.mType != 1) {
        break label237;
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
      this.pjM = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.pjB.a(2130839850, this.mContext.getString(2131301922), this.pjM);
      AppMethodBeat.o(23195);
      return;
      if (this.mType != 2) {
        break;
      }
      localIntent.setAction("com.tencent.failnotification.omit_sns");
      localIntent.setClass(this.mContext, FailSendMsgNotification.FailSendSnsMsgNotificationService.class);
      break;
      label237:
      if (this.mType == 2)
      {
        localIntent.setAction("com.tencent.failnotificaiton.resend_sns");
        localIntent.setClass(this.mContext, FailSendMsgNotification.FailSendSnsMsgNotificationService.class);
      }
    }
  }
  
  private static int bYt()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 2130839845;
    }
    return 2130839847;
  }
  
  public final void Wi(String paramString)
  {
    AppMethodBeat.i(23197);
    this.pjH = paramString;
    show();
    AppMethodBeat.o(23197);
  }
  
  public final void bYp()
  {
    AppMethodBeat.i(23196);
    Intent localIntent = new Intent();
    if (this.mType == 1)
    {
      localIntent.setAction("com.tencent.failnotification.click_msg");
      localIntent.setClass(this.mContext, FailSendMsgNotification.FailSendNormalMsgNotificationService.class);
      localIntent.putExtra("notification_type", this.mType);
      this.pjJ = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.pjB.ya = this.pjJ;
      localIntent = new Intent();
      if (this.mType != 1) {
        break label191;
      }
      localIntent.setAction("com.tencent.failnotification.dismiss_msg");
      localIntent.setClass(this.mContext, FailSendMsgNotification.FailSendNormalMsgNotificationService.class);
    }
    for (;;)
    {
      localIntent.putExtra("notification_type", this.mType);
      this.pjK = PendingIntent.getService(this.mContext, this.mType, localIntent, 134217728);
      this.pjB.a(this.pjK);
      AppMethodBeat.o(23196);
      return;
      if (this.mType != 2) {
        break;
      }
      localIntent.setAction("com.tencent.failnotification.click_sns");
      localIntent.setClass(this.mContext, FailSendMsgNotification.FailSendSnsMsgNotificationService.class);
      break;
      label191:
      if (this.mType == 2)
      {
        localIntent.setAction("com.tencent.failnotification.dismiss_sns");
        localIntent.setClass(this.mContext, FailSendMsgNotification.FailSendSnsMsgNotificationService.class);
      }
    }
  }
  
  public final void bYq()
  {
    AppMethodBeat.i(23198);
    ab.d("MicroMsg.FailSendMsgNotification", "setIsForeground:%b", new Object[] { Boolean.FALSE });
    this.bNX = false;
    AppMethodBeat.o(23198);
  }
  
  public final void bYr()
  {
    AppMethodBeat.i(23201);
    this.pjB.g(2, false);
    this.pjO = false;
    show();
    ab.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, unLockInNotificationBar");
    AppMethodBeat.o(23201);
  }
  
  public final void bYs()
  {
    AppMethodBeat.i(23202);
    this.pjP = true;
    this.pjB = com.tencent.mm.bp.a.br(this.mContext, com.tencent.mm.bp.a.dkN());
    bYo();
    bYp();
    AppMethodBeat.o(23202);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(23200);
    aw.getNotification().cancel(this.mType);
    Intent localIntent = new Intent();
    if (this.mType == 1)
    {
      localIntent.setClass(this.mContext, FailSendMsgNotification.FailSendNormalMsgNotificationService.class);
      this.mContext.stopService(localIntent);
    }
    for (;;)
    {
      this.bNX = false;
      this.pjN = false;
      AppMethodBeat.o(23200);
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
    AppMethodBeat.i(23199);
    if (!this.mIsInit)
    {
      ab.e("MicroMsg.FailSendMsgNotification", "when show notification, is not init yet");
      AppMethodBeat.o(23199);
      return;
    }
    this.pjB.h(this.pjI);
    this.pjB.e(this.mContext.getText(2131297005));
    this.pjB.Y(bYt());
    this.pjB.f(this.pjH);
    this.pjB.z(false);
    this.yC = this.pjB.build();
    if ((Build.VERSION.SDK_INT >= 16) && (!this.bNX))
    {
      this.yC.priority = 2;
      ab.d("MicroMsg.FailSendMsgNotification", "show notification, set priority to max");
    }
    ab.d("MicroMsg.FailSendMsgNotification", "show notification, mIsForeground:%b", new Object[] { Boolean.valueOf(this.bNX) });
    aw.getNotification().a(this.mType, this.yC, false);
    this.pjN = true;
    AppMethodBeat.o(23199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.ui.FailSendMsgNotification
 * JD-Core Version:    0.7.0.1
 */
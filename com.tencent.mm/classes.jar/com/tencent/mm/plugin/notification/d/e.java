package com.tencent.mm.plugin.notification.d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.la;
import com.tencent.mm.h.a.qp;
import com.tencent.mm.h.a.qp.a;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends com.tencent.mm.plugin.notification.c.a<c>
{
  private com.tencent.mm.sdk.b.c mIT = new e.1(this);
  private com.tencent.mm.sdk.b.c mIU = new com.tencent.mm.sdk.b.c() {};
  
  protected final void K(ArrayList<Long> paramArrayList)
  {
    la localla = new la();
    localla.bUb.bPa = paramArrayList;
    com.tencent.mm.sdk.b.a.udP.m(localla);
  }
  
  protected final String T(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.mContext.getString(R.l.notification_resending_sns_with_fail, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
  }
  
  public final void bpC()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.mIU);
  }
  
  public final void bpD()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.mIT);
  }
  
  public final void bpE()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.mIU);
  }
  
  public final void bpF()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.mIT);
  }
  
  protected final void bpn()
  {
    if (au.DK())
    {
      au.Hx();
      com.tencent.mm.model.c.Dz().o(589825, Boolean.valueOf(false));
    }
  }
  
  protected final void bpx()
  {
    Object localObject = ((ActivityManager)this.mContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      if (localObject != null)
      {
        localObject = ((ComponentName)localObject).getClassName();
        y.d("MicroMsg.SendSnsFailNotification", "onNotificationClick, currentActivity name:%s", new Object[] { localObject });
        if (((String)localObject).contains("SnsTimeLineUI"))
        {
          y.d("MicroMsg.SendSnsFailNotification", "onNotificationClick, already in SnsTimlineUI");
          return;
        }
      }
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("sns_resume_state", false);
    ((Intent)localObject).putExtra("sns_timeline_NeedFirstLoadint", true);
    ((Intent)localObject).putExtra("preferred_tab", 2);
    if (Build.VERSION.SDK_INT < 16) {
      ((Intent)localObject).putExtra("is_need_resend_sns", true);
    }
    ((Intent)localObject).putExtra("From_fail_notify", true);
    ((Intent)localObject).putExtra("jump_sns_from_notify", true);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).addFlags(536870912);
    d.e(this.mContext, "com.tencent.mm.ui.LauncherUI", (Intent)localObject);
  }
  
  protected final String du(int paramInt1, int paramInt2)
  {
    return this.mContext.getString(R.l.notification_resending_sns, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
  }
  
  protected final String dv(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0) {
      return this.mContext.getString(R.l.notification_resend_finish_sns_without_fail, new Object[] { Integer.valueOf(paramInt1) });
    }
    return this.mContext.getString(R.l.notificaiton_resend_finish_sns, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public final void fo(long paramLong)
  {
    ai.d(new e.3(this, paramLong));
  }
  
  public final boolean fp(long paramLong)
  {
    boolean bool = n.omI.xy((int)paramLong);
    y.d("MicroMsg.SendSnsFailNotification", "checkMsgIfExist, msgId:%d, result:%b", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool) });
    return bool;
  }
  
  protected final int getType()
  {
    return 2;
  }
  
  protected final String vu(int paramInt)
  {
    return this.mContext.getString(R.l.notificaiton_notify_fail_sns, new Object[] { Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.e
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.notification.d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.mz;
import com.tencent.mm.g.a.qw;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tt.a;
import com.tencent.mm.g.a.tv;
import com.tencent.mm.g.a.tv.a;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.sns.c.h;
import com.tencent.mm.plugin.sns.c.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.ab;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends com.tencent.mm.plugin.notification.c.a<c>
{
  private com.tencent.mm.sdk.b.c uhL;
  private com.tencent.mm.sdk.b.c uhM;
  
  public e()
  {
    AppMethodBeat.i(26779);
    this.uhL = new com.tencent.mm.sdk.b.c() {};
    this.uhM = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(26779);
  }
  
  public final String IB(int paramInt)
  {
    AppMethodBeat.i(26787);
    String str = getContext().getString(2131761658, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(26787);
    return str;
  }
  
  public final void af(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(26781);
    mz localmz = new mz();
    localmz.dsd.dlQ = paramArrayList;
    com.tencent.mm.sdk.b.a.ESL.l(localmz);
    AppMethodBeat.o(26781);
  }
  
  public final String an(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(26789);
    String str = getContext().getString(2131761716, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(26789);
    return str;
  }
  
  public final void cXD()
  {
    AppMethodBeat.i(26792);
    if (az.afw())
    {
      az.arV();
      com.tencent.mm.model.c.afk().set(589825, Boolean.FALSE);
    }
    AppMethodBeat.o(26792);
  }
  
  public final void cXP()
  {
    AppMethodBeat.i(26780);
    Object localObject = ((ActivityManager)this.mContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      if (localObject != null)
      {
        localObject = ((ComponentName)localObject).getClassName();
        ad.d("MicroMsg.SendSnsFailNotification", "onNotificationClick, currentActivity name:%s", new Object[] { localObject });
        if (((String)localObject).contains("SnsTimeLineUI"))
        {
          ad.d("MicroMsg.SendSnsFailNotification", "onNotificationClick, already in SnsTimlineUI");
          AppMethodBeat.o(26780);
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
    AppMethodBeat.o(26780);
  }
  
  public final void cXU()
  {
    AppMethodBeat.i(26782);
    com.tencent.mm.sdk.b.a.ESL.c(this.uhM);
    AppMethodBeat.o(26782);
  }
  
  public final void cXV()
  {
    AppMethodBeat.i(26783);
    com.tencent.mm.sdk.b.a.ESL.c(this.uhL);
    AppMethodBeat.o(26783);
  }
  
  public final void cXW()
  {
    AppMethodBeat.i(26785);
    com.tencent.mm.sdk.b.a.ESL.d(this.uhM);
    AppMethodBeat.o(26785);
  }
  
  public final void cXX()
  {
    AppMethodBeat.i(26786);
    com.tencent.mm.sdk.b.a.ESL.d(this.uhL);
    AppMethodBeat.o(26786);
  }
  
  public final int getType()
  {
    return 2;
  }
  
  public final String gq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26788);
    String str = getContext().getString(2131761715, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(26788);
    return str;
  }
  
  public final String gr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26790);
    if (paramInt2 <= 0)
    {
      str = getContext().getString(2131761712, new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(26790);
      return str;
    }
    String str = getContext().getString(2131761659, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(26790);
    return str;
  }
  
  public final void rC(final long paramLong)
  {
    AppMethodBeat.i(26784);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26778);
        ad.d("MicroMsg.SendSnsFailNotification", "resend snsInfo id:%d", new Object[] { Long.valueOf(paramLong) });
        qw localqw = new qw();
        localqw.dwz.dwA = ((int)paramLong);
        com.tencent.mm.sdk.b.a.ESL.l(localqw);
        AppMethodBeat.o(26778);
      }
    });
    AppMethodBeat.o(26784);
  }
  
  public final boolean rD(long paramLong)
  {
    AppMethodBeat.i(26791);
    if (o.wzM != null)
    {
      boolean bool = o.wzM.LW((int)paramLong);
      ad.d("MicroMsg.SendSnsFailNotification", "checkMsgIfExist, msgId:%d, result:%b", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool) });
      AppMethodBeat.o(26791);
      return bool;
    }
    AppMethodBeat.o(26791);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.e
 * JD-Core Version:    0.7.0.1
 */
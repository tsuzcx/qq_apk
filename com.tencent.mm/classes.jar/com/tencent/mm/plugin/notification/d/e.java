package com.tencent.mm.plugin.notification.d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.pg;
import com.tencent.mm.f.a.to;
import com.tencent.mm.f.a.xd;
import com.tencent.mm.f.a.xd.a;
import com.tencent.mm.f.a.xf;
import com.tencent.mm.f.a.xf.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.notification.c.a;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ao;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends a<c>
{
  private IListener GAy;
  private IListener GAz;
  
  public e()
  {
    AppMethodBeat.i(26779);
    this.GAy = new IListener() {};
    this.GAz = new IListener() {};
    AppMethodBeat.o(26779);
  }
  
  public final void OU(final long paramLong)
  {
    AppMethodBeat.i(26784);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26778);
        Log.d("MicroMsg.SendSnsFailNotification", "resend snsInfo id:%d", new Object[] { Long.valueOf(paramLong) });
        to localto = new to();
        localto.fSW.fSX = ((int)paramLong);
        EventCenter.instance.publish(localto);
        AppMethodBeat.o(26778);
      }
    });
    AppMethodBeat.o(26784);
  }
  
  public final boolean OV(long paramLong)
  {
    AppMethodBeat.i(26791);
    if (p.JPi != null)
    {
      boolean bool = p.JPi.afx((int)paramLong);
      Log.d("MicroMsg.SendSnsFailNotification", "checkMsgIfExist, msgId:%d, result:%b", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool) });
      AppMethodBeat.o(26791);
      return bool;
    }
    AppMethodBeat.o(26791);
    return false;
  }
  
  public final void aP(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(26781);
    pg localpg = new pg();
    localpg.fNY.fHi = paramArrayList;
    EventCenter.instance.publish(localpg);
    AppMethodBeat.o(26781);
  }
  
  public final String aaE(int paramInt)
  {
    AppMethodBeat.i(26787);
    String str = getContext().getString(R.l.eMY, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(26787);
    return str;
  }
  
  public final String az(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(26789);
    String str = getContext().getString(R.l.eNE, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(26789);
    return str;
  }
  
  public final void fkd()
  {
    AppMethodBeat.i(26792);
    if (bh.aHB())
    {
      bh.beI();
      com.tencent.mm.model.c.aHp().i(589825, Boolean.FALSE);
    }
    AppMethodBeat.o(26792);
  }
  
  public final void fkp()
  {
    AppMethodBeat.i(26780);
    Object localObject = ((ActivityManager)this.mContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      if (localObject != null)
      {
        localObject = ((ComponentName)localObject).getClassName();
        Log.d("MicroMsg.SendSnsFailNotification", "onNotificationClick, currentActivity name:%s", new Object[] { localObject });
        if (((String)localObject).contains("SnsTimeLineUI"))
        {
          Log.d("MicroMsg.SendSnsFailNotification", "onNotificationClick, already in SnsTimlineUI");
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
    com.tencent.mm.by.c.f(this.mContext, "com.tencent.mm.ui.LauncherUI", (Intent)localObject);
    AppMethodBeat.o(26780);
  }
  
  public final void fku()
  {
    AppMethodBeat.i(26782);
    EventCenter.instance.addListener(this.GAz);
    AppMethodBeat.o(26782);
  }
  
  public final void fkv()
  {
    AppMethodBeat.i(26783);
    EventCenter.instance.addListener(this.GAy);
    AppMethodBeat.o(26783);
  }
  
  public final void fkw()
  {
    AppMethodBeat.i(26785);
    EventCenter.instance.removeListener(this.GAz);
    AppMethodBeat.o(26785);
  }
  
  public final void fkx()
  {
    AppMethodBeat.i(26786);
    EventCenter.instance.removeListener(this.GAy);
    AppMethodBeat.o(26786);
  }
  
  public final int getType()
  {
    return 2;
  }
  
  public final String iG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26788);
    String str = getContext().getString(R.l.eND, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(26788);
    return str;
  }
  
  public final String iH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26790);
    if (paramInt2 <= 0)
    {
      str = getContext().getString(R.l.eNA, new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(26790);
      return str;
    }
    String str = getContext().getString(R.l.eMZ, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(26790);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.e
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.notification.d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oj;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.g.a.vy;
import com.tencent.mm.g.a.vy.a;
import com.tencent.mm.g.a.wa;
import com.tencent.mm.g.a.wa.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.notification.c.a;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.plugin.sns.b.o;
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
  private IListener AHp;
  private IListener AHq;
  
  public e()
  {
    AppMethodBeat.i(26779);
    this.AHp = new IListener() {};
    this.AHq = new IListener() {};
    AppMethodBeat.o(26779);
  }
  
  public final void HA(final long paramLong)
  {
    AppMethodBeat.i(26784);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26778);
        Log.d("MicroMsg.SendSnsFailNotification", "resend snsInfo id:%d", new Object[] { Long.valueOf(paramLong) });
        sn localsn = new sn();
        localsn.dZd.dZe = ((int)paramLong);
        EventCenter.instance.publish(localsn);
        AppMethodBeat.o(26778);
      }
    });
    AppMethodBeat.o(26784);
  }
  
  public final boolean HB(long paramLong)
  {
    AppMethodBeat.i(26791);
    if (o.DCS != null)
    {
      boolean bool = o.DCS.Yh((int)paramLong);
      Log.d("MicroMsg.SendSnsFailNotification", "checkMsgIfExist, msgId:%d, result:%b", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool) });
      AppMethodBeat.o(26791);
      return bool;
    }
    AppMethodBeat.o(26791);
    return false;
  }
  
  public final String TR(int paramInt)
  {
    AppMethodBeat.i(26787);
    String str = getContext().getString(2131763626, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(26787);
    return str;
  }
  
  public final void aH(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(26781);
    oj localoj = new oj();
    localoj.dUw.dNX = paramArrayList;
    EventCenter.instance.publish(localoj);
    AppMethodBeat.o(26781);
  }
  
  public final String av(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(26789);
    String str = getContext().getString(2131763684, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(26789);
    return str;
  }
  
  public final void eyK()
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
    com.tencent.mm.br.c.f(this.mContext, "com.tencent.mm.ui.LauncherUI", (Intent)localObject);
    AppMethodBeat.o(26780);
  }
  
  public final void eyP()
  {
    AppMethodBeat.i(26782);
    EventCenter.instance.addListener(this.AHq);
    AppMethodBeat.o(26782);
  }
  
  public final void eyQ()
  {
    AppMethodBeat.i(26783);
    EventCenter.instance.addListener(this.AHp);
    AppMethodBeat.o(26783);
  }
  
  public final void eyR()
  {
    AppMethodBeat.i(26785);
    EventCenter.instance.removeListener(this.AHq);
    AppMethodBeat.o(26785);
  }
  
  public final void eyS()
  {
    AppMethodBeat.i(26786);
    EventCenter.instance.removeListener(this.AHp);
    AppMethodBeat.o(26786);
  }
  
  public final void eyy()
  {
    AppMethodBeat.i(26792);
    if (bg.aAc())
    {
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(589825, Boolean.FALSE);
    }
    AppMethodBeat.o(26792);
  }
  
  public final int getType()
  {
    return 2;
  }
  
  public final String hB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26788);
    String str = getContext().getString(2131763683, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(26788);
    return str;
  }
  
  public final String hC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26790);
    if (paramInt2 <= 0)
    {
      str = getContext().getString(2131763680, new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(26790);
      return str;
    }
    String str = getContext().getString(2131763627, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(26790);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.e
 * JD-Core Version:    0.7.0.1
 */
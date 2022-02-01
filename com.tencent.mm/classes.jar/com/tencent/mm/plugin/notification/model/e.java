package com.tencent.mm.plugin.notification.model;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.qs;
import com.tencent.mm.autogen.a.vd;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.notification.base.a;
import com.tencent.mm.plugin.sns.c.j;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.aq;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends a<c>
{
  private IListener MwI;
  private IListener MwJ;
  
  public e()
  {
    AppMethodBeat.i(26779);
    this.MwI = new SendSnsFailNotification.1(this, f.hfK);
    this.MwJ = new SendSnsFailNotification.2(this, f.hfK);
    AppMethodBeat.o(26779);
  }
  
  public final String aX(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(26789);
    String str = getContext().getString(R.l.gPS, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(26789);
    return str;
  }
  
  public final String aeX(int paramInt)
  {
    AppMethodBeat.i(26787);
    String str = getContext().getString(R.l.gPl, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(26787);
    return str;
  }
  
  public final void bl(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(26781);
    qs localqs = new qs();
    localqs.hTQ.hMF = paramArrayList;
    localqs.publish();
    AppMethodBeat.o(26781);
  }
  
  public final int getType()
  {
    return 2;
  }
  
  public final void guG()
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
    com.tencent.mm.br.c.g(this.mContext, "com.tencent.mm.ui.LauncherUI", (Intent)localObject);
    AppMethodBeat.o(26780);
  }
  
  public final void guL()
  {
    AppMethodBeat.i(26782);
    this.MwJ.alive();
    AppMethodBeat.o(26782);
  }
  
  public final void guM()
  {
    AppMethodBeat.i(26783);
    this.MwI.alive();
    AppMethodBeat.o(26783);
  }
  
  public final void guN()
  {
    AppMethodBeat.i(26785);
    this.MwJ.dead();
    AppMethodBeat.o(26785);
  }
  
  public final void guO()
  {
    AppMethodBeat.i(26786);
    this.MwI.dead();
    AppMethodBeat.o(26786);
  }
  
  public final void guu()
  {
    AppMethodBeat.i(26792);
    if (bh.baz())
    {
      bh.bCz();
      com.tencent.mm.model.c.ban().B(589825, Boolean.FALSE);
    }
    AppMethodBeat.o(26792);
  }
  
  public final String km(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26788);
    String str = getContext().getString(R.l.gPR, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(26788);
    return str;
  }
  
  public final String kn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26790);
    if (paramInt2 <= 0)
    {
      str = getContext().getString(R.l.gPO, new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(26790);
      return str;
    }
    String str = getContext().getString(R.l.gPm, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(26790);
    return str;
  }
  
  public final void sX(final long paramLong)
  {
    AppMethodBeat.i(26784);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26778);
        Log.d("MicroMsg.SendSnsFailNotification", "resend snsInfo id:%d", new Object[] { Long.valueOf(paramLong) });
        vd localvd = new vd();
        localvd.hYU.hYV = ((int)paramLong);
        localvd.publish();
        AppMethodBeat.o(26778);
      }
    });
    AppMethodBeat.o(26784);
  }
  
  public final boolean sY(long paramLong)
  {
    AppMethodBeat.i(26791);
    if (q.Qko != null)
    {
      boolean bool = q.Qko.akj((int)paramLong);
      Log.d("MicroMsg.SendSnsFailNotification", "checkMsgIfExist, msgId:%d, result:%b", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool) });
      AppMethodBeat.o(26791);
      return bool;
    }
    AppMethodBeat.o(26791);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.model.e
 * JD-Core Version:    0.7.0.1
 */
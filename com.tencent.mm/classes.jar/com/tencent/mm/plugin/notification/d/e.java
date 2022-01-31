package com.tencent.mm.plugin.notification.d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.lo;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.g.a.rz.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends com.tencent.mm.plugin.notification.c.a<c>
{
  private com.tencent.mm.sdk.b.c pji;
  private com.tencent.mm.sdk.b.c pjj;
  
  public e()
  {
    AppMethodBeat.i(23158);
    this.pji = new e.1(this);
    this.pjj = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(23158);
  }
  
  public final String AS(int paramInt)
  {
    AppMethodBeat.i(23166);
    String str = getContext().getString(2131301896, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(23166);
    return str;
  }
  
  public final void M(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(23160);
    lo locallo = new lo();
    locallo.cBG.cwr = paramArrayList;
    com.tencent.mm.sdk.b.a.ymk.l(locallo);
    AppMethodBeat.o(23160);
  }
  
  public final String ae(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(23168);
    String str = getContext().getString(2131301954, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(23168);
    return str;
  }
  
  public final void bXR()
  {
    AppMethodBeat.i(23171);
    if (aw.RG())
    {
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(589825, Boolean.FALSE);
    }
    AppMethodBeat.o(23171);
  }
  
  public final void bYd()
  {
    AppMethodBeat.i(23159);
    Object localObject = ((ActivityManager)this.mContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      if (localObject != null)
      {
        localObject = ((ComponentName)localObject).getClassName();
        ab.d("MicroMsg.SendSnsFailNotification", "onNotificationClick, currentActivity name:%s", new Object[] { localObject });
        if (((String)localObject).contains("SnsTimeLineUI"))
        {
          ab.d("MicroMsg.SendSnsFailNotification", "onNotificationClick, already in SnsTimlineUI");
          AppMethodBeat.o(23159);
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
    d.f(this.mContext, "com.tencent.mm.ui.LauncherUI", (Intent)localObject);
    AppMethodBeat.o(23159);
  }
  
  public final void bYi()
  {
    AppMethodBeat.i(23161);
    com.tencent.mm.sdk.b.a.ymk.c(this.pjj);
    AppMethodBeat.o(23161);
  }
  
  public final void bYj()
  {
    AppMethodBeat.i(23162);
    com.tencent.mm.sdk.b.a.ymk.c(this.pji);
    AppMethodBeat.o(23162);
  }
  
  public final void bYk()
  {
    AppMethodBeat.i(23164);
    com.tencent.mm.sdk.b.a.ymk.d(this.pjj);
    AppMethodBeat.o(23164);
  }
  
  public final void bYl()
  {
    AppMethodBeat.i(23165);
    com.tencent.mm.sdk.b.a.ymk.d(this.pji);
    AppMethodBeat.o(23165);
  }
  
  public final String eU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(23167);
    String str = getContext().getString(2131301953, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(23167);
    return str;
  }
  
  public final String eV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(23169);
    if (paramInt2 <= 0)
    {
      str = getContext().getString(2131301950, new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(23169);
      return str;
    }
    String str = getContext().getString(2131301897, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(23169);
    return str;
  }
  
  public final int getType()
  {
    return 2;
  }
  
  public final void kM(long paramLong)
  {
    AppMethodBeat.i(23163);
    al.d(new e.3(this, paramLong));
    AppMethodBeat.o(23163);
  }
  
  public final boolean kN(long paramLong)
  {
    AppMethodBeat.i(23170);
    if (n.raW != null)
    {
      boolean bool = n.raW.Dy((int)paramLong);
      ab.d("MicroMsg.SendSnsFailNotification", "checkMsgIfExist, msgId:%d, result:%b", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool) });
      AppMethodBeat.o(23170);
      return bool;
    }
    AppMethodBeat.o(23170);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.e
 * JD-Core Version:    0.7.0.1
 */
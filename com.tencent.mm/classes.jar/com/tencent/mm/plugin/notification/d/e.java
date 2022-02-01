package com.tencent.mm.plugin.notification.d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.g.a.rr;
import com.tencent.mm.g.a.uz;
import com.tencent.mm.g.a.uz.a;
import com.tencent.mm.g.a.vb;
import com.tencent.mm.g.a.vb.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.storage.aj;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends com.tencent.mm.plugin.notification.c.a<c>
{
  private com.tencent.mm.sdk.b.c wLN;
  private com.tencent.mm.sdk.b.c wLO;
  
  public e()
  {
    AppMethodBeat.i(26779);
    this.wLN = new com.tencent.mm.sdk.b.c() {};
    this.wLO = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(26779);
  }
  
  public final String MH(int paramInt)
  {
    AppMethodBeat.i(26787);
    String str = getContext().getString(2131761658, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(26787);
    return str;
  }
  
  public final String ap(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(26789);
    String str = getContext().getString(2131761716, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(26789);
    return str;
  }
  
  public final void aq(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(26781);
    nr localnr = new nr();
    localnr.dCG.dwq = paramArrayList;
    com.tencent.mm.sdk.b.a.IvT.l(localnr);
    AppMethodBeat.o(26781);
  }
  
  public final void dyR()
  {
    AppMethodBeat.i(26792);
    if (bc.ajM())
    {
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(589825, Boolean.FALSE);
    }
    AppMethodBeat.o(26792);
  }
  
  public final void dzd()
  {
    AppMethodBeat.i(26780);
    Object localObject = ((ActivityManager)this.mContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      if (localObject != null)
      {
        localObject = ((ComponentName)localObject).getClassName();
        ae.d("MicroMsg.SendSnsFailNotification", "onNotificationClick, currentActivity name:%s", new Object[] { localObject });
        if (((String)localObject).contains("SnsTimeLineUI"))
        {
          ae.d("MicroMsg.SendSnsFailNotification", "onNotificationClick, already in SnsTimlineUI");
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
    d.f(this.mContext, "com.tencent.mm.ui.LauncherUI", (Intent)localObject);
    AppMethodBeat.o(26780);
  }
  
  public final void dzi()
  {
    AppMethodBeat.i(26782);
    com.tencent.mm.sdk.b.a.IvT.c(this.wLO);
    AppMethodBeat.o(26782);
  }
  
  public final void dzj()
  {
    AppMethodBeat.i(26783);
    com.tencent.mm.sdk.b.a.IvT.c(this.wLN);
    AppMethodBeat.o(26783);
  }
  
  public final void dzk()
  {
    AppMethodBeat.i(26785);
    com.tencent.mm.sdk.b.a.IvT.d(this.wLO);
    AppMethodBeat.o(26785);
  }
  
  public final void dzl()
  {
    AppMethodBeat.i(26786);
    com.tencent.mm.sdk.b.a.IvT.d(this.wLN);
    AppMethodBeat.o(26786);
  }
  
  public final String gQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26788);
    String str = getContext().getString(2131761715, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(26788);
    return str;
  }
  
  public final String gR(int paramInt1, int paramInt2)
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
  
  public final int getType()
  {
    return 2;
  }
  
  public final void yI(final long paramLong)
  {
    AppMethodBeat.i(26784);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26778);
        ae.d("MicroMsg.SendSnsFailNotification", "resend snsInfo id:%d", new Object[] { Long.valueOf(paramLong) });
        rr localrr = new rr();
        localrr.dHs.dHt = ((int)paramLong);
        com.tencent.mm.sdk.b.a.IvT.l(localrr);
        AppMethodBeat.o(26778);
      }
    });
    AppMethodBeat.o(26784);
  }
  
  public final boolean yJ(long paramLong)
  {
    AppMethodBeat.i(26791);
    if (o.zsB != null)
    {
      boolean bool = o.zsB.Qm((int)paramLong);
      ae.d("MicroMsg.SendSnsFailNotification", "checkMsgIfExist, msgId:%d, result:%b", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool) });
      AppMethodBeat.o(26791);
      return bool;
    }
    AppMethodBeat.o(26791);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.e
 * JD-Core Version:    0.7.0.1
 */
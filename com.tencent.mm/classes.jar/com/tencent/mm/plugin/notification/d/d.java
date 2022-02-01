package com.tencent.mm.plugin.notification.d;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rd;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.g.a.sl.a;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.g.a.sn.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.notification.c.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.bo;
import java.util.ArrayList;

public final class d
  extends com.tencent.mm.plugin.notification.c.a<bo>
{
  private com.tencent.mm.sdk.b.c vqC;
  private com.tencent.mm.sdk.b.c vqD;
  
  public d()
  {
    AppMethodBeat.i(26759);
    this.vqC = new com.tencent.mm.sdk.b.c() {};
    this.vqD = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(26759);
  }
  
  public final String KA(int paramInt)
  {
    AppMethodBeat.i(26767);
    String str = getContext().getString(2131761657, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(26767);
    return str;
  }
  
  public final String ap(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(26769);
    String str = getContext().getString(2131761714, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(26769);
    return str;
  }
  
  public final void aq(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(26766);
    az.ayM();
    com.tencent.mm.model.c.awD().al(paramArrayList);
    AppMethodBeat.o(26766);
  }
  
  public final void dlC()
  {
    AppMethodBeat.i(26760);
    com.tencent.mm.sdk.b.a.GpY.c(this.vqC);
    AppMethodBeat.o(26760);
  }
  
  public final void dlD()
  {
    AppMethodBeat.i(26761);
    com.tencent.mm.sdk.b.a.GpY.c(this.vqD);
    AppMethodBeat.o(26761);
  }
  
  public final void dlE()
  {
    AppMethodBeat.i(26763);
    com.tencent.mm.sdk.b.a.GpY.d(this.vqC);
    AppMethodBeat.o(26763);
  }
  
  public final void dlF()
  {
    AppMethodBeat.i(26764);
    com.tencent.mm.sdk.b.a.GpY.d(this.vqD);
    AppMethodBeat.o(26764);
  }
  
  public final void dlx()
  {
    AppMethodBeat.i(26765);
    ac.i("MicroMsg.SendNormalMsgFailNotificaiton", "onNotificationClick, mMsgList.size:%d", new Object[] { Integer.valueOf(this.vql.vqw.size()) });
    if (!g.agP().afY())
    {
      ac.w("MicroMsg.SendNormalMsgFailNotificaiton", "account not ready.");
      AppMethodBeat.o(26765);
      return;
    }
    Object localObject;
    if (this.vql.vqw.size() > 1)
    {
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).addFlags(536870912);
      if (Build.VERSION.SDK_INT < 16) {
        ((Intent)localObject).putExtra("resend_fail_messages", true);
      }
      ((Intent)localObject).putExtra("From_fail_notify", true);
      ac.d("MicroMsg.SendNormalMsgFailNotificaiton", "startMainUI");
      com.tencent.mm.br.d.e(this.mContext, "com.tencent.mm.ui.LauncherUI", (Intent)localObject);
      AppMethodBeat.o(26765);
      return;
    }
    if (this.vql.vqw.size() == 1)
    {
      long l = this.vql.get(0);
      az.ayM();
      localObject = com.tencent.mm.model.c.awD().vP(l).field_talker;
      Intent localIntent = new Intent();
      localIntent.putExtra("Main_User", (String)localObject);
      localIntent.putExtra("From_fail_notify", true);
      localIntent.addFlags(67108864);
      localIntent.addFlags(536870912);
      if (Build.VERSION.SDK_INT < 16) {
        localIntent.putExtra("resend_fail_messages", true);
      }
      com.tencent.mm.br.d.e(this.mContext, "com.tencent.mm.ui.LauncherUI", localIntent);
    }
    AppMethodBeat.o(26765);
  }
  
  public final int getType()
  {
    return 1;
  }
  
  public final String gx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26768);
    String str = getContext().getString(2131761713, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(26768);
    return str;
  }
  
  public final String gy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26770);
    if (paramInt2 <= 0)
    {
      str = getContext().getString(2131761711, new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(26770);
      return str;
    }
    String str = getContext().getString(2131761710, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(26770);
    return str;
  }
  
  public final void wf(final long paramLong)
  {
    AppMethodBeat.i(26762);
    az.ayM();
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26758);
        ac.d("MicroMsg.SendNormalMsgFailNotificaiton", "resend msgId:%d", new Object[] { Long.valueOf(paramLong) });
        rd localrd = new rd();
        localrd.dui.cZc = this.hmq;
        com.tencent.mm.sdk.b.a.GpY.l(localrd);
        AppMethodBeat.o(26758);
      }
    });
    AppMethodBeat.o(26762);
  }
  
  public final boolean wg(long paramLong)
  {
    AppMethodBeat.i(26771);
    az.ayM();
    bo localbo = com.tencent.mm.model.c.awD().vP(paramLong);
    ac.d("MicroMsg.SendNormalMsgFailNotificaiton", "checkMsgIfExist, msgId:%d, msg.getMsgId:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(localbo.field_msgId) });
    if (localbo.field_msgId != 0L)
    {
      AppMethodBeat.o(26771);
      return true;
    }
    AppMethodBeat.o(26771);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.d
 * JD-Core Version:    0.7.0.1
 */
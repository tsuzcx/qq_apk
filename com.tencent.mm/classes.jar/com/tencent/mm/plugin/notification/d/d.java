package com.tencent.mm.plugin.notification.d;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.g.a.sc.a;
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.a.se.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.notification.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.bl;
import java.util.ArrayList;

public final class d
  extends com.tencent.mm.plugin.notification.c.a<bl>
{
  private com.tencent.mm.sdk.b.c uhE;
  private com.tencent.mm.sdk.b.c uhF;
  
  public d()
  {
    AppMethodBeat.i(26759);
    this.uhE = new com.tencent.mm.sdk.b.c() {};
    this.uhF = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(26759);
  }
  
  public final String IB(int paramInt)
  {
    AppMethodBeat.i(26767);
    String str = getContext().getString(2131761657, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(26767);
    return str;
  }
  
  public final void af(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(26766);
    az.arV();
    com.tencent.mm.model.c.apO().aa(paramArrayList);
    AppMethodBeat.o(26766);
  }
  
  public final String an(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(26769);
    String str = getContext().getString(2131761714, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(26769);
    return str;
  }
  
  public final void cXP()
  {
    AppMethodBeat.i(26765);
    ad.i("MicroMsg.SendNormalMsgFailNotificaiton", "onNotificationClick, mMsgList.size:%d", new Object[] { Integer.valueOf(this.uhn.uhy.size()) });
    if (!g.afz().aeI())
    {
      ad.w("MicroMsg.SendNormalMsgFailNotificaiton", "account not ready.");
      AppMethodBeat.o(26765);
      return;
    }
    Object localObject;
    if (this.uhn.uhy.size() > 1)
    {
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).addFlags(536870912);
      if (Build.VERSION.SDK_INT < 16) {
        ((Intent)localObject).putExtra("resend_fail_messages", true);
      }
      ((Intent)localObject).putExtra("From_fail_notify", true);
      ad.d("MicroMsg.SendNormalMsgFailNotificaiton", "startMainUI");
      com.tencent.mm.bs.d.e(this.mContext, "com.tencent.mm.ui.LauncherUI", (Intent)localObject);
      AppMethodBeat.o(26765);
      return;
    }
    if (this.uhn.uhy.size() == 1)
    {
      long l = this.uhn.get(0);
      az.arV();
      localObject = com.tencent.mm.model.c.apO().rm(l).field_talker;
      Intent localIntent = new Intent();
      localIntent.putExtra("Main_User", (String)localObject);
      localIntent.putExtra("From_fail_notify", true);
      localIntent.addFlags(67108864);
      localIntent.addFlags(536870912);
      if (Build.VERSION.SDK_INT < 16) {
        localIntent.putExtra("resend_fail_messages", true);
      }
      com.tencent.mm.bs.d.e(this.mContext, "com.tencent.mm.ui.LauncherUI", localIntent);
    }
    AppMethodBeat.o(26765);
  }
  
  public final void cXU()
  {
    AppMethodBeat.i(26760);
    com.tencent.mm.sdk.b.a.ESL.c(this.uhE);
    AppMethodBeat.o(26760);
  }
  
  public final void cXV()
  {
    AppMethodBeat.i(26761);
    com.tencent.mm.sdk.b.a.ESL.c(this.uhF);
    AppMethodBeat.o(26761);
  }
  
  public final void cXW()
  {
    AppMethodBeat.i(26763);
    com.tencent.mm.sdk.b.a.ESL.d(this.uhE);
    AppMethodBeat.o(26763);
  }
  
  public final void cXX()
  {
    AppMethodBeat.i(26764);
    com.tencent.mm.sdk.b.a.ESL.d(this.uhF);
    AppMethodBeat.o(26764);
  }
  
  public final int getType()
  {
    return 1;
  }
  
  public final String gq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26768);
    String str = getContext().getString(2131761713, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(26768);
    return str;
  }
  
  public final String gr(int paramInt1, int paramInt2)
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
  
  public final void rC(final long paramLong)
  {
    AppMethodBeat.i(26762);
    az.arV();
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26758);
        ad.d("MicroMsg.SendNormalMsgFailNotificaiton", "resend msgId:%d", new Object[] { Long.valueOf(paramLong) });
        qu localqu = new qu();
        localqu.dwv.dbD = this.gLQ;
        com.tencent.mm.sdk.b.a.ESL.l(localqu);
        AppMethodBeat.o(26758);
      }
    });
    AppMethodBeat.o(26762);
  }
  
  public final boolean rD(long paramLong)
  {
    AppMethodBeat.i(26771);
    az.arV();
    bl localbl = com.tencent.mm.model.c.apO().rm(paramLong);
    ad.d("MicroMsg.SendNormalMsgFailNotificaiton", "checkMsgIfExist, msgId:%d, msg.getMsgId:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(localbl.field_msgId) });
    if (localbl.field_msgId != 0L)
    {
      AppMethodBeat.o(26771);
      return true;
    }
    AppMethodBeat.o(26771);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.d
 * JD-Core Version:    0.7.0.1
 */
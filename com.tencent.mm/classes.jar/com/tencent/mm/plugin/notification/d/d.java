package com.tencent.mm.plugin.notification.d;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.g.a.sy.a;
import com.tencent.mm.g.a.ta;
import com.tencent.mm.g.a.ta.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.notification.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.bu;
import java.util.ArrayList;

public final class d
  extends com.tencent.mm.plugin.notification.c.a<bu>
{
  private com.tencent.mm.sdk.b.c wvU;
  private com.tencent.mm.sdk.b.c wvV;
  
  public d()
  {
    AppMethodBeat.i(26759);
    this.wvU = new com.tencent.mm.sdk.b.c() {};
    this.wvV = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(26759);
  }
  
  public final String Mc(int paramInt)
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
  
  public final void ap(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(26766);
    ba.aBQ();
    com.tencent.mm.model.c.azs().ak(paramArrayList);
    AppMethodBeat.o(26766);
  }
  
  public final void dvO()
  {
    AppMethodBeat.i(26765);
    ad.i("MicroMsg.SendNormalMsgFailNotificaiton", "onNotificationClick, mMsgList.size:%d", new Object[] { Integer.valueOf(this.wvD.wvO.size()) });
    if (!g.ajA().aiK())
    {
      ad.w("MicroMsg.SendNormalMsgFailNotificaiton", "account not ready.");
      AppMethodBeat.o(26765);
      return;
    }
    Object localObject;
    if (this.wvD.wvO.size() > 1)
    {
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).addFlags(536870912);
      if (Build.VERSION.SDK_INT < 16) {
        ((Intent)localObject).putExtra("resend_fail_messages", true);
      }
      ((Intent)localObject).putExtra("From_fail_notify", true);
      ad.d("MicroMsg.SendNormalMsgFailNotificaiton", "startMainUI");
      com.tencent.mm.bs.d.f(this.mContext, "com.tencent.mm.ui.LauncherUI", (Intent)localObject);
      AppMethodBeat.o(26765);
      return;
    }
    if (this.wvD.wvO.size() == 1)
    {
      long l = this.wvD.get(0);
      ba.aBQ();
      localObject = com.tencent.mm.model.c.azs().xY(l).field_talker;
      Intent localIntent = new Intent();
      localIntent.putExtra("Main_User", (String)localObject);
      localIntent.putExtra("From_fail_notify", true);
      localIntent.addFlags(67108864);
      localIntent.addFlags(536870912);
      if (Build.VERSION.SDK_INT < 16) {
        localIntent.putExtra("resend_fail_messages", true);
      }
      com.tencent.mm.bs.d.f(this.mContext, "com.tencent.mm.ui.LauncherUI", localIntent);
    }
    AppMethodBeat.o(26765);
  }
  
  public final void dvT()
  {
    AppMethodBeat.i(26760);
    com.tencent.mm.sdk.b.a.IbL.c(this.wvU);
    AppMethodBeat.o(26760);
  }
  
  public final void dvU()
  {
    AppMethodBeat.i(26761);
    com.tencent.mm.sdk.b.a.IbL.c(this.wvV);
    AppMethodBeat.o(26761);
  }
  
  public final void dvV()
  {
    AppMethodBeat.i(26763);
    com.tencent.mm.sdk.b.a.IbL.d(this.wvU);
    AppMethodBeat.o(26763);
  }
  
  public final void dvW()
  {
    AppMethodBeat.i(26764);
    com.tencent.mm.sdk.b.a.IbL.d(this.wvV);
    AppMethodBeat.o(26764);
  }
  
  public final String gP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26768);
    String str = getContext().getString(2131761713, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(26768);
    return str;
  }
  
  public final String gQ(int paramInt1, int paramInt2)
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
  
  public final int getType()
  {
    return 1;
  }
  
  public final void yo(final long paramLong)
  {
    AppMethodBeat.i(26762);
    ba.aBQ();
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26758);
        ad.d("MicroMsg.SendNormalMsgFailNotificaiton", "resend msgId:%d", new Object[] { Long.valueOf(paramLong) });
        ro localro = new ro();
        localro.dGi.dku = this.hED;
        com.tencent.mm.sdk.b.a.IbL.l(localro);
        AppMethodBeat.o(26758);
      }
    });
    AppMethodBeat.o(26762);
  }
  
  public final boolean yp(long paramLong)
  {
    AppMethodBeat.i(26771);
    ba.aBQ();
    bu localbu = com.tencent.mm.model.c.azs().xY(paramLong);
    ad.d("MicroMsg.SendNormalMsgFailNotificaiton", "checkMsgIfExist, msgId:%d, msg.getMsgId:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(localbu.field_msgId) });
    if (localbu.field_msgId != 0L)
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
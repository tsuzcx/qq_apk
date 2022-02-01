package com.tencent.mm.plugin.notification.d;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rp;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.a.sz.a;
import com.tencent.mm.g.a.tb;
import com.tencent.mm.g.a.tb.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.notification.c.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;

public final class d
  extends com.tencent.mm.plugin.notification.c.a<bv>
{
  private com.tencent.mm.sdk.b.c wLG;
  private com.tencent.mm.sdk.b.c wLH;
  
  public d()
  {
    AppMethodBeat.i(26759);
    this.wLG = new com.tencent.mm.sdk.b.c() {};
    this.wLH = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(26759);
  }
  
  public final String MH(int paramInt)
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
    g.ajS();
    if (g.ajP().aiZ())
    {
      bc.aCg();
      com.tencent.mm.model.c.azI().ak(paramArrayList);
      AppMethodBeat.o(26766);
      return;
    }
    ae.e("MicroMsg.SendNormalMsgFailNotificaiton", "omitAllFailMsgImpl account no initialized");
    AppMethodBeat.o(26766);
  }
  
  public final void dzd()
  {
    AppMethodBeat.i(26765);
    ae.i("MicroMsg.SendNormalMsgFailNotificaiton", "onNotificationClick, mMsgList.size:%d", new Object[] { Integer.valueOf(this.wLo.wLz.size()) });
    if (!g.ajP().aiZ())
    {
      ae.w("MicroMsg.SendNormalMsgFailNotificaiton", "account not ready.");
      AppMethodBeat.o(26765);
      return;
    }
    Object localObject;
    if (this.wLo.wLz.size() > 1)
    {
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).addFlags(536870912);
      if (Build.VERSION.SDK_INT < 16) {
        ((Intent)localObject).putExtra("resend_fail_messages", true);
      }
      ((Intent)localObject).putExtra("From_fail_notify", true);
      ae.d("MicroMsg.SendNormalMsgFailNotificaiton", "startMainUI");
      com.tencent.mm.br.d.f(this.mContext, "com.tencent.mm.ui.LauncherUI", (Intent)localObject);
      AppMethodBeat.o(26765);
      return;
    }
    if (this.wLo.wLz.size() == 1)
    {
      long l = this.wLo.get(0);
      bc.aCg();
      localObject = com.tencent.mm.model.c.azI().ys(l).field_talker;
      Intent localIntent = new Intent();
      localIntent.putExtra("Main_User", (String)localObject);
      localIntent.putExtra("From_fail_notify", true);
      localIntent.addFlags(67108864);
      localIntent.addFlags(536870912);
      if (Build.VERSION.SDK_INT < 16) {
        localIntent.putExtra("resend_fail_messages", true);
      }
      com.tencent.mm.br.d.f(this.mContext, "com.tencent.mm.ui.LauncherUI", localIntent);
    }
    AppMethodBeat.o(26765);
  }
  
  public final void dzi()
  {
    AppMethodBeat.i(26760);
    com.tencent.mm.sdk.b.a.IvT.c(this.wLG);
    AppMethodBeat.o(26760);
  }
  
  public final void dzj()
  {
    AppMethodBeat.i(26761);
    com.tencent.mm.sdk.b.a.IvT.c(this.wLH);
    AppMethodBeat.o(26761);
  }
  
  public final void dzk()
  {
    AppMethodBeat.i(26763);
    com.tencent.mm.sdk.b.a.IvT.d(this.wLG);
    AppMethodBeat.o(26763);
  }
  
  public final void dzl()
  {
    AppMethodBeat.i(26764);
    com.tencent.mm.sdk.b.a.IvT.d(this.wLH);
    AppMethodBeat.o(26764);
  }
  
  public final String gQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26768);
    String str = getContext().getString(2131761713, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(26768);
    return str;
  }
  
  public final String gR(int paramInt1, int paramInt2)
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
  
  public final void yI(final long paramLong)
  {
    AppMethodBeat.i(26762);
    bc.aCg();
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26758);
        ae.d("MicroMsg.SendNormalMsgFailNotificaiton", "resend msgId:%d", new Object[] { Long.valueOf(paramLong) });
        rp localrp = new rp();
        localrp.dHo.dlw = this.hHv;
        com.tencent.mm.sdk.b.a.IvT.l(localrp);
        AppMethodBeat.o(26758);
      }
    });
    AppMethodBeat.o(26762);
  }
  
  public final boolean yJ(long paramLong)
  {
    AppMethodBeat.i(26771);
    bc.aCg();
    bv localbv = com.tencent.mm.model.c.azI().ys(paramLong);
    ae.d("MicroMsg.SendNormalMsgFailNotificaiton", "checkMsgIfExist, msgId:%d, msg.getMsgId:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(localbv.field_msgId) });
    if (localbv.field_msgId != 0L)
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
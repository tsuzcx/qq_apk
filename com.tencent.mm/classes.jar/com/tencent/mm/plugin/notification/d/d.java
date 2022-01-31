package com.tencent.mm.plugin.notification.d;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.notification.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;

public final class d
  extends com.tencent.mm.plugin.notification.c.a<bi>
{
  private com.tencent.mm.sdk.b.c pjb;
  private com.tencent.mm.sdk.b.c pjc;
  
  public d()
  {
    AppMethodBeat.i(23136);
    this.pjb = new d.1(this);
    this.pjc = new d.2(this);
    AppMethodBeat.o(23136);
  }
  
  public final String AS(int paramInt)
  {
    AppMethodBeat.i(23144);
    String str = getContext().getString(2131301895, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(23144);
    return str;
  }
  
  public final void M(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(23143);
    aw.aaz();
    com.tencent.mm.model.c.YC().J(paramArrayList);
    AppMethodBeat.o(23143);
  }
  
  public final String ae(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(23146);
    String str = getContext().getString(2131301952, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(23146);
    return str;
  }
  
  public final void bYd()
  {
    AppMethodBeat.i(23142);
    ab.i("MicroMsg.SendNormalMsgFailNotificaiton", "onNotificationClick, mMsgList.size:%d", new Object[] { Integer.valueOf(this.piK.piV.size()) });
    if (!g.RJ().QU())
    {
      ab.w("MicroMsg.SendNormalMsgFailNotificaiton", "account not ready.");
      AppMethodBeat.o(23142);
      return;
    }
    Object localObject;
    if (this.piK.piV.size() > 1)
    {
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).addFlags(536870912);
      if (Build.VERSION.SDK_INT < 16) {
        ((Intent)localObject).putExtra("resend_fail_messages", true);
      }
      ((Intent)localObject).putExtra("From_fail_notify", true);
      ab.d("MicroMsg.SendNormalMsgFailNotificaiton", "startMainUI");
      com.tencent.mm.bq.d.f(this.mContext, "com.tencent.mm.ui.LauncherUI", (Intent)localObject);
      AppMethodBeat.o(23142);
      return;
    }
    if (this.piK.piV.size() == 1)
    {
      long l = this.piK.get(0);
      aw.aaz();
      localObject = com.tencent.mm.model.c.YC().kB(l).field_talker;
      Intent localIntent = new Intent();
      localIntent.putExtra("Main_User", (String)localObject);
      localIntent.putExtra("From_fail_notify", true);
      localIntent.addFlags(67108864);
      localIntent.addFlags(536870912);
      if (Build.VERSION.SDK_INT < 16) {
        localIntent.putExtra("resend_fail_messages", true);
      }
      com.tencent.mm.bq.d.f(this.mContext, "com.tencent.mm.ui.LauncherUI", localIntent);
    }
    AppMethodBeat.o(23142);
  }
  
  public final void bYi()
  {
    AppMethodBeat.i(23137);
    com.tencent.mm.sdk.b.a.ymk.c(this.pjb);
    AppMethodBeat.o(23137);
  }
  
  public final void bYj()
  {
    AppMethodBeat.i(23138);
    com.tencent.mm.sdk.b.a.ymk.c(this.pjc);
    AppMethodBeat.o(23138);
  }
  
  public final void bYk()
  {
    AppMethodBeat.i(23140);
    com.tencent.mm.sdk.b.a.ymk.d(this.pjb);
    AppMethodBeat.o(23140);
  }
  
  public final void bYl()
  {
    AppMethodBeat.i(23141);
    com.tencent.mm.sdk.b.a.ymk.d(this.pjc);
    AppMethodBeat.o(23141);
  }
  
  public final String eU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(23145);
    String str = getContext().getString(2131301951, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(23145);
    return str;
  }
  
  public final String eV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(23147);
    if (paramInt2 <= 0)
    {
      str = getContext().getString(2131301949, new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(23147);
      return str;
    }
    String str = getContext().getString(2131301948, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(23147);
    return str;
  }
  
  public final int getType()
  {
    return 1;
  }
  
  public final void kM(long paramLong)
  {
    AppMethodBeat.i(23139);
    aw.aaz();
    al.d(new d.3(this, paramLong, com.tencent.mm.model.c.YC().kB(paramLong)));
    AppMethodBeat.o(23139);
  }
  
  public final boolean kN(long paramLong)
  {
    AppMethodBeat.i(23148);
    aw.aaz();
    bi localbi = com.tencent.mm.model.c.YC().kB(paramLong);
    ab.d("MicroMsg.SendNormalMsgFailNotificaiton", "checkMsgIfExist, msgId:%d, msg.getMsgId:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(localbi.field_msgId) });
    if (localbi.field_msgId != 0L)
    {
      AppMethodBeat.o(23148);
      return true;
    }
    AppMethodBeat.o(23148);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.notification.d;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.notification.c.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;

public final class d
  extends com.tencent.mm.plugin.notification.c.a<bi>
{
  private com.tencent.mm.sdk.b.c mIM = new d.1(this);
  private com.tencent.mm.sdk.b.c mIN = new d.2(this);
  
  protected final void K(ArrayList<Long> paramArrayList)
  {
    au.Hx();
    com.tencent.mm.model.c.Fy().H(paramArrayList);
  }
  
  protected final String T(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.mContext.getString(R.l.notification_resending_msg_with_fail, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
  }
  
  public final void bpC()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.mIM);
  }
  
  public final void bpD()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.mIN);
  }
  
  public final void bpE()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.mIM);
  }
  
  public final void bpF()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.mIN);
  }
  
  protected final void bpx()
  {
    y.i("MicroMsg.SendNormalMsgFailNotificaiton", "onNotificationClick, mMsgList.size:%d", new Object[] { Integer.valueOf(this.mIu.mIG.size()) });
    if (!com.tencent.mm.kernel.g.DN().Dc()) {
      y.w("MicroMsg.SendNormalMsgFailNotificaiton", "account not ready.");
    }
    do
    {
      return;
      if (this.mIu.mIG.size() > 1)
      {
        localObject = new Intent();
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).addFlags(536870912);
        if (Build.VERSION.SDK_INT < 16) {
          ((Intent)localObject).putExtra("resend_fail_messages", true);
        }
        ((Intent)localObject).putExtra("From_fail_notify", true);
        y.d("MicroMsg.SendNormalMsgFailNotificaiton", "startMainUI");
        com.tencent.mm.br.d.e(this.mContext, "com.tencent.mm.ui.LauncherUI", (Intent)localObject);
        return;
      }
    } while (this.mIu.mIG.size() != 1);
    long l = this.mIu.get(0);
    au.Hx();
    Object localObject = com.tencent.mm.model.c.Fy().fd(l).field_talker;
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
  
  protected final String du(int paramInt1, int paramInt2)
  {
    return this.mContext.getString(R.l.notification_resending_msg, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
  }
  
  protected final String dv(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0) {
      return this.mContext.getString(R.l.notification_resend_finish_msg_without_fail, new Object[] { Integer.valueOf(paramInt1) });
    }
    return this.mContext.getString(R.l.notification_resend_finish_msg, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public final void fo(long paramLong)
  {
    au.Hx();
    ai.d(new d.3(this, paramLong, com.tencent.mm.model.c.Fy().fd(paramLong)));
  }
  
  public final boolean fp(long paramLong)
  {
    au.Hx();
    bi localbi = com.tencent.mm.model.c.Fy().fd(paramLong);
    y.d("MicroMsg.SendNormalMsgFailNotificaiton", "checkMsgIfExist, msgId:%d, msg.getMsgId:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(localbi.field_msgId) });
    return localbi.field_msgId != 0L;
  }
  
  protected final int getType()
  {
    return 1;
  }
  
  protected final String vu(int paramInt)
  {
    return this.mContext.getString(R.l.notificaiton_notify_fail_msg, new Object[] { Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.d
 * JD-Core Version:    0.7.0.1
 */
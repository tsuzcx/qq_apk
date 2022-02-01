package com.tencent.mm.plugin.notification.model;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.vb;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.notification.base.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.cc;
import java.util.ArrayList;

public final class d
  extends a<cc>
{
  private IListener MwB;
  private IListener MwC;
  
  public d()
  {
    AppMethodBeat.i(26759);
    this.MwB = new SendNormalMsgFailNotificaiton.1(this, f.hfK);
    this.MwC = new SendNormalMsgFailNotificaiton.2(this, f.hfK);
    AppMethodBeat.o(26759);
  }
  
  public final String aX(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(26769);
    String str = getContext().getString(R.l.gPQ, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(26769);
    return str;
  }
  
  public final String aeX(int paramInt)
  {
    AppMethodBeat.i(26767);
    String str = getContext().getString(R.l.gPk, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(26767);
    return str;
  }
  
  public final void bl(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(26766);
    h.baF();
    if (h.baC().aZN())
    {
      bh.bCz();
      com.tencent.mm.model.c.bzD().aY(paramArrayList);
      AppMethodBeat.o(26766);
      return;
    }
    Log.e("MicroMsg.SendNormalMsgFailNotificaiton", "omitAllFailMsgImpl account no initialized");
    AppMethodBeat.o(26766);
  }
  
  public final int getType()
  {
    return 1;
  }
  
  public final void guG()
  {
    AppMethodBeat.i(26765);
    Log.i("MicroMsg.SendNormalMsgFailNotificaiton", "onNotificationClick, mMsgList.size:%d", new Object[] { Integer.valueOf(this.Mwj.Mwu.size()) });
    if (!h.baC().aZN())
    {
      Log.w("MicroMsg.SendNormalMsgFailNotificaiton", "account not ready.");
      AppMethodBeat.o(26765);
      return;
    }
    Object localObject;
    if (this.Mwj.Mwu.size() > 1)
    {
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).addFlags(536870912);
      if (Build.VERSION.SDK_INT < 16) {
        ((Intent)localObject).putExtra("resend_fail_messages", true);
      }
      ((Intent)localObject).putExtra("From_fail_notify", true);
      Log.d("MicroMsg.SendNormalMsgFailNotificaiton", "startMainUI");
      com.tencent.mm.br.c.g(this.mContext, "com.tencent.mm.ui.LauncherUI", (Intent)localObject);
      AppMethodBeat.o(26765);
      return;
    }
    if (this.Mwj.Mwu.size() == 1)
    {
      long l = this.Mwj.get(0);
      bh.bCz();
      localObject = com.tencent.mm.model.c.bzD().sl(l).field_talker;
      Intent localIntent = new Intent();
      localIntent.putExtra("Main_User", (String)localObject);
      localIntent.putExtra("From_fail_notify", true);
      localIntent.addFlags(67108864);
      localIntent.addFlags(536870912);
      if (Build.VERSION.SDK_INT < 16) {
        localIntent.putExtra("resend_fail_messages", true);
      }
      com.tencent.mm.br.c.g(this.mContext, "com.tencent.mm.ui.LauncherUI", localIntent);
    }
    AppMethodBeat.o(26765);
  }
  
  public final void guL()
  {
    AppMethodBeat.i(26760);
    this.MwB.alive();
    AppMethodBeat.o(26760);
  }
  
  public final void guM()
  {
    AppMethodBeat.i(26761);
    this.MwC.alive();
    AppMethodBeat.o(26761);
  }
  
  public final void guN()
  {
    AppMethodBeat.i(26763);
    this.MwB.dead();
    AppMethodBeat.o(26763);
  }
  
  public final void guO()
  {
    AppMethodBeat.i(26764);
    this.MwC.dead();
    AppMethodBeat.o(26764);
  }
  
  public final String km(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26768);
    String str = getContext().getString(R.l.gPP, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(26768);
    return str;
  }
  
  public final String kn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26770);
    if (paramInt2 <= 0)
    {
      str = getContext().getString(R.l.gPN, new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(26770);
      return str;
    }
    String str = getContext().getString(R.l.gPM, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(26770);
    return str;
  }
  
  public final void sX(final long paramLong)
  {
    AppMethodBeat.i(26762);
    bh.bCz();
    cc localcc = com.tencent.mm.model.c.bzD().sl(paramLong);
    if (localcc != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(26758);
          Log.d("MicroMsg.SendNormalMsgFailNotificaiton", "resend msgId:%d", new Object[] { Long.valueOf(paramLong) });
          vb localvb = new vb();
          localvb.hYQ.hzO = this.oiL;
          localvb.publish();
          AppMethodBeat.o(26758);
        }
      });
    }
    AppMethodBeat.o(26762);
  }
  
  public final boolean sY(long paramLong)
  {
    AppMethodBeat.i(26771);
    bh.bCz();
    cc localcc = com.tencent.mm.model.c.bzD().sl(paramLong);
    Log.d("MicroMsg.SendNormalMsgFailNotificaiton", "checkMsgIfExist, msgId:%d, msg.getMsgId:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(localcc.field_msgId) });
    if (localcc.field_msgId != 0L)
    {
      AppMethodBeat.o(26771);
      return true;
    }
    AppMethodBeat.o(26771);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.model.d
 * JD-Core Version:    0.7.0.1
 */
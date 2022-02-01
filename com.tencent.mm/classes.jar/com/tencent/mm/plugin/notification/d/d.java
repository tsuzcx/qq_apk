package com.tencent.mm.plugin.notification.d;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.g.a.tx;
import com.tencent.mm.g.a.tx.a;
import com.tencent.mm.g.a.tz;
import com.tencent.mm.g.a.tz.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.notification.c.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;

public final class d
  extends com.tencent.mm.plugin.notification.c.a<ca>
{
  private IListener AHi;
  private IListener AHj;
  
  public d()
  {
    AppMethodBeat.i(26759);
    this.AHi = new IListener() {};
    this.AHj = new IListener() {};
    AppMethodBeat.o(26759);
  }
  
  public final void HA(final long paramLong)
  {
    AppMethodBeat.i(26762);
    bg.aVF();
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26758);
        Log.d("MicroMsg.SendNormalMsgFailNotificaiton", "resend msgId:%d", new Object[] { Long.valueOf(paramLong) });
        sl localsl = new sl();
        localsl.dYZ.dCM = this.iBF;
        EventCenter.instance.publish(localsl);
        AppMethodBeat.o(26758);
      }
    });
    AppMethodBeat.o(26762);
  }
  
  public final boolean HB(long paramLong)
  {
    AppMethodBeat.i(26771);
    bg.aVF();
    ca localca = com.tencent.mm.model.c.aSQ().Hb(paramLong);
    Log.d("MicroMsg.SendNormalMsgFailNotificaiton", "checkMsgIfExist, msgId:%d, msg.getMsgId:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(localca.field_msgId) });
    if (localca.field_msgId != 0L)
    {
      AppMethodBeat.o(26771);
      return true;
    }
    AppMethodBeat.o(26771);
    return false;
  }
  
  public final String TR(int paramInt)
  {
    AppMethodBeat.i(26767);
    String str = getContext().getString(2131763625, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(26767);
    return str;
  }
  
  public final void aH(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(26766);
    g.aAi();
    if (g.aAf().azp())
    {
      bg.aVF();
      com.tencent.mm.model.c.aSQ().ay(paramArrayList);
      AppMethodBeat.o(26766);
      return;
    }
    Log.e("MicroMsg.SendNormalMsgFailNotificaiton", "omitAllFailMsgImpl account no initialized");
    AppMethodBeat.o(26766);
  }
  
  public final String av(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(26769);
    String str = getContext().getString(2131763682, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(26769);
    return str;
  }
  
  public final void eyK()
  {
    AppMethodBeat.i(26765);
    Log.i("MicroMsg.SendNormalMsgFailNotificaiton", "onNotificationClick, mMsgList.size:%d", new Object[] { Integer.valueOf(this.AGQ.AHb.size()) });
    if (!g.aAf().azp())
    {
      Log.w("MicroMsg.SendNormalMsgFailNotificaiton", "account not ready.");
      AppMethodBeat.o(26765);
      return;
    }
    Object localObject;
    if (this.AGQ.AHb.size() > 1)
    {
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).addFlags(536870912);
      if (Build.VERSION.SDK_INT < 16) {
        ((Intent)localObject).putExtra("resend_fail_messages", true);
      }
      ((Intent)localObject).putExtra("From_fail_notify", true);
      Log.d("MicroMsg.SendNormalMsgFailNotificaiton", "startMainUI");
      com.tencent.mm.br.c.f(this.mContext, "com.tencent.mm.ui.LauncherUI", (Intent)localObject);
      AppMethodBeat.o(26765);
      return;
    }
    if (this.AGQ.AHb.size() == 1)
    {
      long l = this.AGQ.get(0);
      bg.aVF();
      localObject = com.tencent.mm.model.c.aSQ().Hb(l).field_talker;
      Intent localIntent = new Intent();
      localIntent.putExtra("Main_User", (String)localObject);
      localIntent.putExtra("From_fail_notify", true);
      localIntent.addFlags(67108864);
      localIntent.addFlags(536870912);
      if (Build.VERSION.SDK_INT < 16) {
        localIntent.putExtra("resend_fail_messages", true);
      }
      com.tencent.mm.br.c.f(this.mContext, "com.tencent.mm.ui.LauncherUI", localIntent);
    }
    AppMethodBeat.o(26765);
  }
  
  public final void eyP()
  {
    AppMethodBeat.i(26760);
    EventCenter.instance.addListener(this.AHi);
    AppMethodBeat.o(26760);
  }
  
  public final void eyQ()
  {
    AppMethodBeat.i(26761);
    EventCenter.instance.addListener(this.AHj);
    AppMethodBeat.o(26761);
  }
  
  public final void eyR()
  {
    AppMethodBeat.i(26763);
    EventCenter.instance.removeListener(this.AHi);
    AppMethodBeat.o(26763);
  }
  
  public final void eyS()
  {
    AppMethodBeat.i(26764);
    EventCenter.instance.removeListener(this.AHj);
    AppMethodBeat.o(26764);
  }
  
  public final int getType()
  {
    return 1;
  }
  
  public final String hB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26768);
    String str = getContext().getString(2131763681, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(26768);
    return str;
  }
  
  public final String hC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26770);
    if (paramInt2 <= 0)
    {
      str = getContext().getString(2131763679, new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(26770);
      return str;
    }
    String str = getContext().getString(2131763678, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(26770);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.d
 * JD-Core Version:    0.7.0.1
 */
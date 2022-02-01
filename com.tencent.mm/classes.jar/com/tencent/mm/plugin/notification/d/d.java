package com.tencent.mm.plugin.notification.d;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.tm;
import com.tencent.mm.f.a.va;
import com.tencent.mm.f.a.va.a;
import com.tencent.mm.f.a.vc;
import com.tencent.mm.f.a.vc.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.notification.c.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;

public final class d
  extends a<ca>
{
  private IListener GAr;
  private IListener GAs;
  
  public d()
  {
    AppMethodBeat.i(26759);
    this.GAr = new IListener() {};
    this.GAs = new IListener() {};
    AppMethodBeat.o(26759);
  }
  
  public final void OU(final long paramLong)
  {
    AppMethodBeat.i(26762);
    bh.beI();
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26758);
        Log.d("MicroMsg.SendNormalMsgFailNotificaiton", "resend msgId:%d", new Object[] { Long.valueOf(paramLong) });
        tm localtm = new tm();
        localtm.fSS.fvt = this.lrk;
        EventCenter.instance.publish(localtm);
        AppMethodBeat.o(26758);
      }
    });
    AppMethodBeat.o(26762);
  }
  
  public final boolean OV(long paramLong)
  {
    AppMethodBeat.i(26771);
    bh.beI();
    ca localca = com.tencent.mm.model.c.bbO().Oq(paramLong);
    Log.d("MicroMsg.SendNormalMsgFailNotificaiton", "checkMsgIfExist, msgId:%d, msg.getMsgId:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(localca.field_msgId) });
    if (localca.field_msgId != 0L)
    {
      AppMethodBeat.o(26771);
      return true;
    }
    AppMethodBeat.o(26771);
    return false;
  }
  
  public final void aP(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(26766);
    h.aHH();
    if (h.aHE().aGM())
    {
      bh.beI();
      com.tencent.mm.model.c.bbO().aF(paramArrayList);
      AppMethodBeat.o(26766);
      return;
    }
    Log.e("MicroMsg.SendNormalMsgFailNotificaiton", "omitAllFailMsgImpl account no initialized");
    AppMethodBeat.o(26766);
  }
  
  public final String aaE(int paramInt)
  {
    AppMethodBeat.i(26767);
    String str = getContext().getString(R.l.eMX, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(26767);
    return str;
  }
  
  public final String az(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(26769);
    String str = getContext().getString(R.l.eNC, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(26769);
    return str;
  }
  
  public final void fkp()
  {
    AppMethodBeat.i(26765);
    Log.i("MicroMsg.SendNormalMsgFailNotificaiton", "onNotificationClick, mMsgList.size:%d", new Object[] { Integer.valueOf(this.GzZ.GAk.size()) });
    if (!h.aHE().aGM())
    {
      Log.w("MicroMsg.SendNormalMsgFailNotificaiton", "account not ready.");
      AppMethodBeat.o(26765);
      return;
    }
    Object localObject;
    if (this.GzZ.GAk.size() > 1)
    {
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).addFlags(536870912);
      if (Build.VERSION.SDK_INT < 16) {
        ((Intent)localObject).putExtra("resend_fail_messages", true);
      }
      ((Intent)localObject).putExtra("From_fail_notify", true);
      Log.d("MicroMsg.SendNormalMsgFailNotificaiton", "startMainUI");
      com.tencent.mm.by.c.f(this.mContext, "com.tencent.mm.ui.LauncherUI", (Intent)localObject);
      AppMethodBeat.o(26765);
      return;
    }
    if (this.GzZ.GAk.size() == 1)
    {
      long l = this.GzZ.get(0);
      bh.beI();
      localObject = com.tencent.mm.model.c.bbO().Oq(l).field_talker;
      Intent localIntent = new Intent();
      localIntent.putExtra("Main_User", (String)localObject);
      localIntent.putExtra("From_fail_notify", true);
      localIntent.addFlags(67108864);
      localIntent.addFlags(536870912);
      if (Build.VERSION.SDK_INT < 16) {
        localIntent.putExtra("resend_fail_messages", true);
      }
      com.tencent.mm.by.c.f(this.mContext, "com.tencent.mm.ui.LauncherUI", localIntent);
    }
    AppMethodBeat.o(26765);
  }
  
  public final void fku()
  {
    AppMethodBeat.i(26760);
    EventCenter.instance.addListener(this.GAr);
    AppMethodBeat.o(26760);
  }
  
  public final void fkv()
  {
    AppMethodBeat.i(26761);
    EventCenter.instance.addListener(this.GAs);
    AppMethodBeat.o(26761);
  }
  
  public final void fkw()
  {
    AppMethodBeat.i(26763);
    EventCenter.instance.removeListener(this.GAr);
    AppMethodBeat.o(26763);
  }
  
  public final void fkx()
  {
    AppMethodBeat.i(26764);
    EventCenter.instance.removeListener(this.GAs);
    AppMethodBeat.o(26764);
  }
  
  public final int getType()
  {
    return 1;
  }
  
  public final String iG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26768);
    String str = getContext().getString(R.l.eNB, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(26768);
    return str;
  }
  
  public final String iH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26770);
    if (paramInt2 <= 0)
    {
      str = getContext().getString(R.l.eNz, new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(26770);
      return str;
    }
    String str = getContext().getString(R.l.eNy, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(26770);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.d
 * JD-Core Version:    0.7.0.1
 */
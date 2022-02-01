package com.tencent.mm.plugin.talkroom.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.d;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;

public final class c
  implements d
{
  private Notification jyo;
  private ao mHandler;
  public boolean uaQ;
  public String uao;
  public boolean zVN;
  private String zVO;
  
  public c()
  {
    AppMethodBeat.i(29452);
    this.uao = "";
    this.uaQ = false;
    this.zVN = false;
    this.mHandler = new ao(Looper.getMainLooper());
    AppMethodBeat.o(29452);
  }
  
  private static boolean ebq()
  {
    AppMethodBeat.i(29448);
    if (bs.isNullOrNil(b.ebm().zWB))
    {
      ac.w("MicroMsg.TalkRoomDisplayMgr", "yy checkServer null");
      ac.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
      ebt();
      AppMethodBeat.o(29448);
      return false;
    }
    AppMethodBeat.o(29448);
    return true;
  }
  
  private void ebs()
  {
    AppMethodBeat.i(29454);
    if (!ebq())
    {
      AppMethodBeat.o(29454);
      return;
    }
    if (this.jyo == null)
    {
      ac.e("MicroMsg.TalkRoomDisplayMgr", "yy updateNotify error no notification");
      AppMethodBeat.o(29454);
      return;
    }
    String str = h.bg(ai.getContext(), b.ebm().zWB);
    if (b.ebm().zWP) {}
    for (Object localObject1 = ai.getContext().getString(2131764360);; localObject1 = ai.getContext().getString(2131764357, new Object[] { Integer.valueOf(b.ebm().cXc().size()) }))
    {
      Object localObject2 = com.tencent.mm.plugin.talkroom.a.iyy.Ln();
      ((Intent)localObject2).putExtra("enter_chat_usrname", b.ebm().zWB);
      localObject2 = PendingIntent.getActivity(ai.getContext(), 100, (Intent)localObject2, 268435456);
      localObject1 = com.tencent.mm.bq.a.bE(ai.getContext(), "reminder_channel_id").i(this.zVO).i(0L).f(str).g((CharSequence)localObject1);
      ((s.c)localObject1).Fu = ((PendingIntent)localObject2);
      this.jyo = ((s.c)localObject1).build();
      this.jyo.icon = 2131234321;
      this.jyo.flags = 32;
      az.getNotification().a(100, this.jyo, false);
      AppMethodBeat.o(29454);
      return;
    }
  }
  
  public static void ebt()
  {
    AppMethodBeat.i(29455);
    ac.v("MicroMsg.TalkRoomDisplayMgr", "yy cancelNotify");
    az.getNotification().cancel(100);
    AppMethodBeat.o(29455);
  }
  
  public final void DD(String paramString)
  {
    this.uao = paramString;
  }
  
  public final void aIR()
  {
    this.uaQ = false;
  }
  
  public final void aIS() {}
  
  public final void aIT()
  {
    AppMethodBeat.i(29450);
    ac.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
    ebt();
    AppMethodBeat.o(29450);
  }
  
  public final void aIU() {}
  
  public final void aIV() {}
  
  public final void aIW() {}
  
  public final void axB(String paramString)
  {
    AppMethodBeat.i(29453);
    if (!ebq())
    {
      AppMethodBeat.o(29453);
      return;
    }
    ac.v("MicroMsg.TalkRoomDisplayMgr", "yy showNotify: ".concat(String.valueOf(paramString)));
    this.zVO = paramString;
    this.jyo = com.tencent.mm.bq.a.bE(ai.getContext(), "reminder_channel_id").i(paramString).i(0L).build();
    this.jyo.icon = 2131234321;
    this.jyo.flags = 32;
    ebs();
    AppMethodBeat.o(29453);
  }
  
  public final void bv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(29449);
    if (this.zVN)
    {
      AppMethodBeat.o(29449);
      return;
    }
    ebs();
    AppMethodBeat.o(29449);
  }
  
  public final void ebr()
  {
    AppMethodBeat.i(29451);
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29447);
        b.ebl();
        ac.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        b.ebl();
        c.ebt();
        AppMethodBeat.o(29447);
      }
    });
    AppMethodBeat.o(29451);
  }
  
  public final void j(int paramInt1, int paramInt2, String paramString) {}
  
  public final void pF(int paramInt) {}
  
  public final void q(String paramString, int paramInt1, int paramInt2)
  {
    this.uaQ = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.c
 * JD-Core Version:    0.7.0.1
 */
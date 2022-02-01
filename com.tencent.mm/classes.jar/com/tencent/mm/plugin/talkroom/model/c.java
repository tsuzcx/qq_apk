package com.tencent.mm.plugin.talkroom.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.ba;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public final class c
  implements d
{
  public boolean Bnr;
  private String Bns;
  private Notification jSl;
  private ap mHandler;
  public String vcX;
  public boolean vdz;
  
  public c()
  {
    AppMethodBeat.i(29452);
    this.vcX = "";
    this.vdz = false;
    this.Bnr = false;
    this.mHandler = new ap(Looper.getMainLooper());
    AppMethodBeat.o(29452);
  }
  
  private static boolean enH()
  {
    AppMethodBeat.i(29448);
    if (bt.isNullOrNil(b.enD().Bof))
    {
      ad.w("MicroMsg.TalkRoomDisplayMgr", "yy checkServer null");
      ad.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
      enK();
      AppMethodBeat.o(29448);
      return false;
    }
    AppMethodBeat.o(29448);
    return true;
  }
  
  private void enJ()
  {
    AppMethodBeat.i(29454);
    if (!enH())
    {
      AppMethodBeat.o(29454);
      return;
    }
    if (this.jSl == null)
    {
      ad.e("MicroMsg.TalkRoomDisplayMgr", "yy updateNotify error no notification");
      AppMethodBeat.o(29454);
      return;
    }
    String str = h.bj(aj.getContext(), b.enD().Bof);
    if (b.enD().Bot) {}
    for (Object localObject1 = aj.getContext().getString(2131764360);; localObject1 = aj.getContext().getString(2131764357, new Object[] { Integer.valueOf(b.enD().dgo().size()) }))
    {
      Object localObject2 = com.tencent.mm.plugin.talkroom.a.iRH.MV();
      ((Intent)localObject2).putExtra("enter_chat_usrname", b.enD().Bof);
      localObject2 = PendingIntent.getActivity(aj.getContext(), 100, (Intent)localObject2, 268435456);
      localObject1 = com.tencent.mm.br.a.bI(aj.getContext(), "reminder_channel_id").i(this.Bns).i(0L).f(str).g((CharSequence)localObject1);
      ((s.c)localObject1).Hl = ((PendingIntent)localObject2);
      this.jSl = ((s.c)localObject1).build();
      this.jSl.icon = 2131234321;
      this.jSl.flags = 32;
      ba.getNotification().a(100, this.jSl, false);
      AppMethodBeat.o(29454);
      return;
    }
  }
  
  public static void enK()
  {
    AppMethodBeat.i(29455);
    ad.v("MicroMsg.TalkRoomDisplayMgr", "yy cancelNotify");
    ba.getNotification().cancel(100);
    AppMethodBeat.o(29455);
  }
  
  public final void GI(String paramString)
  {
    this.vcX = paramString;
  }
  
  public final void aCF(String paramString)
  {
    AppMethodBeat.i(29453);
    if (!enH())
    {
      AppMethodBeat.o(29453);
      return;
    }
    ad.v("MicroMsg.TalkRoomDisplayMgr", "yy showNotify: ".concat(String.valueOf(paramString)));
    this.Bns = paramString;
    this.jSl = com.tencent.mm.br.a.bI(aj.getContext(), "reminder_channel_id").i(paramString).i(0L).build();
    this.jSl.icon = 2131234321;
    this.jSl.flags = 32;
    enJ();
    AppMethodBeat.o(29453);
  }
  
  public final void aMb()
  {
    this.vdz = false;
  }
  
  public final void aMc() {}
  
  public final void aMd()
  {
    AppMethodBeat.i(29450);
    ad.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
    enK();
    AppMethodBeat.o(29450);
  }
  
  public final void aMe() {}
  
  public final void aMf() {}
  
  public final void aMg() {}
  
  public final void bw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(29449);
    if (this.Bnr)
    {
      AppMethodBeat.o(29449);
      return;
    }
    enJ();
    AppMethodBeat.o(29449);
  }
  
  public final void enI()
  {
    AppMethodBeat.i(29451);
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29447);
        b.enC();
        ad.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        b.enC();
        c.enK();
        AppMethodBeat.o(29447);
      }
    });
    AppMethodBeat.o(29451);
  }
  
  public final void j(int paramInt1, int paramInt2, String paramString) {}
  
  public final void qh(int paramInt) {}
  
  public final void s(String paramString, int paramInt1, int paramInt2)
  {
    this.vdz = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.c
 * JD-Core Version:    0.7.0.1
 */
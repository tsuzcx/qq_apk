package com.tencent.mm.plugin.talkroom.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public final class c
  implements d
{
  private Notification iXX;
  private ap mHandler;
  public boolean sSE;
  public String sSb;
  public boolean yIA;
  private String yIB;
  
  public c()
  {
    AppMethodBeat.i(29452);
    this.sSb = "";
    this.sSE = false;
    this.yIA = false;
    this.mHandler = new ap(Looper.getMainLooper());
    AppMethodBeat.o(29452);
  }
  
  private static boolean dMQ()
  {
    AppMethodBeat.i(29448);
    if (bt.isNullOrNil(b.dMM().yJo))
    {
      ad.w("MicroMsg.TalkRoomDisplayMgr", "yy checkServer null");
      ad.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
      dMT();
      AppMethodBeat.o(29448);
      return false;
    }
    AppMethodBeat.o(29448);
    return true;
  }
  
  private void dMS()
  {
    AppMethodBeat.i(29454);
    if (!dMQ())
    {
      AppMethodBeat.o(29454);
      return;
    }
    if (this.iXX == null)
    {
      ad.e("MicroMsg.TalkRoomDisplayMgr", "yy updateNotify error no notification");
      AppMethodBeat.o(29454);
      return;
    }
    String str = h.bf(aj.getContext(), b.dMM().yJo);
    if (b.dMM().yJC) {}
    for (Object localObject1 = aj.getContext().getString(2131764360);; localObject1 = aj.getContext().getString(2131764357, new Object[] { Integer.valueOf(b.dMM().cJx().size()) }))
    {
      Object localObject2 = com.tencent.mm.plugin.talkroom.a.hYu.Lp();
      ((Intent)localObject2).putExtra("enter_chat_usrname", b.dMM().yJo);
      localObject2 = PendingIntent.getActivity(aj.getContext(), 100, (Intent)localObject2, 268435456);
      localObject1 = com.tencent.mm.br.a.bD(aj.getContext(), "reminder_channel_id").i(this.yIB).g(0L).f(str).g((CharSequence)localObject1);
      ((s.c)localObject1).Ew = ((PendingIntent)localObject2);
      this.iXX = ((s.c)localObject1).build();
      this.iXX.icon = 2131234321;
      this.iXX.flags = 32;
      az.getNotification().a(100, this.iXX, false);
      AppMethodBeat.o(29454);
      return;
    }
  }
  
  public static void dMT()
  {
    AppMethodBeat.i(29455);
    ad.v("MicroMsg.TalkRoomDisplayMgr", "yy cancelNotify");
    az.getNotification().cancel(100);
    AppMethodBeat.o(29455);
  }
  
  public final void aCb()
  {
    this.sSE = false;
  }
  
  public final void aCc() {}
  
  public final void aCd()
  {
    AppMethodBeat.i(29450);
    ad.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
    dMT();
    AppMethodBeat.o(29450);
  }
  
  public final void aCe() {}
  
  public final void aCf() {}
  
  public final void aCg() {}
  
  public final void ass(String paramString)
  {
    AppMethodBeat.i(29453);
    if (!dMQ())
    {
      AppMethodBeat.o(29453);
      return;
    }
    ad.v("MicroMsg.TalkRoomDisplayMgr", "yy showNotify: ".concat(String.valueOf(paramString)));
    this.yIB = paramString;
    this.iXX = com.tencent.mm.br.a.bD(aj.getContext(), "reminder_channel_id").i(paramString).g(0L).build();
    this.iXX.icon = 2131234321;
    this.iXX.flags = 32;
    dMS();
    AppMethodBeat.o(29453);
  }
  
  public final void bn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(29449);
    if (this.yIA)
    {
      AppMethodBeat.o(29449);
      return;
    }
    dMS();
    AppMethodBeat.o(29449);
  }
  
  public final void dMR()
  {
    AppMethodBeat.i(29451);
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29447);
        b.dML();
        ad.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        b.dML();
        c.dMT();
        AppMethodBeat.o(29447);
      }
    });
    AppMethodBeat.o(29451);
  }
  
  public final void j(int paramInt1, int paramInt2, String paramString) {}
  
  public final void oQ(int paramInt) {}
  
  public final void r(String paramString, int paramInt1, int paramInt2)
  {
    this.sSE = false;
  }
  
  public final void zy(String paramString)
  {
    this.sSb = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.c
 * JD-Core Version:    0.7.0.1
 */
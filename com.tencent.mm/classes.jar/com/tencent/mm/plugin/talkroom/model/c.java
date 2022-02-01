package com.tencent.mm.plugin.talkroom.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.d;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bc;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;

public final class c
  implements d
{
  public boolean BEQ;
  private String BER;
  private Notification jVC;
  private aq mHandler;
  public boolean vpK;
  public String vpi;
  
  public c()
  {
    AppMethodBeat.i(29452);
    this.vpi = "";
    this.vpK = false;
    this.BEQ = false;
    this.mHandler = new aq(Looper.getMainLooper());
    AppMethodBeat.o(29452);
  }
  
  private static boolean ero()
  {
    AppMethodBeat.i(29448);
    if (bu.isNullOrNil(b.erk().BFE))
    {
      ae.w("MicroMsg.TalkRoomDisplayMgr", "yy checkServer null");
      ae.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
      err();
      AppMethodBeat.o(29448);
      return false;
    }
    AppMethodBeat.o(29448);
    return true;
  }
  
  private void erq()
  {
    AppMethodBeat.i(29454);
    if (!ero())
    {
      AppMethodBeat.o(29454);
      return;
    }
    if (this.jVC == null)
    {
      ae.e("MicroMsg.TalkRoomDisplayMgr", "yy updateNotify error no notification");
      AppMethodBeat.o(29454);
      return;
    }
    String str = h.bl(ak.getContext(), b.erk().BFE);
    if (b.erk().BFS) {}
    for (Object localObject1 = ak.getContext().getString(2131764360);; localObject1 = ak.getContext().getString(2131764357, new Object[] { Integer.valueOf(b.erk().djn().size()) }))
    {
      Object localObject2 = com.tencent.mm.plugin.talkroom.a.iUA.MQ();
      ((Intent)localObject2).putExtra("enter_chat_usrname", b.erk().BFE);
      localObject2 = PendingIntent.getActivity(ak.getContext(), 100, (Intent)localObject2, 268435456);
      localObject1 = com.tencent.mm.bq.a.bJ(ak.getContext(), "reminder_channel_id").i(this.BER).i(0L).f(str).g((CharSequence)localObject1);
      ((s.c)localObject1).Hl = ((PendingIntent)localObject2);
      this.jVC = ((s.c)localObject1).build();
      this.jVC.icon = 2131234321;
      this.jVC.flags = 32;
      bc.getNotification().a(100, this.jVC, false);
      AppMethodBeat.o(29454);
      return;
    }
  }
  
  public static void err()
  {
    AppMethodBeat.i(29455);
    ae.v("MicroMsg.TalkRoomDisplayMgr", "yy cancelNotify");
    bc.getNotification().cancel(100);
    AppMethodBeat.o(29455);
  }
  
  public final void Hk(String paramString)
  {
    this.vpi = paramString;
  }
  
  public final void aDY(String paramString)
  {
    AppMethodBeat.i(29453);
    if (!ero())
    {
      AppMethodBeat.o(29453);
      return;
    }
    ae.v("MicroMsg.TalkRoomDisplayMgr", "yy showNotify: ".concat(String.valueOf(paramString)));
    this.BER = paramString;
    this.jVC = com.tencent.mm.bq.a.bJ(ak.getContext(), "reminder_channel_id").i(paramString).i(0L).build();
    this.jVC.icon = 2131234321;
    this.jVC.flags = 32;
    erq();
    AppMethodBeat.o(29453);
  }
  
  public final void aMA()
  {
    AppMethodBeat.i(29450);
    ae.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
    err();
    AppMethodBeat.o(29450);
  }
  
  public final void aMB() {}
  
  public final void aMC() {}
  
  public final void aMD() {}
  
  public final void aMy()
  {
    this.vpK = false;
  }
  
  public final void aMz() {}
  
  public final void bw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(29449);
    if (this.BEQ)
    {
      AppMethodBeat.o(29449);
      return;
    }
    erq();
    AppMethodBeat.o(29449);
  }
  
  public final void erp()
  {
    AppMethodBeat.i(29451);
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29447);
        b.erj();
        ae.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        b.erj();
        c.err();
        AppMethodBeat.o(29447);
      }
    });
    AppMethodBeat.o(29451);
  }
  
  public final void j(int paramInt1, int paramInt2, String paramString) {}
  
  public final void qk(int paramInt) {}
  
  public final void s(String paramString, int paramInt1, int paramInt2)
  {
    this.vpK = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.c
 * JD-Core Version:    0.7.0.1
 */
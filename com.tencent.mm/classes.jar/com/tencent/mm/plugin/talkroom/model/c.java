package com.tencent.mm.plugin.talkroom.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.bc.d;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class c
  implements d
{
  public String Kfz;
  public boolean Kgb;
  public boolean SNd;
  private String SNe;
  private MMHandler mHandler;
  private Notification qSv;
  
  public c()
  {
    AppMethodBeat.i(29452);
    this.Kfz = "";
    this.Kgb = false;
    this.SNd = false;
    this.mHandler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(29452);
  }
  
  private static boolean hCu()
  {
    AppMethodBeat.i(29448);
    if (Util.isNullOrNil(b.hCo().SNR))
    {
      Log.w("MicroMsg.TalkRoomDisplayMgr", "yy checkServer null");
      Log.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
      hCx();
      AppMethodBeat.o(29448);
      return false;
    }
    AppMethodBeat.o(29448);
    return true;
  }
  
  private void hCw()
  {
    AppMethodBeat.i(29454);
    if (!hCu())
    {
      AppMethodBeat.o(29454);
      return;
    }
    if (this.qSv == null)
    {
      Log.e("MicroMsg.TalkRoomDisplayMgr", "yy updateNotify error no notification");
      AppMethodBeat.o(29454);
      return;
    }
    String str = h.bU(MMApplicationContext.getContext(), b.hCo().SNR);
    if (b.hCo().GNB) {}
    for (Object localObject1 = MMApplicationContext.getContext().getString(R.l.gWT);; localObject1 = MMApplicationContext.getContext().getString(R.l.gWQ, new Object[] { Integer.valueOf(b.hCo().fUJ().size()) }))
    {
      Object localObject2 = com.tencent.mm.plugin.talkroom.a.pFo.aDB();
      ((Intent)localObject2).putExtra("enter_chat_usrname", b.hCo().SNR);
      localObject2 = PendingIntent.getActivity(MMApplicationContext.getContext(), 100, (Intent)localObject2, 268435456);
      localObject1 = com.tencent.mm.bq.a.cA(MMApplicationContext.getContext(), "reminder_channel_id").o(this.SNe).bt(0L).l(str).m((CharSequence)localObject1);
      ((f.d)localObject1).bor = ((PendingIntent)localObject2);
      this.qSv = ((f.d)localObject1).DA();
      this.qSv.icon = R.g.fpy;
      this.qSv.flags = 32;
      bh.getNotification().a(100, this.qSv, false);
      AppMethodBeat.o(29454);
      return;
    }
  }
  
  public static void hCx()
  {
    AppMethodBeat.i(29455);
    Log.v("MicroMsg.TalkRoomDisplayMgr", "yy cancelNotify");
    bh.getNotification().cancel(100);
    AppMethodBeat.o(29455);
  }
  
  public final void Pw(String paramString)
  {
    this.Kfz = paramString;
  }
  
  public final void bNv()
  {
    this.Kgb = false;
  }
  
  public final void bNw() {}
  
  public final void bNx()
  {
    AppMethodBeat.i(29450);
    Log.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
    hCx();
    AppMethodBeat.o(29450);
  }
  
  public final void bNy() {}
  
  public final void bNz() {}
  
  public final void bP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(29449);
    if (this.SNd)
    {
      AppMethodBeat.o(29449);
      return;
    }
    hCw();
    AppMethodBeat.o(29449);
  }
  
  public final void bdf(String paramString)
  {
    AppMethodBeat.i(29453);
    if (!hCu())
    {
      AppMethodBeat.o(29453);
      return;
    }
    Log.v("MicroMsg.TalkRoomDisplayMgr", "yy showNotify: ".concat(String.valueOf(paramString)));
    this.SNe = paramString;
    this.qSv = com.tencent.mm.bq.a.cA(MMApplicationContext.getContext(), "reminder_channel_id").o(paramString).bt(0L).DA();
    this.qSv.icon = R.g.fpy;
    this.qSv.flags = 32;
    hCw();
    AppMethodBeat.o(29453);
  }
  
  public final void hCv()
  {
    AppMethodBeat.i(29451);
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29447);
        b.hCs();
        Log.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        b.hCs();
        c.hCx();
        AppMethodBeat.o(29447);
      }
    });
    AppMethodBeat.o(29451);
  }
  
  public final void k(int paramInt1, int paramInt2, String paramString) {}
  
  public final void onReconnect() {}
  
  public final void w(String paramString, int paramInt1, int paramInt2)
  {
    this.Kgb = false;
  }
  
  public final void wZ(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.c
 * JD-Core Version:    0.7.0.1
 */
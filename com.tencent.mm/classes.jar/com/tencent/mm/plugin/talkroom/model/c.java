package com.tencent.mm.plugin.talkroom.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.d;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class c
  implements d
{
  public boolean FPH;
  private String FPI;
  private Notification kYy;
  private MMHandler mHandler;
  public String yIY;
  public boolean yJA;
  
  public c()
  {
    AppMethodBeat.i(29452);
    this.yIY = "";
    this.yJA = false;
    this.FPH = false;
    this.mHandler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(29452);
  }
  
  private static boolean ftR()
  {
    AppMethodBeat.i(29448);
    if (Util.isNullOrNil(b.ftN().FQv))
    {
      Log.w("MicroMsg.TalkRoomDisplayMgr", "yy checkServer null");
      Log.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
      ftU();
      AppMethodBeat.o(29448);
      return false;
    }
    AppMethodBeat.o(29448);
    return true;
  }
  
  private void ftT()
  {
    AppMethodBeat.i(29454);
    if (!ftR())
    {
      AppMethodBeat.o(29454);
      return;
    }
    if (this.kYy == null)
    {
      Log.e("MicroMsg.TalkRoomDisplayMgr", "yy updateNotify error no notification");
      AppMethodBeat.o(29454);
      return;
    }
    String str = h.bC(MMApplicationContext.getContext(), b.ftN().FQv);
    if (b.ftN().FQJ) {}
    for (Object localObject1 = MMApplicationContext.getContext().getString(2131766621);; localObject1 = MMApplicationContext.getContext().getString(2131766618, new Object[] { Integer.valueOf(b.ftN().ecY().size()) }))
    {
      Object localObject2 = com.tencent.mm.plugin.talkroom.a.jRu.Xd();
      ((Intent)localObject2).putExtra("enter_chat_usrname", b.ftN().FQv);
      localObject2 = PendingIntent.getActivity(MMApplicationContext.getContext(), 100, (Intent)localObject2, 268435456);
      localObject1 = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(this.FPI).i(0L).f(str).g((CharSequence)localObject1);
      ((s.c)localObject1).Hv = ((PendingIntent)localObject2);
      this.kYy = ((s.c)localObject1).build();
      this.kYy.icon = 2131235204;
      this.kYy.flags = 32;
      bg.getNotification().a(100, this.kYy, false);
      AppMethodBeat.o(29454);
      return;
    }
  }
  
  public static void ftU()
  {
    AppMethodBeat.i(29455);
    Log.v("MicroMsg.TalkRoomDisplayMgr", "yy cancelNotify");
    bg.getNotification().cancel(100);
    AppMethodBeat.o(29455);
  }
  
  public final void PX(String paramString)
  {
    this.yIY = paramString;
  }
  
  public final void aST(String paramString)
  {
    AppMethodBeat.i(29453);
    if (!ftR())
    {
      AppMethodBeat.o(29453);
      return;
    }
    Log.v("MicroMsg.TalkRoomDisplayMgr", "yy showNotify: ".concat(String.valueOf(paramString)));
    this.FPI = paramString;
    this.kYy = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(paramString).i(0L).build();
    this.kYy.icon = 2131235204;
    this.kYy.flags = 32;
    ftT();
    AppMethodBeat.o(29453);
  }
  
  public final void bA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(29449);
    if (this.FPH)
    {
      AppMethodBeat.o(29449);
      return;
    }
    ftT();
    AppMethodBeat.o(29449);
  }
  
  public final void bgA() {}
  
  public final void bgB()
  {
    AppMethodBeat.i(29450);
    Log.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
    ftU();
    AppMethodBeat.o(29450);
  }
  
  public final void bgC() {}
  
  public final void bgD() {}
  
  public final void bgE() {}
  
  public final void bgz()
  {
    this.yJA = false;
  }
  
  public final void ftS()
  {
    AppMethodBeat.i(29451);
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29447);
        b.ftM();
        Log.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        b.ftM();
        c.ftU();
        AppMethodBeat.o(29447);
      }
    });
    AppMethodBeat.o(29451);
  }
  
  public final void j(int paramInt1, int paramInt2, String paramString) {}
  
  public final void s(String paramString, int paramInt1, int paramInt2)
  {
    this.yJA = false;
  }
  
  public final void ua(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.c
 * JD-Core Version:    0.7.0.1
 */
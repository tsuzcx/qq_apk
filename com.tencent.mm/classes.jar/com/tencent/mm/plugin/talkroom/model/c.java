package com.tencent.mm.plugin.talkroom.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import androidx.core.app.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.bj.d;
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
  public String EmR;
  public boolean Ent;
  public boolean MjI;
  private String MjJ;
  private MMHandler mHandler;
  private Notification nSJ;
  
  public c()
  {
    AppMethodBeat.i(29452);
    this.EmR = "";
    this.Ent = false;
    this.MjI = false;
    this.mHandler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(29452);
  }
  
  private static boolean git()
  {
    AppMethodBeat.i(29448);
    if (Util.isNullOrNil(b.gin().Mkw))
    {
      Log.w("MicroMsg.TalkRoomDisplayMgr", "yy checkServer null");
      Log.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
      giw();
      AppMethodBeat.o(29448);
      return false;
    }
    AppMethodBeat.o(29448);
    return true;
  }
  
  private void giv()
  {
    AppMethodBeat.i(29454);
    if (!git())
    {
      AppMethodBeat.o(29454);
      return;
    }
    if (this.nSJ == null)
    {
      Log.e("MicroMsg.TalkRoomDisplayMgr", "yy updateNotify error no notification");
      AppMethodBeat.o(29454);
      return;
    }
    String str = h.bQ(MMApplicationContext.getContext(), b.gin().Mkw);
    if (b.gin().MkK) {}
    for (Object localObject1 = MMApplicationContext.getContext().getString(R.l.eTZ);; localObject1 = MMApplicationContext.getContext().getString(R.l.eTW, new Object[] { Integer.valueOf(b.gin().eMr().size()) }))
    {
      Object localObject2 = com.tencent.mm.plugin.talkroom.a.mIH.abG();
      ((Intent)localObject2).putExtra("enter_chat_usrname", b.gin().Mkw);
      localObject2 = PendingIntent.getActivity(MMApplicationContext.getContext(), 100, (Intent)localObject2, 268435456);
      localObject1 = com.tencent.mm.bx.a.cp(MMApplicationContext.getContext(), "reminder_channel_id").n(this.MjJ).e(0L).k(str).l((CharSequence)localObject1);
      ((e.d)localObject1).Ip = ((PendingIntent)localObject2);
      this.nSJ = ((e.d)localObject1).gr();
      this.nSJ.icon = R.g.dpj;
      this.nSJ.flags = 32;
      bh.getNotification().a(100, this.nSJ, false);
      AppMethodBeat.o(29454);
      return;
    }
  }
  
  public static void giw()
  {
    AppMethodBeat.i(29455);
    Log.v("MicroMsg.TalkRoomDisplayMgr", "yy cancelNotify");
    bh.getNotification().cancel(100);
    AppMethodBeat.o(29455);
  }
  
  public final void Xu(String paramString)
  {
    this.EmR = paramString;
  }
  
  public final void aFx() {}
  
  public final void bD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(29449);
    if (this.MjI)
    {
      AppMethodBeat.o(29449);
      return;
    }
    giv();
    AppMethodBeat.o(29449);
  }
  
  public final void bdX(String paramString)
  {
    AppMethodBeat.i(29453);
    if (!git())
    {
      AppMethodBeat.o(29453);
      return;
    }
    Log.v("MicroMsg.TalkRoomDisplayMgr", "yy showNotify: ".concat(String.valueOf(paramString)));
    this.MjJ = paramString;
    this.nSJ = com.tencent.mm.bx.a.cp(MMApplicationContext.getContext(), "reminder_channel_id").n(paramString).e(0L).gr();
    this.nSJ.icon = R.g.dpj;
    this.nSJ.flags = 32;
    giv();
    AppMethodBeat.o(29453);
  }
  
  public final void bpP()
  {
    this.Ent = false;
  }
  
  public final void bpQ() {}
  
  public final void bpR()
  {
    AppMethodBeat.i(29450);
    Log.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
    giw();
    AppMethodBeat.o(29450);
  }
  
  public final void bpS() {}
  
  public final void bpT() {}
  
  public final void giu()
  {
    AppMethodBeat.i(29451);
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29447);
        b.gir();
        Log.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        b.gir();
        c.giw();
        AppMethodBeat.o(29447);
      }
    });
    AppMethodBeat.o(29451);
  }
  
  public final void j(int paramInt1, int paramInt2, String paramString) {}
  
  public final void t(String paramString, int paramInt1, int paramInt2)
  {
    this.Ent = false;
  }
  
  public final void wZ(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.c
 * JD-Core Version:    0.7.0.1
 */
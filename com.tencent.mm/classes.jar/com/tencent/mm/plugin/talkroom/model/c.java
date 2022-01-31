package com.tencent.mm.plugin.talkroom.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.an;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class c
  implements d
{
  private ak mHandler;
  private Notification oUV;
  public boolean odR;
  public String odp;
  public boolean tce;
  private String tcf;
  
  public c()
  {
    AppMethodBeat.i(25770);
    this.odp = "";
    this.odR = false;
    this.tce = false;
    this.mHandler = new ak(Looper.getMainLooper());
    AppMethodBeat.o(25770);
  }
  
  private static boolean cHw()
  {
    AppMethodBeat.i(25766);
    if (bo.isNullOrNil(b.cHs().tcS))
    {
      ab.w("MicroMsg.TalkRoomDisplayMgr", "yy checkServer null");
      ab.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
      cHz();
      AppMethodBeat.o(25766);
      return false;
    }
    AppMethodBeat.o(25766);
    return true;
  }
  
  private void cHy()
  {
    AppMethodBeat.i(25772);
    if (!cHw())
    {
      AppMethodBeat.o(25772);
      return;
    }
    if (this.oUV == null)
    {
      ab.e("MicroMsg.TalkRoomDisplayMgr", "yy updateNotify error no notification");
      AppMethodBeat.o(25772);
      return;
    }
    String str = h.aT(ah.getContext(), b.cHs().tcS);
    if (b.cHs().tdg) {}
    for (Object localObject1 = ah.getContext().getString(2131304242);; localObject1 = ah.getContext().getString(2131304239, new Object[] { Integer.valueOf(b.cHs().bLy().size()) }))
    {
      Object localObject2 = com.tencent.mm.plugin.talkroom.a.gmP.BS();
      ((Intent)localObject2).putExtra("enter_chat_usrname", b.cHs().tcS);
      localObject2 = PendingIntent.getActivity(ah.getContext(), 100, (Intent)localObject2, 268435456);
      localObject1 = com.tencent.mm.bp.a.br(ah.getContext(), "reminder_channel_id").h(this.tcf).g(0L).e(str).f((CharSequence)localObject1);
      ((s.c)localObject1).ya = ((PendingIntent)localObject2);
      this.oUV = ((s.c)localObject1).build();
      this.oUV.icon = 2130840532;
      this.oUV.flags = 32;
      aw.getNotification().a(100, this.oUV, false);
      AppMethodBeat.o(25772);
      return;
    }
  }
  
  public static void cHz()
  {
    AppMethodBeat.i(25773);
    ab.v("MicroMsg.TalkRoomDisplayMgr", "yy cancelNotify");
    aw.getNotification().cancel(100);
    AppMethodBeat.o(25773);
  }
  
  public final void aX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25767);
    if (this.tce)
    {
      AppMethodBeat.o(25767);
      return;
    }
    cHy();
    AppMethodBeat.o(25767);
  }
  
  public final void adZ(String paramString)
  {
    AppMethodBeat.i(25771);
    if (!cHw())
    {
      AppMethodBeat.o(25771);
      return;
    }
    ab.v("MicroMsg.TalkRoomDisplayMgr", "yy showNotify: ".concat(String.valueOf(paramString)));
    this.tcf = paramString;
    this.oUV = com.tencent.mm.bp.a.br(ah.getContext(), "reminder_channel_id").h(paramString).g(0L).build();
    this.oUV.icon = 2130840532;
    this.oUV.flags = 32;
    cHy();
    AppMethodBeat.o(25771);
  }
  
  public final void akV()
  {
    this.odR = false;
  }
  
  public final void akW() {}
  
  public final void akX()
  {
    AppMethodBeat.i(25768);
    ab.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
    cHz();
    AppMethodBeat.o(25768);
  }
  
  public final void akY() {}
  
  public final void akZ() {}
  
  public final void ala() {}
  
  public final void cHx()
  {
    AppMethodBeat.i(25769);
    this.mHandler.post(new c.1(this));
    AppMethodBeat.o(25769);
  }
  
  public final void i(int paramInt1, int paramInt2, String paramString) {}
  
  public final void mh(int paramInt) {}
  
  public final void t(String paramString, int paramInt1, int paramInt2)
  {
    this.odR = false;
  }
  
  public final void uM(String paramString)
  {
    this.odp = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.c
 * JD-Core Version:    0.7.0.1
 */
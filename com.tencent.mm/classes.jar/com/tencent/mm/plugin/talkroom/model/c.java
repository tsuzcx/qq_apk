package com.tencent.mm.plugin.talkroom.model;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.bf.d;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.talkroom.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public final class c
  implements d
{
  public boolean lGE = false;
  public String lGc = "";
  ah mHandler = new ah(Looper.getMainLooper());
  public boolean pAs = false;
  private Notification pAt;
  private String pAu;
  
  public static void bMA()
  {
    y.v("MicroMsg.TalkRoomDisplayMgr", "yy cancelNotify");
    au.getNotification().cancel(100);
  }
  
  private static boolean bMy()
  {
    if (bk.bl(b.bMu().pBi))
    {
      y.w("MicroMsg.TalkRoomDisplayMgr", "yy checkServer null");
      y.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
      bMA();
      return false;
    }
    return true;
  }
  
  private void bMz()
  {
    if (!bMy()) {
      return;
    }
    if (this.pAt == null)
    {
      y.e("MicroMsg.TalkRoomDisplayMgr", "yy updateNotify error no notification");
      return;
    }
    String str2 = h.aJ(ae.getContext(), b.bMu().pBi);
    if (b.bMu().pBw) {}
    for (String str1 = ae.getContext().getString(R.l.talk_room_pausing);; str1 = ae.getContext().getString(R.l.talk_room_member_count, new Object[] { Integer.valueOf(b.bMu().bee().size()) }))
    {
      Object localObject = a.eUS.to();
      ((Intent)localObject).putExtra("enter_chat_usrname", b.bMu().pBi);
      localObject = PendingIntent.getActivity(ae.getContext(), 100, (Intent)localObject, 268435456);
      this.pAt = new Notification.Builder(ae.getContext()).setTicker(this.pAu).setWhen(0L).setContentTitle(str2).setContentText(str1).setContentIntent((PendingIntent)localObject).getNotification();
      this.pAt.icon = R.g.talk_room_notify_ic;
      this.pAt.flags = 32;
      au.getNotification().a(100, this.pAt, false);
      return;
    }
  }
  
  public final void PG(String paramString)
  {
    if (!bMy()) {
      return;
    }
    y.v("MicroMsg.TalkRoomDisplayMgr", "yy showNotify: " + paramString);
    this.pAu = paramString;
    this.pAt = new Notification.Builder(ae.getContext()).setTicker(paramString).setWhen(0L).getNotification();
    this.pAt.icon = R.g.talk_room_notify_ic;
    this.pAt.flags = 32;
    bMz();
  }
  
  public final void RM()
  {
    this.lGE = false;
  }
  
  public final void RN() {}
  
  public final void RO()
  {
    y.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
    bMA();
  }
  
  public final void RP() {}
  
  public final void RQ() {}
  
  public final void RR() {}
  
  public final void aE(String paramString1, String paramString2)
  {
    if (this.pAs) {
      return;
    }
    bMz();
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString) {}
  
  public final void i(String paramString, int paramInt1, int paramInt2)
  {
    this.lGE = false;
  }
  
  public final void jp(int paramInt) {}
  
  public final void ny(String paramString)
  {
    this.lGc = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.c
 * JD-Core Version:    0.7.0.1
 */
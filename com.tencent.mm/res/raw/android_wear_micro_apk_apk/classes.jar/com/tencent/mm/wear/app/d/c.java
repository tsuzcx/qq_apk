package com.tencent.mm.wear.app.d;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.ar;
import android.support.v4.app.at;
import android.support.v4.app.au;
import android.support.v4.app.aw;
import com.tencent.mm.e.a.n;
import com.tencent.mm.wear.app.MMApplication;
import com.tencent.mm.wear.app.ui.message.ReplyLuckyUI;
import java.io.IOException;

public final class c
{
  private static int agA = 10000;
  private int agB;
  private n agC;
  
  public c(n paramn)
  {
    agA += 1;
    this.agB = agA;
    this.agC = paramn;
  }
  
  private Intent z(Context paramContext)
  {
    paramContext = new Intent(paramContext, ReplyLuckyUI.class);
    try
    {
      paramContext.putExtra("key_data", this.agC.toByteArray());
      label25:
      paramContext.putExtra("key_notification_id", this.agB);
      return paramContext;
    }
    catch (IOException localIOException)
    {
      break label25;
    }
  }
  
  public final void nq()
  {
    PendingIntent localPendingIntent = PendingIntent.getActivity(MMApplication.getContext(), this.agB, z(MMApplication.getContext()), 134217728);
    at localat = f.i(MMApplication.getContext(), "message_channel_id");
    localat.t(2130837543);
    localat.a(BitmapFactory.decodeResource(MMApplication.getContext().getResources(), 2130837579));
    localat.b(d.o(this.agC.XI, this.agC.Xr));
    localat.c(d.p(this.agC.XI, this.agC.Xs));
    localat.aO();
    localat.a(new long[] { 0L, 800L, 500L, 800L });
    new aw().aP().aR().aQ().c(new ar(2130837581, "", localPendingIntent)).a(localat);
    g.a(MMApplication.getContext(), this.agB, localat.build());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import com.tencent.mm.br.d.a;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.platformtools.y;

final class ac$c$1
  implements d.a
{
  ac$c$1(ac.c paramc) {}
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
      if (paramIntent == null)
      {
        y.e("MicroMsg.LocationClickListener", "[onActivityResult] null == data, requestCode:%s resultCode:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        return;
      }
    } while (!paramIntent.getBooleanExtra("kfavorite", false));
    cj localcj = new cj();
    e.a(localcj, paramIntent);
    localcj.bIw.uD = ac.c.a(this.vFc).vtz;
    localcj.bIw.bID = 42;
    com.tencent.mm.sdk.b.a.udP.m(localcj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac.c.1
 * JD-Core Version:    0.7.0.1
 */
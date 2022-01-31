package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import com.tencent.mm.br.d.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;

final class n$c$3
  implements d.a
{
  n$c$3(n.c paramc, a parama) {}
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 != 221) || (paramIntent == null)) {}
    do
    {
      return;
      paramIntent = paramIntent.getStringExtra("result_msg");
    } while (bk.bl(paramIntent));
    h.b(this.vBl.vtz.getContext(), paramIntent, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.n.c.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.chatting;

import android.content.Intent;
import com.tencent.mm.br.d.a;
import com.tencent.mm.ui.chatting.b.b.h;
import com.tencent.mm.ui.chatting.c.a;

final class o$1
  implements d.a
{
  o$1(a parama) {}
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramIntent = (h)this.vjy.ac(h.class);
    if ((-1 == paramInt2) && (paramIntent != null) && (paramIntent.cEh())) {
      paramIntent.cEf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.o.1
 * JD-Core Version:    0.7.0.1
 */
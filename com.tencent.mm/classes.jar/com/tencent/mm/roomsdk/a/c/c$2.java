package com.tencent.mm.roomsdk.a.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.roomsdk.a.b.a;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.ui.base.p;

final class c$2
  implements h.a
{
  c$2(c paramc) {}
  
  public final void n(int paramInt, String paramString1, String paramString2)
  {
    ((j)g.r(j.class)).Fv().b(this.ubA.ubx.getCmdId(), this.ubA.ubz);
    if (this.ubA.uby) {}
    do
    {
      return;
      this.ubA.uby = true;
      if (this.ubA.ubu != null)
      {
        if ((this.ubA.ubu instanceof e))
        {
          e locale = (e)this.ubA.ubu;
          locale.ret = paramInt;
          locale.title = paramString1;
          locale.content = paramString2;
        }
        this.ubA.ubu.a(0, paramInt, "", this.ubA.ubu);
      }
    } while (this.ubA.tipDialog == null);
    this.ubA.tipDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.c.2
 * JD-Core Version:    0.7.0.1
 */
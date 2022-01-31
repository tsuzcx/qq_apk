package com.tencent.mm.roomsdk.a.c;

import com.tencent.mm.h.a.lr;
import com.tencent.mm.h.a.lr.a;
import com.tencent.mm.roomsdk.a.b.a;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.ui.base.p;

final class c$1$1
  implements Runnable
{
  c$1$1(c.1 param1, lr paramlr) {}
  
  public final void run()
  {
    if (this.ubC.ubA.uby) {}
    do
    {
      return;
      this.ubC.ubA.uby = true;
      String str1 = this.ubB.bUK.bUL;
      String str2 = this.ubB.bUK.bUM;
      int i = this.ubB.bUK.ret;
      if (this.ubC.ubA.ubu != null)
      {
        if ((this.ubC.ubA.ubu instanceof e))
        {
          e locale = (e)this.ubC.ubA.ubu;
          locale.title = str1;
          locale.ret = i;
          locale.content = str2;
        }
        this.ubC.ubA.ubu.a(0, i, "", this.ubC.ubA.ubu);
      }
    } while (this.ubC.ubA.tipDialog == null);
    this.ubC.ubA.tipDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.c.1.1
 * JD-Core Version:    0.7.0.1
 */
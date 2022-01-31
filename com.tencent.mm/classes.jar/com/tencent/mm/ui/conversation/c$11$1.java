package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import com.tencent.mm.ai.a.e;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.pointers.PBool;

final class c$11$1
  implements bd.a
{
  c$11$1(c.11 param11) {}
  
  public final void xA()
  {
    e.D(this.vPC.uII, false);
    if (this.vPC.doh != null) {
      this.vPC.doh.dismiss();
    }
  }
  
  public final boolean xz()
  {
    return (this.vPC.vPx.value) || (this.vPC.doh == null) || (!this.vPC.doh.isShowing());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.c.11.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.z;

final class h$18$1
  implements Runnable
{
  h$18$1(h.18 param18) {}
  
  public final void run()
  {
    au.Hx();
    c.Dz().o(68377, "");
    if (h.a(this.uJw.uJi) != null) {
      h.a(this.uJw.uJi).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.h.18.1
 * JD-Core Version:    0.7.0.1
 */
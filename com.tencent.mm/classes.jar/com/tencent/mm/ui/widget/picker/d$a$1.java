package com.tencent.mm.ui.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.d;
import java.util.HashMap;

final class d$a$1
  implements View.OnClickListener
{
  d$a$1(d.a parama, int paramInt, m paramm) {}
  
  public final void onClick(View paramView)
  {
    if (this.woK.woG.phI != null) {
      this.woK.woG.phI.onMMMenuItemSelected(this.woK.woG.phJ.getItem(this.kX), this.kX);
    }
    if (this.woJ.tMS) {
      return;
    }
    if (((Boolean)d.a.a(this.woK).get(Integer.valueOf(this.kX))).booleanValue()) {
      d.a.a(this.woK).put(Integer.valueOf(this.kX), Boolean.valueOf(false));
    }
    for (;;)
    {
      this.woK.woH = d.a.a(this.woK);
      this.woK.notifyDataSetChanged();
      return;
      d.a.a(this.woK).put(Integer.valueOf(this.kX), Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.d.a.1
 * JD-Core Version:    0.7.0.1
 */
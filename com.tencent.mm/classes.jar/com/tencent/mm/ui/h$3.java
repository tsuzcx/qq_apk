package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.tencent.mm.as.c;
import com.tencent.mm.as.o;
import com.tencent.mm.as.p;
import com.tencent.mm.plugin.websearch.api.an.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.IconPreference;

final class h$3
  implements Runnable
{
  h$3(h paramh, IconPreference paramIconPreference, an.a parama) {}
  
  public final void run()
  {
    if (this.uJj == null) {
      return;
    }
    if (this.uJk == null)
    {
      this.uJj.Gv(8);
      return;
    }
    if (this.uJk.isValid())
    {
      y.i("MicroMsg.FindMoreFriendsUI", "show red %s", new Object[] { this.uJj.getTitle() });
      switch (this.uJk.type)
      {
      default: 
        y.e("MicroMsg.FindMoreFriendsUI", "search unknown red type %d", new Object[] { Integer.valueOf(this.uJk.type) });
      }
    }
    for (;;)
    {
      h.a(this.uJi).notifyDataSetChanged();
      return;
      this.uJj.Gv(0);
      this.uJj.Gu(8);
      continue;
      this.uJj.Gv(8);
      this.uJj.Gu(0);
      this.uJj.ap(this.uJk.text, -1, Color.parseColor("#8c8c8c"));
      this.uJj.ne(true);
      this.uJj.Gy(8);
      continue;
      this.uJj.Gy(0);
      this.uJj.Gx(0);
      this.uJj.Gz(0);
      this.uJj.ne(false);
      o.OI();
      Bitmap localBitmap = c.jK(this.uJk.bVO);
      if (localBitmap != null)
      {
        h.a(this.uJi, null);
        this.uJj.Z(localBitmap);
      }
      else
      {
        o.OM().a(this.uJk.bVO, this.uJi.uJh);
        h.a(this.uJi, this.uJk.bVO);
        continue;
        this.uJj.Gy(0);
        this.uJj.Gx(0);
        this.uJj.Gz(0);
        this.uJj.Gu(0);
        this.uJj.ne(false);
        this.uJj.ap(this.uJk.text, -1, Color.parseColor("#8c8c8c"));
        o.OI();
        localBitmap = c.jK(this.uJk.bVO);
        if (localBitmap != null)
        {
          h.a(this.uJi, null);
          this.uJj.Z(localBitmap);
        }
        else
        {
          o.OM().a(this.uJk.bVO, this.uJi.uJh);
          h.a(this.uJi, this.uJk.bVO);
          continue;
          y.i("MicroMsg.FindMoreFriendsUI", "hide red %s", new Object[] { this.uJj.getTitle() });
          this.uJj.Gv(8);
          this.uJj.Gu(8);
          this.uJj.Gy(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.h.3
 * JD-Core Version:    0.7.0.1
 */
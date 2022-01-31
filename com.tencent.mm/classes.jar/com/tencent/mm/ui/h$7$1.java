package com.tencent.mm.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.IconPreference;

final class h$7$1
  implements Runnable
{
  h$7$1(h.7 param7, String paramString, Bitmap paramBitmap) {}
  
  public final void run()
  {
    Object localObject = new StringBuilder("download url ").append(this.iXG).append(" , result ");
    boolean bool;
    if (this.uJm == null)
    {
      bool = true;
      y.i("MicroMsg.FindMoreFriendsUI", bool);
      localObject = (IconPreference)h.a(this.uJn.uJi).add("jd_market_entrance");
      if (localObject != null)
      {
        if (!this.iXG.equals(h.i(this.uJn.uJi))) {
          break label393;
        }
        ((IconPreference)localObject).drawable = new BitmapDrawable(this.uJn.uJi.getContext().getResources(), this.uJm);
        h.j(this.uJn.uJi);
      }
    }
    for (;;)
    {
      h.a(this.uJn.uJi).notifyDataSetChanged();
      if (this.iXG.equals(h.m(this.uJn.uJi)))
      {
        ((IconPreference)h.a(this.uJn.uJi).add("find_friends_by_look")).drawable = new BitmapDrawable(this.uJn.uJi.getContext().getResources(), this.uJm);
        h.n(this.uJn.uJi);
        h.a(this.uJn.uJi).notifyDataSetChanged();
      }
      if (this.iXG.equals(h.o(this.uJn.uJi)))
      {
        ((IconPreference)h.a(this.uJn.uJi).add("find_friends_by_search")).drawable = new BitmapDrawable(this.uJn.uJi.getContext().getResources(), this.uJm);
        h.p(this.uJn.uJi);
        h.a(this.uJn.uJi).notifyDataSetChanged();
      }
      if (this.iXG.equals(h.q(this.uJn.uJi)))
      {
        ((IconPreference)h.a(this.uJn.uJi).add("find_friends_by_look")).Z(this.uJm);
        h.a(this.uJn.uJi, null);
        h.a(this.uJn.uJi).notifyDataSetChanged();
      }
      return;
      bool = false;
      break;
      label393:
      if (this.iXG.equals(h.k(this.uJn.uJi)))
      {
        ((IconPreference)localObject).Z(this.uJm);
        h.l(this.uJn.uJi);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.h.7.1
 * JD-Core Version:    0.7.0.1
 */
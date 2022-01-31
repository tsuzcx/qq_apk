package com.tencent.mm.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.p.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.h;

final class FindMoreFriendsUI$9
  implements p.a
{
  FindMoreFriendsUI$9(FindMoreFriendsUI paramFindMoreFriendsUI) {}
  
  public final void i(final String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(29219);
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29218);
        Object localObject = new StringBuilder("download url ").append(paramString).append(" , result ");
        if (paramBitmap == null) {}
        for (boolean bool = true;; bool = false)
        {
          ab.i("MicroMsg.FindMoreFriendsUI", bool);
          localObject = (IconPreference)FindMoreFriendsUI.a(FindMoreFriendsUI.9.this.yWI).atx("jd_market_entrance");
          if (localObject != null)
          {
            if (paramString.equals(FindMoreFriendsUI.k(FindMoreFriendsUI.9.this.yWI)))
            {
              ((IconPreference)localObject).ap(paramBitmap);
              FindMoreFriendsUI.l(FindMoreFriendsUI.9.this.yWI);
            }
            FindMoreFriendsUI.a(FindMoreFriendsUI.9.this.yWI).notifyDataSetChanged();
          }
          if (paramString.equals(FindMoreFriendsUI.m(FindMoreFriendsUI.9.this.yWI)))
          {
            ((IconPreference)FindMoreFriendsUI.a(FindMoreFriendsUI.9.this.yWI).atx("find_friends_by_look")).drawable = new BitmapDrawable(FindMoreFriendsUI.9.this.yWI.getContext().getResources(), paramBitmap);
            FindMoreFriendsUI.n(FindMoreFriendsUI.9.this.yWI);
            FindMoreFriendsUI.a(FindMoreFriendsUI.9.this.yWI).notifyDataSetChanged();
          }
          if (paramString.equals(FindMoreFriendsUI.o(FindMoreFriendsUI.9.this.yWI)))
          {
            ((IconPreference)FindMoreFriendsUI.a(FindMoreFriendsUI.9.this.yWI).atx("find_friends_by_search")).drawable = new BitmapDrawable(FindMoreFriendsUI.9.this.yWI.getContext().getResources(), paramBitmap);
            FindMoreFriendsUI.p(FindMoreFriendsUI.9.this.yWI);
            FindMoreFriendsUI.a(FindMoreFriendsUI.9.this.yWI).notifyDataSetChanged();
          }
          if (paramString.equals(FindMoreFriendsUI.q(FindMoreFriendsUI.9.this.yWI)))
          {
            ((IconPreference)FindMoreFriendsUI.a(FindMoreFriendsUI.9.this.yWI).atx("find_friends_by_look")).ap(paramBitmap);
            FindMoreFriendsUI.a(FindMoreFriendsUI.9.this.yWI, null);
            FindMoreFriendsUI.a(FindMoreFriendsUI.9.this.yWI).notifyDataSetChanged();
          }
          if (paramString.equals(FindMoreFriendsUI.r(FindMoreFriendsUI.9.this.yWI)))
          {
            ((IconPreference)FindMoreFriendsUI.a(FindMoreFriendsUI.9.this.yWI).atx("my_life_around")).ap(d.a(paramBitmap, false, paramBitmap.getWidth() * 0.1F));
            FindMoreFriendsUI.s(FindMoreFriendsUI.9.this.yWI);
            FindMoreFriendsUI.a(FindMoreFriendsUI.9.this.yWI).notifyDataSetChanged();
          }
          AppMethodBeat.o(29218);
          return;
        }
      }
    });
    AppMethodBeat.o(29219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.9
 * JD-Core Version:    0.7.0.1
 */
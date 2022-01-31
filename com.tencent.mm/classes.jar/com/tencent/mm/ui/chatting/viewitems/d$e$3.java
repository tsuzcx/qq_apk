package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.LinearLayout;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.as.a.c.g;
import com.tencent.mm.as.a.d.b;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.ui.chatting.e;

final class d$e$3
  implements g
{
  d$e$3(d.e parame, d.c paramc, com.tencent.mm.ui.chatting.c.a parama) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(final String paramString, View paramView, b paramb)
  {
    if (paramb.bitmap != null)
    {
      paramString = paramb.bitmap;
      this.vCh.vBI.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          d.e.3.this.vCh.vBI.getViewTreeObserver().removeOnPreDrawListener(this);
          int j = d.e.3.this.vCh.vBI.getHeight();
          int k = d.e.3.this.vCh.vBI.getWidth();
          int i = j;
          if (j == 0) {
            i = com.tencent.mm.cb.a.aa(d.e.3.this.vBl.vtz.getContext(), R.f.chatting_music_item_height);
          }
          j = k;
          if (k == 0) {
            j = com.tencent.mm.cb.a.aa(d.e.3.this.vBl.vtz.getContext(), R.f.chatting_music_item_width);
          }
          BitmapDrawable localBitmapDrawable = new BitmapDrawable(c.a(paramString, R.g.chat_to_content_bg_mask, j, i));
          d.e.3.this.vCh.vBI.setBackgroundDrawable(localBitmapDrawable);
          return true;
        }
      });
    }
  }
  
  public final void mv(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.e.3
 * JD-Core Version:    0.7.0.1
 */
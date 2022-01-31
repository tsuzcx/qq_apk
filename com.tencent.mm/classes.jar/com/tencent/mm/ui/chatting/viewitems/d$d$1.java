package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.LinearLayout;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.ui.chatting.e;

final class d$d$1
  implements ViewTreeObserver.OnPreDrawListener
{
  private boolean vCg = false;
  
  d$d$1(d.d paramd, d.c paramc, com.tencent.mm.ui.chatting.c.a parama, Bitmap paramBitmap) {}
  
  public final boolean onPreDraw()
  {
    if (this.vCg)
    {
      this.vCh.vBI.getViewTreeObserver().removeOnPreDrawListener(this);
      return true;
    }
    this.vCh.vBI.getViewTreeObserver().removeOnPreDrawListener(this);
    this.vCg = true;
    int i = com.tencent.mm.cb.a.fromDPToPix(this.vBl.vtz.getContext(), 24);
    Bitmap localBitmap = this.ara;
    Object localObject;
    if (localBitmap != null)
    {
      localObject = localBitmap;
      if (!localBitmap.isRecycled()) {}
    }
    else
    {
      localObject = c.ah(this.vBl.vtz.getContext().getResources().getColor(R.e.chat_item_default_mucic_mask_color), i, i);
    }
    int j = ((Bitmap)localObject).getHeight();
    if (i > j) {
      i = j;
    }
    for (;;)
    {
      localObject = c.f(c.W(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
      j = this.vCh.vBI.getHeight();
      int k = this.vCh.vBI.getWidth();
      i = j;
      if (j == 0) {
        i = com.tencent.mm.cb.a.aa(this.vBl.vtz.getContext(), R.f.chatting_music_item_height);
      }
      j = k;
      if (k == 0) {
        j = com.tencent.mm.cb.a.aa(this.vBl.vtz.getContext(), R.f.chatting_music_item_width);
      }
      localObject = new BitmapDrawable(c.a((Bitmap)localObject, R.g.chat_from_content_bg_mask, j, i));
      this.vCh.vBI.setBackgroundDrawable((Drawable)localObject);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.d.1
 * JD-Core Version:    0.7.0.1
 */
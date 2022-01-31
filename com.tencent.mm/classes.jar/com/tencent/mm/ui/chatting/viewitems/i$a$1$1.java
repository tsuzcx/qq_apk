package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.c;

final class i$a$1$1
  implements ViewTreeObserver.OnPreDrawListener
{
  i$a$1$1(i.a.1 param1, Bitmap paramBitmap) {}
  
  public final boolean onPreDraw()
  {
    this.vCG.vCF.vCC.getViewTreeObserver().removeOnPreDrawListener(this);
    int j = this.vCG.vCF.vCC.getHeight();
    int k = this.vCG.vCF.vCC.getWidth();
    int i = j;
    if (j == 0) {
      i = a.aa(this.vCG.val$context, R.f.chatting_music_item_height);
    }
    j = k;
    if (k == 0) {
      j = a.aa(this.vCG.val$context, R.f.chatting_music_item_width);
    }
    if (this.vCG.vCF.vCD) {}
    for (Object localObject = c.a(this.izh, R.g.chat_from_content_bg_mask, j, i);; localObject = c.a(this.izh, R.g.chat_to_content_bg_mask, j, i))
    {
      localObject = new BitmapDrawable((Bitmap)localObject);
      this.vCG.vCF.vCC.setBackgroundDrawable((Drawable)localObject);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.i.a.1.1
 * JD-Core Version:    0.7.0.1
 */
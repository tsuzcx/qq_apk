package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.product.b.n.a;
import com.tencent.mm.sdk.platformtools.bk;

public final class m
  implements x.a
{
  public TextView eXr;
  public ImageView heN;
  public n.a mUJ;
  
  public final void l(String paramString, final Bitmap paramBitmap)
  {
    if ((this.mUJ == null) || (bk.bl(this.mUJ.iconUrl))) {}
    while (!paramString.equals(this.mUJ.iconUrl)) {
      return;
    }
    this.heN.post(new Runnable()
    {
      public final void run()
      {
        m.this.heN.setImageBitmap(paramBitmap);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.m
 * JD-Core Version:    0.7.0.1
 */
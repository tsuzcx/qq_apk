package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.widget.ImageView;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.y;

final class g$b
  implements x.a
{
  public ImageView bQf = null;
  public String url;
  
  public g$b(g paramg, String paramString)
  {
    this.url = paramString;
    this.bQf = ((ImageView)((LayoutInflater)paramg.mContext.getSystemService("layout_inflater")).inflate(a.g.product_image_item, null));
    paramString = x.a(new c(paramString));
    this.bQf.setImageBitmap(paramString);
    this.bQf.setOnClickListener(new g.b.1(this, paramg));
    x.a(this);
  }
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(", bitmap = ");
    boolean bool;
    if (paramBitmap == null)
    {
      bool = true;
      y.d("MicroMsg.MallProductImageAdapter", bool);
      if (this.url != null) {
        break label51;
      }
    }
    label51:
    while (!paramString.equals(this.url))
    {
      return;
      bool = false;
      break;
    }
    this.bQf.post(new g.b.2(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.g.b
 * JD-Core Version:    0.7.0.1
 */
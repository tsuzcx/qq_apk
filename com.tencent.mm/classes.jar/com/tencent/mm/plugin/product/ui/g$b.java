package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.sdk.platformtools.ab;

final class g$b
  implements x.a
{
  public ImageView cxy;
  public String url;
  
  public g$b(g paramg, String paramString)
  {
    AppMethodBeat.i(44071);
    this.cxy = null;
    this.url = paramString;
    this.cxy = ((ImageView)((LayoutInflater)paramg.mContext.getSystemService("layout_inflater")).inflate(2130970446, null));
    paramString = x.a(new c(paramString));
    this.cxy.setImageBitmap(paramString);
    this.cxy.setOnClickListener(new g.b.1(this, paramg));
    x.a(this);
    AppMethodBeat.o(44071);
  }
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(44072);
    StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(", bitmap = ");
    if (paramBitmap == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.MallProductImageAdapter", bool);
      if (this.url != null) {
        break;
      }
      AppMethodBeat.o(44072);
      return;
    }
    if (paramString.equals(this.url)) {
      this.cxy.post(new g.b.2(this, paramBitmap));
    }
    AppMethodBeat.o(44072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.g.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.webview.ui.tools;

import android.graphics.Bitmap;
import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.a;

final class j$18
  implements n.a
{
  j$18(j paramj) {}
  
  public final void a(ImageView paramImageView, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(7657);
    if (j.d(paramMenuItem))
    {
      paramImageView.setVisibility(8);
      AppMethodBeat.o(7657);
      return;
    }
    paramMenuItem = paramMenuItem.getTitle();
    if ((this.vcO.vcE.get(paramMenuItem) != null) && (!((Bitmap)this.vcO.vcE.get(paramMenuItem)).isRecycled()))
    {
      paramImageView.setImageBitmap((Bitmap)this.vcO.vcE.get(paramMenuItem));
      AppMethodBeat.o(7657);
      return;
    }
    ab.w("MicroMsg.WebViewMenuHelper", "on attach icon, load from cache fail");
    try
    {
      Object localObject = this.vcO.ddt().igU.ahN(paramMenuItem);
      if (!bo.isNullOrNil((String)localObject))
      {
        localObject = g.aie((String)localObject);
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
        {
          paramImageView.setImageBitmap((Bitmap)localObject);
          this.vcO.vcE.put(paramMenuItem, localObject);
        }
      }
      AppMethodBeat.o(7657);
      return;
    }
    catch (Exception paramImageView)
    {
      ab.w("MicroMsg.WebViewMenuHelper", "getheadimg, ex = " + paramImageView.getMessage());
      AppMethodBeat.o(7657);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.j.18
 * JD-Core Version:    0.7.0.1
 */
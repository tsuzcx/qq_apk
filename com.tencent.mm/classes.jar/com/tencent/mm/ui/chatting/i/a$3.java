package com.tencent.mm.ui.chatting.i;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.plugin.appbrand.s.n;

final class a$3
  implements b.i
{
  a$3(a parama, a.b paramb, a.a parama1) {}
  
  public final void acG() {}
  
  public final void acH()
  {
    AppMethodBeat.i(32512);
    o.ahG().a(this.zPb.imagePath, this.zPa.ivs, this.zOW.zOV);
    AppMethodBeat.o(32512);
  }
  
  public final String tX()
  {
    AppMethodBeat.i(32513);
    String str = "SEARCH#" + n.bt(this);
    AppMethodBeat.o(32513);
    return str;
  }
  
  public final void w(Bitmap paramBitmap)
  {
    AppMethodBeat.i(32511);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.zPa.ivs.setImageBitmap(paramBitmap);
      AppMethodBeat.o(32511);
      return;
    }
    o.ahG().a(this.zPb.imagePath, this.zPa.ivs, this.zOW.zOV);
    AppMethodBeat.o(32511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.a.3
 * JD-Core Version:    0.7.0.1
 */
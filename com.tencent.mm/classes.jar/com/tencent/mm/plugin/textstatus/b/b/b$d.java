package com.tencent.mm.plugin.textstatus.b.b;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.r.a;
import com.tencent.mm.plugin.textstatus.g.b.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "", "kotlin.jvm.PlatformType", "bitmap", "Landroid/graphics/Bitmap;", "path", "onLoadImageEnd"})
final class b$d
  implements r.a
{
  b$d(ImageView paramImageView, b paramb) {}
  
  public final void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    AppMethodBeat.i(235913);
    paramString1 = this.MAz;
    p.j(paramString1, "ivThumb");
    if (p.h(paramString1.getTag(), this.MAA)) {
      this.MAz.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(235913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.b.b.d
 * JD-Core Version:    0.7.0.1
 */
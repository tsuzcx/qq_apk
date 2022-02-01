package com.tencent.mm.plugin.textstatus.b.b;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.r.a;
import com.tencent.mm.plugin.textstatus.g.b.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "", "kotlin.jvm.PlatformType", "bitmap", "Landroid/graphics/Bitmap;", "path", "onLoadImageEnd"})
final class e$d
  implements r.a
{
  e$d(ImageView paramImageView, d paramd) {}
  
  public final void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    AppMethodBeat.i(237894);
    paramString1 = this.MAE;
    p.j(paramString1, "ivRefBack");
    if (p.h(paramString1.getTag(), this.MAF)) {
      this.MAE.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(237894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.b.e.d
 * JD-Core Version:    0.7.0.1
 */
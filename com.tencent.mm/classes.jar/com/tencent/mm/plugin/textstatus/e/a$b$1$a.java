package com.tencent.mm.plugin.textstatus.e;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/textstatus/manager/StatusImgHandler$handleImgUrl$1$1$1$1"})
final class a$b$1$a
  implements Runnable
{
  a$b$1$a(Bitmap paramBitmap, a.b.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(258416);
    this.UrP.FYM.FYJ.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(258415);
        if ((p.j(this.UrQ.UrP.FYM.FYJ.getTag(2131299785), Integer.valueOf(this.UrQ.UrP.FYM.FYK)) ^ true))
        {
          AppMethodBeat.o(258415);
          return;
        }
        Object localObject = a.FYI;
        localObject = a.b(this.UrQ.UrN, this.UrQ.UrP.FYM.FYF.fvV(), this.UrQ.UrP.FYM.$context);
        this.UrQ.UrP.FYM.FYJ.setImageBitmap((Bitmap)localObject);
        AppMethodBeat.o(258415);
      }
    });
    AppMethodBeat.o(258416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.e.a.b.1.a
 * JD-Core Version:    0.7.0.1
 */
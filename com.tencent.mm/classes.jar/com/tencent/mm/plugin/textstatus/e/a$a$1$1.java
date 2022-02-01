package com.tencent.mm.plugin.textstatus.e;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class a$a$1$1
  implements Runnable
{
  a$a$1$1(a.a.1 param1, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(258414);
    this.UrM.FYL.FYJ.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(258413);
        if ((p.j(this.UrO.UrM.FYL.FYJ.getTag(2131299785), Integer.valueOf(this.UrO.UrM.FYL.FYK)) ^ true))
        {
          AppMethodBeat.o(258413);
          return;
        }
        ImageView localImageView = this.UrO.UrM.FYL.FYJ;
        a locala = a.FYI;
        localImageView.setImageBitmap(a.b(this.UrO.UrN, this.UrO.UrM.FYL.FYF.fvV(), this.UrO.UrM.FYL.$context));
        AppMethodBeat.o(258413);
      }
    });
    AppMethodBeat.o(258414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.e.a.a.1.1
 * JD-Core Version:    0.7.0.1
 */
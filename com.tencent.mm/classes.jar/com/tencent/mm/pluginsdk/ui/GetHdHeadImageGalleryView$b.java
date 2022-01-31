package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.tools.MMGestureGallery.c;

final class GetHdHeadImageGalleryView$b
  implements MMGestureGallery.c
{
  private GetHdHeadImageGalleryView$b(GetHdHeadImageGalleryView paramGetHdHeadImageGalleryView) {}
  
  public final void bxv()
  {
    AppMethodBeat.i(79684);
    if ((GetHdHeadImageGalleryView.b(this.vQD) != null) && (GetHdHeadImageGalleryView.c(this.vQD) != null))
    {
      String[] arrayOfString = this.vQD.getContext().getResources().getStringArray(2131755020);
      h.a(this.vQD.getContext(), null, arrayOfString, "", new h.c()
      {
        public final void iA(int paramAnonymousInt)
        {
          AppMethodBeat.i(79683);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(79683);
            return;
            String str = com.tencent.mm.compatible.util.e.esr + "hdImg_" + g.w(GetHdHeadImageGalleryView.c(GetHdHeadImageGalleryView.b.this.vQD).getBytes()) + System.currentTimeMillis() + ".jpg";
            com.tencent.mm.vfs.e.deleteFile(str);
            com.tencent.mm.vfs.e.C(GetHdHeadImageGalleryView.b(GetHdHeadImageGalleryView.b.this.vQD), str);
            b.a(str, GetHdHeadImageGalleryView.b.this.vQD.getContext());
            Toast.makeText(GetHdHeadImageGalleryView.b.this.vQD.getContext(), GetHdHeadImageGalleryView.b.this.vQD.getContext().getString(2131300527, new Object[] { com.tencent.mm.compatible.util.e.esr }), 1).show();
          }
        }
      });
    }
    AppMethodBeat.o(79684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView.b
 * JD-Core Version:    0.7.0.1
 */
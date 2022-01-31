package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.n;
import com.tencent.mm.c.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class b$1$1
  implements n
{
  b$1$1(b.1 param1) {}
  
  public final void b(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(55132);
    ab.i("MicroMsg.MMSightVideoEditor", "photoEditor onSuccess: %s isNever：%s", new Object[] { paramBitmap, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        paramBitmap.recycle();
      }
      if ((b.a(this.oOW.oOV) != null) && (!b.b(this.oOW.oOV)))
      {
        if ((b.c(this.oOW.oOV) > 0) && (b.d(this.oOW.oOV) > 0) && (b.c(this.oOW.oOV) <= b.d(this.oOW.oOV)))
        {
          al.d(new b.1.1.1(this));
          AppMethodBeat.o(55132);
          return;
        }
        b.a(this.oOW.oOV, g.getMD5(b.g(this.oOW.oOV)));
        al.d(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(55128);
            b.a(b.1.1.this.oOW.oOV).bRC();
            AppMethodBeat.o(55128);
          }
        });
        AppMethodBeat.o(55132);
        return;
      }
      if (b.b(this.oOW.oOV))
      {
        al.d(new b.1.1.3(this));
        AppMethodBeat.o(55132);
      }
    }
    else if (paramBitmap != null)
    {
      al.d(new b.1.1.4(this, paramBitmap));
    }
    AppMethodBeat.o(55132);
  }
  
  public final void onError(Exception paramException)
  {
    AppMethodBeat.i(55131);
    ab.e("MicroMsg.MMSightVideoEditor", "photoEditor onError: %s", new Object[] { paramException });
    AppMethodBeat.o(55131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.b.1.1
 * JD-Core Version:    0.7.0.1
 */
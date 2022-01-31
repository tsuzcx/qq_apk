package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;

final class f$5
  implements x.a
{
  f$5(f paramf) {}
  
  public final void m(String paramString, final Bitmap paramBitmap)
  {
    boolean bool = false;
    AppMethodBeat.i(79931);
    if (paramBitmap == null) {
      bool = true;
    }
    ab.v("MicroMsg.ImageEngine", "on get picture finish, notifyKey[%s], bitmap is null[%B]", new Object[] { paramString, Boolean.valueOf(bool) });
    if (paramBitmap == null)
    {
      AppMethodBeat.o(79931);
      return;
    }
    this.weP.weJ.put(paramString, paramBitmap);
    final ImageView localImageView = (ImageView)this.weP.weH.get(paramString);
    if (localImageView != null)
    {
      this.weP.weI.remove(localImageView);
      this.weP.faV.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(79930);
          f.c.d(localImageView, paramBitmap);
          AppMethodBeat.o(79930);
        }
      });
    }
    this.weP.weH.remove(paramString);
    AppMethodBeat.o(79931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.f.5
 * JD-Core Version:    0.7.0.1
 */
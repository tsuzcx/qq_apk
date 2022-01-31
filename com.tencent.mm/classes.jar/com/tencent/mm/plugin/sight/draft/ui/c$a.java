package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.lang.ref.WeakReference;

final class c$a
  implements Runnable
{
  String key;
  String path;
  boolean qVo;
  WeakReference<c> qVp;
  
  public final void run()
  {
    AppMethodBeat.i(25022);
    Bitmap localBitmap = d.aoV(this.path);
    Object localObject = (c)this.qVp.get();
    if (localObject != null)
    {
      if ((!bo.isNullOrNil(this.key)) && (localBitmap != null)) {
        ((c)localObject).qVm.put(this.key, localBitmap);
      }
      localObject = new c.b((byte)0);
      ((c.b)localObject).key = this.key;
      ((c.b)localObject).nfX = localBitmap;
      ((c.b)localObject).qVp = this.qVp;
      if (this.qVo) {
        al.d((Runnable)localObject);
      }
    }
    AppMethodBeat.o(25022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.c.a
 * JD-Core Version:    0.7.0.1
 */
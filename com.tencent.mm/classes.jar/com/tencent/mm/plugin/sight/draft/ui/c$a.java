package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import java.lang.ref.WeakReference;

final class c$a
  implements Runnable
{
  String key;
  boolean ogZ;
  WeakReference<c> oha;
  String path;
  
  public final void run()
  {
    Bitmap localBitmap = com.tencent.mm.sdk.platformtools.c.YW(this.path);
    Object localObject = (c)this.oha.get();
    if (localObject != null)
    {
      if ((!bk.bl(this.key)) && (localBitmap != null)) {
        ((c)localObject).ogX.put(this.key, localBitmap);
      }
      localObject = new c.b((byte)0);
      ((c.b)localObject).key = this.key;
      ((c.b)localObject).kJz = localBitmap;
      ((c.b)localObject).oha = this.oha;
      if (this.ogZ) {
        ai.d((Runnable)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.c.a
 * JD-Core Version:    0.7.0.1
 */
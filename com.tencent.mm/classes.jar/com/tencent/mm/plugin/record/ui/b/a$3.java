package com.tencent.mm.plugin.record.ui.b;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.R.k;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.plugin.record.ui.h.a.b;
import com.tencent.mm.plugin.record.ui.h.a.c;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;

final class a$3
  implements Runnable
{
  a$3(a parama, b paramb, ImageView paramImageView) {}
  
  public final void run()
  {
    Object localObject = (com.tencent.mm.plugin.record.ui.a.a)this.nuw;
    final int i;
    if (((com.tencent.mm.plugin.record.ui.a.a)localObject).aYU == 0)
    {
      if (!h.g(((com.tencent.mm.plugin.record.ui.a.a)localObject).bNt, ((com.tencent.mm.plugin.record.ui.a.a)localObject).bIt)) {
        break label227;
      }
      i = R.k.record_errpicture_icon;
      if (i != -1) {
        break label310;
      }
      i = R.k.fav_list_img_default;
    }
    label302:
    label305:
    label310:
    for (;;)
    {
      com.tencent.mm.plugin.record.ui.a.a locala = (com.tencent.mm.plugin.record.ui.a.a)this.nuw;
      h.a locala1 = this.nus.ntP;
      int j = this.nus.nur;
      localObject = new h.a.b();
      ((h.a.b)localObject).bNt = locala.bNt;
      ((h.a.b)localObject).bNw = false;
      ((h.a.b)localObject).maxWidth = j;
      h.a.c localc = new h.a.c();
      localc.bNt = locala.bNt;
      Bitmap localBitmap;
      if (locala.aYU == 0)
      {
        if (h.g(locala.bNt, locala.bIt)) {
          break label305;
        }
        ((h.a.b)localObject).ntR = locala.bIt;
        localBitmap = locala1.a((h.a.b)localObject);
        localObject = localBitmap;
        if (localBitmap != null) {
          break label302;
        }
        localc.ntR = locala.bIt;
        localObject = locala1.a(localc);
      }
      for (;;)
      {
        ai.d(new Runnable()
        {
          public final void run()
          {
            a.3.this.nus.a(a.3.this.nux, this.kfS, i, a.3.this.nuw.bNt.kgC);
          }
        });
        return;
        if ((((com.tencent.mm.plugin.record.ui.a.a)localObject).aYU == 1) && (bk.bl(((com.tencent.mm.plugin.record.ui.a.a)localObject).bNt.sUG)))
        {
          i = R.k.record_errpicture_icon;
          break;
        }
        label227:
        i = -1;
        break;
        if (locala.aYU == 1)
        {
          ((h.a.b)localObject).ntR = locala.khA.field_localId;
          ((h.a.b)localObject).bNx = false;
          localBitmap = locala1.a((h.a.b)localObject);
          localObject = localBitmap;
          if (localBitmap == null)
          {
            localc.ntR = locala.khA.field_localId;
            localObject = locala1.a(localc);
          }
        }
        else
        {
          localObject = null;
        }
      }
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|fillView";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.a.3
 * JD-Core Version:    0.7.0.1
 */
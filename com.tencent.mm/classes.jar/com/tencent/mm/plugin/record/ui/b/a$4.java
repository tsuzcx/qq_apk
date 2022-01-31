package com.tencent.mm.plugin.record.ui.b;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.plugin.record.ui.h.a.b;
import com.tencent.mm.plugin.record.ui.h.a.c;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

final class a$4
  implements Runnable
{
  a$4(a parama, b paramb, ImageView paramImageView) {}
  
  public final void run()
  {
    AppMethodBeat.i(153630);
    Object localObject = (com.tencent.mm.plugin.record.ui.a.a)this.qak;
    int i;
    if (((com.tencent.mm.plugin.record.ui.a.a)localObject).dataType == 0)
    {
      if (!n.g(((com.tencent.mm.plugin.record.ui.a.a)localObject).cuL, ((com.tencent.mm.plugin.record.ui.a.a)localObject).cpO)) {
        break label234;
      }
      i = 2131231918;
      if (i != -1) {
        break label317;
      }
      i = 2131231298;
    }
    label309:
    label312:
    label317:
    for (;;)
    {
      com.tencent.mm.plugin.record.ui.a.a locala = (com.tencent.mm.plugin.record.ui.a.a)this.qak;
      h.a locala1 = this.qag.pZw;
      int j = this.qag.qaf;
      localObject = new h.a.b();
      ((h.a.b)localObject).cuL = locala.cuL;
      ((h.a.b)localObject).cuO = false;
      ((h.a.b)localObject).maxWidth = j;
      h.a.c localc = new h.a.c();
      localc.cuL = locala.cuL;
      Bitmap localBitmap;
      if (locala.dataType == 0)
      {
        if (n.g(locala.cuL, locala.cpO)) {
          break label312;
        }
        ((h.a.b)localObject).pZy = locala.cpO;
        localBitmap = locala1.a((h.a.b)localObject);
        localObject = localBitmap;
        if (localBitmap != null) {
          break label309;
        }
        localc.pZy = locala.cpO;
        localObject = locala1.a(localc);
      }
      for (;;)
      {
        al.d(new a.4.1(this, (Bitmap)localObject, i));
        AppMethodBeat.o(153630);
        return;
        if ((((com.tencent.mm.plugin.record.ui.a.a)localObject).dataType == 1) && (bo.isNullOrNil(((com.tencent.mm.plugin.record.ui.a.a)localObject).cuL.wSC)))
        {
          i = 2131231918;
          break;
        }
        label234:
        i = -1;
        break;
        if (locala.dataType == 1)
        {
          ((h.a.b)localObject).pZy = locala.mCk.field_localId;
          ((h.a.b)localObject).cuP = false;
          localBitmap = locala1.a((h.a.b)localObject);
          localObject = localBitmap;
          if (localBitmap == null)
          {
            localc.pZy = locala.mCk.field_localId;
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
    AppMethodBeat.i(153631);
    String str = super.toString() + "|fillView";
    AppMethodBeat.o(153631);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.a.4
 * JD-Core Version:    0.7.0.1
 */
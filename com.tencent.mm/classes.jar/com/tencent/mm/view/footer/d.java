package com.tencent.mm.view.footer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.bt.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class d
  extends a
{
  private Bitmap Rpv;
  private Bitmap Rpw;
  
  public d(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
  }
  
  protected final Bitmap a(h paramh, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    if (paramh == h.diM)
    {
      if (paramBoolean) {
        localBitmap = this.Rpw;
      }
    }
    else {
      return localBitmap;
    }
    return this.Rpv;
  }
  
  protected final boolean apX(int paramInt)
  {
    AppMethodBeat.i(9426);
    boolean bool = super.apX(paramInt);
    switch (1.Kyu[apW(paramInt).ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(9426);
      return bool;
      bool = false;
    }
  }
  
  protected final void hgh()
  {
    AppMethodBeat.i(9425);
    super.hgh();
    this.Rpv = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(2131690039));
    this.Rpw = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(2131690038));
    AppMethodBeat.o(9425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.footer.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.view.footer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;
import com.tencent.mm.bo.a.g;
import com.tencent.mm.bt.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class d
  extends a
{
  private Bitmap agMv;
  private Bitmap agMw;
  
  public d(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
  }
  
  protected final Bitmap a(i parami, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    if (parami == i.hdT)
    {
      if (paramBoolean) {
        localBitmap = this.agMw;
      }
    }
    else {
      return localBitmap;
    }
    return this.agMv;
  }
  
  protected final boolean aGa(int paramInt)
  {
    AppMethodBeat.i(9426);
    boolean bool = super.aGa(paramInt);
    switch (1.YwI[aFZ(paramInt).ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(9426);
      return bool;
      bool = false;
    }
  }
  
  protected final void jMV()
  {
    AppMethodBeat.i(9425);
    super.jMV();
    this.agMv = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.crop_video_unselected));
    this.agMw = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.crop_video_selected));
    AppMethodBeat.o(9425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.footer.d
 * JD-Core Version:    0.7.0.1
 */
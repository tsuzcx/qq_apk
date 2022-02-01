package com.tencent.mm.view.footer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.bv.a.g;
import com.tencent.mm.ca.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class d
  extends a
{
  private Bitmap YQP;
  private Bitmap YQQ;
  
  public d(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
  }
  
  protected final Bitmap a(h paramh, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    if (paramh == h.fas)
    {
      if (paramBoolean) {
        localBitmap = this.YQQ;
      }
    }
    else {
      return localBitmap;
    }
    return this.YQP;
  }
  
  protected final boolean azw(int paramInt)
  {
    AppMethodBeat.i(9426);
    boolean bool = super.azw(paramInt);
    switch (1.RAi[azv(paramInt).ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(9426);
      return bool;
      bool = false;
    }
  }
  
  protected final void ihI()
  {
    AppMethodBeat.i(9425);
    super.ihI();
    this.YQP = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.crop_video_unselected));
    this.YQQ = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.crop_video_selected));
    AppMethodBeat.o(9425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.footer.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.view.footer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bu.b;

public final class c
  extends a
{
  private Bitmap Lub;
  private Bitmap Luc;
  
  public c(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
  }
  
  protected final Bitmap a(com.tencent.mm.api.g paramg, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    if (paramg == com.tencent.mm.api.g.cRI)
    {
      if (paramBoolean) {
        localBitmap = this.Luc;
      }
    }
    else {
      return localBitmap;
    }
    return this.Lub;
  }
  
  protected final boolean agd(int paramInt)
  {
    AppMethodBeat.i(9426);
    boolean bool = super.agd(paramInt);
    switch (1.FmQ[agc(paramInt).ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(9426);
      return bool;
      bool = false;
    }
  }
  
  protected final void fQp()
  {
    AppMethodBeat.i(9425);
    super.fQp();
    this.Lub = com.tencent.mm.sdk.platformtools.g.A(getResources().getDrawable(2131690010));
    this.Luc = com.tencent.mm.sdk.platformtools.g.A(getResources().getDrawable(2131690009));
    AppMethodBeat.o(9425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.footer.c
 * JD-Core Version:    0.7.0.1
 */
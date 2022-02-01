package com.tencent.mm.view.footer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.g;
import com.tencent.mm.bt.b;
import com.tencent.mm.sdk.platformtools.f;

public final class c
  extends a
{
  private Bitmap JAU;
  private Bitmap JAV;
  
  public c(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
  }
  
  protected final Bitmap a(g paramg, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    if (paramg == g.cGE)
    {
      if (paramBoolean) {
        localBitmap = this.JAV;
      }
    }
    else {
      return localBitmap;
    }
    return this.JAU;
  }
  
  protected final boolean adD(int paramInt)
  {
    AppMethodBeat.i(9426);
    boolean bool = super.adD(paramInt);
    switch (1.DHJ[adC(paramInt).ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(9426);
      return bool;
      bool = false;
    }
  }
  
  protected final void fzg()
  {
    AppMethodBeat.i(9425);
    super.fzg();
    this.JAU = f.A(getResources().getDrawable(2131690010));
    this.JAV = f.A(getResources().getDrawable(2131690009));
    AppMethodBeat.o(9425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.footer.c
 * JD-Core Version:    0.7.0.1
 */
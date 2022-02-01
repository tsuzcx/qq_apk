package com.tencent.mm.view.footer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.g;
import com.tencent.mm.bt.b;
import com.tencent.mm.sdk.platformtools.h;

public final class c
  extends a
{
  private Bitmap LQO;
  private Bitmap LQP;
  
  public c(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
  }
  
  protected final Bitmap a(g paramg, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    if (paramg == g.cSs)
    {
      if (paramBoolean) {
        localBitmap = this.LQP;
      }
    }
    else {
      return localBitmap;
    }
    return this.LQO;
  }
  
  protected final boolean agM(int paramInt)
  {
    AppMethodBeat.i(9426);
    boolean bool = super.agM(paramInt);
    switch (c.1.FFo[agL(paramInt).ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(9426);
      return bool;
      bool = false;
    }
  }
  
  protected final void fUL()
  {
    AppMethodBeat.i(9425);
    super.fUL();
    this.LQO = h.B(getResources().getDrawable(2131690010));
    this.LQP = h.B(getResources().getDrawable(2131690009));
    AppMethodBeat.o(9425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.footer.c
 * JD-Core Version:    0.7.0.1
 */
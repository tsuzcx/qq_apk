package com.tencent.mm.view.footer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.g;
import com.tencent.mm.bu.b;
import com.tencent.mm.sdk.platformtools.f;

public final class c
  extends a
{
  private Bitmap Iae;
  private Bitmap Iaf;
  
  public c(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
  }
  
  protected final Bitmap a(g paramg, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    if (paramg == g.cJx)
    {
      if (paramBoolean) {
        localBitmap = this.Iaf;
      }
    }
    else {
      return localBitmap;
    }
    return this.Iae;
  }
  
  protected final boolean abl(int paramInt)
  {
    AppMethodBeat.i(9426);
    boolean bool = super.abl(paramInt);
    switch (1.Cpr[abk(paramInt).ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(9426);
      return bool;
      bool = false;
    }
  }
  
  protected final void fiT()
  {
    AppMethodBeat.i(9425);
    super.fiT();
    this.Iae = f.B(getResources().getDrawable(2131690010));
    this.Iaf = f.B(getResources().getDrawable(2131690009));
    AppMethodBeat.o(9425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.footer.c
 * JD-Core Version:    0.7.0.1
 */
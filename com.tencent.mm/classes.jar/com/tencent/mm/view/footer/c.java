package com.tencent.mm.view.footer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.e;
import com.tencent.mm.bs.b;
import com.tencent.mm.sdk.platformtools.d;

public final class c
  extends a
{
  private Bitmap ATQ;
  private Bitmap ATR;
  
  public c(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
  }
  
  protected final boolean RM(int paramInt)
  {
    AppMethodBeat.i(116447);
    boolean bool = super.RM(paramInt);
    switch (c.1.whp[RL(paramInt).ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(116447);
      return bool;
      bool = false;
    }
  }
  
  protected final Bitmap a(e parame, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    if (parame == e.bWb)
    {
      if (paramBoolean) {
        localBitmap = this.ATR;
      }
    }
    else {
      return localBitmap;
    }
    return this.ATQ;
  }
  
  protected final void dQV()
  {
    AppMethodBeat.i(116446);
    super.dQV();
    this.ATQ = d.u(getResources().getDrawable(2131231205));
    this.ATR = d.u(getResources().getDrawable(2131231204));
    AppMethodBeat.o(116446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.footer.c
 * JD-Core Version:    0.7.0.1
 */
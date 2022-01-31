package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.d.n;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class o
  extends n
{
  private a uss;
  
  public o(a parama)
  {
    this(parama, (byte)0);
  }
  
  private o(a parama, byte paramByte)
  {
    super(2, null);
    this.uss = parama;
  }
  
  public o(String paramString, a parama)
  {
    this(parama, (byte)0);
    AppMethodBeat.i(47535);
    if (!bo.isNullOrNil(paramString)) {
      setColor(Color.parseColor(paramString), ah.getContext().getResources().getColor(2131690488));
    }
    AppMethodBeat.o(47535);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47536);
    if (this.uss != null) {
      this.uss.dj(paramView);
    }
    AppMethodBeat.o(47536);
  }
  
  public final void setColorConfig(int paramInt)
  {
    AppMethodBeat.i(47537);
    Context localContext = ah.getContext();
    super.setColorConfig(paramInt);
    if (paramInt == 5) {
      setColor(localContext.getResources().getColor(2131690709), localContext.getResources().getColor(2131690488));
    }
    AppMethodBeat.o(47537);
  }
  
  public static abstract interface a
  {
    public abstract void dj(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.o
 * JD-Core Version:    0.7.0.1
 */
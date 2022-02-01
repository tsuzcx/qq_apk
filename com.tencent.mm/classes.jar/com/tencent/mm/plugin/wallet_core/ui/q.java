package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class q
  extends o
{
  private a DzD;
  
  public q(int paramInt, a parama)
  {
    super(paramInt, null);
    this.DzD = parama;
  }
  
  public q(a parama)
  {
    this(2, parama);
  }
  
  public q(String paramString, a parama)
  {
    this(2, parama);
    AppMethodBeat.i(71104);
    if (!bu.isNullOrNil(paramString)) {
      setColor(Color.parseColor(paramString), ak.getContext().getResources().getColor(2131100913));
    }
    AppMethodBeat.o(71104);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(71105);
    if (this.DzD != null) {
      this.DzD.dN(paramView);
    }
    AppMethodBeat.o(71105);
  }
  
  public final void setColorConfig(int paramInt)
  {
    AppMethodBeat.i(71106);
    Context localContext = ak.getContext();
    super.setColorConfig(paramInt);
    if (paramInt == 5) {
      setColor(localContext.getResources().getColor(2131101179), localContext.getResources().getColor(2131100913));
    }
    AppMethodBeat.o(71106);
  }
  
  public static abstract interface a
  {
    public abstract void dN(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.q
 * JD-Core Version:    0.7.0.1
 */
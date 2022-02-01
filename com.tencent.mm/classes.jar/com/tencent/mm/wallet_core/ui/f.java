package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;

public final class f
  extends t
{
  private a agUR;
  private boolean agUS = true;
  
  public f(a parama)
  {
    this(parama, true);
  }
  
  public f(a parama, boolean paramBoolean)
  {
    super(7, null);
    this.agUR = parama;
    this.agUS = paramBoolean;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(242186);
    if (this.agUR != null)
    {
      this.agUR.onClick(paramView);
      g.mH(paramView);
    }
    AppMethodBeat.o(242186);
  }
  
  public final void setColorConfig(int paramInt)
  {
    AppMethodBeat.i(242191);
    Context localContext = MMApplicationContext.getContext();
    super.setColorConfig(paramInt);
    if (paramInt == 7)
    {
      setColor(localContext.getResources().getColor(a.c.Link), localContext.getResources().getColor(a.c.FG_3));
      AppMethodBeat.o(242191);
      return;
    }
    if (paramInt == 6) {
      setColor(localContext.getResources().getColor(a.c.UN_Link), localContext.getResources().getColor(a.c.UN_BW_0_Alpha_0_1));
    }
    AppMethodBeat.o(242191);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(242188);
    super.updateDrawState(paramTextPaint);
    if (this.agUS) {
      aw.a(paramTextPaint, 0.8F);
    }
    AppMethodBeat.o(242188);
  }
  
  public static abstract interface a
  {
    public abstract void onClick(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.f
 * JD-Core Version:    0.7.0.1
 */
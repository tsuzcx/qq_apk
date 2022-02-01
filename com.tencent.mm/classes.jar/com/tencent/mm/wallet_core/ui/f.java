package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;

public final class f
  extends p
{
  private a YWW;
  private boolean YWX = true;
  
  public f(a parama)
  {
    this(parama, true);
  }
  
  public f(a parama, boolean paramBoolean)
  {
    super(7, null);
    this.YWW = parama;
    this.YWX = paramBoolean;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203668);
    if (this.YWW != null) {
      this.YWW.bwz();
    }
    AppMethodBeat.o(203668);
  }
  
  public final void setColorConfig(int paramInt)
  {
    AppMethodBeat.i(203672);
    Context localContext = MMApplicationContext.getContext();
    super.setColorConfig(paramInt);
    if (paramInt == 7)
    {
      setColor(localContext.getResources().getColor(a.c.Link), localContext.getResources().getColor(a.c.FG_3));
      AppMethodBeat.o(203672);
      return;
    }
    if (paramInt == 6) {
      setColor(localContext.getResources().getColor(a.c.UN_Link), localContext.getResources().getColor(a.c.UN_BW_0_Alpha_0_1));
    }
    AppMethodBeat.o(203672);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(203669);
    super.updateDrawState(paramTextPaint);
    if (this.YWX) {
      ar.a(paramTextPaint, 0.8F);
    }
    AppMethodBeat.o(203669);
  }
  
  public static abstract interface a
  {
    public abstract void bwz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.f
 * JD-Core Version:    0.7.0.1
 */
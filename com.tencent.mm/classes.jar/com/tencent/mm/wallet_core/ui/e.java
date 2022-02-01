package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;

public final class e
  extends p
{
  private a Rvx;
  
  public e(a parama)
  {
    super(7, null);
    this.Rvx = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(214337);
    if (this.Rvx != null) {
      this.Rvx.bmr();
    }
    AppMethodBeat.o(214337);
  }
  
  public final void setColorConfig(int paramInt)
  {
    AppMethodBeat.i(214339);
    Context localContext = MMApplicationContext.getContext();
    super.setColorConfig(paramInt);
    if (paramInt == 7)
    {
      setColor(localContext.getResources().getColor(2131099783), localContext.getResources().getColor(2131099750));
      AppMethodBeat.o(214339);
      return;
    }
    if (paramInt == 6) {
      setColor(localContext.getResources().getColor(2131099841), localContext.getResources().getColor(2131099832));
    }
    AppMethodBeat.o(214339);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(214338);
    super.updateDrawState(paramTextPaint);
    ao.a(paramTextPaint, 0.8F);
    AppMethodBeat.o(214338);
  }
  
  public static abstract interface a
  {
    public abstract void bmr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.e
 * JD-Core Version:    0.7.0.1
 */
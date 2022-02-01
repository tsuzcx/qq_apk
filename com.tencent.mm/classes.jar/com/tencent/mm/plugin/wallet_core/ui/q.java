package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;

public final class q
  extends p
{
  private a IiO;
  private boolean IiP = false;
  
  public q(int paramInt, a parama)
  {
    super(paramInt, null);
    this.IiO = parama;
  }
  
  public q(a parama)
  {
    this(2, parama);
  }
  
  public q(a parama, byte paramByte)
  {
    super(6, null);
    this.IiO = parama;
    this.IiP = true;
  }
  
  public q(String paramString, a parama)
  {
    this(2, parama);
    AppMethodBeat.i(71104);
    if (!Util.isNullOrNil(paramString)) {
      setColor(Color.parseColor(paramString), MMApplicationContext.getContext().getResources().getColor(2131101130));
    }
    AppMethodBeat.o(71104);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(71105);
    if (this.IiO != null) {
      this.IiO.dF(paramView);
    }
    AppMethodBeat.o(71105);
  }
  
  public final void setColorConfig(int paramInt)
  {
    AppMethodBeat.i(71106);
    Context localContext = MMApplicationContext.getContext();
    super.setColorConfig(paramInt);
    if (paramInt == 5)
    {
      setColor(localContext.getResources().getColor(2131101424), localContext.getResources().getColor(2131101130));
      AppMethodBeat.o(71106);
      return;
    }
    if (paramInt == 6) {
      setColor(localContext.getResources().getColor(2131099841), localContext.getResources().getColor(2131099832));
    }
    AppMethodBeat.o(71106);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(214245);
    super.updateDrawState(paramTextPaint);
    if (this.IiP) {
      ao.a(paramTextPaint, 0.8F);
    }
    AppMethodBeat.o(214245);
  }
  
  public static abstract interface a
  {
    public abstract void dF(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.q
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;

public final class r
  extends p
{
  private a Pbe;
  private boolean Pbf = false;
  
  public r(int paramInt, a parama)
  {
    super(paramInt, null);
    this.Pbe = parama;
  }
  
  public r(a parama)
  {
    this(2, parama);
  }
  
  public r(a parama, byte paramByte)
  {
    super(6, null);
    this.Pbe = parama;
    this.Pbf = true;
  }
  
  public r(String paramString, a parama)
  {
    this(2, parama);
    AppMethodBeat.i(71104);
    if (!Util.isNullOrNil(paramString)) {
      setColor(Color.parseColor(paramString), MMApplicationContext.getContext().getResources().getColor(a.c.sns_link_bg_color));
    }
    AppMethodBeat.o(71104);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(71105);
    if (this.Pbe != null) {
      this.Pbe.ed(paramView);
    }
    AppMethodBeat.o(71105);
  }
  
  public final void setColorConfig(int paramInt)
  {
    AppMethodBeat.i(71106);
    Context localContext = MMApplicationContext.getContext();
    super.setColorConfig(paramInt);
    if (paramInt == 7)
    {
      setColor(localContext.getResources().getColor(a.c.Link), localContext.getResources().getColor(a.c.FG_3));
      AppMethodBeat.o(71106);
      return;
    }
    if (paramInt == 5)
    {
      setColor(localContext.getResources().getColor(a.c.white), localContext.getResources().getColor(a.c.sns_link_bg_color));
      AppMethodBeat.o(71106);
      return;
    }
    if (paramInt == 6) {
      setColor(localContext.getResources().getColor(a.c.UN_Link), localContext.getResources().getColor(a.c.UN_BW_0_Alpha_0_1));
    }
    AppMethodBeat.o(71106);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(195368);
    super.updateDrawState(paramTextPaint);
    if (this.Pbf) {
      ar.a(paramTextPaint, 0.8F);
    }
    AppMethodBeat.o(195368);
  }
  
  public static abstract interface a
  {
    public abstract void ed(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.r
 * JD-Core Version:    0.7.0.1
 */
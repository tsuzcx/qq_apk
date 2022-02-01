package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.wallet_core.ui.g;

public final class s
  extends t
{
  private s.a VRI;
  private boolean VRJ = false;
  
  public s(int paramInt, s.a parama)
  {
    super(paramInt, null);
    this.VRI = parama;
  }
  
  public s(int paramInt, s.a parama, byte paramByte)
  {
    super(paramInt, null);
    this.VRI = parama;
    this.VRJ = true;
  }
  
  public s(s.a parama)
  {
    this(2, parama);
  }
  
  public s(String paramString, s.a parama)
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
    if (this.VRI != null)
    {
      this.VRI.eS(paramView);
      g.mH(paramView);
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
    AppMethodBeat.i(301274);
    super.updateDrawState(paramTextPaint);
    if (this.VRJ) {
      aw.a(paramTextPaint, 0.8F);
    }
    AppMethodBeat.o(301274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.s
 * JD-Core Version:    0.7.0.1
 */
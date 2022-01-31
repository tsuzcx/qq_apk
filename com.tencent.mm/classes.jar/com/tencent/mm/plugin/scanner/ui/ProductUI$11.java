package com.tencent.mm.plugin.scanner.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashMap;

final class ProductUI$11
  implements e.a
{
  ProductUI$11(ProductUI paramProductUI) {}
  
  public final Boolean YA(String paramString)
  {
    AppMethodBeat.i(81093);
    if ((paramString != null) && (paramString.length() > 0))
    {
      paramString = (Boolean)ProductUI.k(this.qyh).get(paramString);
      AppMethodBeat.o(81093);
      return paramString;
    }
    AppMethodBeat.o(81093);
    return null;
  }
  
  public final void a(String paramString, Boolean paramBoolean)
  {
    AppMethodBeat.i(81092);
    if ((paramString != null) && (paramString.length() > 0)) {
      ProductUI.k(this.qyh).put(paramString, paramBoolean);
    }
    AppMethodBeat.o(81092);
  }
  
  public final void ciJ()
  {
    AppMethodBeat.i(81094);
    if (this.qyh.screen != null) {
      this.qyh.screen.notifyDataSetChanged();
    }
    AppMethodBeat.o(81094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.11
 * JD-Core Version:    0.7.0.1
 */
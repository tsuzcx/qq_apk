package com.tencent.mm.view.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.view.SmileyPanelViewPager;
import com.tencent.mm.view.a.i;

final class a$10
  implements k.a
{
  a$10(a parama) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(63034);
    paramString = paramm.obj;
    if ((paramString instanceof Integer)) {}
    for (int i = ((Integer)paramString).intValue(); (!a.d(this.AUz).dRF()) && (i >= 3); i = 0)
    {
      a.d(this.AUz).dRG();
      a.h(this.AUz);
      this.AUz.dRo();
      AppMethodBeat.o(63034);
      return;
    }
    if ((a.i(this.AUz) != null) && (a.c(this.AUz) != null)) {
      a.i(this.AUz).aM(a.c(this.AUz).getCurrentItem(), false);
    }
    AppMethodBeat.o(63034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.view.e.a.10
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.sns.ui.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.o.c.a;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.g;

public final class c
{
  public int RAj;
  public b RHc;
  public c.a RHd;
  public boolean hasInit;
  
  public c()
  {
    AppMethodBeat.i(99838);
    this.RHc = new b();
    this.RHd = null;
    this.RAj = 0;
    this.hasInit = false;
    AppMethodBeat.o(99838);
  }
  
  private void b(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(99839);
    Object localObject = this.RHc;
    if (((b)localObject).RyR != null)
    {
      localObject = ((b)localObject).RyR.RYH;
      g.b(paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt)).c((a)localObject);
    }
    AppMethodBeat.o(99839);
  }
  
  private void c(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(99840);
    Object localObject = this.RHc;
    if (((b)localObject).RyR != null)
    {
      localObject = ((b)localObject).RyR.RYI;
      g.b(paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt)).c((a)localObject);
    }
    AppMethodBeat.o(99840);
  }
  
  public final void d(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(99841);
    if (!this.hasInit)
    {
      AppMethodBeat.o(99841);
      return;
    }
    if (this.RAj == 0) {
      b(paramString, paramBoolean1, paramBoolean2, paramInt);
    }
    AppMethodBeat.o(99841);
  }
  
  public final void e(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(99842);
    if (!this.hasInit)
    {
      AppMethodBeat.o(99842);
      return;
    }
    if (this.RAj == 0) {
      c(paramString, paramBoolean1, paramBoolean2, paramInt);
    }
    AppMethodBeat.o(99842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.c
 * JD-Core Version:    0.7.0.1
 */
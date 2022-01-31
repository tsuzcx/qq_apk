package com.tencent.mm.plugin.sns.ui.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.k.c.a;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.f;

public final class c
{
  public boolean hasInit;
  public int rYo;
  public b sdN;
  public c.a sdO;
  
  public c()
  {
    AppMethodBeat.i(39948);
    this.sdN = new b();
    this.sdO = null;
    this.rYo = 0;
    this.hasInit = false;
    AppMethodBeat.o(39948);
  }
  
  private void b(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(39949);
    Object localObject = this.sdN;
    if (((b)localObject).rXk != null)
    {
      localObject = ((b)localObject).rXk.snv;
      f.b(paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt)).c((a)localObject);
    }
    AppMethodBeat.o(39949);
  }
  
  private void c(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(39950);
    Object localObject = this.sdN;
    if (((b)localObject).rXk != null)
    {
      localObject = ((b)localObject).rXk.snw;
      f.b(paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt)).c((a)localObject);
    }
    AppMethodBeat.o(39950);
  }
  
  public final void d(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(39951);
    if (!this.hasInit)
    {
      AppMethodBeat.o(39951);
      return;
    }
    if (this.rYo == 0) {
      b(paramString, paramBoolean1, paramBoolean2, paramInt);
    }
    AppMethodBeat.o(39951);
  }
  
  public final void e(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(39952);
    if (!this.hasInit)
    {
      AppMethodBeat.o(39952);
      return;
    }
    if (this.rYo == 0) {
      c(paramString, paramBoolean1, paramBoolean2, paramInt);
    }
    AppMethodBeat.o(39952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.c
 * JD-Core Version:    0.7.0.1
 */
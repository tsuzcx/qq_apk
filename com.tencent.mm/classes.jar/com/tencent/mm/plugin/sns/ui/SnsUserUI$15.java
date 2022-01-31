package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.e.b;
import com.tencent.mm.sdk.platformtools.bo;

final class SnsUserUI$15
  extends b
{
  SnsUserUI$15(SnsUserUI paramSnsUserUI) {}
  
  public final void a(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(39805);
    super.a(paramString, paramLong, paramInt);
    if ((paramInt > 0) && (!bo.isNullOrNil(paramString)) && (paramString.endsWith(this.sce.getClass().getSimpleName()))) {
      SnsUserUI.a(this.sce, SnsUserUI.j(this.sce) + paramInt);
    }
    AppMethodBeat.o(39805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI.15
 * JD-Core Version:    0.7.0.1
 */
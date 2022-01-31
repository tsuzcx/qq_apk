package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.e.b;
import com.tencent.mm.sdk.platformtools.bo;

final class SnsMsgUI$10
  extends b
{
  SnsMsgUI$10(SnsMsgUI paramSnsMsgUI) {}
  
  public final void a(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(39075);
    super.a(paramString, paramLong, paramInt);
    if ((paramInt > 0) && (!bo.isNullOrNil(paramString)) && (paramString.endsWith(this.rSU.getClass().getSimpleName()))) {
      SnsMsgUI.a(this.rSU, SnsMsgUI.b(this.rSU) + paramInt);
    }
    AppMethodBeat.o(39075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.10
 * JD-Core Version:    0.7.0.1
 */
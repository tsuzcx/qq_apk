package com.tencent.mm.plugin.subapp.jdbiz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;

final class d$1
  extends o.a
{
  d$1(d paramd) {}
  
  public final void onAppBackground(String paramString) {}
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(28878);
    if (com.tencent.mm.pluginsdk.i.d.JYo != null)
    {
      d.fsQ();
      d.fsX();
    }
    AppMethodBeat.o(28878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.d.1
 * JD-Core Version:    0.7.0.1
 */
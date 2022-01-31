package com.tencent.mm.plugin.subapp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.plugin.subapp.jdbiz.d;
import com.tencent.mm.pluginsdk.f.f;

final class a$1
  extends j.a
{
  a$1(a parama) {}
  
  public final void onAppBackground(String paramString) {}
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(153647);
    if (f.vMG != null)
    {
      d.cGE();
      d.cGL();
    }
    AppMethodBeat.o(153647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.a.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.websearch.widget.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.ui.widget.b.d;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static final a uMK;
  public Map<Integer, d> uMI;
  private c uMJ;
  
  static
  {
    AppMethodBeat.i(91479);
    uMK = new a();
    AppMethodBeat.o(91479);
  }
  
  private a()
  {
    AppMethodBeat.i(91477);
    this.uMI = new HashMap();
    c.a locala = new c.a();
    locala.eNM = true;
    locala.eNL = true;
    this.uMJ = locala.ahY();
    AppMethodBeat.o(91477);
  }
  
  public static a daf()
  {
    return uMK;
  }
  
  public final void JA(int paramInt)
  {
    AppMethodBeat.i(91478);
    d locald = (d)this.uMI.remove(Integer.valueOf(paramInt));
    if (locald != null) {
      locald.cre();
    }
    AppMethodBeat.o(91478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.a
 * JD-Core Version:    0.7.0.1
 */
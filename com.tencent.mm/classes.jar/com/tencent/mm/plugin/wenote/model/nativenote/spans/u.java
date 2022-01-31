package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;

public final class u
{
  public static final b vBC;
  public static final j vBD;
  public static final c vBE;
  public static final l vBF;
  public static final h vBG;
  public static final ArrayList<t> vBH;
  
  static
  {
    AppMethodBeat.i(26975);
    vBC = new b();
    vBD = new j();
    vBE = new c();
    vBF = new l();
    vBG = new h();
    ArrayList localArrayList = new ArrayList();
    vBH = localArrayList;
    localArrayList.add(vBC);
    vBH.add(vBE);
    vBH.add(vBF);
    vBH.add(vBD);
    AppMethodBeat.o(26975);
  }
  
  private static void a(WXRTEditText paramWXRTEditText, o paramo, t... paramVarArgs)
  {
    AppMethodBeat.i(26974);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      if (paramo == paramVarArgs[i])
      {
        AppMethodBeat.o(26974);
        return;
      }
      i += 1;
    }
    paramo.a(paramWXRTEditText, null, null);
    AppMethodBeat.o(26974);
  }
  
  public static void a(WXRTEditText paramWXRTEditText, t... paramVarArgs)
  {
    AppMethodBeat.i(26973);
    a(paramWXRTEditText, vBG, paramVarArgs);
    a(paramWXRTEditText, vBE, paramVarArgs);
    a(paramWXRTEditText, vBF, paramVarArgs);
    a(paramWXRTEditText, vBD, paramVarArgs);
    AppMethodBeat.o(26973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.u
 * JD-Core Version:    0.7.0.1
 */
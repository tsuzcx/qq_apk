package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;

public final class u
{
  public static final b ETt;
  public static final j ETu;
  public static final c ETv;
  public static final l ETw;
  public static final h ETx;
  public static final ArrayList<t> pEv;
  
  static
  {
    AppMethodBeat.i(30669);
    ETt = new b();
    ETu = new j();
    ETv = new c();
    ETw = new l();
    ETx = new h();
    ArrayList localArrayList = new ArrayList();
    pEv = localArrayList;
    localArrayList.add(ETt);
    pEv.add(ETv);
    pEv.add(ETw);
    pEv.add(ETu);
    AppMethodBeat.o(30669);
  }
  
  private static void a(WXRTEditText paramWXRTEditText, o paramo, t... paramVarArgs)
  {
    AppMethodBeat.i(30668);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      if (paramo == paramVarArgs[i])
      {
        AppMethodBeat.o(30668);
        return;
      }
      i += 1;
    }
    paramo.a(paramWXRTEditText, null, null);
    AppMethodBeat.o(30668);
  }
  
  public static void a(WXRTEditText paramWXRTEditText, t... paramVarArgs)
  {
    AppMethodBeat.i(30667);
    a(paramWXRTEditText, ETx, paramVarArgs);
    a(paramWXRTEditText, ETv, paramVarArgs);
    a(paramWXRTEditText, ETw, paramVarArgs);
    a(paramWXRTEditText, ETu, paramVarArgs);
    AppMethodBeat.o(30667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.u
 * JD-Core Version:    0.7.0.1
 */
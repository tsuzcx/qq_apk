package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;

public final class u
{
  public static final b JJh;
  public static final j JJi;
  public static final c JJj;
  public static final l JJk;
  public static final h JJl;
  public static final ArrayList<t> qTM;
  
  static
  {
    AppMethodBeat.i(30669);
    JJh = new b();
    JJi = new j();
    JJj = new c();
    JJk = new l();
    JJl = new h();
    ArrayList localArrayList = new ArrayList();
    qTM = localArrayList;
    localArrayList.add(JJh);
    qTM.add(JJj);
    qTM.add(JJk);
    qTM.add(JJi);
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
    a(paramWXRTEditText, JJl, paramVarArgs);
    a(paramWXRTEditText, JJj, paramVarArgs);
    a(paramWXRTEditText, JJk, paramVarArgs);
    a(paramWXRTEditText, JJi, paramVarArgs);
    AppMethodBeat.o(30667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.u
 * JD-Core Version:    0.7.0.1
 */
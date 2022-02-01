package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;

public final class u
{
  public static final b CXb;
  public static final j CXc;
  public static final c CXd;
  public static final l CXe;
  public static final h CXf;
  public static final ArrayList<t> oUh;
  
  static
  {
    AppMethodBeat.i(30669);
    CXb = new b();
    CXc = new j();
    CXd = new c();
    CXe = new l();
    CXf = new h();
    ArrayList localArrayList = new ArrayList();
    oUh = localArrayList;
    localArrayList.add(CXb);
    oUh.add(CXd);
    oUh.add(CXe);
    oUh.add(CXc);
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
    a(paramWXRTEditText, CXf, paramVarArgs);
    a(paramWXRTEditText, CXd, paramVarArgs);
    a(paramWXRTEditText, CXe, paramVarArgs);
    a(paramWXRTEditText, CXc, paramVarArgs);
    AppMethodBeat.o(30667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.u
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;

public final class u
{
  public static final j QIA;
  public static final c QIB;
  public static final l QIC;
  public static final h QID;
  public static final b QIz;
  public static final ArrayList<t> uvS;
  
  static
  {
    AppMethodBeat.i(30669);
    QIz = new b();
    QIA = new j();
    QIB = new c();
    QIC = new l();
    QID = new h();
    ArrayList localArrayList = new ArrayList();
    uvS = localArrayList;
    localArrayList.add(QIz);
    uvS.add(QIB);
    uvS.add(QIC);
    uvS.add(QIA);
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
    a(paramWXRTEditText, QID, paramVarArgs);
    a(paramWXRTEditText, QIB, paramVarArgs);
    a(paramWXRTEditText, QIC, paramVarArgs);
    a(paramWXRTEditText, QIA, paramVarArgs);
    AppMethodBeat.o(30667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.u
 * JD-Core Version:    0.7.0.1
 */
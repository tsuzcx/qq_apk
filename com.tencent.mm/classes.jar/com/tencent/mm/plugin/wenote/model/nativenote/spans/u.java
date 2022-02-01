package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;

public final class u
{
  public static final b EAX;
  public static final j EAY;
  public static final c EAZ;
  public static final l EBa;
  public static final h EBb;
  public static final ArrayList<t> pxR;
  
  static
  {
    AppMethodBeat.i(30669);
    EAX = new b();
    EAY = new j();
    EAZ = new c();
    EBa = new l();
    EBb = new h();
    ArrayList localArrayList = new ArrayList();
    pxR = localArrayList;
    localArrayList.add(EAX);
    pxR.add(EAZ);
    pxR.add(EBa);
    pxR.add(EAY);
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
    a(paramWXRTEditText, EBb, paramVarArgs);
    a(paramWXRTEditText, EAZ, paramVarArgs);
    a(paramWXRTEditText, EBa, paramVarArgs);
    a(paramWXRTEditText, EAY, paramVarArgs);
    AppMethodBeat.o(30667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.u
 * JD-Core Version:    0.7.0.1
 */
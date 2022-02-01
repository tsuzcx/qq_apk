package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;

public final class u
{
  public static final b XBY;
  public static final j XBZ;
  public static final c XCa;
  public static final l XCb;
  public static final h XCc;
  public static final ArrayList<t> xCr;
  
  static
  {
    AppMethodBeat.i(30669);
    XBY = new b();
    XBZ = new j();
    XCa = new c();
    XCb = new l();
    XCc = new h();
    ArrayList localArrayList = new ArrayList();
    xCr = localArrayList;
    localArrayList.add(XBY);
    xCr.add(XCa);
    xCr.add(XCb);
    xCr.add(XBZ);
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
    a(paramWXRTEditText, XCc, paramVarArgs);
    a(paramWXRTEditText, XCa, paramVarArgs);
    a(paramWXRTEditText, XCb, paramVarArgs);
    a(paramWXRTEditText, XBZ, paramVarArgs);
    AppMethodBeat.o(30667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.u
 * JD-Core Version:    0.7.0.1
 */
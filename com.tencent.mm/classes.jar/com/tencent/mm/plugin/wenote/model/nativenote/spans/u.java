package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;

public final class u
{
  public static final b BEU;
  public static final j BEV;
  public static final c BEW;
  public static final l BEX;
  public static final h BEY;
  public static final ArrayList<t> oqH;
  
  static
  {
    AppMethodBeat.i(30669);
    BEU = new b();
    BEV = new j();
    BEW = new c();
    BEX = new l();
    BEY = new h();
    ArrayList localArrayList = new ArrayList();
    oqH = localArrayList;
    localArrayList.add(BEU);
    oqH.add(BEW);
    oqH.add(BEX);
    oqH.add(BEV);
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
    a(paramWXRTEditText, BEY, paramVarArgs);
    a(paramWXRTEditText, BEW, paramVarArgs);
    a(paramWXRTEditText, BEX, paramVarArgs);
    a(paramWXRTEditText, BEV, paramVarArgs);
    AppMethodBeat.o(30667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.u
 * JD-Core Version:    0.7.0.1
 */
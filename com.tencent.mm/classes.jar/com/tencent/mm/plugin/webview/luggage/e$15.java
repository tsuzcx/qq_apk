package com.tencent.mm.plugin.webview.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key.a;
import java.util.Map;

final class e$15
  extends LuggageGetA8Key.a
{
  e$15(e parame) {}
  
  public final void PQ(String paramString)
  {
    AppMethodBeat.i(153102);
    this.uRQ.PQ(paramString);
    AppMethodBeat.o(153102);
  }
  
  public final void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(153105);
    this.uRQ.uRG = false;
    this.uRQ.X(new e.15.3(this, paramInt1, paramString1, paramInt2, paramInt3, paramString2));
    AppMethodBeat.o(153105);
  }
  
  public final void dbm()
  {
    this.uRQ.uRG = false;
  }
  
  public final void e(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(153103);
    this.uRQ.uRG = false;
    this.uRQ.X(new e.15.1(this, paramString1, paramString2, paramMap));
    AppMethodBeat.o(153103);
  }
  
  public final void hp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(153104);
    this.uRQ.uRG = false;
    this.uRQ.X(new e.15.2(this, paramString1, paramString2));
    AppMethodBeat.o(153104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.15
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

final class v$d
{
  long id;
  v.c pJQ;
  n.b pJR;
  n.c pJS;
  Map<String, String> pJT;
  v.a pJU;
  String uri;
  
  public v$d(v paramv, String paramString, n.b paramb, v.a parama)
  {
    AppMethodBeat.i(68003);
    this.id = System.currentTimeMillis();
    this.uri = paramString;
    this.pJR = paramb;
    this.pJU = parama;
    AppMethodBeat.o(68003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.v.d
 * JD-Core Version:    0.7.0.1
 */
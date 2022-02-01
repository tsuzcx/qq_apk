package com.tencent.mm.plugin.webview.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"deleteChildJs", "", "Lcom/tencent/mm/vfs/VFSFile;", "invoke"})
final class c$b$g
  extends kotlin.g.b.q
  implements b<o, x>
{
  public static final g JDz;
  
  static
  {
    AppMethodBeat.i(82798);
    JDz = new g();
    AppMethodBeat.o(82798);
  }
  
  c$b$g()
  {
    super(1);
  }
  
  public static void Z(o paramo)
  {
    AppMethodBeat.i(175715);
    p.h(paramo, "$this$deleteChildJs");
    paramo = paramo.a((com.tencent.mm.vfs.q)1.JDA);
    if (paramo == null) {
      p.hyc();
    }
    p.g(paramo, "listFiles { filter ->\n  …on\"))\n                }!!");
    int j = paramo.length;
    int i = 0;
    while (i < j)
    {
      paramo[i].delete();
      i += 1;
    }
    AppMethodBeat.o(175715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.c.b.g
 * JD-Core Version:    0.7.0.1
 */
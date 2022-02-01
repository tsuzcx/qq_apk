package com.tencent.mm.plugin.webview.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Worker;", "", "id", "", "isPreload", "", "isRecycled", "(IZZ)V", "getId", "()I", "()Z", "scripts", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "getScripts", "()Ljava/util/LinkedList;", "toString", "", "webview-sdk_release"})
final class c$b$f
{
  final LinkedList<c.b.d> JDp;
  private final boolean aHN;
  private final int id;
  private final boolean ltW;
  
  private c$b$f(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(82792);
    this.id = paramInt;
    this.ltW = paramBoolean1;
    this.aHN = paramBoolean2;
    this.JDp = new LinkedList();
    AppMethodBeat.o(82792);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(82791);
    String str = n.buv("[worker #" + this.id + "]\n                preload: " + this.ltW + "\n                recycled: " + this.aHN + "\n\n                " + j.a((Iterable)this.JDp, (CharSequence)"\n\n", null, null, 0, null, null, 62) + "\n                ");
    AppMethodBeat.o(82791);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.c.b.f
 * JD-Core Version:    0.7.0.1
 */
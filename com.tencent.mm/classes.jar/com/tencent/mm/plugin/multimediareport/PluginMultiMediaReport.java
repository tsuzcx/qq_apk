package com.tencent.mm.plugin.multimediareport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.zero.a.d;

public class PluginMultiMediaReport
  extends f
  implements b
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(194287);
    new e();
    AppMethodBeat.o(194287);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(194286);
    dependsOn(d.class);
    AppMethodBeat.o(194286);
  }
  
  public void execute(g paramg) {}
  
  public void installed()
  {
    AppMethodBeat.i(194285);
    alias(b.class);
    AppMethodBeat.o(194285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multimediareport.PluginMultiMediaReport
 * JD-Core Version:    0.7.0.1
 */
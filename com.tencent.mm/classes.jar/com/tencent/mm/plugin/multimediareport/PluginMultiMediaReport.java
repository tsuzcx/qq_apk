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
    AppMethodBeat.i(187527);
    new e();
    AppMethodBeat.o(187527);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(187525);
    dependsOn(d.class);
    AppMethodBeat.o(187525);
  }
  
  public void execute(g paramg) {}
  
  public void installed()
  {
    AppMethodBeat.i(187523);
    alias(b.class);
    AppMethodBeat.o(187523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multimediareport.PluginMultiMediaReport
 * JD-Core Version:    0.7.0.1
 */
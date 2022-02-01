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
    AppMethodBeat.i(262713);
    new e();
    AppMethodBeat.o(262713);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(262710);
    dependsOn(d.class);
    AppMethodBeat.o(262710);
  }
  
  public void execute(g paramg) {}
  
  public void installed()
  {
    AppMethodBeat.i(262707);
    alias(b.class);
    AppMethodBeat.o(262707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multimediareport.PluginMultiMediaReport
 * JD-Core Version:    0.7.0.1
 */
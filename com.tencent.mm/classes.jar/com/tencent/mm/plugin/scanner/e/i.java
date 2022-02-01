package com.tencent.mm.plugin.scanner.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNStrategyFactory;", "", "()V", "create", "Lcom/tencent/mm/plugin/scanner/image/IAiScanImageCDNStrategy;", "type", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i OQB;
  
  static
  {
    AppMethodBeat.i(313624);
    OQB = new i();
    AppMethodBeat.o(313624);
  }
  
  public static k ahK(int paramInt)
  {
    AppMethodBeat.i(313618);
    switch (paramInt)
    {
    case 8: 
    default: 
      localk = (k)new d();
      AppMethodBeat.o(313618);
      return localk;
    case 3: 
    case 4: 
      localk = (k)new b();
      AppMethodBeat.o(313618);
      return localk;
    }
    k localk = (k)new j();
    AppMethodBeat.o(313618);
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.i
 * JD-Core Version:    0.7.0.1
 */
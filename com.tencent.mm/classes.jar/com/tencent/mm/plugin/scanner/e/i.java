package com.tencent.mm.plugin.scanner.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNStrategyFactory;", "", "()V", "create", "Lcom/tencent/mm/plugin/scanner/image/IAiScanImageCDNStrategy;", "type", "", "plugin-scan_release"})
public final class i
{
  public static final i IJO;
  
  static
  {
    AppMethodBeat.i(217033);
    IJO = new i();
    AppMethodBeat.o(217033);
  }
  
  public static k adn(int paramInt)
  {
    AppMethodBeat.i(217031);
    if ((paramInt == 3) || (paramInt == 4))
    {
      localk = (k)new b();
      AppMethodBeat.o(217031);
      return localk;
    }
    if ((paramInt == 5) || (paramInt == 6) || (paramInt == 7) || (paramInt == 9))
    {
      localk = (k)new j();
      AppMethodBeat.o(217031);
      return localk;
    }
    k localk = (k)new d();
    AppMethodBeat.o(217031);
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.i
 * JD-Core Version:    0.7.0.1
 */
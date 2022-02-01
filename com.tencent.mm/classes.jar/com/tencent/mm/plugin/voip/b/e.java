package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.h;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/util/VoipRendererHelper;", "", "()V", "isUseNewVoipRenderer", "", "plugin-voip_release"})
public final class e
{
  public static final e ztn;
  
  static
  {
    AppMethodBeat.i(192315);
    ztn = new e();
    AppMethodBeat.o(192315);
  }
  
  public static final boolean dWu()
  {
    AppMethodBeat.i(192314);
    if (h.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(192314);
      return true;
    }
    boolean bool;
    switch (ae.fFH.fCE)
    {
    case 0: 
    default: 
      bool = ((b)g.ab(b.class)).a(b.a.poK, false);
      AppMethodBeat.o(192314);
      return bool;
    case -1: 
      bool = ((b)g.ab(b.class)).a(b.a.poK, false);
      AppMethodBeat.o(192314);
      return bool;
    case 2: 
      AppMethodBeat.o(192314);
      return false;
    }
    AppMethodBeat.o(192314);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.e
 * JD-Core Version:    0.7.0.1
 */
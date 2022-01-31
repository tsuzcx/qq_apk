package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.Map;

public class aj
{
  private static volatile aj uJO;
  private al fPW;
  private volatile boolean uJJ;
  private volatile boolean uJK;
  private volatile Boolean uJL;
  private l uJM;
  private Map<Integer, ak> uJN;
  
  private aj()
  {
    AppMethodBeat.i(124179);
    this.uJJ = false;
    this.uJK = false;
    this.uJM = new ae();
    AppMethodBeat.o(124179);
  }
  
  public static aj cZB()
  {
    AppMethodBeat.i(124180);
    if (uJO == null) {}
    try
    {
      if (uJO == null) {
        uJO = new aj();
      }
      aj localaj = uJO;
      AppMethodBeat.o(124180);
      return localaj;
    }
    finally
    {
      AppMethodBeat.o(124180);
    }
  }
  
  public final l Jr(int paramInt)
  {
    AppMethodBeat.i(124181);
    if (paramInt <= 0)
    {
      localObject = this.uJM;
      AppMethodBeat.o(124181);
      return localObject;
    }
    if (this.uJN == null) {
      this.uJN = new HashMap();
    }
    ak localak = (ak)this.uJN.get(Integer.valueOf(paramInt));
    Object localObject = localak;
    if (localak == null)
    {
      localObject = new ak(paramInt);
      this.uJN.put(Integer.valueOf(paramInt), localObject);
    }
    AppMethodBeat.o(124181);
    return localObject;
  }
  
  public final boolean Js(int paramInt)
  {
    AppMethodBeat.i(124187);
    if (!ah.brt())
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("please call from main process");
      AppMethodBeat.o(124187);
      throw localIllegalStateException;
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(124187);
      return false;
    case 1: 
      bool = cZD();
      AppMethodBeat.o(124187);
      return bool;
    }
    boolean bool = cZE();
    AppMethodBeat.o(124187);
    return bool;
  }
  
  public final void cZC()
  {
    AppMethodBeat.i(124184);
    if (this.fPW == null)
    {
      this.fPW = new al();
      this.fPW.ac(new aj.2(this));
    }
    AppMethodBeat.o(124184);
  }
  
  public final boolean cZD()
  {
    AppMethodBeat.i(124185);
    if (this.uJL != null)
    {
      ab.i("MicroMsg.WebSearch.WebSearchPreloadExport", "openSearchPreload cmdPreloadSwitch %b", new Object[] { this.uJL });
      bool = this.uJL.booleanValue();
      AppMethodBeat.o(124185);
      return bool;
    }
    if (aa.Jf(0) < 80007181)
    {
      ab.e("MicroMsg.WebSearch.WebSearchPreloadExport", "current search template not support preload");
      AppMethodBeat.o(124185);
      return false;
    }
    boolean bool = this.uJJ;
    AppMethodBeat.o(124185);
    return bool;
  }
  
  public final boolean cZE()
  {
    AppMethodBeat.i(124186);
    if (this.uJL != null)
    {
      ab.i("MicroMsg.WebSearch.WebSearchPreloadExport", "isOpenRecommendPreload cmdPreloadSwitch %b", new Object[] { this.uJL });
      bool = this.uJL.booleanValue();
      AppMethodBeat.o(124186);
      return bool;
    }
    boolean bool = this.uJK;
    AppMethodBeat.o(124186);
    return bool;
  }
  
  public final void dK(String paramString, int paramInt)
  {
    AppMethodBeat.i(124182);
    ab.i("MicroMsg.WebSearch.WebSearchPreloadExport", "preloadWebview 1 %s", new Object[] { ah.getProcessName() });
    if (ah.dsW())
    {
      Jr(paramInt).agp(paramString);
      AppMethodBeat.o(124182);
      return;
    }
    if (ah.brt()) {
      g.RO().ac(new aj.1(this, paramInt, paramString));
    }
    AppMethodBeat.o(124182);
  }
  
  public final void oh(boolean paramBoolean)
  {
    AppMethodBeat.i(124183);
    this.uJL = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(124183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.aj
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.chatting.gallery.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.websearch.api.c;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonConfigManager;", "", "()V", "TAG", "", "openImageSearch", "", "showScanCodeButton", "showSearchBubble", "showSearchButton", "init", "", "app_release"})
public final class d
{
  private static boolean WWN;
  private static boolean WWO;
  private static boolean WWP;
  private static boolean WWQ;
  public static final d WWR;
  
  static
  {
    AppMethodBeat.i(276167);
    WWR = new d();
    WWN = true;
    AppMethodBeat.o(276167);
  }
  
  public static final boolean hSX()
  {
    return WWN;
  }
  
  public static final boolean hSY()
  {
    return WWP;
  }
  
  public static final boolean hSZ()
  {
    return WWQ;
  }
  
  public static final void init()
  {
    AppMethodBeat.i(276164);
    int i = ((b)h.ae(b.class)).a(b.a.vOg, 0);
    int j;
    if (i == 0)
    {
      bool = true;
      WWN = bool;
      a locala = h.ag(c.class);
      p.j(locala, "MMKernel.plugin(IPluginWebSearch::class.java)");
      bool = ((c)locala).isOpenImageSearch();
      WWO = bool;
      WWP = bool;
      j = ((b)h.ae(b.class)).a(b.a.vOi, 0);
      if ((!WWO) || ((j != 1) && (!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED))) {
        break label183;
      }
    }
    label183:
    for (boolean bool = true;; bool = false)
    {
      WWQ = bool;
      Log.i("MicroMsg.ImageScanCodeConfigManager", "ImageScanCodeConfigManager init config: %d, showScanCodeButton: %b, openImageSearch: %b, showSearchButton: %b, showSearchBubbleConfig: %d, showSearchBubble: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(WWN), Boolean.valueOf(WWO), Boolean.valueOf(WWP), Integer.valueOf(j), Boolean.valueOf(WWQ) });
      AppMethodBeat.o(276164);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.d
 * JD-Core Version:    0.7.0.1
 */
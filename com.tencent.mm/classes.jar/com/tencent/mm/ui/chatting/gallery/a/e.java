package com.tencent.mm.ui.chatting.gallery.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.websearch.api.c;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonConfigManager;", "", "()V", "TAG", "", "openImageSearch", "", "showScanCodeButton", "showSearchBubble", "showSearchButton", "init", "", "app_release"})
public final class e
{
  private static boolean PBR;
  private static boolean PBS;
  private static boolean PBT;
  private static boolean PBU;
  public static final e PBV;
  
  static
  {
    AppMethodBeat.i(231225);
    PBV = new e();
    PBR = true;
    AppMethodBeat.o(231225);
  }
  
  public static final boolean gTr()
  {
    return PBR;
  }
  
  public static final boolean gTs()
  {
    return PBT;
  }
  
  public static final boolean gTt()
  {
    return PBU;
  }
  
  public static final void init()
  {
    AppMethodBeat.i(231224);
    int i = ((b)g.af(b.class)).a(b.a.seE, 0);
    int j;
    if (i == 0)
    {
      bool = true;
      PBR = bool;
      a locala = g.ah(c.class);
      p.g(locala, "MMKernel.plugin(IPluginWebSearch::class.java)");
      bool = ((c)locala).isOpenImageSearch();
      PBS = bool;
      PBT = bool;
      j = ((b)g.af(b.class)).a(b.a.seG, 0);
      if ((!PBS) || ((j != 1) && (!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED))) {
        break label183;
      }
    }
    label183:
    for (boolean bool = true;; bool = false)
    {
      PBU = bool;
      Log.i("MicroMsg.ImageScanCodeConfigManager", "ImageScanCodeConfigManager init config: %d, showScanCodeButton: %b, openImageSearch: %b, showSearchButton: %b, showSearchBubbleConfig: %d, showSearchBubble: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(PBR), Boolean.valueOf(PBS), Boolean.valueOf(PBT), Integer.valueOf(j), Boolean.valueOf(PBU) });
      AppMethodBeat.o(231224);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.e
 * JD-Core Version:    0.7.0.1
 */
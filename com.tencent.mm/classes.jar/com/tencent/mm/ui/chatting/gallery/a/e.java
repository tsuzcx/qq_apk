package com.tencent.mm.ui.chatting.gallery.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.websearch.api.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.j;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonConfigManager;", "", "()V", "TAG", "", "openImageSearch", "", "showScanCodeButton", "showSearchBubble", "showSearchButton", "init", "", "app_release"})
public final class e
{
  private static boolean KpJ;
  private static boolean KpK;
  private static boolean KpL;
  public static final e KpM;
  private static boolean OAw;
  
  static
  {
    AppMethodBeat.i(188274);
    KpM = new e();
    KpJ = true;
    AppMethodBeat.o(188274);
  }
  
  public static final boolean fKZ()
  {
    return KpJ;
  }
  
  public static final boolean fLa()
  {
    return KpK;
  }
  
  public static final boolean fLb()
  {
    return KpL;
  }
  
  public static final void init()
  {
    AppMethodBeat.i(188273);
    int i = ((b)g.ab(b.class)).a(b.a.qJf, 0);
    int j;
    if (i == 0)
    {
      bool = true;
      KpJ = bool;
      a locala = g.ad(c.class);
      p.g(locala, "MMKernel.plugin(IPluginWebSearch::class.java)");
      bool = ((c)locala).isOpenImageSearch();
      OAw = bool;
      KpK = bool;
      j = ((b)g.ab(b.class)).a(b.a.qJh, 0);
      if ((!OAw) || ((j != 1) && (!j.DEBUG) && (!j.IS_FLAVOR_RED))) {
        break label183;
      }
    }
    label183:
    for (boolean bool = true;; bool = false)
    {
      KpL = bool;
      ae.i("MicroMsg.ImageScanCodeConfigManager", "ImageScanCodeConfigManager init config: %d, showScanCodeButton: %b, openImageSearch: %b, showSearchButton: %b, showSearchBubbleConfig: %d, showSearchBubble: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(KpJ), Boolean.valueOf(OAw), Boolean.valueOf(KpK), Integer.valueOf(j), Boolean.valueOf(KpL) });
      AppMethodBeat.o(188273);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.e
 * JD-Core Version:    0.7.0.1
 */
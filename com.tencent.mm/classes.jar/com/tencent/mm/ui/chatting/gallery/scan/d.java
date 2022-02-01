package com.tencent.mm.ui.chatting.gallery.scan;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonConfigManager;", "", "()V", "TAG", "", "openImageSearch", "", "showScanCodeButton", "showSearchBubble", "showSearchButton", "init", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d aeGr;
  private static boolean aeGs;
  private static boolean aeGt;
  private static boolean aeGu;
  private static boolean aeGv;
  
  static
  {
    AppMethodBeat.i(254808);
    aeGr = new d();
    aeGs = true;
    AppMethodBeat.o(254808);
  }
  
  public static final void init()
  {
    AppMethodBeat.i(254802);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zgx, 0);
    int j;
    if (i == 0)
    {
      bool = true;
      aeGs = bool;
      bool = ((com.tencent.mm.plugin.websearch.api.c)h.az(com.tencent.mm.plugin.websearch.api.c.class)).isOpenImageSearch();
      aeGt = bool;
      aeGu = bool;
      j = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zgz, 0);
      if ((!aeGt) || ((j != 1) && (!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED))) {
        break label175;
      }
    }
    label175:
    for (boolean bool = true;; bool = false)
    {
      aeGv = bool;
      Log.i("MicroMsg.ImageScanCodeConfigManager", "ImageScanCodeConfigManager init config: %d, showScanCodeButton: %b, openImageSearch: %b, showSearchButton: %b, showSearchBubbleConfig: %d, showSearchBubble: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(aeGs), Boolean.valueOf(aeGt), Boolean.valueOf(aeGu), Integer.valueOf(j), Boolean.valueOf(aeGv) });
      AppMethodBeat.o(254802);
      return;
      bool = false;
      break;
    }
  }
  
  public static final boolean jwA()
  {
    return aeGs;
  }
  
  public static final boolean jwB()
  {
    return aeGu;
  }
  
  public static final boolean jwC()
  {
    return aeGv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.scan.d
 * JD-Core Version:    0.7.0.1
 */
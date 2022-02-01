package com.tencent.mm.ui.chatting.gallery.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeConfigManager;", "", "()V", "TAG", "", "showScanCodeButton", "", "init", "", "app_release"})
public final class e
{
  private static boolean JUu;
  public static final e JUv;
  
  static
  {
    AppMethodBeat.i(194891);
    JUv = new e();
    JUu = true;
    AppMethodBeat.o(194891);
  }
  
  public static final boolean fGS()
  {
    return JUu;
  }
  
  public static final void init()
  {
    AppMethodBeat.i(194890);
    int i = ((b)g.ab(b.class)).a(b.a.qBM, 0);
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      JUu = bool;
      ad.i("MicroMsg.ImageScanCodeConfigManager", "ImageScanCodeConfigManager init config: %d, showScanCodeButton: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(JUu) });
      AppMethodBeat.o(194890);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.e
 * JD-Core Version:    0.7.0.1
 */
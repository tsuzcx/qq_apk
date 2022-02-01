package com.tencent.mm.plugin.webcanvas;

import com.tencent.magicbrush.d;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MBViewManager.a;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$magicBrush$2$2", "Lcom/tencent/magicbrush/ui/MBViewManager$Listener;", "eleIds", "", "getEleIds", "()Ljava/lang/String;", "onViewAdd", "", "v", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "onViewRemove", "webview-sdk_release"})
public final class b$d
  implements MBViewManager.a
{
  b$d(d paramd, b paramb) {}
  
  private final String eLf()
  {
    AppMethodBeat.i(214038);
    Object localObject = new LinkedList();
    this.Dyu.cwM.forEach((d.g.a.b)new q((LinkedList)localObject) {});
    localObject = j.a((Iterable)localObject, (CharSequence)",", (CharSequence)"[", (CharSequence)"]", 0, null, null, 56);
    AppMethodBeat.o(214038);
    return localObject;
  }
  
  public final void a(MagicBrushView paramMagicBrushView)
  {
    AppMethodBeat.i(214040);
    p.h(paramMagicBrushView, "v");
    ad.d(b.b(this.Dyt), "magicBrush onViewRemove " + paramMagicBrushView.getVirtualElementId() + " remains:" + eLf());
    AppMethodBeat.o(214040);
  }
  
  public final void b(MagicBrushView paramMagicBrushView)
  {
    AppMethodBeat.i(214039);
    p.h(paramMagicBrushView, "v");
    ad.d(b.b(this.Dyt), "magicBrush onViewAdd " + paramMagicBrushView.getVirtualElementId() + " remains:" + eLf());
    AppMethodBeat.o(214039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.b.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.webcanvas;

import android.webkit.ValueCallback;
import com.tencent.magicbrush.ui.MagicBrushView.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ab.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.ui.ao;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.g.b.p;
import kotlin.g.b.z.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webcanvas/WebCanvasViewContext$elementId$1$4", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "onSurfaceAvailable", "", "surface", "", "width", "", "height", "canReadPixelsFromJava", "", "onSurfaceDestroyed", "syncDestroy", "webview-sdk_release"})
public final class n$c
  implements MagicBrushView.c
{
  n$c(z.a parama1, String paramString, z.a parama2, n paramn) {}
  
  public final void a(Object paramObject, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(224765);
    p.h(paramObject, "surface");
    this.IAV.SYB = true;
    paramObject = this.IAT.IAS.Iza;
    final long l;
    if (paramObject != null)
    {
      l = paramObject.start;
      Log.d(this.IAT.TAG, "magicBrushView onSurfaceAvailable:" + this.pAl + ", dur:" + (MMSlotKt.now() - l) + "ms");
      a locala = this.IAT.IAS;
      if (!locala.Izd) {
        break label507;
      }
      Object localObject1 = locala.Izb;
      if (localObject1 == null) {
        break label501;
      }
      Object localObject2 = locala.Izc;
      if (localObject2 == null) {
        break label496;
      }
      paramBoolean = ((a.e)localObject2).crv;
      paramObject = f.IBd;
      if ((paramBoolean == ao.isDarkMode()) && (((a.e)localObject2).fontSize == locala.getFontSize()) && (((a.e)localObject2).orientation == a.fWp()) && (((a.e)localObject2).width == ((a.f)localObject1).width) && (((a.e)localObject2).height == ((a.f)localObject1).height)) {
        break label490;
      }
      paramBoolean = true;
      label202:
      if (paramBoolean)
      {
        paramObject = a.TAG;
        localObject1 = new StringBuilder("lastDrawChanged: [").append(((a.e)localObject2).width).append(", ").append(((a.e)localObject2).height).append(", ").append(((a.e)localObject2).fontSize).append(", ").append(((a.e)localObject2).crv).append("] ").append(((a.e)localObject2).orientation).append(" to [").append(((a.f)localObject1).width).append(", ").append(((a.f)localObject1).height).append(", ").append(locala.getFontSize()).append(", ");
        localObject2 = f.IBd;
        Log.i(paramObject, ao.isDarkMode() + ' ' + a.fWp() + ']');
      }
      paramObject = Boolean.valueOf(paramBoolean);
      label368:
      if (paramObject == null) {
        break label501;
      }
      paramBoolean = paramObject.booleanValue();
      label378:
      if (paramBoolean) {
        locala.fWl().bw(locala.lAN, l);
      }
      if (!paramBoolean) {
        break label507;
      }
      paramInt1 = 1;
      label405:
      if (paramInt1 == 0) {
        break label512;
      }
      Log.i(this.IAT.TAG, "checkDrawChanged:" + this.pAl);
      this.IAT.IAS.fWo();
    }
    for (;;)
    {
      this.IAT.IAS.fWk().IAp.remove(this.IAT.IAS.lAN);
      AppMethodBeat.o(224765);
      return;
      l = -1L;
      break;
      label490:
      paramBoolean = false;
      break label202;
      label496:
      paramObject = null;
      break label368;
      label501:
      paramBoolean = true;
      break label378;
      label507:
      paramInt1 = 0;
      break label405;
      label512:
      this.IAT.IAS.fWk().a(l, this.IAT.IAS.lAN, (ValueCallback)new ValueCallback() {});
    }
  }
  
  public final void a(Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(224766);
    p.h(paramObject, "surface");
    Log.d(this.IAT.TAG, "onSurfaceDestroyed:" + this.pAl);
    this.IAT.IAS.fWk().IAp.add(this.IAT.IAS.lAN);
    this.IAW.SYB = true;
    AppMethodBeat.o(224766);
  }
  
  public final void c(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(224767);
    p.h(paramObject, "surface");
    p.h(paramObject, "surface");
    AppMethodBeat.o(224767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.n.c
 * JD-Core Version:    0.7.0.1
 */
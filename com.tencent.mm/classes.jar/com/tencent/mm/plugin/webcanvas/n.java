package com.tencent.mm.plugin.webcanvas;

import android.content.Context;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.c;
import com.tencent.magicbrush.ui.MagicBrushView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ab.f;
import com.tencent.mm.plugin.ac.c;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.z.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasViewContext;", "", "canvasContext", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext;Landroid/content/Context;)V", "TAG", "", "getCanvasContext", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext;", "canvasId", "getCanvasId", "()Ljava/lang/String;", "contextId", "", "getContextId", "()I", "elementId", "getElementId", "logicJsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "getLogicJsEngine", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "magicBrushView", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "getMagicBrushView", "()Lcom/tencent/magicbrush/ui/MagicBrushView;", "renderJsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "getRenderJsEngine", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "config", "", "webview-sdk_release"})
public final class n
{
  final int IAR;
  final a IAS;
  final String TAG;
  final int biJ;
  
  public n(a parama, Context paramContext)
  {
    AppMethodBeat.i(224770);
    this.IAS = parama;
    this.TAG = "MicroMsg.WebCanvasViewContext";
    parama = this.IAS.fWk().bME();
    Object localObject = new f((com.tencent.mm.plugin.ab.g)this.IAS);
    p.g(parama, "this");
    ((f)localObject).f((i)parama);
    p.g(parama, "canvasContext.renderJsEn…ntext).attach(this)\n    }");
    this.IAR = parama.bMC();
    parama = new MagicBrushView(paramContext, MagicBrushView.h.cPd);
    paramContext = "#" + this.IAS.lAN + ':' + this.IAR + '@' + parama.getVirtualElementId();
    localObject = this.IAS.fWk();
    ((k)localObject).fWD();
    parama.setMagicBrush(((k)localObject).pqH);
    Log.i(this.TAG, "createCanvasView:".concat(String.valueOf(paramContext)));
    parama.setOpaque(false);
    parama.setClipChildren(false);
    parama.setClipToPadding(false);
    parama.setEnableTouchEvent(false);
    parama.setOnTouchListener((View.OnTouchListener)new n.a(this));
    localObject = new z.a();
    ((z.a)localObject).SYB = false;
    z.a locala = new z.a();
    locala.SYB = false;
    parama.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)new n.b(parama, paramContext, (z.a)localObject, locala, this));
    parama.a((MagicBrushView.c)new n.c((z.a)localObject, paramContext, locala, this));
    this.biJ = parama.getVirtualElementId();
    AppMethodBeat.o(224770);
  }
  
  public final MagicBrushView MQ()
  {
    AppMethodBeat.i(224769);
    MagicBrushView localMagicBrushView = this.IAS.fWk().pqH.cLz.find(this.biJ);
    AppMethodBeat.o(224769);
    return localMagicBrushView;
  }
  
  public final void cYb()
  {
    AppMethodBeat.i(224768);
    k localk = this.IAS.fWk();
    com.tencent.mm.plugin.appbrand.m.g localg = this.IAS.fWk().xX(this.IAR);
    p.g(localg, "renderJsEngine.getJsContext(contextId)");
    c.a(localk, localg, "CanvasRender#" + this.IAS.lAN, null, null, null, 28);
    AppMethodBeat.o(224768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.n
 * JD-Core Version:    0.7.0.1
 */
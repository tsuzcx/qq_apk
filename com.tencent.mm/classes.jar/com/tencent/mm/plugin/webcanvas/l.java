package com.tencent.mm.plugin.webcanvas;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.c;
import com.tencent.magicbrush.ui.MagicBrushView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.ax.c.a;
import com.tencent.mm.plugin.ax.f;
import com.tencent.mm.plugin.ax.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.ui.aw;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasViewContext;", "", "canvasContext", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext;Landroid/content/Context;)V", "TAG", "", "getCanvasContext", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext;", "canvasId", "getCanvasId", "()Ljava/lang/String;", "contextId", "", "getContextId", "()I", "elementId", "getElementId", "logicJsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "getLogicJsEngine", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "magicBrushView", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "getMagicBrushView", "()Lcom/tencent/magicbrush/ui/MagicBrushView;", "renderJsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "getRenderJsEngine", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "tmpMagicBrushView", "getTmpMagicBrushView", "setTmpMagicBrushView", "(Lcom/tencent/magicbrush/ui/MagicBrushView;)V", "config", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  final String TAG;
  final a Wlx;
  final int Wly;
  private MagicBrushView Wlz;
  final int cMj;
  
  public l(final a parama, final Context paramContext)
  {
    AppMethodBeat.i(261253);
    this.Wlx = parama;
    this.TAG = "MicroMsg.WebCanvasViewContext";
    parama = this.Wlx.ioh().sSV.czj();
    Object localObject = new f((com.tencent.mm.plugin.ax.g)this.Wlx);
    s.s(parama, "this");
    ((f)localObject).l((com.tencent.mm.plugin.appbrand.n.i)parama);
    localObject = ah.aiuX;
    this.Wly = parama.czh();
    parama = new MagicBrushView(paramContext, MagicBrushView.h.eKZ);
    paramContext = "#" + this.Wlx.rzx + ':' + this.Wly + '@' + parama.getVirtualElementId();
    this.Wlz = parama;
    localObject = this.Wlx.ioh();
    ((i)localObject).ioH();
    parama.setMagicBrush(((i)localObject).SKU);
    Log.i(this.TAG, s.X("createCanvasView:", paramContext));
    parama.setOpaque(false);
    parama.setClipChildren(false);
    parama.setClipToPadding(false);
    parama.setEnableTouchEvent(false);
    parama.setOnTouchListener(new l..ExternalSyntheticLambda0(this));
    localObject = new ah.a();
    final ah.a locala = new ah.a();
    parama.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)new a(this, parama, paramContext, (ah.a)localObject, locala));
    parama.a((MagicBrushView.c)new b((ah.a)localObject, this, paramContext, locala));
    this.Wlx.ioh().WkV.add(this.Wlx.rzx);
    paramContext = ah.aiuX;
    this.cMj = parama.getVirtualElementId();
    AppMethodBeat.o(261253);
  }
  
  private static final boolean a(l paraml, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(261259);
    s.u(paraml, "this$0");
    paramView = paraml.Wlx.ioi();
    Object localObject = paraml.Wlx.rzx;
    s.s(paramMotionEvent, "event");
    s.u(localObject, "canvasId");
    s.u(paramMotionEvent, "touch");
    switch (paramMotionEvent.getAction())
    {
    default: 
      paraml = null;
    }
    for (;;)
    {
      if (paraml != null)
      {
        int i = paramMotionEvent.getActionIndex();
        paramView = (com.tencent.mm.plugin.ax.c)paramView;
        localObject = new StringBuilder("\n                {\n                    target:\"").append((String)localObject).append("\",\n                    touches: [{\n                        identifier:").append(paramMotionEvent.getPointerId(i)).append(",\n                        clientX:");
        f.a locala = f.WlF;
        localObject = ((StringBuilder)localObject).append(f.a.e((Number)Float.valueOf(paramMotionEvent.getX()))).append(",\n                        clientY:");
        locala = f.WlF;
        c.a.a(paramView, paraml, n.bJB(f.a.e((Number)Float.valueOf(paramMotionEvent.getY())) + "\n                    }]\n                }\n            "), null, 4);
      }
      AppMethodBeat.o(261259);
      return true;
      paraml = "touchend";
      continue;
      paraml = "touchstart";
      continue;
      paraml = "touchmove";
      continue;
      paraml = "touchcancel";
    }
  }
  
  public final MagicBrushView apS()
  {
    AppMethodBeat.i(261272);
    MagicBrushView localMagicBrushView = this.Wlz;
    if (localMagicBrushView == null)
    {
      localMagicBrushView = this.Wlx.ioh().SKU.eHD.find(this.cMj);
      AppMethodBeat.o(261272);
      return localMagicBrushView;
    }
    AppMethodBeat.o(261272);
    return localMagicBrushView;
  }
  
  public final void dVw()
  {
    AppMethodBeat.i(261267);
    com.tencent.mm.plugin.ay.c localc = (com.tencent.mm.plugin.ay.c)this.Wlx.ioh();
    com.tencent.mm.plugin.appbrand.n.g localg = this.Wlx.ioh().BK(this.Wly);
    s.s(localg, "renderJsEngine.getJsContext(contextId)");
    com.tencent.mm.plugin.ay.c.a(localc, localg, s.X("CanvasRender#", this.Wlx.rzx), null, null, null, 28);
    AppMethodBeat.o(261267);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webcanvas/WebCanvasViewContext$elementId$1$3", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements View.OnAttachStateChangeListener
  {
    a(l paraml, MagicBrushView paramMagicBrushView, String paramString, ah.a parama1, ah.a parama2) {}
    
    public final void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(261281);
      paramView = a.WjK;
      if (a.a.ios())
      {
        paramView = a.WjK;
        int i = a.ioq();
        a.asP(i + 1);
        if (i == 0) {
          this.WlA.Wlx.ioh().ioH();
        }
      }
      paramView = this.WlA.Wlx.ioi();
      String str = this.WlA.Wlx.rzx;
      s.u(str, "canvasId");
      Log.i(paramView.TAG, s.X("attach #", str));
      c.a(paramView, "attach", str);
      this.WlA.Wlx.ioh().bhT(this.WlA.Wlx.rzx);
      this.WlA.Wlx.iol();
      parama.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new a(parama, this.WlA, paramContext, this.WlB, locala));
      AppMethodBeat.o(261281);
    }
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      AppMethodBeat.i(261289);
      this.WlA.Wlx.iom();
      paramView = this.WlA.Wlx.ioi();
      String str = this.WlA.Wlx.rzx;
      s.u(str, "canvasId");
      c.a(paramView, "detach", str);
      i.a(this.WlA.Wlx.ioh(), this.WlA.Wlx.rzx);
      locala.aiwY = true;
      paramView = a.WjK;
      if (a.a.ios())
      {
        paramView = a.WjK;
        a.asP(a.ioq() - 1);
        if (a.ioq() == 0) {
          this.WlA.Wlx.ioh().ioI();
        }
      }
      AppMethodBeat.o(261289);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webcanvas/WebCanvasViewContext$elementId$1$3$onViewAttachedToWindow$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements ViewTreeObserver.OnGlobalLayoutListener
    {
      a(MagicBrushView paramMagicBrushView, l paraml, String paramString, ah.a parama1, ah.a parama2) {}
      
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(261186);
        this.SLA.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        Log.d(this.WlA.TAG, "onAttachedToWindow:" + this.vQo + " height= " + this.SLA.getHeight());
        j localj;
        if ((!this.WlB.aiwY) && (!this.WlC.aiwY))
        {
          localj = j.WkY;
          j.xC(111L);
          d.a(1000L, (kotlin.g.a.a)new a(this.WlB, this.WlC, this.WlA, this.vQo));
        }
        if (this.SLA.getHeight() == 0)
        {
          Log.i(this.WlA.TAG, "reflow:" + this.vQo + " when height == 0");
          this.WlA.Wlx.ioh().bhU(this.WlA.Wlx.rzx);
          localj = j.WkY;
          j.xC(113L);
        }
        AppMethodBeat.o(261186);
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements kotlin.g.a.a<ah>
      {
        a(ah.a parama1, ah.a parama2, l paraml, String paramString)
        {
          super();
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webcanvas/WebCanvasViewContext$elementId$1$4", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "availableWidth", "", "getAvailableWidth", "()I", "setAvailableWidth", "(I)V", "onSurfaceAvailable", "", "surface", "", "width", "height", "canReadPixelsFromJava", "", "onSurfaceDestroyed", "syncDestroy", "onSurfaceSizeChanged", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements MagicBrushView.c
  {
    private int WlD;
    
    b(ah.a parama1, l paraml, String paramString, ah.a parama2) {}
    
    private static final void a(l paraml, String paramString1, long paramLong, String paramString2)
    {
      AppMethodBeat.i(261297);
      s.u(paraml, "this$0");
      s.u(paramString1, "$id");
      Log.d(paraml.TAG, "magicBrushView refresh:" + paramString1 + ", dur:" + (MMSlotKt.now() - paramLong) + "ms");
      paraml.Wlx.iom();
      AppMethodBeat.o(261297);
    }
    
    public final void a(Object paramObject, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(261321);
      s.u(paramObject, "surface");
      this.WlB.aiwY = true;
      this.WlD = paramInt1;
      paramObject = jdField_this.Wlx.WjV;
      long l;
      a locala;
      Object localObject1;
      if (paramObject == null)
      {
        l = -1L;
        Log.d(jdField_this.TAG, "magicBrushView onSurfaceAvailable:" + paramContext + ", dur:" + (MMSlotKt.now() - l) + "ms");
        locala = jdField_this.Wlx;
        if (!locala.WjL) {
          break label492;
        }
        localObject1 = locala.WjW;
        if (localObject1 != null) {
          break label200;
        }
        paramBoolean = true;
        label124:
        if (paramBoolean) {
          locala.ioi().bO(locala.rzx, l);
        }
        if (!paramBoolean) {
          break label492;
        }
      }
      label200:
      label472:
      label477:
      label483:
      label492:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label497;
        }
        Log.i(jdField_this.TAG, s.X("checkDrawChanged:", paramContext));
        jdField_this.Wlx.iom();
        AppMethodBeat.o(261321);
        return;
        l = paramObject.start;
        break;
        Object localObject2 = locala.WjX;
        if (localObject2 == null)
        {
          paramObject = null;
          if (paramObject != null) {
            break label483;
          }
          paramBoolean = true;
          break label124;
        }
        paramBoolean = ((a.e)localObject2).ehd;
        paramObject = f.WlF;
        if (paramBoolean == aw.isDarkMode())
        {
          if (((a.e)localObject2).fontSize != locala.getFontSize()) {
            break label472;
          }
          paramInt1 = 1;
          if ((paramInt1 != 0) && (((a.e)localObject2).orientation == a.ion()) && (((a.e)localObject2).width == ((a.f)localObject1).width) && (((a.e)localObject2).height == ((a.f)localObject1).height)) {
            break label477;
          }
        }
        for (paramBoolean = true;; paramBoolean = false)
        {
          if (paramBoolean)
          {
            paramObject = a.TAG;
            localObject1 = new StringBuilder("lastDrawChanged: [").append(((a.e)localObject2).width).append(", ").append(((a.e)localObject2).height).append(", ").append(((a.e)localObject2).fontSize).append(", ").append(((a.e)localObject2).ehd).append(", ").append(((a.e)localObject2).orientation).append("] to [").append(((a.f)localObject1).width).append(", ").append(((a.f)localObject1).height).append(", ").append(locala.getFontSize()).append(", ");
            localObject2 = f.WlF;
            Log.i(paramObject, aw.isDarkMode() + ' ' + a.ion() + ']');
          }
          paramObject = Boolean.valueOf(paramBoolean);
          break;
          paramInt1 = 0;
          break label259;
        }
        paramBoolean = paramObject.booleanValue();
        break label124;
      }
      label259:
      label497:
      jdField_this.Wlx.ioh().a(l, jdField_this.Wlx.rzx, new l.b..ExternalSyntheticLambda0(jdField_this, paramContext, l));
      AppMethodBeat.o(261321);
    }
    
    public final void c(Object paramObject, boolean paramBoolean)
    {
      AppMethodBeat.i(261330);
      s.u(paramObject, "surface");
      Log.d(jdField_this.TAG, s.X("onSurfaceDestroyed:", paramContext));
      locala.aiwY = true;
      AppMethodBeat.o(261330);
    }
    
    public final void e(Object paramObject, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(261325);
      s.u(paramObject, "surface");
      c.a(jdField_this.Wlx.ioi(), jdField_this.Wlx.rzx);
      if (this.WlD != paramInt1)
      {
        Log.i(jdField_this.TAG, "magicBrushView onSurfaceSizeChanged:" + paramContext + " width=" + paramInt1 + ", height= " + paramInt2);
        paramObject = j.WkY;
        j.xC(114L);
      }
      AppMethodBeat.o(261325);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.l
 * JD-Core Version:    0.7.0.1
 */
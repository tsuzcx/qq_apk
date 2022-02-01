package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.content.Context;
import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.ScanPoint;
import com.tencent.mm.plugin.scanner.model.ae;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanDotsAnimationController;", "context", "Landroid/content/Context;", "scanAnimationDotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;)V", "dotsAnimationListener", "com/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$dotsAnimationListener$1", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$dotsAnimationListener$1;", "dotsGroupSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView;", "Lkotlin/collections/HashSet;", "getDotsGroupSet", "()Ljava/util/HashSet;", "setDotsGroupSet", "(Ljava/util/HashSet;)V", "duration", "", "isStoping", "", "()Z", "setStoping", "(Z)V", "viewHeight", "", "getViewHeight", "()I", "setViewHeight", "(I)V", "viewWidth", "getViewWidth", "setViewWidth", "addAnimationDots", "", "pointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "addAnimationDotsGroup", "points", "draw", "canvas", "Landroid/graphics/Canvas;", "refreshView", "release", "setDuration", "show", "visible", "startAnimation", "stopAnimation", "updateViewSize", "width", "height", "Companion", "plugin-scan_release"})
public abstract class a
  implements e
{
  private static final ArrayList<c> CPp = new ArrayList();
  public static final a.a CPq = new a.a((byte)0);
  HashSet<c> CPl;
  boolean CPm;
  private b CPn;
  private final d CPo;
  private final Context context;
  private long duration;
  int gRD;
  int gRE;
  
  public a(Context paramContext, d paramd)
  {
    this.context = paramContext;
    this.CPo = paramd;
    this.duration = 700L;
    this.CPl = new HashSet();
    this.CPn = new b(this);
  }
  
  public final void b(ae paramae)
  {
    Object localObject3 = null;
    p.h(paramae, "pointsResult");
    Log.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo addAnimationDots size: %d", new Object[] { Integer.valueOf(paramae.pointCount) });
    Context localContext = this.context;
    long l = this.duration;
    d locald = this.CPo;
    p.h(localContext, "context");
    p.h(locald, "scanAnimationDotsView");
    Log.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo obtain recycledViewList: %d", new Object[] { Integer.valueOf(CPp.size()) });
    Object localObject1 = ((Iterable)CPp).iterator();
    Object localObject2;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (c)((Iterator)localObject1).next();
    } while (((c)localObject2).isAnimating());
    for (;;)
    {
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (CPp.size() < 10)
        {
          localObject1 = (c)new g(localContext, locald);
          CPp.add(localObject1);
        }
      }
      else
      {
        if (localObject1 == null) {
          p.hyc();
        }
        ((c)localObject1).setDuration(l);
        Log.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo obtain return new view");
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          p.hyc();
          localObject2 = localObject1;
        }
        if (localObject2 == null) {
          break label363;
        }
        localObject1 = localObject3;
        if (paramae != null) {
          localObject1 = paramae.points;
        }
        if (localObject1 != null)
        {
          localObject1 = paramae.points;
          if (localObject1 == null) {
            p.hyc();
          }
          ((c)localObject2).a((ScanPoint[])localObject1, paramae.pointCount);
        }
        ((c)localObject2).A(this.gRD, this.gRE, true);
        ((c)localObject2).a((c.a)this.CPn);
      }
      for (;;)
      {
        if (localObject2 == null) {
          break label369;
        }
        Log.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo addAnimationDotsGroup dotsGroupSet size: %d", new Object[] { Integer.valueOf(this.CPl.size()) });
        this.CPl.add(localObject2);
        return;
        Log.e("MicroMsg.BaseScanDotsAnimationController", "alvinluo recycledViewList exceed max size: %d", new Object[] { Integer.valueOf(CPp.size()) });
        localObject2 = null;
        break;
        label363:
        localObject2 = null;
      }
      label369:
      Log.e("MicroMsg.BaseScanDotsAnimationController", "alvinluo addAnimationDotsGroup group obtain failed and ignore");
      return;
      localObject2 = null;
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Iterator localIterator = ((Iterable)this.CPl).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).draw(paramCanvas);
    }
  }
  
  public final void ih(int paramInt1, int paramInt2)
  {
    this.gRD = paramInt1;
    this.gRE = paramInt2;
    Iterator localIterator = ((Iterable)this.CPl).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).A(paramInt1, paramInt2, false);
    }
  }
  
  public final void refreshView() {}
  
  public final void release()
  {
    stopAnimation();
    Iterator localIterator = ((Iterable)CPp).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).release();
    }
    CPp.clear();
  }
  
  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
    Iterator localIterator = ((Iterable)this.CPl).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).setDuration(paramLong);
    }
  }
  
  public void startAnimation() {}
  
  public void stopAnimation()
  {
    this.CPm = true;
    Iterator localIterator = ((Iterable)this.CPl).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).stopAnimation();
    }
    this.CPl.clear();
    this.CPm = false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$dotsAnimationListener$1", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView$AnimationListener;", "onAnimationEnd", "", "dotsGroupView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView;", "onAnimationStart", "plugin-scan_release"})
  public static final class b
    implements c.a
  {
    public final void a(c paramc)
    {
      AppMethodBeat.i(52250);
      Log.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo dotsGroupSet remove isStoping: %b", new Object[] { Boolean.valueOf(this.CPr.CPm) });
      if (!this.CPr.CPm)
      {
        Collection localCollection = (Collection)this.CPr.CPl;
        if (localCollection == null)
        {
          paramc = new t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
          AppMethodBeat.o(52250);
          throw paramc;
        }
        af.eV(localCollection).remove(paramc);
      }
      AppMethodBeat.o(52250);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.a
 * JD-Core Version:    0.7.0.1
 */
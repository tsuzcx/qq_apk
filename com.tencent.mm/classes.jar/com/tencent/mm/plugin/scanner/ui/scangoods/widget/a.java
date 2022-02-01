package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.content.Context;
import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.ScanPoint;
import com.tencent.mm.plugin.scanner.model.ac;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanDotsAnimationController;", "context", "Landroid/content/Context;", "scanAnimationDotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;)V", "dotsAnimationListener", "com/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$dotsAnimationListener$1", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$dotsAnimationListener$1;", "dotsGroupSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView;", "Lkotlin/collections/HashSet;", "getDotsGroupSet", "()Ljava/util/HashSet;", "setDotsGroupSet", "(Ljava/util/HashSet;)V", "duration", "", "isStoping", "", "()Z", "setStoping", "(Z)V", "viewHeight", "", "getViewHeight", "()I", "setViewHeight", "(I)V", "viewWidth", "getViewWidth", "setViewWidth", "addAnimationDots", "", "pointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "addAnimationDotsGroup", "points", "draw", "canvas", "Landroid/graphics/Canvas;", "refreshView", "release", "setDuration", "show", "visible", "startAnimation", "stopAnimation", "updateViewSize", "width", "height", "Companion", "plugin-scan_release"})
public abstract class a
  implements e
{
  private static final ArrayList<c> yLw = new ArrayList();
  public static final a.a yLx = new a.a((byte)0);
  private final Context context;
  private long duration;
  int gil;
  int gim;
  HashSet<c> yLs;
  boolean yLt;
  private b yLu;
  private final d yLv;
  
  public a(Context paramContext, d paramd)
  {
    this.context = paramContext;
    this.yLv = paramd;
    this.duration = 700L;
    this.yLs = new HashSet();
    this.yLu = new b(this);
  }
  
  public final void b(ac paramac)
  {
    Object localObject3 = null;
    p.h(paramac, "pointsResult");
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo addAnimationDots size: %d", new Object[] { Integer.valueOf(paramac.pointCount) });
    Context localContext = this.context;
    long l = this.duration;
    d locald = this.yLv;
    p.h(localContext, "context");
    p.h(locald, "scanAnimationDotsView");
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo obtain recycledViewList: %d", new Object[] { Integer.valueOf(yLw.size()) });
    Object localObject1 = ((Iterable)yLw).iterator();
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
        if (yLw.size() < 10)
        {
          localObject1 = (c)new g(localContext, locald);
          yLw.add(localObject1);
        }
      }
      else
      {
        if (localObject1 == null) {
          p.gkB();
        }
        ((c)localObject1).setDuration(l);
        com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo obtain return new view");
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          p.gkB();
          localObject2 = localObject1;
        }
        if (localObject2 == null) {
          break label363;
        }
        localObject1 = localObject3;
        if (paramac != null) {
          localObject1 = paramac.points;
        }
        if (localObject1 != null)
        {
          localObject1 = paramac.points;
          if (localObject1 == null) {
            p.gkB();
          }
          ((c)localObject2).a((ScanPoint[])localObject1, paramac.pointCount);
        }
        ((c)localObject2).v(this.gil, this.gim, true);
        ((c)localObject2).a((c.a)this.yLu);
      }
      for (;;)
      {
        if (localObject2 == null) {
          break label369;
        }
        com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo addAnimationDotsGroup dotsGroupSet size: %d", new Object[] { Integer.valueOf(this.yLs.size()) });
        this.yLs.add(localObject2);
        return;
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.BaseScanDotsAnimationController", "alvinluo recycledViewList exceed max size: %d", new Object[] { Integer.valueOf(yLw.size()) });
        localObject2 = null;
        break;
        label363:
        localObject2 = null;
      }
      label369:
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.BaseScanDotsAnimationController", "alvinluo addAnimationDotsGroup group obtain failed and ignore");
      return;
      localObject2 = null;
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Iterator localIterator = ((Iterable)this.yLs).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).draw(paramCanvas);
    }
  }
  
  public final void ht(int paramInt1, int paramInt2)
  {
    this.gil = paramInt1;
    this.gim = paramInt2;
    Iterator localIterator = ((Iterable)this.yLs).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).v(paramInt1, paramInt2, false);
    }
  }
  
  public final void refreshView() {}
  
  public final void release()
  {
    stopAnimation();
    Iterator localIterator = ((Iterable)yLw).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).release();
    }
    yLw.clear();
  }
  
  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
    Iterator localIterator = ((Iterable)this.yLs).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).setDuration(paramLong);
    }
  }
  
  public void startAnimation() {}
  
  public void stopAnimation()
  {
    this.yLt = true;
    Iterator localIterator = ((Iterable)this.yLs).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).stopAnimation();
    }
    this.yLs.clear();
    this.yLt = false;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$dotsAnimationListener$1", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView$AnimationListener;", "onAnimationEnd", "", "dotsGroupView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView;", "onAnimationStart", "plugin-scan_release"})
  public static final class b
    implements c.a
  {
    public final void a(c paramc)
    {
      AppMethodBeat.i(52250);
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo dotsGroupSet remove isStoping: %b", new Object[] { Boolean.valueOf(this.yLy.yLt) });
      if (!this.yLy.yLt)
      {
        Collection localCollection = (Collection)this.yLy.yLs;
        if (localCollection == null)
        {
          paramc = new v("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
          AppMethodBeat.o(52250);
          throw paramc;
        }
        d.g.b.ae.eU(localCollection).remove(paramc);
      }
      AppMethodBeat.o(52250);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.a
 * JD-Core Version:    0.7.0.1
 */
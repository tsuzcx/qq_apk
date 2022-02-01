package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.content.Context;
import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.ScanPoint;
import com.tencent.mm.plugin.scanner.model.ab;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.ae;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanDotsAnimationController;", "context", "Landroid/content/Context;", "scanAnimationDotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;)V", "dotsAnimationListener", "com/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$dotsAnimationListener$1", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$dotsAnimationListener$1;", "dotsGroupSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView;", "Lkotlin/collections/HashSet;", "getDotsGroupSet", "()Ljava/util/HashSet;", "setDotsGroupSet", "(Ljava/util/HashSet;)V", "duration", "", "isStoping", "", "()Z", "setStoping", "(Z)V", "viewHeight", "", "getViewHeight", "()I", "setViewHeight", "(I)V", "viewWidth", "getViewWidth", "setViewWidth", "addAnimationDots", "", "pointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "addAnimationDotsGroup", "points", "draw", "canvas", "Landroid/graphics/Canvas;", "refreshView", "release", "setDuration", "show", "visible", "startAnimation", "stopAnimation", "updateViewSize", "width", "height", "Companion", "plugin-scan_release"})
public abstract class a
  implements e
{
  private static final ArrayList<c> yvw = new ArrayList();
  public static final a.a yvx = new a.a((byte)0);
  private final Context context;
  private long duration;
  int gfT;
  int gfU;
  HashSet<c> yvs;
  boolean yvt;
  private b yvu;
  private final d yvv;
  
  public a(Context paramContext, d paramd)
  {
    this.context = paramContext;
    this.yvv = paramd;
    this.duration = 700L;
    this.yvs = new HashSet();
    this.yvu = new b(this);
  }
  
  public final void b(ab paramab)
  {
    Object localObject3 = null;
    p.h(paramab, "pointsResult");
    ad.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo addAnimationDots size: %d", new Object[] { Integer.valueOf(paramab.pointCount) });
    Context localContext = this.context;
    long l = this.duration;
    d locald = this.yvv;
    p.h(localContext, "context");
    p.h(locald, "scanAnimationDotsView");
    ad.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo obtain recycledViewList: %d", new Object[] { Integer.valueOf(yvw.size()) });
    Object localObject1 = ((Iterable)yvw).iterator();
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
        if (yvw.size() < 10)
        {
          localObject1 = (c)new g(localContext, locald);
          yvw.add(localObject1);
        }
      }
      else
      {
        if (localObject1 == null) {
          p.gfZ();
        }
        ((c)localObject1).setDuration(l);
        ad.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo obtain return new view");
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          p.gfZ();
          localObject2 = localObject1;
        }
        if (localObject2 == null) {
          break label363;
        }
        localObject1 = localObject3;
        if (paramab != null) {
          localObject1 = paramab.points;
        }
        if (localObject1 != null)
        {
          localObject1 = paramab.points;
          if (localObject1 == null) {
            p.gfZ();
          }
          ((c)localObject2).a((ScanPoint[])localObject1, paramab.pointCount);
        }
        ((c)localObject2).v(this.gfT, this.gfU, true);
        ((c)localObject2).a((c.a)this.yvu);
      }
      for (;;)
      {
        if (localObject2 == null) {
          break label369;
        }
        ad.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo addAnimationDotsGroup dotsGroupSet size: %d", new Object[] { Integer.valueOf(this.yvs.size()) });
        this.yvs.add(localObject2);
        return;
        ad.e("MicroMsg.BaseScanDotsAnimationController", "alvinluo recycledViewList exceed max size: %d", new Object[] { Integer.valueOf(yvw.size()) });
        localObject2 = null;
        break;
        label363:
        localObject2 = null;
      }
      label369:
      ad.e("MicroMsg.BaseScanDotsAnimationController", "alvinluo addAnimationDotsGroup group obtain failed and ignore");
      return;
      localObject2 = null;
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Iterator localIterator = ((Iterable)this.yvs).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).draw(paramCanvas);
    }
  }
  
  public final void hr(int paramInt1, int paramInt2)
  {
    this.gfT = paramInt1;
    this.gfU = paramInt2;
    Iterator localIterator = ((Iterable)this.yvs).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).v(paramInt1, paramInt2, false);
    }
  }
  
  public final void refreshView() {}
  
  public final void release()
  {
    stopAnimation();
    Iterator localIterator = ((Iterable)yvw).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).release();
    }
    yvw.clear();
  }
  
  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
    Iterator localIterator = ((Iterable)this.yvs).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).setDuration(paramLong);
    }
  }
  
  public void startAnimation() {}
  
  public void stopAnimation()
  {
    this.yvt = true;
    Iterator localIterator = ((Iterable)this.yvs).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).stopAnimation();
    }
    this.yvs.clear();
    this.yvt = false;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$dotsAnimationListener$1", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView$AnimationListener;", "onAnimationEnd", "", "dotsGroupView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView;", "onAnimationStart", "plugin-scan_release"})
  public static final class b
    implements c.a
  {
    public final void a(c paramc)
    {
      AppMethodBeat.i(52250);
      ad.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo dotsGroupSet remove isStoping: %b", new Object[] { Boolean.valueOf(this.yvy.yvt) });
      if (!this.yvy.yvt)
      {
        Collection localCollection = (Collection)this.yvy.yvs;
        if (localCollection == null)
        {
          paramc = new v("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
          AppMethodBeat.o(52250);
          throw paramc;
        }
        ae.eR(localCollection).remove(paramc);
      }
      AppMethodBeat.o(52250);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.content.Context;
import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.ScanPoint;
import com.tencent.mm.plugin.scanner.model.w;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.aa;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanDotsAnimationController;", "context", "Landroid/content/Context;", "scanAnimationDotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;)V", "dotsAnimationListener", "com/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$dotsAnimationListener$1", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$dotsAnimationListener$1;", "dotsGroupSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView;", "Lkotlin/collections/HashSet;", "getDotsGroupSet", "()Ljava/util/HashSet;", "setDotsGroupSet", "(Ljava/util/HashSet;)V", "duration", "", "isStoping", "", "()Z", "setStoping", "(Z)V", "viewHeight", "", "getViewHeight", "()I", "setViewHeight", "(I)V", "viewWidth", "getViewWidth", "setViewWidth", "addAnimationDots", "", "pointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "addAnimationDotsGroup", "points", "draw", "canvas", "Landroid/graphics/Canvas;", "refreshView", "release", "setDuration", "show", "visible", "startAnimation", "stopAnimation", "updateViewSize", "width", "height", "Companion", "plugin-scan_release"})
public abstract class a
  implements e
{
  private static final ArrayList<c> vWI = new ArrayList();
  public static final a.a vWJ = new a.a((byte)0);
  private final Context context;
  private long duration;
  int fIN;
  int fIO;
  HashSet<c> vWE;
  boolean vWF;
  private b vWG;
  private final d vWH;
  
  public a(Context paramContext, d paramd)
  {
    this.context = paramContext;
    this.vWH = paramd;
    this.duration = 700L;
    this.vWE = new HashSet();
    this.vWG = new b(this);
  }
  
  public final void b(w paramw)
  {
    Object localObject3 = null;
    k.h(paramw, "pointsResult");
    ad.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo addAnimationDots size: %d", new Object[] { Integer.valueOf(paramw.pointCount) });
    Context localContext = this.context;
    long l = this.duration;
    d locald = this.vWH;
    k.h(localContext, "context");
    k.h(locald, "scanAnimationDotsView");
    ad.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo obtain recycledViewList: %d", new Object[] { Integer.valueOf(vWI.size()) });
    Object localObject1 = ((Iterable)vWI).iterator();
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
        if (vWI.size() < 10)
        {
          localObject1 = (c)new g(localContext, locald);
          vWI.add(localObject1);
        }
      }
      else
      {
        if (localObject1 == null) {
          k.fvU();
        }
        ((c)localObject1).setDuration(l);
        ad.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo obtain return new view");
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          k.fvU();
          localObject2 = localObject1;
        }
        if (localObject2 == null) {
          break label363;
        }
        localObject1 = localObject3;
        if (paramw != null) {
          localObject1 = paramw.points;
        }
        if (localObject1 != null)
        {
          localObject1 = paramw.points;
          if (localObject1 == null) {
            k.fvU();
          }
          ((c)localObject2).a((ScanPoint[])localObject1, paramw.pointCount);
        }
        ((c)localObject2).v(this.fIN, this.fIO, true);
        ((c)localObject2).a((c.a)this.vWG);
      }
      for (;;)
      {
        if (localObject2 == null) {
          break label369;
        }
        ad.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo addAnimationDotsGroup dotsGroupSet size: %d", new Object[] { Integer.valueOf(this.vWE.size()) });
        this.vWE.add(localObject2);
        return;
        ad.e("MicroMsg.BaseScanDotsAnimationController", "alvinluo recycledViewList exceed max size: %d", new Object[] { Integer.valueOf(vWI.size()) });
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
    Iterator localIterator = ((Iterable)this.vWE).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).draw(paramCanvas);
    }
  }
  
  public final void gR(int paramInt1, int paramInt2)
  {
    this.fIN = paramInt1;
    this.fIO = paramInt2;
    Iterator localIterator = ((Iterable)this.vWE).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).v(paramInt1, paramInt2, false);
    }
  }
  
  public final void refreshView() {}
  
  public final void release()
  {
    stopAnimation();
    Iterator localIterator = ((Iterable)vWI).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).release();
    }
    vWI.clear();
  }
  
  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
    Iterator localIterator = ((Iterable)this.vWE).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).setDuration(paramLong);
    }
  }
  
  public void startAnimation() {}
  
  public void stopAnimation()
  {
    this.vWF = true;
    Iterator localIterator = ((Iterable)this.vWE).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).stopAnimation();
    }
    this.vWE.clear();
    this.vWF = false;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$dotsAnimationListener$1", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView$AnimationListener;", "onAnimationEnd", "", "dotsGroupView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView;", "onAnimationStart", "plugin-scan_release"})
  public static final class b
    implements c.a
  {
    public final void a(c paramc)
    {
      AppMethodBeat.i(52250);
      ad.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo dotsGroupSet remove isStoping: %b", new Object[] { Boolean.valueOf(this.vWK.vWF) });
      if (!this.vWK.vWF)
      {
        Collection localCollection = (Collection)this.vWK.vWE;
        if (localCollection == null)
        {
          paramc = new v("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
          AppMethodBeat.o(52250);
          throw paramc;
        }
        aa.eL(localCollection).remove(paramc);
      }
      AppMethodBeat.o(52250);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.a
 * JD-Core Version:    0.7.0.1
 */
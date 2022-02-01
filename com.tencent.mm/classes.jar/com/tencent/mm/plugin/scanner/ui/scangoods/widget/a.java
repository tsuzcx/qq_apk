package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.content.Context;
import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.ScanPoint;
import com.tencent.mm.plugin.scanner.model.y;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.aa;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanDotsAnimationController;", "context", "Landroid/content/Context;", "scanAnimationDotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;)V", "dotsAnimationListener", "com/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$dotsAnimationListener$1", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$dotsAnimationListener$1;", "dotsGroupSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView;", "Lkotlin/collections/HashSet;", "getDotsGroupSet", "()Ljava/util/HashSet;", "setDotsGroupSet", "(Ljava/util/HashSet;)V", "duration", "", "isStoping", "", "()Z", "setStoping", "(Z)V", "viewHeight", "", "getViewHeight", "()I", "setViewHeight", "(I)V", "viewWidth", "getViewWidth", "setViewWidth", "addAnimationDots", "", "pointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "addAnimationDotsGroup", "points", "draw", "canvas", "Landroid/graphics/Canvas;", "refreshView", "release", "setDuration", "show", "visible", "startAnimation", "stopAnimation", "updateViewSize", "width", "height", "Companion", "plugin-scan_release"})
public abstract class a
  implements e
{
  private static final ArrayList<c> xhv = new ArrayList();
  public static final a.a xhw = new a.a((byte)0);
  private final Context context;
  private long duration;
  int fMt;
  int fMu;
  HashSet<c> xhr;
  boolean xhs;
  private b xht;
  private final d xhu;
  
  public a(Context paramContext, d paramd)
  {
    this.context = paramContext;
    this.xhu = paramd;
    this.duration = 700L;
    this.xhr = new HashSet();
    this.xht = new b(this);
  }
  
  public final void b(y paramy)
  {
    Object localObject3 = null;
    k.h(paramy, "pointsResult");
    ac.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo addAnimationDots size: %d", new Object[] { Integer.valueOf(paramy.pointCount) });
    Context localContext = this.context;
    long l = this.duration;
    d locald = this.xhu;
    k.h(localContext, "context");
    k.h(locald, "scanAnimationDotsView");
    ac.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo obtain recycledViewList: %d", new Object[] { Integer.valueOf(xhv.size()) });
    Object localObject1 = ((Iterable)xhv).iterator();
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
        if (xhv.size() < 10)
        {
          localObject1 = (c)new g(localContext, locald);
          xhv.add(localObject1);
        }
      }
      else
      {
        if (localObject1 == null) {
          k.fOy();
        }
        ((c)localObject1).setDuration(l);
        ac.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo obtain return new view");
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          k.fOy();
          localObject2 = localObject1;
        }
        if (localObject2 == null) {
          break label363;
        }
        localObject1 = localObject3;
        if (paramy != null) {
          localObject1 = paramy.points;
        }
        if (localObject1 != null)
        {
          localObject1 = paramy.points;
          if (localObject1 == null) {
            k.fOy();
          }
          ((c)localObject2).a((ScanPoint[])localObject1, paramy.pointCount);
        }
        ((c)localObject2).v(this.fMt, this.fMu, true);
        ((c)localObject2).a((c.a)this.xht);
      }
      for (;;)
      {
        if (localObject2 == null) {
          break label369;
        }
        ac.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo addAnimationDotsGroup dotsGroupSet size: %d", new Object[] { Integer.valueOf(this.xhr.size()) });
        this.xhr.add(localObject2);
        return;
        ac.e("MicroMsg.BaseScanDotsAnimationController", "alvinluo recycledViewList exceed max size: %d", new Object[] { Integer.valueOf(xhv.size()) });
        localObject2 = null;
        break;
        label363:
        localObject2 = null;
      }
      label369:
      ac.e("MicroMsg.BaseScanDotsAnimationController", "alvinluo addAnimationDotsGroup group obtain failed and ignore");
      return;
      localObject2 = null;
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Iterator localIterator = ((Iterable)this.xhr).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).draw(paramCanvas);
    }
  }
  
  public final void ha(int paramInt1, int paramInt2)
  {
    this.fMt = paramInt1;
    this.fMu = paramInt2;
    Iterator localIterator = ((Iterable)this.xhr).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).v(paramInt1, paramInt2, false);
    }
  }
  
  public final void refreshView() {}
  
  public final void release()
  {
    stopAnimation();
    Iterator localIterator = ((Iterable)xhv).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).release();
    }
    xhv.clear();
  }
  
  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
    Iterator localIterator = ((Iterable)this.xhr).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).setDuration(paramLong);
    }
  }
  
  public void startAnimation() {}
  
  public void stopAnimation()
  {
    this.xhs = true;
    Iterator localIterator = ((Iterable)this.xhr).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).stopAnimation();
    }
    this.xhr.clear();
    this.xhs = false;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$dotsAnimationListener$1", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView$AnimationListener;", "onAnimationEnd", "", "dotsGroupView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView;", "onAnimationStart", "plugin-scan_release"})
  public static final class b
    implements c.a
  {
    public final void a(c paramc)
    {
      AppMethodBeat.i(52250);
      ac.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo dotsGroupSet remove isStoping: %b", new Object[] { Boolean.valueOf(this.xhx.xhs) });
      if (!this.xhx.xhs)
      {
        Collection localCollection = (Collection)this.xhx.xhr;
        if (localCollection == null)
        {
          paramc = new v("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
          AppMethodBeat.o(52250);
          throw paramc;
        }
        aa.eO(localCollection).remove(paramc);
      }
      AppMethodBeat.o(52250);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.a
 * JD-Core Version:    0.7.0.1
 */
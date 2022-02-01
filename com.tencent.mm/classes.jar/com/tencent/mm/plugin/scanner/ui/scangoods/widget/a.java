package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.content.Context;
import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.ScanPoint;
import com.tencent.mm.plugin.scanner.model.ac;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.b.ag;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanDotsAnimationController;", "context", "Landroid/content/Context;", "scanAnimationDotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;)V", "dotsAnimationListener", "com/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$dotsAnimationListener$1", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$dotsAnimationListener$1;", "dotsGroupSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView;", "Lkotlin/collections/HashSet;", "getDotsGroupSet", "()Ljava/util/HashSet;", "setDotsGroupSet", "(Ljava/util/HashSet;)V", "duration", "", "isStoping", "", "()Z", "setStoping", "(Z)V", "viewHeight", "", "getViewHeight", "()I", "setViewHeight", "(I)V", "viewWidth", "getViewWidth", "setViewWidth", "addAnimationDots", "", "pointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "addAnimationDotsGroup", "points", "draw", "canvas", "Landroid/graphics/Canvas;", "refreshView", "release", "setDuration", "show", "visible", "startAnimation", "stopAnimation", "updateViewSize", "width", "height", "Companion", "plugin-scan_release"})
public abstract class a
  implements e
{
  private static final ArrayList<c> IUR = new ArrayList();
  public static final a.a IUS = new a.a((byte)0);
  HashSet<c> IUN;
  boolean IUO;
  private b IUP;
  private final d IUQ;
  private final Context context;
  private long duration;
  private int jBZ;
  private int jCa;
  
  public a(Context paramContext, d paramd)
  {
    this.context = paramContext;
    this.IUQ = paramd;
    this.duration = 700L;
    this.IUN = new HashSet();
    this.IUP = new b(this);
  }
  
  public final void b(ac paramac)
  {
    Object localObject3 = null;
    p.k(paramac, "pointsResult");
    Log.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo addAnimationDots size: %d", new Object[] { Integer.valueOf(paramac.pointCount) });
    Context localContext = this.context;
    long l = this.duration;
    d locald = this.IUQ;
    p.k(localContext, "context");
    p.k(locald, "scanAnimationDotsView");
    Log.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo obtain recycledViewList: %d", new Object[] { Integer.valueOf(IUR.size()) });
    Object localObject1 = ((Iterable)IUR).iterator();
    Object localObject2;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (c)((Iterator)localObject1).next();
    } while (((c)localObject2).fEq());
    for (;;)
    {
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (IUR.size() < 10)
        {
          localObject1 = (c)new g(localContext, locald);
          IUR.add(localObject1);
        }
      }
      else
      {
        if (localObject1 == null) {
          p.iCn();
        }
        ((c)localObject1).setDuration(l);
        Log.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo obtain return new view");
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          p.iCn();
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
            p.iCn();
          }
          ((c)localObject2).a((ScanPoint[])localObject1, paramac.pointCount);
        }
        ((c)localObject2).F(this.jBZ, this.jCa, true);
        ((c)localObject2).a((c.a)this.IUP);
      }
      for (;;)
      {
        if (localObject2 == null) {
          break label369;
        }
        Log.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo addAnimationDotsGroup dotsGroupSet size: %d", new Object[] { Integer.valueOf(this.IUN.size()) });
        this.IUN.add(localObject2);
        return;
        Log.e("MicroMsg.BaseScanDotsAnimationController", "alvinluo recycledViewList exceed max size: %d", new Object[] { Integer.valueOf(IUR.size()) });
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
    Iterator localIterator = ((Iterable)this.IUN).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).draw(paramCanvas);
    }
  }
  
  protected final int getViewHeight()
  {
    return this.jCa;
  }
  
  protected final int getViewWidth()
  {
    return this.jBZ;
  }
  
  public final void jm(int paramInt1, int paramInt2)
  {
    this.jBZ = paramInt1;
    this.jCa = paramInt2;
    Iterator localIterator = ((Iterable)this.IUN).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).F(paramInt1, paramInt2, false);
    }
  }
  
  public final void refreshView() {}
  
  public final void release()
  {
    stopAnimation();
    Iterator localIterator = ((Iterable)IUR).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).release();
    }
    IUR.clear();
  }
  
  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
    Iterator localIterator = ((Iterable)this.IUN).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).setDuration(paramLong);
    }
  }
  
  public void startAnimation() {}
  
  public void stopAnimation()
  {
    this.IUO = true;
    Iterator localIterator = ((Iterable)this.IUN).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).stopAnimation();
    }
    this.IUN.clear();
    this.IUO = false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$dotsAnimationListener$1", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView$AnimationListener;", "onAnimationEnd", "", "dotsGroupView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView;", "onAnimationStart", "plugin-scan_release"})
  public static final class b
    implements c.a
  {
    public final void a(c paramc)
    {
      AppMethodBeat.i(52250);
      Log.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo dotsGroupSet remove isStoping: %b", new Object[] { Boolean.valueOf(this.IUT.IUO) });
      if (!this.IUT.IUO)
      {
        Collection localCollection = (Collection)this.IUT.IUN;
        if (localCollection == null)
        {
          paramc = new t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
          AppMethodBeat.o(52250);
          throw paramc;
        }
        ag.fc(localCollection).remove(paramc);
      }
      AppMethodBeat.o(52250);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.a
 * JD-Core Version:    0.7.0.1
 */
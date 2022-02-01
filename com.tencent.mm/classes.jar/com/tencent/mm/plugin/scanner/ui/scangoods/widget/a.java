package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.content.Context;
import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.ScanPoint;
import com.tencent.mm.plugin.scanner.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.an;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanDotsAnimationController;", "context", "Landroid/content/Context;", "scanAnimationDotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;)V", "dotsAnimationListener", "com/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$dotsAnimationListener$1", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$dotsAnimationListener$1;", "dotsGroupSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView;", "Lkotlin/collections/HashSet;", "getDotsGroupSet", "()Ljava/util/HashSet;", "setDotsGroupSet", "(Ljava/util/HashSet;)V", "duration", "", "isStoping", "", "()Z", "setStoping", "(Z)V", "viewHeight", "", "getViewHeight", "()I", "setViewHeight", "(I)V", "viewWidth", "getViewWidth", "setViewWidth", "addAnimationDots", "", "pointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "addAnimationDotsGroup", "points", "draw", "canvas", "Landroid/graphics/Canvas;", "refreshView", "release", "setDuration", "show", "visible", "startAnimation", "stopAnimation", "updateViewSize", "width", "height", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements e
{
  public static final a.a PdE = new a.a((byte)0);
  private static final ArrayList<c> PdJ = new ArrayList();
  private final d PdF;
  HashSet<c> PdG;
  boolean PdH;
  private b PdI;
  private final Context context;
  private long duration;
  private int mbM;
  private int mbN;
  
  public a(Context paramContext, d paramd)
  {
    this.context = paramContext;
    this.PdF = paramd;
    this.duration = 700L;
    this.PdG = new HashSet();
    this.PdI = new b(this);
  }
  
  public final void b(aj paramaj)
  {
    Object localObject2 = null;
    s.u(paramaj, "pointsResult");
    Log.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo addAnimationDots size: %d", new Object[] { Integer.valueOf(paramaj.pointCount) });
    Context localContext = this.context;
    long l = this.duration;
    d locald = this.PdF;
    s.u(localContext, "context");
    s.u(locald, "scanAnimationDotsView");
    Log.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo obtain recycledViewList: %d", new Object[] { Integer.valueOf(PdJ.size()) });
    Object localObject1 = ((Iterable)PdJ).iterator();
    c localc;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localc = (c)((Iterator)localObject1).next();
    } while (localc.gTd());
    for (;;)
    {
      localObject1 = localc;
      if (localc == null)
      {
        if (PdJ.size() < 10)
        {
          localObject1 = new g(localContext, locald);
          PdJ.add(localObject1);
        }
      }
      else
      {
        ((c)localObject1).setDuration(l);
        Log.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo obtain return new view");
      }
      for (localc = (c)localObject1; localc == null; localc = null)
      {
        paramaj = null;
        if (paramaj == null) {
          break label352;
        }
        Log.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo addAnimationDotsGroup dotsGroupSet size: %d", new Object[] { Integer.valueOf(this.PdG.size()) });
        this.PdG.add(paramaj);
        return;
        Log.e("MicroMsg.BaseScanDotsAnimationController", "alvinluo recycledViewList exceed max size: %d", new Object[] { Integer.valueOf(PdJ.size()) });
      }
      if (paramaj == null) {}
      for (localObject1 = localObject2;; localObject1 = paramaj.points)
      {
        if (localObject1 != null)
        {
          localObject1 = paramaj.points;
          s.checkNotNull(localObject1);
          localc.a((ScanPoint[])localObject1, paramaj.pointCount);
        }
        localc.L(this.mbM, this.mbN, true);
        localc.a((c.a)this.PdI);
        paramaj = localc;
        break;
      }
      label352:
      Log.e("MicroMsg.BaseScanDotsAnimationController", "alvinluo addAnimationDotsGroup group obtain failed and ignore");
      return;
      localc = null;
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Iterator localIterator = ((Iterable)this.PdG).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).draw(paramCanvas);
    }
  }
  
  protected final int getViewHeight()
  {
    return this.mbN;
  }
  
  protected final int getViewWidth()
  {
    return this.mbM;
  }
  
  public final void kT(int paramInt1, int paramInt2)
  {
    this.mbM = paramInt1;
    this.mbN = paramInt2;
    Iterator localIterator = ((Iterable)this.PdG).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).L(paramInt1, paramInt2, false);
    }
  }
  
  public final void refreshView() {}
  
  public final void release()
  {
    stopAnimation();
    Iterator localIterator = ((Iterable)PdJ).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).release();
    }
    PdJ.clear();
  }
  
  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
    Iterator localIterator = ((Iterable)this.PdG).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).setDuration(paramLong);
    }
  }
  
  public void startAnimation() {}
  
  public void stopAnimation()
  {
    this.PdH = true;
    Iterator localIterator = ((Iterable)this.PdG).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).stopAnimation();
    }
    this.PdG.clear();
    this.PdH = false;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController$dotsAnimationListener$1", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView$AnimationListener;", "onAnimationEnd", "", "dotsGroupView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsGroupView;", "onAnimationStart", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements c.a
  {
    b(a parama) {}
    
    public final void a(c paramc)
    {
      AppMethodBeat.i(52250);
      Log.v("MicroMsg.BaseScanDotsAnimationController", "alvinluo dotsGroupSet remove isStoping: %b", new Object[] { Boolean.valueOf(this.PdK.PdH) });
      if (!this.PdK.PdH)
      {
        Collection localCollection = (Collection)this.PdK.PdG;
        if (localCollection == null)
        {
          paramc = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
          AppMethodBeat.o(52250);
          throw paramc;
        }
        an.hA(localCollection).remove(paramc);
      }
      AppMethodBeat.o(52250);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.a
 * JD-Core Version:    0.7.0.1
 */
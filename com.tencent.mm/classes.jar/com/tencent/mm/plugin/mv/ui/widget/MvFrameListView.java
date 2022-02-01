package com.tencent.mm.plugin.mv.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.ui.c.g.b;
import com.tencent.mm.plugin.mv.ui.c.g.c;
import com.tencent.mm.plugin.mv.ui.c.g.d;
import com.tencent.mm.plugin.mv.ui.c.g.e;
import com.tencent.mm.plugin.vlog.ui.thumb.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.a.f;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.b.b;
import kotlinx.coroutines.b.c;
import kotlinx.coroutines.by;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/widget/MvFrameListView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bounds", "Landroid/graphics/Rect;", "value", "", "drawEnd", "getDrawEnd", "()I", "setDrawEnd", "(I)V", "drawStart", "getDrawStart", "setDrawStart", "loader", "Lcom/tencent/mm/plugin/mv/ui/thumb/ThumbCachedLoader;", "paint", "Landroid/graphics/Paint;", "previousJob", "Lkotlinx/coroutines/Job;", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setTrackInfo", "info", "stop", "Companion", "plugin-mv_release"})
public final class MvFrameListView
  extends View
{
  public static final MvFrameListView.a Gqi;
  com.tencent.mm.plugin.vlog.ui.thumb.a Gqd;
  com.tencent.mm.plugin.mv.ui.c.g Gqe;
  by Gqf;
  private int Gqg;
  private int Gqh;
  final Rect byi;
  private final Paint paint;
  
  static
  {
    AppMethodBeat.i(225556);
    Gqi = new MvFrameListView.a((byte)0);
    AppMethodBeat.o(225556);
  }
  
  public MvFrameListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(225555);
    this.paint = new Paint();
    this.byi = new Rect();
    this.Gqg = -1;
    this.Gqh = -1;
    this.paint.setAntiAlias(true);
    setBackgroundColor(385875967);
    AppMethodBeat.o(225555);
  }
  
  public final int getDrawEnd()
  {
    return this.Gqh;
  }
  
  public final int getDrawStart()
  {
    return this.Gqg;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(225551);
    p.k(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    paramCanvas.save();
    com.tencent.mm.plugin.vlog.ui.thumb.a locala = this.Gqd;
    if (locala == null)
    {
      AppMethodBeat.o(225551);
      return;
    }
    com.tencent.mm.plugin.mv.ui.c.g localg = this.Gqe;
    if (localg == null)
    {
      AppMethodBeat.o(225551);
      return;
    }
    int i = this.Gqg / this.byi.width();
    paramCanvas.translate(this.byi.width() * i, 0.0F);
    if ((this.byi.width() * i < this.Gqh) && (i < locala.NCm.size()))
    {
      long l3 = ((e)locala.NCm.get(i)).GhA;
      p.k(locala, "track");
      Object localObject2 = (Bitmap)localg.GhU.get(new g.c(locala, l3));
      Object localObject1 = localObject2;
      long l1;
      if (localObject2 == null)
      {
        localObject1 = localg.a(locala);
        if (!((g.b)localObject1).GhY.contains(Long.valueOf(l3)))
        {
          ((g.b)localObject1).GhX.add(Long.valueOf(l3));
          localObject2 = ((g.b)localObject1).Gib;
          if ((localObject2 == null) || (((by)localObject2).isActive() != true)) {
            ((g.b)localObject1).Gib = kotlinx.coroutines.g.b(localg.rcY, null, (m)new g.e(localg, (g.b)localObject1, locala, null), 3);
          }
        }
        localObject1 = localg.a(locala);
        l1 = -9223372036854775808L;
        localObject1 = ((Iterable)((g.b)localObject1).GhZ).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          long l2 = ((Number)((Iterator)localObject1).next()).longValue();
          if (Math.abs(l3 - l2) < Math.abs(l3 - l1)) {
            l1 = l2;
          }
        }
        if (l1 < 0L) {
          break label416;
        }
      }
      label416:
      for (localObject1 = (Bitmap)localg.GhU.get(new g.c(locala, l1));; localObject1 = null)
      {
        if (localObject1 != null) {
          paramCanvas.drawBitmap((Bitmap)localObject1, this.byi, this.byi, this.paint);
        }
        paramCanvas.translate(this.byi.right, 0.0F);
        i += 1;
        break;
      }
    }
    paramCanvas.restore();
    AppMethodBeat.o(225551);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225544);
    int i = this.byi.width();
    com.tencent.mm.plugin.vlog.ui.thumb.a locala = this.Gqd;
    if (locala != null) {}
    for (paramInt1 = locala.width;; paramInt1 = 0)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1 * i, 1073741824), paramInt2);
      AppMethodBeat.o(225544);
      return;
    }
  }
  
  public final void setDrawEnd(int paramInt)
  {
    AppMethodBeat.i(225540);
    this.Gqh = paramInt;
    invalidate();
    AppMethodBeat.o(225540);
  }
  
  public final void setDrawStart(int paramInt)
  {
    AppMethodBeat.i(225537);
    this.Gqg = paramInt;
    invalidate();
    AppMethodBeat.o(225537);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends j
    implements m<ak, d<? super x>, Object>
  {
    Object L$0;
    int label;
    Object oDA;
    private ak p$;
    
    b(MvFrameListView paramMvFrameListView, com.tencent.mm.plugin.mv.ui.c.g paramg, com.tencent.mm.plugin.vlog.ui.thumb.a parama, d paramd)
    {
      super(paramd);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(226429);
      p.k(paramd, "completion");
      paramd = new b(this.Gqj, this.Gqk, this.Gql, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(226429);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(226430);
      paramObject1 = ((b)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(226430);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(226428);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(226428);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        Object localObject1 = this.Gqk;
        Object localObject2 = this.Gql;
        p.k(localObject2, "track");
        localObject1 = (b)new kotlinx.coroutines.b.a(((com.tencent.mm.plugin.mv.ui.c.g)localObject1).a((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject2).Gia.iSr());
        localObject2 = (c)new a(this);
        this.L$0 = paramObject;
        this.oDA = localObject1;
        this.label = 1;
        if (((b)localObject1).a((c)localObject2, this) == locala)
        {
          AppMethodBeat.o(226428);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = x.aazN;
      AppMethodBeat.o(226428);
      return paramObject;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
    public static final class a
      implements c<Long>
    {
      public a(MvFrameListView.b paramb) {}
      
      public final Object a(Object paramObject, d paramd)
      {
        AppMethodBeat.i(241924);
        long l = ((Number)paramObject).longValue();
        Log.i("MicroMsg.MvFrameListView", this.Gqm.Gql + " receives " + l);
        this.Gqm.Gqj.postInvalidate();
        paramObject = x.aazN;
        AppMethodBeat.o(241924);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.widget.MvFrameListView
 * JD-Core Version:    0.7.0.1
 */
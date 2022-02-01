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
import com.tencent.mm.plugin.mv.ui.c.b;
import com.tencent.mm.plugin.mv.ui.c.b.b;
import com.tencent.mm.plugin.mv.ui.c.b.c;
import com.tencent.mm.plugin.mv.ui.c.b.d;
import com.tencent.mm.plugin.mv.ui.c.b.e;
import com.tencent.mm.plugin.vlog.ui.thumb.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.a.f;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/widget/MvFrameListView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bounds", "Landroid/graphics/Rect;", "value", "", "drawEnd", "getDrawEnd", "()I", "setDrawEnd", "(I)V", "drawStart", "getDrawStart", "setDrawStart", "loader", "Lcom/tencent/mm/plugin/mv/ui/thumb/ThumbCachedLoader;", "paint", "Landroid/graphics/Paint;", "previousJob", "Lkotlinx/coroutines/Job;", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setTrackInfo", "info", "stop", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MvFrameListView
  extends View
{
  public static final a Mkf;
  com.tencent.mm.plugin.vlog.ui.thumb.a Mkg;
  b Mkh;
  cb Mki;
  private int Mkj;
  private int Mkk;
  final Rect bounds;
  private final Paint paint;
  
  static
  {
    AppMethodBeat.i(286683);
    Mkf = new a((byte)0);
    AppMethodBeat.o(286683);
  }
  
  public MvFrameListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(286676);
    this.paint = new Paint();
    this.bounds = new Rect();
    this.Mkj = -1;
    this.Mkk = -1;
    this.paint.setAntiAlias(true);
    setBackgroundColor(385875967);
    AppMethodBeat.o(286676);
  }
  
  public final int getDrawEnd()
  {
    return this.Mkk;
  }
  
  public final int getDrawStart()
  {
    return this.Mkj;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(286726);
    s.u(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    paramCanvas.save();
    com.tencent.mm.plugin.vlog.ui.thumb.a locala = this.Mkg;
    if (locala == null)
    {
      AppMethodBeat.o(286726);
      return;
    }
    b localb = this.Mkh;
    if (localb == null)
    {
      AppMethodBeat.o(286726);
      return;
    }
    int i = this.Mkj / this.bounds.width();
    paramCanvas.translate(this.bounds.width() * i, 0.0F);
    if ((this.bounds.width() * i < this.Mkk) && (i < locala.UoS.size()))
    {
      long l3 = ((e)locala.UoS.get(i)).GvM;
      s.u(locala, "track");
      Object localObject2 = (Bitmap)localb.Mdg.get(new b.c(locala, l3));
      Object localObject1 = localObject2;
      long l1;
      if (localObject2 == null)
      {
        localObject1 = localb.a(locala);
        if (!((b.b)localObject1).Mdi.contains(Long.valueOf(l3)))
        {
          ((b.b)localObject1).Mdh.add(Long.valueOf(l3));
          localObject2 = ((b.b)localObject1).job;
          if ((localObject2 == null) || (((cb)localObject2).isActive() != true)) {
            break label354;
          }
        }
        label354:
        for (int j = 1;; j = 0)
        {
          if (j == 0) {
            ((b.b)localObject1).job = j.a(localb.scope, null, null, (m)new b.e((b.b)localObject1, locala, localb, null), 3);
          }
          localObject1 = localb.a(locala);
          l1 = -9223372036854775808L;
          localObject1 = ((Iterable)((b.b)localObject1).Mdj).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            long l2 = ((Number)((Iterator)localObject1).next()).longValue();
            if (Math.abs(l3 - l2) < Math.abs(l3 - l1)) {
              l1 = l2;
            }
          }
        }
        if (l1 < 0L) {
          break label433;
        }
      }
      label433:
      for (localObject1 = (Bitmap)localb.Mdg.get(new b.c(locala, l1));; localObject1 = null)
      {
        if (localObject1 != null) {
          paramCanvas.drawBitmap((Bitmap)localObject1, this.bounds, this.bounds, this.paint);
        }
        paramCanvas.translate(this.bounds.right, 0.0F);
        i += 1;
        break;
      }
    }
    paramCanvas.restore();
    AppMethodBeat.o(286726);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(286709);
    int i = this.bounds.width();
    com.tencent.mm.plugin.vlog.ui.thumb.a locala = this.Mkg;
    if (locala == null) {}
    for (paramInt1 = 0;; paramInt1 = locala.width)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1 * i, 1073741824), paramInt2);
      AppMethodBeat.o(286709);
      return;
    }
  }
  
  public final void setDrawEnd(int paramInt)
  {
    AppMethodBeat.i(286702);
    this.Mkk = paramInt;
    invalidate();
    AppMethodBeat.o(286702);
  }
  
  public final void setDrawStart(int paramInt)
  {
    AppMethodBeat.i(286692);
    this.Mkj = paramInt;
    invalidate();
    AppMethodBeat.o(286692);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/widget/MvFrameListView$Companion;", "", "()V", "TAG", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(b paramb, com.tencent.mm.plugin.vlog.ui.thumb.a parama, MvFrameListView paramMvFrameListView, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(286632);
      paramObject = (kotlin.d.d)new b(this.Mkl, this.Mkm, this.Mkn, paramd);
      AppMethodBeat.o(286632);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(286622);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(286622);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.Mkl;
        Object localObject = this.Mkm;
        s.u(localObject, "track");
        paramObject = (g)new kotlinx.coroutines.b.d(paramObject.a((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject).Mdk.kDj(), false);
        localObject = (h)new a(this.Mkm, this.Mkn);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.a((h)localObject, locald) == locala)
        {
          AppMethodBeat.o(286622);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(286622);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements h<Long>
    {
      public a(com.tencent.mm.plugin.vlog.ui.thumb.a parama, MvFrameListView paramMvFrameListView) {}
      
      public final Object a(Long paramLong, kotlin.d.d<? super ah> paramd)
      {
        AppMethodBeat.i(286668);
        long l = ((Number)paramLong).longValue();
        Log.i("MicroMsg.MvFrameListView", this.Mko + " receives " + l);
        this.Mkn.postInvalidate();
        paramLong = ah.aiuX;
        AppMethodBeat.o(286668);
        return paramLong;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.widget.MvFrameListView
 * JD-Core Version:    0.7.0.1
 */
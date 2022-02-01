package com.tencent.mm.plugin.vlog.ui.thumb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "centerMatrix", "Landroid/graphics/Matrix;", "clipOffset", "", "clipPath", "Landroid/graphics/Path;", "clipRadius", "clipRect", "Landroid/graphics/RectF;", "firstThumb", "Landroid/graphics/Bitmap;", "noClipLeft", "", "noClipRight", "noRadiusLeft", "noRadiusRight", "paint", "Landroid/graphics/Paint;", "thumbDrawRect", "thumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "thumbFetcherExtraData", "", "thumbFetcherFactory", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ThumbFetcherFactory;", "thumbList", "Ljava/util/LinkedList;", "thumbRect", "Landroid/graphics/Rect;", "thumbScale", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "clearThumbs", "", "noClip", "left", "right", "noRadius", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "release", "setThumbFetcherExtraData", "data", "setThumbFetcherFactory", "setToDefaultThumbFetcherFactory", "setTrackInfo", "info", "plugin-vlog_release"})
public final class FrameListView
  extends View
{
  private g Avo;
  private final Rect COM;
  private LinkedList<Bitmap> GOW;
  private Bitmap GOX;
  private float GOY;
  private final RectF GOZ;
  private boolean GPa;
  private boolean GPb;
  private boolean GPc;
  private boolean GPd;
  private final RectF GPe;
  private final float GPf;
  private final float GPg;
  private a GPs;
  private Object GPt;
  private final String TAG;
  private final Paint paint;
  private final Path rqV;
  private com.tencent.mm.videocomposition.g vNj;
  private final Matrix xnd;
  
  public FrameListView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(192097);
    AppMethodBeat.o(192097);
  }
  
  public FrameListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(192096);
    AppMethodBeat.o(192096);
  }
  
  public FrameListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192095);
    this.TAG = "MicroMsg.FrameListView";
    this.paint = new Paint();
    this.GOW = new LinkedList();
    this.GOY = 1.0F;
    this.COM = new Rect();
    this.GOZ = new RectF();
    this.xnd = new Matrix();
    this.rqV = new Path();
    this.GPe = new RectF();
    this.GPf = com.tencent.mm.cb.a.fromDPToPix(paramContext, 4);
    this.GPg = com.tencent.mm.cb.a.fromDPToPix(paramContext, 4);
    this.Avo = ((g)new b());
    this.paint.setColor(-65536);
    this.paint.setAntiAlias(true);
    AppMethodBeat.o(192095);
  }
  
  private final void fEw()
  {
    AppMethodBeat.i(192091);
    Log.i(this.TAG, "clearThumb");
    this.GOW.clear();
    this.GOX = null;
    postInvalidate();
    AppMethodBeat.o(192091);
  }
  
  public final void aC(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.GPa = paramBoolean1;
    this.GPb = paramBoolean2;
  }
  
  public final void aD(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.GPc = paramBoolean1;
    this.GPd = paramBoolean2;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(192093);
    p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    Log.i(this.TAG, "onDraw, trackInfo:" + this.GPs + ", thumbList.size:" + this.GOW.size());
    paramCanvas.save();
    paramCanvas.clipPath(this.rqV);
    Object localObject = this.GPs;
    if ((localObject != null) && (((a)localObject).GOH == true))
    {
      localObject = (Bitmap)kotlin.a.j.L((List)this.GOW, 0);
      if (localObject != null)
      {
        paramCanvas.concat(this.xnd);
        paramCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, this.paint);
      }
      paramCanvas.restore();
      localObject = getBackground();
      if (localObject != null)
      {
        ((Drawable)localObject).setBounds((int)this.GPe.left, (int)this.GPe.top, (int)this.GPe.right, (int)this.GPe.bottom);
        ((Drawable)localObject).draw(paramCanvas);
        AppMethodBeat.o(192093);
      }
    }
    else
    {
      localObject = ((Iterable)this.GOW).iterator();
      label200:
      Bitmap localBitmap;
      if (((Iterator)localObject).hasNext())
      {
        localBitmap = (Bitmap)((Iterator)localObject).next();
        if (localBitmap == null) {
          break label255;
        }
        paramCanvas.drawBitmap(localBitmap, this.COM, this.GOZ, this.paint);
      }
      for (;;)
      {
        paramCanvas.translate(this.GOZ.right, 0.0F);
        break label200;
        break;
        label255:
        localBitmap = this.GOX;
        if (localBitmap != null) {
          paramCanvas.drawBitmap(localBitmap, this.COM, this.GOZ, this.paint);
        }
      }
    }
    AppMethodBeat.o(192093);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(192092);
    int i = View.getDefaultSize(getSuggestedMinimumHeight(), paramInt2);
    this.GOZ.bottom = i;
    paramInt1 = View.getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
    Object localObject1 = this.GPs;
    if (localObject1 != null)
    {
      this.COM.right = ((a)localObject1).width;
      this.COM.bottom = ((a)localObject1).height;
      this.GOY = (i * 1.0F / ((a)localObject1).height);
      this.GOZ.right = (this.GOY * ((a)localObject1).width);
      paramInt1 = (int)(this.GOZ.right * ((a)localObject1).GOF);
    }
    localObject1 = this.GPs;
    paramInt2 = paramInt1;
    float f1;
    if (localObject1 != null)
    {
      paramInt2 = paramInt1;
      if (((a)localObject1).GOH == true)
      {
        localObject1 = this.xnd;
        f1 = this.COM.right;
        float f3 = this.COM.bottom;
        float f4 = i;
        p.h(localObject1, "$this$setRectToRectCenterCrop");
        t.a((Matrix)localObject1, new RectF(0.0F, 0.0F, f1, f3), new RectF(0.0F, 0.0F, f4, f4));
        paramInt2 = i;
      }
    }
    label248:
    Object localObject2;
    Object localObject3;
    if (this.GPa)
    {
      this.GPe.left = 0.0F;
      if (!this.GPb) {
        break label505;
      }
      this.GPe.right = paramInt2;
      localObject2 = this.TAG;
      localObject3 = new StringBuilder("onMeasure: ").append(this.GPa).append(' ').append(this.GPb).append(", ").append(paramInt2).append(' ').append(i).append(", thumbScale:").append(this.GOY).append(", trackInfo.width:");
      localObject1 = this.GPs;
      if (localObject1 == null) {
        break label522;
      }
      localObject1 = Integer.valueOf(((a)localObject1).width);
      label345:
      Log.i((String)localObject2, localObject1 + ", thumbDrawRect.right:" + this.GOZ.right);
      this.GPe.bottom = i;
      this.rqV.reset();
      if (!this.GPc) {
        break label528;
      }
      f1 = 0.0F;
      label402:
      if (!this.GPd) {
        break label536;
      }
    }
    for (;;)
    {
      localObject1 = this.rqV;
      localObject2 = this.GPe;
      localObject3 = Path.Direction.CW;
      ((Path)localObject1).addRoundRect((RectF)localObject2, new float[] { f1, f1, f2, f2, f2, f2, f1, f1 }, (Path.Direction)localObject3);
      setMeasuredDimension(paramInt2, i);
      AppMethodBeat.o(192092);
      return;
      this.GPe.left = this.GPg;
      break;
      label505:
      this.GPe.right = (paramInt2 - this.GPg);
      break label248;
      label522:
      localObject1 = null;
      break label345;
      label528:
      f1 = this.GPf;
      break label402;
      label536:
      f2 = this.GPf;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(192094);
    com.tencent.mm.videocomposition.g localg = this.vNj;
    if (localg != null) {
      localg.destroy();
    }
    this.vNj = null;
    this.GPs = null;
    fEw();
    AppMethodBeat.o(192094);
  }
  
  public final void setThumbFetcherExtraData(Object paramObject)
  {
    this.GPt = paramObject;
  }
  
  public final void setThumbFetcherFactory(g paramg)
  {
    AppMethodBeat.i(192089);
    p.h(paramg, "thumbFetcherFactory");
    this.Avo = paramg;
    fEw();
    AppMethodBeat.o(192089);
  }
  
  public final void setTrackInfo(a parama)
  {
    AppMethodBeat.i(192090);
    p.h(parama, "info");
    this.GPs = parama;
    this.GOW.clear();
    parama = this.GPs;
    if (parama != null)
    {
      parama = parama.GOG;
      if (parama != null)
      {
        parama = ((Iterable)parama).iterator();
        while (parama.hasNext())
        {
          parama.next();
          this.GOW.add(null);
        }
      }
    }
    kotlinx.coroutines.f.b((ai)bn.TUK, (kotlin.d.f)ba.hMW(), (m)new a(this, null), 2);
    AppMethodBeat.o(192090);
  }
  
  @kotlin.d.b.a.f(c="com.tencent.mm.plugin.vlog.ui.thumb.FrameListView$setTrackInfo$2", f="FrameListView.kt", hxM={109}, m="invokeSuspend")
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class a
    extends kotlin.d.b.a.j
    implements m<ai, d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ai p$;
    Object pED;
    
    a(FrameListView paramFrameListView, d paramd)
    {
      super(paramd);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(192087);
      p.h(paramd, "completion");
      paramd = new a(this.GPu, paramd);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(192087);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(192088);
      paramObject1 = ((a)create(paramObject1, (d)paramObject2)).invokeSuspend(x.SXb);
      AppMethodBeat.o(192088);
      return paramObject1;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(192086);
      kotlin.d.a.a locala = kotlin.d.a.a.SXO;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(192086);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        Log.i(FrameListView.a(this.GPu), paramObject.hashCode() + " setTrackInfo launch");
        a locala1 = FrameListView.b(this.GPu);
        if (locala1 != null)
        {
          Log.i(FrameListView.a(this.GPu), paramObject.hashCode() + " setTrackInfo init thumb fetcher");
          Object localObject1 = FrameListView.c(this.GPu);
          if (localObject1 != null) {
            ((com.tencent.mm.videocomposition.g)localObject1).destroy();
          }
          FrameListView.a(this.GPu, FrameListView.d(this.GPu).a(locala1, FrameListView.e(this.GPu)));
          localObject1 = FrameListView.c(this.GPu);
          if (localObject1 != null) {
            ((com.tencent.mm.videocomposition.g)localObject1).setSize(locala1.width, locala1.height);
          }
          Log.i(FrameListView.a(this.GPu), paramObject.hashCode() + " setTrackInfo finish init thumb fetcher, frames.size:" + locala1.GOG.size());
          localObject1 = FrameListView.c(this.GPu);
          if (localObject1 != null) {
            ((com.tencent.mm.videocomposition.g)localObject1).b(kotlin.a.j.listOf(kotlin.d.b.a.b.Pe(0L)), (m)new a(this, paramObject));
          }
          localObject1 = FrameListView.c(this.GPu);
          Object localObject2;
          if (localObject1 != null)
          {
            Object localObject3 = (Iterable)locala1.GOG;
            localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
            localObject3 = ((Iterable)localObject3).iterator();
            while (((Iterator)localObject3).hasNext()) {
              ((Collection)localObject2).add(kotlin.d.b.a.b.Pe(((e)((Iterator)localObject3).next()).Asv));
            }
            ((com.tencent.mm.videocomposition.g)localObject1).b((List)localObject2, (m)new b(locala1, this, paramObject));
          }
          Log.i(FrameListView.a(this.GPu), paramObject.hashCode() + " setTrackInfo request layout");
          if ((!this.GPu.isInLayout()) || (locala1.GOH))
          {
            localObject1 = (kotlin.d.f)ba.hMV();
            localObject2 = (m)new c(null, this, paramObject);
            this.L$0 = paramObject;
            this.pED = locala1;
            this.label = 1;
            if (kotlinx.coroutines.g.a((kotlin.d.f)localObject1, (m)localObject2, this) == locala)
            {
              AppMethodBeat.o(192086);
              return locala;
            }
          }
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = x.SXb;
      AppMethodBeat.o(192086);
      return paramObject;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/ui/thumb/FrameListView$setTrackInfo$2$1$1"})
    static final class a
      extends q
      implements m<Long, Bitmap, x>
    {
      a(FrameListView.a parama, ai paramai)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/ui/thumb/FrameListView$setTrackInfo$2$1$3"})
    static final class b
      extends q
      implements m<Long, Bitmap, x>
    {
      b(a parama, FrameListView.a parama1, ai paramai)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/vlog/ui/thumb/FrameListView$setTrackInfo$2$1$4"})
    static final class c
      extends kotlin.d.b.a.j
      implements m<ai, d<? super x>, Object>
    {
      int label;
      private ai p$;
      
      c(d paramd, FrameListView.a parama, ai paramai)
      {
        super(paramd);
      }
      
      public final d<x> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(192084);
        p.h(paramd, "completion");
        paramd = new c(paramd, jdField_this, paramObject);
        paramd.p$ = ((ai)paramObject);
        AppMethodBeat.o(192084);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(192085);
        paramObject1 = ((c)create(paramObject1, (d)paramObject2)).invokeSuspend(x.SXb);
        AppMethodBeat.o(192085);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(192083);
        kotlin.d.a.a locala = kotlin.d.a.a.SXO;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(192083);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        jdField_this.GPu.requestLayout();
        paramObject = x.SXb;
        AppMethodBeat.o(192083);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.FrameListView
 * JD-Core Version:    0.7.0.1
 */
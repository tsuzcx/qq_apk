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
import com.tencent.mm.videocomposition.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.br;
import kotlinx.coroutines.i;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "centerMatrix", "Landroid/graphics/Matrix;", "clipOffset", "", "clipPath", "Landroid/graphics/Path;", "clipRadius", "clipRect", "Landroid/graphics/RectF;", "firstThumb", "Landroid/graphics/Bitmap;", "noClipLeft", "", "noClipRight", "noRadiusLeft", "noRadiusRight", "paint", "Landroid/graphics/Paint;", "thumbDrawRect", "thumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "thumbFetcherExtraData", "", "thumbFetcherFactory", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ThumbFetcherFactory;", "thumbList", "Ljava/util/LinkedList;", "thumbRect", "Landroid/graphics/Rect;", "thumbScale", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "clearThumbs", "", "noClip", "left", "right", "noRadius", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "release", "setThumbFetcherExtraData", "data", "setThumbFetcherFactory", "setToDefaultThumbFetcherFactory", "setTrackInfo", "info", "plugin-vlog_release"})
public final class FrameListView
  extends View
{
  private c Aub;
  private final Matrix BZv;
  private g GhV;
  private a Gqd;
  private final RectF GrG;
  private final float GrH;
  private final Rect IUo;
  private LinkedList<Bitmap> NCE;
  private Bitmap NCF;
  private float NCG;
  private final RectF NCH;
  private boolean NCI;
  private boolean NCJ;
  private boolean NCK;
  private boolean NCL;
  private final float NCM;
  private Object NCY;
  private final String TAG;
  private final Paint paint;
  private final Path uWB;
  
  public FrameListView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(246649);
    AppMethodBeat.o(246649);
  }
  
  public FrameListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(246648);
    AppMethodBeat.o(246648);
  }
  
  public FrameListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(246647);
    this.TAG = "MicroMsg.FrameListView";
    this.paint = new Paint();
    this.NCE = new LinkedList();
    this.NCG = 1.0F;
    this.IUo = new Rect();
    this.NCH = new RectF();
    this.BZv = new Matrix();
    this.uWB = new Path();
    this.GrG = new RectF();
    this.GrH = com.tencent.mm.ci.a.fromDPToPix(paramContext, 4);
    this.NCM = com.tencent.mm.ci.a.fromDPToPix(paramContext, 4);
    this.GhV = ((g)new b());
    this.paint.setColor(-65536);
    this.paint.setAntiAlias(true);
    AppMethodBeat.o(246647);
  }
  
  private final void gwx()
  {
    AppMethodBeat.i(246637);
    Log.i(this.TAG, "clearThumb");
    this.NCE.clear();
    this.NCF = null;
    postInvalidate();
    AppMethodBeat.o(246637);
  }
  
  public final void aO(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.NCI = paramBoolean1;
    this.NCJ = paramBoolean2;
  }
  
  public final void aP(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.NCK = paramBoolean1;
    this.NCL = paramBoolean2;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(246645);
    p.k(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    Log.i(this.TAG, "onDraw, trackInfo:" + this.Gqd + ", thumbList.size:" + this.NCE.size());
    paramCanvas.save();
    paramCanvas.clipPath(this.uWB);
    Object localObject = this.Gqd;
    if ((localObject != null) && (((a)localObject).NCn == true))
    {
      localObject = (Bitmap)kotlin.a.j.M((List)this.NCE, 0);
      if (localObject != null)
      {
        paramCanvas.concat(this.BZv);
        paramCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, this.paint);
      }
      paramCanvas.restore();
      localObject = getBackground();
      if (localObject != null)
      {
        ((Drawable)localObject).setBounds((int)this.GrG.left, (int)this.GrG.top, (int)this.GrG.right, (int)this.GrG.bottom);
        ((Drawable)localObject).draw(paramCanvas);
        AppMethodBeat.o(246645);
      }
    }
    else
    {
      localObject = ((Iterable)this.NCE).iterator();
      label200:
      Bitmap localBitmap;
      if (((Iterator)localObject).hasNext())
      {
        localBitmap = (Bitmap)((Iterator)localObject).next();
        if (localBitmap == null) {
          break label255;
        }
        paramCanvas.drawBitmap(localBitmap, this.IUo, this.NCH, this.paint);
      }
      for (;;)
      {
        paramCanvas.translate(this.NCH.right, 0.0F);
        break label200;
        break;
        label255:
        localBitmap = this.NCF;
        if (localBitmap != null) {
          paramCanvas.drawBitmap(localBitmap, this.IUo, this.NCH, this.paint);
        }
      }
    }
    AppMethodBeat.o(246645);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(246643);
    int i = View.getDefaultSize(getSuggestedMinimumHeight(), paramInt2);
    this.NCH.bottom = i;
    paramInt1 = View.getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
    Object localObject1 = this.Gqd;
    if (localObject1 != null)
    {
      this.IUo.right = ((a)localObject1).width;
      this.IUo.bottom = ((a)localObject1).height;
      this.NCG = (i * 1.0F / ((a)localObject1).height);
      this.NCH.right = (this.NCG * ((a)localObject1).width);
      paramInt1 = (int)(this.NCH.right * ((a)localObject1).NCl);
    }
    localObject1 = this.Gqd;
    paramInt2 = paramInt1;
    float f1;
    if (localObject1 != null)
    {
      paramInt2 = paramInt1;
      if (((a)localObject1).NCn == true)
      {
        localObject1 = this.BZv;
        f1 = this.IUo.right;
        float f3 = this.IUo.bottom;
        float f4 = i;
        p.k(localObject1, "$this$setRectToRectCenterCrop");
        t.a((Matrix)localObject1, new RectF(0.0F, 0.0F, f1, f3), new RectF(0.0F, 0.0F, f4, f4));
        paramInt2 = i;
      }
    }
    label248:
    Object localObject2;
    Object localObject3;
    if (this.NCI)
    {
      this.GrG.left = 0.0F;
      if (!this.NCJ) {
        break label505;
      }
      this.GrG.right = paramInt2;
      localObject2 = this.TAG;
      localObject3 = new StringBuilder("onMeasure: ").append(this.NCI).append(' ').append(this.NCJ).append(", ").append(paramInt2).append(' ').append(i).append(", thumbScale:").append(this.NCG).append(", trackInfo.width:");
      localObject1 = this.Gqd;
      if (localObject1 == null) {
        break label522;
      }
      localObject1 = Integer.valueOf(((a)localObject1).width);
      label345:
      Log.i((String)localObject2, localObject1 + ", thumbDrawRect.right:" + this.NCH.right);
      this.GrG.bottom = i;
      this.uWB.reset();
      if (!this.NCK) {
        break label528;
      }
      f1 = 0.0F;
      label402:
      if (!this.NCL) {
        break label536;
      }
    }
    for (;;)
    {
      localObject1 = this.uWB;
      localObject2 = this.GrG;
      localObject3 = Path.Direction.CW;
      ((Path)localObject1).addRoundRect((RectF)localObject2, new float[] { f1, f1, f2, f2, f2, f2, f1, f1 }, (Path.Direction)localObject3);
      setMeasuredDimension(paramInt2, i);
      AppMethodBeat.o(246643);
      return;
      this.GrG.left = this.NCM;
      break;
      label505:
      this.GrG.right = (paramInt2 - this.NCM);
      break label248;
      label522:
      localObject1 = null;
      break label345;
      label528:
      f1 = this.GrH;
      break label402;
      label536:
      f2 = this.GrH;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(246646);
    c localc = this.Aub;
    if (localc != null) {
      localc.destroy();
    }
    this.Aub = null;
    this.Gqd = null;
    gwx();
    AppMethodBeat.o(246646);
  }
  
  public final void setThumbFetcherExtraData(Object paramObject)
  {
    this.NCY = paramObject;
  }
  
  public final void setThumbFetcherFactory(g paramg)
  {
    AppMethodBeat.i(246633);
    p.k(paramg, "thumbFetcherFactory");
    this.GhV = paramg;
    gwx();
    AppMethodBeat.o(246633);
  }
  
  public final void setTrackInfo(a parama)
  {
    AppMethodBeat.i(246636);
    p.k(parama, "info");
    this.Gqd = parama;
    this.NCE.clear();
    parama = this.Gqd;
    if (parama != null)
    {
      parama = parama.NCm;
      if (parama != null)
      {
        parama = ((Iterable)parama).iterator();
        while (parama.hasNext())
        {
          parama.next();
          this.NCE.add(null);
        }
      }
    }
    kotlinx.coroutines.g.b((ak)br.abxo, (f)bc.iRs(), (m)new a(this, null), 2);
    AppMethodBeat.o(246636);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class a
    extends kotlin.d.b.a.j
    implements m<ak, d<? super x>, Object>
  {
    Object L$0;
    int label;
    Object oDA;
    private ak p$;
    
    a(FrameListView paramFrameListView, d paramd)
    {
      super(paramd);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(230652);
      p.k(paramd, "completion");
      paramd = new a(this.NCZ, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(230652);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(230653);
      paramObject1 = ((a)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(230653);
      return paramObject1;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(230651);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(230651);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        Log.i(FrameListView.a(this.NCZ), paramObject.hashCode() + " setTrackInfo launch");
        a locala1 = FrameListView.b(this.NCZ);
        if (locala1 != null)
        {
          Log.i(FrameListView.a(this.NCZ), paramObject.hashCode() + " setTrackInfo init thumb fetcher");
          Object localObject1 = FrameListView.c(this.NCZ);
          if (localObject1 != null) {
            ((c)localObject1).destroy();
          }
          FrameListView.a(this.NCZ, FrameListView.d(this.NCZ).a(locala1, FrameListView.e(this.NCZ)));
          localObject1 = FrameListView.c(this.NCZ);
          if (localObject1 != null) {
            ((c)localObject1).setSize(locala1.width, locala1.height);
          }
          Log.i(FrameListView.a(this.NCZ), paramObject.hashCode() + " setTrackInfo finish init thumb fetcher, frames.size:" + locala1.NCm.size());
          localObject1 = FrameListView.c(this.NCZ);
          if (localObject1 != null) {
            ((c)localObject1).b(kotlin.a.j.listOf(kotlin.d.b.a.b.Xu(0L)), (m)new a(this, paramObject));
          }
          localObject1 = FrameListView.c(this.NCZ);
          Object localObject2;
          if (localObject1 != null)
          {
            Object localObject3 = (Iterable)locala1.NCm;
            localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
            localObject3 = ((Iterable)localObject3).iterator();
            while (((Iterator)localObject3).hasNext()) {
              ((Collection)localObject2).add(kotlin.d.b.a.b.Xu(((e)((Iterator)localObject3).next()).GhA));
            }
            ((c)localObject1).b((List)localObject2, (m)new b(locala1, this, paramObject));
          }
          Log.i(FrameListView.a(this.NCZ), paramObject.hashCode() + " setTrackInfo request layout");
          if ((!this.NCZ.isInLayout()) || (locala1.NCn))
          {
            localObject1 = (f)bc.iRr();
            localObject2 = (m)new c(null, this, paramObject);
            this.L$0 = paramObject;
            this.oDA = locala1;
            this.label = 1;
            if (i.a((f)localObject1, (m)localObject2, this) == locala)
            {
              AppMethodBeat.o(230651);
              return locala;
            }
          }
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = x.aazN;
      AppMethodBeat.o(230651);
      return paramObject;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/ui/thumb/FrameListView$setTrackInfo$2$1$1"})
    static final class a
      extends q
      implements m<Long, Bitmap, x>
    {
      a(FrameListView.a parama, ak paramak)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/ui/thumb/FrameListView$setTrackInfo$2$1$3"})
    static final class b
      extends q
      implements m<Long, Bitmap, x>
    {
      b(a parama, FrameListView.a parama1, ak paramak)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/vlog/ui/thumb/FrameListView$setTrackInfo$2$1$4"})
    static final class c
      extends kotlin.d.b.a.j
      implements m<ak, d<? super x>, Object>
    {
      int label;
      private ak p$;
      
      c(d paramd, FrameListView.a parama, ak paramak)
      {
        super(paramd);
      }
      
      public final d<x> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(241188);
        p.k(paramd, "completion");
        paramd = new c(paramd, jdField_this, paramObject);
        paramd.p$ = ((ak)paramObject);
        AppMethodBeat.o(241188);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(241189);
        paramObject1 = ((c)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
        AppMethodBeat.o(241189);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(241186);
        kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(241186);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        jdField_this.NCZ.requestLayout();
        paramObject = x.aazN;
        AppMethodBeat.o(241186);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.FrameListView
 * JD-Core Version:    0.7.0.1
 */
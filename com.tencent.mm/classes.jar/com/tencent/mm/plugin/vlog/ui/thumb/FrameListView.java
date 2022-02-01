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
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.videocomposition.a.a;
import d.d.b.a.b;
import d.d.d;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.az;
import kotlinx.coroutines.bk;
import kotlinx.coroutines.g;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "centerMatrix", "Landroid/graphics/Matrix;", "clipOffset", "", "clipPath", "Landroid/graphics/Path;", "clipRadius", "clipRect", "Landroid/graphics/RectF;", "firstThumb", "Landroid/graphics/Bitmap;", "noClipLeft", "", "noClipRight", "noRadiusLeft", "noRadiusRight", "paint", "Landroid/graphics/Paint;", "thumbDrawRect", "thumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "thumbList", "Ljava/util/LinkedList;", "thumbRect", "Landroid/graphics/Rect;", "thumbScale", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "noClip", "", "left", "right", "noRadius", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "release", "setTrackInfo", "info", "plugin-vlog_release"})
public final class FrameListView
  extends View
{
  private c ClG;
  private LinkedList<Bitmap> ClH;
  private Bitmap ClI;
  private float ClJ;
  private final RectF ClK;
  private boolean ClL;
  private boolean ClM;
  private boolean ClN;
  private boolean ClO;
  private final RectF ClP;
  private final float ClQ;
  private final float ClR;
  private final String TAG;
  private final Path pZY;
  private final Paint paint;
  private com.tencent.mm.videocomposition.c sQw;
  private final Matrix tVT;
  private final Rect yKZ;
  
  public FrameListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(192310);
    AppMethodBeat.o(192310);
  }
  
  public FrameListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192309);
    this.TAG = "MicroMsg.FrameListView";
    this.paint = new Paint();
    this.ClH = new LinkedList();
    this.ClJ = 1.0F;
    this.yKZ = new Rect();
    this.ClK = new RectF();
    this.tVT = new Matrix();
    this.pZY = new Path();
    this.ClP = new RectF();
    this.ClQ = com.tencent.mm.cb.a.fromDPToPix(paramContext, 4);
    this.ClR = com.tencent.mm.cb.a.fromDPToPix(paramContext, 4);
    this.paint.setColor(-65536);
    this.paint.setAntiAlias(true);
    AppMethodBeat.o(192309);
  }
  
  public final void ar(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.ClL = paramBoolean1;
    this.ClM = paramBoolean2;
  }
  
  public final void as(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.ClN = paramBoolean1;
    this.ClO = paramBoolean2;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(192307);
    p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    paramCanvas.save();
    paramCanvas.clipPath(this.pZY);
    Object localObject = this.ClG;
    if ((localObject != null) && (((c)localObject).Cml == true))
    {
      localObject = (Bitmap)d.a.j.F((List)this.ClH, 0);
      if (localObject != null)
      {
        paramCanvas.concat(this.tVT);
        paramCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, this.paint);
      }
      paramCanvas.restore();
      localObject = getBackground();
      if (localObject != null)
      {
        ((Drawable)localObject).setBounds((int)this.ClP.left, (int)this.ClP.top, (int)this.ClP.right, (int)this.ClP.bottom);
        ((Drawable)localObject).draw(paramCanvas);
        AppMethodBeat.o(192307);
      }
    }
    else
    {
      localObject = ((Iterable)this.ClH).iterator();
      label158:
      Bitmap localBitmap;
      if (((Iterator)localObject).hasNext())
      {
        localBitmap = (Bitmap)((Iterator)localObject).next();
        if (localBitmap == null) {
          break label213;
        }
        paramCanvas.drawBitmap(localBitmap, this.yKZ, this.ClK, this.paint);
      }
      for (;;)
      {
        paramCanvas.translate(this.ClK.right, 0.0F);
        break label158;
        break;
        label213:
        localBitmap = this.ClI;
        if (localBitmap != null) {
          paramCanvas.drawBitmap(localBitmap, this.yKZ, this.ClK, this.paint);
        }
      }
    }
    AppMethodBeat.o(192307);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(192306);
    int i = View.getDefaultSize(getSuggestedMinimumHeight(), paramInt2);
    this.ClK.bottom = i;
    paramInt1 = View.getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
    Object localObject1 = this.ClG;
    if (localObject1 != null)
    {
      this.yKZ.right = ((c)localObject1).width;
      this.yKZ.bottom = ((c)localObject1).height;
      this.ClJ = (i * 1.0F / ((c)localObject1).height);
      this.ClK.right = (this.ClJ * ((c)localObject1).width);
      paramInt1 = (int)(this.ClK.right * ((c)localObject1).Cmj);
    }
    localObject1 = this.ClG;
    paramInt2 = paramInt1;
    float f1;
    if (localObject1 != null)
    {
      paramInt2 = paramInt1;
      if (((c)localObject1).Cml == true)
      {
        localObject1 = this.tVT;
        f1 = this.yKZ.right;
        float f3 = this.yKZ.bottom;
        float f4 = i;
        p.h(localObject1, "$this$setRectToRectCenterCrop");
        com.tencent.mm.plugin.vlog.model.m.a((Matrix)localObject1, new RectF(0.0F, 0.0F, f1, f3), new RectF(0.0F, 0.0F, f4, f4));
        paramInt2 = i;
      }
    }
    label248:
    Object localObject2;
    Object localObject3;
    if (this.ClL)
    {
      this.ClP.left = 0.0F;
      if (!this.ClM) {
        break label505;
      }
      this.ClP.right = paramInt2;
      localObject2 = this.TAG;
      localObject3 = new StringBuilder("onMeasure: ").append(this.ClL).append(' ').append(this.ClM).append(", ").append(paramInt2).append(' ').append(i).append(", thumbScale:").append(this.ClJ).append(", trackInfo.width:");
      localObject1 = this.ClG;
      if (localObject1 == null) {
        break label522;
      }
      localObject1 = Integer.valueOf(((c)localObject1).width);
      label345:
      ae.i((String)localObject2, localObject1 + ", thumbDrawRect.right:" + this.ClK.right);
      this.ClP.bottom = i;
      this.pZY.reset();
      if (!this.ClN) {
        break label528;
      }
      f1 = 0.0F;
      label402:
      if (!this.ClO) {
        break label536;
      }
    }
    for (;;)
    {
      localObject1 = this.pZY;
      localObject2 = this.ClP;
      localObject3 = Path.Direction.CW;
      ((Path)localObject1).addRoundRect((RectF)localObject2, new float[] { f1, f1, f2, f2, f2, f2, f1, f1 }, (Path.Direction)localObject3);
      setMeasuredDimension(paramInt2, i);
      AppMethodBeat.o(192306);
      return;
      this.ClP.left = this.ClR;
      break;
      label505:
      this.ClP.right = (paramInt2 - this.ClR);
      break label248;
      label522:
      localObject1 = null;
      break label345;
      label528:
      f1 = this.ClQ;
      break label402;
      label536:
      f2 = this.ClQ;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(192308);
    com.tencent.mm.videocomposition.c localc = this.sQw;
    if (localc != null) {
      localc.destroy();
    }
    this.sQw = null;
    AppMethodBeat.o(192308);
  }
  
  public final void setTrackInfo(c paramc)
  {
    AppMethodBeat.i(192305);
    p.h(paramc, "info");
    this.ClG = paramc;
    this.ClH.clear();
    paramc = this.ClG;
    if (paramc != null)
    {
      paramc = paramc.Cmk;
      if (paramc != null)
      {
        paramc = ((Iterable)paramc).iterator();
        while (paramc.hasNext())
        {
          paramc.next();
          this.ClH.add(null);
        }
      }
    }
    kotlinx.coroutines.f.b((ah)bk.OfO, (d.d.f)az.gzR(), (d.g.a.m)new a(this, null), 2);
    AppMethodBeat.o(192305);
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.vlog.ui.thumb.FrameListView$setTrackInfo$2", f="FrameListView.kt", gkn={92}, m="invokeSuspend")
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class a
    extends d.d.b.a.j
    implements d.g.a.m<ah, d<? super z>, Object>
  {
    int label;
    Object ocA;
    private ah ocz;
    Object oqW;
    
    a(FrameListView paramFrameListView, d paramd)
    {
      super();
    }
    
    public final d<z> a(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(192303);
      p.h(paramd, "completion");
      paramd = new a(this.ClS, paramd);
      paramd.ocz = ((ah)paramObject);
      AppMethodBeat.o(192303);
      return paramd;
    }
    
    public final Object cR(Object paramObject)
    {
      AppMethodBeat.i(192302);
      paramObject = d.d.a.a.Nif;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(192302);
        throw paramObject;
      case 0: 
        final ah localah = this.ocz;
        ae.i(FrameListView.a(this.ClS), localah.hashCode() + " setTrackInfo launch");
        c localc = FrameListView.b(this.ClS);
        if (localc != null)
        {
          ae.i(FrameListView.a(this.ClS), localah.hashCode() + " setTrackInfo init thumb fetcher");
          Object localObject1 = FrameListView.c(this.ClS);
          if (localObject1 != null) {
            ((com.tencent.mm.videocomposition.c)localObject1).destroy();
          }
          localObject1 = this.ClS;
          Object localObject2 = com.tencent.mm.videocomposition.a.LJa;
          FrameListView.a((FrameListView)localObject1, (com.tencent.mm.videocomposition.c)a.a.a(localc.Cmm.BXV));
          localObject1 = FrameListView.c(this.ClS);
          if (localObject1 != null) {
            ((com.tencent.mm.videocomposition.c)localObject1).setSize(localc.width, localc.height);
          }
          ae.i(FrameListView.a(this.ClS), localah.hashCode() + " setTrackInfo finish init thumb fetcher, frames.size:" + localc.Cmk.size());
          localObject1 = FrameListView.c(this.ClS);
          if (localObject1 != null) {
            ((com.tencent.mm.videocomposition.c)localObject1).b(d.a.j.listOf(b.FW(0L)), (d.g.a.m)new a(this, localah));
          }
          localObject1 = FrameListView.c(this.ClS);
          if (localObject1 != null)
          {
            Object localObject3 = (Iterable)localc.Cmk;
            localObject2 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
            localObject3 = ((Iterable)localObject3).iterator();
            while (((Iterator)localObject3).hasNext()) {
              ((Collection)localObject2).add(b.FW(((a)((Iterator)localObject3).next()).Cly));
            }
            ((com.tencent.mm.videocomposition.c)localObject1).b((List)localObject2, (d.g.a.m)new b(localc, this, localah));
          }
          ae.i(FrameListView.a(this.ClS), localah.hashCode() + " setTrackInfo request layout");
          if ((!this.ClS.isInLayout()) || (localc.Cml))
          {
            localObject1 = (d.d.f)az.gzQ();
            localObject2 = (d.g.a.m)new c(null, this, localah);
            this.ocA = localah;
            this.oqW = localc;
            this.label = 1;
            if (g.a((d.d.f)localObject1, (d.g.a.m)localObject2, this) == paramObject)
            {
              AppMethodBeat.o(192302);
              return paramObject;
            }
          }
        }
        break;
      }
      paramObject = z.Nhr;
      AppMethodBeat.o(192302);
      return paramObject;
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(192304);
      paramObject1 = ((a)a(paramObject1, (d)paramObject2)).cR(z.Nhr);
      AppMethodBeat.o(192304);
      return paramObject1;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/ui/thumb/FrameListView$setTrackInfo$2$1$1"})
    static final class a
      extends q
      implements d.g.a.m<Long, Bitmap, z>
    {
      a(FrameListView.a parama, ah paramah)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/ui/thumb/FrameListView$setTrackInfo$2$1$3"})
    static final class b
      extends q
      implements d.g.a.m<Long, Bitmap, z>
    {
      b(c paramc, FrameListView.a parama, ah paramah)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/vlog/ui/thumb/FrameListView$setTrackInfo$2$1$4"})
    static final class c
      extends d.d.b.a.j
      implements d.g.a.m<ah, d<? super z>, Object>
    {
      int label;
      private ah ocz;
      
      c(d paramd, FrameListView.a parama, ah paramah)
      {
        super();
      }
      
      public final d<z> a(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(192300);
        p.h(paramd, "completion");
        paramd = new c(paramd, jdField_this, localah);
        paramd.ocz = ((ah)paramObject);
        AppMethodBeat.o(192300);
        return paramd;
      }
      
      public final Object cR(Object paramObject)
      {
        AppMethodBeat.i(192299);
        paramObject = d.d.a.a.Nif;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(192299);
          throw paramObject;
        }
        jdField_this.ClS.requestLayout();
        paramObject = z.Nhr;
        AppMethodBeat.o(192299);
        return paramObject;
      }
      
      public final Object p(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(192301);
        paramObject1 = ((c)a(paramObject1, (d)paramObject2)).cR(z.Nhr);
        AppMethodBeat.o(192301);
        return paramObject1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.FrameListView
 * JD-Core Version:    0.7.0.1
 */
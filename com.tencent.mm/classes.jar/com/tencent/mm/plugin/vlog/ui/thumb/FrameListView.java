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
import com.tencent.mm.sdk.platformtools.ad;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "centerMatrix", "Landroid/graphics/Matrix;", "clipOffset", "", "clipPath", "Landroid/graphics/Path;", "clipRadius", "clipRect", "Landroid/graphics/RectF;", "firstThumb", "Landroid/graphics/Bitmap;", "noClipLeft", "", "noClipRight", "noRadiusLeft", "noRadiusRight", "paint", "Landroid/graphics/Paint;", "thumbDrawRect", "thumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "thumbList", "Ljava/util/LinkedList;", "thumbRect", "Landroid/graphics/Rect;", "thumbScale", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "noClip", "", "left", "right", "noRadius", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "release", "setTrackInfo", "info", "plugin-vlog_release"})
public final class FrameListView
  extends View
{
  private c BUf;
  private LinkedList<Bitmap> BUg;
  private Bitmap BUh;
  private float BUi;
  private final RectF BUj;
  private boolean BUk;
  private boolean BUl;
  private boolean BUm;
  private boolean BUn;
  private final RectF BUo;
  private final float BUp;
  private final float BUq;
  private final String TAG;
  private final Path pTt;
  private final Paint paint;
  private com.tencent.mm.videocomposition.c sFx;
  private final Matrix tLc;
  private final Rect yuZ;
  
  public FrameListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(196847);
    AppMethodBeat.o(196847);
  }
  
  public FrameListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(196846);
    this.TAG = "MicroMsg.FrameListView";
    this.paint = new Paint();
    this.BUg = new LinkedList();
    this.BUi = 1.0F;
    this.yuZ = new Rect();
    this.BUj = new RectF();
    this.tLc = new Matrix();
    this.pTt = new Path();
    this.BUo = new RectF();
    this.BUp = com.tencent.mm.cc.a.fromDPToPix(paramContext, 4);
    this.BUq = com.tencent.mm.cc.a.fromDPToPix(paramContext, 4);
    this.paint.setColor(-65536);
    this.paint.setAntiAlias(true);
    AppMethodBeat.o(196846);
  }
  
  public final void as(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.BUk = paramBoolean1;
    this.BUl = paramBoolean2;
  }
  
  public final void at(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.BUm = paramBoolean1;
    this.BUn = paramBoolean2;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(196844);
    p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    paramCanvas.save();
    paramCanvas.clipPath(this.pTt);
    Object localObject = this.BUf;
    if ((localObject != null) && (((c)localObject).BUK == true))
    {
      localObject = (Bitmap)d.a.j.E((List)this.BUg, 0);
      if (localObject != null)
      {
        paramCanvas.concat(this.tLc);
        paramCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, this.paint);
      }
      paramCanvas.restore();
      localObject = getBackground();
      if (localObject != null)
      {
        ((Drawable)localObject).setBounds((int)this.BUo.left, (int)this.BUo.top, (int)this.BUo.right, (int)this.BUo.bottom);
        ((Drawable)localObject).draw(paramCanvas);
        AppMethodBeat.o(196844);
      }
    }
    else
    {
      localObject = ((Iterable)this.BUg).iterator();
      label158:
      Bitmap localBitmap;
      if (((Iterator)localObject).hasNext())
      {
        localBitmap = (Bitmap)((Iterator)localObject).next();
        if (localBitmap == null) {
          break label213;
        }
        paramCanvas.drawBitmap(localBitmap, this.yuZ, this.BUj, this.paint);
      }
      for (;;)
      {
        paramCanvas.translate(this.BUj.right, 0.0F);
        break label158;
        break;
        label213:
        localBitmap = this.BUh;
        if (localBitmap != null) {
          paramCanvas.drawBitmap(localBitmap, this.yuZ, this.BUj, this.paint);
        }
      }
    }
    AppMethodBeat.o(196844);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(196843);
    int i = View.getDefaultSize(getSuggestedMinimumHeight(), paramInt2);
    this.BUj.bottom = i;
    paramInt1 = View.getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
    Object localObject1 = this.BUf;
    if (localObject1 != null)
    {
      this.yuZ.right = ((c)localObject1).width;
      this.yuZ.bottom = ((c)localObject1).height;
      this.BUi = (i * 1.0F / ((c)localObject1).height);
      this.BUj.right = (this.BUi * ((c)localObject1).width);
      paramInt1 = (int)(this.BUj.right * ((c)localObject1).BUI);
    }
    localObject1 = this.BUf;
    paramInt2 = paramInt1;
    float f1;
    if (localObject1 != null)
    {
      paramInt2 = paramInt1;
      if (((c)localObject1).BUK == true)
      {
        localObject1 = this.tLc;
        f1 = this.yuZ.right;
        float f3 = this.yuZ.bottom;
        float f4 = i;
        p.h(localObject1, "$this$setRectToRectCenterCrop");
        com.tencent.mm.plugin.vlog.model.m.a((Matrix)localObject1, new RectF(0.0F, 0.0F, f1, f3), new RectF(0.0F, 0.0F, f4, f4));
        paramInt2 = i;
      }
    }
    label248:
    Object localObject2;
    Object localObject3;
    if (this.BUk)
    {
      this.BUo.left = 0.0F;
      if (!this.BUl) {
        break label505;
      }
      this.BUo.right = paramInt2;
      localObject2 = this.TAG;
      localObject3 = new StringBuilder("onMeasure: ").append(this.BUk).append(' ').append(this.BUl).append(", ").append(paramInt2).append(' ').append(i).append(", thumbScale:").append(this.BUi).append(", trackInfo.width:");
      localObject1 = this.BUf;
      if (localObject1 == null) {
        break label522;
      }
      localObject1 = Integer.valueOf(((c)localObject1).width);
      label345:
      ad.i((String)localObject2, localObject1 + ", thumbDrawRect.right:" + this.BUj.right);
      this.BUo.bottom = i;
      this.pTt.reset();
      if (!this.BUm) {
        break label528;
      }
      f1 = 0.0F;
      label402:
      if (!this.BUn) {
        break label536;
      }
    }
    for (;;)
    {
      localObject1 = this.pTt;
      localObject2 = this.BUo;
      localObject3 = Path.Direction.CW;
      ((Path)localObject1).addRoundRect((RectF)localObject2, new float[] { f1, f1, f2, f2, f2, f2, f1, f1 }, (Path.Direction)localObject3);
      setMeasuredDimension(paramInt2, i);
      AppMethodBeat.o(196843);
      return;
      this.BUo.left = this.BUq;
      break;
      label505:
      this.BUo.right = (paramInt2 - this.BUq);
      break label248;
      label522:
      localObject1 = null;
      break label345;
      label528:
      f1 = this.BUp;
      break label402;
      label536:
      f2 = this.BUp;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(196845);
    com.tencent.mm.videocomposition.c localc = this.sFx;
    if (localc != null) {
      localc.destroy();
    }
    this.sFx = null;
    AppMethodBeat.o(196845);
  }
  
  public final void setTrackInfo(c paramc)
  {
    AppMethodBeat.i(196842);
    p.h(paramc, "info");
    this.BUf = paramc;
    this.BUg.clear();
    paramc = this.BUf;
    if (paramc != null)
    {
      paramc = paramc.BUJ;
      if (paramc != null)
      {
        paramc = ((Iterable)paramc).iterator();
        while (paramc.hasNext())
        {
          paramc.next();
          this.BUg.add(null);
        }
      }
    }
    kotlinx.coroutines.f.b((ah)bk.NII, (d.d.f)az.gvp(), (d.g.a.m)new a(this, null), 2);
    AppMethodBeat.o(196842);
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.vlog.ui.thumb.FrameListView$setTrackInfo$2", f="FrameListView.kt", gfL={92}, m="invokeSuspend")
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class a
    extends d.d.b.a.j
    implements d.g.a.m<ah, d<? super z>, Object>
  {
    int label;
    private ah nWQ;
    Object nWR;
    Object olg;
    
    a(FrameListView paramFrameListView, d paramd)
    {
      super();
    }
    
    public final d<z> a(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(196840);
      p.h(paramd, "completion");
      paramd = new a(this.BUr, paramd);
      paramd.nWQ = ((ah)paramObject);
      AppMethodBeat.o(196840);
      return paramd;
    }
    
    public final Object cQ(Object paramObject)
    {
      AppMethodBeat.i(196839);
      paramObject = d.d.a.a.MLc;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(196839);
        throw paramObject;
      case 0: 
        final ah localah = this.nWQ;
        ad.i(FrameListView.a(this.BUr), localah.hashCode() + " setTrackInfo launch");
        c localc = FrameListView.b(this.BUr);
        if (localc != null)
        {
          ad.i(FrameListView.a(this.BUr), localah.hashCode() + " setTrackInfo init thumb fetcher");
          Object localObject1 = FrameListView.c(this.BUr);
          if (localObject1 != null) {
            ((com.tencent.mm.videocomposition.c)localObject1).destroy();
          }
          localObject1 = this.BUr;
          Object localObject2 = com.tencent.mm.videocomposition.a.Lmq;
          FrameListView.a((FrameListView)localObject1, (com.tencent.mm.videocomposition.c)a.a.a(localc.BUL.BGw));
          localObject1 = FrameListView.c(this.BUr);
          if (localObject1 != null) {
            ((com.tencent.mm.videocomposition.c)localObject1).setSize(localc.width, localc.height);
          }
          ad.i(FrameListView.a(this.BUr), localah.hashCode() + " setTrackInfo finish init thumb fetcher, frames.size:" + localc.BUJ.size());
          localObject1 = FrameListView.c(this.BUr);
          if (localObject1 != null) {
            ((com.tencent.mm.videocomposition.c)localObject1).b(d.a.j.listOf(b.Fu(0L)), (d.g.a.m)new a(this, localah));
          }
          localObject1 = FrameListView.c(this.BUr);
          if (localObject1 != null)
          {
            Object localObject3 = (Iterable)localc.BUJ;
            localObject2 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
            localObject3 = ((Iterable)localObject3).iterator();
            while (((Iterator)localObject3).hasNext()) {
              ((Collection)localObject2).add(b.Fu(((a)((Iterator)localObject3).next()).BTX));
            }
            ((com.tencent.mm.videocomposition.c)localObject1).b((List)localObject2, (d.g.a.m)new b(localc, this, localah));
          }
          ad.i(FrameListView.a(this.BUr), localah.hashCode() + " setTrackInfo request layout");
          if ((!this.BUr.isInLayout()) || (localc.BUK))
          {
            localObject1 = (d.d.f)az.gvo();
            localObject2 = (d.g.a.m)new c(null, this, localah);
            this.nWR = localah;
            this.olg = localc;
            this.label = 1;
            if (g.a((d.d.f)localObject1, (d.g.a.m)localObject2, this) == paramObject)
            {
              AppMethodBeat.o(196839);
              return paramObject;
            }
          }
        }
        break;
      }
      paramObject = z.MKo;
      AppMethodBeat.o(196839);
      return paramObject;
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(196841);
      paramObject1 = ((a)a(paramObject1, (d)paramObject2)).cQ(z.MKo);
      AppMethodBeat.o(196841);
      return paramObject1;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/ui/thumb/FrameListView$setTrackInfo$2$1$1"})
    static final class a
      extends q
      implements d.g.a.m<Long, Bitmap, z>
    {
      a(FrameListView.a parama, ah paramah)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/ui/thumb/FrameListView$setTrackInfo$2$1$3"})
    static final class b
      extends q
      implements d.g.a.m<Long, Bitmap, z>
    {
      b(c paramc, FrameListView.a parama, ah paramah)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/vlog/ui/thumb/FrameListView$setTrackInfo$2$1$4"})
    static final class c
      extends d.d.b.a.j
      implements d.g.a.m<ah, d<? super z>, Object>
    {
      int label;
      private ah nWQ;
      
      c(d paramd, FrameListView.a parama, ah paramah)
      {
        super();
      }
      
      public final d<z> a(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(196837);
        p.h(paramd, "completion");
        paramd = new c(paramd, jdField_this, localah);
        paramd.nWQ = ((ah)paramObject);
        AppMethodBeat.o(196837);
        return paramd;
      }
      
      public final Object cQ(Object paramObject)
      {
        AppMethodBeat.i(196836);
        paramObject = d.d.a.a.MLc;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(196836);
          throw paramObject;
        }
        jdField_this.BUr.requestLayout();
        paramObject = z.MKo;
        AppMethodBeat.o(196836);
        return paramObject;
      }
      
      public final Object p(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(196838);
        paramObject1 = ((c)a(paramObject1, (d)paramObject2)).cQ(z.MKo);
        AppMethodBeat.o(196838);
        return paramObject1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.FrameListView
 * JD-Core Version:    0.7.0.1
 */
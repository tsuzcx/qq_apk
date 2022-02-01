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
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "centerMatrix", "Landroid/graphics/Matrix;", "clipOffset", "", "clipPath", "Landroid/graphics/Path;", "clipRadius", "clipRect", "Landroid/graphics/RectF;", "firstThumb", "Landroid/graphics/Bitmap;", "noClipLeft", "", "noClipRight", "noRadiusLeft", "noRadiusRight", "paint", "Landroid/graphics/Paint;", "thumbDrawRect", "thumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "thumbFetcherExtraData", "", "thumbFetcherFactory", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ThumbFetcherFactory;", "thumbList", "Ljava/util/LinkedList;", "thumbRect", "Landroid/graphics/Rect;", "thumbScale", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "clearThumbs", "", "noClip", "left", "right", "noRadius", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "release", "setThumbFetcherExtraData", "data", "setThumbFetcherFactory", "setToDefaultThumbFetcherFactory", "setTrackInfo", "info", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FrameListView
  extends View
{
  private c FTn;
  private final Matrix HLq;
  private g Mdf;
  private a Mkg;
  private final RectF MlJ;
  private final float MlK;
  private final Rect Pdg;
  private final String TAG;
  private Object UpC;
  private LinkedList<Bitmap> Upm;
  private Bitmap Upn;
  private float Upo;
  private final RectF Upp;
  private boolean Upq;
  private boolean Upr;
  private boolean Ups;
  private boolean Upt;
  private final float Upu;
  private final Paint paint;
  private final Path yjb;
  
  public FrameListView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(281646);
    AppMethodBeat.o(281646);
  }
  
  public FrameListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(281641);
    AppMethodBeat.o(281641);
  }
  
  public FrameListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(281637);
    this.TAG = "MicroMsg.FrameListView";
    this.paint = new Paint();
    this.Upm = new LinkedList();
    this.Upo = 1.0F;
    this.Pdg = new Rect();
    this.Upp = new RectF();
    this.HLq = new Matrix();
    this.yjb = new Path();
    this.MlJ = new RectF();
    this.MlK = com.tencent.mm.cd.a.fromDPToPix(paramContext, 4);
    this.Upu = com.tencent.mm.cd.a.fromDPToPix(paramContext, 4);
    this.Mdf = ((g)new b());
    this.paint.setColor(-65536);
    this.paint.setAntiAlias(true);
    AppMethodBeat.o(281637);
  }
  
  private final void hUq()
  {
    AppMethodBeat.i(281653);
    Log.i(this.TAG, "clearThumb");
    this.Upm.clear();
    this.Upn = null;
    postInvalidate();
    AppMethodBeat.o(281653);
  }
  
  public final void bl(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.Upq = paramBoolean1;
    this.Upr = paramBoolean2;
  }
  
  public final void bm(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.Ups = paramBoolean1;
    this.Upt = paramBoolean2;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    int i = 1;
    AppMethodBeat.i(281743);
    s.u(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    Log.i(this.TAG, "onDraw, trackInfo:" + this.Mkg + ", thumbList.size:" + this.Upm.size());
    paramCanvas.save();
    paramCanvas.clipPath(this.yjb);
    Object localObject = this.Mkg;
    if ((localObject != null) && (((a)localObject).UoT == true)) {}
    while (i != 0)
    {
      localObject = (Bitmap)p.ae((List)this.Upm, 0);
      if (localObject != null)
      {
        paramCanvas.concat(this.HLq);
        paramCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, this.paint);
      }
      paramCanvas.restore();
      localObject = getBackground();
      if (localObject != null)
      {
        ((Drawable)localObject).setBounds((int)this.MlJ.left, (int)this.MlJ.top, (int)this.MlJ.right, (int)this.MlJ.bottom);
        ((Drawable)localObject).draw(paramCanvas);
      }
      AppMethodBeat.o(281743);
      return;
      i = 0;
    }
    localObject = ((Iterable)this.Upm).iterator();
    label212:
    Bitmap localBitmap;
    if (((Iterator)localObject).hasNext())
    {
      localBitmap = (Bitmap)((Iterator)localObject).next();
      if (localBitmap == null) {
        break label270;
      }
      paramCanvas.drawBitmap(localBitmap, this.Pdg, this.Upp, this.paint);
    }
    for (;;)
    {
      paramCanvas.translate(this.Upp.right, 0.0F);
      break label212;
      break;
      label270:
      localBitmap = this.Upn;
      if (localBitmap != null) {
        paramCanvas.drawBitmap(localBitmap, this.Pdg, this.Upp, this.paint);
      }
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(281734);
    int i = View.getDefaultSize(getSuggestedMinimumHeight(), paramInt2);
    this.Upp.bottom = i;
    paramInt1 = View.getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
    Object localObject1 = this.Mkg;
    if (localObject1 != null)
    {
      this.Pdg.right = ((a)localObject1).width;
      this.Pdg.bottom = ((a)localObject1).height;
      this.Upo = (i * 1.0F / ((a)localObject1).height);
      this.Upp.right = (this.Upo * ((a)localObject1).width);
      paramInt1 = (int)(this.Upp.right * ((a)localObject1).UoR);
    }
    localObject1 = this.Mkg;
    float f1;
    label234:
    label250:
    Object localObject2;
    Object localObject3;
    if ((localObject1 != null) && (((a)localObject1).UoT == true))
    {
      paramInt2 = 1;
      if (paramInt2 != 0)
      {
        localObject1 = this.HLq;
        f1 = this.Pdg.right;
        float f3 = this.Pdg.bottom;
        float f4 = i;
        s.u(localObject1, "<this>");
        t.a((Matrix)localObject1, new RectF(0.0F, 0.0F, f1, f3), new RectF(0.0F, 0.0F, f4, f4));
        paramInt1 = i;
      }
      if (!this.Upq) {
        break label491;
      }
      this.MlJ.left = 0.0F;
      if (!this.Upr) {
        break label505;
      }
      this.MlJ.right = paramInt1;
      localObject2 = this.TAG;
      localObject3 = new StringBuilder("onMeasure: ").append(this.Upq).append(' ').append(this.Upr).append(", ").append(paramInt1).append(' ').append(i).append(", thumbScale:").append(this.Upo).append(", trackInfo.width:");
      localObject1 = this.Mkg;
      if (localObject1 != null) {
        break label522;
      }
      localObject1 = null;
      label340:
      Log.i((String)localObject2, localObject1 + ", thumbDrawRect.right:" + this.Upp.right);
      this.MlJ.bottom = i;
      this.yjb.reset();
      if (!this.Ups) {
        break label535;
      }
      f1 = 0.0F;
      label397:
      if (!this.Upt) {
        break label543;
      }
    }
    for (;;)
    {
      localObject1 = this.yjb;
      localObject2 = this.MlJ;
      localObject3 = Path.Direction.CW;
      ((Path)localObject1).addRoundRect((RectF)localObject2, new float[] { f1, f1, f2, f2, f2, f2, f1, f1 }, (Path.Direction)localObject3);
      setMeasuredDimension(paramInt1, i);
      AppMethodBeat.o(281734);
      return;
      paramInt2 = 0;
      break;
      label491:
      this.MlJ.left = this.Upu;
      break label234;
      label505:
      this.MlJ.right = (paramInt1 - this.Upu);
      break label250;
      label522:
      localObject1 = Integer.valueOf(((a)localObject1).width);
      break label340;
      label535:
      f1 = this.MlK;
      break label397;
      label543:
      f2 = this.MlK;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(281750);
    c localc = this.FTn;
    if (localc != null) {
      localc.destroy();
    }
    this.FTn = null;
    this.Mkg = null;
    hUq();
    AppMethodBeat.o(281750);
  }
  
  public final void setThumbFetcherExtraData(Object paramObject)
  {
    this.UpC = paramObject;
  }
  
  public final void setThumbFetcherFactory(g paramg)
  {
    AppMethodBeat.i(281701);
    s.u(paramg, "thumbFetcherFactory");
    this.Mdf = paramg;
    hUq();
    AppMethodBeat.o(281701);
  }
  
  public final void setTrackInfo(a parama)
  {
    AppMethodBeat.i(281711);
    s.u(parama, "info");
    this.Mkg = parama;
    this.Upm.clear();
    parama = this.Mkg;
    if (parama != null)
    {
      parama = parama.UoS;
      if (parama != null)
      {
        parama = ((Iterable)parama).iterator();
        while (parama.hasNext())
        {
          parama.next();
          this.Upm.add(null);
        }
      }
    }
    j.a((aq)bu.ajwo, (f)bg.kCi(), null, (m)new a(this, null), 2);
    AppMethodBeat.o(281711);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    a(FrameListView paramFrameListView, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(281571);
      paramd = new a(this.UpD, paramd);
      paramd.L$0 = paramObject;
      paramObject = (d)paramd;
      AppMethodBeat.o(281571);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(281566);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(281566);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Object localObject1 = (aq)this.L$0;
        Log.i(FrameListView.a(this.UpD), localObject1.hashCode() + " setTrackInfo launch");
        final a locala1 = FrameListView.b(this.UpD);
        if (locala1 != null)
        {
          paramObject = this.UpD;
          Log.i(FrameListView.a(paramObject), localObject1.hashCode() + " setTrackInfo init thumb fetcher");
          c localc = FrameListView.c(paramObject);
          if (localc != null) {
            localc.destroy();
          }
          FrameListView.a(paramObject, FrameListView.d(paramObject).a(locala1, FrameListView.e(paramObject)));
          localc = FrameListView.c(paramObject);
          if (localc != null) {
            localc.setSize(locala1.width, locala1.height);
          }
          Log.i(FrameListView.a(paramObject), localObject1.hashCode() + " setTrackInfo finish init thumb fetcher, frames.size:" + locala1.UoS.size());
          localc = FrameListView.c(paramObject);
          if (localc != null) {
            localc.b(p.listOf(kotlin.d.b.a.b.BF(0L)), (m)new a(paramObject));
          }
          localc = FrameListView.c(paramObject);
          if (localc != null)
          {
            Object localObject2 = (Iterable)locala1.UoS;
            Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
            localObject2 = ((Iterable)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              localCollection.add(kotlin.d.b.a.b.BF(((e)((Iterator)localObject2).next()).GvM));
            }
            localc.b((List)localCollection, (m)new b(paramObject, locala1));
          }
          Log.i(FrameListView.a(paramObject), localObject1.hashCode() + " setTrackInfo request layout");
          if ((!paramObject.isInLayout()) || (locala1.UoT))
          {
            localObject1 = (f)bg.kCh();
            paramObject = (m)new c(paramObject, null);
            this.label = 1;
            if (l.a((f)localObject1, paramObject, this) == locala)
            {
              AppMethodBeat.o(281566);
              return locala;
            }
          }
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(281566);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements m<Long, Bitmap, ah>
    {
      a(FrameListView paramFrameListView)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements m<Long, Bitmap, ah>
    {
      b(FrameListView paramFrameListView, a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends k
      implements m<aq, d<? super ah>, Object>
    {
      int label;
      
      c(FrameListView paramFrameListView, d<? super c> paramd)
      {
        super(paramd);
      }
      
      public final d<ah> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(281589);
        paramObject = (d)new c(this.UpD, paramd);
        AppMethodBeat.o(281589);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(281583);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(281583);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        this.UpD.requestLayout();
        paramObject = ah.aiuX;
        AppMethodBeat.o(281583);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.FrameListView
 * JD-Core Version:    0.7.0.1
 */
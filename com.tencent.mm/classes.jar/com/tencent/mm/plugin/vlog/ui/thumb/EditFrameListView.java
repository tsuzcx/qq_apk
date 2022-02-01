package com.tencent.mm.plugin.vlog.ui.thumb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.c;
import com.tencent.mm.videocomposition.c.a;
import com.tencent.mm.videocomposition.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.d.b.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clipOffset", "", "clipPath", "Landroid/graphics/Path;", "clipRadius", "clipRect", "Landroid/graphics/RectF;", "firstThumb", "Landroid/graphics/Bitmap;", "frameWidth", "getFrameWidth", "()I", "setFrameWidth", "(I)V", "leftExtend", "minDuration", "", "minWidth", "getMinWidth", "setMinWidth", "noClipLeft", "", "noClipRight", "noRadiusLeft", "noRadiusRight", "paint", "Landroid/graphics/Paint;", "rightExtend", "showWidth", "getShowWidth", "setShowWidth", "thumbDrawRect", "thumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "thumbList", "Ljava/util/LinkedList;", "thumbRect", "Landroid/graphics/Rect;", "thumbScale", "totalFrameWidth", "getTotalFrameWidth", "setTotalFrameWidth", "totalWidth", "getTotalWidth", "setTotalWidth", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "validWidth", "getValidWidth", "noClip", "", "left", "right", "noRadius", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "release", "setTrackInfo", "info", "parentHeight", "Companion", "plugin-vlog_release"})
public final class EditFrameListView
  extends View
{
  public static final EditFrameListView.a GPl;
  private final Rect COM;
  private int GJa;
  private h GOV;
  private LinkedList<Bitmap> GOW;
  private Bitmap GOX;
  private float GOY;
  private final RectF GOZ;
  boolean GPa;
  boolean GPb;
  boolean GPc;
  boolean GPd;
  private final RectF GPe;
  private final float GPf;
  private final float GPg;
  private int GPh;
  private int GPi;
  private int GPj;
  private int GPk;
  private int kxW;
  private int minWidth;
  private final Paint paint;
  private final Path rqV;
  private final long tXD;
  g vNj;
  
  static
  {
    AppMethodBeat.i(192065);
    GPl = new EditFrameListView.a((byte)0);
    AppMethodBeat.o(192065);
  }
  
  public EditFrameListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(192064);
    AppMethodBeat.o(192064);
  }
  
  public EditFrameListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192063);
    this.paint = new Paint();
    this.GOW = new LinkedList();
    this.GOY = 1.0F;
    this.COM = new Rect();
    this.GOZ = new RectF();
    this.rqV = new Path();
    this.GPe = new RectF();
    this.GPf = com.tencent.mm.cb.a.fromDPToPix(paramContext, 4);
    this.GPg = com.tencent.mm.cb.a.fromDPToPix(paramContext, 4);
    this.tXD = 3000L;
    this.paint.setColor(-65536);
    this.paint.setAntiAlias(true);
    AppMethodBeat.o(192063);
  }
  
  public final void a(h paramh, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192060);
    p.h(paramh, "info");
    this.GOV = paramh;
    this.GOW.clear();
    Object localObject = this.GOV;
    if (localObject != null)
    {
      localObject = ((a)localObject).GOG;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ((Iterator)localObject).next();
          this.GOW.add(null);
        }
      }
    }
    this.COM.right = paramh.width;
    this.COM.bottom = paramh.height;
    this.GOY = (paramInt * 1.0F / paramh.height);
    this.GOZ.bottom = paramInt;
    this.GOZ.right = (this.GOY * paramh.width);
    this.GPk = ((int)(this.GOZ.right * paramh.GOF));
    this.minWidth = ((int)((float)this.tXD / (float)paramh.GQc.GzA.GJB * this.GPk));
    if (paramh.GQb)
    {
      paramInt = (int)(this.GPk * (float)paramh.GOE / (float)paramh.GQc.GzA.GJB);
      this.kxW = paramInt;
      if (!paramBoolean1) {
        break label416;
      }
      paramInt = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
      label246:
      this.GPh = paramInt;
      if (!paramBoolean2) {
        break label428;
      }
    }
    label416:
    label428:
    for (paramInt = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);; paramInt = com.tencent.mm.cb.a.fromDPToPix(getContext(), 4))
    {
      this.GPi = paramInt;
      this.GPj = (this.kxW + this.GPh + this.GPi);
      this.GJa = (this.GPk + this.GPh + this.GPi);
      kotlinx.coroutines.f.b((ai)bn.TUK, (kotlin.d.f)ba.hMW(), (m)new b(this, null), 2);
      AppMethodBeat.o(192060);
      return;
      if (paramh.GQa)
      {
        paramInt = (int)(this.GPk * (float)(paramh.GQc.GzA.GJB - paramh.GOD) / (float)paramh.GQc.GzA.GJB);
        break;
      }
      paramInt = (int)(this.GPk * (float)paramh.fEu() / (float)paramh.GQc.GzA.GJB);
      break;
      paramInt = com.tencent.mm.cb.a.fromDPToPix(getContext(), 4);
      break label246;
    }
  }
  
  public final int getFrameWidth()
  {
    return this.kxW;
  }
  
  public final int getMinWidth()
  {
    return this.minWidth;
  }
  
  public final int getShowWidth()
  {
    return this.GPj;
  }
  
  public final int getTotalFrameWidth()
  {
    return this.GPk;
  }
  
  public final int getTotalWidth()
  {
    return this.GJa;
  }
  
  public final int getValidWidth()
  {
    AppMethodBeat.i(192059);
    float f1 = this.GPk;
    h localh = this.GOV;
    if (localh == null) {
      p.hyc();
    }
    float f2 = (float)localh.fEu();
    localh = this.GOV;
    if (localh == null) {
      p.hyc();
    }
    int i = (int)(f1 * f2 / (float)localh.GQc.GzA.GJB);
    int j = this.GPh;
    int k = this.GPi;
    AppMethodBeat.o(192059);
    return i + j + k;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(192062);
    p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    Log.i("MicroMsg.EditFrameListView", "onDraw: " + this + ", width:" + getWidth() + ", showWidth:" + this.GPj + ", track:" + this.GOV);
    paramCanvas.translate(this.GPh, 0.0F);
    paramCanvas.save();
    paramCanvas.clipPath(this.rqV);
    Object localObject = this.GOV;
    if ((localObject != null) && (!((h)localObject).GQb)) {
      paramCanvas.translate(-(float)((a)localObject).GOD / (float)((h)localObject).GQc.GzA.GJB * this.GPk, 0.0F);
    }
    localObject = ((Iterable)this.GOW).iterator();
    if (((Iterator)localObject).hasNext())
    {
      Bitmap localBitmap = (Bitmap)((Iterator)localObject).next();
      if (localBitmap != null) {
        paramCanvas.drawBitmap(localBitmap, this.COM, this.GOZ, this.paint);
      }
      for (;;)
      {
        paramCanvas.translate(this.GOZ.right, 0.0F);
        break;
        localBitmap = this.GOX;
        if (localBitmap != null) {
          paramCanvas.drawBitmap(localBitmap, this.COM, this.GOZ, this.paint);
        }
      }
    }
    paramCanvas.restore();
    localObject = getBackground();
    if (localObject != null)
    {
      ((Drawable)localObject).setBounds((int)this.GPe.left, (int)this.GPe.top, (int)this.GPe.right, (int)this.GPe.bottom);
      ((Drawable)localObject).draw(paramCanvas);
      AppMethodBeat.o(192062);
      return;
    }
    AppMethodBeat.o(192062);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(192061);
    int i = View.getDefaultSize(getSuggestedMinimumHeight(), paramInt2);
    label53:
    Object localObject2;
    Object localObject1;
    label147:
    float f1;
    if (this.GPa)
    {
      this.GPe.left = 0.0F;
      if (!this.GPb) {
        break label307;
      }
      this.GPe.right = this.kxW;
      localObject2 = new StringBuilder("onMeasure: ").append(this.GPa).append(' ').append(this.GPb).append(", ").append(getWidth()).append(' ').append(i).append(", thumbScale:").append(this.GOY).append(", trackInfo.width:");
      localObject1 = this.GOV;
      if (localObject1 == null) {
        break label327;
      }
      localObject1 = Integer.valueOf(((a)localObject1).width);
      Log.i("MicroMsg.EditFrameListView", localObject1 + ", thumbDrawRect.right:" + this.GOZ.right);
      this.GPe.bottom = i;
      this.rqV.reset();
      if (!this.GPc) {
        break label333;
      }
      f1 = 0.0F;
      label205:
      if (!this.GPd) {
        break label341;
      }
    }
    for (;;)
    {
      localObject1 = this.rqV;
      localObject2 = this.GPe;
      Path.Direction localDirection = Path.Direction.CW;
      ((Path)localObject1).addRoundRect((RectF)localObject2, new float[] { f1, f1, f2, f2, f2, f2, f1, f1 }, localDirection);
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(192061);
      return;
      this.GPe.left = this.GPg;
      break;
      label307:
      this.GPe.right = (this.kxW - this.GPg);
      break label53;
      label327:
      localObject1 = null;
      break label147;
      label333:
      f1 = this.GPf;
      break label205;
      label341:
      f2 = this.GPf;
    }
  }
  
  public final void setFrameWidth(int paramInt)
  {
    this.kxW = paramInt;
  }
  
  public final void setMinWidth(int paramInt)
  {
    this.minWidth = paramInt;
  }
  
  public final void setShowWidth(int paramInt)
  {
    this.GPj = paramInt;
  }
  
  public final void setTotalFrameWidth(int paramInt)
  {
    this.GPk = paramInt;
  }
  
  public final void setTotalWidth(int paramInt)
  {
    this.GJa = paramInt;
  }
  
  @kotlin.d.b.a.f(c="com.tencent.mm.plugin.vlog.ui.thumb.EditFrameListView$setTrackInfo$2", f="EditFrameListView.kt", hxM={}, m="invokeSuspend")
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends kotlin.d.b.a.j
    implements m<ai, kotlin.d.d<? super x>, Object>
  {
    int label;
    private ai p$;
    
    b(EditFrameListView paramEditFrameListView, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(192057);
      p.h(paramd, "completion");
      paramd = new b(this.GPm, paramd);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(192057);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(192058);
      paramObject1 = ((b)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.SXb);
      AppMethodBeat.o(192058);
      return paramObject1;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(192056);
      Object localObject1 = kotlin.d.a.a.SXO;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(192056);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.p$;
      Log.i("MicroMsg.EditFrameListView", paramObject.hashCode() + " setTrackInfo launch");
      localObject1 = EditFrameListView.a(this.GPm);
      if (localObject1 != null)
      {
        Log.i("MicroMsg.EditFrameListView", paramObject.hashCode() + " setTrackInfo init thumb fetcher");
        Object localObject2 = EditFrameListView.b(this.GPm);
        if (localObject2 != null) {
          ((g)localObject2).destroy();
        }
        localObject2 = this.GPm;
        Object localObject3 = c.RgU;
        EditFrameListView.a((EditFrameListView)localObject2, (g)c.a.b(((h)localObject1).GQc.GzA));
        localObject2 = EditFrameListView.b(this.GPm);
        if (localObject2 != null) {
          ((g)localObject2).setSize(((a)localObject1).width, ((a)localObject1).height);
        }
        Log.i("MicroMsg.EditFrameListView", paramObject.hashCode() + " setTrackInfo finish init thumb fetcher, frames.size:" + ((a)localObject1).GOG.size());
        localObject2 = EditFrameListView.b(this.GPm);
        if (localObject2 != null) {
          ((g)localObject2).b(kotlin.a.j.listOf(b.Pe(0L)), (m)new a(this, paramObject));
        }
        localObject2 = EditFrameListView.b(this.GPm);
        if (localObject2 != null)
        {
          Object localObject4 = (Iterable)((a)localObject1).GOG;
          localObject3 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext()) {
            ((Collection)localObject3).add(b.Pe(((e)((Iterator)localObject4).next()).Asv));
          }
          ((g)localObject2).b((List)localObject3, (m)new b((h)localObject1, this, paramObject));
        }
      }
      paramObject = x.SXb;
      AppMethodBeat.o(192056);
      return paramObject;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/ui/thumb/EditFrameListView$setTrackInfo$2$1$1"})
    static final class a
      extends q
      implements m<Long, Bitmap, x>
    {
      a(EditFrameListView.b paramb, ai paramai)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/ui/thumb/EditFrameListView$setTrackInfo$2$1$3"})
    static final class b
      extends q
      implements m<Long, Bitmap, x>
    {
      b(h paramh, EditFrameListView.b paramb, ai paramai)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.EditFrameListView
 * JD-Core Version:    0.7.0.1
 */
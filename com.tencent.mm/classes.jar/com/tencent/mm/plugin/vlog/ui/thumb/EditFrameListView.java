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
import com.tencent.mm.videocomposition.a.a;
import com.tencent.mm.videocomposition.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.d.b.a.b;
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
import kotlinx.coroutines.g;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clipOffset", "", "clipPath", "Landroid/graphics/Path;", "clipRadius", "clipRect", "Landroid/graphics/RectF;", "firstThumb", "Landroid/graphics/Bitmap;", "frameWidth", "getFrameWidth", "()I", "setFrameWidth", "(I)V", "leftExtend", "minDuration", "", "minWidth", "getMinWidth", "setMinWidth", "noClipLeft", "", "noClipRight", "noRadiusLeft", "noRadiusRight", "paint", "Landroid/graphics/Paint;", "rightExtend", "showWidth", "getShowWidth", "setShowWidth", "thumbDrawRect", "thumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "thumbList", "Ljava/util/LinkedList;", "thumbRect", "Landroid/graphics/Rect;", "thumbScale", "totalFrameWidth", "getTotalFrameWidth", "setTotalFrameWidth", "totalWidth", "getTotalWidth", "setTotalWidth", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "validWidth", "getValidWidth", "noClip", "", "left", "right", "noRadius", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "release", "setTrackInfo", "info", "parentHeight", "Companion", "plugin-vlog_release"})
public final class EditFrameListView
  extends View
{
  public static final EditFrameListView.a NCR;
  c Aub;
  private final RectF GrG;
  private final float GrH;
  private int Gry;
  private final Rect IUo;
  private h NCD;
  private LinkedList<Bitmap> NCE;
  private Bitmap NCF;
  private float NCG;
  private final RectF NCH;
  boolean NCI;
  boolean NCJ;
  boolean NCK;
  boolean NCL;
  private final float NCM;
  private int NCN;
  private int NCO;
  private int NCP;
  private int NCQ;
  private int NzM;
  private int nqW;
  private final Paint paint;
  private final Path uWB;
  private final long xJy;
  
  static
  {
    AppMethodBeat.i(243960);
    NCR = new EditFrameListView.a((byte)0);
    AppMethodBeat.o(243960);
  }
  
  public EditFrameListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(243959);
    AppMethodBeat.o(243959);
  }
  
  public EditFrameListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(243957);
    this.paint = new Paint();
    this.NCE = new LinkedList();
    this.NCG = 1.0F;
    this.IUo = new Rect();
    this.NCH = new RectF();
    this.uWB = new Path();
    this.GrG = new RectF();
    this.GrH = com.tencent.mm.ci.a.fromDPToPix(paramContext, 4);
    this.NCM = com.tencent.mm.ci.a.fromDPToPix(paramContext, 4);
    this.xJy = 3000L;
    this.paint.setColor(-65536);
    this.paint.setAntiAlias(true);
    AppMethodBeat.o(243957);
  }
  
  public final void a(h paramh, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(243954);
    p.k(paramh, "info");
    this.NCD = paramh;
    this.NCE.clear();
    Object localObject = this.NCD;
    if (localObject != null)
    {
      localObject = ((a)localObject).NCm;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ((Iterator)localObject).next();
          this.NCE.add(null);
        }
      }
    }
    this.IUo.right = paramh.width;
    this.IUo.bottom = paramh.height;
    this.NCG = (paramInt * 1.0F / paramh.height);
    this.NCH.bottom = paramInt;
    this.NCH.right = (this.NCG * paramh.width);
    this.NCQ = ((int)(this.NCH.right * paramh.NCl));
    this.Gry = ((int)((float)this.xJy / (float)paramh.getTotalDuration() * this.NCQ));
    if (paramh.NCq)
    {
      paramInt = (int)(this.NCQ * (float)paramh.NCk / (float)paramh.getTotalDuration());
      this.nqW = paramInt;
      if (!paramBoolean1) {
        break label386;
      }
      paramInt = com.tencent.mm.ci.a.fromDPToPix(getContext(), 8);
      label234:
      this.NCN = paramInt;
      if (!paramBoolean2) {
        break label398;
      }
    }
    label386:
    label398:
    for (paramInt = com.tencent.mm.ci.a.fromDPToPix(getContext(), 8);; paramInt = com.tencent.mm.ci.a.fromDPToPix(getContext(), 4))
    {
      this.NCO = paramInt;
      this.NCP = (this.nqW + this.NCN + this.NCO);
      this.NzM = (this.NCQ + this.NCN + this.NCO);
      g.b((ak)br.abxo, (f)bc.iRs(), (m)new b(this, null), 2);
      AppMethodBeat.o(243954);
      return;
      if (paramh.NCp)
      {
        paramInt = (int)(this.NCQ * (float)(paramh.getTotalDuration() - paramh.NCj) / (float)paramh.getTotalDuration());
        break;
      }
      paramInt = (int)(this.NCQ * (float)paramh.gwv() / (float)paramh.getTotalDuration());
      break;
      paramInt = com.tencent.mm.ci.a.fromDPToPix(getContext(), 4);
      break label234;
    }
  }
  
  public final int getFrameWidth()
  {
    return this.nqW;
  }
  
  public final int getMinWidth()
  {
    return this.Gry;
  }
  
  public final int getShowWidth()
  {
    return this.NCP;
  }
  
  public final int getTotalFrameWidth()
  {
    return this.NCQ;
  }
  
  public final int getTotalWidth()
  {
    return this.NzM;
  }
  
  public final int getValidWidth()
  {
    AppMethodBeat.i(243953);
    float f1 = this.NCQ;
    h localh = this.NCD;
    if (localh == null) {
      p.iCn();
    }
    float f2 = (float)localh.gwv();
    localh = this.NCD;
    if (localh == null) {
      p.iCn();
    }
    int i = (int)(f1 * f2 / (float)localh.getTotalDuration());
    int j = this.NCN;
    int k = this.NCO;
    AppMethodBeat.o(243953);
    return i + j + k;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(243956);
    p.k(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    Log.i("MicroMsg.EditFrameListView", "onDraw: " + this + ", width:" + getWidth() + ", showWidth:" + this.NCP + ", track:" + this.NCD);
    paramCanvas.translate(this.NCN, 0.0F);
    paramCanvas.save();
    paramCanvas.clipPath(this.uWB);
    Object localObject = this.NCD;
    if ((localObject != null) && (!((a)localObject).NCq)) {
      paramCanvas.translate(-(float)((a)localObject).NCj / (float)((h)localObject).getTotalDuration() * this.NCQ, 0.0F);
    }
    localObject = ((Iterable)this.NCE).iterator();
    if (((Iterator)localObject).hasNext())
    {
      Bitmap localBitmap = (Bitmap)((Iterator)localObject).next();
      if (localBitmap != null) {
        paramCanvas.drawBitmap(localBitmap, this.IUo, this.NCH, this.paint);
      }
      for (;;)
      {
        paramCanvas.translate(this.NCH.right, 0.0F);
        break;
        localBitmap = this.NCF;
        if (localBitmap != null) {
          paramCanvas.drawBitmap(localBitmap, this.IUo, this.NCH, this.paint);
        }
      }
    }
    paramCanvas.restore();
    localObject = getBackground();
    if (localObject != null)
    {
      ((Drawable)localObject).setBounds((int)this.GrG.left, (int)this.GrG.top, (int)this.GrG.right, (int)this.GrG.bottom);
      ((Drawable)localObject).draw(paramCanvas);
      AppMethodBeat.o(243956);
      return;
    }
    AppMethodBeat.o(243956);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(243955);
    int i = View.getDefaultSize(getSuggestedMinimumHeight(), paramInt2);
    label53:
    Object localObject2;
    Object localObject1;
    label147:
    float f1;
    if (this.NCI)
    {
      this.GrG.left = 0.0F;
      if (!this.NCJ) {
        break label307;
      }
      this.GrG.right = this.nqW;
      localObject2 = new StringBuilder("onMeasure: ").append(this.NCI).append(' ').append(this.NCJ).append(", ").append(getWidth()).append(' ').append(i).append(", thumbScale:").append(this.NCG).append(", trackInfo.width:");
      localObject1 = this.NCD;
      if (localObject1 == null) {
        break label327;
      }
      localObject1 = Integer.valueOf(((a)localObject1).width);
      Log.i("MicroMsg.EditFrameListView", localObject1 + ", thumbDrawRect.right:" + this.NCH.right);
      this.GrG.bottom = i;
      this.uWB.reset();
      if (!this.NCK) {
        break label333;
      }
      f1 = 0.0F;
      label205:
      if (!this.NCL) {
        break label341;
      }
    }
    for (;;)
    {
      localObject1 = this.uWB;
      localObject2 = this.GrG;
      Path.Direction localDirection = Path.Direction.CW;
      ((Path)localObject1).addRoundRect((RectF)localObject2, new float[] { f1, f1, f2, f2, f2, f2, f1, f1 }, localDirection);
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(243955);
      return;
      this.GrG.left = this.NCM;
      break;
      label307:
      this.GrG.right = (this.nqW - this.NCM);
      break label53;
      label327:
      localObject1 = null;
      break label147;
      label333:
      f1 = this.GrH;
      break label205;
      label341:
      f2 = this.GrH;
    }
  }
  
  public final void setFrameWidth(int paramInt)
  {
    this.nqW = paramInt;
  }
  
  public final void setMinWidth(int paramInt)
  {
    this.Gry = paramInt;
  }
  
  public final void setShowWidth(int paramInt)
  {
    this.NCP = paramInt;
  }
  
  public final void setTotalFrameWidth(int paramInt)
  {
    this.NCQ = paramInt;
  }
  
  public final void setTotalWidth(int paramInt)
  {
    this.NzM = paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends kotlin.d.b.a.j
    implements m<ak, d<? super x>, Object>
  {
    int label;
    private ak p$;
    
    b(EditFrameListView paramEditFrameListView, d paramd)
    {
      super(paramd);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(244159);
      p.k(paramd, "completion");
      paramd = new b(this.NCS, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(244159);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(244160);
      paramObject1 = ((b)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(244160);
      return paramObject1;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(244158);
      Object localObject1 = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(244158);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.p$;
      Log.i("MicroMsg.EditFrameListView", paramObject.hashCode() + " setTrackInfo launch");
      localObject1 = EditFrameListView.a(this.NCS);
      if (localObject1 != null)
      {
        Log.i("MicroMsg.EditFrameListView", paramObject.hashCode() + " setTrackInfo init thumb fetcher");
        Object localObject2 = EditFrameListView.b(this.NCS);
        if (localObject2 != null) {
          ((c)localObject2).destroy();
        }
        localObject2 = this.NCS;
        Object localObject3 = com.tencent.mm.videocomposition.a.YHM;
        EditFrameListView.a((EditFrameListView)localObject2, (c)a.a.d(((h)localObject1).NDI.Nng));
        localObject2 = EditFrameListView.b(this.NCS);
        if (localObject2 != null) {
          ((c)localObject2).setSize(((a)localObject1).width, ((a)localObject1).height);
        }
        Log.i("MicroMsg.EditFrameListView", paramObject.hashCode() + " setTrackInfo finish init thumb fetcher, frames.size:" + ((a)localObject1).NCm.size());
        localObject2 = EditFrameListView.b(this.NCS);
        if (localObject2 != null) {
          ((c)localObject2).b(kotlin.a.j.listOf(b.Xu(0L)), (m)new a(this, paramObject));
        }
        localObject2 = EditFrameListView.b(this.NCS);
        if (localObject2 != null)
        {
          Object localObject4 = (Iterable)((a)localObject1).NCm;
          localObject3 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext()) {
            ((Collection)localObject3).add(b.Xu(((e)((Iterator)localObject4).next()).GhA));
          }
          ((c)localObject2).b((List)localObject3, (m)new b((h)localObject1, this, paramObject));
        }
      }
      paramObject = x.aazN;
      AppMethodBeat.o(244158);
      return paramObject;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/ui/thumb/EditFrameListView$setTrackInfo$2$1$1"})
    static final class a
      extends q
      implements m<Long, Bitmap, x>
    {
      a(EditFrameListView.b paramb, ak paramak)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/ui/thumb/EditFrameListView$setTrackInfo$2$1$3"})
    static final class b
      extends q
      implements m<Long, Bitmap, x>
    {
      b(h paramh, EditFrameListView.b paramb, ak paramak)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.EditFrameListView
 * JD-Core Version:    0.7.0.1
 */
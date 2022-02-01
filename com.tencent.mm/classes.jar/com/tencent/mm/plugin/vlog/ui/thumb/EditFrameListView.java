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
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.b.a.b;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clipOffset", "", "clipPath", "Landroid/graphics/Path;", "clipRadius", "clipRect", "Landroid/graphics/RectF;", "firstThumb", "Landroid/graphics/Bitmap;", "frameWidth", "getFrameWidth", "()I", "setFrameWidth", "(I)V", "leftExtend", "minDuration", "", "minWidth", "getMinWidth", "setMinWidth", "noClipLeft", "", "noClipRight", "noRadiusLeft", "noRadiusRight", "paint", "Landroid/graphics/Paint;", "rightExtend", "showWidth", "getShowWidth", "setShowWidth", "thumbDrawRect", "thumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "thumbList", "Ljava/util/LinkedList;", "thumbRect", "Landroid/graphics/Rect;", "thumbScale", "totalFrameWidth", "getTotalFrameWidth", "setTotalFrameWidth", "totalWidth", "getTotalWidth", "setTotalWidth", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "validWidth", "getValidWidth", "noClip", "", "left", "right", "noRadius", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "release", "setTrackInfo", "info", "parentHeight", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EditFrameListView
  extends View
{
  public static final EditFrameListView.a Upk;
  private int Bdl;
  private final long Bjj;
  private int DWv;
  c FTn;
  private final RectF MlJ;
  private final float MlK;
  private final Rect Pdg;
  private h Upl;
  private LinkedList<Bitmap> Upm;
  private Bitmap Upn;
  private float Upo;
  private final RectF Upp;
  boolean Upq;
  boolean Upr;
  boolean Ups;
  boolean Upt;
  private final float Upu;
  private int Upv;
  private int Upw;
  private int Upx;
  private int Upy;
  private final Paint paint;
  private int qpD;
  private final Path yjb;
  
  static
  {
    AppMethodBeat.i(281748);
    Upk = new EditFrameListView.a((byte)0);
    AppMethodBeat.o(281748);
  }
  
  public EditFrameListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(281718);
    AppMethodBeat.o(281718);
  }
  
  public EditFrameListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(281710);
    this.paint = new Paint();
    this.Upm = new LinkedList();
    this.Upo = 1.0F;
    this.Pdg = new Rect();
    this.Upp = new RectF();
    this.yjb = new Path();
    this.MlJ = new RectF();
    this.MlK = com.tencent.mm.cd.a.fromDPToPix(paramContext, 4);
    this.Upu = com.tencent.mm.cd.a.fromDPToPix(paramContext, 4);
    this.Bjj = 3000L;
    this.paint.setColor(-65536);
    this.paint.setAntiAlias(true);
    AppMethodBeat.o(281710);
  }
  
  public final void a(h paramh, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(281816);
    s.u(paramh, "info");
    this.Upl = paramh;
    this.Upm.clear();
    Object localObject = this.Upl;
    if (localObject != null)
    {
      localObject = ((a)localObject).UoS;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ((Iterator)localObject).next();
          this.Upm.add(null);
        }
      }
    }
    this.Pdg.right = paramh.width;
    this.Pdg.bottom = paramh.height;
    this.Upo = (paramInt * 1.0F / paramh.height);
    this.Upp.bottom = paramInt;
    this.Upp.right = (this.Upo * paramh.width);
    this.Upy = ((int)(this.Upp.right * paramh.UoR));
    this.DWv = ((int)((float)this.Bjj / (float)paramh.getTotalDuration() * this.Upy));
    if (paramh.UoW)
    {
      paramInt = (int)(this.Upy * (float)paramh.UoQ / (float)paramh.getTotalDuration());
      this.qpD = paramInt;
      if (!paramBoolean1) {
        break label387;
      }
      paramInt = com.tencent.mm.cd.a.fromDPToPix(getContext(), 8);
      label234:
      this.Upv = paramInt;
      if (!paramBoolean2) {
        break label399;
      }
    }
    label387:
    label399:
    for (paramInt = com.tencent.mm.cd.a.fromDPToPix(getContext(), 8);; paramInt = com.tencent.mm.cd.a.fromDPToPix(getContext(), 4))
    {
      this.Upw = paramInt;
      this.Upx = (this.qpD + this.Upv + this.Upw);
      this.Bdl = (this.Upy + this.Upv + this.Upw);
      j.a((aq)bu.ajwo, (f)bg.kCi(), null, (m)new b(this, null), 2);
      AppMethodBeat.o(281816);
      return;
      if (paramh.UoV)
      {
        paramInt = (int)(this.Upy * (float)(paramh.getTotalDuration() - paramh.UoP) / (float)paramh.getTotalDuration());
        break;
      }
      paramInt = (int)(this.Upy * (float)paramh.hUo() / (float)paramh.getTotalDuration());
      break;
      paramInt = com.tencent.mm.cd.a.fromDPToPix(getContext(), 4);
      break label234;
    }
  }
  
  public final int getFrameWidth()
  {
    return this.qpD;
  }
  
  public final int getMinWidth()
  {
    return this.DWv;
  }
  
  public final int getShowWidth()
  {
    return this.Upx;
  }
  
  public final int getTotalFrameWidth()
  {
    return this.Upy;
  }
  
  public final int getTotalWidth()
  {
    return this.Bdl;
  }
  
  public final int getValidWidth()
  {
    AppMethodBeat.i(281788);
    float f1 = this.Upy;
    h localh = this.Upl;
    s.checkNotNull(localh);
    float f2 = (float)localh.hUo();
    localh = this.Upl;
    s.checkNotNull(localh);
    int i = (int)(f1 * f2 / (float)localh.getTotalDuration());
    int j = this.Upv;
    int k = this.Upw;
    AppMethodBeat.o(281788);
    return i + j + k;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(281844);
    s.u(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    Log.i("MicroMsg.EditFrameListView", "onDraw: " + this + ", width:" + getWidth() + ", showWidth:" + this.Upx + ", track:" + this.Upl);
    paramCanvas.translate(this.Upv, 0.0F);
    paramCanvas.save();
    paramCanvas.clipPath(this.yjb);
    Object localObject = this.Upl;
    if ((localObject != null) && (!((a)localObject).UoW)) {
      paramCanvas.translate(-(float)((a)localObject).UoP / (float)((h)localObject).getTotalDuration() * getTotalFrameWidth(), 0.0F);
    }
    localObject = ((Iterable)this.Upm).iterator();
    if (((Iterator)localObject).hasNext())
    {
      Bitmap localBitmap = (Bitmap)((Iterator)localObject).next();
      if (localBitmap != null) {
        paramCanvas.drawBitmap(localBitmap, this.Pdg, this.Upp, this.paint);
      }
      for (;;)
      {
        paramCanvas.translate(this.Upp.right, 0.0F);
        break;
        localBitmap = this.Upn;
        if (localBitmap != null) {
          paramCanvas.drawBitmap(localBitmap, this.Pdg, this.Upp, this.paint);
        }
      }
    }
    paramCanvas.restore();
    localObject = getBackground();
    if (localObject != null)
    {
      ((Drawable)localObject).setBounds((int)this.MlJ.left, (int)this.MlJ.top, (int)this.MlJ.right, (int)this.MlJ.bottom);
      ((Drawable)localObject).draw(paramCanvas);
    }
    AppMethodBeat.o(281844);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(281832);
    int i = View.getDefaultSize(getSuggestedMinimumHeight(), paramInt2);
    label53:
    Object localObject2;
    Object localObject1;
    label140:
    float f1;
    if (this.Upq)
    {
      this.MlJ.left = 0.0F;
      if (!this.Upr) {
        break label300;
      }
      this.MlJ.right = this.qpD;
      localObject2 = new StringBuilder("onMeasure: ").append(this.Upq).append(' ').append(this.Upr).append(", ").append(getWidth()).append(' ').append(i).append(", thumbScale:").append(this.Upo).append(", trackInfo.width:");
      localObject1 = this.Upl;
      if (localObject1 != null) {
        break label320;
      }
      localObject1 = null;
      Log.i("MicroMsg.EditFrameListView", localObject1 + ", thumbDrawRect.right:" + this.Upp.right);
      this.MlJ.bottom = i;
      this.yjb.reset();
      if (!this.Ups) {
        break label333;
      }
      f1 = 0.0F;
      label198:
      if (!this.Upt) {
        break label341;
      }
    }
    for (;;)
    {
      localObject1 = this.yjb;
      localObject2 = this.MlJ;
      Path.Direction localDirection = Path.Direction.CW;
      ((Path)localObject1).addRoundRect((RectF)localObject2, new float[] { f1, f1, f2, f2, f2, f2, f1, f1 }, localDirection);
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(281832);
      return;
      this.MlJ.left = this.Upu;
      break;
      label300:
      this.MlJ.right = (this.qpD - this.Upu);
      break label53;
      label320:
      localObject1 = Integer.valueOf(((a)localObject1).width);
      break label140;
      label333:
      f1 = this.MlK;
      break label198;
      label341:
      f2 = this.MlK;
    }
  }
  
  public final void setFrameWidth(int paramInt)
  {
    this.qpD = paramInt;
  }
  
  public final void setMinWidth(int paramInt)
  {
    this.DWv = paramInt;
  }
  
  public final void setShowWidth(int paramInt)
  {
    this.Upx = paramInt;
  }
  
  public final void setTotalFrameWidth(int paramInt)
  {
    this.Upy = paramInt;
  }
  
  public final void setTotalWidth(int paramInt)
  {
    this.Bdl = paramInt;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    b(EditFrameListView paramEditFrameListView, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(281700);
      paramd = new b(this.Upz, paramd);
      paramd.L$0 = paramObject;
      paramObject = (d)paramd;
      AppMethodBeat.o(281700);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(281694);
      Object localObject1 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(281694);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      Object localObject2 = (aq)this.L$0;
      Log.i("MicroMsg.EditFrameListView", localObject2.hashCode() + " setTrackInfo launch");
      paramObject = EditFrameListView.a(this.Upz);
      if (paramObject != null)
      {
        localObject1 = this.Upz;
        Log.i("MicroMsg.EditFrameListView", localObject2.hashCode() + " setTrackInfo init thumb fetcher");
        Object localObject3 = EditFrameListView.b((EditFrameListView)localObject1);
        if (localObject3 != null) {
          ((c)localObject3).destroy();
        }
        localObject3 = com.tencent.mm.videocomposition.a.agDr;
        EditFrameListView.a((EditFrameListView)localObject1, (c)a.a.d(paramObject.Uqg.UaI));
        localObject3 = EditFrameListView.b((EditFrameListView)localObject1);
        if (localObject3 != null) {
          ((c)localObject3).setSize(paramObject.width, paramObject.height);
        }
        Log.i("MicroMsg.EditFrameListView", localObject2.hashCode() + " setTrackInfo finish init thumb fetcher, frames.size:" + paramObject.UoS.size());
        localObject2 = EditFrameListView.b((EditFrameListView)localObject1);
        if (localObject2 != null) {
          ((c)localObject2).b(p.listOf(b.BF(0L)), (m)new a((EditFrameListView)localObject1));
        }
        localObject2 = EditFrameListView.b((EditFrameListView)localObject1);
        if (localObject2 != null)
        {
          Object localObject4 = (Iterable)paramObject.UoS;
          localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext()) {
            ((Collection)localObject3).add(b.BF(((e)((Iterator)localObject4).next()).GvM));
          }
          ((c)localObject2).b((List)localObject3, (m)new b((EditFrameListView)localObject1, paramObject));
        }
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(281694);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "bitmap", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements m<Long, Bitmap, ah>
    {
      a(EditFrameListView paramEditFrameListView)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements m<Long, Bitmap, ah>
    {
      b(EditFrameListView paramEditFrameListView, h paramh)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.EditFrameListView
 * JD-Core Version:    0.7.0.1
 */
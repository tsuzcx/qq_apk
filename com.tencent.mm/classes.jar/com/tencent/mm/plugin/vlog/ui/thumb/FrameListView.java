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
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.t;
import com.tencent.mm.plugin.vlog.model.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavkit.composition.resource.TAVImageResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import d.g.a.m;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "centerMatrix", "Landroid/graphics/Matrix;", "clipOffset", "", "clipPath", "Landroid/graphics/Path;", "clipRadius", "clipRect", "Landroid/graphics/RectF;", "paint", "Landroid/graphics/Paint;", "thumbDrawRect", "thumbFetcher", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ITrackThumbFetcher;", "thumbList", "Ljava/util/LinkedList;", "Landroid/graphics/Bitmap;", "thumbRect", "Landroid/graphics/Rect;", "thumbScale", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onDetachedFromWindow", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setThumbList", "", "setTrackInfo", "info", "plugin-vlog_release"})
public final class FrameListView
  extends View
{
  private d AuQ;
  private LinkedList<Bitmap> AuR;
  private float AuS;
  private final RectF AuT;
  private final RectF AuU;
  private final float AuV;
  private final float AuW;
  private final String TAG;
  private final Paint paint;
  private final Path ppS;
  private c rKw;
  private final Matrix sOw;
  private final Rect xgY;
  
  public FrameListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(207920);
    AppMethodBeat.o(207920);
  }
  
  public FrameListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(207919);
    this.TAG = "MicroMsg.FrameListView";
    this.paint = new Paint();
    this.AuR = new LinkedList();
    this.AuS = 1.0F;
    this.xgY = new Rect();
    this.AuT = new RectF();
    this.sOw = new Matrix();
    this.ppS = new Path();
    this.AuU = new RectF();
    this.AuV = com.tencent.mm.cc.a.fromDPToPix(paramContext, 4);
    this.AuW = com.tencent.mm.cc.a.fromDPToPix(paramContext, 2);
    this.paint.setColor(-65536);
    this.paint.setAntiAlias(true);
    AppMethodBeat.o(207919);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(207918);
    super.onDetachedFromWindow();
    c localc = this.rKw;
    if (localc != null) {
      localc.destroy();
    }
    this.rKw = null;
    AppMethodBeat.o(207918);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(207917);
    k.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    int i = paramCanvas.getSaveCount();
    paramCanvas.clipPath(this.ppS);
    Object localObject = this.AuQ;
    if ((localObject != null) && (((d)localObject).AvC == true))
    {
      localObject = (Bitmap)d.a.j.C((List)this.AuR, 0);
      if (localObject != null)
      {
        paramCanvas.concat(this.sOw);
        paramCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, this.paint);
      }
    }
    for (;;)
    {
      paramCanvas.restoreToCount(i);
      AppMethodBeat.o(207917);
      return;
      localObject = ((Iterable)this.AuR).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bitmap localBitmap = (Bitmap)((Iterator)localObject).next();
        ac.i(this.TAG, "onDraw: ".concat(String.valueOf(localBitmap)));
        if (localBitmap != null) {
          paramCanvas.drawBitmap(localBitmap, this.xgY, this.AuT, this.paint);
        }
        paramCanvas.translate(this.AuT.right, 0.0F);
      }
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207916);
    int i = View.getDefaultSize(getSuggestedMinimumHeight(), paramInt2);
    this.AuT.bottom = i;
    paramInt1 = View.getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
    d locald = this.AuQ;
    if (locald != null)
    {
      this.xgY.right = locald.width;
      this.xgY.bottom = locald.height;
      this.AuS = (i * 1.0F / locald.height);
      this.AuT.right = (this.AuS * locald.width);
      paramInt1 = (int)(this.AuT.right * locald.AvA);
    }
    locald = this.AuQ;
    paramInt2 = paramInt1;
    if (locald != null)
    {
      paramInt2 = paramInt1;
      if (locald.AvC == true)
      {
        com.tencent.mm.plugin.vlog.model.j.a(this.sOw, this.xgY.right, this.xgY.bottom, 0.0F, 0.0F, i, i);
        paramInt2 = i;
      }
    }
    this.AuU.left = this.AuW;
    this.AuU.right = (paramInt2 - this.AuW);
    this.AuU.bottom = i;
    this.ppS.reset();
    this.ppS.addRoundRect(this.AuU, this.AuV, this.AuV, Path.Direction.CW);
    setMeasuredDimension(paramInt2, i);
    AppMethodBeat.o(207916);
  }
  
  public final void setThumbList(List<Bitmap> paramList)
  {
    AppMethodBeat.i(207915);
    k.h(paramList, "thumbList");
    this.AuR.clear();
    this.AuR.addAll((Collection)paramList);
    postInvalidate();
    AppMethodBeat.o(207915);
  }
  
  public final void setTrackInfo(d paramd)
  {
    AppMethodBeat.i(207914);
    this.AuQ = paramd;
    ac.i(this.TAG, hashCode() + " setTrackInfo launch");
    ac.i(this.TAG, hashCode() + " setTrackInfo in launch");
    this.AuR.clear();
    paramd = this.AuQ;
    if (paramd != null)
    {
      paramd = paramd.AvB;
      if (paramd != null)
      {
        paramd = ((Iterable)paramd).iterator();
        while (paramd.hasNext())
        {
          paramd.next();
          this.AuR.add(null);
        }
      }
    }
    d locald = this.AuQ;
    if (locald != null)
    {
      ac.i(this.TAG, hashCode() + " setTrackInfo init thumb fetcher");
      paramd = this.rKw;
      if (paramd != null) {
        paramd.destroy();
      }
      paramd = t.Aop;
      Object localObject1 = locald.AnN;
      k.h(localObject1, "track");
      if (((u)localObject1).type == 1)
      {
        paramd = new TAVClip((TAVResource)new TAVImageResource(new CIImage(((u)localObject1).efJ()), CMTime.fromMs(((u)localObject1).getDurationMs())));
        paramd.setDuration(CMTime.fromMs(((u)localObject1).getDurationMs()));
        ac.i("MicroMsg.VLogCompositionTrack", ((u)localObject1).id + " build image thumb clip, path:" + ((u)localObject1).path + ", material startEnd:[" + ((u)localObject1).bvf + ", " + ((u)localObject1).gOz + ']');
      }
      for (;;)
      {
        paramd.setStartTime(CMTime.CMTimeZero);
        Object localObject2 = paramd.getVideoConfiguration();
        k.g(localObject2, "clip.videoConfiguration");
        ((TAVVideoConfiguration)localObject2).setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
        localObject2 = new TAVComposition();
        ((TAVComposition)localObject2).addVideoChannel(d.a.j.listOf(paramd));
        paramd = new TAVCompositionBuilder((TAVComposition)localObject2);
        paramd.setReloadChannels(false);
        paramd = paramd.buildSource();
        k.g(paramd, "builder.buildSource()");
        this.rKw = ((c)new t(paramd, ((u)localObject1).path, (byte)0));
        paramd = this.rKw;
        if (paramd != null) {
          paramd.setSize(locald.width, locald.height);
        }
        paramd = this.rKw;
        if (paramd != null) {
          paramd.init();
        }
        ac.i(this.TAG, hashCode() + " setTrackInfo finish init thumb fetcher");
        paramd = this.rKw;
        if (paramd == null) {
          break label724;
        }
        localObject2 = (Iterable)locald.AvB;
        localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(Long.valueOf(((a)((Iterator)localObject2).next()).Aoq));
        }
        paramd = new TAVClip((Asset)new URLAsset(i.k(((u)localObject1).path, false)));
        paramd.setStartTime(CMTime.fromMs(((u)localObject1).bvf));
        ac.i("MicroMsg.VLogCompositionTrack", ((u)localObject1).id + " build Video thumb Clip, path:" + ((u)localObject1).path + ", video startEnd:[" + ((u)localObject1).Aox + ", " + ((u)localObject1).Aoy + "], material startEnd:[" + ((u)localObject1).bvf + ", " + ((u)localObject1).gOz + ']');
      }
      paramd.b((List)localObject1, (m)new a(locald, this));
      label724:
      ac.i(this.TAG, hashCode() + " setTrackInfo request layout");
      if ((!isInLayout()) || (locald.AvC == true)) {
        requestLayout();
      }
      AppMethodBeat.o(207914);
      return;
    }
    AppMethodBeat.o(207914);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/ui/thumb/FrameListView$setTrackInfo$2$2"})
  static final class a
    extends d.g.b.l
    implements m<Long, Bitmap, y>
  {
    a(d paramd, FrameListView paramFrameListView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.FrameListView
 * JD-Core Version:    0.7.0.1
 */
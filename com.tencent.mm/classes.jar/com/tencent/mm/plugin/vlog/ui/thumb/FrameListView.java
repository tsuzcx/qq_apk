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
import com.tencent.mm.plugin.vlog.model.p;
import com.tencent.mm.plugin.vlog.model.x;
import com.tencent.mm.sdk.platformtools.ad;
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
import d.a.j;
import d.g.a.m;
import d.g.b.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "centerMatrix", "Landroid/graphics/Matrix;", "clipOffset", "", "clipPath", "Landroid/graphics/Path;", "clipRadius", "clipRect", "Landroid/graphics/RectF;", "paint", "Landroid/graphics/Paint;", "thumbDrawRect", "thumbFetcher", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ITrackThumbFetcher;", "thumbList", "Ljava/util/LinkedList;", "Landroid/graphics/Bitmap;", "thumbRect", "Landroid/graphics/Rect;", "thumbScale", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onDetachedFromWindow", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setThumbList", "", "setTrackInfo", "info", "plugin-vlog_release"})
public final class FrameListView
  extends View
{
  private final RectF HTV;
  private c KZb;
  private d Lvg;
  private LinkedList<Bitmap> Lvh;
  private float Lvi;
  private final RectF Lvj;
  private final float Lvk;
  private final float Lvl;
  private final String TAG;
  private final Path oMy;
  private final Paint paint;
  private final Matrix rGJ;
  private final Rect vWl;
  
  public FrameListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(201235);
    AppMethodBeat.o(201235);
  }
  
  public FrameListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(201234);
    this.TAG = "MicroMsg.FrameListView";
    this.paint = new Paint();
    this.Lvh = new LinkedList();
    this.Lvi = 1.0F;
    this.vWl = new Rect();
    this.Lvj = new RectF();
    this.rGJ = new Matrix();
    this.oMy = new Path();
    this.HTV = new RectF();
    this.Lvk = com.tencent.mm.cd.a.fromDPToPix(paramContext, 4);
    this.Lvl = com.tencent.mm.cd.a.fromDPToPix(paramContext, 2);
    this.paint.setColor(-65536);
    this.paint.setAntiAlias(true);
    AppMethodBeat.o(201234);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(201233);
    super.onDetachedFromWindow();
    c localc = this.KZb;
    if (localc != null) {
      localc.destroy();
    }
    this.KZb = null;
    AppMethodBeat.o(201233);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(201232);
    k.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    int i = paramCanvas.getSaveCount();
    paramCanvas.clipPath(this.oMy);
    Object localObject = this.Lvg;
    if ((localObject != null) && (((d)localObject).LvP == true))
    {
      localObject = (Bitmap)j.C((List)this.Lvh, 0);
      if (localObject != null)
      {
        paramCanvas.concat(this.rGJ);
        paramCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, this.paint);
      }
    }
    for (;;)
    {
      paramCanvas.restoreToCount(i);
      AppMethodBeat.o(201232);
      return;
      localObject = ((Iterable)this.Lvh).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bitmap localBitmap = (Bitmap)((Iterator)localObject).next();
        ad.i(this.TAG, "onDraw: ".concat(String.valueOf(localBitmap)));
        if (localBitmap != null) {
          paramCanvas.drawBitmap(localBitmap, this.vWl, this.Lvj, this.paint);
        }
        paramCanvas.translate(this.Lvj.right, 0.0F);
      }
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201231);
    int i = View.getDefaultSize(getSuggestedMinimumHeight(), paramInt2);
    this.Lvj.bottom = i;
    paramInt1 = View.getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
    d locald = this.Lvg;
    if (locald != null)
    {
      this.vWl.right = locald.width;
      this.vWl.bottom = locald.height;
      this.Lvi = (i * 1.0F / locald.height);
      this.Lvj.right = (this.Lvi * locald.width);
      paramInt1 = (int)(this.Lvj.right * locald.LvN);
    }
    locald = this.Lvg;
    paramInt2 = paramInt1;
    if (locald != null)
    {
      paramInt2 = paramInt1;
      if (locald.LvP == true)
      {
        p.a(this.rGJ, this.vWl.right, this.vWl.bottom, 0.0F, 0.0F, i, i);
        paramInt2 = i;
      }
    }
    this.HTV.left = this.Lvl;
    this.HTV.right = (paramInt2 - this.Lvl);
    this.HTV.bottom = i;
    this.oMy.reset();
    this.oMy.addRoundRect(this.HTV, this.Lvk, this.Lvk, Path.Direction.CW);
    setMeasuredDimension(paramInt2, i);
    AppMethodBeat.o(201231);
  }
  
  public final void setThumbList(List<Bitmap> paramList)
  {
    AppMethodBeat.i(201230);
    k.h(paramList, "thumbList");
    this.Lvh.clear();
    this.Lvh.addAll((Collection)paramList);
    postInvalidate();
    AppMethodBeat.o(201230);
  }
  
  public final void setTrackInfo(d paramd)
  {
    AppMethodBeat.i(201229);
    this.Lvg = paramd;
    ad.i(this.TAG, hashCode() + " setTrackInfo launch");
    ad.i(this.TAG, hashCode() + " setTrackInfo in launch");
    this.Lvh.clear();
    paramd = this.Lvg;
    if (paramd != null)
    {
      paramd = paramd.LvO;
      if (paramd != null)
      {
        paramd = ((Iterable)paramd).iterator();
        while (paramd.hasNext())
        {
          paramd.next();
          this.Lvh.add(null);
        }
      }
    }
    d locald = this.Lvg;
    if (locald != null)
    {
      ad.i(this.TAG, hashCode() + " setTrackInfo init thumb fetcher");
      paramd = this.KZb;
      if (paramd != null) {
        paramd.destroy();
      }
      paramd = x.Lrh;
      Object localObject1 = locald.LqI;
      k.h(localObject1, "track");
      if (((com.tencent.mm.plugin.vlog.model.y)localObject1).type == 1)
      {
        paramd = new TAVClip((TAVResource)new TAVImageResource(new CIImage(((com.tencent.mm.plugin.vlog.model.y)localObject1).fYP()), CMTime.fromMs(((com.tencent.mm.plugin.vlog.model.y)localObject1).cuR())));
        paramd.setDuration(CMTime.fromMs(((com.tencent.mm.plugin.vlog.model.y)localObject1).cuR()));
        ad.i("MicroMsg.VLogCompositionTrack", ((com.tencent.mm.plugin.vlog.model.y)localObject1).id + " build image thumb clip, path:" + ((com.tencent.mm.plugin.vlog.model.y)localObject1).path + ", material startEnd:[" + ((com.tencent.mm.plugin.vlog.model.y)localObject1).bxw + ", " + ((com.tencent.mm.plugin.vlog.model.y)localObject1).gnO + ']');
      }
      for (;;)
      {
        paramd.setStartTime(CMTime.CMTimeZero);
        Object localObject2 = paramd.getVideoConfiguration();
        k.g(localObject2, "clip.videoConfiguration");
        ((TAVVideoConfiguration)localObject2).setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
        localObject2 = new TAVComposition();
        ((TAVComposition)localObject2).addVideoChannel(j.listOf(paramd));
        paramd = new TAVCompositionBuilder((TAVComposition)localObject2);
        paramd.setReloadChannels(false);
        paramd = paramd.buildSource();
        k.g(paramd, "builder.buildSource()");
        this.KZb = ((c)new x(paramd, ((com.tencent.mm.plugin.vlog.model.y)localObject1).path, (byte)0));
        paramd = this.KZb;
        if (paramd != null) {
          paramd.setSize(locald.width, locald.height);
        }
        paramd = this.KZb;
        if (paramd != null) {
          paramd.init();
        }
        ad.i(this.TAG, hashCode() + " setTrackInfo finish init thumb fetcher");
        paramd = this.KZb;
        if (paramd == null) {
          break label724;
        }
        localObject2 = (Iterable)locald.LvO;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(Long.valueOf(((a)((Iterator)localObject2).next()).Lri));
        }
        paramd = new TAVClip((Asset)new URLAsset(i.k(((com.tencent.mm.plugin.vlog.model.y)localObject1).path, false)));
        paramd.setStartTime(CMTime.fromMs(((com.tencent.mm.plugin.vlog.model.y)localObject1).bxw));
        ad.i("MicroMsg.VLogCompositionTrack", ((com.tencent.mm.plugin.vlog.model.y)localObject1).id + " build Video thumb Clip, path:" + ((com.tencent.mm.plugin.vlog.model.y)localObject1).path + ", video startEnd:[" + ((com.tencent.mm.plugin.vlog.model.y)localObject1).Lro + ", " + ((com.tencent.mm.plugin.vlog.model.y)localObject1).Lrp + "], material startEnd:[" + ((com.tencent.mm.plugin.vlog.model.y)localObject1).bxw + ", " + ((com.tencent.mm.plugin.vlog.model.y)localObject1).gnO + ']');
      }
      paramd.b((List)localObject1, (m)new a(locald, this));
      label724:
      ad.i(this.TAG, hashCode() + " setTrackInfo request layout");
      if ((!isInLayout()) || (locald.LvP == true)) {
        requestLayout();
      }
      AppMethodBeat.o(201229);
      return;
    }
    AppMethodBeat.o(201229);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/ui/thumb/FrameListView$setTrackInfo$2$2"})
  static final class a
    extends d.g.b.l
    implements m<Long, Bitmap, d.y>
  {
    a(d paramd, FrameListView paramFrameListView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.FrameListView
 * JD-Core Version:    0.7.0.1
 */
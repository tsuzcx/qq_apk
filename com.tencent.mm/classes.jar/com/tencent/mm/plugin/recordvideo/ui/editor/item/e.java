package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.editor.a.h;
import com.tencent.mm.plugin.recordvideo.background.f;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "Landroid/view/View;", "Lcom/tencent/mm/media/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DP_1", "", "LAST_INTERVAL", "", "LYRICS_VERTICAL_OFFSET", "", "MARGIN", "TAG", "", "TRANS_TIME", "WAVE_DECREMENT", "WAVE_INCREMENT", "WAVE_INVALIDAT_INTERVAL", "WAVE_RECT_COUNT", "WAVE_RECT_HEIGHT", "WAVE_RECT_MIN_HEIGHT", "WAVE_RECT_OFFSET", "WAVE_RECT_WIDTH", "alpha", "bitmapList", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "getBitmapList", "()Ljava/util/ArrayList;", "setBitmapList", "(Ljava/util/ArrayList;)V", "curIndex", "getCurIndex", "()I", "setCurIndex", "(I)V", "displayRect", "Landroid/graphics/Rect;", "getDisplayRect", "()Landroid/graphics/Rect;", "duration", "getDuration", "()J", "setDuration", "(J)V", "frameDrawable", "Lcom/tencent/mm/media/editor/view/ActiveFrameDrawable;", "lyricsList", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "getLyricsList", "needInvalidate", "", "getNeedInvalidate", "()Z", "setNeedInvalidate", "(Z)V", "originMatrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "setPaint", "(Landroid/graphics/Paint;)V", "sourceDataType", "Lcom/tencent/mm/media/editor/item/EditorDataType;", "getSourceDataType", "()Lcom/tencent/mm/media/editor/item/EditorDataType;", "setSourceDataType", "(Lcom/tencent/mm/media/editor/item/EditorDataType;)V", "startTime", "getStartTime", "setStartTime", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "text", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textSize", "getTextSize", "()F", "setTextSize", "(F)V", "touchArray", "", "touchDownX", "getTouchDownX", "setTouchDownX", "touchDownY", "getTouchDownY", "setTouchDownY", "touchMoved", "getTouchMoved", "setTouchMoved", "touchSlop", "getTouchSlop", "touchTracker", "Lcom/tencent/mm/media/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/media/editor/touch/TouchTracker;", "validRect", "getValidRect", "setValidRect", "(Landroid/graphics/Rect;)V", "value", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "waveAlpha", "wavePaint", "getWavePaint", "setWavePaint", "waveRects", "", "Landroid/graphics/RectF;", "[Landroid/graphics/RectF;", "waveTargetHeight", "waveTime", "getWaveTime", "setWaveTime", "createEditorData", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "matrix", "createLyricsBitmap", "", "drawWave", "canvas", "Landroid/graphics/Canvas;", "fillAlpha", "fillWaveAlpha", "appearTime", "getContentBoundary", "getSafeArea", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditItemType;", "nextIndex", "onDraw", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "renderLyrics", "lyricsInfo", "", "reshowLyrics", "resume", "setDefaultLocation", "heightPercent", "setSafeArea", "safeRect", "damp", "setStateResolve", "setValidArea", "updateLyricsList", "plugin-recordvideo_release"})
public final class e
  extends View
  implements h, d
{
  private final int MARGIN;
  private final String TAG;
  private int alpha;
  private long duration;
  private boolean fPg;
  private float fPj;
  private float fPk;
  private int goS;
  private long goT;
  private int goU;
  private final long goW;
  private final long goX;
  private final long goY;
  private final int goZ;
  private final int gpa;
  private final float gpb;
  private final float gpc;
  private final int gpd;
  private final float gpe;
  private final float gpf;
  private final float gpg;
  private final int gph;
  private final RectF[] gpi;
  private final float[] gpj;
  private Paint gpk;
  private final com.tencent.mm.media.editor.c.c oMw;
  private Paint paint;
  private final int pd;
  private long startTime;
  private CharSequence text;
  private float textSize;
  private final ArrayList<bmx> viA;
  private final com.tencent.mm.media.editor.view.a vsA;
  private EditorItemContainer.b vsB;
  private Rect vsD;
  private final Rect vsE;
  private com.tencent.mm.media.editor.a.e vsH;
  private Matrix vsI;
  private final float[] vts;
  private final Matrix vtt;
  private ArrayList<Bitmap> vtu;
  public boolean vtv;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76159);
    this.viA = new ArrayList();
    this.TAG = "MicroMsg.LyricsItemView";
    this.goW = 50L;
    this.goX = 200L;
    this.goY = 3000L;
    this.goZ = 11;
    this.gpa = ao.fromDPToPix(paramContext, 1);
    this.gpb = (this.gpa * 1.5F);
    this.gpc = (this.gpa * 9.0F);
    this.gpd = this.gpa;
    this.gpe = (this.gpa * 1.5F);
    this.gpf = (this.gpa * 12.0F);
    this.gpg = (this.gpa * 2.0F);
    this.gph = this.gpa;
    this.MARGIN = ao.fromDPToPix(paramContext, 32);
    int j = this.goZ;
    Object localObject = new RectF[j];
    int i = 0;
    while (i < j)
    {
      localObject[i] = new RectF();
      i += 1;
    }
    this.gpi = ((RectF[])localObject);
    this.gpj = new float[this.goZ];
    this.vts = new float[9];
    this.vtt = new Matrix();
    this.oMw = new com.tencent.mm.media.editor.c.c();
    this.textSize = getResources().getDimension(2131166195);
    this.vsH = com.tencent.mm.media.editor.a.e.goK;
    this.vtu = new ArrayList();
    this.paint = new Paint();
    this.gpk = new Paint();
    this.vsD = new Rect(0, 0, ap.cf(aj.getContext()).x, ap.cf(aj.getContext()).y);
    this.vsE = new Rect(0, 0, ap.cf(aj.getContext()).x, ap.cf(aj.getContext()).y);
    this.vtv = true;
    this.oMw.aMv = 0.5F;
    this.oMw.aMu = 3.0F;
    this.gpk.setColor(Color.parseColor("#CCFFFFFF"));
    localObject = getResources();
    d.g.b.k.g(localObject, "resources");
    this.vsA = new com.tencent.mm.media.editor.view.a((Resources)localObject);
    paramContext = ViewConfiguration.get(paramContext);
    d.g.b.k.g(paramContext, "ViewConfiguration.get(context)");
    this.pd = paramContext.getScaledTouchSlop();
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(76159);
  }
  
  private final void diZ()
  {
    AppMethodBeat.i(76150);
    Iterator localIterator = ((Iterable)this.viA).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (bmx)localIterator.next();
      if (!bt.isNullOrNil(((bmx)localObject1).lyrics))
      {
        Object localObject2 = new LinearLayout(getContext());
        localObject2 = LayoutInflater.from(getContext()).inflate(2131495685, (ViewGroup)localObject2, false);
        TextView localTextView = (TextView)((View)localObject2).findViewById(2131305457);
        d.g.b.k.g(localTextView, "lyricsText");
        com.tencent.mm.ad.c.e(localTextView);
        localTextView.setText((CharSequence)((bmx)localObject1).lyrics);
        f localf = f.vdH;
        localTextView.setMaxHeight(f.dgJ().height());
        int i = this.MARGIN;
        localf = f.vdH;
        if (i >= f.dgJ().left)
        {
          localf = f.vdH;
          i = f.dgJ().width();
          j = this.MARGIN;
          localf = f.vdH;
          i -= (j - f.dgJ().left) * 2;
          label194:
          localTextView.setMaxWidth(i);
          ((View)localObject2).measure(0, 0);
          d.g.b.k.g(localObject2, "parent");
          ((View)localObject2).layout(0, 0, ((View)localObject2).getMeasuredWidth(), ((View)localObject2).getMeasuredHeight());
          if (((View)localObject2).getMeasuredWidth() > 0)
          {
            i = ((View)localObject2).getMeasuredWidth();
            localf = f.vdH;
            if (i <= f.dgJ().width()) {
              break label457;
            }
          }
          localf = f.vdH;
          i = f.dgJ().width();
          label273:
          if (((View)localObject2).getMeasuredHeight() > 0)
          {
            j = ((View)localObject2).getMeasuredHeight();
            localf = f.vdH;
            if (j <= f.dgJ().height()) {
              break label466;
            }
          }
          localf = f.vdH;
        }
        label457:
        label466:
        for (int j = f.dgJ().height();; j = ((View)localObject2).getMeasuredHeight())
        {
          ad.i(this.TAG, "it.lyrics=" + ((bmx)localObject1).lyrics + " lyricsText.maxWidth=" + localTextView.getMaxWidth() + " lyricsText.maxHeight=" + localTextView.getMaxHeight() + " parent.measuredWidth=" + ((View)localObject2).getMeasuredWidth() + " parent.measuredHeight=" + ((View)localObject2).getMeasuredHeight());
          localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          ((View)localObject2).draw(new Canvas((Bitmap)localObject1));
          this.vsH = com.tencent.mm.media.editor.a.e.goK;
          this.vtu.add(localObject1);
          break;
          localf = f.vdH;
          i = f.dgJ().width();
          break label194;
          i = ((View)localObject2).getMeasuredWidth();
          break label273;
        }
      }
    }
    AppMethodBeat.o(76150);
  }
  
  private final void eR(List<? extends bmx> paramList)
  {
    AppMethodBeat.i(76149);
    this.viA.clear();
    ArrayList localArrayList = this.viA;
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label98:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (!bt.isNullOrNil(((bmx)localObject2).lyrics)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label98;
        }
        paramList.add(localObject2);
        break;
      }
    }
    localArrayList.addAll((Collection)paramList);
    AppMethodBeat.o(76149);
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(76145);
    d.g.b.k.h(paramRect, "displayRect");
    this.vsE.set(paramRect);
    AppMethodBeat.o(76145);
  }
  
  public final com.tencent.mm.media.editor.a.a ajz()
  {
    AppMethodBeat.i(76154);
    if (this.vtu.isEmpty())
    {
      AppMethodBeat.o(76154);
      return null;
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).postConcat(this.oMw.dY);
    ((Matrix)localObject).postTranslate(-(this.vsE.width() - this.vsD.width()) / 2.0F, -(this.vsE.height() - this.vsD.height()) / 2.0F);
    localObject = (com.tencent.mm.media.editor.a.a)new com.tencent.mm.media.editor.a.l((List)this.viA, (Matrix)localObject);
    AppMethodBeat.o(76154);
    return localObject;
  }
  
  public final com.tencent.mm.media.editor.a.b c(Matrix paramMatrix)
  {
    AppMethodBeat.i(163471);
    if (this.vtu.isEmpty())
    {
      AppMethodBeat.o(163471);
      return null;
    }
    paramMatrix = new ArrayList();
    Object localObject1 = (Iterable)this.viA;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        d.a.j.fvx();
      }
      localObject2 = (bmx)localObject2;
      if (i < this.vtu.size())
      {
        Object localObject3 = this.vtu.get(i);
        d.g.b.k.g(localObject3, "bitmapList[index]");
        paramMatrix.add(new com.tencent.mm.media.editor.a.j((bmx)localObject2, (Bitmap)localObject3));
      }
      i += 1;
    }
    localObject1 = new Matrix();
    ((Matrix)localObject1).postConcat(this.oMw.dY);
    ((Matrix)localObject1).postTranslate(-(this.vsE.width() - this.vsD.width()) / 2.0F, -(this.vsE.height() - this.vsD.height()) / 2.0F);
    paramMatrix = (com.tencent.mm.media.editor.a.b)new com.tencent.mm.media.editor.a.k((List)paramMatrix, (Matrix)localObject1);
    AppMethodBeat.o(163471);
    return paramMatrix;
  }
  
  public final void eP(List<? extends bmx> paramList)
  {
    AppMethodBeat.i(76146);
    d.g.b.k.h(paramList, "lyricsInfo");
    eR(paramList);
    diZ();
    paramList = ((Iterable)this.vtu).iterator();
    int i = 0;
    int k = 0;
    int j;
    if (paramList.hasNext())
    {
      Bitmap localBitmap = (Bitmap)paramList.next();
      j = k;
      if (localBitmap.getWidth() > k) {
        j = localBitmap.getWidth();
      }
      if (localBitmap.getHeight() <= i) {
        break label284;
      }
      i = localBitmap.getHeight();
    }
    label269:
    label284:
    for (;;)
    {
      k = j;
      break;
      float f2;
      if ((k != 0) && (i != 0))
      {
        this.oMw.width = k;
        this.oMw.height = i;
        this.vsA.setBounds(0, 0, k, i);
        this.oMw.l(new float[] { 0.0F, 0.0F, k, 0.0F, 0.0F, i, k, i });
        f2 = this.vsE.height() - ao.fromDPToPix(getContext(), 360) - i;
        i = this.MARGIN;
        paramList = f.vdH;
        if (i < f.dgJ().left) {
          break label269;
        }
      }
      for (float f1 = this.MARGIN;; f1 = f.dgJ().left)
      {
        this.oMw.dY.setTranslate(f1, f2);
        AppMethodBeat.o(76146);
        return;
        paramList = f.vdH;
      }
    }
  }
  
  public final void eQ(List<? extends bmx> paramList)
  {
    AppMethodBeat.i(76148);
    d.g.b.k.h(paramList, "lyricsInfo");
    eR(paramList);
    diZ();
    this.vsH = com.tencent.mm.media.editor.a.e.goK;
    AppMethodBeat.o(76148);
  }
  
  public final ArrayList<Bitmap> getBitmapList()
  {
    return this.vtu;
  }
  
  public final float[] getContentBoundary()
  {
    AppMethodBeat.i(76157);
    float[] arrayOfFloat = (float[])this.oMw.gpM.clone();
    AppMethodBeat.o(76157);
    return arrayOfFloat;
  }
  
  public final int getCurIndex()
  {
    return this.goS;
  }
  
  public final Rect getDisplayRect()
  {
    return this.vsE;
  }
  
  public final long getDuration()
  {
    return this.duration;
  }
  
  public final ArrayList<bmx> getLyricsList()
  {
    return this.viA;
  }
  
  public final boolean getNeedInvalidate()
  {
    return this.vtv;
  }
  
  public final Paint getPaint()
  {
    return this.paint;
  }
  
  public final Rect getSafeArea()
  {
    AppMethodBeat.i(76156);
    Rect localRect = this.oMw.gpG;
    Object localObject = localRect;
    if (localRect == null)
    {
      localObject = getResources();
      d.g.b.k.g(localObject, "resources");
      int i = ((Resources)localObject).getDisplayMetrics().widthPixels;
      localObject = getResources();
      d.g.b.k.g(localObject, "resources");
      localObject = new Rect(0, 0, i, ((Resources)localObject).getDisplayMetrics().heightPixels);
    }
    AppMethodBeat.o(76156);
    return localObject;
  }
  
  public final com.tencent.mm.media.editor.a.e getSourceDataType()
  {
    return this.vsH;
  }
  
  public final long getStartTime()
  {
    return this.startTime;
  }
  
  public final CharSequence getText()
  {
    return this.text;
  }
  
  public final float getTextSize()
  {
    return this.textSize;
  }
  
  public final float getTouchDownX()
  {
    return this.fPj;
  }
  
  public final float getTouchDownY()
  {
    return this.fPk;
  }
  
  public final boolean getTouchMoved()
  {
    return this.fPg;
  }
  
  public final int getTouchSlop()
  {
    return this.pd;
  }
  
  protected final com.tencent.mm.media.editor.c.c getTouchTracker()
  {
    return this.oMw;
  }
  
  public final b getType()
  {
    return b.vsN;
  }
  
  public final Rect getValidRect()
  {
    return this.vsD;
  }
  
  public final Matrix getViewMatrix()
  {
    return this.vsI;
  }
  
  public final Paint getWavePaint()
  {
    return this.gpk;
  }
  
  public final long getWaveTime()
  {
    return this.goT;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(76152);
    d.g.b.k.h(paramCanvas, "canvas");
    paramCanvas.save();
    float f1;
    Object localObject1;
    int i;
    int j;
    label108:
    Object localObject2;
    if (this.vsI != null)
    {
      paramCanvas.setMatrix(this.vsI);
      if (isActivated()) {
        this.vsA.draw(paramCanvas);
      }
      if (this.viA.isEmpty()) {
        break label486;
      }
      if ((this.goT != 0L) && (bt.vM(this.goT) <= this.goW)) {
        break label328;
      }
      this.goT = System.currentTimeMillis();
      f1 = 0.0F;
      localObject1 = this.gpi;
      i = 0;
      int k = localObject1.length;
      j = 0;
      if (j >= k) {
        break label328;
      }
      localObject2 = localObject1[j];
      f2 = localObject2.height();
      if (f2 > this.gpd) {
        break label282;
      }
      this.gpj[i] = ((float)(this.gpc * Math.random()));
      label155:
      if (f2 > this.gpj[i]) {
        break label309;
      }
    }
    label282:
    label309:
    for (float f2 = Math.min(this.gpg + f2, this.gpc);; f2 = Math.max(f2 - this.gph, this.gpd))
    {
      float f3 = this.gpe;
      float f4 = this.gpc / 2.0F;
      float f5 = f2 / 2.0F;
      float f6 = this.gpe;
      float f7 = this.gpb;
      float f8 = this.gpc / 2.0F;
      localObject2.set(f3 + f1, f4 - f5, f1 + f6 + f7, f2 / 2.0F + f8);
      f1 = localObject2.right;
      j += 1;
      i += 1;
      break label108;
      paramCanvas.setMatrix(this.oMw.dY);
      break;
      if (f2 < this.gpj[i]) {
        break label155;
      }
      this.gpj[i] = this.gpd;
      break label155;
    }
    label328:
    long l1 = ((bmx)this.viA.get(0)).startTime;
    long l2;
    long l3;
    if (this.goU < 255)
    {
      l2 = this.goX;
      l3 = this.duration - l1;
      if (0L <= l3) {
        break label452;
      }
      if (this.duration - l1 <= this.goX) {}
    }
    for (this.goU = 255;; this.goU = ((int)((float)(this.duration - l1) * 255.0F / (float)this.goX)))
    {
      this.gpk.setAlpha(this.goU);
      localObject1 = this.gpi;
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        paramCanvas.drawRect(localObject1[i], this.gpk);
        i += 1;
      }
      label452:
      if (l2 < l3) {
        break;
      }
    }
    label486:
    if (!this.viA.isEmpty())
    {
      this.duration = (System.currentTimeMillis() - this.startTime);
      localObject1 = (bmx)d.a.j.C((List)this.viA, this.goS + 1);
      if (localObject1 == null) {
        break label836;
      }
      l1 = ((bmx)localObject1).startTime;
      if (this.duration >= l1)
      {
        this.goS += 1;
        if (this.goS >= this.viA.size())
        {
          this.goS = 0;
          this.startTime = System.currentTimeMillis();
          this.duration = 0L;
        }
      }
    }
    label610:
    long l4;
    if (!((Collection)this.vtu).isEmpty())
    {
      i = 1;
      if ((i != 0) && (this.goS < this.vtu.size())) {
        if (this.goS < this.viA.size())
        {
          l2 = ((bmx)this.viA.get(this.goS)).startTime;
          localObject1 = (bmx)d.a.j.C((List)this.viA, this.goS + 1);
          if (localObject1 == null) {
            break label869;
          }
          l1 = ((bmx)localObject1).startTime;
          label695:
          l3 = this.goX;
          l4 = this.duration - l2;
          if (0L <= l4) {
            break label896;
          }
          label717:
          l3 = this.goX;
          l4 = l1 - this.duration;
          if (0L <= l4) {
            break label930;
          }
          label739:
          if ((this.duration - l2 > this.goX) && (l1 - this.duration > this.goX)) {
            this.alpha = 255;
          }
        }
      }
    }
    for (;;)
    {
      this.paint.setAlpha(this.alpha);
      paramCanvas.drawBitmap((Bitmap)this.vtu.get(this.goS), 0.0F, this.gpf, this.paint);
      paramCanvas.restore();
      if (this.vtv) {
        invalidate();
      }
      AppMethodBeat.o(76152);
      return;
      label836:
      l1 = ((bmx)this.viA.get(this.goS)).startTime + this.goY;
      break;
      i = 0;
      break label610;
      label869:
      l1 = ((bmx)this.viA.get(this.goS)).startTime + this.goY;
      break label695;
      label896:
      if (l3 < l4) {
        break label717;
      }
      this.alpha = ((int)(255.0F * (float)(this.duration - l2) / (float)this.goX));
      continue;
      label930:
      if (l3 < l4) {
        break label739;
      }
      this.alpha = ((int)((float)(l1 - this.duration) / (float)this.goX * 255.0F));
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76151);
    d.g.b.k.h(paramMotionEvent, "event");
    this.vtt.set(this.oMw.dY);
    this.vtt.getValues(this.vts);
    float f1 = this.vts[2];
    boolean bool2 = this.oMw.v(paramMotionEvent);
    this.oMw.dY.getValues(this.vts);
    float f2 = this.vts[5];
    this.oMw.dY.set(this.vtt);
    this.oMw.dY.setTranslate(f1, f2);
    Object localObject;
    if (bool2)
    {
      localObject = this.vsB;
      if (localObject != null) {
        ((EditorItemContainer.b)localObject).c((View)this, paramMotionEvent);
      }
      bringToFront();
      postInvalidate();
    }
    if (bool2) {
      switch (paramMotionEvent.getActionMasked())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(76151);
      return bool2;
      this.fPj = paramMotionEvent.getX();
      this.fPk = paramMotionEvent.getY();
      this.fPg = false;
      continue;
      f1 = Math.max(Math.abs(paramMotionEvent.getX() - this.fPj), Math.abs(paramMotionEvent.getY() - this.fPk));
      if (!this.fPg)
      {
        if (f1 > this.pd) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          this.fPg = bool1;
          break;
        }
        if (!this.fPg) {
          performClick();
        }
        paramMotionEvent = new com.tencent.mm.media.editor.c.a();
        localObject = this.vsD;
        paramMotionEvent.aMv = this.oMw.aMv;
        paramMotionEvent.aMu = this.oMw.aMu;
        paramMotionEvent.k(new float[] { this.oMw.width / 2.0F, this.oMw.height / 2.0F });
        paramMotionEvent.e(new RectF(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom));
        paramMotionEvent.a(this.oMw.dY, (d.g.a.b)new a(this));
      }
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(76158);
    this.vtv = true;
    invalidate();
    AppMethodBeat.o(76158);
  }
  
  public final void setBitmapList(ArrayList<Bitmap> paramArrayList)
  {
    AppMethodBeat.i(76139);
    d.g.b.k.h(paramArrayList, "<set-?>");
    this.vtu = paramArrayList;
    AppMethodBeat.o(76139);
  }
  
  public final void setCurIndex(int paramInt)
  {
    this.goS = paramInt;
  }
  
  public final void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public final void setNeedInvalidate(boolean paramBoolean)
  {
    this.vtv = paramBoolean;
  }
  
  public final void setPaint(Paint paramPaint)
  {
    AppMethodBeat.i(76140);
    d.g.b.k.h(paramPaint, "<set-?>");
    this.paint = paramPaint;
    AppMethodBeat.o(76140);
  }
  
  public final void setSafeArea$27eda001(Rect paramRect)
  {
    AppMethodBeat.i(76155);
    d.g.b.k.h(paramRect, "safeRect");
    this.oMw.gpG = paramRect;
    this.oMw.gpH = com.tencent.mm.cd.a.fromDPToPix(getContext(), 54);
    AppMethodBeat.o(76155);
  }
  
  public final void setSourceDataType(com.tencent.mm.media.editor.a.e parame)
  {
    AppMethodBeat.i(76138);
    d.g.b.k.h(parame, "<set-?>");
    this.vsH = parame;
    AppMethodBeat.o(76138);
  }
  
  public final void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(76147);
    d.g.b.k.h(paramb, "stateResolve");
    this.vsB = paramb;
    AppMethodBeat.o(76147);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    this.text = paramCharSequence;
  }
  
  public final void setTextSize(float paramFloat)
  {
    this.textSize = paramFloat;
  }
  
  public final void setTouchDownX(float paramFloat)
  {
    this.fPj = paramFloat;
  }
  
  public final void setTouchDownY(float paramFloat)
  {
    this.fPk = paramFloat;
  }
  
  public final void setTouchMoved(boolean paramBoolean)
  {
    this.fPg = paramBoolean;
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(76144);
    d.g.b.k.h(paramRect, "validRect");
    this.vsD.set(paramRect);
    AppMethodBeat.o(76144);
  }
  
  public final void setValidRect(Rect paramRect)
  {
    AppMethodBeat.i(76142);
    d.g.b.k.h(paramRect, "<set-?>");
    this.vsD = paramRect;
    AppMethodBeat.o(76142);
  }
  
  public final void setViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(76143);
    this.vsI = paramMatrix;
    if (paramMatrix != null)
    {
      this.oMw.setMatrix(paramMatrix);
      Canvas localCanvas = new Canvas();
      localCanvas.save();
      if (this.vsI != null) {
        localCanvas.setMatrix(paramMatrix);
      }
      if (isActivated()) {
        this.vsA.draw(localCanvas);
      }
    }
    AppMethodBeat.o(76143);
  }
  
  public final void setWavePaint(Paint paramPaint)
  {
    AppMethodBeat.i(76141);
    d.g.b.k.h(paramPaint, "<set-?>");
    this.gpk = paramPaint;
    AppMethodBeat.o(76141);
  }
  
  public final void setWaveTime(long paramLong)
  {
    this.goT = paramLong;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<Matrix, y>
  {
    a(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.e
 * JD-Core Version:    0.7.0.1
 */
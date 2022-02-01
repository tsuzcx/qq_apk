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
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a.f;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.c.a;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DP_1", "", "LAST_INTERVAL", "", "LYRICS_VERTICAL_OFFSET", "", "MARGIN", "TAG", "", "TRANS_TIME", "WAVE_DECREMENT", "WAVE_INCREMENT", "WAVE_INVALIDAT_INTERVAL", "WAVE_RECT_COUNT", "WAVE_RECT_HEIGHT", "WAVE_RECT_MIN_HEIGHT", "WAVE_RECT_OFFSET", "WAVE_RECT_WIDTH", "alpha", "bitmapList", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "getBitmapList", "()Ljava/util/ArrayList;", "setBitmapList", "(Ljava/util/ArrayList;)V", "curIndex", "getCurIndex", "()I", "setCurIndex", "(I)V", "displayRect", "Landroid/graphics/Rect;", "getDisplayRect", "()Landroid/graphics/Rect;", "duration", "getDuration", "()J", "setDuration", "(J)V", "frameDrawable", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "lyricsItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem;", "lyricsList", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "getLyricsList", "needInvalidate", "", "getNeedInvalidate", "()Z", "setNeedInvalidate", "(Z)V", "originMatrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "setPaint", "(Landroid/graphics/Paint;)V", "sourceDataType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "getSourceDataType", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "setSourceDataType", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;)V", "startTime", "getStartTime", "setStartTime", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "text", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textSize", "getTextSize", "()F", "setTextSize", "(F)V", "touchArray", "", "touchDownX", "getTouchDownX", "setTouchDownX", "touchDownY", "getTouchDownY", "setTouchDownY", "touchMoved", "getTouchMoved", "setTouchMoved", "touchSlop", "getTouchSlop", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validRect", "getValidRect", "setValidRect", "(Landroid/graphics/Rect;)V", "value", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "waveAlpha", "wavePaint", "getWavePaint", "setWavePaint", "waveRects", "", "Landroid/graphics/RectF;", "[Landroid/graphics/RectF;", "waveTargetHeight", "waveTime", "getWaveTime", "setWaveTime", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "createLyricsBitmap", "", "drawWave", "canvas", "Landroid/graphics/Canvas;", "fillAlpha", "fillWaveAlpha", "appearTime", "getContentBoundary", "getDrawRect", "getEditorData", "getLyricsEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorItem;", "item", "getSafeArea", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "nextIndex", "onDraw", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "renderLyrics", "lyricsInfo", "", "reshowLyrics", "resume", "setDefaultLocation", "heightPercent", "setSafeArea", "safeRect", "damp", "setStateResolve", "setValidArea", "updateLyricsList", "plugin-recordvideo_release"})
public final class m
  extends View
  implements g, com.tencent.mm.plugin.recordvideo.ui.editor.view.c
{
  private final String TAG;
  private int alpha;
  private final int api;
  private long duration;
  private boolean gmF;
  private float gmI;
  private float gmJ;
  private final int oKW;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c pTr;
  private Paint paint;
  private final int rW;
  private int rko;
  private long startTime;
  private CharSequence text;
  private float textSize;
  private Rect xJu;
  private final Rect xJv;
  private EditorItemContainer.b xJw;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.view.a xND;
  private d xNI;
  private Matrix xNJ;
  private long xOH;
  private int xOI;
  private final long xOJ;
  private final long xOK;
  private final long xOL;
  private final int xOM;
  private final float xON;
  private final float xOO;
  private final int xOP;
  private final float xOQ;
  private final float xOR;
  private final float xOS;
  private final int xOT;
  private final RectF[] xOU;
  private final float[] xOV;
  private final float[] xOW;
  private final Matrix xOX;
  private ArrayList<Bitmap> xOY;
  private Paint xOZ;
  public boolean xPa;
  private l xPb;
  private final ArrayList<bwa> xza;
  
  public m(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76159);
    this.xza = new ArrayList();
    this.TAG = "MicroMsg.LyricsItemView";
    this.xOJ = 50L;
    this.xOK = 200L;
    this.xOL = 3000L;
    this.xOM = 11;
    this.oKW = aq.fromDPToPix(paramContext, 1);
    this.xON = (this.oKW * 1.5F);
    this.xOO = (this.oKW * 9.0F);
    this.xOP = this.oKW;
    this.xOQ = (this.oKW * 1.5F);
    this.xOR = (this.oKW * 12.0F);
    this.xOS = (this.oKW * 2.0F);
    this.xOT = this.oKW;
    this.api = aq.fromDPToPix(paramContext, 32);
    int j = this.xOM;
    Object localObject = new RectF[j];
    int i = 0;
    while (i < j)
    {
      localObject[i] = new RectF();
      i += 1;
    }
    this.xOU = ((RectF[])localObject);
    this.xOV = new float[this.xOM];
    this.xOW = new float[9];
    this.xOX = new Matrix();
    this.pTr = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    this.textSize = getResources().getDimension(2131166195);
    this.xNI = d.xNT;
    this.xOY = new ArrayList();
    this.paint = new Paint();
    this.xOZ = new Paint();
    this.xJu = new Rect(0, 0, ar.ci(aj.getContext()).x, ar.ci(aj.getContext()).y);
    this.xJv = new Rect(0, 0, ar.ci(aj.getContext()).x, ar.ci(aj.getContext()).y);
    this.xPa = true;
    this.pTr.aXF = 0.5F;
    this.pTr.aXE = 3.0F;
    this.xOZ.setColor(Color.parseColor("#CCFFFFFF"));
    localObject = getResources();
    p.g(localObject, "resources");
    this.xND = new com.tencent.mm.plugin.recordvideo.ui.editor.view.a((Resources)localObject);
    paramContext = ViewConfiguration.get(paramContext);
    p.g(paramContext, "ViewConfiguration.get(context)");
    this.rW = paramContext.getScaledTouchSlop();
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(76159);
  }
  
  private final void dIc()
  {
    AppMethodBeat.i(76150);
    Iterator localIterator = ((Iterable)this.xza).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (bwa)localIterator.next();
      if (!bt.isNullOrNil(((bwa)localObject1).lyrics))
      {
        Object localObject2 = new LinearLayout(getContext());
        localObject2 = LayoutInflater.from(getContext()).inflate(2131495685, (ViewGroup)localObject2, false);
        TextView localTextView = (TextView)((View)localObject2).findViewById(2131305457);
        p.g(localTextView, "lyricsText");
        com.tencent.mm.ad.c.e(localTextView);
        localTextView.setText((CharSequence)((bwa)localObject1).lyrics);
        e locale = e.xuo;
        localTextView.setMaxHeight(e.dEN().height());
        int i = this.api;
        locale = e.xuo;
        if (i >= e.dEN().left)
        {
          locale = e.xuo;
          i = e.dEN().width();
          j = this.api;
          locale = e.xuo;
          i -= (j - e.dEN().left) * 2;
          label194:
          localTextView.setMaxWidth(i);
          ((View)localObject2).measure(0, 0);
          p.g(localObject2, "parent");
          ((View)localObject2).layout(0, 0, ((View)localObject2).getMeasuredWidth(), ((View)localObject2).getMeasuredHeight());
          if (((View)localObject2).getMeasuredWidth() > 0)
          {
            i = ((View)localObject2).getMeasuredWidth();
            locale = e.xuo;
            if (i <= e.dEN().width()) {
              break label457;
            }
          }
          locale = e.xuo;
          i = e.dEN().width();
          label273:
          if (((View)localObject2).getMeasuredHeight() > 0)
          {
            j = ((View)localObject2).getMeasuredHeight();
            locale = e.xuo;
            if (j <= e.dEN().height()) {
              break label466;
            }
          }
          locale = e.xuo;
        }
        label457:
        label466:
        for (int j = e.dEN().height();; j = ((View)localObject2).getMeasuredHeight())
        {
          ad.i(this.TAG, "it.lyrics=" + ((bwa)localObject1).lyrics + " lyricsText.maxWidth=" + localTextView.getMaxWidth() + " lyricsText.maxHeight=" + localTextView.getMaxHeight() + " parent.measuredWidth=" + ((View)localObject2).getMeasuredWidth() + " parent.measuredHeight=" + ((View)localObject2).getMeasuredHeight());
          localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          ((View)localObject2).draw(new Canvas((Bitmap)localObject1));
          this.xNI = d.xNT;
          this.xOY.add(localObject1);
          break;
          locale = e.xuo;
          i = e.dEN().width();
          break label194;
          i = ((View)localObject2).getMeasuredWidth();
          break label273;
        }
      }
    }
    AppMethodBeat.o(76150);
  }
  
  private final void fk(List<? extends bwa> paramList)
  {
    AppMethodBeat.i(76149);
    this.xza.clear();
    ArrayList localArrayList = this.xza;
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label98:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (!bt.isNullOrNil(((bwa)localObject2).lyrics)) {}
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
    p.h(paramRect, "displayRect");
    this.xJv.set(paramRect);
    AppMethodBeat.o(76145);
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(200693);
    p.h(paraml, "item");
    this.xPb = paraml;
    setViewMatrix(paraml.gR);
    fk((List)paraml.xOF);
    dIc();
    this.xNI = d.xNT;
    AppMethodBeat.o(200693);
  }
  
  public final boolean avO(String paramString)
  {
    AppMethodBeat.i(200700);
    p.h(paramString, "objID");
    boolean bool = c.a.a(this, paramString);
    AppMethodBeat.o(200700);
    return bool;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.g b(l paraml)
  {
    AppMethodBeat.i(200696);
    p.h(paraml, "item");
    fj((List)paraml.xOF);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (Iterable)this.xza;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.gfB();
      }
      localObject2 = (bwa)localObject2;
      Object localObject3 = this.xOY.get(i);
      p.g(localObject3, "bitmapList[index]");
      localArrayList.add(new f((bwa)localObject2, (Bitmap)localObject3));
      i += 1;
    }
    paraml = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.g((List)localArrayList, paraml.gR);
    AppMethodBeat.o(200696);
    return paraml;
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(200697);
    p.h(paramRect, "safeRect");
    this.pTr.xul = paramRect;
    this.pTr.xQl = com.tencent.mm.cc.a.fromDPToPix(getContext(), 54);
    AppMethodBeat.o(200697);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    AppMethodBeat.i(200694);
    if (this.xOY.isEmpty())
    {
      AppMethodBeat.o(200694);
      return null;
    }
    paramMatrix = new ArrayList();
    Object localObject1 = (Iterable)this.xza;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.gfB();
      }
      localObject2 = (bwa)localObject2;
      if (i < this.xOY.size())
      {
        Object localObject3 = this.xOY.get(i);
        p.g(localObject3, "bitmapList[index]");
        paramMatrix.add(new f((bwa)localObject2, (Bitmap)localObject3));
      }
      i += 1;
    }
    localObject1 = new Matrix();
    ((Matrix)localObject1).postConcat(this.pTr.gR);
    ((Matrix)localObject1).postTranslate(-(this.xJv.width() - this.xJu.width()) / 2.0F, -(this.xJv.height() - this.xJu.height()) / 2.0F);
    paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.g((List)paramMatrix, (Matrix)localObject1);
    AppMethodBeat.o(200694);
    return paramMatrix;
  }
  
  public final a ckw()
  {
    AppMethodBeat.i(200695);
    if (this.xOY.isEmpty())
    {
      AppMethodBeat.o(200695);
      return null;
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).postConcat(this.pTr.gR);
    localObject = (a)new l((List)this.xza, (Matrix)localObject);
    AppMethodBeat.o(200695);
    return localObject;
  }
  
  public final boolean dHt()
  {
    return true;
  }
  
  public final void fj(List<? extends bwa> paramList)
  {
    AppMethodBeat.i(76146);
    p.h(paramList, "lyricsInfo");
    fk(paramList);
    dIc();
    paramList = ((Iterable)this.xOY).iterator();
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
        this.pTr.width = k;
        this.pTr.height = i;
        this.xND.setBounds(0, 0, k, i);
        this.pTr.o(new float[] { 0.0F, 0.0F, k, 0.0F, 0.0F, i, k, i });
        f2 = this.xJv.height() - aq.fromDPToPix(getContext(), 360) - i;
        i = this.api;
        paramList = e.xuo;
        if (i < e.dEN().left) {
          break label269;
        }
      }
      for (float f1 = this.api;; f1 = e.dEN().left)
      {
        this.pTr.gR.setTranslate(f1, f2);
        AppMethodBeat.o(76146);
        return;
        paramList = e.xuo;
      }
    }
  }
  
  public final ArrayList<Bitmap> getBitmapList()
  {
    return this.xOY;
  }
  
  public final float[] getContentBoundary()
  {
    AppMethodBeat.i(76157);
    float[] arrayOfFloat = (float[])this.pTr.xQq.clone();
    AppMethodBeat.o(76157);
    return arrayOfFloat;
  }
  
  public final int getCurIndex()
  {
    return this.rko;
  }
  
  public final Rect getDisplayRect()
  {
    return this.xJv;
  }
  
  public final RectF getDrawRect()
  {
    AppMethodBeat.i(200698);
    RectF localRectF = new RectF(this.pTr.xQq[0], this.pTr.xQq[1], this.pTr.xQq[2], this.pTr.xQq[3]);
    AppMethodBeat.o(200698);
    return localRectF;
  }
  
  public final long getDuration()
  {
    return this.duration;
  }
  
  public final a getEditorData()
  {
    return (a)this.xPb;
  }
  
  public final ArrayList<bwa> getLyricsList()
  {
    return this.xza;
  }
  
  public final boolean getNeedInvalidate()
  {
    return this.xPa;
  }
  
  public final Paint getPaint()
  {
    return this.paint;
  }
  
  public final Rect getSafeArea()
  {
    AppMethodBeat.i(76156);
    Rect localRect = this.pTr.xul;
    Object localObject = localRect;
    if (localRect == null)
    {
      localObject = getResources();
      p.g(localObject, "resources");
      int i = ((Resources)localObject).getDisplayMetrics().widthPixels;
      localObject = getResources();
      p.g(localObject, "resources");
      localObject = new Rect(0, 0, i, ((Resources)localObject).getDisplayMetrics().heightPixels);
    }
    AppMethodBeat.o(76156);
    return localObject;
  }
  
  public final d getSourceDataType()
  {
    return this.xNI;
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
    return this.gmI;
  }
  
  public final float getTouchDownY()
  {
    return this.gmJ;
  }
  
  public final boolean getTouchMoved()
  {
    return this.gmF;
  }
  
  public final int getTouchSlop()
  {
    return this.rW;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker()
  {
    return this.pTr;
  }
  
  public final b getType()
  {
    return b.xQL;
  }
  
  public final Rect getValidRect()
  {
    return this.xJu;
  }
  
  public final Matrix getViewMatrix()
  {
    return this.xNJ;
  }
  
  public final Paint getWavePaint()
  {
    return this.xOZ;
  }
  
  public final long getWaveTime()
  {
    return this.xOH;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(76152);
    p.h(paramCanvas, "canvas");
    paramCanvas.save();
    float f1;
    Object localObject1;
    int i;
    int j;
    label108:
    Object localObject2;
    if (this.xNJ != null)
    {
      paramCanvas.setMatrix(this.xNJ);
      if (isActivated()) {
        this.xND.draw(paramCanvas);
      }
      if (this.xza.isEmpty()) {
        break label486;
      }
      if ((this.xOH != 0L) && (bt.Df(this.xOH) <= this.xOJ)) {
        break label328;
      }
      this.xOH = System.currentTimeMillis();
      f1 = 0.0F;
      localObject1 = this.xOU;
      i = 0;
      int k = localObject1.length;
      j = 0;
      if (j >= k) {
        break label328;
      }
      localObject2 = localObject1[j];
      f2 = localObject2.height();
      if (f2 > this.xOP) {
        break label282;
      }
      this.xOV[i] = ((float)(this.xOO * Math.random()));
      label155:
      if (f2 > this.xOV[i]) {
        break label309;
      }
    }
    label282:
    label309:
    for (float f2 = Math.min(this.xOS + f2, this.xOO);; f2 = Math.max(f2 - this.xOT, this.xOP))
    {
      float f3 = this.xOQ;
      float f4 = this.xOO / 2.0F;
      float f5 = f2 / 2.0F;
      float f6 = this.xOQ;
      float f7 = this.xON;
      float f8 = this.xOO / 2.0F;
      localObject2.set(f3 + f1, f4 - f5, f1 + f6 + f7, f2 / 2.0F + f8);
      f1 = localObject2.right;
      j += 1;
      i += 1;
      break label108;
      paramCanvas.setMatrix(this.pTr.gR);
      break;
      if (f2 < this.xOV[i]) {
        break label155;
      }
      this.xOV[i] = this.xOP;
      break label155;
    }
    label328:
    long l1 = ((bwa)this.xza.get(0)).startTime;
    long l2;
    long l3;
    if (this.xOI < 255)
    {
      l2 = this.xOK;
      l3 = this.duration - l1;
      if (0L <= l3) {
        break label452;
      }
      if (this.duration - l1 <= this.xOK) {}
    }
    for (this.xOI = 255;; this.xOI = ((int)((float)(this.duration - l1) * 255.0F / (float)this.xOK)))
    {
      this.xOZ.setAlpha(this.xOI);
      localObject1 = this.xOU;
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        paramCanvas.drawRect(localObject1[i], this.xOZ);
        i += 1;
      }
      label452:
      if (l2 < l3) {
        break;
      }
    }
    label486:
    if (!this.xza.isEmpty())
    {
      this.duration = (System.currentTimeMillis() - this.startTime);
      localObject1 = (bwa)j.E((List)this.xza, this.rko + 1);
      if (localObject1 == null) {
        break label836;
      }
      l1 = ((bwa)localObject1).startTime;
      if (this.duration >= l1)
      {
        this.rko += 1;
        if (this.rko >= this.xza.size())
        {
          this.rko = 0;
          this.startTime = System.currentTimeMillis();
          this.duration = 0L;
        }
      }
    }
    label610:
    long l4;
    if (!((Collection)this.xOY).isEmpty())
    {
      i = 1;
      if ((i != 0) && (this.rko < this.xOY.size())) {
        if (this.rko < this.xza.size())
        {
          l2 = ((bwa)this.xza.get(this.rko)).startTime;
          localObject1 = (bwa)j.E((List)this.xza, this.rko + 1);
          if (localObject1 == null) {
            break label869;
          }
          l1 = ((bwa)localObject1).startTime;
          label695:
          l3 = this.xOK;
          l4 = this.duration - l2;
          if (0L <= l4) {
            break label896;
          }
          label717:
          l3 = this.xOK;
          l4 = l1 - this.duration;
          if (0L <= l4) {
            break label930;
          }
          label739:
          if ((this.duration - l2 > this.xOK) && (l1 - this.duration > this.xOK)) {
            this.alpha = 255;
          }
        }
      }
    }
    for (;;)
    {
      this.paint.setAlpha(this.alpha);
      paramCanvas.drawBitmap((Bitmap)this.xOY.get(this.rko), 0.0F, this.xOR, this.paint);
      paramCanvas.restore();
      if (this.xPa) {
        invalidate();
      }
      AppMethodBeat.o(76152);
      return;
      label836:
      l1 = ((bwa)this.xza.get(this.rko)).startTime + this.xOL;
      break;
      i = 0;
      break label610;
      label869:
      l1 = ((bwa)this.xza.get(this.rko)).startTime + this.xOL;
      break label695;
      label896:
      if (l3 < l4) {
        break label717;
      }
      this.alpha = ((int)(255.0F * (float)(this.duration - l2) / (float)this.xOK));
      continue;
      label930:
      if (l3 < l4) {
        break label739;
      }
      this.alpha = ((int)((float)(l1 - this.duration) / (float)this.xOK * 255.0F));
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76151);
    p.h(paramMotionEvent, "event");
    this.xOX.set(this.pTr.gR);
    this.xOX.getValues(this.xOW);
    float f1 = this.xOW[2];
    boolean bool2 = this.pTr.W(paramMotionEvent);
    this.pTr.gR.getValues(this.xOW);
    float f2 = this.xOW[5];
    this.pTr.gR.set(this.xOX);
    this.pTr.gR.setTranslate(f1, f2);
    Object localObject;
    if (bool2)
    {
      localObject = this.xJw;
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
      this.gmI = paramMotionEvent.getX();
      this.gmJ = paramMotionEvent.getY();
      this.gmF = false;
      continue;
      f1 = Math.max(Math.abs(paramMotionEvent.getX() - this.gmI), Math.abs(paramMotionEvent.getY() - this.gmJ));
      if (!this.gmF)
      {
        if (f1 > this.rW) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          this.gmF = bool1;
          break;
        }
        if (!this.gmF) {
          performClick();
        }
        paramMotionEvent = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
        localObject = this.xJu;
        paramMotionEvent.aXF = this.pTr.aXF;
        paramMotionEvent.aXE = this.pTr.aXE;
        paramMotionEvent.n(new float[] { this.pTr.width / 2.0F, this.pTr.height / 2.0F });
        paramMotionEvent.f(new RectF(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom));
        paramMotionEvent.a(this.pTr.gR, (d.g.a.m)new a(this));
      }
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(76158);
    this.xPa = true;
    invalidate();
    AppMethodBeat.o(76158);
  }
  
  public final void setBitmapList(ArrayList<Bitmap> paramArrayList)
  {
    AppMethodBeat.i(76139);
    p.h(paramArrayList, "<set-?>");
    this.xOY = paramArrayList;
    AppMethodBeat.o(76139);
  }
  
  public final void setCurIndex(int paramInt)
  {
    this.rko = paramInt;
  }
  
  public final void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public final void setNeedInvalidate(boolean paramBoolean)
  {
    this.xPa = paramBoolean;
  }
  
  public final void setPaint(Paint paramPaint)
  {
    AppMethodBeat.i(76140);
    p.h(paramPaint, "<set-?>");
    this.paint = paramPaint;
    AppMethodBeat.o(76140);
  }
  
  public final void setSourceDataType(d paramd)
  {
    AppMethodBeat.i(200692);
    p.h(paramd, "<set-?>");
    this.xNI = paramd;
    AppMethodBeat.o(200692);
  }
  
  public final void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(76147);
    p.h(paramb, "stateResolve");
    this.xJw = paramb;
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
    this.gmI = paramFloat;
  }
  
  public final void setTouchDownY(float paramFloat)
  {
    this.gmJ = paramFloat;
  }
  
  public final void setTouchMoved(boolean paramBoolean)
  {
    this.gmF = paramBoolean;
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(76144);
    p.h(paramRect, "validRect");
    this.xJu.set(paramRect);
    AppMethodBeat.o(76144);
  }
  
  public final void setValidRect(Rect paramRect)
  {
    AppMethodBeat.i(76142);
    p.h(paramRect, "<set-?>");
    this.xJu = paramRect;
    AppMethodBeat.o(76142);
  }
  
  public final void setViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(76143);
    this.xNJ = paramMatrix;
    if (paramMatrix != null)
    {
      this.pTr.setMatrix(paramMatrix);
      Canvas localCanvas = new Canvas();
      localCanvas.save();
      if (this.xNJ != null) {
        localCanvas.setMatrix(paramMatrix);
      }
      if (isActivated()) {
        this.xND.draw(localCanvas);
      }
    }
    AppMethodBeat.o(76143);
  }
  
  public final void setWavePaint(Paint paramPaint)
  {
    AppMethodBeat.i(76141);
    p.h(paramPaint, "<set-?>");
    this.xOZ = paramPaint;
    AppMethodBeat.o(76141);
  }
  
  public final void setWaveTime(long paramLong)
  {
    this.xOH = paramLong;
  }
  
  public final boolean yJ(long paramLong)
  {
    AppMethodBeat.i(200699);
    boolean bool = c.a.a(this, paramLong);
    AppMethodBeat.o(200699);
    return bool;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "<anonymous parameter 1>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.m<Matrix, Boolean, z>
  {
    a(m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.m
 * JD-Core Version:    0.7.0.1
 */
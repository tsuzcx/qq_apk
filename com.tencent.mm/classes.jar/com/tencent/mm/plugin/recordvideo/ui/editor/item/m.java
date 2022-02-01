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
import com.tencent.mm.protocal.protobuf.bwu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
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

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DP_1", "", "LAST_INTERVAL", "", "LYRICS_VERTICAL_OFFSET", "", "MARGIN", "TAG", "", "TRANS_TIME", "WAVE_DECREMENT", "WAVE_INCREMENT", "WAVE_INVALIDAT_INTERVAL", "WAVE_RECT_COUNT", "WAVE_RECT_HEIGHT", "WAVE_RECT_MIN_HEIGHT", "WAVE_RECT_OFFSET", "WAVE_RECT_WIDTH", "alpha", "bitmapList", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "getBitmapList", "()Ljava/util/ArrayList;", "setBitmapList", "(Ljava/util/ArrayList;)V", "curIndex", "getCurIndex", "()I", "setCurIndex", "(I)V", "displayRect", "Landroid/graphics/Rect;", "getDisplayRect", "()Landroid/graphics/Rect;", "duration", "getDuration", "()J", "setDuration", "(J)V", "frameDrawable", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "lyricsItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem;", "lyricsList", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "getLyricsList", "needInvalidate", "", "getNeedInvalidate", "()Z", "setNeedInvalidate", "(Z)V", "originMatrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "setPaint", "(Landroid/graphics/Paint;)V", "sourceDataType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "getSourceDataType", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "setSourceDataType", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;)V", "startTime", "getStartTime", "setStartTime", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "text", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textSize", "getTextSize", "()F", "setTextSize", "(F)V", "touchArray", "", "touchDownX", "getTouchDownX", "setTouchDownX", "touchDownY", "getTouchDownY", "setTouchDownY", "touchMoved", "getTouchMoved", "setTouchMoved", "touchSlop", "getTouchSlop", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validRect", "getValidRect", "setValidRect", "(Landroid/graphics/Rect;)V", "value", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "waveAlpha", "wavePaint", "getWavePaint", "setWavePaint", "waveRects", "", "Landroid/graphics/RectF;", "[Landroid/graphics/RectF;", "waveTargetHeight", "waveTime", "getWaveTime", "setWaveTime", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "createLyricsBitmap", "", "drawWave", "canvas", "Landroid/graphics/Canvas;", "fillAlpha", "fillWaveAlpha", "appearTime", "getContentBoundary", "getDrawRect", "getEditorData", "getLyricsEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorItem;", "item", "getSafeArea", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "nextIndex", "onDraw", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "renderLyrics", "lyricsInfo", "", "reshowLyrics", "resume", "setDefaultLocation", "heightPercent", "setSafeArea", "safeRect", "damp", "setStateResolve", "setValidArea", "updateLyricsList", "plugin-recordvideo_release"})
public final class m
  extends View
  implements g, com.tencent.mm.plugin.recordvideo.ui.editor.view.c
{
  private final String TAG;
  private int alpha;
  private final int api;
  private long duration;
  private boolean gpb;
  private float gpe;
  private float gpf;
  private final int oRy;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c pZW;
  private Paint paint;
  private final int rW;
  private int rss;
  private long startTime;
  private CharSequence text;
  private float textSize;
  private final ArrayList<bwu> xOW;
  private Rect xZp;
  private final Rect xZq;
  private EditorItemContainer.b xZr;
  private d ydB;
  private Matrix ydC;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.view.a ydw;
  private long yeA;
  private int yeB;
  private final long yeC;
  private final long yeD;
  private final long yeE;
  private final int yeF;
  private final float yeG;
  private final float yeH;
  private final int yeI;
  private final float yeJ;
  private final float yeK;
  private final float yeL;
  private final int yeM;
  private final RectF[] yeN;
  private final float[] yeO;
  private final float[] yeP;
  private final Matrix yeQ;
  private ArrayList<Bitmap> yeR;
  private Paint yeS;
  public boolean yeT;
  private l yeU;
  
  public m(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76159);
    this.xOW = new ArrayList();
    this.TAG = "MicroMsg.LyricsItemView";
    this.yeC = 50L;
    this.yeD = 200L;
    this.yeE = 3000L;
    this.yeF = 11;
    this.oRy = aq.fromDPToPix(paramContext, 1);
    this.yeG = (this.oRy * 1.5F);
    this.yeH = (this.oRy * 9.0F);
    this.yeI = this.oRy;
    this.yeJ = (this.oRy * 1.5F);
    this.yeK = (this.oRy * 12.0F);
    this.yeL = (this.oRy * 2.0F);
    this.yeM = this.oRy;
    this.api = aq.fromDPToPix(paramContext, 32);
    int j = this.yeF;
    Object localObject = new RectF[j];
    int i = 0;
    while (i < j)
    {
      localObject[i] = new RectF();
      i += 1;
    }
    this.yeN = ((RectF[])localObject);
    this.yeO = new float[this.yeF];
    this.yeP = new float[9];
    this.yeQ = new Matrix();
    this.pZW = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    this.textSize = getResources().getDimension(2131166195);
    this.ydB = d.ydM;
    this.yeR = new ArrayList();
    this.paint = new Paint();
    this.yeS = new Paint();
    this.xZp = new Rect(0, 0, ar.ck(ak.getContext()).x, ar.ck(ak.getContext()).y);
    this.xZq = new Rect(0, 0, ar.ck(ak.getContext()).x, ar.ck(ak.getContext()).y);
    this.yeT = true;
    this.pZW.aXF = 0.5F;
    this.pZW.aXE = 3.0F;
    this.yeS.setColor(Color.parseColor("#CCFFFFFF"));
    localObject = getResources();
    p.g(localObject, "resources");
    this.ydw = new com.tencent.mm.plugin.recordvideo.ui.editor.view.a((Resources)localObject);
    paramContext = ViewConfiguration.get(paramContext);
    p.g(paramContext, "ViewConfiguration.get(context)");
    this.rW = paramContext.getScaledTouchSlop();
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(76159);
  }
  
  private final void dLt()
  {
    AppMethodBeat.i(76150);
    Iterator localIterator = ((Iterable)this.xOW).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (bwu)localIterator.next();
      if (!bu.isNullOrNil(((bwu)localObject1).lyrics))
      {
        Object localObject2 = new LinearLayout(getContext());
        localObject2 = LayoutInflater.from(getContext()).inflate(2131495685, (ViewGroup)localObject2, false);
        TextView localTextView = (TextView)((View)localObject2).findViewById(2131305457);
        p.g(localTextView, "lyricsText");
        com.tencent.mm.ac.c.e(localTextView);
        localTextView.setText((CharSequence)((bwu)localObject1).lyrics);
        e locale = e.xKl;
        localTextView.setMaxHeight(e.dIe().height());
        int i = this.api;
        locale = e.xKl;
        if (i >= e.dIe().left)
        {
          locale = e.xKl;
          i = e.dIe().width();
          j = this.api;
          locale = e.xKl;
          i -= (j - e.dIe().left) * 2;
          label194:
          localTextView.setMaxWidth(i);
          ((View)localObject2).measure(0, 0);
          p.g(localObject2, "parent");
          ((View)localObject2).layout(0, 0, ((View)localObject2).getMeasuredWidth(), ((View)localObject2).getMeasuredHeight());
          if (((View)localObject2).getMeasuredWidth() > 0)
          {
            i = ((View)localObject2).getMeasuredWidth();
            locale = e.xKl;
            if (i <= e.dIe().width()) {
              break label457;
            }
          }
          locale = e.xKl;
          i = e.dIe().width();
          label273:
          if (((View)localObject2).getMeasuredHeight() > 0)
          {
            j = ((View)localObject2).getMeasuredHeight();
            locale = e.xKl;
            if (j <= e.dIe().height()) {
              break label466;
            }
          }
          locale = e.xKl;
        }
        label457:
        label466:
        for (int j = e.dIe().height();; j = ((View)localObject2).getMeasuredHeight())
        {
          ae.i(this.TAG, "it.lyrics=" + ((bwu)localObject1).lyrics + " lyricsText.maxWidth=" + localTextView.getMaxWidth() + " lyricsText.maxHeight=" + localTextView.getMaxHeight() + " parent.measuredWidth=" + ((View)localObject2).getMeasuredWidth() + " parent.measuredHeight=" + ((View)localObject2).getMeasuredHeight());
          localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          ((View)localObject2).draw(new Canvas((Bitmap)localObject1));
          this.ydB = d.ydM;
          this.yeR.add(localObject1);
          break;
          locale = e.xKl;
          i = e.dIe().width();
          break label194;
          i = ((View)localObject2).getMeasuredWidth();
          break label273;
        }
      }
    }
    AppMethodBeat.o(76150);
  }
  
  private final void fs(List<? extends bwu> paramList)
  {
    AppMethodBeat.i(76149);
    this.xOW.clear();
    ArrayList localArrayList = this.xOW;
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label98:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (!bu.isNullOrNil(((bwu)localObject2).lyrics)) {}
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
    this.xZq.set(paramRect);
    AppMethodBeat.o(76145);
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(206951);
    p.h(paraml, "item");
    this.yeU = paraml;
    setViewMatrix(paraml.gR);
    fs((List)paraml.yey);
    dLt();
    this.ydB = d.ydM;
    AppMethodBeat.o(206951);
  }
  
  public final boolean axd(String paramString)
  {
    AppMethodBeat.i(206958);
    p.h(paramString, "objID");
    boolean bool = c.a.a(this, paramString);
    AppMethodBeat.o(206958);
    return bool;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.g b(l paraml)
  {
    AppMethodBeat.i(206954);
    p.h(paraml, "item");
    fr((List)paraml.yey);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (Iterable)this.xOW;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.gkd();
      }
      localObject2 = (bwu)localObject2;
      Object localObject3 = this.yeR.get(i);
      p.g(localObject3, "bitmapList[index]");
      localArrayList.add(new f((bwu)localObject2, (Bitmap)localObject3));
      i += 1;
    }
    paraml = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.g((List)localArrayList, paraml.gR);
    AppMethodBeat.o(206954);
    return paraml;
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(206955);
    p.h(paramRect, "safeRect");
    this.pZW.xKi = paramRect;
    this.pZW.yge = com.tencent.mm.cb.a.fromDPToPix(getContext(), 54);
    AppMethodBeat.o(206955);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    AppMethodBeat.i(206952);
    if (this.yeR.isEmpty())
    {
      AppMethodBeat.o(206952);
      return null;
    }
    paramMatrix = new ArrayList();
    Object localObject1 = (Iterable)this.xOW;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.gkd();
      }
      localObject2 = (bwu)localObject2;
      if (i < this.yeR.size())
      {
        Object localObject3 = this.yeR.get(i);
        p.g(localObject3, "bitmapList[index]");
        paramMatrix.add(new f((bwu)localObject2, (Bitmap)localObject3));
      }
      i += 1;
    }
    localObject1 = new Matrix();
    ((Matrix)localObject1).postConcat(this.pZW.gR);
    ((Matrix)localObject1).postTranslate(-(this.xZq.width() - this.xZp.width()) / 2.0F, -(this.xZq.height() - this.xZp.height()) / 2.0F);
    paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.g((List)paramMatrix, (Matrix)localObject1);
    AppMethodBeat.o(206952);
    return paramMatrix;
  }
  
  public final a clM()
  {
    AppMethodBeat.i(206953);
    if (this.yeR.isEmpty())
    {
      AppMethodBeat.o(206953);
      return null;
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).postConcat(this.pZW.gR);
    localObject = (a)new l((List)this.xOW, (Matrix)localObject);
    AppMethodBeat.o(206953);
    return localObject;
  }
  
  public final boolean dKK()
  {
    return true;
  }
  
  public final void fr(List<? extends bwu> paramList)
  {
    AppMethodBeat.i(76146);
    p.h(paramList, "lyricsInfo");
    fs(paramList);
    dLt();
    paramList = ((Iterable)this.yeR).iterator();
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
        this.pZW.width = k;
        this.pZW.height = i;
        this.ydw.setBounds(0, 0, k, i);
        this.pZW.o(new float[] { 0.0F, 0.0F, k, 0.0F, 0.0F, i, k, i });
        f2 = this.xZq.height() - aq.fromDPToPix(getContext(), 360) - i;
        i = this.api;
        paramList = e.xKl;
        if (i < e.dIe().left) {
          break label269;
        }
      }
      for (float f1 = this.api;; f1 = e.dIe().left)
      {
        this.pZW.gR.setTranslate(f1, f2);
        AppMethodBeat.o(76146);
        return;
        paramList = e.xKl;
      }
    }
  }
  
  public final ArrayList<Bitmap> getBitmapList()
  {
    return this.yeR;
  }
  
  public final float[] getContentBoundary()
  {
    AppMethodBeat.i(76157);
    float[] arrayOfFloat = (float[])this.pZW.ygj.clone();
    AppMethodBeat.o(76157);
    return arrayOfFloat;
  }
  
  public final int getCurIndex()
  {
    return this.rss;
  }
  
  public final Rect getDisplayRect()
  {
    return this.xZq;
  }
  
  public final RectF getDrawRect()
  {
    AppMethodBeat.i(206956);
    RectF localRectF = new RectF(this.pZW.ygj[0], this.pZW.ygj[1], this.pZW.ygj[2], this.pZW.ygj[3]);
    AppMethodBeat.o(206956);
    return localRectF;
  }
  
  public final long getDuration()
  {
    return this.duration;
  }
  
  public final a getEditorData()
  {
    return (a)this.yeU;
  }
  
  public final ArrayList<bwu> getLyricsList()
  {
    return this.xOW;
  }
  
  public final boolean getNeedInvalidate()
  {
    return this.yeT;
  }
  
  public final Paint getPaint()
  {
    return this.paint;
  }
  
  public final Rect getSafeArea()
  {
    AppMethodBeat.i(76156);
    Rect localRect = this.pZW.xKi;
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
    return this.ydB;
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
    return this.gpe;
  }
  
  public final float getTouchDownY()
  {
    return this.gpf;
  }
  
  public final boolean getTouchMoved()
  {
    return this.gpb;
  }
  
  public final int getTouchSlop()
  {
    return this.rW;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker()
  {
    return this.pZW;
  }
  
  public final b getType()
  {
    return b.ygE;
  }
  
  public final Rect getValidRect()
  {
    return this.xZp;
  }
  
  public final Matrix getViewMatrix()
  {
    return this.ydC;
  }
  
  public final Paint getWavePaint()
  {
    return this.yeS;
  }
  
  public final long getWaveTime()
  {
    return this.yeA;
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
    if (this.ydC != null)
    {
      paramCanvas.setMatrix(this.ydC);
      if (isActivated()) {
        this.ydw.draw(paramCanvas);
      }
      if (this.xOW.isEmpty()) {
        break label486;
      }
      if ((this.yeA != 0L) && (bu.DD(this.yeA) <= this.yeC)) {
        break label328;
      }
      this.yeA = System.currentTimeMillis();
      f1 = 0.0F;
      localObject1 = this.yeN;
      i = 0;
      int k = localObject1.length;
      j = 0;
      if (j >= k) {
        break label328;
      }
      localObject2 = localObject1[j];
      f2 = localObject2.height();
      if (f2 > this.yeI) {
        break label282;
      }
      this.yeO[i] = ((float)(this.yeH * Math.random()));
      label155:
      if (f2 > this.yeO[i]) {
        break label309;
      }
    }
    label282:
    label309:
    for (float f2 = Math.min(this.yeL + f2, this.yeH);; f2 = Math.max(f2 - this.yeM, this.yeI))
    {
      float f3 = this.yeJ;
      float f4 = this.yeH / 2.0F;
      float f5 = f2 / 2.0F;
      float f6 = this.yeJ;
      float f7 = this.yeG;
      float f8 = this.yeH / 2.0F;
      localObject2.set(f3 + f1, f4 - f5, f1 + f6 + f7, f2 / 2.0F + f8);
      f1 = localObject2.right;
      j += 1;
      i += 1;
      break label108;
      paramCanvas.setMatrix(this.pZW.gR);
      break;
      if (f2 < this.yeO[i]) {
        break label155;
      }
      this.yeO[i] = this.yeI;
      break label155;
    }
    label328:
    long l1 = ((bwu)this.xOW.get(0)).startTime;
    long l2;
    long l3;
    if (this.yeB < 255)
    {
      l2 = this.yeD;
      l3 = this.duration - l1;
      if (0L <= l3) {
        break label452;
      }
      if (this.duration - l1 <= this.yeD) {}
    }
    for (this.yeB = 255;; this.yeB = ((int)((float)(this.duration - l1) * 255.0F / (float)this.yeD)))
    {
      this.yeS.setAlpha(this.yeB);
      localObject1 = this.yeN;
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        paramCanvas.drawRect(localObject1[i], this.yeS);
        i += 1;
      }
      label452:
      if (l2 < l3) {
        break;
      }
    }
    label486:
    if (!this.xOW.isEmpty())
    {
      this.duration = (System.currentTimeMillis() - this.startTime);
      localObject1 = (bwu)j.F((List)this.xOW, this.rss + 1);
      if (localObject1 == null) {
        break label836;
      }
      l1 = ((bwu)localObject1).startTime;
      if (this.duration >= l1)
      {
        this.rss += 1;
        if (this.rss >= this.xOW.size())
        {
          this.rss = 0;
          this.startTime = System.currentTimeMillis();
          this.duration = 0L;
        }
      }
    }
    label610:
    long l4;
    if (!((Collection)this.yeR).isEmpty())
    {
      i = 1;
      if ((i != 0) && (this.rss < this.yeR.size())) {
        if (this.rss < this.xOW.size())
        {
          l2 = ((bwu)this.xOW.get(this.rss)).startTime;
          localObject1 = (bwu)j.F((List)this.xOW, this.rss + 1);
          if (localObject1 == null) {
            break label869;
          }
          l1 = ((bwu)localObject1).startTime;
          label695:
          l3 = this.yeD;
          l4 = this.duration - l2;
          if (0L <= l4) {
            break label896;
          }
          label717:
          l3 = this.yeD;
          l4 = l1 - this.duration;
          if (0L <= l4) {
            break label930;
          }
          label739:
          if ((this.duration - l2 > this.yeD) && (l1 - this.duration > this.yeD)) {
            this.alpha = 255;
          }
        }
      }
    }
    for (;;)
    {
      this.paint.setAlpha(this.alpha);
      paramCanvas.drawBitmap((Bitmap)this.yeR.get(this.rss), 0.0F, this.yeK, this.paint);
      paramCanvas.restore();
      if (this.yeT) {
        invalidate();
      }
      AppMethodBeat.o(76152);
      return;
      label836:
      l1 = ((bwu)this.xOW.get(this.rss)).startTime + this.yeE;
      break;
      i = 0;
      break label610;
      label869:
      l1 = ((bwu)this.xOW.get(this.rss)).startTime + this.yeE;
      break label695;
      label896:
      if (l3 < l4) {
        break label717;
      }
      this.alpha = ((int)(255.0F * (float)(this.duration - l2) / (float)this.yeD));
      continue;
      label930:
      if (l3 < l4) {
        break label739;
      }
      this.alpha = ((int)((float)(l1 - this.duration) / (float)this.yeD * 255.0F));
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76151);
    p.h(paramMotionEvent, "event");
    this.yeQ.set(this.pZW.gR);
    this.yeQ.getValues(this.yeP);
    float f1 = this.yeP[2];
    boolean bool2 = this.pZW.U(paramMotionEvent);
    this.pZW.gR.getValues(this.yeP);
    float f2 = this.yeP[5];
    this.pZW.gR.set(this.yeQ);
    this.pZW.gR.setTranslate(f1, f2);
    Object localObject;
    if (bool2)
    {
      localObject = this.xZr;
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
      this.gpe = paramMotionEvent.getX();
      this.gpf = paramMotionEvent.getY();
      this.gpb = false;
      continue;
      f1 = Math.max(Math.abs(paramMotionEvent.getX() - this.gpe), Math.abs(paramMotionEvent.getY() - this.gpf));
      if (!this.gpb)
      {
        if (f1 > this.rW) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          this.gpb = bool1;
          break;
        }
        if (!this.gpb) {
          performClick();
        }
        paramMotionEvent = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
        localObject = this.xZp;
        paramMotionEvent.aXF = this.pZW.aXF;
        paramMotionEvent.aXE = this.pZW.aXE;
        paramMotionEvent.n(new float[] { this.pZW.width / 2.0F, this.pZW.height / 2.0F });
        paramMotionEvent.f(new RectF(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom));
        paramMotionEvent.a(this.pZW.gR, (d.g.a.m)new a(this));
      }
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(76158);
    this.yeT = true;
    invalidate();
    AppMethodBeat.o(76158);
  }
  
  public final void setBitmapList(ArrayList<Bitmap> paramArrayList)
  {
    AppMethodBeat.i(76139);
    p.h(paramArrayList, "<set-?>");
    this.yeR = paramArrayList;
    AppMethodBeat.o(76139);
  }
  
  public final void setCurIndex(int paramInt)
  {
    this.rss = paramInt;
  }
  
  public final void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public final void setNeedInvalidate(boolean paramBoolean)
  {
    this.yeT = paramBoolean;
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
    AppMethodBeat.i(206950);
    p.h(paramd, "<set-?>");
    this.ydB = paramd;
    AppMethodBeat.o(206950);
  }
  
  public final void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(76147);
    p.h(paramb, "stateResolve");
    this.xZr = paramb;
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
    this.gpe = paramFloat;
  }
  
  public final void setTouchDownY(float paramFloat)
  {
    this.gpf = paramFloat;
  }
  
  public final void setTouchMoved(boolean paramBoolean)
  {
    this.gpb = paramBoolean;
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(76144);
    p.h(paramRect, "validRect");
    this.xZp.set(paramRect);
    AppMethodBeat.o(76144);
  }
  
  public final void setValidRect(Rect paramRect)
  {
    AppMethodBeat.i(76142);
    p.h(paramRect, "<set-?>");
    this.xZp = paramRect;
    AppMethodBeat.o(76142);
  }
  
  public final void setViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(76143);
    this.ydC = paramMatrix;
    if (paramMatrix != null)
    {
      this.pZW.setMatrix(paramMatrix);
      Canvas localCanvas = new Canvas();
      localCanvas.save();
      if (this.ydC != null) {
        localCanvas.setMatrix(paramMatrix);
      }
      if (isActivated()) {
        this.ydw.draw(localCanvas);
      }
    }
    AppMethodBeat.o(76143);
  }
  
  public final void setWavePaint(Paint paramPaint)
  {
    AppMethodBeat.i(76141);
    p.h(paramPaint, "<set-?>");
    this.yeS = paramPaint;
    AppMethodBeat.o(76141);
  }
  
  public final void setWaveTime(long paramLong)
  {
    this.yeA = paramLong;
  }
  
  public final boolean zi(long paramLong)
  {
    AppMethodBeat.i(206957);
    boolean bool = c.a.a(this, paramLong);
    AppMethodBeat.o(206957);
    return bool;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "<anonymous parameter 1>", "", "invoke"})
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
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
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DP_1", "", "LAST_INTERVAL", "", "LYRICS_VERTICAL_OFFSET", "", "MARGIN", "TAG", "", "TRANS_TIME", "WAVE_DECREMENT", "WAVE_INCREMENT", "WAVE_INVALIDAT_INTERVAL", "WAVE_RECT_COUNT", "WAVE_RECT_HEIGHT", "WAVE_RECT_MIN_HEIGHT", "WAVE_RECT_OFFSET", "WAVE_RECT_WIDTH", "alpha", "bitmapList", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "getBitmapList", "()Ljava/util/ArrayList;", "setBitmapList", "(Ljava/util/ArrayList;)V", "curIndex", "getCurIndex", "()I", "setCurIndex", "(I)V", "displayRect", "Landroid/graphics/Rect;", "getDisplayRect", "()Landroid/graphics/Rect;", "duration", "getDuration", "()J", "setDuration", "(J)V", "frameDrawable", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "lyricsItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem;", "lyricsList", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "getLyricsList", "needInvalidate", "", "getNeedInvalidate", "()Z", "setNeedInvalidate", "(Z)V", "originMatrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "setPaint", "(Landroid/graphics/Paint;)V", "sourceDataType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "getSourceDataType", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "setSourceDataType", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;)V", "startTime", "getStartTime", "setStartTime", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "text", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textSize", "getTextSize", "()F", "setTextSize", "(F)V", "touchArray", "", "touchDownX", "getTouchDownX", "setTouchDownX", "touchDownY", "getTouchDownY", "setTouchDownY", "touchMoved", "getTouchMoved", "setTouchMoved", "touchSlop", "getTouchSlop", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validRect", "getValidRect", "setValidRect", "(Landroid/graphics/Rect;)V", "value", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "waveAlpha", "wavePaint", "getWavePaint", "setWavePaint", "waveRects", "", "Landroid/graphics/RectF;", "[Landroid/graphics/RectF;", "waveTargetHeight", "waveTime", "getWaveTime", "setWaveTime", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "createLyricsBitmap", "", "drawWave", "canvas", "Landroid/graphics/Canvas;", "fillAlpha", "fillWaveAlpha", "appearTime", "getContentBoundary", "getDrawRect", "getEditorData", "getLyricsEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorItem;", "item", "getSafeArea", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "nextIndex", "onDraw", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "renderLyrics", "lyricsInfo", "", "reshowLyrics", "resume", "setDefaultLocation", "heightPercent", "setSafeArea", "safeRect", "damp", "setStateResolve", "setValidArea", "updateLyricsList", "plugin-recordvideo_release"})
public final class m
  extends View
  implements g, com.tencent.mm.plugin.recordvideo.ui.editor.view.c
{
  private final ArrayList<ckm> BOY;
  private Rect Cao;
  private final Rect Cap;
  private EditorItemContainer.b Caq;
  private d CeD;
  private Matrix CeE;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.view.a Cey;
  private long CfC;
  private int CfD;
  private final long CfE;
  private final long CfF;
  private final long CfG;
  private final int CfH;
  private final float CfI;
  private final float CfJ;
  private final int CfK;
  private final float CfL;
  private final float CfM;
  private final float CfN;
  private final int CfO;
  private final RectF[] CfP;
  private final float[] CfQ;
  private final float[] CfR;
  private final Matrix CfS;
  private ArrayList<Bitmap> CfT;
  private Paint CfU;
  public boolean CfV;
  private l CfW;
  private final String TAG;
  private int alpha;
  private final int apv;
  private long duration;
  private boolean gZU;
  private float gZX;
  private float gZY;
  private Paint paint;
  private final int qfm;
  private final int rZ;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c rqT;
  private int sTB;
  private long startTime;
  private CharSequence text;
  private float textSize;
  
  public m(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76159);
    this.BOY = new ArrayList();
    this.TAG = "MicroMsg.LyricsItemView";
    this.CfE = 50L;
    this.CfF = 200L;
    this.CfG = 3000L;
    this.CfH = 11;
    this.qfm = at.fromDPToPix(paramContext, 1);
    this.CfI = (this.qfm * 1.5F);
    this.CfJ = (this.qfm * 9.0F);
    this.CfK = this.qfm;
    this.CfL = (this.qfm * 1.5F);
    this.CfM = (this.qfm * 12.0F);
    this.CfN = (this.qfm * 2.0F);
    this.CfO = this.qfm;
    this.apv = at.fromDPToPix(paramContext, 32);
    int j = this.CfH;
    Object localObject = new RectF[j];
    int i = 0;
    while (i < j)
    {
      localObject[i] = new RectF();
      i += 1;
    }
    this.CfP = ((RectF[])localObject);
    this.CfQ = new float[this.CfH];
    this.CfR = new float[9];
    this.CfS = new Matrix();
    this.rqT = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    this.textSize = getResources().getDimension(2131166236);
    this.CeD = d.CeO;
    this.CfT = new ArrayList();
    this.paint = new Paint();
    this.CfU = new Paint();
    this.Cao = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
    this.Cap = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
    this.CfV = true;
    this.rqT.aXu = 0.5F;
    this.rqT.aXt = 3.0F;
    this.CfU.setColor(Color.parseColor("#CCFFFFFF"));
    localObject = getResources();
    p.g(localObject, "resources");
    this.Cey = new com.tencent.mm.plugin.recordvideo.ui.editor.view.a((Resources)localObject);
    paramContext = ViewConfiguration.get(paramContext);
    p.g(paramContext, "ViewConfiguration.get(context)");
    this.rZ = paramContext.getScaledTouchSlop();
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(76159);
  }
  
  private final void eMt()
  {
    AppMethodBeat.i(76150);
    Iterator localIterator = ((Iterable)this.BOY).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (ckm)localIterator.next();
      if (!Util.isNullOrNil(((ckm)localObject1).lyrics))
      {
        Object localObject2 = new LinearLayout(getContext());
        localObject2 = LayoutInflater.from(getContext()).inflate(2131496590, (ViewGroup)localObject2, false);
        TextView localTextView = (TextView)((View)localObject2).findViewById(2131308663);
        p.g(localTextView, "lyricsText");
        com.tencent.mm.ac.d.f(localTextView);
        localTextView.setText((CharSequence)((ckm)localObject1).lyrics);
        e locale = e.BKp;
        localTextView.setMaxHeight(e.eIR().height());
        int i = this.apv;
        locale = e.BKp;
        if (i >= e.eIR().left)
        {
          locale = e.BKp;
          i = e.eIR().width();
          j = this.apv;
          locale = e.BKp;
          i -= (j - e.eIR().left) * 2;
          label194:
          localTextView.setMaxWidth(i);
          ((View)localObject2).measure(0, 0);
          p.g(localObject2, "parent");
          ((View)localObject2).layout(0, 0, ((View)localObject2).getMeasuredWidth(), ((View)localObject2).getMeasuredHeight());
          if (((View)localObject2).getMeasuredWidth() > 0)
          {
            i = ((View)localObject2).getMeasuredWidth();
            locale = e.BKp;
            if (i <= e.eIR().width()) {
              break label457;
            }
          }
          locale = e.BKp;
          i = e.eIR().width();
          label273:
          if (((View)localObject2).getMeasuredHeight() > 0)
          {
            j = ((View)localObject2).getMeasuredHeight();
            locale = e.BKp;
            if (j <= e.eIR().height()) {
              break label466;
            }
          }
          locale = e.BKp;
        }
        label457:
        label466:
        for (int j = e.eIR().height();; j = ((View)localObject2).getMeasuredHeight())
        {
          Log.i(this.TAG, "it.lyrics=" + ((ckm)localObject1).lyrics + " lyricsText.maxWidth=" + localTextView.getMaxWidth() + " lyricsText.maxHeight=" + localTextView.getMaxHeight() + " parent.measuredWidth=" + ((View)localObject2).getMeasuredWidth() + " parent.measuredHeight=" + ((View)localObject2).getMeasuredHeight());
          localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          ((View)localObject2).draw(new Canvas((Bitmap)localObject1));
          this.CeD = d.CeO;
          this.CfT.add(localObject1);
          break;
          locale = e.BKp;
          i = e.eIR().width();
          break label194;
          i = ((View)localObject2).getMeasuredWidth();
          break label273;
        }
      }
    }
    AppMethodBeat.o(76150);
  }
  
  private final void gn(List<? extends ckm> paramList)
  {
    AppMethodBeat.i(76149);
    this.BOY.clear();
    ArrayList localArrayList = this.BOY;
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label98:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (!Util.isNullOrNil(((ckm)localObject2).lyrics)) {}
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
  
  public final boolean Ig(long paramLong)
  {
    AppMethodBeat.i(237798);
    boolean bool = c.a.a(this, paramLong);
    AppMethodBeat.o(237798);
    return bool;
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(76145);
    p.h(paramRect, "displayRect");
    this.Cap.set(paramRect);
    AppMethodBeat.o(76145);
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(237792);
    p.h(paraml, "item");
    this.CfW = paraml;
    setViewMatrix(paraml.gT);
    gn((List)paraml.CfA);
    eMt();
    this.CeD = d.CeO;
    AppMethodBeat.o(237792);
  }
  
  public final boolean aLB(String paramString)
  {
    AppMethodBeat.i(237799);
    p.h(paramString, "objID");
    boolean bool = c.a.a(this, paramString);
    AppMethodBeat.o(237799);
    return bool;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.g b(l paraml)
  {
    AppMethodBeat.i(237795);
    p.h(paraml, "item");
    gm((List)paraml.CfA);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (Iterable)this.BOY;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.hxH();
      }
      localObject2 = (ckm)localObject2;
      Object localObject3 = this.CfT.get(i);
      p.g(localObject3, "bitmapList[index]");
      localArrayList.add(new f((ckm)localObject2, (Bitmap)localObject3));
      i += 1;
    }
    paraml = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.g((List)localArrayList, paraml.gT);
    AppMethodBeat.o(237795);
    return paraml;
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(237796);
    p.h(paramRect, "safeRect");
    this.rqT.BKm = paramRect;
    this.rqT.Chb = com.tencent.mm.cb.a.fromDPToPix(getContext(), 54);
    AppMethodBeat.o(237796);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    AppMethodBeat.i(237793);
    if (this.CfT.isEmpty())
    {
      AppMethodBeat.o(237793);
      return null;
    }
    paramMatrix = new ArrayList();
    Object localObject1 = (Iterable)this.BOY;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.hxH();
      }
      localObject2 = (ckm)localObject2;
      if (i < this.CfT.size())
      {
        Object localObject3 = this.CfT.get(i);
        p.g(localObject3, "bitmapList[index]");
        paramMatrix.add(new f((ckm)localObject2, (Bitmap)localObject3));
      }
      i += 1;
    }
    localObject1 = new Matrix();
    ((Matrix)localObject1).postConcat(this.rqT.gT);
    paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.g((List)paramMatrix, (Matrix)localObject1);
    AppMethodBeat.o(237793);
    return paramMatrix;
  }
  
  public final a cJO()
  {
    AppMethodBeat.i(237794);
    if (this.CfT.isEmpty())
    {
      AppMethodBeat.o(237794);
      return null;
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).postConcat(this.rqT.gT);
    localObject = (a)new l((List)this.BOY, (Matrix)localObject);
    AppMethodBeat.o(237794);
    return localObject;
  }
  
  public final boolean eLK()
  {
    return true;
  }
  
  public final ArrayList<Bitmap> getBitmapList()
  {
    return this.CfT;
  }
  
  public final float[] getContentBoundary()
  {
    AppMethodBeat.i(76157);
    float[] arrayOfFloat = (float[])this.rqT.Chg.clone();
    AppMethodBeat.o(76157);
    return arrayOfFloat;
  }
  
  public final int getCurIndex()
  {
    return this.sTB;
  }
  
  public final Rect getDisplayRect()
  {
    return this.Cap;
  }
  
  public final RectF getDrawRect()
  {
    AppMethodBeat.i(237797);
    RectF localRectF = new RectF(this.rqT.Chg[0], this.rqT.Chg[1], this.rqT.Chg[2], this.rqT.Chg[3]);
    AppMethodBeat.o(237797);
    return localRectF;
  }
  
  public final long getDuration()
  {
    return this.duration;
  }
  
  public final a getEditorData()
  {
    return (a)this.CfW;
  }
  
  public final ArrayList<ckm> getLyricsList()
  {
    return this.BOY;
  }
  
  public final boolean getNeedInvalidate()
  {
    return this.CfV;
  }
  
  public final Paint getPaint()
  {
    return this.paint;
  }
  
  public final Rect getSafeArea()
  {
    AppMethodBeat.i(76156);
    Rect localRect = this.rqT.BKm;
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
    return this.CeD;
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
    return this.gZX;
  }
  
  public final float getTouchDownY()
  {
    return this.gZY;
  }
  
  public final boolean getTouchMoved()
  {
    return this.gZU;
  }
  
  public final int getTouchSlop()
  {
    return this.rZ;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker()
  {
    return this.rqT;
  }
  
  public final b getType()
  {
    return b.ChB;
  }
  
  public final Rect getValidRect()
  {
    return this.Cao;
  }
  
  public final Matrix getViewMatrix()
  {
    return this.CeE;
  }
  
  public final Paint getWavePaint()
  {
    return this.CfU;
  }
  
  public final long getWaveTime()
  {
    return this.CfC;
  }
  
  public final void gm(List<? extends ckm> paramList)
  {
    AppMethodBeat.i(76146);
    p.h(paramList, "lyricsInfo");
    gn(paramList);
    eMt();
    paramList = ((Iterable)this.CfT).iterator();
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
        this.rqT.width = k;
        this.rqT.height = i;
        this.Cey.setBounds(0, 0, k, i);
        this.rqT.o(new float[] { 0.0F, 0.0F, k, 0.0F, 0.0F, i, k, i });
        f2 = this.Cap.height() - at.fromDPToPix(getContext(), 360) - i;
        i = this.apv;
        paramList = e.BKp;
        if (i < e.eIR().left) {
          break label269;
        }
      }
      for (float f1 = this.apv;; f1 = e.eIR().left)
      {
        this.rqT.gT.setTranslate(f1, f2);
        AppMethodBeat.o(76146);
        return;
        paramList = e.BKp;
      }
    }
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
    if (this.CeE != null)
    {
      paramCanvas.setMatrix(this.CeE);
      if (isActivated()) {
        this.Cey.draw(paramCanvas);
      }
      if (this.BOY.isEmpty()) {
        break label486;
      }
      if ((this.CfC != 0L) && (Util.milliSecondsToNow(this.CfC) <= this.CfE)) {
        break label328;
      }
      this.CfC = System.currentTimeMillis();
      f1 = 0.0F;
      localObject1 = this.CfP;
      i = 0;
      int k = localObject1.length;
      j = 0;
      if (j >= k) {
        break label328;
      }
      localObject2 = localObject1[j];
      f2 = localObject2.height();
      if (f2 > this.CfK) {
        break label282;
      }
      this.CfQ[i] = ((float)(this.CfJ * Math.random()));
      label155:
      if (f2 > this.CfQ[i]) {
        break label309;
      }
    }
    label282:
    label309:
    for (float f2 = Math.min(this.CfN + f2, this.CfJ);; f2 = Math.max(f2 - this.CfO, this.CfK))
    {
      float f3 = this.CfL;
      float f4 = this.CfJ / 2.0F;
      float f5 = f2 / 2.0F;
      float f6 = this.CfL;
      float f7 = this.CfI;
      float f8 = this.CfJ / 2.0F;
      localObject2.set(f3 + f1, f4 - f5, f1 + f6 + f7, f2 / 2.0F + f8);
      f1 = localObject2.right;
      j += 1;
      i += 1;
      break label108;
      paramCanvas.setMatrix(this.rqT.gT);
      break;
      if (f2 < this.CfQ[i]) {
        break label155;
      }
      this.CfQ[i] = this.CfK;
      break label155;
    }
    label328:
    long l1 = ((ckm)this.BOY.get(0)).startTime;
    long l2;
    long l3;
    if (this.CfD < 255)
    {
      l2 = this.CfF;
      l3 = this.duration - l1;
      if (0L <= l3) {
        break label452;
      }
      if (this.duration - l1 <= this.CfF) {}
    }
    for (this.CfD = 255;; this.CfD = ((int)((float)(this.duration - l1) * 255.0F / (float)this.CfF)))
    {
      this.CfU.setAlpha(this.CfD);
      localObject1 = this.CfP;
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        paramCanvas.drawRect(localObject1[i], this.CfU);
        i += 1;
      }
      label452:
      if (l2 < l3) {
        break;
      }
    }
    label486:
    if (!this.BOY.isEmpty())
    {
      this.duration = (System.currentTimeMillis() - this.startTime);
      localObject1 = (ckm)j.L((List)this.BOY, this.sTB + 1);
      if (localObject1 == null) {
        break label836;
      }
      l1 = ((ckm)localObject1).startTime;
      if (this.duration >= l1)
      {
        this.sTB += 1;
        if (this.sTB >= this.BOY.size())
        {
          this.sTB = 0;
          this.startTime = System.currentTimeMillis();
          this.duration = 0L;
        }
      }
    }
    label610:
    long l4;
    if (!((Collection)this.CfT).isEmpty())
    {
      i = 1;
      if ((i != 0) && (this.sTB < this.CfT.size())) {
        if (this.sTB < this.BOY.size())
        {
          l2 = ((ckm)this.BOY.get(this.sTB)).startTime;
          localObject1 = (ckm)j.L((List)this.BOY, this.sTB + 1);
          if (localObject1 == null) {
            break label869;
          }
          l1 = ((ckm)localObject1).startTime;
          label695:
          l3 = this.CfF;
          l4 = this.duration - l2;
          if (0L <= l4) {
            break label896;
          }
          label717:
          l3 = this.CfF;
          l4 = l1 - this.duration;
          if (0L <= l4) {
            break label930;
          }
          label739:
          if ((this.duration - l2 > this.CfF) && (l1 - this.duration > this.CfF)) {
            this.alpha = 255;
          }
        }
      }
    }
    for (;;)
    {
      this.paint.setAlpha(this.alpha);
      paramCanvas.drawBitmap((Bitmap)this.CfT.get(this.sTB), 0.0F, this.CfM, this.paint);
      paramCanvas.restore();
      if (this.CfV) {
        invalidate();
      }
      AppMethodBeat.o(76152);
      return;
      label836:
      l1 = ((ckm)this.BOY.get(this.sTB)).startTime + this.CfG;
      break;
      i = 0;
      break label610;
      label869:
      l1 = ((ckm)this.BOY.get(this.sTB)).startTime + this.CfG;
      break label695;
      label896:
      if (l3 < l4) {
        break label717;
      }
      this.alpha = ((int)(255.0F * (float)(this.duration - l2) / (float)this.CfF));
      continue;
      label930:
      if (l3 < l4) {
        break label739;
      }
      this.alpha = ((int)((float)(l1 - this.duration) / (float)this.CfF * 255.0F));
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76151);
    p.h(paramMotionEvent, "event");
    this.CfS.set(this.rqT.gT);
    this.CfS.getValues(this.CfR);
    float f1 = this.CfR[2];
    boolean bool2 = this.rqT.Y(paramMotionEvent);
    this.rqT.gT.getValues(this.CfR);
    float f2 = this.CfR[5];
    this.rqT.gT.set(this.CfS);
    this.rqT.gT.setTranslate(f1, f2);
    Object localObject;
    if (bool2)
    {
      localObject = this.Caq;
      if (localObject != null) {
        ((EditorItemContainer.b)localObject).d((View)this, paramMotionEvent);
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
      this.gZX = paramMotionEvent.getX();
      this.gZY = paramMotionEvent.getY();
      this.gZU = false;
      continue;
      f1 = Math.max(Math.abs(paramMotionEvent.getX() - this.gZX), Math.abs(paramMotionEvent.getY() - this.gZY));
      if (!this.gZU)
      {
        if (f1 > this.rZ) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          this.gZU = bool1;
          break;
        }
        if (!this.gZU) {
          performClick();
        }
        paramMotionEvent = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
        localObject = this.Cao;
        paramMotionEvent.aXu = this.rqT.aXu;
        paramMotionEvent.aXt = this.rqT.aXt;
        paramMotionEvent.n(new float[] { this.rqT.width / 2.0F, this.rqT.height / 2.0F });
        paramMotionEvent.f(new RectF(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom));
        paramMotionEvent.a(this.rqT.gT, (kotlin.g.a.m)new a(this));
      }
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(76158);
    this.CfV = true;
    invalidate();
    AppMethodBeat.o(76158);
  }
  
  public final void setBitmapList(ArrayList<Bitmap> paramArrayList)
  {
    AppMethodBeat.i(76139);
    p.h(paramArrayList, "<set-?>");
    this.CfT = paramArrayList;
    AppMethodBeat.o(76139);
  }
  
  public final void setCurIndex(int paramInt)
  {
    this.sTB = paramInt;
  }
  
  public final void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public final void setNeedInvalidate(boolean paramBoolean)
  {
    this.CfV = paramBoolean;
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
    AppMethodBeat.i(237791);
    p.h(paramd, "<set-?>");
    this.CeD = paramd;
    AppMethodBeat.o(237791);
  }
  
  public final void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(76147);
    p.h(paramb, "stateResolve");
    this.Caq = paramb;
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
    this.gZX = paramFloat;
  }
  
  public final void setTouchDownY(float paramFloat)
  {
    this.gZY = paramFloat;
  }
  
  public final void setTouchMoved(boolean paramBoolean)
  {
    this.gZU = paramBoolean;
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(76144);
    p.h(paramRect, "validRect");
    this.Cao.set(paramRect);
    AppMethodBeat.o(76144);
  }
  
  public final void setValidRect(Rect paramRect)
  {
    AppMethodBeat.i(76142);
    p.h(paramRect, "<set-?>");
    this.Cao = paramRect;
    AppMethodBeat.o(76142);
  }
  
  public final void setViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(76143);
    this.CeE = paramMatrix;
    if (paramMatrix != null)
    {
      this.rqT.setMatrix(paramMatrix);
      Canvas localCanvas = new Canvas();
      localCanvas.save();
      if (this.CeE != null) {
        localCanvas.setMatrix(paramMatrix);
      }
      if (isActivated()) {
        this.Cey.draw(localCanvas);
      }
    }
    AppMethodBeat.o(76143);
  }
  
  public final void setWavePaint(Paint paramPaint)
  {
    AppMethodBeat.i(76141);
    p.h(paramPaint, "<set-?>");
    this.CfU = paramPaint;
    AppMethodBeat.o(76141);
  }
  
  public final void setWaveTime(long paramLong)
  {
    this.CfC = paramLong;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "<anonymous parameter 1>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.m<Matrix, Boolean, x>
  {
    a(m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.m
 * JD-Core Version:    0.7.0.1
 */
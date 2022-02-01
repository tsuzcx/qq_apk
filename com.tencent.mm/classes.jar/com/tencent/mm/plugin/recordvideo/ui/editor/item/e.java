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
import com.tencent.mm.plugin.recordvideo.background.g;
import com.tencent.mm.protocal.protobuf.brn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "Landroid/view/View;", "Lcom/tencent/mm/media/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DP_1", "", "LAST_INTERVAL", "", "LYRICS_VERTICAL_OFFSET", "", "MARGIN", "TAG", "", "TRANS_TIME", "WAVE_DECREMENT", "WAVE_INCREMENT", "WAVE_INVALIDAT_INTERVAL", "WAVE_RECT_COUNT", "WAVE_RECT_HEIGHT", "WAVE_RECT_MIN_HEIGHT", "WAVE_RECT_OFFSET", "WAVE_RECT_WIDTH", "alpha", "bitmapList", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "getBitmapList", "()Ljava/util/ArrayList;", "setBitmapList", "(Ljava/util/ArrayList;)V", "curIndex", "getCurIndex", "()I", "setCurIndex", "(I)V", "displayRect", "Landroid/graphics/Rect;", "getDisplayRect", "()Landroid/graphics/Rect;", "duration", "getDuration", "()J", "setDuration", "(J)V", "frameDrawable", "Lcom/tencent/mm/media/editor/view/ActiveFrameDrawable;", "lyricsList", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "getLyricsList", "needInvalidate", "", "getNeedInvalidate", "()Z", "setNeedInvalidate", "(Z)V", "originMatrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "setPaint", "(Landroid/graphics/Paint;)V", "sourceDataType", "Lcom/tencent/mm/media/editor/item/EditorDataType;", "getSourceDataType", "()Lcom/tencent/mm/media/editor/item/EditorDataType;", "setSourceDataType", "(Lcom/tencent/mm/media/editor/item/EditorDataType;)V", "startTime", "getStartTime", "setStartTime", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "text", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textSize", "getTextSize", "()F", "setTextSize", "(F)V", "touchArray", "", "touchDownX", "getTouchDownX", "setTouchDownX", "touchDownY", "getTouchDownY", "setTouchDownY", "touchMoved", "getTouchMoved", "setTouchMoved", "touchSlop", "getTouchSlop", "touchTracker", "Lcom/tencent/mm/media/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/media/editor/touch/TouchTracker;", "validRect", "getValidRect", "setValidRect", "(Landroid/graphics/Rect;)V", "value", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "waveAlpha", "wavePaint", "getWavePaint", "setWavePaint", "waveRects", "", "Landroid/graphics/RectF;", "[Landroid/graphics/RectF;", "waveTargetHeight", "waveTime", "getWaveTime", "setWaveTime", "createEditorData", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "matrix", "createLyricsBitmap", "", "drawWave", "canvas", "Landroid/graphics/Canvas;", "fillAlpha", "fillWaveAlpha", "appearTime", "getContentBoundary", "getSafeArea", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditItemType;", "nextIndex", "onDraw", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "renderLyrics", "lyricsInfo", "", "reshowLyrics", "resume", "setDefaultLocation", "heightPercent", "setSafeArea", "safeRect", "damp", "setStateResolve", "setValidArea", "updateLyricsList", "plugin-recordvideo_release"})
public final class e
  extends View
  implements h, d
{
  private final String TAG;
  private int alpha;
  private final int anr;
  private long duration;
  private boolean fTb;
  private float fTe;
  private float fTf;
  private int gPA;
  private long gPB;
  private int gPC;
  private final long gPE;
  private final long gPF;
  private final long gPG;
  private final int gPH;
  private final int gPI;
  private final float gPJ;
  private final float gPK;
  private final int gPL;
  private final float gPM;
  private final float gPN;
  private final float gPO;
  private final int gPP;
  private final RectF[] gPQ;
  private final float[] gPR;
  private Paint gPS;
  private Paint paint;
  private final com.tencent.mm.media.editor.c.c ppQ;
  private final int qc;
  private long startTime;
  private CharSequence text;
  private float textSize;
  private final com.tencent.mm.media.editor.view.a wCA;
  private EditorItemContainer.b wCB;
  private Rect wCD;
  private final Rect wCE;
  private com.tencent.mm.media.editor.a.e wCH;
  private Matrix wCI;
  private final float[] wDs;
  private final Matrix wDt;
  private ArrayList<Bitmap> wDu;
  public boolean wDv;
  private final ArrayList<brn> wrj;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76159);
    this.wrj = new ArrayList();
    this.TAG = "MicroMsg.LyricsItemView";
    this.gPE = 50L;
    this.gPF = 200L;
    this.gPG = 3000L;
    this.gPH = 11;
    this.gPI = ao.fromDPToPix(paramContext, 1);
    this.gPJ = (this.gPI * 1.5F);
    this.gPK = (this.gPI * 9.0F);
    this.gPL = this.gPI;
    this.gPM = (this.gPI * 1.5F);
    this.gPN = (this.gPI * 12.0F);
    this.gPO = (this.gPI * 2.0F);
    this.gPP = this.gPI;
    this.anr = ao.fromDPToPix(paramContext, 32);
    int j = this.gPH;
    Object localObject = new RectF[j];
    int i = 0;
    while (i < j)
    {
      localObject[i] = new RectF();
      i += 1;
    }
    this.gPQ = ((RectF[])localObject);
    this.gPR = new float[this.gPH];
    this.wDs = new float[9];
    this.wDt = new Matrix();
    this.ppQ = new com.tencent.mm.media.editor.c.c();
    this.textSize = getResources().getDimension(2131166195);
    this.wCH = com.tencent.mm.media.editor.a.e.gPs;
    this.wDu = new ArrayList();
    this.paint = new Paint();
    this.gPS = new Paint();
    this.wCD = new Rect(0, 0, ap.cl(ai.getContext()).x, ap.cl(ai.getContext()).y);
    this.wCE = new Rect(0, 0, ap.cl(ai.getContext()).x, ap.cl(ai.getContext()).y);
    this.wDv = true;
    this.ppQ.aNl = 0.5F;
    this.ppQ.aNk = 3.0F;
    this.gPS.setColor(Color.parseColor("#CCFFFFFF"));
    localObject = getResources();
    d.g.b.k.g(localObject, "resources");
    this.wCA = new com.tencent.mm.media.editor.view.a((Resources)localObject);
    paramContext = ViewConfiguration.get(paramContext);
    d.g.b.k.g(paramContext, "ViewConfiguration.get(context)");
    this.qc = paramContext.getScaledTouchSlop();
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(76159);
  }
  
  private final void dwW()
  {
    AppMethodBeat.i(76150);
    Iterator localIterator = ((Iterable)this.wrj).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (brn)localIterator.next();
      if (!bs.isNullOrNil(((brn)localObject1).lyrics))
      {
        Object localObject2 = new LinearLayout(getContext());
        localObject2 = LayoutInflater.from(getContext()).inflate(2131495685, (ViewGroup)localObject2, false);
        TextView localTextView = (TextView)((View)localObject2).findViewById(2131305457);
        d.g.b.k.g(localTextView, "lyricsText");
        com.tencent.mm.ac.c.e(localTextView);
        localTextView.setText((CharSequence)((brn)localObject1).lyrics);
        g localg = g.wmx;
        localTextView.setMaxHeight(g.dur().height());
        int i = this.anr;
        localg = g.wmx;
        if (i >= g.dur().left)
        {
          localg = g.wmx;
          i = g.dur().width();
          j = this.anr;
          localg = g.wmx;
          i -= (j - g.dur().left) * 2;
          label194:
          localTextView.setMaxWidth(i);
          ((View)localObject2).measure(0, 0);
          d.g.b.k.g(localObject2, "parent");
          ((View)localObject2).layout(0, 0, ((View)localObject2).getMeasuredWidth(), ((View)localObject2).getMeasuredHeight());
          if (((View)localObject2).getMeasuredWidth() > 0)
          {
            i = ((View)localObject2).getMeasuredWidth();
            localg = g.wmx;
            if (i <= g.dur().width()) {
              break label457;
            }
          }
          localg = g.wmx;
          i = g.dur().width();
          label273:
          if (((View)localObject2).getMeasuredHeight() > 0)
          {
            j = ((View)localObject2).getMeasuredHeight();
            localg = g.wmx;
            if (j <= g.dur().height()) {
              break label466;
            }
          }
          localg = g.wmx;
        }
        label457:
        label466:
        for (int j = g.dur().height();; j = ((View)localObject2).getMeasuredHeight())
        {
          ac.i(this.TAG, "it.lyrics=" + ((brn)localObject1).lyrics + " lyricsText.maxWidth=" + localTextView.getMaxWidth() + " lyricsText.maxHeight=" + localTextView.getMaxHeight() + " parent.measuredWidth=" + ((View)localObject2).getMeasuredWidth() + " parent.measuredHeight=" + ((View)localObject2).getMeasuredHeight());
          localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          ((View)localObject2).draw(new Canvas((Bitmap)localObject1));
          this.wCH = com.tencent.mm.media.editor.a.e.gPs;
          this.wDu.add(localObject1);
          break;
          localg = g.wmx;
          i = g.dur().width();
          break label194;
          i = ((View)localObject2).getMeasuredWidth();
          break label273;
        }
      }
    }
    AppMethodBeat.o(76150);
  }
  
  private final void eX(List<? extends brn> paramList)
  {
    AppMethodBeat.i(76149);
    this.wrj.clear();
    ArrayList localArrayList = this.wrj;
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label98:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (!bs.isNullOrNil(((brn)localObject2).lyrics)) {}
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
    this.wCE.set(paramRect);
    AppMethodBeat.o(76145);
  }
  
  public final com.tencent.mm.media.editor.a.a aqy()
  {
    AppMethodBeat.i(76154);
    if (this.wDu.isEmpty())
    {
      AppMethodBeat.o(76154);
      return null;
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).postConcat(this.ppQ.eY);
    ((Matrix)localObject).postTranslate(-(this.wCE.width() - this.wCD.width()) / 2.0F, -(this.wCE.height() - this.wCD.height()) / 2.0F);
    localObject = (com.tencent.mm.media.editor.a.a)new com.tencent.mm.media.editor.a.l((List)this.wrj, (Matrix)localObject);
    AppMethodBeat.o(76154);
    return localObject;
  }
  
  public final com.tencent.mm.media.editor.a.b c(Matrix paramMatrix)
  {
    AppMethodBeat.i(163471);
    if (this.wDu.isEmpty())
    {
      AppMethodBeat.o(163471);
      return null;
    }
    paramMatrix = new ArrayList();
    Object localObject1 = (Iterable)this.wrj;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        d.a.j.fOc();
      }
      localObject2 = (brn)localObject2;
      if (i < this.wDu.size())
      {
        Object localObject3 = this.wDu.get(i);
        d.g.b.k.g(localObject3, "bitmapList[index]");
        paramMatrix.add(new com.tencent.mm.media.editor.a.j((brn)localObject2, (Bitmap)localObject3));
      }
      i += 1;
    }
    localObject1 = new Matrix();
    ((Matrix)localObject1).postConcat(this.ppQ.eY);
    ((Matrix)localObject1).postTranslate(-(this.wCE.width() - this.wCD.width()) / 2.0F, -(this.wCE.height() - this.wCD.height()) / 2.0F);
    paramMatrix = (com.tencent.mm.media.editor.a.b)new com.tencent.mm.media.editor.a.k((List)paramMatrix, (Matrix)localObject1);
    AppMethodBeat.o(163471);
    return paramMatrix;
  }
  
  public final void eV(List<? extends brn> paramList)
  {
    AppMethodBeat.i(76146);
    d.g.b.k.h(paramList, "lyricsInfo");
    eX(paramList);
    dwW();
    paramList = ((Iterable)this.wDu).iterator();
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
        this.ppQ.width = k;
        this.ppQ.height = i;
        this.wCA.setBounds(0, 0, k, i);
        this.ppQ.l(new float[] { 0.0F, 0.0F, k, 0.0F, 0.0F, i, k, i });
        f2 = this.wCE.height() - ao.fromDPToPix(getContext(), 360) - i;
        i = this.anr;
        paramList = g.wmx;
        if (i < g.dur().left) {
          break label269;
        }
      }
      for (float f1 = this.anr;; f1 = g.dur().left)
      {
        this.ppQ.eY.setTranslate(f1, f2);
        AppMethodBeat.o(76146);
        return;
        paramList = g.wmx;
      }
    }
  }
  
  public final void eW(List<? extends brn> paramList)
  {
    AppMethodBeat.i(76148);
    d.g.b.k.h(paramList, "lyricsInfo");
    eX(paramList);
    dwW();
    this.wCH = com.tencent.mm.media.editor.a.e.gPs;
    AppMethodBeat.o(76148);
  }
  
  public final ArrayList<Bitmap> getBitmapList()
  {
    return this.wDu;
  }
  
  public final float[] getContentBoundary()
  {
    AppMethodBeat.i(76157);
    float[] arrayOfFloat = (float[])this.ppQ.gQu.clone();
    AppMethodBeat.o(76157);
    return arrayOfFloat;
  }
  
  public final int getCurIndex()
  {
    return this.gPA;
  }
  
  public final Rect getDisplayRect()
  {
    return this.wCE;
  }
  
  public final long getDuration()
  {
    return this.duration;
  }
  
  public final ArrayList<brn> getLyricsList()
  {
    return this.wrj;
  }
  
  public final boolean getNeedInvalidate()
  {
    return this.wDv;
  }
  
  public final Paint getPaint()
  {
    return this.paint;
  }
  
  public final Rect getSafeArea()
  {
    AppMethodBeat.i(76156);
    Rect localRect = this.ppQ.gQo;
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
    return this.wCH;
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
    return this.fTe;
  }
  
  public final float getTouchDownY()
  {
    return this.fTf;
  }
  
  public final boolean getTouchMoved()
  {
    return this.fTb;
  }
  
  public final int getTouchSlop()
  {
    return this.qc;
  }
  
  protected final com.tencent.mm.media.editor.c.c getTouchTracker()
  {
    return this.ppQ;
  }
  
  public final b getType()
  {
    return b.wCN;
  }
  
  public final Rect getValidRect()
  {
    return this.wCD;
  }
  
  public final Matrix getViewMatrix()
  {
    return this.wCI;
  }
  
  public final Paint getWavePaint()
  {
    return this.gPS;
  }
  
  public final long getWaveTime()
  {
    return this.gPB;
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
    if (this.wCI != null)
    {
      paramCanvas.setMatrix(this.wCI);
      if (isActivated()) {
        this.wCA.draw(paramCanvas);
      }
      if (this.wrj.isEmpty()) {
        break label486;
      }
      if ((this.gPB != 0L) && (bs.Ap(this.gPB) <= this.gPE)) {
        break label328;
      }
      this.gPB = System.currentTimeMillis();
      f1 = 0.0F;
      localObject1 = this.gPQ;
      i = 0;
      int k = localObject1.length;
      j = 0;
      if (j >= k) {
        break label328;
      }
      localObject2 = localObject1[j];
      f2 = localObject2.height();
      if (f2 > this.gPL) {
        break label282;
      }
      this.gPR[i] = ((float)(this.gPK * Math.random()));
      label155:
      if (f2 > this.gPR[i]) {
        break label309;
      }
    }
    label282:
    label309:
    for (float f2 = Math.min(this.gPO + f2, this.gPK);; f2 = Math.max(f2 - this.gPP, this.gPL))
    {
      float f3 = this.gPM;
      float f4 = this.gPK / 2.0F;
      float f5 = f2 / 2.0F;
      float f6 = this.gPM;
      float f7 = this.gPJ;
      float f8 = this.gPK / 2.0F;
      localObject2.set(f3 + f1, f4 - f5, f1 + f6 + f7, f2 / 2.0F + f8);
      f1 = localObject2.right;
      j += 1;
      i += 1;
      break label108;
      paramCanvas.setMatrix(this.ppQ.eY);
      break;
      if (f2 < this.gPR[i]) {
        break label155;
      }
      this.gPR[i] = this.gPL;
      break label155;
    }
    label328:
    long l1 = ((brn)this.wrj.get(0)).startTime;
    long l2;
    long l3;
    if (this.gPC < 255)
    {
      l2 = this.gPF;
      l3 = this.duration - l1;
      if (0L <= l3) {
        break label452;
      }
      if (this.duration - l1 <= this.gPF) {}
    }
    for (this.gPC = 255;; this.gPC = ((int)((float)(this.duration - l1) * 255.0F / (float)this.gPF)))
    {
      this.gPS.setAlpha(this.gPC);
      localObject1 = this.gPQ;
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        paramCanvas.drawRect(localObject1[i], this.gPS);
        i += 1;
      }
      label452:
      if (l2 < l3) {
        break;
      }
    }
    label486:
    if (!this.wrj.isEmpty())
    {
      this.duration = (System.currentTimeMillis() - this.startTime);
      localObject1 = (brn)d.a.j.C((List)this.wrj, this.gPA + 1);
      if (localObject1 == null) {
        break label836;
      }
      l1 = ((brn)localObject1).startTime;
      if (this.duration >= l1)
      {
        this.gPA += 1;
        if (this.gPA >= this.wrj.size())
        {
          this.gPA = 0;
          this.startTime = System.currentTimeMillis();
          this.duration = 0L;
        }
      }
    }
    label610:
    long l4;
    if (!((Collection)this.wDu).isEmpty())
    {
      i = 1;
      if ((i != 0) && (this.gPA < this.wDu.size())) {
        if (this.gPA < this.wrj.size())
        {
          l2 = ((brn)this.wrj.get(this.gPA)).startTime;
          localObject1 = (brn)d.a.j.C((List)this.wrj, this.gPA + 1);
          if (localObject1 == null) {
            break label869;
          }
          l1 = ((brn)localObject1).startTime;
          label695:
          l3 = this.gPF;
          l4 = this.duration - l2;
          if (0L <= l4) {
            break label896;
          }
          label717:
          l3 = this.gPF;
          l4 = l1 - this.duration;
          if (0L <= l4) {
            break label930;
          }
          label739:
          if ((this.duration - l2 > this.gPF) && (l1 - this.duration > this.gPF)) {
            this.alpha = 255;
          }
        }
      }
    }
    for (;;)
    {
      this.paint.setAlpha(this.alpha);
      paramCanvas.drawBitmap((Bitmap)this.wDu.get(this.gPA), 0.0F, this.gPN, this.paint);
      paramCanvas.restore();
      if (this.wDv) {
        invalidate();
      }
      AppMethodBeat.o(76152);
      return;
      label836:
      l1 = ((brn)this.wrj.get(this.gPA)).startTime + this.gPG;
      break;
      i = 0;
      break label610;
      label869:
      l1 = ((brn)this.wrj.get(this.gPA)).startTime + this.gPG;
      break label695;
      label896:
      if (l3 < l4) {
        break label717;
      }
      this.alpha = ((int)(255.0F * (float)(this.duration - l2) / (float)this.gPF));
      continue;
      label930:
      if (l3 < l4) {
        break label739;
      }
      this.alpha = ((int)((float)(l1 - this.duration) / (float)this.gPF * 255.0F));
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76151);
    d.g.b.k.h(paramMotionEvent, "event");
    this.wDt.set(this.ppQ.eY);
    this.wDt.getValues(this.wDs);
    float f1 = this.wDs[2];
    boolean bool2 = this.ppQ.t(paramMotionEvent);
    this.ppQ.eY.getValues(this.wDs);
    float f2 = this.wDs[5];
    this.ppQ.eY.set(this.wDt);
    this.ppQ.eY.setTranslate(f1, f2);
    Object localObject;
    if (bool2)
    {
      localObject = this.wCB;
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
      this.fTe = paramMotionEvent.getX();
      this.fTf = paramMotionEvent.getY();
      this.fTb = false;
      continue;
      f1 = Math.max(Math.abs(paramMotionEvent.getX() - this.fTe), Math.abs(paramMotionEvent.getY() - this.fTf));
      if (!this.fTb)
      {
        if (f1 > this.qc) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          this.fTb = bool1;
          break;
        }
        if (!this.fTb) {
          performClick();
        }
        paramMotionEvent = new com.tencent.mm.media.editor.c.a();
        localObject = this.wCD;
        paramMotionEvent.aNl = this.ppQ.aNl;
        paramMotionEvent.aNk = this.ppQ.aNk;
        paramMotionEvent.k(new float[] { this.ppQ.width / 2.0F, this.ppQ.height / 2.0F });
        paramMotionEvent.e(new RectF(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom));
        paramMotionEvent.a(this.ppQ.eY, (d.g.a.b)new a(this));
      }
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(76158);
    this.wDv = true;
    invalidate();
    AppMethodBeat.o(76158);
  }
  
  public final void setBitmapList(ArrayList<Bitmap> paramArrayList)
  {
    AppMethodBeat.i(76139);
    d.g.b.k.h(paramArrayList, "<set-?>");
    this.wDu = paramArrayList;
    AppMethodBeat.o(76139);
  }
  
  public final void setCurIndex(int paramInt)
  {
    this.gPA = paramInt;
  }
  
  public final void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public final void setNeedInvalidate(boolean paramBoolean)
  {
    this.wDv = paramBoolean;
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
    this.ppQ.gQo = paramRect;
    this.ppQ.gQp = com.tencent.mm.cc.a.fromDPToPix(getContext(), 54);
    AppMethodBeat.o(76155);
  }
  
  public final void setSourceDataType(com.tencent.mm.media.editor.a.e parame)
  {
    AppMethodBeat.i(76138);
    d.g.b.k.h(parame, "<set-?>");
    this.wCH = parame;
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
    this.wCB = paramb;
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
    this.fTe = paramFloat;
  }
  
  public final void setTouchDownY(float paramFloat)
  {
    this.fTf = paramFloat;
  }
  
  public final void setTouchMoved(boolean paramBoolean)
  {
    this.fTb = paramBoolean;
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(76144);
    d.g.b.k.h(paramRect, "validRect");
    this.wCD.set(paramRect);
    AppMethodBeat.o(76144);
  }
  
  public final void setValidRect(Rect paramRect)
  {
    AppMethodBeat.i(76142);
    d.g.b.k.h(paramRect, "<set-?>");
    this.wCD = paramRect;
    AppMethodBeat.o(76142);
  }
  
  public final void setViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(76143);
    this.wCI = paramMatrix;
    if (paramMatrix != null)
    {
      this.ppQ.setMatrix(paramMatrix);
      Canvas localCanvas = new Canvas();
      localCanvas.save();
      if (this.wCI != null) {
        localCanvas.setMatrix(paramMatrix);
      }
      if (isActivated()) {
        this.wCA.draw(localCanvas);
      }
    }
    AppMethodBeat.o(76143);
  }
  
  public final void setWavePaint(Paint paramPaint)
  {
    AppMethodBeat.i(76141);
    d.g.b.k.h(paramPaint, "<set-?>");
    this.gPS = paramPaint;
    AppMethodBeat.o(76141);
  }
  
  public final void setWaveTime(long paramLong)
  {
    this.gPB = paramLong;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.e
 * JD-Core Version:    0.7.0.1
 */
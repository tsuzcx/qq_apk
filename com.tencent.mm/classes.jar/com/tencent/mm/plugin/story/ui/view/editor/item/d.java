package com.tencent.mm.plugin.story.ui.view.editor.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
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
import com.tencent.mm.media.editor.a.e;
import com.tencent.mm.media.editor.a.h;
import com.tencent.mm.protocal.protobuf.baz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.al;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/editor/item/LyricsItemView;", "Landroid/view/View;", "Lcom/tencent/mm/media/editor/item/IEditable;", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DP_1", "", "LAST_INTERVAL", "", "LYRICS_VERTICAL_OFFSET", "", "MARGIN", "TAG", "", "TRANS_TIME", "WAVE_DECREMENT", "WAVE_INCREMENT", "WAVE_INVALIDAT_INTERVAL", "WAVE_RECT_COUNT", "WAVE_RECT_HEIGHT", "WAVE_RECT_MIN_HEIGHT", "WAVE_RECT_OFFSET", "WAVE_RECT_WIDTH", "alpha", "bitmapList", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "getBitmapList", "()Ljava/util/ArrayList;", "setBitmapList", "(Ljava/util/ArrayList;)V", "curIndex", "getCurIndex", "()I", "setCurIndex", "(I)V", "duration", "getDuration", "()J", "setDuration", "(J)V", "frameDrawable", "Lcom/tencent/mm/media/editor/view/ActiveFrameDrawable;", "lyricsList", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "getLyricsList", "needInvalidate", "", "getNeedInvalidate", "()Z", "setNeedInvalidate", "(Z)V", "originMatrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "setPaint", "(Landroid/graphics/Paint;)V", "sourceDataType", "Lcom/tencent/mm/media/editor/item/EditorDataType;", "getSourceDataType", "()Lcom/tencent/mm/media/editor/item/EditorDataType;", "setSourceDataType", "(Lcom/tencent/mm/media/editor/item/EditorDataType;)V", "startTime", "getStartTime", "setStartTime", "stateResolve", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer$ItemStateResolve;", "text", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textSize", "getTextSize", "()F", "setTextSize", "(F)V", "touchArray", "", "touchDownX", "getTouchDownX", "setTouchDownX", "touchDownY", "getTouchDownY", "setTouchDownY", "touchMoved", "getTouchMoved", "setTouchMoved", "touchSlop", "getTouchSlop", "touchTracker", "Lcom/tencent/mm/media/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/media/editor/touch/TouchTracker;", "validRect", "Landroid/graphics/Rect;", "getValidRect", "()Landroid/graphics/Rect;", "setValidRect", "(Landroid/graphics/Rect;)V", "value", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "waveAlpha", "wavePaint", "getWavePaint", "setWavePaint", "waveRects", "", "Landroid/graphics/RectF;", "[Landroid/graphics/RectF;", "waveTargetHeight", "waveTime", "getWaveTime", "setWaveTime", "createEditorData", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "createLyricsBitmap", "", "drawWave", "canvas", "Landroid/graphics/Canvas;", "fillAlpha", "fillWaveAlpha", "appearTime", "getContentBoundary", "getSafeArea", "nextIndex", "onDraw", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "renderLyrics", "lyricsInfo", "", "reshowLyrics", "resume", "setSafeArea", "safeRect", "damp", "setStateResolve", "setValidArea", "heightPercent", "updateLyricsList", "plugin-story_release"})
public final class d
  extends View
  implements h, c
{
  private final int MARGIN;
  private final String TAG;
  private int alpha;
  private long duration;
  private int eSO;
  private long eSP;
  private int eSQ;
  private final long eSS;
  private final long eST;
  private final long eSU;
  private final int eSV;
  private final int eSW;
  private final float eSX;
  private final float eSY;
  private final int eSZ;
  private final float eTa;
  private final float eTb;
  private final float eTc;
  private final int eTd;
  private final RectF[] eTe;
  private final float[] eTf;
  private Paint eTg;
  private float lAn;
  private float lAo;
  private boolean lAp;
  private final com.tencent.mm.media.editor.c.c lwb;
  private final int nwj;
  private Paint paint;
  private final float[] sQZ;
  private final com.tencent.mm.media.editor.view.a sQp;
  private EditorItemContainer.b sQq;
  private e sQu;
  private Matrix sQv;
  private final Matrix sRa;
  private ArrayList<Bitmap> sRb;
  private Rect sRc;
  public boolean sRd;
  private long startTime;
  private final ArrayList<baz> swq;
  private CharSequence text;
  private float textSize;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(151286);
    this.swq = new ArrayList();
    this.TAG = "MicroMsg.LyricsItemView";
    this.eSS = 50L;
    this.eST = 200L;
    this.eSU = 3000L;
    this.eSV = 11;
    this.eSW = al.fromDPToPix(paramContext, 1);
    this.eSX = (this.eSW * 1.5F);
    this.eSY = (this.eSW * 9.0F);
    this.eSZ = this.eSW;
    this.eTa = (this.eSW * 1.5F);
    this.eTb = (this.eSW * 12.0F);
    this.eTc = (this.eSW * 2.0F);
    this.eTd = this.eSW;
    this.MARGIN = al.fromDPToPix(paramContext, 32);
    int j = this.eSV;
    Object localObject = new RectF[j];
    int i = 0;
    while (i < j)
    {
      localObject[i] = new RectF();
      i += 1;
    }
    this.eTe = ((RectF[])localObject);
    this.eTf = new float[this.eSV];
    this.sQZ = new float[9];
    this.sRa = new Matrix();
    this.lwb = new com.tencent.mm.media.editor.c.c();
    this.textSize = getResources().getDimension(2131428342);
    this.sQu = e.eSG;
    this.sRb = new ArrayList();
    this.paint = new Paint();
    this.eTg = new Paint();
    this.sRc = new Rect();
    this.sRd = true;
    this.lwb.arK = 0.5F;
    this.lwb.arJ = 3.0F;
    this.eTg.setColor(Color.parseColor("#CCFFFFFF"));
    localObject = getResources();
    a.f.b.j.p(localObject, "resources");
    this.sQp = new com.tencent.mm.media.editor.view.a((Resources)localObject);
    paramContext = ViewConfiguration.get(paramContext);
    a.f.b.j.p(paramContext, "ViewConfiguration.get(context)");
    this.nwj = paramContext.getScaledTouchSlop();
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(151286);
  }
  
  private final void cFT()
  {
    AppMethodBeat.i(151278);
    Iterator localIterator = ((Iterable)this.swq).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (baz)localIterator.next();
      if (!bo.isNullOrNil(((baz)localObject1).xqi))
      {
        Object localObject2 = new LinearLayout(getContext());
        localObject2 = LayoutInflater.from(getContext()).inflate(2130970947, (ViewGroup)localObject2, false);
        TextView localTextView = (TextView)((View)localObject2).findViewById(2131828395);
        a.f.b.j.p(localTextView, "lyricsText");
        com.tencent.mm.ab.b.e(localTextView);
        localTextView.setText((CharSequence)((baz)localObject1).xqi);
        com.tencent.mm.plugin.story.f.k localk = com.tencent.mm.plugin.story.f.k.sCp;
        localTextView.setMaxHeight(com.tencent.mm.plugin.story.f.k.cCr().height());
        int i = this.MARGIN;
        localk = com.tencent.mm.plugin.story.f.k.sCp;
        if (i >= com.tencent.mm.plugin.story.f.k.cCr().left)
        {
          localk = com.tencent.mm.plugin.story.f.k.sCp;
          i = com.tencent.mm.plugin.story.f.k.cCr().width();
          j = this.MARGIN;
          localk = com.tencent.mm.plugin.story.f.k.sCp;
          i -= (j - com.tencent.mm.plugin.story.f.k.cCr().left) * 2;
          label194:
          localTextView.setMaxWidth(i);
          ((View)localObject2).measure(0, 0);
          a.f.b.j.p(localObject2, "parent");
          ((View)localObject2).layout(0, 0, ((View)localObject2).getMeasuredWidth(), ((View)localObject2).getMeasuredHeight());
          if (((View)localObject2).getMeasuredWidth() > 0)
          {
            i = ((View)localObject2).getMeasuredWidth();
            localk = com.tencent.mm.plugin.story.f.k.sCp;
            if (i <= com.tencent.mm.plugin.story.f.k.cCr().width()) {
              break label457;
            }
          }
          localk = com.tencent.mm.plugin.story.f.k.sCp;
          i = com.tencent.mm.plugin.story.f.k.cCr().width();
          label273:
          if (((View)localObject2).getMeasuredHeight() > 0)
          {
            j = ((View)localObject2).getMeasuredHeight();
            localk = com.tencent.mm.plugin.story.f.k.sCp;
            if (j <= com.tencent.mm.plugin.story.f.k.cCr().height()) {
              break label466;
            }
          }
          localk = com.tencent.mm.plugin.story.f.k.sCp;
        }
        label457:
        label466:
        for (int j = com.tencent.mm.plugin.story.f.k.cCr().height();; j = ((View)localObject2).getMeasuredHeight())
        {
          ab.i(this.TAG, "it.lyrics=" + ((baz)localObject1).xqi + " lyricsText.maxWidth=" + localTextView.getMaxWidth() + " lyricsText.maxHeight=" + localTextView.getMaxHeight() + " parent.measuredWidth=" + ((View)localObject2).getMeasuredWidth() + " parent.measuredHeight=" + ((View)localObject2).getMeasuredHeight());
          localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          ((View)localObject2).draw(new Canvas((Bitmap)localObject1));
          this.sQu = e.eSG;
          this.sRb.add(localObject1);
          break;
          localk = com.tencent.mm.plugin.story.f.k.sCp;
          i = com.tencent.mm.plugin.story.f.k.cCr().width();
          break label194;
          i = ((View)localObject2).getMeasuredWidth();
          break label273;
        }
      }
    }
    AppMethodBeat.o(151278);
  }
  
  private final void dN(List<? extends baz> paramList)
  {
    AppMethodBeat.i(151277);
    this.swq.clear();
    ArrayList localArrayList = this.swq;
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label98:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (!bo.isNullOrNil(((baz)localObject2).xqi)) {}
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
    AppMethodBeat.o(151277);
  }
  
  public final com.tencent.mm.media.editor.a.b UH()
  {
    AppMethodBeat.i(151281);
    if (this.sRb.isEmpty())
    {
      AppMethodBeat.o(151281);
      return null;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = (Iterable)this.swq;
    int i = 0;
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        a.a.j.eaS();
      }
      localObject3 = (baz)localObject3;
      if (i < this.sRb.size())
      {
        Object localObject4 = this.sRb.get(i);
        a.f.b.j.p(localObject4, "bitmapList[index]");
        ((ArrayList)localObject1).add(new com.tencent.mm.media.editor.a.j((baz)localObject3, (Bitmap)localObject4));
      }
      i += 1;
    }
    localObject1 = (com.tencent.mm.media.editor.a.b)new com.tencent.mm.media.editor.a.k((List)localObject1, this.lwb.asO);
    AppMethodBeat.o(151281);
    return localObject1;
  }
  
  public final com.tencent.mm.media.editor.a.a UI()
  {
    AppMethodBeat.i(151282);
    if (this.sRb.isEmpty())
    {
      AppMethodBeat.o(151282);
      return null;
    }
    com.tencent.mm.media.editor.a.a locala = (com.tencent.mm.media.editor.a.a)new com.tencent.mm.media.editor.a.l((List)this.swq, this.lwb.asO);
    AppMethodBeat.o(151282);
    return locala;
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(151273);
    a.f.b.j.q(paramRect, "validRect");
    this.sRc = paramRect;
    AppMethodBeat.o(151273);
  }
  
  public final void dL(List<? extends baz> paramList)
  {
    AppMethodBeat.i(151274);
    a.f.b.j.q(paramList, "lyricsInfo");
    dN(paramList);
    cFT();
    paramList = ((Iterable)this.sRb).iterator();
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
        this.lwb.width = k;
        this.lwb.height = i;
        this.sQp.setBounds(0, 0, k, i);
        this.lwb.h(new float[] { 0.0F, 0.0F, k, 0.0F, 0.0F, i, k, i });
        f2 = this.sRc.height() - al.fromDPToPix(getContext(), 360) - i;
        i = this.MARGIN;
        paramList = com.tencent.mm.plugin.story.f.k.sCp;
        if (i < com.tencent.mm.plugin.story.f.k.cCr().left) {
          break label269;
        }
      }
      for (float f1 = this.MARGIN;; f1 = com.tencent.mm.plugin.story.f.k.cCr().left)
      {
        this.lwb.asO.setTranslate(f1, f2);
        AppMethodBeat.o(151274);
        return;
        paramList = com.tencent.mm.plugin.story.f.k.sCp;
      }
    }
  }
  
  public final void dM(List<? extends baz> paramList)
  {
    AppMethodBeat.i(151276);
    a.f.b.j.q(paramList, "lyricsInfo");
    dN(paramList);
    cFT();
    this.sQu = e.eSG;
    AppMethodBeat.o(151276);
  }
  
  public final ArrayList<Bitmap> getBitmapList()
  {
    return this.sRb;
  }
  
  public final float[] getContentBoundary()
  {
    AppMethodBeat.i(151285);
    float[] arrayOfFloat = (float[])this.lwb.eTI.clone();
    AppMethodBeat.o(151285);
    return arrayOfFloat;
  }
  
  public final int getCurIndex()
  {
    return this.eSO;
  }
  
  public final long getDuration()
  {
    return this.duration;
  }
  
  public final ArrayList<baz> getLyricsList()
  {
    return this.swq;
  }
  
  public final boolean getNeedInvalidate()
  {
    return this.sRd;
  }
  
  public final Paint getPaint()
  {
    return this.paint;
  }
  
  public final Rect getSafeArea()
  {
    AppMethodBeat.i(151284);
    Rect localRect = this.lwb.eTC;
    Object localObject = localRect;
    if (localRect == null)
    {
      localObject = getResources();
      a.f.b.j.p(localObject, "resources");
      int i = ((Resources)localObject).getDisplayMetrics().widthPixels;
      localObject = getResources();
      a.f.b.j.p(localObject, "resources");
      localObject = new Rect(0, 0, i, ((Resources)localObject).getDisplayMetrics().heightPixels);
    }
    AppMethodBeat.o(151284);
    return localObject;
  }
  
  public final e getSourceDataType()
  {
    return this.sQu;
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
    return this.lAn;
  }
  
  public final float getTouchDownY()
  {
    return this.lAo;
  }
  
  public final boolean getTouchMoved()
  {
    return this.lAp;
  }
  
  public final int getTouchSlop()
  {
    return this.nwj;
  }
  
  protected final com.tencent.mm.media.editor.c.c getTouchTracker()
  {
    return this.lwb;
  }
  
  public final Rect getValidRect()
  {
    return this.sRc;
  }
  
  public final Matrix getViewMatrix()
  {
    return this.sQv;
  }
  
  public final Paint getWavePaint()
  {
    return this.eTg;
  }
  
  public final long getWaveTime()
  {
    return this.eSP;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(151280);
    a.f.b.j.q(paramCanvas, "canvas");
    paramCanvas.save();
    Object localObject1;
    int i;
    int j;
    float f1;
    label108:
    Object localObject2;
    if (this.sQv != null)
    {
      paramCanvas.setMatrix(this.sQv);
      if (isActivated()) {
        this.sQp.draw(paramCanvas);
      }
      if (this.swq.isEmpty()) {
        break label486;
      }
      if ((this.eSP != 0L) && (bo.hl(this.eSP) <= this.eSS)) {
        break label328;
      }
      this.eSP = System.currentTimeMillis();
      localObject1 = this.eTe;
      i = 0;
      int k = localObject1.length;
      j = 0;
      f1 = 0.0F;
      if (j >= k) {
        break label328;
      }
      localObject2 = localObject1[j];
      f2 = localObject2.height();
      if (f2 > this.eSZ) {
        break label282;
      }
      this.eTf[i] = ((float)(this.eSY * Math.random()));
      label155:
      if (f2 > this.eTf[i]) {
        break label309;
      }
    }
    label282:
    label309:
    for (float f2 = Math.min(f2 + this.eTc, this.eSY);; f2 = Math.max(f2 - this.eTd, this.eSZ))
    {
      float f3 = this.eTa;
      float f4 = this.eSY / 2.0F;
      float f5 = f2 / 2.0F;
      float f6 = this.eTa;
      float f7 = this.eSX;
      float f8 = this.eSY / 2.0F;
      localObject2.set(f3 + f1, f4 - f5, f1 + f6 + f7, f2 / 2.0F + f8);
      f1 = localObject2.right;
      j += 1;
      i += 1;
      break label108;
      paramCanvas.setMatrix(this.lwb.asO);
      break;
      if (f2 < this.eTf[i]) {
        break label155;
      }
      this.eTf[i] = this.eSZ;
      break label155;
    }
    label328:
    long l1 = ((baz)this.swq.get(0)).startTime;
    long l2;
    long l3;
    if (this.eSQ < 255)
    {
      l2 = this.eST;
      l3 = this.duration - l1;
      if (0L <= l3) {
        break label452;
      }
      if (this.duration - l1 <= this.eST) {}
    }
    for (this.eSQ = 255;; this.eSQ = ((int)((float)(this.duration - l1) * 255.0F / (float)this.eST)))
    {
      this.eTg.setAlpha(this.eSQ);
      localObject1 = this.eTe;
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        paramCanvas.drawRect(localObject1[i], this.eTg);
        i += 1;
      }
      label452:
      if (l2 < l3) {
        break;
      }
    }
    label486:
    if (!this.swq.isEmpty())
    {
      this.duration = (System.currentTimeMillis() - this.startTime);
      localObject1 = (baz)a.a.j.w((List)this.swq, this.eSO + 1);
      if (localObject1 == null) {
        break label836;
      }
      l1 = ((baz)localObject1).startTime;
      if (this.duration >= l1)
      {
        this.eSO += 1;
        if (this.eSO >= this.swq.size())
        {
          this.eSO = 0;
          this.startTime = System.currentTimeMillis();
          this.duration = 0L;
        }
      }
    }
    label610:
    long l4;
    if (!((Collection)this.sRb).isEmpty())
    {
      i = 1;
      if ((i != 0) && (this.eSO < this.sRb.size())) {
        if (this.eSO < this.swq.size())
        {
          l2 = ((baz)this.swq.get(this.eSO)).startTime;
          localObject1 = (baz)a.a.j.w((List)this.swq, this.eSO + 1);
          if (localObject1 == null) {
            break label869;
          }
          l1 = ((baz)localObject1).startTime;
          label695:
          l3 = this.eST;
          l4 = this.duration - l2;
          if (0L <= l4) {
            break label896;
          }
          label717:
          l3 = this.eST;
          l4 = l1 - this.duration;
          if (0L <= l4) {
            break label930;
          }
          label739:
          if ((this.duration - l2 > this.eST) && (l1 - this.duration > this.eST)) {
            this.alpha = 255;
          }
        }
      }
    }
    for (;;)
    {
      this.paint.setAlpha(this.alpha);
      paramCanvas.drawBitmap((Bitmap)this.sRb.get(this.eSO), 0.0F, this.eTb, this.paint);
      paramCanvas.restore();
      if (this.sRd) {
        invalidate();
      }
      AppMethodBeat.o(151280);
      return;
      label836:
      l1 = ((baz)this.swq.get(this.eSO)).startTime + this.eSU;
      break;
      i = 0;
      break label610;
      label869:
      l1 = ((baz)this.swq.get(this.eSO)).startTime + this.eSU;
      break label695;
      label896:
      if (l3 < l4) {
        break label717;
      }
      this.alpha = ((int)(255.0F * (float)(this.duration - l2) / (float)this.eST));
      continue;
      label930:
      if (l3 < l4) {
        break label739;
      }
      this.alpha = ((int)((float)(l1 - this.duration) / (float)this.eST * 255.0F));
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(151279);
    a.f.b.j.q(paramMotionEvent, "event");
    this.sRa.set(this.lwb.asO);
    this.sRa.getValues(this.sQZ);
    float f1 = this.sQZ[2];
    boolean bool2 = this.lwb.u(paramMotionEvent);
    this.lwb.asO.getValues(this.sQZ);
    float f2 = this.sQZ[5];
    this.lwb.asO.set(this.sRa);
    this.lwb.asO.setTranslate(f1, f2);
    if (bool2)
    {
      EditorItemContainer.b localb = this.sQq;
      if (localb != null) {
        localb.e((View)this, paramMotionEvent);
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
      AppMethodBeat.o(151279);
      return bool2;
      this.lAn = paramMotionEvent.getX();
      this.lAo = paramMotionEvent.getY();
      this.lAp = false;
      continue;
      f1 = Math.max(Math.abs(paramMotionEvent.getX() - this.lAn), Math.abs(paramMotionEvent.getY() - this.lAo));
      if (!this.lAp)
      {
        if (f1 > this.nwj) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          this.lAp = bool1;
          break;
        }
        if (!this.lAp) {
          performClick();
        }
      }
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(156044);
    this.sRd = true;
    invalidate();
    AppMethodBeat.o(156044);
  }
  
  public final void setBitmapList(ArrayList<Bitmap> paramArrayList)
  {
    AppMethodBeat.i(151268);
    a.f.b.j.q(paramArrayList, "<set-?>");
    this.sRb = paramArrayList;
    AppMethodBeat.o(151268);
  }
  
  public final void setCurIndex(int paramInt)
  {
    this.eSO = paramInt;
  }
  
  public final void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public final void setNeedInvalidate(boolean paramBoolean)
  {
    this.sRd = paramBoolean;
  }
  
  public final void setPaint(Paint paramPaint)
  {
    AppMethodBeat.i(151269);
    a.f.b.j.q(paramPaint, "<set-?>");
    this.paint = paramPaint;
    AppMethodBeat.o(151269);
  }
  
  public final void setSafeArea$27eda001(Rect paramRect)
  {
    AppMethodBeat.i(151283);
    a.f.b.j.q(paramRect, "safeRect");
    this.lwb.eTC = paramRect;
    this.lwb.eTD = com.tencent.mm.cb.a.fromDPToPix(getContext(), 54);
    AppMethodBeat.o(151283);
  }
  
  public final void setSourceDataType(e parame)
  {
    AppMethodBeat.i(151267);
    a.f.b.j.q(parame, "<set-?>");
    this.sQu = parame;
    AppMethodBeat.o(151267);
  }
  
  public final void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(151275);
    a.f.b.j.q(paramb, "stateResolve");
    this.sQq = paramb;
    AppMethodBeat.o(151275);
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
    this.lAn = paramFloat;
  }
  
  public final void setTouchDownY(float paramFloat)
  {
    this.lAo = paramFloat;
  }
  
  public final void setTouchMoved(boolean paramBoolean)
  {
    this.lAp = paramBoolean;
  }
  
  public final void setValidRect(Rect paramRect)
  {
    AppMethodBeat.i(151271);
    a.f.b.j.q(paramRect, "<set-?>");
    this.sRc = paramRect;
    AppMethodBeat.o(151271);
  }
  
  public final void setViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(151272);
    this.sQv = paramMatrix;
    if (paramMatrix != null)
    {
      this.lwb.setMatrix(paramMatrix);
      Canvas localCanvas = new Canvas();
      localCanvas.save();
      if (this.sQv != null) {
        localCanvas.setMatrix(paramMatrix);
      }
      if (isActivated()) {
        this.sQp.draw(localCanvas);
      }
    }
    AppMethodBeat.o(151272);
  }
  
  public final void setWavePaint(Paint paramPaint)
  {
    AppMethodBeat.i(151270);
    a.f.b.j.q(paramPaint, "<set-?>");
    this.eTg = paramPaint;
    AppMethodBeat.o(151270);
  }
  
  public final void setWaveTime(long paramLong)
  {
    this.eSP = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.item.d
 * JD-Core Version:    0.7.0.1
 */
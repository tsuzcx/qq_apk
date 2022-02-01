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
import com.tencent.mm.plugin.recordvideo.b.c;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a.g;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.c.a;
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DP_1", "", "LAST_INTERVAL", "", "getLAST_INTERVAL", "()J", "LYRICS_VERTICAL_OFFSET", "", "getLYRICS_VERTICAL_OFFSET", "()F", "MARGIN", "TAG", "", "TRANS_TIME", "getTRANS_TIME", "WAVE_DECREMENT", "WAVE_INCREMENT", "WAVE_INVALIDAT_INTERVAL", "WAVE_RECT_COUNT", "WAVE_RECT_HEIGHT", "WAVE_RECT_MIN_HEIGHT", "WAVE_RECT_OFFSET", "WAVE_RECT_WIDTH", "alpha", "getAlpha", "()I", "setAlpha", "(I)V", "bitmapList", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "getBitmapList", "()Ljava/util/ArrayList;", "setBitmapList", "(Ljava/util/ArrayList;)V", "curIndex", "getCurIndex", "setCurIndex", "displayRect", "Landroid/graphics/Rect;", "getDisplayRect", "()Landroid/graphics/Rect;", "duration", "getDuration", "setDuration", "(J)V", "frameDrawable", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "getFrameDrawable", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "lyricsItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem;", "getLyricsItem", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem;", "setLyricsItem", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem;)V", "lyricsList", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "getLyricsList", "needInvalidate", "", "getNeedInvalidate", "()Z", "setNeedInvalidate", "(Z)V", "originMatrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "setPaint", "(Landroid/graphics/Paint;)V", "sourceDataType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "getSourceDataType", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "setSourceDataType", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;)V", "startTime", "getStartTime", "setStartTime", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "text", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textSize", "getTextSize", "setTextSize", "(F)V", "touchArray", "", "touchDownX", "getTouchDownX", "setTouchDownX", "touchDownY", "getTouchDownY", "setTouchDownY", "touchMoved", "getTouchMoved", "setTouchMoved", "touchSlop", "getTouchSlop", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validRect", "getValidRect", "setValidRect", "(Landroid/graphics/Rect;)V", "value", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "waveAlpha", "getWaveAlpha", "setWaveAlpha", "wavePaint", "getWavePaint", "setWavePaint", "waveRects", "", "Landroid/graphics/RectF;", "[Landroid/graphics/RectF;", "waveTargetHeight", "waveTime", "getWaveTime", "setWaveTime", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "createLyricsBitmap", "", "drawWave", "canvas", "Landroid/graphics/Canvas;", "fillAlpha", "fillWaveAlpha", "appearTime", "getContentBoundary", "getDrawRect", "getEditorData", "getLyricsEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorItem;", "item", "getSafeArea", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "nextIndex", "onDraw", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "renderLyrics", "lyricsInfo", "", "reshowLyrics", "resume", "setDefaultLocation", "heightPercent", "setSafeArea", "safeRect", "damp", "setStateResolve", "setValidArea", "updateLyricsList", "plugin-recordvideo_release"})
public class n
  extends View
  implements h, com.tencent.mm.plugin.recordvideo.ui.editor.view.c
{
  private final ArrayList<ctg> HLD;
  private Rect HXd;
  private final Rect HXe;
  private EditorItemContainer.b HXf;
  private final int IaA;
  private final float IaB;
  private final float IaC;
  private final RectF[] IaE;
  private final float[] IaF;
  private final float Iax;
  private final int Iay;
  private final float Iaz;
  private Matrix IbA;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.view.a Ibu;
  private d Ibz;
  private long IcA;
  private int IcB;
  private final long IcC;
  private final long IcD;
  private final long IcE;
  private final int IcF;
  private final float IcG;
  private final float[] IcH;
  private final Matrix IcI;
  private ArrayList<Bitmap> IcJ;
  private Paint IcK;
  public boolean IcL;
  private m IcM;
  private CharSequence LV;
  private final String TAG;
  private final int YY;
  private int alpha;
  private final int bvH;
  private long duration;
  private boolean jKV;
  private float jKY;
  private float jKZ;
  private Paint paint;
  private long startTime;
  private final int tBj;
  private float textSize;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c uWz;
  private int wzx;
  
  public n(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76159);
    this.HLD = new ArrayList();
    this.TAG = "MicroMsg.LyricsItemView";
    this.IcC = 50L;
    this.IcD = 200L;
    this.IcE = 3000L;
    this.IcF = 11;
    this.tBj = aw.fromDPToPix(paramContext, 1);
    this.Iax = (this.tBj * 1.5F);
    this.IaC = (this.tBj * 9.0F);
    this.Iay = this.tBj;
    this.IaB = (this.tBj * 1.5F);
    this.IcG = (this.tBj * 12.0F);
    this.Iaz = (this.tBj * 2.0F);
    this.IaA = this.tBj;
    this.YY = aw.fromDPToPix(paramContext, 32);
    int j = this.IcF;
    Object localObject = new RectF[j];
    int i = 0;
    while (i < j)
    {
      localObject[i] = new RectF();
      i += 1;
    }
    this.IaE = ((RectF[])localObject);
    this.IaF = new float[this.IcF];
    this.IcH = new float[9];
    this.IcI = new Matrix();
    this.uWz = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    this.textSize = getResources().getDimension(b.c.editor_text_item_text_size);
    this.Ibz = d.IbK;
    this.IcJ = new ArrayList();
    this.paint = new Paint();
    this.IcK = new Paint();
    this.HXd = new Rect(0, 0, ax.au(MMApplicationContext.getContext()).x, ax.au(MMApplicationContext.getContext()).y);
    this.HXe = new Rect(0, 0, ax.au(MMApplicationContext.getContext()).x, ax.au(MMApplicationContext.getContext()).y);
    this.IcL = true;
    this.uWz.aGO = 0.5F;
    this.uWz.aGN = 3.0F;
    this.IcK.setColor(Color.parseColor("#CCFFFFFF"));
    localObject = getResources();
    p.j(localObject, "resources");
    this.Ibu = new com.tencent.mm.plugin.recordvideo.ui.editor.view.a((Resources)localObject);
    paramContext = ViewConfiguration.get(paramContext);
    p.j(paramContext, "ViewConfiguration.get(context)");
    this.bvH = paramContext.getScaledTouchSlop();
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(76159);
  }
  
  private final void fyR()
  {
    AppMethodBeat.i(76150);
    Iterator localIterator = ((Iterable)this.HLD).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (ctg)localIterator.next();
      if (!Util.isNullOrNil(((ctg)localObject1).lyrics))
      {
        Object localObject2 = new LinearLayout(getContext());
        localObject2 = LayoutInflater.from(getContext()).inflate(b.f.story_editor_item_lyrics, (ViewGroup)localObject2, false);
        TextView localTextView = (TextView)((View)localObject2).findViewById(b.e.story_item_lyric_content);
        p.j(localTextView, "lyricsText");
        com.tencent.mm.ae.d.g(localTextView);
        localTextView.setText((CharSequence)((ctg)localObject1).lyrics);
        e locale = e.HGz;
        localTextView.setMaxHeight(e.fuV().height());
        int i = this.YY;
        locale = e.HGz;
        if (i >= e.fuV().left)
        {
          locale = e.HGz;
          i = e.fuV().width();
          j = this.YY;
          locale = e.HGz;
          i -= (j - e.fuV().left) * 2;
          label194:
          localTextView.setMaxWidth(i);
          ((View)localObject2).measure(0, 0);
          p.j(localObject2, "parent");
          ((View)localObject2).layout(0, 0, ((View)localObject2).getMeasuredWidth(), ((View)localObject2).getMeasuredHeight());
          if (((View)localObject2).getMeasuredWidth() > 0)
          {
            i = ((View)localObject2).getMeasuredWidth();
            locale = e.HGz;
            if (i <= e.fuV().width()) {
              break label457;
            }
          }
          locale = e.HGz;
          i = e.fuV().width();
          label273:
          if (((View)localObject2).getMeasuredHeight() > 0)
          {
            j = ((View)localObject2).getMeasuredHeight();
            locale = e.HGz;
            if (j <= e.fuV().height()) {
              break label466;
            }
          }
          locale = e.HGz;
        }
        label457:
        label466:
        for (int j = e.fuV().height();; j = ((View)localObject2).getMeasuredHeight())
        {
          Log.i(this.TAG, "it.lyrics=" + ((ctg)localObject1).lyrics + " lyricsText.maxWidth=" + localTextView.getMaxWidth() + " lyricsText.maxHeight=" + localTextView.getMaxHeight() + " parent.measuredWidth=" + ((View)localObject2).getMeasuredWidth() + " parent.measuredHeight=" + ((View)localObject2).getMeasuredHeight());
          localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          ((View)localObject2).draw(new Canvas((Bitmap)localObject1));
          this.Ibz = d.IbK;
          this.IcJ.add(localObject1);
          break;
          locale = e.HGz;
          i = e.fuV().width();
          break label194;
          i = ((View)localObject2).getMeasuredWidth();
          break label273;
        }
      }
    }
    AppMethodBeat.o(76150);
  }
  
  private final void gT(List<? extends ctg> paramList)
  {
    AppMethodBeat.i(76149);
    this.HLD.clear();
    ArrayList localArrayList = this.HLD;
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label98:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (!Util.isNullOrNil(((ctg)localObject2).lyrics)) {}
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
  
  public boolean PA(long paramLong)
  {
    AppMethodBeat.i(219310);
    boolean bool = c.a.a(this, paramLong);
    AppMethodBeat.o(219310);
    return bool;
  }
  
  protected void PC(long paramLong)
  {
    long l1;
    long l2;
    if (this.IcB < 255)
    {
      l1 = this.IcD;
      l2 = this.duration - paramLong;
      if (0L <= l2) {
        break label52;
      }
    }
    label52:
    while (l1 < l2)
    {
      if (this.duration - paramLong > this.IcD) {
        this.IcB = 255;
      }
      return;
    }
    this.IcB = ((int)(255.0F * (float)(this.duration - paramLong) / (float)this.IcD));
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(76145);
    p.k(paramRect, "displayRect");
    this.HXe.set(paramRect);
    AppMethodBeat.o(76145);
  }
  
  public final boolean aWf(String paramString)
  {
    AppMethodBeat.i(219311);
    p.k(paramString, "objID");
    boolean bool = c.a.a(this, paramString);
    AppMethodBeat.o(219311);
    return bool;
  }
  
  public com.tencent.mm.plugin.recordvideo.ui.editor.item.a.h b(m paramm)
  {
    AppMethodBeat.i(219297);
    p.k(paramm, "item");
    gS((List)paramm.Icx);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (Iterable)this.HLD;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.iBO();
      }
      localObject2 = (ctg)localObject2;
      Object localObject3 = this.IcJ.get(i);
      p.j(localObject3, "bitmapList[index]");
      localArrayList.add(new g((ctg)localObject2, (Bitmap)localObject3));
      i += 1;
    }
    paramm = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.h((List)localArrayList, paramm.aHZ);
    AppMethodBeat.o(219297);
    return paramm;
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(219299);
    p.k(paramRect, "safeRect");
    this.uWz.HGw = paramRect;
    this.uWz.IdR = com.tencent.mm.ci.a.fromDPToPix(getContext(), 54);
    AppMethodBeat.o(219299);
  }
  
  public com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    AppMethodBeat.i(219291);
    if (this.IcJ.isEmpty())
    {
      AppMethodBeat.o(219291);
      return null;
    }
    paramMatrix = new ArrayList();
    Object localObject1 = (Iterable)this.HLD;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.iBO();
      }
      localObject2 = (ctg)localObject2;
      if (i < this.IcJ.size())
      {
        Object localObject3 = this.IcJ.get(i);
        p.j(localObject3, "bitmapList[index]");
        paramMatrix.add(new g((ctg)localObject2, (Bitmap)localObject3));
      }
      i += 1;
    }
    localObject1 = new Matrix();
    ((Matrix)localObject1).postConcat(this.uWz.aHZ);
    paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.h((List)paramMatrix, (Matrix)localObject1);
    AppMethodBeat.o(219291);
    return paramMatrix;
  }
  
  public final void c(m paramm)
  {
    AppMethodBeat.i(219252);
    p.k(paramm, "item");
    this.IcM = paramm;
    setViewMatrix(paramm.aHZ);
    gT((List)paramm.Icx);
    fyR();
    this.Ibz = d.IbK;
    AppMethodBeat.o(219252);
  }
  
  public final a cYy()
  {
    AppMethodBeat.i(219293);
    if (this.IcJ.isEmpty())
    {
      AppMethodBeat.o(219293);
      return null;
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).postConcat(this.uWz.aHZ);
    localObject = (a)new m((List)this.HLD, (Matrix)localObject);
    AppMethodBeat.o(219293);
    return localObject;
  }
  
  protected void fyL()
  {
    AppMethodBeat.i(219262);
    long l2;
    long l1;
    long l3;
    long l4;
    if (this.wzx < this.HLD.size())
    {
      l2 = ((ctg)this.HLD.get(this.wzx)).startTime;
      ctg localctg = (ctg)j.M((List)this.HLD, this.wzx + 1);
      if (localctg == null) {
        break label154;
      }
      l1 = localctg.startTime;
      l3 = this.IcD;
      l4 = this.duration - l2;
      if (0L <= l4) {
        break label180;
      }
      label91:
      l3 = this.IcD;
      l4 = l1 - this.duration;
      if (0L <= l4) {
        break label217;
      }
    }
    label154:
    label180:
    label217:
    while (l3 < l4)
    {
      if ((this.duration - l2 > this.IcD) && (l1 - this.duration > this.IcD)) {
        this.alpha = 255;
      }
      AppMethodBeat.o(219262);
      return;
      l1 = ((ctg)this.HLD.get(this.wzx)).startTime + this.IcE;
      break;
      if (l3 < l4) {
        break label91;
      }
      this.alpha = ((int)((float)(this.duration - l2) * 255.0F / (float)this.IcD));
      AppMethodBeat.o(219262);
      return;
    }
    this.alpha = ((int)((float)(l1 - this.duration) / (float)this.IcD * 255.0F));
    AppMethodBeat.o(219262);
  }
  
  protected void fyM()
  {
    AppMethodBeat.i(219270);
    if (this.HLD.isEmpty())
    {
      AppMethodBeat.o(219270);
      return;
    }
    this.duration = (System.currentTimeMillis() - this.startTime);
    ctg localctg = (ctg)j.M((List)this.HLD, this.wzx + 1);
    if (localctg != null) {}
    for (long l = localctg.startTime;; l = ((ctg)this.HLD.get(this.wzx)).startTime + this.IcE)
    {
      if (this.duration >= l)
      {
        this.wzx += 1;
        if (this.wzx >= this.HLD.size())
        {
          this.wzx = 0;
          this.startTime = System.currentTimeMillis();
          this.duration = 0L;
        }
      }
      AppMethodBeat.o(219270);
      return;
    }
  }
  
  public final boolean fyf()
  {
    return true;
  }
  
  public final void gS(List<? extends ctg> paramList)
  {
    AppMethodBeat.i(76146);
    p.k(paramList, "lyricsInfo");
    gT(paramList);
    fyR();
    paramList = ((Iterable)this.IcJ).iterator();
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
        this.uWz.width = k;
        this.uWz.height = i;
        this.Ibu.setBounds(0, 0, k, i);
        this.uWz.p(new float[] { 0.0F, 0.0F, k, 0.0F, 0.0F, i, k, i });
        f2 = this.HXe.height() - aw.fromDPToPix(getContext(), 360) - i;
        i = this.YY;
        paramList = e.HGz;
        if (i < e.fuV().left) {
          break label269;
        }
      }
      for (float f1 = this.YY;; f1 = e.fuV().left)
      {
        this.uWz.aHZ.setTranslate(f1, f2);
        AppMethodBeat.o(76146);
        return;
        paramList = e.HGz;
      }
    }
  }
  
  protected final int getAlpha()
  {
    return this.alpha;
  }
  
  public final ArrayList<Bitmap> getBitmapList()
  {
    return this.IcJ;
  }
  
  public float[] getContentBoundary()
  {
    AppMethodBeat.i(76157);
    float[] arrayOfFloat = (float[])this.uWz.IdW.clone();
    AppMethodBeat.o(76157);
    return arrayOfFloat;
  }
  
  public final int getCurIndex()
  {
    return this.wzx;
  }
  
  public final Rect getDisplayRect()
  {
    return this.HXe;
  }
  
  public RectF getDrawRect()
  {
    AppMethodBeat.i(219303);
    RectF localRectF = new RectF(this.uWz.IdW[0], this.uWz.IdW[1], this.uWz.IdW[2], this.uWz.IdW[3]);
    AppMethodBeat.o(219303);
    return localRectF;
  }
  
  public final long getDuration()
  {
    return this.duration;
  }
  
  public a getEditorData()
  {
    return (a)this.IcM;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.ui.editor.view.a getFrameDrawable()
  {
    return this.Ibu;
  }
  
  protected final long getLAST_INTERVAL()
  {
    return this.IcE;
  }
  
  protected final float getLYRICS_VERTICAL_OFFSET()
  {
    return this.IcG;
  }
  
  protected final m getLyricsItem()
  {
    return this.IcM;
  }
  
  public final ArrayList<ctg> getLyricsList()
  {
    return this.HLD;
  }
  
  public final boolean getNeedInvalidate()
  {
    return this.IcL;
  }
  
  public final Paint getPaint()
  {
    return this.paint;
  }
  
  public Rect getSafeArea()
  {
    AppMethodBeat.i(76156);
    Rect localRect = this.uWz.HGw;
    Object localObject = localRect;
    if (localRect == null)
    {
      localObject = getResources();
      p.j(localObject, "resources");
      int i = ((Resources)localObject).getDisplayMetrics().widthPixels;
      localObject = getResources();
      p.j(localObject, "resources");
      localObject = new Rect(0, 0, i, ((Resources)localObject).getDisplayMetrics().heightPixels);
    }
    AppMethodBeat.o(76156);
    return localObject;
  }
  
  public final d getSourceDataType()
  {
    return this.Ibz;
  }
  
  public final long getStartTime()
  {
    return this.startTime;
  }
  
  protected final long getTRANS_TIME()
  {
    return this.IcD;
  }
  
  public final CharSequence getText()
  {
    return this.LV;
  }
  
  public final float getTextSize()
  {
    return this.textSize;
  }
  
  public final float getTouchDownX()
  {
    return this.jKY;
  }
  
  public final float getTouchDownY()
  {
    return this.jKZ;
  }
  
  public final boolean getTouchMoved()
  {
    return this.jKV;
  }
  
  public final int getTouchSlop()
  {
    return this.bvH;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker()
  {
    return this.uWz;
  }
  
  public b getType()
  {
    return b.Ier;
  }
  
  public final Rect getValidRect()
  {
    return this.HXd;
  }
  
  public final Matrix getViewMatrix()
  {
    return this.IbA;
  }
  
  protected final int getWaveAlpha()
  {
    return this.IcB;
  }
  
  public final Paint getWavePaint()
  {
    return this.IcK;
  }
  
  public final long getWaveTime()
  {
    return this.IcA;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(76152);
    p.k(paramCanvas, "canvas");
    paramCanvas.save();
    if (this.IbA != null)
    {
      paramCanvas.setMatrix(this.IbA);
      if (isActivated()) {
        this.Ibu.draw(paramCanvas);
      }
      x(paramCanvas);
      fyM();
      if (((Collection)this.IcJ).isEmpty()) {
        break label170;
      }
    }
    label170:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.wzx < this.IcJ.size()))
      {
        fyL();
        this.paint.setAlpha(this.alpha);
        paramCanvas.drawBitmap((Bitmap)this.IcJ.get(this.wzx), 0.0F, this.IcG, this.paint);
      }
      paramCanvas.restore();
      if (this.IcL) {
        invalidate();
      }
      AppMethodBeat.o(76152);
      return;
      paramCanvas.setMatrix(this.uWz.aHZ);
      break;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76151);
    p.k(paramMotionEvent, "event");
    this.IcI.set(this.uWz.aHZ);
    this.IcI.getValues(this.IcH);
    float f1 = this.IcH[2];
    boolean bool2 = this.uWz.ah(paramMotionEvent);
    this.uWz.aHZ.getValues(this.IcH);
    float f2 = this.IcH[5];
    this.uWz.aHZ.set(this.IcI);
    this.uWz.aHZ.setTranslate(f1, f2);
    Object localObject;
    if (bool2)
    {
      localObject = this.HXf;
      if (localObject != null) {
        ((EditorItemContainer.b)localObject).e((View)this, paramMotionEvent);
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
      this.jKY = paramMotionEvent.getX();
      this.jKZ = paramMotionEvent.getY();
      this.jKV = false;
      continue;
      f1 = Math.max(Math.abs(paramMotionEvent.getX() - this.jKY), Math.abs(paramMotionEvent.getY() - this.jKZ));
      if (!this.jKV)
      {
        if (f1 > this.bvH) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          this.jKV = bool1;
          break;
        }
        if (!this.jKV) {
          performClick();
        }
        paramMotionEvent = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
        localObject = this.HXd;
        paramMotionEvent.aGO = this.uWz.aGO;
        paramMotionEvent.aGN = this.uWz.aGN;
        paramMotionEvent.o(new float[] { this.uWz.width / 2.0F, this.uWz.height / 2.0F });
        paramMotionEvent.f(new RectF(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom));
        paramMotionEvent.a(this.uWz.aHZ, (kotlin.g.a.m)new a(this));
      }
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(76158);
    this.IcL = true;
    invalidate();
    AppMethodBeat.o(76158);
  }
  
  protected final void setAlpha(int paramInt)
  {
    this.alpha = paramInt;
  }
  
  public final void setBitmapList(ArrayList<Bitmap> paramArrayList)
  {
    AppMethodBeat.i(76139);
    p.k(paramArrayList, "<set-?>");
    this.IcJ = paramArrayList;
    AppMethodBeat.o(76139);
  }
  
  public final void setCurIndex(int paramInt)
  {
    this.wzx = paramInt;
  }
  
  public final void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  protected final void setLyricsItem(m paramm)
  {
    this.IcM = paramm;
  }
  
  public final void setNeedInvalidate(boolean paramBoolean)
  {
    this.IcL = paramBoolean;
  }
  
  public final void setPaint(Paint paramPaint)
  {
    AppMethodBeat.i(76140);
    p.k(paramPaint, "<set-?>");
    this.paint = paramPaint;
    AppMethodBeat.o(76140);
  }
  
  public final void setSourceDataType(d paramd)
  {
    AppMethodBeat.i(219230);
    p.k(paramd, "<set-?>");
    this.Ibz = paramd;
    AppMethodBeat.o(219230);
  }
  
  public final void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(76147);
    p.k(paramb, "stateResolve");
    this.HXf = paramb;
    AppMethodBeat.o(76147);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    this.LV = paramCharSequence;
  }
  
  public final void setTextSize(float paramFloat)
  {
    this.textSize = paramFloat;
  }
  
  public final void setTouchDownX(float paramFloat)
  {
    this.jKY = paramFloat;
  }
  
  public final void setTouchDownY(float paramFloat)
  {
    this.jKZ = paramFloat;
  }
  
  public final void setTouchMoved(boolean paramBoolean)
  {
    this.jKV = paramBoolean;
  }
  
  public void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(76144);
    p.k(paramRect, "validRect");
    this.HXd.set(paramRect);
    AppMethodBeat.o(76144);
  }
  
  public final void setValidRect(Rect paramRect)
  {
    AppMethodBeat.i(76142);
    p.k(paramRect, "<set-?>");
    this.HXd = paramRect;
    AppMethodBeat.o(76142);
  }
  
  public final void setViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(76143);
    this.IbA = paramMatrix;
    if (paramMatrix != null)
    {
      this.uWz.setMatrix(paramMatrix);
      Canvas localCanvas = new Canvas();
      localCanvas.save();
      if (this.IbA != null) {
        localCanvas.setMatrix(paramMatrix);
      }
      if (isActivated()) {
        this.Ibu.draw(localCanvas);
      }
    }
    AppMethodBeat.o(76143);
  }
  
  protected final void setWaveAlpha(int paramInt)
  {
    this.IcB = paramInt;
  }
  
  public final void setWavePaint(Paint paramPaint)
  {
    AppMethodBeat.i(76141);
    p.k(paramPaint, "<set-?>");
    this.IcK = paramPaint;
    AppMethodBeat.o(76141);
  }
  
  public final void setWaveTime(long paramLong)
  {
    this.IcA = paramLong;
  }
  
  protected final void x(Canvas paramCanvas)
  {
    AppMethodBeat.i(219276);
    p.k(paramCanvas, "canvas");
    if (!this.HLD.isEmpty())
    {
      if ((this.IcA == 0L) || (Util.milliSecondsToNow(this.IcA) > this.IcC))
      {
        this.IcA = System.currentTimeMillis();
        arrayOfRectF = this.IaE;
        i = 0;
        int k = arrayOfRectF.length;
        j = 0;
        float f1 = 0.0F;
        if (j < k)
        {
          RectF localRectF = arrayOfRectF[j];
          float f2 = localRectF.height();
          if (f2 <= this.Iay)
          {
            this.IaF[i] = ((float)(this.IaC * Math.random()));
            label120:
            if (f2 > this.IaF[i]) {
              break label260;
            }
          }
          label260:
          for (f2 = Math.min(f2 + this.Iaz, this.IaC);; f2 = Math.max(f2 - this.IaA, this.Iay))
          {
            float f3 = this.IaB;
            float f4 = this.IaC / 2.0F;
            float f5 = f2 / 2.0F;
            float f6 = this.IaB;
            float f7 = this.Iax;
            float f8 = this.IaC / 2.0F;
            localRectF.set(f3 + f1, f4 - f5, f1 + f6 + f7, f2 / 2.0F + f8);
            f1 = localRectF.right;
            j += 1;
            i += 1;
            break;
            if (f2 < this.IaF[i]) {
              break label120;
            }
            this.IaF[i] = this.Iay;
            break label120;
          }
        }
      }
      PC(((ctg)this.HLD.get(0)).startTime);
      this.IcK.setAlpha(this.IcB);
      RectF[] arrayOfRectF = this.IaE;
      int j = arrayOfRectF.length;
      int i = 0;
      while (i < j)
      {
        paramCanvas.drawRect(arrayOfRectF[i], this.IcK);
        i += 1;
      }
    }
    AppMethodBeat.o(219276);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "<anonymous parameter 1>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.m<Matrix, Boolean, x>
  {
    a(n paramn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.n
 * JD-Core Version:    0.7.0.1
 */
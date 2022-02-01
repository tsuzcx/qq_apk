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
import com.tencent.mm.plugin.recordvideo.ui.editor.c.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a.g;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.d.a;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DP_1", "", "LAST_INTERVAL", "", "getLAST_INTERVAL", "()J", "LYRICS_VERTICAL_OFFSET", "", "getLYRICS_VERTICAL_OFFSET", "()F", "MARGIN", "TAG", "", "TRANS_TIME", "getTRANS_TIME", "WAVE_DECREMENT", "WAVE_INCREMENT", "WAVE_INVALIDAT_INTERVAL", "WAVE_RECT_COUNT", "WAVE_RECT_HEIGHT", "WAVE_RECT_MIN_HEIGHT", "WAVE_RECT_OFFSET", "WAVE_RECT_WIDTH", "alpha", "getAlpha", "()I", "setAlpha", "(I)V", "bitmapList", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "getBitmapList", "()Ljava/util/ArrayList;", "setBitmapList", "(Ljava/util/ArrayList;)V", "curIndex", "getCurIndex", "setCurIndex", "displayRect", "Landroid/graphics/Rect;", "getDisplayRect", "()Landroid/graphics/Rect;", "duration", "getDuration", "setDuration", "(J)V", "frameDrawable", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "getFrameDrawable", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "lyricsItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem;", "getLyricsItem", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem;", "setLyricsItem", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem;)V", "lyricsList", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "getLyricsList", "needInvalidate", "", "getNeedInvalidate", "()Z", "setNeedInvalidate", "(Z)V", "originMatrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "setPaint", "(Landroid/graphics/Paint;)V", "sourceDataType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "getSourceDataType", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "setSourceDataType", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;)V", "startTime", "getStartTime", "setStartTime", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "text", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textSize", "getTextSize", "setTextSize", "(F)V", "touchArray", "", "touchDownX", "getTouchDownX", "setTouchDownX", "touchDownY", "getTouchDownY", "setTouchDownY", "touchMoved", "getTouchMoved", "setTouchMoved", "touchSlop", "getTouchSlop", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validRect", "getValidRect", "setValidRect", "(Landroid/graphics/Rect;)V", "value", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "waveAlpha", "getWaveAlpha", "setWaveAlpha", "wavePaint", "getWavePaint", "setWavePaint", "waveRects", "", "Landroid/graphics/RectF;", "[Landroid/graphics/RectF;", "waveTargetHeight", "waveTime", "getWaveTime", "setWaveTime", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "createLyricsBitmap", "", "drawWave", "canvas", "Landroid/graphics/Canvas;", "fillAlpha", "fillWaveAlpha", "appearTime", "getContentBoundary", "getDrawRect", "getEditorData", "getLyricsEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorItem;", "item", "getSafeArea", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "nextIndex", "onDraw", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "renderLyrics", "lyricsInfo", "", "reshowLyrics", "resume", "setDefaultLocation", "heightPercent", "setSafeArea", "safeRect", "damp", "setStateResolve", "setValidArea", "updateLyricsList", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public class n
  extends View
  implements h, com.tencent.mm.plugin.recordvideo.ui.editor.view.d
{
  private final ArrayList<dki> NIE;
  private Rect NTO;
  private final Rect NTP;
  private EditorItemContainer.b NTQ;
  private final float NWY;
  private final int NWZ;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.view.a NXT;
  private d NXX;
  private Matrix NXY;
  private final float NXa;
  private final int NXb;
  private final float NXc;
  private final float NXd;
  private final RectF[] NXf;
  private final float[] NXg;
  private long NYW;
  private int NYX;
  private final long NYY;
  private final long NYZ;
  private final long NZa;
  private final int NZb;
  private final float NZc;
  private final float[] NZd;
  private final Matrix NZe;
  private ArrayList<Bitmap> NZf;
  private Paint NZg;
  public boolean NZh;
  private m NZi;
  private final String TAG;
  private int alpha;
  private final int bGt;
  private CharSequence bba;
  private final int doK;
  private long duration;
  private boolean mkh;
  private float mkk;
  private float mkl;
  private Paint paint;
  private long startTime;
  private float textSize;
  private final int wFI;
  private final c yiZ;
  private int zVI;
  
  public n(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76159);
    this.NIE = new ArrayList();
    this.TAG = "MicroMsg.LyricsItemView";
    this.NYY = 50L;
    this.NYZ = 200L;
    this.NZa = 3000L;
    this.NZb = 11;
    this.wFI = bd.fromDPToPix(paramContext, 1);
    this.NWY = (this.wFI * 1.5F);
    this.NXd = (this.wFI * 9.0F);
    this.NWZ = this.wFI;
    this.NXc = (this.wFI * 1.5F);
    this.NZc = (this.wFI * 12.0F);
    this.NXa = (this.wFI * 2.0F);
    this.NXb = this.wFI;
    this.bGt = bd.fromDPToPix(paramContext, 32);
    int j = this.NZb;
    Object localObject = new RectF[j];
    int i = 0;
    while (i < j)
    {
      localObject[i] = new RectF();
      i += 1;
    }
    this.NXf = ((RectF[])localObject);
    this.NXg = new float[this.NZb];
    this.NZd = new float[9];
    this.NZe = new Matrix();
    this.yiZ = new c();
    this.textSize = getResources().getDimension(b.c.editor_text_item_text_size);
    this.NXX = d.NYh;
    this.NZf = new ArrayList();
    this.paint = new Paint();
    this.NZg = new Paint();
    this.NTO = new Rect(0, 0, bf.bf(MMApplicationContext.getContext()).x, bf.bf(MMApplicationContext.getContext()).y);
    this.NTP = new Rect(0, 0, bf.bf(MMApplicationContext.getContext()).x, bf.bf(MMApplicationContext.getContext()).y);
    this.NZh = true;
    this.yiZ.minScale = 0.5F;
    this.yiZ.maxScale = 3.0F;
    this.NZg.setColor(Color.parseColor("#CCFFFFFF"));
    localObject = getResources();
    s.s(localObject, "resources");
    this.NXT = new com.tencent.mm.plugin.recordvideo.ui.editor.view.a((Resources)localObject);
    this.doK = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(76159);
  }
  
  private final void gKD()
  {
    AppMethodBeat.i(76150);
    Iterator localIterator = ((Iterable)this.NIE).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (dki)localIterator.next();
      if (!Util.isNullOrNil(((dki)localObject1).lyrics))
      {
        Object localObject2 = new LinearLayout(getContext());
        localObject2 = LayoutInflater.from(getContext()).inflate(b.f.story_editor_item_lyrics, (ViewGroup)localObject2, false);
        TextView localTextView = (TextView)((View)localObject2).findViewById(b.e.story_item_lyric_content);
        s.s(localTextView, "lyricsText");
        com.tencent.mm.ae.d.h(localTextView);
        localTextView.setText((CharSequence)((dki)localObject1).lyrics);
        e locale = e.NDU;
        localTextView.setMaxHeight(e.gGL().height());
        int i = this.bGt;
        locale = e.NDU;
        if (i >= e.gGL().left)
        {
          locale = e.NDU;
          i = e.gGL().width();
          j = this.bGt;
          locale = e.NDU;
          i -= (j - e.gGL().left) * 2;
          label194:
          localTextView.setMaxWidth(i);
          ((View)localObject2).measure(0, 0);
          ((View)localObject2).layout(0, 0, ((View)localObject2).getMeasuredWidth(), ((View)localObject2).getMeasuredHeight());
          if (((View)localObject2).getMeasuredWidth() > 0)
          {
            i = ((View)localObject2).getMeasuredWidth();
            locale = e.NDU;
            if (i <= e.gGL().width()) {
              break label449;
            }
          }
          locale = e.NDU;
          i = e.gGL().width();
          label265:
          if (((View)localObject2).getMeasuredHeight() > 0)
          {
            j = ((View)localObject2).getMeasuredHeight();
            locale = e.NDU;
            if (j <= e.gGL().height()) {
              break label458;
            }
          }
          locale = e.NDU;
        }
        label449:
        label458:
        for (int j = e.gGL().height();; j = ((View)localObject2).getMeasuredHeight())
        {
          Log.i(this.TAG, "it.lyrics=" + ((dki)localObject1).lyrics + " lyricsText.maxWidth=" + localTextView.getMaxWidth() + " lyricsText.maxHeight=" + localTextView.getMaxHeight() + " parent.measuredWidth=" + ((View)localObject2).getMeasuredWidth() + " parent.measuredHeight=" + ((View)localObject2).getMeasuredHeight());
          localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          ((View)localObject2).draw(new Canvas((Bitmap)localObject1));
          setSourceDataType(d.NYh);
          getBitmapList().add(localObject1);
          break;
          locale = e.NDU;
          i = e.gGL().width();
          break label194;
          i = ((View)localObject2).getMeasuredWidth();
          break label265;
        }
      }
    }
    AppMethodBeat.o(76150);
  }
  
  private final void jT(List<? extends dki> paramList)
  {
    AppMethodBeat.i(76149);
    this.NIE.clear();
    ArrayList localArrayList = this.NIE;
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label98:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (!Util.isNullOrNil(((dki)localObject2).lyrics)) {}
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
    s.u(paramRect, "displayRect");
    this.NTP.set(paramRect);
    AppMethodBeat.o(76145);
  }
  
  public final boolean aTn(String paramString)
  {
    AppMethodBeat.i(281039);
    boolean bool = d.a.a(this, paramString);
    AppMethodBeat.o(281039);
    return bool;
  }
  
  public com.tencent.mm.plugin.recordvideo.ui.editor.item.a.h b(m paramm)
  {
    AppMethodBeat.i(280963);
    s.u(paramm, "item");
    jS((List)paramm.NYU);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (Iterable)this.NIE;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        p.kkW();
      }
      localObject2 = (dki)localObject2;
      Object localObject3 = getBitmapList().get(i);
      s.s(localObject3, "bitmapList[index]");
      localArrayList.add(new g((dki)localObject2, (Bitmap)localObject3));
      i += 1;
    }
    paramm = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.h((List)localArrayList, paramm.matrix);
    AppMethodBeat.o(280963);
    return paramm;
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(280975);
    s.u(paramRect, "safeRect");
    this.yiZ.NDV = paramRect;
    this.yiZ.Oah = com.tencent.mm.cd.a.fromDPToPix(getContext(), 54);
    AppMethodBeat.o(280975);
  }
  
  public final void c(m paramm)
  {
    AppMethodBeat.i(280857);
    s.u(paramm, "item");
    this.NZi = paramm;
    setViewMatrix(paramm.matrix);
    jT((List)paramm.NYU);
    gKD();
    this.NXX = d.NYh;
    AppMethodBeat.o(280857);
  }
  
  public final a dEP()
  {
    AppMethodBeat.i(280950);
    if (this.NZf.isEmpty())
    {
      AppMethodBeat.o(280950);
      return null;
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).postConcat(this.yiZ.matrix);
    localObject = (a)new m((List)this.NIE, (Matrix)localObject);
    AppMethodBeat.o(280950);
    return localObject;
  }
  
  public com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a e(Matrix paramMatrix)
  {
    AppMethodBeat.i(280947);
    if (this.NZf.isEmpty())
    {
      AppMethodBeat.o(280947);
      return null;
    }
    paramMatrix = new ArrayList();
    Object localObject1 = (Iterable)this.NIE;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        p.kkW();
      }
      localObject2 = (dki)localObject2;
      if (i < getBitmapList().size())
      {
        Object localObject3 = getBitmapList().get(i);
        s.s(localObject3, "bitmapList[index]");
        paramMatrix.add(new g((dki)localObject2, (Bitmap)localObject3));
      }
      i += 1;
    }
    localObject1 = new Matrix();
    ((Matrix)localObject1).postConcat(this.yiZ.matrix);
    paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.h((List)paramMatrix, (Matrix)localObject1);
    AppMethodBeat.o(280947);
    return paramMatrix;
  }
  
  public final boolean gJS()
  {
    AppMethodBeat.i(281031);
    s.u(this, "this");
    AppMethodBeat.o(281031);
    return true;
  }
  
  protected void gKx()
  {
    AppMethodBeat.i(280869);
    if (this.zVI < this.NIE.size())
    {
      long l2 = ((dki)this.NIE.get(this.zVI)).startTime;
      Object localObject = (dki)p.ae((List)this.NIE, this.zVI + 1);
      long l1;
      label96:
      int i;
      if (localObject == null)
      {
        localObject = null;
        if (localObject != null) {
          break label175;
        }
        l1 = ((dki)this.NIE.get(this.zVI)).startTime + this.NZa;
        l3 = this.NYZ;
        l4 = this.duration - l2;
        if (0L > l4) {
          break label189;
        }
        if (l4 > l3) {
          break label184;
        }
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label194;
        }
        this.alpha = ((int)(255.0F * (float)(this.duration - l2) / (float)this.NYZ));
        AppMethodBeat.o(280869);
        return;
        localObject = Long.valueOf(((dki)localObject).startTime);
        break;
        label175:
        l1 = ((Long)localObject).longValue();
        break label96;
        label184:
        i = 0;
        continue;
        label189:
        i = 0;
      }
      label194:
      long l3 = this.NYZ;
      long l4 = l1 - this.duration;
      if (0L <= l4) {
        if (l4 <= l3) {
          i = 1;
        }
      }
      while (i != 0)
      {
        this.alpha = ((int)((float)(l1 - this.duration) / (float)this.NYZ * 255.0F));
        AppMethodBeat.o(280869);
        return;
        i = 0;
        continue;
        i = 0;
      }
      if ((this.duration - l2 > this.NYZ) && (l1 - this.duration > this.NYZ)) {
        this.alpha = 255;
      }
    }
    AppMethodBeat.o(280869);
  }
  
  protected void gKy()
  {
    AppMethodBeat.i(280890);
    if (this.NIE.isEmpty())
    {
      AppMethodBeat.o(280890);
      return;
    }
    this.duration = (System.currentTimeMillis() - this.startTime);
    Object localObject = (dki)p.ae((List)this.NIE, this.zVI + 1);
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label156;
      }
    }
    label156:
    for (long l = ((dki)this.NIE.get(this.zVI)).startTime + this.NZa;; l = ((Long)localObject).longValue())
    {
      if (this.duration >= l)
      {
        this.zVI += 1;
        if (this.zVI >= this.NIE.size())
        {
          this.zVI = 0;
          this.startTime = System.currentTimeMillis();
          this.duration = 0L;
        }
      }
      AppMethodBeat.o(280890);
      return;
      localObject = Long.valueOf(((dki)localObject).startTime);
      break;
    }
  }
  
  protected final int getAlpha()
  {
    return this.alpha;
  }
  
  public final ArrayList<Bitmap> getBitmapList()
  {
    return this.NZf;
  }
  
  public float[] getContentBoundary()
  {
    AppMethodBeat.i(76157);
    float[] arrayOfFloat = (float[])this.yiZ.Oam.clone();
    AppMethodBeat.o(76157);
    return arrayOfFloat;
  }
  
  public final int getCurIndex()
  {
    return this.zVI;
  }
  
  public final Rect getDisplayRect()
  {
    return this.NTP;
  }
  
  public RectF getDrawRect()
  {
    AppMethodBeat.i(281011);
    RectF localRectF = new RectF(this.yiZ.Oam[0], this.yiZ.Oam[1], this.yiZ.Oam[2], this.yiZ.Oam[3]);
    AppMethodBeat.o(281011);
    return localRectF;
  }
  
  public final long getDuration()
  {
    return this.duration;
  }
  
  public a getEditorData()
  {
    return (a)this.NZi;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.ui.editor.view.a getFrameDrawable()
  {
    return this.NXT;
  }
  
  protected final long getLAST_INTERVAL()
  {
    return this.NZa;
  }
  
  protected final float getLYRICS_VERTICAL_OFFSET()
  {
    return this.NZc;
  }
  
  protected final m getLyricsItem()
  {
    return this.NZi;
  }
  
  public final ArrayList<dki> getLyricsList()
  {
    return this.NIE;
  }
  
  public final boolean getNeedInvalidate()
  {
    return this.NZh;
  }
  
  public final Paint getPaint()
  {
    return this.paint;
  }
  
  public Rect getSafeArea()
  {
    AppMethodBeat.i(76156);
    Rect localRect = this.yiZ.NDV;
    if (localRect == null)
    {
      localRect = new Rect(0, 0, getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels);
      AppMethodBeat.o(76156);
      return localRect;
    }
    AppMethodBeat.o(76156);
    return localRect;
  }
  
  public final d getSourceDataType()
  {
    return this.NXX;
  }
  
  public final long getStartTime()
  {
    return this.startTime;
  }
  
  protected final long getTRANS_TIME()
  {
    return this.NYZ;
  }
  
  public final CharSequence getText()
  {
    return this.bba;
  }
  
  public final float getTextSize()
  {
    return this.textSize;
  }
  
  public final float getTouchDownX()
  {
    return this.mkk;
  }
  
  public final float getTouchDownY()
  {
    return this.mkl;
  }
  
  public final boolean getTouchMoved()
  {
    return this.mkh;
  }
  
  public final int getTouchSlop()
  {
    return this.doK;
  }
  
  protected final c getTouchTracker()
  {
    return this.yiZ;
  }
  
  public b getType()
  {
    return b.OaH;
  }
  
  public final Rect getValidRect()
  {
    return this.NTO;
  }
  
  public final Matrix getViewMatrix()
  {
    return this.NXY;
  }
  
  protected final int getWaveAlpha()
  {
    return this.NYX;
  }
  
  public final Paint getWavePaint()
  {
    return this.NZg;
  }
  
  public final long getWaveTime()
  {
    return this.NYW;
  }
  
  public final void jS(List<? extends dki> paramList)
  {
    AppMethodBeat.i(76146);
    s.u(paramList, "lyricsInfo");
    jT(paramList);
    gKD();
    paramList = ((Iterable)this.NZf).iterator();
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
        this.yiZ.width = k;
        this.yiZ.height = i;
        this.NXT.setBounds(0, 0, k, i);
        this.yiZ.x(new float[] { 0.0F, 0.0F, k, 0.0F, 0.0F, i, k, i });
        f2 = this.NTP.height() - bd.fromDPToPix(getContext(), 360) - i;
        i = this.bGt;
        paramList = e.NDU;
        if (i < e.gGL().left) {
          break label269;
        }
      }
      for (float f1 = this.bGt;; f1 = e.gGL().left)
      {
        this.yiZ.matrix.setTranslate(f1, f2);
        AppMethodBeat.o(76146);
        return;
        paramList = e.NDU;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(76152);
    s.u(paramCanvas, "canvas");
    paramCanvas.save();
    if (this.NXY != null)
    {
      paramCanvas.setMatrix(this.NXY);
      if (isActivated()) {
        this.NXT.draw(paramCanvas);
      }
      s(paramCanvas);
      gKy();
      if (((Collection)this.NZf).isEmpty()) {
        break label170;
      }
    }
    label170:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.zVI < this.NZf.size()))
      {
        gKx();
        this.paint.setAlpha(this.alpha);
        paramCanvas.drawBitmap((Bitmap)this.NZf.get(this.zVI), 0.0F, this.NZc, this.paint);
      }
      paramCanvas.restore();
      if (this.NZh) {
        invalidate();
      }
      AppMethodBeat.o(76152);
      return;
      paramCanvas.setMatrix(this.yiZ.matrix);
      break;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76151);
    s.u(paramMotionEvent, "event");
    this.NZe.set(this.yiZ.matrix);
    this.NZe.getValues(this.NZd);
    float f1 = this.NZd[2];
    boolean bool2 = this.yiZ.ak(paramMotionEvent);
    this.yiZ.matrix.getValues(this.NZd);
    float f2 = this.NZd[5];
    this.yiZ.matrix.set(this.NZe);
    this.yiZ.matrix.setTranslate(f1, f2);
    Object localObject;
    if (bool2)
    {
      localObject = this.NTQ;
      if (localObject != null) {
        ((EditorItemContainer.b)localObject).l((View)this, paramMotionEvent);
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
      this.mkk = paramMotionEvent.getX();
      this.mkl = paramMotionEvent.getY();
      this.mkh = false;
      continue;
      f1 = Math.max(Math.abs(paramMotionEvent.getX() - this.mkk), Math.abs(paramMotionEvent.getY() - this.mkl));
      if (!this.mkh)
      {
        if (f1 > this.doK) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          this.mkh = bool1;
          break;
        }
        if (!this.mkh) {
          performClick();
        }
        paramMotionEvent = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
        localObject = this.NTO;
        paramMotionEvent.minScale = this.yiZ.minScale;
        paramMotionEvent.maxScale = this.yiZ.maxScale;
        paramMotionEvent.w(new float[] { this.yiZ.width / 2.0F, this.yiZ.height / 2.0F });
        paramMotionEvent.g(new RectF(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom));
        paramMotionEvent.a(this.yiZ.matrix, (kotlin.g.a.m)new a(this));
      }
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(76158);
    this.NZh = true;
    invalidate();
    AppMethodBeat.o(76158);
  }
  
  protected final void s(Canvas paramCanvas)
  {
    AppMethodBeat.i(280907);
    s.u(paramCanvas, "canvas");
    if (!this.NIE.isEmpty())
    {
      if ((this.NYW == 0L) || (Util.milliSecondsToNow(this.NYW) > this.NYY))
      {
        this.NYW = System.currentTimeMillis();
        arrayOfRectF = this.NXf;
        i = 0;
        int k = arrayOfRectF.length;
        j = 0;
        float f1 = 0.0F;
        if (j < k)
        {
          RectF localRectF = arrayOfRectF[j];
          float f2 = localRectF.height();
          if (f2 <= this.NWZ)
          {
            this.NXg[i] = ((float)(this.NXd * Math.random()));
            label120:
            if (f2 > this.NXg[i]) {
              break label260;
            }
          }
          label260:
          for (f2 = Math.min(f2 + this.NXa, this.NXd);; f2 = Math.max(f2 - this.NXb, this.NWZ))
          {
            float f3 = this.NXc;
            float f4 = this.NXd / 2.0F;
            float f5 = f2 / 2.0F;
            float f6 = this.NXc;
            float f7 = this.NWY;
            float f8 = this.NXd / 2.0F;
            localRectF.set(f3 + f1, f4 - f5, f1 + f6 + f7, f2 / 2.0F + f8);
            f1 = localRectF.right;
            j += 1;
            i += 1;
            break;
            if (f2 < this.NXg[i]) {
              break label120;
            }
            this.NXg[i] = this.NWZ;
            break label120;
          }
        }
      }
      tC(((dki)this.NIE.get(0)).startTime);
      this.NZg.setAlpha(this.NYX);
      RectF[] arrayOfRectF = this.NXf;
      int j = arrayOfRectF.length;
      int i = 0;
      while (i < j)
      {
        paramCanvas.drawRect(arrayOfRectF[i], getWavePaint());
        i += 1;
      }
    }
    AppMethodBeat.o(280907);
  }
  
  protected final void setAlpha(int paramInt)
  {
    this.alpha = paramInt;
  }
  
  public final void setBitmapList(ArrayList<Bitmap> paramArrayList)
  {
    AppMethodBeat.i(76139);
    s.u(paramArrayList, "<set-?>");
    this.NZf = paramArrayList;
    AppMethodBeat.o(76139);
  }
  
  public final void setCurIndex(int paramInt)
  {
    this.zVI = paramInt;
  }
  
  public final void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  protected final void setLyricsItem(m paramm)
  {
    this.NZi = paramm;
  }
  
  public final void setNeedInvalidate(boolean paramBoolean)
  {
    this.NZh = paramBoolean;
  }
  
  public final void setPaint(Paint paramPaint)
  {
    AppMethodBeat.i(76140);
    s.u(paramPaint, "<set-?>");
    this.paint = paramPaint;
    AppMethodBeat.o(76140);
  }
  
  public final void setSourceDataType(d paramd)
  {
    AppMethodBeat.i(280507);
    s.u(paramd, "<set-?>");
    this.NXX = paramd;
    AppMethodBeat.o(280507);
  }
  
  public final void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(76147);
    s.u(paramb, "stateResolve");
    this.NTQ = paramb;
    AppMethodBeat.o(76147);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    this.bba = paramCharSequence;
  }
  
  public final void setTextSize(float paramFloat)
  {
    this.textSize = paramFloat;
  }
  
  public final void setTouchDownX(float paramFloat)
  {
    this.mkk = paramFloat;
  }
  
  public final void setTouchDownY(float paramFloat)
  {
    this.mkl = paramFloat;
  }
  
  public final void setTouchMoved(boolean paramBoolean)
  {
    this.mkh = paramBoolean;
  }
  
  public void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(76144);
    s.u(paramRect, "validRect");
    this.NTO.set(paramRect);
    AppMethodBeat.o(76144);
  }
  
  public final void setValidRect(Rect paramRect)
  {
    AppMethodBeat.i(76142);
    s.u(paramRect, "<set-?>");
    this.NTO = paramRect;
    AppMethodBeat.o(76142);
  }
  
  public final void setViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(76143);
    this.NXY = paramMatrix;
    if (paramMatrix != null)
    {
      this.yiZ.setMatrix(paramMatrix);
      Canvas localCanvas = new Canvas();
      localCanvas.save();
      if (this.NXY != null) {
        localCanvas.setMatrix(paramMatrix);
      }
      if (isActivated()) {
        this.NXT.draw(localCanvas);
      }
    }
    AppMethodBeat.o(76143);
  }
  
  protected final void setWaveAlpha(int paramInt)
  {
    this.NYX = paramInt;
  }
  
  public final void setWavePaint(Paint paramPaint)
  {
    AppMethodBeat.i(76141);
    s.u(paramPaint, "<set-?>");
    this.NZg = paramPaint;
    AppMethodBeat.o(76141);
  }
  
  public final void setWaveTime(long paramLong)
  {
    this.NYW = paramLong;
  }
  
  public boolean tA(long paramLong)
  {
    AppMethodBeat.i(281045);
    boolean bool = d.a.a(this, paramLong);
    AppMethodBeat.o(281045);
    return bool;
  }
  
  protected void tC(long paramLong)
  {
    int j = 0;
    if (this.NYX < 255)
    {
      long l1 = this.NYZ;
      long l2 = this.duration - paramLong;
      int i = j;
      if (0L <= l2)
      {
        i = j;
        if (l2 <= l1) {
          i = 1;
        }
      }
      if (i == 0) {
        break label77;
      }
      this.NYX = ((int)(255.0F * (float)(this.duration - paramLong) / (float)this.NYZ));
    }
    label77:
    while (this.duration - paramLong <= this.NYZ) {
      return;
    }
    this.NYX = 255;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "<anonymous parameter 1>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.m<Matrix, Boolean, ah>
  {
    a(n paramn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.n
 * JD-Core Version:    0.7.0.1
 */
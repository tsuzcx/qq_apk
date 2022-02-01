package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.c.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "Landroid/graphics/Bitmap;", "bitmap", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "displayRect", "Landroid/graphics/Rect;", "getDisplayRect", "()Landroid/graphics/Rect;", "enableNotify", "", "getEnableNotify", "()Z", "setEnableNotify", "(Z)V", "frameDrawable", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "location", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "getLocation", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "setLocation", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;)V", "marginBottom", "getMarginBottom", "setMarginBottom", "navigateBarHeight", "getNavigateBarHeight", "originPivot", "", "paint", "Landroid/graphics/Paint;", "sourceDataType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "getSourceDataType", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "setSourceDataType", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;)V", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "text", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textBg", "getTextBg", "setTextBg", "textSize", "", "getTextSize", "()F", "setTextSize", "(F)V", "touchDownX", "getTouchDownX", "setTouchDownX", "touchDownY", "getTouchDownY", "setTouchDownY", "touchMoved", "getTouchMoved", "setTouchMoved", "touchSlop", "getTouchSlop", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validRect", "getValidRect", "Landroid/graphics/Matrix;", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "getContentBoundary", "getDrawRect", "Landroid/graphics/RectF;", "getSafeArea", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setDefaultLocation", "heightPercent", "setSafeArea", "safeRect", "damp", "setStateResolve", "setValidArea", "plugin-recordvideo_release"})
public abstract class b
  extends View
  implements g, com.tencent.mm.plugin.recordvideo.ui.editor.view.c
{
  private final Rect Cao = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
  private final Rect Cap = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
  private EditorItemContainer.b Caq;
  private int CeA;
  private int CeB;
  private k CeC;
  private d CeD = d.CeK;
  private Matrix CeE;
  private boolean CeF;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.view.a Cey;
  private final int Cez = au.aD(MMApplicationContext.getContext());
  private Bitmap bitmap;
  private int color;
  private boolean gZU;
  private float gZX;
  private float gZY;
  private final Paint paint = new Paint();
  private final int rZ;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c rqT = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
  private final float[] rrd = new float[2];
  private CharSequence text;
  private float textSize = getResources().getDimension(2131166236);
  
  public b(Context paramContext)
  {
    super(paramContext);
    this.rqT.aXu = 0.5F;
    this.rqT.aXt = 3.0F;
    Resources localResources = getResources();
    p.g(localResources, "resources");
    this.Cey = new com.tencent.mm.plugin.recordvideo.ui.editor.view.a(localResources);
    paramContext = ViewConfiguration.get(paramContext);
    p.g(paramContext, "ViewConfiguration.get(context)");
    this.rZ = paramContext.getScaledTouchSlop();
    this.paint.setAntiAlias(true);
    this.CeF = true;
  }
  
  public final boolean Ig(long paramLong)
  {
    return c.a.a(this, paramLong);
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    p.h(paramRect, "displayRect");
    this.Cap.set(paramRect);
    this.rqT.gT.postTranslate(paramRect.width() / 2.0F, paramRect.height() * paramFloat);
  }
  
  public final boolean aLB(String paramString)
  {
    p.h(paramString, "objID");
    return c.a.a(this, paramString);
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    p.h(paramRect, "safeRect");
    this.rqT.BKm = paramRect;
    this.rqT.Chb = com.tencent.mm.cb.a.fromDPToPix(getContext(), paramInt);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    if (this.bitmap == null) {
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.rqT.gT);
    if (paramMatrix != null) {
      localMatrix.postConcat(paramMatrix);
    }
    return (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(this.bitmap, localMatrix);
  }
  
  public a cJO()
  {
    if (this.bitmap == null) {
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.rqT.gT);
    if ((this.CeD == d.CeK) || (this.CeD == d.CeN)) {
      return (a)new q(this.text, this.color, this.CeA, this.CeB, localMatrix);
    }
    Object localObject1 = this.CeC;
    if (localObject1 == null) {
      p.hyc();
    }
    localObject1 = ((k)localObject1).Cfy;
    Object localObject2 = this.CeC;
    if (localObject2 == null) {
      p.hyc();
    }
    localObject2 = ((k)localObject2).kHV;
    k localk = this.CeC;
    if (localk == null) {
      p.hyc();
    }
    float f = localk.dTj;
    localk = this.CeC;
    if (localk == null) {
      p.hyc();
    }
    return (a)new k((String)localObject1, (String)localObject2, f, localk.latitude, localMatrix);
  }
  
  public final boolean eLK()
  {
    return this.CeF;
  }
  
  public final Bitmap getBitmap()
  {
    return this.bitmap;
  }
  
  public final int getColor()
  {
    return this.color;
  }
  
  public float[] getContentBoundary()
  {
    return (float[])this.rqT.Chg.clone();
  }
  
  protected final Rect getDisplayRect()
  {
    return this.Cap;
  }
  
  public RectF getDrawRect()
  {
    return new RectF(this.rqT.Chg[0], this.rqT.Chg[1], this.rqT.Chg[2], this.rqT.Chg[3]);
  }
  
  public final boolean getEnableNotify()
  {
    return this.CeF;
  }
  
  public final k getLocation()
  {
    return this.CeC;
  }
  
  public final int getMarginBottom()
  {
    return this.CeB;
  }
  
  protected final int getNavigateBarHeight()
  {
    return this.Cez;
  }
  
  public Rect getSafeArea()
  {
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
    return localObject;
  }
  
  public final d getSourceDataType()
  {
    return this.CeD;
  }
  
  public final CharSequence getText()
  {
    return this.text;
  }
  
  public final int getTextBg()
  {
    return this.CeA;
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
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker()
  {
    return this.rqT;
  }
  
  protected final Rect getValidRect()
  {
    return this.Cao;
  }
  
  public final Matrix getViewMatrix()
  {
    return this.CeE;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    p.h(paramCanvas, "canvas");
    paramCanvas.save();
    if (this.CeE != null)
    {
      paramCanvas.setMatrix(this.CeE);
      if (isActivated()) {
        this.Cey.draw(paramCanvas);
      }
      paramCanvas.restore();
      paramCanvas.clipRect(this.Cao);
      paramCanvas.save();
      if (this.CeE == null) {
        break label124;
      }
      paramCanvas.setMatrix(this.CeE);
    }
    for (;;)
    {
      if (this.bitmap != null)
      {
        Bitmap localBitmap = this.bitmap;
        if (localBitmap == null) {
          p.hyc();
        }
        paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, this.paint);
      }
      paramCanvas.restore();
      return;
      paramCanvas.setMatrix(this.rqT.gT);
      break;
      label124:
      paramCanvas.setMatrix(this.rqT.gT);
    }
  }
  
  public boolean onTouchEvent(final MotionEvent paramMotionEvent)
  {
    p.h(paramMotionEvent, "event");
    boolean bool2;
    Object localObject1;
    if ((paramMotionEvent.getActionMasked() != 3) && (paramMotionEvent.getActionMasked() != 1))
    {
      bool2 = this.rqT.Y(paramMotionEvent);
      bool1 = bool2;
      if (bool2)
      {
        bringToFront();
        localObject1 = this.Caq;
        if (localObject1 != null) {
          ((EditorItemContainer.b)localObject1).d((View)this, paramMotionEvent);
        }
        postInvalidate();
      }
    }
    for (boolean bool1 = bool2;; bool1 = true)
    {
      if (bool1) {}
      switch (paramMotionEvent.getActionMasked())
      {
      default: 
      case 0: 
      case 2: 
        float f;
        do
        {
          return bool1;
          this.gZX = paramMotionEvent.getX();
          this.gZY = paramMotionEvent.getY();
          this.gZU = false;
          this.rrd[0] = (this.rqT.width / 2.0F);
          this.rrd[1] = (this.rqT.height / 2.0F);
          this.rqT.gT.mapPoints(this.rrd);
          return bool1;
          f = Math.max(Math.abs(paramMotionEvent.getX() - this.gZX), Math.abs(paramMotionEvent.getY() - this.gZY));
        } while (this.gZU);
        if (f > this.rZ) {}
        for (bool2 = true;; bool2 = false)
        {
          this.gZU = bool2;
          return bool1;
        }
      }
      localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
      Object localObject2 = this.Cao;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).aXu = this.rqT.aXu;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).aXt = this.rqT.aXt;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).n(new float[] { this.rqT.width / 2.0F, this.rqT.height / 2.0F });
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).f(new RectF(((Rect)localObject2).left, ((Rect)localObject2).top, ((Rect)localObject2).right, ((Rect)localObject2).bottom));
      localObject2 = new float[2];
      localObject2[0] = (this.rqT.width / 2.0F);
      localObject2[1] = (this.rqT.height / 2.0F);
      this.rqT.gT.mapPoints((float[])localObject2);
      if (!((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).CgM.contains(localObject2[0], localObject2[1])) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).f(new RectF(this.rrd[0], this.rrd[1], this.rrd[0], this.rrd[1]));
      }
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).a(this.rqT.gT, (m)new a(this, paramMotionEvent));
      return bool1;
    }
  }
  
  public final void setBitmap(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
    if (paramBitmap != null)
    {
      this.rqT.width = paramBitmap.getWidth();
      this.rqT.height = paramBitmap.getHeight();
      this.rqT.gT.preTranslate(-paramBitmap.getWidth() / 2.0F, -paramBitmap.getHeight() / 2.0F);
      this.Cey.setBounds(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      this.rqT.o(new float[] { 0.0F, 0.0F, paramBitmap.getWidth(), 0.0F, 0.0F, paramBitmap.getHeight(), paramBitmap.getWidth(), paramBitmap.getHeight() });
    }
  }
  
  public final void setColor(int paramInt)
  {
    this.color = paramInt;
  }
  
  public final void setEnableNotify(boolean paramBoolean)
  {
    this.CeF = paramBoolean;
  }
  
  public final void setLocation(k paramk)
  {
    this.CeC = paramk;
  }
  
  public final void setMarginBottom(int paramInt)
  {
    this.CeB = paramInt;
  }
  
  public final void setSourceDataType(d paramd)
  {
    p.h(paramd, "<set-?>");
    this.CeD = paramd;
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    p.h(paramb, "stateResolve");
    this.Caq = paramb;
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    this.text = paramCharSequence;
  }
  
  public final void setTextBg(int paramInt)
  {
    this.CeA = paramInt;
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
  
  public void setValidArea(Rect paramRect)
  {
    p.h(paramRect, "validRect");
    this.Cao.set(paramRect);
  }
  
  public final void setViewMatrix(Matrix paramMatrix)
  {
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
      if (this.bitmap != null)
      {
        paramMatrix = this.bitmap;
        if (paramMatrix == null) {
          p.hyc();
        }
        localCanvas.drawBitmap(paramMatrix, 0.0F, 0.0F, null);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "animateFinish", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements m<Matrix, Boolean, x>
  {
    a(b paramb, MotionEvent paramMotionEvent)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.b
 * JD-Core Version:    0.7.0.1
 */
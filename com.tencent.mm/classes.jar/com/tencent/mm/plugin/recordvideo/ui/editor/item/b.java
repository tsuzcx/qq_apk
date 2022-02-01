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
import com.tencent.mm.plugin.recordvideo.b.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.c.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ax;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "Landroid/graphics/Bitmap;", "bitmap", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "displayRect", "Landroid/graphics/Rect;", "getDisplayRect", "()Landroid/graphics/Rect;", "enableNotify", "", "getEnableNotify", "()Z", "setEnableNotify", "(Z)V", "frameDrawable", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "location", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "getLocation", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "setLocation", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;)V", "marginBottom", "getMarginBottom", "setMarginBottom", "navigateBarHeight", "getNavigateBarHeight", "originPivot", "", "paint", "Landroid/graphics/Paint;", "sourceDataType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "getSourceDataType", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "setSourceDataType", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;)V", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "text", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textBg", "getTextBg", "setTextBg", "textSize", "", "getTextSize", "()F", "setTextSize", "(F)V", "touchDownX", "getTouchDownX", "setTouchDownX", "touchDownY", "getTouchDownY", "setTouchDownY", "touchMoved", "getTouchMoved", "setTouchMoved", "touchSlop", "getTouchSlop", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validRect", "getValidRect", "Landroid/graphics/Matrix;", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "getContentBoundary", "getDrawRect", "Landroid/graphics/RectF;", "getSafeArea", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setDefaultLocation", "heightPercent", "setSafeArea", "safeRect", "damp", "setStateResolve", "setValidArea", "plugin-recordvideo_release"})
public abstract class b
  extends View
  implements h, com.tencent.mm.plugin.recordvideo.ui.editor.view.c
{
  private final Rect HXd = new Rect(0, 0, ax.au(MMApplicationContext.getContext()).x, ax.au(MMApplicationContext.getContext()).y);
  private final Rect HXe = new Rect(0, 0, ax.au(MMApplicationContext.getContext()).x, ax.au(MMApplicationContext.getContext()).y);
  private EditorItemContainer.b HXf;
  private Matrix IbA;
  private boolean IbB;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.view.a Ibu;
  private final int Ibv = ax.aB(MMApplicationContext.getContext());
  private int Ibw;
  private int Ibx;
  private l Iby;
  private d Ibz = d.IbG;
  private CharSequence LV;
  private Bitmap bitmap;
  private final int bvH;
  private int color;
  private boolean jKV;
  private float jKY;
  private float jKZ;
  private final Paint paint = new Paint();
  private float textSize = getResources().getDimension(b.c.editor_text_item_text_size);
  private final float[] uWJ = new float[2];
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c uWz = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
  
  public b(Context paramContext)
  {
    super(paramContext);
    this.uWz.aGO = 0.5F;
    this.uWz.aGN = 3.0F;
    Resources localResources = getResources();
    p.j(localResources, "resources");
    this.Ibu = new com.tencent.mm.plugin.recordvideo.ui.editor.view.a(localResources);
    paramContext = ViewConfiguration.get(paramContext);
    p.j(paramContext, "ViewConfiguration.get(context)");
    this.bvH = paramContext.getScaledTouchSlop();
    this.paint.setAntiAlias(true);
    this.IbB = true;
  }
  
  public final boolean PA(long paramLong)
  {
    return c.a.a(this, paramLong);
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    p.k(paramRect, "displayRect");
    this.HXe.set(paramRect);
    this.uWz.aHZ.postTranslate(paramRect.width() / 2.0F, paramRect.height() * paramFloat);
  }
  
  public final boolean aWf(String paramString)
  {
    p.k(paramString, "objID");
    return c.a.a(this, paramString);
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    p.k(paramRect, "safeRect");
    this.uWz.HGw = paramRect;
    this.uWz.IdR = com.tencent.mm.ci.a.fromDPToPix(getContext(), paramInt);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    if (this.bitmap == null) {
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.uWz.aHZ);
    if (paramMatrix != null) {
      localMatrix.postConcat(paramMatrix);
    }
    return (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(this.bitmap, localMatrix);
  }
  
  public a cYy()
  {
    if (this.bitmap == null) {
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.uWz.aHZ);
    if ((this.Ibz == d.IbG) || (this.Ibz == d.IbJ)) {
      return (a)new r(this.LV, this.color, this.Ibw, this.Ibx, localMatrix);
    }
    Object localObject1 = this.Iby;
    if (localObject1 == null) {
      p.iCn();
    }
    localObject1 = ((l)localObject1).Icv;
    Object localObject2 = this.Iby;
    if (localObject2 == null) {
      p.iCn();
    }
    localObject2 = ((l)localObject2).poiName;
    l locall = this.Iby;
    if (locall == null) {
      p.iCn();
    }
    float f = locall.longitude;
    locall = this.Iby;
    if (locall == null) {
      p.iCn();
    }
    return (a)new l((String)localObject1, (String)localObject2, f, locall.latitude, localMatrix);
  }
  
  public final boolean fyf()
  {
    return this.IbB;
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
    return (float[])this.uWz.IdW.clone();
  }
  
  protected final Rect getDisplayRect()
  {
    return this.HXe;
  }
  
  public RectF getDrawRect()
  {
    return new RectF(this.uWz.IdW[0], this.uWz.IdW[1], this.uWz.IdW[2], this.uWz.IdW[3]);
  }
  
  public final boolean getEnableNotify()
  {
    return this.IbB;
  }
  
  public final l getLocation()
  {
    return this.Iby;
  }
  
  public final int getMarginBottom()
  {
    return this.Ibx;
  }
  
  protected final int getNavigateBarHeight()
  {
    return this.Ibv;
  }
  
  public Rect getSafeArea()
  {
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
    return localObject;
  }
  
  public final d getSourceDataType()
  {
    return this.Ibz;
  }
  
  public final CharSequence getText()
  {
    return this.LV;
  }
  
  public final int getTextBg()
  {
    return this.Ibw;
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
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker()
  {
    return this.uWz;
  }
  
  protected final Rect getValidRect()
  {
    return this.HXd;
  }
  
  public final Matrix getViewMatrix()
  {
    return this.IbA;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    p.k(paramCanvas, "canvas");
    paramCanvas.save();
    if (this.IbA != null)
    {
      paramCanvas.setMatrix(this.IbA);
      if (isActivated()) {
        this.Ibu.draw(paramCanvas);
      }
      paramCanvas.restore();
      paramCanvas.clipRect(this.HXd);
      paramCanvas.save();
      if (this.IbA == null) {
        break label124;
      }
      paramCanvas.setMatrix(this.IbA);
    }
    for (;;)
    {
      if (this.bitmap != null)
      {
        Bitmap localBitmap = this.bitmap;
        if (localBitmap == null) {
          p.iCn();
        }
        paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, this.paint);
      }
      paramCanvas.restore();
      return;
      paramCanvas.setMatrix(this.uWz.aHZ);
      break;
      label124:
      paramCanvas.setMatrix(this.uWz.aHZ);
    }
  }
  
  public boolean onTouchEvent(final MotionEvent paramMotionEvent)
  {
    p.k(paramMotionEvent, "event");
    boolean bool2;
    Object localObject1;
    if ((paramMotionEvent.getActionMasked() != 3) && (paramMotionEvent.getActionMasked() != 1))
    {
      bool2 = this.uWz.ah(paramMotionEvent);
      bool1 = bool2;
      if (bool2)
      {
        bringToFront();
        localObject1 = this.HXf;
        if (localObject1 != null) {
          ((EditorItemContainer.b)localObject1).e((View)this, paramMotionEvent);
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
          this.jKY = paramMotionEvent.getX();
          this.jKZ = paramMotionEvent.getY();
          this.jKV = false;
          this.uWJ[0] = (this.uWz.width / 2.0F);
          this.uWJ[1] = (this.uWz.height / 2.0F);
          this.uWz.aHZ.mapPoints(this.uWJ);
          return bool1;
          f = Math.max(Math.abs(paramMotionEvent.getX() - this.jKY), Math.abs(paramMotionEvent.getY() - this.jKZ));
        } while (this.jKV);
        if (f > this.bvH) {}
        for (bool2 = true;; bool2 = false)
        {
          this.jKV = bool2;
          return bool1;
        }
      }
      localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
      Object localObject2 = this.HXd;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).aGO = this.uWz.aGO;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).aGN = this.uWz.aGN;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).o(new float[] { this.uWz.width / 2.0F, this.uWz.height / 2.0F });
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).f(new RectF(((Rect)localObject2).left, ((Rect)localObject2).top, ((Rect)localObject2).right, ((Rect)localObject2).bottom));
      localObject2 = new float[2];
      localObject2[0] = (this.uWz.width / 2.0F);
      localObject2[1] = (this.uWz.height / 2.0F);
      this.uWz.aHZ.mapPoints((float[])localObject2);
      if (!((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).IdC.contains(localObject2[0], localObject2[1])) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).f(new RectF(this.uWJ[0], this.uWJ[1], this.uWJ[0], this.uWJ[1]));
      }
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).a(this.uWz.aHZ, (m)new a(this, paramMotionEvent));
      return bool1;
    }
  }
  
  public final void setBitmap(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
    if (paramBitmap != null)
    {
      this.uWz.width = paramBitmap.getWidth();
      this.uWz.height = paramBitmap.getHeight();
      this.uWz.aHZ.preTranslate(-paramBitmap.getWidth() / 2.0F, -paramBitmap.getHeight() / 2.0F);
      this.Ibu.setBounds(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      this.uWz.p(new float[] { 0.0F, 0.0F, paramBitmap.getWidth(), 0.0F, 0.0F, paramBitmap.getHeight(), paramBitmap.getWidth(), paramBitmap.getHeight() });
    }
  }
  
  public final void setColor(int paramInt)
  {
    this.color = paramInt;
  }
  
  public final void setEnableNotify(boolean paramBoolean)
  {
    this.IbB = paramBoolean;
  }
  
  public final void setLocation(l paraml)
  {
    this.Iby = paraml;
  }
  
  public final void setMarginBottom(int paramInt)
  {
    this.Ibx = paramInt;
  }
  
  public final void setSourceDataType(d paramd)
  {
    p.k(paramd, "<set-?>");
    this.Ibz = paramd;
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    p.k(paramb, "stateResolve");
    this.HXf = paramb;
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    this.LV = paramCharSequence;
  }
  
  public final void setTextBg(int paramInt)
  {
    this.Ibw = paramInt;
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
    p.k(paramRect, "validRect");
    this.HXd.set(paramRect);
  }
  
  public final void setViewMatrix(Matrix paramMatrix)
  {
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
      if (this.bitmap != null)
      {
        paramMatrix = this.bitmap;
        if (paramMatrix == null) {
          p.iCn();
        }
        localCanvas.drawBitmap(paramMatrix, 0.0F, 0.0F, null);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "animateFinish", "", "invoke"})
  static final class a
    extends q
    implements m<Matrix, Boolean, x>
  {
    a(b paramb, MotionEvent paramMotionEvent)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.b
 * JD-Core Version:    0.7.0.1
 */
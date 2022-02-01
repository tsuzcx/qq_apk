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
import com.tencent.mm.plugin.recordvideo.ui.editor.view.d.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "Landroid/graphics/Bitmap;", "bitmap", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "displayRect", "Landroid/graphics/Rect;", "getDisplayRect", "()Landroid/graphics/Rect;", "enableNotify", "", "getEnableNotify", "()Z", "setEnableNotify", "(Z)V", "frameDrawable", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "location", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "getLocation", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "setLocation", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;)V", "marginBottom", "getMarginBottom", "setMarginBottom", "navigateBarHeight", "getNavigateBarHeight", "originPivot", "", "paint", "Landroid/graphics/Paint;", "sourceDataType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "getSourceDataType", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "setSourceDataType", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;)V", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "text", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textBg", "getTextBg", "setTextBg", "textSize", "", "getTextSize", "()F", "setTextSize", "(F)V", "touchDownX", "getTouchDownX", "setTouchDownX", "touchDownY", "getTouchDownY", "setTouchDownY", "touchMoved", "getTouchMoved", "setTouchMoved", "touchSlop", "getTouchSlop", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validRect", "getValidRect", "Landroid/graphics/Matrix;", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "getContentBoundary", "getDrawRect", "Landroid/graphics/RectF;", "getSafeArea", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setDefaultLocation", "heightPercent", "setSafeArea", "safeRect", "damp", "setStateResolve", "setValidArea", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
  extends View
  implements h, com.tencent.mm.plugin.recordvideo.ui.editor.view.d
{
  private int CMB;
  private final Rect NTO = new Rect(0, 0, bf.bf(MMApplicationContext.getContext()).x, bf.bf(MMApplicationContext.getContext()).y);
  private final Rect NTP = new Rect(0, 0, bf.bf(MMApplicationContext.getContext()).x, bf.bf(MMApplicationContext.getContext()).y);
  private EditorItemContainer.b NTQ;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.view.a NXT;
  private final int NXU = bf.bk(MMApplicationContext.getContext());
  private int NXV;
  private l NXW;
  private d NXX = d.NYd;
  private Matrix NXY;
  private boolean NXZ;
  private CharSequence bba;
  private Bitmap bitmap;
  private int color;
  private final int doK;
  private boolean mkh;
  private float mkk;
  private float mkl;
  private final Paint paint = new Paint();
  private float textSize = getResources().getDimension(b.c.editor_text_item_text_size);
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c yiZ = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
  private final float[] yji = new float[2];
  
  public b(Context paramContext)
  {
    super(paramContext);
    this.yiZ.minScale = 0.5F;
    this.yiZ.maxScale = 3.0F;
    Resources localResources = getResources();
    s.s(localResources, "resources");
    this.NXT = new com.tencent.mm.plugin.recordvideo.ui.editor.view.a(localResources);
    this.doK = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.paint.setAntiAlias(true);
    this.NXZ = true;
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    s.u(paramRect, "displayRect");
    this.NTP.set(paramRect);
    this.yiZ.matrix.postTranslate(paramRect.width() / 2.0F, paramRect.height() * paramFloat);
  }
  
  public final boolean aTn(String paramString)
  {
    return d.a.a(this, paramString);
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    s.u(paramRect, "safeRect");
    this.yiZ.NDV = paramRect;
    this.yiZ.Oah = com.tencent.mm.cd.a.fromDPToPix(getContext(), paramInt);
  }
  
  public a dEP()
  {
    if (this.bitmap == null) {
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.yiZ.matrix);
    if ((this.NXX == d.NYd) || (this.NXX == d.NYg)) {
      return (a)new r(this.bba, this.color, this.NXV, this.CMB, localMatrix);
    }
    Object localObject1 = this.NXW;
    s.checkNotNull(localObject1);
    localObject1 = ((l)localObject1).NYS;
    Object localObject2 = this.NXW;
    s.checkNotNull(localObject2);
    localObject2 = ((l)localObject2).poiName;
    l locall = this.NXW;
    s.checkNotNull(locall);
    float f = locall.longitude;
    locall = this.NXW;
    s.checkNotNull(locall);
    return (a)new l((String)localObject1, (String)localObject2, f, locall.latitude, localMatrix);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a e(Matrix paramMatrix)
  {
    if (this.bitmap == null) {
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.yiZ.matrix);
    if (paramMatrix != null) {
      localMatrix.postConcat(paramMatrix);
    }
    return (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(this.bitmap, localMatrix);
  }
  
  public final boolean gJS()
  {
    return this.NXZ;
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
    return (float[])this.yiZ.Oam.clone();
  }
  
  protected final Rect getDisplayRect()
  {
    return this.NTP;
  }
  
  public RectF getDrawRect()
  {
    return new RectF(this.yiZ.Oam[0], this.yiZ.Oam[1], this.yiZ.Oam[2], this.yiZ.Oam[3]);
  }
  
  public final boolean getEnableNotify()
  {
    return this.NXZ;
  }
  
  public final l getLocation()
  {
    return this.NXW;
  }
  
  public final int getMarginBottom()
  {
    return this.CMB;
  }
  
  protected final int getNavigateBarHeight()
  {
    return this.NXU;
  }
  
  public Rect getSafeArea()
  {
    Rect localRect2 = this.yiZ.NDV;
    Rect localRect1 = localRect2;
    if (localRect2 == null) {
      localRect1 = new Rect(0, 0, getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels);
    }
    return localRect1;
  }
  
  public final d getSourceDataType()
  {
    return this.NXX;
  }
  
  public final CharSequence getText()
  {
    return this.bba;
  }
  
  public final int getTextBg()
  {
    return this.NXV;
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
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker()
  {
    return this.yiZ;
  }
  
  protected final Rect getValidRect()
  {
    return this.NTO;
  }
  
  public final Matrix getViewMatrix()
  {
    return this.NXY;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    s.u(paramCanvas, "canvas");
    paramCanvas.save();
    if (this.NXY != null)
    {
      paramCanvas.setMatrix(this.NXY);
      if (isActivated()) {
        this.NXT.draw(paramCanvas);
      }
      paramCanvas.restore();
      paramCanvas.clipRect(this.NTO);
      paramCanvas.save();
      if (this.NXY == null) {
        break label121;
      }
      paramCanvas.setMatrix(this.NXY);
    }
    for (;;)
    {
      if (this.bitmap != null)
      {
        Bitmap localBitmap = this.bitmap;
        s.checkNotNull(localBitmap);
        paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, this.paint);
      }
      paramCanvas.restore();
      return;
      paramCanvas.setMatrix(this.yiZ.matrix);
      break;
      label121:
      paramCanvas.setMatrix(this.yiZ.matrix);
    }
  }
  
  public boolean onTouchEvent(final MotionEvent paramMotionEvent)
  {
    s.u(paramMotionEvent, "event");
    boolean bool2;
    Object localObject1;
    if ((paramMotionEvent.getActionMasked() != 3) && (paramMotionEvent.getActionMasked() != 1))
    {
      bool2 = this.yiZ.ak(paramMotionEvent);
      bool1 = bool2;
      if (bool2)
      {
        bringToFront();
        localObject1 = this.NTQ;
        if (localObject1 != null) {
          ((EditorItemContainer.b)localObject1).l((View)this, paramMotionEvent);
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
          this.mkk = paramMotionEvent.getX();
          this.mkl = paramMotionEvent.getY();
          this.mkh = false;
          this.yji[0] = (this.yiZ.width / 2.0F);
          this.yji[1] = (this.yiZ.height / 2.0F);
          this.yiZ.matrix.mapPoints(this.yji);
          return bool1;
          f = Math.max(Math.abs(paramMotionEvent.getX() - this.mkk), Math.abs(paramMotionEvent.getY() - this.mkl));
        } while (this.mkh);
        if (f > this.doK) {}
        for (bool2 = true;; bool2 = false)
        {
          this.mkh = bool2;
          return bool1;
        }
      }
      localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
      Object localObject2 = this.NTO;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).minScale = this.yiZ.minScale;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).maxScale = this.yiZ.maxScale;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).w(new float[] { this.yiZ.width / 2.0F, this.yiZ.height / 2.0F });
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).g(new RectF(((Rect)localObject2).left, ((Rect)localObject2).top, ((Rect)localObject2).right, ((Rect)localObject2).bottom));
      localObject2 = new float[2];
      localObject2[0] = (this.yiZ.width / 2.0F);
      localObject2[1] = (this.yiZ.height / 2.0F);
      this.yiZ.matrix.mapPoints((float[])localObject2);
      if (!((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).NZY.contains(localObject2[0], localObject2[1])) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).g(new RectF(this.yji[0], this.yji[1], this.yji[0], this.yji[1]));
      }
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).a(this.yiZ.matrix, (m)new a(this, paramMotionEvent));
      return bool1;
    }
  }
  
  public final void setBitmap(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
    if (paramBitmap != null)
    {
      this.yiZ.width = paramBitmap.getWidth();
      this.yiZ.height = paramBitmap.getHeight();
      this.yiZ.matrix.preTranslate(-paramBitmap.getWidth() / 2.0F, -paramBitmap.getHeight() / 2.0F);
      this.NXT.setBounds(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      this.yiZ.x(new float[] { 0.0F, 0.0F, paramBitmap.getWidth(), 0.0F, 0.0F, paramBitmap.getHeight(), paramBitmap.getWidth(), paramBitmap.getHeight() });
    }
  }
  
  public final void setColor(int paramInt)
  {
    this.color = paramInt;
  }
  
  public final void setEnableNotify(boolean paramBoolean)
  {
    this.NXZ = paramBoolean;
  }
  
  public final void setLocation(l paraml)
  {
    this.NXW = paraml;
  }
  
  public final void setMarginBottom(int paramInt)
  {
    this.CMB = paramInt;
  }
  
  public final void setSourceDataType(d paramd)
  {
    s.u(paramd, "<set-?>");
    this.NXX = paramd;
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    s.u(paramb, "stateResolve");
    this.NTQ = paramb;
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    this.bba = paramCharSequence;
  }
  
  public final void setTextBg(int paramInt)
  {
    this.NXV = paramInt;
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
    s.u(paramRect, "validRect");
    this.NTO.set(paramRect);
  }
  
  public final void setViewMatrix(Matrix paramMatrix)
  {
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
      if (this.bitmap != null)
      {
        paramMatrix = this.bitmap;
        s.checkNotNull(paramMatrix);
        localCanvas.drawBitmap(paramMatrix, 0.0F, 0.0F, null);
      }
    }
  }
  
  public final boolean tA(long paramLong)
  {
    return d.a.a(this, paramLong);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "animateFinish", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<Matrix, Boolean, ah>
  {
    a(b paramb, MotionEvent paramMotionEvent)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.b
 * JD-Core Version:    0.7.0.1
 */
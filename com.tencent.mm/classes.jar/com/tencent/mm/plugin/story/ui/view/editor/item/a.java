package com.tencent.mm.plugin.story.ui.view.editor.item;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.editor.a.b;
import com.tencent.mm.media.editor.a.d;
import com.tencent.mm.media.editor.a.e;
import com.tencent.mm.media.editor.a.h;
import com.tencent.mm.media.editor.a.i;
import com.tencent.mm.media.editor.a.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.am;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/editor/item/BitmapItemView;", "Landroid/view/View;", "Lcom/tencent/mm/media/editor/item/IEditable;", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "Landroid/graphics/Bitmap;", "bitmap", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "frameDrawable", "Lcom/tencent/mm/media/editor/view/ActiveFrameDrawable;", "location", "Lcom/tencent/mm/media/editor/item/LocationItem;", "getLocation", "()Lcom/tencent/mm/media/editor/item/LocationItem;", "setLocation", "(Lcom/tencent/mm/media/editor/item/LocationItem;)V", "marginBottom", "getMarginBottom", "setMarginBottom", "navigateBarHeight", "getNavigateBarHeight", "sourceDataType", "Lcom/tencent/mm/media/editor/item/EditorDataType;", "getSourceDataType", "()Lcom/tencent/mm/media/editor/item/EditorDataType;", "setSourceDataType", "(Lcom/tencent/mm/media/editor/item/EditorDataType;)V", "stateResolve", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer$ItemStateResolve;", "text", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textBg", "getTextBg", "setTextBg", "textSize", "", "getTextSize", "()F", "setTextSize", "(F)V", "touchDownX", "getTouchDownX", "setTouchDownX", "touchDownY", "getTouchDownY", "setTouchDownY", "touchMoved", "", "getTouchMoved", "()Z", "setTouchMoved", "(Z)V", "touchSlop", "getTouchSlop", "touchTracker", "Lcom/tencent/mm/media/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/media/editor/touch/TouchTracker;", "Landroid/graphics/Matrix;", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "createEditorData", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "getContentBoundary", "", "getSafeArea", "Landroid/graphics/Rect;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setSafeArea", "safeRect", "damp", "setStateResolve", "setValidArea", "validRect", "heightPercent", "plugin-story_release"})
public class a
  extends View
  implements h, c
{
  private Bitmap bitmap;
  private int color;
  private int eTk;
  private float lAn;
  private float lAo;
  private boolean lAp;
  private final com.tencent.mm.media.editor.c.c lwb;
  private final int nwj;
  private final com.tencent.mm.media.editor.view.a sQp;
  private EditorItemContainer.b sQq;
  private final int sQr;
  private int sQs;
  private i sQt;
  private e sQu;
  private Matrix sQv;
  private CharSequence text;
  private float textSize;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(110631);
    this.lwb = new com.tencent.mm.media.editor.c.c();
    this.sQr = am.fx(ah.getContext());
    this.textSize = getResources().getDimension(2131428342);
    this.sQu = e.eSC;
    this.lwb.arK = 0.5F;
    this.lwb.arJ = 3.0F;
    Resources localResources = getResources();
    j.p(localResources, "resources");
    this.sQp = new com.tencent.mm.media.editor.view.a(localResources);
    paramContext = ViewConfiguration.get(paramContext);
    j.p(paramContext, "ViewConfiguration.get(context)");
    this.nwj = paramContext.getScaledTouchSlop();
    AppMethodBeat.o(110631);
  }
  
  public final b UH()
  {
    AppMethodBeat.i(110626);
    if (this.bitmap == null)
    {
      AppMethodBeat.o(110626);
      return null;
    }
    b localb = (b)new d(this.bitmap, this.lwb.asO);
    AppMethodBeat.o(110626);
    return localb;
  }
  
  public final com.tencent.mm.media.editor.a.a UI()
  {
    AppMethodBeat.i(110627);
    if (this.bitmap == null)
    {
      AppMethodBeat.o(110627);
      return null;
    }
    if ((this.sQu == e.eSC) || (this.sQu == e.eSF))
    {
      localObject = (com.tencent.mm.media.editor.a.a)new m(this.text, this.color, this.sQs, this.eTk, this.sQu, this.lwb.asO);
      AppMethodBeat.o(110627);
      return localObject;
    }
    Object localObject = this.sQt;
    if (localObject == null) {
      j.ebi();
    }
    localObject = ((i)localObject).eSL;
    i locali = this.sQt;
    if (locali == null) {
      j.ebi();
    }
    localObject = (com.tencent.mm.media.editor.a.a)new i((String)localObject, locali.eSM, this.lwb.asO);
    AppMethodBeat.o(110627);
    return localObject;
  }
  
  public void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(151243);
    j.q(paramRect, "validRect");
    this.lwb.asO.postTranslate(paramRect.width() / 2.0F, paramRect.height() * paramFloat);
    AppMethodBeat.o(151243);
  }
  
  public final void c(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(151244);
    j.q(paramRect, "safeRect");
    this.lwb.eTC = paramRect;
    this.lwb.eTD = com.tencent.mm.cb.a.fromDPToPix(getContext(), paramInt);
    AppMethodBeat.o(151244);
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
    AppMethodBeat.i(110630);
    float[] arrayOfFloat = (float[])this.lwb.eTI.clone();
    AppMethodBeat.o(110630);
    return arrayOfFloat;
  }
  
  public final i getLocation()
  {
    return this.sQt;
  }
  
  public final int getMarginBottom()
  {
    return this.eTk;
  }
  
  protected final int getNavigateBarHeight()
  {
    return this.sQr;
  }
  
  public Rect getSafeArea()
  {
    AppMethodBeat.i(110629);
    Rect localRect = this.lwb.eTC;
    Object localObject = localRect;
    if (localRect == null)
    {
      localObject = getResources();
      j.p(localObject, "resources");
      int i = ((Resources)localObject).getDisplayMetrics().widthPixels;
      localObject = getResources();
      j.p(localObject, "resources");
      localObject = new Rect(0, 0, i, ((Resources)localObject).getDisplayMetrics().heightPixels);
    }
    AppMethodBeat.o(110629);
    return localObject;
  }
  
  public final e getSourceDataType()
  {
    return this.sQu;
  }
  
  public final CharSequence getText()
  {
    return this.text;
  }
  
  public final int getTextBg()
  {
    return this.sQs;
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
  
  public final Matrix getViewMatrix()
  {
    return this.sQv;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(110625);
    j.q(paramCanvas, "canvas");
    paramCanvas.save();
    if (this.sQv != null) {
      paramCanvas.setMatrix(this.sQv);
    }
    for (;;)
    {
      if (isActivated()) {
        this.sQp.draw(paramCanvas);
      }
      if (this.bitmap != null) {
        paramCanvas.drawBitmap(this.bitmap, 0.0F, 0.0F, null);
      }
      paramCanvas.restore();
      AppMethodBeat.o(110625);
      return;
      paramCanvas.setMatrix(this.lwb.asO);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(110624);
    j.q(paramMotionEvent, "event");
    boolean bool2 = this.lwb.u(paramMotionEvent);
    if (bool2)
    {
      bringToFront();
      EditorItemContainer.b localb = this.sQq;
      if (localb != null) {
        localb.e((View)this, paramMotionEvent);
      }
      postInvalidate();
    }
    if (bool2) {
      switch (paramMotionEvent.getActionMasked())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(110624);
      return bool2;
      this.lAn = paramMotionEvent.getX();
      this.lAo = paramMotionEvent.getY();
      this.lAp = false;
      continue;
      float f = Math.max(Math.abs(paramMotionEvent.getX() - this.lAn), Math.abs(paramMotionEvent.getY() - this.lAo));
      if (!this.lAp)
      {
        if (f > this.nwj) {}
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
  
  public final void setBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(110620);
    this.bitmap = paramBitmap;
    if (paramBitmap != null)
    {
      this.lwb.width = paramBitmap.getWidth();
      this.lwb.height = paramBitmap.getHeight();
      this.lwb.asO.preTranslate(-paramBitmap.getWidth() / 2.0F, -paramBitmap.getHeight() / 2.0F);
      this.sQp.setBounds(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      this.lwb.h(new float[] { 0.0F, 0.0F, paramBitmap.getWidth(), 0.0F, 0.0F, paramBitmap.getHeight(), paramBitmap.getWidth(), paramBitmap.getHeight() });
    }
    AppMethodBeat.o(110620);
  }
  
  public final void setColor(int paramInt)
  {
    this.color = paramInt;
  }
  
  public final void setLocation(i parami)
  {
    this.sQt = parami;
  }
  
  public final void setMarginBottom(int paramInt)
  {
    this.eTk = paramInt;
  }
  
  public final void setSourceDataType(e parame)
  {
    AppMethodBeat.i(110619);
    j.q(parame, "<set-?>");
    this.sQu = parame;
    AppMethodBeat.o(110619);
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(110623);
    j.q(paramb, "stateResolve");
    this.sQq = paramb;
    AppMethodBeat.o(110623);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    this.text = paramCharSequence;
  }
  
  public final void setTextBg(int paramInt)
  {
    this.sQs = paramInt;
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
  
  public final void setViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(110621);
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
      if (this.bitmap != null) {
        localCanvas.drawBitmap(this.bitmap, 0.0F, 0.0F, null);
      }
    }
    AppMethodBeat.o(110621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.item.a
 * JD-Core Version:    0.7.0.1
 */
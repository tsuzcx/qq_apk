package com.tencent.mm.plugin.multitask.animation.c.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bd;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "contentBitmap", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/graphics/Bitmap;)V", "<set-?>", "getContentBitmap", "()Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/GradientDrawable;", "gradientDrawable", "getGradientDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "mClipPath", "Landroid/graphics/Path;", "mDrawRect", "Landroid/graphics/Rect;", "mDstRect", "mHeight", "", "mMaskAlpha", "mMaskPaint", "Landroid/graphics/Paint;", "mMaskRect", "Landroid/graphics/RectF;", "mPaint", "mRectConnerRadius", "", "mRotate", "", "mUseGradient", "", "mWidth", "init", "", "bitmap", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setGradientOrientation", "orientation", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "setMaskAlpha", "maskAlpha", "setMaskRect", "left", "top", "right", "buttom", "setRectConnerRadius", "radll", "radlt", "radtl", "radtt", "radrl", "radrt", "radbl", "radbt", "setRotate", "degree", "setViewSize", "width", "height", "Companion", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends View
{
  private static final int LBF;
  public static final c.a LCk;
  private GradientDrawable LBB;
  private final float[] LBE;
  private Bitmap LBz;
  private boolean LCl;
  private Rect bre;
  private float ciR;
  private int mHeight;
  private Paint mPaint;
  private int mWidth;
  private int vmA;
  private Paint vmC;
  private Path vqG;
  private Rect vqH;
  private RectF vqI;
  
  static
  {
    AppMethodBeat.i(304071);
    LCk = new c.a((byte)0);
    LBF = bd.fromDPToPix(MMApplicationContext.getContext(), 8);
    AppMethodBeat.o(304071);
  }
  
  public c(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext);
    AppMethodBeat.i(304058);
    this.LCl = true;
    this.LBE = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, LBF, LBF, LBF, LBF };
    this.mPaint = new Paint();
    this.vqG = new Path();
    this.vmC = new Paint();
    PorterDuffXfermode localPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    Paint localPaint = this.vmC;
    paramContext = localPaint;
    if (localPaint == null)
    {
      s.bIx("mMaskPaint");
      paramContext = null;
    }
    paramContext.setXfermode((Xfermode)localPorterDuffXfermode);
    this.LBz = paramBitmap;
    this.mWidth = ((int)(paramBitmap.getWidth() * 1.25F));
    this.mHeight = ((int)(paramBitmap.getHeight() * 1.25F));
    this.vqH = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    this.bre = new Rect(0, 0, this.mWidth, this.mHeight);
    this.vqI = new RectF();
    paramBitmap = this.vqI;
    paramContext = paramBitmap;
    if (paramBitmap == null)
    {
      s.bIx("mMaskRect");
      paramContext = null;
    }
    paramContext.left = 0.0F;
    paramBitmap = this.vqI;
    paramContext = paramBitmap;
    if (paramBitmap == null)
    {
      s.bIx("mMaskRect");
      paramContext = null;
    }
    paramContext.top = 0.0F;
    paramBitmap = this.vqI;
    paramContext = paramBitmap;
    if (paramBitmap == null)
    {
      s.bIx("mMaskRect");
      paramContext = null;
    }
    paramContext.right = this.mWidth;
    paramBitmap = this.vqI;
    paramContext = paramBitmap;
    if (paramBitmap == null)
    {
      s.bIx("mMaskRect");
      paramContext = null;
    }
    paramContext.bottom = this.mHeight;
    int i = Color.argb(230, 0, 0, 0);
    int j = Color.argb(76, 0, 0, 0);
    int k = Color.argb(0, 0, 0, 0);
    this.LBB = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, j, k });
    paramContext = this.LBB;
    if (paramContext != null) {
      paramContext.setGradientType(0);
    }
    paramContext = this.LBB;
    if (paramContext != null) {
      paramContext.setGradientCenter(0.5F, 0.4F);
    }
    paramBitmap = this.LBB;
    if (paramBitmap != null)
    {
      paramContext = this.bre;
      if (paramContext != null) {
        break label519;
      }
      s.bIx("mDstRect");
      paramContext = localObject;
    }
    label519:
    for (;;)
    {
      paramBitmap.setBounds(paramContext);
      paramContext = am.aixg;
      paramContext = String.format("default init: mWidth:%d mHeight:%d", Arrays.copyOf(new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) }, 2));
      s.s(paramContext, "java.lang.String.format(format, *args)");
      Log.i("MicroMsg.TransformSwipeBackToMultiTaskView", paramContext);
      AppMethodBeat.o(304058);
      return;
    }
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    this.LBE[0] = paramFloat1;
    this.LBE[1] = paramFloat2;
    this.LBE[2] = paramFloat3;
    this.LBE[3] = paramFloat4;
    this.LBE[4] = paramFloat5;
    this.LBE[5] = paramFloat6;
    this.LBE[6] = paramFloat7;
    this.LBE[7] = paramFloat8;
  }
  
  public final Bitmap getContentBitmap()
  {
    return this.LBz;
  }
  
  public final GradientDrawable getGradientDrawable()
  {
    return this.LBB;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    Object localObject3 = null;
    AppMethodBeat.i(304093);
    s.u(paramCanvas, "canvas");
    Object localObject2 = this.vqG;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("mClipPath");
      localObject1 = null;
    }
    ((Path)localObject1).reset();
    localObject2 = this.vqG;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("mClipPath");
      localObject1 = null;
    }
    Object localObject4 = this.vqI;
    localObject2 = localObject4;
    if (localObject4 == null)
    {
      s.bIx("mMaskRect");
      localObject2 = null;
    }
    ((Path)localObject1).addRoundRect((RectF)localObject2, this.LBE, Path.Direction.CW);
    localObject2 = this.vqG;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("mClipPath");
      localObject1 = null;
    }
    paramCanvas.clipPath((Path)localObject1);
    Bitmap localBitmap = this.LBz;
    int i;
    if (localBitmap != null)
    {
      i = paramCanvas.save();
      float f1 = this.ciR;
      localObject2 = this.vqI;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mMaskRect");
        localObject1 = null;
      }
      float f2 = ((RectF)localObject1).centerX();
      localObject2 = this.vqI;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mMaskRect");
        localObject1 = null;
      }
      paramCanvas.rotate(f1, f2, ((RectF)localObject1).centerY());
      localObject2 = this.vqH;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mDrawRect");
        localObject1 = null;
      }
      localObject4 = this.bre;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("mDstRect");
        localObject2 = null;
      }
      localObject4 = this.mPaint;
      if (localObject4 != null) {
        break label344;
      }
      s.bIx("mPaint");
    }
    for (;;)
    {
      paramCanvas.drawBitmap(localBitmap, (Rect)localObject1, (Rect)localObject2, (Paint)localObject3);
      if (this.LCl)
      {
        localObject1 = getGradientDrawable();
        if (localObject1 != null)
        {
          ((GradientDrawable)localObject1).setAlpha(this.vmA);
          ((GradientDrawable)localObject1).draw(paramCanvas);
        }
      }
      paramCanvas.restoreToCount(i);
      AppMethodBeat.o(304093);
      return;
      label344:
      localObject3 = localObject4;
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(304100);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    AppMethodBeat.o(304100);
  }
  
  public final void setGradientOrientation(GradientDrawable.Orientation paramOrientation)
  {
    AppMethodBeat.i(304123);
    s.u(paramOrientation, "orientation");
    GradientDrawable localGradientDrawable = this.LBB;
    if (localGradientDrawable != null) {
      localGradientDrawable.setOrientation(paramOrientation);
    }
    AppMethodBeat.o(304123);
  }
  
  public final void setMaskAlpha(int paramInt)
  {
    this.vmA = paramInt;
  }
  
  public final void setRotate(float paramFloat)
  {
    this.ciR = paramFloat;
  }
  
  public final void t(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(304109);
    RectF localRectF2 = this.vqI;
    RectF localRectF1 = localRectF2;
    if (localRectF2 == null)
    {
      s.bIx("mMaskRect");
      localRectF1 = null;
    }
    localRectF1.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    AppMethodBeat.o(304109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.c.a.c
 * JD-Core Version:    0.7.0.1
 */
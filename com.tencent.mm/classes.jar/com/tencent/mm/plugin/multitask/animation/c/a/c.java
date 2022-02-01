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
import com.tencent.mm.ui.aw;
import java.util.Arrays;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "contentBitmap", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/graphics/Bitmap;)V", "<set-?>", "getContentBitmap", "()Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/GradientDrawable;", "gradientDrawable", "getGradientDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "mClipPath", "Landroid/graphics/Path;", "mDrawRect", "Landroid/graphics/Rect;", "mDstRect", "mHeight", "", "mMaskAlpha", "mMaskPaint", "Landroid/graphics/Paint;", "mMaskRect", "Landroid/graphics/RectF;", "mPaint", "mRectConnerRadius", "", "mRotate", "", "mUseGradient", "", "mWidth", "init", "", "bitmap", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setGradientOrientation", "orientation", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "setMaskAlpha", "maskAlpha", "setMaskRect", "left", "top", "right", "buttom", "setRectConnerRadius", "radll", "radlt", "radtl", "radtt", "radrl", "radrt", "radbl", "radbt", "setRotate", "degree", "setViewSize", "width", "height", "Companion", "plugin-multitask_release"})
public final class c
  extends View
{
  private static final int FFI;
  public static final c.a FGt;
  private Bitmap FFC;
  private GradientDrawable FFE;
  private final float[] FFH;
  private boolean FGs;
  private Rect KV;
  private float auu;
  private int mHeight;
  private Paint mPaint;
  private int mWidth;
  private int sbi;
  private Paint sbk;
  private Path seT;
  private Rect seU;
  private RectF seV;
  
  static
  {
    AppMethodBeat.i(248971);
    FGt = new c.a((byte)0);
    FFI = aw.fromDPToPix(MMApplicationContext.getContext(), 8);
    AppMethodBeat.o(248971);
  }
  
  public c(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext);
    AppMethodBeat.i(248970);
    this.FGs = true;
    this.FFH = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, FFI, FFI, FFI, FFI };
    this.mPaint = new Paint();
    this.seT = new Path();
    this.sbk = new Paint();
    paramContext = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    Paint localPaint = this.sbk;
    if (localPaint == null) {
      p.bGy("mMaskPaint");
    }
    localPaint.setXfermode((Xfermode)paramContext);
    this.FFC = paramBitmap;
    this.mWidth = ((int)(paramBitmap.getWidth() * 1.25F));
    this.mHeight = ((int)(paramBitmap.getHeight() * 1.25F));
    this.seU = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    this.KV = new Rect(0, 0, this.mWidth, this.mHeight);
    this.seV = new RectF();
    paramContext = this.seV;
    if (paramContext == null) {
      p.bGy("mMaskRect");
    }
    paramContext.left = 0.0F;
    paramContext = this.seV;
    if (paramContext == null) {
      p.bGy("mMaskRect");
    }
    paramContext.top = 0.0F;
    paramContext = this.seV;
    if (paramContext == null) {
      p.bGy("mMaskRect");
    }
    paramContext.right = this.mWidth;
    paramContext = this.seV;
    if (paramContext == null) {
      p.bGy("mMaskRect");
    }
    paramContext.bottom = this.mHeight;
    int i = Color.argb(230, 0, 0, 0);
    int j = Color.argb(76, 0, 0, 0);
    int k = Color.argb(0, 0, 0, 0);
    this.FFE = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, j, k });
    paramContext = this.FFE;
    if (paramContext != null) {
      paramContext.setGradientType(0);
    }
    paramContext = this.FFE;
    if (paramContext != null) {
      paramContext.setGradientCenter(0.5F, 0.4F);
    }
    paramContext = this.FFE;
    if (paramContext != null)
    {
      paramBitmap = this.KV;
      if (paramBitmap == null) {
        p.bGy("mDstRect");
      }
      paramContext.setBounds(paramBitmap);
    }
    paramContext = af.aaBG;
    paramContext = String.format("default init: mWidth:%d mHeight:%d", Arrays.copyOf(new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) }, 2));
    p.j(paramContext, "java.lang.String.format(format, *args)");
    Log.i("MicroMsg.TransformSwipeBackToMultiTaskView", paramContext);
    AppMethodBeat.o(248970);
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    this.FFH[0] = paramFloat1;
    this.FFH[1] = paramFloat2;
    this.FFH[2] = paramFloat3;
    this.FFH[3] = paramFloat4;
    this.FFH[4] = paramFloat5;
    this.FFH[5] = paramFloat6;
    this.FFH[6] = paramFloat7;
    this.FFH[7] = paramFloat8;
  }
  
  public final Bitmap getContentBitmap()
  {
    return this.FFC;
  }
  
  public final GradientDrawable getGradientDrawable()
  {
    return this.FFE;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(248958);
    p.k(paramCanvas, "canvas");
    Object localObject1 = this.seT;
    if (localObject1 == null) {
      p.bGy("mClipPath");
    }
    ((Path)localObject1).reset();
    localObject1 = this.seT;
    if (localObject1 == null) {
      p.bGy("mClipPath");
    }
    Object localObject2 = this.seV;
    if (localObject2 == null) {
      p.bGy("mMaskRect");
    }
    ((Path)localObject1).addRoundRect((RectF)localObject2, this.FFH, Path.Direction.CW);
    localObject1 = this.seT;
    if (localObject1 == null) {
      p.bGy("mClipPath");
    }
    paramCanvas.clipPath((Path)localObject1);
    localObject1 = this.FFC;
    if (localObject1 != null)
    {
      int i = paramCanvas.save();
      float f1 = this.auu;
      localObject2 = this.seV;
      if (localObject2 == null) {
        p.bGy("mMaskRect");
      }
      float f2 = ((RectF)localObject2).centerX();
      localObject2 = this.seV;
      if (localObject2 == null) {
        p.bGy("mMaskRect");
      }
      paramCanvas.rotate(f1, f2, ((RectF)localObject2).centerY());
      localObject2 = this.seU;
      if (localObject2 == null) {
        p.bGy("mDrawRect");
      }
      Rect localRect = this.KV;
      if (localRect == null) {
        p.bGy("mDstRect");
      }
      Paint localPaint = this.mPaint;
      if (localPaint == null) {
        p.bGy("mPaint");
      }
      paramCanvas.drawBitmap((Bitmap)localObject1, (Rect)localObject2, localRect, localPaint);
      if (this.FGs)
      {
        localObject1 = this.FFE;
        if (localObject1 != null)
        {
          ((GradientDrawable)localObject1).setAlpha(this.sbi);
          ((GradientDrawable)localObject1).draw(paramCanvas);
        }
      }
      paramCanvas.restoreToCount(i);
      AppMethodBeat.o(248958);
      return;
    }
    AppMethodBeat.o(248958);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248959);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    AppMethodBeat.o(248959);
  }
  
  public final void p(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(248960);
    RectF localRectF = this.seV;
    if (localRectF == null) {
      p.bGy("mMaskRect");
    }
    localRectF.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    AppMethodBeat.o(248960);
  }
  
  public final void setGradientOrientation(GradientDrawable.Orientation paramOrientation)
  {
    AppMethodBeat.i(248965);
    p.k(paramOrientation, "orientation");
    GradientDrawable localGradientDrawable = this.FFE;
    if (localGradientDrawable != null)
    {
      localGradientDrawable.setOrientation(paramOrientation);
      AppMethodBeat.o(248965);
      return;
    }
    AppMethodBeat.o(248965);
  }
  
  public final void setMaskAlpha(int paramInt)
  {
    this.sbi = paramInt;
  }
  
  public final void setRotate(float paramFloat)
  {
    this.auu = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.c.a.c
 * JD-Core Version:    0.7.0.1
 */
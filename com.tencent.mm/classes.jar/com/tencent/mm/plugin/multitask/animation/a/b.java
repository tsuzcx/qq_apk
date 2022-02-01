package com.tencent.mm.plugin.multitask.animation.a;

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
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import java.util.Arrays;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterToMultiTaskDefaultView;", "Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterBaseView;", "context", "Landroid/content/Context;", "contentBitmap", "Landroid/graphics/Bitmap;", "defaultBlt", "(Landroid/content/Context;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V", "<set-?>", "getContentBitmap", "()Landroid/graphics/Bitmap;", "defaultIcon", "getDefaultIcon", "Landroid/graphics/drawable/GradientDrawable;", "gradientDrawable", "getGradientDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "mClipPath", "Landroid/graphics/Path;", "mDrawDefaultRect", "Landroid/graphics/Rect;", "mDrawRect", "mDstDefaultRect", "mDstRect", "mHeight", "", "mMaskAlpha", "mMaskPaint", "Landroid/graphics/Paint;", "mMaskRect", "Landroid/graphics/RectF;", "mPaint", "mRectConnerRadius", "", "mWidth", "init", "", "bitmap", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setDefaultDstRect", "dstRect", "setDstRect", "setMaskAlpha", "maskAlpha", "setMaskRect", "left", "", "top", "right", "buttom", "setRectConnerRadius", "radll", "radlt", "radtl", "radtt", "radrl", "radrt", "radbl", "radbt", "setViewSize", "width", "height", "Companion", "plugin-multitask_release"})
public final class b
  extends a
{
  private static final int FFI;
  public static final b.a FFJ;
  private Bitmap FFC;
  private Bitmap FFD;
  private GradientDrawable FFE;
  private Rect FFF;
  private Rect FFG;
  private final float[] FFH;
  private Rect KV;
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
    AppMethodBeat.i(247832);
    FFJ = new b.a((byte)0);
    FFI = aw.fromDPToPix(MMApplicationContext.getContext(), 8);
    AppMethodBeat.o(247832);
  }
  
  public b(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    super(paramContext);
    AppMethodBeat.i(247830);
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
    this.FFC = paramBitmap1;
    this.FFD = paramBitmap2;
    this.mWidth = ((int)(paramBitmap1.getWidth() * 1.25F));
    this.mHeight = ((int)(paramBitmap1.getHeight() * 1.25F));
    this.seU = new Rect(0, 0, paramBitmap1.getWidth(), paramBitmap1.getHeight());
    int i;
    if (paramBitmap2 != null)
    {
      i = paramBitmap2.getWidth();
      if (paramBitmap2 == null) {
        break label536;
      }
    }
    label536:
    for (int j = paramBitmap2.getHeight();; j = 0)
    {
      this.FFF = new Rect(0, 0, i, j);
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
      i = Color.argb(230, 0, 0, 0);
      j = Color.argb(76, 0, 0, 0);
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
        paramBitmap1 = this.KV;
        if (paramBitmap1 == null) {
          p.bGy("mDstRect");
        }
        paramContext.setBounds(paramBitmap1);
      }
      paramContext = af.aaBG;
      paramContext = String.format("default init: mWidth:%d mHeight:%d", Arrays.copyOf(new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) }, 2));
      p.j(paramContext, "java.lang.String.format(format, *args)");
      Log.i("MicroMsg.TransformSwipeBackToMultiTaskView", paramContext);
      AppMethodBeat.o(247830);
      return;
      i = 0;
      break;
    }
  }
  
  public final Bitmap getContentBitmap()
  {
    return this.FFC;
  }
  
  public final Bitmap getDefaultIcon()
  {
    return this.FFD;
  }
  
  public final GradientDrawable getGradientDrawable()
  {
    return this.FFE;
  }
  
  public final void ip(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public final void n(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(247824);
    RectF localRectF = this.seV;
    if (localRectF == null) {
      p.bGy("mMaskRect");
    }
    localRectF.set(0.0F, paramFloat1, paramFloat2, paramFloat3);
    AppMethodBeat.o(247824);
  }
  
  public final void n(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.FFH[0] = 0.0F;
    this.FFH[1] = 0.0F;
    this.FFH[2] = 0.0F;
    this.FFH[3] = 0.0F;
    this.FFH[4] = paramFloat1;
    this.FFH[5] = paramFloat2;
    this.FFH[6] = paramFloat3;
    this.FFH[7] = paramFloat4;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(247820);
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
    Rect localRect;
    Paint localPaint;
    if (localObject1 != null)
    {
      localObject2 = this.seU;
      if (localObject2 == null) {
        p.bGy("mDrawRect");
      }
      localRect = this.KV;
      if (localRect == null) {
        p.bGy("mDstRect");
      }
      localPaint = this.mPaint;
      if (localPaint == null) {
        p.bGy("mPaint");
      }
      paramCanvas.drawBitmap((Bitmap)localObject1, (Rect)localObject2, localRect, localPaint);
    }
    localObject1 = this.FFD;
    if (localObject1 != null)
    {
      localObject2 = this.FFF;
      if (localObject2 == null) {
        p.bGy("mDrawDefaultRect");
      }
      localRect = this.FFG;
      if (localRect == null) {
        p.bGy("mDstDefaultRect");
      }
      localPaint = this.mPaint;
      if (localPaint == null) {
        p.bGy("mPaint");
      }
      paramCanvas.drawBitmap((Bitmap)localObject1, (Rect)localObject2, localRect, localPaint);
    }
    localObject1 = this.FFE;
    if (localObject1 != null)
    {
      ((GradientDrawable)localObject1).setAlpha(this.sbi);
      ((GradientDrawable)localObject1).draw(paramCanvas);
      AppMethodBeat.o(247820);
      return;
    }
    AppMethodBeat.o(247820);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(247821);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    AppMethodBeat.o(247821);
  }
  
  public final void setDefaultDstRect(Rect paramRect)
  {
    AppMethodBeat.i(247829);
    p.k(paramRect, "dstRect");
    this.FFG = paramRect;
    AppMethodBeat.o(247829);
  }
  
  public final void setDstRect(Rect paramRect)
  {
    AppMethodBeat.i(247827);
    p.k(paramRect, "dstRect");
    this.KV = paramRect;
    AppMethodBeat.o(247827);
  }
  
  public final void setMaskAlpha(int paramInt)
  {
    this.sbi = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.a.b
 * JD-Core Version:    0.7.0.1
 */
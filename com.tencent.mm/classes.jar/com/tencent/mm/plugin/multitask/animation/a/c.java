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
import com.tencent.mm.ui.at;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterToMultiTaskView;", "Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterBaseView;", "context", "Landroid/content/Context;", "contentBitmap", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/graphics/Bitmap;)V", "<set-?>", "getContentBitmap", "()Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/GradientDrawable;", "gradientDrawable", "getGradientDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "mClipPath", "Landroid/graphics/Path;", "mDrawRect", "Landroid/graphics/Rect;", "mDstRect", "mHeight", "", "mMaskAlpha", "mMaskPaint", "Landroid/graphics/Paint;", "mMaskRect", "Landroid/graphics/RectF;", "mPaint", "mRectConnerRadius", "", "mWidth", "init", "", "bitmap", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setDstRect", "dstRect", "setMaskAlpha", "maskAlpha", "setMaskRect", "left", "", "top", "right", "buttom", "setRectConnerRadius", "radll", "radlt", "radtl", "radtt", "radrl", "radrt", "radbl", "radbt", "setViewSize", "width", "height", "Companion", "plugin-multitask_release"})
public final class c
  extends a
{
  private static final int zZS;
  public static final a zZU;
  private Rect Ky;
  private int mHeight;
  private Paint mPaint;
  private int mWidth;
  private int oZh;
  private Paint oZj;
  private Path pcR;
  private Rect pcS;
  private RectF pcT;
  private Bitmap zZM;
  private GradientDrawable zZO;
  private final float[] zZR;
  
  static
  {
    AppMethodBeat.i(200390);
    zZU = new a((byte)0);
    zZS = at.fromDPToPix(MMApplicationContext.getContext(), 8);
    AppMethodBeat.o(200390);
  }
  
  public c(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext);
    AppMethodBeat.i(200389);
    this.zZR = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, zZS, zZS, zZS, zZS };
    this.mPaint = new Paint();
    this.pcR = new Path();
    this.oZj = new Paint();
    paramContext = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    Paint localPaint = this.oZj;
    if (localPaint == null) {
      p.btv("mMaskPaint");
    }
    localPaint.setXfermode((Xfermode)paramContext);
    this.zZM = paramBitmap;
    this.mWidth = ((int)(paramBitmap.getWidth() * 1.25F));
    this.mHeight = ((int)(paramBitmap.getHeight() * 1.25F));
    this.pcS = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    this.Ky = new Rect(0, 0, this.mWidth, this.mHeight);
    this.pcT = new RectF();
    paramContext = this.pcT;
    if (paramContext == null) {
      p.btv("mMaskRect");
    }
    paramContext.left = 0.0F;
    paramContext = this.pcT;
    if (paramContext == null) {
      p.btv("mMaskRect");
    }
    paramContext.top = 0.0F;
    paramContext = this.pcT;
    if (paramContext == null) {
      p.btv("mMaskRect");
    }
    paramContext.right = this.mWidth;
    paramContext = this.pcT;
    if (paramContext == null) {
      p.btv("mMaskRect");
    }
    paramContext.bottom = this.mHeight;
    int i = Color.argb(230, 0, 0, 0);
    int j = Color.argb(76, 0, 0, 0);
    int k = Color.argb(0, 0, 0, 0);
    this.zZO = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, j, k });
    paramContext = this.zZO;
    if (paramContext != null) {
      paramContext.setGradientType(0);
    }
    paramContext = this.zZO;
    if (paramContext != null) {
      paramContext.setGradientCenter(0.5F, 0.4F);
    }
    paramContext = this.zZO;
    if (paramContext != null)
    {
      paramBitmap = this.Ky;
      if (paramBitmap == null) {
        p.btv("mDstRect");
      }
      paramContext.setBounds(paramBitmap);
    }
    paramContext = ae.SYK;
    paramContext = String.format("default init: mWidth:%d mHeight:%d", Arrays.copyOf(new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) }, 2));
    p.g(paramContext, "java.lang.String.format(format, *args)");
    Log.i("MicroMsg.TransformSwipeBackToMultiTaskView", paramContext);
    AppMethodBeat.o(200389);
  }
  
  public final Bitmap getContentBitmap()
  {
    return this.zZM;
  }
  
  public final GradientDrawable getGradientDrawable()
  {
    return this.zZO;
  }
  
  public final void hk(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public final void m(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(200387);
    RectF localRectF = this.pcT;
    if (localRectF == null) {
      p.btv("mMaskRect");
    }
    localRectF.set(0.0F, paramFloat1, paramFloat2, paramFloat3);
    AppMethodBeat.o(200387);
  }
  
  public final void m(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.zZR[0] = 0.0F;
    this.zZR[1] = 0.0F;
    this.zZR[2] = 0.0F;
    this.zZR[3] = 0.0F;
    this.zZR[4] = paramFloat1;
    this.zZR[5] = paramFloat2;
    this.zZR[6] = paramFloat3;
    this.zZR[7] = paramFloat4;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(200385);
    p.h(paramCanvas, "canvas");
    Object localObject1 = this.pcR;
    if (localObject1 == null) {
      p.btv("mClipPath");
    }
    ((Path)localObject1).reset();
    localObject1 = this.pcR;
    if (localObject1 == null) {
      p.btv("mClipPath");
    }
    Object localObject2 = this.pcT;
    if (localObject2 == null) {
      p.btv("mMaskRect");
    }
    ((Path)localObject1).addRoundRect((RectF)localObject2, this.zZR, Path.Direction.CW);
    localObject1 = this.pcR;
    if (localObject1 == null) {
      p.btv("mClipPath");
    }
    paramCanvas.clipPath((Path)localObject1);
    localObject1 = this.zZM;
    if (localObject1 != null)
    {
      localObject2 = this.pcS;
      if (localObject2 == null) {
        p.btv("mDrawRect");
      }
      Rect localRect = this.Ky;
      if (localRect == null) {
        p.btv("mDstRect");
      }
      Paint localPaint = this.mPaint;
      if (localPaint == null) {
        p.btv("mPaint");
      }
      paramCanvas.drawBitmap((Bitmap)localObject1, (Rect)localObject2, localRect, localPaint);
    }
    localObject1 = this.zZO;
    if (localObject1 != null)
    {
      ((GradientDrawable)localObject1).setAlpha(this.oZh);
      ((GradientDrawable)localObject1).draw(paramCanvas);
      AppMethodBeat.o(200385);
      return;
    }
    AppMethodBeat.o(200385);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200386);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    AppMethodBeat.o(200386);
  }
  
  public final void setDstRect(Rect paramRect)
  {
    AppMethodBeat.i(200388);
    p.h(paramRect, "dstRect");
    this.Ky = paramRect;
    AppMethodBeat.o(200388);
  }
  
  public final void setMaskAlpha(int paramInt)
  {
    this.oZh = paramInt;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterToMultiTaskView$Companion;", "", "()V", "DEFAULT_CORNER_RADIUS", "", "getDEFAULT_CORNER_RADIUS", "()I", "TAG", "", "plugin-multitask_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.a.c
 * JD-Core Version:    0.7.0.1
 */
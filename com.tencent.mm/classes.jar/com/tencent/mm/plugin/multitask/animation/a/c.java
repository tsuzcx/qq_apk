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
import com.tencent.mm.ui.bd;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterToMultiTaskView;", "Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterBaseView;", "context", "Landroid/content/Context;", "contentBitmap", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/graphics/Bitmap;)V", "<set-?>", "getContentBitmap", "()Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/GradientDrawable;", "gradientDrawable", "getGradientDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "mClipPath", "Landroid/graphics/Path;", "mDrawRect", "Landroid/graphics/Rect;", "mDstRect", "mHeight", "", "mMaskAlpha", "mMaskPaint", "Landroid/graphics/Paint;", "mMaskRect", "Landroid/graphics/RectF;", "mPaint", "mRectConnerRadius", "", "mWidth", "init", "", "bitmap", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setDstRect", "dstRect", "setMaskAlpha", "maskAlpha", "setMaskRect", "left", "", "top", "right", "buttom", "setRectConnerRadius", "radll", "radlt", "radtl", "radtt", "radrl", "radrt", "radbl", "radbt", "setViewSize", "width", "height", "Companion", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
{
  private static final int LBF;
  public static final c.a LBG;
  private GradientDrawable LBB;
  private final float[] LBE;
  private Bitmap LBz;
  private Rect bre;
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
    AppMethodBeat.i(303930);
    LBG = new c.a((byte)0);
    LBF = bd.fromDPToPix(MMApplicationContext.getContext(), 8);
    AppMethodBeat.o(303930);
  }
  
  public c(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext);
    AppMethodBeat.i(303919);
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
        break label513;
      }
      s.bIx("mDstRect");
      paramContext = localObject;
    }
    label513:
    for (;;)
    {
      paramBitmap.setBounds(paramContext);
      paramContext = am.aixg;
      paramContext = String.format("default init: mWidth:%d mHeight:%d", Arrays.copyOf(new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) }, 2));
      s.s(paramContext, "java.lang.String.format(format, *args)");
      Log.i("MicroMsg.TransformSwipeBackToMultiTaskView", paramContext);
      AppMethodBeat.o(303919);
      return;
    }
  }
  
  public final void ef(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
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
    AppMethodBeat.i(303952);
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
    if (localBitmap != null)
    {
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
        break label223;
      }
      s.bIx("mPaint");
    }
    for (;;)
    {
      paramCanvas.drawBitmap(localBitmap, (Rect)localObject1, (Rect)localObject2, (Paint)localObject3);
      localObject1 = this.LBB;
      if (localObject1 != null)
      {
        ((GradientDrawable)localObject1).setAlpha(this.vmA);
        ((GradientDrawable)localObject1).draw(paramCanvas);
      }
      AppMethodBeat.o(303952);
      return;
      label223:
      localObject3 = localObject4;
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(303958);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    AppMethodBeat.o(303958);
  }
  
  public final void r(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(303965);
    RectF localRectF2 = this.vqI;
    RectF localRectF1 = localRectF2;
    if (localRectF2 == null)
    {
      s.bIx("mMaskRect");
      localRectF1 = null;
    }
    localRectF1.set(0.0F, paramFloat1, paramFloat2, paramFloat3);
    AppMethodBeat.o(303965);
  }
  
  public final void r(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.LBE[0] = 0.0F;
    this.LBE[1] = 0.0F;
    this.LBE[2] = 0.0F;
    this.LBE[3] = 0.0F;
    this.LBE[4] = paramFloat1;
    this.LBE[5] = paramFloat2;
    this.LBE[6] = paramFloat3;
    this.LBE[7] = paramFloat4;
  }
  
  public final void setDstRect(Rect paramRect)
  {
    AppMethodBeat.i(303971);
    s.u(paramRect, "dstRect");
    this.bre = paramRect;
    AppMethodBeat.o(303971);
  }
  
  public final void setMaskAlpha(int paramInt)
  {
    this.vmA = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.a.c
 * JD-Core Version:    0.7.0.1
 */
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterToMultiTaskDefaultView;", "Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterBaseView;", "context", "Landroid/content/Context;", "contentBitmap", "Landroid/graphics/Bitmap;", "defaultBlt", "(Landroid/content/Context;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V", "<set-?>", "getContentBitmap", "()Landroid/graphics/Bitmap;", "defaultIcon", "getDefaultIcon", "Landroid/graphics/drawable/GradientDrawable;", "gradientDrawable", "getGradientDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "mClipPath", "Landroid/graphics/Path;", "mDrawDefaultRect", "Landroid/graphics/Rect;", "mDrawRect", "mDstDefaultRect", "mDstRect", "mHeight", "", "mMaskAlpha", "mMaskPaint", "Landroid/graphics/Paint;", "mMaskRect", "Landroid/graphics/RectF;", "mPaint", "mRectConnerRadius", "", "mWidth", "init", "", "bitmap", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setDefaultDstRect", "dstRect", "setDstRect", "setMaskAlpha", "maskAlpha", "setMaskRect", "left", "", "top", "right", "buttom", "setRectConnerRadius", "radll", "radlt", "radtl", "radtt", "radrl", "radrt", "radbl", "radbt", "setViewSize", "width", "height", "Companion", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  private static final int LBF;
  public static final b.a LBy;
  private Bitmap LBA;
  private GradientDrawable LBB;
  private Rect LBC;
  private Rect LBD;
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
    AppMethodBeat.i(303963);
    LBy = new b.a((byte)0);
    LBF = bd.fromDPToPix(MMApplicationContext.getContext(), 8);
    AppMethodBeat.o(303963);
  }
  
  public b(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    super(paramContext);
    AppMethodBeat.i(303949);
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
    this.LBz = paramBitmap1;
    this.LBA = paramBitmap2;
    this.mWidth = ((int)(paramBitmap1.getWidth() * 1.25F));
    this.mHeight = ((int)(paramBitmap1.getHeight() * 1.25F));
    this.vqH = new Rect(0, 0, paramBitmap1.getWidth(), paramBitmap1.getHeight());
    int i;
    int j;
    if (paramBitmap2 == null)
    {
      i = 0;
      if (paramBitmap2 != null) {
        break label561;
      }
      j = 0;
      label220:
      this.LBC = new Rect(0, 0, i, j);
      this.bre = new Rect(0, 0, this.mWidth, this.mHeight);
      this.vqI = new RectF();
      paramBitmap1 = this.vqI;
      paramContext = paramBitmap1;
      if (paramBitmap1 == null)
      {
        s.bIx("mMaskRect");
        paramContext = null;
      }
      paramContext.left = 0.0F;
      paramBitmap1 = this.vqI;
      paramContext = paramBitmap1;
      if (paramBitmap1 == null)
      {
        s.bIx("mMaskRect");
        paramContext = null;
      }
      paramContext.top = 0.0F;
      paramBitmap1 = this.vqI;
      paramContext = paramBitmap1;
      if (paramBitmap1 == null)
      {
        s.bIx("mMaskRect");
        paramContext = null;
      }
      paramContext.right = this.mWidth;
      paramBitmap1 = this.vqI;
      paramContext = paramBitmap1;
      if (paramBitmap1 == null)
      {
        s.bIx("mMaskRect");
        paramContext = null;
      }
      paramContext.bottom = this.mHeight;
      i = Color.argb(230, 0, 0, 0);
      j = Color.argb(76, 0, 0, 0);
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
      paramBitmap1 = this.LBB;
      if (paramBitmap1 != null)
      {
        paramContext = this.bre;
        if (paramContext != null) {
          break label570;
        }
        s.bIx("mDstRect");
        paramContext = localObject;
      }
    }
    label561:
    label570:
    for (;;)
    {
      paramBitmap1.setBounds(paramContext);
      paramContext = am.aixg;
      paramContext = String.format("default init: mWidth:%d mHeight:%d", Arrays.copyOf(new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) }, 2));
      s.s(paramContext, "java.lang.String.format(format, *args)");
      Log.i("MicroMsg.TransformSwipeBackToMultiTaskView", paramContext);
      AppMethodBeat.o(303949);
      return;
      i = paramBitmap2.getWidth();
      break;
      j = paramBitmap2.getHeight();
      break label220;
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
  
  public final Bitmap getDefaultIcon()
  {
    return this.LBA;
  }
  
  public final GradientDrawable getGradientDrawable()
  {
    return this.LBB;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    Object localObject4 = null;
    AppMethodBeat.i(304006);
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
    Object localObject3 = this.vqI;
    localObject2 = localObject3;
    if (localObject3 == null)
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
      localObject3 = this.bre;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("mDstRect");
        localObject2 = null;
      }
      localObject5 = this.mPaint;
      localObject3 = localObject5;
      if (localObject5 == null)
      {
        s.bIx("mPaint");
        localObject3 = null;
      }
      paramCanvas.drawBitmap(localBitmap, (Rect)localObject1, (Rect)localObject2, (Paint)localObject3);
    }
    Object localObject5 = this.LBA;
    if (localObject5 != null)
    {
      localObject2 = this.LBC;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mDrawDefaultRect");
        localObject1 = null;
      }
      localObject3 = this.LBD;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("mDstDefaultRect");
        localObject2 = null;
      }
      localObject3 = this.mPaint;
      if (localObject3 != null) {
        break label313;
      }
      s.bIx("mPaint");
      localObject3 = localObject4;
    }
    label313:
    for (;;)
    {
      paramCanvas.drawBitmap((Bitmap)localObject5, (Rect)localObject1, (Rect)localObject2, (Paint)localObject3);
      localObject1 = this.LBB;
      if (localObject1 != null)
      {
        ((GradientDrawable)localObject1).setAlpha(this.vmA);
        ((GradientDrawable)localObject1).draw(paramCanvas);
      }
      AppMethodBeat.o(304006);
      return;
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(304016);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    AppMethodBeat.o(304016);
  }
  
  public final void r(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(304025);
    RectF localRectF2 = this.vqI;
    RectF localRectF1 = localRectF2;
    if (localRectF2 == null)
    {
      s.bIx("mMaskRect");
      localRectF1 = null;
    }
    localRectF1.set(0.0F, paramFloat1, paramFloat2, paramFloat3);
    AppMethodBeat.o(304025);
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
  
  public final void setDefaultDstRect(Rect paramRect)
  {
    AppMethodBeat.i(304045);
    s.u(paramRect, "dstRect");
    this.LBD = paramRect;
    AppMethodBeat.o(304045);
  }
  
  public final void setDstRect(Rect paramRect)
  {
    AppMethodBeat.i(304035);
    s.u(paramRect, "dstRect");
    this.bre = paramRect;
    AppMethodBeat.o(304035);
  }
  
  public final void setMaskAlpha(int paramInt)
  {
    this.vmA = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.a.b
 * JD-Core Version:    0.7.0.1
 */
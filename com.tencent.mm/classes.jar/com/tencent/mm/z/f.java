package com.tencent.mm.z;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.view.PhotoEditText;

public final class f
  extends c
{
  private static TextPaint awy;
  private static final int gfA;
  private static final int gfB;
  private static final float gfz;
  public SpannableString gfC;
  public int mBgColor = -65536;
  public int mColor = -1;
  
  static
  {
    AppMethodBeat.i(9275);
    gfz = ai.getResources().getDimension(2131166169);
    gfA = (int)ai.getResources().getDimension(2131166481);
    gfB = (int)ai.getResources().getDimension(2131166674);
    TextPaint localTextPaint = new TextPaint(1);
    awy = localTextPaint;
    localTextPaint.setStrokeCap(Paint.Cap.ROUND);
    awy.setStyle(Paint.Style.FILL);
    awy.setDither(true);
    awy.setTextSize(gfz);
    AppMethodBeat.o(9275);
  }
  
  public f(Context paramContext, Matrix paramMatrix, String paramString, Rect paramRect, SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    super(paramContext, paramMatrix, paramString, paramRect);
    this.mColor = paramInt1;
    this.gfC = paramSpannableString;
    this.mBgColor = paramInt2;
  }
  
  protected final Bitmap afg()
  {
    AppMethodBeat.i(9273);
    awy.setColor(this.mColor);
    if (this.gfC == null)
    {
      AppMethodBeat.o(9273);
      return null;
    }
    PhotoEditText localPhotoEditText = new PhotoEditText(this.mContext);
    int i = a.au(this.mContext, 2131166167);
    localPhotoEditText.setPadding(i, 0, i, 0);
    localPhotoEditText.setTextBackground(this.mBgColor);
    localPhotoEditText.setTextColor(this.mColor);
    localPhotoEditText.setTextSize(Math.round(gfz / this.mContext.getResources().getDisplayMetrics().density));
    localPhotoEditText.setText(k.b(this.mContext, this.gfC, gfz / 1.3F));
    localPhotoEditText.setSingleLine(false);
    localPhotoEditText.setMaxWidth((int)(this.mContext.getResources().getDisplayMetrics().widthPixels - this.mContext.getResources().getDimension(2131166167) * 2.0F));
    if ((this.mBgColor == 0) && (this.mColor != -16777216)) {
      localPhotoEditText.setShadowLayer(a.fromDPToPix(localPhotoEditText.getContext(), 3), 0.0F, a.fromDPToPix(localPhotoEditText.getContext(), 1), -2147483648);
    }
    localPhotoEditText.measure(0, 0);
    Bitmap localBitmap = Bitmap.createBitmap(localPhotoEditText.getMeasuredWidth() - i, localPhotoEditText.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localPhotoEditText.getLayout().getPaint().setColor(this.mColor);
    localCanvas.save();
    localCanvas.translate(-0.5F * i, 0.0F);
    localPhotoEditText.draw(localCanvas);
    localCanvas.restore();
    localCanvas.save();
    localCanvas.translate(i * 0.5F, 0.0F);
    localPhotoEditText.getLayout().draw(localCanvas);
    localCanvas.restore();
    AppMethodBeat.o(9273);
    return localBitmap;
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(9274);
    super.setSelected(paramBoolean);
    if (!paramBoolean) {
      this.gfj = false;
    }
    AppMethodBeat.o(9274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.z.f
 * JD-Core Version:    0.7.0.1
 */
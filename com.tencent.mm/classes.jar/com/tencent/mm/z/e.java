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
import com.tencent.mm.bo.a.c;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.view.PhotoEditText;

public final class e
  extends c
{
  private static final float dIh = ae.getResources().getDimension(a.c.edit_text_size);
  private static final int dIi = (int)ae.getResources().getDimension(a.c.line_padding_text);
  private static final int dIj = (int)ae.getResources().getDimension(a.c.padding_text);
  private static TextPaint gI;
  public int dIk = -65536;
  public SpannableString dIl;
  public int mColor = -1;
  
  static
  {
    TextPaint localTextPaint = new TextPaint(1);
    gI = localTextPaint;
    localTextPaint.setStrokeCap(Paint.Cap.ROUND);
    gI.setStyle(Paint.Style.FILL);
    gI.setDither(true);
    gI.setTextSize(dIh);
  }
  
  public e(Context paramContext, Matrix paramMatrix, String paramString, Rect paramRect, SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    super(paramContext, paramMatrix, paramString, paramRect);
    this.mColor = paramInt1;
    this.dIl = paramSpannableString;
    this.dIk = paramInt2;
  }
  
  protected final Bitmap Cl()
  {
    gI.setColor(this.mColor);
    if (this.dIl == null) {
      return null;
    }
    PhotoEditText localPhotoEditText = new PhotoEditText(this.mContext);
    int i = a.aa(this.mContext, a.c.edit_text_padding);
    localPhotoEditText.setPadding(i, 0, i, 0);
    localPhotoEditText.setTextBackground(this.dIk);
    localPhotoEditText.setTextColor(this.mColor);
    localPhotoEditText.setTextSize(Math.round(dIh / this.mContext.getResources().getDisplayMetrics().density));
    localPhotoEditText.setText(j.a(this.mContext, this.dIl, dIh / 1.3F));
    localPhotoEditText.setSingleLine(false);
    localPhotoEditText.setMaxWidth((int)(this.mContext.getResources().getDisplayMetrics().widthPixels - this.mContext.getResources().getDimension(a.c.edit_text_padding) * 2.0F));
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
    return localBitmap;
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    if (!paramBoolean) {
      this.dHT = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.z.e
 * JD-Core Version:    0.7.0.1
 */
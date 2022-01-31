package com.tencent.mm.y;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.view.PhotoEditText;

public final class e
  extends c
{
  private static final float eFL;
  private static final int eFM;
  private static final int eFN;
  private static TextPaint hB;
  public SpannableString eFO;
  public int mBgColor = -65536;
  public int mColor = -1;
  
  static
  {
    AppMethodBeat.i(116299);
    eFL = ah.getResources().getDimension(2131428318);
    eFM = (int)ah.getResources().getDimension(2131428493);
    eFN = (int)ah.getResources().getDimension(2131428618);
    TextPaint localTextPaint = new TextPaint(1);
    hB = localTextPaint;
    localTextPaint.setStrokeCap(Paint.Cap.ROUND);
    hB.setStyle(Paint.Style.FILL);
    hB.setDither(true);
    hB.setTextSize(eFL);
    AppMethodBeat.o(116299);
  }
  
  public e(Context paramContext, Matrix paramMatrix, String paramString, Rect paramRect, SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    super(paramContext, paramMatrix, paramString, paramRect);
    this.mColor = paramInt1;
    this.eFO = paramSpannableString;
    this.mBgColor = paramInt2;
  }
  
  protected final Bitmap Qe()
  {
    AppMethodBeat.i(116297);
    hB.setColor(this.mColor);
    if (this.eFO == null)
    {
      AppMethodBeat.o(116297);
      return null;
    }
    PhotoEditText localPhotoEditText = new PhotoEditText(this.mContext);
    int i = a.ao(this.mContext, 2131428316);
    localPhotoEditText.setPadding(i, 0, i, 0);
    localPhotoEditText.setTextBackground(this.mBgColor);
    localPhotoEditText.setTextColor(this.mColor);
    localPhotoEditText.setTextSize(Math.round(eFL / this.mContext.getResources().getDisplayMetrics().density));
    localPhotoEditText.setText(j.b(this.mContext, this.eFO, eFL / 1.3F));
    localPhotoEditText.setSingleLine(false);
    localPhotoEditText.setMaxWidth((int)(this.mContext.getResources().getDisplayMetrics().widthPixels - this.mContext.getResources().getDimension(2131428316) * 2.0F));
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
    AppMethodBeat.o(116297);
    return localBitmap;
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(116298);
    super.setSelected(paramBoolean);
    if (!paramBoolean) {
      this.eFx = false;
    }
    AppMethodBeat.o(116298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.y.e
 * JD-Core Version:    0.7.0.1
 */
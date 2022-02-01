import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingTitle$GdtMotiveBrowsingCenterFixWidthSpan;", "Landroid/text/style/ReplacementSpan;", "fixWidth", "", "(I)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class acrd
  extends ReplacementSpan
{
  private final int a;
  
  public acrd(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void draw(@NotNull Canvas paramCanvas, @Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NotNull Paint paramPaint)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Intrinsics.checkParameterIsNotNull(paramPaint, "paint");
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      float f = paramPaint.measureText(paramCharSequence, paramInt1, paramInt2);
      f = Math.max(0.0F, (this.a - f) / 2);
      if (paramCharSequence == null) {
        Intrinsics.throwNpe();
      }
      paramCanvas.drawText(paramCharSequence, paramInt1, paramInt2, paramFloat + f, paramInt4, paramPaint);
    }
  }
  
  public int getSize(@NotNull Paint paramPaint, @Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt)
  {
    Intrinsics.checkParameterIsNotNull(paramPaint, "paint");
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acrd
 * JD-Core Version:    0.7.0.1
 */
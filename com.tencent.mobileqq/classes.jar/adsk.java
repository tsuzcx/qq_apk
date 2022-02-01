import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ImageSpan;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class adsk
  extends ImageSpan
{
  public adsk(ChatSettingForTroop paramChatSettingForTroop, Drawable paramDrawable, int paramInt)
  {
    super(paramDrawable, paramInt);
  }
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint)
  {
    paramCanvas.save();
    paramCanvas.translate(ScreenUtil.dip2px(9.0F), 0.0F);
    super.draw(paramCanvas, paramCharSequence, paramInt1, paramInt2, paramFloat, paramInt3, paramInt4, paramInt5, paramPaint);
    paramCanvas.restore();
  }
  
  public int getSize(@NonNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt)
  {
    return getDrawable().getBounds().right + ScreenUtil.dip2px(9.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adsk
 * JD-Core Version:    0.7.0.1
 */
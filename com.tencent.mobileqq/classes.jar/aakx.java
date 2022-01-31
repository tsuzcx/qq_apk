import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.style.ImageSpan;
import com.tencent.mobileqq.activity.ChatSettingForTroop;

public class aakx
  extends ImageSpan
{
  public aakx(ChatSettingForTroop paramChatSettingForTroop, Drawable paramDrawable, int paramInt)
  {
    super(paramDrawable, paramInt);
  }
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint)
  {
    paramCanvas.save();
    paramCanvas.translate(awmc.a(5.0F), -awmc.a(2.0F));
    super.draw(paramCanvas, paramCharSequence, paramInt1, paramInt2, paramFloat, paramInt3, paramInt4, paramInt5, paramPaint);
    paramCanvas.restore();
  }
  
  public Drawable getDrawable()
  {
    return super.getDrawable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aakx
 * JD-Core Version:    0.7.0.1
 */
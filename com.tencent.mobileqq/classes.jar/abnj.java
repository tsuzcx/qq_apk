import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

public class abnj
  extends ImageSpan
{
  private Context a;
  public String a;
  
  public abnj(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext, paramInt, 1);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    if (paramCharSequence == null) {
      return;
    }
    if (((paramCharSequence instanceof URLDrawable)) && (((URLDrawable)paramCharSequence).getStatus() == 1)) {
      paramCharSequence.setBounds(0, 0, paramCharSequence.getIntrinsicWidth() / 2, paramCharSequence.getIntrinsicHeight() / 2);
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat, (paramInt5 - paramInt3 - paramCharSequence.getBounds().bottom) / 2 + paramInt3);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public Drawable getDrawable()
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      URLDrawable localURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, null);
      if (QLog.isColorLevel()) {
        if ("UrlCenterImageSpan.getDrawable. url:" + this.jdField_a_of_type_JavaLangString + " drawable:" + localURLDrawable == null) {
          break label88;
        }
      }
      label88:
      for (String str = localURLDrawable.getIntrinsicWidth() + "";; str = localURLDrawable.toString())
      {
        QLog.e(".troop.send_gift", 2, str);
        return localURLDrawable;
      }
    }
    return super.getDrawable();
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = getDrawable();
    if (paramCharSequence == null) {
      return 0;
    }
    if (((paramCharSequence instanceof URLDrawable)) && (((URLDrawable)paramCharSequence).getStatus() == 1)) {
      paramCharSequence.setBounds(0, 0, paramCharSequence.getIntrinsicWidth() / 2, paramCharSequence.getIntrinsicHeight() / 2);
    }
    paramCharSequence = paramCharSequence.getBounds();
    if (paramFontMetricsInt != null)
    {
      paramPaint = paramPaint.getFontMetricsInt();
      paramInt2 = paramPaint.bottom - paramPaint.top;
      int i = paramCharSequence.bottom - paramCharSequence.top;
      paramInt1 = i / 2 - paramInt2 / 4;
      i /= 2;
      paramInt2 = paramInt2 / 4 + i;
      paramFontMetricsInt.ascent = (-paramInt2);
      paramFontMetricsInt.top = (-paramInt2);
      paramFontMetricsInt.bottom = paramInt1;
      paramFontMetricsInt.descent = paramInt1;
    }
    return paramCharSequence.right;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abnj
 * JD-Core Version:    0.7.0.1
 */
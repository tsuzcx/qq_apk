import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;

public class alzp
{
  public float a;
  private int jdField_a_of_type_Int = 2;
  StaticLayout jdField_a_of_type_AndroidTextStaticLayout = null;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  public String a;
  private boolean jdField_a_of_type_Boolean = true;
  public float b;
  private boolean b;
  public float c;
  
  public alzp(String paramString, float paramFloat1, int paramInt1, float paramFloat2, float paramFloat3, int paramInt2, float paramFloat4, Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(paramInt1);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramFloat1);
    if (paramTypeface != null) {
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    }
    if (paramFloat4 > 0.0F)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.jdField_a_of_type_AndroidTextTextPaint.setFakeBoldText(true);
      this.jdField_a_of_type_AndroidTextTextPaint.setStrokeWidth(paramFloat4);
    }
    if (paramFloat3 == -1.0F)
    {
      this.jdField_b_of_type_Boolean = true;
      if (paramFloat2 != -1.0F) {
        break label157;
      }
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      a(paramString);
      return;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_b_of_type_Float = paramFloat3;
      break;
      label157:
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Float = paramFloat2;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidTextStaticLayout != null) {
      return this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount();
    }
    return 1;
  }
  
  public void a(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (paramCanvas == null)) {}
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
          {
            paramCanvas.save();
            paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, paramFloat1, paramFloat2 - this.c, this.jdField_a_of_type_AndroidTextTextPaint);
            paramCanvas.restore();
            return;
          }
          if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
            break;
          }
        } while (this.jdField_a_of_type_AndroidTextStaticLayout == null);
        paramCanvas.save();
        paramCanvas.clipRect(paramFloat1, paramFloat2, this.jdField_a_of_type_Float + paramFloat1, paramFloat2 - this.c);
        paramCanvas.translate(paramFloat1, paramFloat2);
        this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
        paramCanvas.restore();
        return;
      } while ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean));
      if (this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (this.jdField_a_of_type_AndroidTextStaticLayout == null);
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
    return;
    paramCanvas.save();
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, paramFloat1, paramFloat2 - this.c, this.jdField_a_of_type_AndroidTextTextPaint);
    paramCanvas.restore();
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaLangString = paramString;
      paramString = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
      float f1 = paramString.bottom;
      float f2 = paramString.top;
      this.c = paramString.top;
      paramString = Layout.Alignment.ALIGN_NORMAL;
      if (this.jdField_a_of_type_Int == 2) {
        paramString = Layout.Alignment.ALIGN_CENTER;
      }
      while ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_a_of_type_JavaLangString);
        this.jdField_b_of_type_Float = (f1 - f2);
        this.jdField_a_of_type_AndroidTextStaticLayout = null;
        return;
        if (this.jdField_a_of_type_Int == 1) {
          paramString = Layout.Alignment.ALIGN_NORMAL;
        }
      }
      if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidTextTextPaint, (int)this.jdField_a_of_type_Float + 1, paramString, 1.0F, 0.0F, false);
        return;
      }
    } while ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean));
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidTextTextPaint, (int)this.jdField_a_of_type_Float + 1, paramString, 1.0F, 0.0F, false);
      this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidTextStaticLayout.getHeight();
      return;
    }
    this.jdField_a_of_type_AndroidTextStaticLayout = null;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alzp
 * JD-Core Version:    0.7.0.1
 */
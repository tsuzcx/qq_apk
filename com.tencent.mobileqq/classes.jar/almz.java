import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

class almz
{
  public float a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  public String a;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public float b;
  ArrayList<PointF> b;
  public float c;
  public float d;
  private float e;
  private float f;
  private float g;
  
  public almz(String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, Typeface paramTypeface)
  {
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-16777216);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramFloat1);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
    if (paramTypeface != null) {
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    }
    this.jdField_a_of_type_Float = paramFloat5;
    this.jdField_b_of_type_Float = paramFloat6;
    this.e = paramFloat2;
    this.f = paramFloat3;
    this.g = paramFloat4;
    a(paramString);
  }
  
  private void b(Canvas paramCanvas)
  {
    float f1 = this.jdField_b_of_type_Float;
    f1 = this.e / 2.0F + f1;
    float f2 = this.e / 2.0F;
    float f3 = (this.e - this.g) / 2.0F;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      float f4 = this.jdField_a_of_type_Float + this.e / 2.0F + i * (this.e + this.f);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16777216);
      paramCanvas.drawCircle(f4, f1, f2, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      paramCanvas.drawCircle(f4, f1, f3, this.jdField_a_of_type_AndroidGraphicsPaint);
      i += 1;
    }
  }
  
  private void c(Canvas paramCanvas)
  {
    float f1 = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics().ascent;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      String str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      float f2 = this.jdField_a_of_type_Float;
      float f3 = i;
      float f4 = this.f;
      float f5 = this.e;
      float f6 = ((PointF)this.jdField_b_of_type_JavaUtilArrayList.get(i)).x;
      float f7 = this.jdField_b_of_type_Float;
      paramCanvas.drawText(str, f3 * (f4 + f5) + f2 + f6, ((PointF)this.jdField_b_of_type_JavaUtilArrayList.get(i)).y + (f7 + f1 * -1.0F), this.jdField_a_of_type_AndroidTextTextPaint);
      i += 1;
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) || (paramCanvas == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() != this.jdField_b_of_type_JavaUtilArrayList.size())) {
      return;
    }
    b(paramCanvas);
    c(paramCanvas);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      int i = 0;
      while (i < paramString.length())
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString.substring(i, i + 1));
        i += 1;
      }
      this.c = (this.jdField_a_of_type_JavaUtilArrayList.size() * (this.e + this.f));
      this.d = this.e;
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      paramString = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
      float f1 = paramString.bottom;
      float f2 = paramString.top;
      paramString = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString.hasNext())
      {
        Object localObject = (String)paramString.next();
        localObject = new PointF((this.e - this.jdField_a_of_type_AndroidTextTextPaint.measureText((String)localObject)) / 2.0F, (this.e - (f1 - f2)) / 2.0F);
        this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     almz
 * JD-Core Version:    0.7.0.1
 */
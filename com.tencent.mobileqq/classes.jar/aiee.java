import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class aiee
  implements aief
{
  double jdField_a_of_type_Double;
  int jdField_a_of_type_Int;
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  int c;
  int d;
  
  aiee(aied paramaied, int paramInt1, double paramDouble, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Double = (0.0174532925199433D * paramDouble);
    this.d = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt4;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt3;
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    Object localObject = this.jdField_a_of_type_Aied.jdField_a_of_type_Aieg.a(this.jdField_a_of_type_Aied, this.d);
    float f;
    if (localObject != null)
    {
      Rect localRect1 = this.jdField_a_of_type_Aied.getBounds();
      int i = localRect1.width();
      int j = localRect1.height();
      i = (int)(i / 2 + Math.sin(this.jdField_a_of_type_Double) * this.jdField_a_of_type_Aied.d);
      j = (int)(j / 2 - Math.cos(this.jdField_a_of_type_Double) * this.jdField_a_of_type_Aied.d);
      int k = (int)(((Bitmap)localObject).getWidth() * this.jdField_a_of_type_Aied.jdField_a_of_type_Double);
      int m = (int)(((Bitmap)localObject).getHeight() * this.jdField_a_of_type_Aied.jdField_a_of_type_Double);
      this.jdField_a_of_type_AndroidGraphicsRect.set(i - k / 2, j - m / 2 + this.jdField_a_of_type_Aied.c / 2, k / 2 + i, m / 2 + j + this.jdField_a_of_type_Aied.c / 2);
      Rect localRect2;
      if (this.jdField_a_of_type_AndroidGraphicsRect.left < localRect1.left)
      {
        localRect2 = this.jdField_a_of_type_AndroidGraphicsRect;
        localRect2.right += localRect1.left - this.jdField_a_of_type_AndroidGraphicsRect.left;
        this.jdField_a_of_type_AndroidGraphicsRect.left = localRect1.left;
      }
      if (this.jdField_a_of_type_AndroidGraphicsRect.top < localRect1.top)
      {
        localRect2 = this.jdField_a_of_type_AndroidGraphicsRect;
        localRect2.bottom += localRect1.top - this.jdField_a_of_type_AndroidGraphicsRect.top;
        this.jdField_a_of_type_AndroidGraphicsRect.top = localRect1.top;
      }
      if (this.jdField_a_of_type_AndroidGraphicsRect.right > localRect1.right)
      {
        localRect2 = this.jdField_a_of_type_AndroidGraphicsRect;
        localRect2.left += localRect1.right - this.jdField_a_of_type_AndroidGraphicsRect.right;
        this.jdField_a_of_type_AndroidGraphicsRect.right = localRect1.right;
      }
      if (this.jdField_a_of_type_AndroidGraphicsRect.bottom > localRect1.bottom)
      {
        localRect2 = this.jdField_a_of_type_AndroidGraphicsRect;
        localRect2.top += localRect1.bottom - this.jdField_a_of_type_AndroidGraphicsRect.bottom;
        this.jdField_a_of_type_AndroidGraphicsRect.bottom = localRect1.bottom;
      }
      paramCanvas.drawBitmap((Bitmap)localObject, null, this.jdField_a_of_type_AndroidGraphicsRect, paramPaint);
      if (QLog.isColorLevel()) {
        QLog.d("DiyPendantDrawable", 2, "draw sticker index = " + this.d + "scaleFactor=" + this.jdField_a_of_type_Aied.jdField_a_of_type_Double + ", x=" + i + ", y=" + j + ", w=" + k + ", h=" + m);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        i = (int)(10.0D * this.jdField_a_of_type_Aied.jdField_a_of_type_Double);
        this.jdField_b_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect.left + i, this.jdField_a_of_type_AndroidGraphicsRect.top + i, this.jdField_a_of_type_AndroidGraphicsRect.right - i, this.jdField_a_of_type_AndroidGraphicsRect.bottom - i);
        f = baau.a(this.jdField_a_of_type_Aied.b, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_JavaLangString);
        if (this.jdField_b_of_type_Int != 1) {
          break label891;
        }
        localObject = new Paint();
        ((Paint)localObject).setTextSize(f);
        i = (int)((Paint)localObject).measureText(this.jdField_a_of_type_JavaLangString);
        j = (int)Math.min(f + 10.0D * this.jdField_a_of_type_Aied.jdField_a_of_type_Double, this.jdField_b_of_type_AndroidGraphicsRect.height());
        localObject = this.jdField_a_of_type_Aied.jdField_a_of_type_Aieg.a(this.jdField_a_of_type_Aied, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, f, this.c, i, j, paramPaint);
        if (localObject != null)
        {
          i = this.jdField_a_of_type_AndroidGraphicsRect.centerX();
          j = this.jdField_a_of_type_AndroidGraphicsRect.centerY();
          this.jdField_b_of_type_AndroidGraphicsRect.set(i - ((Bitmap)localObject).getWidth() / 2, j - ((Bitmap)localObject).getHeight() / 2, i + ((Bitmap)localObject).getWidth() / 2, j + ((Bitmap)localObject).getHeight() / 2);
          paramCanvas.drawBitmap((Bitmap)localObject, null, this.jdField_b_of_type_AndroidGraphicsRect, paramPaint);
        }
        if (QLog.isColorLevel())
        {
          if ("draw textInfo text = " + this.jdField_a_of_type_JavaLangString + " fontId = " + this.jdField_a_of_type_Int + " fontType = " + 1 + " color = " + this.c + " fontBitmap Existed = " + localObject == null) {
            break label885;
          }
          bool = true;
          QLog.d("DiyPendantDrawable", 2, new Object[] { Boolean.valueOf(bool) });
        }
      }
    }
    label885:
    label891:
    do
    {
      return;
      bool = false;
      break;
      paramPaint = this.jdField_a_of_type_Aied.jdField_a_of_type_Aieg.a(this.jdField_a_of_type_Aied, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      if (paramPaint != null) {
        this.jdField_a_of_type_Aied.b.setTypeface(paramPaint);
      }
      this.jdField_a_of_type_Aied.b.setColor(this.c);
      this.jdField_a_of_type_Aied.b.setTextAlign(Paint.Align.CENTER);
      this.jdField_a_of_type_Aied.b.setTextSize(f);
      localObject = this.jdField_a_of_type_Aied.b.getFontMetrics();
      f = (this.jdField_b_of_type_AndroidGraphicsRect.bottom + this.jdField_b_of_type_AndroidGraphicsRect.top - ((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top) / 2.0F;
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_AndroidGraphicsRect.centerX(), f, this.jdField_a_of_type_Aied.b);
    } while (!QLog.isColorLevel());
    if ("draw textInfo text = " + this.jdField_a_of_type_JavaLangString + " fontId = " + this.jdField_a_of_type_Int + " fontType = " + this.jdField_b_of_type_Int + " color = " + this.c + " localTypeFace Existed = " + paramPaint != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("DiyPendantDrawable", 2, new Object[] { Boolean.valueOf(bool) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiee
 * JD-Core Version:    0.7.0.1
 */
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

class alze
  extends alyx
{
  public int a;
  private alys jdField_a_of_type_Alys;
  public alyt a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = -1;
  private alys jdField_b_of_type_Alys;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private final String jdField_b_of_type_JavaLangString = "PacmanTextItem";
  int c = -1;
  int d;
  private int e = 1;
  private int f = 15;
  
  public alze(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, String paramString, alyt paramalyt, float paramFloat4, float paramFloat5, Bitmap paramBitmap1, Bitmap paramBitmap2, Typeface paramTypeface)
  {
    super(paramLong1, paramLong2, paramBoolean);
    a(8, paramFloat1);
    a(9, paramFloat2);
    a(6, paramFloat4);
    a(7, paramFloat5);
    a(5, a(paramFloat3, paramFloat1 * paramFloat2));
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Alyt = paramalyt;
    this.d = 0;
    this.jdField_a_of_type_Alys = new alys(a(this.d), this.jdField_a_of_type_Alyt, paramTypeface);
    this.jdField_a_of_type_Alys.jdField_a_of_type_Float = (this.jdField_a_of_type_Alyt.jdField_a_of_type_Float + paramFloat4 + this.jdField_a_of_type_Alyt.d);
    this.jdField_b_of_type_Alys = new alys(a(this.d + 50), this.jdField_a_of_type_Alyt, paramTypeface);
    this.jdField_b_of_type_Alys.jdField_a_of_type_Float = (this.jdField_a_of_type_Alys.jdField_a_of_type_Float + this.jdField_a_of_type_Alys.jdField_a_of_type_Alyr.c);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    paramFloat2 = this.jdField_a_of_type_Alys.jdField_a_of_type_Alyr.c + paramalyt.jdField_a_of_type_Float + paramalyt.d;
    paramFloat1 = paramFloat2;
    if (this.jdField_b_of_type_Alys.jdField_a_of_type_Boolean) {
      paramFloat1 = paramFloat2 + this.jdField_b_of_type_Alys.jdField_a_of_type_Alyr.c;
    }
    a(3, paramFloat1);
    a(4, paramalyt.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap1;
    this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap2;
    this.jdField_b_of_type_Int = -1;
    this.c = -1;
  }
  
  private float a(float paramFloat1, float paramFloat2)
  {
    return paramFloat1 * paramFloat2;
  }
  
  private String a(int paramInt)
  {
    Object localObject;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject = "";
      return localObject;
    }
    if (this.jdField_a_of_type_JavaLangString.length() <= paramInt) {
      return "";
    }
    if (this.jdField_a_of_type_JavaLangString.length() > paramInt + 50) {}
    for (String str = this.jdField_a_of_type_JavaLangString.substring(paramInt, paramInt + 50);; str = this.jdField_a_of_type_JavaLangString.substring(paramInt, this.jdField_a_of_type_JavaLangString.length()))
    {
      localObject = str;
      if (str != null) {
        break;
      }
      return "";
    }
  }
  
  private void a(Canvas paramCanvas, RenderBuffer paramRenderBuffer)
  {
    boolean bool;
    if (this.e % this.f == 0)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        bool = true;
        this.jdField_a_of_type_Boolean = bool;
        this.e = 1;
      }
    }
    else
    {
      this.e += 1;
      if (paramCanvas == null) {
        break label160;
      }
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      if (!this.jdField_a_of_type_Boolean) {
        break label152;
      }
      paramRenderBuffer = this.jdField_a_of_type_AndroidGraphicsBitmap;
      paramCanvas.drawBitmap(paramRenderBuffer, new Rect(0, 0, paramRenderBuffer.getWidth(), paramRenderBuffer.getHeight()), new RectF(a(6), a(7), a(6) + this.jdField_a_of_type_Alyt.jdField_a_of_type_Float, a(7) + this.jdField_a_of_type_Alyt.jdField_a_of_type_Float), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    label152:
    label160:
    while (paramRenderBuffer == null) {
      for (;;)
      {
        return;
        bool = false;
        break;
        paramRenderBuffer = this.jdField_b_of_type_AndroidGraphicsBitmap;
      }
    }
    if (this.jdField_b_of_type_Int < 0) {
      this.jdField_b_of_type_Int = GlUtil.createTexture(3553, this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    if (this.c < 0) {
      this.c = GlUtil.createTexture(3553, this.jdField_b_of_type_AndroidGraphicsBitmap);
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = this.jdField_b_of_type_Int;; i = this.c)
    {
      a(paramRenderBuffer, i, this.jdField_a_of_type_Alyt.jdField_a_of_type_Float, this.jdField_a_of_type_Alyt.jdField_a_of_type_Float, null, a(6), a(7));
      return;
    }
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_Alys != null)
    {
      float f3 = a(6);
      float f4 = a(4) / 2.0F;
      float f2 = this.jdField_a_of_type_Alys.jdField_a_of_type_Float + this.jdField_a_of_type_Alys.jdField_a_of_type_Alyr.c;
      float f1 = f2;
      if (this.jdField_b_of_type_Alys != null)
      {
        f1 = f2;
        if (this.jdField_b_of_type_Alys.jdField_a_of_type_Boolean) {
          f1 = f2 + this.jdField_b_of_type_Alys.jdField_a_of_type_Alyr.c;
        }
      }
      if ((f4 + f3 > f1) || (f1 < 0.0F)) {
        return false;
      }
    }
    return true;
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      a(6, a(6) + paramFloat);
      if (this.jdField_a_of_type_Alys != null) {
        break label49;
      }
    }
    label49:
    Object localObject;
    float f1;
    float f2;
    do
    {
      return;
      a(6, a(6) + paramFloat / 2.0F);
      break;
      localObject = this.jdField_a_of_type_Alys;
      ((alys)localObject).jdField_a_of_type_Float += paramFloat;
      if (this.jdField_b_of_type_Alys != null)
      {
        localObject = this.jdField_b_of_type_Alys;
        ((alys)localObject).jdField_a_of_type_Float += paramFloat;
      }
      paramFloat = a(6);
      f1 = a(4) / 2.0F;
      f2 = this.jdField_a_of_type_Alys.jdField_a_of_type_Float + this.jdField_a_of_type_Alys.jdField_a_of_type_Alyr.c;
    } while ((paramFloat + f1 <= f2) && (f2 >= 0.0F));
    if ((this.jdField_b_of_type_Alys != null) && (this.jdField_b_of_type_Alys.jdField_a_of_type_Boolean))
    {
      localObject = this.jdField_a_of_type_Alys;
      this.jdField_a_of_type_Alys = this.jdField_b_of_type_Alys;
      this.jdField_b_of_type_Alys = ((alys)localObject);
      this.d += 50;
      localObject = a(this.d + 50);
      this.jdField_b_of_type_Alys.a((String)localObject);
      f1 = a(3);
      paramFloat = f1;
      if (this.jdField_b_of_type_Alys.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_Alys.jdField_a_of_type_Float = (this.jdField_a_of_type_Alys.jdField_a_of_type_Float + this.jdField_a_of_type_Alys.jdField_a_of_type_Alyr.c);
        paramFloat = f1 + this.jdField_b_of_type_Alys.jdField_a_of_type_Alyr.c;
      }
      a(3, paramFloat);
      return;
    }
    a(3, 0.0F);
  }
  
  public void a(Canvas paramCanvas)
  {
    if (!b()) {}
    float f1;
    do
    {
      return;
      f1 = a(6) + this.jdField_a_of_type_Alyt.jdField_a_of_type_Float / 2.0F;
      if (f1 > 0.0F)
      {
        paramCanvas.save();
        paramCanvas.clipRect(f1, a(7), paramCanvas.getWidth(), a(7) + a(4));
      }
      float f2 = a(7);
      if (this.jdField_a_of_type_Alys != null)
      {
        this.jdField_a_of_type_Alys.a(paramCanvas, this.jdField_a_of_type_Alys.jdField_a_of_type_Float, f2);
        if ((this.jdField_b_of_type_Alys != null) && (this.jdField_b_of_type_Alys.jdField_a_of_type_Boolean)) {
          this.jdField_b_of_type_Alys.a(paramCanvas, this.jdField_b_of_type_Alys.jdField_a_of_type_Float, f2);
        }
      }
      if (f1 > 0.0F) {
        paramCanvas.restore();
      }
    } while (f1 + this.jdField_a_of_type_Alyt.jdField_a_of_type_Float / 2.0F <= 0.0F);
    a(paramCanvas, null);
  }
  
  public void a(RenderBuffer paramRenderBuffer)
  {
    if (!b()) {}
    while (this.jdField_a_of_type_Alys == null) {
      return;
    }
    if (this.jdField_a_of_type_Alys.jdField_a_of_type_Float >= a(6) + this.jdField_a_of_type_Alyt.jdField_a_of_type_Float / 2.0F) {
      this.jdField_a_of_type_Alys.a(paramRenderBuffer, null, this.jdField_a_of_type_Alys.jdField_a_of_type_Float, a(7));
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_Alys != null) && (this.jdField_b_of_type_Alys.jdField_a_of_type_Boolean)) {
        this.jdField_b_of_type_Alys.a(paramRenderBuffer, null, this.jdField_b_of_type_Alys.jdField_a_of_type_Float, a(7));
      }
      a(null, paramRenderBuffer);
      return;
      float f1 = a(6) + this.jdField_a_of_type_Alyt.jdField_a_of_type_Float / 2.0F;
      if (f1 > 0.0F)
      {
        f1 -= this.jdField_a_of_type_Alys.jdField_a_of_type_Float;
        float f2 = a(3);
        float f3 = a(4);
        QLog.d("PacmanTextItem", 2, "draw area:" + f1 + "-" + 0.0F + "-" + f2 + "-" + f3);
        this.jdField_a_of_type_Alys.a(paramRenderBuffer, new RectF(f1, 0.0F, f2, f3), f1 + this.jdField_a_of_type_Alys.jdField_a_of_type_Float, a(7));
      }
      else
      {
        this.jdField_a_of_type_Alys.a(paramRenderBuffer, null, this.jdField_a_of_type_Alys.jdField_a_of_type_Float, a(7));
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramString.equals(this.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_JavaLangString = paramString;
      } while (this.jdField_a_of_type_Alys == null);
      paramString = a(this.d);
      boolean bool = this.jdField_a_of_type_Alys.jdField_a_of_type_Boolean;
      float f3 = this.jdField_a_of_type_Alys.jdField_a_of_type_Alyr.c;
      float f1 = a(3);
      this.jdField_a_of_type_Alys.a(paramString);
      float f2 = f1;
      if (bool) {
        f2 = f1 - f3;
      }
      f1 = f2;
      if (this.jdField_a_of_type_Alys.jdField_a_of_type_Boolean) {
        f1 = f2 + this.jdField_a_of_type_Alys.jdField_a_of_type_Alyr.c;
      }
      f3 = f1;
      if (this.jdField_b_of_type_Alys != null)
      {
        bool = this.jdField_b_of_type_Alys.jdField_a_of_type_Boolean;
        f3 = this.jdField_b_of_type_Alys.jdField_a_of_type_Alyr.c;
        paramString = a(this.d + 50);
        this.jdField_b_of_type_Alys.a(paramString);
        this.jdField_b_of_type_Alys.jdField_a_of_type_Float = (this.jdField_a_of_type_Alys.jdField_a_of_type_Float + this.jdField_a_of_type_Alys.jdField_a_of_type_Alyr.c);
        f2 = f1;
        if (bool) {
          f2 = f1 - f3;
        }
        f3 = f2;
        if (this.jdField_b_of_type_Alys.jdField_a_of_type_Boolean) {
          f3 = f2 + this.jdField_b_of_type_Alys.jdField_a_of_type_Alyr.c;
        }
      }
      a(3, f3);
    } while ((this.jdField_b_of_type_Alys == null) || (!QLog.isColorLevel()));
    QLog.d("PacmanTextItem", 2, "PacmanTextItem settext: ManPOSX:" + a(6) + " param_width:" + a(3) + " isvalid:" + this.jdField_a_of_type_Alys.jdField_a_of_type_Boolean + "-" + this.jdField_b_of_type_Alys.jdField_a_of_type_Boolean + " width:" + this.jdField_a_of_type_Alys.jdField_a_of_type_Alyr.c + "-" + this.jdField_b_of_type_Alys.jdField_a_of_type_Alyr.c + " posx:" + this.jdField_a_of_type_Alys.jdField_a_of_type_Float + "-" + this.jdField_b_of_type_Alys.jdField_a_of_type_Float);
  }
  
  public void b(float paramFloat)
  {
    a(6, paramFloat);
    if ((this.jdField_a_of_type_Alys != null) && (this.jdField_a_of_type_Alys.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Alys.jdField_a_of_type_Float = (this.jdField_a_of_type_Alyt.jdField_a_of_type_Float + paramFloat + this.jdField_a_of_type_Alyt.d);
      if (this.jdField_b_of_type_Alys != null) {
        this.jdField_b_of_type_Alys.jdField_a_of_type_Float = (this.jdField_a_of_type_Alys.jdField_a_of_type_Float + this.jdField_a_of_type_Alys.jdField_a_of_type_Alyr.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alze
 * JD-Core Version:    0.7.0.1
 */
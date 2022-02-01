import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class airu
{
  private double jdField_a_of_type_Double = 1.0D;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private airl jdField_a_of_type_Airl;
  private airv jdField_a_of_type_Airv;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_a_of_type_JavaLangString;
  private double jdField_b_of_type_Double = 1.0D;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private double jdField_c_of_type_Double = 1.0D;
  private long jdField_c_of_type_Long;
  private double jdField_d_of_type_Double = 1.0D;
  private long jdField_d_of_type_Long;
  private double jdField_e_of_type_Double;
  private long jdField_e_of_type_Long;
  private double f = 1.0D;
  private double g = -0.8D;
  
  public airu(Drawable paramDrawable, Point paramPoint, airn paramairn, airm paramairm, double paramDouble, long paramLong, String paramString, int paramInt)
  {
    this(paramDrawable, paramPoint, paramairn, paramairm, paramLong, paramDouble, false, paramString, paramInt);
  }
  
  public airu(Drawable paramDrawable, Point paramPoint, airn paramairn, airm paramairm, long paramLong, double paramDouble, boolean paramBoolean, String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_Airl = new airl();
    this.f = paramDouble;
    this.jdField_a_of_type_Long = paramLong;
    paramDouble = paramDrawable.getIntrinsicWidth() * this.f;
    double d1 = paramDrawable.getIntrinsicHeight() * this.f;
    if (paramInt == 85) {
      this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.set((float)(paramPoint.x - paramDouble), (float)(paramPoint.y - d1), paramPoint.x, paramPoint.y);
    }
    for (;;)
    {
      this.jdField_a_of_type_Airl.jdField_a_of_type_Airn.a(paramairn);
      this.jdField_a_of_type_Airl.jdField_a_of_type_Airm.a(paramairm);
      this.jdField_a_of_type_JavaLangString = paramString;
      if (paramBoolean) {
        this.jdField_a_of_type_Airl.jdField_a_of_type_Int = 5;
      }
      return;
      float f1;
      float f2;
      if (paramInt == 81)
      {
        paramDrawable = this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF;
        f1 = (float)(paramPoint.x - paramDouble / 2.0D);
        f2 = (float)(paramPoint.y - d1);
        d1 = paramPoint.x;
        paramDrawable.set(f1, f2, (float)(paramDouble / 2.0D + d1), paramPoint.y);
      }
      else
      {
        paramDrawable = this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF;
        f1 = (float)(paramPoint.x - paramDouble / 2.0D);
        f2 = paramPoint.y;
        double d2 = paramPoint.x;
        paramDrawable.set(f1, f2, (float)(paramDouble / 2.0D + d2), (float)(d1 + paramPoint.y));
      }
    }
  }
  
  private double a(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return (paramDouble1 * 2.0D + paramDouble2 * paramDouble3) / 2.0D * paramDouble3;
  }
  
  private double a(long paramLong)
  {
    if (Math.abs(this.jdField_d_of_type_Double - this.jdField_b_of_type_Double) < 0.01D) {
      return this.jdField_b_of_type_Double;
    }
    paramLong -= this.jdField_a_of_type_Long;
    if (this.jdField_d_of_type_Double < this.jdField_b_of_type_Double)
    {
      double d1 = this.jdField_d_of_type_Double;
      this.jdField_d_of_type_Double = (paramLong * 2L / 1000.0D + d1);
    }
    for (this.jdField_d_of_type_Double = Math.min(this.jdField_b_of_type_Double, this.jdField_d_of_type_Double);; this.jdField_d_of_type_Double = Math.max(this.jdField_b_of_type_Double, this.jdField_d_of_type_Double))
    {
      return this.jdField_d_of_type_Double;
      this.jdField_d_of_type_Double -= paramLong * 2L / 1000.0D;
    }
  }
  
  private int a(int paramInt)
  {
    int j = 0;
    int i = j;
    if ((paramInt & 0x1) > 0)
    {
      i = j;
      if (Math.abs(this.jdField_a_of_type_Airl.jdField_a_of_type_Airn.jdField_a_of_type_Double) > 100.0D) {
        i = 1;
      }
    }
    j = i;
    if ((paramInt & 0x2) > 0)
    {
      j = i;
      if (Math.abs(this.jdField_a_of_type_Airl.jdField_a_of_type_Airn.jdField_a_of_type_Double) > 100.0D) {
        j = i | 0x2;
      }
    }
    i = j;
    if ((paramInt & 0x4) > 0)
    {
      i = j;
      if (Math.abs(this.jdField_a_of_type_Airl.jdField_a_of_type_Airn.jdField_b_of_type_Double) > 100.0D) {
        i = j | 0x4;
      }
    }
    j = i;
    if ((paramInt & 0x8) > 0)
    {
      j = i;
      if (Math.abs(this.jdField_a_of_type_Airl.jdField_a_of_type_Airn.jdField_b_of_type_Double) > 100.0D) {
        j = i | 0x8;
      }
    }
    return j;
  }
  
  private int a(Rect paramRect, RectF paramRectF)
  {
    int j = 0;
    if (paramRect.left > paramRectF.left) {
      j = 1;
    }
    int i = j;
    if (paramRect.right < paramRectF.right) {
      i = j ^ 0x2;
    }
    j = i;
    if (paramRect.top > paramRectF.top) {
      j = i ^ 0x4;
    }
    i = j;
    if (paramRect.bottom < paramRectF.bottom) {
      i = j ^ 0x8;
    }
    return i;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.left < this.jdField_a_of_type_AndroidGraphicsRect.left) {
      this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.offset(this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.left, 0.0F);
    }
    if (this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.right > this.jdField_a_of_type_AndroidGraphicsRect.right) {
      this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.offset(this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.right, 0.0F);
    }
    if (this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.top < this.jdField_a_of_type_AndroidGraphicsRect.top) {
      this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.offset(0.0F, this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.top);
    }
    if (this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.bottom > this.jdField_a_of_type_AndroidGraphicsRect.bottom) {
      this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.offset(0.0F, this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.bottom);
    }
  }
  
  private void a(int paramInt, long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_Double = 1.0D;
    this.jdField_b_of_type_Double = 1.0D;
    if ((paramInt & 0x1) > 0) {
      c();
    }
    if ((paramInt & 0x2) > 0) {
      c();
    }
    if ((paramInt & 0x4) > 0) {
      d();
    }
    if ((paramInt & 0x8) > 0) {
      d();
    }
  }
  
  private void a(int paramInt, Rect paramRect, RectF paramRectF)
  {
    double d3 = 0.0D;
    double d1;
    if ((paramInt & 0x1) > 0)
    {
      d1 = (paramRectF.left - paramRect.left) * -1.8D;
      this.jdField_a_of_type_Airl.jdField_a_of_type_Airn.jdField_a_of_type_Double *= -0.8D;
    }
    for (;;)
    {
      double d2 = d1;
      if ((paramInt & 0x2) > 0)
      {
        d2 = (paramRectF.right - paramRect.right) * -1.8D;
        this.jdField_a_of_type_Airl.jdField_a_of_type_Airn.jdField_a_of_type_Double *= -0.8D;
      }
      d1 = d3;
      if ((paramInt & 0x4) > 0)
      {
        d1 = (paramRectF.top - paramRect.top) * -1.8D;
        this.jdField_a_of_type_Airl.jdField_a_of_type_Airn.jdField_b_of_type_Double *= -0.8D;
      }
      if ((paramInt & 0x8) > 0)
      {
        d1 = (paramRectF.bottom - paramRect.bottom) * (-1.0D + this.g);
        this.jdField_a_of_type_Airl.jdField_a_of_type_Airn.jdField_b_of_type_Double *= this.g;
      }
      this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.offset((float)d2, (float)d1);
      return;
      d1 = 0.0D;
    }
  }
  
  private void a(long paramLong)
  {
    double d1 = this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.centerX();
    double d2 = this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.centerY();
    double d3 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() * this.f;
    double d4 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() * this.f;
    if (this.jdField_e_of_type_Long > 0L)
    {
      paramLong -= this.jdField_e_of_type_Long;
      if (paramLong > 500L)
      {
        this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.left = ((float)(d1 - d3 / 2.0D));
        this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.right = ((float)(d1 + d3 / 2.0D));
        this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.top = ((float)(d2 - d4 / 2.0D));
        this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.bottom = ((float)(d2 + d4 / 2.0D));
        a();
        this.jdField_a_of_type_Airl.jdField_a_of_type_Int = 0;
      }
    }
    else
    {
      return;
    }
    double d6;
    if (paramLong < 100L)
    {
      d5 = paramLong * 1.0D / 100.0D + 1.0D;
      d6 = paramLong * 0.4D / 100.0D + 1.0D;
      this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.left = ((float)(d1 - d3 * d5 / 2.0D));
      this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.right = ((float)(d1 + d3 * d5 / 2.0D));
      this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.top = ((float)(d2 - d4 * d6 / 2.0D));
      this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.bottom = ((float)(d2 + d4 * d6 / 2.0D));
      a();
      return;
    }
    if (paramLong < 200L)
    {
      d5 = (paramLong - 100L) * -0.4D / 100.0D + 2.0D;
      d6 = (paramLong - 100L) * -0.6D / 100.0D + 1.4D;
      this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.left = ((float)(d1 - d3 * d5 / 2.0D));
      this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.right = ((float)(d1 + d3 * d5 / 2.0D));
      this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.top = ((float)(d2 - d4 * d6 / 2.0D));
      this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.bottom = ((float)(d2 + d4 * d6 / 2.0D));
      return;
    }
    if (paramLong < 300L)
    {
      d5 = (paramLong - 200L) * -0.6D / 100.0D + 1.6D;
      d6 = (paramLong - 200L) * 0.5D / 100.0D + 0.8D;
      this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.left = ((float)(d1 - d3 * d5 / 2.0D));
      this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.right = ((float)(d1 + d3 * d5 / 2.0D));
      this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.top = ((float)(d2 - d4 * d6 / 2.0D));
      this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.bottom = ((float)(d2 + d4 * d6 / 2.0D));
      return;
    }
    if (paramLong < 400L)
    {
      d5 = (paramLong - 300L) * 0.2D / 100.0D + 1.0D;
      d6 = (paramLong - 300L) * -0.3D / 100.0D + 1.3D;
      this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.left = ((float)(d1 - d3 * d5 / 2.0D));
      this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.right = ((float)(d1 + d3 * d5 / 2.0D));
      this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.top = ((float)(d2 - d4 * d6 / 2.0D));
      this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.bottom = ((float)(d2 + d4 * d6 / 2.0D));
      return;
    }
    double d5 = (paramLong - 400L) * -0.2D / 100.0D + 1.2D;
    this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.left = ((float)(d1 - d3 * d5 / 2.0D));
    this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.right = ((float)(d1 + d3 * d5 / 2.0D));
    this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.top = ((float)(d2 - d4 * 1.0D / 2.0D));
    this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.bottom = ((float)(d2 + d4 * 1.0D / 2.0D));
  }
  
  private double b(long paramLong)
  {
    if (Math.abs(this.jdField_c_of_type_Double - this.jdField_a_of_type_Double) < 0.01D) {
      return this.jdField_a_of_type_Double;
    }
    paramLong -= this.jdField_a_of_type_Long;
    if (this.jdField_c_of_type_Double < this.jdField_a_of_type_Double)
    {
      double d1 = this.jdField_c_of_type_Double;
      this.jdField_c_of_type_Double = (paramLong * 2L / 1000.0D + d1);
    }
    for (this.jdField_c_of_type_Double = Math.min(this.jdField_a_of_type_Double, this.jdField_c_of_type_Double);; this.jdField_c_of_type_Double = Math.max(this.jdField_a_of_type_Double, this.jdField_c_of_type_Double))
    {
      return this.jdField_c_of_type_Double;
      this.jdField_c_of_type_Double -= paramLong * 2L / 1000.0D;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_Double = 1.0D;
    this.jdField_b_of_type_Double = 1.0D;
  }
  
  private void b(long paramLong)
  {
    double d1 = this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.centerX();
    double d2 = this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.centerY();
    double d3 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() * this.f;
    double d4 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() * this.f;
    this.jdField_c_of_type_Double = b(paramLong);
    this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.left = ((float)(d1 - this.jdField_c_of_type_Double * d3 / 2.0D));
    this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.right = ((float)(d1 + d3 * this.jdField_c_of_type_Double / 2.0D));
    this.jdField_d_of_type_Double = a(paramLong);
    this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.top = ((float)(d2 - this.jdField_d_of_type_Double * d4 / 2.0D));
    this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.bottom = ((float)(d2 + this.jdField_d_of_type_Double * d4 / 2.0D));
  }
  
  private void c()
  {
    this.jdField_a_of_type_Double = Math.max(1.0D - Math.abs(this.jdField_a_of_type_Airl.jdField_a_of_type_Airn.jdField_a_of_type_Double) * 0.0003D, 0.8D);
  }
  
  private void c(long paramLong)
  {
    double d1 = (paramLong - this.jdField_a_of_type_Long) / 1000.0D;
    double d2 = a(this.jdField_a_of_type_Airl.jdField_a_of_type_Airn.jdField_a_of_type_Double, this.jdField_a_of_type_Airl.jdField_a_of_type_Airm.jdField_a_of_type_Double, d1);
    double d3 = a(this.jdField_a_of_type_Airl.jdField_a_of_type_Airn.jdField_b_of_type_Double, this.jdField_a_of_type_Airl.jdField_a_of_type_Airm.jdField_b_of_type_Double, d1);
    airn localairn = this.jdField_a_of_type_Airl.jdField_a_of_type_Airn;
    localairn.jdField_a_of_type_Double += this.jdField_a_of_type_Airl.jdField_a_of_type_Airm.jdField_a_of_type_Double * d1;
    localairn = this.jdField_a_of_type_Airl.jdField_a_of_type_Airn;
    localairn.jdField_b_of_type_Double += this.jdField_a_of_type_Airl.jdField_a_of_type_Airm.jdField_b_of_type_Double * d1;
    double d4 = this.jdField_a_of_type_Airl.jdField_a_of_type_Airn.jdField_a_of_type_Double;
    double d5 = this.jdField_a_of_type_Airl.jdField_a_of_type_Airn.jdField_b_of_type_Double;
    localairn = this.jdField_a_of_type_Airl.jdField_a_of_type_Airn;
    localairn.jdField_a_of_type_Double = (0.0D * d1 * d4 + localairn.jdField_a_of_type_Double);
    localairn = this.jdField_a_of_type_Airl.jdField_a_of_type_Airn;
    localairn.jdField_b_of_type_Double = (0.0D * d1 * d5 + localairn.jdField_b_of_type_Double);
    this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.offset((float)d2, (float)d3);
  }
  
  private void d()
  {
    this.jdField_b_of_type_Double = Math.max(1.0D - Math.abs(this.jdField_a_of_type_Airl.jdField_a_of_type_Airn.jdField_b_of_type_Double) * 0.0003D, 0.8D);
  }
  
  public long a()
  {
    return this.jdField_e_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(airv paramairv)
  {
    this.jdField_a_of_type_Airv = paramairv;
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint, long paramLong, Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect == null)
    {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, paramCanvas.getWidth(), paramCanvas.getHeight());
    }
    if (this.jdField_b_of_type_AndroidGraphicsRect == null) {
      this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    }
    if (this.jdField_a_of_type_Airl.jdField_a_of_type_Int == 5) {
      a(paramLong);
    }
    if (this.jdField_a_of_type_Airl.jdField_a_of_type_Int != 5)
    {
      if (paramLong - this.jdField_b_of_type_Long > 170L) {
        b();
      }
      b(paramLong);
    }
    int i;
    if (this.jdField_a_of_type_Airl.jdField_a_of_type_Int != 3)
    {
      c(paramLong);
      i = a(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF);
      if (i != 0)
      {
        if ((i & 0x8) > 0)
        {
          if (this.jdField_c_of_type_Long == 0L) {
            this.jdField_c_of_type_Long = paramLong;
          }
          this.jdField_a_of_type_Int += 1;
          paramPaint = this.jdField_a_of_type_Airl.jdField_a_of_type_Airn;
          paramPaint.jdField_a_of_type_Double *= 0.95D;
          if ((this.jdField_a_of_type_Airl.jdField_a_of_type_Int != 4) && (this.jdField_a_of_type_Int >= 3))
          {
            this.jdField_a_of_type_Airl.jdField_a_of_type_Int = 4;
            this.jdField_d_of_type_Long = paramLong;
          }
        }
        this.jdField_b_of_type_Int += 1;
        if (this.jdField_b_of_type_Int == 3)
        {
          this.jdField_e_of_type_Double = this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.left;
          this.jdField_a_of_type_Airl.jdField_a_of_type_Airm.jdField_b_of_type_Double = 2000.0D;
          this.g = -0.5D;
        }
        a(i, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF);
        i = a(i);
        if ((i != 0) && (this.jdField_a_of_type_Airl.jdField_a_of_type_Int != 4) && (this.jdField_a_of_type_Airl.jdField_a_of_type_Int != 5)) {
          a(i, paramLong);
        }
      }
    }
    long l;
    if (this.jdField_a_of_type_Airl.jdField_a_of_type_Int != 3)
    {
      int k = paramCanvas.save();
      float f1 = 0.0F;
      if (this.jdField_e_of_type_Double > 0.0D) {
        f1 = (float)((this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.left - this.jdField_e_of_type_Double) * 360.0D / (3.141592653589793D * this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight()));
      }
      paramCanvas.rotate(f1, this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.centerY());
      int j = 255;
      i = j;
      if (this.jdField_a_of_type_Airl.jdField_a_of_type_Int == 4)
      {
        l = paramLong - this.jdField_d_of_type_Long - 2000L;
        i = j;
        if (l > 0L)
        {
          if (l <= 700L) {
            break label552;
          }
          this.jdField_a_of_type_Airl.jdField_a_of_type_Int = 3;
          i = 0;
        }
      }
      paramDrawable.setAlpha(i);
      this.jdField_a_of_type_Airl.jdField_a_of_type_AndroidGraphicsRectF.round(this.jdField_b_of_type_AndroidGraphicsRect);
      paramDrawable.setBounds(this.jdField_b_of_type_AndroidGraphicsRect);
      paramDrawable.draw(paramCanvas);
      paramCanvas.restoreToCount(k);
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = paramLong;
      if (this.jdField_e_of_type_Long == 0L) {
        this.jdField_e_of_type_Long = paramLong;
      }
      return;
      label552:
      i = (int)(255L - l * 255L / 700L);
      break;
      if (this.jdField_a_of_type_Airv != null) {
        this.jdField_a_of_type_Airv.a(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airu
 * JD-Core Version:    0.7.0.1
 */
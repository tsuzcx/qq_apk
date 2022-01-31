import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class aaby
{
  public final float a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int;
  private float jdField_g_of_type_Float = 0.0F;
  private int jdField_g_of_type_Int;
  private float jdField_h_of_type_Float = 1.0F;
  private int jdField_h_of_type_Int;
  private float jdField_i_of_type_Float;
  private int jdField_i_of_type_Int;
  private int j;
  private int k;
  private int l;
  
  public aaby(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public aaby(Context paramContext, Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
    this.jdField_a_of_type_Float = (paramContext.getResources().getDisplayMetrics().density * 800.0F * 386.0878F * ViewConfiguration.getScrollFriction());
  }
  
  private float a(float paramFloat)
  {
    paramFloat = this.jdField_e_of_type_Float * paramFloat;
    if (paramFloat < 1.0F) {}
    for (paramFloat -= 1.0F - (float)Math.exp(-paramFloat);; paramFloat = (1.0F - (float)Math.exp(1.0F - paramFloat)) * (1.0F - 0.3678795F) + 0.3678795F) {
      return paramFloat * this.jdField_f_of_type_Float;
    }
  }
  
  public final int a()
  {
    return this.j;
  }
  
  public int a(int paramInt)
  {
    return (int)(paramInt * paramInt / (2.0F * this.jdField_a_of_type_Float));
  }
  
  public int a(boolean paramBoolean, int paramInt)
  {
    int m = (int)Math.sqrt(paramInt * 2 * this.jdField_a_of_type_Float);
    paramInt = m;
    if (paramBoolean) {
      paramInt = -m;
    }
    return paramInt;
  }
  
  public void a()
  {
    this.j = this.jdField_d_of_type_Int;
    this.k = this.jdField_e_of_type_Int;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, 250);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.l = paramInt5;
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_d_of_type_Int = (paramInt1 + paramInt3);
    this.jdField_e_of_type_Int = (paramInt2 + paramInt4);
    this.jdField_c_of_type_Float = paramInt3;
    this.jdField_d_of_type_Float = paramInt4;
    this.jdField_b_of_type_Float = (1.0F / this.l);
    this.jdField_e_of_type_Float = 8.0F;
    this.jdField_f_of_type_Float = 1.0F;
    this.jdField_f_of_type_Float = (1.0F / a(1.0F));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    float f2 = 1.0F;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = false;
    float f3 = (float)Math.hypot(paramInt3, paramInt4);
    this.jdField_i_of_type_Float = f3;
    this.l = ((int)(1000.0F * f3 / this.jdField_a_of_type_Float));
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    if (f3 == 0.0F)
    {
      f1 = 1.0F;
      this.jdField_g_of_type_Float = f1;
      if (f3 != 0.0F) {
        break label236;
      }
    }
    label236:
    for (float f1 = f2;; f1 = paramInt4 / f3)
    {
      this.jdField_h_of_type_Float = f1;
      paramInt3 = (int)(f3 * f3 / (2.0F * this.jdField_a_of_type_Float));
      this.jdField_f_of_type_Int = paramInt5;
      this.jdField_g_of_type_Int = paramInt6;
      this.jdField_h_of_type_Int = paramInt7;
      this.jdField_i_of_type_Int = paramInt8;
      this.jdField_d_of_type_Int = (Math.round(paramInt3 * this.jdField_g_of_type_Float) + paramInt1);
      this.jdField_d_of_type_Int = Math.min(this.jdField_d_of_type_Int, this.jdField_g_of_type_Int);
      this.jdField_d_of_type_Int = Math.max(this.jdField_d_of_type_Int, this.jdField_f_of_type_Int);
      this.jdField_e_of_type_Int = (Math.round(paramInt3 * this.jdField_h_of_type_Float) + paramInt2);
      this.jdField_e_of_type_Int = Math.min(this.jdField_e_of_type_Int, this.jdField_i_of_type_Int);
      this.jdField_e_of_type_Int = Math.max(this.jdField_e_of_type_Int, this.jdField_h_of_type_Int);
      return;
      f1 = paramInt3 / f3;
      break;
    }
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public final int b()
  {
    return this.k;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return false;
    }
    int m = (int)(AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long);
    if (m < this.l) {
      switch (this.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      return true;
      float f1 = m * this.jdField_b_of_type_Float;
      if (this.jdField_a_of_type_AndroidViewAnimationInterpolator == null) {}
      for (f1 = a(f1);; f1 = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f1))
      {
        this.j = (this.jdField_b_of_type_Int + Math.round(this.jdField_c_of_type_Float * f1));
        m = this.jdField_c_of_type_Int;
        this.k = (Math.round(f1 * this.jdField_d_of_type_Float) + m);
        if ((this.j != this.jdField_d_of_type_Int) || (this.k != this.jdField_e_of_type_Int)) {
          break;
        }
        this.jdField_a_of_type_Boolean = true;
        break;
      }
      f1 = m / 1000.0F;
      f1 = this.jdField_i_of_type_Float * f1 - f1 * (this.jdField_a_of_type_Float * f1) / 2.0F;
      this.j = (this.jdField_b_of_type_Int + Math.round(this.jdField_g_of_type_Float * f1));
      this.j = Math.min(this.j, this.jdField_g_of_type_Int);
      this.j = Math.max(this.j, this.jdField_f_of_type_Int);
      m = this.jdField_c_of_type_Int;
      this.k = (Math.round(f1 * this.jdField_h_of_type_Float) + m);
      this.k = Math.min(this.k, this.jdField_i_of_type_Int);
      this.k = Math.max(this.k, this.jdField_h_of_type_Int);
      if ((this.j == this.jdField_d_of_type_Int) && (this.k == this.jdField_e_of_type_Int))
      {
        this.jdField_a_of_type_Boolean = true;
        continue;
        this.j = this.jdField_d_of_type_Int;
        this.k = this.jdField_e_of_type_Int;
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaby
 * JD-Core Version:    0.7.0.1
 */
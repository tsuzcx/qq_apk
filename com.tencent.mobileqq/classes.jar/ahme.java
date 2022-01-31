import com.tencent.qphone.base.util.QLog;

public class ahme
{
  protected double a;
  protected int a;
  protected short a;
  private boolean a;
  protected double b;
  protected int b;
  private boolean b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  
  public ahme()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = -1;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = (paramInt / 50);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Double = 2.25D;
      this.jdField_a_of_type_Double = 2.0D;
      this.jdField_b_of_type_Int = 20;
      return;
    }
    this.jdField_b_of_type_Double = (62500 * this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Double = (0.0500000007450581D * this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Int = -1;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return true;
    }
    int i = 0;
    while (i < paramInt2)
    {
      this.c += 1;
      if (((paramArrayOfShort[(i + paramInt1)] >= 0) && (this.jdField_a_of_type_Short < 0)) || ((paramArrayOfShort[(i + paramInt1)] < 0) && (this.jdField_a_of_type_Short >= 0))) {
        this.d += 1;
      }
      this.jdField_a_of_type_Short = paramArrayOfShort[(i + paramInt1)];
      this.f += paramArrayOfShort[i] * paramArrayOfShort[i];
      if (this.c >= this.jdField_a_of_type_Int)
      {
        this.c = 0;
        if (this.jdField_b_of_type_Int >= 0)
        {
          if (this.jdField_b_of_type_Int == 0)
          {
            this.jdField_a_of_type_Double = (this.d * this.jdField_a_of_type_Double / 20.0D);
            this.jdField_b_of_type_Double = (this.f * this.jdField_b_of_type_Double / 20.0D);
            if (this.jdField_a_of_type_Double > 100.0D)
            {
              if (QLog.isColorLevel()) {
                QLog.d("NoiseDetector", 2, "large zero threshold, reset:" + this.jdField_a_of_type_Double);
              }
              this.jdField_a_of_type_Double = 100.0D;
            }
            if (this.jdField_b_of_type_Double > 85000000.0D)
            {
              if (QLog.isColorLevel()) {
                QLog.d("NoiseDetector", 2, "large power threshold, reset:" + this.jdField_b_of_type_Double);
              }
              this.jdField_b_of_type_Double = 85000000.0D;
            }
            if (QLog.isColorLevel()) {
              QLog.d("NoiseDetector", 2, "calc new threshold:" + this.jdField_a_of_type_Double + " - " + this.jdField_b_of_type_Double);
            }
            this.d = 0;
            this.f = 0;
            this.e = 0;
            this.g = 0;
          }
          this.jdField_b_of_type_Int -= 1;
        }
      }
      else
      {
        i += 1;
        continue;
      }
      int j = 0;
      int k = 0;
      if (this.d >= this.jdField_a_of_type_Double)
      {
        this.e += 1;
        label382:
        if (this.e >= 1)
        {
          this.e = 0;
          if (QLog.isColorLevel()) {
            QLog.d("NoiseDetector", 2, "reach Zero cross :" + this.d + "-" + this.jdField_a_of_type_Double);
          }
          j = 1;
        }
        this.d = 0;
        if (this.f < this.jdField_b_of_type_Double) {
          break label573;
        }
      }
      label573:
      for (this.g += 1;; this.g = 0)
      {
        if (this.g >= 1)
        {
          this.g = 0;
          if (QLog.isColorLevel()) {
            QLog.d("NoiseDetector", 2, "reach Power:" + this.f + "-" + this.jdField_b_of_type_Double);
          }
          k = 1;
        }
        this.f = 0;
        if ((j == 0) || (k == 0)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("NoiseDetector", 2, "DETECT VOICE..:");
        }
        return true;
        this.e = 0;
        break label382;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahme
 * JD-Core Version:    0.7.0.1
 */
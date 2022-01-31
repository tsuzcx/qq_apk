import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;

class adxm
  implements bejw
{
  int jdField_a_of_type_Int = -2147483648;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 2147483647;
  boolean jdField_b_of_type_Boolean;
  
  adxm(adxg paramadxg) {}
  
  public adyb a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_Adxg.a.a(paramInt);
    if (adyb.class.isInstance(localObject)) {
      return (adyb)localObject;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    boolean bool2 = false;
    if (!adxg.b(this.jdField_a_of_type_Adxg)) {}
    adyb localadyb;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Adxg.a() == 2);
      localadyb = a(paramInt);
    } while (localadyb == null);
    if (localadyb.b() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      adxg localadxg = this.jdField_a_of_type_Adxg;
      bool1 = bool2;
      if (!this.jdField_a_of_type_Boolean) {
        bool1 = true;
      }
      if (localadxg.a(localadyb, bool1, true))
      {
        this.jdField_a_of_type_Adxg.w();
        adxg.g(this.jdField_a_of_type_Adxg).invalidateViews();
      }
      this.jdField_b_of_type_Boolean = true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOImageListScene", 2, "onSelectBegin beginIndex:" + paramInt);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!adxg.c(this.jdField_a_of_type_Adxg)) {}
    while ((this.jdField_a_of_type_Adxg.a() == 2) || (!this.jdField_b_of_type_Boolean)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "onSelectChanged beginIndex:" + paramInt1 + " selectIndex:" + paramInt2);
    }
    int j;
    int i;
    if (paramInt2 < paramInt1)
    {
      j = paramInt1;
      i = paramInt2;
      if (this.jdField_b_of_type_Int > paramInt2)
      {
        this.jdField_b_of_type_Int = paramInt2;
        i = paramInt2;
        j = paramInt1;
      }
    }
    adyb localadyb;
    for (;;)
    {
      paramInt1 = i;
      for (;;)
      {
        if (paramInt1 > j) {
          break label181;
        }
        localadyb = a(paramInt1);
        if (localadyb != null) {
          break;
        }
        paramInt1 += 1;
      }
      if (this.jdField_a_of_type_Int < paramInt2) {
        this.jdField_a_of_type_Int = paramInt2;
      }
      j = paramInt2;
      i = paramInt1;
    }
    adxg localadxg = this.jdField_a_of_type_Adxg;
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localadxg.a(localadyb, bool, true);
      break;
    }
    label181:
    paramInt1 = j + 1;
    if (paramInt1 <= this.jdField_a_of_type_Int)
    {
      localadyb = a(paramInt1);
      if (localadyb == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.jdField_a_of_type_Adxg.a(localadyb, this.jdField_a_of_type_Boolean, true);
      }
    }
    paramInt1 = this.jdField_b_of_type_Int;
    if (paramInt1 < i)
    {
      localadyb = a(paramInt1);
      if (localadyb == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.jdField_a_of_type_Adxg.a(localadyb, this.jdField_a_of_type_Boolean, true);
      }
    }
    this.jdField_a_of_type_Adxg.w();
    adxg.h(this.jdField_a_of_type_Adxg).invalidateViews();
  }
  
  public void g()
  {
    if (!adxg.d(this.jdField_a_of_type_Adxg)) {}
    while ((this.jdField_a_of_type_Adxg.a() == 2) || (!this.jdField_b_of_type_Boolean)) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "onSelectEnd");
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -2147483648;
    this.jdField_b_of_type_Int = 2147483647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adxm
 * JD-Core Version:    0.7.0.1
 */
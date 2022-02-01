import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;

class aide
  implements blma
{
  int jdField_a_of_type_Int = -2147483648;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 2147483647;
  boolean jdField_b_of_type_Boolean;
  
  aide(aicy paramaicy) {}
  
  public aidw a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_Aicy.a.a(paramInt);
    if (aidw.class.isInstance(localObject)) {
      return (aidw)localObject;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    boolean bool2 = false;
    if (!aicy.b(this.jdField_a_of_type_Aicy)) {}
    aidw localaidw;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Aicy.a() == 2);
      localaidw = a(paramInt);
    } while (localaidw == null);
    if (localaidw.b() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      aicy localaicy = this.jdField_a_of_type_Aicy;
      bool1 = bool2;
      if (!this.jdField_a_of_type_Boolean) {
        bool1 = true;
      }
      if (localaicy.a(localaidw, bool1, true))
      {
        this.jdField_a_of_type_Aicy.w();
        aicy.g(this.jdField_a_of_type_Aicy).invalidateViews();
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
    if (!aicy.c(this.jdField_a_of_type_Aicy)) {}
    while ((this.jdField_a_of_type_Aicy.a() == 2) || (!this.jdField_b_of_type_Boolean)) {
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
    aidw localaidw;
    for (;;)
    {
      paramInt1 = i;
      for (;;)
      {
        if (paramInt1 > j) {
          break label181;
        }
        localaidw = a(paramInt1);
        if (localaidw != null) {
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
    aicy localaicy = this.jdField_a_of_type_Aicy;
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localaicy.a(localaidw, bool, true);
      break;
    }
    label181:
    paramInt1 = j + 1;
    if (paramInt1 <= this.jdField_a_of_type_Int)
    {
      localaidw = a(paramInt1);
      if (localaidw == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.jdField_a_of_type_Aicy.a(localaidw, this.jdField_a_of_type_Boolean, true);
      }
    }
    paramInt1 = this.jdField_b_of_type_Int;
    if (paramInt1 < i)
    {
      localaidw = a(paramInt1);
      if (localaidw == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.jdField_a_of_type_Aicy.a(localaidw, this.jdField_a_of_type_Boolean, true);
      }
    }
    this.jdField_a_of_type_Aicy.w();
    aicy.h(this.jdField_a_of_type_Aicy).invalidateViews();
  }
  
  public void h()
  {
    if (!aicy.d(this.jdField_a_of_type_Aicy)) {}
    while ((this.jdField_a_of_type_Aicy.a() == 2) || (!this.jdField_b_of_type_Boolean)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aide
 * JD-Core Version:    0.7.0.1
 */
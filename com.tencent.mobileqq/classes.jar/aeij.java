import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;

class aeij
  implements bfsh
{
  int jdField_a_of_type_Int = -2147483648;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 2147483647;
  boolean jdField_b_of_type_Boolean;
  
  aeij(aeid paramaeid) {}
  
  public aeiy a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_Aeid.a.a(paramInt);
    if (aeiy.class.isInstance(localObject)) {
      return (aeiy)localObject;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    boolean bool2 = false;
    if (!aeid.b(this.jdField_a_of_type_Aeid)) {}
    aeiy localaeiy;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Aeid.a() == 2);
      localaeiy = a(paramInt);
    } while (localaeiy == null);
    if (localaeiy.b() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      aeid localaeid = this.jdField_a_of_type_Aeid;
      bool1 = bool2;
      if (!this.jdField_a_of_type_Boolean) {
        bool1 = true;
      }
      if (localaeid.a(localaeiy, bool1, true))
      {
        this.jdField_a_of_type_Aeid.w();
        aeid.g(this.jdField_a_of_type_Aeid).invalidateViews();
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
    if (!aeid.c(this.jdField_a_of_type_Aeid)) {}
    while ((this.jdField_a_of_type_Aeid.a() == 2) || (!this.jdField_b_of_type_Boolean)) {
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
    aeiy localaeiy;
    for (;;)
    {
      paramInt1 = i;
      for (;;)
      {
        if (paramInt1 > j) {
          break label181;
        }
        localaeiy = a(paramInt1);
        if (localaeiy != null) {
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
    aeid localaeid = this.jdField_a_of_type_Aeid;
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localaeid.a(localaeiy, bool, true);
      break;
    }
    label181:
    paramInt1 = j + 1;
    if (paramInt1 <= this.jdField_a_of_type_Int)
    {
      localaeiy = a(paramInt1);
      if (localaeiy == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.jdField_a_of_type_Aeid.a(localaeiy, this.jdField_a_of_type_Boolean, true);
      }
    }
    paramInt1 = this.jdField_b_of_type_Int;
    if (paramInt1 < i)
    {
      localaeiy = a(paramInt1);
      if (localaeiy == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.jdField_a_of_type_Aeid.a(localaeiy, this.jdField_a_of_type_Boolean, true);
      }
    }
    this.jdField_a_of_type_Aeid.w();
    aeid.h(this.jdField_a_of_type_Aeid).invalidateViews();
  }
  
  public void g()
  {
    if (!aeid.d(this.jdField_a_of_type_Aeid)) {}
    while ((this.jdField_a_of_type_Aeid.a() == 2) || (!this.jdField_b_of_type_Boolean)) {
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
 * Qualified Name:     aeij
 * JD-Core Version:    0.7.0.1
 */
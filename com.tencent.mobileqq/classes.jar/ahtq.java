import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;

class ahtq
  implements bkkx
{
  int jdField_a_of_type_Int = -2147483648;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 2147483647;
  boolean jdField_b_of_type_Boolean;
  
  ahtq(ahtk paramahtk) {}
  
  public ahui a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_Ahtk.a.a(paramInt);
    if (ahui.class.isInstance(localObject)) {
      return (ahui)localObject;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    boolean bool2 = false;
    if (!ahtk.b(this.jdField_a_of_type_Ahtk)) {}
    ahui localahui;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Ahtk.a() == 2);
      localahui = a(paramInt);
    } while (localahui == null);
    if (localahui.b() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      ahtk localahtk = this.jdField_a_of_type_Ahtk;
      bool1 = bool2;
      if (!this.jdField_a_of_type_Boolean) {
        bool1 = true;
      }
      if (localahtk.a(localahui, bool1, true))
      {
        this.jdField_a_of_type_Ahtk.w();
        ahtk.g(this.jdField_a_of_type_Ahtk).invalidateViews();
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
    if (!ahtk.c(this.jdField_a_of_type_Ahtk)) {}
    while ((this.jdField_a_of_type_Ahtk.a() == 2) || (!this.jdField_b_of_type_Boolean)) {
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
    ahui localahui;
    for (;;)
    {
      paramInt1 = i;
      for (;;)
      {
        if (paramInt1 > j) {
          break label181;
        }
        localahui = a(paramInt1);
        if (localahui != null) {
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
    ahtk localahtk = this.jdField_a_of_type_Ahtk;
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localahtk.a(localahui, bool, true);
      break;
    }
    label181:
    paramInt1 = j + 1;
    if (paramInt1 <= this.jdField_a_of_type_Int)
    {
      localahui = a(paramInt1);
      if (localahui == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.jdField_a_of_type_Ahtk.a(localahui, this.jdField_a_of_type_Boolean, true);
      }
    }
    paramInt1 = this.jdField_b_of_type_Int;
    if (paramInt1 < i)
    {
      localahui = a(paramInt1);
      if (localahui == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.jdField_a_of_type_Ahtk.a(localahui, this.jdField_a_of_type_Boolean, true);
      }
    }
    this.jdField_a_of_type_Ahtk.w();
    ahtk.h(this.jdField_a_of_type_Ahtk).invalidateViews();
  }
  
  public void h()
  {
    if (!ahtk.d(this.jdField_a_of_type_Ahtk)) {}
    while ((this.jdField_a_of_type_Ahtk.a() == 2) || (!this.jdField_b_of_type_Boolean)) {
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
 * Qualified Name:     ahtq
 * JD-Core Version:    0.7.0.1
 */
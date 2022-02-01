import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;

class agzu
  implements bjqw
{
  int jdField_a_of_type_Int = -2147483648;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 2147483647;
  boolean jdField_b_of_type_Boolean;
  
  agzu(agzo paramagzo) {}
  
  public aham a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_Agzo.a.a(paramInt);
    if (aham.class.isInstance(localObject)) {
      return (aham)localObject;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    boolean bool2 = false;
    if (!agzo.b(this.jdField_a_of_type_Agzo)) {}
    aham localaham;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Agzo.a() == 2);
      localaham = a(paramInt);
    } while (localaham == null);
    if (localaham.getSelected() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      agzo localagzo = this.jdField_a_of_type_Agzo;
      bool1 = bool2;
      if (!this.jdField_a_of_type_Boolean) {
        bool1 = true;
      }
      if (localagzo.a(localaham, bool1, true))
      {
        this.jdField_a_of_type_Agzo.w();
        agzo.g(this.jdField_a_of_type_Agzo).invalidateViews();
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
    if (!agzo.c(this.jdField_a_of_type_Agzo)) {}
    while ((this.jdField_a_of_type_Agzo.a() == 2) || (!this.jdField_b_of_type_Boolean)) {
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
    aham localaham;
    for (;;)
    {
      paramInt1 = i;
      for (;;)
      {
        if (paramInt1 > j) {
          break label181;
        }
        localaham = a(paramInt1);
        if (localaham != null) {
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
    agzo localagzo = this.jdField_a_of_type_Agzo;
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localagzo.a(localaham, bool, true);
      break;
    }
    label181:
    paramInt1 = j + 1;
    if (paramInt1 <= this.jdField_a_of_type_Int)
    {
      localaham = a(paramInt1);
      if (localaham == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.jdField_a_of_type_Agzo.a(localaham, this.jdField_a_of_type_Boolean, true);
      }
    }
    paramInt1 = this.jdField_b_of_type_Int;
    if (paramInt1 < i)
    {
      localaham = a(paramInt1);
      if (localaham == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.jdField_a_of_type_Agzo.a(localaham, this.jdField_a_of_type_Boolean, true);
      }
    }
    this.jdField_a_of_type_Agzo.w();
    agzo.h(this.jdField_a_of_type_Agzo).invalidateViews();
  }
  
  public void h()
  {
    if (!agzo.d(this.jdField_a_of_type_Agzo)) {}
    while ((this.jdField_a_of_type_Agzo.a() == 2) || (!this.jdField_b_of_type_Boolean)) {
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
 * Qualified Name:     agzu
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;

class ahsu
  implements blci
{
  int jdField_a_of_type_Int = -2147483648;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 2147483647;
  boolean jdField_b_of_type_Boolean;
  
  ahsu(ahso paramahso) {}
  
  public ahtm a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_Ahso.a.a(paramInt);
    if (ahtm.class.isInstance(localObject)) {
      return (ahtm)localObject;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    boolean bool2 = false;
    if (!ahso.b(this.jdField_a_of_type_Ahso)) {}
    ahtm localahtm;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Ahso.a() == 2);
      localahtm = a(paramInt);
    } while (localahtm == null);
    if (localahtm.getSelected() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      ahso localahso = this.jdField_a_of_type_Ahso;
      bool1 = bool2;
      if (!this.jdField_a_of_type_Boolean) {
        bool1 = true;
      }
      if (localahso.a(localahtm, bool1, true))
      {
        this.jdField_a_of_type_Ahso.w();
        ahso.g(this.jdField_a_of_type_Ahso).invalidateViews();
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
    if (!ahso.c(this.jdField_a_of_type_Ahso)) {}
    while ((this.jdField_a_of_type_Ahso.a() == 2) || (!this.jdField_b_of_type_Boolean)) {
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
    ahtm localahtm;
    for (;;)
    {
      paramInt1 = i;
      for (;;)
      {
        if (paramInt1 > j) {
          break label181;
        }
        localahtm = a(paramInt1);
        if (localahtm != null) {
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
    ahso localahso = this.jdField_a_of_type_Ahso;
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localahso.a(localahtm, bool, true);
      break;
    }
    label181:
    paramInt1 = j + 1;
    if (paramInt1 <= this.jdField_a_of_type_Int)
    {
      localahtm = a(paramInt1);
      if (localahtm == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.jdField_a_of_type_Ahso.a(localahtm, this.jdField_a_of_type_Boolean, true);
      }
    }
    paramInt1 = this.jdField_b_of_type_Int;
    if (paramInt1 < i)
    {
      localahtm = a(paramInt1);
      if (localahtm == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.jdField_a_of_type_Ahso.a(localahtm, this.jdField_a_of_type_Boolean, true);
      }
    }
    this.jdField_a_of_type_Ahso.w();
    ahso.h(this.jdField_a_of_type_Ahso).invalidateViews();
  }
  
  public void h()
  {
    if (!ahso.d(this.jdField_a_of_type_Ahso)) {}
    while ((this.jdField_a_of_type_Ahso.a() == 2) || (!this.jdField_b_of_type_Boolean)) {
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
 * Qualified Name:     ahsu
 * JD-Core Version:    0.7.0.1
 */
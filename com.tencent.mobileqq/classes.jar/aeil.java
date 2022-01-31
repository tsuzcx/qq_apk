import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;

class aeil
  implements bfrq
{
  int jdField_a_of_type_Int = -2147483648;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 2147483647;
  boolean jdField_b_of_type_Boolean;
  
  aeil(aeif paramaeif) {}
  
  public aeja a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_Aeif.a.a(paramInt);
    if (aeja.class.isInstance(localObject)) {
      return (aeja)localObject;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    boolean bool2 = false;
    if (!aeif.b(this.jdField_a_of_type_Aeif)) {}
    aeja localaeja;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Aeif.a() == 2);
      localaeja = a(paramInt);
    } while (localaeja == null);
    if (localaeja.b() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      aeif localaeif = this.jdField_a_of_type_Aeif;
      bool1 = bool2;
      if (!this.jdField_a_of_type_Boolean) {
        bool1 = true;
      }
      if (localaeif.a(localaeja, bool1, true))
      {
        this.jdField_a_of_type_Aeif.w();
        aeif.g(this.jdField_a_of_type_Aeif).invalidateViews();
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
    if (!aeif.c(this.jdField_a_of_type_Aeif)) {}
    while ((this.jdField_a_of_type_Aeif.a() == 2) || (!this.jdField_b_of_type_Boolean)) {
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
    aeja localaeja;
    for (;;)
    {
      paramInt1 = i;
      for (;;)
      {
        if (paramInt1 > j) {
          break label181;
        }
        localaeja = a(paramInt1);
        if (localaeja != null) {
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
    aeif localaeif = this.jdField_a_of_type_Aeif;
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localaeif.a(localaeja, bool, true);
      break;
    }
    label181:
    paramInt1 = j + 1;
    if (paramInt1 <= this.jdField_a_of_type_Int)
    {
      localaeja = a(paramInt1);
      if (localaeja == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.jdField_a_of_type_Aeif.a(localaeja, this.jdField_a_of_type_Boolean, true);
      }
    }
    paramInt1 = this.jdField_b_of_type_Int;
    if (paramInt1 < i)
    {
      localaeja = a(paramInt1);
      if (localaeja == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.jdField_a_of_type_Aeif.a(localaeja, this.jdField_a_of_type_Boolean, true);
      }
    }
    this.jdField_a_of_type_Aeif.w();
    aeif.h(this.jdField_a_of_type_Aeif).invalidateViews();
  }
  
  public void g()
  {
    if (!aeif.d(this.jdField_a_of_type_Aeif)) {}
    while ((this.jdField_a_of_type_Aeif.a() == 2) || (!this.jdField_b_of_type_Boolean)) {
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
 * Qualified Name:     aeil
 * JD-Core Version:    0.7.0.1
 */
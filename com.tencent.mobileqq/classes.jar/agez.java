import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;

class agez
  implements bhte
{
  int jdField_a_of_type_Int = -2147483648;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 2147483647;
  boolean jdField_b_of_type_Boolean;
  
  agez(aget paramaget) {}
  
  public agfq a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_Aget.a.a(paramInt);
    if (agfq.class.isInstance(localObject)) {
      return (agfq)localObject;
    }
    return null;
  }
  
  public void onSelectBegin(int paramInt)
  {
    boolean bool2 = false;
    if (!aget.b(this.jdField_a_of_type_Aget)) {}
    agfq localagfq;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Aget.a() == 2);
      localagfq = a(paramInt);
    } while (localagfq == null);
    if (localagfq.b() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      aget localaget = this.jdField_a_of_type_Aget;
      bool1 = bool2;
      if (!this.jdField_a_of_type_Boolean) {
        bool1 = true;
      }
      if (localaget.a(localagfq, bool1, true))
      {
        this.jdField_a_of_type_Aget.w();
        aget.g(this.jdField_a_of_type_Aget).invalidateViews();
      }
      this.jdField_b_of_type_Boolean = true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOImageListScene", 2, "onSelectBegin beginIndex:" + paramInt);
      return;
    }
  }
  
  public void onSelectChanged(int paramInt1, int paramInt2)
  {
    if (!aget.c(this.jdField_a_of_type_Aget)) {}
    while ((this.jdField_a_of_type_Aget.a() == 2) || (!this.jdField_b_of_type_Boolean)) {
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
    agfq localagfq;
    for (;;)
    {
      paramInt1 = i;
      for (;;)
      {
        if (paramInt1 > j) {
          break label181;
        }
        localagfq = a(paramInt1);
        if (localagfq != null) {
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
    aget localaget = this.jdField_a_of_type_Aget;
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localaget.a(localagfq, bool, true);
      break;
    }
    label181:
    paramInt1 = j + 1;
    if (paramInt1 <= this.jdField_a_of_type_Int)
    {
      localagfq = a(paramInt1);
      if (localagfq == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.jdField_a_of_type_Aget.a(localagfq, this.jdField_a_of_type_Boolean, true);
      }
    }
    paramInt1 = this.jdField_b_of_type_Int;
    if (paramInt1 < i)
    {
      localagfq = a(paramInt1);
      if (localagfq == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.jdField_a_of_type_Aget.a(localagfq, this.jdField_a_of_type_Boolean, true);
      }
    }
    this.jdField_a_of_type_Aget.w();
    aget.h(this.jdField_a_of_type_Aget).invalidateViews();
  }
  
  public void onSelectEnd()
  {
    if (!aget.d(this.jdField_a_of_type_Aget)) {}
    while ((this.jdField_a_of_type_Aget.a() == 2) || (!this.jdField_b_of_type_Boolean)) {
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
 * Qualified Name:     agez
 * JD-Core Version:    0.7.0.1
 */
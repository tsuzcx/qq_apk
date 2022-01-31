import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;

class agjo
  implements bhxl
{
  int jdField_a_of_type_Int = -2147483648;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 2147483647;
  boolean jdField_b_of_type_Boolean;
  
  agjo(agji paramagji) {}
  
  public agkf a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_Agji.a.a(paramInt);
    if (agkf.class.isInstance(localObject)) {
      return (agkf)localObject;
    }
    return null;
  }
  
  public void onSelectBegin(int paramInt)
  {
    boolean bool2 = false;
    if (!agji.b(this.jdField_a_of_type_Agji)) {}
    agkf localagkf;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Agji.a() == 2);
      localagkf = a(paramInt);
    } while (localagkf == null);
    if (localagkf.b() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      agji localagji = this.jdField_a_of_type_Agji;
      bool1 = bool2;
      if (!this.jdField_a_of_type_Boolean) {
        bool1 = true;
      }
      if (localagji.a(localagkf, bool1, true))
      {
        this.jdField_a_of_type_Agji.w();
        agji.g(this.jdField_a_of_type_Agji).invalidateViews();
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
    if (!agji.c(this.jdField_a_of_type_Agji)) {}
    while ((this.jdField_a_of_type_Agji.a() == 2) || (!this.jdField_b_of_type_Boolean)) {
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
    agkf localagkf;
    for (;;)
    {
      paramInt1 = i;
      for (;;)
      {
        if (paramInt1 > j) {
          break label181;
        }
        localagkf = a(paramInt1);
        if (localagkf != null) {
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
    agji localagji = this.jdField_a_of_type_Agji;
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localagji.a(localagkf, bool, true);
      break;
    }
    label181:
    paramInt1 = j + 1;
    if (paramInt1 <= this.jdField_a_of_type_Int)
    {
      localagkf = a(paramInt1);
      if (localagkf == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.jdField_a_of_type_Agji.a(localagkf, this.jdField_a_of_type_Boolean, true);
      }
    }
    paramInt1 = this.jdField_b_of_type_Int;
    if (paramInt1 < i)
    {
      localagkf = a(paramInt1);
      if (localagkf == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.jdField_a_of_type_Agji.a(localagkf, this.jdField_a_of_type_Boolean, true);
      }
    }
    this.jdField_a_of_type_Agji.w();
    agji.h(this.jdField_a_of_type_Agji).invalidateViews();
  }
  
  public void onSelectEnd()
  {
    if (!agji.d(this.jdField_a_of_type_Agji)) {}
    while ((this.jdField_a_of_type_Agji.a() == 2) || (!this.jdField_b_of_type_Boolean)) {
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
 * Qualified Name:     agjo
 * JD-Core Version:    0.7.0.1
 */
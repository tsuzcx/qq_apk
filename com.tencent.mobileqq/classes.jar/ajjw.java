import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ajjw
{
  public ArrayList<ajki> a;
  private boolean a;
  public int[] a;
  public String[] a;
  private boolean b;
  
  public ajjw(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if ((paramBoolean1) && (!bdvn.a())) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.b = paramBoolean1;
      this.jdField_a_of_type_Boolean = paramBoolean2;
      a();
      return;
    }
  }
  
  public int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return ((ajki)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c;
    }
    return 1;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.b) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new ajki(0, 2131365117, anvx.a(2131702056)));
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new ajki(6, 2131365114, anvx.a(2131702042)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ajki(1, 2131365113, anvx.a(2131702013)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ajki(2, 2131365118, anvx.a(2131702055)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ajki(3, 2131365111, anvx.a(2131702039)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ajki(4, 2131365115, anvx.a(2131702035)));
    if (!bdvn.a()) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new ajki(5, 2131365116, usu.a()));
    }
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[j];
    this.jdField_a_of_type_ArrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = ((ajki)this.jdField_a_of_type_JavaUtilArrayList.get(i)).d;
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((ajki)this.jdField_a_of_type_JavaUtilArrayList.get(i)).f;
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTabs", 2, "buildData showRecommend:" + this.b + " tabSize:" + j);
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!bdvn.a()))
    {
      paramBoolean1 = true;
      if (paramBoolean1 == this.b) {
        break label205;
      }
      this.b = paramBoolean1;
      if (!paramBoolean1) {
        break label150;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(0, new ajki(0, 2131365117, anvx.a(2131702010)));
    }
    int j;
    for (;;)
    {
      j = this.jdField_a_of_type_JavaUtilArrayList.size();
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[j];
      this.jdField_a_of_type_ArrayOfInt = new int[j];
      int i = 0;
      while (i < j)
      {
        ajki localajki = (ajki)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localajki.c == 5) {
          localajki.f = usu.a();
        }
        this.jdField_a_of_type_ArrayOfInt[i] = localajki.d;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = localajki.f;
        i += 1;
      }
      paramBoolean1 = false;
      break;
      label150:
      this.jdField_a_of_type_JavaUtilArrayList.remove(0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTabs", 2, "update showRecommend1:" + paramBoolean1 + " tabSize:" + j);
    }
    return true;
    label205:
    if (paramBoolean2 != this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean2;
      a();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTabs", 2, "update showRecommend2:" + paramBoolean1 + " tabSize:" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    return false;
  }
  
  public int b(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((ajki)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjw
 * JD-Core Version:    0.7.0.1
 */
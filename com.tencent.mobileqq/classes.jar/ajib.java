import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ajib
{
  public ArrayList<ajin> a;
  private boolean a;
  public int[] a;
  public String[] a;
  
  public ajib(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if ((paramBoolean) && (!bdch.a())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      a();
      return;
    }
  }
  
  public int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return ((ajin)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c;
    }
    return 1;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new ajin(0, 2131364959, anni.a(2131701363)));
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new ajin(6, 2131364956, anni.a(2131701349)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ajin(1, 2131364955, anni.a(2131701320)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ajin(2, 2131364960, anni.a(2131701362)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ajin(3, 2131364953, anni.a(2131701346)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ajin(4, 2131364957, anni.a(2131701342)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ajin(5, 2131364958, tyg.a()));
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[j];
    this.jdField_a_of_type_ArrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = ((ajin)this.jdField_a_of_type_JavaUtilArrayList.get(i)).d;
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((ajin)this.jdField_a_of_type_JavaUtilArrayList.get(i)).f;
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTabs", 2, "buildData showRecommend:" + this.jdField_a_of_type_Boolean + " tabSize:" + j);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if ((paramBoolean) && (!bdch.a()))
    {
      paramBoolean = true;
      if (paramBoolean == this.jdField_a_of_type_Boolean) {
        break label200;
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (!paramBoolean) {
        break label146;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(0, new ajin(0, 2131364959, anni.a(2131701317)));
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
        ajin localajin = (ajin)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localajin.c == 5) {
          localajin.f = tyg.a();
        }
        this.jdField_a_of_type_ArrayOfInt[i] = localajin.d;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = localajin.f;
        i += 1;
      }
      paramBoolean = false;
      break;
      label146:
      this.jdField_a_of_type_JavaUtilArrayList.remove(0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTabs", 2, "update showRecommend1:" + paramBoolean + " tabSize:" + j);
    }
    return true;
    label200:
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTabs", 2, "update showRecommend2:" + paramBoolean + " tabSize:" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    return false;
  }
  
  public int b(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((ajin)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajib
 * JD-Core Version:    0.7.0.1
 */
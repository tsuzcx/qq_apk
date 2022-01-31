import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ahmn
{
  public ArrayList<ahms> a;
  private boolean a;
  public int[] a;
  public String[] a;
  
  public ahmn(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if ((paramBoolean) && (!azwu.a())) {}
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
      return ((ahms)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c;
    }
    return 1;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new ahms(0, 2131364732, alpo.a(2131702944)));
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new ahms(6, 2131364729, alpo.a(2131702930)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ahms(1, 2131364728, alpo.a(2131702901)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ahms(2, 2131364733, alpo.a(2131702943)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ahms(3, 2131364726, alpo.a(2131702927)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ahms(4, 2131364730, alpo.a(2131702923)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ahms(5, 2131364731, swy.a()));
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[j];
    this.jdField_a_of_type_ArrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = ((ahms)this.jdField_a_of_type_JavaUtilArrayList.get(i)).d;
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((ahms)this.jdField_a_of_type_JavaUtilArrayList.get(i)).f;
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
    if ((paramBoolean) && (!azwu.a()))
    {
      paramBoolean = true;
      if (paramBoolean == this.jdField_a_of_type_Boolean) {
        break label200;
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (!paramBoolean) {
        break label146;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(0, new ahms(0, 2131364732, alpo.a(2131702898)));
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
        ahms localahms = (ahms)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localahms.c == 5) {
          localahms.f = swy.a();
        }
        this.jdField_a_of_type_ArrayOfInt[i] = localahms.d;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = localahms.f;
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
      if (((ahms)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmn
 * JD-Core Version:    0.7.0.1
 */
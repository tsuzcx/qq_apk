import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ahrc
{
  public ArrayList<ahrh> a;
  private boolean a;
  public int[] a;
  public String[] a;
  
  public ahrc(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if ((paramBoolean) && (!babd.a())) {}
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
      return ((ahrh)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c;
    }
    return 1;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new ahrh(0, 2131364733, alud.a(2131702956)));
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new ahrh(6, 2131364730, alud.a(2131702942)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ahrh(1, 2131364729, alud.a(2131702913)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ahrh(2, 2131364734, alud.a(2131702955)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ahrh(3, 2131364727, alud.a(2131702939)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ahrh(4, 2131364731, alud.a(2131702935)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ahrh(5, 2131364732, swy.a()));
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[j];
    this.jdField_a_of_type_ArrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = ((ahrh)this.jdField_a_of_type_JavaUtilArrayList.get(i)).d;
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((ahrh)this.jdField_a_of_type_JavaUtilArrayList.get(i)).f;
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
    if ((paramBoolean) && (!babd.a()))
    {
      paramBoolean = true;
      if (paramBoolean == this.jdField_a_of_type_Boolean) {
        break label200;
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (!paramBoolean) {
        break label146;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(0, new ahrh(0, 2131364733, alud.a(2131702910)));
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
        ahrh localahrh = (ahrh)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localahrh.c == 5) {
          localahrh.f = swy.a();
        }
        this.jdField_a_of_type_ArrayOfInt[i] = localahrh.d;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = localahrh.f;
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
      if (((ahrh)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrc
 * JD-Core Version:    0.7.0.1
 */
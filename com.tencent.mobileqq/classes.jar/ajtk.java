import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ajtk
{
  public ArrayList<ajtw> a;
  private boolean a;
  public int[] a;
  public String[] a;
  
  public ajtk(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if ((paramBoolean) && (!bduy.a())) {}
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
      return ((ajtw)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c;
    }
    return 1;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new ajtw(0, 2131365006, anzj.a(2131701470)));
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new ajtw(6, 2131365003, anzj.a(2131701456)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ajtw(1, 2131365002, anzj.a(2131701427)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ajtw(2, 2131365007, anzj.a(2131701469)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ajtw(3, 2131365000, anzj.a(2131701453)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ajtw(4, 2131365004, anzj.a(2131701449)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ajtw(5, 2131365005, tyi.a()));
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[j];
    this.jdField_a_of_type_ArrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = ((ajtw)this.jdField_a_of_type_JavaUtilArrayList.get(i)).d;
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((ajtw)this.jdField_a_of_type_JavaUtilArrayList.get(i)).f;
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
    if ((paramBoolean) && (!bduy.a()))
    {
      paramBoolean = true;
      if (paramBoolean == this.jdField_a_of_type_Boolean) {
        break label200;
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (!paramBoolean) {
        break label146;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(0, new ajtw(0, 2131365006, anzj.a(2131701424)));
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
        ajtw localajtw = (ajtw)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localajtw.c == 5) {
          localajtw.f = tyi.a();
        }
        this.jdField_a_of_type_ArrayOfInt[i] = localajtw.d;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = localajtw.f;
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
      if (((ajtw)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajtk
 * JD-Core Version:    0.7.0.1
 */
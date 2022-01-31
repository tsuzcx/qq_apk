import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class afdf
{
  public ArrayList<afdh> a;
  private boolean a;
  public int[] a;
  public String[] a;
  
  public afdf(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = paramBoolean;
    a();
  }
  
  public int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return ((afdh)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c;
    }
    return 1;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new afdh(0, 2131299094, ajjy.a(2131636777)));
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new afdh(6, 2131299091, ajjy.a(2131636763)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new afdh(1, 2131299090, ajjy.a(2131636734)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new afdh(2, 2131299095, ajjy.a(2131636776)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new afdh(3, 2131299088, ajjy.a(2131636760)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new afdh(4, 2131299092, ajjy.a(2131636756)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new afdh(5, 2131299093, rsp.a()));
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[j];
    this.jdField_a_of_type_ArrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = ((afdh)this.jdField_a_of_type_JavaUtilArrayList.get(i)).d;
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((afdh)this.jdField_a_of_type_JavaUtilArrayList.get(i)).f;
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
    boolean bool = false;
    if (paramBoolean != this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (paramBoolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(0, new afdh(0, 2131299094, ajjy.a(2131636731)));
      }
      for (;;)
      {
        j = this.jdField_a_of_type_JavaUtilArrayList.size();
        this.jdField_a_of_type_ArrayOfJavaLangString = new String[j];
        this.jdField_a_of_type_ArrayOfInt = new int[j];
        i = 0;
        while (i < j)
        {
          localafdh = (afdh)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (localafdh.c == 5) {
            localafdh.f = rsp.a();
          }
          this.jdField_a_of_type_ArrayOfInt[i] = localafdh.d;
          this.jdField_a_of_type_ArrayOfJavaLangString[i] = localafdh.f;
          i += 1;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTabs", 2, "update showRecommend1:" + paramBoolean + " tabSize:" + j);
      }
      bool = true;
    }
    while (!QLog.isColorLevel())
    {
      int j;
      int i;
      afdh localafdh;
      return bool;
    }
    QLog.d("ContactsTabs", 2, "update showRecommend2:" + paramBoolean + " tabSize:" + this.jdField_a_of_type_JavaUtilArrayList.size());
    return false;
  }
  
  public int b(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((afdh)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afdf
 * JD-Core Version:    0.7.0.1
 */
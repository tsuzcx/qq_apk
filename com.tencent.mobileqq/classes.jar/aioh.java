import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aioh
{
  public ArrayList<aiot> a;
  private boolean a;
  public int[] a;
  public String[] a;
  private boolean b;
  
  public aioh(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if ((paramBoolean1) && (!bcoo.a())) {}
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
      return ((aiot)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c;
    }
    return 1;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.b) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new aiot(0, 2131365033, amtj.a(2131701705)));
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new aiot(6, 2131365030, amtj.a(2131701691)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new aiot(1, 2131365029, amtj.a(2131701662)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new aiot(2, 2131365034, amtj.a(2131701704)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new aiot(3, 2131365027, amtj.a(2131701688)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new aiot(4, 2131365031, amtj.a(2131701684)));
    if (!bcoo.a()) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new aiot(5, 2131365032, uex.a()));
    }
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[j];
    this.jdField_a_of_type_ArrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = ((aiot)this.jdField_a_of_type_JavaUtilArrayList.get(i)).d;
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((aiot)this.jdField_a_of_type_JavaUtilArrayList.get(i)).f;
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
    if ((paramBoolean1) && (!bcoo.a()))
    {
      paramBoolean1 = true;
      if (paramBoolean1 == this.b) {
        break label205;
      }
      this.b = paramBoolean1;
      if (!paramBoolean1) {
        break label150;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(0, new aiot(0, 2131365033, amtj.a(2131701659)));
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
        aiot localaiot = (aiot)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localaiot.c == 5) {
          localaiot.f = uex.a();
        }
        this.jdField_a_of_type_ArrayOfInt[i] = localaiot.d;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = localaiot.f;
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
      if (((aiot)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aioh
 * JD-Core Version:    0.7.0.1
 */
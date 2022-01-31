import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class afoy
{
  public ArrayList<afpd> a;
  private boolean a;
  public int[] a;
  public String[] a;
  
  public afoy(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = paramBoolean;
    a();
  }
  
  public int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return ((afpd)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c;
    }
    return 1;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new afpd(0, 2131364654, ajyc.a(2131702561)));
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new afpd(6, 2131364651, ajyc.a(2131702547)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new afpd(1, 2131364650, ajyc.a(2131702518)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new afpd(2, 2131364655, ajyc.a(2131702560)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new afpd(3, 2131364648, ajyc.a(2131702544)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new afpd(4, 2131364652, ajyc.a(2131702540)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new afpd(5, 2131364653, sfh.a()));
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[j];
    this.jdField_a_of_type_ArrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = ((afpd)this.jdField_a_of_type_JavaUtilArrayList.get(i)).d;
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((afpd)this.jdField_a_of_type_JavaUtilArrayList.get(i)).f;
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
        this.jdField_a_of_type_JavaUtilArrayList.add(0, new afpd(0, 2131364654, ajyc.a(2131702515)));
      }
      for (;;)
      {
        j = this.jdField_a_of_type_JavaUtilArrayList.size();
        this.jdField_a_of_type_ArrayOfJavaLangString = new String[j];
        this.jdField_a_of_type_ArrayOfInt = new int[j];
        i = 0;
        while (i < j)
        {
          localafpd = (afpd)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (localafpd.c == 5) {
            localafpd.f = sfh.a();
          }
          this.jdField_a_of_type_ArrayOfInt[i] = localafpd.d;
          this.jdField_a_of_type_ArrayOfJavaLangString[i] = localafpd.f;
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
      afpd localafpd;
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
      if (((afpd)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afoy
 * JD-Core Version:    0.7.0.1
 */
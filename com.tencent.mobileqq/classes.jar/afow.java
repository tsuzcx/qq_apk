import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class afow
{
  public ArrayList<afpb> a;
  private boolean a;
  public int[] a;
  public String[] a;
  
  public afow(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = paramBoolean;
    a();
  }
  
  public int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return ((afpb)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c;
    }
    return 1;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new afpb(0, 2131364653, ajya.a(2131702572)));
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new afpb(6, 2131364650, ajya.a(2131702558)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new afpb(1, 2131364649, ajya.a(2131702529)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new afpb(2, 2131364654, ajya.a(2131702571)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new afpb(3, 2131364647, ajya.a(2131702555)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new afpb(4, 2131364651, ajya.a(2131702551)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new afpb(5, 2131364652, sfe.a()));
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[j];
    this.jdField_a_of_type_ArrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = ((afpb)this.jdField_a_of_type_JavaUtilArrayList.get(i)).d;
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((afpb)this.jdField_a_of_type_JavaUtilArrayList.get(i)).f;
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
        this.jdField_a_of_type_JavaUtilArrayList.add(0, new afpb(0, 2131364653, ajya.a(2131702526)));
      }
      for (;;)
      {
        j = this.jdField_a_of_type_JavaUtilArrayList.size();
        this.jdField_a_of_type_ArrayOfJavaLangString = new String[j];
        this.jdField_a_of_type_ArrayOfInt = new int[j];
        i = 0;
        while (i < j)
        {
          localafpb = (afpb)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (localafpb.c == 5) {
            localafpb.f = sfe.a();
          }
          this.jdField_a_of_type_ArrayOfInt[i] = localafpb.d;
          this.jdField_a_of_type_ArrayOfJavaLangString[i] = localafpb.f;
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
      afpb localafpb;
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
      if (((afpb)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afow
 * JD-Core Version:    0.7.0.1
 */
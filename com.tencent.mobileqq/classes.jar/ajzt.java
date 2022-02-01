import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.List;

public class ajzt
{
  private ajzu jdField_a_of_type_Ajzu;
  private awdf jdField_a_of_type_Awdf;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<arpq> jdField_a_of_type_JavaUtilList;
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    anxl localanxl;
    do
    {
      return false;
      localanxl = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLebaHelper();
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    return localanxl.a();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Awdf != null) {
      return this.jdField_a_of_type_Awdf.a();
    }
    return -1;
  }
  
  public awdf a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return new awdk();
    }
    return new awdh();
  }
  
  public void a()
  {
    QLog.i("Q.lebatab.LebaController", 1, "onResume");
    if (this.jdField_a_of_type_Awdf != null)
    {
      a(true);
      this.jdField_a_of_type_Awdf.a();
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    QLog.i("Q.lebatab.LebaController", 1, "onPause" + paramInt1 + "|" + paramBoolean + paramInt2);
    if (this.jdField_a_of_type_Awdf != null) {
      this.jdField_a_of_type_Awdf.a(paramInt1, paramBoolean, paramInt2);
    }
  }
  
  public void a(ajzu paramajzu)
  {
    this.jdField_a_of_type_Ajzu = paramajzu;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramajzu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = paramajzu.jdField_a_of_type_JavaUtilList;
    QLog.i("Q.lebatab.LebaController", 1, "initLebaView" + arpq.a(this.jdField_a_of_type_JavaUtilList));
    if (this.jdField_a_of_type_Awdf == null)
    {
      boolean bool = a();
      this.jdField_a_of_type_Awdf = a(bool);
      QLog.i("Q.lebatab.LebaController", 1, String.format("init puginLogin modle = %b", new Object[] { Boolean.valueOf(bool) }));
    }
    for (;;)
    {
      this.jdField_a_of_type_Awdf.a(paramajzu);
      return;
      a(false);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Awdf != null) {
      this.jdField_a_of_type_Awdf.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Awdf != null)
    {
      boolean bool1 = a();
      boolean bool2 = this.jdField_a_of_type_Awdf instanceof awdk;
      if (bool1 != bool2)
      {
        QLog.i("Q.lebatab.LebaController", 1, String.format("checkAndSwtichModel old: %b new %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
        this.jdField_a_of_type_Awdf.d();
        this.jdField_a_of_type_Awdf = a(bool1);
        if (paramBoolean) {
          this.jdField_a_of_type_Awdf.a(this.jdField_a_of_type_Ajzu);
        }
      }
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Awdf != null) {
      return this.jdField_a_of_type_Awdf.b();
    }
    return 0;
  }
  
  public void b()
  {
    QLog.i("Q.lebatab.LebaController", 1, "notifyDataSetChanged" + arpq.a(this.jdField_a_of_type_JavaUtilList));
    if (this.jdField_a_of_type_Awdf != null) {
      this.jdField_a_of_type_Awdf.c();
    }
  }
  
  public void c()
  {
    QLog.i("Q.lebatab.LebaController", 1, "onPostThemeChanged");
    if (this.jdField_a_of_type_Awdf != null) {
      this.jdField_a_of_type_Awdf.b();
    }
  }
  
  public void d()
  {
    QLog.i("Q.lebatab.LebaController", 1, "refreshSearchBar");
    if (this.jdField_a_of_type_Awdf != null) {
      this.jdField_a_of_type_Awdf.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzt
 * JD-Core Version:    0.7.0.1
 */
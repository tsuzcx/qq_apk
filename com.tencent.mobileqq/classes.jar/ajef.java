import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.List;

public class ajef
{
  private ajeg jdField_a_of_type_Ajeg;
  private auxg jdField_a_of_type_Auxg;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<aqmf> jdField_a_of_type_JavaUtilList;
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    amux localamux;
    do
    {
      return false;
      localamux = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLebaHelper();
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    return localamux.a();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Auxg != null) {
      return this.jdField_a_of_type_Auxg.a();
    }
    return -1;
  }
  
  public auxg a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return new auxl();
    }
    return new auxi();
  }
  
  public void a()
  {
    QLog.i("Q.lebatab.LebaController", 1, "onResume");
    if (this.jdField_a_of_type_Auxg != null)
    {
      a(true);
      this.jdField_a_of_type_Auxg.a();
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    QLog.i("Q.lebatab.LebaController", 1, "onPause" + paramInt1 + "|" + paramBoolean + paramInt2);
    if (this.jdField_a_of_type_Auxg != null) {
      this.jdField_a_of_type_Auxg.a(paramInt1, paramBoolean, paramInt2);
    }
  }
  
  public void a(ajeg paramajeg)
  {
    this.jdField_a_of_type_Ajeg = paramajeg;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramajeg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = paramajeg.jdField_a_of_type_JavaUtilList;
    QLog.i("Q.lebatab.LebaController", 1, "initLebaView" + aqmf.a(this.jdField_a_of_type_JavaUtilList));
    if (this.jdField_a_of_type_Auxg == null)
    {
      boolean bool = a();
      this.jdField_a_of_type_Auxg = a(bool);
      QLog.i("Q.lebatab.LebaController", 1, String.format("init puginLogin modle = %b", new Object[] { Boolean.valueOf(bool) }));
    }
    for (;;)
    {
      this.jdField_a_of_type_Auxg.a(paramajeg);
      return;
      a(false);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Auxg != null) {
      this.jdField_a_of_type_Auxg.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Auxg != null)
    {
      boolean bool1 = a();
      boolean bool2 = this.jdField_a_of_type_Auxg instanceof auxl;
      if (bool1 != bool2)
      {
        QLog.i("Q.lebatab.LebaController", 1, String.format("checkAndSwtichModel old: %b new %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
        this.jdField_a_of_type_Auxg.d();
        this.jdField_a_of_type_Auxg = a(bool1);
        if (paramBoolean) {
          this.jdField_a_of_type_Auxg.a(this.jdField_a_of_type_Ajeg);
        }
      }
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Auxg != null) {
      return this.jdField_a_of_type_Auxg.b();
    }
    return 0;
  }
  
  public void b()
  {
    QLog.i("Q.lebatab.LebaController", 1, "notifyDataSetChanged" + aqmf.a(this.jdField_a_of_type_JavaUtilList));
    if (this.jdField_a_of_type_Auxg != null) {
      this.jdField_a_of_type_Auxg.c();
    }
  }
  
  public void c()
  {
    QLog.i("Q.lebatab.LebaController", 1, "onPostThemeChanged");
    if (this.jdField_a_of_type_Auxg != null) {
      this.jdField_a_of_type_Auxg.b();
    }
  }
  
  public void d()
  {
    QLog.i("Q.lebatab.LebaController", 1, "refreshSearchBar");
    if (this.jdField_a_of_type_Auxg != null) {
      this.jdField_a_of_type_Auxg.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajef
 * JD-Core Version:    0.7.0.1
 */
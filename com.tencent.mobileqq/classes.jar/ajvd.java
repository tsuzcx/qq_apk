import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.List;

public class ajvd
{
  private ajve jdField_a_of_type_Ajve;
  private avrl jdField_a_of_type_Avrl;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<arcs> jdField_a_of_type_JavaUtilList;
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    anov localanov;
    do
    {
      return false;
      localanov = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    return localanov.a();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Avrl != null) {
      return this.jdField_a_of_type_Avrl.a();
    }
    return -1;
  }
  
  public avrl a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return new avrq();
    }
    return new avrn();
  }
  
  public void a()
  {
    QLog.i("Q.lebatab.LebaController", 1, "onResume");
    if (this.jdField_a_of_type_Avrl != null)
    {
      a(true);
      this.jdField_a_of_type_Avrl.a();
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    QLog.i("Q.lebatab.LebaController", 1, "onPause" + paramInt1 + "|" + paramBoolean + paramInt2);
    if (this.jdField_a_of_type_Avrl != null) {
      this.jdField_a_of_type_Avrl.a(paramInt1, paramBoolean, paramInt2);
    }
  }
  
  public void a(ajve paramajve)
  {
    this.jdField_a_of_type_Ajve = paramajve;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramajve.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = paramajve.jdField_a_of_type_JavaUtilList;
    QLog.i("Q.lebatab.LebaController", 1, "initLebaView" + arcs.a(this.jdField_a_of_type_JavaUtilList));
    if (this.jdField_a_of_type_Avrl == null)
    {
      boolean bool = a();
      this.jdField_a_of_type_Avrl = a(bool);
      QLog.i("Q.lebatab.LebaController", 1, String.format("init puginLogin modle = %b", new Object[] { Boolean.valueOf(bool) }));
    }
    for (;;)
    {
      this.jdField_a_of_type_Avrl.a(paramajve);
      return;
      a(false);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Avrl != null) {
      this.jdField_a_of_type_Avrl.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Avrl != null)
    {
      boolean bool1 = a();
      boolean bool2 = this.jdField_a_of_type_Avrl instanceof avrq;
      if (bool1 != bool2)
      {
        QLog.i("Q.lebatab.LebaController", 1, String.format("checkAndSwtichModel old: %b new %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
        this.jdField_a_of_type_Avrl.d();
        this.jdField_a_of_type_Avrl = a(bool1);
        if (paramBoolean) {
          this.jdField_a_of_type_Avrl.a(this.jdField_a_of_type_Ajve);
        }
      }
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Avrl != null) {
      return this.jdField_a_of_type_Avrl.b();
    }
    return 0;
  }
  
  public void b()
  {
    QLog.i("Q.lebatab.LebaController", 1, "notifyDataSetChanged" + arcs.a(this.jdField_a_of_type_JavaUtilList));
    if (this.jdField_a_of_type_Avrl != null) {
      this.jdField_a_of_type_Avrl.c();
    }
  }
  
  public void c()
  {
    QLog.i("Q.lebatab.LebaController", 1, "onPostThemeChanged");
    if (this.jdField_a_of_type_Avrl != null) {
      this.jdField_a_of_type_Avrl.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvd
 * JD-Core Version:    0.7.0.1
 */
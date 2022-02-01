import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.List;

public class akgm
{
  private akgn jdField_a_of_type_Akgn;
  private awkc jdField_a_of_type_Awkc;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<arsh> jdField_a_of_type_JavaUtilList;
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    aoaw localaoaw;
    do
    {
      return false;
      localaoaw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    return localaoaw.a();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Awkc != null) {
      return this.jdField_a_of_type_Awkc.a();
    }
    return -1;
  }
  
  public awkc a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return new awkh();
    }
    return new awke();
  }
  
  public void a()
  {
    QLog.i("Q.lebatab.LebaController", 1, "onResume");
    if (this.jdField_a_of_type_Awkc != null)
    {
      a(true);
      this.jdField_a_of_type_Awkc.a();
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    QLog.i("Q.lebatab.LebaController", 1, "onPause" + paramInt1 + "|" + paramBoolean + paramInt2);
    if (this.jdField_a_of_type_Awkc != null) {
      this.jdField_a_of_type_Awkc.a(paramInt1, paramBoolean, paramInt2);
    }
  }
  
  public void a(akgn paramakgn)
  {
    this.jdField_a_of_type_Akgn = paramakgn;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramakgn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = paramakgn.jdField_a_of_type_JavaUtilList;
    QLog.i("Q.lebatab.LebaController", 1, "initLebaView" + arsh.a(this.jdField_a_of_type_JavaUtilList));
    if (this.jdField_a_of_type_Awkc == null)
    {
      boolean bool = a();
      this.jdField_a_of_type_Awkc = a(bool);
      QLog.i("Q.lebatab.LebaController", 1, String.format("init puginLogin modle = %b", new Object[] { Boolean.valueOf(bool) }));
    }
    for (;;)
    {
      this.jdField_a_of_type_Awkc.a(paramakgn);
      return;
      a(false);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Awkc != null) {
      this.jdField_a_of_type_Awkc.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Awkc != null)
    {
      boolean bool1 = a();
      boolean bool2 = this.jdField_a_of_type_Awkc instanceof awkh;
      if (bool1 != bool2)
      {
        QLog.i("Q.lebatab.LebaController", 1, String.format("checkAndSwtichModel old: %b new %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
        this.jdField_a_of_type_Awkc.d();
        this.jdField_a_of_type_Awkc = a(bool1);
        if (paramBoolean) {
          this.jdField_a_of_type_Awkc.a(this.jdField_a_of_type_Akgn);
        }
      }
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Awkc != null) {
      return this.jdField_a_of_type_Awkc.b();
    }
    return 0;
  }
  
  public void b()
  {
    QLog.i("Q.lebatab.LebaController", 1, "notifyDataSetChanged" + arsh.a(this.jdField_a_of_type_JavaUtilList));
    if (this.jdField_a_of_type_Awkc != null) {
      this.jdField_a_of_type_Awkc.c();
    }
  }
  
  public void c()
  {
    QLog.i("Q.lebatab.LebaController", 1, "onPostThemeChanged");
    if (this.jdField_a_of_type_Awkc != null) {
      this.jdField_a_of_type_Awkc.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akgm
 * JD-Core Version:    0.7.0.1
 */
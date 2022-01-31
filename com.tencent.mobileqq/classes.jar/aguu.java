import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.qphone.base.util.QLog;

public class aguu
  implements Runnable
{
  public aguu(PraiseManager paramPraiseManager, int paramInt, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PraiseManager", 1, "createPraiseInfo failed, id=" + this.jdField_a_of_type_Int, localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aguu
 * JD-Core Version:    0.7.0.1
 */
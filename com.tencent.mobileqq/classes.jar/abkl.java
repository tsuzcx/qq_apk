import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.VasFaceManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class abkl
  implements Runnable
{
  public abkl(VasFaceManager paramVasFaceManager, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (new File(this.jdField_a_of_type_JavaLangString).exists())
    {
      QLog.d("Q.qqhead.VasFaceManager", 1, "getFace from sd card: " + this.b);
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVasFaceManager.a(this.b, this.jdField_a_of_type_JavaLangString);
    }
    VasQuickUpdateManager localVasQuickUpdateManager;
    do
    {
      return;
      QLog.d("Q.qqhead.VasFaceManager", 1, "getFace need download: " + this.b);
      localVasQuickUpdateManager = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVasFaceManager.a.getManager(183);
    } while (localVasQuickUpdateManager == null);
    localVasQuickUpdateManager.a(23L, this.b, "Q.qqhead.VasFaceManager");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abkl
 * JD-Core Version:    0.7.0.1
 */
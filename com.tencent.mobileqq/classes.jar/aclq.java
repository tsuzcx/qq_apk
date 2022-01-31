import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.VasEmojiManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class aclq
  implements Runnable
{
  public aclq(VasEmojiManager paramVasEmojiManager, String paramString, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonVasEmojiManager.a();
    if ((!new File(VasEmojiManager.b(this.jdField_a_of_type_JavaLangString)).exists()) || (!((EmojiManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, true, false)))
    {
      localObject = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqEmoticonVasEmojiManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(183);
      if (localObject != null)
      {
        EmojiManager.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage);
        ((VasQuickUpdateManager)localObject).a(1004L, this.jdField_a_of_type_JavaLangString, "VasEmojiManager");
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonVasEmojiManager.a();
        ((EmojiManager)localObject).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
        ((EmojiManager)localObject).a((Bundle)this.jdField_a_of_type_ComTencentMobileqqEmoticonVasEmojiManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId), null, false, 0, "nomatch", 0L, 0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aclq
 * JD-Core Version:    0.7.0.1
 */
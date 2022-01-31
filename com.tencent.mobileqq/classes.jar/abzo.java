import android.os.Bundle;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import com.tencent.mobileqq.emosm.favroaming.EmoticonIPCModule;
import eipc.EIPCResult;

public class abzo
  implements Runnable
{
  public abzo(EmoticonIPCModule paramEmoticonIPCModule, Bundle paramBundle, String paramString, EmoticonFromGroupManager paramEmoticonFromGroupManager, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("pic_md5");
    if ("action_group_emo_big_pic_add_fav".equals(this.jdField_a_of_type_JavaLangString)) {
      if (!this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.b((String)localObject))
      {
        localObject = EIPCResult.createResult(-102, null);
        this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonIPCModule.callbackResult(this.jdField_a_of_type_Int, (EIPCResult)localObject);
      }
    }
    while (!"action_group_emo_big_pic_upload_wy".equals(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.a((String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abzo
 * JD-Core Version:    0.7.0.1
 */
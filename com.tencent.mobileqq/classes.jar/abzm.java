import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.model.EmoticonManager;
import java.io.Serializable;
import java.util.List;

public final class abzm
  implements Runnable
{
  public abzm(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, H5MagicPlayerActivity.class);
      localIntent.putExtra("clickTime", System.currentTimeMillis());
      localIntent.putExtra("autoPlay", "1");
      localIntent.putExtra("senderUin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localIntent.putExtra("selfUin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localIntent.putExtra("sessionInfo", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      localIntent.putExtra("emoticon", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      Object localObject = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      EmoticonPackage localEmoticonPackage = ((EmoticonManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      if (localEmoticonPackage != null)
      {
        localObject = ((EmoticonManager)localObject).a(localEmoticonPackage.childEpId);
        if ((localObject != null) && (((List)localObject).size() > 0)) {
          localIntent.putExtra("childEmoticon", (Serializable)((List)localObject).get(0));
        }
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abzm
 * JD-Core Version:    0.7.0.1
 */
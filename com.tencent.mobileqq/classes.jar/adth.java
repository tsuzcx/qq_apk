import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardQFavBatchOption;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.AioShortVideoOperator;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qqfav.QfavReport;

public class adth
  implements Runnable
{
  public adth(ForwardQFavBatchOption paramForwardQFavBatchOption, Bundle paramBundle, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, Intent paramIntent) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("qfavType");
    Object localObject2;
    String str1;
    String str2;
    String str3;
    switch (i)
    {
    case 3: 
    case 4: 
    default: 
      return;
    case 6: 
    case 8: 
      this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_icon", BaseApplicationImpl.getContext().getString(2131431642));
      this.jdField_a_of_type_AndroidOsBundle.putString("app_name", BaseApplicationImpl.getContext().getString(2131431628));
      this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_action", "plugin");
      this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_action_data", "qqfav://operation/2");
      localObject1 = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqForwardForwardQFavBatchOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str1 = this.jdField_a_of_type_JavaLangString;
      str2 = this.jdField_b_of_type_JavaLangString;
      str3 = this.c;
      int j = this.jdField_a_of_type_Int;
      int k = MobileQQService.jdField_a_of_type_Int;
      MobileQQService.jdField_a_of_type_Int = k + 1;
      localObject1 = MessageRecordFactory.a((QQAppInterface)localObject2, str1, str2, str3, j, k, (AbsStructMsg)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardQFavBatchOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject1, null);
      if (i == 8)
      {
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardQFavBatchOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 8, 0, this.jdField_b_of_type_Int);
        return;
      }
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardQFavBatchOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 2, 0, this.jdField_b_of_type_Int);
      return;
    case 1: 
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("text");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject1 = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardQFavBatchOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.jdField_a_of_type_Int, (byte)1, (byte)0, (short)0, (String)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardQFavBatchOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardQFavBatchOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject1, null);
      }
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardQFavBatchOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 1, 0, this.jdField_b_of_type_Int);
      return;
    case 2: 
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ThreadManager.post(new adti(this, (String)localObject1), 8, null, false);
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardQFavBatchOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 3, 0, this.jdField_b_of_type_Int);
      return;
    case 7: 
      localObject1 = new SessionInfo();
      ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      ((SessionInfo)localObject1).d = this.d;
      ((SessionInfo)localObject1).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      ((SessionInfo)localObject1).jdField_b_of_type_JavaLangString = this.c;
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("lat");
      str1 = this.jdField_a_of_type_AndroidOsBundle.getString("lon");
      str2 = this.jdField_a_of_type_AndroidOsBundle.getString("title");
      str3 = this.jdField_a_of_type_AndroidOsBundle.getString("address");
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardQFavBatchOption.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqForwardForwardQFavBatchOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (SessionInfo)localObject1, (String)localObject2, str1, str3, str2, str3, null, "", "", "", null);
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardQFavBatchOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 7, 0, this.jdField_b_of_type_Int);
      return;
    }
    Object localObject1 = ShortVideoBusiManager.a(0, 2);
    this.jdField_a_of_type_AndroidContentIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    localObject1 = ShortVideoBusiManager.a(this.jdField_a_of_type_AndroidContentIntent, (ShortVideoReq)localObject1);
    ((ShortVideoUploadInfo)localObject1).c = this.jdField_a_of_type_ComTencentMobileqqForwardForwardQFavBatchOption.jdField_a_of_type_AndroidOsBundle.getString("uin");
    ((ShortVideoUploadInfo)localObject1).d = this.jdField_a_of_type_ComTencentMobileqqForwardForwardQFavBatchOption.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    ((ShortVideoUploadInfo)localObject1).jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqForwardForwardQFavBatchOption.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    ((ShortVideoUploadInfo)localObject1).jdField_a_of_type_Int = 2;
    new AioShortVideoOperator(this.jdField_a_of_type_ComTencentMobileqqForwardForwardQFavBatchOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((ShortVideoUploadInfo)localObject1);
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardQFavBatchOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 5, 0, this.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adth
 * JD-Core Version:    0.7.0.1
 */
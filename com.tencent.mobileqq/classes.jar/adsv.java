import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager;
import com.tencent.mobileqq.statistics.ReportController;

public class adsv
  implements Runnable
{
  public adsv(ImaxAdRecentUserManager paramImaxAdRecentUserManager, QQAppInterface paramQQAppInterface, String paramString, int paramInt, AdvertisementItem paramAdvertisementItem) {}
  
  public void run()
  {
    QQMessageFacade.Message localMessage = null;
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localQQMessageFacade != null) {
      localMessage = localQQMessageFacade.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    if (localMessage != null)
    {
      if ("false".equals(localMessage.getExtInfoFromExtStr("recent_list_advertisement_message_first_click")))
      {
        localMessage.saveExtInfoToExtStr("recent_list_advertisement_message_first_click", "true");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessage.frienduin, localMessage.msgtype, localMessage.uniseq, "extStr", localMessage.extStr);
        if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a != null) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.jdField_a_of_type_JavaLangString, "0X8008F5E", "0X8008F5E", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.c, "", PublicAccountAdUtil.a(), "");
        }
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a != null) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.jdField_a_of_type_JavaLangString, "0X8008F60", "0X8008F60", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.c, "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adsv
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.qphone.base.util.QLog;

class aedn
  implements URLDrawable.DownloadListener
{
  aedn(aedl paramaedl, URLDrawable paramURLDrawable, MessageForTroopGift paramMessageForTroopGift, aeds paramaeds) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isFromNearby)
    {
      akbk.a("gift_aio", "fail_obj", this.jdField_a_of_type_Aedl.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
      return;
    }
    if (mye.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift)) {}
    for (paramInt = 2;; paramInt = 1)
    {
      axqw.b(this.jdField_a_of_type_Aedl.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "objicon_fail", paramInt, 0, this.jdField_a_of_type_Aedl.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "0", "" + mud.a(this.jdField_a_of_type_Aedl.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aedl.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Aedl.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a));
      return;
    }
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    int i;
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof RegionDrawable))
    {
      i = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.objColor;
      if (i != 0) {
        break label136;
      }
      i = -2138570752;
    }
    label136:
    for (;;)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.interactId)) {
        this.jdField_a_of_type_Aedl.a(((RegionDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).getBitmap(), i, this.jdField_a_of_type_Aeds.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.giftPicId + "");
      }
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("TroopGiftMsgItemBuilder", 2, "drawable.getCurrDrawable() instanceof  RegionDrawable = " + (this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof RegionDrawable));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aedn
 * JD-Core Version:    0.7.0.1
 */
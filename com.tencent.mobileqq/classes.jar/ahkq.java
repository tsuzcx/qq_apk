import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager.BannerInfoHandler;
import com.tencent.mobileqq.redtouch.VipBannerInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import mqq.os.MqqHandler;

class ahkq
  implements RedTouchManager.BannerInfoHandler
{
  ahkq(ahkp paramahkp) {}
  
  public boolean a(VipBannerInfo paramVipBannerInfo)
  {
    if (paramVipBannerInfo == null) {}
    label385:
    label390:
    label396:
    label400:
    for (;;)
    {
      return false;
      int i;
      label86:
      int j;
      label163:
      label187:
      int k;
      if (1 == paramVipBannerInfo.jdField_b_of_type_Int)
      {
        this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("blue_banner_time_out" + this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getAccount(), System.currentTimeMillis() + paramVipBannerInfo.jdField_a_of_type_Long).commit();
        paramVipBannerInfo.jdField_b_of_type_Long = paramVipBannerInfo.jdField_a_of_type_Long;
        i = 1;
        if (paramVipBannerInfo.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo == null) {
          break label378;
        }
        m = paramVipBannerInfo.jdField_a_of_type_Int;
        if ((1 != paramVipBannerInfo.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get()) || (i == 0) || (TextUtils.isEmpty(paramVipBannerInfo.jdField_b_of_type_JavaLangString)) || (m < 1) || (m > 4)) {
          continue;
        }
        if ((1 != m) || (VipUtils.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a))) {
          break label380;
        }
        i = 1;
        if ((2 != m) || (VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a))) {
          break label385;
        }
        j = 1;
        if ((3 != m) || (!VipUtils.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a))) {
          break label390;
        }
        k = 1;
        label212:
        if ((4 != m) || (!VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a))) {
          break label396;
        }
      }
      for (int m = 1;; m = 0)
      {
        if ((i == 0) && (j == 0) && (k == 0) && (m == 0)) {
          break label400;
        }
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(9);
        Message localMessage = this.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(8, paramVipBannerInfo);
        localMessage.obj = paramVipBannerInfo;
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
        return true;
        long l = this.a.jdField_a_of_type_AndroidContentSharedPreferences.getLong("blue_banner_time_out" + this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getAccount(), -1L);
        if (l > System.currentTimeMillis())
        {
          paramVipBannerInfo.jdField_b_of_type_Long = (l - System.currentTimeMillis());
          i = 1;
          break label86;
        }
        i = 0;
        break label86;
        label378:
        break;
        label380:
        i = 0;
        break label163;
        j = 0;
        break label187;
        k = 0;
        break label212;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahkq
 * JD-Core Version:    0.7.0.1
 */
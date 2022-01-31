import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class aivl
  implements DialogInterface.OnClickListener
{
  public aivl(HotChatCenterFragment paramHotChatCenterFragment, HotChatInfo paramHotChatInfo, String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isWifiHotChat)
    {
      paramInt = 1;
      axqw.b(HotChatCenterFragment.a(this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment), "CliOper", "", "", "0X8004D2C", "0X8004D2C", paramInt, 0, "", "", "", "");
      if ((!this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment.isAdded()) || (bbev.d(this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment.getActivity().getApplicationContext()))) {
        break label98;
      }
      bcpw.a(this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment.getActivity().getApplicationContext(), ajyc.a(2131705541), 0).b(0);
    }
    label98:
    do
    {
      return;
      paramInt = 2;
      break;
      ((ajyi)HotChatCenterFragment.a(this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment).a(35)).a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL);
      if (HotChatCenterFragment.a(this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment).get() != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HotchatActivity", 2, "remove");
        }
        ((ajyf)HotChatCenterFragment.a(this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment).get()).b(this.jdField_a_of_type_JavaLangString);
      }
    } while (HotChatCenterFragment.a(this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment) == null);
    ((aivm)HotChatCenterFragment.a(this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment)).b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aivl
 * JD-Core Version:    0.7.0.1
 */
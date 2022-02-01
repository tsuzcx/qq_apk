import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.syncadapter.SyncService;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.PatternLockUtils;

public class aeye
  implements View.OnClickListener
{
  public aeye(MainFragment paramMainFragment, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    QLog.flushLog();
    boolean bool = ((CheckBox)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131364495)).isChecked();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.d = bool;
    SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.getActivity(), MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.getString(2131717380), "qqsetting_receivemsg_whenexit_key", bool);
    SyncService.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.d);
    int i = MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment).a().b();
    int j = MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment).a().a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.getActivity().getSharedPreferences("unreadcount", 4).edit();
    ((SharedPreferences.Editor)localObject).putInt("unread", i + j);
    ((SharedPreferences.Editor)localObject).commit();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.g();
    MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment).a = this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.d;
    MainFragment.c = true;
    if (QQPlayerService.a())
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("qqplayer_exit_action");
      this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.getActivity().sendBroadcast((Intent)localObject);
    }
    PatternLockUtils.setFirstEnterAfterLoginState(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.getActivity(), MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment).getCurrentAccountUin(), true);
    this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.getActivity().finish();
    bdll.b(MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment), "CliOper", "", "", "Quit", "Setting_Quit", 0, 0, "0", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeye
 * JD-Core Version:    0.7.0.1
 */
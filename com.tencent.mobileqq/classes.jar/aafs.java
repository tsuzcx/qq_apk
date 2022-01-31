import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.contactsync.syncadapter.SyncService;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.PatternLockUtils;

public class aafs
  implements View.OnClickListener
{
  public aafs(AccountManageActivity paramAccountManageActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    QLog.flushLog();
    boolean bool = ((CheckBox)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131364181)).isChecked();
    this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.d = bool;
    SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.getString(2131718625), "qqsetting_receivemsg_whenexit_key", bool);
    SyncService.a(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.d);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app.a().b();
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app.a().a();
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.getActivity().getSharedPreferences("unreadcount", 4).edit();
    paramView.putInt("unread", i + j);
    paramView.commit();
    this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.i();
    this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app.a = this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.d;
    com.tencent.mobileqq.activity.MainFragment.c = true;
    if (QQPlayerService.a())
    {
      paramView = new Intent();
      paramView.setAction("qqplayer_exit_action");
      this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.getActivity().sendBroadcast(paramView);
    }
    PatternLockUtils.setFirstEnterAfterLoginState(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app.getCurrentAccountUin(), true);
    paramView = new Intent("QQ_ACTION_MENU_QUIT");
    paramView.setClass(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.getActivity(), SplashActivity.class);
    paramView.addFlags(67108864);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.startActivity(paramView);
      label265:
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app, "CliOper", "", "", "0X800932A", "0X800932A", 0, 0, "0", "", "", "");
      return;
    }
    catch (Exception paramView)
    {
      break label265;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aafs
 * JD-Core Version:    0.7.0.1
 */
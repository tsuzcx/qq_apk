import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.syncadapter.SyncService;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.PatternLockUtils;

public class ajzf
  implements View.OnClickListener
{
  public ajzf(MainFragment paramMainFragment, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    QLog.flushLog();
    boolean bool = ((CheckBox)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131364596)).isChecked();
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment.d = bool;
    SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment.getActivity(), MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment.getString(2131717979), "qqsetting_receivemsg_whenexit_key", bool);
    SyncService.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment.d);
    int i = MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment).getMessageFacade().getUnreadMsgsNum();
    int j = MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment).getCallFacade().a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment.getActivity().getSharedPreferences("unreadcount", 4).edit();
    ((SharedPreferences.Editor)localObject).putInt("unread", i + j);
    ((SharedPreferences.Editor)localObject).commit();
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment.h();
    MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment).bReceiveMsgOnExit = this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment.d;
    MainFragment.c = true;
    if (QQPlayerService.a())
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("qqplayer_exit_action");
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment.getActivity().sendBroadcast((Intent)localObject);
    }
    PatternLockUtils.setFirstEnterAfterLoginState(this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment.getActivity(), MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment).getCurrentAccountUin(), true);
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment.getActivity().finish();
    bdla.b(MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment), "CliOper", "", "", "Quit", "Setting_Quit", 0, 0, "0", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzf
 * JD-Core Version:    0.7.0.1
 */
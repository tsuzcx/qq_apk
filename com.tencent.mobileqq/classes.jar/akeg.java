import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.trooponline.TroopOnlineMemberListAdapter;
import com.tencent.mobileqq.trooponline.TroopOnlineMemberListAdapter.ViewHolder;

public class akeg
  implements TroopManager.ITroopMemberInfoCallBack
{
  public TroopOnlineMemberListAdapter.ViewHolder a;
  
  private akeg(TroopOnlineMemberListAdapter paramTroopOnlineMemberListAdapter) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberListAdapter$ViewHolder != null) && (paramTroopMemberInfo != null) && (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberListAdapter$ViewHolder.jdField_a_of_type_JavaLangString, paramTroopMemberInfo.memberuin)))
    {
      paramTroopMemberInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberListAdapter.a.getManager(51)).a(paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin);
      this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberListAdapter$ViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopMemberInfo);
      if (AppSetting.b) {
        TroopOnlineMemberListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberListAdapter, this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberListAdapter$ViewHolder);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akeg
 * JD-Core Version:    0.7.0.1
 */
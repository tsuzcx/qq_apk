import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class acmb
  extends BaseAdapter
{
  private aloz jdField_a_of_type_Aloz;
  private boolean jdField_a_of_type_Boolean = true;
  
  public acmb(ChatSettingForTroop paramChatSettingForTroop)
  {
    this.jdField_a_of_type_Aloz = ((aloz)paramChatSettingForTroop.app.getManager(51));
    a();
  }
  
  private void a()
  {
    if ((TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {}
    for (boolean bool = true; ((!this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mMemberInvitingFlag) && (!this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())) || ((!this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 3) && (!bool)); bool = false)
    {
      this.jdField_a_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "隐藏邀请按钮：mMemberInvitingFlag=" + this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mMemberInvitingFlag + ", mTroopInfoData.isOwnerOrAdim() = " + this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim() + ", mTroopInfoData.cGroupOption=" + this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption + ", isPayToJoinTroop=" + bool);
      }
      return;
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_JavaUtilList.size())
    {
      int j = i;
      if (this.jdField_a_of_type_Boolean)
      {
        j = i;
        if (i != 0) {
          j = i + 1;
        }
      }
      return Math.min(5, j);
    }
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_JavaUtilList.size())) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    acqa localacqa;
    TextView localTextView;
    ImageView localImageView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.getLayoutInflater().inflate(2131558797, null);
      localacqa = new acqa();
      localacqa.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367808));
      localacqa.jdField_a_of_type_AndroidWidgetTextView = ((ColorNickTextView)localView.findViewById(2131370958));
      localView.setTag(localacqa);
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app)) {
        localacqa.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(1996488704);
      }
      localView.setVisibility(0);
      localView.setFocusable(false);
      localTextView = localacqa.jdField_a_of_type_AndroidWidgetTextView;
      localImageView = localacqa.jdField_a_of_type_AndroidWidgetImageView;
      if ((!this.jdField_a_of_type_Boolean) || (paramInt != getCount() - 1)) {
        break label248;
      }
      localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.getString(2131693776));
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.getResources().getColor(2131166989));
      localImageView.setBackgroundDrawable(null);
      localImageView.setImageResource(2130839009);
      localImageView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_AndroidViewView$OnTouchListener);
      localImageView.setEnabled(true);
      localImageView.setTag(Integer.valueOf(2));
      localacqa.jdField_a_of_type_JavaLangString = "";
    }
    label248:
    String str;
    for (;;)
    {
      if (AppSetting.c) {
        ViewCompat.setImportantForAccessibility(localImageView, 2);
      }
      localImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop);
      return localView;
      localacqa = (acqa)paramView.getTag();
      localView = paramView;
      break;
      if (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_JavaUtilList.size())
      {
        localImageView.setImageResource(2130844483);
        localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.getResources().getColor(2131166904));
        str = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_JavaUtilList.get(paramInt) + "";
        localacqa.jdField_a_of_type_JavaLangString = str;
        if (!TextUtils.isEmpty(str)) {
          break label354;
        }
        localTextView.setText("");
        localImageView.setImageDrawable(bdda.b());
      }
    }
    label354:
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, str)) {}
    for (paramViewGroup = bdbt.c(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, str, true);; paramViewGroup = str)
    {
      if (!TextUtils.isEmpty(paramViewGroup))
      {
        paramView = paramViewGroup;
        if (TextUtils.isEmpty(paramViewGroup)) {
          paramView = str;
        }
        paramViewGroup = paramView;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_Boolean)
        {
          paramViewGroup = paramView;
          if (TextUtils.isDigitsOnly(paramView)) {
            paramViewGroup = alpo.a(2131702131);
          }
        }
        paramView = new bahs(paramViewGroup, 12).a();
        localTextView.setText(paramView);
        bdnm.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app, localTextView, paramView);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a(localacqa, null, true);
      localImageView.setTag(2131377384, str);
      localImageView.setTag(Integer.valueOf(3));
      break;
      bdbt.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, str, new acmc(this, localacqa, str, localTextView));
    }
  }
  
  public void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acmb
 * JD-Core Version:    0.7.0.1
 */
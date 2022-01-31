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

public class aalp
  extends BaseAdapter
{
  private ajjj jdField_a_of_type_Ajjj;
  private boolean jdField_a_of_type_Boolean = true;
  
  public aalp(ChatSettingForTroop paramChatSettingForTroop)
  {
    this.jdField_a_of_type_Ajjj = ((ajjj)paramChatSettingForTroop.app.getManager(51));
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
    aapn localaapn;
    TextView localTextView;
    ImageView localImageView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.getLayoutInflater().inflate(2131493205, null);
      localaapn = new aapn();
      localaapn.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131302061));
      localaapn.jdField_a_of_type_AndroidWidgetTextView = ((ColorNickTextView)localView.findViewById(2131304981));
      localView.setTag(localaapn);
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app)) {
        localaapn.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(1996488704);
      }
      localView.setVisibility(0);
      localView.setFocusable(false);
      localTextView = localaapn.jdField_a_of_type_AndroidWidgetTextView;
      localImageView = localaapn.jdField_a_of_type_AndroidWidgetImageView;
      if ((!this.jdField_a_of_type_Boolean) || (paramInt != getCount() - 1)) {
        break label248;
      }
      localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.getString(2131628030));
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.getResources().getColor(2131101346));
      localImageView.setBackgroundDrawable(null);
      localImageView.setImageResource(2130838910);
      localImageView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_AndroidViewView$OnTouchListener);
      localImageView.setEnabled(true);
      localImageView.setTag(Integer.valueOf(2));
      localaapn.jdField_a_of_type_JavaLangString = "";
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
      localaapn = (aapn)paramView.getTag();
      localView = paramView;
      break;
      if (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_JavaUtilList.size())
      {
        localImageView.setImageResource(2130844059);
        localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.getResources().getColor(2131101263));
        str = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_JavaUtilList.get(paramInt) + "";
        localaapn.jdField_a_of_type_JavaLangString = str;
        if (!TextUtils.isEmpty(str)) {
          break label354;
        }
        localTextView.setText("");
        localImageView.setImageDrawable(bacm.b());
      }
    }
    label354:
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, str)) {}
    for (paramViewGroup = babh.c(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, str, true);; paramViewGroup = str)
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
            paramViewGroup = ajjy.a(2131635964);
          }
        }
        paramView = new axjq(paramViewGroup, 12).a();
        localTextView.setText(paramView);
        bami.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app, localTextView, paramView);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a(localaapn, null, true);
      localImageView.setTag(2131311059, str);
      localImageView.setTag(Integer.valueOf(3));
      break;
      babh.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, str, new aalq(this, localaapn, str, localTextView));
    }
  }
  
  public void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aalp
 * JD-Core Version:    0.7.0.1
 */
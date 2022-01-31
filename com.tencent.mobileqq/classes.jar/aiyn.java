import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment.ViewHolder;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.ArrayList;

public class aiyn
  extends BaseAdapter
  implements View.OnClickListener
{
  public ArrayList a;
  public boolean a;
  
  public aiyn(BulkSendMessageFragment paramBulkSendMessageFragment)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public int getCount()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size());
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    TextView localTextView;
    ImageView localImageView;
    Object localObject2;
    String str;
    Object localObject1;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.getActivity()).inflate(2130968771, null);
      paramViewGroup = new BulkSendMessageFragment.ViewHolder(localView);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362701));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362736));
      localView.setTag(paramViewGroup);
      localView.setVisibility(0);
      localView.setFocusable(false);
      localTextView = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
      localImageView = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
      localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label392;
      }
      localImageView.setImageResource(2130842323);
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.getResources().getColor(2131494270));
      str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt) + "";
      paramViewGroup.jdField_a_of_type_JavaLangString = str;
      localObject1 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_JavaLangString, str);
      if (!TextUtils.isEmpty(str)) {
        break label283;
      }
      if (localObject1 != null) {
        break label277;
      }
      paramView = "";
      label216:
      localTextView.setText(paramView);
      localImageView.setImageDrawable(ImageUtil.b());
      label230:
      paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(2131372898, null);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
    }
    for (;;)
    {
      if (AppSetting.b) {
        ViewCompat.setImportantForAccessibility(localImageView, 2);
      }
      return localView;
      paramViewGroup = (BulkSendMessageFragment.ViewHolder)paramView.getTag();
      localView = paramView;
      break;
      label277:
      paramView = (View)localObject1;
      break label216;
      label283:
      paramView = (View)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramView = (View)localObject1;
        if (localObject2 != null)
        {
          localObject2 = ((FriendsManager)localObject2).c(str);
          paramView = (View)localObject1;
          if (localObject2 != null)
          {
            paramView = (View)localObject1;
            if (((Friends)localObject2).isFriend()) {
              paramView = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
            }
          }
        }
      }
      localObject1 = paramView;
      if (TextUtils.isEmpty(paramView)) {
        localObject1 = "群聊成员";
      }
      localTextView.setText((CharSequence)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.a(paramViewGroup, null, true);
      localImageView.setTag(2131362362, str);
      localImageView.setTag(null);
      break label230;
      label392:
      localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.getString(2131435209));
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.getResources().getColorStateList(2131494153));
      localImageView.setBackgroundDrawable(null);
      localImageView.setImageResource(2130838416);
      localImageView.setEnabled(true);
      localImageView.setTag(Integer.valueOf(0));
      paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(2131372898, Integer.valueOf(0));
      paramViewGroup.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    paramView = (Integer)paramView.getTag(2131372898);
    if (paramView == null) {}
    while (paramView.intValue() != 0) {
      return;
    }
    paramView = TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_JavaLangString, 20);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    paramView.putStringArrayListExtra("param_pick_selected_list", this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_Aiyn.jdField_a_of_type_JavaUtilArrayList);
    paramView.putStringArrayListExtra("param_hide_filter_member_list", localArrayList);
    paramView.putExtra("param_pick_max_num", this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_Int);
    paramView.putExtra("param_pick_max_num_exceeds_wording", 2131430837);
    paramView.putExtra("param_pick_title_string", "添加接收人");
    this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.startActivityForResult(paramView, 1);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.getActivity().overridePendingTransition(2131034380, 2131034131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiyn
 * JD-Core Version:    0.7.0.1
 */
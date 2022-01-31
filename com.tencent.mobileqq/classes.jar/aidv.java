import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.RecentMemberInnerFrame;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import java.util.ArrayList;
import java.util.List;

public class aidv
  extends aims
{
  public aidv(RecentMemberInnerFrame paramRecentMemberInnerFrame)
  {
    super(paramRecentMemberInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, paramRecentMemberInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, RecentMemberInnerFrame.a(paramRecentMemberInnerFrame), 1, true);
  }
  
  public int getCount()
  {
    if (RecentMemberInnerFrame.a(this.a) == null) {
      return 0;
    }
    return RecentMemberInnerFrame.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < RecentMemberInnerFrame.a(this.a).size())) {
      return RecentMemberInnerFrame.a(this.a).get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = (aidw)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    RecentUser localRecentUser;
    for (;;)
    {
      localRecentUser = (RecentUser)getItem(paramInt);
      if (localRecentUser != null) {
        break;
      }
      return paramViewGroup;
      paramView = new aidw(this.a, null);
      paramViewGroup = this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2131562407, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131364192));
      paramView.c = ((ImageView)paramViewGroup.findViewById(2131367679));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370647));
      paramViewGroup.setTag(paramView);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b(localRecentUser.uin))
    {
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      paramView.c.setImageBitmap(a(1, localRecentUser.uin));
      localObject = RecentMemberInnerFrame.a(this.a).b(localRecentUser.uin);
      if (localObject != null) {
        break label323;
      }
      localObject = "";
      label189:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramView.jdField_a_of_type_JavaLangString = localRecentUser.uin;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b.contains(localRecentUser.uin))) {
        break label333;
      }
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
      label249:
      if (AppSetting.d)
      {
        if ((!paramView.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) || (!paramView.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())) {
          break label344;
        }
        paramViewGroup.setContentDescription((String)localObject + ajya.a(2131713209));
      }
    }
    for (;;)
    {
      paramViewGroup.setOnClickListener(this.a);
      return paramViewGroup;
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break;
      label323:
      localObject = bbcz.a((Friends)localObject);
      break label189;
      label333:
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
      break label249;
      label344:
      paramViewGroup.setContentDescription((String)localObject + ajya.a(2131713206));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aidv
 * JD-Core Version:    0.7.0.1
 */
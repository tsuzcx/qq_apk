import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberFromFriendGroup;
import com.tencent.mobileqq.data.Groups;
import java.util.ArrayList;
import java.util.List;

public class akbb
  extends BaseAdapter
{
  public akbb(SelectMemberFromFriendGroup paramSelectMemberFromFriendGroup) {}
  
  public int getCount()
  {
    return SelectMemberFromFriendGroup.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return SelectMemberFromFriendGroup.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity).inflate(2131560251, null);
      paramViewGroup = new akbd(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131364256));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367316));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131367317));
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(new akbc(this));
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataGroups = ((Groups)getItem(paramInt));
      int i = paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataGroups.group_friend_count;
      paramViewGroup.b.setText("" + i);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataGroups.group_name);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setTag(paramViewGroup);
      if (!this.a.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataGroups)) {
        break label224;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    }
    for (;;)
    {
      if (SelectMemberFromFriendGroup.a(this.a).size() != 1) {
        break label258;
      }
      paramView.setBackgroundResource(2130839261);
      return paramView;
      paramViewGroup = (akbd)paramView.getTag();
      break;
      label224:
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.a.jdField_a_of_type_JavaUtilList.contains(paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataGroups));
    }
    label258:
    if (SelectMemberFromFriendGroup.a(this.a).size() == 2)
    {
      if (paramInt == 0)
      {
        paramView.setBackgroundResource(2130839270);
        return paramView;
      }
      paramView.setBackgroundResource(2130839261);
      return paramView;
    }
    if (paramInt == 0)
    {
      paramView.setBackgroundResource(2130839270);
      return paramView;
    }
    if (paramInt == SelectMemberFromFriendGroup.a(this.a).size() - 1)
    {
      paramView.setBackgroundResource(2130839261);
      return paramView;
    }
    paramView.setBackgroundResource(2130839264);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akbb
 * JD-Core Version:    0.7.0.1
 */
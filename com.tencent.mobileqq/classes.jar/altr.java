import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberFromFriendGroup;
import com.tencent.mobileqq.data.Groups;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class altr
  extends BaseAdapter
{
  public altr(SelectMemberFromFriendGroup paramSelectMemberFromFriendGroup) {}
  
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
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity).inflate(2131560405, null);
      paramView = new altt(this);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131364466));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367622));
      paramView.b = ((TextView)localView.findViewById(2131367623));
      localView.setTag(paramView);
      localView.setOnClickListener(new alts(this));
      paramView.jdField_a_of_type_Int = paramInt;
      paramView.jdField_a_of_type_ComTencentMobileqqDataGroups = ((Groups)getItem(paramInt));
      int i = paramView.jdField_a_of_type_ComTencentMobileqqDataGroups.group_friend_count;
      paramView.b.setText("" + i);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramView.jdField_a_of_type_ComTencentMobileqqDataGroups.group_name);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setTag(paramView);
      if (!this.a.a(paramView.jdField_a_of_type_ComTencentMobileqqDataGroups)) {
        break label254;
      }
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      label197:
      if (SelectMemberFromFriendGroup.a(this.a).size() != 1) {
        break label288;
      }
      localView.setBackgroundResource(2130839439);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      altt localaltt = (altt)paramView.getTag();
      localView = paramView;
      paramView = localaltt;
      break;
      label254:
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.a.jdField_a_of_type_JavaUtilList.contains(paramView.jdField_a_of_type_ComTencentMobileqqDataGroups));
      break label197;
      label288:
      if (SelectMemberFromFriendGroup.a(this.a).size() == 2)
      {
        if (paramInt == 0) {
          localView.setBackgroundResource(2130839448);
        } else {
          localView.setBackgroundResource(2130839439);
        }
      }
      else if (paramInt == 0) {
        localView.setBackgroundResource(2130839448);
      } else if (paramInt == SelectMemberFromFriendGroup.a(this.a).size() - 1) {
        localView.setBackgroundResource(2130839439);
      } else {
        localView.setBackgroundResource(2130839442);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     altr
 * JD-Core Version:    0.7.0.1
 */
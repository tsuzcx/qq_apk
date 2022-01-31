import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.ProfileLabelTypeInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class adop
  extends BaseAdapter
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new adoq(this);
  List<ProfileLabelInfo> jdField_a_of_type_JavaUtilList;
  
  public adop(List<ProfileLabelInfo> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  private void a(ProfileLabelInfo paramProfileLabelInfo)
  {
    Object localObject = null;
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity.jdField_a_of_type_Awvn.a().keySet().iterator();
    if (localIterator.hasNext())
    {
      ProfileLabelInfo localProfileLabelInfo = (ProfileLabelInfo)localIterator.next();
      if (!localProfileLabelInfo.labelId.equals(paramProfileLabelInfo.labelId)) {
        break label114;
      }
      localObject = localProfileLabelInfo;
    }
    label114:
    for (;;)
    {
      break;
      if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity.jdField_a_of_type_Awvn.a(localObject)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity.jdField_a_of_type_Awvn.c(localObject, this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity.jdField_a_of_type_Awvn.a(localObject));
        return;
      }
      a(paramProfileLabelInfo.labelId);
      return;
    }
  }
  
  private void a(Long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity.b.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((ProfileLabelTypeInfo)localIterator.next()).labels);
    }
    paramLong = this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity.a(paramLong, localArrayList);
    if (paramLong != null) {
      paramLong.toggleStatus();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity.getLayoutInflater().inflate(2131562709, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)(32.0F * this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity.jdField_a_of_type_Float)));
      paramViewGroup = new adoo();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377406));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      int i = paramInt % ProfileActivity.a.length;
      paramView.setBackgroundResource(ProfileActivity.a[i][0]);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      i = ProfileActivity.a[i][1];
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((ProfileLabelInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).labelName);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(((ProfileLabelInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).labelName);
      return paramView;
      paramViewGroup = (adoo)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adop
 * JD-Core Version:    0.7.0.1
 */
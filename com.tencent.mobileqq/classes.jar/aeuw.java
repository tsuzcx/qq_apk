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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class aeuw
  extends BaseAdapter
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aeux(this);
  List<ProfileLabelInfo> jdField_a_of_type_JavaUtilList;
  
  public aeuw(List<ProfileLabelInfo> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  private void a(ProfileLabelInfo paramProfileLabelInfo)
  {
    Object localObject = null;
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity.jdField_a_of_type_Azjr.a().keySet().iterator();
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
      if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity.jdField_a_of_type_Azjr.a(localObject)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity.jdField_a_of_type_Azjr.c(localObject, this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity.jdField_a_of_type_Azjr.a(localObject));
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
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity.getLayoutInflater().inflate(2131562948, null);
      localView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)(32.0F * this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity.jdField_a_of_type_Float)));
      paramView = new aeuv();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378230));
      localView.setTag(paramView);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_Int = paramInt;
      int i = paramInt % ProfileActivity.a.length;
      localView.setBackgroundResource(ProfileActivity.a[i][0]);
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      i = ProfileActivity.a[i][1];
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((ProfileLabelInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).labelName);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(((ProfileLabelInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).labelName);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      aeuv localaeuv = (aeuv)paramView.getTag();
      localView = paramView;
      paramView = localaeuv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeuw
 * JD-Core Version:    0.7.0.1
 */
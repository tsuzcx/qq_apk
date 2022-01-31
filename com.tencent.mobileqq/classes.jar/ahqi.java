import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import java.util.List;
import tencent.im.nearfield_discuss.nearfield_discuss.UserProfile;

public class ahqi
  extends BaseAdapter
{
  ahqj jdField_a_of_type_Ahqj;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public ahqi(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramCreateFaceToFaceDiscussionActivity.jdField_a_of_type_AndroidContentContext);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList.size() < 50) {
      return this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList.size() + 1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return (nearfield_discuss.UserProfile)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495205, null);
      this.jdField_a_of_type_Ahqj = new ahqj(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity);
      this.jdField_a_of_type_Ahqj.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302061));
      this.jdField_a_of_type_Ahqj.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131304981));
      paramView.setTag(this.jdField_a_of_type_Ahqj);
    }
    while ((paramInt == getCount() - 1) && (getCount() < 50))
    {
      CreateFaceToFaceDiscussionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity, paramView);
      return paramView;
      this.jdField_a_of_type_Ahqj = ((ahqj)paramView.getTag());
      if (this.jdField_a_of_type_Ahqj.jdField_a_of_type_Boolean)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495205, null);
        this.jdField_a_of_type_Ahqj = new ahqj(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity);
        this.jdField_a_of_type_Ahqj.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302061));
        this.jdField_a_of_type_Ahqj.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131304981));
        paramView.setTag(this.jdField_a_of_type_Ahqj);
        this.jdField_a_of_type_Ahqj.jdField_a_of_type_Boolean = false;
      }
    }
    CreateFaceToFaceDiscussionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity, paramView, (nearfield_discuss.UserProfile)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList.get(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahqi
 * JD-Core Version:    0.7.0.1
 */
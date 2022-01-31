import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.JobSelectionActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.widget.InterestLabelTextView;

public class adaj
  extends BaseAdapter
{
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private String[] b;
  
  private adaj(JobSelectionActivity paramJobSelectionActivity)
  {
    if (JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity))
    {
      paramJobSelectionActivity = allj.d;
      this.jdField_a_of_type_ArrayOfJavaLangString = paramJobSelectionActivity;
      if (!JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity)) {
        break label74;
      }
      paramJobSelectionActivity = allj.e;
      label42:
      this.b = paramJobSelectionActivity;
      if (!JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity)) {
        break label81;
      }
    }
    label74:
    label81:
    for (paramJobSelectionActivity = allj.jdField_a_of_type_ArrayOfInt;; paramJobSelectionActivity = bcyr.b)
    {
      this.jdField_a_of_type_ArrayOfInt = paramJobSelectionActivity;
      return;
      paramJobSelectionActivity = bcyr.d;
      break;
      paramJobSelectionActivity = bcyr.e;
      break label42;
    }
  }
  
  public int getCount()
  {
    if (JobSelectionActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity)) {
      return this.jdField_a_of_type_ArrayOfJavaLangString.length - 2;
    }
    return this.jdField_a_of_type_ArrayOfJavaLangString.length - 1;
  }
  
  public Object getItem(int paramInt)
  {
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity.a(paramInt);
    return this.jdField_a_of_type_ArrayOfJavaLangString[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity.getLayoutInflater().inflate(2131560981, paramViewGroup, false);
      paramView = new adak(null);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView = ((InterestLabelTextView)localView.findViewById(2131377349));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370958));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131364249));
      localView.setTag(paramView);
    }
    paramView = (adak)localView.getTag();
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity.a(paramInt);
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity.getResources().getDrawable(this.jdField_a_of_type_ArrayOfInt[paramInt]);
    ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity.app, paramViewGroup);
    paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setText(this.b[paramInt]);
    paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setBackgroundDrawable(paramViewGroup);
    int i = aekt.a(4.0F, JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity).getResources());
    paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setPadding(i, 0, i, 0);
    if (paramInt < this.jdField_a_of_type_ArrayOfJavaLangString.length - 1) {
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(0);
    }
    for (;;)
    {
      if ((JobSelectionActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity)) && (paramInt == 0)) {
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(4);
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
      if (JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity) != paramInt) {
        break;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return localView;
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(4);
    }
    paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adaj
 * JD-Core Version:    0.7.0.1
 */
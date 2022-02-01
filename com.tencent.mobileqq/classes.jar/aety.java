import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.JobSelectionActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.widget.InterestLabelTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aety
  extends BaseAdapter
{
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private String[] b;
  
  private aety(JobSelectionActivity paramJobSelectionActivity)
  {
    if (JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity))
    {
      paramJobSelectionActivity = anve.d;
      this.jdField_a_of_type_ArrayOfJavaLangString = paramJobSelectionActivity;
      if (!JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity)) {
        break label74;
      }
      paramJobSelectionActivity = anve.e;
      label42:
      this.b = paramJobSelectionActivity;
      if (!JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity)) {
        break label81;
      }
    }
    label74:
    label81:
    for (paramJobSelectionActivity = anve.jdField_a_of_type_ArrayOfInt;; paramJobSelectionActivity = bhhu.b)
    {
      this.jdField_a_of_type_ArrayOfInt = paramJobSelectionActivity;
      return;
      paramJobSelectionActivity = bhhu.d;
      break;
      paramJobSelectionActivity = bhhu.e;
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
    aetz localaetz;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity.getLayoutInflater().inflate(2131561246, paramViewGroup, false);
      localaetz = new aetz(null);
      localaetz.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView = ((InterestLabelTextView)paramView.findViewById(2131378384));
      localaetz.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371647));
      localaetz.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364504));
      paramView.setTag(localaetz);
    }
    for (;;)
    {
      localaetz = (aetz)paramView.getTag();
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity.a(paramInt);
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity.getResources().getDrawable(this.jdField_a_of_type_ArrayOfInt[i]);
      ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity.app, localDrawable);
      localaetz.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setText(this.b[i]);
      localaetz.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setBackgroundDrawable(localDrawable);
      int j = agej.a(4.0F, JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity).getResources());
      localaetz.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setPadding(j, 0, j, 0);
      if (i < this.jdField_a_of_type_ArrayOfJavaLangString.length - 1)
      {
        localaetz.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(0);
        if ((JobSelectionActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity)) && (i == 0)) {
          localaetz.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(4);
        }
        localaetz.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
        if (JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity) != i) {
          break label292;
        }
        localaetz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localaetz.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(4);
        break;
        label292:
        localaetz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aety
 * JD-Core Version:    0.7.0.1
 */
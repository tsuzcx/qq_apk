import SummaryCard.CondFitUser;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.conditionsearch.SearchResultActivity;
import com.tencent.mobileqq.widget.InterestLabelTextView;
import java.util.List;

public class abrf
  extends BaseAdapter
{
  private abrf(SearchResultActivity paramSearchResultActivity) {}
  
  public int getCount()
  {
    int j = this.a.jdField_a_of_type_JavaUtilList.size();
    if (this.a.b != 0) {}
    for (int i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.a.jdField_a_of_type_JavaUtilList.size()) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (getItemViewType(paramInt) == 0)
    {
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = this.a.getLayoutInflater().inflate(2130970284, null);
        paramViewGroup.setOnClickListener(this.a);
        paramView = new abrg();
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131362869));
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131362870));
        paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367502));
        paramView.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView = ((InterestLabelTextView)paramViewGroup.findViewById(2131369946));
        paramView.c = ((InterestLabelTextView)paramViewGroup.findViewById(2131369948));
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView = ((InterestLabelTextView)paramViewGroup.findViewById(2131369947));
        paramView.d = ((InterestLabelTextView)paramViewGroup.findViewById(2131369949));
        paramViewGroup.setTag(paramView);
      }
      paramView = (abrg)paramViewGroup.getTag();
      localObject = (CondFitUser)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
      localObject = this.a.a(paramView, (CondFitUser)localObject);
      paramView = paramViewGroup;
      if (SearchResultActivity.jdField_a_of_type_Boolean)
      {
        paramViewGroup.setContentDescription((CharSequence)localObject);
        paramView = paramViewGroup;
      }
    }
    do
    {
      return paramView;
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = this.a.getLayoutInflater().inflate(2130969103, null);
        paramViewGroup.setOnClickListener(this.a);
        paramView = new abrh();
        paramViewGroup.setTag(paramView);
        paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131363049));
        paramViewGroup.findViewById(2131365172).setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131364983));
      }
      if (this.a.b == 1)
      {
        this.a.b = 2;
        SearchResultActivity.d(this.a);
      }
      localObject = (abrh)paramViewGroup.getTag();
      if (this.a.b == 3)
      {
        ((abrh)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        ((abrh)localObject).jdField_a_of_type_AndroidWidgetTextView.setText("获取失败，请稍后再试");
        return paramViewGroup;
      }
      if (this.a.b == 2)
      {
        ((abrh)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        ((abrh)localObject).jdField_a_of_type_AndroidWidgetTextView.setText("载入中，请稍候...");
        return paramViewGroup;
      }
      paramView = paramViewGroup;
    } while (this.a.b != 4);
    ((abrh)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    ((abrh)localObject).jdField_a_of_type_AndroidWidgetTextView.setText("获取失败，请检查网络连接");
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abrf
 * JD-Core Version:    0.7.0.1
 */
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import java.util.List;

public class aazn
  extends aims
{
  private List<aazk> jdField_a_of_type_JavaUtilList;
  
  public aazn(List<aazk> paramList)
  {
    super(paramList, paramList.app, paramList.a, 1, true);
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    aazk localaazk;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.getLayoutInflater().inflate(2131558991, paramViewGroup, false);
      paramViewGroup = new aazp(null);
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131368583));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378265));
      paramView.setTag(paramViewGroup);
      localaazk = (aazk)getItem(paramInt);
      if (localaazk != null)
      {
        if ((localaazk.b != null) && (!"".equals(localaazk.b.trim()))) {
          break label149;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localaazk.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_JavaLangString = localaazk.jdField_a_of_type_JavaLangString;
      paramViewGroup.c.setImageBitmap(a(1, localaazk.jdField_a_of_type_JavaLangString));
      return paramView;
      paramViewGroup = (aazp)paramView.getTag();
      break;
      label149:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localaazk.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aazn
 * JD-Core Version:    0.7.0.1
 */
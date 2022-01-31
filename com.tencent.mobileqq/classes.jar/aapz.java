import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import java.util.List;

public class aapz
  extends aiab
{
  private List<aapw> jdField_a_of_type_JavaUtilList;
  
  public aapz(List<aapw> paramList)
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
    aapw localaapw;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.getLayoutInflater().inflate(2131493428, paramViewGroup, false);
      paramViewGroup = new aaqb(null);
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131302951));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312436));
      paramView.setTag(paramViewGroup);
      localaapw = (aapw)getItem(paramInt);
      if (localaapw != null)
      {
        if ((localaapw.b != null) && (!"".equals(localaapw.b.trim()))) {
          break label149;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localaapw.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_JavaLangString = localaapw.jdField_a_of_type_JavaLangString;
      paramViewGroup.c.setImageBitmap(a(1, localaapw.jdField_a_of_type_JavaLangString));
      return paramView;
      paramViewGroup = (aaqb)paramView.getTag();
      break;
      label149:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localaapw.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aapz
 * JD-Core Version:    0.7.0.1
 */
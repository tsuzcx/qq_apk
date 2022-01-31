import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import java.util.List;

public class acqm
  extends aked
{
  private List<acqj> jdField_a_of_type_JavaUtilList;
  
  public acqm(List<acqj> paramList)
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
    acqj localacqj;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.getLayoutInflater().inflate(2131559030, paramViewGroup, false);
      paramViewGroup = new acqo(null);
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131368782));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378839));
      paramView.setTag(paramViewGroup);
      localacqj = (acqj)getItem(paramInt);
      if (localacqj != null)
      {
        if ((localacqj.b != null) && (!"".equals(localacqj.b.trim()))) {
          break label149;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localacqj.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_JavaLangString = localacqj.jdField_a_of_type_JavaLangString;
      paramViewGroup.c.setImageBitmap(a(1, localacqj.jdField_a_of_type_JavaLangString));
      return paramView;
      paramViewGroup = (acqo)paramView.getTag();
      break;
      label149:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localacqj.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqm
 * JD-Core Version:    0.7.0.1
 */
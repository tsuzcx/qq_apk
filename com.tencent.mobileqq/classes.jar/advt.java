import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class advt
  extends amgy
{
  private List<advq> jdField_a_of_type_JavaUtilList;
  
  public advt(List<advq> paramList)
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
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.getLayoutInflater().inflate(2131559133, paramViewGroup, false);
      paramView = new advv(null);
      paramView.c = ((ImageView)localView.findViewById(2131369417));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380038));
      localView.setTag(paramView);
      localObject = (advq)getItem(paramInt);
      if (localObject != null)
      {
        if ((((advq)localObject).b != null) && (!"".equals(((advq)localObject).b.trim()))) {
          break label176;
        }
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((advq)localObject).jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      paramView.jdField_a_of_type_JavaLangString = ((advq)localObject).jdField_a_of_type_JavaLangString;
      paramView.c.setImageBitmap(a(1, ((advq)localObject).jdField_a_of_type_JavaLangString));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (advv)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label176:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((advq)localObject).b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advt
 * JD-Core Version:    0.7.0.1
 */
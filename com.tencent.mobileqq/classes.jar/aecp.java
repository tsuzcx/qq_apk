import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aecp
  extends amck
{
  private List<aecm> jdField_a_of_type_JavaUtilList;
  
  public aecp(List<aecm> paramList)
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
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.getLayoutInflater().inflate(2131559097, paramViewGroup, false);
      paramView = new aecr(null);
      paramView.c = ((ImageView)localView.findViewById(2131369143));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379779));
      localView.setTag(paramView);
      localObject = (aecm)getItem(paramInt);
      if (localObject != null)
      {
        if ((((aecm)localObject).b != null) && (!"".equals(((aecm)localObject).b.trim()))) {
          break label176;
        }
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((aecm)localObject).jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      paramView.jdField_a_of_type_JavaLangString = ((aecm)localObject).jdField_a_of_type_JavaLangString;
      paramView.c.setImageBitmap(a(1, ((aecm)localObject).jdField_a_of_type_JavaLangString));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (aecr)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label176:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((aecm)localObject).b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aecp
 * JD-Core Version:    0.7.0.1
 */
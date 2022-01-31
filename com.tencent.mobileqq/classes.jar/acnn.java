import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import java.util.List;

public class acnn
  extends aims
{
  private List<acnq> jdField_a_of_type_JavaUtilList;
  
  public acnn(List<acnq> paramList)
  {
    super(paramList, paramList.app, paramList.b, 1, true);
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
    acnq localacnq;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.getLayoutInflater().inflate(2131562411, paramViewGroup, false);
      paramViewGroup = new acns(null);
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131368583));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378265));
      ((TextView)paramView.findViewById(2131378356)).setText("");
      paramView.setTag(paramViewGroup);
      localacnq = (acnq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((TextUtils.isEmpty(localacnq.e)) || (localacnq.e.equals(localacnq.b))) {
        break label203;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localacnq.b + "(" + localacnq.e + ")");
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_JavaLangString = localacnq.jdField_a_of_type_JavaLangString;
      paramViewGroup.jdField_a_of_type_Acnq = localacnq;
      paramViewGroup.c.setImageBitmap(a(1, localacnq.jdField_a_of_type_JavaLangString));
      return paramView;
      paramViewGroup = (acns)paramView.getTag();
      break;
      label203:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localacnq.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acnn
 * JD-Core Version:    0.7.0.1
 */
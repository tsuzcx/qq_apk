import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import java.util.List;

public class aeex
  extends aked
{
  private List<aefa> jdField_a_of_type_JavaUtilList;
  
  public aeex(List<aefa> paramList)
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
    aefa localaefa;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.getLayoutInflater().inflate(2131562615, paramViewGroup, false);
      paramViewGroup = new aefc(null);
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131368782));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378839));
      ((TextView)paramView.findViewById(2131378950)).setText("");
      paramView.setTag(paramViewGroup);
      localaefa = (aefa)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((TextUtils.isEmpty(localaefa.e)) || (localaefa.e.equals(localaefa.b))) {
        break label203;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localaefa.b + "(" + localaefa.e + ")");
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_JavaLangString = localaefa.jdField_a_of_type_JavaLangString;
      paramViewGroup.jdField_a_of_type_Aefa = localaefa;
      paramViewGroup.c.setImageBitmap(a(1, localaefa.jdField_a_of_type_JavaLangString));
      return paramView;
      paramViewGroup = (aefc)paramView.getTag();
      break;
      label203:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localaefa.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeex
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import java.util.List;

public class aejm
  extends akis
{
  private List<aejp> jdField_a_of_type_JavaUtilList;
  
  public aejm(List<aejp> paramList)
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
    aejp localaejp;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.getLayoutInflater().inflate(2131562633, paramViewGroup, false);
      paramViewGroup = new aejr(null);
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131368796));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378896));
      ((TextView)paramView.findViewById(2131379008)).setText("");
      paramView.setTag(paramViewGroup);
      localaejp = (aejp)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((TextUtils.isEmpty(localaejp.e)) || (localaejp.e.equals(localaejp.b))) {
        break label203;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localaejp.b + "(" + localaejp.e + ")");
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_JavaLangString = localaejp.jdField_a_of_type_JavaLangString;
      paramViewGroup.jdField_a_of_type_Aejp = localaejp;
      paramViewGroup.c.setImageBitmap(a(1, localaejp.jdField_a_of_type_JavaLangString));
      return paramView;
      paramViewGroup = (aejr)paramView.getTag();
      break;
      label203:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localaejp.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aejm
 * JD-Core Version:    0.7.0.1
 */
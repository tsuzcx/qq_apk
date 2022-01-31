import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import java.util.List;

public class acnr
  extends aimu
{
  private List<acnu> jdField_a_of_type_JavaUtilList;
  
  public acnr(List<acnu> paramList)
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
    acnu localacnu;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.getLayoutInflater().inflate(2131562412, paramViewGroup, false);
      paramViewGroup = new acnw(null);
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131368584));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378262));
      ((TextView)paramView.findViewById(2131378353)).setText("");
      paramView.setTag(paramViewGroup);
      localacnu = (acnu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((TextUtils.isEmpty(localacnu.e)) || (localacnu.e.equals(localacnu.b))) {
        break label203;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localacnu.b + "(" + localacnu.e + ")");
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_JavaLangString = localacnu.jdField_a_of_type_JavaLangString;
      paramViewGroup.jdField_a_of_type_Acnu = localacnu;
      paramViewGroup.c.setImageBitmap(a(1, localacnu.jdField_a_of_type_JavaLangString));
      return paramView;
      paramViewGroup = (acnw)paramView.getTag();
      break;
      label203:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localacnu.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acnr
 * JD-Core Version:    0.7.0.1
 */
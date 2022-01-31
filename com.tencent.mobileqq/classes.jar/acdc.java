import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import java.util.List;

public class acdc
  extends aiab
{
  private List<acdf> jdField_a_of_type_JavaUtilList;
  
  public acdc(List<acdf> paramList)
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
    acdf localacdf;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.getLayoutInflater().inflate(2131496812, paramViewGroup, false);
      paramViewGroup = new acdh(null);
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131302951));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312436));
      ((TextView)paramView.findViewById(2131312528)).setText("");
      paramView.setTag(paramViewGroup);
      localacdf = (acdf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((TextUtils.isEmpty(localacdf.e)) || (localacdf.e.equals(localacdf.b))) {
        break label203;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localacdf.b + "(" + localacdf.e + ")");
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_JavaLangString = localacdf.jdField_a_of_type_JavaLangString;
      paramViewGroup.jdField_a_of_type_Acdf = localacdf;
      paramViewGroup.c.setImageBitmap(a(1, localacdf.jdField_a_of_type_JavaLangString));
      return paramView;
      paramViewGroup = (acdh)paramView.getTag();
      break;
      label203:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localacdf.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acdc
 * JD-Core Version:    0.7.0.1
 */
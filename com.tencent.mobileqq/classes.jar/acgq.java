import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopClassChoiceActivity;
import java.util.ArrayList;

public class acgq
  extends BaseAdapter
{
  public acgq(TroopClassChoiceActivity paramTroopClassChoiceActivity) {}
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.a.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.a.getLayoutInflater().inflate(2131562532, null);
    }
    TextView localTextView1 = (TextView)paramViewGroup.findViewById(2131377750);
    TextView localTextView2 = (TextView)paramViewGroup.findViewById(2131377749);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131371062);
    basm localbasm2 = (basm)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Object localObject;
    if ((this.a.jdField_a_of_type_Basm != null) && (localbasm2.jdField_a_of_type_Int < this.a.jdField_a_of_type_Basm.jdField_a_of_type_Int))
    {
      localObject = this.a.jdField_a_of_type_Basm;
      paramView = ((basm)localObject).jdField_a_of_type_Basm;
      if ((paramView == null) || (paramView.jdField_a_of_type_Int < localbasm2.jdField_a_of_type_Int)) {
        break label310;
      }
      if (!localbasm2.b.equals(paramView.b)) {}
    }
    label302:
    label310:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        localTextView2.setVisibility(0);
        localTextView2.setText(((basm)localObject).jdField_a_of_type_JavaLangString);
        localTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130849563, 0);
      }
      for (;;)
      {
        localTextView1.setText(localbasm2.jdField_a_of_type_JavaLangString);
        if ((localbasm2.jdField_a_of_type_JavaUtilArrayList == null) || (localbasm2.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
          break label302;
        }
        localImageView.setVisibility(0);
        return paramViewGroup;
        basm localbasm1 = paramView.jdField_a_of_type_Basm;
        localObject = paramView;
        paramView = localbasm1;
        break;
        localTextView2.setVisibility(4);
        continue;
        if ((this.a.jdField_a_of_type_Basm != null) && (localbasm2.b.equals(this.a.jdField_a_of_type_Basm.b)))
        {
          localTextView2.setVisibility(0);
          localTextView2.setText("");
          localTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130849563, 0);
        }
        else
        {
          localTextView2.setVisibility(4);
        }
      }
      localImageView.setVisibility(4);
      return paramViewGroup;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acgq
 * JD-Core Version:    0.7.0.1
 */
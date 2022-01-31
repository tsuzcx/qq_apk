import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopClassChoiceActivity;
import java.util.ArrayList;

public class acgm
  extends BaseAdapter
{
  public acgm(TroopClassChoiceActivity paramTroopClassChoiceActivity) {}
  
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
      paramViewGroup = this.a.getLayoutInflater().inflate(2131562531, null);
    }
    TextView localTextView1 = (TextView)paramViewGroup.findViewById(2131377750);
    TextView localTextView2 = (TextView)paramViewGroup.findViewById(2131377749);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131371062);
    bata localbata2 = (bata)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Object localObject;
    if ((this.a.jdField_a_of_type_Bata != null) && (localbata2.jdField_a_of_type_Int < this.a.jdField_a_of_type_Bata.jdField_a_of_type_Int))
    {
      localObject = this.a.jdField_a_of_type_Bata;
      paramView = ((bata)localObject).jdField_a_of_type_Bata;
      if ((paramView == null) || (paramView.jdField_a_of_type_Int < localbata2.jdField_a_of_type_Int)) {
        break label310;
      }
      if (!localbata2.b.equals(paramView.b)) {}
    }
    label302:
    label310:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        localTextView2.setVisibility(0);
        localTextView2.setText(((bata)localObject).jdField_a_of_type_JavaLangString);
        localTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130849572, 0);
      }
      for (;;)
      {
        localTextView1.setText(localbata2.jdField_a_of_type_JavaLangString);
        if ((localbata2.jdField_a_of_type_JavaUtilArrayList == null) || (localbata2.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
          break label302;
        }
        localImageView.setVisibility(0);
        return paramViewGroup;
        bata localbata1 = paramView.jdField_a_of_type_Bata;
        localObject = paramView;
        paramView = localbata1;
        break;
        localTextView2.setVisibility(4);
        continue;
        if ((this.a.jdField_a_of_type_Bata != null) && (localbata2.b.equals(this.a.jdField_a_of_type_Bata.b)))
        {
          localTextView2.setVisibility(0);
          localTextView2.setText("");
          localTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130849572, 0);
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
 * Qualified Name:     acgm
 * JD-Core Version:    0.7.0.1
 */
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopClassChoiceActivity;
import java.util.ArrayList;

public class abwe
  extends BaseAdapter
{
  public abwe(TroopClassChoiceActivity paramTroopClassChoiceActivity) {}
  
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
      paramViewGroup = this.a.getLayoutInflater().inflate(2131496932, null);
    }
    TextView localTextView1 = (TextView)paramViewGroup.findViewById(2131311929);
    TextView localTextView2 = (TextView)paramViewGroup.findViewById(2131311928);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131305369);
    azri localazri2 = (azri)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Object localObject;
    if ((this.a.jdField_a_of_type_Azri != null) && (localazri2.jdField_a_of_type_Int < this.a.jdField_a_of_type_Azri.jdField_a_of_type_Int))
    {
      localObject = this.a.jdField_a_of_type_Azri;
      paramView = ((azri)localObject).jdField_a_of_type_Azri;
      if ((paramView == null) || (paramView.jdField_a_of_type_Int < localazri2.jdField_a_of_type_Int)) {
        break label310;
      }
      if (!localazri2.b.equals(paramView.b)) {}
    }
    label302:
    label310:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        localTextView2.setVisibility(0);
        localTextView2.setText(((azri)localObject).jdField_a_of_type_JavaLangString);
        localTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130849328, 0);
      }
      for (;;)
      {
        localTextView1.setText(localazri2.jdField_a_of_type_JavaLangString);
        if ((localazri2.jdField_a_of_type_JavaUtilArrayList == null) || (localazri2.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
          break label302;
        }
        localImageView.setVisibility(0);
        return paramViewGroup;
        azri localazri1 = paramView.jdField_a_of_type_Azri;
        localObject = paramView;
        paramView = localazri1;
        break;
        localTextView2.setVisibility(4);
        continue;
        if ((this.a.jdField_a_of_type_Azri != null) && (localazri2.b.equals(this.a.jdField_a_of_type_Azri.b)))
        {
          localTextView2.setVisibility(0);
          localTextView2.setText("");
          localTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130849328, 0);
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
 * Qualified Name:     abwe
 * JD-Core Version:    0.7.0.1
 */
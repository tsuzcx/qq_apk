import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopClassChoiceActivity;
import java.util.ArrayList;

public class adxw
  extends BaseAdapter
{
  public adxw(TroopClassChoiceActivity paramTroopClassChoiceActivity) {}
  
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
      paramViewGroup = this.a.getLayoutInflater().inflate(2131562734, null);
    }
    TextView localTextView1 = (TextView)paramViewGroup.findViewById(2131378294);
    TextView localTextView2 = (TextView)paramViewGroup.findViewById(2131378293);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131371375);
    bcru localbcru2 = (bcru)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Object localObject;
    if ((this.a.jdField_a_of_type_Bcru != null) && (localbcru2.jdField_a_of_type_Int < this.a.jdField_a_of_type_Bcru.jdField_a_of_type_Int))
    {
      localObject = this.a.jdField_a_of_type_Bcru;
      paramView = ((bcru)localObject).jdField_a_of_type_Bcru;
      if ((paramView == null) || (paramView.jdField_a_of_type_Int < localbcru2.jdField_a_of_type_Int)) {
        break label310;
      }
      if (!localbcru2.b.equals(paramView.b)) {}
    }
    label302:
    label310:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        localTextView2.setVisibility(0);
        localTextView2.setText(((bcru)localObject).jdField_a_of_type_JavaLangString);
        localTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130850013, 0);
      }
      for (;;)
      {
        localTextView1.setText(localbcru2.jdField_a_of_type_JavaLangString);
        if ((localbcru2.jdField_a_of_type_JavaUtilArrayList == null) || (localbcru2.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
          break label302;
        }
        localImageView.setVisibility(0);
        return paramViewGroup;
        bcru localbcru1 = paramView.jdField_a_of_type_Bcru;
        localObject = paramView;
        paramView = localbcru1;
        break;
        localTextView2.setVisibility(4);
        continue;
        if ((this.a.jdField_a_of_type_Bcru != null) && (localbcru2.b.equals(this.a.jdField_a_of_type_Bcru.b)))
        {
          localTextView2.setVisibility(0);
          localTextView2.setText("");
          localTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130850013, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxw
 * JD-Core Version:    0.7.0.1
 */
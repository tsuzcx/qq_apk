import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopClassChoiceActivity;
import java.util.ArrayList;

public class aecl
  extends BaseAdapter
{
  public aecl(TroopClassChoiceActivity paramTroopClassChoiceActivity) {}
  
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
      paramViewGroup = this.a.getLayoutInflater().inflate(2131562752, null);
    }
    TextView localTextView1 = (TextView)paramViewGroup.findViewById(2131378348);
    TextView localTextView2 = (TextView)paramViewGroup.findViewById(2131378347);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131371394);
    bcwd localbcwd2 = (bcwd)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Object localObject;
    if ((this.a.jdField_a_of_type_Bcwd != null) && (localbcwd2.jdField_a_of_type_Int < this.a.jdField_a_of_type_Bcwd.jdField_a_of_type_Int))
    {
      localObject = this.a.jdField_a_of_type_Bcwd;
      paramView = ((bcwd)localObject).jdField_a_of_type_Bcwd;
      if ((paramView == null) || (paramView.jdField_a_of_type_Int < localbcwd2.jdField_a_of_type_Int)) {
        break label310;
      }
      if (!localbcwd2.b.equals(paramView.b)) {}
    }
    label302:
    label310:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        localTextView2.setVisibility(0);
        localTextView2.setText(((bcwd)localObject).jdField_a_of_type_JavaLangString);
        localTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130850086, 0);
      }
      for (;;)
      {
        localTextView1.setText(localbcwd2.jdField_a_of_type_JavaLangString);
        if ((localbcwd2.jdField_a_of_type_JavaUtilArrayList == null) || (localbcwd2.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
          break label302;
        }
        localImageView.setVisibility(0);
        return paramViewGroup;
        bcwd localbcwd1 = paramView.jdField_a_of_type_Bcwd;
        localObject = paramView;
        paramView = localbcwd1;
        break;
        localTextView2.setVisibility(4);
        continue;
        if ((this.a.jdField_a_of_type_Bcwd != null) && (localbcwd2.b.equals(this.a.jdField_a_of_type_Bcwd.b)))
        {
          localTextView2.setVisibility(0);
          localTextView2.setText("");
          localTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130850086, 0);
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
 * Qualified Name:     aecl
 * JD-Core Version:    0.7.0.1
 */
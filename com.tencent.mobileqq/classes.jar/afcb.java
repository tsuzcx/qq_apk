import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopClassChoiceActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class afcb
  extends BaseAdapter
{
  public afcb(TroopClassChoiceActivity paramTroopClassChoiceActivity) {}
  
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
    if (paramView == null) {}
    for (View localView = this.a.getLayoutInflater().inflate(2131562979, null);; localView = paramView)
    {
      TextView localTextView1 = (TextView)localView.findViewById(2131379429);
      TextView localTextView2 = (TextView)localView.findViewById(2131379428);
      ImageView localImageView = (ImageView)localView.findViewById(2131372236);
      bgss localbgss2 = (bgss)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      int j = 0;
      Object localObject;
      if ((this.a.jdField_a_of_type_Bgss != null) && (localbgss2.jdField_a_of_type_Int < this.a.jdField_a_of_type_Bgss.jdField_a_of_type_Int))
      {
        localObject = this.a.jdField_a_of_type_Bgss;
        paramView = ((bgss)localObject).jdField_a_of_type_Bgss;
        int i = j;
        if (paramView != null)
        {
          i = j;
          if (paramView.jdField_a_of_type_Int >= localbgss2.jdField_a_of_type_Int)
          {
            if (!localbgss2.b.equals(paramView.b)) {
              break label243;
            }
            i = 1;
          }
        }
        if (i != 0)
        {
          localTextView2.setVisibility(0);
          localTextView2.setText(((bgss)localObject).jdField_a_of_type_JavaLangString);
          localTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130850752, 0);
          label190:
          localTextView1.setText(localbgss2.jdField_a_of_type_JavaLangString);
          if ((localbgss2.jdField_a_of_type_JavaUtilArrayList == null) || (localbgss2.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
            break label333;
          }
          localImageView.setVisibility(0);
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        label243:
        bgss localbgss1 = paramView.jdField_a_of_type_Bgss;
        localObject = paramView;
        paramView = localbgss1;
        break;
        localTextView2.setVisibility(4);
        break label190;
        if ((this.a.jdField_a_of_type_Bgss != null) && (localbgss2.b.equals(this.a.jdField_a_of_type_Bgss.b)))
        {
          localTextView2.setVisibility(0);
          localTextView2.setText("");
          localTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130850752, 0);
          break label190;
        }
        localTextView2.setVisibility(4);
        break label190;
        label333:
        localImageView.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afcb
 * JD-Core Version:    0.7.0.1
 */
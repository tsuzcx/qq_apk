import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopClassChoiceActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class afiw
  extends BaseAdapter
{
  public afiw(TroopClassChoiceActivity paramTroopClassChoiceActivity) {}
  
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
    for (View localView = this.a.getLayoutInflater().inflate(2131562991, null);; localView = paramView)
    {
      TextView localTextView1 = (TextView)localView.findViewById(2131379199);
      TextView localTextView2 = (TextView)localView.findViewById(2131379198);
      ImageView localImageView = (ImageView)localView.findViewById(2131371965);
      bgao localbgao2 = (bgao)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      int j = 0;
      Object localObject;
      if ((this.a.jdField_a_of_type_Bgao != null) && (localbgao2.jdField_a_of_type_Int < this.a.jdField_a_of_type_Bgao.jdField_a_of_type_Int))
      {
        localObject = this.a.jdField_a_of_type_Bgao;
        paramView = ((bgao)localObject).jdField_a_of_type_Bgao;
        int i = j;
        if (paramView != null)
        {
          i = j;
          if (paramView.jdField_a_of_type_Int >= localbgao2.jdField_a_of_type_Int)
          {
            if (!localbgao2.b.equals(paramView.b)) {
              break label243;
            }
            i = 1;
          }
        }
        if (i != 0)
        {
          localTextView2.setVisibility(0);
          localTextView2.setText(((bgao)localObject).jdField_a_of_type_JavaLangString);
          localTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130850679, 0);
          label190:
          localTextView1.setText(localbgao2.jdField_a_of_type_JavaLangString);
          if ((localbgao2.jdField_a_of_type_JavaUtilArrayList == null) || (localbgao2.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
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
        bgao localbgao1 = paramView.jdField_a_of_type_Bgao;
        localObject = paramView;
        paramView = localbgao1;
        break;
        localTextView2.setVisibility(4);
        break label190;
        if ((this.a.jdField_a_of_type_Bgao != null) && (localbgao2.b.equals(this.a.jdField_a_of_type_Bgao.b)))
        {
          localTextView2.setVisibility(0);
          localTextView2.setText("");
          localTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130850679, 0);
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
 * Qualified Name:     afiw
 * JD-Core Version:    0.7.0.1
 */
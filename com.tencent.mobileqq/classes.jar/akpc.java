import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.phone.NewStyleCountryActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class akpc
  extends bjai
{
  private akpc(NewStyleCountryActivity paramNewStyleCountryActivity) {}
  
  public int a()
  {
    return 2131562844;
  }
  
  public void a(View paramView, int paramInt)
  {
    paramInt = ((Integer)this.a.jdField_a_of_type_JavaUtilLinkedHashMap.get(((bhof)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString)).intValue();
    ((TextView)paramView).setText(((bhof)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(int paramInt)
  {
    return ((bhof)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Boolean;
  }
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (((bhof)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Boolean) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bhof localbhof = (bhof)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (getItemViewType(paramInt) == 0)
    {
      if (paramView != null) {
        break label129;
      }
      paramView = this.a.getLayoutInflater().inflate(a(), paramViewGroup, false);
    }
    label129:
    for (;;)
    {
      ((TextView)paramView).setText(localbhof.jdField_a_of_type_JavaLangString);
      for (;;)
      {
        paramView.setVisibility(0);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        View localView = paramView;
        if (paramView == null)
        {
          localView = NewStyleCountryActivity.a(this.a, paramViewGroup, this.a.getLayoutInflater(), false);
          localView.setOnClickListener(this.a);
        }
        this.a.a(localView, localbhof);
        paramView = localView;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akpc
 * JD-Core Version:    0.7.0.1
 */
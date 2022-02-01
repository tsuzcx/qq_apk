import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SearchFriendListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class aeeh
  extends BaseAdapter
{
  private aeeh(SearchFriendListActivity paramSearchFriendListActivity) {}
  
  public int getCount()
  {
    return SearchFriendListActivity.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= SearchFriendListActivity.a(this.a).size())) {
      return null;
    }
    return SearchFriendListActivity.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.a.getLayoutInflater().inflate(2131562739, paramViewGroup, false);
      aeei localaeei = new aeei();
      localaeei.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367958));
      localaeei.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371790));
      localaeei.b = ((TextView)paramView.findViewById(2131365361));
      paramView.setTag(localaeei);
      paramView.setOnClickListener(this.a);
    }
    for (;;)
    {
      this.a.a(paramView, paramInt);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeeh
 * JD-Core Version:    0.7.0.1
 */
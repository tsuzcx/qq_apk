import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SearchFriendListActivity;
import java.util.ArrayList;

public class adrm
  extends BaseAdapter
{
  private adrm(SearchFriendListActivity paramSearchFriendListActivity) {}
  
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
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.a.getLayoutInflater().inflate(2131562570, paramViewGroup, false);
      paramView = new adrn();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367536));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371141));
      paramView.b = ((TextView)localView.findViewById(2131365048));
      localView.setTag(paramView);
      localView.setOnClickListener(this.a);
    }
    this.a.a(localView, paramInt);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrm
 * JD-Core Version:    0.7.0.1
 */
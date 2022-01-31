import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SearchFriendListActivity;
import java.util.ArrayList;

public class acae
  extends BaseAdapter
{
  private acae(SearchFriendListActivity paramSearchFriendListActivity) {}
  
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
      localView = this.a.getLayoutInflater().inflate(2131562366, paramViewGroup, false);
      paramView = new acaf();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367407));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370830));
      paramView.b = ((TextView)localView.findViewById(2131364963));
      localView.setTag(paramView);
      localView.setOnClickListener(this.a);
    }
    this.a.a(localView, paramInt);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acae
 * JD-Core Version:    0.7.0.1
 */
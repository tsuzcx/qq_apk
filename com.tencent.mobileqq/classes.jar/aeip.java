import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.data.Groups;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aeip
  extends BaseAdapter
{
  private aeip(MoveToGroupActivity paramMoveToGroupActivity) {}
  
  public int getCount()
  {
    if (MoveToGroupActivity.a(this.a) != null) {
      return MoveToGroupActivity.a(this.a).size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = this.a.getLayoutInflater().inflate(2131559522, null);
      int i = (byte)((Groups)MoveToGroupActivity.a(this.a).get(paramInt)).group_id;
      localObject = (ImageView)localView.findViewById(2131364620);
      if (i != MoveToGroupActivity.a(this.a)) {
        break label163;
      }
      ((ImageView)localObject).setVisibility(0);
    }
    for (;;)
    {
      localObject = (TextView)localView.findViewById(2131367917);
      ((TextView)localObject).setText(((Groups)MoveToGroupActivity.a(this.a).get(paramInt)).group_name);
      localView.setContentDescription(((TextView)localObject).getText().toString());
      localView.setTag(Integer.valueOf(paramInt));
      localView.setOnClickListener(this.a);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      localView = paramView;
      break;
      label163:
      ((ImageView)localObject).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeip
 * JD-Core Version:    0.7.0.1
 */
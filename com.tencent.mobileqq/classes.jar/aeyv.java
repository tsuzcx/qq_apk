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

public class aeyv
  extends BaseAdapter
{
  private aeyv(MoveToGroupActivity paramMoveToGroupActivity) {}
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_JavaUtilList != null) {
      return this.a.jdField_a_of_type_JavaUtilList.size();
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
      localView = this.a.getLayoutInflater().inflate(2131559487, null);
      int i = (byte)((Groups)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).group_id;
      localObject = (ImageView)localView.findViewById(2131364519);
      if (i != this.a.jdField_a_of_type_Byte) {
        break label163;
      }
      ((ImageView)localObject).setVisibility(0);
    }
    for (;;)
    {
      localObject = (TextView)localView.findViewById(2131367748);
      ((TextView)localObject).setText(((Groups)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).group_name);
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
 * Qualified Name:     aeyv
 * JD-Core Version:    0.7.0.1
 */
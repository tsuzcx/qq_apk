import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aisy
  extends BaseAdapter
{
  private aisy(aisw paramaisw) {}
  
  public int getCount()
  {
    return 6;
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
    if (paramView == null) {
      paramView = LayoutInflater.from(aisw.a(this.a)).inflate(2131562913, null);
    }
    for (;;)
    {
      int k;
      int j;
      int i;
      switch (paramInt)
      {
      case 4: 
      default: 
        k = 2130839122;
        j = 2131718391;
        i = 2131718788;
      }
      for (;;)
      {
        ImageView localImageView = (ImageView)paramView.findViewById(2131362830);
        TextView localTextView = (TextView)paramView.findViewById(2131362842);
        localImageView.setImageResource(k);
        localTextView.setText(j);
        if (AppSetting.c) {
          paramView.setContentDescription(aisw.a(this.a).getString(i));
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        j = 2131718405;
        k = 2130839126;
        i = 2131718804;
        continue;
        j = 2131718407;
        k = 2130839127;
        i = 2131718805;
        continue;
        j = 2131718412;
        k = 2130839130;
        i = 2131718812;
        continue;
        j = 2131718403;
        k = 2130839124;
        i = 2131718795;
        continue;
        i = 2131716154;
        j = 2131716154;
        k = 2130842473;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisy
 * JD-Core Version:    0.7.0.1
 */
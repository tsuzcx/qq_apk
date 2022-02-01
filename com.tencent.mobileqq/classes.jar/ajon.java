import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajon
  extends BaseAdapter
{
  private ajon(ajol paramajol) {}
  
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
      paramView = LayoutInflater.from(ajol.a(this.a)).inflate(2131562987, null);
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
        k = 2130839142;
        j = 2131718777;
        i = 2131719178;
      }
      for (;;)
      {
        ImageView localImageView = (ImageView)paramView.findViewById(2131362846);
        TextView localTextView = (TextView)paramView.findViewById(2131362858);
        localImageView.setImageResource(k);
        localTextView.setText(j);
        if (AppSetting.c) {
          paramView.setContentDescription(ajol.a(this.a).getString(i));
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        j = 2131718791;
        k = 2130839146;
        i = 2131719197;
        continue;
        j = 2131718793;
        k = 2130839147;
        i = 2131719198;
        continue;
        j = 2131718798;
        k = 2130839150;
        i = 2131719205;
        continue;
        j = 2131718789;
        k = 2130839144;
        i = 2131719185;
        continue;
        i = 2131716510;
        j = 2131716510;
        k = 2130842503;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajon
 * JD-Core Version:    0.7.0.1
 */
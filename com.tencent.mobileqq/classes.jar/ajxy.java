import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajxy
  extends BaseAdapter
{
  private ajxy(ajxw paramajxw) {}
  
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
      paramView = LayoutInflater.from(ajxw.a(this.a)).inflate(2131563032, null);
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
        k = 2130839087;
        j = 2131718150;
        i = 2131718540;
      }
      for (;;)
      {
        ImageView localImageView = (ImageView)paramView.findViewById(2131362822);
        TextView localTextView = (TextView)paramView.findViewById(2131362834);
        localImageView.setImageResource(k);
        localTextView.setText(j);
        if (AppSetting.c) {
          paramView.setContentDescription(ajxw.a(this.a).getString(i));
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        j = 2131718164;
        k = 2130839091;
        i = 2131718556;
        continue;
        j = 2131718166;
        k = 2130839092;
        i = 2131718557;
        continue;
        j = 2131718171;
        k = 2130839095;
        i = 2131718564;
        continue;
        j = 2131718162;
        k = 2130839089;
        i = 2131718547;
        continue;
        i = 2131715920;
        j = 2131715920;
        k = 2130842427;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxy
 * JD-Core Version:    0.7.0.1
 */
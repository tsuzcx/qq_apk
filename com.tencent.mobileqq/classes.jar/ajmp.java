import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajmp
  extends BaseAdapter
{
  private ajmp(ajmn paramajmn) {}
  
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
      paramView = LayoutInflater.from(ajmn.a(this.a)).inflate(2131562997, null);
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
        k = 2130839079;
        j = 2131718018;
        i = 2131718404;
      }
      for (;;)
      {
        ImageView localImageView = (ImageView)paramView.findViewById(2131362804);
        TextView localTextView = (TextView)paramView.findViewById(2131362816);
        localImageView.setImageResource(k);
        localTextView.setText(j);
        if (AppSetting.c) {
          paramView.setContentDescription(ajmn.a(this.a).getString(i));
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        j = 2131718032;
        k = 2130839083;
        i = 2131718420;
        continue;
        j = 2131718034;
        k = 2130839084;
        i = 2131718421;
        continue;
        j = 2131718038;
        k = 2130839087;
        i = 2131718428;
        continue;
        j = 2131718030;
        k = 2130839081;
        i = 2131718411;
        continue;
        i = 2131715811;
        j = 2131715811;
        k = 2130842415;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajmp
 * JD-Core Version:    0.7.0.1
 */
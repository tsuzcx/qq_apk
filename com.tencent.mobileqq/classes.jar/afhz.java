import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;

class afhz
  extends BaseAdapter
{
  private afhz(afhx paramafhx) {}
  
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
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = LayoutInflater.from(afhx.a(this.a)).inflate(2131496938, null);
    }
    int j;
    int i;
    switch (paramInt)
    {
    case 4: 
    default: 
      j = 2130838728;
      i = 2131653605;
      paramInt = 2131654157;
    }
    for (;;)
    {
      paramView = (ImageView)paramViewGroup.findViewById(2131297128);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131297140);
      paramView.setImageResource(j);
      localTextView.setText(i);
      if (AppSetting.c) {
        paramViewGroup.setContentDescription(afhx.a(this.a).getString(paramInt));
      }
      return paramViewGroup;
      i = 2131653620;
      j = 2130838732;
      paramInt = 2131654173;
      continue;
      i = 2131653622;
      j = 2130838733;
      paramInt = 2131654174;
      continue;
      i = 2131653628;
      j = 2130838736;
      paramInt = 2131654181;
      continue;
      i = 2131653617;
      j = 2130838730;
      paramInt = 2131654164;
      continue;
      paramInt = 2131651399;
      i = 2131651399;
      j = 2130841846;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afhz
 * JD-Core Version:    0.7.0.1
 */
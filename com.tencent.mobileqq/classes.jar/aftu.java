import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;

class aftu
  extends BaseAdapter
{
  private aftu(afts paramafts) {}
  
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
      paramViewGroup = LayoutInflater.from(afts.a(this.a)).inflate(2131562537, null);
    }
    int j;
    int i;
    switch (paramInt)
    {
    case 4: 
    default: 
      j = 2130838750;
      i = 2131719499;
      paramInt = 2131720058;
    }
    for (;;)
    {
      paramView = (ImageView)paramViewGroup.findViewById(2131362667);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131362679);
      paramView.setImageResource(j);
      localTextView.setText(i);
      if (AppSetting.d) {
        paramViewGroup.setContentDescription(afts.a(this.a).getString(paramInt));
      }
      return paramViewGroup;
      i = 2131719514;
      j = 2130838754;
      paramInt = 2131720074;
      continue;
      i = 2131719516;
      j = 2130838755;
      paramInt = 2131720075;
      continue;
      i = 2131719522;
      j = 2130838758;
      paramInt = 2131720082;
      continue;
      i = 2131719511;
      j = 2130838752;
      paramInt = 2131720065;
      continue;
      paramInt = 2131717202;
      i = 2131717202;
      j = 2130841940;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aftu
 * JD-Core Version:    0.7.0.1
 */
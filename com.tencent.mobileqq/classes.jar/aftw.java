import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;

class aftw
  extends BaseAdapter
{
  private aftw(aftu paramaftu) {}
  
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
      paramViewGroup = LayoutInflater.from(aftu.a(this.a)).inflate(2131562538, null);
    }
    int j;
    int i;
    switch (paramInt)
    {
    case 4: 
    default: 
      j = 2130838750;
      i = 2131719488;
      paramInt = 2131720047;
    }
    for (;;)
    {
      paramView = (ImageView)paramViewGroup.findViewById(2131362668);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131362680);
      paramView.setImageResource(j);
      localTextView.setText(i);
      if (AppSetting.d) {
        paramViewGroup.setContentDescription(aftu.a(this.a).getString(paramInt));
      }
      return paramViewGroup;
      i = 2131719503;
      j = 2130838754;
      paramInt = 2131720063;
      continue;
      i = 2131719505;
      j = 2130838755;
      paramInt = 2131720064;
      continue;
      i = 2131719511;
      j = 2130838758;
      paramInt = 2131720071;
      continue;
      i = 2131719500;
      j = 2130838752;
      paramInt = 2131720054;
      continue;
      paramInt = 2131717191;
      i = 2131717191;
      j = 2130841940;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aftw
 * JD-Core Version:    0.7.0.1
 */
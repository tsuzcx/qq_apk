import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;

class ahrm
  extends BaseAdapter
{
  private ahrm(ahrk paramahrk) {}
  
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
      paramViewGroup = LayoutInflater.from(ahrk.a(this.a)).inflate(2131562740, null);
    }
    int j;
    int i;
    switch (paramInt)
    {
    case 4: 
    default: 
      j = 2130838912;
      i = 2131720031;
      paramInt = 2131720594;
    }
    for (;;)
    {
      paramView = (ImageView)paramViewGroup.findViewById(2131362695);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131362707);
      paramView.setImageResource(j);
      localTextView.setText(i);
      if (AppSetting.c) {
        paramViewGroup.setContentDescription(ahrk.a(this.a).getString(paramInt));
      }
      return paramViewGroup;
      i = 2131720046;
      j = 2130838916;
      paramInt = 2131720610;
      continue;
      i = 2131720048;
      j = 2130838917;
      paramInt = 2131720611;
      continue;
      i = 2131720054;
      j = 2130838920;
      paramInt = 2131720618;
      continue;
      i = 2131720043;
      j = 2130838914;
      paramInt = 2131720601;
      continue;
      paramInt = 2131717574;
      i = 2131717574;
      j = 2130842092;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrm
 * JD-Core Version:    0.7.0.1
 */
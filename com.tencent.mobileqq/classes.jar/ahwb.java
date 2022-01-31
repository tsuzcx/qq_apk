import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;

class ahwb
  extends BaseAdapter
{
  private ahwb(ahvz paramahvz) {}
  
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
      paramViewGroup = LayoutInflater.from(ahvz.a(this.a)).inflate(2131562758, null);
    }
    int j;
    int i;
    switch (paramInt)
    {
    case 4: 
    default: 
      j = 2130838913;
      i = 2131720043;
      paramInt = 2131720606;
    }
    for (;;)
    {
      paramView = (ImageView)paramViewGroup.findViewById(2131362695);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131362707);
      paramView.setImageResource(j);
      localTextView.setText(i);
      if (AppSetting.c) {
        paramViewGroup.setContentDescription(ahvz.a(this.a).getString(paramInt));
      }
      return paramViewGroup;
      i = 2131720058;
      j = 2130838917;
      paramInt = 2131720622;
      continue;
      i = 2131720060;
      j = 2130838918;
      paramInt = 2131720623;
      continue;
      i = 2131720066;
      j = 2130838921;
      paramInt = 2131720630;
      continue;
      i = 2131720055;
      j = 2130838915;
      paramInt = 2131720613;
      continue;
      paramInt = 2131717586;
      i = 2131717586;
      j = 2130842105;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahwb
 * JD-Core Version:    0.7.0.1
 */
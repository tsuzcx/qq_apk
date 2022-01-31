import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.widget.AbsListView.LayoutParams;

public class ajlj
  extends ajju
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public View a(int paramInt, Object paramObject, ajjp paramajjp, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajlm paramajlm)
  {
    int i;
    if (paramView == null)
    {
      paramajjp = null;
      if (!"TroopAssistantEmptyItemBuilder".equals(paramajjp))
      {
        paramView = View.inflate(paramContext, 2131562747, null);
        paramView.setTag("TroopAssistantEmptyItemBuilder");
        paramajjp = paramContext.getResources();
        this.b = paramajjp.getDimensionPixelSize(2131298633);
        this.a = paramajjp.getDimensionPixelSize(2131298638);
        this.c = paramajjp.getDimensionPixelSize(2131298640);
        i = paramajjp.getDimensionPixelSize(2131298942);
        this.d = (paramajjp.getDimensionPixelSize(2131298943) + i);
      }
      i = paramViewGroup.getMeasuredHeight() - this.a - this.b - 10 - this.d;
      if (i <= this.c) {
        break label210;
      }
      label124:
      paramajjp = new AbsListView.LayoutParams(-1, -1);
      paramajjp.width = -1;
      paramajjp.height = i;
      paramView.setLayoutParams(paramajjp);
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        paramajjp = (TextView)paramView.findViewById(2131378342);
        if (paramObject.intValue() != 4) {
          break label219;
        }
        paramajjp.setText(2131720976);
      }
    }
    for (;;)
    {
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
      paramajjp = paramView.getTag();
      break;
      label210:
      i = this.c;
      break label124;
      label219:
      paramajjp.setText(2131695289);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajlj
 * JD-Core Version:    0.7.0.1
 */
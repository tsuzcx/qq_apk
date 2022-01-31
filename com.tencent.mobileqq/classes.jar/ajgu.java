import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.widget.AbsListView.LayoutParams;

public class ajgu
  extends ajff
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public View a(int paramInt, Object paramObject, ajfa paramajfa, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajgx paramajgx)
  {
    int i;
    if (paramView == null)
    {
      paramajfa = null;
      if (!"TroopAssistantEmptyItemBuilder".equals(paramajfa))
      {
        paramView = View.inflate(paramContext, 2131562729, null);
        paramView.setTag("TroopAssistantEmptyItemBuilder");
        paramajfa = paramContext.getResources();
        this.b = paramajfa.getDimensionPixelSize(2131298633);
        this.a = paramajfa.getDimensionPixelSize(2131298638);
        this.c = paramajfa.getDimensionPixelSize(2131298640);
        i = paramajfa.getDimensionPixelSize(2131298942);
        this.d = (paramajfa.getDimensionPixelSize(2131298943) + i);
      }
      i = paramViewGroup.getMeasuredHeight() - this.a - this.b - 10 - this.d;
      if (i <= this.c) {
        break label210;
      }
      label124:
      paramajfa = new AbsListView.LayoutParams(-1, -1);
      paramajfa.width = -1;
      paramajfa.height = i;
      paramView.setLayoutParams(paramajfa);
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        paramajfa = (TextView)paramView.findViewById(2131378288);
        if (paramObject.intValue() != 4) {
          break label219;
        }
        paramajfa.setText(2131720964);
      }
    }
    for (;;)
    {
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
      paramajfa = paramView.getTag();
      break;
      label210:
      i = this.c;
      break label124;
      label219:
      paramajfa.setText(2131695287);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgu
 * JD-Core Version:    0.7.0.1
 */
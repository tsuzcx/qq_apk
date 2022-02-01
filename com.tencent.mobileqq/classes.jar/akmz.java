import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.widget.AbsListView.LayoutParams;

public class akmz
  extends akll
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public View a(int paramInt, Object paramObject, aklg paramaklg, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, aknm paramaknm)
  {
    int i;
    if (paramView == null)
    {
      paramaklg = null;
      if (!"TroopAssistantEmptyItemBuilder".equals(paramaklg))
      {
        paramView = View.inflate(paramContext, 2131562900, null);
        paramView.setTag("TroopAssistantEmptyItemBuilder");
        paramaklg = paramContext.getResources();
        this.b = paramaklg.getDimensionPixelSize(2131298793);
        this.a = paramaklg.getDimensionPixelSize(2131298798);
        this.c = paramaklg.getDimensionPixelSize(2131298800);
        i = paramaklg.getDimensionPixelSize(2131299104);
        this.d = (paramaklg.getDimensionPixelSize(2131299105) + i);
      }
      i = paramViewGroup.getMeasuredHeight() - this.a - this.b - 10 - this.d;
      if (i <= this.c) {
        break label210;
      }
      label124:
      paramaklg = new AbsListView.LayoutParams(-1, -1);
      paramaklg.width = -1;
      paramaklg.height = i;
      paramView.setLayoutParams(paramaklg);
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        paramaklg = (TextView)paramView.findViewById(2131379128);
        if (paramObject.intValue() != 4) {
          break label219;
        }
        paramaklg.setText(2131719091);
      }
    }
    for (;;)
    {
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
      paramaklg = paramView.getTag();
      break;
      label210:
      i = this.c;
      break label124;
      label219:
      paramaklg.setText(2131694452);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akmz
 * JD-Core Version:    0.7.0.1
 */
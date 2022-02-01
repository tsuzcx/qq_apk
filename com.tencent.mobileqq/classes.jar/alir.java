import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.widget.AbsListView.LayoutParams;

public class alir
  extends alhd
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public View a(int paramInt, Object paramObject, algy paramalgy, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alje paramalje)
  {
    int i;
    if (paramView == null)
    {
      paramalgy = null;
      if (!"TroopAssistantEmptyItemBuilder".equals(paramalgy))
      {
        paramView = View.inflate(paramContext, 2131562974, null);
        paramView.setTag("TroopAssistantEmptyItemBuilder");
        paramalgy = paramContext.getResources();
        this.b = paramalgy.getDimensionPixelSize(2131298797);
        this.a = paramalgy.getDimensionPixelSize(2131298802);
        this.c = paramalgy.getDimensionPixelSize(2131298804);
        i = paramalgy.getDimensionPixelSize(2131299110);
        this.d = (paramalgy.getDimensionPixelSize(2131299111) + i);
      }
      i = paramViewGroup.getMeasuredHeight() - this.a - this.b - 10 - this.d;
      if (i <= this.c) {
        break label210;
      }
      label124:
      paramalgy = new AbsListView.LayoutParams(-1, -1);
      paramalgy.width = -1;
      paramalgy.height = i;
      paramView.setLayoutParams(paramalgy);
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        paramalgy = (TextView)paramView.findViewById(2131379423);
        if (paramObject.intValue() != 4) {
          break label219;
        }
        paramalgy.setText(2131719496);
      }
    }
    for (;;)
    {
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
      paramalgy = paramView.getTag();
      break;
      label210:
      i = this.c;
      break label124;
      label219:
      paramalgy.setText(2131694653);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alir
 * JD-Core Version:    0.7.0.1
 */
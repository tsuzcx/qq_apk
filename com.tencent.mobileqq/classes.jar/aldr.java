import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.widget.AbsListView.LayoutParams;

public class aldr
  extends alcd
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public View a(int paramInt, Object paramObject, alby paramalby, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, aled paramaled)
  {
    int i;
    if (paramView == null)
    {
      paramalby = null;
      if (!"TroopAssistantEmptyItemBuilder".equals(paramalby))
      {
        paramView = View.inflate(paramContext, 2131562986, null);
        paramView.setTag("TroopAssistantEmptyItemBuilder");
        paramalby = paramContext.getResources();
        this.b = paramalby.getDimensionPixelSize(2131298715);
        this.a = paramalby.getDimensionPixelSize(2131298720);
        this.c = paramalby.getDimensionPixelSize(2131298722);
        i = paramalby.getDimensionPixelSize(2131299026);
        this.d = (paramalby.getDimensionPixelSize(2131299027) + i);
      }
      i = paramViewGroup.getMeasuredHeight() - this.a - this.b - 10 - this.d;
      if (i <= this.c) {
        break label210;
      }
      label124:
      paramalby = new AbsListView.LayoutParams(-1, -1);
      paramalby.width = -1;
      paramalby.height = i;
      paramView.setLayoutParams(paramalby);
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        paramalby = (TextView)paramView.findViewById(2131379193);
        if (paramObject.intValue() != 4) {
          break label219;
        }
        paramalby.setText(2131718706);
      }
    }
    for (;;)
    {
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
      paramalby = paramView.getTag();
      break;
      label210:
      i = this.c;
      break label124;
      label219:
      paramalby.setText(2131694296);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aldr
 * JD-Core Version:    0.7.0.1
 */
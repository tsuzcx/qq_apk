import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.widget.AbsListView.LayoutParams;

public class ahpn
  extends ahny
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public View a(int paramInt, Object paramObject, ahnt paramahnt, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpq paramahpq)
  {
    int i;
    if (paramView == null)
    {
      paramahnt = null;
      if (!"TroopAssistantEmptyItemBuilder".equals(paramahnt))
      {
        paramView = View.inflate(paramContext, 2131562527, null);
        paramView.setTag("TroopAssistantEmptyItemBuilder");
        paramahnt = paramContext.getResources();
        this.b = paramahnt.getDimensionPixelSize(2131298605);
        this.a = paramahnt.getDimensionPixelSize(2131298610);
        this.c = paramahnt.getDimensionPixelSize(2131298612);
        i = paramahnt.getDimensionPixelSize(2131298893);
        this.d = (paramahnt.getDimensionPixelSize(2131298894) + i);
      }
      i = paramViewGroup.getMeasuredHeight() - this.a - this.b - 10 - this.d;
      if (i <= this.c) {
        break label210;
      }
      label124:
      paramahnt = new AbsListView.LayoutParams(-1, -1);
      paramahnt.width = -1;
      paramahnt.height = i;
      paramView.setLayoutParams(paramahnt);
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        paramahnt = (TextView)paramView.findViewById(2131377743);
        if (paramObject.intValue() != 4) {
          break label219;
        }
        paramahnt.setText(2131720415);
      }
    }
    for (;;)
    {
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
      paramahnt = paramView.getTag();
      break;
      label210:
      i = this.c;
      break label124;
      label219:
      paramahnt.setText(2131695128);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahpn
 * JD-Core Version:    0.7.0.1
 */
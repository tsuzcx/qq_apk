import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.widget.AbsListView.LayoutParams;

public class alpi
  extends alnt
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public View a(int paramInt, Object paramObject, alno paramalno, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alpv paramalpv)
  {
    int i;
    if (paramView == null)
    {
      paramalno = null;
      if (!"TroopAssistantEmptyItemBuilder".equals(paramalno))
      {
        paramView = View.inflate(paramContext, 2131563020, null);
        paramView.setTag("TroopAssistantEmptyItemBuilder");
        paramalno = paramContext.getResources();
        this.b = paramalno.getDimensionPixelSize(2131298728);
        this.a = paramalno.getDimensionPixelSize(2131298733);
        this.c = paramalno.getDimensionPixelSize(2131298735);
        i = paramalno.getDimensionPixelSize(2131299039);
        this.d = (paramalno.getDimensionPixelSize(2131299040) + i);
      }
      i = paramViewGroup.getMeasuredHeight() - this.a - this.b - 10 - this.d;
      if (i <= this.c) {
        break label210;
      }
      label124:
      paramalno = new AbsListView.LayoutParams(-1, -1);
      paramalno.width = -1;
      paramalno.height = i;
      paramView.setLayoutParams(paramalno);
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        paramalno = (TextView)paramView.findViewById(2131379358);
        if (paramObject.intValue() != 4) {
          break label219;
        }
        paramalno.setText(2131718842);
      }
    }
    for (;;)
    {
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
      paramalno = paramView.getTag();
      break;
      label210:
      i = this.c;
      break label124;
      label219:
      paramalno.setText(2131694338);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alpi
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.widget.AbsListView.LayoutParams;

public class ahcy
  extends ahbj
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public View a(int paramInt, Object paramObject, ahbe paramahbe, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahdb paramahdb)
  {
    int i;
    if (paramView == null)
    {
      paramahbe = null;
      if (!"TroopAssistantEmptyItemBuilder".equals(paramahbe))
      {
        paramView = View.inflate(paramContext, 2131496927, null);
        paramView.setTag("TroopAssistantEmptyItemBuilder");
        paramahbe = paramContext.getResources();
        this.b = paramahbe.getDimensionPixelSize(2131167512);
        this.a = paramahbe.getDimensionPixelSize(2131167517);
        this.c = paramahbe.getDimensionPixelSize(2131167519);
        i = paramahbe.getDimensionPixelSize(2131167794);
        this.d = (paramahbe.getDimensionPixelSize(2131167795) + i);
      }
      i = paramViewGroup.getMeasuredHeight() - this.a - this.b - 10 - this.d;
      if (i <= this.c) {
        break label210;
      }
      label124:
      paramahbe = new AbsListView.LayoutParams(-1, -1);
      paramahbe.width = -1;
      paramahbe.height = i;
      paramView.setLayoutParams(paramahbe);
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        paramahbe = (TextView)paramView.findViewById(2131311922);
        if (paramObject.intValue() != 4) {
          break label219;
        }
        paramahbe.setText(2131654519);
      }
    }
    for (;;)
    {
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
      paramahbe = paramView.getTag();
      break;
      label210:
      i = this.c;
      break label124;
      label219:
      paramahbe.setText(2131629447);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahcy
 * JD-Core Version:    0.7.0.1
 */
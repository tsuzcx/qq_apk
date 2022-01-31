import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.widget.AbsListView.LayoutParams;

public class ahpl
  extends ahnw
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public View a(int paramInt, Object paramObject, ahnr paramahnr, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpo paramahpo)
  {
    int i;
    if (paramView == null)
    {
      paramahnr = null;
      if (!"TroopAssistantEmptyItemBuilder".equals(paramahnr))
      {
        paramView = View.inflate(paramContext, 2131562526, null);
        paramView.setTag("TroopAssistantEmptyItemBuilder");
        paramahnr = paramContext.getResources();
        this.b = paramahnr.getDimensionPixelSize(2131298605);
        this.a = paramahnr.getDimensionPixelSize(2131298610);
        this.c = paramahnr.getDimensionPixelSize(2131298612);
        i = paramahnr.getDimensionPixelSize(2131298893);
        this.d = (paramahnr.getDimensionPixelSize(2131298894) + i);
      }
      i = paramViewGroup.getMeasuredHeight() - this.a - this.b - 10 - this.d;
      if (i <= this.c) {
        break label210;
      }
      label124:
      paramahnr = new AbsListView.LayoutParams(-1, -1);
      paramahnr.width = -1;
      paramahnr.height = i;
      paramView.setLayoutParams(paramahnr);
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        paramahnr = (TextView)paramView.findViewById(2131377743);
        if (paramObject.intValue() != 4) {
          break label219;
        }
        paramahnr.setText(2131720426);
      }
    }
    for (;;)
    {
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
      paramahnr = paramView.getTag();
      break;
      label210:
      i = this.c;
      break label124;
      label219:
      paramahnr.setText(2131695129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahpl
 * JD-Core Version:    0.7.0.1
 */
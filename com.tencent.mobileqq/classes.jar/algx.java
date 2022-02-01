import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.widget.AbsListView.LayoutParams;

public class algx
  extends alhd
{
  private int a;
  private int b;
  private int c;
  
  public View a(int paramInt, Object paramObject, algy paramalgy, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alje paramalje)
  {
    if (paramView != null)
    {
      paramalgy = paramView;
      if ("R.layout.conversation_no_chat".equals(paramView.getTag(2131559007))) {}
    }
    else
    {
      paramalgy = View.inflate(paramContext, 2131559007, null);
      this.b = paramContext.getResources().getDimensionPixelSize(2131298797);
      this.a = paramContext.getResources().getDimensionPixelSize(2131298800);
      this.c = paramContext.getResources().getDimensionPixelSize(2131298804);
    }
    int i = paramViewGroup.getHeight() - this.a * 2 - this.b;
    if (i > this.c)
    {
      paramView = new AbsListView.LayoutParams(-1, -1);
      paramView.width = -1;
      paramView.height = i;
      paramalgy.setLayoutParams(paramView);
      paramalgy.setTag(Boolean.valueOf(true));
      paramView = (TextView)paramalgy.findViewById(2131372004);
      paramViewGroup = (Button)paramalgy.findViewById(2131363813);
      if (!(paramObject instanceof Integer)) {
        break label382;
      }
      i = ((Integer)paramObject).intValue();
      if (i != 1) {
        break label263;
      }
      paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130841420, 0, 0);
      paramView.setVisibility(0);
      paramView.setText(2131694653);
      paramView.setTextColor(paramContext.getResources().getColorStateList(2131167112));
      paramViewGroup.setVisibility(8);
      paramViewGroup.setOnClickListener(null);
    }
    for (;;)
    {
      paramalgy.setTag(-1, Integer.valueOf(paramInt));
      paramalgy.setTag(2131559007, "R.layout.conversation_no_chat");
      return paramalgy;
      i = this.c;
      break;
      label263:
      if (i == 0)
      {
        if ((paramContext instanceof MsgBoxListActivity))
        {
          if (((MsgBoxListActivity)paramContext).f)
          {
            paramView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            paramView.setVisibility(0);
            paramView.setText("");
          }
        }
        else
        {
          paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130841420, 0, 0);
          paramView.setVisibility(0);
          paramView.setText(2131694296);
          paramView.setTextColor(paramContext.getResources().getColorStateList(2131167112));
          paramViewGroup.setVisibility(8);
          paramViewGroup.setOnClickListener(null);
        }
      }
      else
      {
        paramView.setVisibility(4);
        paramView.setText("");
        continue;
        label382:
        paramView.setVisibility(8);
        paramView.setText("");
        paramViewGroup.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     algx
 * JD-Core Version:    0.7.0.1
 */
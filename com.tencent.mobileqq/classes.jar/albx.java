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

public class albx
  extends alcd
{
  private int a;
  private int b;
  private int c;
  
  public View a(int paramInt, Object paramObject, alby paramalby, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, aled paramaled)
  {
    if (paramView != null)
    {
      paramalby = paramView;
      if ("R.layout.conversation_no_chat".equals(paramView.getTag(2131558973))) {}
    }
    else
    {
      paramalby = View.inflate(paramContext, 2131558973, null);
      this.b = paramContext.getResources().getDimensionPixelSize(2131298715);
      this.a = paramContext.getResources().getDimensionPixelSize(2131298718);
      this.c = paramContext.getResources().getDimensionPixelSize(2131298722);
    }
    int i = paramViewGroup.getHeight() - this.a * 2 - this.b;
    if (i > this.c)
    {
      paramView = new AbsListView.LayoutParams(-1, -1);
      paramView.width = -1;
      paramView.height = i;
      paramalby.setLayoutParams(paramView);
      paramalby.setTag(Boolean.valueOf(true));
      paramView = (TextView)paramalby.findViewById(2131371741);
      paramViewGroup = (Button)paramalby.findViewById(2131363688);
      if (!(paramObject instanceof Integer)) {
        break label382;
      }
      i = ((Integer)paramObject).intValue();
      if (i != 1) {
        break label263;
      }
      paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130841368, 0, 0);
      paramView.setVisibility(0);
      paramView.setText(2131694296);
      paramView.setTextColor(paramContext.getResources().getColorStateList(2131167066));
      paramViewGroup.setVisibility(8);
      paramViewGroup.setOnClickListener(null);
    }
    for (;;)
    {
      paramalby.setTag(-1, Integer.valueOf(paramInt));
      paramalby.setTag(2131558973, "R.layout.conversation_no_chat");
      return paramalby;
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
          paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130841368, 0, 0);
          paramView.setVisibility(0);
          paramView.setText(2131693982);
          paramView.setTextColor(paramContext.getResources().getColorStateList(2131167066));
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
 * Qualified Name:     albx
 * JD-Core Version:    0.7.0.1
 */
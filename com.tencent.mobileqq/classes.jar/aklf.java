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

public class aklf
  extends akll
{
  private int a;
  private int b;
  private int c;
  
  public View a(int paramInt, Object paramObject, aklg paramaklg, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, aknm paramaknm)
  {
    if (paramView != null)
    {
      paramaklg = paramView;
      if ("R.layout.conversation_no_chat".equals(paramView.getTag(2131558980))) {}
    }
    else
    {
      paramaklg = View.inflate(paramContext, 2131558980, null);
      this.b = paramContext.getResources().getDimensionPixelSize(2131298793);
      this.a = paramContext.getResources().getDimensionPixelSize(2131298796);
      this.c = paramContext.getResources().getDimensionPixelSize(2131298800);
    }
    int i = paramViewGroup.getHeight() - this.a * 2 - this.b;
    if (i > this.c)
    {
      paramView = new AbsListView.LayoutParams(-1, -1);
      paramView.width = -1;
      paramView.height = i;
      paramaklg.setLayoutParams(paramView);
      paramaklg.setTag(Boolean.valueOf(true));
      paramView = (TextView)paramaklg.findViewById(2131371814);
      paramViewGroup = (Button)paramaklg.findViewById(2131363742);
      if (!(paramObject instanceof Integer)) {
        break label382;
      }
      i = ((Integer)paramObject).intValue();
      if (i != 1) {
        break label263;
      }
      paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130841414, 0, 0);
      paramView.setVisibility(0);
      paramView.setText(2131694452);
      paramView.setTextColor(paramContext.getResources().getColorStateList(2131167098));
      paramViewGroup.setVisibility(8);
      paramViewGroup.setOnClickListener(null);
    }
    for (;;)
    {
      paramaklg.setTag(-1, Integer.valueOf(paramInt));
      paramaklg.setTag(2131558980, "R.layout.conversation_no_chat");
      return paramaklg;
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
          paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130841414, 0, 0);
          paramView.setVisibility(0);
          paramView.setText(2131694099);
          paramView.setTextColor(paramContext.getResources().getColorStateList(2131167098));
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
 * Qualified Name:     aklf
 * JD-Core Version:    0.7.0.1
 */
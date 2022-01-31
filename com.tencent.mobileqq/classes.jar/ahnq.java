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

public class ahnq
  extends ahnw
{
  private int a;
  private int b;
  private int c;
  
  public View a(int paramInt, Object paramObject, ahnr paramahnr, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpo paramahpo)
  {
    if (paramView != null)
    {
      paramahnr = paramView;
      if ("R.layout.conversation_no_chat".equals(paramView.getTag(2131558871))) {}
    }
    else
    {
      paramahnr = View.inflate(paramContext, 2131558871, null);
      this.b = paramContext.getResources().getDimensionPixelSize(2131298605);
      this.a = paramContext.getResources().getDimensionPixelSize(2131298608);
      this.c = paramContext.getResources().getDimensionPixelSize(2131298612);
    }
    int i = paramViewGroup.getHeight() - this.a * 2 - this.b;
    if (i > this.c)
    {
      paramView = new AbsListView.LayoutParams(-1, -1);
      paramView.width = -1;
      paramView.height = i;
      paramahnr.setLayoutParams(paramView);
      paramahnr.setTag(Boolean.valueOf(true));
      paramView = (TextView)paramahnr.findViewById(2131370851);
      paramViewGroup = (Button)paramahnr.findViewById(2131363450);
      if (!(paramObject instanceof Integer)) {
        break label382;
      }
      i = ((Integer)paramObject).intValue();
      if (i != 1) {
        break label263;
      }
      paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130840999, 0, 0);
      paramView.setVisibility(0);
      paramView.setText(2131695129);
      paramView.setTextColor(paramContext.getResources().getColorStateList(2131166933));
      paramViewGroup.setVisibility(8);
      paramViewGroup.setOnClickListener(null);
    }
    for (;;)
    {
      paramahnr.setTag(-1, Integer.valueOf(paramInt));
      paramahnr.setTag(2131558871, "R.layout.conversation_no_chat");
      return paramahnr;
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
          paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130840999, 0, 0);
          paramView.setVisibility(0);
          paramView.setText(2131694659);
          paramView.setTextColor(paramContext.getResources().getColorStateList(2131166933));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahnq
 * JD-Core Version:    0.7.0.1
 */
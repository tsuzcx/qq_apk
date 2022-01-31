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

public class ahbd
  extends ahbj
{
  private int a;
  private int b;
  private int c;
  
  public View a(int paramInt, Object paramObject, ahbe paramahbe, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahdb paramahdb)
  {
    if (paramView != null)
    {
      paramahbe = paramView;
      if ("R.layout.conversation_no_chat".equals(paramView.getTag(2131493311))) {}
    }
    else
    {
      paramahbe = View.inflate(paramContext, 2131493311, null);
      this.b = paramContext.getResources().getDimensionPixelSize(2131167512);
      this.a = paramContext.getResources().getDimensionPixelSize(2131167515);
      this.c = paramContext.getResources().getDimensionPixelSize(2131167519);
    }
    int i = paramViewGroup.getHeight() - this.a * 2 - this.b;
    if (i > this.c)
    {
      paramView = new AbsListView.LayoutParams(-1, -1);
      paramView.width = -1;
      paramView.height = i;
      paramahbe.setLayoutParams(paramView);
      paramahbe.setTag(Boolean.valueOf(true));
      paramView = (TextView)paramahbe.findViewById(2131305178);
      paramViewGroup = (Button)paramahbe.findViewById(2131297905);
      if (!(paramObject instanceof Integer)) {
        break label382;
      }
      i = ((Integer)paramObject).intValue();
      if (i != 1) {
        break label263;
      }
      paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130840935, 0, 0);
      paramView.setVisibility(0);
      paramView.setText(2131629447);
      paramView.setTextColor(paramContext.getResources().getColorStateList(2131101338));
      paramViewGroup.setVisibility(8);
      paramViewGroup.setOnClickListener(null);
    }
    for (;;)
    {
      paramahbe.setTag(-1, Integer.valueOf(paramInt));
      paramahbe.setTag(2131493311, "R.layout.conversation_no_chat");
      return paramahbe;
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
          paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130840935, 0, 0);
          paramView.setVisibility(0);
          paramView.setText(2131628994);
          paramView.setTextColor(paramContext.getResources().getColorStateList(2131101338));
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
 * Qualified Name:     ahbd
 * JD-Core Version:    0.7.0.1
 */
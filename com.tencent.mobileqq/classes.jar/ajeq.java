import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.widget.SingleLineTextView;

public class ajeq
  extends ajex
{
  public View a(int paramInt, Object paramObject, ajfa paramajfa, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajgx paramajgx)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof ajey))) {}
    paramObject = super.a(paramInt, paramObject, paramajfa, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramajgx);
    paramajfa = (ajey)paramObject.getTag();
    paramViewGroup = paramContext.getResources();
    paramView = paramViewGroup.getColorStateList(2131166975);
    paramViewGroup = paramViewGroup.getColorStateList(2131166901);
    paramajfa.a.setTextColor(paramViewGroup);
    paramajfa.b.setTextColor(paramView);
    paramajfa.a.setExtendTextColor(paramView, 0);
    paramObject.findViewById(2131375577).setBackgroundResource(2130839213);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajeq
 * JD-Core Version:    0.7.0.1
 */
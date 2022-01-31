import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.widget.SingleLineTextView;

public class ajjf
  extends ajjm
{
  public View a(int paramInt, Object paramObject, ajjp paramajjp, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajlm paramajlm)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof ajjn))) {}
    paramObject = super.a(paramInt, paramObject, paramajjp, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramajlm);
    paramajjp = (ajjn)paramObject.getTag();
    paramViewGroup = paramContext.getResources();
    paramView = paramViewGroup.getColorStateList(2131166977);
    paramViewGroup = paramViewGroup.getColorStateList(2131166903);
    paramajjp.a.setTextColor(paramViewGroup);
    paramajjp.b.setTextColor(paramView);
    paramajjp.a.setExtendTextColor(paramView, 0);
    paramObject.findViewById(2131375628).setBackgroundResource(2130839214);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjf
 * JD-Core Version:    0.7.0.1
 */
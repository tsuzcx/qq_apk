import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.widget.SingleLineTextView;

public class akkw
  extends akld
{
  public View a(int paramInt, Object paramObject, aklg paramaklg, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, aknm paramaknm)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof akle))) {}
    paramObject = super.a(paramInt, paramObject, paramaklg, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramaknm);
    paramaklg = (akle)paramObject.getTag();
    paramViewGroup = paramContext.getResources();
    paramView = paramViewGroup.getColorStateList(2131167092);
    paramViewGroup = paramViewGroup.getColorStateList(2131167012);
    paramaklg.a.setTextColor(paramViewGroup);
    paramaklg.b.setTextColor(paramView);
    paramaklg.a.setExtendTextColor(paramView, 0);
    paramObject.findViewById(2131376253).setBackgroundResource(2130839434);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akkw
 * JD-Core Version:    0.7.0.1
 */
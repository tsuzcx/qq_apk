import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.widget.SingleLineTextView;

public class ahnh
  extends ahno
{
  public View a(int paramInt, Object paramObject, ahnr paramahnr, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpo paramahpo)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof ahnp))) {}
    paramObject = super.a(paramInt, paramObject, paramahnr, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramahpo);
    paramahnr = (ahnp)paramObject.getTag();
    paramViewGroup = paramContext.getResources();
    paramView = paramViewGroup.getColorStateList(2131166928);
    paramViewGroup = paramViewGroup.getColorStateList(2131166854);
    paramahnr.a.setTextColor(paramViewGroup);
    paramahnr.b.setTextColor(paramView);
    paramahnr.a.setExtendTextColor(paramView, 0);
    paramObject.findViewById(2131375097).setBackgroundResource(2130839129);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahnh
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.widget.SingleLineTextView;

public class ahnj
  extends ahnq
{
  public View a(int paramInt, Object paramObject, ahnt paramahnt, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpq paramahpq)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof ahnr))) {}
    paramObject = super.a(paramInt, paramObject, paramahnt, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramahpq);
    paramahnt = (ahnr)paramObject.getTag();
    paramViewGroup = paramContext.getResources();
    paramView = paramViewGroup.getColorStateList(2131166928);
    paramViewGroup = paramViewGroup.getColorStateList(2131166854);
    paramahnt.a.setTextColor(paramViewGroup);
    paramahnt.b.setTextColor(paramView);
    paramahnt.a.setExtendTextColor(paramView, 0);
    paramObject.findViewById(2131375095).setBackgroundResource(2130839129);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahnj
 * JD-Core Version:    0.7.0.1
 */
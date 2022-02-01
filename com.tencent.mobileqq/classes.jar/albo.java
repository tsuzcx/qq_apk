import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.widget.SingleLineTextView;

public class albo
  extends albv
{
  public View a(int paramInt, Object paramObject, alby paramalby, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, aled paramaled)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof albw))) {}
    paramObject = super.a(paramInt, paramObject, paramalby, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramaled);
    paramalby = (albw)paramObject.getTag();
    paramViewGroup = paramContext.getResources();
    paramView = paramViewGroup.getColorStateList(2131167060);
    paramViewGroup = paramViewGroup.getColorStateList(2131166986);
    paramalby.a.setTextColor(paramViewGroup);
    paramalby.b.setTextColor(paramView);
    paramalby.a.setExtendTextColor(paramView, 0);
    paramObject.findViewById(2131376353).setBackgroundResource(2130839391);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     albo
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.widget.SingleLineTextView;

public class ahau
  extends ahbb
{
  public View a(int paramInt, Object paramObject, ahbe paramahbe, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahdb paramahdb)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof ahbc))) {}
    paramObject = super.a(paramInt, paramObject, paramahbe, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramahdb);
    paramahbe = (ahbc)paramObject.getTag();
    paramViewGroup = paramContext.getResources();
    paramView = paramViewGroup.getColorStateList(2131101333);
    paramViewGroup = paramViewGroup.getColorStateList(2131101260);
    paramahbe.a.setTextColor(paramViewGroup);
    paramahbe.b.setTextColor(paramView);
    paramahbe.a.setExtendTextColor(paramView, 0);
    paramObject.findViewById(2131309349).setBackgroundResource(2130839101);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahau
 * JD-Core Version:    0.7.0.1
 */
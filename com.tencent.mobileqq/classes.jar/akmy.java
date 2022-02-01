import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;

@Deprecated
public class akmy
  extends akll
{
  public View a(int paramInt, Object paramObject, aklg paramaklg, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, aknm paramaknm)
  {
    paramObject = paramView;
    if (paramView == null) {
      paramObject = View.inflate(paramContext, 2131562902, null);
    }
    paramaklg = paramObject.findViewById(2131379126);
    paramaklg.setTag(-1, Integer.valueOf(paramInt));
    paramaklg.setOnClickListener(paramOnClickListener);
    paramaklg = paramObject.findViewById(2131379125);
    paramaklg.setTag(-1, Integer.valueOf(paramInt));
    paramaklg.setOnClickListener(paramOnClickListener);
    paramObject.setTag(-1, Integer.valueOf(paramInt));
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akmy
 * JD-Core Version:    0.7.0.1
 */
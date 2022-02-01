import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;

@Deprecated
public class aldq
  extends alcd
{
  public View a(int paramInt, Object paramObject, alby paramalby, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, aled paramaled)
  {
    paramObject = paramView;
    if (paramView == null) {
      paramObject = View.inflate(paramContext, 2131562988, null);
    }
    paramalby = paramObject.findViewById(2131379191);
    paramalby.setTag(-1, Integer.valueOf(paramInt));
    paramalby.setOnClickListener(paramOnClickListener);
    paramalby = paramObject.findViewById(2131379190);
    paramalby.setTag(-1, Integer.valueOf(paramInt));
    paramalby.setOnClickListener(paramOnClickListener);
    paramObject.setTag(-1, Integer.valueOf(paramInt));
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aldq
 * JD-Core Version:    0.7.0.1
 */
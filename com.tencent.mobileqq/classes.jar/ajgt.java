import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;

@Deprecated
public class ajgt
  extends ajff
{
  public View a(int paramInt, Object paramObject, ajfa paramajfa, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajgx paramajgx)
  {
    paramObject = paramView;
    if (paramView == null) {
      paramObject = View.inflate(paramContext, 2131562731, null);
    }
    paramajfa = paramObject.findViewById(2131378286);
    paramajfa.setTag(-1, Integer.valueOf(paramInt));
    paramajfa.setOnClickListener(paramOnClickListener);
    paramajfa = paramObject.findViewById(2131378285);
    paramajfa.setTag(-1, Integer.valueOf(paramInt));
    paramajfa.setOnClickListener(paramOnClickListener);
    paramObject.setTag(-1, Integer.valueOf(paramInt));
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgt
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;

@Deprecated
public class ajli
  extends ajju
{
  public View a(int paramInt, Object paramObject, ajjp paramajjp, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajlm paramajlm)
  {
    paramObject = paramView;
    if (paramView == null) {
      paramObject = View.inflate(paramContext, 2131562749, null);
    }
    paramajjp = paramObject.findViewById(2131378340);
    paramajjp.setTag(-1, Integer.valueOf(paramInt));
    paramajjp.setOnClickListener(paramOnClickListener);
    paramajjp = paramObject.findViewById(2131378339);
    paramajjp.setTag(-1, Integer.valueOf(paramInt));
    paramajjp.setOnClickListener(paramOnClickListener);
    paramObject.setTag(-1, Integer.valueOf(paramInt));
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajli
 * JD-Core Version:    0.7.0.1
 */
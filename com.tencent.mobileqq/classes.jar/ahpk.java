import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;

@Deprecated
public class ahpk
  extends ahnw
{
  public View a(int paramInt, Object paramObject, ahnr paramahnr, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpo paramahpo)
  {
    paramObject = paramView;
    if (paramView == null) {
      paramObject = View.inflate(paramContext, 2131562528, null);
    }
    paramahnr = paramObject.findViewById(2131377741);
    paramahnr.setTag(-1, Integer.valueOf(paramInt));
    paramahnr.setOnClickListener(paramOnClickListener);
    paramahnr = paramObject.findViewById(2131377740);
    paramahnr.setTag(-1, Integer.valueOf(paramInt));
    paramahnr.setOnClickListener(paramOnClickListener);
    paramObject.setTag(-1, Integer.valueOf(paramInt));
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahpk
 * JD-Core Version:    0.7.0.1
 */
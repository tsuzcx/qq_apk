import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;

@Deprecated
public class ahpm
  extends ahny
{
  public View a(int paramInt, Object paramObject, ahnt paramahnt, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpq paramahpq)
  {
    paramObject = paramView;
    if (paramView == null) {
      paramObject = View.inflate(paramContext, 2131562529, null);
    }
    paramahnt = paramObject.findViewById(2131377741);
    paramahnt.setTag(-1, Integer.valueOf(paramInt));
    paramahnt.setOnClickListener(paramOnClickListener);
    paramahnt = paramObject.findViewById(2131377740);
    paramahnt.setTag(-1, Integer.valueOf(paramInt));
    paramahnt.setOnClickListener(paramOnClickListener);
    paramObject.setTag(-1, Integer.valueOf(paramInt));
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahpm
 * JD-Core Version:    0.7.0.1
 */
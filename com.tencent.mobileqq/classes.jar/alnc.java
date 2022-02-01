import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;

public class alnc
  extends alnt
{
  public View a(int paramInt, Object paramObject, alno paramalno, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alpv paramalpv)
  {
    paramObject = paramView;
    if (paramView == null) {
      paramObject = LayoutInflater.from(paramContext).inflate(2131558926, null);
    }
    paramObject.setOnClickListener(paramOnClickListener);
    paramObject.setOnLongClickListener(paramOnLongClickListener);
    paramObject.setTag(-1, Integer.valueOf(paramInt));
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alnc
 * JD-Core Version:    0.7.0.1
 */
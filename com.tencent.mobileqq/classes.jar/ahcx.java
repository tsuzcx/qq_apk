import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;

@Deprecated
public class ahcx
  extends ahbj
{
  public View a(int paramInt, Object paramObject, ahbe paramahbe, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahdb paramahdb)
  {
    paramObject = paramView;
    if (paramView == null) {
      paramObject = View.inflate(paramContext, 2131496929, null);
    }
    paramahbe = paramObject.findViewById(2131311920);
    paramahbe.setTag(-1, Integer.valueOf(paramInt));
    paramahbe.setOnClickListener(paramOnClickListener);
    paramahbe = paramObject.findViewById(2131311919);
    paramahbe.setTag(-1, Integer.valueOf(paramInt));
    paramahbe.setOnClickListener(paramOnClickListener);
    paramObject.setTag(-1, Integer.valueOf(paramInt));
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahcx
 * JD-Core Version:    0.7.0.1
 */
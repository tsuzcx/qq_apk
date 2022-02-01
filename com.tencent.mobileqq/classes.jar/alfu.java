import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class alfu
  extends algt
{
  public View a(int paramInt, Object paramObject, algy paramalgy, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alje paramalje)
  {
    paramObject = new View(paramContext);
    paramObject.setBackgroundColor(Color.parseColor("#f2f2f2"));
    paramObject.setMinimumHeight(DisplayUtil.dip2px(paramContext, 20.0F));
    paramObject.setMinimumWidth((int)DeviceInfoUtil.getDispalyWidth());
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alfu
 * JD-Core Version:    0.7.0.1
 */
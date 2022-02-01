import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.RecentBaseData;

public class algn
  extends algv
{
  public algn()
  {
    this.jdField_a_of_type_Int = 2131562767;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext)
  {
    algw localalgw = null;
    if ((paramView.getTag() instanceof algw)) {
      localalgw = (algw)paramView.getTag();
    }
    if ((localalgw == null) || (localalgw.a == null) || (paramRecentBaseData == null)) {
      return;
    }
    bbxa.a(paramContext, localalgw.a, paramRecentBaseData.getRecentUserUin());
  }
  
  public View a(int paramInt, Object paramObject, algy paramalgy, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alje paramalje)
  {
    return super.a(paramInt, paramObject, paramalgy, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramalje);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
    a(paramView, paramRecentBaseData, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     algn
 * JD-Core Version:    0.7.0.1
 */
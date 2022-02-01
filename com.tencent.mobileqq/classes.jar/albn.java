import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.RecentBaseData;

public class albn
  extends albv
{
  public albn()
  {
    this.jdField_a_of_type_Int = 2131562783;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext)
  {
    albw localalbw = null;
    if ((paramView.getTag() instanceof albw)) {
      localalbw = (albw)paramView.getTag();
    }
    if ((localalbw == null) || (localalbw.a == null) || (paramRecentBaseData == null)) {
      return;
    }
    bbdx.a(paramContext, localalbw.a, paramRecentBaseData.getRecentUserUin());
  }
  
  public View a(int paramInt, Object paramObject, alby paramalby, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, aled paramaled)
  {
    return super.a(paramInt, paramObject, paramalby, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramaled);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
    a(paramView, paramRecentBaseData, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     albn
 * JD-Core Version:    0.7.0.1
 */
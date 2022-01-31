import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.RecentBaseData;

public class ahng
  extends ahno
{
  public ahng()
  {
    this.jdField_a_of_type_Int = 2131562323;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext)
  {
    ahnp localahnp = null;
    if ((paramView.getTag() instanceof ahnp)) {
      localahnp = (ahnp)paramView.getTag();
    }
    if ((localahnp == null) || (localahnp.a == null) || (paramRecentBaseData == null)) {
      return;
    }
    awgd.a(paramContext, localahnp.a, paramRecentBaseData.a());
  }
  
  public View a(int paramInt, Object paramObject, ahnr paramahnr, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpo paramahpo)
  {
    return super.a(paramInt, paramObject, paramahnr, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramahpo);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
    a(paramView, paramRecentBaseData, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahng
 * JD-Core Version:    0.7.0.1
 */
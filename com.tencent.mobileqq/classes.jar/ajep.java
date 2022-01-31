import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.RecentBaseData;

public class ajep
  extends ajex
{
  public ajep()
  {
    this.jdField_a_of_type_Int = 2131562527;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext)
  {
    ajey localajey = null;
    if ((paramView.getTag() instanceof ajey)) {
      localajey = (ajey)paramView.getTag();
    }
    if ((localajey == null) || (localajey.a == null) || (paramRecentBaseData == null)) {
      return;
    }
    aybg.a(paramContext, localajey.a, paramRecentBaseData.a());
  }
  
  public View a(int paramInt, Object paramObject, ajfa paramajfa, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajgx paramajgx)
  {
    return super.a(paramInt, paramObject, paramajfa, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramajgx);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
    a(paramView, paramRecentBaseData, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajep
 * JD-Core Version:    0.7.0.1
 */
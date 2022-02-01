import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.RecentBaseData;

public class alnd
  extends alnl
{
  public alnd()
  {
    this.jdField_a_of_type_Int = 2131562817;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext)
  {
    alnm localalnm = null;
    if ((paramView.getTag() instanceof alnm)) {
      localalnm = (alnm)paramView.getTag();
    }
    if ((localalnm == null) || (localalnm.a == null) || (paramRecentBaseData == null)) {
      return;
    }
    bbwq.a(paramContext, localalnm.a, paramRecentBaseData.getRecentUserUin());
  }
  
  public View a(int paramInt, Object paramObject, alno paramalno, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alpv paramalpv)
  {
    return super.a(paramInt, paramObject, paramalno, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramalpv);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
    a(paramView, paramRecentBaseData, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alnd
 * JD-Core Version:    0.7.0.1
 */
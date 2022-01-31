import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.RecentBaseData;

public class ajje
  extends ajjm
{
  public ajje()
  {
    this.jdField_a_of_type_Int = 2131562545;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext)
  {
    ajjn localajjn = null;
    if ((paramView.getTag() instanceof ajjn)) {
      localajjn = (ajjn)paramView.getTag();
    }
    if ((localajjn == null) || (localajjn.a == null) || (paramRecentBaseData == null)) {
      return;
    }
    ayfp.a(paramContext, localajjn.a, paramRecentBaseData.a());
  }
  
  public View a(int paramInt, Object paramObject, ajjp paramajjp, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajlm paramajlm)
  {
    return super.a(paramInt, paramObject, paramajjp, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramajlm);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
    a(paramView, paramRecentBaseData, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajje
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.RecentBaseData;

public class ahni
  extends ahnq
{
  public ahni()
  {
    this.jdField_a_of_type_Int = 2131562324;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext)
  {
    ahnr localahnr = null;
    if ((paramView.getTag() instanceof ahnr)) {
      localahnr = (ahnr)paramView.getTag();
    }
    if ((localahnr == null) || (localahnr.a == null) || (paramRecentBaseData == null)) {
      return;
    }
    awgb.a(paramContext, localahnr.a, paramRecentBaseData.a());
  }
  
  public View a(int paramInt, Object paramObject, ahnt paramahnt, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpq paramahpq)
  {
    return super.a(paramInt, paramObject, paramahnt, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramahpq);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
    a(paramView, paramRecentBaseData, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahni
 * JD-Core Version:    0.7.0.1
 */
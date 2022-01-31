import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.RecentBaseData;

public class ahat
  extends ahbb
{
  public ahat()
  {
    this.jdField_a_of_type_Int = 2131496723;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext)
  {
    ahbc localahbc = null;
    if ((paramView.getTag() instanceof ahbc)) {
      localahbc = (ahbc)paramView.getTag();
    }
    if ((localahbc == null) || (localahbc.a == null) || (paramRecentBaseData == null)) {
      return;
    }
    avgi.a(paramContext, localahbc.a, paramRecentBaseData.a());
  }
  
  public View a(int paramInt, Object paramObject, ahbe paramahbe, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahdb paramahdb)
  {
    return super.a(paramInt, paramObject, paramahbe, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramahdb);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
    a(paramView, paramRecentBaseData, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahat
 * JD-Core Version:    0.7.0.1
 */
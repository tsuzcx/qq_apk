import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.RecentBaseData;

public class akkv
  extends akld
{
  public akkv()
  {
    this.jdField_a_of_type_Int = 2131562696;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext)
  {
    akle localakle = null;
    if ((paramView.getTag() instanceof akle)) {
      localakle = (akle)paramView.getTag();
    }
    if ((localakle == null) || (localakle.a == null) || (paramRecentBaseData == null)) {
      return;
    }
    baql.a(paramContext, localakle.a, paramRecentBaseData.getRecentUserUin());
  }
  
  public View a(int paramInt, Object paramObject, aklg paramaklg, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, aknm paramaknm)
  {
    return super.a(paramInt, paramObject, paramaklg, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramaknm);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
    a(paramView, paramRecentBaseData, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akkv
 * JD-Core Version:    0.7.0.1
 */
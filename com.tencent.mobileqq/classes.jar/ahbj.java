import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public abstract class ahbj
{
  public static final int[] a;
  public static final int[] b = { 2130839215, 2130839214, 2130839214, 2130839214, 2130839216, 2130839216, 2130839216, 2130839214, 2130839214 };
  public static final int[] c = { 2131304236, 2131304256, 2131304231, 2131304249, 2131304246, 2131304247, 2131304259, 2131304255, 2131304254 };
  protected ahai a;
  protected bens a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131625931, 2131625710, 2131625680, 2131625684, 2131625681, 2131625682, 2131628781, 2131627560, 2131627558 };
  }
  
  public int a()
  {
    return 1;
  }
  
  public abstract View a(int paramInt, Object paramObject, ahbe paramahbe, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahdb paramahdb);
  
  public final View a(Context paramContext, int paramInt, ahbl paramahbl)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if ((this.jdField_a_of_type_Ahai != null) && (this.jdField_a_of_type_Ahai.a()))
    {
      if (this.jdField_a_of_type_Bens == null) {
        this.jdField_a_of_type_Bens = a(paramContext);
      }
      return this.jdField_a_of_type_Bens.a(paramContext, localView, paramahbl, -1);
    }
    paramahbl.g = localView;
    paramahbl.a = null;
    return localView;
  }
  
  public bens a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131167510);
    int j = paramContext.getResources().getDimensionPixelSize(2131167511);
    int k = a();
    paramContext = c;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = b;
    return new ahbk(this, k, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    return null;
  }
  
  public void a(ahai paramahai)
  {
    this.jdField_a_of_type_Ahai = paramahai;
  }
  
  public void a(Context paramContext, View paramView, int paramInt, Object paramObject, ahbl paramahbl, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bens != null) {}
    for (int i = this.jdField_a_of_type_Bens.a(paramContext, paramView, paramInt, paramObject, paramahbl, paramOnClickListener);; i = 0)
    {
      int j = paramView.getScrollX();
      if ((paramInt >= 0) && (this.jdField_a_of_type_Ahai != null) && (this.jdField_a_of_type_Ahai.a == paramInt))
      {
        paramView.scrollTo(i, 0);
        if ((j != 0) && (QLog.isDevelopLevel())) {
          if (this.jdField_a_of_type_Ahai != null) {
            break label123;
          }
        }
      }
      label123:
      for (paramContext = null;; paramContext = Integer.valueOf(this.jdField_a_of_type_Ahai.a))
      {
        asfl.a("updateItemMenuView", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j), paramContext });
        return;
        if (j == 0) {
          break;
        }
        paramView.scrollTo(0, 0);
        break;
      }
    }
  }
  
  protected void a(View paramView)
  {
    if ((paramView instanceof DynamicAvatarView))
    {
      paramView = (DynamicAvatarView)paramView;
      if (paramView.a == null) {
        paramView.a = new beog();
      }
      paramView.a.a(true);
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahbj
 * JD-Core Version:    0.7.0.1
 */
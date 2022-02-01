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

public abstract class alhd
{
  public static final int[] a;
  public static final int[] b = { 2130839570, 2130839569, 2130839569, 2130839569, 2130839571, 2130839571, 2130839569, 2130839569, 2130839569, 2130839571 };
  public static final int[] c = { 2131370896, 2131370916, 2131370890, 2131370909, 2131370906, 2131370907, 2131370919, 2131370915, 2131370914, 2131370889 };
  protected algc a;
  protected blfk a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131691448, 2131691248, 2131691231, 2131691234, 2131691232, 2131691233, 2131694168, 2131692964, 2131692962, 2131691230 };
  }
  
  public int a()
  {
    return 1;
  }
  
  public abstract View a(int paramInt, Object paramObject, algy paramalgy, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alje paramalje);
  
  public final View a(Context paramContext, int paramInt, alhf paramalhf)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if ((this.jdField_a_of_type_Algc != null) && (this.jdField_a_of_type_Algc.a()))
    {
      if (this.jdField_a_of_type_Blfk == null) {
        this.jdField_a_of_type_Blfk = a(paramContext);
      }
      return this.jdField_a_of_type_Blfk.a(paramContext, localView, paramalhf, -1);
    }
    paramalhf.g = localView;
    paramalhf.a = null;
    return localView;
  }
  
  public blfk a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298795);
    int j = paramContext.getResources().getDimensionPixelSize(2131298796);
    int k = a();
    paramContext = c;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = b;
    return new alhe(this, k, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    return null;
  }
  
  public void a(algc paramalgc)
  {
    this.jdField_a_of_type_Algc = paramalgc;
  }
  
  public void a(Context paramContext, View paramView, int paramInt, Object paramObject, alhf paramalhf, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Blfk != null) {}
    for (int i = this.jdField_a_of_type_Blfk.a(paramContext, paramView, paramInt, paramObject, paramalhf, paramOnClickListener);; i = 0)
    {
      int j = paramView.getScrollX();
      if ((paramInt >= 0) && (this.jdField_a_of_type_Algc != null) && (this.jdField_a_of_type_Algc.a == paramInt))
      {
        paramView.scrollTo(i, 0);
        if ((j != 0) && (QLog.isDevelopLevel())) {
          if (this.jdField_a_of_type_Algc != null) {
            break label123;
          }
        }
      }
      label123:
      for (paramContext = null;; paramContext = Integer.valueOf(this.jdField_a_of_type_Algc.a))
      {
        axql.a("updateItemMenuView", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j), paramContext });
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
        paramView.a = new blfw();
      }
      paramView.a.a(true);
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alhd
 * JD-Core Version:    0.7.0.1
 */
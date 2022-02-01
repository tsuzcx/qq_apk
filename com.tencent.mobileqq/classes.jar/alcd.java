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

public abstract class alcd
{
  public static final int[] a;
  public static final int[] b = { 2130839506, 2130839505, 2130839505, 2130839505, 2130839507, 2130839507, 2130839507, 2130839505, 2130839505, 2130839507 };
  public static final int[] c = { 2131370639, 2131370659, 2131370633, 2131370652, 2131370649, 2131370650, 2131370662, 2131370658, 2131370657, 2131370632 };
  protected albc a;
  protected bkos a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131691320, 2131691124, 2131691106, 2131691109, 2131691107, 2131691108, 2131693861, 2131692799, 2131692797, 2131691105 };
  }
  
  public int a()
  {
    return 1;
  }
  
  public abstract View a(int paramInt, Object paramObject, alby paramalby, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, aled paramaled);
  
  public final View a(Context paramContext, int paramInt, alcf paramalcf)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if ((this.jdField_a_of_type_Albc != null) && (this.jdField_a_of_type_Albc.a()))
    {
      if (this.jdField_a_of_type_Bkos == null) {
        this.jdField_a_of_type_Bkos = a(paramContext);
      }
      return this.jdField_a_of_type_Bkos.a(paramContext, localView, paramalcf, -1);
    }
    paramalcf.g = localView;
    paramalcf.a = null;
    return localView;
  }
  
  public bkos a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298713);
    int j = paramContext.getResources().getDimensionPixelSize(2131298714);
    int k = a();
    paramContext = c;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = b;
    return new alce(this, k, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    return null;
  }
  
  public void a(albc paramalbc)
  {
    this.jdField_a_of_type_Albc = paramalbc;
  }
  
  public void a(Context paramContext, View paramView, int paramInt, Object paramObject, alcf paramalcf, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bkos != null) {}
    for (int i = this.jdField_a_of_type_Bkos.a(paramContext, paramView, paramInt, paramObject, paramalcf, paramOnClickListener);; i = 0)
    {
      int j = paramView.getScrollX();
      if ((paramInt >= 0) && (this.jdField_a_of_type_Albc != null) && (this.jdField_a_of_type_Albc.a == paramInt))
      {
        paramView.scrollTo(i, 0);
        if ((j != 0) && (QLog.isDevelopLevel())) {
          if (this.jdField_a_of_type_Albc != null) {
            break label123;
          }
        }
      }
      label123:
      for (paramContext = null;; paramContext = Integer.valueOf(this.jdField_a_of_type_Albc.a))
      {
        axei.a("updateItemMenuView", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j), paramContext });
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
        paramView.a = new bkpg();
      }
      paramView.a.a(true);
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alcd
 * JD-Core Version:    0.7.0.1
 */
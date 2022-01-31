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

public abstract class ahny
{
  public static final int[] a;
  public static final int[] b = { 2130839239, 2130839238, 2130839238, 2130839238, 2130839240, 2130839240, 2130839240, 2130839238, 2130839238, 2130839240 };
  public static final int[] c = { 2131369915, 2131369936, 2131369910, 2131369929, 2131369926, 2131369927, 2131369939, 2131369935, 2131369934, 2131369909 };
  protected ahmx a;
  protected bfvm a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131691507, 2131691286, 2131691256, 2131691260, 2131691257, 2131691258, 2131694442, 2131693200, 2131693198, 2131691255 };
  }
  
  public int a()
  {
    return 1;
  }
  
  public abstract View a(int paramInt, Object paramObject, ahnt paramahnt, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpq paramahpq);
  
  public final View a(Context paramContext, int paramInt, ahoa paramahoa)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if ((this.jdField_a_of_type_Ahmx != null) && (this.jdField_a_of_type_Ahmx.a()))
    {
      if (this.jdField_a_of_type_Bfvm == null) {
        this.jdField_a_of_type_Bfvm = a(paramContext);
      }
      return this.jdField_a_of_type_Bfvm.a(paramContext, localView, paramahoa, -1);
    }
    paramahoa.g = localView;
    paramahoa.a = null;
    return localView;
  }
  
  public bfvm a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298603);
    int j = paramContext.getResources().getDimensionPixelSize(2131298604);
    int k = a();
    paramContext = c;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = b;
    return new ahnz(this, k, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    return null;
  }
  
  public void a(ahmx paramahmx)
  {
    this.jdField_a_of_type_Ahmx = paramahmx;
  }
  
  public void a(Context paramContext, View paramView, int paramInt, Object paramObject, ahoa paramahoa, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bfvm != null) {}
    for (int i = this.jdField_a_of_type_Bfvm.a(paramContext, paramView, paramInt, paramObject, paramahoa, paramOnClickListener);; i = 0)
    {
      int j = paramView.getScrollX();
      if ((paramInt >= 0) && (this.jdField_a_of_type_Ahmx != null) && (this.jdField_a_of_type_Ahmx.a == paramInt))
      {
        paramView.scrollTo(i, 0);
        if ((j != 0) && (QLog.isDevelopLevel())) {
          if (this.jdField_a_of_type_Ahmx != null) {
            break label123;
          }
        }
      }
      label123:
      for (paramContext = null;; paramContext = Integer.valueOf(this.jdField_a_of_type_Ahmx.a))
      {
        atbp.a("updateItemMenuView", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j), paramContext });
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
        paramView.a = new bfwa();
      }
      paramView.a.a(true);
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahny
 * JD-Core Version:    0.7.0.1
 */
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

public abstract class ahnw
{
  public static final int[] a;
  public static final int[] b = { 2130839239, 2130839238, 2130839238, 2130839238, 2130839240, 2130839240, 2130839240, 2130839238, 2130839238, 2130839240 };
  public static final int[] c = { 2131369914, 2131369935, 2131369909, 2131369928, 2131369925, 2131369926, 2131369938, 2131369934, 2131369933, 2131369908 };
  protected ahmv a;
  protected bfwd a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131691507, 2131691286, 2131691256, 2131691260, 2131691257, 2131691258, 2131694443, 2131693201, 2131693199, 2131691255 };
  }
  
  public int a()
  {
    return 1;
  }
  
  public abstract View a(int paramInt, Object paramObject, ahnr paramahnr, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpo paramahpo);
  
  public final View a(Context paramContext, int paramInt, ahny paramahny)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if ((this.jdField_a_of_type_Ahmv != null) && (this.jdField_a_of_type_Ahmv.a()))
    {
      if (this.jdField_a_of_type_Bfwd == null) {
        this.jdField_a_of_type_Bfwd = a(paramContext);
      }
      return this.jdField_a_of_type_Bfwd.a(paramContext, localView, paramahny, -1);
    }
    paramahny.g = localView;
    paramahny.a = null;
    return localView;
  }
  
  public bfwd a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298603);
    int j = paramContext.getResources().getDimensionPixelSize(2131298604);
    int k = a();
    paramContext = c;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = b;
    return new ahnx(this, k, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    return null;
  }
  
  public void a(ahmv paramahmv)
  {
    this.jdField_a_of_type_Ahmv = paramahmv;
  }
  
  public void a(Context paramContext, View paramView, int paramInt, Object paramObject, ahny paramahny, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bfwd != null) {}
    for (int i = this.jdField_a_of_type_Bfwd.a(paramContext, paramView, paramInt, paramObject, paramahny, paramOnClickListener);; i = 0)
    {
      int j = paramView.getScrollX();
      if ((paramInt >= 0) && (this.jdField_a_of_type_Ahmv != null) && (this.jdField_a_of_type_Ahmv.a == paramInt))
      {
        paramView.scrollTo(i, 0);
        if ((j != 0) && (QLog.isDevelopLevel())) {
          if (this.jdField_a_of_type_Ahmv != null) {
            break label123;
          }
        }
      }
      label123:
      for (paramContext = null;; paramContext = Integer.valueOf(this.jdField_a_of_type_Ahmv.a))
      {
        atbr.a("updateItemMenuView", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j), paramContext });
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
        paramView.a = new bfwr();
      }
      paramView.a.a(true);
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahnw
 * JD-Core Version:    0.7.0.1
 */
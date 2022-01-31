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

public abstract class ajju
{
  public static final int[] a;
  public static final int[] b = { 2130839329, 2130839328, 2130839328, 2130839328, 2130839330, 2130839330, 2130839330, 2130839328, 2130839328, 2130839330 };
  public static final int[] c = { 2131370198, 2131370219, 2131370192, 2131370212, 2131370209, 2131370210, 2131370222, 2131370218, 2131370217, 2131370191 };
  protected ajit a;
  protected bibh a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131691562, 2131691340, 2131691310, 2131691314, 2131691311, 2131691312, 2131694602, 2131693304, 2131693302, 2131691309 };
  }
  
  public int a()
  {
    return 1;
  }
  
  public abstract View a(int paramInt, Object paramObject, ajjp paramajjp, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajlm paramajlm);
  
  public final View a(Context paramContext, int paramInt, ajjw paramajjw)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if ((this.jdField_a_of_type_Ajit != null) && (this.jdField_a_of_type_Ajit.a()))
    {
      if (this.jdField_a_of_type_Bibh == null) {
        this.jdField_a_of_type_Bibh = a(paramContext);
      }
      return this.jdField_a_of_type_Bibh.a(paramContext, localView, paramajjw, -1);
    }
    paramajjw.g = localView;
    paramajjw.a = null;
    return localView;
  }
  
  public bibh a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298631);
    int j = paramContext.getResources().getDimensionPixelSize(2131298632);
    int k = a();
    paramContext = c;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = b;
    return new ajjv(this, k, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    return null;
  }
  
  public void a(ajit paramajit)
  {
    this.jdField_a_of_type_Ajit = paramajit;
  }
  
  public void a(Context paramContext, View paramView, int paramInt, Object paramObject, ajjw paramajjw, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bibh != null) {}
    for (int i = this.jdField_a_of_type_Bibh.a(paramContext, paramView, paramInt, paramObject, paramajjw, paramOnClickListener);; i = 0)
    {
      int j = paramView.getScrollX();
      if ((paramInt >= 0) && (this.jdField_a_of_type_Ajit != null) && (this.jdField_a_of_type_Ajit.a == paramInt))
      {
        paramView.scrollTo(i, 0);
        if ((j != 0) && (QLog.isDevelopLevel())) {
          if (this.jdField_a_of_type_Ajit != null) {
            break label123;
          }
        }
      }
      label123:
      for (paramContext = null;; paramContext = Integer.valueOf(this.jdField_a_of_type_Ajit.a))
      {
        auwz.a("updateItemMenuView", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j), paramContext });
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
        paramView.a = new bibv();
      }
      paramView.a.a(true);
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajju
 * JD-Core Version:    0.7.0.1
 */
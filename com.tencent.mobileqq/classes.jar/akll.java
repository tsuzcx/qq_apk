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

public abstract class akll
{
  public static final int[] a;
  public static final int[] b = { 2130839549, 2130839548, 2130839548, 2130839548, 2130839550, 2130839550, 2130839550, 2130839548, 2130839548, 2130839550 };
  public static final int[] c = { 2131370711, 2131370731, 2131370705, 2131370724, 2131370721, 2131370722, 2131370734, 2131370730, 2131370729, 2131370704 };
  protected akkk a;
  protected bjty a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131691363, 2131691163, 2131691146, 2131691149, 2131691147, 2131691148, 2131693977, 2131692858, 2131692856, 2131691145 };
  }
  
  public int a()
  {
    return 1;
  }
  
  public abstract View a(int paramInt, Object paramObject, aklg paramaklg, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, aknm paramaknm);
  
  public final View a(Context paramContext, int paramInt, akln paramakln)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if ((this.jdField_a_of_type_Akkk != null) && (this.jdField_a_of_type_Akkk.a()))
    {
      if (this.jdField_a_of_type_Bjty == null) {
        this.jdField_a_of_type_Bjty = a(paramContext);
      }
      return this.jdField_a_of_type_Bjty.a(paramContext, localView, paramakln, -1);
    }
    paramakln.g = localView;
    paramakln.a = null;
    return localView;
  }
  
  public bjty a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298791);
    int j = paramContext.getResources().getDimensionPixelSize(2131298792);
    int k = a();
    paramContext = c;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = b;
    return new aklm(this, k, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    return null;
  }
  
  public void a(akkk paramakkk)
  {
    this.jdField_a_of_type_Akkk = paramakkk;
  }
  
  public void a(Context paramContext, View paramView, int paramInt, Object paramObject, akln paramakln, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bjty != null) {}
    for (int i = this.jdField_a_of_type_Bjty.a(paramContext, paramView, paramInt, paramObject, paramakln, paramOnClickListener);; i = 0)
    {
      int j = paramView.getScrollX();
      if ((paramInt >= 0) && (this.jdField_a_of_type_Akkk != null) && (this.jdField_a_of_type_Akkk.a == paramInt))
      {
        paramView.scrollTo(i, 0);
        if ((j != 0) && (QLog.isDevelopLevel())) {
          if (this.jdField_a_of_type_Akkk != null) {
            break label123;
          }
        }
      }
      label123:
      for (paramContext = null;; paramContext = Integer.valueOf(this.jdField_a_of_type_Akkk.a))
      {
        awkj.a("updateItemMenuView", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j), paramContext });
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
        paramView.a = new bjuk();
      }
      paramView.a.a(true);
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akll
 * JD-Core Version:    0.7.0.1
 */
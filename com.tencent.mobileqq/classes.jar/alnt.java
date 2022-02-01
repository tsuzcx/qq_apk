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

public abstract class alnt
{
  public static final int[] a;
  public static final int[] b = { 2130839514, 2130839513, 2130839513, 2130839513, 2130839515, 2130839515, 2130839515, 2130839513, 2130839513, 2130839515 };
  public static final int[] c = { 2131370743, 2131370763, 2131370737, 2131370756, 2131370753, 2131370754, 2131370766, 2131370762, 2131370761, 2131370736 };
  protected alms a;
  protected blpv a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131691323, 2131691124, 2131691106, 2131691109, 2131691107, 2131691108, 2131693878, 2131692807, 2131692805, 2131691105 };
  }
  
  public int a()
  {
    return 1;
  }
  
  public abstract View a(int paramInt, Object paramObject, alno paramalno, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alpv paramalpv);
  
  public final View a(Context paramContext, int paramInt, alnv paramalnv)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if ((this.jdField_a_of_type_Alms != null) && (this.jdField_a_of_type_Alms.a()))
    {
      if (this.jdField_a_of_type_Blpv == null) {
        this.jdField_a_of_type_Blpv = a(paramContext);
      }
      return this.jdField_a_of_type_Blpv.a(paramContext, localView, paramalnv, -1);
    }
    paramalnv.g = localView;
    paramalnv.a = null;
    return localView;
  }
  
  public blpv a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298726);
    int j = paramContext.getResources().getDimensionPixelSize(2131298727);
    int k = a();
    paramContext = c;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = b;
    return new alnu(this, k, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    return null;
  }
  
  public void a(alms paramalms)
  {
    this.jdField_a_of_type_Alms = paramalms;
  }
  
  public void a(Context paramContext, View paramView, int paramInt, Object paramObject, alnv paramalnv, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Blpv != null) {}
    for (int i = this.jdField_a_of_type_Blpv.a(paramContext, paramView, paramInt, paramObject, paramalnv, paramOnClickListener);; i = 0)
    {
      int j = paramView.getScrollX();
      if ((paramInt >= 0) && (this.jdField_a_of_type_Alms != null) && (this.jdField_a_of_type_Alms.a == paramInt))
      {
        paramView.scrollTo(i, 0);
        if ((j != 0) && (QLog.isDevelopLevel())) {
          if (this.jdField_a_of_type_Alms != null) {
            break label123;
          }
        }
      }
      label123:
      for (paramContext = null;; paramContext = Integer.valueOf(this.jdField_a_of_type_Alms.a))
      {
        axxb.a("updateItemMenuView", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j), paramContext });
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
        paramView.a = new blqj();
      }
      paramView.a.a(true);
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alnt
 * JD-Core Version:    0.7.0.1
 */
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

public abstract class ajff
{
  public static final int[] a;
  public static final int[] b = { 2130839328, 2130839327, 2130839327, 2130839327, 2130839329, 2130839329, 2130839329, 2130839327, 2130839327, 2130839329 };
  public static final int[] c = { 2131370179, 2131370200, 2131370173, 2131370193, 2131370190, 2131370191, 2131370203, 2131370199, 2131370198, 2131370172 };
  protected ajee a;
  protected bhxa a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131691561, 2131691339, 2131691309, 2131691313, 2131691310, 2131691311, 2131694600, 2131693302, 2131693300, 2131691308 };
  }
  
  public int a()
  {
    return 1;
  }
  
  public abstract View a(int paramInt, Object paramObject, ajfa paramajfa, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajgx paramajgx);
  
  public final View a(Context paramContext, int paramInt, ajfh paramajfh)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if ((this.jdField_a_of_type_Ajee != null) && (this.jdField_a_of_type_Ajee.a()))
    {
      if (this.jdField_a_of_type_Bhxa == null) {
        this.jdField_a_of_type_Bhxa = a(paramContext);
      }
      return this.jdField_a_of_type_Bhxa.a(paramContext, localView, paramajfh, -1);
    }
    paramajfh.g = localView;
    paramajfh.a = null;
    return localView;
  }
  
  public bhxa a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298631);
    int j = paramContext.getResources().getDimensionPixelSize(2131298632);
    int k = a();
    paramContext = c;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = b;
    return new ajfg(this, k, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    return null;
  }
  
  public void a(ajee paramajee)
  {
    this.jdField_a_of_type_Ajee = paramajee;
  }
  
  public void a(Context paramContext, View paramView, int paramInt, Object paramObject, ajfh paramajfh, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bhxa != null) {}
    for (int i = this.jdField_a_of_type_Bhxa.a(paramContext, paramView, paramInt, paramObject, paramajfh, paramOnClickListener);; i = 0)
    {
      int j = paramView.getScrollX();
      if ((paramInt >= 0) && (this.jdField_a_of_type_Ajee != null) && (this.jdField_a_of_type_Ajee.a == paramInt))
      {
        paramView.scrollTo(i, 0);
        if ((j != 0) && (QLog.isDevelopLevel())) {
          if (this.jdField_a_of_type_Ajee != null) {
            break label123;
          }
        }
      }
      label123:
      for (paramContext = null;; paramContext = Integer.valueOf(this.jdField_a_of_type_Ajee.a))
      {
        ausq.a("updateItemMenuView", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j), paramContext });
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
        paramView.a = new bhxo();
      }
      paramView.a.a(true);
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajff
 * JD-Core Version:    0.7.0.1
 */
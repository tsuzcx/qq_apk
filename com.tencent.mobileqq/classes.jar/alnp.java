import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;

public class alnp
  extends alnl
{
  private static void a(Context paramContext, View paramView)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(paramContext, 2130772120);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130772119);
    localAnimation.setAnimationListener(new alnq(paramView, paramContext));
    paramContext.setAnimationListener(new alnr(paramView, localAnimation));
    paramView.startAnimation(localAnimation);
  }
  
  public View a(int paramInt, Object paramObject, alno paramalno, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alpv paramalpv)
  {
    alns localalns;
    if ((paramView == null) || (!(paramView.getTag() instanceof alns)))
    {
      localalns = new alns(null);
      View localView = a(paramContext, 2131562820, localalns);
      localalns.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)localView.findViewById(2131368212));
      localalns.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)localView.findViewById(2131380442));
      localalns.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131378936));
      localalns.b = ((SingleLineTextView)localView.findViewById(2131365413));
      localalns.b.setGravity(16);
      localalns.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362686));
      localalns.c = ((ImageView)localView.findViewById(2131362685));
      Object localObject = paramContext.getResources();
      float f = bhlo.a();
      paramView = ((Resources)localObject).getColorStateList(2131167074);
      ColorStateList localColorStateList = ((Resources)localObject).getColorStateList(2131166997);
      localObject = ((Resources)localObject).getColorStateList(2131167075);
      localalns.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(localColorStateList);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null))
      {
        localalns.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject, 0);
        localalns.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
        localalns.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
        localalns.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        localalns.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
        localalns.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
        localalns.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
        localalns.b.setTextColor(paramView);
        localalns.b.setExtendTextPadding((int)(f * 2.0F), 1);
        localalns.b.setExtendTextSize(14.0F, 1);
        localView.setTag(localalns);
        paramView = localView;
        if (this.a != null)
        {
          localalns.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.a.a());
          paramView = localView;
        }
      }
    }
    for (;;)
    {
      return super.a(paramInt, paramObject, paramalno, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramalpv);
      localalns.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
      break;
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
    }
    alns localalns;
    do
    {
      return;
      localalns = null;
      if ((paramView.getTag() instanceof alns)) {
        localalns = (alns)paramView.getTag();
      }
      if (localalns != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
    return;
    super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
    a(paramContext, localalns.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alnp
 * JD-Core Version:    0.7.0.1
 */
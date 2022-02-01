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
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;

public class alos
  extends alnl
{
  private static void a(Context paramContext, View paramView)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(paramContext, 2130772120);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130772119);
    localAnimation.setAnimationListener(new alot(paramView, paramContext));
    paramContext.setAnimationListener(new alou(paramView, localAnimation));
    paramView.startAnimation(localAnimation);
  }
  
  public View a(int paramInt, Object paramObject, alno paramalno, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alpv paramalpv)
  {
    alov localalov;
    if ((paramView == null) || (!(paramView.getTag() instanceof alov)))
    {
      localalov = new alov(null);
      View localView = a(paramContext, 2131562820, localalov);
      localalov.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)localView.findViewById(2131368212));
      localalov.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)localView.findViewById(2131380442));
      localalov.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131378936));
      localalov.b = ((SingleLineTextView)localView.findViewById(2131365413));
      localalov.b.setGravity(16);
      localalov.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362686));
      localalov.c = ((ImageView)localView.findViewById(2131362685));
      Object localObject = paramContext.getResources();
      float f = bhlo.a();
      paramView = ((Resources)localObject).getColorStateList(2131167074);
      ColorStateList localColorStateList = ((Resources)localObject).getColorStateList(2131166997);
      localObject = ((Resources)localObject).getColorStateList(2131167075);
      localalov.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(localColorStateList);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null))
      {
        localalov.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject, 0);
        localalov.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
        localalov.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
        localalov.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        localalov.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
        localalov.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
        localalov.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
        localalov.b.setTextColor(paramView);
        localalov.b.setExtendTextPadding((int)(f * 2.0F), 1);
        localalov.b.setExtendTextSize(14.0F, 1);
        localView.setTag(localalov);
        paramView = localView;
        if (this.a != null)
        {
          localalov.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.a.a());
          paramView = localView;
        }
      }
    }
    for (;;)
    {
      return super.a(paramInt, paramObject, paramalno, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramalpv);
      localalov.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
      break;
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
      return;
    }
    if ((paramView.getTag() instanceof alov)) {}
    for (alov localalov = (alov)paramView.getTag();; localalov = null)
    {
      if (localalov == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
        return;
      }
      super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
      paramView = (RelativeLayout.LayoutParams)localalov.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramView.height = localalov.b.getMeasuredHeight();
      localalov.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
      a(paramContext, localalov.c);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alos
 * JD-Core Version:    0.7.0.1
 */
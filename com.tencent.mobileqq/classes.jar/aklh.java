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
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;

public class aklh
  extends akld
{
  private static void a(Context paramContext, View paramView)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(paramContext, 2130772128);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130772127);
    localAnimation.setAnimationListener(new akli(paramView, paramContext));
    paramContext.setAnimationListener(new aklj(paramView, localAnimation));
    paramView.startAnimation(localAnimation);
  }
  
  public View a(int paramInt, Object paramObject, aklg paramaklg, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, aknm paramaknm)
  {
    aklk localaklk;
    if ((paramView == null) || (!(paramView.getTag() instanceof aklk)))
    {
      localaklk = new aklk(null);
      View localView = a(paramContext, 2131562699, localaklk);
      localaklk.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)localView.findViewById(2131368236));
      localaklk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)localView.findViewById(2131380166));
      localaklk.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131378707));
      localaklk.b = ((SingleLineTextView)localView.findViewById(2131365445));
      localaklk.b.setGravity(16);
      localaklk.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362691));
      localaklk.c = ((ImageView)localView.findViewById(2131362690));
      Object localObject = paramContext.getResources();
      float f = DeviceInfoUtil.getDesity();
      paramView = ((Resources)localObject).getColorStateList(2131167096);
      ColorStateList localColorStateList = ((Resources)localObject).getColorStateList(2131167019);
      localObject = ((Resources)localObject).getColorStateList(2131167097);
      localaklk.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(localColorStateList);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null))
      {
        localaklk.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject, 0);
        localaklk.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
        localaklk.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
        localaklk.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        localaklk.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
        localaklk.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
        localaklk.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
        localaklk.b.setTextColor(paramView);
        localaklk.b.setExtendTextPadding((int)(f * 2.0F), 1);
        localaklk.b.setExtendTextSize(14.0F, 1);
        localView.setTag(localaklk);
        paramView = localView;
        if (this.a != null)
        {
          localaklk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.a.a());
          paramView = localView;
        }
      }
    }
    for (;;)
    {
      return super.a(paramInt, paramObject, paramaklg, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramaknm);
      localaklk.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
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
    aklk localaklk;
    do
    {
      return;
      localaklk = null;
      if ((paramView.getTag() instanceof aklk)) {
        localaklk = (aklk)paramView.getTag();
      }
      if (localaklk != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
    return;
    super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
    a(paramContext, localaklk.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aklh
 * JD-Core Version:    0.7.0.1
 */
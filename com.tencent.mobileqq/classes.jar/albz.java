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

public class albz
  extends albv
{
  private static void a(Context paramContext, View paramView)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(paramContext, 2130772120);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130772119);
    localAnimation.setAnimationListener(new alca(paramView, paramContext));
    paramContext.setAnimationListener(new alcb(paramView, localAnimation));
    paramView.startAnimation(localAnimation);
  }
  
  public View a(int paramInt, Object paramObject, alby paramalby, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, aled paramaled)
  {
    alcc localalcc;
    if ((paramView == null) || (!(paramView.getTag() instanceof alcc)))
    {
      localalcc = new alcc(null);
      View localView = a(paramContext, 2131562786, localalcc);
      localalcc.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)localView.findViewById(2131368138));
      localalcc.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)localView.findViewById(2131380256));
      localalcc.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131378776));
      localalcc.b = ((SingleLineTextView)localView.findViewById(2131365369));
      localalcc.b.setGravity(16);
      localalcc.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362670));
      localalcc.c = ((ImageView)localView.findViewById(2131362669));
      Object localObject = paramContext.getResources();
      float f = bgln.a();
      paramView = ((Resources)localObject).getColorStateList(2131167064);
      ColorStateList localColorStateList = ((Resources)localObject).getColorStateList(2131166993);
      localObject = ((Resources)localObject).getColorStateList(2131167065);
      localalcc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(localColorStateList);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null))
      {
        localalcc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject, 0);
        localalcc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
        localalcc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
        localalcc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        localalcc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
        localalcc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
        localalcc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
        localalcc.b.setTextColor(paramView);
        localalcc.b.setExtendTextPadding((int)(f * 2.0F), 1);
        localalcc.b.setExtendTextSize(14.0F, 1);
        localView.setTag(localalcc);
        paramView = localView;
        if (this.a != null)
        {
          localalcc.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.a.a());
          paramView = localView;
        }
      }
    }
    for (;;)
    {
      return super.a(paramInt, paramObject, paramalby, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramaled);
      localalcc.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
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
    alcc localalcc;
    do
    {
      return;
      localalcc = null;
      if ((paramView.getTag() instanceof alcc)) {
        localalcc = (alcc)paramView.getTag();
      }
      if (localalcc != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
    return;
    super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
    a(paramContext, localalcc.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     albz
 * JD-Core Version:    0.7.0.1
 */
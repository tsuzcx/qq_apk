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

public class ahov
  extends ahno
{
  private static void a(Context paramContext, View paramView)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(paramContext, 2130772114);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130772113);
    localAnimation.setAnimationListener(new ahow(paramView, paramContext));
    paramContext.setAnimationListener(new ahox(paramView, localAnimation));
    paramView.startAnimation(localAnimation);
  }
  
  public View a(int paramInt, Object paramObject, ahnr paramahnr, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpo paramahpo)
  {
    ahoy localahoy;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahoy)))
    {
      localahoy = new ahoy(null);
      View localView = a(paramContext, 2131562326, localahoy);
      localahoy.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)localView.findViewById(2131367679));
      localahoy.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)localView.findViewById(2131378655));
      localahoy.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131377350));
      localahoy.b = ((SingleLineTextView)localView.findViewById(2131365042));
      localahoy.b.setGravity(16);
      localahoy.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362541));
      localahoy.c = ((ImageView)localView.findViewById(2131362540));
      Object localObject = paramContext.getResources();
      float f = bbdh.a();
      paramView = ((Resources)localObject).getColorStateList(2131166931);
      ColorStateList localColorStateList = ((Resources)localObject).getColorStateList(2131166861);
      localObject = ((Resources)localObject).getColorStateList(2131166932);
      localahoy.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(localColorStateList);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null))
      {
        localahoy.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject, 0);
        localahoy.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
        localahoy.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
        localahoy.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        localahoy.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
        localahoy.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
        localahoy.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
        localahoy.b.setTextColor(paramView);
        localahoy.b.setExtendTextPadding((int)(f * 2.0F), 1);
        localahoy.b.setExtendTextSize(14.0F, 1);
        localView.setTag(localahoy);
        paramView = localView;
        if (this.a != null)
        {
          localahoy.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.a.a());
          paramView = localView;
        }
      }
    }
    for (;;)
    {
      return super.a(paramInt, paramObject, paramahnr, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramahpo);
      localahoy.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
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
    if ((paramView.getTag() instanceof ahoy)) {}
    for (ahoy localahoy = (ahoy)paramView.getTag();; localahoy = null)
    {
      if (localahoy == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
        return;
      }
      super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
      paramView = (RelativeLayout.LayoutParams)localahoy.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramView.height = localahoy.b.getMeasuredHeight();
      localahoy.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
      a(paramContext, localahoy.c);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahov
 * JD-Core Version:    0.7.0.1
 */
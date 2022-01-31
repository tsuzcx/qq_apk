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

public class ahnu
  extends ahnq
{
  private static void a(Context paramContext, View paramView)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(paramContext, 2130772114);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130772113);
    localAnimation.setAnimationListener(new ahnv(paramView, paramContext));
    paramContext.setAnimationListener(new ahnw(paramView, localAnimation));
    paramView.startAnimation(localAnimation);
  }
  
  public View a(int paramInt, Object paramObject, ahnt paramahnt, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpq paramahpq)
  {
    ahnx localahnx;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahnx)))
    {
      localahnx = new ahnx(null);
      View localView = a(paramContext, 2131562327, localahnx);
      localahnx.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)localView.findViewById(2131367679));
      localahnx.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)localView.findViewById(2131378650));
      localahnx.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131377350));
      localahnx.b = ((SingleLineTextView)localView.findViewById(2131365043));
      localahnx.b.setGravity(16);
      localahnx.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362542));
      localahnx.c = ((ImageView)localView.findViewById(2131362541));
      Object localObject = paramContext.getResources();
      float f = bbct.a();
      paramView = ((Resources)localObject).getColorStateList(2131166931);
      ColorStateList localColorStateList = ((Resources)localObject).getColorStateList(2131166861);
      localObject = ((Resources)localObject).getColorStateList(2131166932);
      localahnx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(localColorStateList);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null))
      {
        localahnx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject, 0);
        localahnx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
        localahnx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
        localahnx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        localahnx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
        localahnx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
        localahnx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
        localahnx.b.setTextColor(paramView);
        localahnx.b.setExtendTextPadding((int)(f * 2.0F), 1);
        localahnx.b.setExtendTextSize(14.0F, 1);
        localView.setTag(localahnx);
        paramView = localView;
        if (this.a != null)
        {
          localahnx.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.a.a());
          paramView = localView;
        }
      }
    }
    for (;;)
    {
      return super.a(paramInt, paramObject, paramahnt, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramahpq);
      localahnx.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
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
    ahnx localahnx;
    do
    {
      return;
      localahnx = null;
      if ((paramView.getTag() instanceof ahnx)) {
        localahnx = (ahnx)paramView.getTag();
      }
      if (localahnx != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
    return;
    super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
    a(paramContext, localahnx.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahnu
 * JD-Core Version:    0.7.0.1
 */
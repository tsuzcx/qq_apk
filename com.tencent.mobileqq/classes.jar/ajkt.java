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

public class ajkt
  extends ajjm
{
  private static void a(Context paramContext, View paramView)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(paramContext, 2130772116);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130772115);
    localAnimation.setAnimationListener(new ajku(paramView, paramContext));
    paramContext.setAnimationListener(new ajkv(paramView, localAnimation));
    paramView.startAnimation(localAnimation);
  }
  
  public View a(int paramInt, Object paramObject, ajjp paramajjp, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajlm paramajlm)
  {
    ajkw localajkw;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajkw)))
    {
      localajkw = new ajkw(null);
      View localView = a(paramContext, 2131562548, localajkw);
      localajkw.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)localView.findViewById(2131367819));
      localajkw.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)localView.findViewById(2131379331));
      localajkw.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131377938));
      localajkw.b = ((SingleLineTextView)localView.findViewById(2131365129));
      localajkw.b.setGravity(16);
      localajkw.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362569));
      localajkw.c = ((ImageView)localView.findViewById(2131362568));
      Object localObject = paramContext.getResources();
      float f = bdgk.a();
      paramView = ((Resources)localObject).getColorStateList(2131166981);
      ColorStateList localColorStateList = ((Resources)localObject).getColorStateList(2131166910);
      localObject = ((Resources)localObject).getColorStateList(2131166982);
      localajkw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(localColorStateList);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null))
      {
        localajkw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject, 0);
        localajkw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
        localajkw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
        localajkw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        localajkw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
        localajkw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
        localajkw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
        localajkw.b.setTextColor(paramView);
        localajkw.b.setExtendTextPadding((int)(f * 2.0F), 1);
        localajkw.b.setExtendTextSize(14.0F, 1);
        localView.setTag(localajkw);
        paramView = localView;
        if (this.a != null)
        {
          localajkw.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.a.a());
          paramView = localView;
        }
      }
    }
    for (;;)
    {
      return super.a(paramInt, paramObject, paramajjp, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramajlm);
      localajkw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
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
    if ((paramView.getTag() instanceof ajkw)) {}
    for (ajkw localajkw = (ajkw)paramView.getTag();; localajkw = null)
    {
      if (localajkw == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
        return;
      }
      super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
      paramView = (RelativeLayout.LayoutParams)localajkw.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramView.height = localajkw.b.getMeasuredHeight();
      localajkw.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
      a(paramContext, localajkw.c);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkt
 * JD-Core Version:    0.7.0.1
 */
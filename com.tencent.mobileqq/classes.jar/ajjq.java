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

public class ajjq
  extends ajjm
{
  private static void a(Context paramContext, View paramView)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(paramContext, 2130772116);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130772115);
    localAnimation.setAnimationListener(new ajjr(paramView, paramContext));
    paramContext.setAnimationListener(new ajjs(paramView, localAnimation));
    paramView.startAnimation(localAnimation);
  }
  
  public View a(int paramInt, Object paramObject, ajjp paramajjp, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajlm paramajlm)
  {
    ajjt localajjt;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajjt)))
    {
      localajjt = new ajjt(null);
      View localView = a(paramContext, 2131562548, localajjt);
      localajjt.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)localView.findViewById(2131367819));
      localajjt.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)localView.findViewById(2131379331));
      localajjt.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131377938));
      localajjt.b = ((SingleLineTextView)localView.findViewById(2131365129));
      localajjt.b.setGravity(16);
      localajjt.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362569));
      localajjt.c = ((ImageView)localView.findViewById(2131362568));
      Object localObject = paramContext.getResources();
      float f = bdgk.a();
      paramView = ((Resources)localObject).getColorStateList(2131166981);
      ColorStateList localColorStateList = ((Resources)localObject).getColorStateList(2131166910);
      localObject = ((Resources)localObject).getColorStateList(2131166982);
      localajjt.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(localColorStateList);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null))
      {
        localajjt.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject, 0);
        localajjt.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
        localajjt.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
        localajjt.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        localajjt.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
        localajjt.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
        localajjt.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
        localajjt.b.setTextColor(paramView);
        localajjt.b.setExtendTextPadding((int)(f * 2.0F), 1);
        localajjt.b.setExtendTextSize(14.0F, 1);
        localView.setTag(localajjt);
        paramView = localView;
        if (this.a != null)
        {
          localajjt.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.a.a());
          paramView = localView;
        }
      }
    }
    for (;;)
    {
      return super.a(paramInt, paramObject, paramajjp, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramajlm);
      localajjt.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
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
    ajjt localajjt;
    do
    {
      return;
      localajjt = null;
      if ((paramView.getTag() instanceof ajjt)) {
        localajjt = (ajjt)paramView.getTag();
      }
      if (localajjt != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
    return;
    super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
    a(paramContext, localajjt.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjq
 * JD-Core Version:    0.7.0.1
 */
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

public class ahci
  extends ahbb
{
  private static void a(Context paramContext, View paramView)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(paramContext, 2130772114);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130772113);
    localAnimation.setAnimationListener(new ahcj(paramView, paramContext));
    paramContext.setAnimationListener(new ahck(paramView, localAnimation));
    paramView.startAnimation(localAnimation);
  }
  
  public View a(int paramInt, Object paramObject, ahbe paramahbe, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahdb paramahdb)
  {
    ahcl localahcl;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahcl)))
    {
      localahcl = new ahcl(null);
      View localView = a(paramContext, 2131496726, localahcl);
      localahcl.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)localView.findViewById(2131302061));
      localahcl.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)localView.findViewById(2131312826));
      localahcl.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131311534));
      localahcl.b = ((SingleLineTextView)localView.findViewById(2131299475));
      localahcl.b.setGravity(16);
      localahcl.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131297003));
      localahcl.c = ((ImageView)localView.findViewById(2131297002));
      Object localObject = paramContext.getResources();
      float f = babp.a();
      paramView = ((Resources)localObject).getColorStateList(2131101336);
      ColorStateList localColorStateList = ((Resources)localObject).getColorStateList(2131101267);
      localObject = ((Resources)localObject).getColorStateList(2131101337);
      localahcl.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(localColorStateList);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null))
      {
        localahcl.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject, 0);
        localahcl.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
        localahcl.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
        localahcl.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        localahcl.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
        localahcl.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
        localahcl.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
        localahcl.b.setTextColor(paramView);
        localahcl.b.setExtendTextPadding((int)(f * 2.0F), 1);
        localahcl.b.setExtendTextSize(14.0F, 1);
        localView.setTag(localahcl);
        paramView = localView;
        if (this.a != null)
        {
          localahcl.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.a.a());
          paramView = localView;
        }
      }
    }
    for (;;)
    {
      return super.a(paramInt, paramObject, paramahbe, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramahdb);
      localahcl.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
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
    if ((paramView.getTag() instanceof ahcl)) {}
    for (ahcl localahcl = (ahcl)paramView.getTag();; localahcl = null)
    {
      if (localahcl == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
        return;
      }
      super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
      paramView = (RelativeLayout.LayoutParams)localahcl.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramView.height = localahcl.b.getMeasuredHeight();
      localahcl.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
      a(paramContext, localahcl.c);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahci
 * JD-Core Version:    0.7.0.1
 */
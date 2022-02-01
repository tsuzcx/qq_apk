import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.recent.data.RecentItemContactsGuideData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.ThemeImageView;

public class alnf
  extends alnt
{
  View.OnTouchListener a;
  protected String a;
  
  alnf()
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new alng(this);
    if (QLog.isColorLevel()) {
      QLog.d("RecentContactsGuideItemBuilder", 0, "RecentContactsGuideItemBuilder constructed");
    }
  }
  
  public View a(int paramInt, Object paramObject, alno paramalno, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alpv paramalpv)
  {
    paramViewGroup = null;
    paramalno = paramViewGroup;
    if (paramView != null)
    {
      paramalno = paramViewGroup;
      if ((paramView.getTag() instanceof alnh)) {
        paramalno = (alnh)paramView.getTag();
      }
    }
    if (paramalno == null)
    {
      paramalno = new alnh();
      paramView = a(paramContext, 2131558969, paramalno);
      paramalno.a = ((ThemeImageView)paramView.findViewById(2131365051));
      paramView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramViewGroup = paramalno.a.getLayoutParams();
      int i = yzv.a(BaseApplicationImpl.getApplication().getResources());
      int j = (int)(i * 0.5D + 0.5D);
      paramViewGroup.width = i;
      paramViewGroup.height = j;
      paramalno.a.setLayoutParams(paramViewGroup);
      paramalno.a.setMaskShape(blqj.b);
      paramView.setTag(paramalno);
    }
    for (;;)
    {
      if ((paramObject instanceof RecentItemContactsGuideData))
      {
        paramObject = (RecentItemContactsGuideData)paramObject;
        if ((paramObject.mUser != null) && ((paramObject.mUser.extraInfo instanceof awvy)))
        {
          paramObject = (awvy)paramObject.mUser.extraInfo;
          if (paramObject.a != null)
          {
            paramalno.a.setImageDrawable(paramObject.a);
            paramObject.a.setURLDrawableListener(null);
          }
          LoginWelcomeManager.a += 1;
        }
      }
      this.jdField_a_of_type_JavaLangString = ThemeUtil.curThemeId;
      if (AppSetting.c) {
        paramView.setContentDescription(anzj.a(2131712032));
      }
      paramView.setOnClickListener(paramOnClickListener);
      paramView.setOnLongClickListener(paramOnLongClickListener);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alnf
 * JD-Core Version:    0.7.0.1
 */
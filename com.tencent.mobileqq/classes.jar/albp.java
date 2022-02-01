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

public class albp
  extends alcd
{
  View.OnTouchListener a;
  protected String a;
  
  albp()
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new albq(this);
    if (QLog.isColorLevel()) {
      QLog.d("RecentContactsGuideItemBuilder", 0, "RecentContactsGuideItemBuilder constructed");
    }
  }
  
  public View a(int paramInt, Object paramObject, alby paramalby, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, aled paramaled)
  {
    paramViewGroup = null;
    paramalby = paramViewGroup;
    if (paramView != null)
    {
      paramalby = paramViewGroup;
      if ((paramView.getTag() instanceof albr)) {
        paramalby = (albr)paramView.getTag();
      }
    }
    if (paramalby == null)
    {
      paramalby = new albr();
      paramView = a(paramContext, 2131558970, paramalby);
      paramalby.a = ((ThemeImageView)paramView.findViewById(2131365004));
      paramView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramViewGroup = paramalby.a.getLayoutParams();
      int i = ywa.a(BaseApplicationImpl.getApplication().getResources());
      int j = (int)(i * 0.5D + 0.5D);
      paramViewGroup.width = i;
      paramViewGroup.height = j;
      paramalby.a.setLayoutParams(paramViewGroup);
      paramalby.a.setMaskShape(bkpg.b);
      paramView.setTag(paramalby);
    }
    for (;;)
    {
      if ((paramObject instanceof RecentItemContactsGuideData))
      {
        paramObject = (RecentItemContactsGuideData)paramObject;
        if ((paramObject.mUser != null) && ((paramObject.mUser.extraInfo instanceof awdg)))
        {
          paramObject = (awdg)paramObject.mUser.extraInfo;
          if (paramObject.a != null)
          {
            paramalby.a.setImageDrawable(paramObject.a);
            paramObject.a.setURLDrawableListener(null);
          }
          LoginWelcomeManager.a += 1;
        }
      }
      this.jdField_a_of_type_JavaLangString = ThemeUtil.curThemeId;
      if (AppSetting.c) {
        paramView.setContentDescription(anni.a(2131711923));
      }
      paramView.setOnClickListener(paramOnClickListener);
      paramView.setOnLongClickListener(paramOnLongClickListener);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     albp
 * JD-Core Version:    0.7.0.1
 */
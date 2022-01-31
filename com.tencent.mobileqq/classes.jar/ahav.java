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

public class ahav
  extends ahbj
{
  View.OnTouchListener a;
  protected String a;
  
  ahav()
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new ahaw(this);
    if (QLog.isColorLevel()) {
      QLog.d("RecentContactsGuideItemBuilder", 0, "RecentContactsGuideItemBuilder constructed");
    }
  }
  
  public View a(int paramInt, Object paramObject, ahbe paramahbe, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahdb paramahdb)
  {
    paramViewGroup = null;
    paramahbe = paramViewGroup;
    if (paramView != null)
    {
      paramahbe = paramViewGroup;
      if ((paramView.getTag() instanceof ahax)) {
        paramahbe = (ahax)paramView.getTag();
      }
    }
    if (paramahbe == null)
    {
      paramahbe = new ahax();
      paramView = a(paramContext, 2131493308, paramahbe);
      paramahbe.a = ((ThemeImageView)paramView.findViewById(2131299137));
      paramView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramViewGroup = paramahbe.a.getLayoutParams();
      int i = uwv.a(BaseApplicationImpl.getApplication().getResources());
      int j = (int)(i * 0.5D + 0.5D);
      paramViewGroup.width = i;
      paramViewGroup.height = j;
      paramahbe.a.setLayoutParams(paramViewGroup);
      paramahbe.a.setMaskShape(beog.b);
      paramView.setTag(paramahbe);
    }
    for (;;)
    {
      if ((paramObject instanceof RecentItemContactsGuideData))
      {
        paramObject = (RecentItemContactsGuideData)paramObject;
        if ((paramObject.mUser != null) && ((paramObject.mUser.extraInfo instanceof arel)))
        {
          paramObject = (arel)paramObject.mUser.extraInfo;
          if (paramObject.a != null)
          {
            paramahbe.a.setImageDrawable(paramObject.a);
            paramObject.a.setURLDrawableListener(null);
          }
          LoginWelcomeManager.a += 1;
        }
      }
      this.jdField_a_of_type_JavaLangString = ThemeUtil.curThemeId;
      if (AppSetting.c) {
        paramView.setContentDescription(ajjy.a(2131647361));
      }
      paramView.setOnClickListener(paramOnClickListener);
      paramView.setOnLongClickListener(paramOnLongClickListener);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahav
 * JD-Core Version:    0.7.0.1
 */